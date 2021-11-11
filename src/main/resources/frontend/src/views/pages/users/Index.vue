<template>
    <div>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Users</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
                <router-link to="/users/create" class="btn btn-sm btn-primary">Create New User</router-link>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <thead>
                    <tr>
                        <th scope="col">name</th>
                        <th scope="col">email</th>
                        <th scope="col">dob</th>
                        <th width="15%">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="x in displayedUsers" :key="x.id">
                        <td>{{x.name}}</td>
                        <td>{{x.email}}</td>
                        <td>{{x.date_of_birth}}</td>
                        <td>
                            <a @click="edit_users(x)" class="btn btn-success">Edit</a>
                            <a @click="delete_users(x)" class="btn btn-danger">Delete</a>
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
    name: 'IndexUsers',
    data() {
        return {
            users: [],
            page: 1,
            perPage: 2,
            pages: [], 
        }
    },
    mounted() {
        this.getAllUsers();
    },
    methods: {
        getAllUsers(){
            this.axios({
                url: "api/users",
                method: "get"
            }).then(response => {
               this.users = response.data;
                this.setPages();
            });
        },
        setPages () {
            this.pages = [];
            let numberOfPages = Math.ceil(this.users.length / this.perPage);
            for (let index = 1; index <= numberOfPages; index++) {
                this.pages.push(index);
            }
        },
        paginate (users) {
            let page = this.page;
            let perPage = this.perPage;
            let from = (page * perPage) - perPage;
            let to = (page * perPage);
            return users.slice(from, to);
        },
        edit_users(users) {
            this.$router.push({ path: `/users/${users.id}`}) // -> /user/123
        },
        delete_users(users) {
            let x = confirm(`Apakah anda yakin untuk menghapus ${users.username}?`);
            if(x){
                this.axios({
                    url: `api/users/${users.id}`,
                    method: "delete"
                }).then(() => {
                    this.getAllUsers();
                });
            }
        }
    },
    computed: {
        displayedUsers () {
            return this.paginate(this.users);
        }
    },
    watch: {
        users () {
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