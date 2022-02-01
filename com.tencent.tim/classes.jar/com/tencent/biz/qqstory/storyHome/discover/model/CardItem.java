package com.tencent.biz.qqstory.storyHome.discover.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GatherCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NearbyCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.OperationCardInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import qti;
import ram;
import rom;

public class CardItem
  extends BaseUIItem
{
  public static final int CARD_TYPE_GATHER = 4;
  public static final int CARD_TYPE_NEARBY = 2;
  public static final int CARD_TYPE_NORMAL = 1;
  public static final int CARD_TYPE_OPERATION = 3;
  public String cardId;
  public int cardType;
  public a gatherCardInfo;
  public boolean hasReportExp;
  public b nearByCardInfo;
  public c normalCardInfo;
  public d operationCardInfo;
  
  public CardItem(CardEntry paramCardEntry)
  {
    this.cardId = paramCardEntry.cardId;
    this.cardType = paramCardEntry.cardType;
    switch (this.cardType)
    {
    default: 
      rom.fail("not support this type %d for cardId %s", new Object[] { Integer.valueOf(this.cardType), this.cardId });
      return;
    case 1: 
      this.normalCardInfo = new c(paramCardEntry.PBData);
      return;
    case 2: 
      this.nearByCardInfo = new b(paramCardEntry.PBData);
      return;
    case 3: 
      this.operationCardInfo = new d(paramCardEntry.PBData);
      return;
    }
    this.gatherCardInfo = new a(paramCardEntry.PBData);
  }
  
  public CardItem(qqstory_struct.CardInfo paramCardInfo)
  {
    this.cardId = paramCardInfo.card_id.get().toStringUtf8();
    this.cardType = paramCardInfo.card_type.get();
    switch (this.cardType)
    {
    default: 
      rom.fail("not support this type %d for cardId %s", new Object[] { Integer.valueOf(this.cardType), this.cardId });
      return;
    case 1: 
      this.normalCardInfo = new c(paramCardInfo.normal_card);
      return;
    case 2: 
      this.nearByCardInfo = new b(paramCardInfo.nearby_card);
      return;
    case 3: 
      this.operationCardInfo = new d(paramCardInfo.operation_card);
      return;
    }
    this.gatherCardInfo = new a(paramCardInfo.gather_card);
  }
  
  public CardItem(String paramString, c paramc)
  {
    if ((paramString == null) || (paramc == null)) {
      throw new IllegalArgumentException("parameter should not be null");
    }
    this.cardId = paramString;
    this.cardType = 1;
    this.normalCardInfo = paramc;
  }
  
  @Nullable
  public CardVideoInfo getCardVideoInfo()
  {
    switch (this.cardType)
    {
    default: 
      return null;
    case 1: 
      return this.normalCardInfo.a();
    case 2: 
      return this.nearByCardInfo.a();
    }
    return this.operationCardInfo.a();
  }
  
  @Nullable
  public String getFeedId()
  {
    CardVideoInfo localCardVideoInfo = getCardVideoInfo();
    if (localCardVideoInfo != null) {
      return localCardVideoInfo.getFeedId();
    }
    return null;
  }
  
  public CardEntry toCardEntry()
  {
    CardEntry localCardEntry = new CardEntry();
    localCardEntry.cardId = this.cardId;
    localCardEntry.cardType = this.cardType;
    switch (this.cardType)
    {
    default: 
      rom.fail("not support this type %d for cardId %s", new Object[] { Integer.valueOf(this.cardType), this.cardId });
      return localCardEntry;
    case 1: 
      localCardEntry.PBData = c.a(this.normalCardInfo).toByteArray();
      return localCardEntry;
    case 2: 
      localCardEntry.PBData = b.a(this.nearByCardInfo).toByteArray();
      return localCardEntry;
    case 3: 
      localCardEntry.PBData = d.a(this.operationCardInfo).toByteArray();
      return localCardEntry;
    }
    localCardEntry.PBData = a.a(this.gatherCardInfo).toByteArray();
    return localCardEntry;
  }
  
  public String toString()
  {
    return "CardItem{cardId='" + this.cardId + '\'' + ", cardType=" + this.cardType + ", gatherCardInfo=" + this.gatherCardInfo + ", nearByCardInfo=" + this.nearByCardInfo + ", normalCardInfo=" + this.normalCardInfo + ", operationCardInfo=" + this.operationCardInfo + '}';
  }
  
  public static class CardVideoInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<CardVideoInfo> CREATOR = new qti();
    private qqstory_struct.CardVideoInfo a;
    
    public CardVideoInfo(Parcel paramParcel)
    {
      try
      {
        this.a = new qqstory_struct.CardVideoInfo();
        this.a.mergeFrom(paramParcel.createByteArray());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramParcel) {}
    }
    
    public CardVideoInfo(qqstory_struct.CardVideoInfo paramCardVideoInfo)
    {
      this.a = paramCardVideoInfo;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getFeedId()
    {
      return this.a.feed_id.get().toStringUtf8();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeByteArray(this.a.toByteArray());
    }
  }
  
  public static class a
  {
    private qqstory_struct.GatherCardInfo a;
    
    public a(qqstory_struct.GatherCardInfo paramGatherCardInfo)
    {
      this.a = paramGatherCardInfo;
    }
    
    public a(byte[] paramArrayOfByte)
    {
      this.a = new qqstory_struct.GatherCardInfo();
      try
      {
        this.a.mergeFrom(paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
      }
    }
  }
  
  public static class b
  {
    private qqstory_struct.NearbyCardInfo jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo;
    private CardItem.CardVideoInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
    
    public b(qqstory_struct.NearbyCardInfo paramNearbyCardInfo)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo = paramNearbyCardInfo;
    }
    
    public b(byte[] paramArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo = new qqstory_struct.NearbyCardInfo();
      try
      {
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.mergeFrom(paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
      }
    }
    
    public CardItem.CardVideoInfo a()
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo == null)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.card_info.story_video_info.size() == 0) {
          return null;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = new CardItem.CardVideoInfo((qqstory_struct.CardVideoInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.card_info.story_video_info.get(0));
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
    }
  }
  
  public static class c
  {
    private qqstory_struct.NormalCardInfo jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo;
    private CardItem.CardVideoInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
    
    public c(qqstory_struct.NormalCardInfo paramNormalCardInfo)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo = paramNormalCardInfo;
    }
    
    public c(byte[] paramArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo = new qqstory_struct.NormalCardInfo();
      try
      {
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo.mergeFrom(paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
      }
    }
    
    public CardItem.CardVideoInfo a()
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo == null)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo.story_video_info.size() == 0) {
          return null;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = new CardItem.CardVideoInfo((qqstory_struct.CardVideoInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo.story_video_info.get(0));
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
    }
  }
  
  public static class d
  {
    private qqstory_struct.OperationCardInfo jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo;
    private CardItem.CardVideoInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
    
    public d(qqstory_struct.OperationCardInfo paramOperationCardInfo)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo = paramOperationCardInfo;
    }
    
    public d(byte[] paramArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo = new qqstory_struct.OperationCardInfo();
      try
      {
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo.mergeFrom(paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
      }
    }
    
    public CardItem.CardVideoInfo a()
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo == null)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo.card_info.story_video_info.size() == 0) {
          return null;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = new CardItem.CardVideoInfo((qqstory_struct.CardVideoInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo.card_info.story_video_info.get(0));
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem
 * JD-Core Version:    0.7.0.1
 */