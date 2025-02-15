import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: '#FFA000',
                secondary: '#FFECB3',
                accent: '#FFD740',
            },
        },
    },
});
