package com.tencent.mobileqq.filemanager.data;

import agnd;
import ahav;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.vfs.VFSFile;
import java.io.FileNotFoundException;

public class FileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FileInfo> CREATOR = new agnd();
  private String apkPackeageName;
  private byte[] cloudId;
  private byte[] dZ;
  private long date;
  private String description;
  private String groupName;
  private boolean igonFilename;
  private boolean isDirectory;
  private boolean litePath;
  private int mediaId;
  private String name;
  private String path;
  private long size;
  private int type;
  
  public FileInfo()
  {
    setPath("");
    setName("");
    setSize(0L);
    setDate(System.currentTimeMillis());
    setDescription("");
    setType(-1);
    setApkPackeageName("");
    setGroupName("");
  }
  
  private FileInfo(Parcel paramParcel)
  {
    setPath(paramParcel.readString());
    setName(paramParcel.readString());
    setSize(paramParcel.readLong());
    setDate(paramParcel.readLong());
    setDescription(paramParcel.readString());
    setType(paramParcel.readInt());
    setApkPackeageName(paramParcel.readString());
    setGroupName(paramParcel.readString());
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      setDirectory(bool);
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.cloudId = new byte[i];
        paramParcel.readByteArray(this.cloudId);
      }
      i = paramParcel.readInt();
      if (i > 0)
      {
        this.dZ = new byte[i];
        paramParcel.readByteArray(this.dZ);
      }
      return;
    }
  }
  
  public FileInfo(String paramString)
    throws FileNotFoundException
  {
    if (paramString == null) {
      throw new FileNotFoundException("file path is null!");
    }
    paramString = new VFSFile(paramString);
    if (!paramString.exists()) {
      throw new FileNotFoundException("file not exist!");
    }
    setDirectory(paramString.isDirectory());
    setPath(paramString.getAbsolutePath());
    setName(paramString.getName());
    setSize(paramString.length());
    setDate(paramString.lastModified());
    setType(ahav.getFileType(this.name));
    setApkPackeageName("");
    setGroupName("");
  }
  
  public static FileInfo a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    VFSFile localVFSFile;
    do
    {
      return null;
      localVFSFile = new VFSFile(paramString);
    } while ((!localVFSFile.exists()) || (localVFSFile.length() == 0L));
    try
    {
      paramString = new FileInfo(paramString);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  private boolean f(FileInfo paramFileInfo)
  {
    return (getSize() == paramFileInfo.getSize()) && (getDate() == paramFileInfo.getDate()) && (getPath().equals(paramFileInfo.getPath()));
  }
  
  public byte[] X()
  {
    return this.dZ;
  }
  
  public byte[] Y()
  {
    return this.cloudId;
  }
  
  public void be(byte[] paramArrayOfByte)
  {
    this.dZ = paramArrayOfByte;
  }
  
  public void bf(byte[] paramArrayOfByte)
  {
    this.cloudId = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof FileInfo))) {
      return false;
    }
    return f((FileInfo)paramObject);
  }
  
  public String getApkPackeageName()
  {
    return this.apkPackeageName;
  }
  
  public long getDate()
  {
    return this.date;
  }
  
  public String getGroupName()
  {
    return this.groupName;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return (getName() + getSize() + getDate()).hashCode();
  }
  
  public boolean isDirectory()
  {
    return this.isDirectory;
  }
  
  public boolean isIgonFilename()
  {
    return this.igonFilename;
  }
  
  public boolean isLitePath()
  {
    return this.litePath;
  }
  
  public void setApkPackeageName(String paramString)
  {
    this.apkPackeageName = paramString;
  }
  
  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setDirectory(boolean paramBoolean)
  {
    this.isDirectory = paramBoolean;
  }
  
  public void setGroupName(String paramString)
  {
    this.groupName = paramString;
  }
  
  public void setIgonFilename()
  {
    this.igonFilename = true;
  }
  
  public void setLitePath(boolean paramBoolean)
  {
    this.litePath = paramBoolean;
  }
  
  public void setMediaId(int paramInt)
  {
    this.mediaId = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.name);
    paramParcel.writeLong(this.size);
    paramParcel.writeLong(this.date);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.apkPackeageName);
    paramParcel.writeString(this.groupName);
    if (isDirectory())
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (this.cloudId == null) {
        break label133;
      }
      paramParcel.writeInt(this.cloudId.length);
      paramParcel.writeByteArray(this.cloudId);
    }
    for (;;)
    {
      if (this.dZ == null) {
        break label141;
      }
      paramParcel.writeInt(this.dZ.length);
      paramParcel.writeByteArray(this.dZ);
      return;
      paramInt = 0;
      break;
      label133:
      paramParcel.writeInt(0);
    }
    label141:
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileInfo
 * JD-Core Version:    0.7.0.1
 */