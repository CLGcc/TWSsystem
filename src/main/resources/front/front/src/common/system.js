export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除"],"menu":"用工部门","menuJump":"列表","tableName":"yonggongbumen"}],"menu":"用工部门管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"岗位类型","menuJump":"列表","tableName":"gangweileixing"}],"menu":"岗位类型管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","修改","删除","审核","岗位类型统计"],"menu":"勤工助学","menuJump":"列表","tableName":"qingongzhuxue"}],"menu":"勤工助学管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","修改","删除","岗位申请统计"],"menu":"岗位申请","menuJump":"列表","tableName":"gangweishenqing"}],"menu":"岗位申请管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","修改","删除"],"menu":"岗位面试","menuJump":"列表","tableName":"gangweimianshi"}],"menu":"岗位面试管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","修改","删除"],"menu":"岗位录用","menuJump":"列表","tableName":"gangweiluyong"}],"menu":"岗位录用管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","修改","删除"],"menu":"学生考核","menuJump":"列表","tableName":"xueshengkaohe"}],"menu":"学生考核管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","修改","删除"],"menu":"工资结算","menuJump":"列表","tableName":"gongzijiesuan"}],"menu":"工资结算管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","岗位申请"],"menu":"勤工助学列表","menuJump":"列表","tableName":"qingongzhuxue"}],"menu":"勤工助学模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"岗位申请","menuJump":"列表","tableName":"gangweishenqing"}],"menu":"岗位申请管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"岗位面试","menuJump":"列表","tableName":"gangweimianshi"}],"menu":"岗位面试管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看"],"menu":"岗位录用","menuJump":"列表","tableName":"gangweiluyong"}],"menu":"岗位录用管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看"],"menu":"学生考核","menuJump":"列表","tableName":"xueshengkaohe"}],"menu":"学生考核管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看"],"menu":"工资结算","menuJump":"列表","tableName":"gongzijiesuan"}],"menu":"工资结算管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","岗位申请"],"menu":"勤工助学列表","menuJump":"列表","tableName":"qingongzhuxue"}],"menu":"勤工助学模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除"],"menu":"勤工助学","menuJump":"列表","tableName":"qingongzhuxue"}],"menu":"勤工助学管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","审核","面试邀请"],"menu":"岗位申请","menuJump":"列表","tableName":"gangweishenqing"}],"menu":"岗位申请管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","录用"],"menu":"岗位面试","menuJump":"列表","tableName":"gangweimianshi"}],"menu":"岗位面试管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","考核情况"],"menu":"岗位录用","menuJump":"列表","tableName":"gangweiluyong"}],"menu":"岗位录用管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","修改"],"menu":"学生考核","menuJump":"列表","tableName":"xueshengkaohe"}],"menu":"学生考核管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","支付"],"menu":"工资结算","menuJump":"列表","tableName":"gongzijiesuan"}],"menu":"工资结算管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","岗位申请"],"menu":"勤工助学列表","menuJump":"列表","tableName":"qingongzhuxue"}],"menu":"勤工助学模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"用工部门","tableName":"yonggongbumen"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
