<script lang="js">
import { contentGet } from '@/utils/Request';

export default{
    data(){
        return{
            hotList:[]
        }
    },
            //限制hot渲染条数
    computed:{
        showList(){
            return this.hotList.slice(0,10)
        }
    },
    methods:{
        async getHot(){
            const hotObj = await contentGet("/hot")
            if(hotObj.code == "200"){
                this.hotList = hotObj.data;
            }
            if(hotObj.code == "500"){
                console.log("请求失败")
            }
        }
    },
    mounted(){
        this.getHot();
    },

}

</script>

<template>
<div class="right-nav">
    <div class="hot">
        <div class="find">搜索发现</div>
        <div class="cut-off-line"></div>
        <div class="hot-words" v-for="item in showList" :key="item._id">{{ item.hot }}</div>
    </div>
    <div class="notice">
        <div>刘看山知乎指南知乎协议知乎隐私保护指引</div>
        <div>应用工作</div>
        <div>侵权举报</div>
        <div>网上有害信息举报专区</div>
        <div>京ICP证110745号</div>
        <div>京ICP备13052560号-1</div>
        <div>京公网安备11010802020088号</div>
        <div>©2022知乎</div>
    </div>
</div>
</template>

<style lang="scss" scoped>
.right-nav{
    margin-left: 12px;
    user-select: none;
    margin-top: 20px;
    .hot{
        width: 306px;
        height: auto;
        background: #FFFFFF;
        border-radius: 2px 2px 2px 2px;
        padding-top: 20px;
        .find{
            width: 64px;
            height: 22px;
            font-family: PingFang SC, PingFang SC;
            font-weight: normal;
            font-size: 16px;
            color: #1C1C1C;
            line-height: 22px;
            text-align: left;
            font-style: normal;
            text-transform: none;
            margin: 0px 20px 15px 20px;
        }
        .cut-off-line{
            width: 306px;
            height: 1px;
            background: #F3F3F3;
            border-radius: 0px 0px 0px 0px;
        }
                    .hot-words{
                width: 266px;
                height: 22px;
                font-family: PingFang SC, PingFang SC;
                font-weight: normal;
                font-size: 14px;
                color: #1C1C1C;
                line-height: 22px;
                text-align: left;
                font-style: normal;
                text-transform: none;
                margin-left: 20px;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
            }
    }
    .notice{
        display: block;
        margin-top: 20px;
        width: 267px;
        height: 476px;
        font-family: PingFang SC, PingFang SC;
        font-weight: normal;
        font-size: 14px;
        color: #8892A6;
        line-height: 30px;
        text-align: left;
        font-style: normal;
        text-transform: none;
    }
}
</style>