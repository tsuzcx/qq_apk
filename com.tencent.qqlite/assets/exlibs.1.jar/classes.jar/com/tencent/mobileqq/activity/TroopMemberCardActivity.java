package com.tencent.mobileqq.activity;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bnn;
import bno;
import bnp;
import bnq;
import bns;
import bnt;
import bnu;
import bnx;
import bny;
import bnz;
import boa;
import bob;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class TroopMemberCardActivity
  extends IphoneTitleBarActivity
{
  protected static final int A = 3;
  public static final int B = 3;
  public static final int C = 4;
  public static final int E = 1;
  public static final int F = 2;
  public static final int G = 3;
  public static final int H = 4;
  public static final int I = 0;
  public static final int J = 1;
  public static final int K = 21;
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
  protected static final int q = 1;
  protected static final int r = 0;
  public static final int s = 0;
  public static final int t = 1;
  public static final int u = 2;
  public static final int v = 3;
  public static final int w = 4;
  protected static final int x = 0;
  protected static final int y = 1;
  protected static final int z = 2;
  public int D = -1;
  protected float a;
  protected long a;
  protected Intent a;
  public Handler a;
  protected View.OnClickListener a;
  public View a;
  public ImageView a;
  protected LinearLayout a;
  protected TextView a;
  public TroopMemberCardActivity a;
  public TroopHandler a;
  protected TroopObserver a;
  public TroopMemberCard a;
  protected QQProgressDialog a;
  protected QQProgressNotifier a;
  protected ActionSheet.OnButtonClickListener a;
  public ActionSheet a;
  protected final String a;
  public boolean a;
  public View[] a;
  protected View.OnClickListener b;
  protected LinearLayout b;
  protected TroopObserver b;
  public String b;
  protected View.OnClickListener c;
  protected LinearLayout c;
  public String c;
  protected View.OnClickListener d;
  public String d;
  public String e = "";
  public String f = "";
  protected String g = "";
  protected int h;
  protected String h;
  private String j = null;
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
    this.jdField_p_of_type_Int = 1;
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = new TroopMemberCard();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bnn(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new bns(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new bnt(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new bnu(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new bnz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new boa(this);
    this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new bob(this);
    this.jdField_a_of_type_AndroidContentIntent = new Intent();
    this.jdField_a_of_type_AndroidOsHandler = new bno(this);
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
  
  private void a(TroopInfo paramTroopInfo)
  {
    int i1 = 0;
    JSONObject localJSONObject;
    try
    {
      this.j = null;
      if (paramTroopInfo.troopLevelMap != null)
      {
        localJSONObject = new JSONObject();
        paramTroopInfo = paramTroopInfo.troopLevelMap.split("\001");
        if ((paramTroopInfo != null) && (paramTroopInfo.length > 0)) {
          for (;;)
          {
            if (i1 >= paramTroopInfo.length) {
              break label156;
            }
            String[] arrayOfString = paramTroopInfo[i1].split("");
            int i2 = arrayOfString.length;
            if (i2 == 2) {}
            try
            {
              localJSONObject.put(arrayOfString[0], arrayOfString[1]);
              i1 += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "getTroopLevelMap, catch exception, key: " + arrayOfString[0] + " value: " + arrayOfString[1]);
                }
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramTroopInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "getTroopLevelMap, catch exception, makeTroopLevelMapString");
      }
    }
    label156:
    this.j = localJSONObject.toString();
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
    View localView = LayoutInflater.from(this).inflate(2130903677, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    localView.setTag(new TroopMemberCardActivity.ViewHolder(localView, paramInt));
    return localView;
  }
  
  public String a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 == 0)
    {
      localStringBuilder.append(getString(2131363199));
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(getString(2131363201));
        localStringBuilder.append("  ");
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        localStringBuilder.append(paramString1);
        localStringBuilder.append("  ");
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        localStringBuilder.append(paramString2);
        localStringBuilder.append("  ");
      }
      return localStringBuilder.toString();
      if (paramInt1 == 1)
      {
        localStringBuilder.append(getString(2131363200));
        localStringBuilder.append("  ");
      }
    }
  }
  
  public String a(long paramLong)
  {
    if (paramLong == 1L) {
      return "";
    }
    if (paramLong > 0L) {
      try
      {
        String str = DateFormat.format(getString(2131363519), 1000L * paramLong).toString();
        return str;
      }
      catch (Exception localException)
      {
        return "";
      }
    }
    return getString(2131363520);
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
          paramString1 = this.app.c();
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
        localObject1 = (FriendsManager)this.app.getManager(43);
        Object localObject3 = (TroopManager)this.app.getManager(44);
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
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperateUin", this.e);
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
      a(paramLinearLayout.getChildAt(0), 3, 2131363884, 2130838753, 2131361810);
      View localView = paramLinearLayout.getChildAt(1);
      if (localView != null) {
        localView.setVisibility(0);
      }
      a(paramLinearLayout.getChildAt(2), 4, 2131363080, 2130838759, 2131361811);
      paramInt = 3;
      break;
      a(paramLinearLayout.getChildAt(0), 4, 2131363080, 2130838759, 2131361811);
      paramInt = 1;
      break;
      a(paramLinearLayout.getChildAt(0), 3, 2131363884, 2130838753, 2131361810);
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
    ((TroopManager)this.app.getManager(44)).a(this.jdField_c_of_type_JavaLangString, this.e, paramTroopMemberCard);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams, TroopManager.saveTroopMemberCard");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "updateParams, server level name:" + paramTroopMemberCard.levelName);
    }
    this.f = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
      this.f = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark;
    }
    if (TextUtils.isEmpty(this.f)) {
      this.f = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
    }
    if (TextUtils.isEmpty(this.f)) {
      this.f = this.e;
    }
    this.jdField_p_of_type_Int = paramInt;
    this.g = a(paramTroopMemberCard.joinTime);
    this.jdField_h_of_type_JavaLangString = a(paramTroopMemberCard.sex, paramTroopMemberCard.age, paramTroopMemberCard.location, "");
    e();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramInt, paramString, 0).b(getTitleBarHeight());
    }
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
        break label99;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      return;
      label99:
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
      paramView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      paramView = (TextView)paramView.findViewById(2131298339);
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
      if (paramBoolean)
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.setClickable(true);
      }
    }
    else
    {
      return;
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramView.setClickable(false);
  }
  
  protected void a(TextView paramTextView, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq:" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramInt + ", " + paramBoolean3);
        }
        if ((paramBoolean1) || (paramBoolean2) || (this.jdField_h_of_type_Int == 0)) {
          break label638;
        }
        return;
      }
      catch (Exception paramTextView)
      {
        String str2;
        if (!QLog.isColorLevel()) {
          break label637;
        }
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq:" + paramTextView.toString());
        return;
        String str1 = "http://i.gtimg.cn/club/mobile/profile/icon/qvip_profile_svip_" + i1 + ".png";
        continue;
        float f1 = this.jdField_a_of_type_Float * 57.0F;
        continue;
        if (!paramBoolean2) {
          continue;
        }
        if (!paramBoolean3) {
          continue;
        }
        str1 = "http://i.gtimg.cn/club/mobile/profile/icon/qvip_profile_vip_annual_" + i1 + ".png";
        Object localObject = new ColorDrawable(0);
        localObject = URLDrawable.getDrawable(str1, (Drawable)localObject, (Drawable)localObject);
        paramInt = (int)(this.jdField_a_of_type_Float * 24.0F);
        if (!paramBoolean3) {
          continue;
        }
        f1 = this.jdField_a_of_type_Float * 60.0F;
        ((Drawable)localObject).setBounds(0, 0, (int)f1, paramInt);
        continue;
        str1 = "http://i.gtimg.cn/club/mobile/profile/icon/qvip_profile_vip_" + i1 + ".png";
        continue;
        f1 = this.jdField_a_of_type_Float * 50.0F;
        continue;
        if (this.jdField_h_of_type_Int != 0) {
          continue;
        }
        localObject = getResources().getDrawable(2130838851);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        str1 = "";
        continue;
        paramTextView.setPadding(0, 0, 0, 0);
        continue;
        localObject = null;
        str1 = "";
        continue;
      }
      if (paramBoolean1) {
        if (paramBoolean3)
        {
          str1 = "http://i.gtimg.cn/club/mobile/profile/icon/qvip_profile_svip_annual_" + i1 + ".png";
          localObject = new ColorDrawable(0);
          localObject = URLDrawable.getDrawable(str1, (Drawable)localObject, (Drawable)localObject);
          paramInt = (int)(this.jdField_a_of_type_Float * 26.0F);
          if (!paramBoolean3) {
            continue;
          }
          f1 = this.jdField_a_of_type_Float * 66.0F;
          ((Drawable)localObject).setBounds(0, 0, (int)f1, paramInt);
          str2 = paramString + "  ";
          paramInt = i2;
          paramString = str2;
          if (localObject != null)
          {
            paramInt = str2.length();
            paramString = str2 + "0";
          }
          paramString = new SpannableString(paramString);
          if (localObject != null) {
            paramString.setSpan(new ImageSpan((Drawable)localObject, 0), paramInt, paramInt + 1, 34);
          }
          if (localObject == null) {
            continue;
          }
          paramTextView.setPadding(0, 0, 0, (int)(6.0F * this.jdField_a_of_type_Float + 0.5F));
          paramTextView.setText(paramString);
          if (!QLog.isColorLevel()) {
            break label637;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq: url" + str1);
        }
      }
      label637:
      return;
      label638:
      int i1 = paramInt;
      if (paramInt < 1) {
        i1 = 1;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (isResume()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned) {}
    for (paramString1 = "1";; paramString1 = "0")
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624119));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131363727, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131363724, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362794);
      paramString2 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      if (paramString1.equalsIgnoreCase("0")) {}
      for (int i1 = 0;; i1 = 1)
      {
        paramString2.e(i1);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        this.D = 1;
        return;
      }
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
      paramString3.jdField_d_of_type_JavaLangString = paramString2;
      paramString3.jdField_c_of_type_JavaLangString = paramString1;
      paramString3.g = 1;
      paramString1 = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString3);
      paramString1.putExtra("AllInOne", paramString3);
      startActivityForResult(paramString1, 2);
      return;
    }
    if (paramBoolean)
    {
      paramString3 = new ProfileActivity.AllInOne(paramString3, 20);
      paramString3.jdField_d_of_type_JavaLangString = paramString2;
      paramString3.jdField_c_of_type_JavaLangString = paramString1;
      paramString3.g = 1;
      paramString1 = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString3);
      paramString1.putExtra("AllInOne", paramString3);
      startActivityForResult(paramString1, 2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {}
    for (paramString3 = new ProfileActivity.AllInOne(paramString3, 19);; paramString3 = new ProfileActivity.AllInOne(paramString3, 21))
    {
      paramString3.jdField_d_of_type_JavaLangString = paramString2;
      paramString3.jdField_c_of_type_JavaLangString = paramString1;
      paramString3.g = 1;
      paramString1 = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString3);
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
    Object localObject = (TextView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130903678, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    ((TextView)localObject).setText(2131363619);
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
        if (i2 != 1) {
          break label299;
        }
        localView.setBackgroundResource(2130837924);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        i1 += 1;
        break;
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localView.setClickable(false);
        break label251;
        label299:
        if (i1 == 0) {
          localView.setBackgroundResource(2130837927);
        } else if (i1 == i2 - 1) {
          localView.setBackgroundResource(2130837926);
        } else {
          localView.setBackgroundResource(2130837927);
        }
      }
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    paramString1 = DBUtils.a().a(this.app, paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.isTroopFollowed;
    }
    return false;
  }
  
  protected String b(String paramString1, String paramString2)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.app.getManager(8);
    if (localFriendsManagerImp != null) {
      return localFriendsManagerImp.b(paramString1, paramString2);
    }
    return "";
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void b(String paramString)
  {
    Bitmap localBitmap = ImageUtil.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    ThreadManager.b(new bnq(this, paramString));
  }
  
  public void b(String paramString1, String paramString2)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, EditInfoActivity.class);
    localIntent.putExtra("type", 0);
    localIntent.putExtra("title", getString(2131363098));
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
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "modify_name", "Clk", 0, 0, this.jdField_c_of_type_JavaLangString, paramString1, "", "");
      return;
      if (this.jdField_p_of_type_Int == 3) {
        paramString1 = "0";
      } else if (this.jdField_p_of_type_Int == 2) {
        paramString1 = "1";
      }
    }
  }
  
  protected void c()
  {
    try
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(Long.parseLong(this.jdField_c_of_type_JavaLangString), Long.parseLong(this.e));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "loadTroopMemberCard:" + localException.toString());
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
    for (paramString = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123", new Object[] { this.app.getSid(), Integer.valueOf(0), "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun" });; paramString = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123", new Object[] { this.app.getSid(), paramString, "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun" }))
    {
      paramString = paramString + "&ADTAG=mqq_qunmingpian";
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "gotoQQVipWebPage, url:" + paramString);
      }
      ReportController.b(this.app, "CliOper", "", "", "vip", "logo_in", 24, 0, "", "", "", "");
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
    this.e = localIntent.getStringExtra("memberUin");
    this.o = localIntent.getIntExtra("fromFlag", 0);
    if (this.o == 4) {
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent", "Clk_name", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "checkIntentParams:" + this.jdField_c_of_type_JavaLangString + "," + this.e + "," + this.o);
    }
    if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.app.a()))) {
      return false;
    }
    if (this.e.equals(this.app.a())) {}
    for (this.jdField_h_of_type_Int = 0;; this.jdField_h_of_type_Int = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(17));
      d();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      return true;
    }
  }
  
  protected void d()
  {
    boolean bool = false;
    Object localObject1 = (FriendManager)this.app.getManager(8);
    Object localObject4 = (TroopManager)this.app.getManager(44);
    Object localObject2 = ((FriendManager)localObject1).a(this.jdField_c_of_type_JavaLangString);
    Object localObject3 = DBUtils.a().a(this.app, this.jdField_c_of_type_JavaLangString, this.e);
    if (localObject2 != null)
    {
      this.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject2).troopname;
      this.jdField_d_of_type_JavaLangString = ((TroopInfo)localObject2).troopcode;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: troopInfo != null, troopCode:" + this.jdField_d_of_type_JavaLangString + ", mTroopName:" + this.jdField_b_of_type_JavaLangString);
      }
    }
    localObject4 = ((TroopManager)localObject4).a(this.jdField_c_of_type_JavaLangString, this.e);
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
      this.jdField_p_of_type_Int = a((TroopInfo)localObject2, this.app.a());
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend = ((FriendManager)localObject1).b(this.e);
      this.g = a(((TroopMemberCard)localObject4).joinTime);
      this.jdField_h_of_type_JavaLangString = a(((TroopMemberCard)localObject4).sex, ((TroopMemberCard)localObject4).age, ((TroopMemberCard)localObject4).location, "");
      if ((localObject2 != null) && (localObject3 != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName = ((String)((TroopInfo)localObject2).getTroopLevelMap().get(Integer.valueOf(((TroopMemberInfo)localObject3).level)));
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "initParams, troopInfo levelMap:" + ((TroopInfo)localObject2).troopLevelMap + " level:" + ((TroopMemberInfo)localObject3).level + " levelName:" + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName);
        }
        a((TroopInfo)localObject2);
      }
      return;
    }
    this.f = a(this.jdField_c_of_type_JavaLangString, this.e);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.credit = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend = ((FriendManager)localObject1).b(this.e);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned = a(this.jdField_c_of_type_JavaLangString, this.e);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card = b(this.jdField_c_of_type_JavaLangString, this.e);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isAllowModCard = true;
    this.jdField_p_of_type_Int = a((TroopInfo)localObject2, this.app.a());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole = a((TroopInfo)localObject2, this.e);
    if ((localObject2 != null) && (localObject3 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName = ((String)((TroopInfo)localObject2).getTroopLevelMap().get(Integer.valueOf(((TroopMemberInfo)localObject3).level)));
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "initParams, troopInfo levelMap:" + ((TroopInfo)localObject2).troopLevelMap + " level:" + ((TroopMemberInfo)localObject3).level + " levelName:" + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName);
      }
      a((TroopInfo)localObject2);
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
      localObject3 = ((FriendManager)localObject1).a(this.e);
      if (localObject3 == null) {
        break label944;
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
      label944:
      localObject1 = "";
      localObject2 = "";
      i1 = 0;
    }
  }
  
  public void d(String paramString)
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
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_card", paramString1, 0, 0, this.jdField_c_of_type_JavaLangString, str1, str2, str3);
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
    String str;
    switch (paramInt1)
    {
    case 5: 
    default: 
    case 1: 
      do
      {
        return;
        a(2, getString(2131363087));
        paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
        str = b(this.jdField_c_of_type_JavaLangString, this.e);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card = str;
        a(paramIntent, str, true);
        paramIntent.setContentDescription(super.getString(2131363098) + str);
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
      str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_TROOP_DISBAND, finSelf=" + bool + " strTip=" + str + " uin=" + paramIntent);
      }
      if (!TextUtils.isEmpty(paramIntent))
      {
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.app.getManager(8);
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
        a(2, str);
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
    setContentView(2130903675);
    f();
    j();
    e();
    c();
    e("exp");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  protected void e()
  {
    int i1 = 3;
    int i2 = 0;
    Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298875);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298877);
    Object localObject2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298876);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298878);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298872);
    TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298873);
    label149:
    label181:
    label229:
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0)
    {
      localView.setVisibility(0);
      localTextView3.setText(2131363109);
      ((TextView)localObject1).setText(this.f);
      if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        break label927;
      }
      localTextView2.setText(this.jdField_h_of_type_JavaLangString);
      localTextView2.setVisibility(0);
      localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2) {
        break label937;
      }
      localObject1 = getString(2131362844);
      ((TextView)localObject2).setBackgroundResource(2130839433);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label968;
      }
      ((TextView)localObject2).setPadding(AIOUtils.a(5.0F, getResources()), 0, AIOUtils.a(5.0F, getResources()), 0);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) || (TextUtils.isEmpty(this.g))) {
        break label978;
      }
      localTextView1.setText(this.g);
      localTextView1.setVisibility(0);
      label264:
      localObject1 = super.getString(2131363864) + super.getString(2131363395) + this.f + (String)localObject1 + this.jdField_h_of_type_JavaLangString + this.g;
      this.jdField_a_of_type_AndroidViewView.setContentDescription((CharSequence)localObject1);
      localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
      a((View)localObject2, this.e, true);
      a(((TroopMemberCardActivity.ViewHolder)((View)localObject2).getTag()).b, this.e, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip);
      if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip) {
        break label1000;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip) {
        break label988;
      }
      localObject1 = super.getString(2131362657);
      label426:
      localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel + super.getString(2131363106);
      label463:
      ((View)localObject2).setContentDescription(super.getString(2131363864) + this.e + (String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {
        break label1236;
      }
      ((View)localObject2).setBackgroundResource(2130837927);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(0);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = getString(2131363447);
      }
      localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
      ((View)localObject2).setContentDescription(super.getString(2131363098) + (String)localObject1);
      if (this.jdField_h_of_type_Int != 0) {
        break label1093;
      }
      a((View)localObject2, (String)localObject1, true);
      label612:
      this.jdField_a_of_type_ArrayOfAndroidViewView[2].setVisibility(0);
      if (TextUtils.isEmpty(this.j)) {
        break label1143;
      }
      bool = true;
      label634:
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[2];
      if (bool)
      {
        ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((View)localObject1).setContentDescription(super.getString(2131363094) + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName);
      }
      a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName, bool);
      localObject1 = (TroopMemberCardActivity.ViewHolder)((View)localObject1).getTag();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName)) {
        break label1148;
      }
      ((TroopMemberCardActivity.ViewHolder)localObject1).b.setVisibility(4);
      label736:
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[3];
      if (this.jdField_h_of_type_Int == 0) {
        break label1212;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned) {
        break label1160;
      }
      a((View)localObject1, super.getString(2131363724), true);
      ((View)localObject1).setContentDescription(super.getString(2131363620) + super.getString(2131363724));
      label810:
      ((View)localObject1).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label824:
      i1 = i2;
      if (this.jdField_h_of_type_Int == 1) {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
          break label1231;
        }
      }
    }
    label927:
    label937:
    label968:
    label1231:
    for (i1 = 3;; i1 = 2)
    {
      a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.customEntryList);
      return;
      if ((this.jdField_h_of_type_Int != 0) && ((this.jdField_p_of_type_Int == 2) || (this.jdField_p_of_type_Int == 3)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.credit == 1))
      {
        localView.setVisibility(0);
        localTextView3.setText(2131363110);
        break;
      }
      localView.setVisibility(4);
      break;
      localTextView2.setVisibility(8);
      break label149;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 3) {
        break label181;
      }
      localObject1 = getString(2131362845);
      ((TextView)localObject2).setBackgroundResource(2130839434);
      break label181;
      ((TextView)localObject2).setVisibility(8);
      break label229;
      label978:
      localTextView1.setVisibility(8);
      break label264;
      label988:
      localObject1 = super.getString(2131362658);
      break label426;
      label1000:
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip) {}
        for (localObject1 = super.getString(2131362659);; localObject1 = super.getString(2131362660))
        {
          localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel + super.getString(2131363106);
          break;
        }
      }
      localObject1 = super.getString(2131362661);
      break label463;
      if (((this.jdField_p_of_type_Int == 2) || (this.jdField_p_of_type_Int == 3)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isAllowModCard))
      {
        a((View)localObject2, (String)localObject1, true);
        break label612;
      }
      a((View)localObject2, (String)localObject1, false);
      break label612;
      label1143:
      bool = false;
      break label634;
      label1148:
      ((TroopMemberCardActivity.ViewHolder)localObject1).b.setVisibility(0);
      break label736;
      a((View)localObject1, super.getString(2131363727), true);
      ((View)localObject1).setContentDescription(super.getString(2131363620) + super.getString(2131363727));
      break label810;
      ((View)localObject1).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label824;
    }
    label1093:
    label1236:
    this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundResource(2130837926);
    label1160:
    label1212:
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
      return;
      i1 = 1;
      continue;
      i1 = 0;
    }
  }
  
  public void e(String paramString)
  {
    d(paramString, null);
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity = this;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297563));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298870));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130903676, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298874));
    b(this.e);
    a(0, getString(2131363864), "", true);
    a(1, getString(2131363098), "", true);
    a(2, getString(2131363094), "", false);
    Object localObject = (TroopMemberCardActivity.ViewHolder)this.jdField_a_of_type_ArrayOfAndroidViewView[2].getTag();
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setVisibility(4);
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setTextColor(Color.parseColor("#ffffff"));
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setBackgroundResource(2130839140);
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setIncludeFontPadding(false);
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setGravity(17);
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setPadding((int)(this.jdField_a_of_type_Float * 7.0F), 0, (int)(this.jdField_a_of_type_Float * 7.0F), 0);
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setTextSize(1, 13.0F);
    ViewGroup.LayoutParams localLayoutParams = ((TroopMemberCardActivity.ViewHolder)localObject).b.getLayoutParams();
    localLayoutParams.height = ((int)(19.0F * this.jdField_a_of_type_Float));
    ((TroopMemberCardActivity.ViewHolder)localObject).b.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2].setBackgroundResource(2130837926);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout);
    a(3, getString(2131363620), "", true);
    localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[3].getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131492902);
      this.jdField_a_of_type_ArrayOfAndroidViewView[3].setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[3].setBackgroundResource(2130837924);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130903678, this.jdField_a_of_type_AndroidWidgetLinearLayout, false));
    localObject = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(2.0F * this.jdField_a_of_type_Float));
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(2131493029);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, getResources().getInteger(2131558401));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363621);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(super.getString(2131363621));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    g();
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
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = getResources().getColor(2131427446);
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2130903517, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    localView.setBackgroundColor(i1);
    localLayoutParams = new LinearLayout.LayoutParams(1, -1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2130903517, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    localView.setBackgroundColor(i1);
    localLayoutParams = new LinearLayout.LayoutParams(1, -1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2130903517, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
  }
  
  public boolean g()
  {
    if (!NetworkUtil.e(getApplication().getApplicationContext()))
    {
      a(getString(2131363516));
      return false;
    }
    return true;
  }
  
  public int getPathNodeID()
  {
    return 12;
  }
  
  public void h()
  {
    Dialog localDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2131624119);
    localDialog.setContentView(2130903187);
    ((TextView)localDialog.findViewById(2131296911)).setText(getString(2131362852));
    TextView localTextView = (TextView)localDialog.findViewById(2131296470);
    CheckBox localCheckBox = (CheckBox)localDialog.findViewById(2131297087);
    if ((localTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localCheckBox.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localTextView.setText(getString(2131362859));
    localCheckBox.setText(getString(2131362860));
    localTextView = (TextView)localDialog.findViewById(2131296914);
    Object localObject = (TextView)localDialog.findViewById(2131296915);
    localTextView.setText(17039360);
    ((TextView)localObject).setText(17039370);
    localTextView.setOnClickListener(new bnx(this, localDialog));
    ((TextView)localObject).setOnClickListener(new bny(this, localCheckBox, localDialog));
    localDialog.show();
    ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_movegrp", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a((byte)0, this.jdField_c_of_type_JavaLangString, this.e);
      b(2131362865);
    }
    for (;;)
    {
      try
      {
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_card", "un_admin", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
        return;
      }
      catch (Exception localException2) {}
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a((byte)1, this.jdField_c_of_type_JavaLangString, this.e);
        b(2131362861);
        try
        {
          ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_card", "Clk_setadmin", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
          return;
        }
        catch (Exception localException1) {}
      }
    }
  }
  
  protected void j()
  {
    if (this.jdField_h_of_type_Int == 0) {
      setTitle(2131363096);
    }
    for (;;)
    {
      ImageView localImageView = this.jdField_p_of_type_AndroidWidgetImageView;
      localImageView.setVisibility(0);
      localImageView.setImageResource(2130838038);
      localImageView.setContentDescription(getString(2131364151));
      localImageView.setOnClickListener(new bnp(this));
      return;
      setTitle(2131363097);
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
    if (this.jdField_h_of_type_Int == 0)
    {
      this.D = 2;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362794);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131363427), 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    this.jdField_a_of_type_Boolean = ((TroopGagMgr)this.app.getManager(42)).a(this.jdField_c_of_type_JavaLangString, this.e);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362794);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131363580);
      this.D = 4;
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
          break label328;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label291;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131362529);
        label228:
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131363580);
        if (this.jdField_p_of_type_Int == 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2) {
            break label304;
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131362851);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131362853, 3);
        this.D = 3;
        break;
        i1 = 0;
        break label207;
        label291:
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131362528);
        break label228;
        label304:
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 1) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131362850);
        }
      }
      label328:
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131363580);
      this.D = 4;
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void m()
  {
    String str2 = this.f;
    int i1 = 10004;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 0) {
      i1 = 3004;
    }
    for (String str1 = this.jdField_d_of_type_JavaLangString;; str1 = null)
    {
      startActivityForResult(AddFriendLogicActivity.a(this, 1, this.e, str1, i1, 0, str2, null, null, null), 3);
      return;
    }
  }
  
  public void n()
  {
    if (!TextUtils.isEmpty(this.j))
    {
      String str = Uri.encode(this.j);
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", "http://qinfo.clt.qq.com/qlevel/level.html?str=" + str);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberCardActivity
 * JD-Core Version:    0.7.0.1
 */