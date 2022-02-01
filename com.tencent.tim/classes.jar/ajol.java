import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.FriendShipFlagNotify;

public class ajol
{
  static String SDCARD_PATH;
  static String SDCARD_ROOT;
  static String TAG = "HotReactiveHelper";
  static String bRQ = "friendshipres2/";
  static String bRR = "poke/";
  private static final HashSet<ExtensionInfo> bk = new HashSet();
  static String blY;
  private static boolean cpA;
  private static boolean cpz;
  static String filename;
  
  static
  {
    SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
    SDCARD_PATH = SDCARD_ROOT + "/Tencent/MobileQQ/";
    blY = SDCARD_PATH + "hotimage/";
    filename = "friendshipres/";
  }
  
  public static int Gw()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = aqmu.aj(l);
    int k = aqmu.ak(l);
    int j = ((23 - i) * 60 + (60 - k)) * 60;
    k = (60 - k + (17 - i) * 60) * 60;
    if (QLog.isColorLevel()) {
      QLog.d("FriendReactive", 2, "contact resume  offlast=" + j + "off18last=" + k);
    }
    if (i >= 18) {
      return j;
    }
    return k;
  }
  
  public static int Gx()
  {
    return aqmu.aj(NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static int a(int paramInt, String paramString, ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    label437:
    do
    {
      do
      {
        boolean bool;
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
                  return 0;
                } while ((paramBoolean) || (paramExtensionInfo == null) || (paramExtensionInfo.chatHotLevel == 0));
                if (QLog.isColorLevel()) {
                  QLog.d("HotFriend_" + TAG, 2, "getInteractionType|uin=" + paramString + ",level=" + paramExtensionInfo.chatHotLevel + ",days=" + paramExtensionInfo.chatDays);
                }
                return paramExtensionInfo.chatHotLevel;
              } while (paramBoolean);
              if (!arn()) {
                break;
              }
            } while ((paramExtensionInfo == null) || (paramExtensionInfo.newBestIntimacyType == 0));
            if (QLog.isColorLevel()) {
              QLog.d("HotFriend_" + TAG, 2, "getNewBestIntimacyType|uin=" + paramString + ",type=" + paramExtensionInfo.newBestIntimacyType);
            }
            return paramExtensionInfo.newBestIntimacyType;
          } while ((paramExtensionInfo == null) || (paramExtensionInfo.bestIntimacyType == 0));
          if (QLog.isColorLevel()) {
            QLog.d("HotFriend_" + TAG, 2, "getBestIntimacyType|uin=" + paramString + ",type=" + paramExtensionInfo.bestIntimacyType);
          }
          return paramExtensionInfo.bestIntimacyType;
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((localQQAppInterface != null) && (ny(localQQAppInterface.getCurrentUin()))) {}
          for (bool = true;; bool = false)
          {
            if ((paramBoolean) || (!bool)) {
              break label437;
            }
            if ((paramExtensionInfo == null) || (paramExtensionInfo.friendshipLevel == 0)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HotFriend_" + TAG, 2, "getFrdshipType|uin=" + paramString + ",level=" + paramExtensionInfo.friendshipLevel + ",days=" + paramExtensionInfo.friendshipChatDays);
            }
            return paramExtensionInfo.friendshipLevel;
          }
        } while (!QLog.isColorLevel());
        QLog.i(TAG, 2, String.format("getFrdshipType return disable_support=%b_%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
        return 0;
      } while ((paramBoolean) || (paramExtensionInfo == null) || (paramExtensionInfo.loverChatLevel == 0));
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_" + TAG, 2, "getLoverInteractionType|uin=" + paramString + ",level=" + paramExtensionInfo.loverChatLevel + ",days=" + paramExtensionInfo.loverChatDays);
      }
      return paramExtensionInfo.loverChatLevel;
    } while ((paramBoolean) || (paramExtensionInfo == null) || (paramExtensionInfo.praiseHotLevel == 0));
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_" + TAG, 2, "getmLikeType|uin=" + paramString + ",level=" + paramExtensionInfo.praiseHotLevel + ",days=" + paramExtensionInfo.praiseDays);
    }
    return paramExtensionInfo.praiseHotLevel;
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramString1;
    String str2;
    if (paramString1.contains("#likepic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 6L, 1L);
      str1 = paramString1.replace("#likepic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#praisepic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 6L, 1L);
      paramString1 = str1.replace("#praisepic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#likepic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 6L, 2L);
      str1 = paramString1.replace("#likepic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#praisepic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 6L, 2L);
      paramString1 = str1.replace("#praisepic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#chatpic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 5L, 1L);
      str1 = paramString1.replace("#chatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#chatpic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 5L, 2L);
      paramString1 = str1.replace("#chatpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#oftenchatpic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 12L, 1L);
      str1 = paramString1.replace("#oftenchatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#oftenchatpic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 12L, 2L);
      paramString1 = str1.replace("#oftenchatpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#loverchatpic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 7L, 1L);
      str1 = paramString1.replace("#loverchatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#loverchatpic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 7L, 2L);
      paramString1 = str1.replace("#loverchatpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#qzonechatpic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 8L, 1L);
      str1 = paramString1.replace("#qzonechatpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#qzonepic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 8L, 1L);
      paramString1 = str1.replace("#qzonepic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#qzonechatpic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 8L, 2L);
      str1 = paramString1.replace("#qzonechatpic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#qzonepic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 8L, 2L);
      paramString1 = str1.replace("#qzonepic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#friendshipicon1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 4L, 1L);
      str1 = paramString1.replace("#friendshipicon1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#friendshipicon2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 4L, 2L);
      paramString1 = str1.replace("#friendshipicon2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#friendshipicon3"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 4L, 3L);
      str1 = paramString1.replace("#friendshipicon3", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#loverpic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 1L, 0L);
      paramString1 = str1.replace("#loverpic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#loverpic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 1L, 1L);
      str1 = paramString1.replace("#loverpic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#loverpic3"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 1L, 2L);
      paramString1 = str1.replace("#loverpic3", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#sisterpic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 2L, 0L);
      str1 = paramString1.replace("#sisterpic1", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#sisterpic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 2L, 1L);
      paramString1 = str1.replace("#sisterpic2", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#sisterpic3"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 2L, 2L);
      str1 = paramString1.replace("#sisterpic3", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#brotherpic1"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 3L, 0L);
      paramString1 = str1.replace("#brotherpic1", str2);
      localArrayList.add(str2);
    }
    str1 = paramString1;
    if (paramString1.contains("#brotherpic2"))
    {
      str2 = ajnl.a(paramQQAppInterface, paramString2, 3L, 1L);
      str1 = paramString1.replace("#brotherpic2", str2);
      localArrayList.add(str2);
    }
    paramString1 = str1;
    if (str1.contains("#brotherpic3"))
    {
      paramQQAppInterface = ajnl.a(paramQQAppInterface, paramString2, 3L, 2L);
      paramString1 = str1.replace("#brotherpic3", paramQQAppInterface);
      localArrayList.add(paramQQAppInterface);
    }
    localArrayList.add(0, paramString1);
    return localArrayList;
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, acff paramacff)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramString1;
    if (paramString1.contains("#likelevel1")) {
      str = paramString1.replace("#likelevel1", "" + paramacff.cvp);
    }
    paramString1 = str;
    if (str.contains("#likelevel2")) {
      paramString1 = str.replace("#likelevel2", "" + paramacff.cvq);
    }
    str = paramString1;
    if (paramString1.contains("#chatlevel1")) {
      str = paramString1.replace("#chatlevel1", "" + paramacff.cvl);
    }
    paramString1 = str;
    if (str.contains("#chatlevel2")) {
      paramString1 = str.replace("#chatlevel2", "" + paramacff.cvm);
    }
    str = paramString1;
    if (paramString1.contains("#oftenchat1")) {
      str = paramString1.replace("#oftenchat1", "" + paramacff.cvr);
    }
    paramString1 = str;
    if (str.contains("#oftenchat2")) {
      paramString1 = str.replace("#oftenchat2", "" + paramacff.cvs);
    }
    str = paramString1;
    if (paramString1.contains("#loveroftenchat1")) {
      str = paramString1.replace("#loveroftenchat1", "" + paramacff.cvn);
    }
    paramString1 = str;
    if (str.contains("#loveroftenchat2")) {
      paramString1 = str.replace("#loveroftenchat2", "" + paramacff.cvo);
    }
    str = paramString1;
    if (paramString1.contains("#qzonelevel1")) {
      str = paramString1.replace("#qzonelevel1", "" + paramacff.cvt);
    }
    paramString1 = str;
    if (str.contains("#qzonelevel2")) {
      paramString1 = str.replace("#qzonelevel2", "" + paramacff.cvu);
    }
    str = paramString1;
    if (paramString1.contains("#friendshipday1")) {
      str = paramString1.replace("#friendshipday1", "" + paramacff.cvw);
    }
    paramString1 = str;
    if (str.contains("#friendshipday2")) {
      paramString1 = str.replace("#friendshipday2", "" + paramacff.cvx);
    }
    paramacff = paramString1;
    if (paramString1.contains("#likename1"))
    {
      str = ajnl.b(paramQQAppInterface, 6L, 1L);
      paramacff = paramString1.replace("#likename1", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#praisename1"))
    {
      str = ajnl.b(paramQQAppInterface, 6L, 1L);
      paramString1 = paramacff.replace("#praisename1", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#likename2"))
    {
      str = ajnl.b(paramQQAppInterface, 6L, 2L);
      paramacff = paramString1.replace("#likename2", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#praisename2"))
    {
      str = ajnl.b(paramQQAppInterface, 6L, 2L);
      paramString1 = paramacff.replace("#praisename2", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#chatname1"))
    {
      str = ajnl.b(paramQQAppInterface, 5L, 1L);
      paramacff = paramString1.replace("#chatname1", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#chatname2"))
    {
      str = ajnl.b(paramQQAppInterface, 5L, 2L);
      paramString1 = paramacff.replace("#chatname2", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#oftenchatname1"))
    {
      str = ajnl.b(paramQQAppInterface, 12L, 1L);
      paramacff = paramString1.replace("#oftenchatname1", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#oftenchatname2"))
    {
      str = ajnl.b(paramQQAppInterface, 12L, 2L);
      paramString1 = paramacff.replace("#oftenchatname2", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#loverchatname1"))
    {
      str = ajnl.b(paramQQAppInterface, 7L, 1L);
      paramacff = paramString1.replace("#loverchatname1", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#loverchatname2"))
    {
      str = ajnl.b(paramQQAppInterface, 7L, 2L);
      paramString1 = paramacff.replace("#loverchatname2", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#qzonename1"))
    {
      str = ajnl.b(paramQQAppInterface, 8L, 1L);
      paramacff = paramString1.replace("#qzonename1", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#qzonename2"))
    {
      str = ajnl.b(paramQQAppInterface, 8L, 2L);
      paramString1 = paramacff.replace("#qzonename2", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#friendshipname1"))
    {
      str = ajnl.b(paramQQAppInterface, 4L, 1L);
      paramacff = paramString1.replace("#friendshipname1", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#friendshipname2"))
    {
      str = ajnl.b(paramQQAppInterface, 4L, 2L);
      paramString1 = paramacff.replace("#friendshipname2", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#friendshipname3"))
    {
      str = ajnl.b(paramQQAppInterface, 4L, 3L);
      paramacff = paramString1.replace("#friendshipname3", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#lovername1"))
    {
      str = ajnl.b(paramQQAppInterface, 1L, 0L);
      paramString1 = paramacff.replace("#lovername1", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#lovername2"))
    {
      str = ajnl.b(paramQQAppInterface, 1L, 1L);
      paramacff = paramString1.replace("#lovername2", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#lovername3"))
    {
      str = ajnl.b(paramQQAppInterface, 1L, 2L);
      paramString1 = paramacff.replace("#lovername3", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#sistername1"))
    {
      str = ajnl.b(paramQQAppInterface, 2L, 0L);
      paramacff = paramString1.replace("#sistername1", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#sistername2"))
    {
      str = ajnl.b(paramQQAppInterface, 2L, 1L);
      paramString1 = paramacff.replace("#sistername2", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#sistername3"))
    {
      str = ajnl.b(paramQQAppInterface, 2L, 2L);
      paramacff = paramString1.replace("#sistername3", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#brothername1"))
    {
      str = ajnl.b(paramQQAppInterface, 3L, 0L);
      paramString1 = paramacff.replace("#brothername1", str);
      localArrayList.add(str);
    }
    paramacff = paramString1;
    if (paramString1.contains("#brothername2"))
    {
      str = ajnl.b(paramQQAppInterface, 3L, 1L);
      paramacff = paramString1.replace("#brothername2", str);
      localArrayList.add(str);
    }
    paramString1 = paramacff;
    if (paramacff.contains("#brothername3"))
    {
      paramQQAppInterface = ajnl.b(paramQQAppInterface, 3L, 2L);
      paramString1 = paramacff.replace("#brothername3", paramQQAppInterface);
      localArrayList.add(paramQQAppInterface);
    }
    localArrayList.add(0, paramString1.replace(acfp.m(2131707269), paramString2));
    return localArrayList;
  }
  
  public static void a(Context paramContext, acff paramacff, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "updateIntimateRelationshipConfig begin  keys.length" + paramArrayOfString1.length + " values.length" + paramArrayOfString2.length);
    }
    paramacff.cvy = paramInt1;
    paramacff.cvz = paramInt2;
    paramacff.cvA = paramInt3;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (paramInt1 > 0) {
      paramContext.putInt("hot_intimate_min_days", paramInt1);
    }
    if (paramInt2 > 0) {
      paramContext.putInt("hot_intimate_max_days", paramInt2);
    }
    if (paramInt3 > 0) {
      paramContext.putInt("hot_intimate_day_msg_count", paramInt3);
    }
    if (paramArrayOfString1.length != paramArrayOfString2.length) {
      throw new RuntimeException("updateIntimateRelationshipConfig keys.length != values.length");
    }
    paramInt2 = paramArrayOfString1.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (!TextUtils.isEmpty(paramArrayOfString2[paramInt1])) {
        paramContext.putString(paramArrayOfString1[paramInt1], paramArrayOfString2[paramInt1]);
      }
      paramInt1 += 1;
    }
    paramContext.commit();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "updateIntimateRelationshipConfig end");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_up", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_up2", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_up3", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_down", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_down2", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      paramContext.putString("hot_friend_new_boat_graytip_close_down3", paramString6);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_upgrade", paramString7);
    }
    if (!TextUtils.isEmpty(paramString8)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_upgrade2", paramString8);
    }
    if (!TextUtils.isEmpty(paramString9)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_upgrade3", paramString9);
    }
    if (!TextUtils.isEmpty(paramString10)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_downgrade", paramString10);
    }
    if (!TextUtils.isEmpty(paramString11)) {
      paramContext.putString("hot_friend_new_boat_graytip_upcoming_downgrade2", paramString11);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_graytip_priase_down_remind", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString("hot_friend_graytip_praise_dis_remind", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramContext.putString("hot_friend_graytip_chat_down_remind", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.putString("hot_friend_graytip_chat_dis_remind", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      paramContext.putString("hot_friend_graytip_qozne_down_remind", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      paramContext.putString("hot_friend_graytip_qzone_dis_remind", paramString6);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      paramContext.putString("hot_friend_graytip_praiseandchat_dis_remind", paramString7);
    }
    if (!TextUtils.isEmpty(paramString8)) {
      paramContext.putString("hot_friend_graytip_chatandqzone_dis_remind", paramString8);
    }
    if (!TextUtils.isEmpty(paramString9)) {
      paramContext.putString("hot_friend_graytip_praiseandqone_dis_remind", paramString9);
    }
    if (!TextUtils.isEmpty(paramString10)) {
      paramContext.putString("hot_friend_graytip_pcqall_dis_remind", paramString10);
    }
    if (!TextUtils.isEmpty(paramString11)) {
      paramContext.putString("hot_friendship_graytips_1_will_downgrade", paramString11);
    }
    if (!TextUtils.isEmpty(paramString12)) {
      paramContext.putString("hot_friendship_graytips_2_will_downgrade", paramString12);
    }
    if (!TextUtils.isEmpty(paramString13)) {
      paramContext.putString("hot_friendship_graytips_3_will_downgrade", paramString13);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_chat_svip_key", paramString1);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_chat_unionvip_key", paramString2);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_chat_svip_setting", paramString3);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_chat_unionvip_setting", paramString4);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_close_svip_key", paramString5);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_close_unionvip_key", paramString6);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_close_svip_key", paramString7);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_close_unionvip_key", paramString8);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_chat_svip_setting", paramString9);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_chat_unionvip_setting", paramString10);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_chat_svip_setting", paramString11);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_chat_unionvip_setting", paramString12);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_close_svip_setting", paramString13);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_small_close_svip_setting", paramString14);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_close_svip_setting", paramString15);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_big_close_unionvip_setting", paramString16);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_1_vip_type", paramString17);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_2_vip_type", paramString18);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_3_vip_type", paramString19);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_1_vip_setting", paramString20);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_2_vip_setting", paramString21);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_intimate_lover_3_vip_setting", paramString22);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.putString("hot_friend_graytip_chat_up", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString("hot_friend_graytip_priase_up", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramContext.putString("hot_friend_graytip_close_up", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.putString("hot_friend_graytip_lover_up", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      paramContext.putString("hot_friend_graytip_qzone_up", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      paramContext.putString("hot_friend_graytip_chat_up2", paramString6);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      paramContext.putString("hot_friend_graytip_priase_up2", paramString7);
    }
    if (!TextUtils.isEmpty(paramString8)) {
      paramContext.putString("hot_friend_graytip_close_up2", paramString8);
    }
    if (!TextUtils.isEmpty(paramString9)) {
      paramContext.putString("hot_friend_graytip_lover_up2", paramString9);
    }
    if (!TextUtils.isEmpty(paramString21)) {
      paramContext.putString("hot_friend_graytip_lover_close", paramString21);
    }
    if (!TextUtils.isEmpty(paramString22)) {
      paramContext.putString("hot_friend_graytip_lover_close2", paramString22);
    }
    if (!TextUtils.isEmpty(paramString23)) {
      paramContext.putString("hot_friend_graytip_lover_open", paramString23);
    }
    if (!TextUtils.isEmpty(paramString24)) {
      paramContext.putString("hot_friend_graytip_lover_open2", paramString24);
    }
    if (!TextUtils.isEmpty(paramString25)) {
      paramContext.putString("hot_friend_graytip_lover_update", paramString25);
    }
    if (!TextUtils.isEmpty(paramString26)) {
      paramContext.putString("hot_friend_graytip_lover_update2", paramString26);
    }
    if (!TextUtils.isEmpty(paramString10)) {
      paramContext.putString("hot_friend_graytip_qzone_up2", paramString10);
    }
    if (!TextUtils.isEmpty(paramString11)) {
      paramContext.putString("hot_friend_graytip_chat_down", paramString11);
    }
    if (!TextUtils.isEmpty(paramString12)) {
      paramContext.putString("hot_friend_graytip_priase_down", paramString12);
    }
    if (!TextUtils.isEmpty(paramString13)) {
      paramContext.putString("hot_friend_graytip_close_down", paramString13);
    }
    if (!TextUtils.isEmpty(paramString14)) {
      paramContext.putString("hot_friend_graytip_lover_down", paramString14);
    }
    if (!TextUtils.isEmpty(paramString15)) {
      paramContext.putString("hot_friend_graytip_qzone_down", paramString15);
    }
    if (!TextUtils.isEmpty(paramString16)) {
      paramContext.putString("hot_friend_graytip_chat_dis", paramString16);
    }
    if (!TextUtils.isEmpty(paramString17)) {
      paramContext.putString("hot_friend_graytip_priase_dis", paramString17);
    }
    if (!TextUtils.isEmpty(paramString18)) {
      paramContext.putString("hot_friend_graytip_close_dis", paramString18);
    }
    if (!TextUtils.isEmpty(paramString19)) {
      paramContext.putString("hot_friend_graytip_lover_dis", paramString19);
    }
    if (!TextUtils.isEmpty(paramString20)) {
      paramContext.putString("hot_friend_graytip_qzone_dis", paramString20);
    }
    if (!TextUtils.isEmpty(paramString27)) {
      paramContext.putString("hot_friendship_1_upgrade", paramString27);
    }
    if (!TextUtils.isEmpty(paramString28)) {
      paramContext.putString("hot_friendship_graytips_1_downgrade", paramString28);
    }
    if (!TextUtils.isEmpty(paramString29)) {
      paramContext.putString("hot_friendship_graytips_2_upgrade", paramString29);
    }
    if (!TextUtils.isEmpty(paramString30)) {
      paramContext.putString("hot_friendship_graytips_2_downgrade", paramString30);
    }
    if (!TextUtils.isEmpty(paramString31)) {
      paramContext.putString("hot_friendship_graytips_3_upgrade", paramString31);
    }
    if (!TextUtils.isEmpty(paramString32)) {
      paramContext.putString("hot_friendship_graytips_3_downgrade", paramString32);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    cpz = paramBoolean;
    cpA = true;
    paramContext.putBoolean("hot_friend_new_boat_big_use_new", cpz);
    paramContext.putString("hot_friend_new_boat_small_close_setting", paramString1);
    paramContext.putString("hot_friend_new_boat_big_close_setting", paramString2);
    paramContext.putString("hot_friend_new_boat_small_close_key", paramString3);
    paramContext.putString("hot_friend_new_boat_big_close_key", paramString4);
    paramContext.commit();
  }
  
  public static void a(SharedPreferences paramSharedPreferences, acff paramacff)
  {
    int i = paramSharedPreferences.getInt("hot_intimate_min_days", paramacff.cvy);
    if (i > 0) {
      paramacff.cvy = i;
    }
    i = paramSharedPreferences.getInt("hot_intimate_max_days", paramacff.cvz);
    if (i > 0) {
      paramacff.cvz = i;
    }
    i = paramSharedPreferences.getInt("hot_intimate_day_msg_count", paramacff.cvA);
    if (i > 0) {
      paramacff.cvA = i;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, acrj paramacrj, submsgtype0xc7.FriendShipFlagNotify paramFriendShipFlagNotify)
  {
    QLog.i(TAG, 1, "handle friendShipFlagNotify");
    if ((acff)paramQQAppInterface.getManager(51) == null) {
      QLog.i(TAG, 1, "friendShipFlagNotify return due to fm null");
    }
    while ((paramFriendShipFlagNotify.uint64_dst_uin.has()) && (paramFriendShipFlagNotify.uint32_level_1.has()) && (paramFriendShipFlagNotify.uint32_level_2.has()) && (paramFriendShipFlagNotify.uint32_continuity_days.has()) && (paramFriendShipFlagNotify.uint32_chat_flag.has()) && (paramFriendShipFlagNotify.uint64_last_chat_time.has()) && (paramFriendShipFlagNotify.uint64_notify_time.has())) {
      return;
    }
    QLog.i(TAG, 1, "friendShipFlagNotify has empty field, ignored");
  }
  
  public static void aq(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "parsNewBoatConfig:" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("useBoat", 1);
        String str1 = paramString.optString("boatSSetting", "");
        String str2 = paramString.optString("boatBSetting", "");
        String str3 = paramString.optString("boatSName", "");
        String str4 = paramString.optString("boatBName", "");
        Object localObject = paramQQAppInterface.getApp();
        if (i == 1)
        {
          a((Context)localObject, bool, str1, str2, str3, str4);
          str1 = paramString.optString("grayBoatUp", "");
          str2 = paramString.optString("grayBoat2Up", "");
          str3 = paramString.optString("grayBoat3Up", "");
          str4 = paramString.optString("grayBoatDeg", "");
          localObject = paramString.optString("grayBoat2Deg", "");
          String str5 = paramString.optString("grayBoat3Deg", "");
          String str6 = paramString.optString("grayComingUp", "");
          String str7 = paramString.optString("grayComing2Up", "");
          String str8 = paramString.optString("grayComing3Up", "");
          String str9 = paramString.optString("grayComingDeg", "");
          paramString = paramString.optString("grayComing2Deg", "");
          a(paramQQAppInterface.getApp(), str1, str2, str3, str4, (String)localObject, str5, str6, str7, str8, str9, paramString);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(TAG, 2, "parsNewBoatConfig:error->" + paramQQAppInterface.toString());
      }
      bool = false;
    }
  }
  
  public static boolean arm()
  {
    boolean bool2 = false;
    int i = aqmu.aj(NetConnInfoCenter.getServerTimeMillis());
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (i < 18) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean arn()
  {
    if (cpA) {
      return cpz;
    }
    cpz = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("hot_friend_new_boat_big_use_new", false);
    cpA = true;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isNewVersionBoat local:" + cpz);
    }
    return cpz;
  }
  
  public static void b(ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo != null) {
      bk.add(paramExtensionInfo);
    }
  }
  
  public static boolean b(int paramInt, long paramLong, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public static void bH(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putString("show_hot_friend_reactive_will_downgrade_push_tip", paramString);
      paramContext.commit();
    }
  }
  
  public static void bI(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString)) {
      paramContext.putString("hot_friend_chat_num_des", paramString);
    }
    paramContext.commit();
  }
  
  public static List<ajol.a> d(Context paramContext, String paramString)
  {
    paramContext = new ArrayList();
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= 0)
      {
        i = paramString.indexOf("(", j);
        if (i >= 0) {
          break label53;
        }
      }
      label53:
      int k;
      do
      {
        do
        {
          locala = new ajol.a();
          locala.name = paramString;
          paramContext.add(0, locala);
          return paramContext;
          j = paramString.indexOf(")[", i);
        } while (j < 0);
        k = paramString.indexOf("]", j);
      } while (k < 0);
      ajol.a locala = new ajol.a();
      locala.name = paramString.substring(i + 1, j);
      locala.djY = i;
      locala.url = paramString.substring(j + 2, k);
      paramString = paramString.replace(paramString.substring(i, k + 1), locala.name);
      j = locala.name.length() + k;
      paramContext.add(locala);
    }
  }
  
  public static String f(Context paramContext, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str2 = "";
    String str1 = str2;
    switch (paramInt)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, "type=" + paramInt + "getHotSmallChatConfig=" + str1);
      }
      return str1;
      str1 = localSharedPreferences.getString("hot_friend_chat_num_des", paramContext.getString(2131692039));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_up", paramContext.getString(2131694467));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_up", paramContext.getString(2131694481));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_close_up", paramContext.getString(2131694450));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_up2", paramContext.getString(2131694468));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_up2", paramContext.getString(2131694482));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_close_up2", paramContext.getString(2131694451));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_down", paramContext.getString(2131694463));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_down", paramContext.getString(2131694477));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_close_down", paramContext.getString(2131694448));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_dis", paramContext.getString(2131694465));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_dis", paramContext.getString(2131694479));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_close_dis", paramContext.getString(2131694449));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_priase_down_remind", paramContext.getString(2131694478));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_praise_dis_remind", paramContext.getString(2131694480));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_down_remind", paramContext.getString(2131694464));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chat_dis_remind", paramContext.getString(2131694466));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_qozne_down_remind", paramContext.getString(2131694483));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_qzone_dis_remind", paramContext.getString(2131694484));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_praiseandchat_dis_remind", paramContext.getString(2131694461));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_praiseandqone_dis_remind", paramContext.getString(2131694476));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_chatandqzone_dis_remind", paramContext.getString(2131694462));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_pcqall_dis_remind", paramContext.getString(2131694475));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_up", paramContext.getString(2131694493));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_down", paramContext.getString(2131694487));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_dis", paramContext.getString(2131694488));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_up2", paramContext.getString(2131694494));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_close", paramContext.getString(2131694485));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_close2", paramContext.getString(2131694486));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_open", paramContext.getString(2131694489));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_open2", paramContext.getString(2131694490));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_update", paramContext.getString(2131694491));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_graytip_lover_update2", paramContext.getString(2131694492));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_up", paramContext.getString(2131694472));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_up2", paramContext.getString(2131694473));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_up3", paramContext.getString(2131694474));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_down", paramContext.getString(2131694469));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_down2", paramContext.getString(2131694470));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_close_down3", paramContext.getString(2131694471));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_small_close_setting", paramContext.getString(2131719892));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_big_close_setting", paramContext.getString(2131719891));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_upgrade", paramContext.getString(2131694445));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_upgrade2", paramContext.getString(2131694446));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_upgrade3", paramContext.getString(2131694447));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_downgrade", paramContext.getString(2131694443));
      continue;
      str1 = localSharedPreferences.getString("hot_friend_new_boat_graytip_upcoming_downgrade2", paramContext.getString(2131694444));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_1_upgrade", paramContext.getString(2131694453));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_1_will_downgrade", paramContext.getString(2131694454));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_1_downgrade", paramContext.getString(2131694452));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_2_upgrade", paramContext.getString(2131694456));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_2_will_downgrade", paramContext.getString(2131694457));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_2_downgrade", paramContext.getString(2131694455));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_3_upgrade", paramContext.getString(2131694459));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_3_will_downgrade", paramContext.getString(2131694460));
      continue;
      str1 = localSharedPreferences.getString("hot_friendship_graytips_3_downgrade", paramContext.getString(2131694458));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Lover1Upgrade", paramContext.getString(2131694693));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Lover2Upgrade", paramContext.getString(2131694695));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Lover2Downgrade", paramContext.getString(2131694694));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Lover3Downgrade", paramContext.getString(2131694696));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Buddy1Upgrade", paramContext.getString(2131694685));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Buddy2Upgrade", paramContext.getString(2131694687));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Buddy2Downgrade", paramContext.getString(2131694686));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_Buddy3Downgrade", paramContext.getString(2131694688));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_LadyBro1Upgrade", paramContext.getString(2131694689));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_LadyBro2Upgrade", paramContext.getString(2131694691));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_LadyBro2Downgrade", paramContext.getString(2131694690));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_LadyBro3Downgrade", paramContext.getString(2131694692));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BindTip", paramContext.getString(2131694684));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_UnBind1Tip", paramContext.getString(2131694697));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_UnBind2Tip", paramContext.getString(2131694698));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_UnBind3Tip", paramContext.getString(2131694699));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BecomeGrayTip", paramContext.getString(2131694682));
      continue;
      str1 = localSharedPreferences.getString("hot_intimate_BecomeLightTip", paramContext.getString(2131694683));
      continue;
      str1 = localSharedPreferences.getString("show_hot_friend_reactive_will_downgrade_push_tip", paramContext.getString(2131694681));
    }
  }
  
  public static HashSet<ExtensionInfo> h()
  {
    return bk;
  }
  
  public static boolean ny(String paramString)
  {
    boolean bool = aqmj.aq(BaseApplicationImpl.getContext(), paramString);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isSupportFriendShip sp: " + bool);
    }
    return bool;
  }
  
  public static boolean q(int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {}
    while ((paramInt < 18) || (paramInt >= 24) || (aqmu.J(paramLong) == 2131721204)) {
      return false;
    }
    return true;
  }
  
  public static void s(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "parsXMLConfig: {\n" + paramString + "\n}");
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    for (;;)
    {
      try
      {
        new HashMap();
        localHashMap2 = new HashMap();
        localHashMap1 = new HashMap();
        localObject30 = "";
        localObject31 = "";
        i10 = 7;
        i11 = 30;
        i12 = 6;
        localObject32 = "";
        localObject33 = "";
        localObject34 = "";
        localObject35 = "";
        localObject36 = "";
        localObject37 = "";
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i24 = localXmlPullParser.getEventType();
        bool2 = false;
        i8 = 7;
        localObject18 = "";
        i9 = 3;
        localObject19 = "";
        localObject20 = "";
        localObject21 = "";
        localObject22 = "";
        localObject23 = "";
        localObject24 = "";
        localObject25 = "";
        localObject26 = "";
        localObject27 = "";
        localObject28 = "";
        localObject29 = "";
        localObject17 = "";
        i5 = 30;
        localObject13 = "";
        localObject14 = "";
        bool1 = false;
        i6 = 30;
        localObject12 = "";
        i = 30;
        localObject6 = "";
        m = 3;
        localObject5 = "";
        i2 = 3;
        i3 = 0;
        localObject10 = "";
        i4 = 3;
        localObject11 = "";
        localObject9 = "";
        localObject7 = "";
        i1 = 30;
        localObject8 = "";
        n = 5;
        localObject3 = "";
        k = 30;
        localObject4 = "";
        j = 7;
        localObject15 = "";
        i7 = 30;
        localObject16 = "";
        localObject1 = "";
        localObject2 = "";
      }
      catch (Exception paramQQAppInterface)
      {
        HashMap localHashMap2;
        HashMap localHashMap1;
        Object localObject30;
        Object localObject31;
        int i10;
        int i11;
        int i12;
        Object localObject32;
        Object localObject33;
        Object localObject34;
        Object localObject35;
        Object localObject36;
        Object localObject37;
        boolean bool2;
        boolean bool1;
        Object localObject51;
        Object localObject44;
        Object localObject45;
        Object localObject46;
        Object localObject47;
        Object localObject48;
        Object localObject49;
        Object localObject50;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, paramString, paramQQAppInterface);
        return;
      }
      int i24 = localXmlPullParser.next();
      int i13 = k;
      int i14 = i5;
      Object localObject38 = localObject14;
      localObject51 = localObject17;
      Object localObject14 = localObject18;
      Object localObject17 = localObject19;
      Object localObject41 = localObject20;
      Object localObject42 = localObject21;
      Object localObject43 = localObject22;
      localObject44 = localObject23;
      localObject45 = localObject24;
      localObject46 = localObject25;
      localObject47 = localObject26;
      localObject48 = localObject1;
      int i5 = i6;
      Object localObject39 = localObject27;
      localObject49 = localObject2;
      int i6 = j;
      Object localObject18 = localObject6;
      Object localObject6 = localObject9;
      int j = i3;
      Object localObject19 = localObject12;
      int i3 = i;
      Object localObject40 = localObject28;
      localObject50 = localObject8;
      int i = i4;
      Object localObject8 = localObject13;
      int i15 = m;
      Object localObject12 = localObject4;
      int k = i8;
      Object localObject4 = localObject29;
      int i8 = i1;
      Object localObject13 = localObject10;
      int i16 = i2;
      Object localObject1 = localObject16;
      Object localObject2 = localObject15;
      int i2 = i9;
      int i4 = i7;
      int i9 = i14;
      int i1 = i;
      int m = j;
      int i7 = i16;
      j = i8;
      i = n;
      int n = i15;
      Object localObject20 = localObject51;
      Object localObject21 = localObject14;
      Object localObject22 = localObject17;
      Object localObject23 = localObject41;
      Object localObject24 = localObject42;
      Object localObject25 = localObject43;
      Object localObject26 = localObject44;
      Object localObject27 = localObject45;
      Object localObject28 = localObject46;
      Object localObject29 = localObject47;
      localObject17 = localObject48;
      localObject14 = localObject49;
      Object localObject9 = localObject3;
      Object localObject3 = localObject12;
      Object localObject10 = localObject5;
      localObject12 = localObject18;
      localObject18 = localObject7;
      Object localObject7 = localObject50;
      Object localObject15 = localObject13;
      Object localObject16 = localObject11;
      Object localObject5 = localObject19;
      localObject19 = localObject38;
      localObject13 = localObject39;
      Object localObject11 = localObject40;
      i8 = i13;
      break label28866;
      localObject38 = localXmlPullParser.getName();
      if (((String)localObject38).equalsIgnoreCase("ShowInContact"))
      {
        if (Integer.valueOf(localXmlPullParser.nextText()).intValue() == 1) {
          bool2 = true;
        }
      }
      else
      {
        if (((String)localObject38).equalsIgnoreCase("ShowInChat"))
        {
          if (Integer.valueOf(localXmlPullParser.nextText()).intValue() != 1) {
            break label29675;
          }
          bool1 = true;
          break label29675;
        }
        int i17;
        int i18;
        int i19;
        int i23;
        int i21;
        int i20;
        int i22;
        if (((String)localObject38).equalsIgnoreCase("minInteractiveDays"))
        {
          i2 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i2 <= 0)
          {
            i13 = i8;
            localObject41 = localObject17;
            i2 = j;
            i8 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i15 = 3;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i14 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i13;
            m = n;
            n = i1;
            i1 = i2;
            i2 = i8;
            i5 = i9;
            i8 = i14;
            i9 = i15;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxInteractiveDays"))
        {
          k = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (k <= 0)
          {
            k = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = 30;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("minLoverInteractiveDays"))
        {
          i8 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i8 <= 0)
          {
            i16 = 3;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i16;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxLoverInteractiveDays"))
        {
          i6 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i6 <= 0)
          {
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            i17 = 30;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            j = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = j;
            j = i17;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("minLinkDays"))
        {
          i4 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i4 <= 0)
          {
            localObject41 = localObject17;
            i4 = j;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i16 = 3;
            i15 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i5 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i14 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i15;
            k = i8;
            m = n;
            n = i1;
            i1 = i4;
            i2 = i7;
            i4 = i5;
            i5 = i9;
            i7 = i16;
            i8 = i14;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxLinkDays"))
        {
          i5 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i5 <= 0)
          {
            i5 = i9;
            i14 = i8;
            localObject41 = localObject17;
            i8 = j;
            i13 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i16 = 30;
            localObject39 = localObject11;
            i7 = i4;
            i6 = i3;
            i9 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i6;
            k = i14;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i13;
            i6 = i16;
            i8 = i15;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("minIntimacyDays"))
        {
          i9 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i9 <= 0)
          {
            i16 = 3;
            i14 = i8;
            localObject41 = localObject17;
            i8 = j;
            i13 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i9 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i14;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i13;
            i5 = i16;
            i8 = i15;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxIntimacyDays"))
        {
          i1 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i1 <= 0)
          {
            i14 = i8;
            localObject41 = localObject17;
            i1 = j;
            i8 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i4 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i5 = 30;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i2 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i4;
            k = i14;
            m = n;
            n = i2;
            i2 = i8;
            i4 = i5;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("minQzoneVisitDays"))
        {
          m = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (m <= 0)
          {
            m = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i5 = 3;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i3;
            k = m;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i3 = i5;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxQzoneVisitDays"))
        {
          i7 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (i7 <= 0)
          {
            i14 = i8;
            localObject41 = localObject17;
            i8 = j;
            i16 = 30;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i14;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i16;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else if (((String)localObject38).equalsIgnoreCase("maxRemindTimes"))
        {
          n = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
          if (n <= 0)
          {
            n = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            i2 = 5;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = n;
            m = i2;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i15;
            i9 = i13;
          }
        }
        else
        {
          if (((String)localObject38).equalsIgnoreCase("fireNumDescription"))
          {
            localObject41 = localXmlPullParser.nextText();
            i15 = i8;
            localObject2 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject17 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseUpgrade"))
          {
            localHashMap2.put("grayPraiseUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatUpgrade"))
          {
            localHashMap2.put("grayChatUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayColseUpgrade"))
          {
            localHashMap2.put("grayCloseUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverUpgrade"))
          {
            localHashMap2.put("grayQzoneLoverUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneVisitUpgrade"))
          {
            localHashMap2.put("grayQzoneVisitUp", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraise2Upgrade"))
          {
            localHashMap2.put("grayPraiseUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChat2Upgrade"))
          {
            localHashMap2.put("grayChatUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayColse2Upgrade"))
          {
            localHashMap2.put("grayCloseUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLover2Upgrade"))
          {
            localHashMap2.put("grayQzoneLoverUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneVisit2Upgrade"))
          {
            localHashMap2.put("grayQzoneVisitUp2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseDegrade"))
          {
            localHashMap2.put("grayPriaseDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatDegrade"))
          {
            localHashMap2.put("grayChatDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayColseDegrade"))
          {
            localHashMap2.put("grayCloseDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverDegrade"))
          {
            localHashMap2.put("grayQzoneLoverDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverOpen"))
          {
            localHashMap2.put("grayQzoneLoverOpen", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverOpen2"))
          {
            localHashMap2.put("grayQzoneLoverOpen2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverUpdate"))
          {
            localHashMap2.put("grayQzoneLoverUpdate", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverUpdate2"))
          {
            localHashMap2.put("grayQzoneLoverUpdate2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverClose"))
          {
            localHashMap2.put("grayQzoneLoverClose", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverClose2"))
          {
            localHashMap2.put("grayQzoneLoverClose2", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneVisitDegrade"))
          {
            localHashMap2.put("grayQzoneVisitDown", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseDis"))
          {
            localHashMap2.put("grayPriaseDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatDis"))
          {
            localHashMap2.put("grayChatDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayColseDis"))
          {
            localHashMap2.put("grayCloseDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayLoverDis"))
          {
            localHashMap2.put("grayQzoneLoverDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneVisitDis"))
          {
            localHashMap2.put("grayQzoneVisitDis", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseDegradeRemind"))
          {
            localObject38 = localXmlPullParser.nextText();
            localObject19 = localObject22;
            localObject22 = localObject38;
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject22;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseDisRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            i15 = i8;
            localObject8 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject43 = localObject9;
            localObject13 = localObject40;
            i4 = i1;
            localObject9 = localObject7;
            localObject11 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject8;
            localObject2 = localObject42;
            localObject3 = localObject43;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject8 = localObject9;
            localObject9 = localObject11;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatDegradeRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            i15 = i8;
            localObject5 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject40;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject5;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatDisRemind"))
          {
            localObject16 = localXmlPullParser.nextText();
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneDegradeRemind"))
          {
            localObject15 = localXmlPullParser.nextText();
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayQzoneDisRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            i15 = i8;
            localObject6 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject40;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject6;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatAndPraiseRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            localObject7 = localObject18;
            i15 = i8;
            localObject18 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject40;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject18;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayChatAnQzoneRemind"))
          {
            localObject38 = localXmlPullParser.nextText();
            localObject18 = localObject21;
            localObject21 = localObject38;
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject21;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPraiseAndQzoneRemind"))
          {
            localObject39 = localXmlPullParser.nextText();
            i15 = i8;
            localObject12 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject14 = localObject39;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject41 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject12;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject14;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject41;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("grayPCQallRemind"))
          {
            localObject40 = localXmlPullParser.nextText();
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            localObject10 = localObject15;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            localObject11 = localObject40;
            i5 = i3;
            i13 = i2;
            localObject43 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject15 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject42;
            localObject3 = localObject43;
            localObject5 = localObject11;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship1Upgrade"))
          {
            localHashMap2.put("graytipFriendship1Upgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship1WillDowngrade"))
          {
            localObject41 = localXmlPullParser.nextText();
            i15 = i8;
            localObject3 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject41;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject3;
            localObject2 = localObject42;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship1Downgrade"))
          {
            localHashMap2.put("graytipFriendship1Downgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship2Upgrade"))
          {
            localHashMap2.put("graytipFriendship2Upgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship2WillDowngrade"))
          {
            localObject43 = localXmlPullParser.nextText();
            i15 = i8;
            localObject9 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject42 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject11 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject41 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject9;
            localObject2 = localObject42;
            localObject3 = localObject43;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject9 = localObject11;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject41;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship2Downgrade"))
          {
            localHashMap2.put("graytipFriendship2Downgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship3Upgrade"))
          {
            localHashMap2.put("graytipFriendship3Upgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship3WillDowngrade"))
          {
            localObject43 = localXmlPullParser.nextText();
            localObject14 = localObject19;
            i15 = i8;
            localObject19 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject41 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject19;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject41;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("graytipFriendship3Downgrade"))
          {
            localHashMap2.put("graytipFriendship3Downgrade", localXmlPullParser.nextText());
            i15 = i8;
            localObject41 = localObject17;
            i8 = j;
            i14 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i5 = i3;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i3 = m;
            localObject40 = localObject4;
            i16 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i5;
            k = i15;
            m = n;
            n = i1;
            i1 = i8;
            i2 = i14;
            i5 = i9;
            i8 = i16;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("friendshipMinDays"))
          {
            i13 = Integer.parseInt(localXmlPullParser.nextText());
            if (i13 <= 0) {
              break label29912;
            }
            j = i13;
            break label29912;
          }
          if (((String)localObject38).equalsIgnoreCase("friendshipMaxDays"))
          {
            i13 = Integer.parseInt(localXmlPullParser.nextText());
            if (i13 <= 0) {
              break label30149;
            }
            i = i13;
            break label30149;
          }
          if (((String)localObject38).equalsIgnoreCase("friendship"))
          {
            i16 = Integer.parseInt(localXmlPullParser.nextText());
            i14 = i8;
            localObject41 = localObject17;
            i3 = j;
            i8 = i7;
            j = i6;
            localObject43 = localObject14;
            localObject38 = localObject13;
            i6 = i5;
            localObject39 = localObject11;
            i7 = i4;
            i13 = i2;
            localObject11 = localObject9;
            localObject13 = localObject8;
            i4 = i1;
            localObject8 = localObject7;
            localObject9 = localObject6;
            i1 = i;
            localObject14 = localObject5;
            i5 = m;
            localObject40 = localObject4;
            i15 = k;
            localObject4 = localObject3;
            localObject42 = localObject2;
            localObject17 = localObject1;
            localObject1 = localObject41;
            localObject2 = localObject43;
            localObject3 = localObject11;
            localObject5 = localObject10;
            localObject6 = localObject12;
            localObject7 = localObject18;
            localObject10 = localObject15;
            localObject11 = localObject16;
            localObject12 = localObject14;
            localObject14 = localObject19;
            localObject15 = localObject42;
            localObject16 = localObject17;
            localObject17 = localObject20;
            localObject18 = localObject21;
            localObject19 = localObject22;
            localObject20 = localObject23;
            localObject21 = localObject24;
            localObject22 = localObject25;
            localObject23 = localObject26;
            localObject24 = localObject27;
            localObject25 = localObject28;
            localObject26 = localObject29;
            localObject27 = localObject38;
            localObject28 = localObject39;
            localObject29 = localObject40;
            i = i16;
            k = i14;
            m = n;
            n = i1;
            i1 = i3;
            i2 = i8;
            i3 = i5;
            i5 = i9;
            i8 = i15;
            i9 = i13;
            continue;
          }
          if (((String)localObject38).equalsIgnoreCase("intimateMinDays"))
          {
            i13 = Integer.parseInt(localXmlPullParser.nextText());
            if (i13 > 0)
            {
              i10 = i13;
              break label30386;
            }
          }
          else
          {
            if (((String)localObject38).equalsIgnoreCase("intimateMaxDays"))
            {
              i13 = Integer.parseInt(localXmlPullParser.nextText());
              if (i13 > 0)
              {
                i11 = i13;
                break label30623;
              }
            }
            else
            {
              if (((String)localObject38).equalsIgnoreCase("intimateDayMsgCount"))
              {
                i13 = Integer.parseInt(localXmlPullParser.nextText());
                if (i13 > 0)
                {
                  i12 = i13;
                  break label30860;
                }
              }
              else
              {
                if (((String)localObject38).equalsIgnoreCase("graytipLover1Upgrade"))
                {
                  localHashMap1.put("graytipLover1Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLover2Upgrade"))
                {
                  localHashMap1.put("graytipLover2Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLover2Downgrade"))
                {
                  localHashMap1.put("graytipLover2Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLover3Downgrade"))
                {
                  localHashMap1.put("graytipLover3Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBuddy1Upgrade"))
                {
                  localHashMap1.put("graytipBuddy1Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBuddy2Upgrade"))
                {
                  localHashMap1.put("graytipBuddy2Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBuddy2Downgrade"))
                {
                  localHashMap1.put("graytipBuddy2Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipBuddy3Downgrade"))
                {
                  localHashMap1.put("graytipBuddy3Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLadyBro1Upgrade"))
                {
                  localHashMap1.put("graytipLadyBro1Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLadyBro2Upgrade"))
                {
                  localHashMap1.put("graytipLadyBro2Upgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLadyBro2Downgrade"))
                {
                  localHashMap1.put("graytipLadyBro2Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipLadyBro3Downgrade"))
                {
                  localHashMap1.put("graytipLadyBro3Downgrade", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipBindTip"))
                {
                  localHashMap1.put("graytipIntimateshipBindTip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipUnBind1Tip"))
                {
                  localHashMap1.put("graytipIntimateshipUnBind1Tip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipUnBind2Tip"))
                {
                  localHashMap1.put("graytipIntimateshipUnBind2Tip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipUnBind3Tip"))
                {
                  localHashMap1.put("graytipIntimateshipUnBind3Tip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipBecomeGrayTip"))
                {
                  localHashMap1.put("graytipIntimateshipBecomeGrayTip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipIntimateshipBecomeLightTip"))
                {
                  localHashMap1.put("graytipIntimateshipBecomeLightTip", localXmlPullParser.nextText());
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("graytipWillDowngradeWording"))
                {
                  localObject41 = localXmlPullParser.nextText();
                  localObject17 = localObject20;
                  i15 = i8;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject20 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallChatSVipKey"))
                {
                  localObject40 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject4 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  i16 = k;
                  localObject5 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject4;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject4 = localObject5;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallChatUnionVipKey"))
                {
                  localObject39 = localXmlPullParser.nextText();
                  i15 = i8;
                  i8 = j;
                  localObject11 = localObject16;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject43 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject16 = localObject1;
                  localObject1 = localObject17;
                  localObject2 = localObject42;
                  localObject3 = localObject43;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigChatSVipKey"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigChatUnionVipKey"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject40 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject29 = localObject13;
                  i6 = i5;
                  localObject38 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject39 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject40;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject43;
                  localObject27 = localObject29;
                  localObject28 = localObject38;
                  localObject29 = localObject39;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallCloseSvipKey"))
                {
                  localObject28 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallCloseUnionVipKey"))
                {
                  localObject27 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigCloseSVipKey"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject26 = localObject29;
                  localObject29 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject29;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigCloseUnionVipKey"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject25 = localObject28;
                  localObject28 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject28;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover1VipKey"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject32 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject32;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject32 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover2VipKey"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject33 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject33;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject33 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover3VipKey"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject34 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject34;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject34 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover1VipSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject35 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject35;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject35 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover2VipSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject36 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject36;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject36 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("intimateLover3VipSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject37 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject37;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject37 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallChatSVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject24 = localObject27;
                  localObject27 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject27;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallChatUnionVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject23 = localObject26;
                  localObject26 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject26;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigChatSVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject22 = localObject25;
                  localObject25 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject25;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigChatUnionVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject21 = localObject24;
                  localObject24 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject24;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallCloseSVipSetting"))
                {
                  localObject38 = localXmlPullParser.nextText();
                  localObject20 = localObject23;
                  localObject23 = localObject38;
                  i15 = i8;
                  localObject41 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject43 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject42 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject41;
                  localObject2 = localObject43;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject42;
                  localObject16 = localObject17;
                  localObject17 = localObject23;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("smallCloseUnionSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject1 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject43;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                if (((String)localObject38).equalsIgnoreCase("bigCloseSVipSetting"))
                {
                  localObject43 = localXmlPullParser.nextText();
                  i15 = i8;
                  localObject30 = localObject17;
                  i8 = j;
                  i14 = i7;
                  j = i6;
                  localObject42 = localObject14;
                  localObject38 = localObject13;
                  i6 = i5;
                  localObject39 = localObject11;
                  i7 = i4;
                  i5 = i3;
                  i13 = i2;
                  localObject11 = localObject9;
                  localObject13 = localObject8;
                  i4 = i1;
                  localObject8 = localObject7;
                  localObject9 = localObject6;
                  i1 = i;
                  localObject14 = localObject5;
                  i3 = m;
                  localObject40 = localObject4;
                  i16 = k;
                  localObject4 = localObject3;
                  localObject41 = localObject2;
                  localObject17 = localObject1;
                  localObject1 = localObject30;
                  localObject2 = localObject42;
                  localObject3 = localObject11;
                  localObject5 = localObject10;
                  localObject6 = localObject12;
                  localObject7 = localObject18;
                  localObject10 = localObject15;
                  localObject11 = localObject16;
                  localObject12 = localObject14;
                  localObject14 = localObject19;
                  localObject15 = localObject41;
                  localObject30 = localObject43;
                  localObject16 = localObject17;
                  localObject17 = localObject20;
                  localObject18 = localObject21;
                  localObject19 = localObject22;
                  localObject20 = localObject23;
                  localObject21 = localObject24;
                  localObject22 = localObject25;
                  localObject23 = localObject26;
                  localObject24 = localObject27;
                  localObject25 = localObject28;
                  localObject26 = localObject29;
                  localObject27 = localObject38;
                  localObject28 = localObject39;
                  localObject29 = localObject40;
                  i = i5;
                  k = i15;
                  m = n;
                  n = i1;
                  i1 = i8;
                  i2 = i14;
                  i5 = i9;
                  i8 = i16;
                  i9 = i13;
                  continue;
                }
                i17 = i2;
                i13 = k;
                i18 = i4;
                i19 = i5;
                i23 = i9;
                i16 = i1;
                i14 = m;
                i21 = i7;
                i15 = n;
                i20 = i6;
                i22 = i8;
                if (!((String)localObject38).equalsIgnoreCase("bigCloseUnionSetting")) {
                  break label28988;
                }
                localObject43 = localXmlPullParser.nextText();
                i15 = i8;
                localObject31 = localObject17;
                i8 = j;
                i14 = i7;
                j = i6;
                localObject42 = localObject14;
                localObject38 = localObject13;
                i6 = i5;
                localObject39 = localObject11;
                i7 = i4;
                i5 = i3;
                i13 = i2;
                localObject11 = localObject9;
                localObject13 = localObject8;
                i4 = i1;
                localObject8 = localObject7;
                localObject9 = localObject6;
                i1 = i;
                localObject14 = localObject5;
                i3 = m;
                localObject40 = localObject4;
                i16 = k;
                localObject4 = localObject3;
                localObject41 = localObject2;
                localObject17 = localObject1;
                localObject1 = localObject31;
                localObject2 = localObject42;
                localObject3 = localObject11;
                localObject5 = localObject10;
                localObject6 = localObject12;
                localObject7 = localObject18;
                localObject10 = localObject15;
                localObject11 = localObject16;
                localObject12 = localObject14;
                localObject14 = localObject19;
                localObject15 = localObject41;
                localObject31 = localObject43;
                localObject16 = localObject17;
                localObject17 = localObject20;
                localObject18 = localObject21;
                localObject19 = localObject22;
                localObject20 = localObject23;
                localObject21 = localObject24;
                localObject22 = localObject25;
                localObject23 = localObject26;
                localObject24 = localObject27;
                localObject25 = localObject28;
                localObject26 = localObject29;
                localObject27 = localObject38;
                localObject28 = localObject39;
                localObject29 = localObject40;
                i = i5;
                k = i15;
                m = n;
                n = i1;
                i1 = i8;
                i2 = i14;
                i5 = i9;
                i8 = i16;
                i9 = i13;
                continue;
                localObject38 = i2 + "|" + k + "|" + i4 + "|" + i5 + "|" + i9 + "|" + i1 + "|" + m + "|" + i7 + "|" + n + "|" + i8 + "|" + i6 + "|" + j + "|" + i;
                if (QLog.isColorLevel()) {
                  QLog.d(TAG, 2, "handleRespGetHotDaysConfig success：showInContact|ShowInChat|settingdays=" + bool2 + "|" + bool1 + "|" + (String)localObject38 + "version=" + paramInt + "maxRemindTimes=" + n);
                }
                aqmj.D(paramQQAppInterface.getApp(), paramInt, paramQQAppInterface.getCurrentAccountUin());
                aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), bool2, bool1, (String)localObject38);
                aqmj.Y(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), i3);
                localObject38 = (acff)paramQQAppInterface.getManager(51);
                ((acff)localObject38).a(bool2, bool1, i2, k, i4, i5, i9, i1, m, i7, j, i, n);
                a(paramQQAppInterface.getApp(), (String)localObject4, (String)localObject11, (String)localObject13, (String)localObject29, (String)localObject28, (String)localObject27, (String)localObject26, (String)localObject25, (String)localObject24, (String)localObject23, (String)localObject22, (String)localObject21, (String)localObject20, (String)localObject1, (String)localObject30, (String)localObject31, (String)localObject32, (String)localObject33, (String)localObject34, (String)localObject35, (String)localObject36, (String)localObject37);
                bI(paramQQAppInterface.getApp(), (String)localObject2);
                a(paramQQAppInterface.getApp(), (String)localHashMap2.get("grayChatUp"), (String)localHashMap2.get("grayPraiseUp"), (String)localHashMap2.get("grayCloseUp"), (String)localHashMap2.get("grayQzoneLoverUp"), (String)localHashMap2.get("grayQzoneVisitUp"), (String)localHashMap2.get("grayChatUp2"), (String)localHashMap2.get("grayPraiseUp2"), (String)localHashMap2.get("grayCloseUp2"), (String)localHashMap2.get("grayQzoneLoverUp2"), (String)localHashMap2.get("grayQzoneVisitUp2"), (String)localHashMap2.get("grayChatDown"), (String)localHashMap2.get("grayPriaseDown"), (String)localHashMap2.get("grayCloseDown"), (String)localHashMap2.get("grayQzoneLoverDown"), (String)localHashMap2.get("grayQzoneVisitDown"), (String)localHashMap2.get("grayChatDis"), (String)localHashMap2.get("grayPriaseDis"), (String)localHashMap2.get("grayCloseDis"), (String)localHashMap2.get("grayQzoneLoverDis"), (String)localHashMap2.get("grayQzoneVisitDis"), (String)localHashMap2.get("grayQzoneLoverClose"), (String)localHashMap2.get("grayQzoneLoverClose2"), (String)localHashMap2.get("grayQzoneLoverOpen"), (String)localHashMap2.get("grayQzoneLoverOpen2"), (String)localHashMap2.get("grayQzoneLoverUpdate"), (String)localHashMap2.get("grayQzoneLoverUpdate2"), (String)localHashMap2.get("graytipFriendship1Upgrade"), (String)localHashMap2.get("graytipFriendship1Downgrade"), (String)localHashMap2.get("graytipFriendship2Upgrade"), (String)localHashMap2.get("graytipFriendship2Downgrade"), (String)localHashMap2.get("graytipFriendship3Upgrade"), (String)localHashMap2.get("graytipFriendship3Downgrade"));
                a(paramQQAppInterface.getApp(), (String)localObject19, (String)localObject8, (String)localObject5, (String)localObject16, (String)localObject15, (String)localObject6, (String)localObject7, (String)localObject18, (String)localObject12, (String)localObject10, (String)localObject3, (String)localObject9, (String)localObject14);
                localObject1 = paramQQAppInterface.getApp();
                localObject2 = (String)localHashMap1.get("graytipLover1Upgrade");
                localObject3 = (String)localHashMap1.get("graytipLover2Upgrade");
                localObject4 = (String)localHashMap1.get("graytipLover2Downgrade");
                localObject5 = (String)localHashMap1.get("graytipLover3Downgrade");
                localObject6 = (String)localHashMap1.get("graytipBuddy1Upgrade");
                localObject7 = (String)localHashMap1.get("graytipBuddy2Upgrade");
                localObject8 = (String)localHashMap1.get("graytipBuddy2Downgrade");
                localObject9 = (String)localHashMap1.get("graytipBuddy3Downgrade");
                localObject10 = (String)localHashMap1.get("graytipLadyBro1Upgrade");
                localObject11 = (String)localHashMap1.get("graytipLadyBro2Upgrade");
                localObject12 = (String)localHashMap1.get("graytipLadyBro2Downgrade");
                localObject13 = (String)localHashMap1.get("graytipLadyBro3Downgrade");
                localObject14 = (String)localHashMap1.get("graytipIntimateshipBindTip");
                localObject15 = (String)localHashMap1.get("graytipIntimateshipUnBind1Tip");
                localObject16 = (String)localHashMap1.get("graytipIntimateshipUnBind2Tip");
                localObject18 = (String)localHashMap1.get("graytipIntimateshipUnBind3Tip");
                localObject19 = (String)localHashMap1.get("graytipIntimateshipBecomeGrayTip");
                localObject20 = (String)localHashMap1.get("graytipIntimateshipBecomeLightTip");
                a((Context)localObject1, (acff)localObject38, i10, i11, i12, new String[] { "hot_intimate_Lover1Upgrade", "hot_intimate_Lover2Upgrade", "hot_intimate_Lover2Downgrade", "hot_intimate_Lover3Downgrade", "hot_intimate_Buddy1Upgrade", "hot_intimate_Buddy2Upgrade", "hot_intimate_Buddy2Downgrade", "hot_intimate_Buddy3Downgrade", "hot_intimate_LadyBro1Upgrade", "hot_intimate_LadyBro2Upgrade", "hot_intimate_LadyBro2Downgrade", "hot_intimate_LadyBro3Downgrade", "hot_intimate_BindTip", "hot_intimate_UnBind1Tip", "hot_intimate_UnBind2Tip", "hot_intimate_UnBind3Tip", "hot_intimate_BecomeGrayTip", "hot_intimate_BecomeLightTip" }, new String[] { localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject18, localObject19, localObject20 });
                bH(paramQQAppInterface.getApp(), (String)localObject17);
                return;
              }
              break label30860;
            }
            break label30623;
          }
          break label30386;
          label28866:
          if (i24 == 1) {
            continue;
          }
          i17 = i2;
          i13 = k;
          i18 = i4;
          i19 = i5;
          i23 = i9;
          i16 = i1;
          i14 = m;
          i21 = i7;
          i15 = n;
          i20 = i6;
          i22 = i8;
        }
        switch (i24)
        {
        case 2: 
        default: 
          i22 = i8;
          i20 = i6;
          i15 = n;
          i21 = i7;
          i14 = m;
          i16 = i1;
          i23 = i9;
          i19 = i5;
          i18 = i4;
          i13 = k;
          i17 = i2;
        case 3: 
          i5 = i23;
          k = i22;
          localObject41 = localObject17;
          i1 = j;
          i2 = i21;
          j = i20;
          localObject43 = localObject14;
          localObject38 = localObject13;
          i6 = i19;
          localObject39 = localObject11;
          i7 = i18;
          m = i3;
          i9 = i17;
          localObject11 = localObject9;
          localObject13 = localObject8;
          i4 = i16;
          localObject8 = localObject7;
          localObject9 = localObject6;
          n = i;
          localObject14 = localObject5;
          i3 = i14;
          localObject40 = localObject4;
          i8 = i13;
          localObject4 = localObject3;
          localObject42 = localObject2;
          localObject17 = localObject1;
          localObject1 = localObject41;
          localObject2 = localObject43;
          localObject3 = localObject11;
          localObject5 = localObject10;
          localObject6 = localObject12;
          localObject7 = localObject18;
          localObject10 = localObject15;
          localObject11 = localObject16;
          localObject12 = localObject14;
          localObject14 = localObject19;
          localObject15 = localObject42;
          localObject16 = localObject17;
          localObject17 = localObject20;
          localObject18 = localObject21;
          localObject19 = localObject22;
          localObject20 = localObject23;
          localObject21 = localObject24;
          localObject22 = localObject25;
          localObject23 = localObject26;
          localObject24 = localObject27;
          localObject25 = localObject28;
          localObject26 = localObject29;
          localObject27 = localObject38;
          localObject28 = localObject39;
          localObject29 = localObject40;
          i = m;
          m = i15;
          break;
        case 4: 
          label28988:
          i15 = i8;
          localObject41 = localObject17;
          i8 = j;
          i14 = i7;
          j = i6;
          localObject43 = localObject14;
          localObject38 = localObject13;
          i6 = i5;
          localObject39 = localObject11;
          i7 = i4;
          i5 = i3;
          i13 = i2;
          localObject11 = localObject9;
          localObject13 = localObject8;
          i4 = i1;
          localObject8 = localObject7;
          localObject9 = localObject6;
          i1 = i;
          localObject14 = localObject5;
          i3 = m;
          localObject40 = localObject4;
          i16 = k;
          localObject4 = localObject3;
          localObject42 = localObject2;
          localObject17 = localObject1;
          localObject1 = localObject41;
          localObject2 = localObject43;
          localObject3 = localObject11;
          localObject5 = localObject10;
          localObject6 = localObject12;
          localObject7 = localObject18;
          localObject10 = localObject15;
          localObject11 = localObject16;
          localObject12 = localObject14;
          localObject14 = localObject19;
          localObject15 = localObject42;
          localObject16 = localObject17;
          localObject17 = localObject20;
          localObject18 = localObject21;
          localObject19 = localObject22;
          localObject20 = localObject23;
          localObject21 = localObject24;
          localObject22 = localObject25;
          localObject23 = localObject26;
          localObject24 = localObject27;
          localObject25 = localObject28;
          localObject26 = localObject29;
          localObject27 = localObject38;
          localObject28 = localObject39;
          localObject29 = localObject40;
          i = i5;
          k = i15;
          m = n;
          n = i1;
          i1 = i8;
          i2 = i14;
          i5 = i9;
          i8 = i16;
          i9 = i13;
          break;
        }
      }
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label29675:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label29912:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label30149:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label30386:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label30623:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
      continue;
      label30860:
      i15 = i8;
      localObject41 = localObject17;
      i8 = j;
      i14 = i7;
      j = i6;
      localObject43 = localObject14;
      localObject38 = localObject13;
      i6 = i5;
      localObject39 = localObject11;
      i7 = i4;
      i5 = i3;
      i13 = i2;
      localObject11 = localObject9;
      localObject13 = localObject8;
      i4 = i1;
      localObject8 = localObject7;
      localObject9 = localObject6;
      i1 = i;
      localObject14 = localObject5;
      i3 = m;
      localObject40 = localObject4;
      i16 = k;
      localObject4 = localObject3;
      localObject42 = localObject2;
      localObject17 = localObject1;
      localObject1 = localObject41;
      localObject2 = localObject43;
      localObject3 = localObject11;
      localObject5 = localObject10;
      localObject6 = localObject12;
      localObject7 = localObject18;
      localObject10 = localObject15;
      localObject11 = localObject16;
      localObject12 = localObject14;
      localObject14 = localObject19;
      localObject15 = localObject42;
      localObject16 = localObject17;
      localObject17 = localObject20;
      localObject18 = localObject21;
      localObject19 = localObject22;
      localObject20 = localObject23;
      localObject21 = localObject24;
      localObject22 = localObject25;
      localObject23 = localObject26;
      localObject24 = localObject27;
      localObject25 = localObject28;
      localObject26 = localObject29;
      localObject27 = localObject38;
      localObject28 = localObject39;
      localObject29 = localObject40;
      i = i5;
      k = i15;
      m = n;
      n = i1;
      i1 = i8;
      i2 = i14;
      i5 = i9;
      i8 = i16;
      i9 = i13;
    }
  }
  
  public static String xu()
  {
    return aqul.getSDKPrivatePath(blY);
  }
  
  public static String xv()
  {
    String str = xu();
    return str + filename;
  }
  
  public static String xw()
  {
    String str = xu();
    return str + bRQ;
  }
  
  public static class a
  {
    public int djY;
    public String name;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajol
 * JD-Core Version:    0.7.0.1
 */