<template>
  <div>
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Create Role</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
            <router-link to="/role" class="btn btn-sm btn-secondary">Back</router-link>
        </div>
    </div>
      <div class="col-md-12 col-lg-12">
        <form @submit.prevent="onSubmit">
          <div class="row g-3">
            <div class="col-12">
              <label for="name" class="form-label">Name</label>
              <input type="text" v-model="data.name" class="form-control" required placeholder="Please input name">
            </div>
          </div>
          <hr class="my-4">
          <button class="w-100 btn btn-primary btn-lg" type="submit">Save</button>
        </form>
      </div>
  </div>
</template>

<script>

export default {
    name: 'CreateRole',
    data() {
        return {
            data: {
                name: null,
                
            },
        }
    },
    methods:{
        onSubmit() {
            this.axios({
                url: "api/role",
                method: "post",
                data: {
                    name: this.data.name
                }
            }).then(() => {
                this.$router.push({ path: "/role" });
            });
            
        }
    },
    mounted() {
    }
}
</script>

<style>

</style>