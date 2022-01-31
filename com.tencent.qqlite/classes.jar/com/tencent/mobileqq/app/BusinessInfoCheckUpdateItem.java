package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class BusinessInfoCheckUpdateItem
  implements CheckUpdateItemInterface
{
  public static final int A = 100016;
  public static final int B = 886;
  public static final int C = 100170;
  public static final int D = 100171;
  public static final int E = 100172;
  public static final int F = 905;
  public static final int a = 100005;
  public static final String a = "BusinessInfoCheckUpdateItem";
  public static final int b = 100001;
  public static final String b = ".";
  public static final int c = 100002;
  public static final String c = "BusinessInfoCheckUpdateItem_new_1";
  public static final int d = 100003;
  public static final String d = "businessinfo_check_update_interval";
  public static final int e = 100011;
  public static final String e = "businessinfo_last_check_update_timestamp";
  public static final int f = 3;
  public static final int g = 999999;
  public static final int h = 100004;
  public static final int i = 1;
  public static final int j = -1;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 4;
  public static final int p = 100007;
  public static final int q = 100009;
  public static final int r = 100010;
  public static final int s = 100013;
  public static final int t = 100014;
  public static final int u = 100015;
  public static final int v = 100100;
  public static final int w = 100400;
  public static final int x = 100200;
  public static final int y = 826;
  public static final int z = 100160;
  private int J;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String[][] jdField_a_of_type_Array2dOfJavaLangString;
  
  public BusinessInfoCheckUpdateItem(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String[] arrayOfString1 = { "100005", "100005", "1" };
    String[] arrayOfString2 = { "100005", "100005.100001", "1" };
    String[] arrayOfString3 = { "100005", "100005.100002", "1" };
    String[] arrayOfString4 = { "100005", "100005.100003", "1" };
    String[] arrayOfString5 = { "100005", "100005.100011", "1" };
    String[] arrayOfString6 = { "100007", "100007", "1" };
    String[] arrayOfString7 = { "100007", "100007.100009", "1" };
    String[] arrayOfString8 = { "100400", "100400", "1" };
    String[] arrayOfString9 = { "100200", "100200", "1" };
    String[] arrayOfString10 = { "100016", "100016", "1" };
    String[] arrayOfString11 = { "886", "886.100171", "0" };
    String[] arrayOfString12 = { "886", "886.100172", "0" };
    this.jdField_a_of_type_Array2dOfJavaLangString = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, { "100007", "100007.100009.100010", "1" }, { "100007", "100007.100013", "1" }, { "100007", "100007.100014", "1" }, { "100007", "100007.100014.100015", "1" }, arrayOfString8, arrayOfString9, { "100160", "100160", "1" }, arrayOfString10, { "886", "886", "0" }, { "886", "886.100170", "0" }, arrayOfString11, arrayOfString12 };
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.J = paramInt;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 24 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[2] & 0xFF) << 8 | paramArrayOfByte[3] & 0xFF;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(AppInterface paramAppInterface, String paramString)
  {
    Object localObject = (RedTouchManager)paramAppInterface.getManager(32);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    paramAppInterface = new File(paramAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + paramAppInterface.a());
    if ((paramAppInterface == null) || (!paramAppInterface.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      paramAppInterface = localAppInfo;
      return paramAppInterface;
    }
    if (((RedTouchManager)localObject).a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "Can not translate BusinessInfoCheckUpdateItem pb file to byte");
      }
      return localAppInfo;
    }
    for (;;)
    {
      int i1;
      try
      {
        paramAppInterface = ((RedTouchManager)localObject).a();
        if (!paramAppInterface.rptMsgAppInfo.has()) {
          return localAppInfo;
        }
        i1 = 0;
        if (i1 >= paramAppInterface.rptMsgAppInfo.size()) {
          return localAppInfo;
        }
        localObject = (BusinessInfoCheckUpdate.AppInfo)paramAppInterface.rptMsgAppInfo.get(i1);
        if (paramString.equals(((BusinessInfoCheckUpdate.AppInfo)localObject).path.get()))
        {
          paramAppInterface = (AppInterface)localObject;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("BusinessInfoCheckUpdateItem", 2, "checkNewStatusByID path = " + paramString + ",Flag=" + ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() + ",Type=" + ((BusinessInfoCheckUpdate.AppInfo)localObject).type.get());
          return localObject;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return localAppInfo;
      }
      i1 += 1;
    }
    return localAppInfo;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    int i2 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("BusinessInfoCheckUpdateItem", 2, "setNewStatusByID,path=" + paramString);
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)paramAppInterface.getManager(32);
    if (localRedTouchManager.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      return;
    }
    for (;;)
    {
      int i1;
      try
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = localRedTouchManager.a();
        if (localTimeRspBody.rptMsgAppInfo.has())
        {
          i1 = 0;
          if (i1 < localTimeRspBody.rptMsgAppInfo.size())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i1);
            if (!paramString.equals(localAppInfo.path.get())) {
              break label231;
            }
            if ((localAppInfo.iNewFlag.get() == 1) && (!paramBoolean)) {
              localAppInfo.modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            }
            PBInt32Field localPBInt32Field = localAppInfo.iNewFlag;
            if (!paramBoolean) {
              break label225;
            }
            localPBInt32Field.set(i2);
            localTimeRspBody.rptMsgAppInfo.set(i1, localAppInfo);
            paramAppInterface = (GameCenterManagerImp)paramAppInterface.getManager(11);
            if (paramAppInterface != null) {
              paramAppInterface.a(paramString);
            }
          }
        }
        localRedTouchManager.a(localTimeRspBody);
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return;
      }
      label225:
      i2 = 0;
      continue;
      label231:
      i1 += 1;
    }
  }
  
  private boolean a(List paramList, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return false;
      if (paramAppInfo.appset.get() == 3) {
        return true;
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i2 = paramList.size();
        i1 = 0;
        while (i1 < i2)
        {
          if ((((ResourcePluginInfo)paramList.get(i1)).uiResId + "").equals(paramAppInfo.path.get())) {
            return true;
          }
          i1 += 1;
        }
      }
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        paramList = paramAppInfo.path.get();
        if (this.jdField_a_of_type_Array2dOfJavaLangString[i1][1].equals(paramList)) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static byte[] a(int paramInt)
  {
    int i1 = (byte)(paramInt & 0xFF);
    int i2 = (byte)((0xFF00 & paramInt) >> 8);
    int i3 = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), i3, i2, i1 };
  }
  
  private ReqItem b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessInfoCheckUpdateItem", 2, "getNewFlagOp");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 110;
    BusinessInfoCheckUpdate.TimeReqBody localTimeReqBody = new BusinessInfoCheckUpdate.TimeReqBody();
    localTimeReqBody.iProtocolVer.set(1);
    localTimeReqBody.uiClientPlatID.set(109);
    localTimeReqBody.sClientVer.set("3.5.0.660");
    localTimeReqBody.uiUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    List localList = ResourcePluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager(), 64, false);
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    Object localObject3;
    label140:
    int i2;
    if (localRedTouchManager == null)
    {
      localObject3 = null;
      if (localList == null) {
        break label412;
      }
      if (localObject3 != null) {
        break label316;
      }
      i1 = 0;
      localObject1 = null;
      i2 = 0;
    }
    Object localObject2;
    int i3;
    for (;;)
    {
      if (i2 >= localList.size()) {
        break label412;
      }
      localObject2 = new BusinessInfoCheckUpdate.AppInfo();
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).path.set(((ResourcePluginInfo)localList.get(i2)).uiResId + "");
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.set((int)((ResourcePluginInfo)localList.get(i2)).uiResId);
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).appset.set(0);
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(0);
      localTimeReqBody.rptMsgAppInfo.add((MessageMicro)localObject2);
      int i4 = (int)((ResourcePluginInfo)localList.get(i2)).uiResId;
      i3 = 0;
      label276:
      if (i3 < i1)
      {
        localObject1 = (BusinessInfoCheckUpdate.AppSetting)((List)localObject3).get(i3);
        if (localObject1 == null) {}
        label316:
        while (i4 != ((BusinessInfoCheckUpdate.AppSetting)localObject1).appid.get())
        {
          i3 += 1;
          break label276;
          localObject3 = localRedTouchManager.d();
          break;
          i1 = ((List)localObject3).size();
          break label140;
        }
      }
      if (i3 != i1)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        localObject2 = new BusinessInfoCheckUpdate.AppSetting();
        ((BusinessInfoCheckUpdate.AppSetting)localObject2).appid.set(i4);
        ((BusinessInfoCheckUpdate.AppSetting)localObject2).setting.set(true);
        ((BusinessInfoCheckUpdate.AppSetting)localObject2).modify_ts.set(0L);
      }
      localTimeReqBody.rptSetting.add((MessageMicro)localObject2);
      i2 += 1;
      localObject1 = localObject2;
    }
    label412:
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_Array2dOfJavaLangString.length)
    {
      if (Integer.parseInt(this.jdField_a_of_type_Array2dOfJavaLangString[i1][0]) == 100200) {}
      for (;;)
      {
        i1 += 1;
        break;
        localObject1 = new BusinessInfoCheckUpdate.AppInfo();
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).uiAppId.set(Integer.parseInt(this.jdField_a_of_type_Array2dOfJavaLangString[i1][0]));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.set(this.jdField_a_of_type_Array2dOfJavaLangString[i1][1]);
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).appset.set(Integer.parseInt(this.jdField_a_of_type_Array2dOfJavaLangString[i1][2]));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(0);
        localTimeReqBody.rptMsgAppInfo.add((MessageMicro)localObject1);
      }
    }
    Object localObject1 = localRedTouchManager.a(3).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject1).next();
      new BusinessInfoCheckUpdate.AppInfo().path.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
      localTimeReqBody.rptMsgAppInfo.add((MessageMicro)localObject2);
    }
    if (localRedTouchManager.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      if ((!((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38)).a) && (localTimeReqBody.rptMsgAppInfo.has())) {
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 < localTimeReqBody.rptMsgAppInfo.size())
      {
        if ("100005.100011".equals(((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(i1)).path.get())) {
          localTimeReqBody.rptMsgAppInfo.remove(i1);
        }
      }
      else
      {
        localObject1 = localTimeReqBody.toByteArray();
        i1 = localObject1.length;
        i2 = i1 + 4;
        localObject2 = new byte[i2];
        System.arraycopy(a(i2), 0, localObject2, 0, 4);
        System.arraycopy(localObject1, 0, localObject2, 4, i1);
        localReqItem.vecParam = ((byte[])localObject2);
        return localReqItem;
        localRedTouchManager.a(true);
        localObject1 = localRedTouchManager.a();
        if ((!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has()) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has())) {
          break;
        }
        i1 = 0;
        label789:
        if (i1 < ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.size()) {
          i2 = 0;
        }
        for (;;)
        {
          if (i2 < localTimeReqBody.rptMsgAppInfo.size())
          {
            localObject2 = (BusinessInfoCheckUpdate.AppInfo)((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get(i1);
            localObject3 = (BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(i2);
            if (((BusinessInfoCheckUpdate.AppInfo)localObject3).path.get().equals(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get()))
            {
              ((BusinessInfoCheckUpdate.AppInfo)localObject3).path.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
              ((BusinessInfoCheckUpdate.AppInfo)localObject3).uiAppId.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get());
              ((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.get());
              ((BusinessInfoCheckUpdate.AppInfo)localObject3).modify_ts.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.get());
              ((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get());
              ((BusinessInfoCheckUpdate.AppInfo)localObject3).type.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get());
              i3 = 0;
              while (i3 < ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.size())
              {
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).missions.add(((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get(i3));
                i3 += 1;
              }
              localTimeReqBody.rptMsgAppInfo.set(i2, (MessageMicro)localObject3);
            }
          }
          else
          {
            i1 += 1;
            break label789;
            break;
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
  }
  
  private void b(RespItem paramRespItem)
  {
    int i2 = 0;
    if (paramRespItem == null) {}
    label289:
    do
    {
      int i1;
      BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody;
      for (;;)
      {
        return;
        i1 = paramRespItem.cResult;
        localObject = paramRespItem.vecUpdate;
        if (QLog.isColorLevel()) {
          QLog.d("BusinessInfoCheckUpdateItem", 2, "handleNewFlagOp,result:" + i1 + ",vecUpdate.length=" + paramRespItem.vecUpdate.length);
        }
        if (2 != i1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BusinessInfoCheckUpdateItem", 2, "handleNewFlagOp,return fail ,RespItem result:" + i1);
          }
        }
        else
        {
          paramRespItem = new byte[localObject.length - 4];
          PkgTools.a(paramRespItem, 0, (byte[])localObject, 4, localObject.length - 4);
          try
          {
            localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
            localTimeRspBody.mergeFrom(paramRespItem);
            if (localTimeRspBody.iResult.get() != 0)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("BusinessInfoCheckUpdateItem", 2, "handleNewFlagOp,return fail ,TimeRspBody result:" + localTimeRspBody.iResult.get());
            }
          }
          catch (Exception paramRespItem)
          {
            paramRespItem.printStackTrace();
            return;
          }
        }
      }
      paramRespItem = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("check_update_sp_key", 0);
      Object localObject = paramRespItem.edit();
      String str;
      if (localTimeRspBody.iInterval.has())
      {
        str = "businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localTimeRspBody.iInterval.get() > 0) {
          i1 = localTimeRspBody.iInterval.get();
        }
      }
      for (;;)
      {
        ((SharedPreferences.Editor)localObject).putInt(str, i1);
        paramRespItem.edit().putInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (int)(System.currentTimeMillis() / 1000L)).commit();
        ((SharedPreferences.Editor)localObject).commit();
        paramRespItem = ResourcePluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager(), 64, false);
        try
        {
          if (localTimeRspBody.rptMsgAppInfo.has())
          {
            int i3 = localTimeRspBody.rptMsgAppInfo.size();
            i1 = i2;
            for (;;)
            {
              if (i1 < i3)
              {
                localObject = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i1);
                if ((localObject != null) && (1 == ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get()) && (!a(paramRespItem, (BusinessInfoCheckUpdate.AppInfo)localObject)))
                {
                  ((BusinessInfoCheckUpdate.AppInfo)localObject).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
                  ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.set(0);
                  localTimeRspBody.rptMsgAppInfo.set(i1, (MessageMicro)localObject);
                  if (QLog.isColorLevel()) {
                    QLog.d("BusinessInfoCheckUpdateItem", 2, "verifyDataCorrect,return false ,appInfo.path.get():" + ((BusinessInfoCheckUpdate.AppInfo)localObject).path.get());
                  }
                }
                i1 += 1;
                continue;
                i1 = 0;
                break;
                ((SharedPreferences.Editor)localObject).remove("businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                break label289;
              }
            }
          }
          localObject = localTimeRspBody.rptSetting.get();
          if (localObject != null)
          {
            paramRespItem = (RespItem)localObject;
            if (((List)localObject).size() != 0) {}
          }
          else
          {
            paramRespItem = new ArrayList();
            paramRespItem.addAll(((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).d());
          }
          localTimeRspBody.rptSetting.set(paramRespItem);
        }
        catch (Exception paramRespItem)
        {
          for (;;)
          {
            paramRespItem.printStackTrace();
          }
        }
      }
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a(localTimeRspBody);
      if ((localTimeRspBody != null) && (localTimeRspBody.rptSetting != null) && (localTimeRspBody.rptSetting.get() != null)) {
        LebaShowListManager.a().a(localTimeRspBody.rptSetting.get());
      }
      paramRespItem = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    } while (paramRespItem == null);
    paramRespItem.a();
  }
  
  public int a()
  {
    return 7;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessInfoCheckUpdateItem", 2, "getCheckUpdateItemData,uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + ",serviceId=" + this.J);
    }
    ReqItem localReqItem = new ReqItem();
    if (localReqItem != null) {}
    switch (this.J)
    {
    default: 
      return localReqItem;
    }
    return b();
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "handleCheckUpdateItemData,serviceId=" + paramRespItem.eServiceID);
      }
    }
    switch (paramRespItem.eServiceID)
    {
    default: 
      return;
    }
    b(paramRespItem);
  }
  
  public int b()
  {
    return this.J;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */