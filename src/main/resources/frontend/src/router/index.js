
import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const DefaultContainers = () => import("@/views/containers/DefaultContainers");
const Users = () => import("@/views/pages/users/Index")
const UsersCreate = () => import("@/views/pages/users/Create")
const UsersUpdate = () => import("@/views/pages/users/Update")

const Roles = () => import("@/views/pages/role/Index")
const RolesCreate = () => import("@/views/pages/role/Create")
const RolesUpdate = () => import("@/views/pages/role/Update")

const routes = [
    {
        path: "/",
        redirect: "/users",
        name: "index",
        component: DefaultContainers,
        children: [
            {
                path: "users",
                name: "Users Index",
                component: Users
            },
            {
                path: "users/create",
                name: "Users Create",
                component: UsersCreate
            },
            {
                path: "users/:user_id",
                name: "Users Update",
                component: UsersUpdate
            },
            {
                path: "role",
                name: "Role Index",
                component: Roles
            },
            {
                path: "role/create",
                name: "Role Create",
                component: RolesCreate
            },
            {
                path: "role/:role_id",
                name: "Role Update",
                component: RolesUpdate
            },
            
        ]
    },
];



const router = new Router({
    mode: "hash",
    routes: routes
});

export default router;