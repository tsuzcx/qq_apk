package com.tencent.mobileqq.activity;

import acbn;
import acff;
import afsi;
import afwy;
import alcn;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.ImageView;
import aprg;
import aqft;
import aqha;
import aqul;
import asgx;
import aurh;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.activity.profile.friend.FriendProfileFragment;
import com.tencent.tim.activity.profile.friend.StrangerProfileFragment;
import com.tencent.tim.activity.profile.friend.TroopFriendProfileFragment;
import com.tencent.tim.activity.profile.friend.TroopStrangerProfileFragment;
import com.tencent.tim.activity.profile.host.HostProfileFragment;
import com.tencent.tim.activity.profile.host.TroopHostProfileFragment;
import ilp;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import jou;
import jqs;
import vmb;
import vmc;
import vmd;
import vme;

public abstract class ProfileActivity
  extends BaseActivity
  implements acbn
{
  public static final int[][] p;
  
  static
  {
    int[] arrayOfInt = { 2130851551, 2131167509 };
    p = new int[][] { { 2130851548, 2131167508 }, arrayOfInt, { 2130851554, 2131167510 } };
  }
  
  public static int a(AllInOne paramAllInOne)
  {
    if (paramAllInOne.pa == 0) {
      return 2;
    }
    if (AllInOne.b(paramAllInOne)) {
      return 0;
    }
    return 1;
  }
  
  public static long a(AllInOne paramAllInOne, boolean paramBoolean)
  {
    long l1 = 0L;
    if (AllInOne.a(paramAllInOne)) {
      l1 = 0L | 1L;
    }
    long l2 = l1 | 0x4 | 0x10000;
    l1 = l2;
    if (AllInOne.g(paramAllInOne)) {
      l1 = l2 | 0x8;
    }
    l2 = l1 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800;
    l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (AllInOne.b(paramAllInOne)) {
        l1 = l2 | 0x2000;
      }
    }
    return l1;
  }
  
  public static Intent a(Context paramContext, AllInOne paramAllInOne)
  {
    boolean bool2 = true;
    if ((paramAllInOne != null) && (jou.df(paramAllInOne.uin))) {
      return new Intent(paramContext, QidianProfileCardActivity.class);
    }
    Object localObject;
    if ((paramAllInOne != null) && ((paramContext instanceof BaseActivity)) && (((BaseActivity)paramContext).app != null))
    {
      localObject = ((BaseActivity)paramContext).app;
      if ((jqs.c((QQAppInterface)localObject, paramAllInOne.uin)) || (asgx.ag((QQAppInterface)localObject, paramAllInOne.uin)) || (asgx.af((QQAppInterface)localObject, paramAllInOne.uin)))
      {
        boolean bool1 = bool2;
        if (!(paramContext instanceof SplashActivity)) {
          if (!(paramContext instanceof ChatActivity)) {
            break label125;
          }
        }
        label125:
        for (bool1 = bool2;; bool1 = false) {
          return jqs.a(paramContext, null, paramAllInOne.uin, bool1, -1, false, -1);
        }
      }
    }
    if ((paramAllInOne != null) && (aqft.rj(paramAllInOne.uin)) && (!TextUtils.isEmpty(aqft.csE)))
    {
      paramContext = new Intent(paramContext, QQBrowserActivity.class);
      paramContext.putExtra("url", aqft.csE);
      return paramContext;
    }
    paramContext = new Intent(paramContext, FriendProfileCardActivity.class);
    if (paramAllInOne != null)
    {
      if (blz.equals(paramAllInOne.aOG)) {
        paramContext.putExtra("key_from_ark_babyq", true);
      }
      localObject = paramAllInOne.data;
      if (localObject != null) {
        paramContext.putExtra("param_wzry_data", ((Bundle)localObject).getSerializable("param_wzry_data"));
      }
    }
    if ((paramAllInOne != null) && (paramAllInOne.data != null))
    {
      paramAllInOne = paramAllInOne.data.getBundle("flc_extra_param");
      if (paramAllInOne != null) {
        paramContext.putExtra("flc_extra_param", paramAllInOne);
      }
    }
    aurh.ewt();
    return paramContext;
  }
  
  public static Uri a(Activity paramActivity, int paramInt)
  {
    if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext())) {
      return null;
    }
    if (AudioHelper.isForbidByRubbishMeizu(0))
    {
      aqha.a(paramActivity, 230, paramActivity.getString(2131700589), paramActivity.getString(2131700590), new vmb(), null).show();
      return null;
    }
    if (AudioHelper.mr(0))
    {
      aqha.a(paramActivity, 230, paramActivity.getString(2131700589), paramActivity.getString(2131700591), new vmc(), null).show();
      return null;
    }
    Object localObject1 = new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "photo/"));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    Object localObject2 = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "photo/" + System.currentTimeMillis() + ".jpg");
    localObject1 = new Intent();
    localObject2 = FileProvider7Helper.setSystemCapture(paramActivity, new File((String)localObject2), (Intent)localObject1);
    ((Intent)localObject1).putExtra("android.intent.extra.videoQuality", 100);
    paramActivity.startActivityForResult((Intent)localObject1, paramInt);
    return localObject2;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, alcn paramalcn)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramalcn == null) || (paramalcn.e == null)) {}
    do
    {
      do
      {
        return;
        paramActivity = paramActivity.getIntent();
      } while (paramActivity == null);
      paramIntent.putExtra("param_return_profilecard_pa", paramalcn.e.pa);
      paramIntent.putExtra("param_return_profilecard_subsourceid", paramalcn.e.subSourceId);
      if (gj(paramalcn.e.pa)) {
        paramIntent.putExtra("param_return_profilecard_discuss_uin", paramalcn.e.discussUin);
      }
      if (gk(paramalcn.e.pa)) {
        paramIntent.putExtra("param_return_profilecard_group_uin", paramalcn.e.troopUin);
      }
      if (paramalcn.cwc) {
        paramIntent.putExtra("param_return_profilecard_troop_uin", paramalcn.troopUin);
      }
      paramIntent.putExtra("flc_extra_param", paramActivity.getBundleExtra("flc_extra_param"));
    } while (!QLog.isColorLevel());
    QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "updateIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s,  subSourceId:%s, extra:%s]", new Object[] { Integer.valueOf(paramalcn.e.pa), aqft.pl(paramalcn.e.uin), paramalcn.e.troopUin, paramalcn.e.discussUin, paramalcn.troopUin, Integer.valueOf(paramalcn.e.subSourceId), paramActivity.getBundleExtra("flc_extra_param") }));
  }
  
  public static void a(Activity paramActivity, AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtra("requestCode", paramInt);
      localIntent.addFlags(536870912);
      a(paramActivity, paramAllInOne, localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
    }
  }
  
  public static void a(Activity paramActivity, AllInOne paramAllInOne, int paramInt, Bundle paramBundle)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtra("requestCode", paramInt);
      localIntent.addFlags(536870912);
      if (paramBundle != null) {
        localIntent.putExtra("profile_extres", paramBundle);
      }
      a(paramActivity, paramAllInOne, localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
    }
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, String paramString)
  {
    if (((acff)paramAppInterface.getManager(51)).isFriend(paramString)) {}
    for (int i = 1;; i = 114)
    {
      a(paramContext, new AllInOne(paramString, i), false);
      return;
    }
  }
  
  public static void a(Context paramContext, AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      a(paramContext, paramAllInOne, localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, AllInOne paramAllInOne, int paramInt1, int paramInt2)
  {
    if (paramContext != null)
    {
      if (paramAllInOne != null) {}
      try
      {
        Object localObject = ((afsi)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(264)).a(paramAllInOne.uin, false);
        int i = 8;
        if (localObject != null) {
          i = ExtendFriendUserInfo.fromTypeToSubID(((ExtendFriendUserInfo)localObject).fromType);
        }
        paramAllInOne.subSourceId = i;
        localObject = a(paramContext, paramAllInOne);
        ((Intent)localObject).putExtra("AllInOne", paramAllInOne);
        if (paramInt1 == 1) {
          ((Intent)localObject).putExtra("key_from_limit_chat_plus", true);
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("entrance", paramInt2);
          ((Intent)localObject).putExtra("key_from_extends_friend", true);
          ((Intent)localObject).putExtra("ExtendFriendLimitChatFromeType", paramInt1);
          ((Intent)localObject).putExtra("key_from_extends_friend_limit_chat", true);
          ((Intent)localObject).addFlags(536870912);
          a(paramContext, paramAllInOne, (Intent)localObject);
          afwy.Iu(paramAllInOne.uin);
          return;
          ((Intent)localObject).putExtra("key_from_limit_chat_plus", false);
        }
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("Q.profilecard.FrdProfileCard", 1, "openProfileCardFromLimitChat fail.", paramContext);
      }
    }
  }
  
  public static void a(Context paramContext, AllInOne paramAllInOne, Intent paramIntent)
  {
    a(paramContext, paramAllInOne, paramIntent, -1);
  }
  
  public static void a(Context paramContext, AllInOne paramAllInOne, Intent paramIntent, int paramInt)
  {
    if (paramAllInOne.pa == 0) {
      if (paramIntent.hasExtra("troopUin")) {
        paramAllInOne = TroopHostProfileFragment.class;
      }
    }
    while ((paramInt > 0) && ((paramContext instanceof Activity)))
    {
      PublicFragmentActivity.b.startForResult((Activity)paramContext, paramIntent, PublicFragmentActivity.class, paramAllInOne, paramInt);
      return;
      paramAllInOne = HostProfileFragment.class;
      continue;
      if (paramAllInOne.pa == 21) {
        paramAllInOne = TroopStrangerProfileFragment.class;
      } else if (paramAllInOne.pa == 20) {
        paramAllInOne = TroopFriendProfileFragment.class;
      } else if (paramAllInOne.pa == 1) {
        paramAllInOne = FriendProfileFragment.class;
      } else if (paramIntent.hasExtra("troopUin")) {
        paramAllInOne = TroopStrangerProfileFragment.class;
      } else {
        paramAllInOne = StrangerProfileFragment.class;
      }
    }
    PublicFragmentActivity.b.start(paramContext, paramIntent, PublicFragmentActivity.class, paramAllInOne);
  }
  
  public static void a(Context paramContext, AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {
      try
      {
        Intent localIntent = a(paramContext, paramAllInOne);
        localIntent.putExtra("AllInOne", paramAllInOne);
        if ((paramBundle != null) && (paramBundle.getBoolean("single_top", false))) {
          localIntent.addFlags(67108864);
        }
        for (;;)
        {
          if (!(paramContext instanceof Activity)) {
            localIntent.addFlags(268435456);
          }
          if ((paramBundle != null) && (paramBundle.getBoolean("key_need_track_back", false))) {
            localIntent.putExtra("key_need_track_back", true);
          }
          if (paramBundle != null) {
            localIntent.putExtra("profile_extres", paramBundle);
          }
          a(paramContext, paramAllInOne, localIntent);
          return;
          localIntent.addFlags(536870912);
        }
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
        }
      }
    }
  }
  
  public static void a(Context paramContext, AllInOne paramAllInOne, boolean paramBoolean)
  {
    if (paramContext != null) {
      try
      {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramAllInOne != null) && ((localObject instanceof QQAppInterface)) && (aprg.V((QQAppInterface)localObject, paramAllInOne.uin)))
        {
          aprg.H(paramContext, null, paramAllInOne.uin);
          return;
        }
        localObject = a(paramContext, paramAllInOne);
        ((Intent)localObject).putExtra("AllInOne", paramAllInOne);
        if (paramBoolean) {
          ((Intent)localObject).addFlags(536870912);
        }
        if (!(paramContext instanceof Activity)) {
          ((Intent)localObject).addFlags(268435456);
        }
        if ((paramAllInOne != null) && (!gi(paramAllInOne.pa)))
        {
          a(paramContext, paramAllInOne, (Intent)localObject);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
          return;
          paramContext.startActivity((Intent)localObject);
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Drawable paramDrawable)
  {
    if ((paramAppInterface != null) && (paramDrawable != null))
    {
      if (ThemeUtil.isInNightMode(paramAppInterface)) {
        paramDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
    }
    else {
      return;
    }
    paramDrawable.clearColorFilter();
  }
  
  public static void a(AppInterface paramAppInterface, ImageView paramImageView)
  {
    if ((paramAppInterface != null) && (paramImageView != null))
    {
      if (ThemeUtil.isInNightMode(paramAppInterface)) {
        paramImageView.setColorFilter(1996488704);
      }
    }
    else {
      return;
    }
    paramImageView.setColorFilter(0);
  }
  
  public static void b(Activity paramActivity, AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtra("requestCode", paramInt);
      localIntent.putExtra("key_from_extends_friend", true);
      localIntent.putExtra("key_from_extends_friend_limit_chat", false);
      localIntent.addFlags(536870912);
      a(paramActivity, paramAllInOne, localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("Q.profilecard.FrdProfileCard", 1, "openProfileCardForResultFromExtendFriend fail.", paramActivity);
    }
  }
  
  public static void b(Activity paramActivity, String paramString, Intent paramIntent)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)) || (paramIntent == null)) {}
    int i;
    AllInOne localAllInOne;
    do
    {
      do
      {
        return;
        paramActivity = paramActivity.getIntent();
      } while (paramActivity == null);
      i = paramActivity.getIntExtra("param_return_profilecard_pa", 19);
      localAllInOne = new AllInOne(paramString, i);
      if (gj(i)) {
        localAllInOne.discussUin = paramActivity.getStringExtra("param_return_profilecard_discuss_uin");
      }
      if (gk(i))
      {
        localAllInOne.troopUin = paramActivity.getStringExtra("param_return_profilecard_group_uin");
        paramIntent.putExtra("troopUin", paramActivity.getStringExtra("param_return_profilecard_troop_uin"));
      }
      localAllInOne.subSourceId = paramActivity.getIntExtra("param_return_profilecard_subsourceid", 0);
      paramIntent.putExtra("flc_extra_param", paramActivity.getBundleExtra("flc_extra_param"));
      paramIntent.putExtra("AllInOne", localAllInOne);
    } while (!QLog.isColorLevel());
    QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "initProfileIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s, subSourceId:%s, extra:%s]", new Object[] { Integer.valueOf(i), aqft.pl(paramString), localAllInOne.troopUin, localAllInOne.discussUin, paramActivity.getStringExtra("param_return_profilecard_troop_uin"), Integer.valueOf(localAllInOne.subSourceId), paramActivity.getBundleExtra("flc_extra_param") }));
  }
  
  public static void b(Context paramContext, AllInOne paramAllInOne)
  {
    a(paramContext, paramAllInOne, true);
  }
  
  public static void b(Context paramContext, AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(536870912);
      localIntent.addFlags(268435456);
      if (paramBundle != null) {
        localIntent.putExtra("profile_extres", paramBundle);
      }
      a(paramContext, paramAllInOne, localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static int eP(int paramInt)
  {
    if (paramInt == 1) {}
    while (((paramInt >= 4) && (paramInt <= 21)) || ((paramInt >= 30) && (paramInt <= 37)) || (paramInt == 57) || (paramInt == 59) || ((paramInt >= 60) && (paramInt <= 61)) || ((paramInt >= 64) && (paramInt <= 68)) || (paramInt == 84) || ((paramInt >= 87) && (paramInt <= 88)) || (paramInt == 98)) {
      return paramInt;
    }
    return 999;
  }
  
  public static boolean gf(int paramInt)
  {
    switch (paramInt)
    {
    case 12: 
    case 14: 
    case 16: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean gg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean gh(int paramInt)
  {
    switch (paramInt)
    {
    case 33: 
    default: 
      return false;
    }
    return true;
  }
  
  private static boolean gi(int paramInt)
  {
    return (paramInt == 29) || (paramInt == 30) || (paramInt == 31) || (paramInt == 32) || (paramInt == 33) || (paramInt == 34);
  }
  
  public static boolean gj(int paramInt)
  {
    return (paramInt == 45) || (paramInt == 46) || (paramInt == 47);
  }
  
  public static boolean gk(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 21) || (paramInt == 22);
  }
  
  public static boolean s(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1500L;
  }
  
  public static class AllInOne
    implements Parcelable
  {
    public static final Parcelable.Creator<AllInOne> CREATOR = new vmd();
    public long Gz;
    public String aOE;
    public String aOF = "";
    public String aOG;
    public String aOH;
    public String aOI;
    public String aOJ;
    public String aOK;
    public boolean aZe;
    public Bundle ae = new Bundle();
    public int age = -1;
    public String alias;
    public int bIW;
    public int bIX = -1;
    public int bIY;
    public int bIZ;
    public int bJa = 999;
    public int bJb;
    public int bJc;
    public int bJd;
    public boolean bindQQ;
    public byte[] cf;
    public byte[] ch;
    public byte constellation;
    public String contactName;
    public Bundle data = new Bundle();
    public String discussUin;
    public String encId = "";
    public short faceId = -1;
    public byte gender = -1;
    public byte maritalStatus;
    public String nickname;
    public int pa;
    public ArrayList<ProfileActivity.CardContactInfo> pr;
    public int profession_id;
    public String remark;
    public int subSourceId;
    public String troopUin;
    public String troopcode;
    public String uid = "";
    public String uin;
    public byte[] xuanYan;
    
    private AllInOne() {}
    
    public AllInOne(String paramString, int paramInt)
    {
      this.uin = paramString;
      this.pa = paramInt;
    }
    
    public static boolean a(AllInOne paramAllInOne)
    {
      if (i(paramAllInOne)) {}
      while ((paramAllInOne.pa == 41) || (paramAllInOne.pa == 42) || (paramAllInOne.pa == 86) || (paramAllInOne.pa == 4) || (paramAllInOne.pa == 52) || (paramAllInOne.pa == 56) || (paramAllInOne.pa == 57) || (paramAllInOne.pa == 71) || (paramAllInOne.pa == 72) || (paramAllInOne.pa == 58) || (paramAllInOne.pa == 80)) {
        return false;
      }
      return paramAllInOne.pa == 95;
    }
    
    public static boolean b(AllInOne paramAllInOne)
    {
      return (paramAllInOne.pa == 30) || (paramAllInOne.pa == 40) || (paramAllInOne.pa == 20) || (paramAllInOne.pa == 1) || (paramAllInOne.pa == 60) || (paramAllInOne.pa == 55) || (paramAllInOne.pa == 45) || (paramAllInOne.pa == 0);
    }
    
    public static boolean c(AllInOne paramAllInOne)
    {
      boolean bool2 = true;
      boolean bool1;
      if (Build.VERSION.SDK_INT < 8) {
        bool1 = false;
      }
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
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return bool1;
                            bool1 = bool2;
                          } while (b(paramAllInOne));
                          if (paramAllInOne.pa == 29) {
                            return false;
                          }
                          bool1 = bool2;
                        } while (paramAllInOne.pa == 21);
                        bool1 = bool2;
                      } while (paramAllInOne.pa == 22);
                      bool1 = bool2;
                    } while (paramAllInOne.pa == 46);
                    bool1 = bool2;
                  } while (paramAllInOne.pa == 47);
                  if (paramAllInOne.pa != 31) {
                    break;
                  }
                  bool1 = bool2;
                } while (paramAllInOne.bJb != 3001);
                return false;
                bool1 = bool2;
              } while (paramAllInOne.pa == 34);
              bool1 = bool2;
            } while (paramAllInOne.pa == 50);
            bool1 = bool2;
          } while (paramAllInOne.pa == 71);
          bool1 = bool2;
        } while (paramAllInOne.pa == 72);
        bool1 = bool2;
      } while (paramAllInOne.pa == 80);
      return false;
    }
    
    public static boolean d(AllInOne paramAllInOne)
    {
      if (paramAllInOne.pa == 0) {}
      while ((paramAllInOne.pa == 33) || (paramAllInOne.pa == 28) || (paramAllInOne.pa == 108) || (b(paramAllInOne)) || (paramAllInOne.pa == 80)) {
        return false;
      }
      return true;
    }
    
    public static boolean e(AllInOne paramAllInOne)
    {
      if (b(paramAllInOne)) {}
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
                return true;
              } while (h(paramAllInOne));
              if (paramAllInOne.pa == 29) {
                return false;
              }
            } while ((paramAllInOne.pa == 41) || (paramAllInOne.pa == 21) || (paramAllInOne.pa == 58));
            if (paramAllInOne.pa != 3) {
              break;
            }
          } while (paramAllInOne.bIW != 0);
          return false;
          if (paramAllInOne.pa != 31) {
            break;
          }
        } while (paramAllInOne.bJb != 3001);
        return false;
      } while ((paramAllInOne.pa == 34) || (paramAllInOne.pa == 50) || (paramAllInOne.pa == 46) || (paramAllInOne.pa == 56) || (paramAllInOne.pa == 71) || (paramAllInOne.pa == 70));
      return paramAllInOne.pa != 95;
    }
    
    public static boolean f(AllInOne paramAllInOne)
    {
      return (paramAllInOne.pa == 20) || (paramAllInOne.pa == 21) || (paramAllInOne.pa == 22) || (paramAllInOne.pa == 23) || (paramAllInOne.pa == 24) || (paramAllInOne.pa == 120);
    }
    
    public static boolean g(AllInOne paramAllInOne)
    {
      return !i(paramAllInOne);
    }
    
    public static boolean h(AllInOne paramAllInOne)
    {
      return (paramAllInOne.pa == 22) || (paramAllInOne.pa == 42) || (paramAllInOne.pa == 2) || (paramAllInOne.pa == 34) || (paramAllInOne.pa == 47) || (paramAllInOne.pa == 57) || (paramAllInOne.pa == 72) || (paramAllInOne.pa == 27) || (paramAllInOne.pa == 74) || (paramAllInOne.pa == 86);
    }
    
    public static boolean i(AllInOne paramAllInOne)
    {
      return (paramAllInOne.pa == 33) || (paramAllInOne.pa == 32) || (paramAllInOne.pa == 31) || (paramAllInOne.pa == 34) || (paramAllInOne.pa == 50) || (paramAllInOne.pa == 51) || (paramAllInOne.pa == 53) || (paramAllInOne.pa == 29) || (paramAllInOne.pa == 36);
    }
    
    public static boolean j(AllInOne paramAllInOne)
    {
      if (paramAllInOne == null) {}
      while (paramAllInOne.pa != 95) {
        return false;
      }
      return true;
    }
    
    public static boolean k(AllInOne paramAllInOne)
    {
      if (paramAllInOne == null) {}
      while (paramAllInOne.pa != 96) {
        return false;
      }
      return true;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin = ").append(this.uin).append(",nickname = ").append(this.nickname).append(",alais = ").append(this.alias).append(",age = ").append(this.age).append(",gender = ").append(this.gender).append(",faceId = ").append(this.faceId).append(",pa = ").append(this.pa).append(", troopcode = ").append(this.troopcode).append(", contactArray = ").append(this.pr).append(", troopUin = ").append(this.troopUin).append(", troopNickName = ").append(this.aOI).append(", nChatAbility = ").append(this.bIW).append(", remark = ").append(this.remark).append(", discussUin = ").append(this.discussUin).append(", preWinUin = ").append(this.aOF).append(", preWinType = ").append(this.bIX).append(", contactName = ").append(this.contactName).append(", circleName = ").append(this.aOJ).append(", recommendName = ").append(this.aOH).append(", mLastActivity = ").append(this.bIZ).append(",nProfileEntryType = ").append(this.bJa).append(", nRichStatusId = ").append(this.bJd).append(", encId = ").append(this.encId).append(", uid = ").append(this.uid).append(", colorScreen = ").append(this.bIY).append(", likeSource = ").append(this.Gz).append(this.subSourceId).append(", aioDistance = ").append(this.aOK);
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.uin);
      paramParcel.writeInt(this.pa);
      paramParcel.writeInt(this.age);
      paramParcel.writeByte(this.gender);
      paramParcel.writeInt(this.faceId);
      paramParcel.writeByte(this.maritalStatus);
      paramParcel.writeInt(this.profession_id);
      paramParcel.writeByte(this.constellation);
      paramParcel.writeByteArray(this.xuanYan);
      paramParcel.writeString(this.aOE);
      paramParcel.writeString(this.troopcode);
      paramParcel.writeString(this.troopUin);
      paramParcel.writeString(this.discussUin);
      paramParcel.writeTypedList(this.pr);
      paramParcel.writeInt(this.bIW);
      if (this.aZe) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeString(this.aOF);
        paramParcel.writeInt(this.bIX);
        paramParcel.writeString(this.nickname);
        paramParcel.writeString(this.remark);
        paramParcel.writeString(this.alias);
        paramParcel.writeString(this.contactName);
        paramParcel.writeString(this.aOH);
        paramParcel.writeString(this.aOI);
        paramParcel.writeString(this.aOJ);
        paramParcel.writeInt(this.bIZ);
        paramParcel.writeInt(this.bJa);
        paramParcel.writeInt(this.bJb);
        paramParcel.writeByteArray(this.cf);
        paramParcel.writeInt(this.bJc);
        paramParcel.writeInt(this.bJd);
        paramParcel.writeString(this.encId);
        paramParcel.writeString(this.uid);
        paramParcel.writeLong(this.Gz);
        paramParcel.writeInt(this.subSourceId);
        paramParcel.writeString(this.aOK);
        paramParcel.writeParcelable(this.data, paramInt);
        paramParcel.writeInt(this.bIY);
        paramParcel.writeParcelable(this.ae, paramInt);
        paramParcel.writeByteArray(this.ch);
        return;
      }
    }
  }
  
  public static class CardContactInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<CardContactInfo> CREATOR = new vme();
    public String aOL;
    public String aOM;
    public String phoneNumber;
    
    private CardContactInfo() {}
    
    public CardContactInfo(String paramString1, String paramString2, String paramString3)
    {
      this.aOL = paramString1;
      this.phoneNumber = paramString2;
      this.aOM = paramString3;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.aOL);
      paramParcel.writeString(this.phoneNumber);
      paramParcel.writeString(this.aOM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity
 * JD-Core Version:    0.7.0.1
 */