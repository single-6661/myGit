import { createRouter, createWebHistory } from 'vue-router'

import layout from './layout.vue'
import home from './views/HomeView.vue'
import card from './components/card.vue'
import hot from './components/Hot.vue'
import search from './components/Search.vue'
const routes = [
  {path:'/layout',component:  layout}
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
