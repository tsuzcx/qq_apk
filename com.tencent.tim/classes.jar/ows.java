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
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class ows
  extends rxk
  implements View.OnClickListener
{
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private FeedCloudRead.StGetMainPageRsp jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp;
  private ovz jdField_a_of_type_Ovz;
  private oxg jdField_a_of_type_Oxg;
  private pec jdField_a_of_type_Pec;
  private QQCircleFeedBase.StMainPageBusiRspData jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData;
  private ImageView lO;
  private ImageView lP;
  private ImageView lQ;
  private ImageView lR;
  private View nN;
  private TextView vT;
  
  public ows(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = paramQCircleInitBean;
    if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser();
    }
  }
  
  private void bih()
  {
    try
    {
      ImageView localImageView = this.lR;
      if ((QzoneConfig.isQQCircleShowInviteGuideBubbleOnProfilePage()) && (localImageView != null) && (ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)))
      {
        Context localContext = localImageView.getContext();
        String str = "key_sp_profile_page_has_show_invite_guide" + this.app.getCurrentAccountUin();
        if ("1".equals(aqfe.get(localContext, str)))
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
          ((ImageView)localObject).setImageResource(2130844971);
          localObject = new PopupWindow((View)localObject, -2, -2);
          ((PopupWindow)localObject).setOutsideTouchable(true);
          ((PopupWindow)localObject).setBackgroundDrawable(new ColorDrawable(0));
          int i = localRect.left;
          int j = aqnm.dpToPx(10.5F);
          int k = localRect.bottom;
          int m = aqnm.dpToPx(3.0F);
          ((PopupWindow)localObject).showAtLocation(localImageView.getRootView(), 0, i - j, k - m);
          aqfe.J(localContext, str, "1");
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
  
  private void bii()
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
  
  private void bij()
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
      localObject = new ovz();
      ((ovz)localObject).feed = localStFeed;
      this.jdField_a_of_type_Ovz = ((ovz)localObject);
    }
  }
  
  private void bik()
  {
    ovz localovz;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.get() != null)) {
      if (this.jdField_a_of_type_Ovz != null)
      {
        this.jdField_a_of_type_Ovz.type = 1;
        localovz = this.jdField_a_of_type_Ovz;
        if (ovd.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.get())) {
          break label72;
        }
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      localovz.ayK = bool;
      r("share_action_show_share_sheet", this.jdField_a_of_type_Ovz);
      return;
    }
  }
  
  private void bil()
  {
    ausj localausj;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.get() != null))
    {
      localausj = ausj.b(getContext());
      if (!ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label83;
      }
      localausj.addButton(2131700177, 0);
      localausj.addButton(2131700183, 0);
      localausj.addCancelButton(2131721058);
      localausj.a(new owu(this, localausj));
    }
    for (;;)
    {
      if (!localausj.isShowing()) {
        localausj.show();
      }
      return;
      label83:
      localausj.addButton(2131700177, 0);
      localausj.addCancelButton(2131721058);
      localausj.a(new owv(this, localausj));
    }
  }
  
  private void kJ()
  {
    this.lO.setOnClickListener(this);
    this.lP.setOnClickListener(this);
    this.lQ.setOnClickListener(this);
    this.lR.setOnClickListener(this);
  }
  
  private void su()
  {
    int j = 0;
    ImageView localImageView;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null)
    {
      localImageView = this.lP;
      if (!ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label100;
      }
      i = 0;
      localImageView.setVisibility(i);
      if (ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        pco.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 2L, 1L);
      }
      this.vT.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.nick.get());
      localImageView = this.lR;
      if (!ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
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
  
  protected void Rt()
  {
    this.jdField_a_of_type_Pec = ((pec)getViewModel(pec.class));
    this.jdField_a_of_type_Pec.o().observe(b(), new owt(this));
  }
  
  protected void dC(View paramView)
  {
    super.dC(paramView);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && ((getActivity() instanceof PublicFragmentActivity)) && (((PublicFragmentActivity)getActivity()).getSupportFragmentManager().getFragments() != null))
    {
      BasePartFragment localBasePartFragment = (BasePartFragment)((PublicFragmentActivity)getActivity()).getSupportFragmentManager().getFragments().get(0);
      this.jdField_a_of_type_Oxg = new oxg(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      this.jdField_a_of_type_Oxg.a(localBasePartFragment, paramView, localBasePartFragment.a());
      this.jdField_a_of_type_Oxg.dC(paramView);
    }
    this.lO = ((ImageView)paramView.findViewById(2131369930));
    this.lP = ((ImageView)paramView.findViewById(2131369933));
    this.lQ = ((ImageView)paramView.findViewById(2131369932));
    this.vT = ((TextView)paramView.findViewById(2131380979));
    this.lR = ((ImageView)paramView.findViewById(2131369934));
    this.nN = paramView.findViewById(2131381967);
    kJ();
    Rt();
    su();
  }
  
  public String getLogTag()
  {
    return "QCirclePersonalTitleBar";
  }
  
  public void l(String paramString, Object paramObject)
  {
    super.l(paramString, paramObject);
    int i;
    if ((TextUtils.equals(paramString, "personal_page_action_title_bar_animation")) && ((paramObject instanceof Message)))
    {
      i = ((Message)paramObject).what;
      this.nN.setBackgroundColor(Color.argb(i, 235, 236, 240));
      this.vT.setTextColor(Color.argb(i, 3, 8, 26));
      this.vT.setVisibility(0);
      if (i != 0) {
        break label97;
      }
      this.nN.setBackgroundColor(0);
      this.vT.setVisibility(8);
    }
    label97:
    while (i != 255) {
      return;
    }
    this.nN.setBackgroundColor(getActivity().getResources().getColor(2131166508));
    this.vT.setTextColor(Color.argb(255, 3, 8, 26));
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_Oxg != null) {
      this.jdField_a_of_type_Oxg.onActivityDestroyed(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_Oxg != null) {
      this.jdField_a_of_type_Oxg.onActivityResumed(paramActivity);
    }
    ThreadManager.getUIHandler().postDelayed(new QCirclePersonalTitleBarPart.5(this), 500L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!b().onBackEvent()) && (getActivity() != null))
      {
        getActivity().finish();
        continue;
        if (ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))
        {
          oux.s(null);
          pco.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 2L, 2L);
          continue;
          bil();
          pco.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 7L, 1L);
          continue;
          if ((ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) && (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null)) {
            oux.aX(getActivity(), ouw.c(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "TaskCenterUrl"));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ows
 * JD-Core Version:    0.7.0.1
 */