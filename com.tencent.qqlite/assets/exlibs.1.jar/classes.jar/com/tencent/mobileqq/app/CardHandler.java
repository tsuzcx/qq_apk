package com.tencent.mobileqq.app;

import AccostSvc.Msg;
import AccostSvc.RespClientMsg;
import KQQ.SetUserInfoResp;
import QQService.CommonCard;
import QQService.FaceInfo;
import QQService.Intro;
import QQService.MakeFriendsCard;
import QQService.PushVoteIncreaseInfo;
import QQService.RespAddFace;
import QQService.RespCommonCard;
import QQService.RespDelFace;
import QQService.RespFaceInfo;
import QQService.RespFavorite;
import QQService.RespGetCardSwitch;
import QQService.RespGetFace;
import QQService.RespGetFavoriteList;
import QQService.RespGetVisitorList;
import QQService.RespGetVoterList;
import QQService.RespHYCommonCard;
import QQService.RespHYMakeFriendsCard;
import QQService.RespMakeFriendsCard;
import QQService.RespSetCardSwitch;
import QQService.RespUpdateIntro;
import QQService.RespUpdateQQFace;
import QQService.RespVote;
import QQService.UserCntlData;
import QQService.UserProfile;
import QQService.Visitor;
import SummaryCard.RespVoiceManage;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SUserLabel;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import crm;
import crn;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CardHandler
  extends BusinessHandler
{
  public static final int A = 29;
  public static final String A = "key_qzone_switch";
  public static final int B = 30;
  public static final String B = "key_hobby_switch";
  public static final int C = 31;
  public static final String C = "key_new_profile_modified_flag";
  public static final int D = 32;
  public static final String D = "key_is_nearby_people_card";
  public static final int E = 33;
  public static final int F = 34;
  public static final int G = 35;
  public static final int H = 36;
  public static final int I = 37;
  public static final int J = 38;
  public static final int K = 39;
  public static final int L = 41;
  public static final int M = 42;
  public static final int N = 43;
  public static final int O = 44;
  public static final int P = 45;
  public static final int Q = 46;
  public static final int R = 47;
  public static final int S = 48;
  public static final int T = 49;
  public static final int U = 50;
  public static final int V = 51;
  public static final int W = 52;
  public static final int X = 53;
  public static final int Y = 56;
  public static final int Z = 0;
  public static final int a = 0;
  public static final String a;
  public static final Vector a;
  static final boolean jdField_a_of_type_Boolean = true;
  public static final int aa = 60;
  public static final int ab = 100;
  public static final int ac = 160;
  public static final int ad = 640;
  public static final int ae = 960;
  public static final int af = 120;
  public static final int b = 1;
  public static final String b = "background";
  public static final Vector b;
  public static final int c = 2;
  public static final String c = "temp";
  public static final int d = 3;
  public static final String d = "HDAvatar";
  public static final int e = 5;
  public static final String e = "voice";
  public static final int f = 6;
  public static final String f = ";";
  public static final int g = 7;
  public static final String g = "_TIMESTAMP";
  public static final int h = 8;
  public static final String h = "_TEMP_COVER_FILEKEY";
  public static final int i = 9;
  public static final String i = "nick";
  public static final int j = 10;
  public static final String j = "sex";
  public static final int k = 11;
  public static final String k = "birthday";
  public static final int l = 12;
  public static final String l = "age";
  public static final int m = 13;
  public static final String m = "key_constellation";
  public static final int n = 16;
  public static final String n = "profession";
  public static final int o = 17;
  public static final String o = "company";
  public static final int p = 19;
  public static final String p = "college";
  public static final int q = 20;
  public static final String q = "location";
  public static final int r = 20;
  public static final String r = "locationo_desc";
  public static final int s = 21;
  public static final String s = "location_name";
  public static final int t = 22;
  public static final String t = "hometown";
  public static final int u = 23;
  public static final String u = "hometown_desc";
  public static final int v = 24;
  public static final String v = "email";
  public static final int w = 25;
  public static final String w = "personalNote";
  public static final int x = 26;
  public static final String x = "key_xuan_yan";
  public static final int y = 27;
  public static final String y = "key_new_nickname";
  public static final int z = 28;
  public static final String z = "key_marital_status";
  short jdField_a_of_type_Short = 9;
  short b;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.as + "portrait/";
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
  }
  
  CardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Short = -25044;
    if (jdField_a_of_type_JavaUtilVector.size() == 0)
    {
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
    }
    if (jdField_b_of_type_JavaUtilVector.size() == 0)
    {
      jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(960));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(120));
    }
  }
  
  protected static int a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i1 = paramContext.widthPixels;
    int i2 = paramContext.heightPixels;
    if (i1 > i2) {
      return i1;
    }
    return i2;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0).getString(paramString + "_TEMP_COVER_FILEKEY", null);
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString)) || (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      return "";
    }
    return jdField_a_of_type_JavaLangString + paramInt + "/" + paramString + ".jpg";
  }
  
  public static String a(List paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.clear();
    if (paramList.size() > 0)
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        localLinkedList.add(HexUtil.a(((FaceInfo)paramList.get(i1)).vFaceID));
        i1 += 1;
      }
      return b(localLinkedList);
    }
    return ";";
  }
  
  public static LinkedList a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int i1 = 0;
      while (i1 < paramString.length)
      {
        if ((paramString[i1] != null) && (!"".equals(paramString[i1]))) {
          localLinkedList.add(paramString[i1]);
        }
        i1 += 1;
      }
    }
    return localLinkedList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, "_TEMP_COVER_FILEKEY", paramString2);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    if ((paramString3 == null) || ("".equals(paramString3))) {
      paramContext.remove(paramString1 + paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString1 + paramString2, paramString3);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = (RespVote)paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("targetUin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("selfUin");
    paramBundle.putString("targetUin", paramFromServiceMsg);
    paramBundle.putString("selfUin", paramToServiceMsg);
    if ((paramObject != null) && ((paramObject instanceof RespVote)) && (((RespVote)paramObject).stHeader.iReplyCode == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (!TextUtils.isEmpty(paramFromServiceMsg)))
      {
        paramToServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.lVoteCount -= 1L;
          paramFromServiceMsg.bVoted = 0;
          paramToServiceMsg.a(paramFromServiceMsg);
        }
      }
      a(5, bool, paramBundle);
      return;
    }
  }
  
  public static void a(String paramString, List paramList) {}
  
  private void a(List paramList, Bundle paramBundle)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramList.size() * 2 + 7);
    localByteBuffer.putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localByteBuffer.put((byte)0);
    localByteBuffer.putShort((short)paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localByteBuffer.putShort(((Short)paramList.next()).shortValue());
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramList = a("OidbSvc.0x480_9");
    paramList.putWupBuffer(localOIDBSSOPkg.toByteArray());
    if (paramBundle != null) {
      paramList.extraData.putAll(paramBundle);
    }
    paramList.extraData.putBoolean("reqFromCardHandler", true);
    b(paramList);
  }
  
  public static int b(Context paramContext)
  {
    return 640;
  }
  
  public static String b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuffer.append((String)paramList.get(i1));
      if (i1 < i2 - 1) {
        localStringBuffer.append(";");
      }
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          if (ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = bool2;
        bool2 = false;
        continue;
      }
      if (!bool2) {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
      }
      a(38, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    Object localObject = paramFromServiceMsg.getAttribute("result");
    paramObject = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    paramBundle.putString("targetUin", Long.toString(l1));
    paramBundle.putString("selfUin", Long.toString(l2));
    if ((localObject != null) && ((localObject instanceof RespFavorite)))
    {
      paramFromServiceMsg = (RespFavorite)localObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        paramObject.put("param_FailCode", "0");
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramObject, "", false);
        bool2 = paramToServiceMsg.extraData.getBoolean("nearby_people");
        if (!bool1) {
          break label509;
        }
        if ((l1 > 0L) && (bool2))
        {
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          paramFromServiceMsg = (NearbyPeopleCard)paramToServiceMsg.a(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(l1) });
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg.likeCount += 1;
            paramFromServiceMsg.bVoted = 1;
            paramToServiceMsg.a(paramFromServiceMsg);
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + bool1 + "," + l1);
      }
      a(32, bool1, paramBundle);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramFromServiceMsg.stHeader.iReplyCode);
      }
      paramObject.put("param_FailCode", String.valueOf(paramFromServiceMsg.stHeader.iReplyCode));
      break;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
        if (localObject != null)
        {
          paramFromServiceMsg = "not RespFavorite";
          label425:
          QLog.i("Q.profilecard.", 2, paramFromServiceMsg);
        }
      }
      else
      {
        if (localObject == null) {
          break label502;
        }
      }
      label502:
      for (paramFromServiceMsg = "-201";; paramFromServiceMsg = "-202")
      {
        paramObject.put("param_FailCode", paramFromServiceMsg);
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramObject, "", false);
        bool1 = bool2;
        break;
        paramFromServiceMsg = "null";
        break label425;
      }
      label509:
      if ((l1 > 0L) && (!bool2))
      {
        paramToServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramFromServiceMsg = paramToServiceMsg.a(String.valueOf(l1));
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.lVoteCount -= 1L;
          paramFromServiceMsg.bVoted = 0;
          paramToServiceMsg.a(paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.", 2, "reqFavorite fail, revertdata | lVoteCount = " + paramFromServiceMsg.lVoteCount);
          }
        }
      }
    }
  }
  
  public static int c(Context paramContext)
  {
    int i1 = a(paramContext);
    if (i1 <= 240) {
      return 60;
    }
    if (i1 <= 320) {
      return 100;
    }
    return 160;
  }
  
  public static void c()
  {
    int i3 = 0;
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!((File)localObject).exists()) {}
    try
    {
      bool1 = ((File)localObject).mkdirs();
      if (bool1)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add("background");
        ((ArrayList)localObject).add("temp");
        ((ArrayList)localObject).add("HDAvatar");
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= jdField_a_of_type_JavaUtilVector.size()) {
            break;
          }
          ((ArrayList)localObject).add(String.valueOf(((Integer)jdField_a_of_type_JavaUtilVector.get(i1)).intValue()));
          i1 += 1;
        }
        if (i2 < ((ArrayList)localObject).size())
        {
          localFile = new File(jdField_a_of_type_JavaLangString + "/" + (String)((ArrayList)localObject).get(i2));
          if (localFile.exists()) {}
        }
      }
    }
    catch (SecurityException localSecurityException1)
    {
      try
      {
        for (;;)
        {
          int i2;
          File localFile;
          localFile.mkdir();
          label180:
          i2 += 1;
        }
        localSecurityException1 = localSecurityException1;
        bool1 = bool2;
      }
      catch (SecurityException localSecurityException2)
      {
        break label180;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_searchable", true);
      if (!bool1) {
        break label148;
      }
    }
    label148:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
        a(39, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin());
      paramFromServiceMsg = (RespGetFavoriteList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = b();
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        a(42, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        return;
      }
      Iterator localIterator = paramFromServiceMsg.vFavoriteInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      while (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        if (QLog.isDevelopLevel()) {
          QLog.d("favolist", 4, "bConstellation=" + localUserProfile.bConstellation + " vipInfo=" + localUserProfile.stVipInfo + " richSign=" + localUserProfile.vRichSign);
        }
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.setType(3);
        localArrayList.add(localCardProfile);
      }
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      b(paramToServiceMsg.getUin(), localArrayList);
      a(42, true, new Object[] { paramObject, paramBundle, localArrayList });
      return;
    }
    paramToServiceMsg = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin());
    paramBundle.putLong("startMid", -1L);
    a(42, false, new Object[] { paramToServiceMsg, paramBundle, b() });
  }
  
  private void c(String paramString, List paramList)
  {
    b(paramString, paramList);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    String[] arrayOfString;
    NearbyPeopleCard localNearbyPeopleCard;
    boolean bool3;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      i1 = -1000;
      localFriendsManager = null;
      arrayOfString = null;
      localObject1 = null;
      localNearbyPeopleCard = null;
      paramFromServiceMsg = null;
      bool3 = paramToServiceMsg.extraData.getBoolean("key_is_nearby_people_card", false);
      bool2 = bool1;
      i2 = i1;
      if (bool1)
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = arrayOfString;
        i2 = i1;
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          if (paramObject != null)
          {
            localObject1 = localNearbyPeopleCard;
            paramFromServiceMsg = arrayOfString;
            i2 = i1;
            if (paramObject.uint32_result.has())
            {
              localObject1 = localNearbyPeopleCard;
              paramFromServiceMsg = arrayOfString;
              i2 = i1;
              i3 = paramObject.uint32_result.get();
              if (i3 == 0)
              {
                bool2 = true;
                label146:
                i1 = i3;
                bool1 = bool2;
                localObject1 = localNearbyPeopleCard;
                paramFromServiceMsg = arrayOfString;
                i2 = i3;
                if (QLog.isColorLevel())
                {
                  localObject1 = localNearbyPeopleCard;
                  paramFromServiceMsg = arrayOfString;
                  i2 = i3;
                  QLog.d("CardHandler", 2, "handleSetDetailInfo, ret = " + i3 + ", isNearbyPeopleCard = " + bool3);
                  bool1 = bool2;
                  i1 = i3;
                }
                label229:
                if (i1 != 0) {
                  continue;
                }
                if (!bool3) {
                  continue;
                }
                localObject1 = localNearbyPeopleCard;
                paramFromServiceMsg = arrayOfString;
                i2 = i1;
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
                localObject1 = localNearbyPeopleCard;
                paramFromServiceMsg = arrayOfString;
                i2 = i1;
                paramObject = (NearbyPeopleCard)((EntityManager)localObject2).a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() });
                paramFromServiceMsg = paramObject;
                if (paramObject != null) {}
              }
            }
          }
        }
        catch (Exception paramObject)
        {
          int i3;
          Object localObject2;
          label646:
          label679:
          label753:
          label759:
          paramToServiceMsg = (ToServiceMsg)localObject1;
          label813:
          localObject1 = paramFromServiceMsg;
          i1 = i2;
          continue;
          paramFromServiceMsg = null;
          paramToServiceMsg = null;
          continue;
        }
        try
        {
          for (;;)
          {
            localNearbyPeopleCard = new NearbyPeopleCard();
            localObject1 = localNearbyPeopleCard;
            paramFromServiceMsg = arrayOfString;
            i2 = i1;
            localNearbyPeopleCard.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            paramFromServiceMsg = localNearbyPeopleCard;
            try
            {
              if (paramToServiceMsg.extraData.containsKey("key_xuan_yan")) {
                paramFromServiceMsg.xuanYan = paramToServiceMsg.extraData.getByteArray("key_xuan_yan");
              }
              if (paramToServiceMsg.extraData.containsKey("key_new_nickname")) {
                paramFromServiceMsg.nickname = paramToServiceMsg.extraData.getString("key_new_nickname");
              }
              if (paramToServiceMsg.extraData.containsKey("key_marital_status")) {
                paramFromServiceMsg.maritalStatus = paramToServiceMsg.extraData.getByte("key_marital_status");
              }
              if (paramToServiceMsg.extraData.containsKey("sex")) {
                paramFromServiceMsg.gender = paramToServiceMsg.extraData.getByte("sex");
              }
              if (paramToServiceMsg.extraData.containsKey("birthday"))
              {
                paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
                paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
                paramFromServiceMsg.constellation = paramToServiceMsg.extraData.getByte("key_constellation");
              }
              if (paramToServiceMsg.extraData.containsKey("profession")) {
                paramFromServiceMsg.job = paramToServiceMsg.extraData.getInt("profession");
              }
              if (paramToServiceMsg.extraData.containsKey("company")) {
                paramFromServiceMsg.company = paramToServiceMsg.extraData.getString("company");
              }
              if (paramToServiceMsg.extraData.containsKey("college")) {
                paramFromServiceMsg.college = paramToServiceMsg.extraData.getString("college");
              }
              if (paramToServiceMsg.extraData.containsKey("hometown"))
              {
                paramObject = paramToServiceMsg.extraData.getStringArray("hometown");
                paramFromServiceMsg.hometownCountry = paramObject[0];
                paramFromServiceMsg.hometownProvice = paramObject[1];
                paramFromServiceMsg.hometownCity = paramObject[2];
                paramFromServiceMsg.hometownDistrict = paramObject[3];
              }
              if (paramToServiceMsg.extraData.containsKey("key_qzone_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_qzone_switch") == 0)
                {
                  bool2 = true;
                  paramFromServiceMsg.switchQzone = bool2;
                }
              }
              else
              {
                if (paramToServiceMsg.extraData.containsKey("key_hobby_switch"))
                {
                  if (paramToServiceMsg.extraData.getShort("key_hobby_switch") != 0) {
                    break label753;
                  }
                  bool2 = true;
                  paramFromServiceMsg.switchHobby = bool2;
                }
                if (paramFromServiceMsg.getStatus() != 1000) {
                  break label759;
                }
                ((EntityManager)localObject2).b(paramFromServiceMsg);
              }
              for (;;)
              {
                paramToServiceMsg = null;
                i2 = i1;
                localObject1 = paramToServiceMsg;
                bool2 = bool1;
                if (!bool3) {
                  break label1892;
                }
                a(49, bool2, paramFromServiceMsg);
                return;
                bool1 = false;
                break;
                bool2 = false;
                break label146;
                bool1 = false;
                break label229;
                bool2 = false;
                break label646;
                bool2 = false;
                break label679;
                if ((paramFromServiceMsg.getStatus() == 1001) || (paramFromServiceMsg.getStatus() == 1002)) {
                  ((EntityManager)localObject2).a(paramFromServiceMsg);
                }
              }
              if (!QLog.isColorLevel()) {
                break label813;
              }
            }
            catch (Exception paramObject)
            {
              paramToServiceMsg = paramFromServiceMsg;
              localObject1 = localFriendsManager;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = paramObject;
          paramObject = paramFromServiceMsg;
          localObject1 = localFriendsManager;
        }
      }
      QLog.d("CardHandler", 2, "handleGetDetailInfo", paramObject);
      bool2 = false;
      paramFromServiceMsg = paramToServiceMsg;
      i2 = i1;
      continue;
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = arrayOfString;
      i2 = i1;
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = arrayOfString;
      i2 = i1;
      paramObject = localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("nick"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.strNick = paramToServiceMsg.extraData.getString("nick");
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramObject.strNick);
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("sex"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.shGender = ((short)paramToServiceMsg.extraData.getByte("sex"));
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("birthday"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.lBirthday = paramToServiceMsg.extraData.getInt("birthday");
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.age = ((byte)paramToServiceMsg.extraData.getInt("age"));
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.constellation = paramToServiceMsg.extraData.getInt("key_constellation");
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("profession"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.iProfession = paramToServiceMsg.extraData.getInt("profession");
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("company"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.strCompany = paramToServiceMsg.extraData.getString("company");
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("college"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.strSchool = paramToServiceMsg.extraData.getString("college");
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("location"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        arrayOfString = paramToServiceMsg.extraData.getStringArray("location");
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        localObject2 = new StringBuilder();
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        ((StringBuilder)localObject2).append(arrayOfString[0]).append("-").append(arrayOfString[1]).append("-").append(arrayOfString[2]).append("-").append(arrayOfString[3]);
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.strLocationCodes = ((StringBuilder)localObject2).toString();
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.strLocationDesc = paramToServiceMsg.extraData.getString("locationo_desc");
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        arrayOfString = paramToServiceMsg.extraData.getStringArray("location_name");
        if (arrayOfString != null)
        {
          localObject1 = localNearbyPeopleCard;
          paramFromServiceMsg = paramObject;
          i2 = i1;
          if (arrayOfString.length == 4)
          {
            localObject1 = localNearbyPeopleCard;
            paramFromServiceMsg = paramObject;
            i2 = i1;
            if (QLog.isColorLevel())
            {
              localObject1 = localNearbyPeopleCard;
              paramFromServiceMsg = paramObject;
              i2 = i1;
              localObject2 = new StringBuilder("nameArray: ");
              i3 = 0;
              if (i3 < 4)
              {
                localObject1 = localNearbyPeopleCard;
                paramFromServiceMsg = paramObject;
                i2 = i1;
                ((StringBuilder)localObject2).append(arrayOfString[i3]).append(" ");
                i3 += 1;
                continue;
              }
              localObject1 = localNearbyPeopleCard;
              paramFromServiceMsg = paramObject;
              i2 = i1;
              QLog.d("CardHandler", 2, ((StringBuilder)localObject2).toString());
            }
            localObject1 = localNearbyPeopleCard;
            paramFromServiceMsg = paramObject;
            i2 = i1;
            paramObject.strCountry = arrayOfString[0];
            localObject1 = localNearbyPeopleCard;
            paramFromServiceMsg = paramObject;
            i2 = i1;
            paramObject.strProvince = arrayOfString[1];
            localObject1 = localNearbyPeopleCard;
            paramFromServiceMsg = paramObject;
            i2 = i1;
            paramObject.strCity = arrayOfString[2];
          }
        }
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("hometown"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        arrayOfString = paramToServiceMsg.extraData.getStringArray("hometown");
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        localObject2 = new StringBuilder();
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        ((StringBuilder)localObject2).append(arrayOfString[0]).append("-").append(arrayOfString[1]).append("-").append(arrayOfString[2]).append("-").append(arrayOfString[3]);
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.strHometownCodes = ((StringBuilder)localObject2).toString();
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.strHometownDesc = paramToServiceMsg.extraData.getString("hometown_desc");
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("email"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.strEmail = paramToServiceMsg.extraData.getString("email");
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      if (paramToServiceMsg.extraData.containsKey("personalNote"))
      {
        localObject1 = localNearbyPeopleCard;
        paramFromServiceMsg = paramObject;
        i2 = i1;
        paramObject.strPersonalNote = paramToServiceMsg.extraData.getString("personalNote");
      }
      localObject1 = localNearbyPeopleCard;
      paramFromServiceMsg = paramObject;
      i2 = i1;
      localFriendsManager.a(paramObject);
      paramFromServiceMsg = null;
      paramToServiceMsg = paramObject;
    }
    label1892:
    a(31, bool2, new Object[] { Integer.valueOf(i2), localObject1 });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin());
      paramFromServiceMsg = (RespGetVoterList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a();
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        a(6, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        return;
      }
      Iterator localIterator = paramFromServiceMsg.vVoterInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      while (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.setType(2);
        localArrayList.add(localCardProfile);
      }
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      d(paramToServiceMsg.getUin(), localArrayList);
      if ((paramToServiceMsg.extraData.getLong("targetUin") + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
        ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      }
      a(6, true, new Object[] { paramObject, paramBundle, localArrayList });
      return;
    }
    paramToServiceMsg = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin());
    paramBundle.putLong("startMid", -1L);
    a(6, false, new Object[] { paramToServiceMsg, paramBundle, a() });
  }
  
  private void d(String paramString, List paramList)
  {
    b(paramString, paramList);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1) {}
      for (;;)
      {
        int i3;
        int i2;
        Object localObject8;
        Object localObject9;
        Object localObject10;
        Object localObject11;
        Object localObject12;
        Object localObject13;
        Object localObject14;
        Object localObject15;
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
            continue;
          }
          long l1 = localByteBuffer.getInt();
          localByteBuffer.get();
          int i6 = localByteBuffer.getShort();
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetDetailInfo, request success, tlvCount = " + i6);
          }
          i3 = 0;
          localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
          paramFromServiceMsg = localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          paramObject = "0";
          localObject2 = "0";
          localObject3 = "0";
          localObject1 = "0";
          localObject4 = "0";
          localObject6 = "0";
          localObject7 = "0";
          localObject5 = "0";
          i4 = 0;
          i5 = 0;
          try
          {
            if ((!localByteBuffer.hasRemaining()) || (i3 >= i6)) {
              continue;
            }
            i1 = localByteBuffer.getShort();
            i2 = localByteBuffer.getShort();
            switch (i1)
            {
            case 20002: 
              if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "invaild type: " + i1);
              }
              localByteBuffer.position(localByteBuffer.position() + i2);
              i1 = i5;
              i2 = i4;
              localObject8 = localObject5;
              localObject9 = localObject7;
              localObject10 = localObject6;
              localObject11 = localObject4;
              localObject12 = localObject1;
              localObject13 = localObject3;
              localObject14 = localObject2;
              localObject15 = paramObject;
            }
          }
          catch (Exception paramObject) {}
          localObject8 = new byte[i2];
          localByteBuffer.get((byte[])localObject8);
          paramFromServiceMsg.strNick = new String((byte[])localObject8);
          i1 = i5;
          i2 = i4;
          localObject8 = localObject5;
          localObject9 = localObject7;
          localObject10 = localObject6;
          localObject11 = localObject4;
          localObject12 = localObject1;
          localObject13 = localObject3;
          localObject14 = localObject2;
          localObject15 = paramObject;
          if (!QLog.isColorLevel()) {
            break label2926;
          }
          QLog.d("CardHandler", 2, "strNick = " + paramFromServiceMsg.strNick);
          i1 = i5;
          i2 = i4;
          localObject8 = localObject5;
          localObject9 = localObject7;
          localObject10 = localObject6;
          localObject11 = localObject4;
          localObject12 = localObject1;
          localObject13 = localObject3;
          localObject14 = localObject2;
          localObject15 = paramObject;
        }
        catch (Exception paramObject)
        {
          ByteBuffer localByteBuffer;
          FriendsManager localFriendsManager;
          boolean bool2;
          String str;
          int i7;
          int i8;
          paramFromServiceMsg = null;
          continue;
          i1 = -1111;
          continue;
        }
        bool2 = false;
        paramToServiceMsg = paramFromServiceMsg;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "handleGetDetailInfo", paramObject);
          bool1 = bool2;
          paramToServiceMsg = paramFromServiceMsg;
        }
        a(20, bool1, paramToServiceMsg);
        return;
        int i1 = localByteBuffer.get();
        if (i1 == 1)
        {
          paramFromServiceMsg.shGender = 0;
          i1 = i5;
          i2 = i4;
          localObject8 = localObject5;
          localObject9 = localObject7;
          localObject10 = localObject6;
          localObject11 = localObject4;
          localObject12 = localObject1;
          localObject13 = localObject3;
          localObject14 = localObject2;
          localObject15 = paramObject;
          if (QLog.isColorLevel())
          {
            QLog.d("CardHandler", 2, "shGender = " + paramFromServiceMsg.shGender);
            i1 = i5;
            i2 = i4;
            localObject8 = localObject5;
            localObject9 = localObject7;
            localObject10 = localObject6;
            localObject11 = localObject4;
            localObject12 = localObject1;
            localObject13 = localObject3;
            localObject14 = localObject2;
            localObject15 = paramObject;
          }
        }
        else
        {
          if (i1 == 2)
          {
            paramFromServiceMsg.shGender = 1;
            continue;
          }
          paramFromServiceMsg.shGender = -1;
          continue;
          i1 = localByteBuffer.getInt();
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "profession = " + i1);
          }
          if (NearbyProfileUtil.a(i1))
          {
            paramFromServiceMsg.iProfession = i1;
            i1 = i5;
            i2 = i4;
            localObject8 = localObject5;
            localObject9 = localObject7;
            localObject10 = localObject6;
            localObject11 = localObject4;
            localObject12 = localObject1;
            localObject13 = localObject3;
            localObject14 = localObject2;
            localObject15 = paramObject;
          }
          else
          {
            paramFromServiceMsg.iProfession = -1;
            i1 = i5;
            i2 = i4;
            localObject8 = localObject5;
            localObject9 = localObject7;
            localObject10 = localObject6;
            localObject11 = localObject4;
            localObject12 = localObject1;
            localObject13 = localObject3;
            localObject14 = localObject2;
            localObject15 = paramObject;
            break label2926;
            paramFromServiceMsg.lBirthday = localByteBuffer.getInt();
            if (paramFromServiceMsg.lBirthday == 0L)
            {
              paramFromServiceMsg.constellation = 0;
              i1 = i5;
              i2 = i4;
              localObject8 = localObject5;
              localObject9 = localObject7;
              localObject10 = localObject6;
              localObject11 = localObject4;
              localObject12 = localObject1;
              localObject13 = localObject3;
              localObject14 = localObject2;
              localObject15 = paramObject;
              if (QLog.isColorLevel())
              {
                QLog.d("CardHandler", 2, "birth = " + paramFromServiceMsg.lBirthday + ", constellation = " + paramFromServiceMsg.constellation);
                i1 = i5;
                i2 = i4;
                localObject8 = localObject5;
                localObject9 = localObject7;
                localObject10 = localObject6;
                localObject11 = localObject4;
                localObject12 = localObject1;
                localObject13 = localObject3;
                localObject14 = localObject2;
                localObject15 = paramObject;
              }
            }
            else
            {
              paramFromServiceMsg.constellation = Utils.a((int)((paramFromServiceMsg.lBirthday & 0xFF00) >> 8), (int)(paramFromServiceMsg.lBirthday & 0xFF));
              continue;
              localObject8 = new byte[i2];
              localByteBuffer.get((byte[])localObject8);
              str = new String((byte[])localObject8);
              paramFromServiceMsg.strCompany = str;
              i1 = i5;
              i2 = i4;
              localObject8 = localObject5;
              localObject9 = localObject7;
              localObject10 = localObject6;
              localObject11 = localObject4;
              localObject12 = localObject1;
              localObject13 = localObject3;
              localObject14 = localObject2;
              localObject15 = paramObject;
              if (QLog.isColorLevel())
              {
                QLog.d("CardHandler", 2, "company = " + str);
                i1 = i5;
                i2 = i4;
                localObject8 = localObject5;
                localObject9 = localObject7;
                localObject10 = localObject6;
                localObject11 = localObject4;
                localObject12 = localObject1;
                localObject13 = localObject3;
                localObject14 = localObject2;
                localObject15 = paramObject;
                break label2926;
                i1 = 1;
                i2 = localByteBuffer.getInt();
                i5 = localByteBuffer.getInt();
                i7 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "hometown, countryId " + i2 + ", provinceId " + i5 + ", cityId " + i7);
                }
                localObject15 = ConditionSearchManager.a(i2);
                localObject14 = ConditionSearchManager.a(i5);
                localObject13 = ConditionSearchManager.a(i7);
                i2 = i4;
                localObject8 = localObject5;
                localObject9 = localObject7;
                localObject10 = localObject6;
                localObject11 = localObject4;
                localObject12 = localObject1;
                break label2926;
                i1 = 1;
                i2 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "hometown, districtId " + i2);
                }
                localObject12 = ConditionSearchManager.a(i2);
                i2 = i4;
                localObject8 = localObject5;
                localObject9 = localObject7;
                localObject10 = localObject6;
                localObject11 = localObject4;
                localObject13 = localObject3;
                localObject14 = localObject2;
                localObject15 = paramObject;
                break label2926;
                i2 = 1;
                i1 = localByteBuffer.getInt();
                i4 = localByteBuffer.getInt();
                i7 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "location, countryId " + i1 + ", provinceId " + i4 + ", cityId " + i7);
                }
                localObject11 = ConditionSearchManager.a(i1);
                localObject10 = ConditionSearchManager.a(i4);
                localObject9 = ConditionSearchManager.a(i7);
                i1 = i5;
                localObject8 = localObject5;
                localObject12 = localObject1;
                localObject13 = localObject3;
                localObject14 = localObject2;
                localObject15 = paramObject;
                break label2926;
                i2 = 1;
                i1 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "location, districtId " + i1);
                }
                localObject8 = ConditionSearchManager.a(i1);
                i1 = i5;
                localObject9 = localObject7;
                localObject10 = localObject6;
                localObject11 = localObject4;
                localObject12 = localObject1;
                localObject13 = localObject3;
                localObject14 = localObject2;
                localObject15 = paramObject;
                break label2926;
                localObject8 = new byte[i2];
                localByteBuffer.get((byte[])localObject8);
                str = new String((byte[])localObject8);
                paramFromServiceMsg.strEmail = str;
                i1 = i5;
                i2 = i4;
                localObject8 = localObject5;
                localObject9 = localObject7;
                localObject10 = localObject6;
                localObject11 = localObject4;
                localObject12 = localObject1;
                localObject13 = localObject3;
                localObject14 = localObject2;
                localObject15 = paramObject;
                if (QLog.isColorLevel())
                {
                  QLog.d("CardHandler", 2, "email = " + str);
                  i1 = i5;
                  i2 = i4;
                  localObject8 = localObject5;
                  localObject9 = localObject7;
                  localObject10 = localObject6;
                  localObject11 = localObject4;
                  localObject12 = localObject1;
                  localObject13 = localObject3;
                  localObject14 = localObject2;
                  localObject15 = paramObject;
                  break label2926;
                  localObject8 = new byte[i2];
                  localByteBuffer.get((byte[])localObject8);
                  str = new String((byte[])localObject8);
                  paramFromServiceMsg.strPersonalNote = str;
                  i1 = i5;
                  i2 = i4;
                  localObject8 = localObject5;
                  localObject9 = localObject7;
                  localObject10 = localObject6;
                  localObject11 = localObject4;
                  localObject12 = localObject1;
                  localObject13 = localObject3;
                  localObject14 = localObject2;
                  localObject15 = paramObject;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("CardHandler", 2, "personal note = " + str);
                    i1 = i5;
                    i2 = i4;
                    localObject8 = localObject5;
                    localObject9 = localObject7;
                    localObject10 = localObject6;
                    localObject11 = localObject4;
                    localObject12 = localObject1;
                    localObject13 = localObject3;
                    localObject14 = localObject2;
                    localObject15 = paramObject;
                    break label2926;
                    localObject8 = new byte[i2];
                    localByteBuffer.get((byte[])localObject8);
                    str = new String((byte[])localObject8);
                    paramFromServiceMsg.strSchool = str;
                    i1 = i5;
                    i2 = i4;
                    localObject8 = localObject5;
                    localObject9 = localObject7;
                    localObject10 = localObject6;
                    localObject11 = localObject4;
                    localObject12 = localObject1;
                    localObject13 = localObject3;
                    localObject14 = localObject2;
                    localObject15 = paramObject;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("CardHandler", 2, "school = " + str);
                      i1 = i5;
                      i2 = i4;
                      localObject8 = localObject5;
                      localObject9 = localObject7;
                      localObject10 = localObject6;
                      localObject11 = localObject4;
                      localObject12 = localObject1;
                      localObject13 = localObject3;
                      localObject14 = localObject2;
                      localObject15 = paramObject;
                      break label2926;
                      paramFromServiceMsg.age = localByteBuffer.get();
                      paramFromServiceMsg.shAge = ((short)paramFromServiceMsg.age);
                      i1 = i5;
                      i2 = i4;
                      localObject8 = localObject5;
                      localObject9 = localObject7;
                      localObject10 = localObject6;
                      localObject11 = localObject4;
                      localObject12 = localObject1;
                      localObject13 = localObject3;
                      localObject14 = localObject2;
                      localObject15 = paramObject;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("CardHandler", 2, "age = " + paramFromServiceMsg.age);
                        i1 = i5;
                        i2 = i4;
                        localObject8 = localObject5;
                        localObject9 = localObject7;
                        localObject10 = localObject6;
                        localObject11 = localObject4;
                        localObject12 = localObject1;
                        localObject13 = localObject3;
                        localObject14 = localObject2;
                        localObject15 = paramObject;
                        break label2926;
                        paramFromServiceMsg.constellation = localByteBuffer.get();
                        i1 = i5;
                        i2 = i4;
                        localObject8 = localObject5;
                        localObject9 = localObject7;
                        localObject10 = localObject6;
                        localObject11 = localObject4;
                        localObject12 = localObject1;
                        localObject13 = localObject3;
                        localObject14 = localObject2;
                        localObject15 = paramObject;
                        if (QLog.isColorLevel())
                        {
                          QLog.d("CardHandler", 2, "constellation = " + paramFromServiceMsg.constellation);
                          i1 = i5;
                          i2 = i4;
                          localObject8 = localObject5;
                          localObject9 = localObject7;
                          localObject10 = localObject6;
                          localObject11 = localObject4;
                          localObject12 = localObject1;
                          localObject13 = localObject3;
                          localObject14 = localObject2;
                          localObject15 = paramObject;
                          break label2926;
                          i7 = localByteBuffer.getShort();
                          i8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("nearby_people_profile_ok_new", -1);
                          if (QLog.isColorLevel()) {
                            QLog.i("CardHandler", 2, "handleGetDetalInfo nearbyprofile local is :" + i8 + " server is: " + i7);
                          }
                          i1 = i5;
                          i2 = i4;
                          localObject8 = localObject5;
                          localObject9 = localObject7;
                          localObject10 = localObject6;
                          localObject11 = localObject4;
                          localObject12 = localObject1;
                          localObject13 = localObject3;
                          localObject14 = localObject2;
                          localObject15 = paramObject;
                          if (i8 != i7)
                          {
                            i1 = i5;
                            i2 = i4;
                            localObject8 = localObject5;
                            localObject9 = localObject7;
                            localObject10 = localObject6;
                            localObject11 = localObject4;
                            localObject12 = localObject1;
                            localObject13 = localObject3;
                            localObject14 = localObject2;
                            localObject15 = paramObject;
                            if (i8 != 1)
                            {
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("nearby_people_profile_ok_new", i7).commit();
                              i1 = i5;
                              i2 = i4;
                              localObject8 = localObject5;
                              localObject9 = localObject7;
                              localObject10 = localObject6;
                              localObject11 = localObject4;
                              localObject12 = localObject1;
                              localObject13 = localObject3;
                              localObject14 = localObject2;
                              localObject15 = paramObject;
                              break label2926;
                              if (i4 != 0)
                              {
                                localObject8 = new StringBuilder();
                                ((StringBuilder)localObject8).append((String)localObject4).append("-");
                                ((StringBuilder)localObject8).append((String)localObject6).append("-");
                                ((StringBuilder)localObject8).append((String)localObject7).append("-");
                                ((StringBuilder)localObject8).append((String)localObject5);
                                paramFromServiceMsg.strLocationCodes = ((StringBuilder)localObject8).toString();
                              }
                              if (i5 != 0)
                              {
                                localObject4 = new StringBuilder();
                                ((StringBuilder)localObject4).append(paramObject).append("-");
                                ((StringBuilder)localObject4).append((String)localObject2).append("-");
                                ((StringBuilder)localObject4).append((String)localObject3).append("-");
                                ((StringBuilder)localObject4).append((String)localObject1);
                                paramFromServiceMsg.strHometownCodes = ((StringBuilder)localObject4).toString();
                              }
                              localFriendsManager.a(paramFromServiceMsg);
                              if (((i4 != 0) || (i5 != 0)) && (paramToServiceMsg.extraData.getBoolean("reqFromDetailActivity"))) {
                                ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a();
                              }
                              paramToServiceMsg = paramFromServiceMsg;
                              continue;
                              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
                              {
                                i1 = paramFromServiceMsg.uint32_result.get();
                                if (QLog.isColorLevel()) {
                                  QLog.d("CardHandler", 2, "request error, ret " + i1);
                                }
                                paramToServiceMsg = null;
                                bool1 = false;
                                continue;
                              }
                              paramToServiceMsg = null;
                              continue;
                              continue;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label2926:
        i3 += 1;
        int i5 = i1;
        int i4 = i2;
        Object localObject5 = localObject8;
        Object localObject7 = localObject9;
        Object localObject6 = localObject10;
        Object localObject4 = localObject11;
        Object localObject1 = localObject12;
        Object localObject3 = localObject13;
        Object localObject2 = localObject14;
        paramObject = localObject15;
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = new ArrayList();
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespGetVisitorList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramObject = c();
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        a(7, false, new Object[] { paramBundle, paramObject });
        return;
      }
      Iterator localIterator = paramFromServiceMsg.vEncounterInfos.iterator();
      while (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.setType(1);
        paramObject.add(localCardProfile);
      }
      c(paramToServiceMsg.getUin(), paramObject);
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      a(7, true, new Object[] { paramBundle, paramObject });
      return;
    }
    paramToServiceMsg = c();
    paramBundle.putLong("startMid", -1L);
    a(7, false, new Object[] { paramBundle, paramToServiceMsg });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {}
    int i1;
    label188:
    label616:
    for (boolean bool1 = true;; bool1 = false)
    {
      i1 = -1;
      if (bool1) {}
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramObject = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          long l1 = paramObject.getInt();
          paramObject.get();
          i4 = paramObject.getShort();
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetNearbySymbol, request success, tlvCount = " + i4);
          }
          i1 = -1;
          i2 = 0;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        int i2;
        int i3;
        for (;;)
        {
          int i4;
          int i5;
          boolean bool2;
        }
      }
      try
      {
        if ((!paramObject.hasRemaining()) || (i2 >= i4)) {
          break label496;
        }
        i3 = paramObject.getShort();
        i5 = paramObject.getShort();
        switch (i3)
        {
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        break label371;
        i2 = -1111;
        break label530;
        break label188;
        i2 += 1;
        i1 = i3;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetNearbySymbol invaild type: " + i3);
      }
      paramObject.position(paramObject.position() + i5);
      i3 = i1;
      continue;
      i3 = paramObject.getShort();
      i1 = i3;
      try
      {
        i5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("nearby_people_profile_ok_new", -1);
        if (QLog.isColorLevel()) {
          QLog.i("CardHandler", 2, "handleGetNearbySymbol nearbyprofile ok local is :" + i5 + " server is: " + i1);
        }
        i3 = i1;
        if (i5 == i1) {
          continue;
        }
        i3 = i1;
        if (i5 == 1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("nearby_people_profile_ok_new", i1).commit();
        i3 = i1;
      }
      catch (Exception paramFromServiceMsg) {}
      label371:
      bool1 = false;
      i2 = i1;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "handleGetNearbySymbol", paramFromServiceMsg);
        bool2 = bool1;
        i2 = i1;
      }
      for (;;)
      {
        if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && (paramToServiceMsg.extraData.getBoolean("nearby_people_profile_ok_new")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetNearbySymbol server nearby profile get is : " + bool2 + " symbol is: " + i2 + " to notifyUI");
          }
          a(56, bool2, Integer.valueOf(i2));
        }
        return;
        for (;;)
        {
          label496:
          i2 = i1;
          bool2 = bool1;
          break;
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
            break label616;
          }
          i2 = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetNearbySymbol request error, ret " + i2);
          }
          i1 = -1;
          bool1 = false;
        }
        i2 = i1;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "handleGetNearbySymbol get not success.");
          i2 = i1;
          bool2 = bool1;
        }
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "handleReqSynPCPortrait|res.resultCode = " + paramFromServiceMsg.getResultCode());
    }
    boolean bool;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespUpdateQQFace)paramObject;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "handleReqSynPCPortrait|iReplyCode = " + paramFromServiceMsg.stHeader.iReplyCode);
      }
      if (paramFromServiceMsg.stHeader.iReplyCode == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      a(bool, paramToServiceMsg.getUin(), 0);
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  /* Error */
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 530	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +419 -> 426
    //   10: aload_3
    //   11: ifnull +415 -> 426
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 639
    //   26: iconst_2
    //   27: new 182	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1114
    //   37: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 6
    //   42: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: bipush 43
    //   57: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   60: checkcast 888	com/tencent/mobileqq/app/FriendsManager
    //   63: astore_1
    //   64: aload_1
    //   65: aload_0
    //   66: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   72: invokevirtual 889	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   75: astore_2
    //   76: iload 6
    //   78: istore 9
    //   80: iload 6
    //   82: ifeq +636 -> 718
    //   85: iload 6
    //   87: istore 7
    //   89: iload 6
    //   91: istore 8
    //   93: new 412	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: dup
    //   97: invokespecial 413	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   100: aload_3
    //   101: checkcast 531	[B
    //   104: checkcast 531	[B
    //   107: invokevirtual 535	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: checkcast 412	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +317 -> 432
    //   118: iload 6
    //   120: istore 7
    //   122: iload 6
    //   124: istore 8
    //   126: aload_3
    //   127: getfield 426	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: ifne +299 -> 432
    //   136: iconst_1
    //   137: istore 6
    //   139: iload 6
    //   141: istore 7
    //   143: iload 6
    //   145: istore 8
    //   147: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +39 -> 189
    //   153: iload 6
    //   155: istore 7
    //   157: iload 6
    //   159: istore 8
    //   161: ldc_w 639
    //   164: iconst_2
    //   165: new 182	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 1116
    //   175: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 6
    //   180: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iload 6
    //   191: istore 9
    //   193: iload 6
    //   195: ifeq +523 -> 718
    //   198: iload 6
    //   200: istore 7
    //   202: iload 6
    //   204: istore 8
    //   206: iload 6
    //   208: istore 9
    //   210: aload_3
    //   211: getfield 477	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   214: invokevirtual 1117	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   217: ifeq +501 -> 718
    //   220: iload 6
    //   222: istore 7
    //   224: iload 6
    //   226: istore 8
    //   228: iload 6
    //   230: istore 9
    //   232: aload_3
    //   233: getfield 477	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 540	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   239: ifnull +479 -> 718
    //   242: iload 6
    //   244: istore 7
    //   246: iload 6
    //   248: istore 8
    //   250: aload_3
    //   251: getfield 477	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 540	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 541	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   260: invokestatic 545	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   263: astore_3
    //   264: iload 6
    //   266: istore 7
    //   268: iload 6
    //   270: istore 8
    //   272: aload_3
    //   273: invokevirtual 974	java/nio/ByteBuffer:getInt	()I
    //   276: pop
    //   277: iload 6
    //   279: istore 7
    //   281: iload 6
    //   283: istore 8
    //   285: aload_3
    //   286: invokevirtual 548	java/nio/ByteBuffer:get	()B
    //   289: pop
    //   290: iload 6
    //   292: istore 7
    //   294: iload 6
    //   296: istore 8
    //   298: iload 6
    //   300: istore 9
    //   302: aload_3
    //   303: invokevirtual 976	java/nio/ByteBuffer:getShort	()S
    //   306: invokestatic 1120	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   309: invokevirtual 473	java/lang/Short:shortValue	()S
    //   312: iconst_1
    //   313: if_icmpne +405 -> 718
    //   316: iload 6
    //   318: istore 7
    //   320: iload 6
    //   322: istore 8
    //   324: aload_3
    //   325: invokevirtual 976	java/nio/ByteBuffer:getShort	()S
    //   328: istore 4
    //   330: iload 6
    //   332: istore 7
    //   334: iload 6
    //   336: istore 8
    //   338: aload_0
    //   339: getfield 217	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_Short	S
    //   342: istore 5
    //   344: iload 4
    //   346: iload 5
    //   348: if_icmpeq +90 -> 438
    //   351: iload 10
    //   353: istore 7
    //   355: iload 7
    //   357: istore 8
    //   359: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +48 -> 410
    //   365: ldc_w 639
    //   368: iconst_2
    //   369: new 182	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 1116
    //   379: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: iload 7
    //   384: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: ldc_w 1122
    //   390: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_2
    //   394: getfield 1125	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   397: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   400: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: iload 7
    //   408: istore 8
    //   410: aload_0
    //   411: bipush 44
    //   413: iload 8
    //   415: aload_2
    //   416: getfield 1125	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   419: invokestatic 559	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   422: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   425: return
    //   426: iconst_0
    //   427: istore 6
    //   429: goto -412 -> 17
    //   432: iconst_0
    //   433: istore 6
    //   435: goto -296 -> 139
    //   438: iload 6
    //   440: istore 7
    //   442: iload 6
    //   444: istore 8
    //   446: aload_3
    //   447: invokevirtual 976	java/nio/ByteBuffer:getShort	()S
    //   450: istore 4
    //   452: iload 10
    //   454: istore 7
    //   456: iload 4
    //   458: iconst_2
    //   459: if_icmpne -104 -> 355
    //   462: iload 6
    //   464: istore 7
    //   466: iload 6
    //   468: istore 8
    //   470: iload 4
    //   472: newarray byte
    //   474: astore 11
    //   476: iload 6
    //   478: istore 7
    //   480: iload 6
    //   482: istore 8
    //   484: aload_3
    //   485: aload 11
    //   487: invokevirtual 991	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   490: pop
    //   491: iload 6
    //   493: istore 7
    //   495: iload 6
    //   497: istore 8
    //   499: aload 11
    //   501: iconst_0
    //   502: invokestatic 1128	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   505: ifne +55 -> 560
    //   508: iconst_0
    //   509: istore 9
    //   511: iload 6
    //   513: istore 7
    //   515: iload 6
    //   517: istore 8
    //   519: aload_2
    //   520: iload 9
    //   522: putfield 1125	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   525: iload 6
    //   527: istore 7
    //   529: iload 6
    //   531: istore 8
    //   533: aload_3
    //   534: invokevirtual 976	java/nio/ByteBuffer:getShort	()S
    //   537: istore 4
    //   539: iload 10
    //   541: istore 7
    //   543: iload 4
    //   545: ifne -190 -> 355
    //   548: aload_1
    //   549: aload_2
    //   550: invokevirtual 955	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   553: pop
    //   554: iconst_1
    //   555: istore 7
    //   557: goto -202 -> 355
    //   560: iconst_1
    //   561: istore 9
    //   563: goto -52 -> 511
    //   566: astore_1
    //   567: iload 7
    //   569: istore 6
    //   571: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +14 -> 588
    //   577: ldc_w 639
    //   580: iconst_2
    //   581: ldc_w 1130
    //   584: aload_1
    //   585: invokestatic 886	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   588: iload 6
    //   590: istore 8
    //   592: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq -185 -> 410
    //   598: ldc_w 639
    //   601: iconst_2
    //   602: new 182	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 1116
    //   612: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: iload 6
    //   617: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   620: ldc_w 1122
    //   623: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload_2
    //   627: getfield 1125	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   630: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   633: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: iload 6
    //   641: istore 8
    //   643: goto -233 -> 410
    //   646: astore_1
    //   647: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +44 -> 694
    //   653: ldc_w 639
    //   656: iconst_2
    //   657: new 182	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 1116
    //   667: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: iload 8
    //   672: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: ldc_w 1122
    //   678: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_2
    //   682: getfield 1125	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   685: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   688: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: aload_1
    //   695: athrow
    //   696: astore_1
    //   697: iconst_1
    //   698: istore 8
    //   700: goto -53 -> 647
    //   703: astore_1
    //   704: iload 6
    //   706: istore 8
    //   708: goto -61 -> 647
    //   711: astore_1
    //   712: iconst_1
    //   713: istore 6
    //   715: goto -144 -> 571
    //   718: iload 9
    //   720: istore 7
    //   722: goto -367 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	CardHandler
    //   0	725	1	paramToServiceMsg	ToServiceMsg
    //   0	725	2	paramFromServiceMsg	FromServiceMsg
    //   0	725	3	paramObject	Object
    //   328	216	4	i1	int
    //   342	7	5	i2	int
    //   15	699	6	bool1	boolean
    //   87	634	7	bool2	boolean
    //   91	616	8	bool3	boolean
    //   78	641	9	bool4	boolean
    //   1	539	10	bool5	boolean
    //   474	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   93	114	566	java/lang/Exception
    //   126	136	566	java/lang/Exception
    //   147	153	566	java/lang/Exception
    //   161	189	566	java/lang/Exception
    //   210	220	566	java/lang/Exception
    //   232	242	566	java/lang/Exception
    //   250	264	566	java/lang/Exception
    //   272	277	566	java/lang/Exception
    //   285	290	566	java/lang/Exception
    //   302	316	566	java/lang/Exception
    //   324	330	566	java/lang/Exception
    //   338	344	566	java/lang/Exception
    //   446	452	566	java/lang/Exception
    //   470	476	566	java/lang/Exception
    //   484	491	566	java/lang/Exception
    //   499	508	566	java/lang/Exception
    //   519	525	566	java/lang/Exception
    //   533	539	566	java/lang/Exception
    //   93	114	646	finally
    //   126	136	646	finally
    //   147	153	646	finally
    //   161	189	646	finally
    //   210	220	646	finally
    //   232	242	646	finally
    //   250	264	646	finally
    //   272	277	646	finally
    //   285	290	646	finally
    //   302	316	646	finally
    //   324	330	646	finally
    //   338	344	646	finally
    //   446	452	646	finally
    //   470	476	646	finally
    //   484	491	646	finally
    //   499	508	646	finally
    //   519	525	646	finally
    //   533	539	646	finally
    //   548	554	696	finally
    //   571	588	703	finally
    //   548	554	711	java/lang/Exception
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespAddFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramObject = paramToServiceMsg.extraData.getByteArray("filekey");
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        Card localCard = localFriendsManagerImp.b(paramToServiceMsg.getUin());
        localCard.uin = paramToServiceMsg.getUin();
        if (paramFromServiceMsg.uFaceTimeStamp > localCard.uFaceTimeStamp)
        {
          localCard.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
          localCard.addHeadPortrait(paramObject);
        }
        localCard.iFaceNum += 1;
        localFriendsManagerImp.a(localCard);
        ProfileCardUtil.a(paramObject);
        a(11, true, new Object[] { localCard, paramBundle });
        return;
      }
      paramBundle.putInt("retCode", paramFromServiceMsg.stHeader.iReplyCode);
      a(11, false, paramBundle);
      return;
    }
    a(11, false, paramBundle);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label607;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1);
        }
        bool4 = bool1;
        if (!bool1) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        i1 = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (i1 >= 0) {
          continue;
        }
        l1 = i1 + 4294967296L;
        bool2 = bool1;
        bool3 = bool1;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        bool2 = bool1;
        bool3 = bool1;
        paramObject.allowPeopleSee = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.a(paramObject);
        bool1 = bool5;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg) {}finally
      {
        try
        {
          int i1;
          long l1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch ex", paramFromServiceMsg);
          }
          bool3 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          continue;
        }
        finally
        {
          bool3 = bool2;
        }
        paramFromServiceMsg = finally;
      }
      a(45, bool3, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l1 = i1;
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      throw paramFromServiceMsg;
      label607:
      bool1 = bool4;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    long l1 = paramToServiceMsg.extraData.getLong("uin");
    int i1 = paramToServiceMsg.extraData.getInt("timestamp");
    paramToServiceMsg = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(String.valueOf(Long.valueOf(l1)));
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespFaceInfo)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        if ((i1 != 0) && (paramFromServiceMsg.uFaceTimeStamp == paramToServiceMsg.uFaceTimeStamp)) {
          break label177;
        }
        paramToServiceMsg.iFaceNum = paramFromServiceMsg.iFaceNum;
        paramToServiceMsg.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
        paramToServiceMsg.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
      }
    }
    label177:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(paramToServiceMsg);
      a(10, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
      return;
      a(10, false, paramToServiceMsg);
      return;
      a(10, false, paramToServiceMsg);
      return;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    bool2 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      bool1 = bool2;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool4;
      }
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg != null)
      {
        bool1 = bool5;
        bool2 = bool4;
        if (paramToServiceMsg.uint32_result.get() == 0) {
          bool1 = true;
        }
        bool3 = bool1;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
          bool3 = bool1;
        }
      }
      bool1 = bool3;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.update_photo_list", 2, paramToServiceMsg.toString());
          bool1 = bool2;
        }
      }
    }
    a(46, bool1, null);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      paramToServiceMsg = (RespMakeFriendsCard)paramObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        paramBundle = paramToServiceMsg.stHeader.lUIN + "";
        paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramObject = paramFromServiceMsg.b(paramBundle);
        paramObject.uin = paramBundle;
        paramObject.strNick = paramToServiceMsg.stMakeFriendsCard.strNick;
        paramObject.shGender = paramToServiceMsg.stMakeFriendsCard.shGender;
        paramObject.shAge = paramToServiceMsg.stMakeFriendsCard.shAge;
        paramObject.nFaceID = paramToServiceMsg.stMakeFriendsCard.nFaceID;
        paramObject.strCertificationInfo = paramToServiceMsg.stMakeFriendsCard.strCertificationInfo;
        paramObject.shType = paramToServiceMsg.stMakeFriendsCard.stIntro.shType;
        paramObject.vContent = paramToServiceMsg.stMakeFriendsCard.stIntro.vContent;
        paramObject.vQQFaceID = paramToServiceMsg.stMakeFriendsCard.vQQFaceID;
        paramObject.lCardShowNum = paramToServiceMsg.lCardShowNum;
        paramObject.bSingle = paramToServiceMsg.stMakeFriendsCard.bSingle;
        paramObject.lVisitCount = paramToServiceMsg.stMakeFriendsCard.lVisitCount;
        if (paramToServiceMsg.stMakeFriendsCard.lVoteCount > paramObject.lVoteCount) {
          paramObject.lVoteCount = paramToServiceMsg.stMakeFriendsCard.lVoteCount;
        }
        if ((i1 == 0) || (paramToServiceMsg.stMakeFriendsCard.uFaceTimeStamp > paramObject.uFaceTimeStamp))
        {
          paramObject.uFaceTimeStamp = paramToServiceMsg.stMakeFriendsCard.uFaceTimeStamp;
          paramObject.setStrJoinHexAlbumFileKey(a(paramToServiceMsg.vFaceInfo));
        }
        paramObject.iVoteIncrement += paramToServiceMsg.iVoteIncrement;
        paramBundle = paramToServiceMsg.stMakeFriendsCard.vTags;
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBundle);
          paramObject.setTagInfosByte(paramBundle);
        }
        paramObject.eUserIdentityType = ((byte)paramToServiceMsg.stMakeFriendsCard.eUserIdentityType);
        paramObject.vBackground = paramToServiceMsg.stMakeFriendsCard.vBackground;
        paramObject.iFaceNum = paramToServiceMsg.stMakeFriendsCard.iFaceNum;
        paramObject.cSqqLevel = paramToServiceMsg.cSqqLevel;
        paramFromServiceMsg.a(paramObject);
        paramFromServiceMsg.a(paramObject.uin, (short)paramObject.nFaceID, paramObject.strNick, paramObject.strSign);
        a(1, true, paramObject);
        return;
      }
      if ((3 == paramToServiceMsg.stHeader.iReplyCode) || (56 == paramToServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.handleImportQzonePhotoes(), FromServiceMsg isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    paramToServiceMsg = null;
    localToServiceMsg = paramToServiceMsg;
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      localToServiceMsg = paramToServiceMsg;
      bool1 = bool2;
      if (paramObject != null)
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg = localObject;
        bool2 = bool4;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      bool3 = bool6;
      if (paramFromServiceMsg == null) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool4;
      bool3 = bool6;
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label409;
      }
      bool1 = bool5;
      paramToServiceMsg = localObject;
      bool2 = bool4;
      if (paramFromServiceMsg.uint32_result.get() == 0) {
        bool1 = true;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = localObject;
        bool2 = bool1;
        QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "oidbPkg.uint32_result = " + paramFromServiceMsg.uint32_result.get());
      }
      bool3 = bool1;
      if (!bool1) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramObject = (UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramFromServiceMsg = new Object[5];
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[0] = paramObject.rpt_msg_headinfo.get();
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[1] = Integer.valueOf(paramObject.uint32_import_state.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[2] = Integer.valueOf(paramObject.uint32_import_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[3] = Integer.valueOf(paramObject.uint32_import_rest_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[4] = Integer.valueOf(paramObject.uint32_rest_count_in_qzone.get());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        boolean bool3;
        localToServiceMsg = paramToServiceMsg;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramFromServiceMsg.toString());
          localToServiceMsg = paramToServiceMsg;
          bool1 = bool2;
          continue;
          paramToServiceMsg = null;
          bool1 = bool3;
        }
      }
    }
    localToServiceMsg = paramToServiceMsg;
    a(48, bool1, localToServiceMsg);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespGetCardSwitch)paramObject;
      long l1 = paramFromServiceMsg.uCloseNeighborVote;
      long l2 = paramFromServiceMsg.uCloseTimeGateVote;
      paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      paramObject = paramFromServiceMsg.b(paramToServiceMsg.getUin());
      if (l1 == 0L)
      {
        bool = true;
        paramObject.setZanShowFlag(bool);
        paramFromServiceMsg.a(paramObject);
        paramFromServiceMsg = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131363068) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (l2 != 0L) {
          break label194;
        }
      }
      label194:
      for (boolean bool = true;; bool = false)
      {
        paramFromServiceMsg.putBoolean(paramObject, bool).commit();
        paramBundle.putLong("uCloseNeighborVote", l1);
        paramBundle.putLong("uColseTimeEntityManager", l2);
        paramBundle.putString("uin", paramToServiceMsg.getUin());
        a(33, true, paramBundle);
        return;
        bool = false;
        break;
      }
    }
    paramBundle.putString("uin", paramToServiceMsg.getUin());
    a(33, false, paramBundle);
  }
  
  /* Error */
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 4
    //   12: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +33 -> 48
    //   18: ldc_w 1353
    //   21: iconst_2
    //   22: new 182	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 1355
    //   32: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 530	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   39: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 11
    //   54: aload 11
    //   56: astore_1
    //   57: iload 8
    //   59: istore 7
    //   61: aload_2
    //   62: invokevirtual 530	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   65: ifeq +392 -> 457
    //   68: aload 11
    //   70: astore_1
    //   71: iload 8
    //   73: istore 7
    //   75: aload_3
    //   76: ifnull +381 -> 457
    //   79: new 412	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 413	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 531	[B
    //   92: checkcast 531	[B
    //   95: invokevirtual 535	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 412	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +422 -> 525
    //   106: aload_1
    //   107: getfield 426	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 799	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   113: ifeq +412 -> 525
    //   116: aload_1
    //   117: getfield 426	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   123: istore 5
    //   125: iload 5
    //   127: ifne +406 -> 533
    //   130: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +36 -> 169
    //   136: ldc_w 1353
    //   139: iconst_2
    //   140: new 182	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1357
    //   150: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 426	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 6
    //   171: ifeq +349 -> 520
    //   174: new 1295	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   177: dup
    //   178: invokespecial 1296	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:<init>	()V
    //   181: aload_1
    //   182: getfield 477	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 540	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 541	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokevirtual 1297	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   194: checkcast 1295	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   197: astore_2
    //   198: iconst_5
    //   199: anewarray 751	java/lang/Object
    //   202: astore_1
    //   203: aload_1
    //   204: iconst_0
    //   205: aload_2
    //   206: getfield 1301	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:rpt_msg_headinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: invokevirtual 1306	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   212: aastore
    //   213: aload_1
    //   214: iconst_1
    //   215: aload_2
    //   216: getfield 1309	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload_1
    //   227: iconst_2
    //   228: aload_2
    //   229: getfield 1312	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   235: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: aload_1
    //   240: iconst_3
    //   241: aload_2
    //   242: getfield 1315	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_rest_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   245: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   248: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: aload_1
    //   253: iconst_4
    //   254: aload_2
    //   255: getfield 1318	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_rest_count_in_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +185 -> 453
    //   271: new 182	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc_w 1359
    //   283: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: iconst_0
    //   289: aaload
    //   290: ifnull +102 -> 392
    //   293: aload_1
    //   294: iconst_0
    //   295: aaload
    //   296: checkcast 290	java/util/List
    //   299: astore_3
    //   300: iload 4
    //   302: aload_3
    //   303: invokeinterface 291 1 0
    //   308: if_icmpge +84 -> 392
    //   311: aload_3
    //   312: iload 4
    //   314: invokeinterface 295 2 0
    //   319: checkcast 1361	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo
    //   322: astore 10
    //   324: aload_2
    //   325: ldc_w 1363
    //   328: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 10
    //   333: getfield 1366	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_headid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 1368
    //   345: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 10
    //   350: getfield 1372	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:str_headurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 1376	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 1378
    //   362: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 10
    //   367: getfield 1381	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_is_curhead	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 1383
    //   379: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 4
    //   385: iconst_1
    //   386: iadd
    //   387: istore 4
    //   389: goto -89 -> 300
    //   392: aload_2
    //   393: ldc_w 1385
    //   396: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: iconst_1
    //   401: aaload
    //   402: invokevirtual 779	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 1387
    //   408: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: iconst_2
    //   413: aaload
    //   414: invokevirtual 779	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 1389
    //   420: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: iconst_3
    //   425: aaload
    //   426: invokevirtual 779	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: ldc_w 1391
    //   432: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: iconst_4
    //   437: aaload
    //   438: invokevirtual 779	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 1353
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iload 6
    //   455: istore 7
    //   457: aload_0
    //   458: bipush 50
    //   460: iload 7
    //   462: aload_1
    //   463: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   466: return
    //   467: astore_2
    //   468: iload 9
    //   470: istore 6
    //   472: aload 10
    //   474: astore_3
    //   475: aload_3
    //   476: astore_1
    //   477: iload 6
    //   479: istore 7
    //   481: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq -27 -> 457
    //   487: ldc_w 1353
    //   490: iconst_2
    //   491: aload_2
    //   492: invokevirtual 1196	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   495: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_3
    //   499: astore_1
    //   500: iload 6
    //   502: istore 7
    //   504: goto -47 -> 457
    //   507: astore_2
    //   508: aload 10
    //   510: astore_3
    //   511: goto -36 -> 475
    //   514: astore_2
    //   515: aload_1
    //   516: astore_3
    //   517: goto -42 -> 475
    //   520: aconst_null
    //   521: astore_1
    //   522: goto -69 -> 453
    //   525: aconst_null
    //   526: astore_1
    //   527: iconst_0
    //   528: istore 6
    //   530: goto -77 -> 453
    //   533: iconst_0
    //   534: istore 6
    //   536: goto -406 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	CardHandler
    //   0	539	1	paramToServiceMsg	ToServiceMsg
    //   0	539	2	paramFromServiceMsg	FromServiceMsg
    //   0	539	3	paramObject	Object
    //   10	378	4	i1	int
    //   123	3	5	i2	int
    //   1	534	6	bool1	boolean
    //   59	444	7	bool2	boolean
    //   4	68	8	bool3	boolean
    //   7	462	9	bool4	boolean
    //   49	460	10	localHeadInfo	tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo
    //   52	17	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   87	102	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	125	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	169	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	203	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	287	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   293	300	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	383	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   392	453	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespSetCardSwitch)paramObject;
      if (bool2)
      {
        l1 = paramFromServiceMsg.uCloseNeighborVote;
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
        paramObject = paramFromServiceMsg.b(paramToServiceMsg.getUin());
        if (l1 == 0L)
        {
          bool1 = true;
          paramObject.setZanShowFlag(bool1);
          paramFromServiceMsg.a(paramObject);
          if (l1 != 0L) {
            break label150;
          }
        }
        label150:
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.putBoolean("modify_switch_for_near_people", bool2);
          paramBundle.putBoolean("target_switch", bool1);
          paramBundle.putString("uin", paramToServiceMsg.getUin());
          a(34, true, paramBundle);
          return;
          bool1 = false;
          break;
        }
      }
      if (paramFromServiceMsg.uCloseTimeGateVote == 0L) {}
      for (bool1 = true;; bool1 = false)
      {
        localSharedPreferences.edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131363068) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), bool1).commit();
        break;
      }
    }
    long l1 = paramToServiceMsg.extraData.getLong("target_value");
    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (l1 == 0L)
    {
      bool1 = true;
      label260:
      if (paramFromServiceMsg.a(bool2, bool1)) {
        break label362;
      }
      if (!bool2) {
        break label370;
      }
      paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      paramObject = paramFromServiceMsg.b(paramToServiceMsg.getUin());
      if (l1 != 0L) {
        break label364;
      }
      bool1 = true;
      label308:
      paramObject.setZanShowFlag(bool1);
      paramFromServiceMsg.a(paramObject);
    }
    label362:
    label364:
    label370:
    for (boolean bool1 = paramObject.isShowZan();; bool1 = localSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131363068) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false))
    {
      paramBundle.putString("uin", paramToServiceMsg.getUin());
      paramBundle.putBoolean("current_switch", bool1);
      a(34, false, paramBundle);
      return;
      bool1 = false;
      break label260;
      break;
      bool1 = false;
      break label308;
    }
  }
  
  /* Error */
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1412
    //   7: invokevirtual 836	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   10: istore 5
    //   12: aload 4
    //   14: ldc_w 1412
    //   17: iload 5
    //   19: invokevirtual 1155	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   22: aload 4
    //   24: ldc_w 1414
    //   27: aload_1
    //   28: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 1414
    //   34: invokevirtual 826	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   37: invokevirtual 1418	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   40: aload 4
    //   42: ldc_w 1419
    //   45: aload_1
    //   46: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   49: ldc_w 1419
    //   52: invokevirtual 816	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   55: invokevirtual 745	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   58: aload 4
    //   60: ldc_w 1421
    //   63: aload_1
    //   64: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   67: ldc_w 1421
    //   70: invokevirtual 816	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   73: invokevirtual 745	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   76: iload 5
    //   78: tableswitch	default:+30 -> 108, 0:+141->219, 1:+148->226, 2:+155->233, 3:+162->240
    //   109: istore 5
    //   111: bipush 26
    //   113: iload 5
    //   115: if_icmpne +21 -> 136
    //   118: aload_0
    //   119: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: invokevirtual 594	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   125: aload_0
    //   126: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   132: aconst_null
    //   133: invokestatic 1423	com/tencent/mobileqq/app/CardHandler:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_0
    //   137: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   140: bipush 43
    //   142: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   145: checkcast 888	com/tencent/mobileqq/app/FriendsManager
    //   148: astore 4
    //   150: aload_2
    //   151: invokevirtual 530	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   154: ifeq +623 -> 777
    //   157: bipush 26
    //   159: iload 5
    //   161: if_icmpne +86 -> 247
    //   164: aload 4
    //   166: aload_1
    //   167: invokevirtual 709	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   170: invokevirtual 1424	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   173: astore_3
    //   174: aload_3
    //   175: astore_2
    //   176: aload_3
    //   177: ifnull +549 -> 726
    //   180: aload_3
    //   181: aload_1
    //   182: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   185: ldc_w 1419
    //   188: invokevirtual 816	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   191: putfield 1276	com/tencent/mobileqq/data/Card:vBackground	[B
    //   194: aload 4
    //   196: aload_3
    //   197: invokevirtual 955	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   200: pop
    //   201: aload_3
    //   202: astore_1
    //   203: iload 5
    //   205: bipush 41
    //   207: if_icmpeq +11 -> 218
    //   210: aload_0
    //   211: iload 5
    //   213: iconst_1
    //   214: aload_1
    //   215: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   218: return
    //   219: bipush 24
    //   221: istore 5
    //   223: goto -112 -> 111
    //   226: bipush 25
    //   228: istore 5
    //   230: goto -119 -> 111
    //   233: bipush 26
    //   235: istore 5
    //   237: goto -126 -> 111
    //   240: bipush 41
    //   242: istore 5
    //   244: goto -133 -> 111
    //   247: iload 5
    //   249: bipush 25
    //   251: if_icmpne +89 -> 340
    //   254: new 1426	java/io/ObjectInputStream
    //   257: dup
    //   258: new 1428	java/io/ByteArrayInputStream
    //   261: dup
    //   262: aload_1
    //   263: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   266: ldc_w 1430
    //   269: invokevirtual 816	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   272: invokespecial 1431	java/io/ByteArrayInputStream:<init>	([B)V
    //   275: invokespecial 1434	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   278: invokevirtual 1437	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   281: checkcast 685	java/util/ArrayList
    //   284: astore_2
    //   285: aload 4
    //   287: aload_0
    //   288: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   291: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   294: invokevirtual 1424	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   297: astore_1
    //   298: aload_1
    //   299: ifnull +28 -> 327
    //   302: aload_2
    //   303: ifnull +24 -> 327
    //   306: aload_0
    //   307: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   310: aload_2
    //   311: invokevirtual 1263	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/util/ArrayList;)V
    //   314: aload_1
    //   315: aload_2
    //   316: invokevirtual 1267	com/tencent/mobileqq/data/Card:setTagInfosByte	(Ljava/lang/Object;)[B
    //   319: pop
    //   320: aload 4
    //   322: aload_1
    //   323: invokevirtual 955	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   326: pop
    //   327: goto -124 -> 203
    //   330: astore_2
    //   331: aconst_null
    //   332: astore_1
    //   333: aload_2
    //   334: invokevirtual 1440	java/lang/Exception:printStackTrace	()V
    //   337: goto -134 -> 203
    //   340: iload 5
    //   342: bipush 24
    //   344: if_icmpne +52 -> 396
    //   347: aload_0
    //   348: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   351: bipush 8
    //   353: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   356: checkcast 391	com/tencent/mobileqq/app/FriendsManagerImp
    //   359: astore_2
    //   360: aload_2
    //   361: aload_0
    //   362: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   365: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   368: aload_1
    //   369: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   372: ldc_w 1414
    //   375: invokevirtual 826	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   378: invokevirtual 1442	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;B)V
    //   381: aload_2
    //   382: aload_0
    //   383: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   386: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   389: invokevirtual 394	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   392: astore_1
    //   393: goto -190 -> 203
    //   396: iload 5
    //   398: bipush 41
    //   400: if_icmpne +413 -> 813
    //   403: aload_2
    //   404: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   407: sipush 1000
    //   410: if_icmpne +321 -> 731
    //   413: aload_3
    //   414: instanceof 1444
    //   417: ifeq +314 -> 731
    //   420: iconst_1
    //   421: istore 6
    //   423: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +41 -> 467
    //   429: ldc_w 1446
    //   432: iconst_2
    //   433: new 182	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 1448
    //   443: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: iload 6
    //   448: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   451: ldc_w 1450
    //   454: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_3
    //   458: invokevirtual 779	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: aload_3
    //   468: ifnull +338 -> 806
    //   471: iload 6
    //   473: ifeq +333 -> 806
    //   476: aload_3
    //   477: checkcast 1444	QQService/RespSetCard
    //   480: astore_1
    //   481: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +37 -> 521
    //   487: aload_1
    //   488: ifnull +33 -> 521
    //   491: ldc_w 1446
    //   494: iconst_2
    //   495: new 182	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 1452
    //   505: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_1
    //   509: invokevirtual 1453	QQService/RespSetCard:toString	()Ljava/lang/String;
    //   512: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aload_1
    //   522: getfield 1454	QQService/RespSetCard:stHeader	LQQService/RespHead;
    //   525: ifnull +281 -> 806
    //   528: aload_1
    //   529: getfield 1454	QQService/RespSetCard:stHeader	LQQService/RespHead;
    //   532: getfield 374	QQService/RespHead:iReplyCode	I
    //   535: ifne +271 -> 806
    //   538: aload_1
    //   539: getfield 1457	QQService/RespSetCard:vRespSetTemplate	[B
    //   542: ifnull +264 -> 806
    //   545: aload_0
    //   546: aload_1
    //   547: getfield 1457	QQService/RespSetCard:vRespSetTemplate	[B
    //   550: ldc_w 1459
    //   553: new 1461	SummaryCardTaf/SSummaryCardRsp
    //   556: dup
    //   557: invokespecial 1462	SummaryCardTaf/SSummaryCardRsp:<init>	()V
    //   560: invokevirtual 1465	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   563: checkcast 1461	SummaryCardTaf/SSummaryCardRsp
    //   566: astore_2
    //   567: aload_2
    //   568: ifnull +238 -> 806
    //   571: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +33 -> 607
    //   577: ldc_w 1446
    //   580: iconst_2
    //   581: new 182	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 1467
    //   591: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_2
    //   595: getfield 1470	SummaryCardTaf/SSummaryCardRsp:res	I
    //   598: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: aload_2
    //   608: getfield 1470	SummaryCardTaf/SSummaryCardRsp:res	I
    //   611: ifne +126 -> 737
    //   614: aload 4
    //   616: aload_0
    //   617: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   620: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   623: invokevirtual 1424	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   626: astore_1
    //   627: aload_1
    //   628: ifnull +173 -> 801
    //   631: aload_1
    //   632: aload_2
    //   633: getfield 1473	SummaryCardTaf/SSummaryCardRsp:styleid	J
    //   636: putfield 1476	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   639: aload_1
    //   640: aload_2
    //   641: getfield 1479	SummaryCardTaf/SSummaryCardRsp:bgurl	Ljava/lang/String;
    //   644: putfield 1482	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   647: aload_1
    //   648: aload_2
    //   649: getfield 1485	SummaryCardTaf/SSummaryCardRsp:bgid	J
    //   652: putfield 1488	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   655: aload_1
    //   656: aload_2
    //   657: getfield 1491	SummaryCardTaf/SSummaryCardRsp:color	J
    //   660: putfield 1494	com/tencent/mobileqq/data/Card:backgroundColor	J
    //   663: aload_1
    //   664: iconst_0
    //   665: putfield 1497	com/tencent/mobileqq/data/Card:templateRet	I
    //   668: aload 4
    //   670: aload_1
    //   671: invokevirtual 955	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   674: pop
    //   675: aload_0
    //   676: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   679: invokevirtual 1052	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   682: astore_2
    //   683: aload_2
    //   684: ifnull +24 -> 708
    //   687: aload_2
    //   688: invokeinterface 322 1 0
    //   693: ldc_w 1499
    //   696: iconst_0
    //   697: invokeinterface 1348 3 0
    //   702: invokeinterface 332 1 0
    //   707: pop
    //   708: aconst_null
    //   709: astore_2
    //   710: aload_1
    //   711: ifnull +5 -> 716
    //   714: aload_1
    //   715: astore_2
    //   716: aload_0
    //   717: iload 5
    //   719: iconst_1
    //   720: aload_2
    //   721: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   724: aload_1
    //   725: astore_2
    //   726: aload_2
    //   727: astore_1
    //   728: goto -525 -> 203
    //   731: iconst_0
    //   732: istore 6
    //   734: goto -311 -> 423
    //   737: ldc_w 266
    //   740: astore_1
    //   741: aload_2
    //   742: getfield 1502	SummaryCardTaf/SSummaryCardRsp:emsg	Ljava/lang/String;
    //   745: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   748: ifne +8 -> 756
    //   751: aload_2
    //   752: getfield 1502	SummaryCardTaf/SSummaryCardRsp:emsg	Ljava/lang/String;
    //   755: astore_1
    //   756: new 1504	android/util/Pair
    //   759: dup
    //   760: aload_2
    //   761: getfield 1470	SummaryCardTaf/SSummaryCardRsp:res	I
    //   764: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   767: aload_1
    //   768: invokespecial 1507	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   771: astore_2
    //   772: aconst_null
    //   773: astore_1
    //   774: goto -64 -> 710
    //   777: aload_0
    //   778: iload 5
    //   780: iconst_0
    //   781: aload 4
    //   783: aload_0
    //   784: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   787: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   790: invokevirtual 889	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   793: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   796: return
    //   797: astore_2
    //   798: goto -465 -> 333
    //   801: aconst_null
    //   802: astore_2
    //   803: goto -93 -> 710
    //   806: aconst_null
    //   807: astore_2
    //   808: aconst_null
    //   809: astore_1
    //   810: goto -100 -> 710
    //   813: aconst_null
    //   814: astore_1
    //   815: goto -612 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	this	CardHandler
    //   0	818	1	paramToServiceMsg	ToServiceMsg
    //   0	818	2	paramFromServiceMsg	FromServiceMsg
    //   0	818	3	paramObject	Object
    //   0	818	4	paramBundle	Bundle
    //   10	769	5	i1	int
    //   421	312	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   254	298	330	java/lang/Exception
    //   306	327	797	java/lang/Exception
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel success : " + bool + ", data : " + paramObject);
      }
      if ((!bool) || (paramObject == null)) {
        break label210;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
        paramBundle = paramFromServiceMsg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        paramBundle.setLabelList(paramToServiceMsg.likes.label);
        paramFromServiceMsg.a(paramBundle);
      }
      a(52, true, paramObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    a(52, false, paramObject);
    return;
    label210:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    a(52, false, paramObject);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    Card localCard;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike success : " + bool + ", data : " + paramObject);
      }
      paramBundle = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      localCard = paramBundle.b(String.valueOf(paramToServiceMsg.extraData.getLong("destUin")));
      long l1 = paramToServiceMsg.extraData.getLong("labelId");
      if ((!bool) || (paramObject == null)) {
        break label254;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        localCard.setLabelList(paramToServiceMsg.likes.label);
        paramBundle.a(localCard);
      }
      a(53, true, new Object[] { localCard, Long.valueOf(Long.valueOf(l1).longValue()) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    a(53, false, localCard);
    return;
    label254:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    a(53, false, localCard);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYMakeFriendsCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
        paramBundle = paramToServiceMsg.b(paramObject);
        paramBundle.uin = paramObject;
        paramBundle.strNick = paramFromServiceMsg.stMakeFriendsCard.strNick;
        paramBundle.shGender = paramFromServiceMsg.stMakeFriendsCard.shGender;
        paramBundle.shAge = paramFromServiceMsg.stMakeFriendsCard.shAge;
        paramBundle.nFaceID = paramFromServiceMsg.stMakeFriendsCard.nFaceID;
        paramBundle.strCertificationInfo = paramFromServiceMsg.stMakeFriendsCard.strCertificationInfo;
        paramBundle.shType = paramFromServiceMsg.stMakeFriendsCard.stIntro.shType;
        paramBundle.vContent = paramFromServiceMsg.stMakeFriendsCard.stIntro.vContent;
        paramBundle.vQQFaceID = paramFromServiceMsg.stMakeFriendsCard.vQQFaceID;
        paramBundle.bWeiboInfo = paramFromServiceMsg.bWeiboInfo;
        paramBundle.bQzoneInfo = paramFromServiceMsg.bQzoneInfo;
        paramBundle.nSameFriendsNum = paramFromServiceMsg.nSameFriendsNum;
        paramBundle.strCompanySame = paramFromServiceMsg.strCompany;
        paramBundle.strSchoolSame = paramFromServiceMsg.strSchool;
        paramBundle.bSingle = paramFromServiceMsg.stMakeFriendsCard.bSingle;
        paramBundle.lVisitCount = paramFromServiceMsg.stMakeFriendsCard.lVisitCount;
        if ((i1 == 0) || (paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp > paramBundle.uFaceTimeStamp))
        {
          paramBundle.uFaceTimeStamp = paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp;
          paramBundle.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
        }
        if (paramFromServiceMsg.stMakeFriendsCard.lVoteCount > paramBundle.lVoteCount) {
          paramBundle.lVoteCount = paramFromServiceMsg.stMakeFriendsCard.lVoteCount;
        }
        paramObject = paramFromServiceMsg.stMakeFriendsCard.vTags;
        if ((paramObject != null) && (paramObject.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramObject);
          paramBundle.setTagInfosByte(paramObject);
        }
        paramBundle.eUserIdentityType = ((byte)paramFromServiceMsg.stMakeFriendsCard.eUserIdentityType);
        paramBundle.vBackground = paramFromServiceMsg.stMakeFriendsCard.vBackground;
        paramBundle.bVoted = paramFromServiceMsg.bVoted;
        paramBundle.iFaceNum = paramFromServiceMsg.stMakeFriendsCard.iFaceNum;
        paramBundle.cSqqLevel = paramFromServiceMsg.cSqqLevel;
        paramBundle.iQQLevel = paramFromServiceMsg.stMakeFriendsCard.iQQLevel;
        paramToServiceMsg.a(paramBundle);
        paramToServiceMsg.a(paramBundle.uin, (short)paramBundle.nFaceID, paramBundle.strNick, paramBundle.strSign);
        a(1, true, paramBundle);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYCommonCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
        paramBundle = paramToServiceMsg.b(paramObject);
        paramBundle.uin = paramObject;
        paramBundle.iQQLevel = paramFromServiceMsg.stCommonCard.iQQLevel;
        paramBundle.strNick = paramFromServiceMsg.stCommonCard.strNick;
        paramBundle.shGender = paramFromServiceMsg.stCommonCard.shGender;
        paramBundle.shAge = paramFromServiceMsg.stCommonCard.shAge;
        paramBundle.nFaceID = paramFromServiceMsg.stCommonCard.nFaceID;
        paramBundle.strSign = paramFromServiceMsg.stCommonCard.strSign;
        paramBundle.strCompany = paramFromServiceMsg.stCommonCard.strCompany;
        paramBundle.strSchool = paramFromServiceMsg.stCommonCard.strSchool;
        paramBundle.strReMark = paramFromServiceMsg.strReMark;
        paramBundle.bWeiboInfo = paramFromServiceMsg.bWeiboInfo;
        paramBundle.bQzoneInfo = paramFromServiceMsg.bQzoneInfo;
        paramBundle.bSingle = paramFromServiceMsg.stCommonCard.bSingle;
        paramBundle.lVisitCount = paramFromServiceMsg.stCommonCard.lVisitCount;
        if (paramFromServiceMsg.stCommonCard.lVoteCount > paramBundle.lVoteCount) {
          paramBundle.lVoteCount = paramFromServiceMsg.stCommonCard.lVoteCount;
        }
        if ((i1 == 0) || (paramFromServiceMsg.stCommonCard.uFaceTimeStamp > paramBundle.uFaceTimeStamp))
        {
          paramBundle.uFaceTimeStamp = paramFromServiceMsg.stCommonCard.uFaceTimeStamp;
          paramBundle.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
        }
        paramObject = paramFromServiceMsg.stCommonCard.vTags;
        if ((paramObject != null) && (paramObject.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramObject);
          paramBundle.setTagInfosByte(paramObject);
        }
        paramBundle.eUserIdentityType = ((byte)paramFromServiceMsg.stCommonCard.eUserIdentityType);
        paramBundle.vBackground = paramFromServiceMsg.stCommonCard.vBackground;
        paramBundle.bVoted = paramFromServiceMsg.bVoted;
        paramBundle.iFaceNum = paramFromServiceMsg.stCommonCard.iFaceNum;
        paramBundle.cSqqLevel = paramFromServiceMsg.cSqqLevel;
        paramToServiceMsg.a(paramBundle);
        paramToServiceMsg.b(paramBundle.uin, paramBundle.strReMark);
        paramToServiceMsg.a(paramBundle.uin, (short)paramBundle.nFaceID, paramBundle.strNick, paramBundle.strSign);
        a(1, true, paramBundle);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramFromServiceMsg = (RespCommonCard)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramBundle = paramFromServiceMsg.stHeader.lUIN + "";
        int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
        paramObject = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramToServiceMsg = paramObject.b(paramToServiceMsg.getUin());
        paramToServiceMsg.uin = paramBundle;
        paramToServiceMsg.iQQLevel = paramFromServiceMsg.stCommonCard.iQQLevel;
        paramToServiceMsg.strNick = paramFromServiceMsg.stCommonCard.strNick;
        paramToServiceMsg.shGender = paramFromServiceMsg.stCommonCard.shGender;
        paramToServiceMsg.shAge = paramFromServiceMsg.stCommonCard.shAge;
        paramToServiceMsg.nFaceID = paramFromServiceMsg.stCommonCard.nFaceID;
        paramToServiceMsg.strSign = paramFromServiceMsg.stCommonCard.strSign;
        paramToServiceMsg.strCompany = paramFromServiceMsg.stCommonCard.strCompany;
        paramToServiceMsg.strSchool = paramFromServiceMsg.stCommonCard.strSchool;
        paramToServiceMsg.vQQFaceID = paramFromServiceMsg.vQQFaceID;
        paramToServiceMsg.bSingle = paramFromServiceMsg.stCommonCard.bSingle;
        paramToServiceMsg.lVisitCount = paramFromServiceMsg.stCommonCard.lVisitCount;
        if (paramFromServiceMsg.stCommonCard.lVoteCount > paramToServiceMsg.lVoteCount) {
          paramToServiceMsg.lVoteCount = paramFromServiceMsg.stCommonCard.lVoteCount;
        }
        if ((i1 == 0) || (paramFromServiceMsg.stCommonCard.uFaceTimeStamp > paramToServiceMsg.uFaceTimeStamp))
        {
          paramToServiceMsg.uFaceTimeStamp = paramFromServiceMsg.stCommonCard.uFaceTimeStamp;
          paramToServiceMsg.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
        }
        paramToServiceMsg.iVoteIncrement += paramFromServiceMsg.iVoteIncrement;
        paramBundle = paramFromServiceMsg.stCommonCard.vTags;
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBundle);
          paramToServiceMsg.setTagInfosByte(paramBundle);
        }
        paramToServiceMsg.eUserIdentityType = ((byte)paramFromServiceMsg.stCommonCard.eUserIdentityType);
        paramToServiceMsg.vBackground = paramFromServiceMsg.stCommonCard.vBackground;
        paramToServiceMsg.iFaceNum = paramFromServiceMsg.stCommonCard.iFaceNum;
        paramToServiceMsg.cSqqLevel = paramFromServiceMsg.cSqqLevel;
        paramObject.a(paramToServiceMsg.uin, (short)paramToServiceMsg.nFaceID, paramToServiceMsg.strNick, paramToServiceMsg.strSign);
        paramFromServiceMsg = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.a(paramToServiceMsg.uin) != null)) {
          paramFromServiceMsg.e();
        }
        a(1, true, paramToServiceMsg);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() , resp.getResultCode() = " + paramFromServiceMsg.getResultCode());
    }
    long l1 = paramToServiceMsg.extraData.getLong("pttcenter_targetuin");
    int i2 = paramToServiceMsg.extraData.getInt("pttcenter_voice_optype");
    int i1 = 9006;
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    boolean bool1;
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespVoiceManage)))
    {
      bool1 = true;
      if (!bool1) {}
    }
    else
    {
      try
      {
        localRespHead = (SummaryCard.RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new SummaryCard.RespHead());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder().append("handleVoiceManager() respHead.iResult = ");
          if (localRespHead == null) {
            break label501;
          }
          paramBundle = Integer.valueOf(localRespHead.iResult);
          label160:
          QLog.d("Q.profilecard.SummaryCard", 2, paramBundle);
        }
        if (localRespHead != null) {
          break label507;
        }
        bool1 = false;
        i1 = 9045;
        localStringBuilder1.append("|wupbuf: ").append(HexUtil.a(paramFromServiceMsg.getWupBuffer()));
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          SummaryCard.RespHead localRespHead;
          label209:
          short s1;
          label377:
          boolean bool2;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.SummaryCard", 2, paramBundle.toString());
          }
          bool1 = false;
          i1 = 9045;
          localStringBuilder1.append("|exception: ").append(paramBundle.toString()).append("|wufbuf: ").append(HexUtil.a(paramFromServiceMsg.getWupBuffer()));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() lUin = " + l1 + ", eOptype = " + i2 + ", success = " + bool1);
      }
      if (!bool1) {
        break label741;
      }
      paramBundle = (RespVoiceManage)paramObject;
      if (l1 > 0L)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
        paramObject = paramFromServiceMsg.b(String.valueOf(l1));
        if (paramBundle.eOpType != 1) {
          break label650;
        }
        paramBundle = paramToServiceMsg.extraData.getString("pttcenter_filekey");
        s1 = paramToServiceMsg.extraData.getShort("pttcenter_shDuration");
        paramObject.strVoiceFilekey = paramBundle;
        paramObject.shDuration = s1;
        paramObject.bRead = 0;
        paramObject.strUrl = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "上传成功");
        }
        bool2 = paramFromServiceMsg.a(paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "更新结果  bRet = " + bool2);
        }
        a(35, true, new Object[] { String.valueOf(l1), Integer.valueOf(i2), paramObject });
      }
    }
    for (;;)
    {
      if (i2 == 1) {
        ProfileCardUtil.a(String.valueOf(l1), 0, bool1, paramToServiceMsg.extraData.getString("pttcenter_filekey"), "0", ProfileCardUtil.a(), 0, i1, 0L, localStringBuilder1.toString(), "");
      }
      return;
      bool1 = false;
      break;
      label501:
      paramBundle = null;
      break label160;
      label507:
      if (localRespHead.iResult != 0)
      {
        localStringBuilder1.append("|iResult: ").append(localRespHead.iResult);
        bool1 = false;
        i1 = 9007;
        break label209;
      }
      bool1 = true;
      break label209;
      i1 = 9311;
      localStringBuilder1.append("|resultcode: ").append(paramFromServiceMsg.getResultCode()).append("|reason: ").append(MessageHandler.a(paramFromServiceMsg));
      break label209;
      label650:
      if (paramBundle.eOpType == 2)
      {
        paramObject.strVoiceFilekey = "";
        paramObject.shDuration = 0;
        paramObject.bRead = 0;
        paramObject.strUrl = null;
        if (!QLog.isColorLevel()) {
          break label377;
        }
        QLog.d("Q.profilecard.SummaryCard", 2, "删除成功");
        break label377;
      }
      if (paramBundle.eOpType != 3) {
        break label377;
      }
      if (paramObject.bRead != 1) {
        paramObject.bRead = 1;
      }
      if (!QLog.isColorLevel()) {
        break label377;
      }
      QLog.d("Q.profilecard.SummaryCard", 2, "已读标识设置成功");
      break label377;
      label741:
      a(35, false, new Object[] { String.valueOf(l1), Integer.valueOf(i2), null });
    }
  }
  
  /* Error */
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc_w 1638
    //   9: iconst_2
    //   10: new 182	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1718
    //   20: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   27: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: invokestatic 763	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   39: ifeq +3226 -> 3265
    //   42: invokestatic 1723	java/lang/System:currentTimeMillis	()J
    //   45: lstore 8
    //   47: aconst_null
    //   48: astore 4
    //   50: aload_2
    //   51: invokevirtual 530	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   54: ifeq +310 -> 364
    //   57: aload_3
    //   58: instanceof 1725
    //   61: ifeq +303 -> 364
    //   64: iconst_1
    //   65: istore 6
    //   67: iload 6
    //   69: ifeq +3191 -> 3260
    //   72: aload_0
    //   73: aload_2
    //   74: invokevirtual 1650	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   77: ldc_w 1652
    //   80: new 1654	SummaryCard/RespHead
    //   83: dup
    //   84: invokespecial 1655	SummaryCard/RespHead:<init>	()V
    //   87: invokevirtual 1465	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 1654	SummaryCard/RespHead
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +275 -> 370
    //   98: aload_2
    //   99: getfield 1660	SummaryCard/RespHead:iResult	I
    //   102: ifne +268 -> 370
    //   105: iconst_1
    //   106: istore 6
    //   108: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +33 -> 144
    //   114: ldc_w 1638
    //   117: iconst_2
    //   118: new 182	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 1727
    //   128: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: getfield 1660	SummaryCard/RespHead:iResult	I
    //   135: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_1
    //   145: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   148: ldc_w 355
    //   151: invokevirtual 578	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   154: lstore 10
    //   156: aload_1
    //   157: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   160: ldc_w 1729
    //   163: invokevirtual 360	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: astore 4
    //   168: aload_1
    //   169: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   172: ldc_w 1731
    //   175: invokevirtual 836	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   178: istore 7
    //   180: iload 6
    //   182: ifeq +2998 -> 3180
    //   185: aload_0
    //   186: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   189: bipush 43
    //   191: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   194: checkcast 888	com/tencent/mobileqq/app/FriendsManager
    //   197: astore 14
    //   199: aload_0
    //   200: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   203: bipush 44
    //   205: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   208: checkcast 1733	com/tencent/mobileqq/app/TroopManager
    //   211: astore 15
    //   213: aload_3
    //   214: checkcast 1725	SummaryCard/RespSummaryCard
    //   217: astore 13
    //   219: lload 10
    //   221: lconst_0
    //   222: lcmp
    //   223: ifgt +186 -> 409
    //   226: iload 7
    //   228: bipush 41
    //   230: if_icmpeq +179 -> 409
    //   233: iload 7
    //   235: bipush 6
    //   237: if_icmpeq +172 -> 409
    //   240: aload 14
    //   242: aload 4
    //   244: invokevirtual 1736	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ContactCard;
    //   247: astore_1
    //   248: aload_1
    //   249: aload 13
    //   251: getfield 1739	SummaryCard/RespSummaryCard:bAge	B
    //   254: putfield 1742	com/tencent/mobileqq/data/ContactCard:bAge	B
    //   257: aload_1
    //   258: aload 13
    //   260: getfield 1745	SummaryCard/RespSummaryCard:bSex	B
    //   263: putfield 1746	com/tencent/mobileqq/data/ContactCard:bSex	B
    //   266: aload_1
    //   267: aload 13
    //   269: getfield 1747	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   272: putfield 1750	com/tencent/mobileqq/data/ContactCard:nickName	Ljava/lang/String;
    //   275: aload_1
    //   276: aload 13
    //   278: getfield 1751	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   281: putfield 1752	com/tencent/mobileqq/data/ContactCard:strProvince	Ljava/lang/String;
    //   284: aload_1
    //   285: aload 13
    //   287: getfield 1753	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   290: putfield 1754	com/tencent/mobileqq/data/ContactCard:strCountry	Ljava/lang/String;
    //   293: aload_1
    //   294: aload 13
    //   296: getfield 1755	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   299: putfield 1756	com/tencent/mobileqq/data/ContactCard:strCity	Ljava/lang/String;
    //   302: aload_1
    //   303: aload 13
    //   305: getfield 1759	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   308: putfield 1760	com/tencent/mobileqq/data/ContactCard:strContactName	Ljava/lang/String;
    //   311: aload 14
    //   313: aload_1
    //   314: invokevirtual 1763	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ContactCard;)Z
    //   317: pop
    //   318: aload_0
    //   319: iconst_1
    //   320: iconst_1
    //   321: aload_1
    //   322: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   325: invokestatic 763	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   328: ifeq +35 -> 363
    //   331: ldc_w 1638
    //   334: iconst_4
    //   335: new 182	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 1765
    //   345: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokestatic 1723	java/lang/System:currentTimeMillis	()J
    //   351: lload 8
    //   353: lsub
    //   354: invokevirtual 649	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   357: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 651	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: return
    //   364: iconst_0
    //   365: istore 6
    //   367: goto -300 -> 67
    //   370: iconst_0
    //   371: istore 6
    //   373: goto -265 -> 108
    //   376: astore 13
    //   378: aload 4
    //   380: astore_2
    //   381: aload 13
    //   383: astore 4
    //   385: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +15 -> 403
    //   391: ldc_w 1638
    //   394: iconst_2
    //   395: aload 4
    //   397: invokevirtual 1699	java/lang/Exception:toString	()Ljava/lang/String;
    //   400: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iconst_0
    //   404: istore 6
    //   406: goto -262 -> 144
    //   409: aload_1
    //   410: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   413: ldc_w 1767
    //   416: invokevirtual 612	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   419: iconst_1
    //   420: if_icmpne +708 -> 1128
    //   423: aload_0
    //   424: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: invokevirtual 615	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   430: invokevirtual 621	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   433: astore 4
    //   435: aload_1
    //   436: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   439: ldc_w 1769
    //   442: lconst_0
    //   443: invokevirtual 1772	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   446: lstore 8
    //   448: aconst_null
    //   449: astore_1
    //   450: lload 8
    //   452: lconst_0
    //   453: lcmp
    //   454: ifle +30 -> 484
    //   457: aload 4
    //   459: ldc_w 623
    //   462: ldc_w 1774
    //   465: iconst_1
    //   466: anewarray 268	java/lang/String
    //   469: dup
    //   470: iconst_0
    //   471: lload 8
    //   473: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   476: aastore
    //   477: invokevirtual 630	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   480: checkcast 623	com/tencent/mobileqq/data/NearbyPeopleCard
    //   483: astore_1
    //   484: aload_1
    //   485: astore_3
    //   486: aload_1
    //   487: ifnonnull +42 -> 529
    //   490: aload_1
    //   491: astore_3
    //   492: aload 13
    //   494: getfield 1775	SummaryCard/RespSummaryCard:lUIN	J
    //   497: lconst_0
    //   498: lcmp
    //   499: ifle +30 -> 529
    //   502: aload 4
    //   504: ldc_w 623
    //   507: ldc_w 625
    //   510: iconst_1
    //   511: anewarray 268	java/lang/String
    //   514: dup
    //   515: iconst_0
    //   516: lload 10
    //   518: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   521: aastore
    //   522: invokevirtual 630	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   525: checkcast 623	com/tencent/mobileqq/data/NearbyPeopleCard
    //   528: astore_3
    //   529: aload_3
    //   530: ifnonnull +2725 -> 3255
    //   533: new 623	com/tencent/mobileqq/data/NearbyPeopleCard
    //   536: dup
    //   537: invokespecial 806	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   540: astore_1
    //   541: aload 13
    //   543: getfield 1779	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   546: astore_3
    //   547: aload_1
    //   548: aload 13
    //   550: getfield 1775	SummaryCard/RespSummaryCard:lUIN	J
    //   553: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   556: putfield 809	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   559: lload 8
    //   561: lconst_0
    //   562: lcmp
    //   563: ifle +9 -> 572
    //   566: aload_1
    //   567: lload 8
    //   569: putfield 1781	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   572: aload_1
    //   573: aload 13
    //   575: getfield 1747	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   578: putfield 822	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   581: aload_1
    //   582: aload 13
    //   584: getfield 1782	SummaryCard/RespSummaryCard:vRichSign	[B
    //   587: putfield 819	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   590: aload_1
    //   591: aload_3
    //   592: getfield 1787	SummaryCard/DateCard:bMarriage	B
    //   595: putfield 829	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   598: aload_1
    //   599: aload 13
    //   601: getfield 1745	SummaryCard/RespSummaryCard:bSex	B
    //   604: putfield 832	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   607: aload_1
    //   608: aload 13
    //   610: getfield 1739	SummaryCard/RespSummaryCard:bAge	B
    //   613: putfield 840	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   616: aload_1
    //   617: aload 13
    //   619: getfield 1790	SummaryCard/RespSummaryCard:iBirthday	I
    //   622: putfield 838	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   625: aload_1
    //   626: aload_3
    //   627: getfield 1793	SummaryCard/DateCard:uProfession	J
    //   630: l2i
    //   631: putfield 846	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   634: aload_1
    //   635: aload_3
    //   636: getfield 1794	SummaryCard/DateCard:bConstellation	B
    //   639: putfield 843	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   642: aload_1
    //   643: aload_3
    //   644: getfield 1797	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   647: putfield 1800	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   650: aload_1
    //   651: aload_3
    //   652: getfield 1803	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   655: putfield 1806	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   658: aload_1
    //   659: aload_3
    //   660: getfield 1809	SummaryCard/DateCard:vFaces	[B
    //   663: putfield 1812	com/tencent/mobileqq/data/NearbyPeopleCard:photoInfoes	[B
    //   666: aload_1
    //   667: aload 13
    //   669: getfield 1815	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   672: putfield 1818	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   675: aload_1
    //   676: aload 13
    //   678: getfield 1821	SummaryCard/RespSummaryCard:iVoteCount	I
    //   681: putfield 633	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   684: aload_1
    //   685: aload_3
    //   686: getfield 1824	SummaryCard/DateCard:vDateInfo	[B
    //   689: putfield 1827	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   692: aload_1
    //   693: aload_3
    //   694: getfield 1828	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   697: putfield 848	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   700: aload_1
    //   701: aload_3
    //   702: getfield 1829	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   705: putfield 850	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   708: aload_1
    //   709: aload_3
    //   710: getfield 1832	SummaryCard/DateCard:uHomeCountry	J
    //   713: invokestatic 1029	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   716: putfield 856	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   719: aload_1
    //   720: aload_3
    //   721: getfield 1835	SummaryCard/DateCard:uHomeProvince	J
    //   724: invokestatic 1029	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   727: putfield 859	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   730: aload_1
    //   731: aload_3
    //   732: getfield 1838	SummaryCard/DateCard:uHomeCity	J
    //   735: invokestatic 1029	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   738: putfield 862	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   741: aload_1
    //   742: aload_3
    //   743: getfield 1841	SummaryCard/DateCard:uHomeZone	J
    //   746: invokestatic 1029	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   749: putfield 865	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   752: aload_1
    //   753: aload 13
    //   755: getfield 1844	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   758: putfield 1847	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   761: aload_1
    //   762: aload 13
    //   764: getfield 1850	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   767: putfield 1853	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   770: aload_1
    //   771: aload 13
    //   773: getfield 1856	SummaryCard/RespSummaryCard:ulShowControl	J
    //   776: putfield 1859	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   779: aload_1
    //   780: aload 13
    //   782: getfield 1862	SummaryCard/RespSummaryCard:lUserFlag	J
    //   785: putfield 1865	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   788: aload_1
    //   789: aload 13
    //   791: getfield 1868	SummaryCard/RespSummaryCard:vSeed	[B
    //   794: putfield 1869	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   797: aload_1
    //   798: aload 13
    //   800: getfield 1872	SummaryCard/RespSummaryCard:lCacheControl	J
    //   803: invokevirtual 1876	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   806: aload_1
    //   807: invokestatic 1723	java/lang/System:currentTimeMillis	()J
    //   810: putfield 1879	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   813: aload 14
    //   815: ifnull +9 -> 824
    //   818: aload 14
    //   820: aload_1
    //   821: invokevirtual 1882	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   824: aload 13
    //   826: getfield 1885	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   829: ifne +159 -> 988
    //   832: aload_1
    //   833: iconst_1
    //   834: putfield 634	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   837: aload_2
    //   838: ifnull +11 -> 849
    //   841: aload_1
    //   842: aload_2
    //   843: getfield 1888	SummaryCard/RespHead:vCookies	[B
    //   846: putfield 1889	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   849: aload_1
    //   850: getfield 1865	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   853: ldc2_w 1890
    //   856: land
    //   857: lconst_0
    //   858: lcmp
    //   859: ifeq +137 -> 996
    //   862: aload_1
    //   863: iconst_1
    //   864: putfield 872	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   867: aload_1
    //   868: getfield 1865	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   871: ldc2_w 1892
    //   874: land
    //   875: lconst_0
    //   876: lcmp
    //   877: ifeq +127 -> 1004
    //   880: aload_1
    //   881: iconst_1
    //   882: putfield 875	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   885: aload_1
    //   886: invokevirtual 1896	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   889: ifne +179 -> 1068
    //   892: aload_1
    //   893: ldc_w 266
    //   896: putfield 1899	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   899: aload_1
    //   900: ldc_w 266
    //   903: putfield 1902	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   906: aload_1
    //   907: ldc_w 266
    //   910: putfield 1905	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   913: aload 13
    //   915: getfield 1909	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   918: astore_2
    //   919: aload_2
    //   920: ifnull +148 -> 1068
    //   923: aload_2
    //   924: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   927: ifnull +141 -> 1068
    //   930: aload_2
    //   931: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   934: invokevirtual 692	java/util/ArrayList:size	()I
    //   937: ifle +131 -> 1068
    //   940: iconst_0
    //   941: istore 6
    //   943: iload 6
    //   945: aload_2
    //   946: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   949: invokevirtual 692	java/util/ArrayList:size	()I
    //   952: if_icmpge +116 -> 1068
    //   955: iload 6
    //   957: ifne +55 -> 1012
    //   960: aload_1
    //   961: aload_2
    //   962: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   965: iload 6
    //   967: invokevirtual 693	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   970: checkcast 1916	SummaryCard/PhotoInfo
    //   973: getfield 1919	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   976: putfield 1899	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   979: iload 6
    //   981: iconst_1
    //   982: iadd
    //   983: istore 6
    //   985: goto -42 -> 943
    //   988: aload_1
    //   989: iconst_0
    //   990: putfield 634	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   993: goto -156 -> 837
    //   996: aload_1
    //   997: iconst_0
    //   998: putfield 872	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1001: goto -134 -> 867
    //   1004: aload_1
    //   1005: iconst_0
    //   1006: putfield 875	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1009: goto -124 -> 885
    //   1012: iload 6
    //   1014: iconst_1
    //   1015: if_icmpne +25 -> 1040
    //   1018: aload_1
    //   1019: aload_2
    //   1020: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1023: iload 6
    //   1025: invokevirtual 693	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1028: checkcast 1916	SummaryCard/PhotoInfo
    //   1031: getfield 1919	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1034: putfield 1902	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1037: goto -58 -> 979
    //   1040: iload 6
    //   1042: iconst_2
    //   1043: if_icmpne -64 -> 979
    //   1046: aload_1
    //   1047: aload_2
    //   1048: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1051: iload 6
    //   1053: invokevirtual 693	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1056: checkcast 1916	SummaryCard/PhotoInfo
    //   1059: getfield 1919	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1062: putfield 1905	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1065: goto -86 -> 979
    //   1068: aload_1
    //   1069: invokevirtual 878	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1072: sipush 1000
    //   1075: if_icmpne +23 -> 1098
    //   1078: aload 4
    //   1080: aload_1
    //   1081: invokevirtual 881	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   1084: aload 4
    //   1086: invokevirtual 1920	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1089: aload_0
    //   1090: bipush 51
    //   1092: iconst_1
    //   1093: aload_1
    //   1094: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   1097: return
    //   1098: aload_1
    //   1099: invokevirtual 878	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1102: sipush 1001
    //   1105: if_icmpeq +13 -> 1118
    //   1108: aload_1
    //   1109: invokevirtual 878	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1112: sipush 1002
    //   1115: if_icmpne -31 -> 1084
    //   1118: aload 4
    //   1120: aload_1
    //   1121: invokevirtual 637	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1124: pop
    //   1125: goto -41 -> 1084
    //   1128: lload 10
    //   1130: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1133: astore 16
    //   1135: aload 14
    //   1137: aload 16
    //   1139: invokevirtual 889	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1142: astore 4
    //   1144: aload 4
    //   1146: aload 13
    //   1148: getfield 1923	SummaryCard/RespSummaryCard:iLevel	I
    //   1151: putfield 1584	com/tencent/mobileqq/data/Card:iQQLevel	I
    //   1154: aload 4
    //   1156: aload 13
    //   1158: getfield 1747	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   1161: putfield 892	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   1164: aload 4
    //   1166: aload 13
    //   1168: getfield 1745	SummaryCard/RespSummaryCard:bSex	B
    //   1171: i2s
    //   1172: putfield 902	com/tencent/mobileqq/data/Card:shGender	S
    //   1175: aload 4
    //   1177: aload 13
    //   1179: getfield 1739	SummaryCard/RespSummaryCard:bAge	B
    //   1182: i2s
    //   1183: putfield 1044	com/tencent/mobileqq/data/Card:shAge	S
    //   1186: aload 4
    //   1188: aload 13
    //   1190: getfield 1739	SummaryCard/RespSummaryCard:bAge	B
    //   1193: putfield 907	com/tencent/mobileqq/data/Card:age	B
    //   1196: aload 4
    //   1198: aload 13
    //   1200: getfield 1926	SummaryCard/RespSummaryCard:iFace	I
    //   1203: putfield 1216	com/tencent/mobileqq/data/Card:nFaceID	I
    //   1206: aload 4
    //   1208: aload 13
    //   1210: getfield 1927	SummaryCard/RespSummaryCard:strSign	Ljava/lang/String;
    //   1213: putfield 1284	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   1216: aload 4
    //   1218: aload 13
    //   1220: getfield 1755	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   1223: putfield 940	com/tencent/mobileqq/data/Card:strCity	Ljava/lang/String;
    //   1226: aload 4
    //   1228: aload 13
    //   1230: getfield 1751	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   1233: putfield 937	com/tencent/mobileqq/data/Card:strProvince	Ljava/lang/String;
    //   1236: aload 4
    //   1238: aload 13
    //   1240: getfield 1753	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   1243: putfield 934	com/tencent/mobileqq/data/Card:strCountry	Ljava/lang/String;
    //   1246: aload 4
    //   1248: aload 13
    //   1250: getfield 1930	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   1253: putfield 1606	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   1256: aload 4
    //   1258: aload 13
    //   1260: getfield 1815	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   1263: putfield 1146	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   1266: aload 4
    //   1268: aload 13
    //   1270: getfield 1933	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   1273: putfield 1936	com/tencent/mobileqq/data/Card:strTroopName	Ljava/lang/String;
    //   1276: aload 4
    //   1278: aload 13
    //   1280: getfield 1939	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   1283: putfield 1942	com/tencent/mobileqq/data/Card:strTroopNick	Ljava/lang/String;
    //   1286: aload 4
    //   1288: aload 13
    //   1290: getfield 1945	SummaryCard/RespSummaryCard:strMobile	Ljava/lang/String;
    //   1293: putfield 1946	com/tencent/mobileqq/data/Card:strMobile	Ljava/lang/String;
    //   1296: aload 4
    //   1298: aload 13
    //   1300: getfield 1759	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   1303: putfield 1947	com/tencent/mobileqq/data/Card:strContactName	Ljava/lang/String;
    //   1306: aload 4
    //   1308: aload 13
    //   1310: getfield 1950	SummaryCard/RespSummaryCard:strStatus	Ljava/lang/String;
    //   1313: putfield 1951	com/tencent/mobileqq/data/Card:strStatus	Ljava/lang/String;
    //   1316: aload 4
    //   1318: aload 13
    //   1320: getfield 1954	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   1323: putfield 1955	com/tencent/mobileqq/data/Card:strAutoRemark	Ljava/lang/String;
    //   1326: aload 4
    //   1328: aload 13
    //   1330: getfield 1868	SummaryCard/RespSummaryCard:vSeed	[B
    //   1333: putfield 1956	com/tencent/mobileqq/data/Card:vSeed	[B
    //   1336: aload 4
    //   1338: aload 13
    //   1340: getfield 1821	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1343: i2l
    //   1344: putfield 1250	com/tencent/mobileqq/data/Card:lVisitCount	J
    //   1347: aload 4
    //   1349: aload 13
    //   1351: getfield 1959	SummaryCard/RespSummaryCard:uQQMasterLoginDays	J
    //   1354: putfield 1962	com/tencent/mobileqq/data/Card:lQQMasterLogindays	J
    //   1357: aload_1
    //   1358: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1361: ldc_w 1731
    //   1364: invokevirtual 836	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1367: bipush 37
    //   1369: if_icmpne +18 -> 1387
    //   1372: aload 4
    //   1374: aload_1
    //   1375: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1378: ldc_w 1729
    //   1381: invokevirtual 360	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1384: putfield 1965	com/tencent/mobileqq/data/Card:encId	Ljava/lang/String;
    //   1387: aload_2
    //   1388: ifnull +12 -> 1400
    //   1391: aload 4
    //   1393: aload_2
    //   1394: getfield 1888	SummaryCard/RespHead:vCookies	[B
    //   1397: putfield 1966	com/tencent/mobileqq/data/Card:vCookies	[B
    //   1400: aload 13
    //   1402: getfield 1885	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1405: ifne +250 -> 1655
    //   1408: aload 4
    //   1410: iconst_1
    //   1411: putfield 402	com/tencent/mobileqq/data/Card:bVoted	B
    //   1414: aload 4
    //   1416: aload 13
    //   1418: getfield 1821	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1421: i2l
    //   1422: putfield 399	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1425: aload 4
    //   1427: aload 4
    //   1429: getfield 1256	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1432: aload 13
    //   1434: getfield 1969	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1437: iadd
    //   1438: putfield 1256	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1441: aload 13
    //   1443: getfield 1856	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1446: ldc2_w 1892
    //   1449: land
    //   1450: lconst_0
    //   1451: lcmp
    //   1452: ifne +212 -> 1664
    //   1455: iconst_0
    //   1456: istore 12
    //   1458: aload 4
    //   1460: iload 12
    //   1462: invokevirtual 1330	com/tencent/mobileqq/data/Card:setZanShowFlag	(Z)V
    //   1465: aload 13
    //   1467: getfield 1856	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1470: lconst_1
    //   1471: land
    //   1472: lconst_0
    //   1473: lcmp
    //   1474: ifne +196 -> 1670
    //   1477: iconst_0
    //   1478: istore 12
    //   1480: aload 4
    //   1482: iload 12
    //   1484: invokevirtual 1972	com/tencent/mobileqq/data/Card:setFeedsShowFlag	(Z)V
    //   1487: aload 13
    //   1489: getfield 1856	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1492: ldc2_w 1890
    //   1495: land
    //   1496: lconst_0
    //   1497: lcmp
    //   1498: ifne +178 -> 1676
    //   1501: iconst_0
    //   1502: istore 12
    //   1504: aload 4
    //   1506: iload 12
    //   1508: invokevirtual 1975	com/tencent/mobileqq/data/Card:setPhotoShowFlag	(Z)V
    //   1511: aload 13
    //   1513: getfield 1872	SummaryCard/RespSummaryCard:lCacheControl	J
    //   1516: lconst_0
    //   1517: lcmp
    //   1518: ifne +164 -> 1682
    //   1521: iconst_0
    //   1522: istore 12
    //   1524: aload 4
    //   1526: iload 12
    //   1528: invokevirtual 1978	com/tencent/mobileqq/data/Card:setPhotoUseCacheFlag	(Z)V
    //   1531: aload 4
    //   1533: iconst_0
    //   1534: invokevirtual 1981	com/tencent/mobileqq/data/Card:setXManFlag	(Z)V
    //   1537: aload 4
    //   1539: aload 13
    //   1541: getfield 1844	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   1544: putfield 1982	com/tencent/mobileqq/data/Card:strQzoneFeedsDesc	Ljava/lang/String;
    //   1547: aload 4
    //   1549: aload 13
    //   1551: getfield 1850	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   1554: putfield 1983	com/tencent/mobileqq/data/Card:strSpaceName	Ljava/lang/String;
    //   1557: aload 4
    //   1559: invokevirtual 1984	com/tencent/mobileqq/data/Card:isPhotoUseCache	()Z
    //   1562: ifne +184 -> 1746
    //   1565: aload 4
    //   1567: ldc_w 266
    //   1570: putfield 1987	com/tencent/mobileqq/data/Card:strQzonePicUrl1	Ljava/lang/String;
    //   1573: aload 4
    //   1575: ldc_w 266
    //   1578: putfield 1990	com/tencent/mobileqq/data/Card:strQzonePicUrl2	Ljava/lang/String;
    //   1581: aload 4
    //   1583: ldc_w 266
    //   1586: putfield 1993	com/tencent/mobileqq/data/Card:strQzonePicUrl3	Ljava/lang/String;
    //   1589: aload 13
    //   1591: getfield 1909	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1594: astore_2
    //   1595: aload_2
    //   1596: ifnull +150 -> 1746
    //   1599: aload_2
    //   1600: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1603: ifnull +143 -> 1746
    //   1606: iconst_0
    //   1607: istore 6
    //   1609: iload 6
    //   1611: aload_2
    //   1612: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1615: invokevirtual 692	java/util/ArrayList:size	()I
    //   1618: if_icmpge +128 -> 1746
    //   1621: iload 6
    //   1623: ifne +65 -> 1688
    //   1626: aload 4
    //   1628: aload_2
    //   1629: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1632: iload 6
    //   1634: invokevirtual 693	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1637: checkcast 1916	SummaryCard/PhotoInfo
    //   1640: getfield 1919	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1643: putfield 1987	com/tencent/mobileqq/data/Card:strQzonePicUrl1	Ljava/lang/String;
    //   1646: iload 6
    //   1648: iconst_1
    //   1649: iadd
    //   1650: istore 6
    //   1652: goto -43 -> 1609
    //   1655: aload 4
    //   1657: iconst_0
    //   1658: putfield 402	com/tencent/mobileqq/data/Card:bVoted	B
    //   1661: goto -247 -> 1414
    //   1664: iconst_1
    //   1665: istore 12
    //   1667: goto -209 -> 1458
    //   1670: iconst_1
    //   1671: istore 12
    //   1673: goto -193 -> 1480
    //   1676: iconst_1
    //   1677: istore 12
    //   1679: goto -175 -> 1504
    //   1682: iconst_1
    //   1683: istore 12
    //   1685: goto -161 -> 1524
    //   1688: iload 6
    //   1690: iconst_1
    //   1691: if_icmpne +26 -> 1717
    //   1694: aload 4
    //   1696: aload_2
    //   1697: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1700: iload 6
    //   1702: invokevirtual 693	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1705: checkcast 1916	SummaryCard/PhotoInfo
    //   1708: getfield 1919	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1711: putfield 1990	com/tencent/mobileqq/data/Card:strQzonePicUrl2	Ljava/lang/String;
    //   1714: goto -68 -> 1646
    //   1717: iload 6
    //   1719: iconst_2
    //   1720: if_icmpne -74 -> 1646
    //   1723: aload 4
    //   1725: aload_2
    //   1726: getfield 1914	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1729: iload 6
    //   1731: invokevirtual 693	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1734: checkcast 1916	SummaryCard/PhotoInfo
    //   1737: getfield 1919	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1740: putfield 1993	com/tencent/mobileqq/data/Card:strQzonePicUrl3	Ljava/lang/String;
    //   1743: goto -97 -> 1646
    //   1746: aload 4
    //   1748: aload 13
    //   1750: getfield 1994	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   1753: invokevirtual 1998	com/tencent/mobileqq/data/Card:setVipInfo	(LQQService/VipBaseInfo;)V
    //   1756: aload_1
    //   1757: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1760: ldc_w 2000
    //   1763: invokevirtual 578	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1766: lstore 10
    //   1768: lconst_1
    //   1769: lload 10
    //   1771: land
    //   1772: lconst_0
    //   1773: lcmp
    //   1774: ifeq +68 -> 1842
    //   1777: aload 4
    //   1779: aload 13
    //   1781: getfield 2003	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1784: putfield 2004	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1787: aload 4
    //   1789: getfield 2004	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1792: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1795: ifeq +10 -> 1805
    //   1798: aload 4
    //   1800: aload 16
    //   1802: putfield 2004	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1805: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1808: ifeq +34 -> 1842
    //   1811: ldc_w 1638
    //   1814: iconst_2
    //   1815: new 182	java/lang/StringBuilder
    //   1818: dup
    //   1819: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1822: ldc_w 2006
    //   1825: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1828: aload 13
    //   1830: getfield 2003	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1833: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1839: invokestatic 651	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1842: ldc2_w 2007
    //   1845: lload 10
    //   1847: land
    //   1848: lconst_0
    //   1849: lcmp
    //   1850: ifeq +13 -> 1863
    //   1853: aload 4
    //   1855: aload 13
    //   1857: getfield 2011	SummaryCard/RespSummaryCard:uAccelerateMultiple	J
    //   1860: putfield 2012	com/tencent/mobileqq/data/Card:uAccelerateMultiple	J
    //   1863: ldc2_w 1892
    //   1866: lload 10
    //   1868: land
    //   1869: lconst_0
    //   1870: lcmp
    //   1871: ifeq +23 -> 1894
    //   1874: aload 4
    //   1876: aload 13
    //   1878: getfield 1782	SummaryCard/RespSummaryCard:vRichSign	[B
    //   1881: putfield 2013	com/tencent/mobileqq/data/Card:vRichSign	[B
    //   1884: aload 4
    //   1886: aload 13
    //   1888: getfield 2016	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   1891: putfield 2019	com/tencent/mobileqq/data/Card:lSignModifyTime	J
    //   1894: ldc2_w 2020
    //   1897: lload 10
    //   1899: land
    //   1900: lconst_0
    //   1901: lcmp
    //   1902: ifeq +54 -> 1956
    //   1905: new 574	java/util/HashMap
    //   1908: dup
    //   1909: invokespecial 575	java/util/HashMap:<init>	()V
    //   1912: astore_2
    //   1913: aload 13
    //   1915: getfield 2024	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   1918: ifnull +1006 -> 2924
    //   1921: aload_0
    //   1922: aload 13
    //   1924: getfield 2024	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   1927: ldc_w 1459
    //   1930: new 1461	SummaryCardTaf/SSummaryCardRsp
    //   1933: dup
    //   1934: invokespecial 1462	SummaryCardTaf/SSummaryCardRsp:<init>	()V
    //   1937: invokevirtual 1465	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1940: checkcast 1461	SummaryCardTaf/SSummaryCardRsp
    //   1943: astore_2
    //   1944: aload 4
    //   1946: aload_0
    //   1947: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1950: aload 16
    //   1952: aload_2
    //   1953: invokevirtual 2028	com/tencent/mobileqq/data/Card:updateCardTemplate	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;LSummaryCardTaf/SSummaryCardRsp;)V
    //   1956: ldc2_w 2029
    //   1959: lload 10
    //   1961: land
    //   1962: lconst_0
    //   1963: lcmp
    //   1964: ifeq +50 -> 2014
    //   1967: aload 4
    //   1969: aload 13
    //   1971: getfield 1862	SummaryCard/RespSummaryCard:lUserFlag	J
    //   1974: putfield 2031	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   1977: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1980: ifeq +34 -> 2014
    //   1983: ldc_w 1638
    //   1986: iconst_2
    //   1987: new 182	java/lang/StringBuilder
    //   1990: dup
    //   1991: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1994: ldc_w 2033
    //   1997: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: aload 4
    //   2002: getfield 2031	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2005: invokevirtual 649	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2008: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2011: invokestatic 651	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2014: ldc2_w 2034
    //   2017: lload 10
    //   2019: land
    //   2020: lconst_0
    //   2021: lcmp
    //   2022: ifeq +74 -> 2096
    //   2025: aload 4
    //   2027: aload 13
    //   2029: getfield 2038	SummaryCard/RespSummaryCard:uLoginDays	J
    //   2032: putfield 2041	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   2035: aload 4
    //   2037: aload 13
    //   2039: getfield 2044	SummaryCard/RespSummaryCard:strLoginDesc	Ljava/lang/String;
    //   2042: putfield 2047	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   2045: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2048: ifeq +48 -> 2096
    //   2051: ldc_w 1638
    //   2054: iconst_2
    //   2055: new 182	java/lang/StringBuilder
    //   2058: dup
    //   2059: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2062: ldc_w 2049
    //   2065: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: aload 4
    //   2070: getfield 2041	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   2073: invokevirtual 649	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2076: ldc_w 2051
    //   2079: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: aload 4
    //   2084: getfield 2047	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   2087: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2090: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2093: invokestatic 651	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2096: aload 13
    //   2098: getfield 2054	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   2101: ifnull +172 -> 2273
    //   2104: aload 13
    //   2106: getfield 2054	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   2109: invokevirtual 2060	QQService/VipBaseInfo:getMOpenInfo	()Ljava/util/Map;
    //   2112: astore_2
    //   2113: aload_2
    //   2114: ifnull +159 -> 2273
    //   2117: aload_2
    //   2118: bipush 101
    //   2120: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2123: invokeinterface 2065 2 0
    //   2128: checkcast 2067	QQService/VipOpenInfo
    //   2131: astore_3
    //   2132: aload_3
    //   2133: getfield 2070	QQService/VipOpenInfo:bOpen	Z
    //   2136: ifeq +24 -> 2160
    //   2139: aload 4
    //   2141: iconst_1
    //   2142: putfield 2073	com/tencent/mobileqq/data/Card:isRedDiamond	Z
    //   2145: aload_3
    //   2146: getfield 2076	QQService/VipOpenInfo:iVipFlag	I
    //   2149: iconst_1
    //   2150: iand
    //   2151: ifle +9 -> 2160
    //   2154: aload 4
    //   2156: iconst_1
    //   2157: putfield 2079	com/tencent/mobileqq/data/Card:isSuperRedDiamond	Z
    //   2160: aload 4
    //   2162: aload_3
    //   2163: getfield 2082	QQService/VipOpenInfo:iVipLevel	I
    //   2166: putfield 2085	com/tencent/mobileqq/data/Card:redLevel	I
    //   2169: aload_2
    //   2170: bipush 102
    //   2172: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2175: invokeinterface 2065 2 0
    //   2180: checkcast 2067	QQService/VipOpenInfo
    //   2183: astore_3
    //   2184: aload_3
    //   2185: getfield 2070	QQService/VipOpenInfo:bOpen	Z
    //   2188: ifeq +24 -> 2212
    //   2191: aload 4
    //   2193: iconst_1
    //   2194: putfield 2088	com/tencent/mobileqq/data/Card:isYellowDiamond	Z
    //   2197: aload_3
    //   2198: getfield 2076	QQService/VipOpenInfo:iVipFlag	I
    //   2201: iconst_1
    //   2202: iand
    //   2203: ifle +9 -> 2212
    //   2206: aload 4
    //   2208: iconst_1
    //   2209: putfield 2091	com/tencent/mobileqq/data/Card:isSuperYellowDiamond	Z
    //   2212: aload 4
    //   2214: aload_3
    //   2215: getfield 2082	QQService/VipOpenInfo:iVipLevel	I
    //   2218: putfield 2094	com/tencent/mobileqq/data/Card:yellowLevel	I
    //   2221: aload_2
    //   2222: bipush 103
    //   2224: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2227: invokeinterface 2065 2 0
    //   2232: checkcast 2067	QQService/VipOpenInfo
    //   2235: astore_2
    //   2236: aload_2
    //   2237: getfield 2070	QQService/VipOpenInfo:bOpen	Z
    //   2240: ifeq +24 -> 2264
    //   2243: aload 4
    //   2245: iconst_1
    //   2246: putfield 2097	com/tencent/mobileqq/data/Card:isGreenDiamond	Z
    //   2249: aload_2
    //   2250: getfield 2076	QQService/VipOpenInfo:iVipFlag	I
    //   2253: iconst_1
    //   2254: iand
    //   2255: ifle +9 -> 2264
    //   2258: aload 4
    //   2260: iconst_1
    //   2261: putfield 2100	com/tencent/mobileqq/data/Card:isSuperGreenDiamond	Z
    //   2264: aload 4
    //   2266: aload_2
    //   2267: getfield 2082	QQService/VipOpenInfo:iVipLevel	I
    //   2270: putfield 2103	com/tencent/mobileqq/data/Card:greenLevel	I
    //   2273: aload 4
    //   2275: getfield 2031	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2278: ldc2_w 2029
    //   2281: land
    //   2282: lconst_0
    //   2283: lcmp
    //   2284: ifeq +680 -> 2964
    //   2287: aload 4
    //   2289: iconst_1
    //   2290: putfield 2106	com/tencent/mobileqq/data/Card:allowClick	Z
    //   2293: aload 16
    //   2295: aload_0
    //   2296: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2299: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2302: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2305: ifne +23 -> 2328
    //   2308: aload 4
    //   2310: getfield 2031	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2313: ldc2_w 2034
    //   2316: land
    //   2317: lconst_0
    //   2318: lcmp
    //   2319: ifeq +654 -> 2973
    //   2322: aload 4
    //   2324: iconst_1
    //   2325: putfield 1125	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   2328: aload 14
    //   2330: aload 4
    //   2332: invokevirtual 955	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   2335: pop
    //   2336: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2339: ifeq +76 -> 2415
    //   2342: ldc_w 1638
    //   2345: iconst_2
    //   2346: new 182	java/lang/StringBuilder
    //   2349: dup
    //   2350: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2353: ldc_w 2049
    //   2356: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2359: aload 4
    //   2361: getfield 2041	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   2364: invokevirtual 649	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2367: ldc_w 2108
    //   2370: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2373: aload 4
    //   2375: getfield 2047	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   2378: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2381: ldc_w 2110
    //   2384: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2387: aload 4
    //   2389: getfield 2106	com/tencent/mobileqq/data/Card:allowClick	Z
    //   2392: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2395: ldc_w 2112
    //   2398: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2401: aload 4
    //   2403: getfield 1125	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   2406: invokevirtual 644	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2409: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2412: invokestatic 651	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2415: aload 14
    //   2417: aload 16
    //   2419: invokevirtual 2115	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   2422: astore_3
    //   2423: aload_3
    //   2424: astore_2
    //   2425: aload_3
    //   2426: ifnonnull +17 -> 2443
    //   2429: new 2117	com/tencent/mobileqq/data/ExtensionInfo
    //   2432: dup
    //   2433: invokespecial 2118	com/tencent/mobileqq/data/ExtensionInfo:<init>	()V
    //   2436: astore_2
    //   2437: aload_2
    //   2438: aload 16
    //   2440: putfield 2119	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   2443: aload_2
    //   2444: aload 13
    //   2446: getfield 2122	SummaryCard/RespSummaryCard:ulFaceAddonId	J
    //   2449: putfield 2125	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   2452: aload_2
    //   2453: invokestatic 1723	java/lang/System:currentTimeMillis	()J
    //   2456: putfield 2127	com/tencent/mobileqq/data/ExtensionInfo:timestamp	J
    //   2459: aload 14
    //   2461: aload_2
    //   2462: invokevirtual 2130	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   2465: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2468: ifeq +44 -> 2512
    //   2471: ldc_w 1638
    //   2474: iconst_2
    //   2475: new 182	java/lang/StringBuilder
    //   2478: dup
    //   2479: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2482: ldc_w 2132
    //   2485: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2488: aload 16
    //   2490: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2493: ldc_w 2134
    //   2496: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2499: aload_2
    //   2500: getfield 2125	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   2503: invokevirtual 649	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2506: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2509: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2512: aload 14
    //   2514: aload 16
    //   2516: invokevirtual 2137	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   2519: astore_3
    //   2520: aload_3
    //   2521: aload 4
    //   2523: getfield 1284	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   2526: putfield 2142	com/tencent/mobileqq/data/Friends:signature	Ljava/lang/String;
    //   2529: aload_3
    //   2530: aload 4
    //   2532: getfield 892	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   2535: putfield 2145	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   2538: aload_3
    //   2539: aload 4
    //   2541: getfield 1606	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   2544: putfield 2148	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   2547: lconst_1
    //   2548: lload 10
    //   2550: land
    //   2551: lconst_0
    //   2552: lcmp
    //   2553: ifeq +429 -> 2982
    //   2556: aload 4
    //   2558: getfield 2004	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   2561: astore_2
    //   2562: aload_3
    //   2563: aload_2
    //   2564: putfield 2151	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   2567: aload 4
    //   2569: getfield 902	com/tencent/mobileqq/data/Card:shGender	S
    //   2572: ifne +418 -> 2990
    //   2575: iconst_1
    //   2576: istore 5
    //   2578: aload_3
    //   2579: iload 5
    //   2581: putfield 2152	com/tencent/mobileqq/data/Friends:gender	B
    //   2584: aload_3
    //   2585: aload 4
    //   2587: getfield 907	com/tencent/mobileqq/data/Card:age	B
    //   2590: putfield 2153	com/tencent/mobileqq/data/Friends:age	I
    //   2593: ldc2_w 1892
    //   2596: lload 10
    //   2598: land
    //   2599: lconst_0
    //   2600: lcmp
    //   2601: ifeq +17 -> 2618
    //   2604: aload_3
    //   2605: aload 13
    //   2607: getfield 1782	SummaryCard/RespSummaryCard:vRichSign	[B
    //   2610: aload 13
    //   2612: getfield 2016	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   2615: invokevirtual 2157	com/tencent/mobileqq/data/Friends:setRichBuffer	([BJ)V
    //   2618: aload 13
    //   2620: getfield 1994	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   2623: ifnull +69 -> 2692
    //   2626: aload_3
    //   2627: aload 13
    //   2629: getfield 1994	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   2632: getstatic 2163	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   2635: invokevirtual 2166	QQService/EVIPSPEC:value	()I
    //   2638: aload_3
    //   2639: getfield 2169	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   2642: invokestatic 2174	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   2645: putfield 2169	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   2648: aload_3
    //   2649: aload 13
    //   2651: getfield 1994	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   2654: getstatic 2177	QQService/EVIPSPEC:E_SP_SUPERQQ	LQQService/EVIPSPEC;
    //   2657: invokevirtual 2166	QQService/EVIPSPEC:value	()I
    //   2660: aload_3
    //   2661: getfield 2180	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   2664: invokestatic 2174	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   2667: putfield 2180	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   2670: aload_3
    //   2671: aload 13
    //   2673: getfield 1994	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   2676: getstatic 2183	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   2679: invokevirtual 2166	QQService/EVIPSPEC:value	()I
    //   2682: aload_3
    //   2683: getfield 2186	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   2686: invokestatic 2174	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   2689: putfield 2186	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   2692: ldc2_w 2029
    //   2695: lload 10
    //   2697: land
    //   2698: lconst_0
    //   2699: lcmp
    //   2700: ifeq +26 -> 2726
    //   2703: aload 4
    //   2705: getfield 2031	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2708: lconst_1
    //   2709: land
    //   2710: lconst_0
    //   2711: lcmp
    //   2712: ifeq +299 -> 3011
    //   2715: aload_3
    //   2716: aload_3
    //   2717: getfield 2189	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   2720: iconst_1
    //   2721: ior
    //   2722: i2b
    //   2723: putfield 2189	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   2726: aload 14
    //   2728: aload_3
    //   2729: invokevirtual 2192	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   2732: aload_0
    //   2733: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2736: bipush 10
    //   2738: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2741: checkcast 1631	com/tencent/mobileqq/model/PhoneContactManager
    //   2744: astore_2
    //   2745: aload_2
    //   2746: ifnull +22 -> 2768
    //   2749: aload_2
    //   2750: aload_3
    //   2751: getfield 2193	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   2754: invokeinterface 1634 2 0
    //   2759: ifnull +9 -> 2768
    //   2762: aload_2
    //   2763: invokeinterface 1636 1 0
    //   2768: aload_1
    //   2769: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   2772: ldc_w 2195
    //   2775: lconst_0
    //   2776: invokevirtual 1772	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   2779: lstore 10
    //   2781: lload 10
    //   2783: lconst_0
    //   2784: lcmp
    //   2785: ifle +128 -> 2913
    //   2788: iload 7
    //   2790: iconst_2
    //   2791: if_icmpeq +16 -> 2807
    //   2794: iload 7
    //   2796: iconst_5
    //   2797: if_icmpeq +10 -> 2807
    //   2800: iload 7
    //   2802: bipush 7
    //   2804: if_icmpne +248 -> 3052
    //   2807: aload 15
    //   2809: lload 10
    //   2811: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2814: invokevirtual 2198	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   2817: astore_1
    //   2818: aload_1
    //   2819: ifnull +94 -> 2913
    //   2822: aload_1
    //   2823: getfield 2203	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   2826: ifnull +200 -> 3026
    //   2829: aload_1
    //   2830: getfield 2203	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   2833: aload 13
    //   2835: getfield 1933	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   2838: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2841: ifne +18 -> 2859
    //   2844: aload_1
    //   2845: aload 13
    //   2847: getfield 1933	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   2850: putfield 2203	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   2853: aload 15
    //   2855: aload_1
    //   2856: invokevirtual 2206	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   2859: aload_0
    //   2860: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2863: bipush 8
    //   2865: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2868: checkcast 391	com/tencent/mobileqq/app/FriendsManagerImp
    //   2871: lload 10
    //   2873: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2876: aload 13
    //   2878: getfield 1775	SummaryCard/RespSummaryCard:lUIN	J
    //   2881: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2884: aload 13
    //   2886: getfield 1939	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   2889: bipush 156
    //   2891: aload 13
    //   2893: getfield 1747	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   2896: aconst_null
    //   2897: bipush 156
    //   2899: bipush 156
    //   2901: bipush 156
    //   2903: ldc2_w 2207
    //   2906: ldc2_w 2207
    //   2909: invokevirtual 2211	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   2912: pop
    //   2913: aload_0
    //   2914: iconst_1
    //   2915: iconst_1
    //   2916: aload 4
    //   2918: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   2921: goto -2596 -> 325
    //   2924: aload_2
    //   2925: ldc_w 586
    //   2928: ldc_w 2213
    //   2931: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2934: pop
    //   2935: aload_0
    //   2936: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2939: invokevirtual 594	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2942: invokestatic 599	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2945: aload 16
    //   2947: ldc_w 2215
    //   2950: iconst_0
    //   2951: lconst_0
    //   2952: lconst_0
    //   2953: aconst_null
    //   2954: ldc_w 266
    //   2957: iconst_0
    //   2958: invokevirtual 606	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2961: goto -1005 -> 1956
    //   2964: aload 4
    //   2966: iconst_0
    //   2967: putfield 2106	com/tencent/mobileqq/data/Card:allowClick	Z
    //   2970: goto -677 -> 2293
    //   2973: aload 4
    //   2975: iconst_0
    //   2976: putfield 1125	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   2979: goto -651 -> 2328
    //   2982: aload_3
    //   2983: getfield 2151	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   2986: astore_2
    //   2987: goto -425 -> 2562
    //   2990: aload 4
    //   2992: getfield 902	com/tencent/mobileqq/data/Card:shGender	S
    //   2995: iconst_1
    //   2996: if_icmpne +9 -> 3005
    //   2999: iconst_2
    //   3000: istore 5
    //   3002: goto -424 -> 2578
    //   3005: iconst_0
    //   3006: istore 5
    //   3008: goto -430 -> 2578
    //   3011: aload_3
    //   3012: aload_3
    //   3013: getfield 2189	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   3016: bipush 254
    //   3018: iand
    //   3019: i2b
    //   3020: putfield 2189	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   3023: goto -297 -> 2726
    //   3026: aload 13
    //   3028: getfield 1933	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   3031: ifnull -172 -> 2859
    //   3034: aload_1
    //   3035: aload 13
    //   3037: getfield 1933	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   3040: putfield 2203	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   3043: aload 15
    //   3045: aload_1
    //   3046: invokevirtual 2206	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   3049: goto -190 -> 2859
    //   3052: iload 7
    //   3054: iconst_4
    //   3055: if_icmpne -142 -> 2913
    //   3058: aload_0
    //   3059: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3062: bipush 45
    //   3064: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3067: checkcast 2217	com/tencent/mobileqq/app/DiscussionManager
    //   3070: astore_1
    //   3071: aload_1
    //   3072: lload 10
    //   3074: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3077: aload 16
    //   3079: invokevirtual 2220	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   3082: astore_2
    //   3083: aload_2
    //   3084: ifnull -171 -> 2913
    //   3087: aload_2
    //   3088: aload 13
    //   3090: getfield 1747	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   3093: putfield 2225	com/tencent/mobileqq/data/DiscussionMemberInfo:memberName	Ljava/lang/String;
    //   3096: aload 13
    //   3098: getfield 1954	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   3101: ifnull +61 -> 3162
    //   3104: aload 13
    //   3106: getfield 1954	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   3109: invokevirtual 2228	java/lang/String:length	()I
    //   3112: ifle +50 -> 3162
    //   3115: aload 13
    //   3117: getfield 1954	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   3120: aload_2
    //   3121: getfield 2231	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   3124: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3127: ifne +35 -> 3162
    //   3130: aload_2
    //   3131: aload 13
    //   3133: getfield 1954	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   3136: putfield 2231	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   3139: aload 13
    //   3141: getfield 1954	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   3144: aload 13
    //   3146: getfield 1747	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   3149: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3152: ifeq +18 -> 3170
    //   3155: aload_2
    //   3156: ldc2_w 2232
    //   3159: putfield 2236	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   3162: aload_1
    //   3163: aload_2
    //   3164: invokevirtual 2239	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;)V
    //   3167: goto -254 -> 2913
    //   3170: aload_2
    //   3171: ldc2_w 2240
    //   3174: putfield 2236	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   3177: goto -15 -> 3162
    //   3180: aload_1
    //   3181: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   3184: ldc_w 1731
    //   3187: invokevirtual 836	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   3190: bipush 41
    //   3192: if_icmpeq +18 -> 3210
    //   3195: aload_1
    //   3196: getfield 353	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   3199: ldc_w 1731
    //   3202: invokevirtual 836	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   3205: bipush 6
    //   3207: if_icmpne +14 -> 3221
    //   3210: aload_0
    //   3211: bipush 51
    //   3213: iconst_0
    //   3214: aconst_null
    //   3215: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   3218: goto -2893 -> 325
    //   3221: lload 10
    //   3223: lconst_0
    //   3224: lcmp
    //   3225: ifgt +16 -> 3241
    //   3228: aload 4
    //   3230: astore_1
    //   3231: aload_0
    //   3232: iconst_1
    //   3233: iconst_0
    //   3234: aload_1
    //   3235: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   3238: goto -2913 -> 325
    //   3241: lload 10
    //   3243: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3246: astore_1
    //   3247: goto -16 -> 3231
    //   3250: astore 4
    //   3252: goto -2867 -> 385
    //   3255: aload_3
    //   3256: astore_1
    //   3257: goto -2716 -> 541
    //   3260: aconst_null
    //   3261: astore_2
    //   3262: goto -3118 -> 144
    //   3265: lconst_0
    //   3266: lstore 8
    //   3268: goto -3221 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3271	0	this	CardHandler
    //   0	3271	1	paramToServiceMsg	ToServiceMsg
    //   0	3271	2	paramFromServiceMsg	FromServiceMsg
    //   0	3271	3	paramObject	Object
    //   0	3271	4	paramBundle	Bundle
    //   2576	431	5	b1	byte
    //   65	1665	6	i1	int
    //   178	2878	7	i2	int
    //   45	3222	8	l1	long
    //   154	3088	10	l2	long
    //   1456	228	12	bool	boolean
    //   217	87	13	localRespSummaryCard	SummaryCard.RespSummaryCard
    //   376	2769	13	localException	Exception
    //   197	2530	14	localFriendsManager	FriendsManager
    //   211	2833	15	localTroopManager	TroopManager
    //   1133	1945	16	str	String
    // Exception table:
    //   from	to	target	type
    //   72	94	376	java/lang/Exception
    //   98	105	3250	java/lang/Exception
    //   108	144	3250	java/lang/Exception
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("filekey");
    paramBundle.putByteArray("fileKey", arrayOfByte);
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      RespDelFace localRespDelFace = (RespDelFace)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg.getUin());
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      paramObject = localFriendsManagerImp.a(paramToServiceMsg.getUin());
      paramFromServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramFromServiceMsg = new Card();
        paramFromServiceMsg.uin = paramToServiceMsg.getUin();
      }
      paramBundle.putInt("result", localRespDelFace.stHeader.iReplyCode);
      switch (localRespDelFace.stHeader.iReplyCode)
      {
      }
      for (;;)
      {
        localFriendsManagerImp.a(paramFromServiceMsg);
        return;
        if (localRespDelFace.uFaceTimeStamp > paramFromServiceMsg.uFaceTimeStamp) {
          paramFromServiceMsg.uFaceTimeStamp = localRespDelFace.uFaceTimeStamp;
        }
        paramFromServiceMsg.removePortrait(arrayOfByte);
        a(12, true, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        a(12, false, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        a(12, false, new Object[] { paramBundle, paramFromServiceMsg });
      }
    }
    paramBundle.putInt("result", -1);
    a(12, false, new Object[] { paramBundle, ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin()) });
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespGetFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        long l1 = paramToServiceMsg.extraData.getLong("lNextMid");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("lUin");
        paramBundle.putString("lUin", paramToServiceMsg);
        paramBundle.putLong("nextMid", l1);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramObject = paramFromServiceMsg.vFaceInfo;
        paramFromServiceMsg = new ArrayList();
        int i1 = 0;
        while (i1 < paramObject.size())
        {
          paramFromServiceMsg.add(HexUtil.a(((FaceInfo)paramObject.get(i1)).vFaceID));
          i1 += 1;
        }
        paramBundle.putStringArrayList("hexFaceInfo", paramFromServiceMsg);
        paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
        paramToServiceMsg = paramObject.a(paramToServiceMsg);
        i1 = paramToServiceMsg.getLocalPicKeysCount();
        if ((paramToServiceMsg != null) && (l1 == i1) && (i1 < paramToServiceMsg.getPicCountInAlbum()))
        {
          paramToServiceMsg.appendPortrait(paramFromServiceMsg);
          paramObject.a(paramToServiceMsg);
        }
        a(27, true, paramBundle);
        return;
      }
      paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
      paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
      paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
      paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
      a(27, false, paramBundle);
      return;
    }
    paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
    paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
    paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
    paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
    a(27, false, paramBundle);
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramBundle = (String)paramToServiceMsg.getAttribute("nickname");
    Byte localByte = (Byte)paramToServiceMsg.getAttribute("gender");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("birthday");
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|resp.getResultCode = " + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof SetUserInfoResp)))
    {
      paramObject = (SetUserInfoResp)paramObject;
      paramFromServiceMsg = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|setUserInfoResp.result = " + paramObject.result);
      }
    }
    for (paramFromServiceMsg = paramObject;; paramFromServiceMsg = null)
    {
      paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 0))
      {
        paramFromServiceMsg = paramToServiceMsg.getUin();
        Card localCard = paramObject.a(paramToServiceMsg.getUin());
        Friends localFriends = paramObject.c(paramFromServiceMsg);
        if (paramBundle != null)
        {
          if (localCard != null) {
            localCard.strNick = paramBundle;
          }
          if (localFriends != null)
          {
            localFriends.name = paramBundle;
            paramObject.a(localFriends);
          }
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFromServiceMsg)) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + paramFromServiceMsg, paramBundle);
          }
        }
        if (localByte != null)
        {
          if (localCard != null) {
            localCard.shGender = ((short)localByte.byteValue());
          }
          if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFromServiceMsg)) {}
        }
        if ((localInteger != null) && (localCard != null))
        {
          localCard.lBirthday = localInteger.intValue();
          localCard.shAge = ((short)ProfileUtil.a(localInteger.intValue()));
          localCard.age = ((byte)localCard.shAge);
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo()  age = " + localCard.age);
          }
        }
        if (localCard != null) {
          paramObject.a(localCard);
        }
        a(paramToServiceMsg, 31, true, localCard);
        return;
      }
      a(paramToServiceMsg, 31, false, paramObject.b(paramToServiceMsg.getUin()));
      return;
    }
  }
  
  protected Class a()
  {
    return CardObserver.class;
  }
  
  public ArrayList a()
  {
    Object localObject1 = null;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)localEntityManager.a(CardProfile.class, true, "type=?", new String[] { String.valueOf(2) }, null, null, "lTime desc", "7");
        localEntityManager.a();
        localObject1 = localArrayList;
        if (localArrayList == null) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      finally
      {
        localEntityManager.a();
        if (0 == 0) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public void a()
  {
    a(a("MCardSvc.ReqGetCardSwitch"));
  }
  
  public void a(byte paramByte, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setSelfGender|gender = " + paramByte);
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("gender", Byte.valueOf(paramByte));
    a(paramCardObserver);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.importQzonePhotoes()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(3);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    ((UpdatePhotoList.ReqBody)localObject).uint32_copy_count_from_qzone.set(paramInt);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5ea_3");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setBirthday|birthday = " + paramInt);
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("birthday", Integer.valueOf(paramInt));
    a(paramCardObserver);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqVote");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "MCardSvc.ReqPicSafetyCheck");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("lToUIN", paramLong2);
    localToServiceMsg.extraData.putLong("friendUin", paramLong2);
    localToServiceMsg.extraData.putInt("iScene", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, "reqFavorite|" + paramLong2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    a(localToServiceMsg);
  }
  
  public void a(PushVoteIncreaseInfo paramPushVoteIncreaseInfo, String paramString1, String paramString2)
  {
    Visitor localVisitor = (Visitor)paramPushVoteIncreaseInfo.vVoterList.get(0);
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = AppConstants.W;
    localMessageRecord.istroop = 0;
    localMessageRecord.senderuin = String.valueOf(localVisitor.lUIN);
    localMessageRecord.extraflag = paramPushVoteIncreaseInfo.iIncrement;
    localMessageRecord.time = (System.currentTimeMillis() / 1000L);
    new crm(this, paramPushVoteIncreaseInfo.iIncrement, paramPushVoteIncreaseInfo.vVoterList).start();
    try
    {
      Object localObject1 = new String(localVisitor.vecNick, "UTF8");
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() == 0) {
        localObject2 = String.valueOf(localVisitor.lUIN);
      }
      if (1 == paramPushVoteIncreaseInfo.iIncrement)
      {
        localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131363557), new Object[] { localObject2 });
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, paramString1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("newVoteCount", paramPushVoteIncreaseInfo.iIncrement);
        ((Bundle)localObject1).putString("sender", paramString2);
        ((Bundle)localObject1).putString("voteeUin", paramString1);
        ((Bundle)localObject1).putString("uin", paramString1);
        a(28, true, new Object[] { ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), localObject1 });
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        if (QLog.isColorLevel()) {
          QLog.w("accost", 2, "last voter's name. unsupported encoding.");
        }
        String str = "";
        continue;
        localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131363558), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
      }
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("friendUin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramFromServiceMsg.getUin();
    }
    if (c(paramFromServiceMsg.getServiceCmd())) {}
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
                    return;
                    localObject2 = new Bundle();
                    ((Bundle)localObject2).putString("uin", (String)localObject1);
                    if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      s(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("SummaryCard.ReqVoiceManage".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      r(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqCommonCard".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      q(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      i(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqHYCommonCard".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      p(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqHYMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      o(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      l(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("SummaryCard.SetLabel".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      m(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("SummaryCard.LikeIt".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      n(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqGetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      j(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqSetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      k(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("VisitorSvc.ReqVote".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      a(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      b(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      d(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("VisitorSvc.ReqGetFavoriteList".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      c(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("VisitorSvc.ReqGetVisitorList".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      e(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqUpdateQQFace".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      f(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqFaceInfo".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      h(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqAddFace".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      g(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqUpdateIntro".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
                      {
                        if (((RespUpdateIntro)paramObject).stHeader.iReplyCode == 0)
                        {
                          a(9, true, ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin()));
                          return;
                        }
                        a(9, false, localObject2);
                        return;
                      }
                      a(9, false, localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqDelFace".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      t(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("ProfileService.getFriendInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      if (paramFromServiceMsg.getResultCode() == 1000)
                      {
                        a(16, true, localObject2);
                        return;
                      }
                      a(16, false, localObject2);
                      return;
                    }
                    if ("ProfileService.getGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      if (paramFromServiceMsg.getResultCode() == 1000)
                      {
                        a(17, true, ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin()));
                        return;
                      }
                      a(17, false, localObject2);
                      return;
                    }
                    if ("ProfileService.SetUserInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      v(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if (!"AccostSvc.ClientMsg".equals(paramFromServiceMsg.getServiceCmd())) {
                      break;
                    }
                  } while (paramFromServiceMsg.getResultCode() != 1000);
                  paramToServiceMsg = (RespClientMsg)paramFromServiceMsg.getAttribute("result");
                } while ((paramToServiceMsg == null) || (1 != paramToServiceMsg.stMsg.eAccostType));
                a(22, true, localObject2);
                return;
                if ("AccostSvc.SvrMsg".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  if (paramFromServiceMsg.getResultCode() == 1000) {}
                  for (boolean bool = true;; bool = false)
                  {
                    a(29, bool, localObject2);
                    return;
                  }
                }
                if ("MobileQQ.SendPortraitDownloadVerifyCode".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  paramToServiceMsg = paramFromServiceMsg.extraData.getString("filekey");
                  ((Bundle)localObject2).putString("filekey", paramToServiceMsg);
                  if ((paramToServiceMsg != null) && (!"".equals(paramToServiceMsg)))
                  {
                    a(21, true, localObject2);
                    return;
                  }
                  a(21, false, localObject2);
                  return;
                }
                if ("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  ((Bundle)localObject2).putString("uin", String.valueOf(paramToServiceMsg.extraData.getLong("lToUIN")));
                  if (paramFromServiceMsg.getResultCode() == 1000)
                  {
                    a(23, true, localObject2);
                    return;
                  }
                  a(23, false, localObject2);
                  return;
                }
                if ("MCardSvc.ReqGetFace".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  u(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                  return;
                }
              } while ("PttCenterSvr.ReqBody".equals(paramFromServiceMsg.getServiceCmd()));
              if ("OidbSvc.0x490_100".equals(paramFromServiceMsg.getServiceCmd()))
              {
                b(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if ("OidbSvc.0x491_100".equals(paramFromServiceMsg.getServiceCmd()))
              {
                c(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (!"OidbSvc.0x480_9".equals(paramFromServiceMsg.getServiceCmd())) {
                break;
              }
            } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
            if (paramToServiceMsg.extraData.getBoolean("isGetLoginDays", false))
            {
              g(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ((paramToServiceMsg.extraData.getBoolean("activeGetDatingSymbol", false)) || (paramToServiceMsg.extraData.getBoolean("nearby_people_profile_ok_new", false)))
            {
              f(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            e(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
            if (!"OidbSvc.0x4ff_9".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
          } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
          if (paramToServiceMsg.extraData.getBoolean("isSetLoginDays", false))
          {
            h(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
        } while (paramToServiceMsg.extraData.getBoolean("pcActiveState", false));
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
        if ("OidbSvc.0x5ea_1".equals(paramFromServiceMsg.getServiceCmd()))
        {
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while ("OidbSvc.0x5ea_2".equals(paramFromServiceMsg.getServiceCmd()));
      if ("OidbSvc.0x5ea_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x5ea_4".equals(paramFromServiceMsg.getServiceCmd()));
    k(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt, byte paramByte, ArrayList paramArrayList1, byte[] paramArrayOfByte1, ArrayList paramArrayList2, ArrayList paramArrayList3, byte[] paramArrayOfByte2)
  {
    paramString = a("MCardSvc.ReqSetCard");
    paramString.extraData.putInt("eSubCmd", paramInt);
    paramString.extraData.putByte("bIsSingle", paramByte);
    paramString.extraData.putByteArray("vBackground", paramArrayOfByte1);
    paramString.extraData.putByteArray("vReqSetTemplate", paramArrayOfByte2);
    try
    {
      paramArrayOfByte1 = new ByteArrayOutputStream();
      paramArrayOfByte2 = new ObjectOutputStream(paramArrayOfByte1);
      paramArrayOfByte2.writeObject(paramArrayList1);
      paramArrayOfByte2.flush();
      paramString.extraData.putByteArray("vTagsID", paramArrayOfByte1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList2);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vDelTags", paramArrayList1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList3);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vAddTags", paramArrayList1.toByteArray());
      a(paramString);
      return;
    }
    catch (IOException paramArrayList1)
    {
      for (;;)
      {
        paramArrayList1.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCardSvc.ReqGetFace");
    localToServiceMsg.extraData.putString("lUin", paramString);
    localToServiceMsg.extraData.putLong("lNextMid", paramLong);
    localToServiceMsg.extraData.putInt("iPageSize", paramInt);
    localToServiceMsg.extraData.putByteArray("strCookie", paramArrayOfByte);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "deleteLbsPortrait() uin = " + paramString);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCardSvc.ReqDelFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localToServiceMsg.extraData.putByteArray("filekey", paramArrayOfByte);
    localToServiceMsg.extraData.putLong("timestamp", paramLong);
    localToServiceMsg.extraData.putString("touin", paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localToServiceMsg);
  }
  
  public void a(String paramString, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setSelfNickname|nickName = " + paramString);
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("nickname", paramString);
    a(paramCardObserver);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, int paramInt)
  {
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "MCardSvc.ReqHYMakeFriendsCard");
    paramString1.extraData.putString("friendUin", paramString2);
    paramString1.extraData.putByte("bReqType", paramByte);
    paramString1.extraData.putInt("uFaceTimeStamp", paramInt);
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2)
  {
    a(paramString1, paramString2, paramInt1, paramLong1, paramByte, paramLong2, paramLong3, paramArrayOfByte1, paramString3, paramLong4, paramInt2, paramArrayOfByte2, 0L, false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt1).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
      paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
      paramString1.extraData.putLong("selfUin", l1);
      paramString1.extraData.putLong("targetUin", l2);
      paramString1.extraData.putInt("comeFromType", paramInt1);
      paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
      paramString1.extraData.putByte("isFriend", paramByte);
      paramString1.extraData.putLong("troopCode", paramLong2);
      paramString1.extraData.putLong("troopUin", paramLong3);
      paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
      paramString1.extraData.putString("strSearchName", paramString3);
      paramString1.extraData.putLong("lGetControl", paramLong4);
      paramString1.extraData.putInt("EAddFriendSource", paramInt2);
      paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
      paramString1.extraData.putLong("tinyId", paramLong5);
      paramString1.extraData.putBoolean("isNearbyPeopleCard", paramBoolean);
      a(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, "qq_error|getSummayCard() " + paramString1.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetVoterList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, Long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.LikeIt");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("destUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("labelId", paramLong.longValue());
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, short paramShort)
  {
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "MCardSvc.ReqUpdateIntro");
    paramString1.extraData.putString("vContent", paramString2);
    paramString1.extraData.putShort("shType", paramShort);
    a(paramString1);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        ((StringBuilder)localObject).append(paramArrayList.get(i1)).append(", ");
        i1 += 1;
      }
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.updateNearbyPeoplePhotoList(), photo_ids = " + ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1514);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
    localReqBody.rpt_uint32_headids.set(paramArrayList);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramArrayList = a("OidbSvc.0x5ea_1");
    paramArrayList.setTimeout(30000L);
    paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    b(paramArrayList);
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((ProfileLabelInfo)paramList.next()).labelId);
      }
      paramList = a("SummaryCard.SetLabel");
      paramList.extraData.putSerializable("labels", (Serializable)localArrayList);
      a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i1 = 0;
    }
    ((ByteBuffer)localObject).put((byte)i1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x491_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_searchable", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "uploadAvatarResult|isSuc = " + paramBoolean);
    }
    String str = ProfileCardUtil.c();
    ProfileCardUtil.a(null);
    EntityManager localEntityManager;
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject2 = (Setting)localEntityManager.a(Setting.class, paramString);
      if (localObject2 != null) {
        break label264;
      }
      localObject1 = new Setting();
      ((Setting)localObject1).uin = paramString;
      ((Setting)localObject1).bHeadType = 1;
      ((Setting)localObject1).bUsrType = 1;
      localEntityManager.a((Entity)localObject1);
    }
    for (;;)
    {
      localEntityManager.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((Setting)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        FileUtils.d((String)localObject1);
      }
      localObject2 = ProfileCardUtil.a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        FileUtils.d((String)localObject2);
      }
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString, 0);
      if (!TextUtils.isEmpty(str))
      {
        ImageUtil.a(null, str, (String)localObject1, 100, 100);
        FileUtils.c(str, (String)localObject2);
      }
      if (!TextUtils.isEmpty(str)) {
        FileUtils.d(str);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", paramString);
      a(8, paramBoolean, localObject1);
      return;
      label264:
      localObject1 = localObject2;
      if (((Setting)localObject2).bHeadType == 0)
      {
        ((Setting)localObject2).bHeadType = 1;
        localEntityManager.a((Entity)localObject2);
        localObject1 = localObject2;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ToServiceMsg localToServiceMsg = a("MCardSvc.ReqSetCardSwitch");
    localToServiceMsg.extraData.putBoolean("modify_switch_for_near_people", paramBoolean1);
    Bundle localBundle = localToServiceMsg.extraData;
    if (paramBoolean2) {}
    for (long l1 = 0L;; l1 = 1L)
    {
      localBundle.putLong("target_value", l1);
      a(localToServiceMsg);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCardSvc.ReqAddFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localToServiceMsg.extraData.putInt("timestamp", paramInt);
    localToServiceMsg.extraData.putByteArray("filekey", paramArrayOfByte);
    a(localToServiceMsg);
  }
  
  public void a(int[] paramArrayOfInt, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setCity");
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("city", paramArrayOfInt);
    a(paramCardObserver);
  }
  
  public ArrayList b()
  {
    Object localObject1 = null;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)localEntityManager.a(CardProfile.class, true, "type=?", new String[] { String.valueOf(3) }, null, null, "lTime desc", "7");
        localEntityManager.a();
        localObject1 = localArrayList;
        if (localArrayList == null) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      finally
      {
        localEntityManager.a();
        if (0 == 0) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public void b()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, "reqFavorite|" + paramLong2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putBoolean("nearby_people", true);
    a(localToServiceMsg);
  }
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new crn(this, paramBundle));
  }
  
  public void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetFavoriteList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  /* Error */
  protected void b(String paramString, List paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +82 -> 83
    //   4: aload_2
    //   5: invokeinterface 291 1 0
    //   10: ifle +73 -> 83
    //   13: aload_0
    //   14: getfield 383	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 615	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   20: invokevirtual 621	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +58 -> 83
    //   28: aload_1
    //   29: invokevirtual 2834	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   32: invokevirtual 2837	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   35: aload_2
    //   36: invokeinterface 458 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 463 1 0
    //   48: ifeq +36 -> 84
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 467 1 0
    //   58: checkcast 786	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 881	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 1440	java/lang/Exception:printStackTrace	()V
    //   72: aload_1
    //   73: invokevirtual 2834	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   76: invokevirtual 2839	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   79: aload_1
    //   80: invokevirtual 1920	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 2834	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   88: invokevirtual 2841	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   91: aload_1
    //   92: invokevirtual 2834	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   95: invokevirtual 2839	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   98: aload_1
    //   99: invokevirtual 1920	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 2834	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   108: invokevirtual 2839	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   111: aload_1
    //   112: invokevirtual 1920	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	CardHandler
    //   0	117	1	paramString	String
    //   0	117	2	paramList	List
    // Exception table:
    //   from	to	target	type
    //   28	42	67	java/lang/Exception
    //   42	64	67	java/lang/Exception
    //   84	91	67	java/lang/Exception
    //   28	42	103	finally
    //   42	64	103	finally
    //   68	72	103	finally
    //   84	91	103	finally
  }
  
  public void b(boolean paramBoolean)
  {
    short s1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setLoginDaysSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort((short)2).putShort(s1);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetLoginDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
      }
      s1 = 0;
    }
  }
  
  public ArrayList c()
  {
    Object localObject1 = null;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)localEntityManager.a(CardProfile.class, true, "type=?", new String[] { String.valueOf(1) }, null, null, "lTime desc", "8");
        localEntityManager.a();
        localObject1 = localArrayList;
        if (localArrayList == null) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      finally
      {
        localEntityManager.a();
        if (0 == 0) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public void c(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetVisitorList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  protected boolean c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqSummaryCard");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqVoiceManage");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqCommonCard");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqMakeFriendsCard");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqHYCommonCard");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqHYMakeFriendsCard");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqSetCard");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.SetLabel");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.LikeIt");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqGetCardSwitch");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqSetCardSwitch");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqVote");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqFavorite");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqGetVoterList");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqGetFavoriteList");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqGetVisitorList");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqUpdateQQFace");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqFaceInfo");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqAddFace");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqUpdateIntro");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqDelFace");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.getFriendInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.getGroupInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.GetSglUsrFullInfo");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.SetUserInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("AccostSvc.ClientMsg");
      this.jdField_a_of_type_JavaUtilSet.add("AccostSvc.SvrMsg");
      this.jdField_a_of_type_JavaUtilSet.add("MobileQQ.SendPortraitDownloadVerifyCode");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqPicSafetyCheck");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqGetFace");
      this.jdField_a_of_type_JavaUtilSet.add("PttCenterSvr.ReqBody");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x490_100");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x491_100");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x480_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x4ff_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_4");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)20037));
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)-25040));
    a(localArrayList, null);
  }
  
  public void f()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)27037));
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)24008));
    localArrayList.add(Short.valueOf((short)24002));
    localArrayList.add(Short.valueOf((short)20043));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)20011));
    localArrayList.add(Short.valueOf((short)20019));
    localArrayList.add(Short.valueOf((short)20021));
    localArrayList.add(Short.valueOf((short)20037));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("reqFromDetailActivity", true);
    a(localArrayList, localBundle);
  }
  
  public void g()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25040));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("nearby_people_profile_ok_new", true);
    a(localArrayList, localBundle);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.jdField_b_of_type_Short));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetLoginDays", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, "CardHandler.queryImportQzonePhotoesStatus()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(4);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5ea_4");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler
 * JD-Core Version:    0.7.0.1
 */