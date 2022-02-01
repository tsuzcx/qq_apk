package com.tencent.mobileqq.profile.view;

import afcy;
import albb;
import alcn;
import alem;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.HashMap;
import java.util.List;

public class ProfileQVipV5View
  extends ProfileHeaderView
{
  private ImageView CF;
  private View FU;
  private View FV;
  private View FW;
  private View FX;
  private TextView Xj;
  private TextView Xk;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private VoteViewV2 jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2;
  private boolean aWq;
  private PullToZoomHeaderListView b;
  private HeartLayout c;
  private ViewGroup eu;
  private AvatarLayout f;
  private View mContentView;
  
  public ProfileQVipV5View(BaseActivity paramBaseActivity, alcn paramalcn, PullToZoomHeaderListView paramPullToZoomHeaderListView, TextView paramTextView, boolean paramBoolean)
  {
    super(paramBaseActivity, paramalcn);
    this.mActivity = paramBaseActivity;
    this.app = paramBaseActivity.app;
    this.jdField_a_of_type_Alcn = paramalcn;
    this.b = paramPullToZoomHeaderListView;
    this.Xk = paramTextView;
    this.aWq = paramBoolean;
    this.jdField_c_of_type_Afcy = new afcy(paramBaseActivity, this.app, 3, 1);
    e(paramalcn);
  }
  
  private void dFI()
  {
    int j = -16777216;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.eu = ((ViewGroup)this.mContentView.findViewById(2131369171));
    this.f = ((AvatarLayout)this.mContentView.findViewById(2131369165));
    this.f.setVisibility(0);
    albb localalbb = new albb(1, null);
    if (this.jdField_a_of_type_Alcn.e.pa == 0)
    {
      localObject = ((Context)localObject).getString(2131692201);
      this.f.setTag(localalbb);
      this.f.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      this.f.setContentDescription((CharSequence)localObject);
      this.f.c(0, this.f.findViewById(2131363324), false);
      this.mt.put("map_key_face", this.f);
      this.mt.put("map_key_face_stoke", this.mContentView.findViewById(2131369169));
      this.CF = ((ImageView)this.mContentView.findViewById(2131368987));
      this.mt.put("map_key_avatar_pendant", this.CF);
      this.CF.setVisibility(8);
      this.CF.setTag(localalbb);
      this.CF.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      this.FU = this.mContentView.findViewById(2131374934);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.mContentView.findViewById(2131372368));
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
      if (this.jdField_a_of_type_Alcn.d.backgroundColor != 1L) {
        break label523;
      }
      i = -16777216;
      label290:
      ((ProfileNameView)localObject).setTextColor(i);
      this.mt.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.FV = this.mContentView.findViewById(2131374880);
      this.FW = this.mContentView.findViewById(2131374879);
      this.mt.put("map_key_details", this.FW);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 = ((VoteViewV2)this.mContentView.findViewById(2131382077));
      this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.mContentView.findViewById(2131368498));
      this.mt.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.setHeartLayout(this.app, this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.tA(0);
      this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.FX = this.mContentView.findViewById(2131374738);
      this.Xj = ((TextView)this.mContentView.findViewById(2131374737));
      localObject = this.Xj;
      if (this.jdField_a_of_type_Alcn.d.backgroundColor != 1L) {
        break label528;
      }
    }
    label523:
    label528:
    for (int i = j;; i = -1)
    {
      ((TextView)localObject).setTextColor(i);
      this.mt.put("map_key_uin_info", this.Xj);
      return;
      localObject = ((Context)localObject).getString(2131692200);
      break;
      i = -1;
      break label290;
    }
  }
  
  protected void NJ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, " needRefreshUI=" + paramBoolean);
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131562221, this.eu, false);
    if (localView != null)
    {
      this.eu.removeAllViews();
      this.eu.addView(localView);
      if (paramBoolean)
      {
        dFI();
        a(this.jdField_a_of_type_Alcn.e);
        c(this.jdField_a_of_type_Alcn, false);
        j(this.jdField_a_of_type_Alcn);
        n(this.jdField_a_of_type_Alcn);
        i(this.jdField_a_of_type_Alcn);
        a(this.jdField_a_of_type_Alcn, this.app.getCurrentAccountUin());
      }
    }
  }
  
  public void a(alcn paramalcn, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.mt.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).cQn;
      }
      if ((paramalcn.d != null) && (paramalcn.d.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).ejk();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.mActivity.getString(2131692171), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void b(alcn paramalcn, boolean paramBoolean)
  {
    a(paramalcn.e);
    c(paramalcn, false);
    j(paramalcn);
    n(paramalcn);
    i(paramalcn);
    a(paramalcn, this.app.getCurrentAccountUin());
  }
  
  public void c(alcn paramalcn, boolean paramBoolean)
  {
    if (this.CF == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramalcn.e))
    {
      this.CF.setVisibility(8);
      this.pendantId = 0L;
      return;
    }
    ThreadManager.post(new ProfileQVipV5View.1(this, paramalcn, paramBoolean), 8, null, true);
  }
  
  public void e(alcn paramalcn)
  {
    this.mContentView = LayoutInflater.from(getContext()).inflate(2131562238, this, true);
    this.eu = ((ViewGroup)this.mContentView.findViewById(2131369171));
    NJ(false);
    dFI();
    a(paramalcn.e);
    c(paramalcn, true);
    j(paramalcn);
    n(paramalcn);
    i(paramalcn);
    a(paramalcn, this.app.getCurrentAccountUin());
    super.e(paramalcn);
  }
  
  public void f(alcn paramalcn) {}
  
  public void g(alcn paramalcn)
  {
    this.dtk &= 0xFFFFFFFE;
    if (this.Xk != null) {
      this.Xk.setVisibility(8);
    }
  }
  
  public void i(alcn paramalcn)
  {
    if ((paramalcn.cwc) && (TroopInfo.isQidianPrivateTroop(this.app, paramalcn.troopUin))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.mt.get("map_key_like");
    } while (!(localObject1 instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject1;
    boolean bool1 = d(paramalcn);
    if (this.aWq) {
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = TextUtils.equals(paramalcn.e.uin, this.app.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        Object localObject2;
        int j;
        int i;
        if (paramalcn.d == null)
        {
          localObject1 = this.mActivity.getString(2131692248);
          localObject2 = null;
          j = 0;
          bool1 = false;
          i = 0;
        }
        for (;;)
        {
          localVoteViewV2.a(bool2, bool1, i, j, this.jdField_c_of_type_Afcy, false);
          localVoteViewV2.setTag(localObject2);
          localVoteViewV2.setOnClickListener(paramalcn.mOnClickListener);
          localVoteViewV2.setContentDescription((CharSequence)localObject1);
          return;
          if (this.jdField_c_of_type_Afcy == null) {
            this.jdField_c_of_type_Afcy = new afcy(this.mActivity, this.app, 1, 1);
          }
          i = (int)paramalcn.d.lVoteCount;
          j = paramalcn.d.iVoteIncrement;
          if (1 == paramalcn.d.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_c_of_type_Afcy.zn = paramalcn.d.getLastPraiseInfoList();
            if (j <= this.jdField_c_of_type_Afcy.zn.size()) {
              this.jdField_c_of_type_Afcy.zn = this.jdField_c_of_type_Afcy.zn.subList(0, j);
            }
            this.jdField_c_of_type_Afcy.zn = alem.bp(this.jdField_c_of_type_Afcy.zn);
            if (!bool2) {
              break label349;
            }
            localObject2 = new albb(10, paramalcn.d);
            localObject1 = String.format(this.mActivity.getString(2131692246), new Object[] { String.valueOf(i) });
            break;
          }
          label349:
          localObject2 = new albb(10, paramalcn.d);
          localObject1 = String.format(this.mActivity.getString(2131692159), new Object[] { String.valueOf(i) });
          if (paramalcn.d.bAvailVoteCnt == 0) {
            localVoteViewV2.ejk();
          }
        }
      }
      localVoteViewV2.setVisibility(4);
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Alcn != null) {
      c(this.jdField_a_of_type_Alcn, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipV5View
 * JD-Core Version:    0.7.0.1
 */