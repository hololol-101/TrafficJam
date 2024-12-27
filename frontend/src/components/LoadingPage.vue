<template>
  <v-app>
    <v-main class="secondary pa-10">
      <v-container style="max-width: 450px" fill-height>
        <v-layout align-center row wrap>
          <v-flex xs12>
            <v-card
                elevation="24"
                max-width="444"
                class="mx-auto"
            >
              <div class="pa-10">
                <h3 style="text-align: center" class="grey--text">나의 예약대기 순번</h3>
                <h1 style="text-align: center" class="mb-10">{{ waitingNumber }}</h1>
                <form>
                  <div style="min-height: 4px;">
                    <v-progress-linear
                        v-model="value"
                        :active="true"
                        :indeterminate="query"
                        :query="true"
                        value="value"
                        height="10"
                        striped
                        color="primary"
                    ></v-progress-linear>
                  </div>
                </form>
                <v-row class="pa-5">
                  <v-col>
                    <h4 style="text-align: left" class="grey--text">현재 대기 인원</h4>
                  </v-col>
                  <v-col>
                    <h4 style="text-align: right" class="black--text">{{ totalWatingNum }}</h4>
                  </v-col>
                </v-row>
                <div align="center"> 현재 접속 인원이 많아 대기중입니다.<br>
                  잠시만 기다려주시면 예매하기 페이지로 연결됩니다.</div>
                <h5 align="center" class="format_bold pa-5">
                  새로고침/재접속 하는 경우 <br>
                  대기순서가 초기화되어 대기시간이 더 길어집니다.
                </h5>
              </div>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>>
    </v-main>

  </v-app>

</template>

<script>
export default {
  data() {
    return {
      originNumber: 5371,
      waitingNumber: 2049,
      totalWatingNum: 20039,
      query: false,
      show: true,
      interval: 0,
      cid: this.$route.params.cid,
      pid: this.$route.params.pid,
      quantity: this.$route.params.quantity,
    };
  },
  components: {},
  computed: {
    value: function (){
      return (this.originNumber - this.waitingNumber) *100 / (this.originNumber);
    }
  },
  mounted() {
    this.queryAndIndeterminate()
  },

  beforeDestroy() {
    clearInterval(this.interval)
  },
  methods: {
    queryAndIndeterminate() {

      setTimeout(() => {
        var cid = this.cid;
        var pid = this.pid;
        var quantity = this.quantity;
        this.query = false

        this.interval = setInterval(() => {
          if (this.waitingNumber == 1) {
            this.$router.push('/home');
            this.$router.push({name:'pay', params:{cid:cid, pid:pid, quantity:quantity}} );
          }else{
            if(this.waitingNumber > 100){
              this.waitingNumber = this.waitingNumber - 100;
            }else {
              this.waitingNumber = 1;
            }
            //return setTimeout(this.queryAndIndeterminate, 2000)
          }
        }, 1000)
      }, 2500)
    },

  },

};
</script>