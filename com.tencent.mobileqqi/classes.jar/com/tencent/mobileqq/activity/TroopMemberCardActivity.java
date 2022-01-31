package com.tencent.mobileqq.activity;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.CustomEntry;
import com.tencent.mobileqq.data.TroopMemberCard.GBarInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import dqb;
import dqc;
import dqe;
import dqf;
import dqg;
import dqh;
import dqm;
import dqn;
import dqo;
import dqp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TroopMemberCardActivity
  extends IphoneTitleBarActivity
{
  public static final int A = 5;
  public static final int C = 1;
  public static final int D = 2;
  public static final int E = 3;
  public static final int F = 4;
  public static final int G = 0;
  public static final int H = 1;
  public static final int I = 21;
  public static final byte a = 1;
  protected static final int a = 0;
  public static final byte b = 2;
  protected static final int b = 1;
  public static final byte c = 3;
  protected static final int c = 2;
  public static final byte d = 4;
  protected static final int d = 3;
  public static final byte e = 5;
  protected static final int e = 4;
  public static final byte f = 6;
  protected static final int f = 0;
  protected static final int g = 1;
  public static final int i = 0;
  protected static final String i = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 4;
  protected static final int n = 1;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  protected static final int u = 0;
  protected static final int v = 1;
  protected static final int w = 2;
  protected static final int x = 3;
  public static final int y = 3;
  public static final int z = 4;
  public int B = -1;
  protected float a;
  protected long a;
  protected Intent a;
  public Handler a;
  protected View.OnClickListener a;
  protected View a;
  public ImageView a;
  protected LinearLayout a;
  protected TextView a;
  public TroopMemberCardActivity a;
  public TroopHandler a;
  protected TroopObserver a;
  public TroopMemberCard a;
  protected QQProgressNotifier a;
  protected ActionSheet.OnButtonClickListener a;
  public ActionSheet a;
  protected final String a;
  public boolean a;
  public View[] a;
  protected View.OnClickListener b;
  protected View b;
  protected LinearLayout b;
  public String b;
  protected View.OnClickListener c;
  protected LinearLayout c;
  public String c;
  protected View.OnClickListener d;
  public String d;
  protected View.OnClickListener e;
  public String e;
  public String f = "";
  protected String g = "";
  protected int h;
  protected String h;
  public int o = -1;
  public int p;
  
  public TroopMemberCardActivity()
  {
    this.jdField_a_of_type_JavaLangString = "Q.profilecard.TroopMemberCardActivity";
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[4];
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_p_of_type_Int = 1;
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = new TroopMemberCard();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new dqb(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new dqe(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new dqf(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new dqg(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new dqh(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new dqm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dqn(this);
    this.jdField_a_of_type_AndroidContentIntent = new Intent();
    this.jdField_a_of_type_AndroidOsHandler = new dqo(this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, TroopMemberCardActivity.class);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("memberUin", paramString2);
    localIntent.putExtra("fromFlag", paramInt2);
    if (paramInt1 == -1)
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  protected int a(TroopInfo paramTroopInfo, String paramString)
  {
    int i2 = 1;
    int i1 = i2;
    if (paramTroopInfo != null)
    {
      if ((paramTroopInfo.troopowneruin == null) || (!paramTroopInfo.troopowneruin.equalsIgnoreCase(paramString))) {
        break label32;
      }
      i1 = 3;
    }
    label32:
    do
    {
      do
      {
        return i1;
        i1 = i2;
      } while (paramTroopInfo.Administrator == null);
      i1 = i2;
    } while (!paramTroopInfo.Administrator.contains(paramString));
    return 2;
  }
  
  protected View a(int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(2130904034, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    localView.setTag(new TroopMemberCardActivity.ViewHolder(localView, paramInt));
    return localView;
  }
  
  public String a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    if (paramInt1 == 0)
    {
      paramString1.append(getString(2131562338));
      paramString1.append("  ");
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        paramString1.append(paramInt2);
        paramString1.append(getString(2131561415));
        paramString1.append("  ");
      }
      return paramString1.toString();
      if (paramInt1 == 1)
      {
        paramString1.append(getString(2131562104));
        paramString1.append("  ");
      }
    }
  }
  
  public String a(long paramLong)
  {
    if (paramLong > 0L) {
      try
      {
        String str = DateFormat.format("yyyy-MM-dd", 1000L * paramLong).toString();
        str = String.format(getString(2131563301), new Object[] { str });
        return str;
      }
      catch (Exception localException)
      {
        return "";
      }
    }
    return getString(2131562265);
  }
  
  protected String a(String paramString1, String paramString2)
  {
    Object localObject1;
    for (;;)
    {
      try
      {
        if (this.jdField_h_of_type_Int == 0)
        {
          paramString1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
          localObject1 = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            localObject1 = paramString2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, nick=" + (String)localObject1);
          break;
        }
        localObject1 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
        Object localObject3 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
        Object localObject2 = ((FriendsManager)localObject1).a(paramString2);
        TroopMemberInfo localTroopMemberInfo = ((TroopManager)localObject3).a(paramString1, paramString2);
        localObject3 = ((FriendsManager)localObject1).a(paramString2);
        if (localObject2 == null) {
          break label342;
        }
        if (((Friends)localObject2).isFriend())
        {
          localObject1 = ((Friends)localObject2).remark;
          paramString1 = (String)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString1 = ((Friends)localObject2).name;
          }
          localObject1 = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, Friends!=null, remark=" + ((Friends)localObject2).remark + " name=" + ((Friends)localObject2).name);
            localObject1 = paramString1;
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (localTroopMemberInfo != null)
            {
              paramString1 = localTroopMemberInfo.friendnick;
              localObject2 = paramString1;
              if (QLog.isColorLevel())
              {
                QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, TroopMemberInfo!=null, friendnick=" + localTroopMemberInfo.friendnick);
                localObject2 = paramString1;
              }
            }
          }
          paramString1 = (String)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          paramString1 = (String)localObject2;
          if (localObject3 == null) {
            continue;
          }
          localObject1 = ((Card)localObject3).strNick;
          paramString1 = (String)localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, card!=null, strNick=" + ((Card)localObject3).strNick);
          paramString1 = (String)localObject1;
          continue;
        }
        localObject1 = "";
      }
      catch (Exception paramString1)
      {
        return paramString2;
      }
      continue;
      label342:
      localObject1 = "";
    }
    return localObject1;
  }
  
  public void a(int paramInt)
  {
    if (this.o == 1)
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperationFlag", paramInt);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperateUin", this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected void a(int paramInt, LinearLayout paramLinearLayout)
  {
    int i2 = paramLinearLayout.getChildCount();
    switch (paramInt)
    {
    default: 
      paramInt = 0;
      if (paramInt != 0) {
        break;
      }
    }
    for (int i1 = 8;; i1 = 0)
    {
      paramLinearLayout.setVisibility(i1);
      while (paramInt < i2)
      {
        localView = paramLinearLayout.getChildAt(paramInt);
        if (localView != null) {
          localView.setVisibility(8);
        }
        paramInt += 1;
      }
      a(paramLinearLayout.getChildAt(0), 3, 2131561607, 2130838992, 2131558427);
      View localView = paramLinearLayout.getChildAt(1);
      if (localView != null) {
        localView.setVisibility(0);
      }
      a(paramLinearLayout.getChildAt(2), 4, 2131561795, 2130839001, 2131558428);
      paramInt = 3;
      break;
      a(paramLinearLayout.getChildAt(0), 4, 2131561795, 2130839001, 2131558428);
      paramInt = 1;
      break;
      a(paramLinearLayout.getChildAt(0), 3, 2131561607, 2130838992, 2131558427);
      paramInt = 1;
      break;
      paramInt = 0;
      break;
    }
  }
  
  public void a(int paramInt, TroopMemberCard paramTroopMemberCard)
  {
    if (paramTroopMemberCard == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams: cardInfo==null, ");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams: uint32_result:" + paramTroopMemberCard.result + " memberRole:" + paramTroopMemberCard.memberRole);
      }
    } while ((paramTroopMemberCard.result != 0) && (paramTroopMemberCard.memberRole != 0));
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramTroopMemberCard;
    ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramTroopMemberCard);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams: TroopManager.saveTroopMemberCard");
    }
    this.f = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
      this.f = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark;
    }
    if (TextUtils.isEmpty(this.f)) {
      this.f = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
    }
    this.jdField_p_of_type_Int = paramInt;
    this.g = a(paramTroopMemberCard.joinTime);
    this.jdField_h_of_type_JavaLangString = a(paramTroopMemberCard.sex, paramTroopMemberCard.age, paramTroopMemberCard.location, "");
    f();
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    View localView = a(paramInt);
    localView.setContentDescription(paramString1);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = localView;
    TroopMemberCardActivity.ViewHolder localViewHolder;
    if ((localView.getTag() instanceof TroopMemberCardActivity.ViewHolder))
    {
      localViewHolder = (TroopMemberCardActivity.ViewHolder)localView.getTag();
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      localViewHolder.b.setText(paramString2);
      if (!paramBoolean) {
        break label109;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setClickable(true);
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      return;
      label109:
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setClickable(false);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong2));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramBoolean, paramLong1, localArrayList);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      paramView = (TextView)paramView.findViewById(2131233040);
      paramView.setText(paramInt2);
      paramView.setContentDescription(getString(paramInt4));
      paramView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, 0, 0);
    }
  }
  
  public void a(View paramView, String paramString, boolean paramBoolean)
  {
    TroopMemberCardActivity.ViewHolder localViewHolder;
    if ((paramView.getTag() instanceof TroopMemberCardActivity.ViewHolder))
    {
      localViewHolder = (TroopMemberCardActivity.ViewHolder)paramView.getTag();
      localViewHolder.b.setText(paramString);
      if (!paramBoolean) {
        break label57;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.setClickable(true);
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label57:
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.setClickable(false);
    }
  }
  
  protected void a(TextView paramTextView, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq:" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramInt + ", " + paramBoolean3);
      }
      if ((!paramBoolean1) && (!paramBoolean2) && (this.jdField_h_of_type_Int != 0)) {
        return;
      }
      paramString = new SpannableString(paramString);
      paramTextView.setPadding(0, 0, 0, 0);
      paramTextView.setText(paramString);
      return;
    }
    catch (Exception paramTextView)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq:" + paramTextView.toString());
      }
    }
  }
  
  public void a(String paramString)
  {
    if (isResume()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString, 0).b(d());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = "0";
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned) {
      paramString1 = "1";
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131561913, false);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131562121, false);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131561746);
    paramString2 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (paramString1.equalsIgnoreCase("0")) {}
    for (int i1 = 0;; i1 = 1)
    {
      paramString2.e(i1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      this.B = 1;
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {
      paramString1 = "";
    }
    ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString1, paramString3, paramString2, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (this.jdField_h_of_type_Int == 0)
    {
      paramString3 = new ProfileActivity.AllInOne(paramString3, 0);
      paramString3.jdField_c_of_type_JavaLangString = paramString2;
      paramString3.jdField_b_of_type_JavaLangString = paramString1;
      paramString3.f = 1;
      paramString1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, FriendProfileCardActivity.class);
      paramString1.putExtra("AllInOne", paramString3);
      startActivityForResult(paramString1, 2);
      return;
    }
    if (paramBoolean)
    {
      paramString3 = new ProfileActivity.AllInOne(paramString3, 20);
      paramString3.jdField_c_of_type_JavaLangString = paramString2;
      paramString3.jdField_b_of_type_JavaLangString = paramString1;
      paramString3.f = 1;
      paramString1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, FriendProfileCardActivity.class);
      paramString1.putExtra("AllInOne", paramString3);
      startActivityForResult(paramString1, 2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {}
    for (paramString3 = new ProfileActivity.AllInOne(paramString3, 19);; paramString3 = new ProfileActivity.AllInOne(paramString3, 21))
    {
      paramString3.jdField_c_of_type_JavaLangString = paramString2;
      paramString3.jdField_b_of_type_JavaLangString = paramString1;
      paramString3.f = 1;
      paramString1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, FriendProfileCardActivity.class);
      paramString1.putExtra("AllInOne", paramString3);
      startActivityForResult(paramString1, 2);
      return;
    }
  }
  
  protected void a(List paramList)
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initCustomItems: customItemList==null or size==0, return");
      }
      return;
    }
    int i2 = paramList.size();
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initCustomItems: size=" + i2);
    }
    Object localObject = (TextView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130904035, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    ((TextView)localObject).setText(2131562207);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    int i1 = 0;
    if (i1 < i2)
    {
      localObject = (TroopMemberCard.CustomEntry)paramList.get(i1);
      View localView = a(i1);
      TroopMemberCardActivity.ViewHolder localViewHolder = (TroopMemberCardActivity.ViewHolder)localView.getTag();
      if (!TextUtils.isEmpty(((TroopMemberCard.CustomEntry)localObject).label)) {
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopMemberCard.CustomEntry)localObject).label);
      }
      if (!TextUtils.isEmpty(((TroopMemberCard.CustomEntry)localObject).info)) {
        localViewHolder.b.setText(((TroopMemberCard.CustomEntry)localObject).info);
      }
      if ((((TroopMemberCard.CustomEntry)localObject).isClickable) && (!TextUtils.isEmpty(((TroopMemberCard.CustomEntry)localObject).linkUrl)))
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localView.setClickable(true);
        label251:
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (i2 != 1) {
          break label309;
        }
        localView.setBackgroundResource(2130837877);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        i1 += 1;
        break;
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localView.setClickable(false);
        break label251;
        label309:
        if (i1 == 0) {
          localView.setBackgroundResource(2130837882);
        } else if (i1 == i2 - 1) {
          localView.setBackgroundResource(2130837879);
        } else {
          localView.setBackgroundResource(2130837881);
        }
      }
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  protected void a(List paramList, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    Object localObject1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131234216);
    Object localObject2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131234457);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131234621);
    ((TextView)localObject1).setText(paramString1);
    ((TextView)localObject2).setText(paramInt + "");
    localLinearLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initTroopBar: troopBarList==null or size==0, return");
      }
      return;
    }
    int i2 = getResources().getDimensionPixelSize(2131427536);
    int i3 = getResources().getDimensionPixelSize(2131427537);
    int i1 = paramList.size();
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initTroopBar: size " + i1 + " url:" + paramString2 + " toutalCount:" + paramInt);
    }
    if (i1 > 4) {}
    for (paramInt = 4;; paramInt = i1)
    {
      i1 = 0;
      if (i1 < paramInt)
      {
        paramString2 = ((TroopMemberCard.GBarInfo)paramList.get(i1)).headUrl;
        localObject2 = new FrameLayout(this);
        localObject1 = new LinearLayout.LayoutParams(i2, i2);
        ((LinearLayout.LayoutParams)localObject1).rightMargin = i3;
        ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = new ImageView(this);
        ((ImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Object localObject3 = new ImageView(this);
        ((ImageView)localObject3).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ((ImageView)localObject3).setBackgroundResource(2130839287);
        ((FrameLayout)localObject2).addView((View)localObject1);
        ((FrameLayout)localObject2).addView((View)localObject3);
        localLinearLayout.addView((View)localObject2);
        for (;;)
        {
          try
          {
            localObject2 = new ColorDrawable(getResources().getColor(2131361847));
            localObject3 = URLDrawable.getDrawable(paramString2, (Drawable)localObject2, (Drawable)localObject2, false);
            if (localObject3 == null) {
              continue;
            }
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, localException.toString());
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initTroopBar, addBar:" + paramString2);
          }
          i1 += 1;
          break;
          if (localObject2 != null) {
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          }
        }
      }
      if (paramString1 != null) {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(paramString1);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    paramString1 = DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.isTroopFollowed;
    }
    return false;
  }
  
  protected String b(String paramString1, String paramString2)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localFriendsManagerImp != null) {
      return localFriendsManagerImp.c(paramString1, paramString2);
    }
    return "";
  }
  
  protected void b(String paramString)
  {
    Bitmap localBitmap = ImageUtil.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    ThreadManager.b(new dqc(this, paramString));
  }
  
  public void b(String paramString1, String paramString2)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, EditInfoActivity.class);
    localIntent.putExtra("type", 0);
    localIntent.putExtra("title", getString(2131562428));
    localIntent.putExtra("default", str);
    localIntent.putExtra("isTroopNick", true);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("num", 21);
    startActivityForResult(localIntent, 1);
    paramString1 = "";
    if (this.jdField_h_of_type_Int == 0) {
      paramString1 = "2";
    }
    for (;;)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "modify_name", "Clk", 0, 0, this.jdField_c_of_type_JavaLangString, paramString1, "", "");
      return;
      if (this.jdField_p_of_type_Int == 3) {
        paramString1 = "0";
      } else if (this.jdField_p_of_type_Int == 2) {
        paramString1 = "1";
      }
    }
  }
  
  public void c(String paramString)
  {
    if (!f())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "gotoQQVipWebPage, checkClickTime: false");
      }
      return;
    }
    if (this.jdField_h_of_type_Int == 0) {}
    for (paramString = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s", new Object[] { this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), Integer.valueOf(0), "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun" });; paramString = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s", new Object[] { this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), paramString, "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun" }))
    {
      paramString = paramString + "&ADTAG=mqq_qunmingpian";
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "gotoQQVipWebPage, url:" + paramString);
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "vip", "logo_in", 24, 0, "", "", "", "");
      return;
    }
  }
  
  protected void c(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("member_uin", paramString2);
    localIntent.putExtra("from_troop_card", true);
    startActivityForResult(localIntent, 6);
  }
  
  protected boolean c()
  {
    Intent localIntent = getIntent();
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("troopUin");
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("memberUin");
    this.o = localIntent.getIntExtra("fromFlag", 0);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "checkIntentParams:" + this.jdField_c_of_type_JavaLangString + "," + this.jdField_e_of_type_JavaLangString + "," + this.o);
    }
    if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      return false;
    }
    if (this.jdField_e_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
    for (this.jdField_h_of_type_Int = 0;; this.jdField_h_of_type_Int = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19));
      e();
      a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      return true;
    }
  }
  
  protected void d()
  {
    try
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(Long.parseLong(this.jdField_c_of_type_JavaLangString), Long.parseLong(this.jdField_e_of_type_JavaLangString));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "loadTroopMemberCard:" + localException.toString());
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openTroopBarPage:" + paramString);
    }
    if (!f())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openTroopBarPage, checkClickTime: false");
      }
      return;
    }
    paramString = new Intent(this, QQBrowserActivity.class);
    paramString.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarLinkUrl);
    paramString.putExtra("webStyle", "noBottomBar");
    paramString.putExtra("hide_more_button", true);
    paramString.putExtra("hide_operation_bar", true);
    paramString.putExtra("isShowAd", false);
    startActivity(paramString);
  }
  
  public void d(String paramString1, String paramString2)
  {
    String str1 = "";
    String str2;
    if (this.jdField_p_of_type_Int == 3)
    {
      str1 = "0";
      str2 = "";
      if (this.jdField_h_of_type_Int != 0) {
        break label145;
      }
      str2 = "0";
    }
    for (;;)
    {
      String str3 = "";
      if (paramString2 != null) {
        str3 = paramString2;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doReport, actionName:" + paramString1 + " reportId:" + paramString2);
        }
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "mber_card", paramString1, 0, 0, this.jdField_c_of_type_JavaLangString, str1, str2, str3);
        return;
      }
      catch (Exception paramString1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doReport:" + paramString1.toString());
      }
      if (this.jdField_p_of_type_Int == 2)
      {
        str1 = "1";
        break;
      }
      if (this.jdField_p_of_type_Int != 1) {
        break;
      }
      str1 = "2";
      break;
      label145:
      if (this.jdField_h_of_type_Int == 1) {
        str2 = "1";
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    case 5: 
    default: 
    case 1: 
      do
      {
        return;
        a(1, 2131562985, 1000);
        paramIntent = b(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card = paramIntent;
        a(this.jdField_a_of_type_ArrayOfAndroidViewView[1], paramIntent, true);
        a(0);
      } while (!QLog.isColorLevel());
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_SET_TROOP_NICK");
      return;
    case 2: 
      if (paramIntent == null) {
        break;
      }
    }
    for (boolean bool = paramIntent.getBooleanExtra("changed", false);; bool = false)
    {
      if (bool) {
        a(0);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_SHOW_PERSONAL_CARD, isChanged:" + bool);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_ADDFRIEND");
      return;
      bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_TROOP_DISBAND, finSelf=" + bool + " strTip=" + str + " uin=" + paramIntent);
      }
      if (!TextUtils.isEmpty(paramIntent))
      {
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (localFriendsManagerImp != null)
        {
          TroopInfo localTroopInfo = localFriendsManagerImp.a(this.jdField_c_of_type_JavaLangString);
          if (localTroopInfo != null)
          {
            localTroopInfo.troopowneruin = paramIntent;
            localFriendsManagerImp.b(localTroopInfo);
          }
        }
      }
      if ((!TextUtils.isEmpty(str)) && (bool))
      {
        a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.isFinishing())) {
          break;
        }
        a(1, str, 1000);
        return;
      }
      if (!bool) {
        break;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("isNeedFinish", true);
      setResult(-1, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.finish();
      return;
      setResult(-1);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!c())
    {
      finish();
      return false;
    }
    setContentView(2130904032);
    g();
    i();
    f();
    d();
    f("exp");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  protected void e()
  {
    boolean bool = false;
    Object localObject1 = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject4 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
    Object localObject2 = ((FriendManager)localObject1).a(this.jdField_c_of_type_JavaLangString);
    Object localObject3 = DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    if (localObject2 != null)
    {
      this.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject2).troopname;
      this.jdField_d_of_type_JavaLangString = ((TroopInfo)localObject2).troopcode;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: troopInfo != null, troopCode:" + this.jdField_d_of_type_JavaLangString + ", mTroopName:" + this.jdField_b_of_type_JavaLangString);
      }
    }
    localObject4 = ((TroopManager)localObject4).a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    if (localObject4 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: cacheCard != null");
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = ((TroopMemberCard)localObject4);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        this.f = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark;
      }
      if (TextUtils.isEmpty(this.f)) {
        this.f = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
      }
      this.jdField_p_of_type_Int = a((TroopInfo)localObject2, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend = ((FriendManager)localObject1).b(this.jdField_e_of_type_JavaLangString);
      this.g = a(((TroopMemberCard)localObject4).joinTime);
      this.jdField_h_of_type_JavaLangString = a(((TroopMemberCard)localObject4).sex, ((TroopMemberCard)localObject4).age, ((TroopMemberCard)localObject4).location, "");
      return;
    }
    this.f = a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.credit = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend = ((FriendManager)localObject1).b(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned = a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card = b(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isAllowModCard = true;
    this.jdField_p_of_type_Int = a((TroopInfo)localObject2, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole = a((TroopInfo)localObject2, this.jdField_e_of_type_JavaLangString);
    if ((localObject2 != null) && (localObject3 != null)) {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName = ((String)((TroopInfo)localObject2).getTroopLevelMap().get(Integer.valueOf(((TroopMemberInfo)localObject3).level)));
    }
    int i2;
    int i1;
    if (localObject3 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: troopMemberInfo != null");
      }
      if (((TroopMemberInfo)localObject3).join_time != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime = ((TroopMemberInfo)localObject3).join_time;
        this.g = a(((TroopMemberInfo)localObject3).join_time);
      }
    }
    else
    {
      i2 = -1;
      localObject3 = ((FriendManager)localObject1).a(this.jdField_e_of_type_JavaLangString);
      if (localObject3 == null) {
        break label764;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: card != null");
      }
      i2 = ((Card)localObject3).shGender;
      i1 = ((Card)localObject3).age;
      localObject2 = ((Card)localObject3).strProvince;
      localObject1 = ((Card)localObject3).strCity;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.sex = i2;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.age = i1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.location = ((String)localObject2 + "  " + (String)localObject1);
      this.jdField_h_of_type_JavaLangString = a(i2, i1, (String)localObject2, (String)localObject1);
      if (localObject3 == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip = ((Card)localObject3).isVipOpen(EVIPSPEC.E_SP_QQVIP);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip = ((Card)localObject3).isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperQQ = ((Card)localObject3).isVipOpen(EVIPSPEC.E_SP_SUPERQQ);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip) {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel = ((Card)localObject3).getVipLevel(EVIPSPEC.E_SP_QQVIP);
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard;
        if (((Card)localObject3).iQQVipType == 1) {
          bool = true;
        }
        ((TroopMemberCard)localObject1).isYearVip = bool;
        return;
        this.g = "";
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel = ((Card)localObject3).getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
        }
      }
      label764:
      localObject1 = "";
      localObject2 = "";
      i1 = 0;
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openCustomItemPage:" + paramString);
    }
    if (!f())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openCustomItemPage, checkClickTime: false");
      }
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    startActivity(localIntent);
  }
  
  protected void f()
  {
    int i1 = 3;
    Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131234615);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131234617);
    Object localObject2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131234616);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131234618);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131234612);
    TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131234613);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0)
    {
      localView.setVisibility(0);
      localTextView3.setText(2131563080);
      ((TextView)localObject1).setText(this.f);
      if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        break label631;
      }
      localTextView2.setText(this.jdField_h_of_type_JavaLangString);
      localTextView2.setVisibility(0);
      label144:
      localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2) {
        break label641;
      }
      localObject1 = getString(2131561620);
      label166:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label663;
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setVisibility(0);
      label183:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) || (TextUtils.isEmpty(this.g))) {
        break label672;
      }
      localTextView1.setText(this.g);
      localTextView1.setVisibility(0);
      label218:
      a(this.jdField_a_of_type_ArrayOfAndroidViewView[0], this.jdField_e_of_type_JavaLangString, false);
      a(((TroopMemberCardActivity.ViewHolder)this.jdField_a_of_type_ArrayOfAndroidViewView[0].getTag()).b, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {
        break label798;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundResource(2130837881);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(0);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = getString(2131562007);
      }
      if (this.jdField_h_of_type_Int != 0) {
        break label682;
      }
      a(this.jdField_a_of_type_ArrayOfAndroidViewView[1], (String)localObject1, true);
      label360:
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setBackgroundResource(2130837879);
      this.jdField_a_of_type_ArrayOfAndroidViewView[2].setVisibility(0);
      a(this.jdField_a_of_type_ArrayOfAndroidViewView[2], this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName, false);
      localObject1 = (TroopMemberCardActivity.ViewHolder)this.jdField_a_of_type_ArrayOfAndroidViewView[2].getTag();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName)) {
        break label738;
      }
      ((TroopMemberCardActivity.ViewHolder)localObject1).b.setVisibility(4);
      label434:
      this.jdField_a_of_type_ArrayOfAndroidViewView[2].setVisibility(8);
      if (this.jdField_h_of_type_Int == 0) {
        break label770;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned) {
        break label749;
      }
      a(this.jdField_a_of_type_ArrayOfAndroidViewView[3], getString(2131562121), true);
      label480:
      this.jdField_a_of_type_ArrayOfAndroidViewView[3].setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label498:
      if (this.jdField_h_of_type_Int != 1) {
        break label901;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        break label793;
      }
      i1 = 3;
    }
    for (;;)
    {
      a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.customEntryList);
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarList, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarTitle, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarLinkUrl, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarCount);
      return;
      if ((this.jdField_h_of_type_Int != 0) && ((this.jdField_p_of_type_Int == 2) || (this.jdField_p_of_type_Int == 3)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.credit == 1))
      {
        localView.setVisibility(0);
        localTextView3.setText(2131563081);
        break;
      }
      localView.setVisibility(4);
      break;
      label631:
      localTextView2.setVisibility(8);
      break label144;
      label641:
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 3) {
        break label166;
      }
      localObject1 = getString(2131562580);
      break label166;
      label663:
      ((TextView)localObject2).setVisibility(8);
      break label183;
      label672:
      localTextView1.setVisibility(8);
      break label218;
      label682:
      if (((this.jdField_p_of_type_Int == 2) || (this.jdField_p_of_type_Int == 3)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isAllowModCard))
      {
        a(this.jdField_a_of_type_ArrayOfAndroidViewView[1], (String)localObject1, true);
        break label360;
      }
      a(this.jdField_a_of_type_ArrayOfAndroidViewView[1], (String)localObject1, false);
      break label360;
      label738:
      ((TroopMemberCardActivity.ViewHolder)localObject1).b.setVisibility(0);
      break label434;
      label749:
      a(this.jdField_a_of_type_ArrayOfAndroidViewView[3], getString(2131561913), true);
      break label480;
      label770:
      this.jdField_a_of_type_ArrayOfAndroidViewView[3].setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label498;
      label793:
      i1 = 2;
      continue;
      label798:
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundResource(2130837879);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidViewView[2].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidViewView[3].setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_h_of_type_Int == 1) {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {}
      }
      for (;;)
      {
        a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
        break;
        i1 = 1;
        continue;
        i1 = 0;
      }
      label901:
      i1 = 0;
    }
  }
  
  public void f(String paramString)
  {
    d(paramString, null);
  }
  
  protected boolean f()
  {
    boolean bool = true;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      bool = false;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return bool;
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity = this;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131230980));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131234610));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130904033, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131234614));
    b(this.jdField_e_of_type_JavaLangString);
    a(0, getString(2131561581), "", false);
    a(1, getString(2131562428), "", true);
    a(2, getString(2131561452), "", false);
    Object localObject = (TroopMemberCardActivity.ViewHolder)this.jdField_a_of_type_ArrayOfAndroidViewView[2].getTag();
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setVisibility(4);
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setTextColor(Color.parseColor("#ffffff"));
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setBackgroundResource(2130838517);
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setIncludeFontPadding(false);
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setPadding((int)(4.0F * this.jdField_a_of_type_Float), 1, (int)(4.0F * this.jdField_a_of_type_Float), 1);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2].setBackgroundResource(2130837879);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130904036, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    a(3, getString(2131562963), "", true);
    localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[3].getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131427391);
      this.jdField_a_of_type_ArrayOfAndroidViewView[3].setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[3].setBackgroundResource(2130837877);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130904035, this.jdField_a_of_type_AndroidWidgetLinearLayout, false));
    localObject = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(2.0F * this.jdField_a_of_type_Float));
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(2131427533);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, getResources().getInteger(2131492868));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561741);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    h();
  }
  
  public boolean g()
  {
    if (!NetworkUtil.e(getApplication().getApplicationContext()))
    {
      a(getString(2131562449));
      return false;
    }
    return true;
  }
  
  protected void h()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = getResources().getColor(2131362046);
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2130903603, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    localView.setBackgroundColor(i1);
    localLayoutParams = new LinearLayout.LayoutParams(1, -1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2130903603, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    localView.setBackgroundColor(i1);
    localLayoutParams = new LinearLayout.LayoutParams(1, -1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2130903603, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
  }
  
  protected void i()
  {
    if (this.jdField_h_of_type_Int == 0) {
      setTitle(2131562187);
    }
    for (;;)
    {
      ImageView localImageView = this.jdField_p_of_type_AndroidWidgetImageView;
      localImageView.setVisibility(0);
      localImageView.setImageResource(2130838011);
      localImageView.setContentDescription(getString(2131562183));
      localImageView.setOnClickListener(new dqp(this));
      return;
      setTitle(2131562186);
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
    if (this.jdField_h_of_type_Int == 0)
    {
      this.B = 2;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131561746);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131562706), 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    this.jdField_a_of_type_Boolean = ((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131561746);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131562772);
      this.B = 4;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      int i1;
      if ((this.jdField_p_of_type_Int == 3) || ((this.jdField_p_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 3) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2)))
      {
        i1 = 1;
        label207:
        if (i1 == 0) {
          break label275;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label262;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131560648);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131562772);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131562414, 3);
        this.B = 3;
        break;
        i1 = 0;
        break label207;
        label262:
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131560647);
      }
      label275:
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131562772);
      this.B = 4;
    }
  }
  
  public void k()
  {
    String str = this.f;
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, AddFriendLogicActivity.class);
    localIntent.putExtra("type", 0);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {
      localIntent.putExtra("source_id", 10004);
    }
    for (;;)
    {
      localIntent.putExtra("sub_source_id", 0);
      localIntent.putExtra("uin", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("nick_name", str);
      startActivityForResult(localIntent, 3);
      return;
      localIntent.putExtra("source_id", 3004);
      localIntent.putExtra("troop_uin", this.jdField_d_of_type_JavaLangString);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener.OnClick(null, paramMenuItem.getItemId());
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    if (this.jdField_h_of_type_Int == 0)
    {
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 0, 0, getString(2131562706)), 0);
      this.B = 2;
      return true;
    }
    this.jdField_a_of_type_Boolean = ((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0)
    {
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 0, 0, getString(2131562772)), 0);
      this.B = 4;
      return true;
    }
    int i1;
    if ((this.jdField_p_of_type_Int == 3) || ((this.jdField_p_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 3) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2)))
    {
      i1 = 1;
      if (i1 == 0) {
        break label250;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label227;
      }
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 0, 0, getString(2131560648)), 0);
    }
    for (;;)
    {
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 1, 0, getString(2131562772)), 0);
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 2, 0, getString(2131562414)), 0);
      this.B = 3;
      return true;
      i1 = 0;
      break;
      label227:
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 0, 0, getString(2131560647)), 0);
    }
    label250:
    MenuItemCompat.setShowAsAction(paramMenu.add(0, 0, 0, getString(2131562772)), 0);
    this.B = 4;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberCardActivity
 * JD-Core Version:    0.7.0.1
 */