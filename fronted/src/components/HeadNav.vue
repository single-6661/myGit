
<script>
import Search from './Search.vue';
export default{
    components:{
        Search,
    },
    data(){
        return {
            activeTab: 'comperhensiveActive',
            // 全部tab配置放这里，新增/删除只改数组
            tabList:[
                {key:'comperhensiveActive', label:'综合'},
                {key:'userActive', label:'用户'},
                {key:'topicActive', label:'话题'},
                {key:'videoActive', label:'学术'},
                {key:'scienceActive', label:'专栏'},
                {key:'columnActive', label:'严选内容'},
                {key:'choicenessActive', label:'电子书'},
                {key:'communityActive', label:'圈子'},
            ]
        }
    }
}
</script>

<template>
<div class="head-nav">
    <div class="frist-top-nav">
        <div class="zhihu">知乎</div>
        <div class="left">
            <div>首页</div>
            <div>会员</div>
            <div>等你来答</div>
            <div>发现</div>
        </div>
        <Search/>
        <div class="right">
            <div class="zhangai">无障碍</div>
            <button class="login">登录</button>
        </div>
    </div>
    <div class="second-top-nav">
            <div class="button-nav">
            <button
                v-for="item in tabList"
                :key="item.key"
                @click="activeTab = item.key"
                :class="{ active: activeTab === item.key }"
            >{{ item.label }}</button>
            </div>
            <button class="login">登录</button>
    </div>
</div>
</template>

<style lang="scss">
.head-nav{
    user-select: none;
    width: 100vw;
    height: 104px;
    background: #FFFFFF;
    box-shadow: 0px 4px 6px 1px rgba(0,0,0,0.05);
    border-radius: 0px 0px 0px 0px;
    .frist-top-nav{
        width: 100vw;
        height: 54px;
        background: #FFFFFF;
        border-radius: 0px 0px 0px 0px;
        border: 1px solid #EEEEEE;
        display: flex;
        justify-content: center;
        .zhihu{
            width: 64px;
            height: 54px;
            color: #1987FB;
            font-size: larger;
            text-align:center;
            line-height: 54px;
        }
         .left{
                display: flex;
                div{
                    height: 54px;
                    font-family: PingFang SC, PingFang SC;
                    font-weight: normal;
                    font-size: 15px;
                    color: #8892A6;
                    line-height: 22px;
                    text-align: left;
                    font-style: normal;
                    text-transform: none;
                    margin-left: 30px;
                    line-height: 54px;
                }
            }
            .right{
                display: flex;
                .zhangai{
                    width: 48px;
                    height: 54px;
                    font-family: PingFang SC, PingFang SC;
                    font-weight: normal;
                    font-size: 16px;
                    color: #8892A6;
                    line-height: 22px;
                    text-align: center;
                    font-style: normal;
                    text-transform: none;
                    line-height: 54px;
                    margin-left: 140px;
                }
            }
    }
    .second-top-nav{
        width: 99vw;
        height: 52px;
        background: #FFFFFF;
        box-shadow: 0px 4px 6px 1px rgba(0,0,0,0.05);
        border-radius: 0px 0px 0px 0px;
        display: flex;
        justify-content: center;
          .button-nav{
        width: 576px;
        height: 52px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        button{
        height: 54px;
        font-family: PingFang SC, PingFang SC;
        font-weight: normal;
        font-size: 16px;
        color: #1C1C1C;
        line-height: 22px;
        text-align: center;
        font-style: normal;
        text-transform: none;
        position: relative;
        padding-bottom: 8px;
        }
        button.active{
             &::after{
                content:"";
                position:absolute;
                margin-top: 30px;
                bottom:0;
                left:50%;
                transform:translateX(-50%);
                width:100%; /* 控制蓝色条的宽度，和截图匹配 */
                height:4px;
                background:#0084FF;
                border-radius:2px;
                }
            }
        
        }
    }
}

//登录按钮单独设置样式
.login{
    width: 66px;
    height: 34px;
    background: #FFFFFF;
    border-radius: 2px 2px 2px 2px;
    border: 1px solid #0084FF;
    font-family: PingFang SC, PingFang SC;
    font-weight: normal;
    font-size: 16px;
    color: #0084FF;
    line-height: 22px;
    text-align: center;
    font-style: normal;
    text-transform: none;
    margin-top: 10px;
    margin-left: 26px;
    }

</style>


//第二个style负责穿透子组件设置样式，在子组件中设置$attr
<style lang="scss">
.frist-top-nav .search{
    margin-top: 10px;
    margin-left: 100px;
 }
 .second-top-nav .search{
    margin-left: 30px;
    margin-top: 10px;
 }
</style>