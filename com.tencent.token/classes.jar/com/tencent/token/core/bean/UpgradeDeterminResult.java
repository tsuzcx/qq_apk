package com.tencent.token.core.bean;

import com.tencent.token.global.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class UpgradeDeterminResult
  implements Serializable
{
  public static final int BINDTYPE_APPEAL = 7;
  public static final int BINDTYPE_DIR = 2;
  public static final int BINDTYPE_DNA = 1;
  public static final int BINDTYPE_NOCHECK_NOAUTH = 5;
  public static final int BINDTYPE_NOCHECK_NONEPHONE = 3;
  public static final int BINDTYPE_NOCHECK_VERFIYPHONE = 6;
  public static final int BINDTYPE_NOCHECK_WITHAUTH = 4;
  public static final int BINDTYPE_REALNAME = 8;
  public static final int BINDTYPE_REALNAME_H5 = 9;
  private static final long serialVersionUID = 1229246620832794524L;
  private int bindType = 0;
  public int mHaveMobile;
  public int mMobileAppear;
  public String mMobileMask = "";
  public int mQqtokenAppear;
  public int mQuesAppear;
  public List mQuesInfo = null;
  public long mServerTime;
  public String mSmsPort;
  public String mSmsPrefix = "";
  public String mUin = "";
  
  public UpgradeDeterminResult()
  {
    this.mHaveMobile = 0;
    this.mQqtokenAppear = 0;
    this.mQuesAppear = 0;
    this.mMobileAppear = 0;
    this.mQuesInfo = new ArrayList();
  }
  
  public UpgradeDeterminResult(JSONObject paramJSONObject)
  {
    this.bindType = paramJSONObject.getInt("bind_type");
    e.a("UpgradeDeterminResult jsonObject=" + paramJSONObject.toString());
    this.mHaveMobile = paramJSONObject.getInt("have_mobile");
    this.mMobileMask = paramJSONObject.getString("mobile_mask");
    this.mQqtokenAppear = paramJSONObject.getInt("qqtoken_appear");
    this.mQuesAppear = paramJSONObject.getInt("ques_appear");
    this.mMobileAppear = paramJSONObject.getInt("mobile_appear");
    this.mSmsPrefix = paramJSONObject.getString("mobile_sms_prefix");
    if (this.mQuesAppear == 1)
    {
      paramJSONObject = paramJSONObject.getJSONArray("ques_info");
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0)) {
        break label156;
      }
    }
    for (;;)
    {
      return;
      label156:
      this.mQuesInfo = new ArrayList();
      while (i < paramJSONObject.length())
      {
        UpgradeDeterminResult.QuesInfoItem localQuesInfoItem = new UpgradeDeterminResult.QuesInfoItem(this, paramJSONObject.getJSONObject(i));
        this.mQuesInfo.add(localQuesInfoItem);
        i += 1;
      }
    }
  }
  
  public final int a()
  {
    return this.bindType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.UpgradeDeterminResult
 * JD-Core Version:    0.7.0.1
 */