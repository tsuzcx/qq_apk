package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aqoj;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import mgz;
import tencent.im.oidb.articlesummary.articlesummary.DisLikeInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DisLikeInfo;

public class DislikeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DislikeInfo> CREATOR = new mgz();
  public String agQ;
  public byte[] data;
  public String puin;
  public int type;
  public long vf;
  
  public DislikeInfo() {}
  
  public DislikeInfo(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.vf = paramParcel.readLong();
    this.agQ = paramParcel.readString();
    this.puin = paramParcel.readString();
  }
  
  public static String k(ArrayList<DislikeInfo> paramArrayList)
  {
    Object localObject2;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localObject2 = "";
      return localObject2;
    }
    int j = paramArrayList.size();
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      localObject2 = (String)localObject1 + aqoj.C(((DislikeInfo)paramArrayList.get(i)).data);
      localObject1 = localObject2;
      if (i != j - 1) {
        localObject1 = (String)localObject2 + "_";
      }
      i += 1;
    }
  }
  
  public static ArrayList<DislikeInfo> r(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("_");
    int i = paramString.length;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    for (;;)
    {
      if (i < paramString.length)
      {
        articlesummary.DisLikeInfo localDisLikeInfo = new articlesummary.DisLikeInfo();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        try
        {
          localDisLikeInfo.mergeFrom(aqoj.ag(paramString[i]));
          localDislikeInfo.a(localDisLikeInfo);
          localArrayList.add(localDislikeInfo);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(articlesummary.DisLikeInfo paramDisLikeInfo)
  {
    this.agQ = paramDisLikeInfo.bytes_dislike_describe.get().toStringUtf8();
    this.type = paramDisLikeInfo.type.get();
    this.puin = paramDisLikeInfo.bytes_dislike_account_id.get().toStringUtf8();
    this.vf = paramDisLikeInfo.uint64_dislike_tagid.get();
    this.data = paramDisLikeInfo.toByteArray();
  }
  
  public void a(oidb_0x6cf.DisLikeInfo paramDisLikeInfo)
  {
    this.agQ = paramDisLikeInfo.bytes_dislike_describe.get().toStringUtf8();
    this.type = paramDisLikeInfo.type.get();
    this.puin = paramDisLikeInfo.bytes_dislike_account_id.get().toStringUtf8();
    this.vf = paramDisLikeInfo.uint64_dislike_tagid.get();
    this.data = paramDisLikeInfo.toByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DislikeInfo{type=" + this.type + ", tagID=" + this.vf + ", describe='" + this.agQ + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.vf);
    paramParcel.writeString(this.agQ);
    paramParcel.writeString(this.puin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo
 * JD-Core Version:    0.7.0.1
 */