package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class AIOImageData
  extends AIORichMediaData
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
  public String mTemplateId;
  public String mTemplateName;
  public String md5;
  public String send_uin;
  public long timestamp;
  public String uuid = "I:N";
  public long width;
  
  public int bM(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      if (paramString.contains(this.aVW)) {
        return 1;
      }
      if (paramString.contains(this.aVX)) {
        return 2;
      }
    } while (!paramString.contains(this.aVY));
    return 4;
  }
  
  public File c(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
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
      continue;
      localObject = this.aVZ;
    }
    return null;
  }
  
  public String cH(int paramInt)
  {
    Object localObject3 = null;
    Object localObject1;
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (!((String)localObject1).equals("I:N"))
        {
          if (this.EP != 3) {
            break;
          }
          localObject1 = new File((String)localObject1);
        }
      }
      try
      {
        localObject2 = ((File)localObject1).toURI().toURL().toString();
        return localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        return null;
      }
      localObject1 = this.aVW;
      continue;
      localObject1 = this.aVX;
      continue;
      localObject1 = this.aVY;
      continue;
      localObject1 = this.aVZ;
    }
    if (!localMalformedURLException.startsWith("/")) {
      return "file:/" + localMalformedURLException;
    }
    if (localMalformedURLException.startsWith("//")) {
      return "file:" + localMalformedURLException;
    }
    return "file:" + localMalformedURLException;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean gF(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    case 3: 
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
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
        bool1 = bool2;
      } while (this.EP == 3);
      bool1 = bool2;
    } while (!this.aVY.equals("I:N"));
    return false;
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
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    for (;;)
    {
      this.bjc = bool1;
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        label102:
        this.bjd = bool1;
        if (paramParcel.readByte() == 0) {
          break label336;
        }
        bool1 = true;
        this.bje = bool1;
        this.mImageType = paramParcel.readInt();
        this.EP = paramParcel.readInt();
      }
      try
      {
        this.bQ = paramParcel.readValue(null);
        if (paramParcel.readByte() != 0)
        {
          bool1 = true;
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
            break label372;
          }
          bool1 = true;
          this.bjg = bool1;
          this.imageBizType = paramParcel.readInt();
          if (paramParcel.readInt() != 1) {
            break label377;
          }
          bool1 = true;
          this.isSend = bool1;
          this.aWk = paramParcel.readString();
          if (paramParcel.readInt() != 1) {
            break label382;
          }
          bool1 = bool2;
          this.bdq = bool1;
          this.TI = paramParcel.readString();
          this.content = paramParcel.readString();
          this.mTemplateId = paramParcel.readString();
          this.mTemplateName = paramParcel.readString();
          return;
          bool1 = false;
          continue;
          bool1 = false;
          break label102;
          label336:
          bool1 = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AIOImageData", 2, "readValue exception");
          }
          this.bQ = new byte[0];
          continue;
          bool1 = false;
          continue;
          label372:
          bool1 = false;
          continue;
          label377:
          bool1 = false;
          continue;
          label382:
          bool1 = false;
        }
      }
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
      paramParcel.writeString(this.mTemplateId);
      paramParcel.writeString(this.mTemplateName);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageData
 * JD-Core Version:    0.7.0.1
 */