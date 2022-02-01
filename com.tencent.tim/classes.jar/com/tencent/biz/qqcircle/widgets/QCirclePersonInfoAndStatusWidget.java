package com.tencent.biz.qqcircle.widgets;

import acff;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqgv;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
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
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import ouw;
import oux;
import ovd;
import pco;
import pgb;
import pgc;
import phg;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;
import ram;
import rwv;
import rwx;

public class QCirclePersonInfoAndStatusWidget
  extends BaseWidgetView
  implements View.OnClickListener, rwx
{
  private a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget$a;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private FeedCloudRead.StGetMainPageRsp jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp;
  private phg jdField_a_of_type_Phg;
  private QQCircleFeedBase.StMainPageBusiRspData jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData;
  private AsyncRichTextView b;
  private int bis;
  private QCircleAvatarView jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private LinearLayout eK;
  private LinearLayout eL;
  private LinearLayout eM;
  private LinearLayout eN;
  private List<QQCircleBase.UserCircleInfo> lD;
  private List<QQCircleBase.UserCircleInfo> lE;
  private QQAppInterface mApp;
  private Context mContext;
  private int mFollowNum;
  private ImageView mg;
  private View nS;
  private TextView wt;
  private TextView wu;
  private TextView wv;
  private TextView ww;
  private TextView wx;
  private TextView wy;
  private TextView wz;
  private long zO;
  
  public QCirclePersonInfoAndStatusWidget(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.mContext = paramContext;
    this.mApp = ((BaseActivity)paramContext).app;
  }
  
  private void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    paramSpannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(2131166517)), paramInt1, paramInt2, 17);
  }
  
  private void a(SpannableString paramSpannableString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramSpannableString.setSpan(new pgc(this, paramInt3), paramInt1, paramInt2, 33);
      return;
    }
    catch (Exception paramSpannableString)
    {
      QLog.e("QCirclePersonInfoAndStatusWidget", 1, "addClickReport error" + paramSpannableString.getMessage());
      paramSpannableString.printStackTrace();
    }
  }
  
  private void a(FeedCloudMeta.StUser paramStUser, QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    if ((paramStUser != null) && (paramStUser.get() != null))
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "nickName is" + paramStUser.nick.get());
      this.wt.setText(paramStUser.nick.get());
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.mApp, paramStUser);
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAuthDrawable(2130844754);
      if (!TextUtils.isEmpty(paramStUser.desc.get())) {
        break label546;
      }
      this.b.setVisibility(8);
      if ((!ovd.a(paramStUser)) && (paramStMainPageBusiRspData != null)) {
        break label571;
      }
      this.eK.setVisibility(8);
      if (!ovd.c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label724;
      }
      this.mg.setVisibility(0);
    }
    for (;;)
    {
      label137:
      StringBuilder localStringBuilder;
      int i1;
      int i2;
      int i3;
      int i4;
      int k;
      int n;
      int m;
      try
      {
        localStringBuilder = new StringBuilder();
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i = 0;
        k = i;
        Object localObject;
        if (!TextUtils.isEmpty(paramStUser.location.get()))
        {
          localObject = fK(paramStUser.location.get());
          k = i;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            k = ((String)localObject).length();
            localStringBuilder.append((String)localObject);
          }
        }
        if (paramStUser.busiData.get() != null)
        {
          localObject = new QQCircleBase.StUserBusiData();
          ((QQCircleBase.StUserBusiData)localObject).mergeFrom(paramStUser.busiData.get().toByteArray());
          this.lD = new ArrayList();
          this.lE = ((QQCircleBase.StUserBusiData)localObject).schoolInfos.get();
          n = i4;
          m = i3;
          j = i2;
          i = i1;
          if (this.lE != null)
          {
            n = i4;
            m = i3;
            j = i2;
            i = i1;
            if (this.lE.size() > 0)
            {
              QLog.d("QCirclePersonInfoAndStatusWidget", 1, "mSchoolCircleInfos size:" + this.lE.size());
              if (localStringBuilder.length() == 0) {
                break label935;
              }
              j = localStringBuilder.length();
              i = j + " | ".length();
              localStringBuilder.append(" | ");
              this.lD.addAll(this.lE);
              i1 = 1;
              paramStUser = this.lE.iterator();
              if (paramStUser.hasNext())
              {
                localStringBuilder.append(((QQCircleBase.UserCircleInfo)paramStUser.next()).name.get()).append(" ");
                continue;
                if (paramStMainPageBusiRspData == null) {
                  break label916;
                }
              }
            }
          }
        }
      }
      catch (Exception paramStUser)
      {
        QLog.e("QCirclePersonInfoAndStatusWidget", 1, "parseLocationOrAuth error" + paramStUser.getMessage());
      }
      for (;;)
      {
        if (paramStMainPageBusiRspData.recomTagList.get().size() > 0)
        {
          this.jdField_a_of_type_Phg.a(paramStMainPageBusiRspData, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
          this.nS.setVisibility(0);
          if (ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))
          {
            this.wx.setText(2131700115);
            return;
            label546:
            this.b.setVisibility(0);
            this.b.setText(paramStUser.desc.get());
            break;
            label571:
            this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new pgb(this));
            boolean bool = ovd.w(paramStMainPageBusiRspData.opMask.get());
            QLog.d("QCirclePersonInfoAndStatusWidget", 1, "isShowChatEntrance" + bool);
            if ((ovd.H(this.mContext, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get())) || (bool))
            {
              this.wy.setVisibility(0);
              rx(false);
              pco.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 4L, 1L);
            }
            for (;;)
            {
              this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)paramStUser.get());
              this.eK.setVisibility(0);
              break;
              this.wy.setVisibility(8);
              rx(true);
            }
            label724:
            this.mg.setVisibility(8);
            break label137;
            n = "[SchoolAuth]".length();
            m = j;
            j = n;
            n = i;
            for (i = i1;; i = i1)
            {
              if (!TextUtils.isEmpty(localStringBuilder)) {
                break label805;
              }
              this.wz.setVisibility(8);
              break;
              QLog.d("QCirclePersonInfoAndStatusWidget", 1, "poster.busiData is null");
              n = i4;
              m = i3;
              j = i2;
            }
            label805:
            paramStUser = new SpannableString(localStringBuilder.toString());
            if (k != 0) {
              a(paramStUser, 0, k, 3);
            }
            if (i != 0) {
              a(paramStUser, k, j, 6);
            }
            if (m != 0) {
              a(paramStUser, m, n);
            }
            this.wz.setText(paramStUser);
            this.wz.setVisibility(0);
            this.wz.setMovementMethod(LinkMovementMethod.getInstance());
            QLog.d("QCirclePersonInfoAndStatusWidget", 1, new Object[] { localStringBuilder });
            continue;
          }
          this.wx.setText(2131700114);
          return;
        }
      }
      label916:
      this.jdField_a_of_type_Phg.a(null, null);
      this.nS.setVisibility(8);
      return;
      label935:
      int j = 0;
      int i = 0;
    }
  }
  
  private void bkB()
  {
    if ((!(this.mContext instanceof BaseActivity)) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null) || (TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()))) {
      return;
    }
    Intent localIntent = new Intent(this.mContext, ChatActivity.class);
    localIntent.putExtra("open_chatfragment", true);
    localIntent.putExtra("PREVIOUS_WINDOW", QCirclePersonalDetailFragment.class.getName());
    localIntent.putExtra("uin", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
    if (ovd.H(this.mContext, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get())) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      localIntent.putExtra("aio_msg_source", 3);
      String str2 = aqgv.b(this.mApp, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), true);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localIntent.putExtra("uinname", str1);
      this.mContext.startActivity(localIntent);
      return;
      localIntent.putExtra("uintype", 10008);
    }
  }
  
  private void bkC()
  {
    int j = 1;
    if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null) && (ovd.x(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get()))) {}
    Object localObject;
    for (int i = 1;; i = 0)
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "canJumpProfile" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
      if (((i != 0) || (ovd.eL(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()))) && (this.mContext != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get())))
      {
        localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get();
        if (((this.mContext instanceof BaseActivity)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          break;
        }
      }
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.mContext;
    if (((String)localObject).equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
      i = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne((String)localObject, i);
      ((ProfileActivity.AllInOne)localObject).pa = i;
      ((ProfileActivity.AllInOne)localObject).bJa = 128;
      ((ProfileActivity.AllInOne)localObject).bJb = 3080;
      ((ProfileActivity.AllInOne)localObject).subSourceId = 2;
      ProfileActivity.a(this.mContext, (ProfileActivity.AllInOne)localObject, false);
      return;
      i = j;
      if (!((acff)localBaseActivity.app.getManager(51)).isFriend((String)localObject)) {
        i = 115;
      }
    }
  }
  
  private String fK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("-");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      CharSequence localCharSequence = paramString[i];
      if ((TextUtils.isEmpty(localCharSequence)) || (localCharSequence.equals(getResources().getString(2131717022)))) {}
      for (;;)
      {
        i += 1;
        break;
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localStringBuilder.append("·");
        }
        localStringBuilder.append(localCharSequence);
      }
    }
    return localStringBuilder.toString();
  }
  
  private void fa(long paramLong)
  {
    this.zO = paramLong;
    this.wv.setText(ovd.aD(paramLong));
  }
  
  private void kJ()
  {
    this.eL.setOnClickListener(this);
    this.eM.setOnClickListener(this);
    this.eN.setOnClickListener(this);
    this.wy.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.wt.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.nS.setOnClickListener(this);
    this.wz.setOnClickListener(this);
  }
  
  private void rx(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844761);
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844762);
      return;
    }
    this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844763);
    this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130844764);
  }
  
  private void vv(int paramInt)
  {
    ThreadManager.getUIHandler().post(new QCirclePersonInfoAndStatusWidget.3(this, paramInt));
  }
  
  private void vw(int paramInt)
  {
    this.mFollowNum = paramInt;
    this.ww.setText(ovd.aD(paramInt));
  }
  
  public void L(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCirclePersonInfoAndStatusWidget", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  public void P(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("QCirclePersonInfoAndStatusWidget", 1, "bindData error");
      return;
    }
    if ((paramObject instanceof FeedCloudMeta.StUser))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = ((FeedCloudMeta.StUser)paramObject);
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "personDetail setSimpleUser");
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData);
      return;
    }
    if ((paramObject instanceof FeedCloudRead.StGetMainPageRsp))
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "personDetail setRspUser");
      this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp = ((FeedCloudRead.StGetMainPageRsp)paramObject);
      if (this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.busiRspData.get() != null) {
        paramObject = new QQCircleFeedBase.StMainPageBusiRspData();
      }
      try
      {
        paramObject.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.busiRspData.get().toByteArray());
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData = paramObject;
        if (this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.user != null)
        {
          this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.set(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.user);
          a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData);
        }
        vv(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.feedCount.get());
        fa(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.fansCount.get());
        vw(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.followCount.get());
        return;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.e("QCirclePersonInfoAndStatusWidget", 1, "personDetail mergeFrom stMainPageBusiRspData error");
        }
      }
    }
    QLog.d("QCirclePersonInfoAndStatusWidget", 1, "personDetail bindData error" + paramObject.toString());
  }
  
  protected TopGestureLayout a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) && ((getContext() instanceof FragmentActivity)))
    {
      Object localObject = (ViewGroup)((FragmentActivity)getContext()).getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  public void e(Context paramContext, View paramView)
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null) && ((paramContext instanceof Activity)) && (((Activity)paramContext).getIntent() != null) && (((Activity)paramContext).getIntent().hasExtra("key_bundle_common_init_bean")))
    {
      paramContext = (QCircleInitBean)((Activity)paramContext).getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (paramContext != null) {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramContext.getUser();
      }
    }
    this.wt = ((TextView)findViewById(2131380818));
    this.b = ((AsyncRichTextView)findViewById(2131380646));
    this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)findViewById(2131380715));
    this.wu = ((TextView)findViewById(2131380697));
    this.wv = ((TextView)findViewById(2131380691));
    this.ww = ((TextView)findViewById(2131380718));
    this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)findViewById(2131369780));
    this.wx = ((TextView)findViewById(2131380721));
    this.nS = findViewById(2131374538);
    this.jdField_a_of_type_Phg = new phg();
    this.jdField_a_of_type_Phg.u(paramView);
    this.eK = ((LinearLayout)findViewById(2131370651));
    this.wy = ((TextView)findViewById(2131380853));
    this.eL = ((LinearLayout)findViewById(2131370663));
    this.eN = ((LinearLayout)findViewById(2131370662));
    this.eM = ((LinearLayout)findViewById(2131370664));
    this.mg = ((ImageView)findViewById(2131369661));
    this.wz = ((TextView)findViewById(2131380793));
    kJ();
    L(false);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131560931;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
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
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget$a != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget$a.bkD();
        continue;
        if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null)
        {
          oux.aX(this.mContext, ouw.c(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "followListUrl"));
          continue;
          pco.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6L, 1L);
          bkC();
          continue;
          pco.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6L, 2L);
          bkC();
          continue;
          pco.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6L, 4L);
          bkC();
          continue;
          bkC();
          continue;
          if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null)
          {
            oux.aX(this.mContext, ouw.c(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "fansListUrl"));
            continue;
            bkB();
            pco.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 4L, 2L);
            continue;
            oux.qn(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
          }
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    QCircleFollowUpdateEvent localQCircleFollowUpdateEvent;
    if (((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null))
    {
      localQCircleFollowUpdateEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if (ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        if (localQCircleFollowUpdateEvent.mFollowStatus == 1) {
          this.mFollowNum += 1;
        }
      }
    }
    label130:
    do
    {
      do
      {
        break label130;
        break label130;
        vw(this.mFollowNum);
        do
        {
          ThreadManager.getUIHandler().post(new QCirclePersonInfoAndStatusWidget.5(this));
          ram.i("QCirclePersonInfoAndStatusWidget", "onReceiveEvent  id:" + ((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mUserId + " , status:" + ((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mFollowStatus + " " + toString());
          return;
          if (this.mFollowNum <= 0) {
            break;
          }
          this.mFollowNum -= 1;
          break;
        } while (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), localQCircleFollowUpdateEvent.mUserId));
        if ((localQCircleFollowUpdateEvent.mFollowStatus == 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 0)) {}
        for (this.zO += 1L;; this.zO -= 1L) {
          do
          {
            this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mFollowStatus);
            break;
          } while ((localQCircleFollowUpdateEvent.mFollowStatus != 0) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() != 1) || (this.zO <= 0L));
        }
      } while (!(paramSimpleBaseEvent instanceof QCircleFeedEvent));
      paramSimpleBaseEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mState == 2)
      {
        this.bis += 1;
        vv(this.bis);
        return;
      }
    } while (paramSimpleBaseEvent.mState != 3);
    if (this.bis > 0) {
      this.bis -= 1;
    }
    vv(this.bis);
  }
  
  public void setHeaderClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bkD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget
 * JD-Core Version:    0.7.0.1
 */