import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import gangweileixing from '@/views/modules/gangweileixing/list'
    import gangweiluyong from '@/views/modules/gangweiluyong/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import gangweishenqing from '@/views/modules/gangweishenqing/list'
    import qingongzhuxue from '@/views/modules/qingongzhuxue/list'
    import gangweimianshi from '@/views/modules/gangweimianshi/list'
    import gongzijiesuan from '@/views/modules/gongzijiesuan/list'
    import xueshengkaohe from '@/views/modules/xueshengkaohe/list'
    import config from '@/views/modules/config/list'
    import yonggongbumen from '@/views/modules/yonggongbumen/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/gangweileixing',
        name: '岗位类型',
        component: gangweileixing
      }
      ,{
	path: '/gangweiluyong',
        name: '岗位录用',
        component: gangweiluyong
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/gangweishenqing',
        name: '岗位申请',
        component: gangweishenqing
      }
      ,{
	path: '/qingongzhuxue',
        name: '勤工助学',
        component: qingongzhuxue
      }
      ,{
	path: '/gangweimianshi',
        name: '岗位面试',
        component: gangweimianshi
      }
      ,{
	path: '/gongzijiesuan',
        name: '工资结算',
        component: gongzijiesuan
      }
      ,{
	path: '/xueshengkaohe',
        name: '学生考核',
        component: xueshengkaohe
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/yonggongbumen',
        name: '用工部门',
        component: yonggongbumen
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
