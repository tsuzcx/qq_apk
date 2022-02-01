import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.colornote.swipeback.PostTable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import mqq.util.WeakReference;

@ProxyService(proxy=PageGestureProxy.class)
public class aswg
  implements aebf, PageGestureProxy
{
  private WeakReference<Activity> bj;
  private boolean dgy;
  protected aeay mColorNoteController;
  private aeaz mColorNoteCurd;
  private aedo mColorNoteStateNotice;
  private aqju mDialog;
  private boolean mFirstShow = true;
  private MiniAppInfo mMiniAppInfo;
  public PostTable mPostTable;
  private boolean mPostTableVisible;
  private aebf mServiceInfo;
  private aeel mTouchStateDetector;
  private Vibrator mVibrator;
  
  private void cA(Activity paramActivity)
  {
    this.mColorNoteController = new aeay(paramActivity, false, true);
    this.mColorNoteController.attachToActivity(paramActivity);
    this.mColorNoteController.setServiceInfo(this);
    this.mColorNoteController.a(new aswh(this, paramActivity));
    this.mColorNoteController.setOnColorNoteCurdListener(new aswi(this, paramActivity));
    this.mPostTable = new PostTable(paramActivity);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(this.mPostTable);
    this.mPostTable.setVisibility(4);
    this.mPostTable.A(0.0D);
    this.mVibrator = ((Vibrator)paramActivity.getSystemService("vibrator"));
  }
  
  private void fullDialog()
  {
    if (this.bj == null) {}
    Object localObject;
    do
    {
      return;
      if (this.mDialog != null) {
        break;
      }
      localObject = (Activity)this.bj.get();
    } while (localObject == null);
    this.mDialog = new aqju((Context)localObject, 2131756467);
    this.mDialog.setContentView(2131559151);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setTitle(((Activity)localObject).getString(2131691732));
    this.mDialog.setNegativeButton(((Activity)localObject).getString(2131691731), new aswk(this, (Activity)localObject));
    for (;;)
    {
      this.mDialog.show();
      localObject = this.mDialog.getTitleTextView();
      ((View)localObject).setClickable(true);
      ((View)localObject).setFocusable(true);
      ((View)localObject).setFocusableInTouchMode(true);
      aqcl.Q((View)localObject, true);
      return;
      if (this.mDialog.isShowing()) {
        this.mDialog.dismiss();
      }
    }
  }
  
  private ColorNote generateColorNote()
  {
    if (this.mServiceInfo != null) {
      return this.mServiceInfo.getColorNote();
    }
    return null;
  }
  
  private void setColorNoteStateNotice()
  {
    if (this.mColorNoteStateNotice == null)
    {
      this.mColorNoteCurd = new aeaz();
      this.mColorNoteCurd.setOnColorNoteCurdListener(new aswj(this));
      this.mColorNoteStateNotice = new aedo();
      this.mColorNoteStateNotice.a(this.mColorNoteCurd);
    }
  }
  
  public ColorNote getColorNote()
  {
    if (this.mMiniAppInfo != null)
    {
      MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
      if (QLog.isColorLevel()) {
        QLog.d("PageGuestureProxyImpl", 2, "getColorNote, appId: " + localMiniAppInfo.appId + ", name: " + localMiniAppInfo.name);
      }
      return new ColorNote.a().a(16842752).a(localMiniAppInfo.appId).b(localMiniAppInfo.name).c(localMiniAppInfo.desc).d(localMiniAppInfo.iconUrl).a();
    }
    return null;
  }
  
  public aeay getColorNoteController()
  {
    return this.mColorNoteController;
  }
  
  public void onActivityCreate(Activity paramActivity)
  {
    this.bj = new WeakReference(paramActivity);
    cA(paramActivity);
  }
  
  public void onActivityDestroy(Activity paramActivity)
  {
    this.mColorNoteController.onDestroy();
  }
  
  public void onActivityFinish(Activity paramActivity) {}
  
  public void onActivityPause(Activity paramActivity)
  {
    this.mColorNoteController.onPause();
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    this.mColorNoteController.onResume();
  }
  
  public void onActivityStop(Activity paramActivity)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onActivityStop");
    this.mColorNoteController.onPause();
  }
  
  public void onCreateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
  }
  
  public void onLoadUrl(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null) {
      this.mMiniAppInfo = paramMiniAppInfo;
    }
    setServiceInfo(this);
  }
  
  public void onMoveTaskToBack(Activity paramActivity)
  {
    if ((this.mColorNoteController != null) && (this.mColorNoteController.isColorNoteExist())) {
      this.mColorNoteController.exitAnimation();
    }
  }
  
  public void onPageWebViewInit()
  {
    if (this.bj != null)
    {
      Activity localActivity = (Activity)this.bj.get();
      if (localActivity != null) {
        this.mTouchStateDetector = new aeel(localActivity);
      }
    }
    setColorNoteStateNotice();
  }
  
  public void onProcessTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onProcessTouchEvent");
    double d;
    Object localObject;
    boolean bool1;
    if ((this.mColorNoteCurd != null) && (this.mColorNoteCurd.getSyncState()) && (this.mTouchStateDetector != null) && (this.mPostTable != null))
    {
      d = this.mTouchStateDetector.a(paramMotionEvent);
      this.mColorNoteCurd.canAddColorNote();
      localObject = this.mServiceInfo.getColorNote();
      if (localObject == null) {
        break label323;
      }
      bool1 = this.mColorNoteCurd.u(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType());
      if (this.mMiniAppInfo == null) {
        break label383;
      }
    }
    label227:
    label383:
    for (boolean bool2 = this.mMiniAppInfo.isLimitedAccessApp();; bool2 = false)
    {
      if ((d > 0.0D) && (!bool1) && (!bool2) && (this.bj != null))
      {
        if (!this.mPostTableVisible)
        {
          this.mPostTable.setVisibility(0);
          this.mPostTableVisible = true;
        }
        localObject = (Activity)this.bj.get();
        if ((this.mColorNoteCurd.canAddColorNote()) && (localObject != null)) {
          if (this.mTouchStateDetector.a(paramMotionEvent, (Context)localObject))
          {
            this.mPostTable.cWs();
            if ((!this.dgy) && (this.mVibrator != null))
            {
              this.mVibrator.vibrate(20L);
              this.dgy = true;
            }
            this.mPostTable.A(d);
            if (this.mFirstShow)
            {
              anot.a(null, "dc00898", "", "", "0X800A741", "0X800A741", aeax.gT(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
              this.mFirstShow = false;
            }
          }
        }
      }
      for (;;)
      {
        if ((paramMotionEvent.getActionMasked() == 1) && (this.mPostTable != null))
        {
          this.mPostTable.setVisibility(4);
          this.mPostTableVisible = false;
        }
        return;
        bool1 = false;
        break;
        this.mPostTable.cWr();
        this.dgy = false;
        break label227;
        this.mPostTable.cWt();
        break label227;
        if ((d < 1.0E-008D) || (bool1))
        {
          this.mPostTable.setVisibility(4);
          this.mPostTableVisible = false;
        }
      }
    }
  }
  
  public boolean onViewReleasedAndNeedScrollOriginPosition(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    QLog.d("PageGuestureProxyImpl", 1, "onViewReleased");
    if (this.mMiniAppInfo != null) {}
    for (boolean bool1 = this.mMiniAppInfo.isLimitedAccessApp();; bool1 = false)
    {
      if (bool1) {
        return false;
      }
      ColorNote localColorNote = generateColorNote();
      Activity localActivity;
      if (localColorNote != null)
      {
        bool1 = this.mColorNoteCurd.u(localColorNote.getServiceType(), localColorNote.getSubType());
        this.mFirstShow = true;
        if (this.bj == null) {
          break label222;
        }
        localActivity = (Activity)this.bj.get();
        label85:
        if ((this.mTouchStateDetector == null) || (!this.mTouchStateDetector.a(paramMotionEvent, localActivity)) || (bool1) || (localColorNote == null)) {
          break label278;
        }
        if (!this.mColorNoteCurd.canAddColorNote()) {
          break label228;
        }
        paramMotionEvent = localColorNote.parseBundle();
        paramMotionEvent.putInt("color_note_curd_from_type", 1);
        this.mColorNoteCurd.cm(paramMotionEvent);
        anot.a(null, "dc00898", "", "", "0X800A742", "0X800A742", aeax.gT(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
        bool1 = false;
      }
      for (;;)
      {
        if (this.mPostTable != null)
        {
          this.mPostTable.setVisibility(4);
          this.mPostTableVisible = false;
        }
        return bool1;
        bool1 = false;
        break;
        label222:
        localActivity = null;
        break label85;
        label228:
        this.mPostTable.A(0.0D);
        fullDialog();
        anot.a(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        bool1 = bool2;
        continue;
        label278:
        bool1 = false;
      }
    }
  }
  
  public void setServiceInfo(aebf paramaebf)
  {
    this.mServiceInfo = paramaebf;
    setColorNoteStateNotice();
    this.mColorNoteStateNotice.setServiceInfo(paramaebf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswg
 * JD-Core Version:    0.7.0.1
 */