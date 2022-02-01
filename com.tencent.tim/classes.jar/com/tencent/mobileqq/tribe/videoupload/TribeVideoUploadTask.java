package com.tencent.mobileqq.tribe.videoupload;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import aori;
import aork;
import aorl;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import pov;
import pow;

public class TribeVideoUploadTask
  extends BasePublishTask<aork>
  implements pow
{
  protected WeakReference<BaseActivity> mActivity;
  protected Handler mHandler;
  
  public TribeVideoUploadTask(BaseActivity paramBaseActivity, Handler paramHandler, aork paramaork)
  {
    super(paramaork);
    paramaork.Aj = SystemClock.elapsedRealtime();
    aori localaori = new aori(paramaork.mLocalVideoPath);
    localaori.a(new aorl(this, paramaork));
    paramaork.ms.add(localaori);
    this.mHandler = paramHandler;
    this.mActivity = new WeakReference(paramBaseActivity);
    a(this);
  }
  
  private void H(int paramInt, Object paramObject)
  {
    if (this.mActivity == null) {}
    for (Object localObject = null; (localObject == null) || (((BaseActivity)localObject).isFinishing()); localObject = (BaseActivity)this.mActivity.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("tribe_publish_VideoUploadTask", 2, "TribeVideoUploadTask finish but activity is null!");
      }
      return;
    }
    localObject = this.mHandler.obtainMessage(paramInt);
    if (paramObject != null) {
      ((Message)localObject).obj = paramObject;
    }
    this.mHandler.sendMessage((Message)localObject);
  }
  
  public void a(BasePublishTask paramBasePublishTask, ErrorMessage paramErrorMessage)
  {
    QLog.i("tribe_publish_tribe_publish_VideoUploadTask", 1, "upload finish status:" + paramBasePublishTask.a().status);
    paramBasePublishTask = (aork)paramBasePublishTask.a();
    if (paramBasePublishTask.isSuccess())
    {
      QLog.i("tribe_publish_tribe_publish_VideoUploadTask", 1, "uploadVideo succ " + paramBasePublishTask.mVideoKey);
      H(1011, paramBasePublishTask);
    }
    while (!paramBasePublishTask.isFail()) {
      return;
    }
    QLog.i("tribe_publish_tribe_publish_VideoUploadTask", 1, "uploadVideo failed:" + paramBasePublishTask.toString() + " error:" + paramErrorMessage);
    H(1010, paramBasePublishTask);
  }
  
  public void bmg()
  {
    a(5, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.videoupload.TribeVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */