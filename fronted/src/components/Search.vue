<script lang="js">
import { searchGet } from '@/utils/Request';
import  bus  from '@/utils/EventBus'

export default{
    data(){
        return{
        searchInput:'',
        contentList:[],
        //控制搜素栏显隐
        isExpand:true,
        //isChangeCard:false,
        }
    },
    computed:{
        showList(){
            return this.contentList.slice(0,5);
        }
    },

    methods:{
        async submitSearch(){

            const res = await searchGet("/search",this.searchInput);

            if(res.code == "200"){

                if(res.data == null){
                    alert("无法找到您搜寻的内容")
                    this.isExpand = true;
                    return;
                }
                console.log("请求正在执行")
                this.isExpand = false;
                this.contentList = res.data.map(item=>{
                    return {
                    ...item,
                    expand: false}});
                }
          if(res.code == "500"){
            console.error("搜索失败");
            alert("请输入正确的内容！");
            this.isExpand = true;
          }
        },

        //数据传入layout再中转至目标Card后进行操作
        changeCard(){
            bus.emit("searchData",
            {searchList:this.contentList,
            isChangeCard:true
            })
            this.isExpand = true;
        }
    },
}    

</script>

<template>
<div class="search-nav">
    <div class="search">
        <input placeholder="搜索" v-model="searchInput">
        <button @click="submitSearch()">搜索</button>
    </div>
    <div class="expand-card" :class="{'active':isExpand}">
        <div class="search-title" v-for="item in showList">{{ item.title }}</div>
        <button @click="changeCard">查看「{{ searchInput }}」的搜索结果</button>
    </div>
</div>
</template>

<style scoped lang="scss">
.search-nav{
    position: relative;
    .search{
        user-select: none;
        width: 482px;
        height: 34px;
        border-radius: 100px 100px 100px 100px;
        display: flex;
        input{
            height: 34px;
            width: 436px;
            border-top-left-radius: 100px;
            border-bottom-left-radius: 100px;
            border: 1px solid #EBEBEB;
            &:focus {
                border:1px solid #0084FF
            }
            &::placeholder{
                width: 84px;
                height: 20px;
                font-family: PingFang SC, PingFang SC;
                font-weight: normal;
                font-size: 14px;
                margin-right: 20px;
                color: #000000;
                line-height: 20px;
                text-align: center;
                font-style: normal;
                text-transform: none;
            }
        }
        button{
            width: 46px;
            height: 34px;
            border-top-right-radius: 100px;
            border-bottom-right-radius: 100px;
            background: #0084FF;
            &:hover {
                background: #60b4ff;
            }
            &:active {
                background:#48a0ee;
            }
        }
    }
    .expand-card{
        z-index: 999;
        position: absolute;
        margin-top: 9px;
        margin-left: 100px;
        width: 482px;
        height: 266px;
        background: #FFFFFF;
        box-shadow: 0px 0px 10px 1px rgba(0,0,0,0.2);
        border-radius: 4px 4px 4px 4px;
        border: 1px solid #E1E1E1;
        .search-Title{
            margin-top: 16px;
            width: auto;
            height: 22px;
            font-family: PingFang SC, PingFang SC;
            font-weight: normal;
            font-size: 14px;
            color: #888FA2;
            line-height: 22px;
            text-align: left;
            font-style: normal;
            text-transform: none;
        }
        button{
            width: auto;
            height: 22px;
            font-family: PingFang SC, PingFang SC;
            font-weight: normal;
            font-size: 14px;
            color: #0084FF;
            line-height: 22px;
            text-align: left;
            font-style: normal;
            text-transform: none;
        }
    }
}

.active{
    display: none;
}

</style>

