package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class LbsReportInfo
  extends Entity
{
  public float accuracy;
  public double alt;
  public String businessTag;
  public String city;
  public String content;
  public String district;
  public double lat;
  public double lng;
  public String nation;
  public long operTime;
  public String province;
  
  public static ArrayList<String> convert2StrList(ArrayList<LbsReportInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      LbsReportInfo localLbsReportInfo = (LbsReportInfo)paramArrayList.next();
      if ((localLbsReportInfo != null) && (!TextUtils.isEmpty(localLbsReportInfo.content))) {
        localArrayList.add(localLbsReportInfo.content);
      }
    }
    return localArrayList;
  }
  
  public void compatible()
  {
    String[] arrayOfString;
    if (TextUtils.isEmpty(this.businessTag))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsReportInfo", 2, "开始走旧版LBS数据兼容逻辑");
      }
      if (!TextUtils.isEmpty(this.content))
      {
        arrayOfString = this.content.split("\\|");
        if (arrayOfString.length != 7) {}
      }
    }
    try
    {
      this.operTime = Long.parseLong(arrayOfString[0]);
      this.lat = Double.parseDouble(arrayOfString[1]);
      this.lng = Double.parseDouble(arrayOfString[2]);
      this.alt = Double.parseDouble(arrayOfString[3]);
      this.accuracy = Float.parseFloat(arrayOfString[4]);
      this.businessTag = arrayOfString[5];
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LbsReportInfo", 2, localException, new Object[0]);
    }
  }
  
  public void createContent()
  {
    this.content = (this.operTime + "|" + this.lat + "|" + this.lng + "|" + this.alt + "|" + this.accuracy + "|" + this.businessTag + "|" + "android");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.LbsReportInfo
 * JD-Core Version:    0.7.0.1
 */