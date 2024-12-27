<template>
  <v-app>
    <v-main class="amber lighten-4 pa-10">
      <!-- Login Component -->

      <v-row class="pa-10">
        <v-col>
          <v-card
              elevation="24"
              max-width="444"
              class="mx-auto"
          >
            <v-carousel
                :continuous="false"
                :cycle="cycle"
                hide-delimiter-background
                height="500"

            >
              <v-carousel-item
                  v-for="(item,i) in items"
                  :key="i"
                  :src="item.src"
              >
              </v-carousel-item>
            </v-carousel>
          </v-card>
        </v-col>
        <v-col class="pa-5">
          <v-row class="pa-5">
            <div>
              <h3 style="text-align: center" class="grey--text">LivHeart Roomies Party</h3>
              <h1 style="text-align: center" class="mb-10"> Triceratops Large</h1>
              &emsp;
              <p>루미의 파티에 참여한 친구들 중 트리케라톱스를 구매해보세요!</p>
              <h2 align="right">$75</h2>
            </div>
          </v-row>
          <v-divider class="pa-5"></v-divider>
          <v-row align-content-md="space-around" justify="end">
            <v-col
                cols="4" class="mr-10">

              <v-text-field v-model="quantity"
                            type="number"
                            solo
                            reverse
                            append-outer-icon="mdi-plus-thick"
                            @click:append-outer="increment"
                            prepend-icon="mdi-minus-thick"
                            @click:prepend="decrement"></v-text-field>
            </v-col>
          </v-row>
          <v-divider></v-divider>
          &emsp;
          <v-row class="mr-15" justify="center">

            <v-col><h3>충액</h3></v-col>
            <v-col align="center"><h3 class="grey--text">{{quantity}}</h3></v-col>
            <v-col align="center"><h3>*</h3> </v-col>
            <v-col align="center"><h3 class="grey--text">$ 75</h3></v-col>
            <v-col align="center"><h3> = </h3></v-col>
            <v-col align="center" class="red--text"><h3>$ {{totalSum}} </h3></v-col>
          </v-row>
          <v-row>
            <v-btn  block
                    color="primary"
                    @click="submit"
            > 구매하기</v-btn>
          </v-row>

        </v-col>
      </v-row>
    </v-main>

  </v-app>

</template>

<script>

import axios from "axios";

export default {
  data() {
    return {
      quantity: 1,
      pid: 1225,
      cid: this.$route.params.cid,
      items: [
        {
          src: "./tri0.png"
        },
        {
          src: "./tri1.png"
        },
        {
          src: "./tri2.png"
        },
      ],
      cycle: false,

    }
  },
  computed: {
    totalSum: function (){
      return this.quantity * 75;
    }
  }
  ,
  methods: {
    increment() {
      this.quantity = parseInt(this.quantity, 10) + 1
    },
    decrement() {
      this.quantity = parseInt(this.quantity, 10) - 1
    },
    submit() {
      var cid = this.cid;
      var pid = this.pid;
      var quantity = this.quantity;
      alert(this.cid);
      axios.get(
          "http://localhost:8081/order",
          {params: {
              pid: this.pid
              ,quantity: this.quantity
            }
          }
      ).then(result => {
        if(result.data.status == "success"){
          this.$router.push('/home');
          this.$router.push({name:'pay', params:{cid:cid, pid:pid, quantity:quantity}} );
        }else if(result.data.status == "fail"){
          alert("제품 수량이 부족합니다.")
        }else{
          this.$router.push('/home')
          this.$router.push({name:'loading', params:{cid:cid, pid:pid, quantity:quantity}} );
        }
      }).catch(error => {
        alert(error)
        this.$router.push('/home')
        this.$router.push({name:'pay', params:{cid:cid, pid:pid, quantity:quantity}} )
      })
    }
  }
}
</script>
