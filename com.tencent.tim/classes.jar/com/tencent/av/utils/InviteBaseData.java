package com.tencent.av.utils;

import ajdo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import jjz;

public class InviteBaseData
  implements Parcelable
{
  public static final Parcelable.Creator<InviteBaseData> CREATOR = new jjz();
  public String QD = "-1";
  public String SB;
  public int dataType = 0;
  public String name;
  public int type;
  public String uin;
  
  public InviteBaseData() {}
  
  public InviteBaseData(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.SB = paramParcel.readString();
    this.dataType = paramParcel.readInt();
    this.QD = paramParcel.readString();
  }
  
  public InviteBaseData(AVPhoneUserInfo paramAVPhoneUserInfo, QQAppInterface paramQQAppInterface)
  {
    if (paramAVPhoneUserInfo == null) {}
    label181:
    for (;;)
    {
      return;
      this.uin = String.valueOf(paramAVPhoneUserInfo.account);
      if (paramAVPhoneUserInfo.accountType == 1) {}
      for (this.type = 0;; this.type = 1006) {
        do
        {
          if (paramAVPhoneUserInfo.telInfo == null) {
            break label181;
          }
          this.SB = paramAVPhoneUserInfo.telInfo.mobile;
          paramQQAppInterface = ((ajdo)paramQQAppInterface.getManager(11)).b(this.SB);
          if (paramQQAppInterface == null) {
            break label189;
          }
          this.name = paramQQAppInterface.name;
          if (TextUtils.isEmpty(paramQQAppInterface.uin)) {
            break;
          }
          if (!paramQQAppInterface.uin.equals("0")) {
            break label183;
          }
          this.type = 1006;
          this.SB = (paramAVPhoneUserInfo.telInfo.nation + paramAVPhoneUserInfo.telInfo.mobile);
          return;
        } while ((paramAVPhoneUserInfo.accountType != 2) && (paramAVPhoneUserInfo.accountType != 3));
      }
    }
    label183:
    this.type = 0;
    return;
    label189:
    this.name = paramAVPhoneUserInfo.telInfo.mobile;
  }
  
  public InviteBaseData(DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    this.uin = paramDiscussionMemberInfo.memberUin;
    this.type = 0;
    this.name = paramDiscussionMemberInfo.getDiscussionMemberName();
    this.dataType = 0;
    this.QD = paramDiscussionMemberInfo.discussionUin;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin=").append(this.uin);
    localStringBuilder.append(",type=").append(this.type);
    localStringBuilder.append(",phone=").append(this.SB).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.SB);
    paramParcel.writeInt(this.dataType);
    paramParcel.writeString(this.QD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.InviteBaseData
 * JD-Core Version:    0.7.0.1
 */