package com.tencent.mobileqq.activity.aio.photo;

import ahal;
import ahav;
import ahbj;
import ahbr;
import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import java.io.File;
import java.util.ArrayList;
import xsb;
import xsc;
import ztk;
import ztn;

public class AIOFileVideoData
  extends AIORichMediaData
{
  public long Js;
  public String aWb;
  public String bN;
  public boolean bis;
  public boolean bit;
  public boolean biu;
  public boolean biv;
  private boolean biw;
  public String cookie;
  public String downloadUrl;
  public String fileName;
  public String fileUuid;
  public int height;
  public boolean isCancel;
  public int isSend;
  public String mFilePath;
  public String md5;
  public int peerType;
  public long progress;
  public long retCode;
  public String retMsg;
  private String strErr;
  public String strUin;
  public int width;
  
  public AIOFileVideoData() {}
  
  public AIOFileVideoData(String paramString)
  {
    this.bN = paramString;
  }
  
  private boolean SG()
  {
    if (this.biv) {}
    do
    {
      do
      {
        return false;
      } while (!ahav.amK());
      if ((!TextUtils.isEmpty(this.fileName)) && (this.size > 0L) && (this.size > this.Js)) {
        return true;
      }
    } while (this.size <= 1048576L);
    return true;
  }
  
  private void a(Context paramContext, ztk paramztk)
  {
    paramztk = new xsb(this, paramContext, paramztk);
    ahal.a(paramContext, paramContext.getString(2131693826), paramContext.getString(2131693828), paramztk);
  }
  
  public boolean SF()
  {
    if (!TextUtils.isEmpty(this.mFilePath)) {
      return true;
    }
    if (this.bit)
    {
      this.mFilePath = this.aWb;
      return true;
    }
    return false;
  }
  
  public ztn a(boolean paramBoolean)
  {
    boolean bool = false;
    ztn localztn = new ztn();
    localztn.cJ = new String[] { this.downloadUrl };
    localztn.mCookies = new ArrayList();
    localztn.mCookies.add(this.cookie);
    if (!SF()) {
      bool = true;
    }
    localztn.btf = bool;
    if (localztn.btf) {}
    for (String str = this.aWb;; str = this.mFilePath)
    {
      localztn.playUrl = str;
      localztn.progress = this.progress;
      localztn.btg = true;
      localztn.fileSize = this.size;
      localztn.id = this.id;
      localztn.subid = this.subId;
      localztn.isMute = paramBoolean;
      return localztn;
    }
  }
  
  public void a(View paramView, ztk paramztk)
  {
    if (SG())
    {
      if (ahbr.a(paramView.getContext(), false, new xsc(this, paramztk, paramView))) {
        a(paramView.getContext(), paramztk);
      }
      return;
    }
    if (this.biw)
    {
      this.biw = false;
      paramztk.a(paramView, a(false));
    }
    paramztk.crM();
    paramztk.aNX();
  }
  
  public File c(int paramInt)
  {
    if (!ahbj.fileExistsAndNotEmpty(this.bN)) {
      return null;
    }
    return new File(this.bN);
  }
  
  public String cH(int paramInt)
  {
    if (TextUtils.isEmpty(this.bN)) {
      return "";
    }
    if (!this.bN.startsWith("/")) {
      return "file:/" + this.bN;
    }
    if (this.bN.startsWith("//")) {
      return "file:" + this.bN;
    }
    return "file:" + this.bN;
  }
  
  public boolean gF(int paramInt)
  {
    return ahbj.fileExistsAndNotEmpty(this.bN);
  }
  
  public boolean hasError()
  {
    return !TextUtils.isEmpty(this.strErr);
  }
  
  public String pw()
  {
    return this.strErr;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool = true;
    super.readFromParcel(paramParcel);
    this.bN = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.mFilePath = paramParcel.readString();
    this.Js = paramParcel.readLong();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.bit = bool;
      this.strUin = paramParcel.readString();
      this.peerType = paramParcel.readInt();
      this.isSend = paramParcel.readInt();
      this.fileUuid = paramParcel.readString();
      this.md5 = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.bN);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.mFilePath);
    paramParcel.writeLong(this.Js);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    if (this.bit) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.strUin);
      paramParcel.writeInt(this.peerType);
      paramParcel.writeInt(this.isSend);
      paramParcel.writeString(this.fileUuid);
      paramParcel.writeString(this.md5);
      return;
    }
  }
  
  public void ya(String paramString)
  {
    this.strErr = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */