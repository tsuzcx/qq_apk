package com.tencent.mobileqq.profile.view;

import aerg;
import aerh;
import afcy;
import albb;
import alcn;
import alem;
import algt;
import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqae;
import aqaf;
import aqep;
import aqvr;
import aqvs;
import aqvx;
import aqvy;
import awlo;
import awlz;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.mobileqq.vip.diy.TemplateLikeView;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ram;
import rom;
import rpq;
import wja;

public class ProfileQVipDiyView
  extends ProfileHeaderView
{
  private View Ga;
  private View Gb;
  private aqvr jdField_a_of_type_Aqvr;
  private aqvx jdField_a_of_type_Aqvx;
  private awlz jdField_b_of_type_Awlz;
  private ProfileCardMoreInfoView jdField_b_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView;
  private PullToZoomHeaderListView jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private ViewGroup bD;
  private FrameLayout bQ;
  private FrameLayout bR;
  private String bWn = "";
  private HeartLayout c;
  private int dtn;
  ViewGroup ev;
  private View.OnClickListener fC = new algt(this);
  private final String[] gi = { "map_key_account_base_info", "map_key_tag", "map_key_sig", "map_key_phone", "map_key_account_level_info", "map_key_medal_and_diamond", "map_key_qzone", "map_key_mine_weishi", "map_key_photo_wall", "map_key_personality_label_board", "map_key_extend_friend_info", "map_key_favor" };
  private View mAvatarContainer;
  private HashMap<String, View> mu;
  private HashMap<String, View> mv;
  
  public ProfileQVipDiyView(@NonNull BaseActivity paramBaseActivity, @NonNull alcn paramalcn, @NonNull PullToZoomHeaderListView paramPullToZoomHeaderListView, @NonNull ViewGroup paramViewGroup, @NonNull FrameLayout paramFrameLayout, @NonNull ProfileCardMoreInfoView paramProfileCardMoreInfoView)
    throws ProfileTemplateException
  {
    this(paramBaseActivity, paramalcn, paramPullToZoomHeaderListView, paramViewGroup, paramFrameLayout, paramProfileCardMoreInfoView, false);
  }
  
  public ProfileQVipDiyView(@NonNull BaseActivity paramBaseActivity, @NonNull alcn paramalcn, @NonNull PullToZoomHeaderListView paramPullToZoomHeaderListView, @NonNull ViewGroup paramViewGroup, @NonNull FrameLayout paramFrameLayout, @NonNull ProfileCardMoreInfoView paramProfileCardMoreInfoView, boolean paramBoolean)
    throws ProfileTemplateException
  {
    super(paramBaseActivity, paramalcn);
    this.jdField_b_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = paramProfileCardMoreInfoView;
    this.mu = paramProfileCardMoreInfoView.ae();
    this.mv = new HashMap();
    this.bQ = paramFrameLayout;
    this.jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.bD = paramViewGroup;
    this.jdField_c_of_type_Afcy = new afcy(paramBaseActivity, this.app, 3, 1);
    k(paramalcn);
    e(paramalcn);
  }
  
  private void Q(ViewGroup paramViewGroup)
  {
    if (this.ev != null)
    {
      paramViewGroup.removeView(this.ev);
      this.ev = null;
    }
  }
  
  private void b(alcn paramalcn, boolean paramBoolean, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if ("map_key_extend_friend_info".equals(paramVarArgs[i])) {
        for (;;)
        {
          try
          {
            paramVarArgs = (ProfileCardExtendFriendView)((ProfileCardFavorShowView)this.mv.get("map_key_extend_friend_info")).S(0);
            if (paramVarArgs.a() == null) {
              break;
            }
            if (paramVarArgs.a().getText() == null) {
              return;
            }
            paramBoolean = paramalcn.d.declaration.equals(paramVarArgs.a().getText());
            if (paramBoolean) {
              continue;
            }
            paramBoolean = true;
          }
          catch (Exception paramVarArgs)
          {
            ram.w("DIYProfileTemplate.ProfileQVipDiyView", "update the expand info view, we rebuild it! but occur error:" + paramVarArgs);
            paramBoolean = false;
            continue;
          }
          ram.w("DIYProfileTemplate.ProfileQVipDiyView", "update the expand info view, we rebuild it :" + paramBoolean);
          if (!paramBoolean) {
            break;
          }
          this.jdField_a_of_type_Aqvx.a(this.mv, this.app, paramalcn, this.jdField_b_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.daT);
          return;
          paramBoolean = false;
        }
      }
      i += 1;
    }
  }
  
  private void b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (!aerh.c().enable) {}
    while (!aqep.Z(this.app, this.jdField_a_of_type_Alcn.d.uin)) {
      return;
    }
    aqep.be(this.app, this.jdField_a_of_type_Alcn.d.uin);
    this.ev = ((RelativeLayout)LayoutInflater.from(paramActivity).inflate(2131562217, paramViewGroup, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(350.0F, paramActivity.getResources()), wja.dp2px(44.0F, paramActivity.getResources()));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(2, 2131373630);
    localLayoutParams.bottomMargin = wja.dp2px(4.0F, paramActivity.getResources());
    paramViewGroup.addView(this.ev, localLayoutParams);
    paramActivity = (TextView)this.ev.findViewById(2131375572);
    paramViewGroup = (ImageView)this.ev.findViewById(2131375571);
    paramActivity.setOnClickListener(this.fC);
    paramViewGroup.setOnClickListener(this.fC);
    anot.a(this.app, "dc00898", "", "", "qvip", "0X8009E7A", 0, 0, "", "", "", "");
  }
  
  private void bt(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("body");
    if (localJSONObject == null) {
      throw new JSONException("json have no body!! " + paramJSONObject);
    }
    this.dtn = localJSONObject.optInt("ts", 0);
    this.jdField_a_of_type_Aqvx = aqvy.a(this.mActivity, localJSONObject, this.jdField_a_of_type_Alcn, this.bWn);
  }
  
  private void bu(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.opt("header");
    if ((localObject instanceof JSONObject))
    {
      this.jdField_b_of_type_Awlz = awlo.a(this.mActivity).a((JSONObject)localObject, this.bR, true, new aqvs(this.mt, this.bWn));
      return;
    }
    if ((localObject instanceof JSONArray))
    {
      this.jdField_b_of_type_Awlz = awlo.a(this.mActivity).a((JSONArray)localObject, this.bR, true, new aqvs(this.mt, this.bWn));
      return;
    }
    rom.fail("header is illegal :" + paramJSONObject, new Object[0]);
  }
  
  private void bv(JSONObject paramJSONObject)
  {
    this.bQ.removeAllViews();
    if (paramJSONObject == null)
    {
      this.bQ.setBackgroundResource(2130846670);
      return;
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("bg");
    if (localJSONObject != null)
    {
      this.jdField_a_of_type_Aqvr = aqvr.a(this.mActivity).a(this.bQ).a(localJSONObject);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("bg");
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Aqvr = aqvr.a(this.mActivity).a(this.bQ).a(paramJSONObject);
      return;
    }
    ram.e("DIYProfileTemplate.ProfileQVipDiyView", "this json have no background!");
  }
  
  private void c(ExtensionInfo paramExtensionInfo)
  {
    View localView = (View)this.mt.get("map_key_profile_diy_avatar_sticker");
    if (localView == null) {
      return;
    }
    if ((paramExtensionInfo != null) && (paramExtensionInfo.isPendantValid()))
    {
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
  }
  
  private void dFI()
  {
    ram.e("DIYProfileTemplate.ProfileQVipDiyView", "init head UI");
    this.mAvatarContainer = ((View)this.mt.get("map_key_profile_diy_nick_container"));
    Object localObject;
    if ((this.mAvatarContainer instanceof FrameLayout))
    {
      AvatarLayout localAvatarLayout = (AvatarLayout)this.mAvatarContainer.findViewById(2131369165);
      localAvatarLayout.setVisibility(0);
      albb localalbb = new albb(1, null);
      if (this.jdField_a_of_type_Alcn.e.pa == 0)
      {
        localObject = this.mActivity.getString(2131692201);
        localAvatarLayout.setTag(localalbb);
        localAvatarLayout.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
        localAvatarLayout.setContentDescription((CharSequence)localObject);
        localAvatarLayout.c(0, localAvatarLayout.findViewById(2131363324), false);
        this.mt.put("map_key_face", localAvatarLayout);
        this.mt.put("map_key_face_stoke", this.mAvatarContainer.findViewById(2131369169));
        localObject = (ImageView)this.mAvatarContainer.findViewById(2131368987);
        this.mt.put("map_key_avatar_pendant", localObject);
        ((ImageView)localObject).setVisibility(8);
        ((ImageView)localObject).setTag(localalbb);
        ((ImageView)localObject).setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      }
    }
    else
    {
      this.Ga = ((View)this.mt.get("map_key_profile_nick_name"));
      if (!(this.Ga instanceof ProfileNameView)) {
        break label341;
      }
      localObject = (ProfileNameView)this.Ga;
      ((ProfileNameView)localObject).setVisibility(0);
      ((ProfileNameView)localObject).setClickable(true);
    }
    for (;;)
    {
      this.Gb = ((View)this.mt.get("map_key_like"));
      if (!(this.Gb instanceof TemplateLikeView)) {
        break label388;
      }
      localObject = (TemplateLikeView)this.Gb;
      this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(0);
      this.mt.put("map_key_like", this.Gb);
      ((TemplateLikeView)localObject).setHeartLayout(this.app, this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      return;
      localObject = this.mActivity.getString(2131692200);
      break;
      label341:
      if ((this.Ga instanceof ETTextViewPlus))
      {
        localObject = (ETTextViewPlus)this.Ga;
        ((ETTextViewPlus)localObject).setTextSize(20.0F);
        this.jdField_a_of_type_Aqvx.a((ETTextView)localObject);
        ((ETTextViewPlus)localObject).setVisibility(0);
        ((ETTextViewPlus)localObject).setClickable(true);
      }
    }
    label388:
    this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(8);
  }
  
  public int Hx()
  {
    return rpq.dip2px(getContext(), 23.0F);
  }
  
  @NonNull
  public int Hy()
  {
    if (this.dtn == 0) {
      return 2131166970;
    }
    return 2131166829;
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Aqvx != null) {
      return this.jdField_a_of_type_Aqvx.a(paramActivity);
    }
    return new ProfileCardFavorShowView(paramActivity);
  }
  
  public List<View> a(HashMap<String, View> paramHashMap, String[] paramArrayOfString)
  {
    return this.jdField_a_of_type_Aqvx.b(paramHashMap, paramArrayOfString);
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
  
  public void a(alcn paramalcn, boolean paramBoolean, String... paramVarArgs)
  {
    b(paramalcn, paramBoolean, paramVarArgs);
    paramalcn = this.mv.keySet().iterator();
    while (paramalcn.hasNext())
    {
      paramVarArgs = (String)paramalcn.next();
      this.mu.put(paramVarArgs, this.mv.get(paramVarArgs));
    }
  }
  
  public void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    this.jdField_a_of_type_Aqvx.b(paramString, paramTextView, paramView, paramImageView);
  }
  
  public void aC()
  {
    if ((this.mActivity instanceof FriendProfileCardActivity)) {
      ((FriendProfileCardActivity)this.mActivity).AS(1);
    }
  }
  
  public void b(alcn paramalcn, boolean paramBoolean)
  {
    ram.w("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update isNetRet=" + paramBoolean);
    if ((this.Ga == null) || (this.mAvatarContainer == null)) {
      dFI();
    }
    if (this.mAvatarContainer != null)
    {
      ram.w("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 头像");
      a(paramalcn.e);
      c(paramalcn, false);
    }
    if (this.Ga != null)
    {
      ram.w("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 昵称");
      j(paramalcn);
    }
    if (this.Gb != null)
    {
      ram.w("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 点赞");
      i(paramalcn);
    }
  }
  
  public void c(alcn paramalcn, boolean paramBoolean)
  {
    Object localObject = (View)this.mt.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramalcn.e))
      {
        ((ImageView)localObject).setVisibility(4);
        this.pendantId = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new ProfileQVipDiyView.1(this, paramalcn, (ImageView)localObject, paramBoolean), 8, null, true);
  }
  
  public void dFK()
  {
    Object localObject = this.jdField_a_of_type_Alcn.d.diyComplicatedInfo;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ram.e("DIYProfileTemplate.ProfileQVipDiyView", " diy info is null!");
      throw new RuntimeException("diy info is null!");
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.bWn = ((JSONObject)localObject).optString("path", "");
      bv((JSONObject)localObject);
      bu((JSONObject)localObject);
      bt((JSONObject)localObject);
      this.jdField_a_of_type_Aqvx.N(this.mv);
      this.jdField_a_of_type_Aqvx.O(this.mv);
      this.jdField_a_of_type_Aqvx.a(this.mv, this.jdField_a_of_type_Alcn.d);
      this.jdField_a_of_type_Aqvx.a(this.mv, this.app, this.jdField_a_of_type_Alcn, this.jdField_b_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView);
      this.jdField_a_of_type_Aqvx.a(this.mv, this.app, this.jdField_a_of_type_Alcn);
      this.jdField_a_of_type_Aqvx.a(this.mv, this.app, this.jdField_a_of_type_Alcn, this.jdField_b_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.daT);
      a(this.jdField_a_of_type_Alcn, false, this.gi);
      aC();
      dFI();
      b(this.jdField_a_of_type_Alcn, false);
      if (!this.jdField_a_of_type_Alcn.d.uin.equals(this.app.getCurrentAccountUin())) {
        b(this.mActivity, this.bD);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      this.bQ.removeAllViews();
      throw new RuntimeException("diy info is illegal :" + localJSONException);
    }
  }
  
  public void e(alcn paramalcn)
  {
    this.bR = new FrameLayout(this.mActivity);
    int i = getResources().getDimensionPixelSize(2131297318);
    int j = aqep.e(getResources());
    j = (int)this.jG - aqep.v(this.mActivity, 18) - i - j;
    i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(getContext());
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    addView(this.bR, localLayoutParams);
    this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout = new HeartLayout(this.mActivity);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    addView(this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout, localLayoutParams);
    this.jdField_c_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(8);
    super.e(paramalcn);
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
            break label340;
          }
          localObject2 = new albb(10, paramalcn.d);
          localObject1 = String.format(this.mActivity.getString(2131692246), new Object[] { String.valueOf(i) });
          break;
        }
        label340:
        localObject2 = new albb(10, paramalcn.d);
        localObject1 = String.format(this.mActivity.getString(2131692159), new Object[] { String.valueOf(i) });
        if (paramalcn.d.bAvailVoteCnt == 0) {
          localVoteViewV2.ejk();
        }
      }
    }
    localVoteViewV2.setVisibility(4);
  }
  
  public void j(alcn paramalcn)
  {
    Object localObject1 = (View)this.mt.get("map_key_profile_nick_name");
    Object localObject2;
    ProfileActivity.AllInOne localAllInOne;
    String str;
    if ((localObject1 instanceof ProfileNameView))
    {
      localObject1 = (ProfileNameView)localObject1;
      if (localObject1 != null) {
        ((ProfileNameView)localObject1).b(this.app, paramalcn);
      }
      if ((((ProfileNameView)localObject1).b() != null) && (((ProfileNameView)localObject1).b().getVisibility() == 0))
      {
        localObject2 = ((ProfileNameView)localObject1).b();
        localAllInOne = paramalcn.e;
        str = paramalcn.a.a.value;
        if (str != null)
        {
          localObject1 = str;
          if (str.length() != 0) {}
        }
        else
        {
          if (!ProfileActivity.AllInOne.a(localAllInOne)) {
            break label224;
          }
        }
      }
      label224:
      for (localObject1 = String.valueOf(localAllInOne.uin);; localObject1 = " ")
      {
        ((ETTextView)localObject2).setText((CharSequence)localObject1);
        ((ETTextView)localObject2).setTextSize(16.0F);
        str = this.mActivity.getString(2131692177) + ":";
        ((ETTextView)localObject2).setContentDescription(str + (String)localObject1);
        ((ETTextView)localObject2).setTag(new albb(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(paramalcn.mOnClickListener);
        ((ETTextView)localObject2).setOnLongClickListener(paramalcn.b);
        ((ETTextView)localObject2).requestLayout();
        return;
      }
    }
    if ((localObject1 instanceof ETTextView))
    {
      localObject2 = (ETTextView)localObject1;
      localAllInOne = paramalcn.e;
      str = paramalcn.a.a.value;
      if (str != null)
      {
        localObject1 = str;
        if (str.length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label406;
        }
      }
      label406:
      for (localObject1 = String.valueOf(localAllInOne.uin);; localObject1 = " ")
      {
        ((ETTextView)localObject2).setText((CharSequence)localObject1);
        ((ETTextView)localObject2).setTextSize(16.0F);
        str = this.mActivity.getString(2131692177) + ":";
        ((ETTextView)localObject2).setContentDescription(str + (String)localObject1);
        ((ETTextView)localObject2).setTag(new albb(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(paramalcn.mOnClickListener);
        ((ETTextView)localObject2).setOnLongClickListener(paramalcn.b);
        ((ETTextView)localObject2).requestLayout();
        return;
      }
    }
    super.j(paramalcn);
  }
  
  public void k(alcn paramalcn)
    throws ProfileTemplateException
  {}
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.e("DIYProfileTemplate.ProfileQVipDiyView", 1, "profileQvipDiyView destroy");
    if (this.jdField_a_of_type_Aqvr != null) {
      this.jdField_a_of_type_Aqvr.efT();
    }
    if (this.jdField_b_of_type_Awlz != null) {
      this.jdField_b_of_type_Awlz.onDestory();
    }
    if (this.mu != null) {
      this.mu.clear();
    }
    Q(this.bD);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Awlz.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_Awlz.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipDiyView
 * JD-Core Version:    0.7.0.1
 */