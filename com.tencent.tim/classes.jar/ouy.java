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
import com.tencent.widget.BubblePopupWindow.b;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import mqq.util.WeakReference;

public class ouy
{
  private static volatile ouy a;
  private WeakReference<ouy.a> D;
  private CountDownTimer d;
  private BubblePopupWindow h;
  private boolean mEnable;
  private PopupWindow mPopupWindow;
  
  public static ouy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ouy();
      }
      return a;
    }
    finally {}
  }
  
  public static void releaseInstance()
  {
    a = null;
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, ouy.a parama, BubblePopupWindow.b paramb)
  {
    this.h = new BubblePopupWindow(-2, -2);
    this.D = new WeakReference(parama);
    parama = new aqoa();
    if (ovd.eL(paramStFeed.poster.id.get()))
    {
      if (paramStComment.typeFlag.get() != 0) {
        break label219;
      }
      parama.dV(2131374556, BaseApplicationImpl.getContext().getString(2131700137));
    }
    for (;;)
    {
      parama.dV(2131374553, BaseApplicationImpl.getContext().getString(2131700134));
      if ((ovd.eL(paramStFeed.poster.id.get())) || (ovd.a((FeedCloudMeta.StUser)paramStComment.postUser.get()))) {
        parama.dV(2131374554, BaseApplicationImpl.getContext().getString(2131700135));
      }
      paramStFeed = new ovb(this);
      this.h.setContentView(aqgq.a(this.h, paramView.getContext(), parama, paramStFeed));
      this.h.a(paramb);
      this.h.setBackgroundDrawable(new ColorDrawable(0));
      this.h.setOutsideTouchable(true);
      this.h.setFocusable(true);
      this.h.showAsDropDown(paramView);
      return;
      label219:
      if (paramStComment.typeFlag.get() == 1) {
        parama.dV(2131374552, BaseApplicationImpl.getContext().getString(2131700133));
      }
    }
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StReply paramStReply, ouy.a parama, BubblePopupWindow.b paramb)
  {
    this.h = new BubblePopupWindow(-2, -2);
    this.D = new WeakReference(parama);
    parama = new aqoa();
    parama.dV(2131374553, BaseApplicationImpl.getContext().getString(2131700134));
    if ((ovd.eL(paramStFeed.poster.id.get())) || (ovd.a((FeedCloudMeta.StUser)paramStReply.postUser.get()))) {
      parama.dV(2131374554, BaseApplicationImpl.getContext().getString(2131700135));
    }
    paramStFeed = new ovc(this);
    this.h.setContentView(aqgq.a(this.h, paramView.getContext(), parama, paramStFeed));
    this.h.a(paramb);
    this.h.setBackgroundDrawable(new ColorDrawable(0));
    this.h.setOutsideTouchable(true);
    this.h.setFocusable(true);
    this.h.showAsDropDown(paramView);
  }
  
  public boolean a(Context paramContext, View paramView, String paramString)
  {
    if ((paramContext == null) || (paramView == null)) {
      return false;
    }
    try
    {
      release();
      paramContext = new QCirclePushTipView(paramContext);
      paramContext.setText(paramString);
      paramContext.measure(0, 0);
      int i = paramContext.getMeasuredWidth();
      int j = paramContext.getMeasuredHeight();
      this.mPopupWindow = new PopupWindow(paramContext, -2, -2);
      this.mPopupWindow.setOutsideTouchable(true);
      this.mPopupWindow.setTouchable(true);
      paramContext = new int[2];
      paramView.getLocationOnScreen(paramContext);
      QLog.i("QCirclePopupWindowHelper", 1, "popupWidth" + i + " popupHeight" + j);
      QLog.i("QCirclePopupWindowHelper", 1, "location x:" + paramContext[0] + "    loacation y:" + paramContext[1]);
      int k = paramView.getWidth() / 2;
      this.mPopupWindow.showAtLocation(paramView, 8388661, riw.dip2px(paramView.getContext(), 10.0F), paramContext[1] - j);
      QLog.i("QCirclePopupWindowHelper", 1, "x:" + (paramContext[0] + paramView.getWidth() / 2 - i / 2) + "    y:" + (paramContext[1] - j));
      this.d = new ova(this, 3000L, 3000L);
      this.d.start();
      return true;
    }
    catch (Exception paramContext)
    {
      QLog.e("QCirclePopupWindowHelper", 1, "showRecommendAnimation error" + paramContext.getMessage());
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public void aZ(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      release();
      TextView localTextView = new TextView(paramContext);
      localTextView.setTextColor(paramContext.getResources().getColor(2131167654));
      localTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130844976));
      localTextView.setPadding(riw.dip2px(paramContext, 12.0F), riw.dip2px(paramContext, 8.0F), riw.dip2px(paramContext, 12.0F), riw.dip2px(paramContext, 8.0F));
      localTextView.setText(paramString);
      this.mPopupWindow = new PopupWindow(localTextView, -2, -2);
      this.mPopupWindow.setOutsideTouchable(true);
      this.mPopupWindow.setTouchable(true);
      this.mPopupWindow.showAtLocation(localTextView, 17, 0, 0);
      this.d = new ouz(this, 3000L, 3000L, paramContext);
      this.d.start();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QCirclePopupWindowHelper", 1, "showRecommendAnimation error" + paramContext.getMessage());
      paramContext.printStackTrace();
    }
  }
  
  public void f(Context paramContext, View paramView)
  {
    if ((paramContext == null) || (paramView == null)) {}
    while (!oue.a().Hw()) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QCirclePopupWindowHelper.1(this, paramContext, paramView), 1000L);
  }
  
  public boolean isEnable()
  {
    return this.mEnable;
  }
  
  public void release()
  {
    QLog.d("QCirclePopupWindowHelper", 1, "release");
    if (this.d != null)
    {
      this.d.cancel();
      this.d = null;
    }
    if (this.mPopupWindow != null)
    {
      this.mPopupWindow.dismiss();
      this.mPopupWindow = null;
    }
    if (this.h != null) {
      this.h = null;
    }
    a = null;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void onClick(int paramInt);
  }
  
  public static class b
  {
    public static int bgp = 1;
    public static int bgq = 2;
    public static int bgr = 3;
    public static int bgs = 4;
    public static int bgt = 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouy
 * JD-Core Version:    0.7.0.1
 */