package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.ui.QMGesture;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.fingerprint.BaseFingerprintManager;
import com.tencent.qqmail.view.fingerprint.FingerprintFactory;

public class QMGesturePasswordView
  extends LinearLayout
{
  public static int ID_FINGERPRINT_PASSWORD = 3;
  public static int ID_GESTURE_PASSWORD;
  public static int ID_RESET_PASSWORD;
  public static int TYPE_MODIFY_UNLOCK;
  public static int TYPE_SETTING = 1;
  public static int TYPE_UNLOCK = 2;
  private Context context = getContext();
  private TextView fingerPrintTextView;
  private RelativeLayout gestureMiniLayout;
  private QMGesture gestureView;
  private ImageView logoView;
  private TextView resetPasswordTextView;
  private TextView statusTextView;
  
  static
  {
    TYPE_MODIFY_UNLOCK = 3;
    ID_GESTURE_PASSWORD = 1;
    ID_RESET_PASSWORD = 2;
  }
  
  public QMGesturePasswordView(int paramInt)
  {
    super(QMApplicationContext.sharedInstance());
    setOrientation(1);
    initViews();
    if (paramInt == TYPE_UNLOCK) {
      initLogo();
    }
    for (;;)
    {
      initStatusTextView();
      initGestureView();
      if (paramInt == TYPE_UNLOCK)
      {
        if (!FingerprintFactory.createInstance().isAvailable()) {
          break;
        }
        initPasswordResetLinkAndFingerprint();
      }
      return;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 48;
      localLayoutParams.topMargin = getContext().getResources().getDimensionPixelSize(2131299664);
      setLayoutParams(localLayoutParams);
      if (paramInt == TYPE_SETTING) {
        initSmallCircles();
      }
    }
    initPasswordResetLink();
  }
  
  private void adjustMargins()
  {
    int k = 0;
    int m = getMeasuredHeight();
    int i;
    int j;
    label38:
    LinearLayout.LayoutParams localLayoutParams;
    if (this.logoView != null)
    {
      i = this.logoView.getMeasuredHeight();
      if (this.gestureMiniLayout == null) {
        break label281;
      }
      j = this.gestureMiniLayout.getMeasuredHeight();
      int n = this.statusTextView.getMeasuredHeight();
      int i1 = this.gestureView.getMeasuredHeight();
      if (this.resetPasswordTextView != null) {
        k = this.resetPasswordTextView.getMeasuredHeight();
      }
      i = m - i - j - n - i1 - k;
      Log.d("mason", "spaceTotal: " + i);
      if (i > 0)
      {
        if (this.logoView == null) {
          break label286;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.logoView.getLayoutParams();
        localLayoutParams.topMargin = ((int)(i * 0.2D));
        localLayoutParams.bottomMargin = ((int)(i * 0.08D));
        this.logoView.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      if ((this.logoView == null) && (this.gestureMiniLayout == null))
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.statusTextView.getLayoutParams();
        localLayoutParams.topMargin = ((int)(i * 0.2D));
        this.statusTextView.setLayoutParams(localLayoutParams);
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.gestureView.getLayoutParams();
      localLayoutParams.topMargin = ((int)(i * 0.2D));
      localLayoutParams.bottomMargin = ((int)(i * 0.26D));
      this.gestureView.setLayoutParams(localLayoutParams);
      if (this.resetPasswordTextView != null) {
        QMUIKit.expendTouchArea(this.resetPasswordTextView, 15);
      }
      return;
      i = 0;
      break;
      label281:
      j = 0;
      break label38;
      label286:
      if (this.gestureMiniLayout != null)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.gestureMiniLayout.getLayoutParams();
        localLayoutParams.topMargin = ((int)(i * 0.18D));
        localLayoutParams.bottomMargin = ((int)(i * 0.05D));
        this.gestureMiniLayout.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private void initGestureView()
  {
    this.gestureView = new QMGesture(this.context);
    this.gestureView.setId(ID_GESTURE_PASSWORD);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.gestureView.getViewHeight());
    addView(this.gestureView, localLayoutParams);
  }
  
  private void initLogo()
  {
    this.logoView = new ImageView(this.context);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.logoView.setImageResource(2130841419);
    addView(this.logoView, localLayoutParams);
  }
  
  private void initPasswordResetLink()
  {
    this.resetPasswordTextView = new TextView(this.context);
    this.resetPasswordTextView.setId(ID_RESET_PASSWORD);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.resetPasswordTextView.setText(2131719858);
    this.resetPasswordTextView.setTextColor(getResources().getColor(2131167534));
    this.resetPasswordTextView.setTextSize(2, 13.0F);
    int i = QMUIKit.dpToPx(3);
    this.resetPasswordTextView.setPadding(i, i, i, i);
    addView(this.resetPasswordTextView, localLayoutParams);
  }
  
  private void initPasswordResetLinkAndFingerprint()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.resetPasswordTextView = new TextView(this.context);
    this.resetPasswordTextView.setId(ID_RESET_PASSWORD);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = QMUIKit.dpToPx(30);
    this.resetPasswordTextView.setText(2131719858);
    this.resetPasswordTextView.setTextColor(getResources().getColor(2131167534));
    this.resetPasswordTextView.setTextSize(2, 13.0F);
    int i = QMUIKit.dpToPx(3);
    this.resetPasswordTextView.setPadding(i, i, i, i);
    localRelativeLayout.addView(this.resetPasswordTextView, (ViewGroup.LayoutParams)localObject);
    this.fingerPrintTextView = new TextView(this.context);
    this.fingerPrintTextView.setId(ID_FINGERPRINT_PASSWORD);
    localObject = getResources().getDrawable(2130840921);
    ((Drawable)localObject).setBounds(new Rect(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight()));
    this.fingerPrintTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.fingerPrintTextView.setCompoundDrawablePadding(QMUIKit.dpToPx(5));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = QMUIKit.dpToPx(30);
    this.fingerPrintTextView.setText(2131719855);
    this.fingerPrintTextView.setTextColor(getResources().getColor(2131167534));
    this.fingerPrintTextView.setTextSize(2, 13.0F);
    this.fingerPrintTextView.setPadding(i, i, i, i);
    localRelativeLayout.addView(this.fingerPrintTextView, (ViewGroup.LayoutParams)localObject);
    addView(localRelativeLayout, localLayoutParams);
  }
  
  private void initSmallCircles()
  {
    this.gestureMiniLayout = new RelativeLayout(this.context);
    Object localObject = new LinearLayout.LayoutParams(QMUIKit.dpToPx(35), QMUIKit.dpToPx(35));
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    addView(this.gestureMiniLayout, (ViewGroup.LayoutParams)localObject);
    int i = 9;
    if (i > 0)
    {
      localObject = new ImageView(this.context);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((ImageView)localObject).setImageResource(2130840609);
      if (i <= 3)
      {
        localLayoutParams.addRule(10);
        label97:
        if (i % 3 != 1) {
          break label151;
        }
        localLayoutParams.addRule(9);
      }
      for (;;)
      {
        this.gestureMiniLayout.addView((View)localObject, 0, localLayoutParams);
        i -= 1;
        break;
        if (i <= 6)
        {
          localLayoutParams.addRule(15);
          break label97;
        }
        localLayoutParams.addRule(12);
        break label97;
        label151:
        if (i % 3 == 2) {
          localLayoutParams.addRule(14);
        } else {
          localLayoutParams.addRule(11);
        }
      }
    }
  }
  
  private void initStatusTextView()
  {
    this.statusTextView = new TextView(this.context);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.statusTextView.setGravity(1);
    this.statusTextView.setText(2131719859);
    this.statusTextView.setTextColor(getResources().getColor(2131167259));
    this.statusTextView.setTextSize(2, 14.0F);
    addView(this.statusTextView, localLayoutParams);
  }
  
  private void initViews() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    adjustMargins();
  }
  
  public void selectSmallCircles(String paramString)
  {
    int i = 9;
    if (i > 0)
    {
      ImageView localImageView = (ImageView)this.gestureMiniLayout.getChildAt(i - 1);
      if (paramString.contains(i + "")) {
        localImageView.setImageResource(2130840610);
      }
      for (;;)
      {
        i -= 1;
        break;
        localImageView.setImageResource(2130840609);
      }
    }
  }
  
  public void showError(int paramInt)
  {
    showError(this.context.getString(paramInt));
  }
  
  public void showError(String paramString)
  {
    this.statusTextView.setText(paramString);
    this.statusTextView.setTextColor(getResources().getColor(2131167260));
  }
  
  public void showTips(int paramInt)
  {
    this.statusTextView.setText(paramInt);
    this.statusTextView.setTextColor(getResources().getColor(2131167259));
  }
  
  public void switchState(boolean paramBoolean)
  {
    int j = 4;
    Object localObject = this.gestureView;
    if (paramBoolean)
    {
      i = 4;
      ((QMGesture)localObject).setVisibility(i);
      localObject = this.resetPasswordTextView;
      if (!paramBoolean) {
        break label62;
      }
      i = 4;
      label32:
      ((TextView)localObject).setVisibility(i);
      localObject = this.fingerPrintTextView;
      if (!paramBoolean) {
        break label67;
      }
    }
    label62:
    label67:
    for (int i = j;; i = 0)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      i = 0;
      break;
      i = 0;
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMGesturePasswordView
 * JD-Core Version:    0.7.0.1
 */