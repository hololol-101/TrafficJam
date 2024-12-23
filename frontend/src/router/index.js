import Vue from 'vue';
import VueRouter from 'vue-router';
import HelloWorld from "@/components/HelloWorld.vue";
import LoginPage from "@/components/LoginPage.vue";
import LoadingPage from "@/components/LoadingPage.vue";
import OrderPage from "@/components/OrderPage.vue";
Vue.use(VueRouter);

export default new VueRouter({
    mode:'hash', //해쉬값 제거 방식
    routes: [{
        path: '/',
        redirect: '/home'
    }, {
        path: '/home',
        name: 'home',
        component: HelloWorld,
    }, {
        path: '/login',
        name: 'login',
        component: LoginPage
    },{
        path: '/loading',
        component: LoadingPage
    }, {
        path: '/order',
        component: OrderPage
    }]
});