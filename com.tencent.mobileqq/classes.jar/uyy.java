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

public class uyy
{
  private static volatile uyy jdField_a_of_type_Uyy;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private WeakReference<uze> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public static uyy a()
  {
    if (jdField_a_of_type_Uyy == null) {}
    try
    {
      if (jdField_a_of_type_Uyy == null) {
        jdField_a_of_type_Uyy = new uyy();
      }
      return jdField_a_of_type_Uyy;
    }
    finally {}
  }
  
  public static void b()
  {
    jdField_a_of_type_Uyy = null;
  }
  
  public void a()
  {
    QLog.d("QCirclePopupWindowHelper", 1, "release");
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
    jdField_a_of_type_Uyy = null;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if ((paramContext == null) || (paramView == null)) {}
    while (!uyk.a().f()) {
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
      localTextView.setTextColor(paramContext.getResources().getColor(2131167302));
      localTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130844127));
      localTextView.setPadding(zft.b(paramContext, 12.0F), zft.b(paramContext, 8.0F), zft.b(paramContext, 12.0F), zft.b(paramContext, 8.0F));
      localTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localTextView, -2, -2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(localTextView, 17, 0, 0);
      this.jdField_a_of_type_AndroidOsCountDownTimer = new uyz(this, 3000L, 3000L, paramContext);
      this.jdField_a_of_type_AndroidOsCountDownTimer.start();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QCirclePopupWindowHelper", 1, "showRecommendAnimation error" + paramContext.getMessage());
      paramContext.printStackTrace();
    }
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, uze paramuze, blkc paramblkc)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramuze);
    paramuze = new bhuk();
    if (uzg.a(paramStFeed.poster.id.get()))
    {
      if (paramStComment.typeFlag.get() == 0) {
        paramuze.a(2131373989, BaseApplicationImpl.getContext().getString(2131697257));
      }
    }
    else
    {
      paramuze.a(2131373986, BaseApplicationImpl.getContext().getString(2131697254));
      if ((!uzg.a(paramStFeed.poster.id.get())) && (!uzg.a((FeedCloudMeta.StUser)paramStComment.postUser.get()))) {
        break label252;
      }
      paramuze.a(2131373987, BaseApplicationImpl.getContext().getString(2131697255));
    }
    for (;;)
    {
      paramStFeed = new uzc(this);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bhkx.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), paramuze, paramStFeed));
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(paramblkc);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(true);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(paramView);
      return;
      if (paramStComment.typeFlag.get() != 1) {
        break;
      }
      paramuze.a(2131373985, BaseApplicationImpl.getContext().getString(2131697253));
      break;
      label252:
      paramuze.a(2131373988, BaseApplicationImpl.getContext().getString(2131697256));
    }
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StReply paramStReply, uze paramuze, blkc paramblkc)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramuze);
    paramuze = new bhuk();
    paramuze.a(2131373986, BaseApplicationImpl.getContext().getString(2131697254));
    if ((uzg.a(paramStFeed.poster.id.get())) || (uzg.a((FeedCloudMeta.StUser)paramStReply.postUser.get()))) {
      paramuze.a(2131373987, BaseApplicationImpl.getContext().getString(2131697255));
    }
    for (;;)
    {
      paramStFeed = new uzd(this);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bhkx.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), paramuze, paramStFeed));
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(paramblkc);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(true);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(paramView);
      return;
      paramuze.a(2131373988, BaseApplicationImpl.getContext().getString(2131697256));
    }
  }
  
  public void a(View paramView, uze paramuze, blkc paramblkc)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramuze);
    paramuze = new bhuk();
    paramuze.a(2131373986, BaseApplicationImpl.getContext().getString(2131697254));
    uzb localuzb = new uzb(this);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bhkx.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), paramuze, localuzb));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(paramblkc);
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
      QLog.i("QCirclePopupWindowHelper", 1, "popupWidth" + i + " popupHeight" + j);
      QLog.i("QCirclePopupWindowHelper", 1, "location x:" + paramContext[0] + "    loacation y:" + paramContext[1]);
      int k = paramView.getWidth() / 2;
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 8388661, zft.b(paramView.getContext(), 10.0F), paramContext[1] - j);
      QLog.i("QCirclePopupWindowHelper", 1, "x:" + (paramContext[0] + paramView.getWidth() / 2 - i / 2) + "    y:" + (paramContext[1] - j));
      this.jdField_a_of_type_AndroidOsCountDownTimer = new uza(this, 3000L, 3000L);
      this.jdField_a_of_type_AndroidOsCountDownTimer.start();
      return true;
    }
    catch (Exception paramContext)
    {
      QLog.e("QCirclePopupWindowHelper", 1, "showRecommendAnimation error" + paramContext.getMessage());
      paramContext.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyy
 * JD-Core Version:    0.7.0.1
 */