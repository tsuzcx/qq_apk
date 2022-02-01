import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleHippyBean;
import com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.14;
import com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.15;
import com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.2;
import com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.9;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.qqcircle.events.QCircleGoToCardSettingEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleSyncToTroopSettingEvent;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class vdr
  extends vbk
  implements aaam, View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean;
  private QCircleTitleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private FeedCloudRead.StGetMainPageRsp jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp;
  private QQCircleFeedBase.StMainPageBusiRspData jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData;
  private vbd jdField_a_of_type_Vbd;
  private vfe jdField_a_of_type_Vfe;
  private vxe jdField_a_of_type_Vxe;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  
  public vdr(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean = paramQCircleInitBean;
    if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean != null) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getUser();
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    label130:
    do
    {
      do
      {
        return;
      } while (uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser));
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.setmCanShowUnfollow(true);
      }
      while (vqn.a().a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()))
      {
        if (!vqn.a().b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get())) {
          break label130;
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.setmCanShowUnfollow(false);
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 1)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      if (paramInt != 2) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.setAlpha(0.0F);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.a(0);
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, bhtq.a(24.0F) }).setDuration(300L);
      localValueAnimator.setStartDelay(150L);
      localValueAnimator.addUpdateListener(new vdz(this));
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L);
      localObjectAnimator1.setStartDelay(150L);
      localObjectAnimator1.addListener(new vea(this));
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
      localObjectAnimator2.addListener(new veb(this));
      localValueAnimator.start();
      localObjectAnimator1.start();
      localObjectAnimator2.start();
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 3, 1, String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get()), "1", "", "", "", c());
    return;
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.getVisibility() == 0)
    {
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) || (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.getVisibility() != 0));
      bool = vqn.a().b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
    } while ((paramBoolean) && (!bool));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { bhtq.a(24.0F), 0 }).setDuration(300L);
    localValueAnimator.addUpdateListener(new vec(this));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L);
    localObjectAnimator2.setStartDelay(150L);
    localObjectAnimator2.addListener(new ved(this));
    localValueAnimator.start();
    localObjectAnimator1.start();
    localObjectAnimator2.start();
  }
  
  private void b(View paramView)
  {
    this.f = ((ImageView)paramView.findViewById(2131373965));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373968));
    this.g = ((ImageView)paramView.findViewById(2131373967));
    this.h = ((ImageView)paramView.findViewById(2131373966));
    if ((vqo.a().c()) && (uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)))
    {
      this.e.setVisibility(0);
      k();
      vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 16, 1, "1", "", "", "", "", c());
      return;
    }
    this.e.setVisibility(8);
    vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 16, 1, "2", "", "", "", "", c());
  }
  
  private void c()
  {
    try
    {
      ImageView localImageView = this.d;
      if ((QzoneConfig.isQQCircleShowInviteGuideBubbleOnProfilePage()) && (localImageView != null) && (uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)))
      {
        Context localContext = localImageView.getContext();
        String str = "key_sp_profile_page_has_show_invite_guide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ("1".equals(bhjc.a(localContext, str)))
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
          ((ImageView)localObject).setImageResource(2130844125);
          localObject = new PopupWindow((View)localObject, -2, -2);
          ((PopupWindow)localObject).setOutsideTouchable(true);
          ((PopupWindow)localObject).setBackgroundDrawable(new ColorDrawable(0));
          int i = localRect.left;
          int j = bhtq.b(10.5F);
          int k = localRect.bottom;
          int m = bhtq.b(3.0F);
          ((PopupWindow)localObject).showAtLocation(localImageView.getRootView(), 0, i - j, k - m);
          bhjc.a(localContext, str, "1");
          ThreadManager.getUIHandler().postDelayed(new QCirclePersonalTitleBarPart.2(this, (PopupWindow)localObject), 5000L);
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
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  private void e()
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
  
  private void f()
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
      localObject = new vbd();
      ((vbd)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = localStFeed;
      this.jdField_a_of_type_Vbd = ((vbd)localObject);
    }
  }
  
  private void g()
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null)
    {
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (!uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label129;
      }
      i = 0;
      localImageView.setVisibility(i);
      if (uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 2, 1, c());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.setUserData(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.nick.get());
      localImageView = this.d;
      if (!uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label135;
      }
    }
    label129:
    label135:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      if (uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label141;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      i = 8;
      break;
    }
    label141:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.get() != null))
    {
      if (this.jdField_a_of_type_Vbd != null)
      {
        this.jdField_a_of_type_Vbd.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Vbd.jdField_b_of_type_Boolean = false;
      }
      b("share_action_show_share_sheet", this.jdField_a_of_type_Vbd);
    }
  }
  
  private void i()
  {
    blir localblir;
    String str;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.get() != null))
    {
      localblir = blir.a(a());
      if (!uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label216;
      }
      str = "";
      localObject = str;
      if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null)
      {
        localObject = str;
        if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo != null)
        {
          str = uyw.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "personalInviteUrl");
          if (TextUtils.isEmpty(str)) {
            break label211;
          }
        }
      }
    }
    label211:
    for (int i = 1;; i = 0)
    {
      localObject = str;
      if (i != 0)
      {
        vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 31, 1);
        localblir.a(2131697246, 0);
        localObject = str;
      }
      localblir.a(2131697355, 0);
      vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 34, 1);
      localblir.a(2131697335, 0);
      localblir.a(2131697334, 0);
      localblir.c(2131690580);
      localblir.a(new vdt(this, localblir, (String)localObject));
      if (!localblir.isShowing()) {
        localblir.show();
      }
      return;
    }
    label216:
    Object localObject = new int[5];
    Object tmp221_220 = localObject;
    tmp221_220[0] = -1;
    Object tmp225_221 = tmp221_220;
    tmp225_221[1] = -1;
    Object tmp229_225 = tmp225_221;
    tmp229_225[2] = -1;
    Object tmp233_229 = tmp229_225;
    tmp233_229[3] = -1;
    Object tmp237_233 = tmp233_229;
    tmp237_233[4] = -1;
    tmp237_233;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 0)) {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.relationState.get() == 0)
      {
        localblir.a("设置特别关注", 0);
        localObject[0] = 1;
        i = 1;
      }
    }
    for (;;)
    {
      int j = i;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 0)
      {
        localblir.a(2131697335, 0);
        localObject[i] = 0;
        j = i + 1;
      }
      localblir.a(2131697329, 0);
      localObject[j] = 3;
      if ((!uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() != 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() != 3))
      {
        localblir.a(2131697167, 0);
        localObject[(j + 1)] = 4;
      }
      localblir.c(2131690580);
      localblir.a(new vdu(this, (int[])localObject, localblir));
      break;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.relationState.get() == 1)
      {
        localblir.a("取消特别关注", 0);
        localObject[0] = 2;
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private void j()
  {
    bhlq.a(a(), 230, null, anzj.a(2131697169), 2131690580, 2131694098, new vdv(this), new vdx(this)).show();
  }
  
  private void k()
  {
    Object localObject = new ColorDrawable(Color.parseColor("#00000000"));
    localObject = vqo.a("https://sola.gtimg.cn/aoi/sola/20200514172111_1pmImmxMtm.png", new int[] { 34 }, (Drawable)localObject, 3);
    this.e.setImageDrawable((Drawable)localObject);
    ObjectAnimator.ofFloat(this.e, "scaleX", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
    ObjectAnimator.ofFloat(this.e, "scaleY", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
    ApngImage.playByTag(34);
    this.e.setVisibility(0);
  }
  
  public String a()
  {
    return "QCirclePersonalTitleBar";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Vxe = ((vxe)a(vxe.class));
    this.jdField_a_of_type_Vxe.a().observe(a(), new vdy(this));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && ((a() instanceof PublicFragmentActivity)) && (((PublicFragmentActivity)a()).getSupportFragmentManager().getFragments() != null))
    {
      BasePartFragment localBasePartFragment = (BasePartFragment)((PublicFragmentActivity)a()).getSupportFragmentManager().getFragments().get(0);
      this.jdField_a_of_type_Vfe = new vfe(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      this.jdField_a_of_type_Vfe.a(localBasePartFragment, paramView, localBasePartFragment.a());
      this.jdField_a_of_type_Vfe.a(paramView);
      this.jdField_a_of_type_Vfe.a(a());
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369411));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369414));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369413));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380145));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView = ((QCircleTitleFollowView)paramView.findViewById(2131380143));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTitleFollowView.setItemReportListener(new vds(this));
    this.d = ((ImageView)paramView.findViewById(2131369416));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131381117);
    this.e = ((ImageView)paramView.findViewById(2131369417));
    d();
    a();
    g();
    b(paramView);
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    localIntent.putExtra("uin", paramString);
    if (a() != null) {
      a().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    int i;
    if (TextUtils.equals(paramString, "personal_page_action_title_bar_animation")) {
      if ((paramObject instanceof Message))
      {
        i = ((Message)paramObject).what;
        this.jdField_a_of_type_AndroidViewView.setAlpha(i);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(i, 3, 8, 26));
        if (uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
          break label88;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (i != 0) {
          break label100;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    label88:
    label100:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
      } while (i != 255);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(255, 3, 8, 26));
      return;
      if (TextUtils.equals(paramString, "personal_page_action_title_bar_follow_animation"))
      {
        a(((Message)paramObject).what);
        return;
      }
    } while (!TextUtils.equals(paramString, "personal_page_action_title_bar_hide_follow_animation"));
    a(true);
  }
  
  public void b()
  {
    vwj.a(new vaw().a("wezone_profile").b("25015").c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()).a());
    vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 8, 0, "", "", "", "", "", c());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFuelAnimationEvent.class);
    localArrayList.add(QCircleGoToCardSettingEvent.class);
    localArrayList.add(QCircleSpecialFollowUpdateEvent.class);
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    aaak.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    aaak.a().b(this);
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_Vfe != null) {
      this.jdField_a_of_type_Vfe.onActivityDestroyed(paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_Vfe != null) {
      this.jdField_a_of_type_Vfe.onActivityResumed(paramActivity);
    }
    ThreadManager.getUIHandler().postDelayed(new QCirclePersonalTitleBarPart.14(this), 500L);
    this.jdField_c_of_type_Boolean = false;
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
      if ((!a().onBackEvent()) && (a() != null))
      {
        a().finish();
        continue;
        if (uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))
        {
          Object localObject = new QCircleInitBean();
          ((QCircleInitBean)localObject).setFromReportBean(a().clone().setElementIdStr("msg"));
          uyx.f(a(), (QCircleInitBean)localObject);
          vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 2, 2, c());
          continue;
          i();
          vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 7, 1, c());
          continue;
          if ((uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) && (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null))
          {
            localObject = uyw.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "TaskCenterUrl");
            uyx.a(a(), new QCircleHippyBean().setModuleName("WeZoneTask").setDefaultUrl((String)localObject));
            if (this.e.getVisibility() == 0)
            {
              vqo.a().b(false);
              this.e.postDelayed(new QCirclePersonalTitleBarPart.9(this), 1500L);
              vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 16, 2, "1", "", "", "", "", c());
            }
            else
            {
              vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 16, 2, "2", "", "", "", "", c());
            }
          }
        }
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFuelAnimationEvent)) {
      if ((uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) && (!this.jdField_c_of_type_Boolean) && (vqo.a().b())) {
        this.d.postDelayed(new QCirclePersonalTitleBarPart.15(this, paramSimpleBaseEvent), 500L);
      }
    }
    label307:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!(paramSimpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent)) {
                    break;
                  }
                } while ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null) || (!this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get().equals(((QCircleSpecialFollowUpdateEvent)paramSimpleBaseEvent).uin)));
                PBUInt32Field localPBUInt32Field = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.relationState;
                if (((QCircleSpecialFollowUpdateEvent)paramSimpleBaseEvent).isFollow) {}
                for (int i = 1;; i = 0)
                {
                  localPBUInt32Field.set(i);
                  return;
                }
                if (!(paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)) {
                  break;
                }
              } while ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null) || (!this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get().equals(((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mUserId)));
              this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mFollowStatus);
              return;
              if ((!(paramSimpleBaseEvent instanceof QCircleGoToCardSettingEvent)) || (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData == null)) {
                break label307;
              }
              if (!((QCircleGoToCardSettingEvent)paramSimpleBaseEvent).mShowCard) {
                break;
              }
            } while ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask == null) || (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get().contains(Integer.valueOf(3))));
            this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get().add(Integer.valueOf(3));
            return;
          } while ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask == null) || (!this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get().contains(Integer.valueOf(3))));
          this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get().remove(Integer.valueOf(3));
          return;
        } while ((!(paramSimpleBaseEvent instanceof QCircleSyncToTroopSettingEvent)) || (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData == null));
        if (!((QCircleSyncToTroopSettingEvent)paramSimpleBaseEvent).mCanSyncTroopARK) {
          break;
        }
      } while ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask == null) || (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get().contains(Integer.valueOf(4))));
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get().add(Integer.valueOf(4));
      return;
    } while ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask == null) || (!this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get().contains(Integer.valueOf(4))));
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get().remove(Integer.valueOf(4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdr
 * JD-Core Version:    0.7.0.1
 */