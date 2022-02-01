package com.tencent.biz.qqstory.takevideo.publish;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import rld;

public class PublishParam
  implements Parcelable
{
  public static final String BUNDLE_EXTRA_KEY = PublishParam.class.getName();
  public static final Parcelable.Creator<PublishParam> CREATOR = new rld();
  public final String aBf;
  public final String aBg;
  public final String atDoodlePath;
  public final String atJsonData;
  public final String audioFilePath;
  public final int bsP;
  public final int bsX;
  public final int bsY;
  public final int bsZ;
  public final int bta;
  public final int btb;
  public final String doodlePath;
  public final String fakeVid;
  public final int recordFrames;
  public final int saveMode;
  public int specialVideoType;
  public final int syncToStory;
  public final String thumbPath;
  public final String videoAddress;
  public final String videoDoodleDescription;
  public final long videoDuration;
  public final String videoFilePath;
  public final int videoHeight;
  public final String videoLabel;
  public final int videoMaxrate;
  public final int videoMinrate;
  public final int videoWidth;
  
  public PublishParam(Parcel paramParcel)
  {
    this.fakeVid = paramParcel.readString();
    this.thumbPath = paramParcel.readString();
    this.doodlePath = paramParcel.readString();
    this.videoLabel = paramParcel.readString();
    this.videoDoodleDescription = paramParcel.readString();
    this.videoAddress = paramParcel.readString();
    this.videoWidth = paramParcel.readInt();
    this.videoHeight = paramParcel.readInt();
    this.videoDuration = paramParcel.readLong();
    this.videoMaxrate = paramParcel.readInt();
    this.videoMinrate = paramParcel.readInt();
    this.bsX = paramParcel.readInt();
    this.saveMode = paramParcel.readInt();
    this.recordFrames = paramParcel.readInt();
    this.atDoodlePath = paramParcel.readString();
    this.atJsonData = paramParcel.readString();
    this.bsY = paramParcel.readInt();
    this.syncToStory = paramParcel.readInt();
    this.bsZ = paramParcel.readInt();
    this.videoFilePath = paramParcel.readString();
    this.audioFilePath = paramParcel.readString();
    this.aBf = paramParcel.readString();
    this.aBg = paramParcel.readString();
    this.bsP = paramParcel.readInt();
    this.bta = paramParcel.readInt();
    this.btb = paramParcel.readInt();
    this.specialVideoType = paramParcel.readInt();
    paramParcel = mT();
    if (paramParcel != null) {
      throw new RuntimeException(paramParcel);
    }
  }
  
  public PublishParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString7, String paramString8, int paramInt8, int paramInt9, int paramInt10, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt11, boolean paramBoolean, int paramInt12, int paramInt13)
  {
    this.fakeVid = paramString1;
    this.thumbPath = paramString2;
    this.doodlePath = paramString3;
    this.videoLabel = paramString4;
    this.videoDoodleDescription = paramString5;
    this.videoAddress = paramString6;
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    this.videoDuration = paramLong;
    this.videoMaxrate = paramInt3;
    this.videoMinrate = paramInt4;
    this.bsX = paramInt5;
    this.saveMode = paramInt6;
    this.recordFrames = paramInt7;
    this.atDoodlePath = paramString7;
    this.atJsonData = paramString8;
    this.bsY = paramInt8;
    this.syncToStory = paramInt9;
    this.bsZ = paramInt10;
    this.videoFilePath = paramString9;
    this.audioFilePath = paramString10;
    this.aBf = paramString11;
    this.aBg = paramString12;
    this.bsP = paramInt11;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      this.bta = paramInt1;
      this.btb = paramInt12;
      this.specialVideoType = paramInt13;
      paramString1 = mT();
      if (paramString1 == null) {
        break;
      }
      throw new RuntimeException(paramString1);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected String mT()
  {
    if ((TextUtils.isEmpty(this.fakeVid)) || (TextUtils.isEmpty(this.thumbPath))) {
      return "both fakeVid and thumbPath should not be empty";
    }
    return null;
  }
  
  public String toString()
  {
    return "PublishParam{fakeVid='" + this.fakeVid + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", doodlePath='" + this.doodlePath + '\'' + ", videoLabel='" + this.videoLabel + '\'' + ", videoDoodleDescription='" + this.videoDoodleDescription + '\'' + ", videoAddress='" + this.videoAddress + '\'' + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoDuration=" + this.videoDuration + ", videoMaxrate=" + this.videoMaxrate + ", videoMinrate=" + this.videoMinrate + ", isEdited=" + this.bsX + ", saveMode=" + this.saveMode + ", recordFrames=" + this.recordFrames + ", atDoodlePath='" + this.atDoodlePath + '\'' + ", atJsonData='" + this.atJsonData + '\'' + ", needSyncToStory='" + this.syncToStory + '\'' + ", hwEncodeRecordVideo='" + this.bsZ + '\'' + ", videoFilePath='" + this.videoFilePath + '\'' + ", audioFilePath='" + this.audioFilePath + '\'' + ", mosaicFilePath='" + this.aBg + '\'' + ", videoCount=" + this.bsP + "', redBagType=" + this.btb + "', specialVideoType=" + this.specialVideoType + "'" + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.fakeVid);
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeString(this.doodlePath);
    paramParcel.writeString(this.videoLabel);
    paramParcel.writeString(this.videoDoodleDescription);
    paramParcel.writeString(this.videoAddress);
    paramParcel.writeInt(this.videoWidth);
    paramParcel.writeInt(this.videoHeight);
    paramParcel.writeLong(this.videoDuration);
    paramParcel.writeInt(this.videoMaxrate);
    paramParcel.writeInt(this.videoMinrate);
    paramParcel.writeInt(this.bsX);
    paramParcel.writeInt(this.saveMode);
    paramParcel.writeInt(this.recordFrames);
    paramParcel.writeString(this.atDoodlePath);
    paramParcel.writeString(this.atJsonData);
    paramParcel.writeInt(this.bsY);
    paramParcel.writeInt(this.syncToStory);
    paramParcel.writeInt(this.bsZ);
    paramParcel.writeString(this.videoFilePath);
    paramParcel.writeString(this.audioFilePath);
    paramParcel.writeString(this.aBf);
    paramParcel.writeString(this.aBg);
    paramParcel.writeInt(this.bsP);
    paramParcel.writeInt(this.bta);
    paramParcel.writeInt(this.btb);
    paramParcel.writeInt(this.specialVideoType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.PublishParam
 * JD-Core Version:    0.7.0.1
 */