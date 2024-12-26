<template>
  <v-app id="inspire">
    <v-main class="blue-grey lighten-4">
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
      axios.get(
        "http://localhost:8081/login",
          {params: {
              id: this.id
              , password: this.password
            }
          }
      ).then(result => {
          alert("결과:" + result.data)
        }).catch(error => {
          alert(error)
        })

      }
  },

};
</script>