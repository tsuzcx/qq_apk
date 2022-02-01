package com.tencent.mobileqq.activity.photo;

import acbn;
import akxe;
import akya;
import akyr;
import alte;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.widget.TextView;
import aooi;
import aqfx;
import aqhq;
import aszr;
import auqv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.BinderWarpper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import kbp;
import ocp;
import zsx;
import zsz;

public class SendPhotoActivity
  extends BaseActivity
{
  public static final String TAG = SendPhotoActivity.class.getName();
  long Lt = 0L;
  long Lu;
  public SendPhotoTask a;
  boolean bsZ = false;
  ProgressDialog d;
  MessageQueue.IdleHandler f = new zsx(this);
  Messenger h;
  public Handler mHandler = new a(this);
  TextView yw;
  
  private static void a(BaseActivity paramBaseActivity, ArrayList<String> paramArrayList)
  {
    if (paramBaseActivity == null) {}
    for (;;)
    {
      return;
      Object localObject1 = paramBaseActivity.getIntent();
      int j = ((Intent)localObject1).getIntExtra("uintype", 0);
      ArrayList localArrayList;
      int i;
      if (j == 1008)
      {
        localArrayList = new ArrayList();
        Object localObject2 = paramBaseActivity.getClass().getSimpleName();
        QLog.d((String)localObject2, 2, "[report]Send Picture count=" + paramArrayList.size());
        i = 0;
        while (i < paramArrayList.size())
        {
          localArrayList.add(aszr.getFileMd5BigFile((String)paramArrayList.get(i)));
          QLog.d((String)localObject2, 2, "[report] picture " + i + "md5=" + aszr.getFileMd5BigFile((String)paramArrayList.get(i)) + ": path=" + (String)paramArrayList.get(i));
          i += 1;
        }
        localObject2 = new Intent("com.tencent.biz.pubaccount.picResultAction");
        ((Intent)localObject2).putExtra("com.tencent.biz.pubaccount.picResultData", paramArrayList.size());
        ((Intent)localObject2).putStringArrayListExtra("com.tencent.biz.pubaccount.picResult_md5s", localArrayList);
        paramBaseActivity.sendBroadcast((Intent)localObject2, "com.tencent.tim.msg.permission.pushnotify");
      }
      if (paramBaseActivity.app != null)
      {
        i = ((Intent)localObject1).getIntExtra("PhotoConst.SEND_SIZE_SPEC", -1);
        if (i != -1)
        {
          localArrayList = new ArrayList(Arrays.asList(new String[paramArrayList.size()]));
          Collections.copy(localArrayList, paramArrayList);
          PhotoUtils.c(paramBaseActivity.app, i, localArrayList);
        }
      }
      localObject1 = ((Intent)localObject1).getStringExtra("uin");
      if ((localObject1 != null) && (j == 1008) && (ocp.m(paramBaseActivity.app, (String)localObject1)))
      {
        i = 0;
        while (i < paramArrayList.size())
        {
          kbp.a(paramBaseActivity.app, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005C9D", "0X8005C9D", 0, 0, "", "", "", "", false);
          i += 1;
        }
      }
    }
  }
  
  static void crA()
  {
    String str1 = acbn.SDCARD_PATH + "photo/" + ".nomedia";
    String str2 = acbn.SDCARD_PATH + "thumb/" + ".nomedia";
    String str3 = acbn.SDCARD_PATH + "thumb2/" + ".nomedia";
    aqhq.UD(str1);
    aqhq.UD(str2);
    aqhq.UD(str3);
  }
  
  void am(int paramInt)
  {
    try
    {
      if (this.d != null) {
        crB();
      }
      while (!this.d.isShowing())
      {
        this.d.show();
        return;
        this.d = new ReportProgressDialog(this, 2131756467);
        this.d.setCancelable(true);
        this.d.show();
        this.d.setContentView(2131559761);
        this.yw = ((TextView)this.d.findViewById(2131373180));
        this.yw.setText(paramInt);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      akxe.b("PIC_TAG_ERROR", "SendPhotoActivity.showProgressDialog", localThrowable.toString());
    }
  }
  
  void crB()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "TestPicSend finish compress,currentTime = " + System.currentTimeMillis());
    }
    if ((this.d != null) && (this.d.isShowing())) {
      this.d.cancel();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 102))
    {
      super.setResult(paramInt2, paramIntent);
      super.finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    super.doOnCreate(paramBundle);
    ThreadManager.executeOnFileThread(aqhq.hQ);
    Object localObject1 = getIntent();
    paramBundle = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (paramBundle == null)
    {
      akxe.b(TAG, "initPicUploadInfos", "paths is null");
      finish();
      return true;
    }
    auqv.ab(true, paramBundle);
    int i;
    if (((Intent)localObject1).getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false))
    {
      localObject2 = (SessionInfo)((Intent)localObject1).getParcelableExtra("session_info");
      i = ((Intent)localObject1).getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      if (localObject2 != null) {
        alte.a().a(this.app, (SessionInfo)localObject2, paramBundle, i);
      }
      setResult(-1, getIntent());
      finish();
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "TestPicSend start compress,currentTime = " + System.currentTimeMillis());
    }
    Object localObject2 = (BinderWarpper)((Intent)localObject1).getParcelableExtra("presend_handler");
    if (localObject2 != null)
    {
      this.h = new Messenger(((BinderWarpper)localObject2).binder);
      localObject2 = Message.obtain(null, 1);
      ((Message)localObject2).replyTo = new Messenger(this.mHandler);
      i = ((Intent)localObject1).getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        akya localakya = akya.a();
        if (localakya != null) {
          localakya.j(i, ((Intent)localObject1).getLongExtra("key_qzone_batch_id", 0L), ((Intent)localObject1).getStringExtra("key_qzone_album_id"));
        }
      }
    }
    try
    {
      this.h.send((Message)localObject2);
      i = paramBundle.size();
      if (i > 0)
      {
        localObject1 = this.mHandler.obtainMessage(2, "TimeOut");
        this.mHandler.sendMessageDelayed((Message)localObject1, i * 10000);
        akxe.b(TAG, "doOnCreate", "send delayed Message:MSG_CANCLE_PROGRESS, delayTime = " + i * 5000);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, localRemoteException.getMessage());
        }
        localRemoteException.printStackTrace();
      }
    }
    this.Lu = System.nanoTime();
    akxe.a(TAG, "initPicUploadInfos", "  totalCount:" + paramBundle.size());
    setCanLock(false);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Looper.myQueue().removeIdleHandler(this.f);
    getIntent().removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "doOnDestroy ," + this);
    }
    crB();
    isUnLockSuccess = true;
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "doOnResume 1,mSend = " + this.bsZ + "," + this);
    }
    if (!this.bsZ)
    {
      this.Lt = SystemClock.uptimeMillis();
      Looper.myQueue().addIdleHandler(this.f);
      this.bsZ = true;
      this.mHandler.sendEmptyMessageDelayed(3, 500L);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "doOnResume 2,mSend = " + this.bsZ + "," + this);
    }
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<SendPhotoActivity> mActivity;
    
    public a(SendPhotoActivity paramSendPhotoActivity)
    {
      this.mActivity = new WeakReference(paramSendPhotoActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      SendPhotoActivity localSendPhotoActivity = (SendPhotoActivity)this.mActivity.get();
      if (localSendPhotoActivity != null) {
        switch (paramMessage.what)
        {
        default: 
          super.handleMessage(paramMessage);
        }
      }
      label399:
      label555:
      do
      {
        return;
        localSendPhotoActivity.finish();
        return;
        localSendPhotoActivity.am(2131696921);
        return;
        if (localSendPhotoActivity.mHandler.hasMessages(2))
        {
          akxe.b(SendPhotoActivity.TAG, "handleMessage", "remove delayed Message:MSG_CANCLE_PROGRESS");
          localSendPhotoActivity.mHandler.removeMessages(2);
        }
        Object localObject2;
        Object localObject1;
        if ((localSendPhotoActivity.d != null) && (localSendPhotoActivity.d.isShowing()))
        {
          bool1 = true;
          localSendPhotoActivity.crB();
          localObject2 = localSendPhotoActivity.getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            localObject1 = new String[((ArrayList)localObject2).size()];
            ((ArrayList)localObject2).toArray((Object[])localObject1);
            i = localSendPhotoActivity.getIntent().getIntExtra("uintype", 1003);
            localObject2 = localSendPhotoActivity.app;
            if ((paramMessage.obj == null) || (!"TimeOut".equals(paramMessage.obj.toString()))) {
              break label399;
            }
          }
        }
        ArrayList localArrayList;
        for (boolean bool2 = true;; bool2 = false)
        {
          ThreadManager.post(new SendPhotoActivity.MyHandler.1(this, bool2, (String[])localObject1, i, (QQAppInterface)localObject2), 5, null, true);
          localObject2 = localSendPhotoActivity.getIntent();
          ((Intent)localObject2).putExtra(aqfx.REQUEST_CODE, 2);
          if (!((Intent)localObject2).hasExtra("extra_image_sender_tag")) {
            ((Intent)localObject2).putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
          }
          localObject1 = null;
          Object localObject3 = paramMessage.getData();
          localArrayList = new ArrayList();
          paramMessage = (Message)localObject1;
          if (localObject3 == null) {
            break label555;
          }
          ((Bundle)localObject3).setClassLoader(CompressInfo.class.getClassLoader());
          paramMessage = ((Bundle)localObject3).getParcelableArrayList("flag_compressinfolist");
          if (paramMessage == null) {
            break label555;
          }
          localObject1 = paramMessage.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (CompressInfo)((Iterator)localObject1).next();
            akxe.a(SendPhotoActivity.TAG, "handleMessage print CompressInfo", "info:" + localObject3);
            localArrayList.add(((CompressInfo)localObject3).destPath);
          }
          bool1 = false;
          break;
        }
        int i = paramMessage.size();
        long l1 = System.nanoTime();
        long l2 = (l1 - localSendPhotoActivity.Lu) / 1000000L;
        akxe.a(SendPhotoActivity.TAG, "CompressLog", "compress startTime = " + localSendPhotoActivity.Lu + "ns,finishTime = " + l1 + "ns,duration = " + l2 + "ms,count = " + i + ",isShowing = " + bool1);
        zsz.e(l2, i, bool1);
        localSendPhotoActivity.app.a().cL(l1);
        akxe.a(SendPhotoActivity.TAG, "TimeCompare", "CompressFinish Time = " + l1 + "ns");
        ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
        SendPhotoActivity.b(localSendPhotoActivity, localArrayList);
        ((Intent)localObject2).removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
        localSendPhotoActivity.setResult(-1, localSendPhotoActivity.getIntent());
        localSendPhotoActivity.finish();
        boolean bool1 = localSendPhotoActivity.getIntent().getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "sendPhotoActivity isWaitForResult=" + bool1);
        }
        if (!bool1)
        {
          localObject1 = localSendPhotoActivity.getIntent();
          localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
          ((Intent)localObject1).addFlags(603979776);
          localSendPhotoActivity.startActivity((Intent)localObject1);
        }
        akyr.d(BaseApplication.getContext(), paramMessage);
        return;
        if (QLog.isColorLevel()) {
          QLog.e(SendPhotoActivity.TAG, 2, "idleHandler time out");
        }
      } while (localSendPhotoActivity.a != null);
      Looper.myQueue().removeIdleHandler(localSendPhotoActivity.f);
      localSendPhotoActivity.a = new SendPhotoTask(localSendPhotoActivity, null, localSendPhotoActivity.mHandler);
      if (localSendPhotoActivity.Lt != 0L) {
        localSendPhotoActivity.a.Lv = (SystemClock.uptimeMillis() - localSendPhotoActivity.Lt);
      }
      ThreadManager.post(localSendPhotoActivity.a, 8, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity
 * JD-Core Version:    0.7.0.1
 */