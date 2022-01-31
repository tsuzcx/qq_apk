package com.tencent.token.core.bean;

import com.tencent.token.global.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeterminVerifyFactorsResult
  implements Serializable
{
  public static final int S_SOURCE_ID_FIND_PWD = 1;
  public static final int S_SOURCE_ID_FREEZE = 2;
  public static final int VERIFY_FACTOR_FACE = 5;
  public static final int VERIFY_FACTOR_FACE_IDCARD = 6;
  public static final int VERIFY_FACTOR_MB_MOBILE = 3;
  public static final int VERIFY_FACTOR_MB_QUESTION = 7;
  public static final int VERIFY_FACTOR_ORIGINAL_MOBILE = 2;
  public static final int VERIFY_FACTOR_QQ_TOKEN = 4;
  public static final int VERIFY_FACTOR_WITHOUT_VERIFY = 1;
  public static int s_SourceId = 0;
  private static final long serialVersionUID = -233992462595624579L;
  private boolean isAddAccountFlag;
  private int mCanVerify = 0;
  private int mHaveMobile = 0;
  private int mIsZzb = 0;
  private int mMobileAppear = 0;
  private String mMobileMask = "";
  private int mMobileUp = 0;
  private int mQuesAppear = 0;
  private List mQuesInfo = new ArrayList();
  private String mSMSChannel = "";
  private String mSMSContent = "";
  private String mSMSLeftMsg = "";
  private int mScene = 0;
  private String mSmsPrefix = "";
  private List mVerifyTypeList = new ArrayList();
  
  public DeterminVerifyFactorsResult(JSONObject paramJSONObject)
  {
    h.a("DeterminVerifyFactorsResult jsonObject=" + paramJSONObject.toString());
    s_SourceId = 0;
    this.mCanVerify = paramJSONObject.getInt("can_verify");
    this.mScene = paramJSONObject.optInt("scene");
    this.mHaveMobile = paramJSONObject.getInt("have_mobile");
    this.mMobileMask = paramJSONObject.getString("mobile_mask");
    this.mIsZzb = paramJSONObject.getInt("is_zzb");
    this.mMobileAppear = paramJSONObject.getInt("mobile_appear");
    this.mQuesAppear = paramJSONObject.getInt("ques_appear");
    this.mSmsPrefix = paramJSONObject.getString("mobile_sms_prefix");
    this.mMobileUp = paramJSONObject.optInt("mobile_appear_up");
    this.mSMSContent = paramJSONObject.optString("mobile_sms_content");
    this.mSMSChannel = paramJSONObject.optString("mobile_sms_port");
    this.mSMSLeftMsg = paramJSONObject.optString("no_sms_left");
    Object localObject;
    if (this.mQuesAppear == 1)
    {
      localObject = paramJSONObject.getJSONArray("ques_info");
      if ((localObject != null) && (((JSONArray)localObject).length() != 0)) {}
    }
    for (;;)
    {
      return;
      this.mQuesInfo = new ArrayList();
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        DeterminVerifyFactorsResult.QuesInfoItem localQuesInfoItem = new DeterminVerifyFactorsResult.QuesInfoItem(this, ((JSONArray)localObject).getJSONObject(i));
        this.mQuesInfo.add(localQuesInfoItem);
        i += 1;
      }
      paramJSONObject = paramJSONObject.getJSONArray("verify_type");
      i = j;
      while (i < paramJSONObject.length())
      {
        localObject = new DeterminVerifyFactorsResult.VerifyTypeItem(this, paramJSONObject.getJSONObject(i));
        this.mVerifyTypeList.add(localObject);
        i += 1;
      }
    }
  }
  
  public static void a(int paramInt)
  {
    s_SourceId = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.isAddAccountFlag = paramBoolean;
  }
  
  public boolean a()
  {
    return this.isAddAccountFlag;
  }
  
  public boolean b()
  {
    return this.mHaveMobile == 1;
  }
  
  public int c()
  {
    return this.mScene;
  }
  
  public String d()
  {
    return this.mSMSContent;
  }
  
  public String e()
  {
    return this.mSMSChannel;
  }
  
  public String f()
  {
    return this.mSMSLeftMsg;
  }
  
  public String g()
  {
    return this.mMobileMask;
  }
  
  public boolean h()
  {
    return this.mIsZzb == 1;
  }
  
  public boolean i()
  {
    return this.mMobileAppear == 1;
  }
  
  public boolean j()
  {
    return this.mMobileUp == 1;
  }
  
  public List k()
  {
    return this.mQuesInfo;
  }
  
  public List l()
  {
    return this.mVerifyTypeList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.DeterminVerifyFactorsResult
 * JD-Core Version:    0.7.0.1
 */