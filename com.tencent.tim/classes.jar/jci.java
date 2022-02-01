import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class jci
{
  private boolean XA = true;
  private boolean Xw;
  private boolean Xx = true;
  private boolean Xy = true;
  private boolean Xz = true;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private jdf jdField_a_of_type_Jdf;
  private BroadcastReceiver aa = new jcj(this);
  private int awR = 2;
  private AVActivity jdField_e_of_type_ComTencentAvUiAVActivity;
  private ImageView[] jdField_e_of_type_ArrayOfAndroidWidgetImageView = new ImageView[4];
  private RelativeLayout ei;
  private View.OnTouchListener jdField_j_of_type_AndroidViewView$OnTouchListener = new jck(this);
  private Queue<Long> jdField_j_of_type_JavaUtilQueue = new LinkedList();
  private int mCurrentIndex = -1;
  private int mResId;
  private View mRootView;
  private ViewStub n;
  private long oJ = -1L;
  
  public jci(View paramView, ViewStub paramViewStub, int paramInt, VideoController paramVideoController, AVActivity paramAVActivity)
  {
    this.mRootView = paramView;
    this.n = paramViewStub;
    this.mResId = paramInt;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_e_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_Jdf = new jdf(paramVideoController, paramAVActivity);
    this.jdField_a_of_type_Jdf.init();
    this.jdField_e_of_type_ComTencentAvUiAVActivity.registerReceiver(this.aa, new IntentFilter("tencent.video.q2v.SVIP.PAY"));
  }
  
  private void atE()
  {
    Object localObject4 = (RelativeLayout)this.ei.findViewById(2131374209);
    Object localObject3 = (RelativeLayout)this.ei.findViewById(2131374212);
    Object localObject2 = (RelativeLayout)this.ei.findViewById(2131374218);
    Object localObject1 = (RelativeLayout)this.ei.findViewById(2131374214);
    int i = (int)jll.dp2px(this.jdField_a_of_type_ComTencentAvVideoController.mApp.getApp().getApplicationContext(), 4.0F);
    int k = (int)jll.dp2px(this.jdField_a_of_type_ComTencentAvVideoController.mApp.getApp().getApplicationContext(), 132.0F);
    int m = (int)jll.dp2px(this.jdField_a_of_type_ComTencentAvVideoController.mApp.getApp().getApplicationContext(), 8.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.width = k;
    ((RelativeLayout)localObject4).setLayoutParams(localLayoutParams);
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131374209);
    ((RelativeLayout.LayoutParams)localObject4).leftMargin = i;
    ((RelativeLayout.LayoutParams)localObject4).width = k;
    ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131374209);
    ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131374209);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131374209);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject3).width = k;
    ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131374212);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131374212);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131374212);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).width = k;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131374220);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = m;
    ((TextView)this.ei.findViewById(2131374221)).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131374216);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = m;
    ((TextView)this.ei.findViewById(2131374217)).setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  private void atF()
  {
    if (this.ei == null)
    {
      this.n.inflate();
      this.ei = ((RelativeLayout)this.mRootView.findViewById(this.mResId));
      this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.ei.findViewById(2131374210));
      this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[0].setOnTouchListener(this.jdField_j_of_type_AndroidViewView$OnTouchListener);
      this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.ei.findViewById(2131374213));
      this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[1].setOnTouchListener(this.jdField_j_of_type_AndroidViewView$OnTouchListener);
      this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.ei.findViewById(2131374220));
      this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[2].setOnTouchListener(this.jdField_j_of_type_AndroidViewView$OnTouchListener);
      ((TextView)this.ei.findViewById(2131374221)).setText(this.jdField_a_of_type_ComTencentAvVideoController.b().MV);
      if (ioc.Tv)
      {
        this.ei.findViewById(2131374214).setVisibility(0);
        this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[3] = ((ImageView)this.ei.findViewById(2131374216));
        this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[3].setOnTouchListener(this.jdField_j_of_type_AndroidViewView$OnTouchListener);
        ((TextView)this.ei.findViewById(2131374217)).setText(this.jdField_a_of_type_ComTencentAvVideoController.b().MV);
        atE();
      }
      this.ei.setOnClickListener(new jcp(this));
      this.mCurrentIndex = 0;
      this.ei.setVisibility(8);
      this.jdField_a_of_type_Jdf.wv();
    }
    this.mCurrentIndex = this.jdField_a_of_type_ComTencentAvVideoController.b().amX;
    atG();
  }
  
  private void atG()
  {
    ImageView localImageView = this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[0];
    Resources localResources = this.mRootView.getResources();
    if (this.mCurrentIndex == 0)
    {
      i = 2130843108;
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      localImageView = this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[1];
      localResources = this.mRootView.getResources();
      if (this.mCurrentIndex != 1) {
        break label157;
      }
      i = 2130843106;
      label62:
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      localImageView = this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[2];
      localResources = this.mRootView.getResources();
      if (this.mCurrentIndex != 2) {
        break label164;
      }
      i = 2130843112;
      label98:
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      if (ioc.Tv)
      {
        localImageView = this.jdField_e_of_type_ArrayOfAndroidWidgetImageView[3];
        localResources = this.mRootView.getResources();
        if (this.mCurrentIndex != 3) {
          break label171;
        }
      }
    }
    label157:
    label164:
    label171:
    for (int i = 2130843110;; i = 2130843109)
    {
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      return;
      i = 2130843107;
      break;
      i = 2130843105;
      break label62;
      i = 2130843111;
      break label98;
    }
  }
  
  private void atH()
  {
    atG();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (localiiv != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.sendSelectVideoModeRequest(Long.valueOf(localiiv.peerUin).longValue(), this.mCurrentIndex);
      }
    }
  }
  
  private void jX(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.mRootView.findViewById(2131374040);
    String str = this.jdField_a_of_type_ComTencentAvVideoController.mApp.getApp().getString(2131697757);
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.mApp.getApp();
    if (paramBoolean) {}
    for (int i = 2131697756;; i = 2131697755)
    {
      localObject = ((BaseApplication)localObject).getString(i);
      jcq localjcq = new jcq(this);
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      localSpannableString.setSpan(localjcq, 0, ((String)localObject).length(), 18);
      localSpannableString.setSpan(new ForegroundColorSpan(-11692801), 0, ((String)localObject).length(), 17);
      localTextView.setText(str);
      localTextView.append(localSpannableString);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    }
  }
  
  public void atB()
  {
    atF();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.ei, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setStartDelay(300L);
    localObjectAnimator.addListener(new jcn(this));
    localObjectAnimator.start();
  }
  
  public void atC()
  {
    if (this.ei != null) {
      this.ei.setVisibility(8);
    }
  }
  
  public void atD()
  {
    ((RelativeLayout)this.mRootView.findViewById(2131374039)).setVisibility(4);
    atF();
    boolean bool = this.jdField_a_of_type_Jdf.wv();
    int k = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, "switchToHDMode. curMinute = " + k + ", startTime = " + this.jdField_a_of_type_ComTencentAvVideoController.b().amY + ", endTime = " + this.jdField_a_of_type_ComTencentAvVideoController.b().amZ + ", tips = " + this.jdField_a_of_type_ComTencentAvVideoController.b().MV + ", m1080PHDModeTipsHasShowed = " + this.Xy);
    if (this.Xy)
    {
      i = 3;
      anot.a(null, "CliOper", "", "", "0X800AA5E", "0X800AA5E", i + 1, 0, "", "", "", "");
      if ((!bool) && ((this.jdField_a_of_type_ComTencentAvVideoController.b().amY > k) || (k >= this.jdField_a_of_type_ComTencentAvVideoController.b().amZ))) {
        break label252;
      }
      if (!this.Xy) {
        break label247;
      }
    }
    label247:
    for (int i = 3;; i = 2)
    {
      this.mCurrentIndex = i;
      atH();
      return;
      i = 2;
      break;
    }
    label252:
    this.Xw = true;
    Object localObject = new jco(this);
    localObject = aqha.a(this.jdField_e_of_type_ComTencentAvUiAVActivity, 0, acfp.m(2131710318), null, acfp.m(2131710319), acfp.m(2131710320), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if (localObject != null) {
      ((aqju)localObject).show();
    }
    anot.a(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
  }
  
  public void atI()
  {
    if (this.jdField_a_of_type_Jdf != null) {
      this.jdField_a_of_type_Jdf.auo();
    }
  }
  
  public void atJ()
  {
    if (this.jdField_a_of_type_Jdf != null) {
      this.jdField_a_of_type_Jdf.hideProgress();
    }
  }
  
  public void bt(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.mApp == null)) {}
    do
    {
      do
      {
        iiv localiiv;
        do
        {
          return;
          localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
        } while ((localiiv == null) || (localiiv.amI != 2));
        if ((paramInt1 < 1920) || (paramInt2 < 1080)) {
          break;
        }
      } while (this.XA);
      QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onRecvVideoResolutionChanged. w = " + paramInt1 + ", h = " + paramInt2);
      iwu.a(this.jdField_a_of_type_ComTencentAvVideoController.mApp, 1058, this.jdField_a_of_type_ComTencentAvVideoController.mApp.getApp().getString(2131698005));
      this.XA = true;
      anot.a(null, "CliOper", "", "", "0X800AA60", "0X800AA60", 4, 0, "", "", "", "");
      return;
    } while ((paramInt1 < 1280) || (paramInt2 < 720) || (this.Xz));
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onRecvVideoResolutionChanged. w = " + paramInt1 + ", h = " + paramInt2);
    iwu.a(this.jdField_a_of_type_ComTencentAvVideoController.mApp, 1058, this.jdField_a_of_type_ComTencentAvVideoController.mApp.getApp().getString(2131698006));
    this.Xz = true;
    anot.a(null, "CliOper", "", "", "0X800AA60", "0X800AA60", 3, 0, "", "", "", "");
  }
  
  public void doDestroy()
  {
    if (this.jdField_a_of_type_Jdf != null)
    {
      this.jdField_a_of_type_Jdf.unInit();
      this.jdField_a_of_type_Jdf = null;
    }
    if (this.jdField_e_of_type_ComTencentAvUiAVActivity != null) {
      this.jdField_e_of_type_ComTencentAvUiAVActivity.unregisterReceiver(this.aa);
    }
    if (QLog.isColorLevel()) {
      QLog.w("QavDoubleVideoSharpnessMangaer", 1, "doDestroy");
    }
  }
  
  public void kt(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_e_of_type_ComTencentAvUiAVActivity == null) || (this.jdField_e_of_type_ComTencentAvUiAVActivity.mControlUI == null) || (this.mRootView == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
          } while ((localObject == null) || (((iiv)localObject).amI != 2) || ((this.Xx) && (this.Xy)) || ((this.jdField_a_of_type_ComTencentAvVideoController.b().amX != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.b().amX != 2)) || (this.jdField_e_of_type_ComTencentAvUiAVActivity.lV() != 2));
          localObject = this.mRootView.findViewById(2131374120);
        } while (((localObject != null) && (((View)localObject).getVisibility() == 0)) || (this.mRootView.findViewById(2131374247).getVisibility() != 0));
        if (paramInt < 2) {
          break;
        }
      } while ((!ioc.Tv) || (this.Xy));
      QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onNetworkQualityChanged. networkQuality = " + paramInt);
      this.jdField_e_of_type_ComTencentAvUiAVActivity.mControlUI.auV();
      this.jdField_e_of_type_ComTencentAvUiAVActivity.mControlUI.dE(AudioHelper.hG());
      localObject = (RelativeLayout)this.mRootView.findViewById(2131374039);
      jX(true);
      ((RelativeLayout)localObject).setVisibility(0);
      this.Xy = true;
      anot.a(null, "CliOper", "", "", "0X800AA5D", "0X800AA5D", 4, 0, "", "", "", "");
      return;
    } while ((paramInt < 1) || (this.Xx));
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onNetworkQualityChanged. networkQuality = " + paramInt);
    this.jdField_e_of_type_ComTencentAvUiAVActivity.mControlUI.auV();
    this.jdField_e_of_type_ComTencentAvUiAVActivity.mControlUI.dE(AudioHelper.hG());
    Object localObject = (RelativeLayout)this.mRootView.findViewById(2131374039);
    jX(true);
    ((RelativeLayout)localObject).setVisibility(0);
    this.Xx = true;
    anot.a(null, "CliOper", "", "", "0X800AA5D", "0X800AA5D", 3, 0, "", "", "", "");
  }
  
  public void l(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_j_of_type_JavaUtilQueue.size() < 5)
    {
      this.jdField_j_of_type_JavaUtilQueue.offer(Long.valueOf(paramLong2));
      if (this.jdField_j_of_type_JavaUtilQueue.size() != 5) {
        break label238;
      }
      Iterator localIterator = this.jdField_j_of_type_JavaUtilQueue.iterator();
      paramLong1 = 0L;
      label53:
      if (!localIterator.hasNext()) {
        break label118;
      }
      if (((Long)localIterator.next()).longValue() >= jkn.mF()) {
        break label239;
      }
      paramLong1 = 1L + paramLong1;
    }
    label238:
    label239:
    for (;;)
    {
      break label53;
      this.jdField_j_of_type_JavaUtilQueue.poll();
      this.jdField_j_of_type_JavaUtilQueue.offer(Long.valueOf(paramLong2));
      break;
      label118:
      if (paramLong1 >= 4L)
      {
        paramLong2 = System.currentTimeMillis();
        if (paramLong2 - this.oJ > 10000L)
        {
          this.oJ = paramLong2;
          iwu.a(this.jdField_a_of_type_ComTencentAvVideoController.mApp, 1057, acfp.m(2131710323));
          anot.a(null, "CliOper", "", "", "0X800A346", "0X800A346", 0, 0, "", "", "", "");
        }
        if (QLog.isColorLevel()) {
          QLog.w("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameRateInfo frameRate sum/5:=" + paramLong1 / 5L);
        }
      }
      return;
    }
  }
  
  public int lY()
  {
    return this.mCurrentIndex + 1;
  }
  
  public boolean wp()
  {
    return (this.ei != null) && (this.ei.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jci
 * JD-Core Version:    0.7.0.1
 */