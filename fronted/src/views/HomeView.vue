<script>
import card from '../components/card.vue'
import hot from '../components/Hot.vue'

export default{
  name:'home',
  components:{
    card,
    hot
  }
}
</script>

<template>
      <div class="home">
        <div class="content">
            <card/>
        </div>
        <div class="righrt-nav">
            <hot/>
        </div>
    </div>
</template>

<style lang="css">
.home{
  width: 100vw;
  display: flex;
  align-items: flex-start;
  justify-content: center;
}
</style>