import Vue from 'vue';
import VueRouter from 'vue-router';
import HelloWorld from "@/components/HelloWorld.vue";
import TestPage from "@/components/TestPage.vue";
Vue.use(VueRouter);

export default new VueRouter({
    mode:'history', //해쉬값 제거 방식
    routes: [{
        path: '/',
        redirect: '/home'
    }, {
        path: '/home',
        component: HelloWorld,
    }, {
        path: '/login',
        component: TestPage
    }]
});