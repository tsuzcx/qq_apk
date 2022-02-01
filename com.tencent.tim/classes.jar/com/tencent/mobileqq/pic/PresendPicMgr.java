package com.tencent.mobileqq.pic;

import akxc;
import akxe;
import akyj;
import akyl;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import aqhq;
import aqiw;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

public class PresendPicMgr
{
  private static PresendPicMgr jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  private final akxc jdField_a_of_type_Akxc;
  public a a;
  private boolean cve = true;
  public boolean cvf;
  private boolean cvg;
  private boolean cvh;
  private boolean cvi;
  private boolean cvj;
  Messenger j;
  private HandlerThread mHandlerThread;
  private ArrayList<b> yw;
  
  public PresendPicMgr(akxc paramakxc)
  {
    akxe.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, service = " + paramakxc);
    this.jdField_a_of_type_Akxc = paramakxc;
    this.yw = new ArrayList();
    this.mHandlerThread = new HandlerThread("presend_worker_thread");
    this.mHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr$a = new a(this.mHandlerThread.getLooper(), this);
    try
    {
      paramakxc = this.jdField_a_of_type_Akxc.a();
      if ((paramakxc != null) && (paramakxc.length >= 4))
      {
        this.cvg = paramakxc[0];
        this.cvh = paramakxc[1];
        this.cvi = paramakxc[2];
        this.cvj = paramakxc[3];
      }
      int[] arrayOfInt = this.jdField_a_of_type_Akxc.V();
      if ((arrayOfInt != null) && (arrayOfInt.length >= 9))
      {
        akyl.dqc = arrayOfInt[0];
        akyl.dqd = arrayOfInt[1];
        akyl.dqe = arrayOfInt[2];
        akyl.dqf = arrayOfInt[3];
        akyl.dqg = arrayOfInt[4];
        akyl.dqh = arrayOfInt[5];
        akyl.dpY = arrayOfInt[6];
        akyl.dpZ = arrayOfInt[7];
        akyl.dqa = arrayOfInt[8];
      }
      akxe.a("PresendPicMgr", "getInstance", "preCompressConfig = " + Arrays.toString(paramakxc) + ",compressArgConfig = " + Arrays.toString(arrayOfInt));
      akxe.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, mEnablePreCompress_WIFI = " + this.cvg + ",mEnablePreCompress_2G = " + this.cvh + ",mEnablePreCompress_3G = " + this.cvi + ",mEnablePreCompress_4G = " + this.cvj + ",PicType.MaxLongSide_Camera_C2C = " + akyl.dqc + ",PicType.MaxLongSide_Camera_Grp = " + akyl.dqd + ",PicType.MaxLongSide_Screenshot_C2C = " + akyl.dqe + ",PicType.MaxLongSide_Screenshot_Grp = " + akyl.dqf + ",PicType.MaxLongSide_Other_C2C = " + akyl.dqg + ",PicType.MaxLongSide_Other_Grp = " + akyl.dqh + ",PicType.SendPhotoWiFiPicQuality = " + akyl.dpY + ",PicType.SendPhoto23GPicQuality = " + akyl.dpZ + ",PicType.SendPhoto4GPicQuality = " + akyl.dqa);
    }
    catch (RemoteException paramakxc)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, "getPreCompressConfig" + paramakxc.getMessage(), paramakxc);
          continue;
          this.cvf = this.cvg;
          continue;
          this.cvf = this.cvh;
          continue;
          this.cvf = this.cvi;
          continue;
          this.cvf = this.cvj;
        }
      }
    }
    i = aqiw.getSystemNetwork(BaseApplication.getContext());
    switch (i)
    {
    default: 
      this.cvf = true;
      akxe.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, NetType = " + i + ", mEnablePreCompress = " + this.cvf);
      return;
    }
  }
  
  private b a(String paramString)
  {
    akxe.a("PresendPicMgr", "findRequestByPath", "path = " + paramString);
    if (this.yw == null)
    {
      akxe.b("PresendPicMgr", "findRequestByPath", "mPresendReqList == null");
      return null;
    }
    if (this.yw.size() == 0)
    {
      akxe.b("PresendPicMgr", "findRequestByPath", "mPresendReqList.size() == 0");
      return null;
    }
    Iterator localIterator = this.yw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.b.srcPath.equals(paramString)) {
        return localb;
      }
    }
    return null;
  }
  
  public static PresendPicMgr a()
  {
    akxe.a("PresendPicMgr", "getInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  }
  
  public static PresendPicMgr a(akxc paramakxc)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) {}
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) && (paramakxc != null)) {
        jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramakxc);
      }
      akxe.a("PresendPicMgr", "getInstance", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramakxc);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  public static PresendPicMgr b(akxc paramakxc)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null)
    {
      akxe.a("PresendPicMgr", "newInstance()", "mInstance:" + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + "is not null,reset mInstance!");
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
    }
    if (paramakxc != null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramakxc);
      akxe.a("PresendPicMgr", "newInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramakxc);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  private void dDP()
  {
    akxe.a("PresendPicMgr", "sendMsg___ start!", "");
    try
    {
      this.jdField_a_of_type_Akxc.dDP();
      akxe.a("PresendPicMgr", "sendMsg___ end!", "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgr", 2, localException.getMessage(), localException);
        }
      }
    }
  }
  
  public int Hj()
  {
    if (this.yw == null) {
      return 0;
    }
    return this.yw.size();
  }
  
  public void IP(int paramInt)
  {
    if (!this.cvf)
    {
      akxe.a("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
      return;
    }
    akxe.a("PresendPicMgr", "cancelAll", "Start! cancelType = " + paramInt);
    int i = 0;
    while (i < this.yw.size())
    {
      ((b)this.yw.get(i)).cancel(paramInt);
      i += 1;
    }
    this.yw.clear();
    try
    {
      this.jdField_a_of_type_Akxc.IP(paramInt);
      akxe.a("PresendPicMgr", "cancelAll", "End!");
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
        }
      }
    }
  }
  
  public void ay(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.cvf)
    {
      akxe.a("PresendPicMgr", "presendPic", "mEnablePreCompress is false!");
      return;
    }
    akxe.a("PresendPicMgr", "presendPic", "path = " + paramString + ",busiType = " + paramInt1);
    if ((TextUtils.isEmpty(paramString)) || (!aqhq.fileExistsAndNotEmpty(paramString)))
    {
      akxe.b("PresendPicMgr", "presendPic", "path = " + paramString + " pic not exist,return!");
      return;
    }
    paramString = new CompressInfo(paramString, akyj.iA(0), 1052);
    int k = -1;
    try
    {
      i = this.jdField_a_of_type_Akxc.lk();
      paramString.uinType = i;
      paramString.cuS = true;
      akxe.a("PresendPicMgr", "presendPic", "uinType = " + i);
      paramString = new b(paramString, paramInt1, paramInt2);
      this.yw.add(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr$a.post(new PresendRunnable(paramString));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        int i = k;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
          i = k;
        }
      }
    }
  }
  
  public void cE(String paramString, int paramInt)
  {
    ay(paramString, paramInt, 0);
  }
  
  public void dD(Intent paramIntent)
  {
    akxe.a("PresendPicMgr", "getCompossedIntent", "");
    if (!this.cvf)
    {
      akxe.a("PresendPicMgr", "getCompossedIntent", "Presend is OFF!");
      return;
    }
    paramIntent.putExtra("presend_handler", new BinderWarpper(new Messenger(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr$a).getBinder()));
  }
  
  public void dDZ()
  {
    akxe.a("PresendPicMgr", "disablePicPresend", "");
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
      ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", true).commit();
      ((SharedPreferences)localObject).edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
      return;
    }
  }
  
  public void fx(String paramString, int paramInt)
  {
    if (!this.cvf)
    {
      akxe.a("PresendPicMgr", "cancelPresendPic", "mEnablePreCompress is false!");
      return;
    }
    akxe.a("PresendPicMgr", "cancelPresendPic", "path = " + paramString);
    b localb = a(paramString);
    if (localb == null)
    {
      akxe.a("PresendPicMgr", "cancelPresendPic", "cannot find PresendReq,path = " + paramString);
      return;
    }
    this.yw.remove(localb);
    localb.cancel(paramInt);
  }
  
  public void release()
  {
    akxe.b("PresendPicMgr", "release", "");
    this.mHandlerThread.quit();
    this.yw.clear();
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
  }
  
  class PresendRunnable
    implements Runnable
  {
    private PresendPicMgr.b a;
    
    public PresendRunnable(PresendPicMgr.b paramb)
    {
      this.a = paramb;
    }
    
    public void run()
    {
      akxe.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
      this.a.dEa();
    }
  }
  
  public static class a
    extends Handler
  {
    private final WeakReference<PresendPicMgr> hx;
    
    public a(Looper paramLooper, PresendPicMgr paramPresendPicMgr)
    {
      super();
      this.hx = new WeakReference(paramPresendPicMgr);
    }
    
    public void handleMessage(Message paramMessage)
    {
      PresendPicMgr localPresendPicMgr = (PresendPicMgr)this.hx.get();
      if (localPresendPicMgr != null)
      {
        switch (paramMessage.what)
        {
        default: 
          super.handleMessage(paramMessage);
          return;
        case 1: 
          akxe.a("PresendPicMgr", "PresendHandler", "handleMessage MSG_REGISTER_CLIENT_HANDLER");
          localPresendPicMgr.j = paramMessage.replyTo;
          paramMessage = Message.obtain(null, 2);
          ArrayList localArrayList = new ArrayList();
          Object localObject = PresendPicMgr.a(localPresendPicMgr).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(((PresendPicMgr.b)((Iterator)localObject).next()).b);
          }
          localObject = new Bundle();
          ((Bundle)localObject).putParcelableArrayList("flag_compressinfolist", localArrayList);
          paramMessage.setData((Bundle)localObject);
          try
          {
            localPresendPicMgr.j.send(paramMessage);
            localPresendPicMgr.j = null;
            PresendPicMgr.a(localPresendPicMgr);
            localPresendPicMgr.release();
            return;
          }
          catch (RemoteException paramMessage)
          {
            for (;;)
            {
              localPresendPicMgr.j = null;
              if (QLog.isColorLevel()) {
                QLog.e("PresendPicMgr", 2, paramMessage.getMessage(), paramMessage);
              }
              paramMessage.printStackTrace();
            }
          }
        }
        akxe.a("PresendPicMgr", "PresendHandler", "handleMessage MSG_UNREGISTER_CLIENT_HANDLER");
        localPresendPicMgr.j = null;
        return;
      }
      akxe.b("PresendPicMgr", "handleMessage", "PresendPicMgr == null!");
    }
  }
  
  class b
  {
    public CompressInfo b;
    public int busiType = -1;
    public int entrance;
    public String localUUID = xP();
    public boolean mIsCancel;
    public boolean mIsUpload;
    
    public b(CompressInfo paramCompressInfo, int paramInt1, int paramInt2)
    {
      this.b = paramCompressInfo;
      this.b.localUUID = this.localUUID;
      this.busiType = paramInt1;
      this.entrance = paramInt2;
    }
    
    public void cancel(int paramInt)
    {
      for (;;)
      {
        try
        {
          akxe.a("PresendPicMgr", "PresendReq.cancel", "current PresendReq is " + this);
          this.mIsCancel = true;
          boolean bool = this.mIsUpload;
          if (bool) {
            try
            {
              akxe.a("PresendPicMgr", "PresendReq.cancel", "call cancelUpload");
              PresendPicMgr.a(PresendPicMgr.this).fw(this.localUUID, paramInt);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
              continue;
            }
          }
          akxe.a("PresendPicMgr", "PresendReq.cancel", "mIsUpload is false,no need to call cancelUpload");
        }
        finally {}
      }
    }
    
    public void dEa()
    {
      akxe.a("PresendPicMgr", "PresendReq.compressAndUploadPic", "call start,current PresendReq is " + this);
      long l = System.nanoTime();
      if (this.mIsCancel)
      {
        akxe.a("PresendPicMgr", "compressAndUploadPic ", "PresendStatus: srcPah:" + this.b.srcPath + ",destPath:" + this.b.destPath + ",uuid:" + this.localUUID + " ,canceled:true, peakCompress:false, peakUpload:false");
        return;
      }
      akyj.b(this.b);
      akxe.a("PresendPicMgr", "compressAndUploadPic ", "PresendStatus: srcPah:" + this.b.srcPath + ",destPath:" + this.b.destPath + ",uuid:" + this.localUUID + ",canceled:false,peakCompress:true,peakUpload:false");
      l = (System.nanoTime() - l) / 1000000L;
      akxe.a("PresendPicMgr", "PresendReq.compressAndUploadPic", "Process peak,[#]compress, cost= " + l);
      dEb();
      akxe.a("PresendPicMgr", "PresendReq.compressAndUploadPic", "call end,current PresendReq is " + this);
    }
    
    public void dEb()
    {
      try
      {
        akxe.a("PresendPicMgr", "PresendReq.uploadPic", "current PresendReq is " + this);
        if (this.mIsCancel) {
          akxe.a("PresendPicMgr", "uploadPic ", "PresendStatus: srcPah:" + this.b.srcPath + ",destPath:" + this.b.destPath + ",uuid:" + this.localUUID + " ,canceled:true, peakCompress:true, peakUpload:false");
        }
        for (;;)
        {
          return;
          if (this.b.destPath == null)
          {
            akxe.b("PresendPicMgr", "PresendReq.uploadPic", "mCompressInfo.destPath == null! ");
            continue;
          }
          try
          {
            PresendPicMgr.a(PresendPicMgr.this).b(this.b.destPath, this.localUUID, this.b.cuQ, this.busiType, this.entrance);
            this.mIsUpload = true;
            akxe.a("PresendPicMgr", "uploadPic ", "PresendStatus: srcPah:" + this.b.srcPath + ",destPath:" + this.b.destPath + ",uuid:" + this.localUUID + " ,canceled:false, peakCompress:true, peakUpload:true");
            akxe.a("PresendPicMgr", "PresendReq.uploadPic", "call end");
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
              }
            }
          }
        }
      }
      finally {}
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\nPresendReq");
      localStringBuilder.append("\n|-").append("localUUID:").append(this.localUUID);
      localStringBuilder.append("\n|-").append("mIsCancel:").append(this.mIsCancel);
      localStringBuilder.append("\n|-").append("mIsUpload:").append(this.mIsUpload);
      localStringBuilder.append("\n|-").append("mCompressInfo:").append(this.b);
      return localStringBuilder.toString();
    }
    
    public String xP()
    {
      return "__" + UUID.randomUUID().toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr
 * JD-Core Version:    0.7.0.1
 */