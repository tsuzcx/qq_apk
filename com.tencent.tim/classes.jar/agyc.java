import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.1;
import com.tencent.mobileqq.filemanager.widget.DragContainerLayout;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.DragView.b;

public class agyc
  extends agxu
  implements View.OnTouchListener
{
  private TextView SO;
  private TextView SP;
  private TextView SQ;
  private DragContainerLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout;
  private DragView.b jdField_a_of_type_ComTencentWidgetDragView$b = new agyg(this);
  private VideoPlayParam jdField_b_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
  private BaseVideoView jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
  private boolean cfM;
  private boolean cfN;
  private boolean cfP;
  private boolean cfQ;
  private ValueAnimator d;
  private Button gi;
  private LinearLayout iV;
  private RelativeLayout iX;
  private RelativeLayout kr;
  private RelativeLayout ks;
  private float lx;
  private float ly;
  private TextView mBackTextView;
  private SeekBar q;
  private TextView sk;
  private ImageView zO;
  
  public agyc(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private String bq(long paramLong)
  {
    long l3 = paramLong / 1000L;
    paramLong = l3 / 86400L;
    long l1 = l3 % 86400L / 3600L;
    long l2 = l3 % 86400L % 3600L / 60L;
    l3 = l3 % 86400L % 3600L % 60L;
    String str2;
    String str1;
    if (paramLong > 0L)
    {
      str2 = String.format("%02d:%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      str1 = str2;
      if (QLog.isDevelopLevel())
      {
        QLog.d("#@#@", 1, "getTick 161 [" + str2 + "]");
        str1 = str2;
      }
    }
    do
    {
      do
      {
        return str1;
        if (l1 <= 0L) {
          break;
        }
        str2 = String.format("%02d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
        str1 = str2;
      } while (!QLog.isDevelopLevel());
      QLog.d("#@#@", 1, "getTick 167 [" + str2 + "]");
      return str2;
      str2 = String.format("%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
      str1 = str2;
    } while (!QLog.isDevelopLevel());
    QLog.d("#@#@", 1, "getTick 174 [" + str2 + "]");
    return str2;
  }
  
  public void JK(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.cfN)) {}
    for (boolean bool = true;; bool = false)
    {
      super.JK(bool);
      this.cfM = paramBoolean;
      return;
    }
  }
  
  public void JT(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.SQ != null)
    {
      localTextView = this.SQ;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void JU(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.gi.setBackgroundResource(2130846637);
      this.gi.setContentDescription(this.mContext.getString(2131692141));
      return;
    }
    this.gi.setBackgroundResource(2130846635);
    this.gi.setContentDescription(this.mContext.getString(2131692144));
  }
  
  public void JV(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.SO != null)
    {
      localTextView = this.SO;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void JW(boolean paramBoolean)
  {
    int j = 0;
    LinearLayout localLinearLayout;
    if ((paramBoolean) && (!this.cfN))
    {
      i = 1;
      localLinearLayout = this.iV;
      if (i == 0) {
        break label44;
      }
    }
    label44:
    for (int i = j;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      this.cfP = paramBoolean;
      return;
      i = 0;
      break;
    }
  }
  
  public void JX(boolean paramBoolean)
  {
    int j = 0;
    RelativeLayout localRelativeLayout;
    if ((paramBoolean) && (!this.cfN))
    {
      i = 1;
      localRelativeLayout = this.kr;
      if (i == 0) {
        break label44;
      }
    }
    label44:
    for (int i = j;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      this.cfQ = paramBoolean;
      return;
      i = 0;
      break;
    }
  }
  
  public void OL(int paramInt)
  {
    this.q.setProgress(paramInt);
  }
  
  public void OR(int paramInt)
  {
    this.q.setMax(paramInt);
  }
  
  @TargetApi(16)
  public void U(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      this.jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setBackground(paramDrawable);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(long paramLong, View.OnLongClickListener paramOnLongClickListener)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)allg.createBaseVideoView(this.mContext, paramLong, null, null));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13, -1);
      this.jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout = new DragContainerLayout(this.mContext);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.setContainerLongClickListener(paramOnLongClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.addView(this.jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView);
      int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.setGestureChangeListener(this.jdField_a_of_type_ComTencentWidgetDragView$b);
      paramOnLongClickListener = new RelativeLayout.LayoutParams(-1, -1);
      this.iX.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout, 0, paramOnLongClickListener);
      if (this.jdField_b_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam != null) {
        this.jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(this.jdField_b_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
      }
    }
  }
  
  public BaseVideoView c()
  {
    return this.jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
  }
  
  public View ca()
  {
    return this.CS;
  }
  
  public void dkA()
  {
    if (this.iX != null) {
      this.iX.removeAllViews();
    }
  }
  
  @TargetApi(11)
  public void dkB()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.d = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.d.setDuration(2500L);
      this.d.addUpdateListener(new agyf(this));
    }
  }
  
  public void dkC()
  {
    if ((this.iV.getVisibility() == 0) && (Build.VERSION.SDK_INT >= 11))
    {
      this.d.cancel();
      this.d.start();
    }
  }
  
  public void dkD()
  {
    this.iV.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.iV.setAlpha(1.0F);
    }
  }
  
  public void dkq()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: VideoFileViewer initFileView");
    if (this.CS == null)
    {
      this.CS = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131561068, this.mRootView, false);
      this.SP = ((TextView)this.CS.findViewById(2131373534));
      this.sk = ((TextView)this.CS.findViewById(2131362688));
      this.iV = ((LinearLayout)this.CS.findViewById(2131381582));
      this.ks = ((RelativeLayout)this.CS.findViewById(2131373664));
      this.SQ = ((TextView)this.CS.findViewById(2131377225));
      this.SQ.setText(acfp.m(2131716386));
      this.zO = ((ImageView)this.CS.findViewById(2131373663));
      this.ks.setVisibility(8);
      this.q = ((SeekBar)this.CS.findViewById(2131373413));
      this.gi = ((Button)this.CS.findViewById(2131373366));
      this.SO = ((TextView)this.CS.findViewById(2131371273));
      this.kr = ((RelativeLayout)this.CS.findViewById(2131379879));
      this.mBackTextView = ((TextView)this.CS.findViewById(2131363223));
      this.iX = ((RelativeLayout)this.CS.findViewById(2131367044));
    }
  }
  
  public void fR(String paramString1, String paramString2)
  {
    ((ViewGroup)this.CS).removeView(this.jdField_b_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setBackgroundColor(Color.parseColor("#D8DAE0"));
    TextView localTextView = new TextView(this.mContext);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845187, 0, 0);
    localTextView.setText(paramString2);
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(Color.parseColor("#83889A"));
    localTextView.setPadding(0, 15, 0, 0);
    localRelativeLayout.addView(localTextView, -2, -2);
    ((RelativeLayout.LayoutParams)localTextView.getLayoutParams()).addRule(13);
    if (ahbj.fileExistsAndNotEmpty(paramString1))
    {
      paramString2 = new TextView(this.mContext);
      paramString2.setText("用QQ浏览器打开");
      paramString2.setContentDescription("用qq浏览器打开");
      paramString2.setTextSize(12.0F);
      paramString2.setTextColor(Color.parseColor("#12B7F5"));
      paramString2.setOnClickListener(new agyd(this, paramString1));
      localRelativeLayout.addView(paramString2, -2, -2);
      paramString1 = (RelativeLayout.LayoutParams)paramString2.getLayoutParams();
      paramString1.addRule(13);
      paramString1.addRule(12);
      paramString1.setMargins(0, 0, 0, 40);
      paramString2.setLayoutParams(paramString1);
    }
    int i = (int)(((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 0.75D);
    ((ViewGroup)this.CS).addView(localRelativeLayout, -1, i);
    ((RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams()).addRule(13);
    JK(false);
    this.gi.setVisibility(4);
    this.SP.setVisibility(4);
    this.q.setVisibility(4);
    this.sk.setVisibility(4);
    this.iV.setBackgroundDrawable(null);
    this.CS.setOnClickListener(new agye(this));
  }
  
  public void fW(long paramLong)
  {
    this.sk.setText(bq(paramLong));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      float f3;
      float f4;
      do
      {
        for (;;)
        {
          return false;
          this.lx = f1;
          this.ly = f2;
        }
        f3 = Math.abs(f1 - this.lx);
        f4 = Math.abs(f2 - this.ly);
        QLog.i("FileBrowserViewBase", 1, "absX[" + f3 + "] --- absY[" + f4 + "]，mPressDownY[" + this.ly + "]，currTouchY【" + f2 + "】");
      } while (f3 <= f4);
      if (f1 - this.lx > 20.0F)
      {
        QLog.i("FileBrowserViewBase", 1, "<--  左滑");
        return true;
      }
    } while (f1 - this.lx >= -20.0F);
    QLog.i("FileBrowserViewBase", 1, "-->  右滑");
    return true;
  }
  
  public void setCurrentTime(long paramLong)
  {
    this.SP.setText(bq(paramLong));
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.iV.setOnClickListener(paramOnClickListener);
      this.gi.setOnClickListener(paramOnClickListener);
      this.SO.setOnClickListener(paramOnClickListener);
      this.mBackTextView.setOnClickListener(paramOnClickListener);
      this.SQ.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.q.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void showLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ks.setVisibility(0);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(500L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setRepeatMode(1);
      localRotateAnimation.setStartTime(-1L);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.zO.startAnimation(localRotateAnimation);
      return;
    }
    this.mContext.runOnUiThread(new VideoFileViewer.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyc
 * JD-Core Version:    0.7.0.1
 */