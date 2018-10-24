<template>
  <div class="ion-page">
    
    <ion-header>
      <ion-toolbar>
        <ion-title> 테스트 페이지 </ion-title>
      </ion-toolbar>
    </ion-header>
    
    <ion-content>
      <ion-list>
        <ion-item v-for="todo of todoList" :key="todo.workname">
          <ion-label> {{todo.workname}} </ion-label>
        </ion-item>
      </ion-list>
    </ion-content>
  </div>
</template>

<script>
// @ is an alias to /src
import Vue from 'vue';
import { mapState } from 'vuex';


export default {
  name: 'home',
  components: {
    
  }, 

  data(){
    return {
      todoList: [{
        workname: "시작.."
      }]
    }
  },

  mounted(){

    Vue.axios.get("http://localhost:6400/remoteLogin?userId=jongwon1")
    .then(result => {
      console.log(result);
      Vue.axios.get("http://localhost:6400/myWorks").then(result=>{
          this.todoList = result.data;
          console.log(result);
        });
    })
   
  },

  computed: {
    ...mapState({
      user: state => state.user
    }), 

    login(){
      this.$router.push("/login")
    },

    logout(){
      this.$store.action("logout");
      this.login();
    }
    
  }
}
</script>
