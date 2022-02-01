package com.tencent.token.core.bean;

import com.tencent.token.xa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  public boolean isAddAccountFlag;
  private int mCanVerify;
  private int mHaveMobile;
  private int mIsZzb;
  private int mMobileAppear;
  public String mMobileMask;
  private int mMobileUp;
  private int mQuesAppear;
  public List<QuesInfoItem> mQuesInfo;
  public String mSMSChannel;
  public String mSMSContent;
  public String mSMSLeftMsg;
  public int mScene;
  private String mSmsPrefix;
  public List<VerifyTypeItem> mVerifyTypeList;
  
  public DeterminVerifyFactorsResult(JSONObject paramJSONObject)
  {
    int j = 0;
    this.mHaveMobile = 0;
    this.mCanVerify = 0;
    this.mScene = 0;
    this.mMobileMask = "";
    this.mSMSContent = "";
    this.mSMSChannel = "";
    this.mSMSLeftMsg = "";
    this.mIsZzb = 0;
    this.mMobileAppear = 0;
    this.mQuesAppear = 0;
    this.mMobileUp = 0;
    this.mSmsPrefix = "";
    this.mQuesInfo = new ArrayList();
    this.mVerifyTypeList = new ArrayList();
    Object localObject = new StringBuilder("DeterminVerifyFactorsResult jsonObject=");
    ((StringBuilder)localObject).append(paramJSONObject.toString());
    xa.a(((StringBuilder)localObject).toString());
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
    if (this.mQuesAppear == 1)
    {
      localObject = paramJSONObject.getJSONArray("ques_info");
      if (localObject != null)
      {
        if (((JSONArray)localObject).length() == 0) {
          return;
        }
        this.mQuesInfo = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          QuesInfoItem localQuesInfoItem = new QuesInfoItem(((JSONArray)localObject).getJSONObject(i));
          this.mQuesInfo.add(localQuesInfoItem);
          i += 1;
        }
      }
      return;
    }
    paramJSONObject = paramJSONObject.getJSONArray("verify_type");
    int i = j;
    while (i < paramJSONObject.length())
    {
      localObject = new VerifyTypeItem(paramJSONObject.getJSONObject(i));
      this.mVerifyTypeList.add(localObject);
      i += 1;
    }
  }
  
  public static void a()
  {
    s_SourceId = 2;
  }
  
  public final boolean b()
  {
    return this.mHaveMobile == 1;
  }
  
  public final boolean c()
  {
    return this.mIsZzb == 1;
  }
  
  public final boolean d()
  {
    return this.mMobileAppear == 1;
  }
  
  public final boolean e()
  {
    return this.mMobileUp == 1;
  }
  
  public class QuesInfoItem
    implements Serializable
  {
    private static final long serialVersionUID = -545981221446172220L;
    public String mContent = null;
    public int mId = 0;
    public int mType = 0;
    
    public QuesInfoItem(JSONObject paramJSONObject)
    {
      this.mId = paramJSONObject.getInt("ques_id");
      this.mContent = paramJSONObject.getString("ques_context");
      this.mType = paramJSONObject.getInt("ques_type");
    }
  }
  
  public class VerifyTypeItem
    implements Serializable
  {
    private static final long serialVersionUID = 7129591075283836873L;
    private Map<Integer, Integer> factorPositionMap = new HashMap();
    public List<Integer> mVerifyFactorList = new ArrayList();
    public int verifyTypeId;
    public String verifyTypeName;
    
    public VerifyTypeItem(JSONObject paramJSONObject)
    {
      this.verifyTypeId = paramJSONObject.getInt("verify_type_id");
      this.verifyTypeName = paramJSONObject.getString("verify_type_name");
      this$1 = paramJSONObject.getJSONArray("verify_factors");
      int i = 0;
      while (i < DeterminVerifyFactorsResult.this.length())
      {
        this.mVerifyFactorList.add(Integer.valueOf(DeterminVerifyFactorsResult.this.getInt(i)));
        this.factorPositionMap.put(Integer.valueOf(DeterminVerifyFactorsResult.this.getInt(i)), Integer.valueOf(i));
        i += 1;
      }
    }
    
    public final int a(int paramInt)
    {
      paramInt = ((Integer)this.factorPositionMap.get(Integer.valueOf(paramInt))).intValue();
      if (paramInt < this.mVerifyFactorList.size() - 1) {
        paramInt += 1;
      } else {
        paramInt = this.mVerifyFactorList.size() - 1;
      }
      return ((Integer)this.mVerifyFactorList.get(paramInt)).intValue();
    }
    
    public final boolean a(Integer paramInteger)
    {
      return ((Integer)this.factorPositionMap.get(paramInteger)).intValue() == this.mVerifyFactorList.size() - 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.DeterminVerifyFactorsResult
 * JD-Core Version:    0.7.0.1
 */