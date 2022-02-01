package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mhp;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.MultiBiuSameContent;

public class MultiBiuSameContent
  implements Parcelable
{
  public static final Parcelable.Creator<MultiBiuSameContent> CREATOR = new mhp();
  public int aLh;
  public int aRW;
  public String ahj;
  public ArrayList<SocializeFeedsInfo.BiuCommentInfo> kW = new ArrayList();
  public int mStrategyId;
  public long mUin;
  public int mUinType;
  public long vd;
  public long vm;
  
  public MultiBiuSameContent() {}
  
  public MultiBiuSameContent(Parcel paramParcel)
  {
    this.mUin = paramParcel.readLong();
    this.ahj = paramParcel.readString();
    this.mUinType = paramParcel.readInt();
    this.aRW = paramParcel.readInt();
    this.vd = paramParcel.readLong();
    this.aLh = paramParcel.readInt();
    this.mStrategyId = paramParcel.readInt();
    this.vm = paramParcel.readLong();
    this.kW = paramParcel.createTypedArrayList(SocializeFeedsInfo.BiuCommentInfo.CREATOR);
  }
  
  public static ArrayList<MultiBiuSameContent> p(List<articlesummary.MultiBiuSameContent> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      MultiBiuSameContent localMultiBiuSameContent;
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          Object localObject = (articlesummary.MultiBiuSameContent)paramList.next();
          localMultiBiuSameContent = new MultiBiuSameContent();
          localMultiBiuSameContent.ahj = ((articlesummary.MultiBiuSameContent)localObject).bytes_biu_comments.get().toStringUtf8();
          localMultiBiuSameContent.mUin = ((articlesummary.MultiBiuSameContent)localObject).uint64_uin.get();
          localMultiBiuSameContent.mUinType = ((articlesummary.MultiBiuSameContent)localObject).enum_uin_type.get();
          localMultiBiuSameContent.aRW = ((articlesummary.MultiBiuSameContent)localObject).uint32_biu_time.get();
          localMultiBiuSameContent.vd = ((articlesummary.MultiBiuSameContent)localObject).uint64_feeds_id.get();
          localMultiBiuSameContent.aLh = ((articlesummary.MultiBiuSameContent)localObject).uint32_feeds_type.get();
          localMultiBiuSameContent.mStrategyId = ((articlesummary.MultiBiuSameContent)localObject).uint32_strategy_id.get();
          localMultiBiuSameContent.vm = ((articlesummary.MultiBiuSameContent)localObject).uint64_algorithm_id.get();
          if ((((articlesummary.MultiBiuSameContent)localObject).rpt_biu_mutli_level.has()) && (((articlesummary.MultiBiuSameContent)localObject).rpt_biu_mutli_level.get() != null))
          {
            localObject = ((articlesummary.MultiBiuSameContent)localObject).rpt_biu_mutli_level.get().iterator();
            if (((Iterator)localObject).hasNext())
            {
              articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)((Iterator)localObject).next();
              localMultiBiuSameContent.kW.add(SocializeFeedsInfo.a(localBiuOneLevelItem));
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiBiuSameContent", 2, "parseFromPBBytes error:" + paramList.toString());
        }
      }
      localArrayList.add(localMultiBiuSameContent);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mUin);
    paramParcel.writeString(this.ahj);
    paramParcel.writeInt(this.mUinType);
    paramParcel.writeInt(this.aRW);
    paramParcel.writeLong(this.vd);
    paramParcel.writeInt(this.aLh);
    paramParcel.writeInt(this.mStrategyId);
    paramParcel.writeLong(this.vm);
    paramParcel.writeTypedList(this.kW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent
 * JD-Core Version:    0.7.0.1
 */