import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/store'
import './registerServiceWorker'
import { Ionic, IonicVueRouter, IonicAPI } from '@modus/ionic-vue';
import axios from 'axios';
import VueAxios from 'vue-axios';


Ionic.init();
Vue.use(IonicAPI);
Vue.use(IonicVueRouter);
Vue.use(VueAxios, axios);

Vue.config.productionTip = false
axios.defaults.withCredentials = true;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
