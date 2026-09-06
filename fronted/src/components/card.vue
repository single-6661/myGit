
<script>
import { contentGet } from '@/utils/Request.js'
import bus from '@/utils/EventBus'

export default{
    data(){
        return{
            contentList:[],
            searchList:[],
            isChangeCard:false
        }
    },
    methods:{
        async getContent(){
            const res = await contentGet("/contentCard");
            const backendObj = res;
            if(backendObj.code == "200"){
                //后端传入的是result数据
                const arr = backendObj.data;
                this.contentList = arr.map(item=>{
          return {
            ...item,
            expand: false
          }});
            }
            if(backendObj.code == "500"){
                console.log("请求错误")
            }
        },

        openContent(card){
            card.expand = !card.expand;
        }

    },
    mounted(){
        this.getContent();

        bus.on('searchData',(payload)=>{
            this.searchList = payload.searchList;
            this.isChangeCard = payload.isChangeCard;
        })
    },
    //防止内存泄漏
    beforeUnmount(){
        bus.off('searchData')
    }
}

</script>

<template>
<div class="card" 
     v-for="card in isChangeCard ? searchList : contentList " 
     :key="card._id"
     :class="{card_expand: card.expand}">
    <div class="title">
        {{ card.title }}
    </div>
    <div class="content">
        <div class="content-words" :class="{'active': card.expand}">
            {{card.AuthorName || "未知用户"}}:{{ card.contentText }}
        </div>
        <button class="read-all" @click="openContent(card)">阅读全文</button>
    </div>
    <div class="foot">
        <div class="is-agree">
            <button class="agree">顶{{ card.voteUpCount }}</button>
            <button class="not-agree">踩</button>
        </div>
        <div class="comment">评论</div>
        <div class="day">{{ card.date }}</div>
    </div>
</div>
</template>



<style lang="css" scoped>

.card{
    user-select: none;
    margin-top: 10px;
    width: 682px;
    height: auto;
    background: #FFFFFF;
    border-radius: 2px 2px 2px 2px;
    .title{
        width: 645px;
        font-family: PingFang SC, PingFang SC;
        font-weight: normal;
        font-size: 16px;
        color: #1C1C1C;
        line-height: 22px;
        text-align: left;
        font-style: normal;
        text-transform: none;
        margin-top: 20px;
        margin-left: 15px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    .content{
            margin-top: 12px;
            margin-left: 15px;
            width: 645px;
        &-words{
            width: 645px;
            background: #FFFFFF;
            border-radius: 2px 2px 2px 2px;
            overflow: hidden;
            text-overflow: ellipsis;
            display: inline-block;
            line-clamp: 2;
            }
            .read-all{
                width: 56px;
                height: 22px;
                font-family: PingFang SC, PingFang SC;
                font-weight: normal;
                font-size: 14px;
                color: #005DB5;
                line-height: 22px;
                text-align: left;
                font-style: normal;
                text-transform: none;
                }
        }
        .foot{
            display: flex;
            align-items: center;
            margin-top: 20px;
            .is-agree{
                button{
                    height: 30px;
                    background: #E8EFFC;
                    border-radius: 2px 2px 0px 2px;
                    padding: 4px 8px;
                    font-family: PingFang SC, PingFang SC;
                    font-weight: normal;
                    font-size: 14px;
                    color: #426BED;
                    line-height: 22px;
                    text-align: left;
                    font-style: normal;
                    text-transform: none;
                }
                .agree{
                    margin-left: 15px;
                }
                .not-agree{
                    margin-left: 4px;
                }
            }
            .comment{
                width: 56px;
                height: 22px;
                font-family: PingFang SC, PingFang SC;
                font-weight: normal;
                font-size: 14px;
                color: #888FA2;
                line-height: 22px;
                text-align: left;
                font-style: normal;
                text-transform: none;
                margin-left: 24px;
            }
            .day{
                width: 38px;
                height: 22px;
                font-family: PingFang SC, PingFang SC;
                font-weight: normal;
                font-size: 14px;
                color: #888FA2;
                line-height: 22px;
                text-align: left;
                font-style: normal;
                text-transform: none;
                margin-left: 24px;
            }
        }
}
</style>

//‑webkit‑box‑orient:vertica不能在scoped中，会被vue删除
<style lang="scss">
.content-words.active{
    display:block;
    -webkit-line-clamp: unset;
    -webkit-box-orient: unset;
    overflow: visible;
}
.content-words{
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    line-clamp:2;
}
</style>