<template>
  <v-app id="inspire">
    <v-main class="secondary">
      <!-- Login Component -->
      <v-container style="max-width: 450px" fill-height>
        <v-layout align-center row wrap>
          <v-flex xs12>
            <v-card>
              <div class="pa-10">
                <h1 style="text-align: center" class="mb-10">Login</h1>
                <form>
                  <v-text-field
                      v-model="id"
                      label="ID"
                      prepend-inner-icon="mdi-account"
                  ></v-text-field>
                  <v-text-field
                      v-model="password"
                      prepend-inner-icon="mdi-lock"
                      type="password"
                      label="Password"
                  >
                  </v-text-field>
                  <v-btn
                      @click="submit"
                      color="primary text-capitalize"
                      depressed
                      large
                      block
                      dark
                      class="mb-3"
                  >
                    Login
                  </v-btn>
                </form>
              </div>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      id:null
      , password:null
    };
  },
  components: {},
  computed: {},
  methods: {
    submit() {
      if(this.id == null){
        alert("아이디를 입력해주세요");
        return;
      }else if(this.password == null){
        alert("비밀번호를 입력해주세요");
        return;
      }

      axios.get(
        "http://localhost:8081/login",
          {params: {
              id: this.id
              , password: this.password
            }
          }
      ).then(result => {
          if(result.data<0){
            alert("아이디/비밀번호를 확인해주세요");
            return;
          }else{
            this.$router.push('/home');
            this.$router.push({name:'order', params:{cid:result.data}} );
          }


      }).catch(error => {
          alert(error)
        })

      }
  },

};
</script>