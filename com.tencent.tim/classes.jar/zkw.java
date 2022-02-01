import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog.1;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class zkw
  extends ReportDialog
  implements Handler.Callback
{
  public XListView F;
  arhz jdField_a_of_type_Arhz;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  zmc jdField_a_of_type_Zmc;
  QQAppInterface app;
  protected aurf b;
  boolean brA = false;
  protected int cdF;
  private Runnable eZ = new BaseMessageSearchDialog.2(this);
  protected Context mContext;
  protected MessageRecord o;
  SessionInfo sessionInfo;
  EditText v;
  
  public zkw(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, 16973834);
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.b = new aurf(Looper.getMainLooper(), this);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(2);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2131559537);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    bVX();
  }
  
  private void bVX()
  {
    View localView;
    if (((this.mContext instanceof Activity)) && (this.mContext.getResources().getConfiguration().orientation == 1))
    {
      Activity localActivity = (Activity)this.mContext;
      localView = findViewById(2131370833);
      if (ayxa.hasNotchInScreenByVersion(localActivity)) {
        localView.post(new BaseMessageSearchDialog.1(this, localView, localActivity));
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseMessageSearchDialog", 2, "has no Notch, setPaddingTop 0");
    }
    localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
    ThreadManager.getUIHandler().postDelayed(this.eZ, 500L);
  }
  
  public void BM(boolean paramBoolean)
  {
    this.brA = paramBoolean;
  }
  
  public boolean Vv()
  {
    return this.brA;
  }
  
  protected void am(int paramInt)
  {
    if (this.a == null) {
      this.a = new arhz(this.mContext, this.mContext.getResources().getDimensionPixelSize(2131299627));
    }
    this.a.setCancelable(false);
    this.a.setCanceledOnTouchOutside(false);
    this.a.setMessage(paramInt);
    this.a.show();
  }
  
  protected void cpN() {}
  
  public void dismiss()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.eZ);
    super.dismiss();
  }
  
  protected void dismissProgressDialog()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public int getRecordCount()
  {
    return this.cdF;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected void showSoftInput()
  {
    if (isShowing())
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.v.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      this.v.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
  }
  
  protected void showSoftInputIfNecessary()
  {
    if (getContext().getResources().getConfiguration().orientation == 2) {
      this.b.sendEmptyMessageDelayed(1, 0L);
    }
  }
  
  public class a
    implements View.OnKeyListener, TextView.OnEditorActionListener
  {
    protected a() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 3)
      {
        zkw.this.cpN();
        return true;
      }
      return false;
    }
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 84))
      {
        if (paramKeyEvent.getAction() == 1) {
          zkw.this.cpN();
        }
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zkw
 * JD-Core Version:    0.7.0.1
 */