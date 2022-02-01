package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import SummaryCard.PhotoInfo;
import acff;
import acfp;
import acny;
import aetb;
import aetb.a;
import aetb.b;
import aetc;
import afsi;
import afxn;
import afxw;
import ahbj;
import akjp;
import albb;
import albg;
import alcn;
import alcs;
import alcx;
import alcz;
import alda;
import aldb;
import aldf;
import alee;
import aleo;
import alep;
import alse;
import amfh;
import amhj;
import amii;
import amii.a;
import amin;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anlm;
import anot;
import aofk;
import aofr;
import apuh;
import aqaf;
import aqcu;
import aqdf;
import aqdf.a;
import aqek;
import aqep;
import aqfr;
import aqft;
import aqgv;
import aqhu;
import aqmj;
import aqnm;
import aqqx;
import argi;
import arhe;
import arhf;
import arhg;
import arhh;
import arhi;
import arhj;
import arhk;
import arhl;
import arho;
import arhq;
import arhs;
import arjh;
import avpw;
import avsn;
import awbq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.b;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.widget.MiniAppProfileCardGuestView;
import com.tencent.mobileqq.mini.widget.MiniAppProfileCardView;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard.a;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfileQVipDiyView;
import com.tencent.mobileqq.profile.view.ProfileQVipV5View;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.troop.TroopPluginManager;
import feedcloud.FeedCloudMeta.StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import jll;
import srn;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.UinItem;
import top;
import wja;

