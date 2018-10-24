
import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

let ADDR = "http://localhost:3001/api";

export default new Vuex.Store({

  state: {
    user: null
  },

  mutations: {
    LOGIN (state, user) { state.user = user;},
    LOGOUT (state) { state.user = null; }
  }, 

  actions: {
    login({commit}, form) {
      return Vue.axios.post(`${ADDR}/login`, form)
        .then((result)=>{
          console.log(result);
          commit("LOGIN", result);
        })
    }, 

    logout({commit}){
      commit("logout");
    }
    
  }

});