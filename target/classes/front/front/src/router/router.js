import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import yonggongbumenList from '../pages/yonggongbumen/list'
import yonggongbumenDetail from '../pages/yonggongbumen/detail'
import yonggongbumenAdd from '../pages/yonggongbumen/add'
import gangweileixingList from '../pages/gangweileixing/list'
import gangweileixingDetail from '../pages/gangweileixing/detail'
import gangweileixingAdd from '../pages/gangweileixing/add'
import qingongzhuxueList from '../pages/qingongzhuxue/list'
import qingongzhuxueDetail from '../pages/qingongzhuxue/detail'
import qingongzhuxueAdd from '../pages/qingongzhuxue/add'
import gangweishenqingList from '../pages/gangweishenqing/list'
import gangweishenqingDetail from '../pages/gangweishenqing/detail'
import gangweishenqingAdd from '../pages/gangweishenqing/add'
import gangweimianshiList from '../pages/gangweimianshi/list'
import gangweimianshiDetail from '../pages/gangweimianshi/detail'
import gangweimianshiAdd from '../pages/gangweimianshi/add'
import gangweiluyongList from '../pages/gangweiluyong/list'
import gangweiluyongDetail from '../pages/gangweiluyong/detail'
import gangweiluyongAdd from '../pages/gangweiluyong/add'
import xueshengkaoheList from '../pages/xueshengkaohe/list'
import xueshengkaoheDetail from '../pages/xueshengkaohe/detail'
import xueshengkaoheAdd from '../pages/xueshengkaohe/add'
import gongzijiesuanList from '../pages/gongzijiesuan/list'
import gongzijiesuanDetail from '../pages/gongzijiesuan/detail'
import gongzijiesuanAdd from '../pages/gongzijiesuan/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'yonggongbumen',
					component: yonggongbumenList
				},
				{
					path: 'yonggongbumenDetail',
					component: yonggongbumenDetail
				},
				{
					path: 'yonggongbumenAdd',
					component: yonggongbumenAdd
				},
				{
					path: 'gangweileixing',
					component: gangweileixingList
				},
				{
					path: 'gangweileixingDetail',
					component: gangweileixingDetail
				},
				{
					path: 'gangweileixingAdd',
					component: gangweileixingAdd
				},
				{
					path: 'qingongzhuxue',
					component: qingongzhuxueList
				},
				{
					path: 'qingongzhuxueDetail',
					component: qingongzhuxueDetail
				},
				{
					path: 'qingongzhuxueAdd',
					component: qingongzhuxueAdd
				},
				{
					path: 'gangweishenqing',
					component: gangweishenqingList
				},
				{
					path: 'gangweishenqingDetail',
					component: gangweishenqingDetail
				},
				{
					path: 'gangweishenqingAdd',
					component: gangweishenqingAdd
				},
				{
					path: 'gangweimianshi',
					component: gangweimianshiList
				},
				{
					path: 'gangweimianshiDetail',
					component: gangweimianshiDetail
				},
				{
					path: 'gangweimianshiAdd',
					component: gangweimianshiAdd
				},
				{
					path: 'gangweiluyong',
					component: gangweiluyongList
				},
				{
					path: 'gangweiluyongDetail',
					component: gangweiluyongDetail
				},
				{
					path: 'gangweiluyongAdd',
					component: gangweiluyongAdd
				},
				{
					path: 'xueshengkaohe',
					component: xueshengkaoheList
				},
				{
					path: 'xueshengkaoheDetail',
					component: xueshengkaoheDetail
				},
				{
					path: 'xueshengkaoheAdd',
					component: xueshengkaoheAdd
				},
				{
					path: 'gongzijiesuan',
					component: gongzijiesuanList
				},
				{
					path: 'gongzijiesuanDetail',
					component: gongzijiesuanDetail
				},
				{
					path: 'gongzijiesuanAdd',
					component: gongzijiesuanAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
