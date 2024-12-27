<template>
  <div id="app">
    <v-row dense>
        <v-navigation-drawer permanent>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                Page
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>

          <v-divider></v-divider>

          <v-list
              dense
              nav
          >
            <v-list-item
                v-for="item in items"
                :key="item.title"
                :to="item.link"
                link
            >
              <v-list-item-content>
                <v-list-item-title>{{ item.title }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
      <v-col dense>
        <div dense>
          <router-view></router-view>
        </div>
      </v-col>
    </v-row>
  </div>
</template>
<script>
export default {
  data () {
    return {
      items: [
        { title: 'Main', link: '/' },
        { title: 'Login', link: '/login' },
        { title: 'Order', link: '/order' },
        { title: 'Loading', link: '/loading' },
        { title: 'Pay', link: '/pay' },
        { title: 'PaySuccess', link: '/paysuccess' },
        { title: 'PayFail', link: '/payfail' },
      ],
      right: null,
    }
  },
}</script>