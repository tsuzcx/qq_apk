package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import arhz;
import arib;
import aurp;
import com.tencent.qphone.base.util.QLog;
import rls;
import rma;

public class SlideProgressNotifier
  extends arib
  implements DialogInterface.OnKeyListener, rls
{
  RefreshProgressThread jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread;
  private a jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$a;
  Activity mContext;
  Handler uiHandler;
  
  public SlideProgressNotifier(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.mContext = paramActivity;
    this.uiHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$a = parama;
  }
  
  public void ah(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.isCancel()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.cancel();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = null;
    }
    xG(paramInt3);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = new RefreshProgressThread(paramInt1, paramInt2, paramInt3, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.start();
    if (QLog.isColorLevel()) {
      QLog.d("SlideProgressNotifier", 2, "beginMerge totalDuration=" + paramInt1 + " totalProgress = " + paramInt2 + " startProgress=" + paramInt3);
    }
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.cancel();
    }
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      rma.a().bvs();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$a != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$a.onCancel();
      }
    }
    return false;
  }
  
  public void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.aa(paramInt1, this.mContext.getString(2131701771) + "0%", 0);
    if (this.D != null) {
      this.D.setOnKeyListener(this);
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.isCancel()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.cancel();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = null;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = new RefreshProgressThread(paramInt2, paramInt3, paramInt4, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.start();
    if (QLog.isColorLevel()) {
      QLog.d("SlideProgressNotifier", 2, " beginTask totalDuration=" + paramInt2 + " totalProgress = " + paramInt3 + " startProgress=" + paramInt4);
    }
  }
  
  public void xG(int paramInt)
  {
    if (this.uiHandler != null) {
      this.uiHandler.post(new SlideProgressNotifier.1(this, paramInt));
    }
  }
  
  public static class RefreshProgressThread
    extends Thread
  {
    rls a;
    int bti;
    int btj;
    int btk;
    int interval;
    boolean isCancel = false;
    
    public RefreshProgressThread(int paramInt1, int paramInt2, int paramInt3, rls paramrls)
    {
      this.bti = paramInt1;
      this.btj = paramInt2;
      if (paramInt2 - paramInt3 > 0) {}
      for (this.interval = (paramInt1 / (paramInt2 - paramInt3));; this.interval = 100)
      {
        this.btk = paramInt3;
        this.a = paramrls;
        return;
      }
    }
    
    public void cancel()
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProgressNotifier", 2, "cancel progress update thread, stack trace : " + aurp.getStackTraceAsString(new RuntimeException()));
      }
      this.isCancel = true;
    }
    
    public boolean isCancel()
    {
      return this.isCancel;
    }
    
    public void run()
    {
      while (!this.isCancel) {
        if (this.btk < this.btj)
        {
          if (this.a != null)
          {
            this.a.xG(this.btk);
            this.btk += 1;
            try
            {
              Thread.sleep(this.interval);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
        else
        {
          this.btk = this.btj;
          if (this.a != null) {
            this.a.xG(this.btk);
          }
          this.isCancel = true;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier
 * JD-Core Version:    0.7.0.1
 */