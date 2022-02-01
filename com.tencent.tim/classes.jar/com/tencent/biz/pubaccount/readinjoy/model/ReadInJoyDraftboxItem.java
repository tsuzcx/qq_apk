package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lin;
import lio;
import lip;

public class ReadInJoyDraftboxItem
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<ReadInJoyDraftboxItem> CREATOR = new lin();
  public static final int DEFAULT_DRAFTID = -1;
  public static final String TABLE_NAME = ReadInJoyDraftboxItem.class.getSimpleName();
  public static final int TYPE_ANSWER = 2;
  public static final int TYPE_ARTICLE = 1;
  public static final int TYPE_QUESTION = 3;
  public static final int TYPE_UGC = 0;
  public byte[] content;
  public String digest;
  public byte[] firstPic;
  public PicData firstPicData;
  public long time;
  public String title;
  public int type;
  
  public ReadInJoyDraftboxItem() {}
  
  public ReadInJoyDraftboxItem(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.digest = paramParcel.readString();
    this.time = paramParcel.readLong();
    if (paramParcel.readInt() > 0) {
      paramParcel.readByteArray(this.firstPic);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readByteArray(this.content);
    }
    this.type = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ReadInJoyDraftboxItem{id='" + getId() + '\'' + "title='" + this.title + '\'' + ", digest='" + this.digest + '\'' + ", time=" + this.time + ", type=" + this.type + ", firstPicData=" + this.firstPicData + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.digest);
    paramParcel.writeLong(this.time);
    if ((this.firstPic != null) && (this.firstPic.length > 0))
    {
      paramParcel.writeInt(this.firstPic.length);
      paramParcel.writeByteArray(this.firstPic);
      if ((this.content == null) || (this.content.length <= 0)) {
        break label105;
      }
      paramParcel.writeInt(this.content.length);
      paramParcel.writeByteArray(this.content);
    }
    for (;;)
    {
      paramParcel.writeInt(this.type);
      return;
      paramParcel.writeInt(0);
      break;
      label105:
      paramParcel.writeInt(0);
    }
  }
  
  public static class PicData
    implements Parcelable
  {
    public static final Parcelable.Creator<PicData> CREATOR = new lio();
    public HotPicData b;
    public String picPath;
    public int type = -1;
    
    public PicData() {}
    
    public PicData(Parcel paramParcel)
    {
      this.b = ((HotPicData)paramParcel.readParcelable(HotPicData.class.getClassLoader()));
      this.picPath = paramParcel.readString();
      this.type = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "PicData{hotPicData=" + this.b + ", localPic='" + this.picPath + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.b, paramInt);
      paramParcel.writeString(this.picPath);
      paramParcel.writeInt(this.type);
    }
  }
  
  public static class ReadInJoyDraftboxContent
    implements Parcelable, Serializable
  {
    public static final Parcelable.Creator<ReadInJoyDraftboxContent> CREATOR = new lip();
    private static final long serialVersionUID = 1L;
    public int adTag;
    public ArrayList<ReadInJoyDraftboxItem.PicData> adapterList;
    public String answerTitle;
    public int articleType;
    public String commentString;
    public ArrayList<SocializeFeedsInfo.BiuCommentInfo> multiBiuStruct;
    public int originFrom;
    public ArrayList<ReadInJoyDraftboxItem.PicData> picDataList;
    public ArrayList<ReadInJoyDraftboxItem.PicData> realList;
    public String richTextContent;
    public int srcSize;
    public String topicId;
    public List<Integer> typeList;
    public String ugcEditCookie;
    
    public ReadInJoyDraftboxContent() {}
    
    public ReadInJoyDraftboxContent(Parcel paramParcel)
    {
      this.topicId = paramParcel.readString();
      this.ugcEditCookie = paramParcel.readString();
      this.adTag = paramParcel.readInt();
      this.commentString = paramParcel.readString();
      this.typeList = paramParcel.readArrayList(Integer.class.getClassLoader());
      this.srcSize = paramParcel.readInt();
      this.multiBiuStruct = paramParcel.createTypedArrayList(SocializeFeedsInfo.BiuCommentInfo.CREATOR);
      this.picDataList = paramParcel.createTypedArrayList(ReadInJoyDraftboxItem.PicData.CREATOR);
      this.realList = paramParcel.createTypedArrayList(ReadInJoyDraftboxItem.PicData.CREATOR);
      this.adapterList = paramParcel.createTypedArrayList(ReadInJoyDraftboxItem.PicData.CREATOR);
      this.richTextContent = paramParcel.readString();
      this.answerTitle = paramParcel.readString();
      this.articleType = paramParcel.readInt();
      this.originFrom = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "ReadInJoyDraftboxContent{topicId='" + this.topicId + '\'' + ", ugcEditCookie='" + this.ugcEditCookie + '\'' + ", adTag=" + this.adTag + ", commentString='" + this.commentString + '\'' + ", typeList=" + this.typeList + ", srcSize=" + this.srcSize + ", multiBiuStruct=" + this.multiBiuStruct + ", picDataList=" + this.picDataList + ", realList=" + this.realList + ", adapterList=" + this.adapterList + ", richTextContent='" + this.richTextContent + '\'' + ", answerTitle='" + this.answerTitle + '\'' + ", articleType=" + this.articleType + ", originFrom=" + this.originFrom + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.topicId);
      paramParcel.writeString(this.ugcEditCookie);
      paramParcel.writeInt(this.adTag);
      paramParcel.writeString(this.commentString);
      paramParcel.writeList(this.typeList);
      paramParcel.writeInt(this.srcSize);
      paramParcel.writeTypedList(this.multiBiuStruct);
      paramParcel.writeTypedList(this.picDataList);
      paramParcel.writeTypedList(this.realList);
      paramParcel.writeTypedList(this.adapterList);
      paramParcel.writeString(this.richTextContent);
      paramParcel.writeString(this.answerTitle);
      paramParcel.writeInt(this.articleType);
      paramParcel.writeInt(this.originFrom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem
 * JD-Core Version:    0.7.0.1
 */