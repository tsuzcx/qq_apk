package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import miq;

public class WeishiRedDotInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiRedDotInfo> CREATOR = new miq();
  private String aiU = "";
  private String algorithmId = "";
  private List<String> iZ = new ArrayList();
  private String pushContext = "";
  private String title = "";
  
  public WeishiRedDotInfo(Parcel paramParcel)
  {
    this.iZ = paramParcel.createStringArrayList();
    this.title = paramParcel.readString();
    this.algorithmId = paramParcel.readString();
    this.aiU = paramParcel.readString();
    this.pushContext = paramParcel.readString();
  }
  
  public WeishiRedDotInfo(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      paramMessageForStructing = paramMessageForStructing.structingMsg;
      if (paramMessageForStructing.mAlgorithmIds != null) {
        this.algorithmId = paramMessageForStructing.mAlgorithmIds;
      }
      if (paramMessageForStructing.mStrategyIds != null) {
        this.aiU = paramMessageForStructing.mStrategyIds;
      }
      if (paramMessageForStructing.mMsgBrief != null) {
        this.title = paramMessageForStructing.mMsgBrief;
      }
      if (!TextUtils.isEmpty(paramMessageForStructing.mArticleIds)) {
        this.iZ.addAll(Arrays.asList(paramMessageForStructing.mArticleIds.split("\\|")));
      }
      if (paramMessageForStructing.mMsgActionData != null) {
        this.pushContext = paramMessageForStructing.mMsgActionData;
      }
    }
  }
  
  public List<String> ba()
  {
    return this.iZ;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String jX()
  {
    return this.algorithmId;
  }
  
  public String jY()
  {
    return this.aiU;
  }
  
  public String jd()
  {
    return this.pushContext;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringList(this.iZ);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.algorithmId);
    paramParcel.writeString(this.aiU);
    paramParcel.writeString(this.pushContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo
 * JD-Core Version:    0.7.0.1
 */