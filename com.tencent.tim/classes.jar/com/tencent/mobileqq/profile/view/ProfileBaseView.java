package com.tencent.mobileqq.profile.view;

import afcy;
import albb;
import alcn;
import alem;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.HashMap;
import java.util.List;

public class ProfileBaseView
  extends ProfileHeaderView
{
  private ImageView CF;
  private View FT;
  private View FU;
  private View FV;
  private View FW;
  private View FX;
  private RectF S;
  private TextView Xj;
  private TextView Xk;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private VoteViewV2 jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2;
  private boolean aWq;
  private Paint ap;
  private RandomCoverView jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView;
  private PullToZoomHeaderListView jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private HeartLayout c;
  private boolean cwH = true;
  private int dtg;
  private ViewGroup eu;
  private AvatarLayout f;
  private View mContentView;
  
  public ProfileBaseView(BaseActivity paramBaseActivity, alcn paramalcn, PullToZoomHeaderListView paramPullToZoomHeaderListView, TextView paramTextView, boolean paramBoolean)
  {
    super(paramBaseActivity, paramalcn);
    this.mActivity = paramBaseActivity;
    this.app = paramBaseActivity.app;
    this.jdField_a_of_type_Alcn = paramalcn;
    this.jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.Xk = paramTextView;
    this.aWq = paramBoolean;
    this.jdField_c_of_type_Afcy = new afcy(paramBaseActivity, this.app, 3, 1);
    e(paramalcn);
  }
  
  private void dFI()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.eu = ((ViewGroup)this.mContentView.findViewById(2131369171));
    this.f = ((AvatarLayout)this.mContentView.findViewById(2131369165));
    this.f.setVisibility(0);
    albb localalbb = new albb(1, null);
    if (this.jdField_a_of_type_Alcn.e.pa == 0) {}
    for (localObject = ((Context)localObject).getString(2131692201);; localObject = ((Context)localObject).getString(2131692200))
    {
      this.f.setTag(localalbb);
      this.f.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      this.f.setContentDescription((CharSequence)localObject);
      this.f.c(0, this.f.findViewById(2131363324), false);
      this.mt.put("map_key_face", this.f);
      this.mt.put("map_key_face_stoke", this.mContentView.findViewById(2131369169));
      this.CF = ((ImageView)this.mContentView.findViewById(2131368987));
      this.mt.put("map_key_avatar_pendant", this.CF);
      this.CF.setVisibility(4);
      this.CF.setTag(localalbb);
      this.CF.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      this.FU = this.mContentView.findViewById(2131374934);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.mContentView.findViewById(2131372368));
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
      this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.FX = this.mContentView.findViewById(2131374738);
      this.Xj = ((TextView)this.mContentView.findViewById(2131374737));
      this.mt.put("map_key_uin_info", this.Xj);
      return;
    }
  }
  
  public boolean PG()
  {
    return (this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView == null) || (this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.ML() == 1);
  }
  
  public void SN(int paramInt)
  {
    this.dtg = paramInt;
    invalidate();
  }
  
  public void SO(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView == null) || (this.FX == null) || (this.FU == null)) {}
    int i;
    int j;
    do
    {
      return;
      if (paramInt == 1)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ankt.dip2px(5.0F);
        this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ankt.dip2px(15.0F);
      this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = getResources();
      i = ((Resources)localObject).getDimensionPixelSize(2131297963);
      j = ((Resources)localObject).getDimensionPixelSize(2131297965);
      localObject = (ViewGroup.MarginLayoutParams)this.FU.getLayoutParams();
      if (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != i)
      {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
        this.FU.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)this.FX.getLayoutParams();
      if (((ViewGroup.MarginLayoutParams)localObject).topMargin != j)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = j;
        this.FX.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, String.format("updateLayoutMargin mode: %s, name:%s, level:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) }));
  }
  
  public void a(int paramInt, alcn paramalcn)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, String.format("onCoverModeChange mode: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setTextColor(getResources().getColor(2131167304));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.tA(1);
      }
      if ((this.mActivity instanceof FriendProfileCardActivity)) {
        ((FriendProfileCardActivity)this.mActivity).AS(0);
      }
      paramalcn = (RelativeLayout.LayoutParams)this.FT.getLayoutParams();
      paramalcn.addRule(3, 0);
      paramalcn.addRule(10, 1);
      this.FT.setLayoutParams(paramalcn);
      this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription(null);
      SO(paramInt);
      return;
    }
    int i;
    albb localalbb;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null)
    {
      if (ThemeUtil.isInNightMode(this.app))
      {
        i = 2131167304;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setTextColor(getResources().getColor(i));
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.tA(0);
      }
      if ((this.mActivity instanceof FriendProfileCardActivity)) {
        ((FriendProfileCardActivity)this.mActivity).AS(1);
      }
      localObject = (RelativeLayout.LayoutParams)this.FT.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131369188);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
      this.FT.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localalbb = new albb(17, null);
      if (paramalcn.e.pa != 0) {
        break label343;
      }
    }
    label343:
    for (Object localObject = getContext().getString(2131692196);; localObject = getContext().getString(2131692195))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(localalbb);
      this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(paramalcn.mOnClickListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription((CharSequence)localObject);
      SO(paramInt);
      return;
      i = 2131167461;
      break;
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
    h(paramalcn);
    a(paramalcn.e);
    c(paramalcn, false);
    j(paramalcn);
    n(paramalcn);
    i(paramalcn);
    a(paramalcn, this.app.getCurrentAccountUin());
  }
  
  protected void bK(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "loadHeadLayout mode=" + paramInt + ", needRefreshUI=" + paramBoolean);
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    View localView = null;
    if (paramInt == 1) {
      localView = localLayoutInflater.inflate(2131562201, this.eu, false);
    }
    for (;;)
    {
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
      return;
      if (paramInt == 0) {
        localView = localLayoutInflater.inflate(2131562200, this.eu, false);
      }
    }
  }
  
  public void c(alcn paramalcn, boolean paramBoolean)
  {
    if (this.CF == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramalcn.e))
    {
      this.CF.setVisibility(4);
      this.pendantId = 0L;
      return;
    }
    ThreadManager.post(new ProfileBaseView.1(this, paramalcn, paramBoolean), 8, null, true);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.cwH)
    {
      if (this.S == null) {
        this.S = new RectF();
      }
      if (this.ap == null) {
        this.ap = new Paint();
      }
      this.S.set(getLeft(), this.dtg, getRight(), getBottom());
      paramCanvas.save();
      paramCanvas.clipRect(this.S);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void e(alcn paramalcn)
  {
    this.mContentView = LayoutInflater.from(getContext()).inflate(2131562199, this, true);
    this.eu = ((ViewGroup)this.mContentView.findViewById(2131369171));
    this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.mContentView.findViewById(2131369188));
    this.jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderImage(this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.e());
    this.jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderMask(this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.cB());
    this.jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView.setProfileBaseView(this);
    int i;
    if (ProfileActivity.AllInOne.i(paramalcn.e)) {
      i = 1;
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.mContentView.findViewById(2131369188));
      this.FT = this.mContentView.findViewById(2131369162);
      this.mt.put("map_key_qzonecover", this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView);
      this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.setVisibility(0);
      Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView;
      Object localObject2 = this.app;
      String str1 = paramalcn.e.uin;
      String str2 = this.mCoverUrl;
      if (this.bHA == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((RandomCoverView)localObject1).a((QQAppInterface)localObject2, str1, i, str2, bool, true);
        bK(i, false);
        dFI();
        a(paramalcn.e);
        c(paramalcn, true);
        j(paramalcn);
        n(paramalcn);
        i(paramalcn);
        a(paramalcn, this.app.getCurrentAccountUin());
        super.e(paramalcn);
        a(i, paramalcn);
        if (ThemeUtil.isInNightMode(this.app))
        {
          paramalcn = (ImageView)this.f.findViewById(2131363324);
          localObject1 = (ImageView)this.mt.get("map_key_face_stoke");
          localObject2 = this.CF;
          paramalcn.setColorFilter(1996488704);
          ((ImageView)localObject1).setColorFilter(1996488704);
          ((ImageView)localObject2).setColorFilter(1996488704);
        }
        return;
        if (paramalcn.d == null) {
          break label410;
        }
        localObject1 = paramalcn.d.getCoverData(this.bHA);
        localObject2 = (String)localObject1[0];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.mCoverUrl = ((String)localObject2);
          this.bHA = ((Integer)localObject1[1]).intValue();
        }
        if (!paramalcn.d.isNoCover()) {
          break label410;
        }
        i = 1;
        break;
      }
      label410:
      i = 0;
    }
  }
  
  public void f(alcn paramalcn) {}
  
  public void g(alcn paramalcn)
  {
    this.dtk &= 0xFFFFFFFE;
    if (this.Xk != null) {
      this.Xk.setVisibility(8);
    }
  }
  
  protected void h(alcn paramalcn)
  {
    int i;
    if (paramalcn.d != null)
    {
      int j = this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.ML();
      if (!paramalcn.d.isNoCover()) {
        break label135;
      }
      i = 1;
      if (j != i)
      {
        bK(i, true);
        this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.YL(i);
        a(i, paramalcn);
      }
      Object localObject = paramalcn.d.getCoverData(this.bHA);
      paramalcn = (String)localObject[0];
      if ((TextUtils.isEmpty(paramalcn)) || (paramalcn.equals(this.mCoverUrl))) {
        break label146;
      }
      this.mCoverUrl = paramalcn;
      this.bHA = ((Integer)localObject[1]).intValue();
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView;
      if (this.bHA != 0) {
        break label140;
      }
      bool = true;
      ((RandomCoverView)localObject).ds(paramalcn, bool);
    }
    label135:
    label140:
    label146:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        i = 0;
        break;
        boolean bool = false;
      }
    }
    QLog.i("Q.profilecard.", 2, "same cover " + paramalcn);
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
  
  public void j(alcn paramalcn)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.b(this.app, paramalcn);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView != null) {
      SO(this.jdField_b_of_type_ComTencentMobileqqWidgetRandomCoverView.ML());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.FT != null)
    {
      paramInt1 = this.FT.getLeft();
      paramInt2 = this.FT.getTop();
      paramInt3 = this.FT.getRight();
      this.FT.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Alcn != null) {
      c(this.jdField_a_of_type_Alcn, false);
    }
  }
  
  public void setClipChildren(boolean paramBoolean)
  {
    this.cwH = paramBoolean;
    super.setClipChildren(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileBaseView
 * JD-Core Version:    0.7.0.1
 */