/********************************************
* 文件名称: RgctDraftTemplateDesc.java
* 系统名称: 合融基础技术平台V2.0
* 模块名称:
* 软件版权: 北京合融科技有限公司
* 功能说明: 
* 系统版本: 2.0.0.1
* 开发人员: 技术平台组
* 开发时间:  
* 审核人员:
* 相关文档:
* 修改记录: 修改日期    修改人员    修改说明
*********************************************/
package com.herongtech.rc.domain.desc;

import java.util.HashMap;
import java.util.Map;
import com.herongtech.domain.FieldDesc;
import com.herongtech.domain.IBeanDesc;
public class RgctDraftTemplateDesc implements IBeanDesc {
	private Map<String,FieldDesc> fieldDescMap=new HashMap<String,FieldDesc>();
	public RgctDraftTemplateDesc(){
FieldDesc  fieldDesc=null;
 fieldDesc=new FieldDesc();
 fieldDesc.setBeanFileName("id");
 fieldDesc.setType("Long");
 fieldDesc.setLength(0);
 fieldDesc.setScale(0);
 fieldDescMap.put(fieldDesc.getBeanFileName(),fieldDesc);


 fieldDesc=new FieldDesc();
 fieldDesc.setBeanFileName("draftNo");
 fieldDesc.setType("String");
 fieldDesc.setLength(50);
 fieldDesc.setScale(0);
 fieldDescMap.put(fieldDesc.getBeanFileName(),fieldDesc);


 fieldDesc=new FieldDesc();
 fieldDesc.setBeanFileName("templateName");
 fieldDesc.setType("String");
 fieldDesc.setLength(100);
 fieldDesc.setScale(0);
 fieldDescMap.put(fieldDesc.getBeanFileName(),fieldDesc);


 fieldDesc=new FieldDesc();
 fieldDesc.setBeanFileName("templateCtx");
 fieldDesc.setType("String");
 fieldDesc.setLength(256);
 fieldDesc.setScale(0);
 fieldDescMap.put(fieldDesc.getBeanFileName(),fieldDesc);


 fieldDesc=new FieldDesc();
 fieldDesc.setBeanFileName("busiType");
 fieldDesc.setType("String");
 fieldDesc.setLength(50);
 fieldDesc.setScale(0);
 fieldDescMap.put(fieldDesc.getBeanFileName(),fieldDesc);


 fieldDesc=new FieldDesc();
 fieldDesc.setBeanFileName("templateCnName");
 fieldDesc.setType("String");
 fieldDesc.setLength(100);
 fieldDesc.setScale(0);
 fieldDescMap.put(fieldDesc.getBeanFileName(),fieldDesc);


 fieldDesc=new FieldDesc();
 fieldDesc.setBeanFileName("sysRunStatus");
 fieldDesc.setType("String");
 fieldDesc.setLength(70);
 fieldDesc.setScale(0);
 fieldDescMap.put(fieldDesc.getBeanFileName(),fieldDesc);


 fieldDesc=new FieldDesc();
 fieldDesc.setBeanFileName("useQueue");
 fieldDesc.setType("String");
 fieldDesc.setLength(1);
 fieldDesc.setScale(0);
 fieldDescMap.put(fieldDesc.getBeanFileName(),fieldDesc);


 fieldDesc=new FieldDesc();
 fieldDesc.setBeanFileName("isCheckDraft");
 fieldDesc.setType("String");
 fieldDesc.setLength(1);
 fieldDesc.setScale(0);
 fieldDescMap.put(fieldDesc.getBeanFileName(),fieldDesc);



}
public FieldDesc getFieldDesc(String beanFieldName){
   return fieldDescMap.get(beanFieldName);
}

}
