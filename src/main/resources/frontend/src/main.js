import Vue from 'vue'
import App from './App.vue'
import router from "./router";
import { VueAxios } from "./utils/request";

Vue.config.productionTip = false

Vue.use(VueAxios);

new Vue({
  el: "#app",
  router,
  render: h => h(App),
  components: {
    App
  }
});

