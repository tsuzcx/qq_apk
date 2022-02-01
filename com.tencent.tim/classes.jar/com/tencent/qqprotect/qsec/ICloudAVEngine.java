package com.tencent.qqprotect.qsec;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import aszp;
import aszr;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public abstract interface ICloudAVEngine
{
  public static final int EVENT_GET_MD5_FAILED = 4;
  public static final int EVENT_QUEUE_FULL = 1;
  public static final int EVENT_SERVER_REPLY = 3;
  public static final int EVENT_WAIT_TIMEOUT = 2;
  
  public abstract int cloudDetect(b paramb, boolean paramBoolean1, boolean paramBoolean2, c paramc);
  
  public abstract void flushRequest();
  
  public static class a
    extends ICloudAVEngine.b
  {
    public a(String paramString)
    {
      this.mFileType = 1;
      this.eoh = 1;
      this.cGc = paramString;
    }
    
    public String getKey()
    {
      if (TextUtils.isEmpty(this.cGc)) {
        return null;
      }
      try
      {
        Object localObject = BaseApplication.getContext().getPackageManager().getPackageInfo(this.cGc, 192);
        if (localObject != null)
        {
          if ((((PackageInfo)localObject).signatures != null) && (((PackageInfo)localObject).signatures.length > 0)) {
            this.cGe = SecUtil.getSignatureHash(localObject.signatures[0].toByteArray());
          }
          if (((PackageInfo)localObject).applicationInfo != null)
          {
            this.mFileName = ((PackageInfo)localObject).applicationInfo.sourceDir;
            this.aCy = ((int)new File(this.mFileName).length());
            this.cGd = ((PackageInfo)localObject).applicationInfo.loadLabel(BaseApplication.getContext().getPackageManager()).toString();
            localObject = new byte[16];
            aszp.a(this.mFileName, "META-INF/MANIFEST.MF", (byte[])localObject);
            this.mFileMd5 = SecUtil.toHexString((byte[])localObject);
          }
        }
        localObject = this.mFileMd5;
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
    }
  }
  
  public static class b
  {
    public int aCy;
    public byte[] br;
    public String cGc;
    public String cGd;
    public String cGe;
    public int eoh;
    public String mFileMd5;
    public String mFileName;
    public int mFileType;
    
    public String getKey()
    {
      if (!TextUtils.isEmpty(this.mFileMd5)) {
        return this.mFileMd5;
      }
      if (TextUtils.isEmpty(this.mFileName)) {
        return null;
      }
      return aszr.getFileMd5BigFile(this.mFileName);
    }
    
    public String toString()
    {
      return "[ft:" + this.mFileType + ",st:" + this.eoh + ",fs:" + this.aCy + ",fn:" + this.mFileName + ",fm:" + this.mFileMd5 + ",a1:" + this.cGc + ",a2:" + this.cGd + ",a3:" + this.cGe + "]";
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, ICloudAVEngine.b paramb, ICloudAVEngine.d paramd);
  }
  
  public static class d
  {
    public byte[] br;
    public boolean cpR;
    public int eoi;
    public int eoj;
    public int lN;
    public int mAction;
    public long mExpireTime;
    
    public String toString()
    {
      return "[type:" + this.eoi + ",cate:" + this.lN + ",subcate:" + this.eoj + ",expire:" + this.mExpireTime + ",act:" + this.mAction + ",iscache:" + this.cpR + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.ICloudAVEngine
 * JD-Core Version:    0.7.0.1
 */