import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.1;
import com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.5;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class tss
  extends tvv
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private FeedCloudRead.StGetMainPageRsp jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp;
  private QQCircleFeedBase.StMainPageBusiRspData jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData;
  private trz jdField_a_of_type_Trz;
  private ttk jdField_a_of_type_Ttk;
  private ubq jdField_a_of_type_Ubq;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public tss(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = paramQCircleInitBean;
    if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser();
    }
  }
  
  private void b()
  {
    try
    {
      ImageView localImageView = this.d;
      if ((QzoneConfig.isQQCircleShowInviteGuideBubbleOnProfilePage()) && (localImageView != null) && (tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)))
      {
        Context localContext = localImageView.getContext();
        String str = "key_sp_profile_page_has_show_invite_guide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ("1".equals(bdea.a(localContext, str)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCirclePersonalTitleBar", 1, "no need showInviteGuideBubble");
          }
        }
        else
        {
          Rect localRect = new Rect();
          localImageView.getGlobalVisibleRect(localRect);
          Object localObject = new ImageView(localContext);
          ((ImageView)localObject).setImageResource(2130843746);
          localObject = new PopupWindow((View)localObject, -2, -2);
          ((PopupWindow)localObject).setOutsideTouchable(true);
          ((PopupWindow)localObject).setBackgroundDrawable(new ColorDrawable(0));
          int i = localRect.left;
          int j = bdoo.b(10.5F);
          int k = localRect.bottom;
          int m = bdoo.b(3.0F);
          ((PopupWindow)localObject).showAtLocation(localImageView.getRootView(), 0, i - j, k - m);
          bdea.a(localContext, str, "1");
          ThreadManager.getUIHandler().postDelayed(new QCirclePersonalTitleBarPart.1(this, (PopupWindow)localObject), 5000L);
          if (QLog.isColorLevel())
          {
            QLog.d("QCirclePersonalTitleBar", 1, "showingInviteGuideBubble");
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCirclePersonalTitleBar", 2, "tryShowingInviteGuideBubble error! ", localThrowable);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  private void d()
  {
    QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData;
    if (this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.busiRspData.get() != null) {
      localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
    }
    try
    {
      localStMainPageBusiRspData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.busiRspData.get().toByteArray());
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData = localStMainPageBusiRspData;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCirclePersonalTitleBar", 1, "mergeFrom stMainPageBusiRspData error");
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.user != null) && (this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.share != null))
    {
      FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
      Object localObject = new FeedCloudMeta.StUser();
      FeedCloudMeta.StShare localStShare = new FeedCloudMeta.StShare();
      ((FeedCloudMeta.StUser)localObject).set(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.user);
      localStShare.set(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.share);
      localStFeed.poster = ((FeedCloudMeta.StUser)localObject);
      localStFeed.share = localStShare;
      localObject = new trz();
      ((trz)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = localStFeed;
      this.jdField_a_of_type_Trz = ((trz)localObject);
    }
  }
  
  private void f()
  {
    int j = 0;
    ImageView localImageView;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null)
    {
      localImageView = this.b;
      if (!tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label100;
      }
      i = 0;
      localImageView.setVisibility(i);
      if (tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        tzv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 2L, 1L);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.nick.get());
      localImageView = this.d;
      if (!tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label106;
      }
    }
    label100:
    label106:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  private void g()
  {
    trz localtrz;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.get() != null)) {
      if (this.jdField_a_of_type_Trz != null)
      {
        this.jdField_a_of_type_Trz.jdField_a_of_type_Int = 1;
        localtrz = this.jdField_a_of_type_Trz;
        if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.get())) {
          break label72;
        }
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      localtrz.c = bool;
      b("share_action_show_share_sheet", this.jdField_a_of_type_Trz);
      return;
    }
  }
  
  private void h()
  {
    bhuf localbhuf;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.get() != null))
    {
      localbhuf = bhuf.a(a());
      if (!tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label83;
      }
      localbhuf.a(2131698386, 0);
      localbhuf.a(2131698392, 0);
      localbhuf.c(2131690648);
      localbhuf.a(new tsu(this, localbhuf));
    }
    for (;;)
    {
      if (!localbhuf.isShowing()) {
        localbhuf.show();
      }
      return;
      label83:
      localbhuf.a(2131698386, 0);
      localbhuf.c(2131690648);
      localbhuf.a(new tsv(this, localbhuf));
    }
  }
  
  public String a()
  {
    return "QCirclePersonalTitleBar";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Ubq = ((ubq)a(ubq.class));
    this.jdField_a_of_type_Ubq.a().observe(a(), new tst(this));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && ((a() instanceof PublicFragmentActivity)) && (((PublicFragmentActivity)a()).getSupportFragmentManager().getFragments() != null))
    {
      ComponentBaseFragment localComponentBaseFragment = (ComponentBaseFragment)((PublicFragmentActivity)a()).getSupportFragmentManager().getFragments().get(0);
      this.jdField_a_of_type_Ttk = new ttk(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      this.jdField_a_of_type_Ttk.a(localComponentBaseFragment, paramView, localComponentBaseFragment.a());
      this.jdField_a_of_type_Ttk.a(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368945));
    this.b = ((ImageView)paramView.findViewById(2131368948));
    this.c = ((ImageView)paramView.findViewById(2131368947));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379046));
    this.d = ((ImageView)paramView.findViewById(2131368949));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379978);
    c();
    a();
    f();
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    int i;
    if ((TextUtils.equals(paramString, "personal_page_action_title_bar_animation")) && ((paramObject instanceof Message)))
    {
      i = ((Message)paramObject).what;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(i, 235, 236, 240));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(i, 3, 8, 26));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (i != 0) {
        break label97;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label97:
    while (i != 255) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(a().getResources().getColor(2131166178));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(255, 3, 8, 26));
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_Ttk != null) {
      this.jdField_a_of_type_Ttk.onActivityDestroyed(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_Ttk != null) {
      this.jdField_a_of_type_Ttk.onActivityResumed(paramActivity);
    }
    ThreadManager.getUIHandler().postDelayed(new QCirclePersonalTitleBarPart.5(this), 500L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((a().onBackEvent()) || (a() == null));
        a().finish();
        return;
      } while (!tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser));
      tqs.c(null);
      tzv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 2L, 2L);
      return;
      h();
      tzv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 7L, 1L);
      return;
    } while ((!tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) || (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData == null));
    tqs.a(a(), tqr.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "TaskCenterUrl"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tss
 * JD-Core Version:    0.7.0.1
 */