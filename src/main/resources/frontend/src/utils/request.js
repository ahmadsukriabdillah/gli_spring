import axios from "axios";
import { VueAxios } from "./axios";

const service = axios.create({
  timeout: 6000
});

const installer = {
  vm: {},
  install(Vue) {
    Vue.use(VueAxios, service);
  }
};

export { installer as VueAxios, service as axios };
