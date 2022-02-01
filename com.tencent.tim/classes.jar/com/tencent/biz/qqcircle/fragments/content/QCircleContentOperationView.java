package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import aqmr;
import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;
import oux;
import ovd;
import oyu;
import pam;
import paw;
import pax;
import pay;
import paz;
import pba;
import pbb;
import pcp;
import pcr;

public class QCircleContentOperationView
  extends BaseWidgetView<FeedCloudMeta.StFeed>
{
  public static int bgR = -1;
  public QCircleDoublePraiseView a;
  protected QCircleExpandableTextView a;
  protected TagFlowLayout a;
  private pam a;
  private final Rect aC = new Rect();
  private String arV;
  private String arW;
  private FrameLayout az;
  protected QCircleCommentBottomBar b;
  protected QCircleAvatarView b;
  protected QCircleFollowView b;
  public QCircleRockeyPopupView b;
  public int bgS;
  public SquareImageView d;
  public LinearLayout eF;
  public SeekBar mSeekBar;
  private View nP;
  protected TextView wf;
  protected TextView wg;
  protected TextView wh;
  public TextView wi;
  public TextView wj;
  public TextView wk;
  private TextView wl;
  
  public QCircleContentOperationView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void biY()
  {
    if ((!isCollapsed()) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(((FeedCloudMeta.StFeed)getData()).content.get(), false);
    }
  }
  
  private void g(FeedCloudMeta.StFeed paramStFeed)
  {
    int i = 0;
    if (paramStFeed == null) {
      return;
    }
    label36:
    int j;
    switch (paramStFeed.type.get())
    {
    default: 
      j = 0;
    }
    while ((i > 0) && (j > 0))
    {
      int k = ImmersiveUtils.getScreenWidth();
      float f = k / j;
      i = (int)(i * f);
      paramStFeed = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.getLayoutParams();
      paramStFeed.width = k;
      paramStFeed.height = i;
      paramStFeed.gravity = 17;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setLayoutParams(paramStFeed);
      return;
      if ((this.bgS < 0) || (this.bgS >= paramStFeed.images.size())) {
        break label36;
      }
      paramStFeed = (FeedCloudMeta.StImage)((FeedCloudMeta.StImage)paramStFeed.images.get(this.bgS)).get();
      j = paramStFeed.width.get();
      i = paramStFeed.height.get();
      continue;
      j = paramStFeed.cover.width.get();
      i = paramStFeed.cover.height.get();
    }
  }
  
  private void kJ()
  {
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(new paw(this));
    this.wg.setOnClickListener(new pax(this));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemPreClickListener(new pay(this));
    paz localpaz = new paz(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setListener(new pba(this, localpaz));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.x().setOnClickListener(localpaz);
    this.wl.setOnClickListener(new pbb(this));
  }
  
  private void vo(int paramInt)
  {
    if ((getData() != null) && (((FeedCloudMeta.StFeed)getData()).poster.get() != null))
    {
      oux.qm(((FeedCloudMeta.StFeed)getData()).poster.id.get());
      pcp.b(paramInt, 2, a());
    }
  }
  
  public boolean B(MotionEvent paramMotionEvent)
  {
    if (this.az != null)
    {
      this.az.getGlobalVisibleRect(this.aC);
      return this.aC.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  public ReportExtraTypeInfo a()
  {
    ReportExtraTypeInfo localReportExtraTypeInfo = new ReportExtraTypeInfo();
    localReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)getData());
    localReportExtraTypeInfo.mDataPosition = getDataPosInList();
    localReportExtraTypeInfo.mPlayScene = 2;
    return localReportExtraTypeInfo;
  }
  
  public void biZ()
  {
    if (this.wi != null) {
      this.wi.setVisibility(8);
    }
    if ((this.az != null) && (this.az.getVisibility() == 8)) {
      this.az.setVisibility(0);
    }
  }
  
  protected void c(FeedCloudMeta.StFeed paramStFeed)
  {
    int j = 8;
    if (paramStFeed == null) {}
    label513:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if (this.wf != null)
      {
        localObject = this.wf;
        if (aqmr.isEmpty(paramStFeed.recomForward.poster.nick.get()))
        {
          i = 8;
          ((TextView)localObject).setVisibility(i);
          this.wf.setText(paramStFeed.recomForward.poster.nick.get());
        }
      }
      else
      {
        if (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView != null) {
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, paramStFeed.poster);
        }
        if (this.wg != null) {
          this.wg.setText(paramStFeed.poster.nick.get());
        }
        if (this.wh != null) {
          this.wh.setText(String.format("%s %s", new Object[] { ovd.aC(paramStFeed.createTime.get() * 1000L), paramStFeed.poiInfo.defaultName.get() }));
        }
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView;
          if (!aqmr.isEmpty(paramStFeed.content.get().trim())) {
            break label483;
          }
          i = 8;
          label207:
          ((QCircleExpandableTextView)localObject).setVisibility(i);
          ((AsyncRichTextView)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.x()).bxX();
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(paramStFeed.content.get());
        }
        if (this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null)
        {
          this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setExtraTypeInfo(a());
          this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setInteractor(getInteractor());
          this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setData(paramStFeed);
        }
        if (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView != null) {
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStFeed.poster);
        }
        if (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView != null)
        {
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setFeedId(paramStFeed.id.get());
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setPageType(2);
        }
        if (this.nP != null)
        {
          localObject = new ExtraTypeInfo();
          if ((paramStFeed.tagInfos.size() <= 0) || (((ExtraTypeInfo)localObject).sourceType == 7)) {
            break label488;
          }
          this.jdField_a_of_type_Pam.e(paramStFeed);
          this.jdField_a_of_type_Pam.notifyDataSetChanged();
          if (this.wl != null)
          {
            localObject = this.wl;
            i = j;
            if (this.jdField_a_of_type_Pam.isFold()) {
              i = 0;
            }
            ((TextView)localObject).setVisibility(i);
          }
          this.nP.setVisibility(0);
        }
        label416:
        switch (paramStFeed.type.get())
        {
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView == null) {
          break label513;
        }
        g(paramStFeed);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setFeed(paramStFeed);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setPageType(pcr.a().getPageId());
        return;
        i = 0;
        break;
        label483:
        i = 0;
        break label207;
        label488:
        this.nP.setVisibility(8);
        break label416;
        h(paramStFeed);
        continue;
        biZ();
      }
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView = ((QCircleRockeyPopupView)paramView.findViewById(2131374593));
    this.wf = ((TextView)paramView.findViewById(2131380993));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369945));
    this.wg = ((TextView)paramView.findViewById(2131381015));
    this.wh = ((TextView)paramView.findViewById(2131381017));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131367354));
    this.arV = getResources().getString(2131700091);
    this.arW = getResources().getString(2131700086);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView = ((QCircleExpandableTextView)paramView.findViewById(2131374605));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.x().setMovementMethod(ScrollingMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.w().setTextColor(Color.parseColor("#435A7A"));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131370748));
    this.wl = ((TextView)paramView.findViewById(2131380686));
    this.jdField_a_of_type_Pam = new pam(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_Pam);
    this.nP = paramView.findViewById(2131370747);
    this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar = ((QCircleCommentBottomBar)paramView.findViewById(2131364371));
    this.wi = ((TextView)paramView.findViewById(2131380639));
    this.d = ((SquareImageView)paramView.findViewById(2131369836));
    this.wj = ((TextView)paramView.findViewById(2131380638));
    this.wk = ((TextView)paramView.findViewById(2131380991));
    this.eF = ((LinearLayout)paramView.findViewById(2131370754));
    this.mSeekBar = ((SeekBar)paramView.findViewById(2131377919));
    this.az = ((FrameLayout)paramView.findViewById(2131367196));
    this.mSeekBar.post(new QCircleContentOperationView.1(this));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(true);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844760);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setPageType(2);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView = ((QCircleDoublePraiseView)paramView.findViewById(2131374510));
    kJ();
  }
  
  public int getLayoutId()
  {
    return 2131560886;
  }
  
  public void h(FeedCloudMeta.StFeed paramStFeed)
  {
    int i = 8;
    if (this.d != null) {
      this.d.setVisibility(8);
    }
    if (this.az != null) {
      this.az.setVisibility(8);
    }
    if (this.eF != null) {
      this.eF.setVisibility(8);
    }
    if (this.wi != null)
    {
      TextView localTextView = this.wi;
      if (paramStFeed.images.size() > 1) {
        i = 0;
      }
      localTextView.setVisibility(i);
      setCurPicPos(0, paramStFeed.images.size());
    }
  }
  
  public boolean isCollapsed()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.isCollapsed();
    }
    return false;
  }
  
  public boolean onBackEvent()
  {
    return (this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) && (this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.onBackPressed());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void release()
  {
    super.release();
    if (this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) {
      this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.release();
    }
  }
  
  public void reset()
  {
    if ((this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) && (this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.b() != null)) {
      this.jdField_b_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.b().rl(false);
    }
    this.bgS = 0;
    biY();
    if ((this.jdField_a_of_type_Pam != null) && (!this.jdField_a_of_type_Pam.isFold())) {
      this.jdField_a_of_type_Pam.rZ();
    }
    if (this.wl != null) {
      this.wl.setText(this.arW);
    }
  }
  
  public void setCurPicPos(int paramInt1, int paramInt2)
  {
    if (this.wi != null)
    {
      if (bgR <= 0) {
        break label61;
      }
      this.bgS = bgR;
      bgR = -1;
    }
    for (;;)
    {
      this.wi.setText(String.format("%s/%s", new Object[] { Integer.valueOf(this.bgS + 1), Integer.valueOf(paramInt2) }));
      return;
      label61:
      this.bgS = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView
 * JD-Core Version:    0.7.0.1
 */