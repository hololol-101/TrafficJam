<template>
  <div id="app">
    <v-row>
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
      <v-col>
        <router-view></router-view>
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
        { title: 'Pay', link: '/pay' },
      ],
      right: null,
    }
  },
}</script>