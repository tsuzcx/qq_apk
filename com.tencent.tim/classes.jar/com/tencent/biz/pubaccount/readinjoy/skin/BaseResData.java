package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id,uin")
public abstract class BaseResData<T extends MessageMicro>
  extends Entity
{
  public int beginTime;
  public String business = "";
  public int endTime;
  public String id;
  public boolean isReady;
  public String name;
  public byte[] resData;
  public long seq;
  public int showTime;
  public String uin;
  public String url;
  
  public BaseResData() {}
  
  public BaseResData(T paramT)
  {
    this.uin = (BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() + "");
  }
  
  public BaseResData(JSONObject paramJSONObject)
  {
    this.uin = (BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() + "");
  }
  
  public void postRead() {}
  
  public void postwrite() {}
  
  public abstract T toBody();
  
  public JSONObject toJson()
  {
    return new JSONObject();
  }
  
  public String toString()
  {
    return "BaseResData{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", url='" + this.url + '\'' + ", seq=" + this.seq + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.BaseResData
 * JD-Core Version:    0.7.0.1
 */