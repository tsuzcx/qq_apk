import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper.1;
import com.tencent.biz.qqcircle.widgets.QCirclePushTipView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import mqq.util.WeakReference;

public class tqt
{
  private static final String jdField_a_of_type_JavaLangString = tqt.class.getSimpleName();
  private static volatile tqt jdField_a_of_type_Tqt;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private WeakReference<tqy> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public static tqt a()
  {
    if (jdField_a_of_type_Tqt == null) {}
    try
    {
      if (jdField_a_of_type_Tqt == null) {
        jdField_a_of_type_Tqt = new tqt();
      }
      return jdField_a_of_type_Tqt;
    }
    finally {}
  }
  
  public static void b()
  {
    jdField_a_of_type_Tqt = null;
  }
  
  public void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "release");
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    jdField_a_of_type_Tqt = null;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if ((paramContext == null) || (paramView == null)) {}
    while (!tpz.a().c()) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QCirclePopupWindowHelper.1(this, paramContext, paramView), 1000L);
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      a();
      TextView localTextView = new TextView(paramContext);
      localTextView.setTextColor(paramContext.getResources().getColor(2131167192));
      localTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130843681));
      localTextView.setPadding(xee.b(paramContext, 12.0F), xee.b(paramContext, 8.0F), xee.b(paramContext, 12.0F), xee.b(paramContext, 8.0F));
      localTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localTextView, -2, -2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(localTextView, 17, 0, 0);
      this.jdField_a_of_type_AndroidOsCountDownTimer = new tqu(this, 3000L, 3000L);
      this.jdField_a_of_type_AndroidOsCountDownTimer.start();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "showRecommendAnimation error" + paramContext.getMessage());
      paramContext.printStackTrace();
    }
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, tqy paramtqy, bhrf parambhrf)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramtqy);
    paramtqy = new bdkz();
    if (tra.a(paramStFeed.poster.id.get()))
    {
      if (paramStComment.typeFlag.get() != 0) {
        break label221;
      }
      paramtqy.a(2131373169, BaseApplicationImpl.getContext().getString(2131698338));
    }
    for (;;)
    {
      paramtqy.a(2131373166, BaseApplicationImpl.getContext().getString(2131698335));
      if ((tra.a(paramStFeed.poster.id.get())) || (tra.a((FeedCloudMeta.StUser)paramStComment.postUser.get()))) {
        paramtqy.a(2131373167, BaseApplicationImpl.getContext().getString(2131698336));
      }
      paramStFeed = new tqw(this);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bdbk.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), paramtqy, paramStFeed));
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(parambhrf);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(true);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(paramView);
      return;
      label221:
      if (paramStComment.typeFlag.get() == 1) {
        paramtqy.a(2131373165, BaseApplicationImpl.getContext().getString(2131698334));
      }
    }
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StReply paramStReply, tqy paramtqy, bhrf parambhrf)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramtqy);
    paramtqy = new bdkz();
    paramtqy.a(2131373166, BaseApplicationImpl.getContext().getString(2131698335));
    if ((tra.a(paramStFeed.poster.id.get())) || (tra.a((FeedCloudMeta.StUser)paramStReply.postUser.get()))) {
      paramtqy.a(2131373167, BaseApplicationImpl.getContext().getString(2131698336));
    }
    paramStFeed = new tqx(this);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bdbk.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), paramtqy, paramStFeed));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(parambhrf);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(true);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(paramView);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Context paramContext, View paramView, String paramString)
  {
    if ((paramContext == null) || (paramView == null)) {
      return false;
    }
    try
    {
      a();
      paramContext = new QCirclePushTipView(paramContext);
      paramContext.setText(paramString);
      paramContext.measure(0, 0);
      int i = paramContext.getMeasuredWidth();
      int j = paramContext.getMeasuredHeight();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramContext, -2, -2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
      paramContext = new int[2];
      paramView.getLocationOnScreen(paramContext);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "popupWidth" + i + " popupHeight" + j);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "location x:" + paramContext[0] + "    loacation y:" + paramContext[1]);
      int k = paramView.getWidth() / 2;
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 8388661, xee.b(paramView.getContext(), 10.0F), paramContext[1] - j);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "x:" + (paramContext[0] + paramView.getWidth() / 2 - i / 2) + "    y:" + (paramContext[1] - j));
      this.jdField_a_of_type_AndroidOsCountDownTimer = new tqv(this, 3000L, 3000L);
      this.jdField_a_of_type_AndroidOsCountDownTimer.start();
      return true;
    }
    catch (Exception paramContext)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "showRecommendAnimation error" + paramContext.getMessage());
      paramContext.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqt
 * JD-Core Version:    0.7.0.1
 */