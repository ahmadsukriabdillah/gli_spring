<template>
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
        <div class="position-sticky pt-3">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <router-link to="/users" class="nav-link">
                        <span data-feather="home"></span>
                        Users
                    </router-link>
                     <router-link to="/role" class="nav-link">
                        <span data-feather="home"></span>
                        Role
                    </router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
export default {

}
</script>

<style>

</style>