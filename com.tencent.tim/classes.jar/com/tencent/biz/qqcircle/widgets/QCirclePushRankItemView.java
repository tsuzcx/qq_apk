package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import aqmr;
import atau.a;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import org.jetbrains.annotations.NotNull;
import ous;
import ouw;
import pco;
import pgo;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;

public class QCirclePushRankItemView
  extends BaseWidgetView<QQCircleDitto.StItemContainer>
  implements View.OnClickListener
{
  private URLImageView U;
  private URLImageView V;
  private QQCircleDitto.StItemInfo a;
  private int biF = 1;
  private QCircleAvatarView jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private ImageView mj;
  private TextView wA;
  private TextView wB;
  private TextView wC;
  
  public QCirclePushRankItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePushRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePushRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @NotNull
  private FeedCloudMeta.StUser a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(paramStItemInfo.id.get());
    localStUser.followState.set(paramStItemInfo.buttonInfo.buttonValue.get());
    localStUser.nick.set(paramStItemInfo.name.get());
    return localStUser;
  }
  
  protected void a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {}
    while ((paramStItemContainer.items == null) || (paramStItemContainer.items.size() < this.biF)) {
      return;
    }
    this.a = ((QQCircleDitto.StItemInfo)paramStItemContainer.items.get(this.biF - 1));
    FeedCloudMeta.StUser localStUser = a(this.a);
    this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, localStUser);
    this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemPreClickListener(new pgo(this));
    this.wA.setText(localStUser.nick.get());
    if (this.a.des.size() > 0) {
      this.wB.setText((CharSequence)this.a.des.get(0));
    }
    if (this.a.des.size() > 1) {
      this.wC.setText((CharSequence)this.a.des.get(1));
    }
    String str1 = "";
    String str2 = "";
    switch (this.biF)
    {
    default: 
      paramStItemContainer = str2;
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(localStUser);
      ous.a(str1, this.U, new ColorDrawable(getResources().getColor(2131166508)));
      ous.a(paramStItemContainer, this.V, new ColorDrawable(getResources().getColor(2131166508)));
      return;
      switch (paramStItemContainer.containerType.get())
      {
      default: 
        paramStItemContainer = str2;
        break;
      case 1: 
        str1 = "https://sola.gtimg.cn/aoi/sola/20200420161850_TO3juCOD5g.png";
        paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420161850_aASbryezls.png";
        this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844928);
        this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844931);
        this.mj.setImageResource(2130844917);
        break;
      case 2: 
        str1 = "https://sola.gtimg.cn/aoi/sola/20200420162643_ucSiy5BHOR.png";
        paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420162643_jHnc9fLr88.png";
        this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844937);
        this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844936);
        this.mj.setImageResource(2130844920);
        break;
      case 3: 
        str1 = "https://sola.gtimg.cn/aoi/sola/20200423195102_1G9RjstwQG.png";
        paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200423195419_fsnqeCkzil.png";
        this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844934);
        this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844936);
        this.mj.setImageResource(2130844923);
        break;
      case 4: 
        str1 = "https://sola.gtimg.cn/aoi/sola/20200420164706_MAybOSOV4Z.png";
        paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420164706_EHkNzcztIK.png";
        this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844930);
        this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844933);
        this.mj.setImageResource(2130844926);
        continue;
        switch (paramStItemContainer.containerType.get())
        {
        default: 
          paramStItemContainer = str2;
          break;
        case 1: 
          str1 = "https://sola.gtimg.cn/aoi/sola/20200420162145_qGlonPe51i.png";
          paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420162145_cs8bXfoj7T.png";
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844929);
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844932);
          this.mj.setImageResource(2130844916);
          break;
        case 2: 
          str1 = "https://sola.gtimg.cn/aoi/sola/20200420162843_LL2oCfCZxQ.png";
          paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420162843_g63ANBxN1I.png";
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844937);
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844936);
          this.mj.setImageResource(2130844919);
          break;
        case 3: 
          str1 = "https://sola.gtimg.cn/aoi/sola/20200423195138_ZpWFx9ROhf.png";
          paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200423195352_8klmXhkiTV.png";
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844928);
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844931);
          this.mj.setImageResource(2130844922);
          break;
        case 4: 
          str1 = "https://sola.gtimg.cn/aoi/sola/20200420164927_WYcCVHrfQU.png";
          paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420164927_b4UUDZex19.png";
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844821);
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844822);
          this.mj.setImageResource(2130844925);
          continue;
          switch (paramStItemContainer.containerType.get())
          {
          default: 
            paramStItemContainer = str2;
            break;
          case 1: 
            str1 = "https://sola.gtimg.cn/aoi/sola/20200420162433_l3SFpIS75O.png";
            paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420162432_U1cpuRvxFL.png";
            this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844930);
            this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844933);
            this.mj.setImageResource(2130844918);
            break;
          case 2: 
            str1 = "https://sola.gtimg.cn/aoi/sola/20200420163559_FeOrK0i9Ig.png";
            paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420163559_dMjJxScsSR.png";
            this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844938);
            this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844936);
            this.mj.setImageResource(2130844921);
            break;
          case 3: 
            str1 = "https://sola.gtimg.cn/aoi/sola/20200423195211_Cj6JbErN8S.png";
            paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200423195440_afxmpzcS18.png";
            this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844935);
            this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844934);
            this.mj.setImageResource(2130844924);
            break;
          case 4: 
            str1 = "https://sola.gtimg.cn/aoi/sola/20200420165139_1uThGkBHzb.png";
            paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420165139_JeRAYOTHqy.png";
            this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844939);
            this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844933);
            this.mj.setImageResource(2130844927);
          }
          break;
        }
        break;
      }
    }
  }
  
  public void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.e(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.ru);
    if (paramContext != null)
    {
      this.biF = paramContext.getInt(0, 1);
      paramContext.recycle();
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.U = ((URLImageView)paramView.findViewById(2131369923));
    this.V = ((URLImageView)paramView.findViewById(2131374584));
    this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373921));
    this.wA = ((TextView)paramView.findViewById(2131380820));
    this.wB = ((TextView)paramView.findViewById(2131380858));
    this.wC = ((TextView)paramView.findViewById(2131380859));
    this.mj = ((ImageView)paramView.findViewById(2131374585));
    this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131374645));
    this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    setOnClickListener(this);
    this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
  }
  
  public int getLayoutId()
  {
    return 2131560943;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      String str = ouw.c(this.a.urlInfo.get(), "RankItemUrl");
      if (aqmr.isEmpty(str)) {
        QLog.w("QCirclePushRankItemView", 1, "rank item url is empty");
      }
      Intent localIntent = new Intent(getContext(), JumpActivity.class);
      localIntent.setData(Uri.parse(str));
      getContext().startActivity(localIntent);
      if (getData() != null) {
        pco.a("", 9, 2L, 0L, ((QQCircleDitto.StItemContainer)getData()).containerType + "", "", "", "", "");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setRank(int paramInt)
  {
    this.biF = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankItemView
 * JD-Core Version:    0.7.0.1
 */