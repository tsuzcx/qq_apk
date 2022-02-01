package com.tencent.biz.qqstory.playvideo.entrance;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class OpenPlayerBuilder
{
  private Data c;
  
  public OpenPlayerBuilder(Serializable paramSerializable, int paramInt)
  {
    this.c = new Data(paramInt);
    this.c.mInfo = paramSerializable;
  }
  
  public OpenPlayerBuilder a()
  {
    this.c.mUIStyle.bottomWidgetShowFlag = 2;
    return this;
  }
  
  public OpenPlayerBuilder a(String paramString)
  {
    this.c.mReportData.openSessionId = paramString;
    return this;
  }
  
  public OpenPlayerBuilder a(boolean paramBoolean)
  {
    this.c.mUIStyle.showVideoCoverList = paramBoolean;
    return this;
  }
  
  public Data b()
  {
    return this.c;
  }
  
  public OpenPlayerBuilder b()
  {
    this.c.mUIStyle.hideMoreIcon = true;
    return this;
  }
  
  public OpenPlayerBuilder b(boolean paramBoolean)
  {
    this.c.mUIStyle.showVideoNoInteresting = paramBoolean;
    return this;
  }
  
  public OpenPlayerBuilder c()
  {
    this.c.mUIStyle.bottomWidgetShowFlag = 3;
    return this;
  }
  
  public OpenPlayerBuilder d()
  {
    this.c.mUIStyle.hideVideoDetailInfo = true;
    return this;
  }
  
  public OpenPlayerBuilder e()
  {
    this.c.mUIStyle.hideBannerInfo = true;
    return this;
  }
  
  public static class Data
    implements Serializable
  {
    public transient Bundle mBundle = new Bundle();
    public Serializable mInfo;
    public OpenPlayerBuilder.ReportData mReportData = new OpenPlayerBuilder.ReportData();
    public OpenPlayerBuilder.UIStyle mUIStyle = new OpenPlayerBuilder.UIStyle();
    
    public Data(int paramInt)
    {
      this.mReportData.from = paramInt;
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      int i = paramObjectInputStream.readInt();
      byte[] arrayOfByte = new byte[i];
      paramObjectInputStream.readFully(arrayOfByte);
      paramObjectInputStream = Parcel.obtain();
      paramObjectInputStream.unmarshall(arrayOfByte, 0, i);
      paramObjectInputStream.setDataPosition(0);
      this.mBundle = ((Bundle)Bundle.CREATOR.createFromParcel(paramObjectInputStream));
      paramObjectInputStream.recycle();
    }
    
    /* Error */
    private void writeObject(java.io.ObjectOutputStream paramObjectOutputStream)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 95	java/io/ObjectOutputStream:defaultWriteObject	()V
      //   4: invokestatic 67	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_2
      //   8: aload_0
      //   9: getfield 37	com/tencent/biz/qqstory/playvideo/entrance/OpenPlayerBuilder$Data:mBundle	Landroid/os/Bundle;
      //   12: aload_2
      //   13: iconst_0
      //   14: invokevirtual 99	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   17: aload_2
      //   18: invokevirtual 103	android/os/Parcel:marshall	()[B
      //   21: astore_3
      //   22: aload_1
      //   23: aload_3
      //   24: arraylength
      //   25: invokevirtual 106	java/io/ObjectOutputStream:writeInt	(I)V
      //   28: aload_1
      //   29: aload_3
      //   30: invokevirtual 109	java/io/ObjectOutputStream:write	([B)V
      //   33: aload_2
      //   34: invokevirtual 87	android/os/Parcel:recycle	()V
      //   37: return
      //   38: astore_1
      //   39: aload_2
      //   40: invokevirtual 87	android/os/Parcel:recycle	()V
      //   43: return
      //   44: astore_1
      //   45: aload_2
      //   46: invokevirtual 87	android/os/Parcel:recycle	()V
      //   49: aload_1
      //   50: athrow
      //   51: astore_1
      //   52: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	53	0	this	Data
      //   0	53	1	paramObjectOutputStream	java.io.ObjectOutputStream
      //   7	39	2	localParcel	Parcel
      //   21	9	3	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   22	33	38	java/io/IOException
      //   22	33	44	finally
      //   0	4	51	java/io/IOException
    }
  }
  
  public static class ReportData
    implements Serializable
  {
    public long activityOnCreateTimeStamp;
    public int from;
    public boolean hasReportFirstVideoTime;
    public long initViewPagerDataTimeStamp;
    public long initViewPagerUiTimeStamp;
    public String openSessionId;
    public boolean playerFastStartup;
    public long startActivityTimeStamp;
  }
  
  public static class UIStyle
    implements Serializable
  {
    public int bottomWidgetShowFlag;
    public boolean hideBannerInfo;
    public boolean hideMoreIcon;
    public boolean hideVideoDetailInfo;
    public boolean mForDebug;
    public int mPlayerRepeatMode = 0;
    public boolean showVideoCoverList = true;
    public boolean showVideoNoInteresting;
    
    public String toString()
    {
      return "UIStyle{showVideoCoverList=" + this.showVideoCoverList + ", hideVideoDetailInfo=" + this.hideVideoDetailInfo + ", bottomWidgetShowFlag=" + this.bottomWidgetShowFlag + ", mPlayerRepeatMode=" + this.mPlayerRepeatMode + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder
 * JD-Core Version:    0.7.0.1
 */