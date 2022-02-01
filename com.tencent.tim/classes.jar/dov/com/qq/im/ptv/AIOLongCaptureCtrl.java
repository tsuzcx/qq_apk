package dov.com.qq.im.ptv;

import ahyj;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import avfp;
import aybs;
import ayxa;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class AIOLongCaptureCtrl
  implements View.OnTouchListener
{
  private static boolean dxs;
  private static boolean dxt;
  private RunnableLW jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$RunnableLW = new RunnableLW(null);
  private a jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a;
  private LWMotionEvent jdField_a_of_type_DovComQqImPtvLWMotionEvent = new LWMotionEvent();
  private long aCC;
  private long aCD = 400L;
  private RichmediaService jdField_b_of_type_ComTencentMobileqqRichmediaRichmediaService;
  private LWMotionEvent jdField_b_of_type_DovComQqImPtvLWMotionEvent = new LWMotionEvent();
  private boolean dxu;
  private boolean dxv;
  private boolean dxw;
  private int eIW;
  private Handler handler;
  private Runnable iQ = new AIOLongCaptureCtrl.3(this);
  
  public AIOLongCaptureCtrl(a parama)
  {
    this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a = parama;
    this.handler = new Handler(Looper.getMainLooper());
  }
  
  private static LWMotionEvent a(Bundle paramBundle)
  {
    LWMotionEvent localLWMotionEvent = new LWMotionEvent();
    localLWMotionEvent.action = paramBundle.getInt("LWAction");
    localLWMotionEvent.x = paramBundle.getFloat("LWX");
    localLWMotionEvent.y = paramBundle.getFloat("LWY");
    localLWMotionEvent.eIZ = paramBundle.getInt("LWEventSource", 0);
    return localLWMotionEvent;
  }
  
  private static void a(Bundle paramBundle, LWMotionEvent paramLWMotionEvent, int paramInt)
  {
    paramBundle.putInt("LWAction", paramLWMotionEvent.getAction());
    paramBundle.putFloat("LWX", paramLWMotionEvent.getRawX());
    paramBundle.putFloat("LWY", paramLWMotionEvent.getRawY());
    paramBundle.putInt("LWEventSource", paramInt);
  }
  
  private boolean aPX()
  {
    boolean bool = LightVideoConfigMgr.a().aQa();
    if (QLog.isColorLevel()) {
      QLog.i("AIOLongCaptureCtrl", 2, "isLongClickSupport: longSupport=" + bool);
    }
    if (!bool) {}
    int i;
    do
    {
      return false;
      if (!this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.RQ()) {
        return true;
      }
      int[] arrayOfInt = ayxa.getRealDisplay(this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.getActivity());
      i = (int)(arrayOfInt[1] * 0.45F);
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "isLongClickSupport: h_40Height=" + i + " mExternalPanelheight=" + XPanelContainer.aLe + " dataInfo[1]=" + arrayOfInt[1]);
      }
    } while (XPanelContainer.aLe > i);
    return true;
  }
  
  public static void eA(Bundle paramBundle)
  {
    paramBundle = a(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("PTV", 2, " cocohe PTV_LONG_POINT x=" + paramBundle.getRawX() + " y:" + paramBundle.getRawY());
    }
    PtvCameraCaptureActivity.e(paramBundle);
  }
  
  public static void eB(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV", 2, "peakExitEvent");
    }
    PtvCameraCaptureActivity.eQb();
  }
  
  private void ePo()
  {
    this.eIW = 3;
    if (!this.dxw)
    {
      ePr();
      this.dxw = true;
      ePq();
    }
  }
  
  private void ePq()
  {
    this.handler.postDelayed(this.iQ, 3000L);
  }
  
  private void ePr()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.RQ())
    {
      localBundle.putInt("flow_camera_show_mode_style", 1);
      localBundle.putBoolean("flow_camera_show_panel", true);
    }
    for (;;)
    {
      localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.a());
      localBundle.putInt("flow_camera_height", XPanelContainer.aLe);
      localBundle.putBoolean("flow_camera_peak_live", this.dxv);
      localBundle.putInt("light_video_entry_type", this.eIW);
      aybs.a(this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.getAppInterface(), this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.getActivity(), localBundle, 20101);
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch longStartActivity peakLive: " + this.dxv);
      }
      if (avfp.h != null) {
        avfp.h.dqV();
      }
      return;
      localBundle.putInt("flow_camera_show_mode_style", 1);
      localBundle.putBoolean("flow_camera_show_panel", false);
    }
  }
  
  private void ePs()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("flow_camera_show_mode_style", 0);
    localBundle.putBoolean("flow_camera_show_panel", false);
    localBundle.putInt("flow_camera_height", XPanelContainer.aLe);
    localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.a());
    localBundle.putInt("light_video_entry_type", this.eIW);
    aybs.a(this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.getAppInterface(), this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.getActivity(), localBundle, 20101);
    if (QLog.isColorLevel()) {
      QLog.i("AIOLongCaptureCtrl", 2, "handleTouch clickStartActivity");
    }
    if (avfp.h != null) {
      avfp.h.dqV();
    }
  }
  
  public static void ePt()
  {
    if (dxt) {
      dxs = true;
    }
    boolean bool;
    do
    {
      RichmediaService localRichmediaService;
      do
      {
        return;
        dxs = false;
        localRichmediaService = RichmediaService.a();
      } while (localRichmediaService == null);
      bool = localRichmediaService.b(252, -1, new Bundle());
    } while (!QLog.isColorLevel());
    QLog.i("AIOLongCaptureCtrl", 2, "RichMediaServiceCall  success: " + bool);
  }
  
  private void ez(Bundle paramBundle)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaRichmediaService == null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaRichmediaService = RichmediaService.a();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaRichmediaService != null) && (!this.jdField_b_of_type_ComTencentMobileqqRichmediaRichmediaService.b(251, -1, paramBundle)))
    {
      Intent localIntent = new Intent("tencent.qq.ipc.event");
      localIntent.putExtras(paramBundle);
      this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a.getActivity().sendBroadcast(localIntent);
    }
  }
  
  public void aeV(int paramInt)
  {
    this.eIW = paramInt;
    if (!this.dxw)
    {
      ePs();
      this.dxw = true;
      ePq();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20101)
    {
      this.dxw = false;
      this.handler.removeCallbacks(this.iQ);
    }
  }
  
  public void ePp()
  {
    aeV(2);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (QLog.isColorLevel()) {
      QLog.i("AIOLongCaptureCtrl", 2, "handleTouch cocohe[AIO] entryX=" + paramMotionEvent.getRawX() + " entryY=" + paramMotionEvent.getRawY() + " actionEvent:" + i);
    }
    if (this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch cocohe[AIO] context=null actionEvent:" + i);
      }
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      dxs = false;
      dxt = true;
      this.aCC = SystemClock.uptimeMillis();
      this.dxu = true;
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[ACTION_DOWN] hasLongEventDown" + this.dxu);
      }
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.action = 2;
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.y = paramMotionEvent.getRawY();
      this.handler.postDelayed(this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$RunnableLW, 100L);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[ACTION_UP]  hasLongEventDown:" + this.dxu);
      }
      this.handler.removeCallbacks(this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$RunnableLW);
      if (this.dxu)
      {
        this.dxu = false;
        ePp();
      }
      for (;;)
      {
        dxs = false;
        dxt = false;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[ACTION_UP] havePtvUIStarted:" + dxs);
        }
        if (dxs)
        {
          paramView = new Bundle();
          this.jdField_b_of_type_DovComQqImPtvLWMotionEvent.ak(paramMotionEvent);
          a(paramView, this.jdField_b_of_type_DovComQqImPtvLWMotionEvent, 0);
          ez(paramView);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[ACTION_MOVE] hasLongEventDown:" + this.dxu + " havePtvUIStarted:" + dxs);
      }
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.action = 2;
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.y = paramMotionEvent.getRawY();
      if (this.dxu)
      {
        long l1 = SystemClock.uptimeMillis();
        long l2 = this.aCC;
        if ((aPX()) && (l1 - l2 >= this.aCD))
        {
          ePo();
          this.dxu = false;
        }
      }
      else if (dxs)
      {
        paramView = new Bundle();
        this.jdField_b_of_type_DovComQqImPtvLWMotionEvent.ak(paramMotionEvent);
        a(paramView, this.jdField_b_of_type_DovComQqImPtvLWMotionEvent, 0);
        ez(paramView);
      }
    }
  }
  
  class RunnableLW
    implements Runnable
  {
    private RunnableLW() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[RunnableLW] hasLongEventDown:" + AIOLongCaptureCtrl.a(AIOLongCaptureCtrl.this) + " havePtvUIStarted:" + AIOLongCaptureCtrl.dxs);
      }
      if (AIOLongCaptureCtrl.a(AIOLongCaptureCtrl.this))
      {
        long l1 = SystemClock.uptimeMillis();
        long l2 = AIOLongCaptureCtrl.a(AIOLongCaptureCtrl.this);
        if ((AIOLongCaptureCtrl.b(AIOLongCaptureCtrl.this)) && (l1 - l2 >= AIOLongCaptureCtrl.b(AIOLongCaptureCtrl.this)))
        {
          AIOLongCaptureCtrl.a(AIOLongCaptureCtrl.this);
          AIOLongCaptureCtrl.a(AIOLongCaptureCtrl.this, false);
        }
      }
      for (;;)
      {
        AIOLongCaptureCtrl.a(AIOLongCaptureCtrl.this).postDelayed(AIOLongCaptureCtrl.a(AIOLongCaptureCtrl.this), 100L);
        return;
        if (AIOLongCaptureCtrl.dxs)
        {
          Bundle localBundle = new Bundle();
          AIOLongCaptureCtrl.b(localBundle, AIOLongCaptureCtrl.a(AIOLongCaptureCtrl.this), 1);
          AIOLongCaptureCtrl.a(AIOLongCaptureCtrl.this, localBundle);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean RQ();
    
    public abstract SessionInfo a();
    
    public abstract Activity getActivity();
    
    public abstract QQAppInterface getAppInterface();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOLongCaptureCtrl
 * JD-Core Version:    0.7.0.1
 */