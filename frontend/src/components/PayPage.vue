<template>
  <v-app id="inspire">
    <v-main class="secondary">
      <!-- Login Component -->
      <v-container style="max-width: 450px" fill-height>
        <v-layout align-center row wrap>
          <v-flex xs12>
          <v-card>
            <div class="pa-10">
              <h1 style="text-align: center" class="mb-10">Pay</h1>
              <form>
                <v-select
                  label="결제 방식"
                    :items="items"
                    outlined
                    dense
                ></v-select>
                <v-col>보안문자(TrafficJam)</v-col>
                  <v-text-field v-model="securityCode"
                                solo
                                reverse
                                label="보안문자를 입력해주세요"
                  ></v-text-field>
                <v-checkbox
                    v-model="payAgree"
                    :label="` 해당 결제 수단을 사용하는 것에 동의합니다.`"
                ></v-checkbox>
                <v-btn
                    @click="submit"
                    color="primary text-capitalize"
                    depressed
                    large
                    block
                    dark
                    class="mb-3"
                >
                  결제하기
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
      select: [''],
      items: [
        '무통장입금',
        '카드결제',
        '핸드폰요금',
      ],
      securityCode: null,
      payAgree: false,
      cid: this.$route.params.cid,
      pid: this.$route.params.pid,
      quantity: this.$route.params.quantity,

    }
  },
  methods: {submit() {
      if(this.select == '선택안함'){
        alert("결제방식을 선택해주세요");
        return;
      }
      if(this.securityCode != "TrafficJam"){
        alert("보안문자가 일치하지 않습니다.");
        return;
      }
      if(this.payAgree == false){
        alert("결제 이용 동의를 체크해주세요.");
        return;
      }
      const fd = {
        cid: this.cid,
        pid: this.pid,
        quantity: this.quantity
      }
      console.log(fd);

      axios.post(
          "http://localhost:8081/pay", fd,  {
            headers: { "Content-Type": "multipart/form-data"},
          }
      ).then(result => {
        if(result.data == "success"){
          this.$router.push('/home')
          this.$router.push('/paysuccess');
        }else{
          this.$router.push('/home')
          this.$router.push('/payfail');
        }
      }).catch(error => {
        alert(error);
        this.$router.push('/home')
        this.$router.push('/payfail').catch(()=>{});
      })

    }
  },
}
</script>
<style scoped>

</style>