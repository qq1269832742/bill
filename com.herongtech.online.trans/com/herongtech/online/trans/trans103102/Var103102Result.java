package com.herongtech.online.trans.trans103102;

import java.util.List;

import com.herongtech.xmlchannel.pkg.ProResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;


public class Var103102Result {
   
    private ProResult proResult;
    private String totNum;//总记录数
    private String errNum;//错误记录数
    private List<Var103102InfoBean> result;
    
    
    
    public ProResult getProResult() {
        return proResult;
    }


    
    public void setProResult(ProResult proResult) {
        this.proResult = proResult;
    }


    public List<Var103102InfoBean> getResult() {
        return result;
    }

    
    public void setResult(List<Var103102InfoBean> result) {
        this.result = result;
    }



	public String getTotNum() {
		return totNum;
	}



	public void setTotNum(String totNum) {
		this.totNum = totNum;
	}



	public String getErrNum() {
		return errNum;
	}



	public void setErrNum(String errNum) {
		this.errNum = errNum;
	}
    
    
}
