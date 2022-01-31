package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dcx;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class QQPhotoInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new dcx();
  public static final int PHOTO_LAST_SELECTED = 3;
  public static final int PHOTO_SELECTED = 1;
  public static final int PHOTO_UNSELECTED = 2;
  private static List photoInfoCache = new ArrayList();
  private long id;
  private long mModifiedDate;
  private String mPath;
  private long mSize;
  private int orientation;
  private int selectStatus;
  
  public QQPhotoInfo(long paramLong, String paramString)
  {
    this.id = paramLong;
    this.mPath = paramString;
    this.selectStatus = 2;
  }
  
  private QQPhotoInfo(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.mPath = paramParcel.readString();
    this.selectStatus = paramParcel.readInt();
  }
  
  private boolean compare(QQPhotoInfo paramQQPhotoInfo)
  {
    return this.mPath.equals(paramQQPhotoInfo.mPath);
  }
  
  public static QQPhotoInfo create(long paramLong, String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return null;
    }
    Object localObject1 = new File(paramString);
    if ((!((File)localObject1).exists()) || (((File)localObject1).isDirectory())) {
      return null;
    }
    for (;;)
    {
      synchronized (photoInfoCache)
      {
        int i = photoInfoCache.size();
        if (i > 0)
        {
          localObject1 = (WeakReference)photoInfoCache.remove(i - 1);
          if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
          {
            localObject1 = (QQPhotoInfo)((WeakReference)localObject1).get();
            ((QQPhotoInfo)localObject1).id = paramLong;
            ((QQPhotoInfo)localObject1).mPath = paramString;
            Object localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new QQPhotoInfo(paramLong, paramString);
            }
            return localObject2;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public static void recycle(QQPhotoInfo paramQQPhotoInfo)
  {
    if (paramQQPhotoInfo == null) {
      return;
    }
    synchronized (photoInfoCache)
    {
      paramQQPhotoInfo = new WeakReference(paramQQPhotoInfo);
      photoInfoCache.add(paramQQPhotoInfo);
      return;
    }
  }
  
  public static void recycle(List paramList)
  {
    List localList = photoInfoCache;
    if (paramList != null) {}
    try
    {
      if (paramList.size() == 0) {
        return;
      }
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        WeakReference localWeakReference = new WeakReference((QQPhotoInfo)paramList.get(i));
        photoInfoCache.add(localWeakReference);
        i += 1;
      }
      return;
    }
    finally {}
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
    if ((paramObject == null) || (!(paramObject instanceof QQPhotoInfo))) {
      return false;
    }
    return compare((QQPhotoInfo)paramObject);
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public int getSelectStatus()
  {
    return this.selectStatus;
  }
  
  public int hashCode()
  {
    return this.mPath.hashCode();
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setSelectStatus(int paramInt)
  {
    this.selectStatus = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.mPath);
    paramParcel.writeInt(this.selectStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQPhotoInfo
 * JD-Core Version:    0.7.0.1
 */