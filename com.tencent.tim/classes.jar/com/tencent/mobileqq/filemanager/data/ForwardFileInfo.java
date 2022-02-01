package com.tencent.mobileqq.filemanager.data;

import agkf;
import agng;
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import attf;
import atyn;
import atzf;
import atzy;
import auaj;
import audx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ForwardFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ForwardFileInfo> CREATOR = new agng();
  private String bIy;
  private WeiYunFileInfo c;
  private int cYd;
  private int cYe;
  private byte[] cloudId;
  private String fileId;
  private String fileName;
  private long fileSize;
  private int fileType = -1;
  public int forwardID;
  private int forwardTroopFileEntrance;
  private long friendUin;
  private String localPath;
  private byte[] pDirKey;
  private long sessionId;
  private String thumbPath;
  private int type;
  private long uniseq;
  private String uuid;
  private ArrayList<Long> wI;
  
  public ForwardFileInfo()
  {
    setLocalPath("");
    setUuid("");
    setFileName("");
    p(-1L);
    setFileId("");
    setType(this.type);
    Ja("");
  }
  
  public ForwardFileInfo(Parcel paramParcel)
  {
    setType(paramParcel.readInt());
    p(paramParcel.readLong());
    setFileSize(paramParcel.readLong());
    setLocalPath(paramParcel.readString());
    setUuid(paramParcel.readString());
    setFileId(paramParcel.readString());
    Oi(paramParcel.readInt());
    setFileName(paramParcel.readString());
    jA(paramParcel.readLong());
    Oj(paramParcel.readInt());
    jB(paramParcel.readLong());
    Ja(paramParcel.readString());
    aA(paramParcel.readString());
    Oh(paramParcel.readInt());
    e((WeiYunFileInfo)paramParcel.readParcelable(WeiYunFileInfo.class.getClassLoader()));
    eo(paramParcel.readArrayList(Long.class.getClassLoader()));
    int i = paramParcel.readInt();
    if (i > 0)
    {
      bg(new byte[i]);
      paramParcel.readByteArray(Z());
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      bf(new byte[i]);
      paramParcel.readByteArray(Y());
    }
  }
  
  private boolean a(ForwardFileInfo paramForwardFileInfo)
  {
    return (getFileName().equals(paramForwardFileInfo.getFileName())) && (getFileSize() == paramForwardFileInfo.getFileSize()) && (getType() == paramForwardFileInfo.getType());
  }
  
  public int Et()
  {
    return this.forwardTroopFileEntrance;
  }
  
  public int Eu()
  {
    return this.cYe;
  }
  
  public int Ev()
  {
    return this.cYd;
  }
  
  public void Ja(String paramString)
  {
    this.bIy = paramString;
  }
  
  public void Oh(int paramInt)
  {
    this.forwardTroopFileEntrance = paramInt;
  }
  
  public void Oi(int paramInt)
  {
    this.cYe = paramInt;
  }
  
  public void Oj(int paramInt)
  {
    this.cYd = paramInt;
  }
  
  public byte[] Y()
  {
    return this.cloudId;
  }
  
  public byte[] Z()
  {
    return this.pDirKey;
  }
  
  public atzy a(Activity paramActivity)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity = localQQAppInterface.a().c(fR());
    if (localFileManagerEntity == null)
    {
      QLog.e("ForwardFileInfo", 1, "ForwardFileInfonot found, bug. sessionid:" + String.valueOf(this.sessionId));
      return null;
    }
    if (localFileManagerEntity.cloudType == 9)
    {
      localObject = localQQAppInterface.a().a(localFileManagerEntity.cloudId);
      if (localObject != null)
      {
        localFileManagerEntity.strFilePath = ((FileManagerEntity)localObject).strFilePath;
        localFileManagerEntity.setfProgress(((FileManagerEntity)localObject).getfProgress());
        localFileManagerEntity.status = ((FileManagerEntity)localObject).status;
      }
    }
    if ((5 != localFileManagerEntity.cloudType) && (9 != localFileManagerEntity.cloudType)) {
      audx.I(localFileManagerEntity);
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(atyn.a(localQQAppInterface, localFileManagerEntity));
    if (localFileManagerEntity.getCloudType() == 9) {
      return new auaj(paramActivity, (List)localObject, 0);
    }
    return new atzf(paramActivity, (List)localObject, 0);
  }
  
  public WeiYunFileInfo a()
  {
    return this.c;
  }
  
  public void aA(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public void bf(byte[] paramArrayOfByte)
  {
    this.cloudId = paramArrayOfByte;
  }
  
  public void bg(byte[] paramArrayOfByte)
  {
    this.pDirKey = paramArrayOfByte;
  }
  
  public ArrayList<Long> de()
  {
    if (this.wI == null) {
      this.wI = new ArrayList();
    }
    return this.wI;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.c = paramWeiYunFileInfo;
  }
  
  public void eo(ArrayList<Long> paramArrayList)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    this.wI = ((ArrayList)localObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof ForwardFileInfo))) {
      return false;
    }
    return a((ForwardFileInfo)paramObject);
  }
  
  public long fR()
  {
    return this.sessionId;
  }
  
  public long fS()
  {
    return this.uniseq;
  }
  
  public String getFileId()
  {
    return this.fileId;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public long getFriendUin()
  {
    return this.friendUin;
  }
  
  public String getLocalPath()
  {
    return this.localPath;
  }
  
  public String getThumbPath()
  {
    return this.thumbPath;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public int hashCode()
  {
    return (getFileName() + getFileSize()).hashCode();
  }
  
  public void jA(long paramLong)
  {
    this.friendUin = paramLong;
  }
  
  public void jB(long paramLong)
  {
    this.uniseq = paramLong;
  }
  
  public void p(long paramLong)
  {
    this.sessionId = paramLong;
  }
  
  public void setFileId(String paramString)
  {
    this.fileId = paramString;
  }
  
  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setFileType(int paramInt)
  {
    this.fileType = paramInt;
  }
  
  public void setLocalPath(String paramString)
  {
    this.localPath = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public String toString()
  {
    return "type[" + this.type + "], cloudTYpe[" + this.cYd + "], sessionId[" + this.sessionId + "], uniseq[" + this.uniseq + "], uuid[" + this.uuid + "], fileId[" + this.fileId + "], weiYunSrcType[" + this.cYe + "], uuidTroopFile[" + this.bIy;
  }
  
  public String vj()
  {
    return this.bIy;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(getType());
    paramParcel.writeLong(fR());
    paramParcel.writeLong(getFileSize());
    paramParcel.writeString(getLocalPath());
    paramParcel.writeString(getUuid());
    paramParcel.writeString(getFileId());
    paramParcel.writeInt(Eu());
    paramParcel.writeString(getFileName());
    paramParcel.writeLong(getFriendUin());
    paramParcel.writeInt(Ev());
    paramParcel.writeLong(fS());
    paramParcel.writeString(vj());
    paramParcel.writeString(getThumbPath());
    paramParcel.writeInt(Et());
    paramParcel.writeParcelable(a(), paramInt);
    paramParcel.writeList(this.wI);
    if ((Z() != null) && (Z().length != 0))
    {
      paramParcel.writeInt(Z().length);
      paramParcel.writeByteArray(Z());
    }
    while ((Y() != null) && (Y().length != 0))
    {
      paramParcel.writeInt(Y().length);
      paramParcel.writeByteArray(Y());
      return;
      paramParcel.writeInt(-1);
    }
    paramParcel.writeInt(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.ForwardFileInfo
 * JD-Core Version:    0.7.0.1
 */