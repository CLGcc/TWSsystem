<template>
<div :style='{"width":"1200px","padding":"120px 7% 100px","margin":"0px auto","position":"relative","background":"url(http://codegen.caihongy.cn/20230109/138a4d606eae4a168810cef229969885.png) no-repeat center top,url(http://codegen.caihongy.cn/20230109/b95aeae1c1294f398aefb7c6cd5b16de.png) no-repeat center top,url(http://codegen.caihongy.cn/20230109/5ffc803e6682418eb7f0b09a98e35527.png) no-repeat center bottom,#faf0e6"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="110px"
    >
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}'  label="岗位名称" prop="gangweimingcheng">
            <el-select v-model="ruleForm.gangweimingcheng" placeholder="请选择岗位名称"  >
              <el-option
                  v-for="(item,index) in gangweimingchengOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="学号" prop="xuehao">
            <el-select  @change="xuehaoChange" v-model="ruleForm.xuehao" placeholder="请选择学号">
              <el-option
                  v-for="(item,index) in xuehaoOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="学生姓名" prop="xueshengxingming">
            <el-input v-model="ruleForm.xueshengxingming" 
                placeholder="学生姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="底薪" prop="dixin">
            <el-input v-model="ruleForm.dixin" 
                placeholder="底薪" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="绩效" prop="jixiao">
            <el-input v-model="ruleForm.jixiao" 
                placeholder="绩效" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="岗位补贴" prop="gangweibutie">
            <el-input v-model="ruleForm.gangweibutie" 
                placeholder="岗位补贴" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="全勤奖" prop="quanqinjiang">
            <el-input v-model="ruleForm.quanqinjiang" 
                placeholder="全勤奖" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="加班费" prop="jiabanfei">
            <el-input v-model="ruleForm.jiabanfei" 
                placeholder="加班费" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="扣绩效" prop="koujixiao">
            <el-input v-model="ruleForm.koujixiao" 
                placeholder="扣绩效" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="其它扣款" prop="qitakoukuan">
            <el-input v-model="ruleForm.qitakoukuan" 
                placeholder="其它扣款" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="实发工资" prop="shifagongzi">
              <el-input v-model="shifagongzi" placeholder="实发工资" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="工资备注" prop="gongzibeizhu">
            <el-input v-model="ruleForm.gongzibeizhu" 
                placeholder="工资备注" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="部门账号" prop="bumenzhanghao">
            <el-input v-model="ruleForm.bumenzhanghao" 
                placeholder="部门账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="部门名称" prop="bumenmingcheng">
            <el-input v-model="ruleForm.bumenmingcheng" 
                placeholder="部门名称" clearable ></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","textAlign":"center","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#cca162","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#009688","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            gangweimingcheng : false,
            xuehao : false,
            xueshengxingming : false,
            dixin : false,
            jixiao : false,
            gangweibutie : false,
            quanqinjiang : false,
            jiabanfei : false,
            koujixiao : false,
            qitakoukuan : false,
            shifagongzi : false,
            gongzibeizhu : false,
            bumenzhanghao : false,
            bumenmingcheng : false,
            ispay : false,
            userid : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          gangweimingcheng: '',
          xuehao: '',
          xueshengxingming: '',
          dixin: '',
          jixiao: '',
          gangweibutie: '',
          quanqinjiang: '',
          jiabanfei: '',
          koujixiao: '',
          qitakoukuan: '',
          shifagongzi: '',
          gongzibeizhu: '',
          bumenzhanghao: '',
          bumenmingcheng: '',
          ispay: '',
          userid: '',
        },
        gangweimingchengOptions: [],
        xuehaoOptions: [],
        rules: {
          gangweimingcheng: [
            { required: true, message: '岗位名称不能为空', trigger: 'blur' },
          ],
          xuehao: [
            { required: true, message: '学号不能为空', trigger: 'blur' },
          ],
          xueshengxingming: [
          ],
          dixin: [
            { required: true, message: '底薪不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          jixiao: [
            { required: true, message: '绩效不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          gangweibutie: [
            { required: true, message: '岗位补贴不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          quanqinjiang: [
            { required: true, message: '全勤奖不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          jiabanfei: [
            { required: true, message: '加班费不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          koujixiao: [
            { required: true, message: '扣绩效不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          qitakoukuan: [
            { required: true, message: '其它扣款不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          shifagongzi: [
          ],
          gongzibeizhu: [
          ],
          bumenzhanghao: [
          ],
          bumenmingcheng: [
          ],
          ispay: [
          ],
          userid: [
          ],
        },
      };
    },
    computed: {
        shifagongzi: {
            get: function () {
                return 0+parseFloat(this.ruleForm.dixin==""?0:this.ruleForm.dixin)+parseFloat(this.ruleForm.jixiao==""?0:this.ruleForm.jixiao)+parseFloat(this.ruleForm.gangweibutie==""?0:this.ruleForm.gangweibutie)+parseFloat(this.ruleForm.quanqinjiang==""?0:this.ruleForm.quanqinjiang)+parseFloat(this.ruleForm.jiabanfei==""?0:this.ruleForm.jiabanfei)-parseFloat(this.ruleForm.koujixiao==""?0:this.ruleForm.koujixiao)-parseFloat(this.ruleForm.qitakoukuan==""?0:this.ruleForm.qitakoukuan) || 0
            }
        },



    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='gangweimingcheng'){
              this.ruleForm.gangweimingcheng = obj[o];
              this.ro.gangweimingcheng = true;
              continue;
            }
            if(o=='xuehao'){
              this.ruleForm.xuehao = obj[o];
              this.ro.xuehao = true;
              continue;
            }
            if(o=='xueshengxingming'){
              this.ruleForm.xueshengxingming = obj[o];
              this.ro.xueshengxingming = true;
              continue;
            }
            if(o=='dixin'){
              this.ruleForm.dixin = obj[o];
              this.ro.dixin = true;
              continue;
            }
            if(o=='jixiao'){
              this.ruleForm.jixiao = obj[o];
              this.ro.jixiao = true;
              continue;
            }
            if(o=='gangweibutie'){
              this.ruleForm.gangweibutie = obj[o];
              this.ro.gangweibutie = true;
              continue;
            }
            if(o=='quanqinjiang'){
              this.ruleForm.quanqinjiang = obj[o];
              this.ro.quanqinjiang = true;
              continue;
            }
            if(o=='jiabanfei'){
              this.ruleForm.jiabanfei = obj[o];
              this.ro.jiabanfei = true;
              continue;
            }
            if(o=='koujixiao'){
              this.ruleForm.koujixiao = obj[o];
              this.ro.koujixiao = true;
              continue;
            }
            if(o=='qitakoukuan'){
              this.ruleForm.qitakoukuan = obj[o];
              this.ro.qitakoukuan = true;
              continue;
            }
            if(o=='shifagongzi'){
              this.ruleForm.shifagongzi = obj[o];
              this.ro.shifagongzi = true;
              continue;
            }
            if(o=='gongzibeizhu'){
              this.ruleForm.gongzibeizhu = obj[o];
              this.ro.gongzibeizhu = true;
              continue;
            }
            if(o=='bumenzhanghao'){
              this.ruleForm.bumenzhanghao = obj[o];
              this.ro.bumenzhanghao = true;
              continue;
            }
            if(o=='bumenmingcheng'){
              this.ruleForm.bumenmingcheng = obj[o];
              this.ro.bumenmingcheng = true;
              continue;
            }
            if(o=='userid'){
              this.ruleForm.userid = obj[o];
              this.ro.userid = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.bumenzhanghao!=''&&json.bumenzhanghao) || json.bumenzhanghao==0){
                this.ruleForm.bumenzhanghao = json.bumenzhanghao
            }
            if((json.bumenmingcheng!=''&&json.bumenmingcheng) || json.bumenmingcheng==0){
                this.ruleForm.bumenmingcheng = json.bumenmingcheng
            }
          }
        });
        this.$http.get('option/qingongzhuxue/gangweimingcheng', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.gangweimingchengOptions = res.data.data;
          }
        });
        this.$http.get('option/xuesheng/xuehao', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.xuehaoOptions = res.data.data;
          }
        });
      },
      // 下二随
      xuehaoChange () {
        this.$http.get('follow/xuesheng/xuehao?columnValue=' + this.ruleForm.xuehao, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.xueshengxingming){
              this.ruleForm.xueshengxingming = res.data.data.xueshengxingming
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('gongzijiesuan/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

          this.ruleForm.shifagongzi = this.shifagongzi
        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('gongzijiesuan/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('gongzijiesuan/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('gongzijiesuan/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 110px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 110px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #e5d9c6;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #e5d9c6;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #e5d9c6;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #e5d9c6;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #e5d9c6;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #e5d9c6;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #e5d9c6;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
