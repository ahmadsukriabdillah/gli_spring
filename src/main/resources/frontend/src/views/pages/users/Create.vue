<template>
  <div>
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Create Users</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
            <router-link to="/users" class="btn btn-sm btn-secondary">Back</router-link>
        </div>
    </div>
      <div class="col-md-12 col-lg-12">
        <form @submit.prevent="onSubmit">
          <div class="row g-3">
            <div class="col-12">
              <label for="name" class="form-label">Name</label>
              <input type="text" v-model="data.name" class="form-control" placeholder="Please input your name" required>
            </div>
            <div class="col-12">
              <label for="email" class="form-label">Email</label>
              <input required type="email" v-model="data.email" class="form-control" id="email" placeholder="Please input your email">
            </div>
            <div class="col-12">
              <label for="email" class="form-label">Gender</label>
              <select required name="gender" class="form-control" v-model="data.gender">
                <option value="">Please select gender</option>
                <option value="L">Man</option>
                <option value="W">Woman</option>
              </select>
            </div>
            <div class="col-12">
              <label for="date_of_birth" class="form-label">Email</label>
              <input required type="date" v-model="data.date_of_birth" class="form-control" id="date_of_birth" placeholder="Please input your Date of birth">
            </div>
            <div class="col-12">
              <label for="address" class="form-label">Address</label>
              <textarea required name="address" v-model="data.address" class="form-control"></textarea>
            </div>
            <div class="col-12">
              <label for="email" class="form-label">Roles</label>
              <select required name="gender" class="form-control" v-model="data.role.id">
                <option value="">Please select role</option>
                <option v-for="x in roles" :key="x.id" :value="x.id">{{ x.name }}</option>
              </select>
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
    name: 'CreateUsers',
    data() {
        return {
            data: {
                email: null,
                name: null,
                gender: null,
                date_of_birth: null,
                address: null,
                role: {
                  id: null,
                  name: null
                }
            },
            roles: []
        }
    },
    methods:{
        onSubmit() {
            this.axios({
                url: "api/users",
                method: "post",
                data: {
                    name: this.data.name,
                    email: this.data.email,
                    gender: this.data.gender,
                    date_of_birth: this.data.date_of_birth,
                    address: this.data.address
                }
            }).then(() => {
                this.$router.push({ path: "/users" });
            });            
        },
        getRoles() {
           this.axios({
                url: "api/role",
                method: "get",
            }).then(response => {
              this.roles = response.data;
            });   
        }
    },
    mounted() {
      this.getRoles();
    }
}
</script>

<style>

</style>