public class ProfileCardMoreInfoView
  extends LinearLayout
  implements amii.a, aqdf.a, FriendProfileCardActivity.b, PhotoWallView.b, AbsListView.e
{
  private float BN;
  private float BO;
  private volatile List<FeedCloudMeta.StFeed> Jq;
  private TextView K;
  private RedTouch R;
  public alcn a;
  private arho jdField_a_of_type_Arho;
  private final arhs jdField_a_of_type_Arhs = new arhs(this);
  private awbq jdField_a_of_type_Awbq;
  public ProfileHeaderView a;
  public a a;
  private volatile boolean aVx = true;
  public QQAppInterface app;
  private ListView jdField_b_of_type_ComTencentWidgetListView;
  private srn jdField_b_of_type_Srn;
  private String bkj;
  private int bsd;
  private String cAr;
  private String cAs;
  private String cAt;
  private aqdf d;
  boolean daH;
  boolean daI = false;
  private boolean daJ;
  private boolean daK;
  private boolean daL;
  private boolean daM;
  private boolean daN;
  private boolean daO;
  private boolean daP;
  protected boolean daQ;
  public boolean daR;
  public boolean daS;
  public boolean daT;
  private boolean daU;
  private volatile boolean daV = true;
  public alcs e;
  private int ehu;
  private int ehv;
  private int ehw;
  private final String[] gi = { "map_key_account_base_info", "map_key_tag", "map_key_sig", "map_key_phone", "map_key_troop_mem_add_time", "map_key_troop_mem_charm_level", "map_key_troop_mem_recent_said", "map_key_troop_mem_game_info", "map_key_account_level_info", "map_key_medal_and_diamond", "map_key_qzone", "map_key_qqcircle", "map_key_present", "map_key_music_box", "map_key_mine_weishi", "map_key_photo_wall", "map_key_personality_label_board", "map_key_life_achievement", "map_key_extend_friend_info", "map_key_favor", "map_key_mini_playing", "map_key_sticky_note" };
  private Runnable hY = new ProfileCardMoreInfoView.1(this);
  private final String[] ij = { "map_key_medal_and_diamond", "map_key_troop_mem_add_time", "map_key_troop_mem_charm_level", "map_key_troop_mem_recent_said", "map_key_troop_mem_game_info" };
  private final String[] ik = { "map_key_troop_mem_add_time", "map_key_account_level_info", "map_key_medal_and_diamond", "map_key_qzone", "map_key_present", "map_key_music_box", "map_key_mine_weishi", "map_key_photo_wall" };
  LayoutInflater inflater;
  public volatile boolean isPluginInstalled = false;
  public BaseActivity mActivity;
  private Context mContext;
  private float mDensity;
  private int mPos;
  private Handler mUiHandler;
  private Map<String, CircleBoarderImageView> oD;
  private float of;
  HashMap<String, View> pH = new HashMap();
  private HashMap<String, String> pI = new HashMap();
  private Resources resources;
  ColorDrawable jdField_t_of_type_AndroidGraphicsDrawableColorDrawable;
  private TextView[] jdField_t_of_type_ArrayOfAndroidWidgetTextView;
  private float yA;
  
  public ProfileCardMoreInfoView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ProfileCardMoreInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void TK(boolean paramBoolean)
  {
    int i = 2;
    if (this.daO) {
      return;
    }
    String str2;
    String str1;
    if (paramBoolean)
    {
      str2 = "0X80092DA";
      str1 = str2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.d.declaration))
      {
        i = 1;
        str1 = str2;
      }
    }
    for (;;)
    {
      this.daO = true;
      anot.a(this.app, "dc00898", "", "", str1, str1, i, 0, "", "", "", "");
      return;
      str2 = "0X80092E1";
      str1 = str2;
      if (this.daS)
      {
        i = 1;
        str1 = str2;
      }
    }
  }
  
  private boolean V(View paramView)
  {
    int[] arrayOfInt = new int[2];
    int i = getResources().getDisplayMetrics().heightPixels;
    paramView.getLocationInWindow(arrayOfInt);
    int j = arrayOfInt[1];
    return ((FriendProfileCardActivity)this.mContext).findViewById(2131373636).getHeight() + j < i;
  }
  
  private boolean V(ArrayList<ProfileActivity.CardContactInfo> paramArrayList)
  {
    int k = 0;
    Object localObject1 = this.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    if ((ProfileActivity.AllInOne.i(this.jdField_a_of_type_Alcn.e)) || (this.jdField_a_of_type_Alcn.e.pa == 80)) {}
    for (int i = 1;; i = 0)
    {
      if ((localObject1 == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
        i = 0;
      }
      if (i == 0) {
        return this.pH.remove("map_key_phone") != null;
      }
      ViewGroup localViewGroup = (ViewGroup)this.pH.get("map_key_phone");
      if (localViewGroup == null)
      {
        localViewGroup = (ViewGroup)this.inflater.inflate(2131561585, null);
        this.pH.put("map_key_phone", localViewGroup);
      }
      for (boolean bool = true;; bool = false)
      {
        if (this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC != null) {
          this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC.clear();
        }
        Object localObject2;
        label223:
        int j;
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
        {
          i = 1;
          localViewGroup.removeAllViews();
          localObject2 = a(localViewGroup, 2130846671, ((ContactCard)localObject1).nickName, 1);
          if (localObject2 != null)
          {
            if (i == 0) {
              break label413;
            }
            alcs.a((View)localObject2, "background", this.e, "commonItemTopBorderBackground");
          }
          localObject2 = this.mContext;
          int m = ((ContactCard)localObject1).bSex;
          if (!aqep.aBZ()) {
            break label424;
          }
          j = 0;
          label244:
          localObject1 = a(localViewGroup, 2130846680, aqep.a((Context)localObject2, m, j, ((ContactCard)localObject1).strCountry, ((ContactCard)localObject1).strProvince, ((ContactCard)localObject1).strCity), 1);
          if (localObject1 != null)
          {
            if (i == 0) {
              break label433;
            }
            alcs.a((View)localObject1, "background", this.e, "commonItemTopBorderBackground");
          }
          label303:
          m = paramArrayList.size();
          j = k;
          label312:
          if (j >= m) {
            break label455;
          }
          localObject1 = (ProfileActivity.CardContactInfo)paramArrayList.get(j);
          localObject2 = a(localViewGroup, (ProfileActivity.CardContactInfo)localObject1);
          if (localObject2 != null)
          {
            if (i == 0) {
              break label444;
            }
            alcs.a((View)localObject2, "background", this.e, "commonItemTopBorderBackground");
          }
        }
        for (;;)
        {
          ((ViewGroup)localObject2).setTag(new albb(4, localObject1));
          ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
          ((ViewGroup)localObject2).setOnLongClickListener(this.jdField_a_of_type_Alcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
          j += 1;
          break label312;
          i = 0;
          break;
          label413:
          ((ViewGroup)localObject2).setBackgroundResource(2130839685);
          break label223;
          label424:
          j = ((ContactCard)localObject1).bAge;
          break label244;
          label433:
          ((ViewGroup)localObject1).setBackgroundResource(2130839685);
          break label303;
          label444:
          ((ViewGroup)localObject2).setBackgroundResource(2130839684);
        }
        label455:
        return bool;
      }
    }
  }
  
  private int a(Card paramCard)
  {
    if ((paramCard != null) && (paramCard.enlargeQzonePic == 1)) {
      return 3;
    }
    return 4;
  }
  
  private int a(List<PrivilegeInfo> paramList, LinearLayout paramLinearLayout, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, Drawable paramDrawable, boolean paramBoolean)
  {
    int k = 0;
    int i = 0;
    if (k < paramList.size())
    {
      PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)paramList.get(k);
      int j = i;
      if (!TextUtils.isEmpty(localPrivilegeInfo.strDeluxeIconUrl))
      {
        if (i == 0) {}
        for (j = 0;; j = paramInt1)
        {
          i += 1;
          paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - j);
          if (paramArrayOfInt[0] >= 0) {
            break;
          }
          paramInt1 = i;
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileCardMoreInfoView", 1, "medal list layout is big =" + localPrivilegeInfo.iIsBig + " icon index=" + i);
            paramInt1 = i;
          }
          return paramInt1;
        }
        a(localPrivilegeInfo, localPrivilegeInfo.strDeluxeIconUrl, paramLinearLayout, paramInt2, paramInt3, j, paramDrawable, paramBoolean);
        j = i;
      }
      if (!TextUtils.isEmpty(localPrivilegeInfo.strIconUrl))
      {
        if (j == 0) {}
        for (i = 0;; i = paramInt1)
        {
          j += 1;
          paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - i);
          if (paramArrayOfInt[0] >= 0) {
            break label274;
          }
          paramInt1 = j;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ProfileCardMoreInfoView", 1, "medal list layout is big =" + localPrivilegeInfo.iIsBig + " icon index=" + j);
          return j;
        }
        label274:
        a(localPrivilegeInfo, localPrivilegeInfo.strIconUrl, paramLinearLayout, paramInt2, paramInt3, i, paramDrawable, paramBoolean);
      }
      for (i = j;; i = j)
      {
        k += 1;
        break;
      }
    }
    return i;
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if ((paramViewGroup != null) && (paramInt1 > 0) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      ViewGroup localViewGroup = (ViewGroup)this.inflater.inflate(2131561570, null);
      View localView = localViewGroup.findViewById(2131368698);
      TextView localTextView = (TextView)localViewGroup.findViewById(2131369154);
      localView.setBackgroundResource(paramInt1);
      if ((paramCharSequence instanceof String)) {
        localTextView.setText(((String)paramCharSequence).trim());
      }
      for (;;)
      {
        paramViewGroup.addView(localViewGroup);
        if (paramInt2 == 1) {
          aqep.a(localTextView, null, null, this.jdField_a_of_type_Alcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
        }
        c("map_key_phone", null, localTextView, null);
        return localViewGroup;
        localTextView.setText(paramCharSequence);
      }
    }
    return null;
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if ((paramViewGroup == null) || (paramCardContactInfo == null)) {
      return null;
    }
    paramCardContactInfo = paramCardContactInfo.phoneNumber;
    ViewGroup localViewGroup = (ViewGroup)this.inflater.inflate(2131561572, null);
    View localView = localViewGroup.findViewById(2131369459);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131369154);
    ImageView localImageView = (ImageView)localViewGroup.findViewById(2131362978);
    localView.setVisibility(0);
    localView.setBackgroundResource(2130846693);
    localTextView.setText(paramCardContactInfo);
    paramViewGroup.addView(localViewGroup);
    c("map_key_phone", null, localTextView, localImageView);
    return localViewGroup;
  }
  
  private ImageView a(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, Drawable paramDrawable)
  {
    URLImageView localURLImageView = new URLImageView(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)paramFloat1, (int)paramFloat2);
    localLayoutParams.leftMargin = ((int)paramFloat3);
    localLayoutParams.gravity = 16;
    localURLImageView.setLayoutParams(localLayoutParams);
    paramDrawable = aqqx.a(paramString, aqqx.pe, paramDrawable);
    if (paramDrawable != null)
    {
      ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), localURLImageView);
      if (paramDrawable.getStatus() == 2)
      {
        localURLImageView.setVisibility(8);
        paramDrawable.restartDownload();
      }
      localURLImageView.setImageDrawable(paramDrawable);
      localURLImageView.setURLDrawableDownListener(new arhq(localURLImageView, paramString, "showDiamondImage onLoadFailed iconUrl = "));
      return localURLImageView;
    }
    QLog.e("QVipSettingMe.ProfileCardMoreInfoView", 1, "apn drawable get null!iconUrl:" + paramString);
    return localURLImageView;
  }
  
  public static String a(alcn paramalcn)
  {
    Object localObject2 = paramalcn.gh[4];
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramalcn.gh[0];
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramalcn.e.uin;
    }
    return localObject2;
  }
  
  private String a(TextView paramTextView, String paramString1, String paramString2)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = localTextPaint;
    if (localTextPaint == null)
    {
      paramTextView = new TextPaint(1);
      paramTextView.density = this.mDensity;
    }
    float f1 = paramTextView.measureText("...");
    float f2 = this.mDensity;
    float f3 = paramTextView.measureText(String.format("(%s)", new Object[] { paramString2 }));
    paramString1 = TextUtils.ellipsize(paramString1, paramTextView, this.yA - f3 - (f1 + 5.0F * f2), TextUtils.TruncateAt.END);
    paramTextView = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramTextView = "...";
    }
    return String.format("%s(%s)", new Object[] { paramTextView, paramString2 });
  }
  
  private void a(PrivilegeInfo paramPrivilegeInfo, String paramString, LinearLayout paramLinearLayout, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, boolean paramBoolean)
  {
    paramString = a(paramString, paramInt1, paramInt2, paramInt3, paramDrawable);
    paramLinearLayout.addView(paramString);
    if (!TextUtils.isEmpty(paramPrivilegeInfo.strJumpUrl))
    {
      paramString.setClickable(true);
      paramString.setTag(new albb(93, paramPrivilegeInfo));
      paramString.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      paramLinearLayout = new StringBuilder();
      a(paramLinearLayout, paramPrivilegeInfo);
      paramLinearLayout.append("徽章");
      paramString.setContentDescription(paramLinearLayout);
      paramString = "";
      switch (paramPrivilegeInfo.iType)
      {
      default: 
        if ((this.ehv & 0x8) == 0)
        {
          if (paramBoolean)
          {
            paramString = "0X800A136";
            label151:
            this.ehv |= 0x8;
          }
        }
        else {
          label162:
          if (!TextUtils.isEmpty(paramString))
          {
            if (paramPrivilegeInfo.iIsBig != 1) {
              break label402;
            }
            if (!paramPrivilegeInfo.isOpen) {
              break label396;
            }
            paramInt1 = 1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramLinearLayout = "";
      if (paramPrivilegeInfo.iType != 1)
      {
        paramPrivilegeInfo = paramLinearLayout;
        if (!paramString.equals("0X800A136")) {}
      }
      else
      {
        paramPrivilegeInfo = String.valueOf(acny.e(this.app, this.app.getCurrentUin(), false));
      }
      anot.a(this.app, "dc00898", "", "", "qvip", paramString, paramInt1, 0, paramPrivilegeInfo, "", "", "");
      return;
      paramString.setTag(null);
      paramString.setOnClickListener(null);
      paramString.setClickable(false);
      break;
      if ((this.ehv & 0x1) != 0) {
        break label162;
      }
      if (paramBoolean) {}
      for (paramString = "0X800A132";; paramString = "0X800A12A")
      {
        this.ehv |= 0x1;
        break;
      }
      if ((this.ehv & 0x2) != 0) {
        break label162;
      }
      if (paramBoolean) {}
      for (paramString = "0X800A134";; paramString = "0X800A12C")
      {
        this.ehv |= 0x2;
        break;
      }
      if ((this.ehv & 0x4) != 0) {
        break label162;
      }
      if (paramBoolean) {}
      for (paramString = "0X800A130";; paramString = "0X800A128")
      {
        this.ehv |= 0x4;
        break;
      }
      paramString = "0X800A12E";
      break label151;
      label396:
      paramInt1 = 2;
      continue;
      label402:
      if (paramPrivilegeInfo.isOpen) {
        paramInt1 = 3;
      } else {
        paramInt1 = 4;
      }
    }
  }
  
  private static void a(View paramView, alcn paramalcn)
  {
    paramView.setVisibility(0);
    Context localContext = paramView.getContext();
    TextView localTextView = (TextView)paramView.findViewById(2131369466);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362978);
    if (!TextUtils.isEmpty(paramalcn.bVm))
    {
      localTextView.setText(paramalcn.bVm);
      localTextView.setContentDescription(paramalcn.bVm);
      localImageView.setVisibility(0);
      paramView.setOnClickListener(paramalcn.mOnClickListener);
      return;
    }
    localTextView.setText(localContext.getString(2131699800));
    localTextView.setContentDescription(localContext.getString(2131699800));
    localImageView.setVisibility(0);
    paramView.setOnClickListener(paramalcn.mOnClickListener);
  }
  
  private void a(LinearLayout paramLinearLayout, Card paramCard)
  {
    List localList = paramCard.getBigOrderEntrys();
    int k = 0;
    if (localList != null)
    {
      paramLinearLayout.removeAllViews();
      int i;
      int j;
      label40:
      alda localalda;
      int m;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
      {
        i = 1;
        j = 0;
        if (j >= localList.size()) {
          break label842;
        }
        localalda = (alda)localList.get(j);
        m = k;
        if (!TextUtils.isEmpty(localalda.strName))
        {
          if (localalda.yC != null) {
            break label111;
          }
          m = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = m;
        break label40;
        i = 0;
        break;
        label111:
        m = k;
        if (localalda.serviceType != 5) {
          if ((localalda.serviceType == 4) && (this.jdField_a_of_type_Arho != null))
          {
            m = k;
            if (!this.jdField_a_of_type_Arho.mI(5)) {}
          }
          else if ((localalda.serviceType == 2) && (this.jdField_a_of_type_Arho != null))
          {
            m = k;
            if (!this.jdField_a_of_type_Arho.mI(4)) {}
          }
          else
          {
            ProfileCardFavorShowView localProfileCardFavorShowView = b(this.mActivity);
            localProfileCardFavorShowView.setTitle(localalda.strName);
            m = 0;
            if (m < localalda.yC.size())
            {
              aldb localaldb = (aldb)localalda.yC.get(m);
              ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.mActivity);
              localProfileCardFavorItemDetailView.setTitle(localaldb.strTitle);
              localProfileCardFavorItemDetailView.setContent(localaldb.bVL);
              localProfileCardFavorItemDetailView.setDesc(localaldb.strDesc);
              Drawable localDrawable = getResources().getDrawable(2131166634);
              paramCard = localDrawable;
              if (!TextUtils.isEmpty(localaldb.strCoverUrl))
              {
                paramCard = URLDrawable.URLDrawableOptions.obtain();
                paramCard.mLoadingDrawable = localDrawable;
                paramCard.mRequestWidth = wja.dp2px(70.0F, getResources());
                paramCard.mRequestHeight = wja.dp2px(70.0F, getResources());
                paramCard = URLDrawable.getDrawable(localaldb.strCoverUrl, paramCard);
              }
              localProfileCardFavorItemDetailView.setIcon(paramCard);
              if (!TextUtils.isEmpty(localaldb.bVM)) {
                localProfileCardFavorItemDetailView.gy(localaldb.bVM, 2);
              }
              if ((localaldb.labels != null) && (localaldb.labels.size() > 0))
              {
                int n = 0;
                while (n < localaldb.labels.size())
                {
                  paramCard = (alcz)localaldb.labels.get(n);
                  localProfileCardFavorItemDetailView.a(null, paramCard.strWording, Color.rgb((int)paramCard.b.R, (int)paramCard.b.G, (int)paramCard.b.B), 3);
                  n += 1;
                }
              }
              label527:
              boolean bool;
              if (i != 0)
              {
                c("map_key_favor", localProfileCardFavorItemDetailView.acl, localProfileCardFavorItemDetailView.ack, null);
                c("map_key_favor", localProfileCardFavorItemDetailView.acm, null, null);
                alcs.a(localProfileCardFavorItemDetailView, "background", this.e, "commonItemTopBorderBackground");
                localProfileCardFavorItemDetailView.setTag(new albb(62, localaldb));
                localProfileCardFavorItemDetailView.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
                localProfileCardFavorShowView.addView(localProfileCardFavorItemDetailView);
                if (m == 0) {
                  break label628;
                }
                bool = true;
                label570:
                localProfileCardFavorItemDetailView.setNeedTopMargin(bool);
                switch (localaldb.serviceType)
                {
                }
              }
              for (;;)
              {
                m += 1;
                break;
                localProfileCardFavorItemDetailView.setBackgroundResource(2130839684);
                break label527;
                label628:
                bool = false;
                break label570;
                if (localaldb.drY == 0)
                {
                  if (!this.daK)
                  {
                    anot.a(this.app, "dc00898", "", "", "0X80070B1", "0X80070B1", 0, 0, "", "", "", "");
                    this.daK = true;
                  }
                }
                else if (!this.daL)
                {
                  anot.a(this.app, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
                  this.daL = true;
                  continue;
                  if (!this.daM)
                  {
                    anot.a(this.app, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
                    this.daM = true;
                  }
                }
              }
            }
            c("map_key_favor", null, localProfileCardFavorShowView.mTitleText, localProfileCardFavorShowView.rx);
            paramCard = new albb(61, localalda);
            localProfileCardFavorShowView.mTitleBar.setTag(paramCard);
            localProfileCardFavorShowView.mTitleBar.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
            paramLinearLayout.addView(localProfileCardFavorShowView);
            m = k + 1;
          }
        }
      }
      label842:
      this.daQ = true;
      this.ehu = k;
    }
  }
  
  private void a(Card paramCard, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardMoreInfoView", 2, "fillUpExtendFriendInfo");
    }
    boolean bool2 = ThemeUtil.isInNightMode(this.app);
    int j;
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs != null)
    {
      j = 1;
      localObject = paramProfileCardFavorShowView.S(0);
      if (localObject == null) {
        break label498;
      }
      if (j == 0) {
        break label365;
      }
      alcs localalcs = (alcs)((View)localObject).getTag(2131373632);
      if ((localalcs != null) && (localalcs.equals(this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs))) {
        break label498;
      }
      i = 1;
    }
    for (;;)
    {
      label90:
      boolean bool1;
      if ((localObject == null) || (!Boolean.FALSE.equals(((View)localObject).getTag(2131373633))) || (!new Boolean(bool2).equals(((View)localObject).getTag(2131373634))) || (i != 0))
      {
        paramProfileCardFavorShowView.removeAllViews();
        paramProfileCardFavorShowView.setFocusable(false);
        paramProfileCardFavorShowView.setClickable(false);
        if (j == 0) {
          break label492;
        }
        localObject = this.e.gB.get("commonItemContentColor");
        if (localObject == null) {
          break label487;
        }
        if ((localObject instanceof ColorStateList))
        {
          i = ((ColorStateList)localObject).getDefaultColor();
          label195:
          localObject = new float[3];
          Color.colorToHSV(i, (float[])localObject);
          if (localObject[2] <= 0.5F) {
            break label416;
          }
          bool1 = true;
        }
      }
      for (;;)
      {
        label220:
        if (bool2)
        {
          localObject = new ProfileCardExtendFriendView(this.mActivity, null, true);
          label240:
          if ((this.jdField_a_of_type_Alcn.e.pa == 96) || (this.daS)) {
            ((ProfileCardExtendFriendView)localObject).setFold(false);
          }
          ((ProfileCardExtendFriendView)localObject).setClickable(true);
          ((ProfileCardExtendFriendView)localObject).setTag(2131373633, Boolean.valueOf(false));
          ((ProfileCardExtendFriendView)localObject).setTag(2131373634, Boolean.valueOf(bool2));
          ((ProfileCardExtendFriendView)localObject).setTag(2131373632, this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs);
          paramProfileCardFavorShowView.addView((View)localObject);
          if (!aGA()) {
            break label478;
          }
          ((ProfileCardExtendFriendView)localObject).setDiyCard(true);
          ((ProfileCardExtendFriendView)localObject).setProfileCardFavorShowView(paramProfileCardFavorShowView);
        }
        for (;;)
        {
          label320:
          ((ProfileCardExtendFriendView)localObject).setIsFromLimitChat(this.daT);
          ((ProfileCardExtendFriendView)localObject).b(paramCard, this.app);
          return;
          j = 0;
          break;
          label365:
          if (((View)localObject).getTag(2131373632) == null) {
            break label498;
          }
          i = 1;
          break label90;
          if (!(localObject instanceof String)) {
            break label487;
          }
          localObject = (String)localObject;
          if (!((String)localObject).startsWith("#")) {
            break label487;
          }
          i = Color.parseColor((String)localObject);
          break label195;
          label416:
          bool1 = false;
          break label220;
          if (j != 0)
          {
            localObject = new ProfileCardExtendFriendView(this.mActivity, this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs, bool1);
            break label240;
          }
          localObject = new ProfileCardExtendFriendView(this.mActivity);
          break label240;
          localObject = (ProfileCardExtendFriendView)localObject;
          break label320;
          label478:
          ((ProfileCardExtendFriendView)localObject).setDiyCard(false);
        }
        label487:
        i = 0;
        break label195;
        label492:
        bool1 = false;
      }
      label498:
      i = 0;
    }
  }
  
  private void a(Card paramCard, boolean paramBoolean, LifeAchivementPanelView paramLifeAchivementPanelView)
  {
    int i = 1;
    c("map_key_life_achievement", null, paramLifeAchivementPanelView.mTitleText, null);
    TextView localTextView;
    if (paramBoolean)
    {
      i = paramCard.lifeAchievementTotalCount;
      localTextView = new TextView(getContext());
      localTextView.setText(String.format(getString(2131701300), new Object[] { Integer.valueOf(i) }));
      paramLifeAchivementPanelView.eR.removeAllViews();
      paramLifeAchivementPanelView.eR.addView(localTextView);
      paramLifeAchivementPanelView.eR.setVisibility(0);
      c("map_key_life_achievement", localTextView, null, null);
      paramLifeAchivementPanelView.E(paramCard.lifeAchivementList, paramCard.lifeAchievementTotalCount);
    }
    for (;;)
    {
      return;
      paramLifeAchivementPanelView.eR.setVisibility(4);
      paramLifeAchivementPanelView.showEmptyView();
      paramBoolean = ThemeUtil.isInNightMode(this.app);
      if (this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs != null) {}
      while ((paramBoolean) || (i != 0))
      {
        paramCard = (TextView)paramLifeAchivementPanelView.findViewById(2131380517);
        localTextView = (TextView)paramLifeAchivementPanelView.findViewById(2131380518);
        Button localButton = (Button)paramLifeAchivementPanelView.findViewById(2131370109);
        ((URLImageView)paramLifeAchivementPanelView.findViewById(2131370108)).setVisibility(4);
        c("map_key_life_achievement", null, paramCard, null);
        c("map_key_life_achievement", null, localTextView, null);
        c("map_key_life_achievement", null, localButton, null);
        return;
        i = 0;
      }
    }
  }
  
  private void a(MiniAppProfileCardGuestView paramMiniAppProfileCardGuestView)
  {
    Object localObject = this.e.gB.get("commonItemContentColor");
    if (localObject != null)
    {
      if (!(localObject instanceof ColorStateList)) {
        break label34;
      }
      paramMiniAppProfileCardGuestView.setTextColor((ColorStateList)localObject);
    }
    label34:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof String));
      localObject = (String)localObject;
    } while (!((String)localObject).startsWith("#"));
    paramMiniAppProfileCardGuestView.setTextColor(Color.parseColor((String)localObject));
  }
  
  private void a(MiniAppProfileCardView paramMiniAppProfileCardView)
  {
    Object localObject = this.e.gB.get("commonItemContentColor");
    if (localObject != null)
    {
      if (!(localObject instanceof ColorStateList)) {
        break label34;
      }
      paramMiniAppProfileCardView.setTextColor((ColorStateList)localObject);
    }
    label34:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof String));
      localObject = (String)localObject;
    } while (!((String)localObject).startsWith("#"));
    paramMiniAppProfileCardView.setTextColor(Color.parseColor((String)localObject));
  }
  
  /* Error */
  private void a(PersonalityLabelBoard paramPersonalityLabelBoard, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 165
    //   3: aconst_null
    //   4: aload_2
    //   5: getfield 889	com/tencent/mobileqq/widget/ProfileCardFavorShowView:mTitleText	Landroid/widget/TextView;
    //   8: aconst_null
    //   9: invokevirtual 497	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:c	(Ljava/lang/String;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/ImageView;)V
    //   12: aload_0
    //   13: getfield 344	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   16: ifnull +276 -> 292
    //   19: aload_0
    //   20: getfield 344	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   23: getfield 942	alcs:gB	Ljava/util/concurrent/ConcurrentHashMap;
    //   26: ifnull +266 -> 292
    //   29: aload_0
    //   30: getfield 344	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   33: getfield 942	alcs:gB	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: invokevirtual 1055	java/util/concurrent/ConcurrentHashMap:size	()I
    //   39: ifle +253 -> 292
    //   42: aload_0
    //   43: getfield 116	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:pI	Ljava/util/HashMap;
    //   46: ldc 165
    //   48: aload_0
    //   49: getfield 344	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   52: getfield 1058	alcs:agr	J
    //   55: invokestatic 1061	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   58: invokevirtual 311	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_0
    //   63: getfield 344	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   66: getfield 942	alcs:gB	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: ldc_w 944
    //   72: invokevirtual 947	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore 8
    //   77: aload 8
    //   79: ifnull +359 -> 438
    //   82: aload 8
    //   84: instanceof 949
    //   87: ifeq +167 -> 254
    //   90: aload 8
    //   92: checkcast 949	android/content/res/ColorStateList
    //   95: astore 8
    //   97: aload_1
    //   98: getfield 1066	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   101: ifnull +330 -> 431
    //   104: aload_1
    //   105: getfield 1066	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   108: invokevirtual 1071	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:getColor	()I
    //   111: istore_3
    //   112: aload_0
    //   113: getfield 326	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   116: ifnull +259 -> 375
    //   119: aload_0
    //   120: getfield 326	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   123: instanceof 328
    //   126: ifne +249 -> 375
    //   129: iconst_1
    //   130: istore 4
    //   132: iload 4
    //   134: ifeq +8 -> 142
    //   137: aload_2
    //   138: iconst_1
    //   139: invokevirtual 938	com/tencent/mobileqq/widget/ProfileCardFavorShowView:setClickable	(Z)V
    //   142: aload_0
    //   143: getfield 219	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   146: invokestatic 912	com/tencent/mobileqq/theme/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   149: istore 7
    //   151: aload_0
    //   152: getfield 201	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Alcn	Lalcn;
    //   155: getfield 914	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   158: ifnull +223 -> 381
    //   161: iconst_1
    //   162: istore 5
    //   164: iload 7
    //   166: ifne +221 -> 387
    //   169: iload 5
    //   171: ifne +216 -> 387
    //   174: iconst_1
    //   175: istore 6
    //   177: aload_1
    //   178: iload 6
    //   180: invokevirtual 1074	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setIsNormalTheme	(Z)V
    //   183: aload_1
    //   184: getfield 1066	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   187: ifnull +30 -> 217
    //   190: iload 4
    //   192: ifeq +201 -> 393
    //   195: aload_1
    //   196: getfield 1066	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   199: aconst_null
    //   200: invokevirtual 1077	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   203: aload 8
    //   205: ifnull +201 -> 406
    //   208: aload_1
    //   209: getfield 1066	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   212: aload 8
    //   214: invokevirtual 1078	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setTextColor	(Landroid/content/res/ColorStateList;)V
    //   217: iload 7
    //   219: ifeq +23 -> 242
    //   222: iload 4
    //   224: ifeq +18 -> 242
    //   227: aload_0
    //   228: ldc 165
    //   230: aload_1
    //   231: getfield 1081	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:Xa	Landroid/widget/TextView;
    //   234: aload_1
    //   235: getfield 1085	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:gV	Landroid/widget/Button;
    //   238: aconst_null
    //   239: invokevirtual 497	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:c	(Ljava/lang/String;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/ImageView;)V
    //   242: aload 8
    //   244: ifnull +173 -> 417
    //   247: aload_1
    //   248: aload 8
    //   250: invokevirtual 1088	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setTextColors	(Landroid/content/res/ColorStateList;)V
    //   253: return
    //   254: aload 8
    //   256: instanceof 125
    //   259: ifeq +179 -> 438
    //   262: aload 8
    //   264: checkcast 125	java/lang/String
    //   267: astore 8
    //   269: aload 8
    //   271: ldc_w 991
    //   274: invokevirtual 995	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   277: ifeq +161 -> 438
    //   280: aload 8
    //   282: invokestatic 999	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   285: pop
    //   286: aconst_null
    //   287: astore 8
    //   289: goto -192 -> 97
    //   292: aload_0
    //   293: getfield 116	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:pI	Ljava/util/HashMap;
    //   296: ldc 165
    //   298: iconst_0
    //   299: invokestatic 687	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   302: invokevirtual 311	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: pop
    //   306: aload_0
    //   307: invokevirtual 238	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:getResources	()Landroid/content/res/Resources;
    //   310: ldc_w 1089
    //   313: invokevirtual 1093	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   316: astore 8
    //   318: goto -221 -> 97
    //   321: astore 9
    //   323: aconst_null
    //   324: astore 8
    //   326: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +34 -> 363
    //   332: ldc_w 1095
    //   335: iconst_2
    //   336: new 443	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 1097
    //   346: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 9
    //   351: invokevirtual 1100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   354: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 462	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 465	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload 9
    //   365: invokevirtual 1103	java/lang/Exception:printStackTrace	()V
    //   368: ldc_w 1104
    //   371: istore_3
    //   372: goto -260 -> 112
    //   375: iconst_0
    //   376: istore 4
    //   378: goto -246 -> 132
    //   381: iconst_0
    //   382: istore 5
    //   384: goto -220 -> 164
    //   387: iconst_0
    //   388: istore 6
    //   390: goto -213 -> 177
    //   393: aload_1
    //   394: getfield 1066	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   397: ldc_w 417
    //   400: invokevirtual 1105	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setBackgroundResource	(I)V
    //   403: goto -200 -> 203
    //   406: aload_1
    //   407: getfield 1066	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   410: iload_3
    //   411: invokevirtual 1106	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setTextColor	(I)V
    //   414: goto -197 -> 217
    //   417: aload_1
    //   418: iload_3
    //   419: invokestatic 1108	android/content/res/ColorStateList:valueOf	(I)Landroid/content/res/ColorStateList;
    //   422: invokevirtual 1088	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setTextColors	(Landroid/content/res/ColorStateList;)V
    //   425: return
    //   426: astore 9
    //   428: goto -102 -> 326
    //   431: ldc_w 1104
    //   434: istore_3
    //   435: goto -323 -> 112
    //   438: aconst_null
    //   439: astore 8
    //   441: goto -344 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	ProfileCardMoreInfoView
    //   0	444	1	paramPersonalityLabelBoard	PersonalityLabelBoard
    //   0	444	2	paramProfileCardFavorShowView	ProfileCardFavorShowView
    //   111	324	3	i	int
    //   130	247	4	j	int
    //   162	221	5	k	int
    //   175	214	6	bool1	boolean
    //   149	69	7	bool2	boolean
    //   75	365	8	localObject	Object
    //   321	43	9	localException1	Exception
    //   426	1	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   12	77	321	java/lang/Exception
    //   82	97	321	java/lang/Exception
    //   254	286	321	java/lang/Exception
    //   292	318	321	java/lang/Exception
    //   97	112	426	java/lang/Exception
  }
  
  private void a(String paramString, CircleBoarderImageView paramCircleBoarderImageView)
  {
    Object localObject = null;
    if (this.d != null)
    {
      Bitmap localBitmap = this.d.b(1, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.d.isPausing())
        {
          this.d.i(paramString, 1, true);
          this.oD.put(paramString, paramCircleBoarderImageView);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = aqhu.G();
    }
    paramString = new BitmapDrawable(paramString);
    if (ThemeUtil.isInNightMode(this.app)) {
      paramString.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    paramCircleBoarderImageView.setImageDrawable(paramString);
  }
  
  private void a(StringBuilder paramStringBuilder, PrivilegeInfo paramPrivilegeInfo)
  {
    if (paramPrivilegeInfo == null) {
      return;
    }
    switch (paramPrivilegeInfo.iType)
    {
    default: 
      return;
    case 1: 
      paramStringBuilder.append("会员");
      return;
    case 2: 
      paramStringBuilder.append("超级QQ");
      return;
    case 4: 
      paramStringBuilder.append("好莱坞会员");
      return;
    case 3: 
      paramStringBuilder.append("超级会员");
      return;
    case 5: 
      paramStringBuilder.append("腾讯图书VIP");
      return;
    case 104: 
      paramStringBuilder.append("情侣黄钻");
      return;
    case 103: 
      paramStringBuilder.append("绿钻");
      return;
    case 101: 
      paramStringBuilder.append("红钻");
      return;
    case 105: 
      paramStringBuilder.append("超级星钻");
      return;
    case 102: 
      paramStringBuilder.append("黄钻");
      return;
    }
    paramStringBuilder.append("大会员");
  }
  
  private void a(List<PrivilegeInfo> paramList, LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    float f1 = 20.0F * this.mDensity;
    float f2 = 20.0F * this.mDensity;
    float f3 = 2.0F * this.mDensity;
    float f4 = this.mDensity;
    f4 = 5.0F * this.mDensity;
    float f5 = 6.0F * this.mDensity;
    float f6 = 8.0F * this.mDensity;
    float f7 = this.mDensity;
    f7 = this.mDensity;
    float f8 = 36.0F * this.mDensity;
    if ((paramLinearLayout == null) || (paramList == null) || (paramList.size() < 1)) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i;
    Object localObject;
    int j;
    label162:
    label192:
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    int[] arrayOfInt;
    int k;
    label385:
    do
    {
      return;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      i = 0;
      if (i < paramList.size())
      {
        localObject = (PrivilegeInfo)paramList.get(i);
        if (((PrivilegeInfo)localObject).iIsBig == 1)
        {
          j = 1;
          if (j == 0) {
            break label192;
          }
          localArrayList1.add(localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label162;
          localArrayList2.add(localObject);
        }
      }
      paramList = new ColorDrawable(16777215);
      localObject = new LinearLayout(this.mContext);
      localLinearLayout = new LinearLayout(this.mContext);
      localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout)localObject).setOrientation(0);
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams1);
      localLinearLayout.setOrientation(0);
      localLinearLayout.setLayoutParams(localLayoutParams2);
      arrayOfInt = new int[1];
      if (QzoneConfig.getInstance().getConfig("qqsetting", "usersummarycardmedalicon", 0) != 0) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label500;
      }
      arrayOfInt[0] = ((int)(this.yA - f3));
      k = a(localArrayList1, localLinearLayout, (int)f3, arrayOfInt, (int)f8, (int)f8, paramList, paramBoolean);
      if (k > 0) {
        arrayOfInt[0] -= (int)f5;
      }
      if (k <= 0) {
        break label492;
      }
      j = (int)f6;
      j = a(localArrayList2, (LinearLayout)localObject, j, arrayOfInt, (int)f1, (int)f2, paramList, paramBoolean);
      paramLinearLayout.setOrientation(0);
      if (k > 0) {
        paramLinearLayout.addView(localLinearLayout);
      }
    } while (j <= 0);
    if (k > 0)
    {
      if (i != 0) {
        localLayoutParams1.leftMargin = ((int)f5);
      }
    }
    else
    {
      label446:
      if (i == 0) {
        break label611;
      }
      localLayoutParams2.gravity = 16;
      localLayoutParams1.gravity = 16;
    }
    for (;;)
    {
      localLinearLayout.setLayoutParams(localLayoutParams2);
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams1);
      paramLinearLayout.addView((View)localObject);
      return;
      i = 0;
      break;
      label492:
      j = (int)f4;
      break label385;
      label500:
      arrayOfInt[0] = ((int)(this.yA - f3));
      k = a(localArrayList1, localLinearLayout, 0, arrayOfInt, (int)f8, (int)f8, paramList, paramBoolean);
      arrayOfInt[0] = ((int)(this.yA - f6 - f3));
      if (k > 0) {}
      for (j = (int)(16.0F * f7);; j = (int)f4)
      {
        j = a(localArrayList2, (LinearLayout)localObject, j, arrayOfInt, (int)f1, (int)f2, paramList, paramBoolean);
        paramLinearLayout.setOrientation(1);
        break;
      }
      localLayoutParams1.leftMargin = ((int)f6);
      break label446;
      label611:
      localLayoutParams1.topMargin = ((int)f3);
    }
  }
  
  private boolean aGy()
  {
    if (!this.jdField_a_of_type_Alcn.cwc) {
      return this.pH.remove("map_key_troop_mem_recent_said") != null;
    }
    View localView = (View)this.pH.get("map_key_troop_mem_recent_said");
    Object localObject;
    if (localView == null)
    {
      localView = this.inflater.inflate(2131563258, null);
      this.pH.put("map_key_troop_mem_recent_said", localView);
      localObject = (ImageView)localView.findViewById(2131368698);
      ((ImageView)localObject).setImageResource(2130846692);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (boolean bool = true;; bool = false)
    {
      localObject = (TextView)localView.findViewById(2131369466);
      ImageView localImageView = (ImageView)localView.findViewById(2131362978);
      localView.setTag(new albb(78, null));
      localView.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      c("map_key_troop_mem_recent_said", null, (View)localObject, localImageView);
      if (!this.isPluginInstalled)
      {
        this.isPluginInstalled = ((TroopPluginManager)this.app.getManager(119)).a("troop_member_card_plugin.apk", new arhj(this));
        if (!this.isPluginInstalled) {
          localView.setVisibility(8);
        }
      }
      for (;;)
      {
        eiv();
        return bool;
        a(localView, this.jdField_a_of_type_Alcn);
      }
    }
  }
  
  private int b(Card paramCard)
  {
    if ((paramCard != null) && (paramCard.enlargeQzonePic == 1)) {
      return 4;
    }
    return 3;
  }
  
  private void b(StringBuilder paramStringBuilder, List<PrivilegeInfo> paramList)
  {
    if ((paramStringBuilder == null) || (paramList == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        a(paramStringBuilder, (PrivilegeInfo)paramList.get(i));
        i += 1;
      }
    }
  }
  
  private List<View> c(HashMap<String, View> paramHashMap, String[] paramArrayOfString)
  {
    return ((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(paramHashMap, paramArrayOfString);
  }
  
  private boolean c(Card paramCard)
  {
    boolean bool5 = false;
    boolean bool7 = e(this.jdField_a_of_type_Alcn);
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    if (this.daH)
    {
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshAccountLevelInfoView bQQVipOpen=%s bSuperVipOpen=%s bEnterprise=%s bPrettyNumber=%s bShowAccountInfo=%s bShowMedal=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool7) }));
      }
      boolean bool6;
      if ((!bool1) && (!bool7))
      {
        if (this.pH.remove("map_key_account_level_info") != null)
        {
          return true;
          if (paramCard == null) {
            break label694;
          }
          bool4 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
          bool6 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
          if ((paramCard.lUserFlag & 1L) == 1L)
          {
            bool1 = true;
            label160:
            if ((paramCard.lUserFlag & 0x400) != 1024L) {
              break label216;
            }
          }
          label216:
          for (bool2 = true;; bool2 = false)
          {
            if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_Alcn.e)) {
              break label222;
            }
            bool3 = bool1;
            bool1 = true;
            bool5 = bool2;
            bool2 = bool3;
            bool3 = bool6;
            break;
            bool1 = false;
            break label160;
          }
          label222:
          if ((bool6) || (bool4) || (paramCard.iQQLevel >= 0))
          {
            bool3 = bool1;
            bool1 = true;
            bool5 = bool2;
            bool2 = bool3;
            bool3 = bool6;
          }
        }
        else
        {
          return false;
        }
      }
      else
      {
        paramCard = (View)this.pH.get("map_key_account_level_info");
        if (paramCard == null)
        {
          paramCard = this.inflater.inflate(2131561606, null);
          this.pH.put("map_key_account_level_info", paramCard);
          paramCard.setClickable(false);
          int i = acny.e(this.app, this.app.getCurrentUin(), false);
          anot.a(this.app, "dc00898", "", "", "0X800A8C6", "0X800A8C6", i, 0, String.valueOf(i), "", "", "");
          if (this.jdField_a_of_type_Alcn.e.pa != 0) {
            anot.a(this.app, "dc00898", "", "", "0X800A8C7", "0X800A8C7", i, 0, String.valueOf(i), "", "", "");
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          ImageView localImageView = (ImageView)paramCard.findViewById(2131362978);
          ProfileQQLevelView localProfileQQLevelView = (ProfileQQLevelView)paramCard.findViewById(2131374917);
          localProfileQQLevelView.d(this.jdField_a_of_type_Alcn, this.daH);
          View localView = localProfileQQLevelView.findViewById(2131371204);
          if (bool7)
          {
            b(this.jdField_a_of_type_Alcn, localView);
            this.pH.put("map_key_medal", localView);
            localView.setBackgroundResource(2130846690);
            localView.setTag(new albb(91, null));
            localView.setOnClickListener(this.jdField_a_of_type_Arhs);
            localProfileQQLevelView.setClickable(false);
            paramCard.setTag(new albb(69, null));
            paramCard.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
            paramCard = (FrameLayout)localProfileQQLevelView.findViewById(2131365584);
            if (paramCard != null)
            {
              paramCard.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
              paramCard.setTag(new albb(100, null));
              if (!this.daP) {
                break label660;
              }
              paramCard.setVisibility(0);
            }
          }
          for (;;)
          {
            QLog.d("ProfileCardMoreInfoView", 2, " update makeOrRefreshAccountLevelInfoView ALLOW" + this.daP);
            c("map_key_account_level_info", null, null, localImageView);
            return bool1;
            localView.setVisibility(8);
            localView.setBackgroundResource(0);
            localView.setTag(null);
            localView.setOnClickListener(null);
            break;
            label660:
            paramCard.setVisibility(8);
          }
        }
      }
      bool3 = bool1;
      bool1 = false;
      bool5 = bool2;
      bool2 = bool3;
      bool3 = bool6;
      continue;
      label694:
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
  }
  
  private boolean c(Card paramCard, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Alcn.cwc) || (this.jdField_a_of_type_Alcn.c == null) || (this.jdField_a_of_type_Alcn.c.mMemberGameInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Alcn.c.mMemberGameInfo.gameName)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "not show game info");
      }
      if (this.pH.remove("map_key_troop_mem_game_info") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    paramCard = (View)this.pH.get("map_key_troop_mem_game_info");
    if (paramCard == null)
    {
      paramCard = this.inflater.inflate(2131561579, null);
      this.pH.put("map_key_troop_mem_game_info", paramCard);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      Object localObject2 = (TextView)paramCard.findViewById(2131367867);
      TextView localTextView1 = (TextView)paramCard.findViewById(2131367869);
      localTextView1.setBackgroundDrawable(apuh.k(getResources(), Color.parseColor("#3094cf")));
      Object localObject1 = (ImageView)paramCard.findViewById(2131376611);
      TextView localTextView2 = (TextView)paramCard.findViewById(2131367870);
      TextView localTextView3 = (TextView)paramCard.findViewById(2131367871);
      ImageView localImageView = (ImageView)paramCard.findViewById(2131362978);
      TroopMemberCard.MemberGameInfo localMemberGameInfo = this.jdField_a_of_type_Alcn.c.mMemberGameInfo;
      if (localMemberGameInfo != null)
      {
        ((TextView)localObject2).setText(localMemberGameInfo.gameName);
        if ((localMemberGameInfo.descInfo != null) && (localMemberGameInfo.descInfo.size() > 0) && (!TextUtils.isEmpty((CharSequence)localMemberGameInfo.descInfo.get(0))))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText((CharSequence)localMemberGameInfo.descInfo.get(0));
        }
        if ((localMemberGameInfo.descInfo != null) && (localMemberGameInfo.descInfo.size() > 1) && (!TextUtils.isEmpty((CharSequence)localMemberGameInfo.descInfo.get(1))))
        {
          localTextView3.setVisibility(0);
          localTextView3.setText((CharSequence)localMemberGameInfo.descInfo.get(1));
        }
      }
      for (;;)
      {
        try
        {
          int i = wja.dp2px(18.0F, getResources());
          int j = wja.dp2px(18.0F, getResources());
          if (!TextUtils.isEmpty(localMemberGameInfo.levelIcon))
          {
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = j;
            ((ImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(localMemberGameInfo.levelIcon, (URLDrawable.URLDrawableOptions)localObject2));
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.levelName))
          {
            localTextView1.setVisibility(0);
            localTextView1.setText(localMemberGameInfo.levelName);
            float f = wja.dp2px(2.0F, getResources());
            i = wja.dp2px(4.0F, getResources());
            localObject1 = new GradientDrawable();
            ((GradientDrawable)localObject1).setCornerRadius(f);
            localTextView1.setPadding(i, 0, i, 0);
            if (TextUtils.isEmpty(localMemberGameInfo.gameBackGroundColor)) {
              continue;
            }
            ((GradientDrawable)localObject1).setColor(Color.parseColor(localMemberGameInfo.gameBackGroundColor));
            localTextView1.setBackgroundDrawable((Drawable)localObject1);
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.gameFontColor)) {
            localTextView1.setTextColor(Color.parseColor(localMemberGameInfo.gameFontColor));
          }
          this.daR = true;
          aqfr.b("Grp_game", "Mber_data", "game_exp", 0, 0, new String[] { this.jdField_a_of_type_Alcn.troopUin, localMemberGameInfo.gameName });
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
          continue;
        }
        paramCard.setTag(new albb(83, null));
        paramCard.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
        paramCard.setVisibility(0);
        c("map_key_troop_mem_game_info", null, null, localImageView);
        return paramBoolean;
        ((GradientDrawable)localObject1).setColor(Color.parseColor("#FFBA26"));
      }
    }
  }
  
  private List<View> d(HashMap<String, View> paramHashMap, String[] paramArrayOfString)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject;
    if ((paramHashMap == null) || (paramArrayOfString == null))
    {
      i = 0;
      if (j >= i) {
        break label136;
      }
      localObject = paramArrayOfString[j];
      if ((!"map_key_sig".equals(localObject)) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.containsKey("map_key_sign"))) {
        break label92;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      i = paramArrayOfString.length;
      break;
      label92:
      if ((!"map_key_account_base_info".equals(localObject)) || (!aGz()))
      {
        localObject = (View)paramHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    label136:
    return localArrayList;
  }
  
  private boolean d(int paramInt, View paramView)
  {
    int j = 1;
    Object localObject1 = this.ik;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (paramView != this.pH.get(localObject2)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (anlm.Vr()) {
        bool = false;
      }
      if ((bool) && (getChildCount() == 0)) {
        bool = false;
      }
      for (;;)
      {
        if (bool)
        {
          localObject2 = String.format("%s_%s", new Object[] { "map_key_divider", Integer.valueOf(paramInt) });
          localObject1 = (View)this.pH.get(localObject2);
          paramView = (View)localObject1;
          if (localObject1 == null)
          {
            paramInt = (int)(this.mDensity * 0.75F);
            if (paramInt >= 1) {
              break label238;
            }
            paramInt = j;
          }
        }
        label238:
        for (;;)
        {
          paramView = new View(getContext());
          localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout.LayoutParams)localObject1).leftMargin = ((int)this.BN);
          ((LinearLayout.LayoutParams)localObject1).topMargin = ((int)(this.mDensity * 6.0F));
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)(this.mDensity * 6.0F));
          this.pH.put(localObject2, paramView);
          paramView.setBackgroundResource(2130851090);
          addView(paramView);
          return bool;
          i += 1;
          break;
        }
      }
    }
  }
  
  private boolean d(Card paramCard)
  {
    int i = 1;
    QLog.i("ProfileCardMoreInfoView", 2, "makeOrRefreshWeiShiFeedList");
    if (this.jdField_b_of_type_Srn == null) {
      return false;
    }
    if (!this.daJ) {
      return this.pH.remove("map_key_mine_weishi") != null;
    }
    Object localObject;
    if ((View)this.pH.get("map_key_mine_weishi") == null)
    {
      localObject = this.inflater.inflate(2131559788, null);
      this.jdField_b_of_type_Srn.initUI((View)localObject);
      this.pH.put("map_key_mine_weishi", localObject);
    }
    for (boolean bool = true;; bool = false)
    {
      if (!aGz())
      {
        localObject = this.jdField_b_of_type_Srn.F();
        this.jdField_b_of_type_Srn.p();
        if ((i == 0) || (paramCard == null)) {
          break label177;
        }
        alcs.a((View)localObject, "color", this.e, "commonItemContentColor");
      }
      for (;;)
      {
        this.jdField_b_of_type_Srn.bAf();
        c("map_key_mine_weishi", null, this.jdField_b_of_type_Srn.F(), this.jdField_b_of_type_Srn.p());
        return bool;
        i = 0;
        break;
        label177:
        ((TextView)localObject).setBackgroundResource(2130839684);
      }
    }
  }
  
  private boolean d(Card paramCard, boolean paramBoolean)
  {
    int j = 0;
    if ((paramCard != null) && (ProfileActivity.AllInOne.a(this.jdField_a_of_type_Alcn.e))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if ((aGz()) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipV5View))) {
        paramBoolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshAccountBaseInfoView bShowAccountInfo=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      if (!paramBoolean) {
        return this.pH.remove("map_key_account_base_info") != null;
      }
      Object localObject1 = (View)this.pH.get("map_key_account_base_info");
      if (localObject1 == null)
      {
        localObject1 = this.inflater.inflate(2131561569, null);
        this.pH.put("map_key_account_base_info", localObject1);
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localObject1 = (ViewGroup)localObject1;
        ViewGroup localViewGroup1 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131361884);
        localViewGroup1.removeAllViews();
        ViewGroup localViewGroup2 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131361887);
        TextView localTextView;
        label311:
        Object localObject2;
        if ((ProfileActivity.AllInOne.j(this.jdField_a_of_type_Alcn.e)) || (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Alcn.e)))
        {
          localObject1 = null;
          localObject1 = a(localViewGroup1, 2130846671, (CharSequence)localObject1, 0);
          if (localObject1 != null)
          {
            localTextView = (TextView)((ViewGroup)localObject1).findViewById(2131369154);
            if (localTextView != null)
            {
              if (!this.jdField_a_of_type_Alcn.cwc) {
                break label584;
              }
              localObject1 = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_Alcn.troopUin, paramCard.uin);
              if ((localObject1 == null) || (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) || (TextUtils.isEmpty(paramCard.strReMark))) {
                break label539;
              }
              localObject1 = paramCard.strNick;
              localObject2 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject2 = aqgv.b(this.app, paramCard.uin, false);
              }
              if (!TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Alcn.troopUin)) {
                break label567;
              }
            }
          }
        }
        label410:
        label539:
        label567:
        for (localObject1 = localObject2;; localObject1 = a(localTextView, (String)localObject2, paramCard.uin))
        {
          localTextView.setText((CharSequence)localObject1);
          aqep.a(localTextView, paramCard.uin, (String)localObject2, this.jdField_a_of_type_Alcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
          if (aGA())
          {
            localObject1 = this.mActivity;
            int k = paramCard.shGender;
            if (!aqep.aBZ()) {
              break label707;
            }
            i = 0;
            a(localViewGroup1, 2130846680, aqep.a((Context)localObject1, k, i, paramCard.constellation, paramCard.strCountry, paramCard.strProvince, paramCard.strCity), 1);
          }
          if ((TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Alcn.troopUin)) || (aGA())) {
            break label916;
          }
          for (i = localViewGroup1.getChildCount(); (i < 4) && (j < 3); i = localViewGroup1.getChildCount()) {
            switch (j)
            {
            default: 
              j += 1;
            }
          }
          localObject1 = " ";
          break;
          if (TextUtils.isEmpty(paramCard.strReMark))
          {
            localObject1 = paramCard.strNick;
            break label311;
          }
          localObject1 = paramCard.strReMark;
          break label311;
        }
        label516:
        label584:
        if ((this.jdField_a_of_type_Alcn.gh != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.gh[5])) && (!TextUtils.equals(this.jdField_a_of_type_Alcn.gh[5], paramCard.strNick))) {}
        for (int i = 1;; i = 0)
        {
          if ((!TextUtils.isEmpty(paramCard.strReMark)) || (i != 0))
          {
            String str2 = a(localTextView, paramCard.strNick, paramCard.uin);
            String str1 = paramCard.strNick;
            localObject2 = str1;
            localObject1 = str2;
            if (!TextUtils.isEmpty(str2)) {
              break;
            }
            localObject1 = paramCard.uin;
            localObject2 = str1;
            break;
          }
          localObject1 = paramCard.uin;
          localObject2 = null;
          break;
          label707:
          i = paramCard.age;
          break label410;
          localObject1 = new StringBuilder();
          if (!TextUtils.isEmpty(paramCard.strCompany)) {
            ((StringBuilder)localObject1).append(paramCard.strCompany);
          }
          localObject2 = aqek.ga(paramCard.iProfession);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject2, aqek.cp[14])))
          {
            if (((StringBuilder)localObject1).length() > 0) {
              ((StringBuilder)localObject1).append(" ");
            }
            ((StringBuilder)localObject1).append((String)localObject2);
          }
          a(localViewGroup1, 2130846684, ((StringBuilder)localObject1).toString(), 1);
          break label516;
          if (TextUtils.isEmpty(paramCard.strSchool)) {
            break label516;
          }
          if (paramCard.schoolVerifiedFlag) {}
          for (localObject1 = aqep.a(paramCard.strSchool, true, 2130846073, 2131298630, 2131298629, getContext(), this.app);; localObject1 = paramCard.strSchool)
          {
            a(localViewGroup1, 2130846689, (CharSequence)localObject1, 1);
            break;
          }
          if (TextUtils.isEmpty(paramCard.strHometownDesc)) {
            break label516;
          }
          a(localViewGroup1, 2130846679, paramCard.strHometownDesc, 1);
          break label516;
          label916:
          localViewGroup2.setTag(new albb(66, paramCard.uin));
          localViewGroup2.setOnClickListener(this.jdField_a_of_type_Arhs);
          c("map_key_account_base_info", (TextView)localViewGroup2.findViewById(2131361888), (ImageView)localViewGroup2.findViewById(2131362978), null);
          return paramBoolean;
        }
      }
    }
  }
  
  private boolean d(RichStatus paramRichStatus)
  {
    if ((this.jdField_a_of_type_Alcn.e.pa != 0) && ((!ProfileActivity.AllInOne.g(this.jdField_a_of_type_Alcn.e)) || (paramRichStatus == null) || (Arrays.equals(paramRichStatus.encode(), RichStatus.getEmptyStatus().encode())))) {
      return this.pH.remove("map_key_sig") != null;
    }
    boolean bool1;
    Resources localResources;
    int i;
    int j;
    label109:
    Object localObject1;
    if (this.jdField_a_of_type_Alcn.e.pa == 0)
    {
      bool1 = true;
      localResources = getResources();
      if (!aGz()) {
        break label182;
      }
      i = localResources.getColor(2131167304);
      j = localResources.getColor(2131167304);
      localObject1 = null;
      if (paramRichStatus != null) {
        localObject1 = new SpannableString(paramRichStatus.toSpannableStringWithTopic(null, i, j, this));
      }
      if (localObject1 != null) {
        break label1569;
      }
      localObject1 = new SpannableString("");
    }
    label522:
    label1179:
    label1569:
    for (;;)
    {
      if ((!bool1) && (((SpannableString)localObject1).length() == 0))
      {
        if (this.pH.remove("map_key_sig") != null)
        {
          return true;
          bool1 = false;
          break;
          label182:
          j = localResources.getColor(2131165381);
          i = -8947849;
          break label109;
        }
        return false;
      }
      Object localObject2 = (View)this.pH.get("map_key_sig");
      if (localObject2 == null)
      {
        localObject2 = this.inflater.inflate(2131561603, null);
        this.pH.put("map_key_sig", localObject2);
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        View localView = ((View)localObject2).findViewById(2131374951);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131369154);
        LinearLayout localLinearLayout = (LinearLayout)((View)localObject2).findViewById(2131370739);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131362978);
        amhj localamhj = (amhj)this.app.getManager(15);
        localTextView.setTextColor(i);
        Object localObject3;
        label476:
        label633:
        boolean bool3;
        if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
        {
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
          localSpannableStringBuilder.insert(0, "[S] ");
          if (localamhj != null)
          {
            localObject3 = localamhj.i(paramRichStatus.actionId, 200);
            localObject3 = new arjh(localResources, (Bitmap)localObject3, false, false);
            i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
            ((BitmapDrawable)localObject3).setBounds(0, 0, i, i);
            localObject3 = new argi((Drawable)localObject3, 0);
            ((argi)localObject3).a(-0.1F);
            localSpannableStringBuilder.setSpan(localObject3, 0, "[S]".length(), 17);
            this.bsd = i;
            localTextView.setText(new aofk(localSpannableStringBuilder, 1, 20));
            localTextView.setMovementMethod(LinkMovementMethod.getInstance());
            if (((SpannableString)localObject1).length() != 0)
            {
              if ((paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0))
              {
                if (this.jdField_a_of_type_Alcn.e.pa != 0) {
                  break label1123;
                }
                i = 1;
                anot.a(null, "dc00898", "", "", "0X800A4D2", "0X800A4D2", i, 0, "0" + i, "0", "", "");
              }
              if ((!aldf.a().bm(this.app)) && (paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0) && (!this.daS))
              {
                if (paramRichStatus.plainText.size() <= 0) {
                  break label1128;
                }
                localObject1 = (String)paramRichStatus.plainText.get(0);
                this.cAt = ((String)localObject1);
                paramRichStatus.sortTopicPos();
                if ((paramRichStatus.topicsPos == null) || (paramRichStatus.topicsPos.size() <= 0)) {
                  break label1134;
                }
                i = ((Integer)((Pair)paramRichStatus.topicsPos.get(0)).second).intValue();
                label685:
                this.mPos = i;
                if (!isVisible(localTextView)) {
                  break label1139;
                }
                localTextView.post(new ProfileCardMoreInfoView.7(this, localTextView, paramRichStatus));
              }
              label715:
              aldf.a().c(this.app, paramRichStatus);
              bool3 = aldf.a().bn(this.app);
              localObject2 = (ImageView)((View)localObject2).findViewById(2131379884);
              localObject1 = new oidb_0xd9f.RspBody();
              if ((this.jdField_a_of_type_Alcn.d == null) || (this.jdField_a_of_type_Alcn.d.vLongNickTopicInfo == null)) {
                break label1230;
              }
            }
          }
        }
        try
        {
          ((oidb_0xd9f.RspBody)localObject1).mergeFrom(this.jdField_a_of_type_Alcn.d.vLongNickTopicInfo);
          localObject1 = (oidb_0xd9f.LongNickItem)((oidb_0xd9f.RspBody)localObject1).longnick_item.get();
          if (localObject1 == null) {
            break label1179;
          }
          localObject1 = ((oidb_0xd9f.LongNickItem)localObject1).rpt_topic_item.get();
          label827:
          if ((!bool3) && (!aldf.a().k(this.app, aldf.a().e((List)localObject1)))) {
            break label1219;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (aldf.a().w((List)localObject1) <= 0)) {
            break label1185;
          }
          localLinearLayout.setTag(new albb(97, aldf.a().d((List)localObject1)));
          localLinearLayout.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
          a(localLinearLayout, (List)localObject1);
          ((ImageView)localObject2).setOnTouchListener(jll.a);
          ((ImageView)localObject2).setOnClickListener(new arhk(this, localLinearLayout));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label944:
            if (QLog.isColorLevel())
            {
              QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
              continue;
              L(localLinearLayout, bool1);
            }
          }
        }
        localObject1 = new StringBuilder();
        if (paramRichStatus != null)
        {
          if (paramRichStatus.actionText != null) {
            ((StringBuilder)localObject1).append(paramRichStatus.actionText);
          }
          if (paramRichStatus.dataText != null) {
            ((StringBuilder)localObject1).append(paramRichStatus.dataText);
          }
          label1123:
          label1128:
          if (paramRichStatus.topics != null)
          {
            i = 0;
            label1000:
            if (i < paramRichStatus.topics.size())
            {
              if (TextUtils.isEmpty((CharSequence)((Pair)paramRichStatus.topics.get(i)).second)) {}
              for (;;)
              {
                i += 1;
                break label1000;
                localObject3 = aqcu.decodeResource(localResources, 2130850435);
                break;
                this.bsd = 0;
                if ((((SpannableString)localObject1).length() == 0) && (bool1))
                {
                  localTextView.setText(2131701614);
                  L(localLinearLayout, bool1);
                  break label476;
                }
                localTextView.setText(new aofk((CharSequence)localObject1, 1, 20));
                localTextView.setMovementMethod(LinkMovementMethod.getInstance());
                break label476;
                i = 2;
                break label522;
                localObject1 = null;
                break label633;
                label1134:
                i = 0;
                break label685;
                label1139:
                this.K = localTextView;
                this.cAs = ((String)((Pair)paramRichStatus.topics.get(0)).second);
                this.bkj = paramRichStatus.actionText;
                break label715;
                localObject1 = null;
                break label827;
                L(localLinearLayout, bool1);
                break label944;
                L(localLinearLayout, bool1);
                break label944;
                localException.append((String)((Pair)paramRichStatus.topics.get(i)).second);
              }
            }
          }
          label1185:
          label1219:
          label1230:
          if (paramRichStatus.plainText != null) {}
          for (i = paramRichStatus.plainText.size();; i = 0)
          {
            j = 0;
            while (j < i)
            {
              localObject2 = (String)paramRichStatus.plainText.get(j);
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localException.append((String)localObject2);
              }
              j += 1;
            }
          }
        }
        localView.setContentDescription(acfp.m(2131709948) + localException);
        if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
        {
          this.jdField_a_of_type_Alcn.richStatus = paramRichStatus;
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$a == null) && (localamhj != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$a = new a(this);
            localamhj.addListener(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$a);
          }
          localView.setTag(new albb(3, localException));
          if ((this.jdField_a_of_type_Alcn.e == null) || ((this.jdField_a_of_type_Alcn.e.pa != 0) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e)))) {
            break label1540;
          }
          localImageView.setVisibility(0);
          localView.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
          label1485:
          if (!bool1) {
            break label1549;
          }
          c("map_key_sig", null, null, localImageView);
        }
        for (;;)
        {
          return bool2;
          this.jdField_a_of_type_Alcn.richStatus = null;
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$a == null) || (localamhj == null)) {
            break;
          }
          localamhj.removeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$a);
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$a = null;
          break;
          localImageView.setVisibility(4);
          break label1485;
          c("map_key_sig", null, localTextView, localImageView);
        }
      }
    }
  }
  
  private boolean e(Card paramCard)
  {
    boolean bool1;
    boolean bool2;
    if ((!ProfileActivity.AllInOne.g(this.jdField_a_of_type_Alcn.e)) || (paramCard == null) || (this.daH))
    {
      if (this.pH.remove("map_key_qzone") != null) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        return bool2;
      }
    }
    ThreadManager.post(new ProfileCardMoreInfoView.2(this), 8, null, true);
    View localView1 = (View)this.pH.get("map_key_qzone");
    label114:
    ViewGroup localViewGroup;
    Object localObject3;
    TextView localTextView1;
    ImageView localImageView1;
    label194:
    List localList;
    Object localObject1;
    int m;
    int i;
    int j;
    int n;
    int i1;
    label652:
    int k;
    label655:
    String str;
    View localView3;
    ImageView localImageView2;
    View localView4;
    View localView2;
    View localView5;
    TextView localTextView2;
    if (localView1 == null)
    {
      localView1 = this.inflater.inflate(2131561597, null);
      this.pH.put("map_key_qzone", localView1);
      bool1 = true;
      localViewGroup = (ViewGroup)localView1.findViewById(2131369207);
      localObject3 = (ViewGroup)localView1.findViewById(2131369208);
      localTextView1 = (TextView)localView1.findViewById(2131379562);
      localImageView1 = (ImageView)localView1.findViewById(2131368865);
      localTextView1.setSingleLine(true);
      localTextView1.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      if ((paramCard.ulShowControl & 0x80) != 0)
      {
        bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshQZone card.ulShowControl=%x hasLocked=%s", new Object[] { Integer.valueOf(paramCard.ulShowControl), Boolean.valueOf(bool2) }));
        }
        if ((bool2) || ((!paramCard.isShowPhoto()) && (!paramCard.hasFakeData)) || (!paramCard.hasGotPhotoUrl())) {
          break label1712;
        }
        localList = paramCard.getQZonePhotoList();
        if (this.jdField_a_of_type_Alcn.e.pa == 0)
        {
          if ((localList == null) || (localList.size() < this.ehw)) {
            break label958;
          }
          this.ehw = localList.size();
        }
        localViewGroup.removeAllViews();
        localViewGroup.setVisibility(0);
        if ((localObject3 != null) && (((ViewGroup)localObject3).getVisibility() != 8))
        {
          ((ViewGroup)localObject3).removeAllViews();
          ((ViewGroup)localObject3).setVisibility(8);
        }
        localTextView1.setVisibility(8);
        if ((localList == null) || (localList.isEmpty())) {
          break label1470;
        }
        localObject1 = getResources();
        m = ((Resources)localObject1).getDimensionPixelSize(2131298784);
        i = ((Resources)localObject1).getDimensionPixelSize(2131297956);
        j = aqnm.dpToPx(30.0F);
        n = (int)(this.of - i - j);
        i = a(paramCard);
        i1 = (int)((n - (i - 1) * m) * 1.0F) / i;
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
        }
        if ((this.jdField_a_of_type_Alcn.e.pa != 0) || ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.app.getLongAccountUin()) & 0x4000) == 0)) {
          break label2019;
        }
        localObject1 = this.inflater.inflate(2131561600, null);
        if (ThemeUtil.isInNightMode(this.app)) {
          ((View)localObject1).setBackgroundColor(Color.parseColor("#77F5F6FA"));
        }
        localViewGroup.addView((View)localObject1);
        localObject3 = ((View)localObject1).getLayoutParams();
        if ((localObject3 instanceof LinearLayout.LayoutParams))
        {
          localObject3 = (LinearLayout.LayoutParams)localObject3;
          ((LinearLayout.LayoutParams)localObject3).width = i1;
          ((LinearLayout.LayoutParams)localObject3).height = i1;
          ((LinearLayout.LayoutParams)localObject3).rightMargin = m;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        i = 0 + i1;
        ((View)localObject1).setOnClickListener(new arhh(this));
        LpReportInfo_pf00064.allReport(699, 7);
        k = 0;
        if (k >= localList.size()) {
          break label1470;
        }
        PhotoInfo localPhotoInfo = (PhotoInfo)localList.get(k);
        str = localPhotoInfo.strPicUrl;
        localView3 = this.inflater.inflate(2131561598, null);
        localImageView2 = (ImageView)localView3.findViewById(2131369210);
        localView4 = localView3.findViewById(2131369215);
        localView2 = localView3.findViewById(2131369209);
        localView5 = localView3.findViewById(2131369214);
        localTextView2 = (TextView)localView3.findViewById(2131369206);
        UnderlineTextView localUnderlineTextView = (UnderlineTextView)localView3.findViewById(2131369205);
        localUnderlineTextView.setEditableFactory(aofr.a);
        localObject3 = "";
        if (localPhotoInfo.mapEx == null) {
          break label2009;
        }
        localObject1 = (String)localPhotoInfo.mapEx.get("info_type");
        localObject3 = (String)localPhotoInfo.mapEx.get("feeds_content");
        bool2 = "1".equals(localPhotoInfo.mapEx.get("isVideo"));
        label847:
        if ((!TextUtils.equals((CharSequence)localObject1, "1")) || (TextUtils.isEmpty((CharSequence)localObject3))) {
          break label995;
        }
        localUnderlineTextView.setText((CharSequence)localObject3);
        localUnderlineTextView.setVisibility(0);
        localImageView2.setVisibility(8);
        localObject1 = localUnderlineTextView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = i1;
        ((ViewGroup.LayoutParams)localObject1).height = i1;
        j = localUnderlineTextView.getLineHeight();
        if (j <= 0) {
          break label965;
        }
        localUnderlineTextView.setMaxLines(b(paramCard));
        label927:
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        QLog.w("ProfileCardMoreInfoView", 1, "makeOrRefreshQZone: needUpdateUI=false,skip this one");
        label943:
        k += 1;
        break label655;
        bool2 = false;
        break label194;
        label958:
        paramCard.hasFakeData = false;
        return true;
        label965:
        QLog.w("ProfileCardMoreInfoView", 1, "makeOrRefreshQZone: invalid lineHeight:" + j);
        break label927;
        label995:
        if (TextUtils.isEmpty(str)) {
          break label2004;
        }
        if (ThemeUtil.isInNightMode(this.app)) {
          localImageView2.setColorFilter(1996488704);
        }
        if (this.jdField_t_of_type_AndroidGraphicsDrawableColorDrawable == null) {
          this.jdField_t_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131165887));
        }
        for (;;)
        {
          try
          {
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_t_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_t_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i1;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i1;
            if ((str.startsWith("http://")) || (str.startsWith("https://")))
            {
              localImageView2.setImageDrawable(URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject1));
              if ((!str.contains("video=1")) && (!bool2)) {
                break label1256;
              }
              localView4.setVisibility(0);
              if (((PhotoInfo)localList.get(k)).IsOnlySelf != 1) {
                break label1266;
              }
              localView5.setVisibility(0);
              break label2030;
            }
            if (!bool2) {
              break label1241;
            }
            localObject1 = ShortVideoUtils.getVideoThumbnail(this.mContext, str, i1, 0L);
            if (localObject1 != null)
            {
              localImageView2.setImageBitmap((Bitmap)localObject1);
              continue;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshQZone fail!", localException);
            }
            j = 1;
          }
          localImageView2.setImageDrawable(this.jdField_t_of_type_AndroidGraphicsDrawableColorDrawable);
          continue;
          label1241:
          localImageView2.setImageDrawable(URLDrawable.getFileDrawable(str, localException));
          continue;
          label1256:
          localView4.setVisibility(8);
        }
        label1266:
        localView5.setVisibility(8);
        break label2030;
      }
      localViewGroup.addView(localView3);
      Object localObject2 = localView3.getLayoutParams();
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = m;
        localView3.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = localImageView2.getLayoutParams();
      if (aGA())
      {
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        label1345:
        localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = localView2.getLayoutParams();
        if (!aGA()) {
          break label1678;
        }
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        label1378:
        localView2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        j = i;
        if (i > 0) {
          j = i + m;
        }
        i = j + i1;
        if (i + i1 + m <= n) {
          break label1695;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
        }
        label1470:
        if (!TextUtils.isEmpty(paramCard.strQzoneHeader))
        {
          localTextView1.setVisibility(0);
          localTextView1.setText(paramCard.strQzoneHeader);
        }
        if (this.jdField_a_of_type_Alcn.e.pa == 0) {
          localTextView1.setText(acfp.m(2131709908));
        }
        label1519:
        if (localTextView1.getText() != null) {
          break label1991;
        }
      }
      label1678:
      label1695:
      label1712:
      label1991:
      for (localObject2 = "";; localObject2 = (String)localTextView1.getText())
      {
        localView1.setTag(new albb(5, null));
        localView1.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
        localView1.setContentDescription(getString(2131692219));
        c("map_key_qzone", null, localTextView1, localImageView1);
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("makeOrRefreshQZone, [h:%s, des: %s, space: %s, remark: %s, nick: %s, info: %s]", new Object[] { paramCard.strQzoneHeader, paramCard.strQzoneFeedsDesc, paramCard.strSpaceName, this.jdField_a_of_type_Alcn.gh[4], this.jdField_a_of_type_Alcn.gh[0], localObject2 }));
        return bool1;
        ((ViewGroup.LayoutParams)localObject2).width = i1;
        ((ViewGroup.LayoutParams)localObject2).height = i1;
        break label1345;
        ((ViewGroup.LayoutParams)localObject2).width = i1;
        ((ViewGroup.LayoutParams)localObject2).height = i1;
        break label1378;
        localView2.setVisibility(8);
        localTextView2.setVisibility(8);
        break label943;
        if ((!bool2) && (paramCard.isShowFeeds()) && (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)))
        {
          localViewGroup.setVisibility(8);
          localTextView1.setVisibility(0);
          localTextView1.setText(alse.e(paramCard.strQzoneFeedsDesc, this.app));
          break label1519;
        }
        if (!TextUtils.isEmpty(paramCard.strSpaceName))
        {
          localViewGroup.setVisibility(8);
          localTextView1.setVisibility(0);
          localTextView1.setText(paramCard.strSpaceName);
          break label1519;
        }
        localViewGroup.setVisibility(8);
        localTextView1.setVisibility(0);
        localObject2 = a(this.jdField_a_of_type_Alcn);
        if (this.jdField_a_of_type_Alcn.e.pa == 0) {
          localObject2 = acfp.m(2131709947);
        }
        localTextView1.setText(String.format("%s%s", new Object[] { localObject2, getString(2131694934) }));
        if ((this.jdField_a_of_type_Alcn.e.pa != 0) || (!paramCard.showPublishButton) || (localObject3 == null) || ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.app.getLongAccountUin()) & 0x4000) == 0)) {
          break label1519;
        }
        ((ViewGroup)localObject3).removeAllViews();
        ((ViewGroup)localObject3).setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardMoreInfoView", 2, "no photo, show writeMoodContainer view.");
        }
        localObject2 = this.inflater.inflate(2131561601, null);
        ((ViewGroup)localObject3).addView((View)localObject2);
        ((View)localObject2).setOnClickListener(new arhi(this));
        LpReportInfo_pf00064.allReport(699, 7);
        break label1519;
      }
      label2004:
      j = 0;
      continue;
      label2009:
      bool2 = false;
      localObject2 = "";
      break label847;
      label2019:
      i = 0;
      break label652;
      bool1 = false;
      break label114;
      label2030:
      j = 1;
    }
  }
  
  private boolean e(Card paramCard, boolean paramBoolean)
  {
    paramBoolean = false;
    boolean bool;
    if ((paramCard == null) || (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Alcn.e))) {
      if (this.pH.remove("map_key_favor") != null)
      {
        paramBoolean = true;
        bool = paramBoolean;
      }
    }
    LinearLayout localLinearLayout1;
    do
    {
      return bool;
      paramBoolean = false;
      break;
      LinearLayout localLinearLayout2 = (LinearLayout)this.pH.get("map_key_favor");
      localLinearLayout1 = localLinearLayout2;
      if (localLinearLayout2 == null)
      {
        localLinearLayout1 = (LinearLayout)LayoutInflater.from(this.mActivity).inflate(2131561552, null, false);
        localLinearLayout1.setTag(2131367712, Boolean.TRUE);
        this.pH.put("map_key_favor", localLinearLayout1);
        paramBoolean = true;
      }
      bool = paramBoolean;
    } while (!(this.mActivity instanceof FriendProfileCardActivity));
    a(localLinearLayout1, paramCard);
    if (this.ehu > 0) {
      return true;
    }
    this.pH.remove("map_key_favor");
    return paramBoolean;
  }
  
  private void eiu()
  {
    this.mActivity.getIntent().putExtra("writeMoodFromProfileCard", true);
    avpw.s(this.mActivity, this.app.getCurrentAccountUin(), 1037);
    LpReportInfo_pf00064.allReport(699, 8);
    LpReportInfo_pf00064.allReport(586, 1, 6);
  }
  
  private void eiw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update more info");
    }
    removeAllViews();
    List localList;
    int j;
    label50:
    int k;
    label107:
    int m;
    label110:
    View localView4;
    if (aGA())
    {
      localList = c(this.pH, this.gi);
      if (aGz()) {
        break label215;
      }
      j = 1;
      View localView1 = (View)this.pH.get("map_key_phone");
      View localView2 = (View)this.pH.get("map_key_photo_wall");
      View localView3 = (View)this.pH.get("map_key_sticky_note");
      int i = 0;
      if (localList == null) {
        break label220;
      }
      k = localList.size();
      m = 0;
      if (m >= k) {
        break label489;
      }
      localView4 = (View)localList.get(m);
      if (localView4 != localView1) {
        break label225;
      }
      label137:
      if ((localView4.getVisibility() != 0) && (localView4 != localView2) && (localView4 != localView3)) {
        localView4.setVisibility(0);
      }
      if ((j != 0) || (!d(i, localView4))) {
        break label490;
      }
      i += 1;
    }
    label215:
    label220:
    label225:
    label489:
    label490:
    for (;;)
    {
      addView(localView4);
      m += 1;
      break label110;
      localList = d(this.pH, this.gi);
      break;
      j = 0;
      break label50;
      k = 0;
      break label107;
      if ((localView4 instanceof ProfileCardFavorShowView))
      {
        localObject = (ProfileCardFavorShowView)localView4;
        if ((j != 0) && (!aGA()))
        {
          alcs.a(((ProfileCardFavorShowView)localObject).mTitleBar, "background", this.e, "commonItemTopBorderBackground");
          break label137;
        }
        ((ProfileCardFavorShowView)localObject).mTitleBar.setBackgroundResource(2130839684);
        break label137;
      }
      if (((localView4 instanceof ViewGroup)) && (localView4.getTag(2131367712) == Boolean.TRUE))
      {
        localObject = (ViewGroup)localView4;
        int i1 = ((ViewGroup)localObject).getChildCount();
        int n = 0;
        View localView5;
        if (n < i1)
        {
          localView5 = ((ViewGroup)localObject).getChildAt(n);
          if ((localView5 != null) && ((localView5 instanceof ProfileCardFavorShowView)) && (localView5.getTag(2131367713) != Boolean.TRUE))
          {
            if (j == 0) {
              break label409;
            }
            if (!aGA()) {
              alcs.a(((ProfileCardFavorShowView)localView5).mTitleBar, "background", this.e, "commonItemTopBorderBackground");
            }
          }
        }
        for (;;)
        {
          n += 1;
          break label325;
          break;
          ((ProfileCardFavorShowView)localView5).mTitleBar.setBackgroundResource(2130839684);
        }
      }
      if (j != 0)
      {
        if (aGA()) {
          break label137;
        }
        alcs.a(localView4, "background", this.e, "commonItemTopBorderBackground");
        break label137;
      }
      Object localObject = localView4.findViewById(2131374951);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130839684);
      }
      localView4.setBackgroundResource(2130839684);
      break label137;
      return;
    }
  }
  
  private boolean f(Card paramCard, boolean paramBoolean)
  {
    boolean bool4 = true;
    boolean bool3 = true;
    boolean bool1;
    label45:
    boolean bool2;
    if ((this.jdField_a_of_type_Arho == null) || (this.jdField_a_of_type_Arho.mI(8)))
    {
      bool1 = true;
      if ((!paramBoolean) || (paramCard == null) || (paramCard.switch_sticky_note == 1)) {
        break label196;
      }
      paramBoolean = true;
      boolean bool5 = ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e);
      bool2 = avsn.aLx();
      if ((!bool1) || (!paramBoolean) || (!bool5) || (!bool2)) {
        break label201;
      }
      bool2 = true;
      label83:
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardMoreInfoView", 2, String.format("makeOrRefreshStickyNote showStickyNote=%s configEnable=%s switchEnable=%s isFriend=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool5) }));
      }
      if ((paramCard != null) && (bool2)) {
        break label212;
      }
      if (this.pH.remove("map_key_sticky_note") == null) {
        break label207;
      }
      paramBoolean = bool3;
      label160:
      bool1 = paramBoolean;
      if (paramBoolean)
      {
        bool1 = paramBoolean;
        if (this.jdField_a_of_type_Awbq != null)
        {
          this.jdField_a_of_type_Awbq.destroy();
          this.jdField_a_of_type_Awbq = null;
          bool1 = paramBoolean;
        }
      }
    }
    label196:
    label201:
    label207:
    label212:
    ProfileCardFavorShowView localProfileCardFavorShowView;
    do
    {
      return bool1;
      bool1 = false;
      break;
      paramBoolean = false;
      break label45;
      bool2 = false;
      break label83;
      paramBoolean = false;
      break label160;
      if ((ProfileCardFavorShowView)this.pH.get("map_key_sticky_note") != null) {
        break label328;
      }
      localProfileCardFavorShowView = new ProfileCardFavorShowView(this.mActivity);
      localProfileCardFavorShowView.setTitle(getString(2131692197));
      localProfileCardFavorShowView.setShowArrow(false);
      localProfileCardFavorShowView.setMarginBottomEnable(false);
      localProfileCardFavorShowView.setVisibility(8);
      this.pH.put("map_key_sticky_note", localProfileCardFavorShowView);
      bool1 = bool4;
    } while (this.jdField_a_of_type_Awbq != null);
    this.jdField_a_of_type_Awbq = new awbq();
    this.jdField_a_of_type_Awbq.a(this.mActivity, this.app, paramCard, this.jdField_b_of_type_ComTencentWidgetListView, localProfileCardFavorShowView);
    return true;
    label328:
    return false;
  }
  
  private boolean g(Card paramCard)
  {
    boolean bool1 = false;
    if ((paramCard == null) || (paramCard.lCurrentStyleId != alcs.agi)) {
      return this.pH.remove("map_key_tag") != null;
    }
    if (this.jdField_a_of_type_Alcn.cwc) {
      return this.pH.remove("map_key_tag") != null;
    }
    Object localObject2 = (View)this.pH.get("map_key_tag");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.inflater.inflate(2131561607, null);
      this.pH.put("map_key_tag", localObject1);
      bool1 = true;
    }
    localObject2 = (AdaptiveLayout)((View)localObject1).findViewById(2131379215);
    int j = getResources().getDimensionPixelSize(2131298990);
    int i = 7;
    if (this.jdField_a_of_type_Alcn.e.pa == 0) {
      i = 8;
    }
    int k;
    if (this.jdField_t_of_type_ArrayOfAndroidWidgetTextView == null)
    {
      ((AdaptiveLayout)localObject2).setGap(j, j);
      this.jdField_t_of_type_ArrayOfAndroidWidgetTextView = new TextView[i];
      k = getResources().getDimensionPixelSize(2131298988);
      int m = getResources().getDimensionPixelSize(2131298991);
      int n = getResources().getDimensionPixelSize(2131298994);
      j = 0;
      if (j < i)
      {
        localObject1 = new TextView(getContext());
        this.jdField_t_of_type_ArrayOfAndroidWidgetTextView[j] = localObject1;
        ((TextView)localObject1).setBackgroundResource(2130847914);
        ((TextView)localObject1).setPadding(m, m, m, m);
        ((TextView)localObject1).setTextSize(0, k);
        ((TextView)localObject1).setTextColor(-16777216);
        ((TextView)localObject1).setGravity(17);
        if (7 == j)
        {
          k = getResources().getDimensionPixelSize(2131298995);
          ((TextView)localObject1).setTextSize(0, k);
          ((TextView)localObject1).setTag(new albb(47, null));
          ((TextView)localObject1).setText("+");
          ((TextView)localObject1).setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
          ((TextView)localObject1).setPadding(n, 0, n, 0);
        }
        for (;;)
        {
          ((AdaptiveLayout)localObject2).addView((View)localObject1);
          j += 1;
          break;
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
    localObject1 = paramCard.getLabelList();
    boolean bool2 = bool1;
    if (localObject2 != null)
    {
      bool2 = bool1;
      if (localObject1 != null)
      {
        label424:
        label471:
        Object localObject3;
        if (((List)localObject1).size() > 7)
        {
          j = 7;
          k = 0;
          if (k >= i) {
            break label598;
          }
          localObject2 = this.jdField_t_of_type_ArrayOfAndroidWidgetTextView[k];
          if (k >= j) {
            break label555;
          }
          ((TextView)localObject2).setText(((ProfileLabelInfo)((List)localObject1).get(k)).labelName);
          ((TextView)localObject2).setVisibility(0);
          if (((TextView)localObject2).getVisibility() == 0)
          {
            localObject3 = ((TextView)localObject2).getBackground();
            if ((localObject3 instanceof GradientDrawable))
            {
              localObject3 = (GradientDrawable)localObject3;
              if (paramCard.backgroundColor != 1L) {
                break label572;
              }
              ((GradientDrawable)localObject3).setColor(-2130706433);
              ((GradientDrawable)localObject3).setStroke(1, 855638016);
              ((TextView)localObject2).setTextColor(-16777216);
            }
          }
        }
        for (;;)
        {
          k += 1;
          break label424;
          j = ((List)localObject1).size();
          break;
          label555:
          if (k >= 7) {
            break label471;
          }
          ((TextView)localObject2).setVisibility(8);
          break label471;
          label572:
          ((GradientDrawable)localObject3).setColor(-2147483648);
          ((GradientDrawable)localObject3).setStroke(1, 872415231);
          ((TextView)localObject2).setTextColor(-1);
        }
        label598:
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private boolean g(Card paramCard, boolean paramBoolean)
  {
    paramBoolean = true;
    boolean bool1 = true;
    Object localObject1;
    if ((paramCard == null) || (!paramCard.isShowCard) || (paramCard.extendFriendFlag != 1))
    {
      if (this.pH.remove("map_key_extend_friend_info") != null)
      {
        paramBoolean = true;
        if (QLog.isDevelopLevel())
        {
          if (paramCard != null) {
            break label94;
          }
          localObject1 = "null";
          label53:
          if (paramCard != null) {
            break label106;
          }
        }
      }
      label94:
      label106:
      for (paramCard = "null";; paramCard = Integer.valueOf(paramCard.extendFriendFlag))
      {
        QLog.i("ProfileCardMoreInfoView", 4, String.format("extend friend [%s, %s]", new Object[] { localObject1, paramCard }));
        return paramBoolean;
        paramBoolean = false;
        break;
        localObject1 = Boolean.valueOf(paramCard.isShowCard);
        break label53;
      }
    }
    boolean bool2 = TextUtils.equals(paramCard.uin, this.app.getCurrentAccountUin());
    int j;
    if (bool2)
    {
      if (paramCard.extendFriendEntryAddFriend == 0)
      {
        if (this.pH.remove("map_key_extend_friend_info") != null) {}
        for (;;)
        {
          paramBoolean = bool1;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("ProfileCardMoreInfoView", 4, "extend friend self add friend flag is zero");
          return bool1;
          bool1 = false;
        }
      }
    }
    else
    {
      localObject1 = aqmj.a(this.app.getCurrentAccountUin(), "extend_friend_config_785");
      j = ((SharedPreferences)localObject1).getInt("sp_extend_friend_entry_add_friend", 0);
      if (!((SharedPreferences)localObject1).contains("sp_extend_friend_entry_add_friend")) {
        break label1061;
      }
    }
    label774:
    label920:
    label1056:
    label1061:
    for (int i = ((SharedPreferences)localObject1).getInt("sp_extend_friend_entry_add_friend", 0);; i = 1)
    {
      if ((j == 0) || (i != 1) || (TextUtils.isEmpty(paramCard.declaration)))
      {
        if (this.pH.remove("map_key_extend_friend_info") != null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("ProfileCardMoreInfoView", 4, String.format("extend friend guest [%s, %s, %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramCard.declaration }));
          }
          return paramBoolean;
        }
      }
      if (!((afsi)this.app.getManager(264)).isResourceReady())
      {
        if (this.pH.remove("map_key_extend_friend_info") != null) {}
        for (bool1 = paramBoolean;; bool1 = false)
        {
          paramBoolean = bool1;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("ProfileCardMoreInfoView", 4, "extend friend resource is not ready");
          return bool1;
        }
      }
      bool1 = ThemeUtil.isInNightMode(this.app);
      if (this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs != null)
      {
        i = 1;
        localObject1 = (ProfileCardFavorShowView)this.pH.get("map_key_extend_friend_info");
        if (localObject1 != null) {
          break label1056;
        }
        localObject1 = new ProfileCardFavorShowView(this.mActivity);
        ((ProfileCardFavorShowView)localObject1).setTitle(getString(2131692166));
        ((ProfileCardFavorShowView)localObject1).setVisibility(8);
        ((ProfileCardFavorShowView)localObject1).setOnClickListener(null);
        if (this.daT) {
          ((ProfileCardFavorShowView)localObject1).setShowArrow(false);
        }
        this.pH.put("map_key_extend_friend_info", localObject1);
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Object localObject2 = ((ProfileCardFavorShowView)localObject1).mTitleBar;
        ((View)localObject2).setTag(new albb(87, null));
        ((View)localObject2).setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
        ((View)localObject2).setContentDescription(getString(2131692166));
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if (bool2) {
          if (TextUtils.isEmpty(paramCard.declaration))
          {
            localObject2 = ((ProfileCardFavorShowView)localObject1).getChildAt(0);
            if ((localObject2 == null) || (!Boolean.TRUE.equals(((View)localObject2).getTag(0))) || (!new Boolean(bool1).equals(((View)localObject2).getTag(1))) || (!this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs.equals(((View)localObject2).getTag(2))))
            {
              ((ProfileCardFavorShowView)localObject1).removeAllViews();
              if ((!bool1) && (i == 0)) {
                break label920;
              }
              localObject2 = LayoutInflater.from(getContext()).inflate(2131561578, null);
              ((View)localObject2).setTag(2131373633, Boolean.valueOf(true));
              ((View)localObject2).setTag(2131373634, Boolean.valueOf(bool1));
              ((View)localObject2).setTag(2131373632, this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs);
              localObject3 = (TextView)((View)localObject2).findViewById(2131380517);
              localObject4 = (TextView)((View)localObject2).findViewById(2131380518);
              if (i != 0)
              {
                localObject5 = this.e.gB.get("commonItemContentColor");
                if (localObject5 != null)
                {
                  if (!(localObject5 instanceof ColorStateList)) {
                    break label871;
                  }
                  ((TextView)localObject3).setTextColor((ColorStateList)localObject5);
                  ((TextView)localObject4).setTextColor((ColorStateList)localObject5);
                }
              }
              ((View)localObject2).setClickable(true);
              localObject3 = ((View)localObject2).findViewById(2131380516);
              ((View)localObject3).setOnClickListener(new arhl(this, paramCard));
              ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
              if (bool1) {
                c("map_key_extend_friend_info", null, (View)localObject3, null);
              }
            }
            label826:
            a(((ProfileCardFavorShowView)localObject1).eR, this.app, paramCard);
          }
        }
        for (;;)
        {
          if ((this.mActivity instanceof FriendProfileCardActivity)) {
            c("map_key_extend_friend_info", null, ((ProfileCardFavorShowView)localObject1).mTitleText, null);
          }
          return paramBoolean;
          i = 0;
          break;
          label871:
          if (!(localObject5 instanceof String)) {
            break label774;
          }
          localObject5 = (String)localObject5;
          if (!((String)localObject5).startsWith("#")) {
            break label774;
          }
          ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject5));
          ((TextView)localObject4).setTextColor(Color.parseColor((String)localObject5));
          break label774;
          localObject3 = LayoutInflater.from(getContext()).inflate(2131561577, null);
          localObject4 = ((View)localObject3).findViewById(2131377455);
          localObject5 = afxw.kL("expand_summary_default_bg.png");
          localObject2 = localObject3;
          if (!ahbj.isFileExists((String)localObject5)) {
            break label774;
          }
          localObject2 = afxw.decodeFile((String)localObject5, null);
          float f = ((Bitmap)localObject2).getWidth() / ((Bitmap)localObject2).getHeight();
          ((View)localObject4).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(getResources().getDisplayMetrics().widthPixels / f)));
          ((View)localObject4).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject2));
          localObject2 = localObject3;
          break label774;
          a(paramCard, (ProfileCardFavorShowView)localObject1);
          break label826;
          a(paramCard, (ProfileCardFavorShowView)localObject1);
        }
      }
    }
  }
  
  private boolean h(Card paramCard)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (paramCard == null) {
      bool2 = bool1;
    }
    boolean bool5;
    Object localObject1;
    int i;
    label71:
    do
    {
      do
      {
        return bool2;
        bool5 = paramCard.uin.equals(this.app.getCurrentAccountUin());
        localObject1 = (View)this.pH.get("map_key_mini_playing");
        ThemeUtil.isInNightMode(this.app);
        if (this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs == null) {
          break;
        }
        i = 1;
        if (!paramCard.isShowMiniPlaying) {
          break label713;
        }
        if (localObject1 != null) {
          break label414;
        }
        localObject1 = new ProfileCardFavorShowView(this.mActivity);
        if (!bool5) {
          break label282;
        }
        bool2 = bool1;
      } while (paramCard.miniAppInfoArrayList == null);
      bool2 = bool1;
    } while (paramCard.miniAppInfoArrayList.size() <= 0);
    ((ProfileCardFavorShowView)localObject1).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingName", "最近在玩"));
    bool1 = bool3;
    if (paramCard.miniAppInfoArrayList.size() > 1) {
      bool1 = true;
    }
    ((ProfileCardFavorShowView)localObject1).setShowArrow(bool1);
    Object localObject2 = new MiniAppProfileCardView(this.mActivity);
    ((MiniAppProfileCardView)localObject2).setData(paramCard.miniAppInfoArrayList);
    ((ProfileCardFavorShowView)localObject1).setVisibility(8);
    ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
    if (i != 0) {
      a((MiniAppProfileCardView)localObject2);
    }
    label218:
    this.pH.put("map_key_mini_playing", localObject1);
    MiniAppUtils.reportProfileCardExposed(paramCard, bool5);
    paramCard = (Card)localObject1;
    bool1 = true;
    for (;;)
    {
      bool2 = bool1;
      if (paramCard == null) {
        break;
      }
      c("map_key_mini_playing", null, (TextView)paramCard.findViewById(2131379562), (ImageView)paramCard.findViewById(2131368865));
      return bool1;
      i = 0;
      break label71;
      label282:
      bool2 = bool1;
      if (paramCard.appPlayingInfos == null) {
        break;
      }
      bool2 = bool1;
      if (paramCard.appPlayingInfos.size() <= 0) {
        break;
      }
      ((ProfileCardFavorShowView)localObject1).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuestDefault", "一起在玩"));
      bool1 = bool4;
      if (paramCard.appPlayingInfos.size() > 1) {
        bool1 = true;
      }
      ((ProfileCardFavorShowView)localObject1).setShowArrow(bool1);
      localObject2 = new MiniAppProfileCardGuestView(this.mActivity);
      ((MiniAppProfileCardGuestView)localObject2).setData(paramCard.appPlayingInfos, paramCard.guestJumpUrl, paramCard.uin);
      ((ProfileCardFavorShowView)localObject1).setVisibility(8);
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      if (i == 0) {
        break label218;
      }
      a((MiniAppProfileCardGuestView)localObject2);
      break label218;
      label414:
      Object localObject3;
      if (bool5)
      {
        if ((localObject1 instanceof ProfileCardFavorShowView))
        {
          localObject2 = (ProfileCardFavorShowView)localObject1;
          if (paramCard.miniAppInfoArrayList.size() > 1) {}
          for (bool1 = true;; bool1 = false)
          {
            ((ProfileCardFavorShowView)localObject2).setShowArrow(bool1);
            localObject3 = (MiniAppProfileCardView)((ProfileCardFavorShowView)localObject2).S(0);
            ((MiniAppProfileCardView)localObject3).setData(paramCard.miniAppInfoArrayList);
            if (i != 0) {
              a((MiniAppProfileCardView)localObject3);
            }
            if (paramCard.miniAppInfoArrayList.size() > 1)
            {
              paramCard = ((ProfileCardFavorShowView)localObject2).mTitleBar;
              paramCard.setTag(new albb(96, Boolean.valueOf(true)));
              paramCard.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
            }
            paramCard = (Card)localObject1;
            bool1 = bool2;
            break;
          }
        }
      }
      else if ((localObject1 instanceof ProfileCardFavorShowView))
      {
        localObject2 = (ProfileCardFavorShowView)localObject1;
        ((ProfileCardFavorShowView)localObject2).setTitle(paramCard.guestAppTotal + QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuest", "个一起在玩的小游戏"));
        if (paramCard.guestAppTotal > 1) {}
        for (bool1 = true;; bool1 = false)
        {
          ((ProfileCardFavorShowView)localObject2).setShowArrow(bool1);
          localObject3 = (MiniAppProfileCardGuestView)((ProfileCardFavorShowView)localObject2).S(0);
          ((MiniAppProfileCardGuestView)localObject3).setData(paramCard.appPlayingInfos, paramCard.guestJumpUrl, paramCard.uin);
          if (i != 0) {
            a((MiniAppProfileCardGuestView)localObject3);
          }
          if (paramCard.guestAppTotal > 1)
          {
            paramCard = ((ProfileCardFavorShowView)localObject2).mTitleBar;
            paramCard.setTag(new albb(96, Boolean.valueOf(false)));
            paramCard.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
          }
          paramCard = (Card)localObject1;
          bool1 = bool2;
          break;
        }
        label713:
        if (localObject1 != null)
        {
          this.pH.remove("map_key_mini_playing");
          paramCard = (Card)localObject1;
          bool1 = true;
          continue;
        }
      }
      paramCard = (Card)localObject1;
      bool1 = bool2;
    }
  }
  
  private boolean h(Card paramCard, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipV5View)) || (aGA()))) {}
    for (int i = 1; (i == 0) || (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Alcn.e)) || (aqft.rj(this.jdField_a_of_type_Alcn.e.uin)) || ((this.jdField_a_of_type_Arho != null) && (!this.jdField_a_of_type_Arho.mI(2))); i = 0)
    {
      this.pH.remove("map_key_photo_wall");
      return false;
    }
    Object localObject = (View)this.pH.get("map_key_photo_wall");
    paramCard = (Card)localObject;
    if (localObject == null)
    {
      localObject = new PhotoWallView(this.mActivity, this.app, this.jdField_a_of_type_Alcn.e.uin, this);
      paramCard = new ProfileCardFavorShowView(this.mActivity);
      paramCard.setTitle(acfp.m(2131709931));
      paramCard.setVisibility(8);
      paramCard.addView((View)localObject);
      this.pH.put("map_key_photo_wall", paramCard);
    }
    if ((paramCard instanceof ProfileCardFavorShowView))
    {
      localObject = (ProfileCardFavorShowView)paramCard;
      paramCard = (PhotoWallView)((ProfileCardFavorShowView)localObject).S(0);
      c("map_key_photo_wall", null, paramCard.acc, null);
      c("map_key_photo_wall", null, paramCard.acd, null);
      if ((this.mActivity instanceof FriendProfileCardActivity)) {
        ((FriendProfileCardActivity)this.mActivity).a(paramCard);
      }
      localObject = ((ProfileCardFavorShowView)localObject).mTitleBar;
      ((View)localObject).setTag(new albb(85, paramCard));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      ((View)localObject).setContentDescription(getString(2131692194));
    }
    return true;
  }
  
  private boolean i(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    if (this.jdField_a_of_type_Alcn.e.pa == 0)
    {
      anot.a(this.app, "", "", "", "0X800A1C6", "0X800A1C6", 0, 0, "", "", "", "");
      QZLog.d("cardInfo.allinone.pa", 2, new Object[] { Integer.valueOf(this.jdField_a_of_type_Alcn.e.pa) });
      if ((paramCard.presentSwitch) && (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_Alcn.e))) {
        break label148;
      }
      if (this.pH.remove("map_key_present") == null) {
        break label143;
      }
    }
    label143:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      anot.a(this.app, "", "", "", "0X800A1C8", "0X800A1C8", 0, 0, "", "", "", "");
      break;
    }
    label148:
    View localView = (View)this.pH.get("map_key_present");
    if (localView == null)
    {
      localView = this.inflater.inflate(2131561590, null);
      this.pH.put("map_key_present", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      Object localObject2 = (ViewGroup)localView.findViewById(2131369190);
      TextView localTextView = (TextView)localView.findViewById(2131379562);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131368865);
      Object localObject3 = (ImageView)localView.findViewById(2131369191);
      Object localObject4 = (ImageView)localView.findViewById(2131369192);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131369193);
      ImageView localImageView3 = (ImageView)localView.findViewById(2131369194);
      Object localObject1 = new ArrayList();
      ((List)localObject1).add(localObject3);
      ((List)localObject1).add(localObject4);
      ((List)localObject1).add(localImageView2);
      ((List)localObject1).add(localImageView3);
      localTextView.setSingleLine(true);
      localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      if ((paramCard.showPresent) && (paramCard.presentUrl != null))
      {
        ((ViewGroup)localObject2).setVisibility(0);
        localObject2 = paramCard.presentUrl;
        localObject3 = getResources();
        int i = ((Resources)localObject3).getDimensionPixelSize(2131298784);
        int j = ((Resources)localObject3).getDimensionPixelSize(2131297956);
        int k = ((Resources)localObject3).getDimensionPixelSize(2131297953);
        j = (int)(this.of - j - k);
        k = (int)((j - i * 3 * 1.0F) / 3.0F);
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
        }
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          if (((List)localObject2).size() > 4) {
            i = 4;
          }
          for (;;)
          {
            j = 0;
            label534:
            if (j < i)
            {
              localObject3 = (String)((List)localObject2).get(j);
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                if (ThemeUtil.isInNightMode(this.app)) {
                  ((ImageView)((List)localObject1).get(j)).setColorFilter(1996488704);
                }
                if (this.jdField_t_of_type_AndroidGraphicsDrawableColorDrawable == null) {
                  this.jdField_t_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131165887));
                }
              }
              try
              {
                localObject4 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_t_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_t_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = k;
                ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = k;
                localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
                ((ImageView)((List)localObject1).get(j)).setImageDrawable((Drawable)localObject3);
                j += 1;
                break label534;
                i = ((List)localObject2).size();
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshPresent fail!", localException);
                  }
                }
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 0)
      {
        localObject1 = acfp.m(2131709932);
        if (TextUtils.isEmpty(paramCard.presentDesc)) {
          break label878;
        }
      }
      label878:
      for (paramCard = ": " + paramCard.presentDesc;; paramCard = "")
      {
        localTextView.setText((String)localObject1 + acfp.m(2131709939) + paramCard);
        localView.setTag(new albb(94, null));
        localView.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
        localView.setContentDescription(getString(2131692180));
        c("map_key_present", null, localTextView, localImageView1);
        return paramBoolean;
        localObject1 = this.jdField_a_of_type_Alcn.gh[0];
        break;
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.inflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.resources = paramContext.getResources();
    this.mUiHandler = new Handler(Looper.getMainLooper());
    this.cAr = ThemeUtil.getCurrentThemeId();
    paramContext = this.resources.getDisplayMetrics();
    this.mDensity = paramContext.density;
    this.of = Math.min(paramContext.widthPixels, paramContext.heightPixels);
    this.BN = (this.resources.getDimensionPixelSize(2131297505) + this.resources.getDimensionPixelSize(2131297957) + this.resources.getDimensionPixelSize(2131297958));
    float f = this.mDensity;
    int i = this.resources.getDimensionPixelSize(2131297954);
    int j = this.resources.getDimensionPixelSize(2131297955);
    this.BO = (7.0F * f + i + j);
    this.yA = (this.of - this.BN - this.BO);
    this.oD = new HashMap();
  }
  
  public static boolean isVisible(View paramView)
  {
    if (paramView == null) {}
    while (!paramView.isShown()) {
      return false;
    }
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect.intersect(new Rect(0, 0, aqnm.getScreenWidth(), aqnm.getScreenHeight()));
  }
  
  private boolean j(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    int i;
    label34:
    label51:
    label77:
    label99:
    int j;
    if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Alcn.e))
    {
      i = 1;
      if ((i == 0) && (paramCard.personalityLabel != null)) {
        break label292;
      }
      i = 1;
      if ((i == 0) && (paramCard.personalityLabel.isCloseByUser != 1)) {
        break label297;
      }
      i = 1;
      if ((i == 0) && ((paramCard.personalityLabel.getSize() != 0) || (paramCard.personalityLabel.remainCount > 0))) {
        break label302;
      }
      i = 1;
      if ((i == 0) && (!aqft.rj(this.jdField_a_of_type_Alcn.e.uin))) {
        break label307;
      }
      i = 1;
      if ((i == 0) && ((paramCard.personalityLabel.getSize() != 0) || (aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.e.uin, this.app.getCurrentAccountUin())))) {
        break label312;
      }
      i = 1;
      label138:
      if ((i == 0) && ((this.jdField_a_of_type_Arho == null) || (this.jdField_a_of_type_Arho.mI(3)))) {
        break label317;
      }
      i = 1;
      label162:
      if ((QLog.isColorLevel()) && (paramCard.personalityLabel != null)) {
        QLog.i("ProfileCardUtil.PROFILE_CARD_TAG", 2, "makeOrRefreshPersonalityLabelBoard isCloseByUser:" + paramCard.personalityLabel.isCloseByUser);
      }
      if ((paramBoolean) && (paramCard.personalityLabel != null))
      {
        localObject1 = this.app;
        if (paramCard.personalityLabel.isCloseByUser != 1) {
          break label322;
        }
        j = 2;
        label239:
        anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X8008408", "0X8008408", j, 0, "", "", "", "");
      }
      if (i == 0) {
        break label333;
      }
      if (this.pH.remove("map_key_personality_label_board") == null) {
        break label328;
      }
    }
    label292:
    label297:
    label302:
    label307:
    label312:
    label317:
    label322:
    label328:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      i = 0;
      break;
      i = 0;
      break label34;
      i = 0;
      break label51;
      i = 0;
      break label77;
      i = 0;
      break label99;
      i = 0;
      break label138;
      i = 0;
      break label162;
      j = 1;
      break label239;
    }
    label333:
    Object localObject1 = (View)this.pH.get("map_key_personality_label_board");
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = new ProfileCardFavorShowView(this.mActivity);
      localObject2 = new PersonalityLabelBoard(this.mActivity, this.app, this.jdField_a_of_type_Alcn.e.uin, (View)localObject1);
      if ((this.mActivity instanceof FriendProfileCardActivity)) {
        ((PersonalityLabelBoard)localObject2).setScrollListener((PersonalityLabelBoard.a)this.mActivity);
      }
      ((ProfileCardFavorShowView)localObject1).setTitle(acfp.m(2131709896));
      ((ProfileCardFavorShowView)localObject1).setVisibility(8);
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      this.pH.put("map_key_personality_label_board", localObject1);
    }
    for (boolean bool = true;; bool = false)
    {
      albg localalbg;
      if ((this.mActivity instanceof FriendProfileCardActivity))
      {
        localObject2 = (ProfileCardFavorShowView)localObject1;
        localalbg = (albg)((ProfileCardFavorShowView)localObject2).S(0);
        ((FriendProfileCardActivity)this.mActivity).a(localalbg);
        localalbg.a(paramCard.personalityLabel, paramBoolean, false);
        a((PersonalityLabelBoard)localalbg, (ProfileCardFavorShowView)localObject1);
        paramCard = a(this.jdField_a_of_type_Alcn);
        if (paramCard == null) {
          break label593;
        }
        localalbg.setNick(paramCard);
      }
      for (;;)
      {
        paramCard = ((ProfileCardFavorShowView)localObject2).mTitleBar;
        paramCard.setTag(new albb(86, ((ProfileCardFavorShowView)localObject2).S(0)));
        paramCard.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
        paramCard.setContentDescription(getString(2131692193));
        return bool;
        label593:
        localalbg.setNick("");
      }
    }
  }
  
  private boolean k(Card paramCard, boolean paramBoolean)
  {
    int i = 2;
    boolean bool2 = true;
    if (paramCard == null)
    {
      QLog.d("ProfileCardMoreInfoView", 1, "makeOrRefreshLifeAchivement null card");
      return false;
    }
    boolean bool1;
    if ((paramCard.lifeAchivementList != null) && (paramCard.lifeAchivementList.size() > 0))
    {
      paramBoolean = true;
      if (this.jdField_a_of_type_Alcn.e.pa != 0) {
        break label140;
      }
      bool1 = true;
      label56:
      boolean bool3 = alee.a(paramCard, this.jdField_a_of_type_Arho, bool1, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCardUtil.PROFILE_CARD_TAG", 2, "makeOrRefreshLifeAchivement ,showLifeAchivementPanel:" + bool3 + ",hasLifeAchivement:" + paramBoolean);
      }
      if (bool3) {
        break label151;
      }
      if (this.pH.remove("map_key_life_achievement") == null) {
        break label146;
      }
    }
    label140:
    label146:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      return paramBoolean;
      paramBoolean = false;
      break;
      bool1 = false;
      break label56;
    }
    label151:
    Object localObject = (View)this.pH.get("map_key_life_achievement");
    if (localObject == null)
    {
      localObject = new LifeAchivementPanelView(this.mActivity);
      CardHandler localCardHandler = (CardHandler)this.app.getBusinessHandler(2);
      ((LifeAchivementPanelView)localObject).setCardHandler(localCardHandler);
      ((ProfileCardFavorShowView)localObject).setTitle(getString(2131692189));
      ((View)localObject).setVisibility(8);
      this.pH.put("map_key_life_achievement", localObject);
    }
    for (bool2 = true;; bool2 = false)
    {
      ((LifeAchivementPanelView)localObject).a(paramCard, this.jdField_a_of_type_Alcn);
      a(paramCard, paramBoolean, (LifeAchivementPanelView)localObject);
      if (bool1) {
        i = 1;
      }
      anot.a(this.app, "", "", "", "0X800AE53", "0X800AE53", i, 0, "", "", "", "");
      return bool2;
    }
  }
  
  public void AT(int paramInt)
  {
    if ((paramInt == 0) && (!aldf.a().bm(this.app)) && (isVisible(this.K))) {
      this.K.post(new ProfileCardMoreInfoView.13(this));
    }
  }
  
  public void L(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (!paramBoolean)
    {
      paramView.setVisibility(8);
      return;
    }
    if (!aldf.a().bo(this.app))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = aetc.a();
    if ((localObject == null) || (((aetb)localObject).isEmpty()))
    {
      paramView.setVisibility(8);
      return;
    }
    iC(paramView);
    paramView.setVisibility(0);
    ArrayList localArrayList = ((aetb)localObject).a().jQ;
    TextView localTextView = (TextView)paramView.findViewById(2131380628);
    ImageView localImageView = (ImageView)paramView.findViewById(2131379884);
    localTextView.setText(aldf.a().a((aetb)localObject));
    int i = 0;
    int j;
    while (i < ((aetb)localObject).a().jQ.size()) {
      if (TextUtils.isEmpty(((aetb.b)localArrayList.get(i)).topicName))
      {
        i += 1;
      }
      else
      {
        j = ((aetb.b)localArrayList.get(i)).topicId;
        localObject = ((aetb.b)localArrayList.get(i)).topicName;
      }
    }
    for (i = j;; i = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new arhf(this, (String)localObject, i, paramView));
      }
      localImageView.setOnTouchListener(jll.a);
      localImageView.setOnClickListener(new arhg(this, paramView));
      if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
        paramView.setBackgroundDrawable(null);
      }
      for (;;)
      {
        anot.a(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
        return;
        if (!aGz()) {
          paramView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846760));
        } else {
          paramView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846759));
        }
      }
      localObject = "";
    }
  }
  
  public void TL(boolean paramBoolean)
  {
    this.daP = paramBoolean;
    Object localObject = (View)this.pH.get("map_key_account_level_info");
    if (localObject != null)
    {
      localObject = (FrameLayout)((ProfileQQLevelView)((View)localObject).findViewById(2131374917)).findViewById(2131365584);
      if (localObject != null)
      {
        if (!this.daP) {
          break label89;
        }
        ((FrameLayout)localObject).setVisibility(0);
      }
      for (;;)
      {
        QLog.d("ProfileCardMoreInfoView", 2, " update mAllowPeopleSee" + this.daP);
        return;
        label89:
        ((FrameLayout)localObject).setVisibility(8);
      }
    }
    QLog.d("ProfileCardMoreInfoView", 2, " accountInfoView not init mAllowPeopleSee" + this.daP);
  }
  
  public void Wu(String paramString)
  {
    if ((this.pH == null) || (this.pH.size() <= 0) || (this.mActivity == null) || (!(this.mActivity instanceof FriendProfileCardActivity))) {
      QLog.i("notifyProfileActScrollToMoreInfo", 1, "mMoreInfoMap or mActivity is null");
    }
    int i;
    do
    {
      do
      {
        return;
        paramString = (View)this.pH.get(paramString);
      } while (paramString == null);
      i = paramString.getTop();
      QLog.i("notifyProfileActScrollToMoreInfo", 1, "scroll offset=" + i);
    } while (i < 0);
    ((FriendProfileCardActivity)this.mActivity).AM(i);
  }
  
  public void YA(int paramInt)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdatePhotoWall size:" + paramInt);
    }
    if (this.jdField_a_of_type_Alcn.e.pa == 0) {}
    for (int i = 1;; i = 0)
    {
      View localView = (View)this.pH.get("map_key_photo_wall");
      if ((localView != null) && ((i != 0) || (paramInt > 0)))
      {
        localView.setVisibility(0);
        if (i == 0) {
          break;
        }
        i = j;
        if (paramInt > 0) {
          i = 1;
        }
        anot.a(this.app, "dc00898", "", "", "0X8007EBC", "0X8007EBC", i, 0, "", "", "", "");
      }
      return;
    }
    anot.a(this.app, "dc00898", "", "", "0X8007EBD", "0X8007EBD", 0, 0, "", "", "", "");
  }
  
  public int a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if ((paramArrayOfString1 != null) && (i < paramArrayOfString1.length)) {
        if (TextUtils.isEmpty(paramArrayOfString1[i]))
        {
          i += 1;
        }
        else
        {
          int m = paramArrayOfString2.length;
          k = 0;
          label38:
          if (k >= m) {
            break label124;
          }
          if (!paramArrayOfString2[k].equals(paramArrayOfString1[i])) {
            break;
          }
        }
      }
    }
    label124:
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardMoreInfoView", 2, String.format("checkTagsForTroop invalid tag for specail troop tag: %s", new Object[] { paramArrayOfString1[i] }));
        }
        paramArrayOfString1[i] = "";
        break;
        k += 1;
        break label38;
      }
      j += 1;
      break;
      return j;
    }
  }
  
  public void a(alcn paramalcn, View paramView)
  {
    if ((paramalcn == null) || (paramalcn.d == null) || (paramView == null)) {
      return;
    }
    paramView.setVisibility(0);
    Object localObject3 = paramalcn.d;
    Object localObject1 = ((Card)localObject3).getPrivilegeOpenInfo();
    Object localObject2 = ((Card)localObject3).getPrivilegeCloseInfo();
    TextView localTextView = (TextView)paramView.findViewById(2131373707);
    paramView = (LinearLayout)paramView.findViewById(2131365913);
    paramView.removeAllViews();
    StringBuilder localStringBuilder = new StringBuilder(24);
    localStringBuilder.append(getContext().getString(2131694870));
    if ((paramalcn.e.pa == 0) || (this.app.getCurrentAccountUin().equals(paramalcn.e.uin)))
    {
      paramalcn = new ArrayList();
      localObject3 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramView.setVisibility(0);
        localTextView.setVisibility(8);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)localIterator.next();
          if (localPrivilegeInfo.iIsBig == 1) {
            ((List)localObject3).add(localPrivilegeInfo);
          }
          for (;;)
          {
            localPrivilegeInfo.isOpen = true;
            break;
            localArrayList.add(localPrivilegeInfo);
          }
        }
        localStringBuilder.append("你已开通");
        b(localStringBuilder, (List)localObject1);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label385;
        }
        localObject1 = ((List)localObject2).iterator();
        label289:
        if (!((Iterator)localObject1).hasNext()) {
          break label385;
        }
        localObject2 = (PrivilegeInfo)((Iterator)localObject1).next();
        if (((PrivilegeInfo)localObject2).iIsBig != 1) {
          break label372;
        }
        ((List)localObject3).add(localObject2);
      }
      for (;;)
      {
        ((PrivilegeInfo)localObject2).isOpen = false;
        break label289;
        paramView.setVisibility(8);
        localTextView.setVisibility(0);
        localTextView.setText(acfp.m(2131709936));
        localStringBuilder.append("你未开通特权服务，快去开通vip服务吧！");
        break;
        label372:
        localArrayList.add(localObject2);
      }
      label385:
      paramalcn.addAll((Collection)localObject3);
      paramalcn.addAll(localArrayList);
      a(paramalcn, paramView, false);
    }
    for (;;)
    {
      paramView.setContentDescription(localStringBuilder);
      c("map_key_medal_and_diamond", null, localTextView, null);
      return;
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break;
      }
      paramView.setVisibility(0);
      localTextView.setVisibility(8);
      a((List)localObject1, paramView, true);
      localStringBuilder.append("你的好友已开通");
      b(localStringBuilder, (List)localObject1);
    }
    paramalcn = ((Card)localObject3).privilegePromptStr;
    if (TextUtils.isEmpty(paramalcn)) {
      localTextView.setVisibility(4);
    }
    for (;;)
    {
      paramView.setVisibility(8);
      break;
      localTextView.setText(paramalcn);
      localTextView.setVisibility(0);
      localStringBuilder.append("TA还未开通任何服务特权");
    }
  }
  
  public void a(alcn paramalcn, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, boolean paramBoolean, arho paramarho, ListView paramListView)
  {
    this.jdField_a_of_type_Alcn = paramalcn;
    this.app = paramQQAppInterface;
    this.mActivity = paramBaseActivity;
    this.daH = paramBoolean;
    this.jdField_a_of_type_Arho = paramarho;
    this.jdField_b_of_type_ComTencentWidgetListView = paramListView;
    this.d = new aqdf(this.mContext, paramQQAppInterface);
    this.d.a(this);
    ((FriendProfileCardActivity)paramBaseActivity).a(this);
  }
  
  public void a(amii paramamii, View paramView)
  {
    paramamii = paramamii.getData();
    if ((paramamii instanceof Pair))
    {
      paramamii = (Pair)paramamii;
      amin.u(this.mActivity, amin.K(((Integer)paramamii.first).intValue(), (String)paramamii.second), -1);
      if (this.jdField_a_of_type_Alcn.e.pa != 0) {
        break label107;
      }
    }
    label107:
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A4D3", "0X800A4D3", i, 0, "" + i, "0", "", "");
      return;
    }
  }
  
  public void a(View paramView, List<oidb_0xd9f.TopicItem> paramList)
  {
    if (paramView == null) {
      return;
    }
    if ((paramList == null) || (paramList.size() <= 0))
    {
      paramView.setVisibility(8);
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131367163);
    Object localObject = (CircleBoarderImageView)paramView.findViewById(2131364622);
    CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131364623);
    CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131364624);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(localCircleBoarderImageView1);
    localArrayList.add(localCircleBoarderImageView2);
    localObject = (TextView)paramView.findViewById(2131380628);
    Collections.sort(paramList, new arhe(this));
    int j = aldf.a().w(paramList);
    paramList = aldf.a().bo(paramList);
    paramView.setVisibility(0);
    localRelativeLayout.setVisibility(0);
    if (paramList.size() > localArrayList.size())
    {
      i = 0;
      while (i < localArrayList.size())
      {
        ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(0);
        a(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(i));
        i += 1;
      }
    }
    int i = 0;
    if (i < localArrayList.size())
    {
      if (i < paramList.size())
      {
        new aqdf(this.mContext, this.app).b(1, String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get()));
        ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(0);
        a(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(8);
      }
    }
    if (j <= 3)
    {
      paramList = j + acfp.m(2131709945);
      ((TextView)localObject).setText(paramList);
      if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
        break label506;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
      return;
      paramList = acfp.m(2131709915) + j + acfp.m(2131709894);
      break;
      label506:
      if (!aGz()) {
        paramView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846760));
      } else {
        paramView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846759));
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup, QQAppInterface paramQQAppInterface, Card paramCard)
  {
    if (paramViewGroup == null) {}
    do
    {
      return;
      if ((paramCard != null) && (!TextUtils.isEmpty(paramCard.schoolName)))
      {
        paramViewGroup.setVisibility(8);
        afxn.G(paramQQAppInterface, false);
        return;
      }
      if (!afxn.az(paramQQAppInterface)) {
        break;
      }
      paramViewGroup.setVisibility(0);
      paramQQAppInterface = LayoutInflater.from(getContext()).inflate(2131561315, null);
      paramCard = (TextView)paramQQAppInterface.findViewById(2131380580);
      paramViewGroup.addView(paramQQAppInterface);
    } while (!(this.mActivity instanceof FriendProfileCardActivity));
    c("map_key_extend_friend_info", paramCard, null, null);
    return;
    paramViewGroup.setVisibility(8);
  }
  
  public boolean a(alcn paramalcn, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramalcn == null) {
      localObject = null;
    }
    while (localObject == null) {
      if (this.pH.remove("map_key_medal_and_diamond") != null)
      {
        return true;
        localObject = paramalcn.d;
      }
      else
      {
        return false;
      }
    }
    if (!aqft.rj(paramalcn.e.uin))
    {
      paramBoolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeAccountLineThree, , diamond: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      if (paramBoolean) {
        break label114;
      }
      if (this.pH.remove("map_key_medal_and_diamond") == null) {
        break label109;
      }
    }
    label109:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      paramBoolean = false;
      break;
    }
    label114:
    Object localObject = (View)this.pH.get("map_key_medal_and_diamond");
    if (localObject == null)
    {
      localObject = this.inflater.inflate(2131561574, null);
      this.pH.put("map_key_medal_and_diamond", localObject);
    }
    for (bool = true;; bool = false)
    {
      ImageView localImageView = (ImageView)((View)localObject).findViewById(2131362978);
      View localView = ((View)localObject).findViewById(2131365912);
      if (paramBoolean)
      {
        a(paramalcn, localView);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        localMarginLayoutParams.leftMargin = 0;
        localView.setLayoutParams(localMarginLayoutParams);
        if (!paramBoolean) {
          break label273;
        }
        ((View)localObject).setTag(new albb(26, null));
        ((View)localObject).setOnClickListener(paramalcn.mOnClickListener);
      }
      for (;;)
      {
        c("map_key_medal_and_diamond", null, null, localImageView);
        return bool;
        localView.setVisibility(8);
        ((View)localObject).setTag(null);
        break;
        label273:
        ((View)localObject).setTag(new albb(91, null));
        ((View)localObject).setOnClickListener(this.jdField_a_of_type_Arhs);
      }
    }
  }
  
  public boolean a(alcs paramalcs)
  {
    if (paramalcs == null) {}
    for (paramalcs = "0"; this.pI.size() > 0; paramalcs = String.valueOf(paramalcs.agr))
    {
      Iterator localIterator = this.pI.keySet().iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((String)this.pI.get(str)).equals(paramalcs));
      return false;
    }
    return true;
  }
  
  public boolean aGA()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipDiyView;
  }
  
  public boolean aGx()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!this.jdField_a_of_type_Alcn.cwc) {
      return this.pH.remove("map_key_troop_mem_add_time") != null;
    }
    String str1 = "";
    String str2 = str1;
    long l;
    if (this.jdField_a_of_type_Alcn.c != null)
    {
      str2 = str1;
      if (this.jdField_a_of_type_Alcn.c.joinTime > 0L)
      {
        l = this.jdField_a_of_type_Alcn.c.joinTime;
        if (this.jdField_a_of_type_Alcn.c.joinTime == 1L) {}
      }
    }
    try
    {
      str1 = DateFormat.format(getString(2131694931), 1000L * l).toString();
      str2 = str1;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileCardMoreInfoView", 2, String.format("makeOrRefreshTroopMemJoinTime, timeStamp: %s, joinTime: %s", new Object[] { Long.valueOf(l), str1 }));
        str2 = str1;
      }
      if (TextUtils.isEmpty(str2)) {
        if (this.pH.remove("map_key_troop_mem_add_time") != null) {
          return bool1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = "";
        continue;
        bool1 = false;
      }
      localObject1 = (View)this.pH.get("map_key_troop_mem_add_time");
      if (localObject1 != null) {
        break label337;
      }
    }
    Object localObject1 = this.inflater.inflate(2131563258, null);
    this.pH.put("map_key_troop_mem_add_time", localObject1);
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131368698);
    ((ImageView)localObject2).setImageResource(2130846678);
    ((ImageView)localObject2).clearColorFilter();
    ((ImageView)localObject2).setColorFilter(10067634);
    label337:
    for (bool1 = true;; bool1 = bool2)
    {
      localObject2 = (TextView)((View)localObject1).findViewById(2131369466);
      localObject1 = (ImageView)((View)localObject1).findViewById(2131362978);
      ((ImageView)localObject1).setVisibility(8);
      ((TextView)localObject2).setText(str2);
      QLog.d("tagckb", 2, "makeOrRefreshTroopMemJoinTime 05");
      c("map_key_troop_mem_add_time", null, (View)localObject2, (ImageView)localObject1);
      return bool1;
    }
  }
  
  public boolean aGz()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView;
  }
  
  public HashMap<String, View> ae()
  {
    return this.pH;
  }
  
  public ProfileCardFavorShowView b(Activity paramActivity)
  {
    if (aGA()) {
      return ((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(paramActivity);
    }
    return new ProfileCardFavorShowView(paramActivity);
  }
  
  public void b(alcn paramalcn, View paramView)
  {
    if ((paramalcn == null) || (paramView == null) || (paramalcn.d == null)) {
      return;
    }
    paramView.setVisibility(0);
    Object localObject1 = (TextView)paramView.findViewById(2131371207);
    if (this.R == null) {
      this.R = new RedTouch(this.mActivity, paramView).a(53).a(true).c(1).e(10).a();
    }
    RedTouch localRedTouch = this.R;
    Object localObject2 = (akjp)this.app.getManager(160);
    RedTouchItem localRedTouchItem = ((akjp)localObject2).a(10016);
    int i;
    if (((akjp)localObject2).a(localRedTouchItem, false))
    {
      if (!QLog.isColorLevel()) {
        break label570;
      }
      QLog.d("ProfileCardMoreInfoView", 2, "update head icon red point: " + localRedTouchItem.redtouchType);
      i = 1;
    }
    for (;;)
    {
      localObject2 = getResources().getDrawable(2130846696);
      ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject2);
      ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
      ((TextView)localObject1).setVisibility(0);
      if (paramalcn.e.pa == 0)
      {
        ((TextView)localObject1).setText(String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(paramalcn.d.iMedalCount - paramalcn.d.iNewCount) }));
        if (paramalcn.d.iNewCount > 0)
        {
          i = wja.dp2px(5.0F, getResources());
          paramView.setPadding(0, wja.dp2px(10.0F, getResources()), i, 0);
          localRedTouch.b(0).a();
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(4);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(String.format(Locale.getDefault(), "+%d", new Object[] { Integer.valueOf(paramalcn.d.iNewCount) }));
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000', 'av':1}");
        }
      }
      for (;;)
      {
        label357:
        paramView.setContentDescription(String.format(Locale.getDefault(), acfp.m(2131709937), new Object[] { Integer.valueOf(paramalcn.d.iMedalCount - paramalcn.d.iNewCount) }));
        for (;;)
        {
          localRedTouch.c((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          return;
          i = 0;
          break;
          if ((i == 0) && (paramalcn.d.iUpgradeCount <= 0)) {
            break label564;
          }
          paramView.setPadding(0, 0, wja.dp2px(4.0F, getResources()), 0);
          localRedTouch.b(15).a();
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set("");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("");
          break label357;
          ((TextView)localObject1).setText(String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(paramalcn.d.iMedalCount) }));
          paramView.setContentDescription(String.format(Locale.getDefault(), acfp.m(2131709929), new Object[] { Integer.valueOf(paramalcn.d.iMedalCount) }));
          localObject1 = null;
        }
        label564:
        localObject1 = null;
      }
      label570:
      i = 1;
    }
  }
  
  public boolean b(Card paramCard, boolean paramBoolean)
  {
    paramBoolean = false;
    if ((!this.jdField_a_of_type_Alcn.cwc) || (this.jdField_a_of_type_Alcn.drO < 0) || (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Alcn.troopUin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileCardMoreInfoView.class.getSimpleName(), 2, "makeOrRefreshTroopMemCharmLevelInfo, isQidianPrivateTroop");
      }
      if (this.pH.remove("map_key_troop_mem_charm_level") != null) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    paramCard = (View)this.pH.get("map_key_troop_mem_charm_level");
    Object localObject;
    if (paramCard == null)
    {
      paramCard = this.inflater.inflate(2131563258, null);
      this.pH.put("map_key_troop_mem_charm_level", paramCard);
      localObject = (ImageView)paramCard.findViewById(2131368698);
      ((ImageView)localObject).setImageResource(2130846676);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = (TextView)paramCard.findViewById(2131369466);
      ImageView localImageView = (ImageView)paramCard.findViewById(2131362978);
      ((TextView)localObject).setText("群聊等级已达LV" + this.jdField_a_of_type_Alcn.drO + " ");
      paramCard.setTag(new albb(80, null));
      paramCard.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      paramCard.setOnLongClickListener(this.jdField_a_of_type_Alcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
      c("map_key_troop_mem_charm_level", null, (View)localObject, localImageView);
      anot.a(this.app, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(this.jdField_a_of_type_Alcn.drO), "", "", "");
      return paramBoolean;
    }
  }
  
  public void c(alcn paramalcn, boolean paramBoolean, String... paramVarArgs)
  {
    if (paramalcn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCardMoreInfoView", 2, "update info is null");
      }
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      if ((paramalcn.cwc) && (TroopInfo.isQidianPrivateTroop(this.app, paramalcn.troopUin)))
      {
        paramVarArgs = this.ij;
        label56:
        i = paramVarArgs.length;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label145;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ProfileCardMoreInfoView", 2, "update no validate tags");
      return;
      paramVarArgs = this.gi;
      break label56;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
        i = 0;
      } else if ((paramalcn.cwc) && (TroopInfo.isQidianPrivateTroop(this.app, paramalcn.troopUin))) {
        i = a(paramVarArgs, this.ij);
      } else {
        i = paramVarArgs.length;
      }
    }
    label145:
    if (aGA()) {
      ((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(paramalcn, paramBoolean, paramVarArgs);
    }
    int j = paramVarArgs.length;
    int i = 0;
    boolean bool2 = false;
    label175:
    String str;
    boolean bool1;
    if (i < j)
    {
      str = paramVarArgs[i];
      if (TextUtils.isEmpty(str)) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      i += 1;
      bool2 = bool1;
      break label175;
      try
      {
        if ("map_key_sig".equals(str))
        {
          RichStatus localRichStatus = paramalcn.richStatus;
          localObject = localRichStatus;
          if (localRichStatus == null)
          {
            localObject = localRichStatus;
            if (paramalcn.d != null) {
              localObject = paramalcn.d.getRichStatus();
            }
          }
          bool1 = d((RichStatus)localObject);
          if (bool2) {
            break label1153;
          }
          if (!bool1) {
            break label1159;
          }
          break label1153;
        }
        if ("map_key_qzone".equals(str))
        {
          bool1 = e(paramalcn.d);
          if (bool2) {
            break label1165;
          }
          if (!bool1) {
            break label1171;
          }
          break label1165;
        }
        bool1 = bool2;
        if ("map_key_qqcircle".equals(str)) {
          continue;
        }
        if ("map_key_medal_and_diamond".equals(str))
        {
          bool1 = a(paramalcn, paramBoolean);
          if (bool2) {
            break label1177;
          }
          if (!bool1) {
            break label1183;
          }
          break label1177;
        }
        if (!"map_key_medal".equals(str)) {
          break label449;
        }
        Object localObject = k(str);
        if (localObject == null) {
          break label428;
        }
        b(paramalcn, (View)localObject);
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        QLog.w("ProfileCardMoreInfoView", 1, String.format("update crash tag: %s", new Object[] { str }), localThrowable);
        bool1 = bool2;
      }
      continue;
      label428:
      bool1 = a(paramalcn, true);
      if (!bool2)
      {
        if (!bool1) {
          break label1195;
        }
        break label1189;
        label449:
        if ("map_key_troop_mem_game_info".equals(str))
        {
          bool1 = c(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1201;
          }
          if (!bool1) {
            break label1207;
          }
          break label1201;
        }
        if ("map_key_troop_mem_add_time".equals(str))
        {
          bool1 = aGx();
          if (bool2) {
            break label1213;
          }
          if (!bool1) {
            break label1219;
          }
          break label1213;
        }
        if ("map_key_troop_mem_charm_level".equals(str))
        {
          bool1 = b(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1225;
          }
          if (!bool1) {
            break label1231;
          }
          break label1225;
        }
        if ("map_key_troop_mem_recent_said".equals(str))
        {
          bool1 = aGy();
          if (bool2) {
            break label1237;
          }
          if (!bool1) {
            break label1243;
          }
          break label1237;
        }
        if ("map_key_tag".equals(str))
        {
          bool1 = g(paramalcn.d);
          if (bool2) {
            break label1249;
          }
          if (!bool1) {
            break label1255;
          }
          break label1249;
        }
        if ("map_key_account_level_info".equals(str))
        {
          bool1 = c(paramalcn.d);
          if (bool2) {
            break label1261;
          }
          if (!bool1) {
            break label1267;
          }
          break label1261;
        }
        if ("map_key_phone".equals(str))
        {
          bool1 = V(paramalcn.e.pr);
          if (bool2) {
            break label1273;
          }
          if (!bool1) {
            break label1279;
          }
          break label1273;
        }
        if ("map_key_mine_weishi".equals(str))
        {
          bool1 = d(paramalcn.d);
          if (bool2) {
            break label1285;
          }
          if (!bool1) {
            break label1291;
          }
          break label1285;
        }
        if ("map_key_photo_wall".equals(str))
        {
          bool1 = h(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1297;
          }
          if (!bool1) {
            break label1303;
          }
          break label1297;
        }
        if ("map_key_personality_label_board".equals(str))
        {
          bool1 = j(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1309;
          }
          if (!bool1) {
            break label1315;
          }
          break label1309;
        }
        if ("map_key_extend_friend_info".equals(str))
        {
          bool1 = g(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1321;
          }
          if (!bool1) {
            break label1327;
          }
          break label1321;
        }
        if ("map_key_favor".equals(str))
        {
          bool1 = e(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1333;
          }
          if (!bool1) {
            break label1339;
          }
          break label1333;
        }
        if ("map_key_account_base_info".equals(str))
        {
          bool1 = d(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1345;
          }
          if (!bool1) {
            break label1351;
          }
          break label1345;
        }
        if ("map_key_present".equals(str))
        {
          bool1 = i(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1357;
          }
          if (!bool1) {
            break label1363;
          }
          break label1357;
        }
        if ("map_key_mini_playing".equals(str))
        {
          bool1 = h(paramalcn.d);
          if (bool2) {
            break label1369;
          }
          if (!bool1) {
            break label1375;
          }
          break label1369;
        }
        if ("map_key_music_box".equals(str))
        {
          if (aleo.c(paramalcn))
          {
            bool1 = f(paramalcn.d);
            break label1381;
          }
          if (this.pH.remove("map_key_music_box") == null) {
            break label1397;
          }
          bool1 = true;
          break label1381;
        }
        if ("map_key_sticky_note".equals(str))
        {
          bool1 = f(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1409;
          }
          if (!bool1) {
            break label1415;
          }
          break label1409;
        }
        if ("map_key_life_achievement".equals(str))
        {
          bool1 = k(paramalcn.d, paramBoolean);
          if (bool2) {
            break label1421;
          }
          if (!bool1) {
            break label1427;
          }
          break label1421;
        }
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("update invalid tag: %s", new Object[] { str }));
        bool1 = bool2;
        continue;
        if (bool2) {
          eiw();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("update ret: %s tags: %s", new Object[] { Boolean.valueOf(bool2), TextUtils.join(",", paramVarArgs) }));
        return;
        label1153:
        bool1 = true;
        continue;
        label1159:
        bool1 = false;
        continue;
        label1165:
        bool1 = true;
        continue;
        label1171:
        bool1 = false;
        continue;
        label1177:
        bool1 = true;
        continue;
        label1183:
        bool1 = false;
        continue;
      }
      label1189:
      bool1 = true;
      continue;
      label1195:
      bool1 = false;
      continue;
      label1201:
      bool1 = true;
      continue;
      label1207:
      bool1 = false;
      continue;
      label1213:
      bool1 = true;
      continue;
      label1219:
      bool1 = false;
      continue;
      label1225:
      bool1 = true;
      continue;
      label1231:
      bool1 = false;
      continue;
      label1237:
      bool1 = true;
      continue;
      label1243:
      bool1 = false;
      continue;
      label1249:
      bool1 = true;
      continue;
      label1255:
      bool1 = false;
      continue;
      label1261:
      bool1 = true;
      continue;
      label1267:
      bool1 = false;
      continue;
      label1273:
      bool1 = true;
      continue;
      label1279:
      bool1 = false;
      continue;
      label1285:
      bool1 = true;
      continue;
      label1291:
      bool1 = false;
      continue;
      label1297:
      bool1 = true;
      continue;
      label1303:
      bool1 = false;
      continue;
      label1309:
      bool1 = true;
      continue;
      label1315:
      bool1 = false;
      continue;
      label1321:
      bool1 = true;
      continue;
      label1327:
      bool1 = false;
      continue;
      label1333:
      bool1 = true;
      continue;
      label1339:
      bool1 = false;
      continue;
      label1345:
      bool1 = true;
      continue;
      label1351:
      bool1 = false;
      continue;
      label1357:
      bool1 = true;
      continue;
      label1363:
      bool1 = false;
      continue;
      label1369:
      bool1 = true;
      continue;
      label1375:
      bool1 = false;
      continue;
      for (;;)
      {
        label1381:
        if ((!bool2) && (!bool1)) {
          break label1403;
        }
        bool1 = true;
        break;
        label1397:
        bool1 = false;
      }
      label1403:
      bool1 = false;
      continue;
      label1409:
      bool1 = true;
      continue;
      label1415:
      bool1 = false;
      continue;
      label1421:
      bool1 = true;
      continue;
      label1427:
      bool1 = false;
    }
  }
  
  void c(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    try
    {
      if ((this.e != null) && (this.e.gB != null) && (this.e.gB.size() > 0))
      {
        this.pI.put(paramString, String.valueOf(this.e.agr));
        alcs.a(paramTextView, "color", this.e, "commonItemTitleColor");
        alcs.a(paramView, "color", this.e, "commonItemContentColor");
        alcs.a(paramImageView, "src", this.e, "commonItemMoreSrc");
        return;
      }
      if (aGA())
      {
        this.pI.put(paramString, String.valueOf(this.jdField_a_of_type_Alcn.d.lCurrentStyleId));
        alcs.a((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, paramString, paramTextView, paramView, paramImageView);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateItemTheme exception msg=" + paramString.getMessage());
      }
      paramString.printStackTrace();
      return;
    }
    this.pI.put(paramString, String.valueOf(0));
    if (paramTextView != null) {
      paramTextView.setTextColor(getResources().getColorStateList(2131167379));
    }
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setTextColor(getResources().getColorStateList(2131167304));
    }
    while (paramImageView != null)
    {
      paramImageView.setImageResource(2130839512);
      return;
      if ((paramView instanceof SingleLineTextView)) {
        ((SingleLineTextView)paramView).setTextColor(getResources().getColorStateList(2131167304));
      }
    }
  }
  
  public boolean e(alcn paramalcn)
  {
    if ((paramalcn == null) || (paramalcn.d == null) || ((paramalcn.e.pa != 0) && (!ProfileActivity.AllInOne.b(paramalcn.e)))) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while ((paramalcn.cwc) && (TroopInfo.isQidianPrivateTroop(this.app, paramalcn.troopUin)));
        if (aqmj.aG(this.app.getApplication(), this.app.getCurrentAccountUin()) == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileCardMoreInfoView", 2, "medal config off");
      return false;
    } while ((paramalcn.d.medalSwitchDisable) || (aqft.rj(paramalcn.e.uin)));
    return true;
  }
  
  protected void eiv()
  {
    ThreadManager.post(new ProfileCardMoreInfoView.6(this), 8, null, true);
  }
  
  /* Error */
  public void eix()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 114	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:pH	Ljava/util/HashMap;
    //   6: ldc 163
    //   8: invokevirtual 296	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: checkcast 251	android/view/View
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 201	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Alcn	Lalcn;
    //   26: getfield 275	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 594	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   32: aload_0
    //   33: getfield 219	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   36: invokevirtual 2113	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   39: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: istore_1
    //   43: aload_0
    //   44: iload_1
    //   45: invokespecial 3052	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:TK	(Z)V
    //   48: iload_1
    //   49: ifne -30 -> 19
    //   52: aload_2
    //   53: instanceof 755
    //   56: ifeq -37 -> 19
    //   59: aload_2
    //   60: checkcast 755	com/tencent/mobileqq/widget/ProfileCardFavorShowView
    //   63: iconst_0
    //   64: invokevirtual 917	com/tencent/mobileqq/widget/ProfileCardFavorShowView:S	(I)Landroid/view/View;
    //   67: astore_2
    //   68: aload_2
    //   69: instanceof 959
    //   72: ifeq -53 -> 19
    //   75: aload_0
    //   76: aload_2
    //   77: checkcast 959	com/tencent/mobileqq/widget/ProfileCardExtendFriendView
    //   80: getfield 3055	com/tencent/mobileqq/widget/ProfileCardExtendFriendView:jS	Landroid/widget/TextView;
    //   83: invokespecial 3057	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:V	(Landroid/view/View;)Z
    //   86: ifeq -67 -> 19
    //   89: aload_0
    //   90: getfield 3059	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:daN	Z
    //   93: ifne -74 -> 19
    //   96: aload_0
    //   97: getfield 219	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: ldc 221
    //   102: ldc 223
    //   104: ldc 223
    //   106: ldc_w 3061
    //   109: ldc_w 3061
    //   112: iconst_0
    //   113: iconst_0
    //   114: ldc 223
    //   116: ldc 223
    //   118: ldc 223
    //   120: ldc 223
    //   122: invokestatic 228	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 3059	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:daN	Z
    //   130: goto -111 -> 19
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	ProfileCardMoreInfoView
    //   42	7	1	bool	boolean
    //   14	63	2	localView	View
    //   133	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	133	finally
    //   22	48	133	finally
    //   52	130	133	finally
  }
  
  public void eiy()
  {
    float f1 = this.BN;
    float f2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.Hx();
    float f3 = this.BO;
    float f4 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.Hx();
    this.yA = (this.of - (f1 + f2) - (f3 + f4));
  }
  
  public void eiz()
  {
    removeCallbacks(this.hY);
    postDelayed(this.hY, 500L);
  }
  
  public boolean f(Card paramCard)
  {
    boolean bool = false;
    if (alcs.cy(this.jdField_a_of_type_Alcn.d.lCurrentStyleId)) {
      return true;
    }
    Object localObject = (View)this.pH.get("map_key_music_box");
    if (localObject == null)
    {
      localObject = new aleo(false);
      paramCard = ((aleo)localObject).b(this.mContext, paramCard.uin);
      paramCard.setTag(2131562224, localObject);
      this.pH.put("map_key_music_box", paramCard);
      bool = true;
    }
    for (;;)
    {
      if (paramCard.getTag(2131562224) != null) {
        ((aleo)paramCard.getTag(2131562224)).d(this.jdField_a_of_type_Alcn);
      }
      c("map_key_music_box", null, (TextView)paramCard.findViewById(2131379562), (ImageView)paramCard.findViewById(2131368865));
      return bool;
      paramCard = (Card)localObject;
    }
  }
  
  protected MessageRecord g()
  {
    Object localObject = top.ox();
    EntityManager localEntityManager = this.app.a().createEntityManager();
    String str1 = MessageRecord.getTableName(this.jdField_a_of_type_Alcn.troopUin, 1);
    String str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(9223372036854775807L), localObject });
    if (this.jdField_a_of_type_Alcn.d != null) {}
    for (localObject = this.jdField_a_of_type_Alcn.d.uin;; localObject = this.jdField_a_of_type_Alcn.e.uin)
    {
      localObject = localEntityManager.query(MessageRecord.class, str1, false, str2, new String[] { localObject }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.close();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break;
      }
      return null;
    }
    return (MessageRecord)((List)localObject).get(0);
  }
  
  protected String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public void iC(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131367163);
      CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131364622);
      CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131364623);
      paramView = (CircleBoarderImageView)paramView.findViewById(2131364624);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
      if (localCircleBoarderImageView1 != null) {
        localCircleBoarderImageView1.setVisibility(8);
      }
      if (localCircleBoarderImageView2 != null) {
        localCircleBoarderImageView2.setVisibility(8);
      }
    } while (paramView == null);
    paramView.setVisibility(8);
  }
  
  public View k(String paramString)
  {
    if ("map_key_tag".equals(paramString))
    {
      paramString = (View)this.pH.get("map_key_medal_and_diamond");
      if (paramString != null) {
        return paramString.findViewById(2131371204);
      }
    }
    else
    {
      return (View)this.pH.get(paramString);
    }
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Awbq != null) {
      this.jdField_a_of_type_Awbq.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (CircleBoarderImageView)this.oD.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
  
  public void onDestory()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$a != null)
    {
      localObject = (amhj)this.app.getManager(15);
      if (localObject != null)
      {
        ((amhj)localObject).removeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$a);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$a = null;
      }
    }
    if (this.d != null) {
      this.d.destory();
    }
    Object localObject = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localObject != null) {
      ((alep)localObject).a(null);
    }
    if (this.jdField_a_of_type_Awbq != null) {
      this.jdField_a_of_type_Awbq.onDestroy();
    }
    if (this.Jq != null)
    {
      this.Jq.clear();
      this.Jq = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    QLog.i("ProfileCardMoreInfoView", 2, "ProfileCardMoreInfoView change=" + paramBoolean + " l=" + paramInt1 + " t=" + paramInt2 + " r=" + paramInt3 + " b=" + paramInt4);
  }
  
  public void onPause()
  {
    if ((this.pH == null) || (this.pH.size() <= 0) || (this.mActivity == null) || (!(this.mActivity instanceof FriendProfileCardActivity))) {
      return;
    }
    this.ehv = 0;
    Object localObject = (ProfileCardFavorShowView)this.pH.get("map_key_extend_friend_info");
    if ((localObject != null) && ((((ProfileCardFavorShowView)localObject).S(0) instanceof ProfileCardExtendFriendView)))
    {
      localObject = (ProfileCardExtendFriendView)((ProfileCardFavorShowView)localObject).S(0);
      if (localObject != null) {
        ((ProfileCardExtendFriendView)localObject).onPause();
      }
    }
    this.aVx = true;
    this.daV = true;
  }
  
  public void onResume()
  {
    QLog.d("ProfileCardMoreInfoView", 4, "onResume");
    if (this.jdField_a_of_type_Awbq != null) {
      this.jdField_a_of_type_Awbq.onResume();
    }
    if (this.daU)
    {
      if (this.Jq != null) {
        this.Jq.clear();
      }
      return;
    }
    this.daU = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (se("map_key_extend_friend_info")) {
      eix();
    }
    if (this.jdField_a_of_type_Awbq != null) {
      this.jdField_a_of_type_Awbq.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Awbq != null) {
      this.jdField_a_of_type_Awbq.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean se(String paramString)
  {
    if ((this.pH == null) || (this.pH.size() <= 0) || (this.mActivity == null)) {}
    while (!this.pH.containsKey(paramString)) {
      return false;
    }
    paramString = (View)this.pH.get(paramString);
    if ((paramString != null) && (V(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void setMineWeiShiPanelInfo(srn paramsrn, boolean paramBoolean)
  {
    QLog.i("ProfileCardMoreInfoView", 2, "setMineWeiShiPanelInfo");
    this.jdField_b_of_type_Srn = paramsrn;
    this.daJ = paramBoolean;
  }
  
  public void setNewSignature(byte[] paramArrayOfByte, long paramLong)
  {
    EntityManager localEntityManager;
    Object localObject;
    if (this.jdField_a_of_type_Alcn.e.pa == 0)
    {
      localEntityManager = this.app.a().createEntityManager();
      localObject = (acff)this.app.getManager(51);
      if (localObject != null) {
        break label126;
      }
      localObject = null;
      if (localObject != null) {
        break label146;
      }
      localObject = new Card();
      ((Card)localObject).uin = this.jdField_a_of_type_Alcn.e.uin;
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.persist((Entity)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Alcn.richStatus = ((Card)localObject).getRichStatus();
      c(this.jdField_a_of_type_Alcn, true, new String[] { "map_key_sig" });
      return;
      label126:
      localObject = ((acff)localObject).b(this.jdField_a_of_type_Alcn.e.uin);
      break;
      label146:
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.update((Entity)localObject);
    }
  }
  
  static class a
    implements amfh
  {
    final WeakReference<ProfileCardMoreInfoView> mRef;
    
    public a(ProfileCardMoreInfoView paramProfileCardMoreInfoView)
    {
      this.mRef = new WeakReference(paramProfileCardMoreInfoView);
    }
    
    public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardMoreInfoView", 2, String.format("onGetIcon actionId=%s size=%s icon=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramBitmap }));
      }
      if (paramBitmap == null) {
        QLog.e("ProfileCardMoreInfoView", 1, "onGetIcon decode icon fail.");
      }
      do
      {
        return;
        paramBitmap = (ProfileCardMoreInfoView)this.mRef.get();
      } while ((paramBitmap == null) || (paramBitmap.a == null) || (paramBitmap.a.richStatus == null) || (paramBitmap.a.richStatus.actionId != paramInt1));
      paramBitmap.c(paramBitmap.a, true, new String[] { "map_key_sig" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView
 * JD-Core Version:    0.7.0.1
 */