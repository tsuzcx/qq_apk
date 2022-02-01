package com.tencent.mobileqq.shortvideo.videotransfer;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TransferData
{
  public static final String KEY_CONFIG_DATA = "config_data";
  public static final String KEY_POSITION_LIST = "pos_list";
  public static final String KEY_REVERSE_SHIFT = "reverse_shift";
  public TransferConfig.ConfigData mConfigData = new TransferConfig.ConfigData();
  private ArrayList<Long> mPositionList = new ArrayList();
  private long mReverseShift = -100L;
  
  public TransferData()
  {
    setConfigData(null);
    setPositions(null);
  }
  
  public TransferData(TransferConfig.ConfigData paramConfigData)
  {
    setConfigData(paramConfigData);
    setPositions(null);
  }
  
  public TransferData(ArrayList<Long> paramArrayList)
  {
    setPositions(paramArrayList);
    setConfigData(null);
  }
  
  public void fromJSONObject(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.mConfigData.fromJSONObject(paramString.optString("config_data"));
      JSONArray localJSONArray = paramString.optJSONArray("pos_list");
      this.mPositionList.clear();
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          this.mPositionList.add(Long.valueOf(localJSONArray.getLong(i)));
          i += 1;
        }
      }
      this.mReverseShift = paramString.optLong("reverse_shift");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public ArrayList<Long> getPositions()
  {
    return this.mPositionList;
  }
  
  public long getReverseShift()
  {
    return this.mReverseShift;
  }
  
  public void setConfigData(TransferConfig.ConfigData paramConfigData)
  {
    if (paramConfigData != null)
    {
      this.mConfigData.mID = paramConfigData.mID;
      this.mConfigData.mVerShader = paramConfigData.mVerShader;
      this.mConfigData.mFragShader = paramConfigData.mFragShader;
      this.mConfigData.shaderList.clear();
      this.mConfigData.shaderList.addAll(paramConfigData.shaderList);
      this.mConfigData.mDuration = paramConfigData.mDuration;
      this.mConfigData.mCommonFloat1 = paramConfigData.mCommonFloat1;
      this.mConfigData.mCommonFloat2 = paramConfigData.mCommonFloat2;
      this.mConfigData.mCommonFloat3 = paramConfigData.mCommonFloat3;
      this.mConfigData.mCommonFloat4 = paramConfigData.mCommonFloat4;
      this.mConfigData.mLevelEffectShader = paramConfigData.mLevelEffectShader;
      return;
    }
    this.mConfigData.mID = -1;
  }
  
  public void setPositions(ArrayList<Long> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.mPositionList.addAll(paramArrayList);
      Collections.sort(this.mPositionList);
      return;
    }
    this.mPositionList.clear();
  }
  
  public void setReverseShift(long paramLong)
  {
    this.mReverseShift = paramLong;
  }
  
  public String toJSONObject()
  {
    if ((this.mPositionList == null) || (this.mPositionList.size() == 0)) {}
    while (!this.mConfigData.isValid()) {
      return null;
    }
    JSONArray localJSONArray;
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("config_data", this.mConfigData.toJSONObject());
      localJSONObject.put("reverse_shift", this.mReverseShift);
      localJSONArray = new JSONArray();
      Iterator localIterator = this.mPositionList.iterator();
      while (localIterator.hasNext())
      {
        localJSONArray.put((Long)localIterator.next());
        continue;
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = null;
    }
    for (;;)
    {
      str.put("pos_list", localJSONArray);
      str = str.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferData
 * JD-Core Version:    0.7.0.1
 */