<script>
import headNav from './components/HeadNav.vue'
import home from './views/HomeView.vue'

export default{
    name : "layot",
    components:{
        headNav,
        home
    }
}
</script>

<template>
<div class="layout">
    <div class="head">
        <head-nav/>
    </div>
    <div class="main">
        <home/>
    </div>
</div>
</template>

<style lang="css" scoped>
.main{
    display: flex;
    align-items: center;
}
</style>