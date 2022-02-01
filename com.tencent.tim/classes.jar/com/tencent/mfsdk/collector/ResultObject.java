package com.tencent.mfsdk.collector;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import java.io.Serializable;
import org.json.JSONObject;

public final class ResultObject
  extends RecyclablePool.Recyclable
  implements Serializable
{
  private static final long serialVersionUID = -1219845830201712069L;
  public int dbId;
  public long elapse;
  public String eventName = "";
  public boolean isMerge;
  public boolean isRealTime;
  public boolean isSucceed = true;
  public JSONObject params;
  public int reportType;
  public long size;
  public long uin = 10000L;
  
  public ResultObject() {}
  
  public ResultObject(int paramInt, String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, JSONObject paramJSONObject, boolean paramBoolean2, boolean paramBoolean3, long paramLong3)
  {
    this.reportType = paramInt;
    this.eventName = paramString;
    this.isSucceed = paramBoolean1;
    this.elapse = paramLong1;
    this.size = paramLong2;
    this.params = paramJSONObject;
    this.isRealTime = paramBoolean2;
    this.isMerge = paramBoolean3;
    this.uin = paramLong3;
  }
  
  public void recycle()
  {
    super.recycle();
    this.reportType = 0;
    this.eventName = "";
    this.isSucceed = false;
    this.elapse = 0L;
    this.size = 0L;
    this.params = null;
    this.isRealTime = false;
    this.isMerge = false;
    this.uin = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.collector.ResultObject
 * JD-Core Version:    0.7.0.1
 */