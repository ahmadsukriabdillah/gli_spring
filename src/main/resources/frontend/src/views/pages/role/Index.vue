<template>
    <div>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Role</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
                <router-link to="/role/create" class="btn btn-sm btn-primary">Create New Role</router-link>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-sm" width="100%">
                <thead>
                    <tr>
                        <th>name</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="x in displayedRoles" :key="x.id">
                        <td>{{x.name}}</td>
                        <td>
                            <a @click="edit_role(x)" class="btn btn-success">Edit</a>
                            <a @click="delete_role(x)" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            
            
        </div>
        <div class="row">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <button type="button" class="page-link" v-if="page != 1" @click="page--"> Previous </button>
                    </li>
                    <li class="page-item">
                        <button type="button" class="page-link" v-for="pageNumber in pages.slice(page-1, page+5)" 
                            :key="pageNumber" :class="{ active: page == pageNumber}"
                            @click="page = pageNumber"> {{pageNumber}} </button>
                    </li>
                    <li class="page-item">
                        <button type="button" @click="page++" v-if="page < pages.length" class="page-link"> Next </button>
                    </li>
                </ul>
            </nav>
        </div>
        
    </div>
</template>

<script>
export default {
    name: 'IndexRoles',
    data() {
        return {
            roles: [],
            page: 1,
            perPage: 2,
            pages: [], 
        }
    },
    mounted() {
        this.getAllRoles();
    },
    methods: {
        getAllRoles(){
            this.axios({
                url: "api/role",
                method: "get"
            }).then(response => {
               this.roles = response.data;
               this.setPages();
            });
        },
        setPages () {
            this.pages = [];
            let numberOfPages = Math.ceil(this.roles.length / this.perPage);
            for (let index = 1; index <= numberOfPages; index++) {
                this.pages.push(index);
            }
        },
        paginate (roles) {
            let page = this.page;
            let perPage = this.perPage;
            let from = (page * perPage) - perPage;
            let to = (page * perPage);
            return roles.slice(from, to);
        },
        edit_role(role) {
            this.$router.push({ path: `/role/${role.id}`}) // -> /user/123
        },
        delete_role(role) {
            let x = confirm(`Apakah anda yakin untuk menghapus ${role.name}?`);
            if(x){
                this.axios({
                    url: `api/role/${role.id}`,
                    method: "delete"
                }).then(() => {
                    this.getAllRoles();
                });
            }
        }
    },
    computed: {
        displayedRoles () {
            return this.paginate(this.roles);
        }
    },
    watch: {
        roles () {
            this.setPages();
        }
    },

}
</script>

<style>
button.page-link {
  display: inline-block;
}
</style>