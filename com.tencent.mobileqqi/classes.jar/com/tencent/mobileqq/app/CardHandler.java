package com.tencent.mobileqq.app;

import AccostSvc.Msg;
import AccostSvc.RespClientMsg;
import KQQ.ProfSmpInfoRes;
import KQQ.ProfUsrFullInfoRes;
import KQQ.SetUserInfoResp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
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
import QQService.RespGetVisitorList;
import QQService.RespGetVoterList;
import QQService.RespHYCommonCard;
import QQService.RespHYMakeFriendsCard;
import QQService.RespMakeFriendsCard;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.RespUpdateIntro;
import QQService.RespUpdateQQFace;
import QQService.RespVote;
import QQService.UserCntlData;
import QQService.UserProfile;
import QQService.Visitor;
import SummaryCard.RespVoiceManage;
import SummaryCardTaf.SSummaryCardRsp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.TagInfoAdapter;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ezl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CardHandler
  extends BusinessHandler
{
  public static final int A = 30;
  public static final int B = 31;
  public static final int C = 32;
  public static final int D = 33;
  public static final int E = 34;
  public static final int F = 35;
  public static final int G = 36;
  public static final int H = 37;
  public static final int I = 38;
  public static final int J = 39;
  public static final int K = 40;
  public static final int L = 41;
  public static final int M = 0;
  public static final int N = 60;
  public static final int O = 100;
  public static final int P = 160;
  public static final int Q = 640;
  public static final int R = 960;
  public static final int S = 120;
  public static final int a = 0;
  public static final String a;
  public static final Vector a;
  public static final int b = 1;
  public static final String b = "background";
  public static final Vector b = new Vector();
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
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 12;
  public static final int m = 13;
  public static final int n = 16;
  public static final int o = 17;
  public static final int p = 19;
  public static final int q = 20;
  public static final int r = 21;
  public static final int s = 22;
  public static final int t = 23;
  public static final int u = 24;
  public static final int v = 25;
  public static final int w = 26;
  public static final int x = 27;
  public static final int y = 28;
  public static final int z = 29;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.an + "portrait/";
    jdField_a_of_type_JavaUtilVector = new Vector();
  }
  
  CardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    if (jdField_a_of_type_JavaUtilVector.size() == 0)
    {
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
    }
    if (b.size() == 0)
    {
      b.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(960));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(120));
    }
  }
  
  public static int a(Context paramContext)
  {
    int i1 = Math.min(paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
    if (i1 >= 720) {
      return 160;
    }
    if (i1 >= 640) {
      return 140;
    }
    if (i1 >= 480) {
      return 100;
    }
    return 60;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "onRecievGetFullInfo() ");
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (ProfUsrFullInfoRes)paramObject;
      paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      Object localObject = (String)paramToServiceMsg.getAttribute("uin");
      paramToServiceMsg = paramObject.b((String)localObject);
      try
      {
        long l1 = Long.parseLong((String)localObject);
        paramToServiceMsg.strReMark = ((String)paramFromServiceMsg.sRemarkInfo.get(Long.valueOf(l1)));
        if (paramFromServiceMsg.strPfileSmpInfoRes != null)
        {
          paramToServiceMsg.lBirthday = paramFromServiceMsg.strPfileSmpInfoRes.dwBirthday;
          paramToServiceMsg.shGender = ((short)paramFromServiceMsg.strPfileSmpInfoRes.cSex);
          paramToServiceMsg.strNick = paramFromServiceMsg.strPfileSmpInfoRes.strNick;
          if ((paramFromServiceMsg.sSigInfo != null) && (!"".equals(paramFromServiceMsg.sSigInfo))) {
            paramToServiceMsg.strSign = paramFromServiceMsg.sSigInfo;
          }
          localObject = TagInfoAdapter.a(paramFromServiceMsg.sTagInfo);
          if ((localObject != null) && (((ArrayList)localObject).size() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.Detail", 2, "onRecievGetFullInfo() 个性标签有拉下来");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((ArrayList)localObject);
            paramToServiceMsg.setTagInfosByte(localObject);
          }
          paramToServiceMsg.shAge = ((short)ProfileUtil.a((int)paramFromServiceMsg.strPfileSmpInfoRes.dwBirthday));
          paramToServiceMsg.age = ((byte)paramToServiceMsg.shAge);
        }
        paramObject.a(paramToServiceMsg);
        paramObject.b(String.valueOf(l1), (String)paramFromServiceMsg.sRemarkInfo.get(Long.valueOf(l1)));
        i1 = 0;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          int i1 = 1;
        }
        a(20, false, paramBundle);
        return;
      }
      if (i1 == 0)
      {
        a(20, true, paramToServiceMsg);
        return;
      }
    }
    a(20, false, paramBundle);
  }
  
  public static void a(String paramString, List paramList) {}
  
  protected static int b(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i1 = paramContext.widthPixels;
    int i2 = paramContext.heightPixels;
    if (i1 > i2) {
      return i1;
    }
    return i2;
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
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l1 = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
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
  
  public static int c(Context paramContext)
  {
    return 640;
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
    paramFromServiceMsg = paramFromServiceMsg.getAttribute("result");
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    paramBundle.putString("targetUin", Long.toString(l1));
    paramBundle.putString("selfUin", Long.toString(l2));
    if ((paramFromServiceMsg != null) && ((paramFromServiceMsg instanceof RespFavorite)) && (((RespFavorite)paramFromServiceMsg).stHeader.iReplyCode == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l1 > 0L))
      {
        paramToServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramFromServiceMsg = paramToServiceMsg.a(String.valueOf(l1));
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.lVoteCount -= 1L;
          paramFromServiceMsg.bVoted = 0;
          paramToServiceMsg.a(paramFromServiceMsg);
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.profilecard.", 4, "reqFavorite fail, revertdata | lVoteCount = " + paramFromServiceMsg.lVoteCount);
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.", 4, "back reqFavorite| result = " + bool + "," + l1);
      }
      a(32, bool, paramBundle);
      return;
    }
  }
  
  private void c(String paramString, List paramList)
  {
    b(paramString, paramList);
  }
  
  public static int d(Context paramContext)
  {
    int i1 = b(paramContext);
    if (i1 <= 240) {
      return 60;
    }
    if (i1 <= 320) {
      return 100;
    }
    return 160;
  }
  
  public static void d()
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
          label179:
          i2 += 1;
        }
        localSecurityException1 = localSecurityException1;
        bool1 = bool2;
      }
      catch (SecurityException localSecurityException2)
      {
        break label179;
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    EntityManager localEntityManager;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      paramObject = (QZoneCover)localEntityManager.a(QZoneCover.class, str);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZoneCover();
        paramToServiceMsg.uin = str;
      }
      paramToServiceMsg.updateQzoneCover(paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localEntityManager.a(paramToServiceMsg);
        localEntityManager.a();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      a(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      localEntityManager.a(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
    }
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
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = new ArrayList();
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespGetVisitorList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramObject = b();
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
    paramToServiceMsg = b();
    paramBundle.putLong("startMid", -1L);
    a(7, false, new Object[] { paramBundle, paramToServiceMsg });
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
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespGetCardSwitch)paramObject;
      long l1 = paramFromServiceMsg.uCloseNeighborVote;
      long l2 = paramFromServiceMsg.uCloseTimeGateVote;
      paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      paramObject = paramFromServiceMsg.b(paramToServiceMsg.getUin());
      if (l1 == 0L)
      {
        bool = true;
        paramObject.setZanShowFlag(bool);
        paramFromServiceMsg.a(paramObject);
        paramFromServiceMsg = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131561651) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
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
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
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
        localSharedPreferences.edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131561651) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), bool1).commit();
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
      paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
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
    for (boolean bool1 = paramObject.isShowZan();; bool1 = localSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131561651) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false))
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
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int i1 = paramToServiceMsg.extraData.getInt("eSubCmd");
    paramBundle.putInt("eSubCmd", i1);
    paramBundle.putByte("bIsSingle", paramToServiceMsg.extraData.getByte("bIsSingle"));
    paramBundle.putByteArray("vBackground", paramToServiceMsg.extraData.getByteArray("vBackground"));
    paramBundle.putByteArray("vReqSetTemplate", paramToServiceMsg.extraData.getByteArray("vReqSetTemplate"));
    switch (i1)
    {
    default: 
      i1 = 3;
      if (26 == i1) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      }
      paramBundle = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      if (paramFromServiceMsg.isSuccess()) {
        if (26 == i1)
        {
          paramObject = paramBundle.a(paramToServiceMsg.getUin());
          paramFromServiceMsg = paramObject;
          if (paramObject == null) {
            break label685;
          }
          paramObject.vBackground = paramToServiceMsg.extraData.getByteArray("vBackground");
          paramBundle.a(paramObject);
          paramToServiceMsg = paramObject;
        }
      }
      break;
    }
    label423:
    label685:
    label816:
    label821:
    for (;;)
    {
      if (i1 != 41) {
        a(i1, true, paramToServiceMsg);
      }
      return;
      i1 = 24;
      break;
      i1 = 25;
      break;
      i1 = 26;
      break;
      i1 = 41;
      break;
      if (i1 == 25)
      {
        try
        {
          paramFromServiceMsg = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vTagsID"))).readObject();
          paramToServiceMsg = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
        }
        catch (Exception paramFromServiceMsg)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramFromServiceMsg);
            paramToServiceMsg.setTagInfosByte(paramFromServiceMsg);
            paramBundle.a(paramToServiceMsg);
          }
          catch (Exception paramFromServiceMsg)
          {
            for (;;)
            {
              boolean bool;
              continue;
              paramFromServiceMsg = null;
              continue;
              paramFromServiceMsg = null;
              paramToServiceMsg = null;
            }
            paramToServiceMsg = null;
          }
          paramFromServiceMsg = paramFromServiceMsg;
          paramToServiceMsg = null;
        }
        paramFromServiceMsg.printStackTrace();
      }
      else if (i1 == 24)
      {
        paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.extraData.getByte("bIsSingle"));
        paramToServiceMsg = paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      else if (i1 == 41)
      {
        if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespSetCard)))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard success : " + bool + ", data : " + paramObject);
          }
          if ((paramObject == null) || (!bool)) {
            break label821;
          }
          paramToServiceMsg = (RespSetCard)paramObject;
          if ((QLog.isColorLevel()) && (paramToServiceMsg != null)) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard RespSetCard : " + paramToServiceMsg.toString());
          }
          if ((paramToServiceMsg.stHeader == null) || (paramToServiceMsg.stHeader.iReplyCode != 0) || (paramToServiceMsg.vRespSetTemplate == null)) {
            break label821;
          }
          paramFromServiceMsg = (SSummaryCardRsp)a(paramToServiceMsg.vRespSetTemplate, "rsp", new SSummaryCardRsp());
          if (paramFromServiceMsg == null) {
            break label821;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard cardRsp res : " + paramFromServiceMsg.res);
          }
          switch (paramFromServiceMsg.res)
          {
          default: 
            paramFromServiceMsg = new Pair(Integer.valueOf((int)paramFromServiceMsg.cardid), Integer.valueOf(paramFromServiceMsg.res));
            paramToServiceMsg = null;
          }
        }
        for (;;)
        {
          if (paramToServiceMsg != null) {
            paramFromServiceMsg = paramToServiceMsg;
          }
          a(i1, true, paramFromServiceMsg);
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramFromServiceMsg;
          break;
          bool = false;
          break label423;
          paramToServiceMsg = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if (paramToServiceMsg == null) {
            break label816;
          }
          paramToServiceMsg.lCurrentTemplateId = paramFromServiceMsg.cardid;
          paramToServiceMsg.templateRet = 0;
          paramBundle.a(paramToServiceMsg);
          paramFromServiceMsg = null;
          continue;
          paramFromServiceMsg = new Pair(Integer.valueOf((int)paramFromServiceMsg.cardid), Integer.valueOf(101107));
          paramToServiceMsg = null;
          continue;
          paramFromServiceMsg = new Pair(Integer.valueOf((int)paramFromServiceMsg.cardid), Integer.valueOf(101108));
          paramToServiceMsg = null;
        }
        a(i1, false, paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        return;
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYMakeFriendsCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
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
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYCommonCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
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
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.d(paramToServiceMsg.uin) != null)) {
          paramFromServiceMsg.d();
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
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
            break label500;
          }
          paramBundle = Integer.valueOf(localRespHead.iResult);
          label160:
          QLog.d("Q.profilecard.SummaryCard", 2, paramBundle);
        }
        if (localRespHead != null) {
          break label506;
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
        break label739;
      }
      paramBundle = (RespVoiceManage)paramObject;
      if (l1 > 0L)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
        paramObject = paramFromServiceMsg.b(String.valueOf(l1));
        if (paramBundle.eOpType != 1) {
          break label649;
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
      label500:
      paramBundle = null;
      break label160;
      label506:
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
      label649:
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
      label739:
      a(35, false, new Object[] { String.valueOf(l1), Integer.valueOf(i2), null });
    }
  }
  
  /* Error */
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc_w 1101
    //   9: iconst_2
    //   10: new 113	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1188
    //   20: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 631	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   27: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: invokestatic 544	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   39: ifeq +2716 -> 2755
    //   42: invokestatic 1193	java/lang/System:currentTimeMillis	()J
    //   45: lstore 9
    //   47: aconst_null
    //   48: astore 4
    //   50: aload_2
    //   51: invokevirtual 631	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   54: sipush 1000
    //   57: if_icmpne +272 -> 329
    //   60: aload_3
    //   61: instanceof 1195
    //   64: ifeq +265 -> 329
    //   67: iconst_1
    //   68: istore 5
    //   70: iload 5
    //   72: istore 6
    //   74: iload 5
    //   76: ifeq +46 -> 122
    //   79: aload_0
    //   80: aload_2
    //   81: invokevirtual 1113	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   84: ldc_w 1115
    //   87: new 1117	SummaryCard/RespHead
    //   90: dup
    //   91: invokespecial 1118	SummaryCard/RespHead:<init>	()V
    //   94: invokevirtual 992	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 1117	SummaryCard/RespHead
    //   100: astore_2
    //   101: aload_2
    //   102: ifnull +233 -> 335
    //   105: aload_2
    //   106: getfield 1123	SummaryCard/RespHead:iResult	I
    //   109: istore 5
    //   111: iload 5
    //   113: ifne +222 -> 335
    //   116: iconst_1
    //   117: istore 6
    //   119: aload_2
    //   120: astore 4
    //   122: aload_1
    //   123: getfield 485	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   126: ldc_w 487
    //   129: invokevirtual 536	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   132: lstore 13
    //   134: aload_1
    //   135: getfield 485	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   138: ldc_w 1197
    //   141: invokevirtual 492	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_2
    //   145: iload 6
    //   147: ifeq +2575 -> 2722
    //   150: aload_0
    //   151: getfield 294	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   154: bipush 46
    //   156: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   159: checkcast 302	com/tencent/mobileqq/app/FriendsManager
    //   162: astore 19
    //   164: aload_0
    //   165: getfield 294	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   168: bipush 47
    //   170: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   173: checkcast 1199	com/tencent/mobileqq/app/TroopManager
    //   176: astore 17
    //   178: aload_3
    //   179: checkcast 1195	SummaryCard/RespSummaryCard
    //   182: astore 16
    //   184: lload 13
    //   186: lconst_0
    //   187: lcmp
    //   188: ifgt +184 -> 372
    //   191: aload_1
    //   192: getfield 485	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   195: ldc_w 1201
    //   198: invokevirtual 771	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   201: bipush 37
    //   203: if_icmpeq +169 -> 372
    //   206: aload 19
    //   208: aload_2
    //   209: invokevirtual 1204	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ContactCard;
    //   212: astore_1
    //   213: aload_1
    //   214: aload 16
    //   216: getfield 1207	SummaryCard/RespSummaryCard:bAge	B
    //   219: putfield 1210	com/tencent/mobileqq/data/ContactCard:bAge	B
    //   222: aload_1
    //   223: aload 16
    //   225: getfield 1213	SummaryCard/RespSummaryCard:bSex	B
    //   228: putfield 1214	com/tencent/mobileqq/data/ContactCard:bSex	B
    //   231: aload_1
    //   232: aload 16
    //   234: getfield 1215	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   237: putfield 1218	com/tencent/mobileqq/data/ContactCard:nickName	Ljava/lang/String;
    //   240: aload_1
    //   241: aload 16
    //   243: getfield 1221	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   246: putfield 1222	com/tencent/mobileqq/data/ContactCard:strProvince	Ljava/lang/String;
    //   249: aload_1
    //   250: aload 16
    //   252: getfield 1225	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   255: putfield 1226	com/tencent/mobileqq/data/ContactCard:strCountry	Ljava/lang/String;
    //   258: aload_1
    //   259: aload 16
    //   261: getfield 1229	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   264: putfield 1230	com/tencent/mobileqq/data/ContactCard:strCity	Ljava/lang/String;
    //   267: aload_1
    //   268: aload 16
    //   270: getfield 1233	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   273: putfield 1234	com/tencent/mobileqq/data/ContactCard:strContactName	Ljava/lang/String;
    //   276: aload 19
    //   278: aload_1
    //   279: invokevirtual 1237	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ContactCard;)Z
    //   282: pop
    //   283: aload_0
    //   284: iconst_1
    //   285: iconst_1
    //   286: aload_1
    //   287: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   290: invokestatic 544	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   293: ifeq +35 -> 328
    //   296: ldc_w 1101
    //   299: iconst_4
    //   300: new 113	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 1239
    //   310: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokestatic 1193	java/lang/System:currentTimeMillis	()J
    //   316: lload 9
    //   318: lsub
    //   319: invokevirtual 551	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 553	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: return
    //   329: iconst_0
    //   330: istore 5
    //   332: goto -262 -> 70
    //   335: iconst_0
    //   336: istore 6
    //   338: goto -219 -> 119
    //   341: astore 4
    //   343: aconst_null
    //   344: astore_2
    //   345: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +15 -> 363
    //   351: ldc_w 1101
    //   354: iconst_2
    //   355: aload 4
    //   357: invokevirtual 1169	java/lang/Exception:toString	()Ljava/lang/String;
    //   360: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: iconst_0
    //   364: istore 6
    //   366: aload_2
    //   367: astore 4
    //   369: goto -247 -> 122
    //   372: lload 13
    //   374: lstore 11
    //   376: lload 13
    //   378: lconst_0
    //   379: lcmp
    //   380: ifgt +29 -> 409
    //   383: lload 13
    //   385: lstore 11
    //   387: aload_1
    //   388: getfield 485	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   391: ldc_w 1201
    //   394: invokevirtual 771	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   397: bipush 37
    //   399: if_icmpne +10 -> 409
    //   402: aload 16
    //   404: getfield 1240	SummaryCard/RespSummaryCard:lUIN	J
    //   407: lstore 11
    //   409: lload 11
    //   411: invokestatic 402	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   414: astore 20
    //   416: aload 19
    //   418: aload 20
    //   420: invokevirtual 313	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   423: astore 18
    //   425: aload 18
    //   427: aload 16
    //   429: getfield 1243	SummaryCard/RespSummaryCard:iLevel	I
    //   432: putfield 1050	com/tencent/mobileqq/data/Card:iQQLevel	I
    //   435: aload 18
    //   437: aload 16
    //   439: getfield 1215	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   442: putfield 358	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   445: aload 18
    //   447: aload 16
    //   449: getfield 1213	SummaryCard/RespSummaryCard:bSex	B
    //   452: i2s
    //   453: putfield 354	com/tencent/mobileqq/data/Card:shGender	S
    //   456: aload 18
    //   458: aload 16
    //   460: getfield 1207	SummaryCard/RespSummaryCard:bAge	B
    //   463: i2s
    //   464: putfield 393	com/tencent/mobileqq/data/Card:shAge	S
    //   467: aload 18
    //   469: aload 16
    //   471: getfield 1207	SummaryCard/RespSummaryCard:bAge	B
    //   474: putfield 396	com/tencent/mobileqq/data/Card:age	B
    //   477: aload 18
    //   479: aload 16
    //   481: getfield 1246	SummaryCard/RespSummaryCard:iFace	I
    //   484: putfield 807	com/tencent/mobileqq/data/Card:nFaceID	I
    //   487: aload 18
    //   489: aload 16
    //   491: getfield 1247	SummaryCard/RespSummaryCard:strSign	Ljava/lang/String;
    //   494: putfield 364	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   497: aload 18
    //   499: aload 16
    //   501: getfield 1229	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   504: putfield 1248	com/tencent/mobileqq/data/Card:strCity	Ljava/lang/String;
    //   507: aload 18
    //   509: aload 16
    //   511: getfield 1221	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   514: putfield 1249	com/tencent/mobileqq/data/Card:strProvince	Ljava/lang/String;
    //   517: aload 18
    //   519: aload 16
    //   521: getfield 1225	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   524: putfield 1250	com/tencent/mobileqq/data/Card:strCountry	Ljava/lang/String;
    //   527: aload 18
    //   529: aload 16
    //   531: getfield 1253	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   534: putfield 336	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   537: aload 18
    //   539: aload 16
    //   541: getfield 1256	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   544: putfield 756	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   547: aload 18
    //   549: aload 16
    //   551: getfield 1259	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   554: putfield 1262	com/tencent/mobileqq/data/Card:strTroopName	Ljava/lang/String;
    //   557: aload 18
    //   559: aload 16
    //   561: getfield 1265	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   564: putfield 1268	com/tencent/mobileqq/data/Card:strTroopNick	Ljava/lang/String;
    //   567: aload 18
    //   569: aload 16
    //   571: getfield 1271	SummaryCard/RespSummaryCard:strMobile	Ljava/lang/String;
    //   574: putfield 1272	com/tencent/mobileqq/data/Card:strMobile	Ljava/lang/String;
    //   577: aload 18
    //   579: aload 16
    //   581: getfield 1233	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   584: putfield 1273	com/tencent/mobileqq/data/Card:strContactName	Ljava/lang/String;
    //   587: aload 18
    //   589: aload 16
    //   591: getfield 1276	SummaryCard/RespSummaryCard:strStatus	Ljava/lang/String;
    //   594: putfield 1277	com/tencent/mobileqq/data/Card:strStatus	Ljava/lang/String;
    //   597: aload 18
    //   599: aload 16
    //   601: getfield 1280	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   604: putfield 1281	com/tencent/mobileqq/data/Card:strAutoRemark	Ljava/lang/String;
    //   607: aload 18
    //   609: aload 16
    //   611: getfield 1284	SummaryCard/RespSummaryCard:vSeed	[B
    //   614: putfield 1285	com/tencent/mobileqq/data/Card:vSeed	[B
    //   617: aload 18
    //   619: aload 16
    //   621: getfield 1288	SummaryCard/RespSummaryCard:iVoteCount	I
    //   624: i2l
    //   625: putfield 841	com/tencent/mobileqq/data/Card:lVisitCount	J
    //   628: aload 18
    //   630: aload 16
    //   632: getfield 1291	SummaryCard/RespSummaryCard:uQQMasterLoginDays	J
    //   635: putfield 1294	com/tencent/mobileqq/data/Card:lQQMasterLogindays	J
    //   638: aload_1
    //   639: getfield 485	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   642: ldc_w 1201
    //   645: invokevirtual 771	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   648: bipush 37
    //   650: if_icmpne +18 -> 668
    //   653: aload 18
    //   655: aload_1
    //   656: getfield 485	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   659: ldc_w 1197
    //   662: invokevirtual 492	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   665: putfield 1297	com/tencent/mobileqq/data/Card:encId	Ljava/lang/String;
    //   668: aload 4
    //   670: ifnull +13 -> 683
    //   673: aload 18
    //   675: aload 4
    //   677: getfield 1300	SummaryCard/RespHead:vCookies	[B
    //   680: putfield 1301	com/tencent/mobileqq/data/Card:vCookies	[B
    //   683: aload 16
    //   685: getfield 1304	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   688: ifne +255 -> 943
    //   691: aload 18
    //   693: iconst_1
    //   694: putfield 522	com/tencent/mobileqq/data/Card:bVoted	B
    //   697: aload 18
    //   699: aload 16
    //   701: getfield 1288	SummaryCard/RespSummaryCard:iVoteCount	I
    //   704: i2l
    //   705: putfield 519	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   708: aload 18
    //   710: aload 18
    //   712: getfield 847	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   715: aload 16
    //   717: getfield 1307	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   720: iadd
    //   721: putfield 847	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   724: aload 16
    //   726: getfield 1310	SummaryCard/RespSummaryCard:ulShowControl	J
    //   729: ldc2_w 1311
    //   732: land
    //   733: lconst_0
    //   734: lcmp
    //   735: ifne +217 -> 952
    //   738: iconst_0
    //   739: istore 15
    //   741: aload 18
    //   743: iload 15
    //   745: invokevirtual 880	com/tencent/mobileqq/data/Card:setZanShowFlag	(Z)V
    //   748: aload 16
    //   750: getfield 1310	SummaryCard/RespSummaryCard:ulShowControl	J
    //   753: lconst_1
    //   754: land
    //   755: lconst_0
    //   756: lcmp
    //   757: ifne +201 -> 958
    //   760: iconst_0
    //   761: istore 15
    //   763: aload 18
    //   765: iload 15
    //   767: invokevirtual 1315	com/tencent/mobileqq/data/Card:setFeedsShowFlag	(Z)V
    //   770: aload 16
    //   772: getfield 1310	SummaryCard/RespSummaryCard:ulShowControl	J
    //   775: ldc2_w 1316
    //   778: land
    //   779: lconst_0
    //   780: lcmp
    //   781: ifne +183 -> 964
    //   784: iconst_0
    //   785: istore 15
    //   787: aload 18
    //   789: iload 15
    //   791: invokevirtual 1320	com/tencent/mobileqq/data/Card:setPhotoShowFlag	(Z)V
    //   794: aload 16
    //   796: getfield 1323	SummaryCard/RespSummaryCard:lCacheControl	J
    //   799: lconst_0
    //   800: lcmp
    //   801: ifne +169 -> 970
    //   804: iconst_0
    //   805: istore 15
    //   807: aload 18
    //   809: iload 15
    //   811: invokevirtual 1326	com/tencent/mobileqq/data/Card:setPhotoUseCacheFlag	(Z)V
    //   814: aload 16
    //   816: getfield 1310	SummaryCard/RespSummaryCard:ulShowControl	J
    //   819: ldc2_w 1327
    //   822: land
    //   823: lconst_0
    //   824: lcmp
    //   825: ifne +151 -> 976
    //   828: iconst_0
    //   829: istore 15
    //   831: aload 18
    //   833: iload 15
    //   835: invokevirtual 1331	com/tencent/mobileqq/data/Card:setXManFlag	(Z)V
    //   838: aload 18
    //   840: aload 16
    //   842: getfield 1334	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   845: putfield 1335	com/tencent/mobileqq/data/Card:strQzoneFeedsDesc	Ljava/lang/String;
    //   848: aload 18
    //   850: invokevirtual 1338	com/tencent/mobileqq/data/Card:isPhotoUseCache	()Z
    //   853: ifne +187 -> 1040
    //   856: aload 18
    //   858: ldc 199
    //   860: putfield 1341	com/tencent/mobileqq/data/Card:strQzonePicUrl1	Ljava/lang/String;
    //   863: aload 18
    //   865: ldc 199
    //   867: putfield 1344	com/tencent/mobileqq/data/Card:strQzonePicUrl2	Ljava/lang/String;
    //   870: aload 18
    //   872: ldc 199
    //   874: putfield 1347	com/tencent/mobileqq/data/Card:strQzonePicUrl3	Ljava/lang/String;
    //   877: aload 16
    //   879: getfield 1351	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   882: astore_2
    //   883: aload_2
    //   884: ifnull +156 -> 1040
    //   887: aload_2
    //   888: getfield 1356	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   891: ifnull +149 -> 1040
    //   894: iconst_0
    //   895: istore 5
    //   897: iload 5
    //   899: aload_2
    //   900: getfield 1356	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   903: invokevirtual 376	java/util/ArrayList:size	()I
    //   906: if_icmpge +134 -> 1040
    //   909: iload 5
    //   911: ifne +71 -> 982
    //   914: aload 18
    //   916: aload_2
    //   917: getfield 1356	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   920: iload 5
    //   922: invokevirtual 587	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   925: checkcast 1358	SummaryCard/PhotoInfo
    //   928: getfield 1361	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   931: putfield 1341	com/tencent/mobileqq/data/Card:strQzonePicUrl1	Ljava/lang/String;
    //   934: iload 5
    //   936: iconst_1
    //   937: iadd
    //   938: istore 5
    //   940: goto -43 -> 897
    //   943: aload 18
    //   945: iconst_0
    //   946: putfield 522	com/tencent/mobileqq/data/Card:bVoted	B
    //   949: goto -252 -> 697
    //   952: iconst_1
    //   953: istore 15
    //   955: goto -214 -> 741
    //   958: iconst_1
    //   959: istore 15
    //   961: goto -198 -> 763
    //   964: iconst_1
    //   965: istore 15
    //   967: goto -180 -> 787
    //   970: iconst_1
    //   971: istore 15
    //   973: goto -166 -> 807
    //   976: iconst_1
    //   977: istore 15
    //   979: goto -148 -> 831
    //   982: iload 5
    //   984: iconst_1
    //   985: if_icmpne +26 -> 1011
    //   988: aload 18
    //   990: aload_2
    //   991: getfield 1356	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   994: iload 5
    //   996: invokevirtual 587	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   999: checkcast 1358	SummaryCard/PhotoInfo
    //   1002: getfield 1361	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1005: putfield 1344	com/tencent/mobileqq/data/Card:strQzonePicUrl2	Ljava/lang/String;
    //   1008: goto -74 -> 934
    //   1011: iload 5
    //   1013: iconst_2
    //   1014: if_icmpne -80 -> 934
    //   1017: aload 18
    //   1019: aload_2
    //   1020: getfield 1356	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1023: iload 5
    //   1025: invokevirtual 587	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1028: checkcast 1358	SummaryCard/PhotoInfo
    //   1031: getfield 1361	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1034: putfield 1347	com/tencent/mobileqq/data/Card:strQzonePicUrl3	Ljava/lang/String;
    //   1037: goto -103 -> 934
    //   1040: aload 18
    //   1042: aload 16
    //   1044: getfield 1365	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   1047: invokevirtual 1369	com/tencent/mobileqq/data/Card:setVipInfo	(LQQService/VipBaseInfo;)V
    //   1050: aload_1
    //   1051: getfield 485	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1054: ldc_w 1371
    //   1057: invokevirtual 536	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1060: lstore 11
    //   1062: lconst_1
    //   1063: lload 11
    //   1065: land
    //   1066: lconst_0
    //   1067: lcmp
    //   1068: ifeq +68 -> 1136
    //   1071: aload 18
    //   1073: aload 16
    //   1075: getfield 1374	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1078: putfield 1375	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1081: aload 18
    //   1083: getfield 1375	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1086: invokestatic 512	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1089: ifeq +10 -> 1099
    //   1092: aload 18
    //   1094: aload 20
    //   1096: putfield 1375	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1099: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1102: ifeq +34 -> 1136
    //   1105: ldc_w 1101
    //   1108: iconst_2
    //   1109: new 113	java/lang/StringBuilder
    //   1112: dup
    //   1113: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1116: ldc_w 1377
    //   1119: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: aload 16
    //   1124: getfield 1374	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1127: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1133: invokestatic 553	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1136: ldc2_w 1378
    //   1139: lload 11
    //   1141: land
    //   1142: lconst_0
    //   1143: lcmp
    //   1144: ifeq +13 -> 1157
    //   1147: aload 18
    //   1149: aload 16
    //   1151: getfield 1382	SummaryCard/RespSummaryCard:uAccelerateMultiple	J
    //   1154: putfield 1383	com/tencent/mobileqq/data/Card:uAccelerateMultiple	J
    //   1157: ldc2_w 1311
    //   1160: lload 11
    //   1162: land
    //   1163: lconst_0
    //   1164: lcmp
    //   1165: ifeq +23 -> 1188
    //   1168: aload 18
    //   1170: aload 16
    //   1172: getfield 1386	SummaryCard/RespSummaryCard:vRichSign	[B
    //   1175: putfield 1387	com/tencent/mobileqq/data/Card:vRichSign	[B
    //   1178: aload 18
    //   1180: aload 16
    //   1182: getfield 1390	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   1185: putfield 1393	com/tencent/mobileqq/data/Card:lSignModifyTime	J
    //   1188: aload 16
    //   1190: getfield 1396	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1193: ifnull +30 -> 1223
    //   1196: aload 18
    //   1198: aload_0
    //   1199: aload 16
    //   1201: getfield 1396	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1204: ldc_w 1398
    //   1207: new 1400	GameCenter/RespLastGameInfo
    //   1210: dup
    //   1211: invokespecial 1401	GameCenter/RespLastGameInfo:<init>	()V
    //   1214: invokevirtual 992	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1217: checkcast 1400	GameCenter/RespLastGameInfo
    //   1220: invokevirtual 1405	com/tencent/mobileqq/data/Card:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1223: aload 16
    //   1225: getfield 1408	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   1228: ifnull +30 -> 1258
    //   1231: aload 18
    //   1233: aload_0
    //   1234: aload 16
    //   1236: getfield 1408	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   1239: ldc_w 986
    //   1242: new 988	SummaryCardTaf/SSummaryCardRsp
    //   1245: dup
    //   1246: invokespecial 989	SummaryCardTaf/SSummaryCardRsp:<init>	()V
    //   1249: invokevirtual 992	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1252: checkcast 988	SummaryCardTaf/SSummaryCardRsp
    //   1255: invokevirtual 1412	com/tencent/mobileqq/data/Card:updateCardTemplate	(LSummaryCardTaf/SSummaryCardRsp;)V
    //   1258: ldc2_w 1413
    //   1261: lload 11
    //   1263: land
    //   1264: lconst_0
    //   1265: lcmp
    //   1266: ifeq +50 -> 1316
    //   1269: aload 18
    //   1271: aload 16
    //   1273: getfield 1417	SummaryCard/RespSummaryCard:lUserFlag	J
    //   1276: putfield 1418	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   1279: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1282: ifeq +34 -> 1316
    //   1285: ldc_w 1101
    //   1288: iconst_2
    //   1289: new 113	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1296: ldc_w 1420
    //   1299: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: aload 18
    //   1304: getfield 1418	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   1307: invokevirtual 551	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1310: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1313: invokestatic 553	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1316: ldc2_w 1327
    //   1319: lload 11
    //   1321: land
    //   1322: lconst_0
    //   1323: lcmp
    //   1324: ifeq +74 -> 1398
    //   1327: aload 18
    //   1329: aload 16
    //   1331: getfield 1423	SummaryCard/RespSummaryCard:uLoginDays	J
    //   1334: putfield 1426	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   1337: aload 18
    //   1339: aload 16
    //   1341: getfield 1429	SummaryCard/RespSummaryCard:strLoginDesc	Ljava/lang/String;
    //   1344: putfield 1432	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   1347: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1350: ifeq +48 -> 1398
    //   1353: ldc_w 1101
    //   1356: iconst_2
    //   1357: new 113	java/lang/StringBuilder
    //   1360: dup
    //   1361: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1364: ldc_w 1434
    //   1367: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: aload 18
    //   1372: getfield 1426	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   1375: invokevirtual 551	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1378: ldc_w 1436
    //   1381: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: aload 18
    //   1386: getfield 1432	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   1389: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1395: invokestatic 553	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1398: aload 16
    //   1400: getfield 1439	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   1403: ifnull +172 -> 1575
    //   1406: aload 16
    //   1408: getfield 1439	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   1411: invokevirtual 1445	QQService/VipBaseInfo:getMOpenInfo	()Ljava/util/Map;
    //   1414: astore_2
    //   1415: aload_2
    //   1416: ifnull +159 -> 1575
    //   1419: aload_2
    //   1420: bipush 101
    //   1422: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1425: invokeinterface 331 2 0
    //   1430: checkcast 1447	QQService/VipOpenInfo
    //   1433: astore_3
    //   1434: aload_3
    //   1435: getfield 1451	QQService/VipOpenInfo:bOpen	Z
    //   1438: ifeq +24 -> 1462
    //   1441: aload 18
    //   1443: iconst_1
    //   1444: putfield 1454	com/tencent/mobileqq/data/Card:isRedDiamond	Z
    //   1447: aload_3
    //   1448: getfield 1457	QQService/VipOpenInfo:iVipFlag	I
    //   1451: iconst_1
    //   1452: iand
    //   1453: ifle +9 -> 1462
    //   1456: aload 18
    //   1458: iconst_1
    //   1459: putfield 1460	com/tencent/mobileqq/data/Card:isSuperRedDiamond	Z
    //   1462: aload 18
    //   1464: aload_3
    //   1465: getfield 1463	QQService/VipOpenInfo:iVipLevel	I
    //   1468: putfield 1466	com/tencent/mobileqq/data/Card:redLevel	I
    //   1471: aload_2
    //   1472: bipush 102
    //   1474: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1477: invokeinterface 331 2 0
    //   1482: checkcast 1447	QQService/VipOpenInfo
    //   1485: astore_3
    //   1486: aload_3
    //   1487: getfield 1451	QQService/VipOpenInfo:bOpen	Z
    //   1490: ifeq +24 -> 1514
    //   1493: aload 18
    //   1495: iconst_1
    //   1496: putfield 1469	com/tencent/mobileqq/data/Card:isYellowDiamond	Z
    //   1499: aload_3
    //   1500: getfield 1457	QQService/VipOpenInfo:iVipFlag	I
    //   1503: iconst_1
    //   1504: iand
    //   1505: ifle +9 -> 1514
    //   1508: aload 18
    //   1510: iconst_1
    //   1511: putfield 1472	com/tencent/mobileqq/data/Card:isSuperYellowDiamond	Z
    //   1514: aload 18
    //   1516: aload_3
    //   1517: getfield 1463	QQService/VipOpenInfo:iVipLevel	I
    //   1520: putfield 1475	com/tencent/mobileqq/data/Card:yellowLevel	I
    //   1523: aload_2
    //   1524: bipush 103
    //   1526: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1529: invokeinterface 331 2 0
    //   1534: checkcast 1447	QQService/VipOpenInfo
    //   1537: astore_2
    //   1538: aload_2
    //   1539: getfield 1451	QQService/VipOpenInfo:bOpen	Z
    //   1542: ifeq +24 -> 1566
    //   1545: aload 18
    //   1547: iconst_1
    //   1548: putfield 1478	com/tencent/mobileqq/data/Card:isGreenDiamond	Z
    //   1551: aload_2
    //   1552: getfield 1457	QQService/VipOpenInfo:iVipFlag	I
    //   1555: iconst_1
    //   1556: iand
    //   1557: ifle +9 -> 1566
    //   1560: aload 18
    //   1562: iconst_1
    //   1563: putfield 1481	com/tencent/mobileqq/data/Card:isSuperGreenDiamond	Z
    //   1566: aload 18
    //   1568: aload_2
    //   1569: getfield 1463	QQService/VipOpenInfo:iVipLevel	I
    //   1572: putfield 1484	com/tencent/mobileqq/data/Card:greenLevel	I
    //   1575: new 375	java/util/ArrayList
    //   1578: dup
    //   1579: invokespecial 578	java/util/ArrayList:<init>	()V
    //   1582: astore_2
    //   1583: aload 16
    //   1585: getfield 1487	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1588: ifnull +379 -> 1967
    //   1591: aload 16
    //   1593: getfield 1487	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1596: invokevirtual 376	java/util/ArrayList:size	()I
    //   1599: ifle +368 -> 1967
    //   1602: iconst_0
    //   1603: istore 5
    //   1605: iload 5
    //   1607: aload 16
    //   1609: getfield 1487	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1612: invokevirtual 376	java/util/ArrayList:size	()I
    //   1615: if_icmpge +352 -> 1967
    //   1618: aload 16
    //   1620: getfield 1487	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1623: iload 5
    //   1625: invokevirtual 587	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1628: checkcast 421	[B
    //   1631: astore 4
    //   1633: aload 4
    //   1635: ifnonnull +22 -> 1657
    //   1638: iconst_0
    //   1639: istore 6
    //   1641: iload 6
    //   1643: bipush 10
    //   1645: if_icmpgt +20 -> 1665
    //   1648: iload 5
    //   1650: iconst_1
    //   1651: iadd
    //   1652: istore 5
    //   1654: goto -49 -> 1605
    //   1657: aload 4
    //   1659: arraylength
    //   1660: istore 6
    //   1662: goto -21 -> 1641
    //   1665: aload 4
    //   1667: iconst_1
    //   1668: invokestatic 1492	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   1671: l2i
    //   1672: istore 7
    //   1674: aload 4
    //   1676: iconst_5
    //   1677: invokestatic 1492	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   1680: l2i
    //   1681: istore 8
    //   1683: iload 7
    //   1685: ifle -37 -> 1648
    //   1688: iload 7
    //   1690: bipush 9
    //   1692: iadd
    //   1693: iload 6
    //   1695: if_icmpge -47 -> 1648
    //   1698: iload 7
    //   1700: newarray byte
    //   1702: astore_3
    //   1703: aload_3
    //   1704: iconst_0
    //   1705: aload 4
    //   1707: bipush 9
    //   1709: iload 7
    //   1711: invokestatic 1495	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   1714: new 1497	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   1717: dup
    //   1718: invokespecial 1498	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   1721: astore 4
    //   1723: aload 4
    //   1725: aload_3
    //   1726: invokevirtual 1499	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1729: pop
    //   1730: aload 4
    //   1732: getfield 1502	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1735: invokevirtual 1505	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1738: istore 6
    //   1740: iload 6
    //   1742: ifne +157 -> 1899
    //   1745: new 1507	com/tencent/mobileqq/profile/ProfileBusiEntry
    //   1748: dup
    //   1749: invokespecial 1508	com/tencent/mobileqq/profile/ProfileBusiEntry:<init>	()V
    //   1752: astore_3
    //   1753: aload_3
    //   1754: aload 4
    //   1756: getfield 1511	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1759: invokevirtual 433	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1762: putfield 1513	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_Int	I
    //   1765: aload 4
    //   1767: getfield 1517	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1770: ifnull +102 -> 1872
    //   1773: aload_3
    //   1774: aload 4
    //   1776: getfield 1517	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1779: getfield 1523	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1782: invokevirtual 1527	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1785: putfield 1528	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1788: aload_3
    //   1789: aload 4
    //   1791: getfield 1517	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1794: getfield 1531	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1797: invokevirtual 1527	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1800: putfield 1533	com/tencent/mobileqq/profile/ProfileBusiEntry:b	Ljava/lang/String;
    //   1803: aload_3
    //   1804: aload 4
    //   1806: getfield 1517	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1809: getfield 1536	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1812: invokevirtual 1527	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1815: putfield 1538	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   1818: aload_3
    //   1819: aload 4
    //   1821: getfield 1517	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1824: getfield 1541	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1827: invokevirtual 1527	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1830: putfield 1543	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   1833: aload_3
    //   1834: invokevirtual 1545	com/tencent/mobileqq/profile/ProfileBusiEntry:a	()Z
    //   1837: ifne -189 -> 1648
    //   1840: aload_2
    //   1841: aload_3
    //   1842: invokeinterface 1546 2 0
    //   1847: pop
    //   1848: goto -200 -> 1648
    //   1851: astore_3
    //   1852: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1855: ifeq -207 -> 1648
    //   1858: ldc_w 1101
    //   1861: iconst_2
    //   1862: aload_3
    //   1863: invokevirtual 1169	java/lang/Exception:toString	()Ljava/lang/String;
    //   1866: invokestatic 553	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1869: goto -221 -> 1648
    //   1872: aload_3
    //   1873: ldc 199
    //   1875: putfield 1528	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1878: aload_3
    //   1879: ldc 199
    //   1881: putfield 1533	com/tencent/mobileqq/profile/ProfileBusiEntry:b	Ljava/lang/String;
    //   1884: aload_3
    //   1885: ldc 199
    //   1887: putfield 1538	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   1890: aload_3
    //   1891: ldc 199
    //   1893: putfield 1543	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   1896: goto -63 -> 1833
    //   1899: invokestatic 544	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1902: ifeq -254 -> 1648
    //   1905: ldc_w 1101
    //   1908: iconst_4
    //   1909: new 113	java/lang/StringBuilder
    //   1912: dup
    //   1913: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1916: ldc_w 1548
    //   1919: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1922: aload 4
    //   1924: getfield 1511	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1927: invokevirtual 433	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1930: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1933: ldc_w 560
    //   1936: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: iload 6
    //   1941: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1944: ldc_w 560
    //   1947: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: aload 4
    //   1952: getfield 1551	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1955: invokevirtual 977	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1958: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1961: invokestatic 553	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1964: goto -316 -> 1648
    //   1967: aload 18
    //   1969: aload_2
    //   1970: invokevirtual 1555	com/tencent/mobileqq/data/Card:saveBusiEntrys	(Ljava/util/List;)V
    //   1973: aload 19
    //   1975: aload 18
    //   1977: invokevirtual 399	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   1980: pop
    //   1981: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1984: ifeq +48 -> 2032
    //   1987: ldc_w 1101
    //   1990: iconst_2
    //   1991: new 113	java/lang/StringBuilder
    //   1994: dup
    //   1995: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1998: ldc_w 1434
    //   2001: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2004: aload 18
    //   2006: getfield 1426	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   2009: invokevirtual 551	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2012: ldc_w 1436
    //   2015: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: aload 18
    //   2020: getfield 1432	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   2023: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2029: invokestatic 553	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2032: aload_0
    //   2033: getfield 294	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2036: bipush 33
    //   2038: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2041: checkcast 1557	com/tencent/mobileqq/app/CircleManager
    //   2044: aload 18
    //   2046: invokevirtual 1558	com/tencent/mobileqq/app/CircleManager:a	(Lcom/tencent/mobileqq/data/Card;)V
    //   2049: aload 19
    //   2051: aload 20
    //   2053: invokevirtual 1561	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   2056: astore_3
    //   2057: aload_3
    //   2058: astore_2
    //   2059: aload_3
    //   2060: ifnonnull +17 -> 2077
    //   2063: new 1563	com/tencent/mobileqq/data/ExtensionInfo
    //   2066: dup
    //   2067: invokespecial 1564	com/tencent/mobileqq/data/ExtensionInfo:<init>	()V
    //   2070: astore_2
    //   2071: aload_2
    //   2072: aload 20
    //   2074: putfield 1565	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   2077: aload_2
    //   2078: aload 16
    //   2080: getfield 1568	SummaryCard/RespSummaryCard:ulFaceAddonId	J
    //   2083: putfield 1571	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   2086: aload_2
    //   2087: invokestatic 1193	java/lang/System:currentTimeMillis	()J
    //   2090: putfield 1573	com/tencent/mobileqq/data/ExtensionInfo:timestamp	J
    //   2093: aload 19
    //   2095: aload_2
    //   2096: invokevirtual 1576	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   2099: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2102: ifeq +44 -> 2146
    //   2105: ldc_w 1101
    //   2108: iconst_2
    //   2109: new 113	java/lang/StringBuilder
    //   2112: dup
    //   2113: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2116: ldc_w 1578
    //   2119: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2122: aload 20
    //   2124: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2127: ldc_w 1580
    //   2130: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2133: aload_2
    //   2134: getfield 1571	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   2137: invokevirtual 551	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2140: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2143: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2146: aload 19
    //   2148: aload 20
    //   2150: invokevirtual 1583	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   2153: astore_3
    //   2154: aload_3
    //   2155: aload 18
    //   2157: getfield 364	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   2160: putfield 1588	com/tencent/mobileqq/data/Friends:signature	Ljava/lang/String;
    //   2163: aload_3
    //   2164: aload 18
    //   2166: getfield 358	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   2169: putfield 1591	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   2172: aload_3
    //   2173: aload 18
    //   2175: getfield 336	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   2178: putfield 1594	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   2181: lconst_1
    //   2182: lload 11
    //   2184: land
    //   2185: lconst_0
    //   2186: lcmp
    //   2187: ifeq +358 -> 2545
    //   2190: aload 18
    //   2192: getfield 1375	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   2195: astore_2
    //   2196: aload_3
    //   2197: aload_2
    //   2198: putfield 1597	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   2201: ldc2_w 1311
    //   2204: lload 11
    //   2206: land
    //   2207: lconst_0
    //   2208: lcmp
    //   2209: ifeq +17 -> 2226
    //   2212: aload_3
    //   2213: aload 16
    //   2215: getfield 1386	SummaryCard/RespSummaryCard:vRichSign	[B
    //   2218: aload 16
    //   2220: getfield 1390	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   2223: invokevirtual 1601	com/tencent/mobileqq/data/Friends:setRichBuffer	([BJ)V
    //   2226: aload 16
    //   2228: getfield 1365	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   2231: ifnull +69 -> 2300
    //   2234: aload_3
    //   2235: aload 16
    //   2237: getfield 1365	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   2240: getstatic 1607	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   2243: invokevirtual 1610	QQService/EVIPSPEC:value	()I
    //   2246: aload_3
    //   2247: getfield 1613	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   2250: invokestatic 1618	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   2253: putfield 1613	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   2256: aload_3
    //   2257: aload 16
    //   2259: getfield 1365	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   2262: getstatic 1621	QQService/EVIPSPEC:E_SP_SUPERQQ	LQQService/EVIPSPEC;
    //   2265: invokevirtual 1610	QQService/EVIPSPEC:value	()I
    //   2268: aload_3
    //   2269: getfield 1624	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   2272: invokestatic 1618	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   2275: putfield 1624	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   2278: aload_3
    //   2279: aload 16
    //   2281: getfield 1365	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   2284: getstatic 1627	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   2287: invokevirtual 1610	QQService/EVIPSPEC:value	()I
    //   2290: aload_3
    //   2291: getfield 1630	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   2294: invokestatic 1618	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   2297: putfield 1630	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   2300: lload 11
    //   2302: ldc2_w 1413
    //   2305: land
    //   2306: lconst_0
    //   2307: lcmp
    //   2308: ifeq +26 -> 2334
    //   2311: aload 18
    //   2313: getfield 1418	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2316: lconst_1
    //   2317: land
    //   2318: lconst_0
    //   2319: lcmp
    //   2320: ifeq +233 -> 2553
    //   2323: aload_3
    //   2324: aload_3
    //   2325: getfield 1633	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   2328: iconst_1
    //   2329: ior
    //   2330: i2b
    //   2331: putfield 1633	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   2334: aload 19
    //   2336: aload_3
    //   2337: invokevirtual 1636	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   2340: aload_0
    //   2341: getfield 294	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2344: bipush 10
    //   2346: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2349: checkcast 1094	com/tencent/mobileqq/model/PhoneContactManager
    //   2352: astore_2
    //   2353: aload_2
    //   2354: ifnull +22 -> 2376
    //   2357: aload_2
    //   2358: aload_3
    //   2359: getfield 1637	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   2362: invokeinterface 1097 2 0
    //   2367: ifnull +9 -> 2376
    //   2370: aload_2
    //   2371: invokeinterface 1099 1 0
    //   2376: aload_1
    //   2377: getfield 485	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   2380: ldc_w 1639
    //   2383: lconst_0
    //   2384: invokevirtual 1642	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   2387: lstore 11
    //   2389: aload_1
    //   2390: getfield 485	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   2393: ldc_w 1201
    //   2396: iconst_m1
    //   2397: invokevirtual 1645	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2400: istore 5
    //   2402: lload 11
    //   2404: lconst_0
    //   2405: lcmp
    //   2406: ifle +128 -> 2534
    //   2409: iload 5
    //   2411: iconst_2
    //   2412: if_icmpeq +16 -> 2428
    //   2415: iload 5
    //   2417: iconst_5
    //   2418: if_icmpeq +10 -> 2428
    //   2421: iload 5
    //   2423: bipush 7
    //   2425: if_icmpne +169 -> 2594
    //   2428: aload 17
    //   2430: lload 11
    //   2432: invokestatic 402	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2435: invokevirtual 1648	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   2438: astore_1
    //   2439: aload_1
    //   2440: ifnull +94 -> 2534
    //   2443: aload_1
    //   2444: getfield 1653	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   2447: ifnull +121 -> 2568
    //   2450: aload_1
    //   2451: getfield 1653	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   2454: aload 16
    //   2456: getfield 1259	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   2459: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2462: ifne +18 -> 2480
    //   2465: aload_1
    //   2466: aload 16
    //   2468: getfield 1259	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   2471: putfield 1653	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   2474: aload 17
    //   2476: aload_1
    //   2477: invokevirtual 1656	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   2480: aload_0
    //   2481: getfield 294	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2484: bipush 8
    //   2486: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2489: checkcast 514	com/tencent/mobileqq/app/FriendsManagerImp
    //   2492: lload 11
    //   2494: invokestatic 402	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2497: aload 16
    //   2499: getfield 1240	SummaryCard/RespSummaryCard:lUIN	J
    //   2502: invokestatic 402	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2505: aload 16
    //   2507: getfield 1265	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   2510: bipush 156
    //   2512: aload 16
    //   2514: getfield 1215	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   2517: aconst_null
    //   2518: bipush 156
    //   2520: bipush 156
    //   2522: bipush 156
    //   2524: ldc2_w 1657
    //   2527: ldc2_w 1657
    //   2530: invokevirtual 1661	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   2533: pop
    //   2534: aload_0
    //   2535: iconst_1
    //   2536: iconst_1
    //   2537: aload 18
    //   2539: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   2542: goto -2252 -> 290
    //   2545: aload_3
    //   2546: getfield 1597	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   2549: astore_2
    //   2550: goto -354 -> 2196
    //   2553: aload_3
    //   2554: aload_3
    //   2555: getfield 1633	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   2558: bipush 254
    //   2560: iand
    //   2561: i2b
    //   2562: putfield 1633	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   2565: goto -231 -> 2334
    //   2568: aload 16
    //   2570: getfield 1259	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   2573: ifnull -93 -> 2480
    //   2576: aload_1
    //   2577: aload 16
    //   2579: getfield 1259	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   2582: putfield 1653	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   2585: aload 17
    //   2587: aload_1
    //   2588: invokevirtual 1656	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   2591: goto -111 -> 2480
    //   2594: iload 5
    //   2596: iconst_4
    //   2597: if_icmpne -63 -> 2534
    //   2600: aload_0
    //   2601: getfield 294	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2604: bipush 48
    //   2606: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2609: checkcast 1663	com/tencent/mobileqq/app/DiscussionManager
    //   2612: astore_1
    //   2613: aload_1
    //   2614: lload 11
    //   2616: invokestatic 402	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2619: aload 20
    //   2621: invokevirtual 1666	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   2624: astore_2
    //   2625: aload_2
    //   2626: ifnull -92 -> 2534
    //   2629: aload_2
    //   2630: aload 16
    //   2632: getfield 1215	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   2635: putfield 1671	com/tencent/mobileqq/data/DiscussionMemberInfo:memberName	Ljava/lang/String;
    //   2638: aload 16
    //   2640: getfield 1280	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   2643: ifnull +61 -> 2704
    //   2646: aload 16
    //   2648: getfield 1280	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   2651: invokevirtual 1674	java/lang/String:length	()I
    //   2654: ifle +50 -> 2704
    //   2657: aload 16
    //   2659: getfield 1280	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   2662: aload_2
    //   2663: getfield 1677	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   2666: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2669: ifne +35 -> 2704
    //   2672: aload_2
    //   2673: aload 16
    //   2675: getfield 1280	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   2678: putfield 1677	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   2681: aload 16
    //   2683: getfield 1280	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   2686: aload 16
    //   2688: getfield 1215	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   2691: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2694: ifeq +18 -> 2712
    //   2697: aload_2
    //   2698: ldc2_w 1678
    //   2701: putfield 1682	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   2704: aload_1
    //   2705: aload_2
    //   2706: invokevirtual 1685	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;)V
    //   2709: goto -175 -> 2534
    //   2712: aload_2
    //   2713: ldc2_w 1686
    //   2716: putfield 1682	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   2719: goto -15 -> 2704
    //   2722: lload 13
    //   2724: lconst_0
    //   2725: lcmp
    //   2726: ifgt +15 -> 2741
    //   2729: aload_2
    //   2730: astore_1
    //   2731: aload_0
    //   2732: iconst_1
    //   2733: iconst_0
    //   2734: aload_1
    //   2735: invokevirtual 408	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   2738: goto -2448 -> 290
    //   2741: lload 13
    //   2743: invokestatic 402	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2746: astore_1
    //   2747: goto -16 -> 2731
    //   2750: astore 4
    //   2752: goto -2407 -> 345
    //   2755: lconst_0
    //   2756: lstore 9
    //   2758: goto -2711 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2761	0	this	CardHandler
    //   0	2761	1	paramToServiceMsg	ToServiceMsg
    //   0	2761	2	paramFromServiceMsg	FromServiceMsg
    //   0	2761	3	paramObject	Object
    //   0	2761	4	paramBundle	Bundle
    //   68	2530	5	i1	int
    //   72	1868	6	i2	int
    //   1672	38	7	i3	int
    //   1681	1	8	i4	int
    //   45	2712	9	l1	long
    //   374	2241	11	l2	long
    //   132	2610	13	l3	long
    //   739	239	15	bool	boolean
    //   182	2505	16	localRespSummaryCard	SummaryCard.RespSummaryCard
    //   176	2410	17	localTroopManager	TroopManager
    //   423	2115	18	localCard	Card
    //   162	2173	19	localFriendsManager	FriendsManager
    //   414	2206	20	str	String
    // Exception table:
    //   from	to	target	type
    //   79	101	341	java/lang/Exception
    //   1723	1740	1851	java/lang/Exception
    //   1745	1833	1851	java/lang/Exception
    //   1833	1848	1851	java/lang/Exception
    //   1872	1896	1851	java/lang/Exception
    //   1899	1964	1851	java/lang/Exception
    //   105	111	2750	java/lang/Exception
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
        paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
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
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
      paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 0))
      {
        paramFromServiceMsg = paramObject.a(paramToServiceMsg.getUin());
        if (paramFromServiceMsg != null)
        {
          if (paramBundle != null) {
            paramFromServiceMsg.strNick = paramBundle;
          }
          if (localByte != null) {
            paramFromServiceMsg.shGender = ((short)localByte.byteValue());
          }
          if (localInteger != null)
          {
            paramFromServiceMsg.lBirthday = localInteger.intValue();
            paramFromServiceMsg.shAge = ((short)ProfileUtil.a(localInteger.intValue()));
            paramFromServiceMsg.age = ((byte)paramFromServiceMsg.shAge);
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo()  age = " + paramFromServiceMsg.age);
            }
          }
          paramObject.a(paramFromServiceMsg);
        }
        a(paramToServiceMsg, 31, true, paramFromServiceMsg);
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
    localMessageRecord.frienduin = AppConstants.S;
    localMessageRecord.istroop = 0;
    localMessageRecord.senderuin = String.valueOf(localVisitor.lUIN);
    localMessageRecord.extraflag = paramPushVoteIncreaseInfo.iIncrement;
    localMessageRecord.time = (System.currentTimeMillis() / 1000L);
    new ezl(this, paramPushVoteIncreaseInfo.iIncrement, paramPushVoteIncreaseInfo.vVoterList).start();
    try
    {
      Object localObject1 = new String(localVisitor.vecNick, "UTF8");
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() == 0) {
        localObject2 = String.valueOf(localVisitor.lUIN);
      }
      if (1 == paramPushVoteIncreaseInfo.iIncrement)
      {
        localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131561525), new Object[] { localObject2 });
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
        localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131561500), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
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
            return;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("uin", (String)localObject1);
            if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
            {
              q(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
              return;
            }
            if ("SummaryCard.ReqVoiceManage".equals(paramFromServiceMsg.getServiceCmd()))
            {
              p(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
              return;
            }
            if ("MCardSvc.ReqCommonCard".equals(paramFromServiceMsg.getServiceCmd()))
            {
              o(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
              return;
            }
            if ("MCardSvc.ReqMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd()))
            {
              i(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
              return;
            }
            if ("MCardSvc.ReqHYCommonCard".equals(paramFromServiceMsg.getServiceCmd()))
            {
              n(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
              return;
            }
            if ("MCardSvc.ReqHYMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd()))
            {
              m(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
              return;
            }
            if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd()))
            {
              l(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
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
              b(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
              return;
            }
            if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
            {
              c(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
              return;
            }
            if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
            {
              d(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
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
              r(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
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
            if ("ProfileService.GetSglUsrFullInfo".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
              return;
            }
            if ("ProfileService.SetUserInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              t(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
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
          s(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
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
    } while (!"SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonecover.", 2, "getQzoneCover");
    }
    ToServiceMsg localToServiceMsg = a("SQQzoneSvc.getCover");
    localToServiceMsg.addAttribute("uin", paramString);
    localToServiceMsg.addAttribute("flag", Integer.valueOf(paramInt));
    a(localToServiceMsg);
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
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSummayCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt1).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2);
      if (QLog.isColorLevel()) {
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
  
  public void a(String paramString1, String paramString2, short paramShort)
  {
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "MCardSvc.ReqUpdateIntro");
    paramString1.extraData.putString("vContent", paramString2);
    paramString1.extraData.putShort("shType", paramShort);
    a(paramString1);
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
        break label263;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString);
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
      label263:
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
  
  public void b(String paramString, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "getUserFullInfo() uin = " + paramString);
    }
    paramCardObserver = a("ProfileService.GetSglUsrFullInfo", paramCardObserver);
    paramCardObserver.addAttribute("uin", paramString);
    paramCardObserver.addAttribute("array_uin", null);
    a(paramCardObserver);
  }
  
  public void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetVisitorList");
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
    //   5: invokeinterface 224 1 0
    //   10: ifle +73 -> 83
    //   13: aload_0
    //   14: getfield 294	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 595	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   20: invokevirtual 601	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +58 -> 83
    //   28: aload_1
    //   29: invokevirtual 2222	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   32: invokevirtual 2225	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   35: aload_2
    //   36: invokeinterface 2226 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 688 1 0
    //   48: ifeq +36 -> 84
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 692 1 0
    //   58: checkcast 696	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 2228	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 964	java/lang/Exception:printStackTrace	()V
    //   72: aload_1
    //   73: invokevirtual 2222	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   76: invokevirtual 2230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   79: aload_1
    //   80: invokevirtual 623	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 2222	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   88: invokevirtual 2232	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   91: aload_1
    //   92: invokevirtual 2222	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   95: invokevirtual 2230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   98: aload_1
    //   99: invokevirtual 623	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 2222	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   108: invokevirtual 2230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   111: aload_1
    //   112: invokevirtual 623	com/tencent/mobileqq/persistence/EntityManager:a	()V
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
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqGetCardSwitch");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqSetCardSwitch");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqVote");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqFavorite");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqGetVoterList");
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
      this.jdField_a_of_type_JavaUtilSet.add("SQQzoneSvc.getCover");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler
 * JD-Core Version:    0.7.0.1
 */