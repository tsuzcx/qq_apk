package com.tencent.mobileqq.activity.aio.photo;

import agkf;
import android.os.Parcel;
import apcy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.io.File;

public class AIOFilePicData
  extends AIORichMediaData
{
  public long Jr;
  public String aVW = "I:N";
  public String aVX = "I:N";
  public String aVY = "I:N";
  public String aVZ = "I:N";
  public String aWa;
  public int bWF;
  public boolean bim;
  public boolean bin;
  public boolean bio;
  public boolean bip;
  public boolean biq;
  public boolean bir;
  public FileManagerEntity c;
  public String curUin;
  public int issend;
  public String mFileName;
  public long mFileSize;
  public String mMd5;
  public int peerType;
  public int picHeight;
  public int picWidth;
  public String strUin;
  
  public void a(apcy paramapcy)
  {
    if (paramapcy == null) {
      return;
    }
    String str;
    if (paramapcy.coc != null)
    {
      str = paramapcy.coc;
      this.aVW = str;
      if (paramapcy.ThumbnailFile_Large == null) {
        break label108;
      }
      str = paramapcy.ThumbnailFile_Large;
      label34:
      this.aVX = str;
      if (paramapcy.LocalFile == null) {
        break label114;
      }
      str = paramapcy.LocalFile;
      label51:
      this.aVY = str;
      this.mFileName = paramapcy.FileName;
      if (paramapcy.Status != 12) {
        break label120;
      }
    }
    label108:
    label114:
    label120:
    for (boolean bool = true;; bool = false)
    {
      this.bip = bool;
      this.mFileSize = paramapcy.ProgressTotal;
      this.size = paramapcy.ProgressTotal;
      this.biq = false;
      return;
      str = "I:N";
      break;
      str = "I:N";
      break label34;
      str = "I:N";
      break label51;
    }
  }
  
  public void aZ(QQAppInterface paramQQAppInterface)
  {
    if (this.c == null) {
      this.c = paramQQAppInterface.a().a(this.id, this.strUin, this.peerType);
    }
    if (this.c != null)
    {
      if (this.c.strMiddleThumPath == null) {
        break label181;
      }
      paramQQAppInterface = this.c.strMiddleThumPath;
      this.aVW = paramQQAppInterface;
      if (this.c.strLargeThumPath == null) {
        break label187;
      }
      paramQQAppInterface = this.c.strLargeThumPath;
      label78:
      this.aVX = paramQQAppInterface;
      if (this.c.getFilePath() == null) {
        break label193;
      }
      paramQQAppInterface = this.c.getFilePath();
      label101:
      this.aVY = paramQQAppInterface;
      this.mFileName = this.c.fileName;
      if (this.c.status != 16) {
        break label199;
      }
    }
    label181:
    label187:
    label193:
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.bip = bool;
      this.mFileSize = this.c.fileSize;
      this.size = this.c.fileSize;
      this.Jr = this.c.lastSuccessTime;
      this.biq = this.c.sendCloudUnsuccessful();
      return;
      paramQQAppInterface = "I:N";
      break;
      paramQQAppInterface = "I:N";
      break label78;
      paramQQAppInterface = "I:N";
      break label101;
    }
  }
  
  public int bM(String paramString)
  {
    return 0;
  }
  
  public File c(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      localObject = null;
    }
    while ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      return localObject;
      localObject = this.aVW;
      continue;
      localObject = this.aVX;
      continue;
      localObject = this.aVY;
    }
    return null;
  }
  
  public String cH(int paramInt)
  {
    Object localObject2 = null;
    String str;
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      str = null;
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!str.equals("I:N"))
        {
          if (str.startsWith("/")) {
            break;
          }
          localObject1 = "file:/" + str;
        }
      }
      return localObject1;
      str = this.aVW;
      continue;
      str = this.aVX;
      continue;
      str = this.aVY;
    }
    if (str.startsWith("//")) {
      return "file:" + str;
    }
    return "file:" + str;
  }
  
  public boolean gF(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.aVW.equals("I:N"));
      return false;
      bool1 = bool2;
    } while (!this.aVX.equals("I:N"));
    return false;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool = true;
    super.readFromParcel(paramParcel);
    this.strUin = paramParcel.readString();
    this.peerType = paramParcel.readInt();
    this.aVW = paramParcel.readString();
    this.aVX = paramParcel.readString();
    this.aVY = paramParcel.readString();
    this.aVZ = paramParcel.readString();
    this.curUin = paramParcel.readString();
    this.issend = paramParcel.readInt();
    this.mFileName = paramParcel.readString();
    this.bip = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.mFileSize = Long.valueOf(paramParcel.readString()).longValue();
    this.Jr = Long.valueOf(paramParcel.readString()).longValue();
    this.biq = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.aWa = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.bir = bool;
      this.mMd5 = paramParcel.readString();
      this.picWidth = paramParcel.readInt();
      this.picHeight = paramParcel.readInt();
      this.bWF = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.strUin);
    paramParcel.writeInt(this.peerType);
    paramParcel.writeString(this.aVW);
    paramParcel.writeString(this.aVX);
    paramParcel.writeString(this.aVY);
    paramParcel.writeString(this.aVZ);
    paramParcel.writeString(this.curUin);
    paramParcel.writeInt(this.issend);
    paramParcel.writeString(this.mFileName);
    paramParcel.writeString(String.valueOf(this.bip));
    paramParcel.writeString(String.valueOf(this.mFileSize));
    paramParcel.writeString(String.valueOf(this.Jr));
    paramParcel.writeString(String.valueOf(this.biq));
    paramParcel.writeString(this.aWa);
    if (this.bir) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.mMd5);
      paramParcel.writeInt(this.picWidth);
      paramParcel.writeInt(this.picHeight);
      paramParcel.writeInt(this.bWF);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
 * JD-Core Version:    0.7.0.1
 */