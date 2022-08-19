import { createWebHistory, createRouter } from "vue-router";
const routes =  [
  {
    path: "/",
    alias: "/products",
    name: "products",
    component: () => import("./components/ProductsList")
  },
  {
    path: "/add",
    name: "add",
    component: () => import("./components/AddProducts")
  }
];
const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;