package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;

public class AIOPictureData
  extends AIOBrowserBaseData
{
  public int EP = 0;
  public long Jx;
  public String TI;
  public String aVW = "I:N";
  public String aVX = "I:N";
  public String aVY = "I:N";
  public String aVZ = "I:N";
  public String aWi;
  public String aWj;
  public String aWk;
  public Object bQ;
  public int bWU;
  public boolean bdq;
  public boolean bim;
  public boolean bin;
  public boolean bio;
  public boolean bjc;
  public boolean bjd;
  public boolean bje;
  public boolean bjf;
  public boolean bjg;
  public int busId;
  public String content;
  public String fileName;
  public String filePath;
  public long groupFileID;
  public long height;
  public int imageBizType;
  public boolean isSend;
  public int mImageType;
  public String md5;
  public String send_uin;
  public String templateId;
  public String templateName;
  public long timestamp;
  public String uuid = "I:N";
  public long width;
  
  public int getType()
  {
    return 100;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    super.readFromParcel(paramParcel);
    this.aVW = paramParcel.readString();
    this.aVX = paramParcel.readString();
    this.aVY = paramParcel.readString();
    this.aVZ = paramParcel.readString();
    this.uuid = paramParcel.readString();
    this.timestamp = paramParcel.readLong();
    this.groupFileID = paramParcel.readLong();
    this.width = paramParcel.readLong();
    this.height = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.bjc = bool1;
      if (paramParcel.readByte() == 0) {
        break label331;
      }
      bool1 = true;
      label102:
      this.bjd = bool1;
      if (paramParcel.readByte() == 0) {
        break label336;
      }
      bool1 = true;
      label116:
      this.bje = bool1;
      this.mImageType = paramParcel.readInt();
      this.EP = paramParcel.readInt();
      this.bQ = paramParcel.readValue(null);
      if (paramParcel.readByte() == 0) {
        break label341;
      }
      bool1 = true;
      label155:
      this.bjf = bool1;
      this.Jx = paramParcel.readLong();
      this.fileName = paramParcel.readString();
      this.filePath = paramParcel.readString();
      this.busId = paramParcel.readInt();
      this.bWU = paramParcel.readInt();
      this.aWi = paramParcel.readString();
      this.md5 = paramParcel.readString();
      this.aWj = paramParcel.readString();
      this.send_uin = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label346;
      }
      bool1 = true;
      label242:
      this.bjg = bool1;
      this.imageBizType = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label351;
      }
      bool1 = true;
      label265:
      this.isSend = bool1;
      this.aWk = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label356;
      }
    }
    label331:
    label336:
    label341:
    label346:
    label351:
    label356:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bdq = bool1;
      this.TI = paramParcel.readString();
      this.content = paramParcel.readString();
      this.templateId = paramParcel.readString();
      this.templateName = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label102;
      bool1 = false;
      break label116;
      bool1 = false;
      break label155;
      bool1 = false;
      break label242;
      bool1 = false;
      break label265;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.aVW);
    paramParcel.writeString(this.aVX);
    paramParcel.writeString(this.aVY);
    paramParcel.writeString(this.aVZ);
    paramParcel.writeString(this.uuid);
    paramParcel.writeLong(this.timestamp);
    paramParcel.writeLong(this.groupFileID);
    paramParcel.writeLong(this.width);
    paramParcel.writeLong(this.height);
    if (this.bjc)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.bjd) {
        break label332;
      }
      paramInt = 1;
      label104:
      paramParcel.writeByte((byte)paramInt);
      if (!this.bje) {
        break label337;
      }
      paramInt = 1;
      label119:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.mImageType);
      paramParcel.writeInt(this.EP);
      paramParcel.writeValue(this.bQ);
      if (!this.bjf) {
        break label342;
      }
      paramInt = 1;
      label158:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.Jx);
      paramParcel.writeString(this.fileName);
      paramParcel.writeString(this.filePath);
      paramParcel.writeInt(this.busId);
      paramParcel.writeInt(this.bWU);
      paramParcel.writeString(this.aWi);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.aWj);
      paramParcel.writeString(this.send_uin);
      if (!this.bjg) {
        break label347;
      }
      paramInt = 1;
      label245:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.imageBizType);
      if (!this.isSend) {
        break label352;
      }
      paramInt = 1;
      label267:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.aWk);
      if (!this.bdq) {
        break label357;
      }
    }
    label332:
    label337:
    label342:
    label347:
    label352:
    label357:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.TI);
      paramParcel.writeString(this.content);
      paramParcel.writeString(this.templateId);
      paramParcel.writeString(this.templateName);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label104;
      paramInt = 0;
      break label119;
      paramInt = 0;
      break label158;
      paramInt = 0;
      break label245;
      paramInt = 0;
      break label267;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOPictureData
 * JD-Core Version:    0.7.0.1
 */