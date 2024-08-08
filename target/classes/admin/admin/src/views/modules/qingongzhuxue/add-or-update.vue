<template>
	<div class="addEdit-block" style="width: 100%;">
		<el-form
			:style='{"padding":"30px 40px","boxShadow":"0 0px 0px #999","borderRadius":"6px","flexWrap":"wrap","background":"none","display":"flex","justifyContent":"space-between"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="岗位名称" prop="gangweimingcheng">
					<el-input v-model="ruleForm.gangweimingcheng" placeholder="岗位名称" clearable  :readonly="ro.gangweimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="岗位名称" prop="gangweimingcheng">
					<el-input v-model="ruleForm.gangweimingcheng" placeholder="岗位名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="upload" v-if="type!='info' && !ro.bangonghuanjing" label="办公环境" prop="bangonghuanjing">
					<file-upload
						tip="点击上传办公环境"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.bangonghuanjing?ruleForm.bangonghuanjing:''"
						@change="bangonghuanjingUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="upload" v-else-if="ruleForm.bangonghuanjing" label="办公环境" prop="bangonghuanjing">
					<img v-if="ruleForm.bangonghuanjing.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.bangonghuanjing.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.bangonghuanjing.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="select" v-if="type!='info'"  label="岗位类型" prop="gangweileixing">
					<el-select :disabled="ro.gangweileixing" v-model="ruleForm.gangweileixing" placeholder="请选择岗位类型" >
						<el-option
							v-for="(item,index) in gangweileixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="岗位类型" prop="gangweileixing">
					<el-input v-model="ruleForm.gangweileixing"
						placeholder="岗位类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="薪资待遇/天" prop="xinzidaiyu">
					<el-input v-model="ruleForm.xinzidaiyu" placeholder="薪资待遇/天" clearable  :readonly="ro.xinzidaiyu"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="薪资待遇/天" prop="xinzidaiyu">
					<el-input v-model="ruleForm.xinzidaiyu" placeholder="薪资待遇/天" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="工作时间" prop="gongzuoshijian">
					<el-input v-model="ruleForm.gongzuoshijian" placeholder="工作时间" clearable  :readonly="ro.gongzuoshijian"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="工作时间" prop="gongzuoshijian">
					<el-input v-model="ruleForm.gongzuoshijian" placeholder="工作时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="工作地点" prop="gongzuodidian">
					<el-input v-model="ruleForm.gongzuodidian" placeholder="工作地点" clearable  :readonly="ro.gongzuodidian"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="工作地点" prop="gongzuodidian">
					<el-input v-model="ruleForm.gongzuodidian" placeholder="工作地点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="联系人" prop="lianxiren">
					<el-input v-model="ruleForm.lianxiren" placeholder="联系人" clearable  :readonly="ro.lianxiren"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="联系人" prop="lianxiren">
					<el-input v-model="ruleForm.lianxiren" placeholder="联系人" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="部门账号" prop="bumenzhanghao">
					<el-input v-model="ruleForm.bumenzhanghao" placeholder="部门账号" clearable  :readonly="ro.bumenzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="部门账号" prop="bumenzhanghao">
					<el-input v-model="ruleForm.bumenzhanghao" placeholder="部门账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="部门名称" prop="bumenmingcheng">
					<el-input v-model="ruleForm.bumenmingcheng" placeholder="部门名称" clearable  :readonly="ro.bumenmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="部门名称" prop="bumenmingcheng">
					<el-input v-model="ruleForm.bumenmingcheng" placeholder="部门名称" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-if="type!='info'"  label="岗位介绍" prop="gangweijieshao">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.gangweijieshao" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else-if="ruleForm.gangweijieshao" label="岗位介绍" prop="gangweijieshao">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.gangweijieshao"></span>
                </el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto","background":"none"}' class="btn">
				<el-button :style='{"border":"1px solid #6ebe9b","cursor":"pointer","padding":"0 16px","boxShadow":"inset 0px 0px 56px 0px #5dae8b","margin":"20px 40px 20px 0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"4px","background":"#fff","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"1px solid #e68888","cursor":"pointer","padding":"0 16px","boxShadow":"inset 0px 0px 56px 0px #ff7676","margin":"0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"4px","background":"#fff","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"1px solid #e68888","cursor":"pointer","padding":"0 16px","boxShadow":"inset 0px 0px 56px 0px #ff7676","margin":"0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"4px","background":"#fff","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				gangweimingcheng : false,
				bangonghuanjing : false,
				gangweileixing : false,
				xinzidaiyu : false,
				gongzuoshijian : false,
				gongzuodidian : false,
				gangweijieshao : false,
				lianxiren : false,
				lianxidianhua : false,
				bumenzhanghao : false,
				bumenmingcheng : false,
				sfsh : false,
				shhf : false,
				clicktime : false,
				clicknum : false,
			},
			
			
			ruleForm: {
				gangweimingcheng: '',
				bangonghuanjing: '',
				gangweileixing: '',
				xinzidaiyu: '',
				gongzuoshijian: '',
				gongzuodidian: '',
				gangweijieshao: '',
				lianxiren: '',
				lianxidianhua: '',
				bumenzhanghao: '',
				bumenmingcheng: '',
				shhf: '',
				clicktime: '',
			},
		
			gangweileixingOptions: [],
			
			rules: {
				gangweimingcheng: [
					{ required: true, message: '岗位名称不能为空', trigger: 'blur' },
				],
				bangonghuanjing: [
				],
				gangweileixing: [
				],
				xinzidaiyu: [
					{ required: true, message: '薪资待遇/天不能为空', trigger: 'blur' },
					{ validator: validateNumber, trigger: 'blur' },
				],
				gongzuoshijian: [
					{ required: true, message: '工作时间不能为空', trigger: 'blur' },
				],
				gongzuodidian: [
					{ required: true, message: '工作地点不能为空', trigger: 'blur' },
				],
				gangweijieshao: [
				],
				lianxiren: [
				],
				lianxidianhua: [
				],
				bumenzhanghao: [
				],
				bumenmingcheng: [
				],
				sfsh: [
				],
				shhf: [
				],
				clicktime: [
				],
				clicknum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='gangweimingcheng'){
							this.ruleForm.gangweimingcheng = obj[o];
							this.ro.gangweimingcheng = true;
							continue;
						}
						if(o=='bangonghuanjing'){
							this.ruleForm.bangonghuanjing = obj[o];
							this.ro.bangonghuanjing = true;
							continue;
						}
						if(o=='gangweileixing'){
							this.ruleForm.gangweileixing = obj[o];
							this.ro.gangweileixing = true;
							continue;
						}
						if(o=='xinzidaiyu'){
							this.ruleForm.xinzidaiyu = obj[o];
							this.ro.xinzidaiyu = true;
							continue;
						}
						if(o=='gongzuoshijian'){
							this.ruleForm.gongzuoshijian = obj[o];
							this.ro.gongzuoshijian = true;
							continue;
						}
						if(o=='gongzuodidian'){
							this.ruleForm.gongzuodidian = obj[o];
							this.ro.gongzuodidian = true;
							continue;
						}
						if(o=='gangweijieshao'){
							this.ruleForm.gangweijieshao = obj[o];
							this.ro.gangweijieshao = true;
							continue;
						}
						if(o=='lianxiren'){
							this.ruleForm.lianxiren = obj[o];
							this.ro.lianxiren = true;
							continue;
						}
						if(o=='lianxidianhua'){
							this.ruleForm.lianxidianhua = obj[o];
							this.ro.lianxidianhua = true;
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
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
						if(o=='clicknum'){
							this.ruleForm.clicknum = obj[o];
							this.ro.clicknum = true;
							continue;
						}
				}
				















			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.lianxiren!=''&&json.lianxiren) || json.lianxiren==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.lianxiren = json.lianxiren
						this.ro.lianxiren = true;
					}
					if(((json.lianxidianhua!=''&&json.lianxidianhua) || json.lianxidianhua==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.lianxidianhua = json.lianxidianhua
						this.ro.lianxidianhua = true;
					}
					if(((json.bumenzhanghao!=''&&json.bumenzhanghao) || json.bumenzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.bumenzhanghao = json.bumenzhanghao
						this.ro.bumenzhanghao = true;
					}
					if(((json.bumenmingcheng!=''&&json.bumenmingcheng) || json.bumenmingcheng==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.bumenmingcheng = json.bumenmingcheng
						this.ro.bumenmingcheng = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/gangweileixing/gangweileixing`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.gangweileixingOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `qingongzhuxue/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.gangweijieshao = this.ruleForm.gangweijieshao.replace(reg,'../../../TWSsystem/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {




	if(this.ruleForm.bangonghuanjing!=null) {
		this.ruleForm.bangonghuanjing = this.ruleForm.bangonghuanjing.replace(new RegExp(this.$base.url,"g"),"");
	}



























var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "qingongzhuxue/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `qingongzhuxue/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.qingongzhuxueCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `qingongzhuxue/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.qingongzhuxueCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.qingongzhuxueCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    bangonghuanjingUploadChange(fileUrls) {
	    this.ruleForm.bangonghuanjing = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  text-shadow: 0 1px 10px #fff;
	  	  color: #666;
	  	  background: none;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #c7ebdb;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  display: inline-block;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #c7ebdb;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #c7ebdb;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
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
	  	  border: 1px solid #c7ebdb;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  color: #aaa;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #c7ebdb;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  color: #aaa;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #c7ebdb;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  color: #aaa;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #c7ebdb;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-height: 150px;
	  	  min-width: 640px;
	  	  height: auto;
	  	}
</style>
