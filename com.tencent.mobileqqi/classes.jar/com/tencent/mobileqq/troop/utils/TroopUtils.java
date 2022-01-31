package com.tencent.mobileqq.troop.utils;

import NearbyGroup.GroupInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopUtils
{
  public static final int a = 4194304;
  public static final String a = "vistor_type";
  public static final String b = "TroopUtils";
  public static final String c = "bid = ?";
  protected static String d = "http://app.qun.qq.com/mobileapp/index.html?_bid=136";
  
  public static int a(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static BitmapFactory.Options a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int m = localOptions.outHeight;
    int k = localOptions.outWidth;
    int n = m * k * 4;
    int j;
    if (m > k)
    {
      i = k;
      j = i;
      if (n > 4194304)
      {
        double d1 = Math.sqrt(n / 4194304.0D);
        j = (int)(i / d1);
      }
      i = m;
      n = 1;
      m = k;
      k = n;
      label97:
      if ((i > j) && (m > j))
      {
        if (Math.min(Math.round(i / j), Math.round(m / j)) < 2) {
          break label236;
        }
        m /= 2;
        i /= 2;
        if ((m >= j) && (i >= j)) {
          break label202;
        }
        localOptions.inSampleSize = k;
      }
      label166:
      localOptions.inJustDecodeBounds = false;
      if (localOptions.inSampleSize < 1) {
        break label246;
      }
    }
    label202:
    label236:
    label246:
    for (int i = localOptions.inSampleSize;; i = 1)
    {
      localOptions.inSampleSize = i;
      return localOptions;
      i = m;
      break;
      if ((m == j) || (i == j))
      {
        localOptions.inSampleSize = (k * 2);
        break label166;
      }
      k *= 2;
      break label97;
      localOptions.inSampleSize = k;
      break label166;
    }
  }
  
  public static Bundle a(int paramInt1, GroupInfo paramGroupInfo, int paramInt2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramGroupInfo.lCode));
    localBundle.putString("troop_code", String.valueOf(paramGroupInfo.lUin));
    localBundle.putString("troop_info_name", paramGroupInfo.strName);
    localBundle.putShort("troop_info_faceid", (short)paramGroupInfo.iFaceId);
    localBundle.putString("troop_info_fingermemo", paramGroupInfo.strIntro);
    localBundle.putString("troop_info_loca", paramGroupInfo.strLocation);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramGroupInfo.dwGroupFlagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramGroupInfo.dwCertType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramGroupInfo.iMemberCnt);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", (int)paramGroupInfo.dwGroupActiveGrade);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static Bundle a(int paramInt1, RecommendTroopInfo paramRecommendTroopInfo, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramRecommendTroopInfo.uin));
    localBundle.putString("troop_code", String.valueOf(paramRecommendTroopInfo.code));
    localBundle.putString("troop_info_name", paramRecommendTroopInfo.name);
    localBundle.putByte("troop_info_opt", (byte)paramRecommendTroopInfo.option);
    localBundle.putString("troop_info_owner", String.valueOf(paramRecommendTroopInfo.ownerUin));
    localBundle.putLong("troop_info_classext", paramRecommendTroopInfo.classId);
    localBundle.putShort("troop_info_faceid", (short)paramRecommendTroopInfo.faceId);
    localBundle.putString("troop_info_fingermemo", paramRecommendTroopInfo.fingerMemo);
    localBundle.putString("troop_info_loca", paramRecommendTroopInfo.location);
    localBundle.putBoolean("troop_info_is_member", paramRecommendTroopInfo.isTroopIn);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramRecommendTroopInfo.flagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramRecommendTroopInfo.authType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramRecommendTroopInfo.curMemberNum);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", paramRecommendTroopInfo.hotDegree);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static Bundle a(int paramInt1, TroopInfo paramTroopInfo, int paramInt2, boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", paramTroopInfo.troopuin);
    localBundle.putString("troop_code", paramTroopInfo.troopcode);
    localBundle.putString("troop_info_name", paramTroopInfo.troopname);
    localBundle.putByte("troop_info_opt", (byte)paramTroopInfo.cGroupOption);
    localBundle.putString("troop_info_owner", paramTroopInfo.troopowneruin);
    localBundle.putString("troop_info_admi", paramTroopInfo.Administrator);
    localBundle.putLong("troop_info_classext", paramTroopInfo.dwGroupClassExt);
    localBundle.putShort("troop_info_faceid", paramTroopInfo.troopface);
    localBundle.putString("troop_info_fingermemo", paramTroopInfo.fingertroopmemo);
    localBundle.putString("troop_info_loca", paramTroopInfo.strLocation);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramTroopInfo.dwGroupFlagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramTroopInfo.dwAuthGroupType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramTroopInfo.wMemberNum);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", paramTroopInfo.nTroopGrade);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static Bundle a(int paramInt1, SearchGroup.GroupInfo paramGroupInfo, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramGroupInfo.dwGroupCode.get()));
    localBundle.putString("troop_code", String.valueOf(paramGroupInfo.dwGroupUin.get()));
    localBundle.putString("troop_info_name", paramGroupInfo.sGroupName.get());
    localBundle.putByte("troop_info_opt", (byte)SearchTroopListActivity.a(paramGroupInfo));
    localBundle.putString("troop_info_owner", String.valueOf(paramGroupInfo.dwGroupOwnerId.get()));
    localBundle.putLong("troop_info_classext", paramGroupInfo.dwGroupClass.get());
    localBundle.putShort("troop_info_faceid", (short)paramGroupInfo.dwGroupFaceId.get());
    localBundle.putString("troop_info_fingermemo", paramGroupInfo.sGroupFingerMem.get());
    localBundle.putString("troop_info_loca", paramGroupInfo.sGroupLocation.get());
    localBundle.putBoolean("troop_info_is_member", paramGroupInfo.bGroupIn.get());
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramGroupInfo.dwGroupFlagExt.get());
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramGroupInfo.dwAuthGroupType.get());
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramGroupInfo.dwCurMemberNum.get());
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", paramGroupInfo.dwGroupHotDegree.get());
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static String a(structmsg.StructMsg paramStructMsg, String paramString)
  {
    String str = paramString;
    if (paramString.contains("%req_uin%"))
    {
      str = paramStructMsg.msg.req_uin_nick.get();
      if (TextUtils.isEmpty(str)) {
        paramString = null;
      }
    }
    do
    {
      return paramString;
      str = paramString.replace("%req_uin%", str);
      paramString = str;
      if (str.contains("%action_uin%"))
      {
        paramString = paramStructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        paramString = str.replace("%action_uin%", paramString);
      }
      str = paramString;
      if (paramString.contains("%actor_uin%"))
      {
        str = paramStructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        str = paramString.replace("%actor_uin%", str);
      }
      paramString = str;
    } while (!str.contains("%group_name%"));
    paramStructMsg = paramStructMsg.msg.group_name.get();
    if (TextUtils.isEmpty(paramStructMsg)) {
      return null;
    }
    return str.replace("%group_name%", paramStructMsg);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, ChatSettingForTroop.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("vistor_type", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopUtils", 2, paramContext.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    String str1 = paramQQAppInterface.getSid();
    String str2 = paramBundle.getString("troop_uin");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", d + "&sid=" + str1 + "#gc=" + str2 + "&t=" + System.currentTimeMillis());
    localIntent.putExtras(paramBundle);
    paramContext.startActivity(localIntent);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, str2, "", "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, ArrayList paramArrayList, AvatarWallAdapter paramAvatarWallAdapter)
  {
    if (paramAvatarWallAdapter != null) {
      paramAvatarWallAdapter.a(paramArrayList, paramString3, paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, ArrayList paramArrayList, HashMap paramHashMap, AvatarWallAdapter paramAvatarWallAdapter)
  {
    if (paramAvatarWallAdapter != null) {
      paramAvatarWallAdapter.a(paramArrayList, paramString3, paramString1, paramString2, paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils
 * JD-Core Version:    0.7.0.1
 */