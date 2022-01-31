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
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
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
import com.tencent.mobileqq.servlet.GameCenterServlet;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class BusinessInfoCheckUpdateItem
  implements CheckUpdateItemInterface
{
  public static final int a = 100005;
  public static final String a = "BusinessInfoCheckUpdateItem";
  public static final int b = 100001;
  public static final String b = ".";
  public static final int c = 100002;
  public static final String c = "BusinessInfoCheckUpdateItem_new_1";
  public static final int d = 100003;
  public static final String d = "businessinfo_check_update_interval";
  public static final int e = 100006;
  public static final String e = "businessinfo_last_check_update_timestamp";
  public static final int f = 100011;
  public static final int g = 3;
  public static final int h = 999999;
  public static final int i = 100004;
  public static final int j = 1;
  public static final int k = -1;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 100007;
  public static final int q = 100008;
  public static final int r = 100009;
  public static final int s = 100010;
  public static final int t = 100400;
  public static final int u = 100012;
  public static final int v = 100200;
  public static final int w = 826;
  public static final int x = 100300;
  private int B;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String[][] jdField_a_of_type_Array2dOfJavaLangString;
  
  public BusinessInfoCheckUpdateItem(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String[] arrayOfString1 = { "100005", "100005", "1" };
    String[] arrayOfString2 = { "100005", "100005.100001", "1" };
    String[] arrayOfString3 = { "100005", "100005.100002", "1" };
    String[] arrayOfString4 = { "100005", "100005.100006", "1" };
    String[] arrayOfString5 = { "100005", "100005.100011", "1" };
    String[] arrayOfString6 = { "100007", "100007", "1" };
    String[] arrayOfString7 = { "100007", "100007.100009.100010", "1" };
    String[] arrayOfString8 = { "100200", "100200", "1" };
    this.jdField_a_of_type_Array2dOfJavaLangString = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, { "100005", "100005.100003", "1" }, arrayOfString4, arrayOfString5, arrayOfString6, { "100007", "100007.100008", "1" }, { "100007", "100007.100009", "1" }, arrayOfString7, { "100400", "100400", "1" }, { "100005", "100005.100012", "1" }, { "100300", "100300", "2" }, { "826", "826", "0" }, arrayOfString8 };
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.B = paramInt;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 24 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[2] & 0xFF) << 8 | paramArrayOfByte[3] & 0xFF;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(AppInterface paramAppInterface, String paramString)
  {
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
    Object localObject = FileUtils.a(paramAppInterface);
    if (localObject == null)
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
        paramAppInterface = new BusinessInfoCheckUpdate.TimeRspBody();
        paramAppInterface.mergeFrom((byte[])localObject);
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
    Object localObject1 = new File(paramAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + paramAppInterface.a());
    if ((localObject1 == null) || (!((File)localObject1).exists())) {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
    }
    Object localObject2;
    do
    {
      return;
      localObject2 = FileUtils.a((File)localObject1);
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BusinessInfoCheckUpdateItem", 2, "Can not translate BusinessInfoCheckUpdateItem pb file to byte");
    return;
    for (;;)
    {
      int i1;
      try
      {
        localObject1 = new BusinessInfoCheckUpdate.TimeRspBody();
        ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).mergeFrom((byte[])localObject2);
        if (((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has())
        {
          i1 = 0;
          if (i1 < ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.size())
          {
            localObject2 = (BusinessInfoCheckUpdate.AppInfo)((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get(i1);
            if (!paramString.equals(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get())) {
              break label343;
            }
            if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1) && (!paramBoolean)) {
              ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            }
            PBInt32Field localPBInt32Field = ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag;
            if (!paramBoolean) {
              break label337;
            }
            localPBInt32Field.set(i2);
            ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.set(i1, (MessageMicro)localObject2);
            localObject2 = (GameCenterManagerImp)paramAppInterface.getManager(11);
            if (localObject2 != null) {
              ((GameCenterManagerImp)localObject2).a(paramString);
            }
          }
        }
        FileUtils.a(new File(paramAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + paramAppInterface.a()).getAbsolutePath(), ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).toByteArray(), false);
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return;
      }
      label337:
      i2 = 0;
      continue;
      label343:
      i1 += 1;
    }
  }
  
  private boolean a(List paramList, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    label161:
    for (;;)
    {
      return false;
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
      for (;;)
      {
        if (i1 >= this.jdField_a_of_type_Array2dOfJavaLangString.length) {
          break label161;
        }
        paramList = paramAppInfo.path.get();
        if (paramAppInfo.type.get() == 3)
        {
          if ((!paramList.equals("100005")) && (!paramList.equals("100005.100001"))) {
            break;
          }
          return true;
        }
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
    localTimeReqBody.sClientVer.set("6.0.2.6602");
    localTimeReqBody.uiUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    List localList = ResourcePluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager(), 64, false);
    Object localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    Object localObject3;
    label140:
    int i2;
    if (localObject1 == null)
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
          localObject3 = ((RedTouchManager)localObject1).c();
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
    localObject1 = (MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
    if ((localObject1 != null) && (((MyBusinessManager)localObject1).a())) {}
    for (int i1 = 1;; i1 = 0)
    {
      i2 = 0;
      if (i2 < this.jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        if ((i1 == 0) && (Integer.parseInt(this.jdField_a_of_type_Array2dOfJavaLangString[i2][0]) == 100200)) {}
        for (;;)
        {
          i2 += 1;
          break;
          localObject1 = new BusinessInfoCheckUpdate.AppInfo();
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).uiAppId.set(Integer.parseInt(this.jdField_a_of_type_Array2dOfJavaLangString[i2][0]));
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.set(this.jdField_a_of_type_Array2dOfJavaLangString[i2][1]);
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).appset.set(Integer.parseInt(this.jdField_a_of_type_Array2dOfJavaLangString[i2][2]));
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(0);
          localTimeReqBody.rptMsgAppInfo.add((MessageMicro)localObject1);
        }
      }
      localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((localObject2 == null) || (!((File)localObject2).exists()) || (FileUtils.a((File)localObject2) == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessInfoCheckUpdateItem", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
        }
        if ((!((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a) && (localTimeReqBody.rptMsgAppInfo.has())) {
          i1 = 0;
        }
      }
      for (;;)
      {
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
            try
            {
              localObject1 = new BusinessInfoCheckUpdate.TimeRspBody();
              ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).mergeFrom(FileUtils.a((File)localObject2));
              if ((!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has()) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has())) {
                break;
              }
              i1 = 0;
              if (i1 >= ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.size()) {
                break;
              }
              i2 = 0;
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
                  break;
                }
                i2 += 1;
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void b(RespItem paramRespItem)
  {
    if (paramRespItem == null) {}
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
    paramRespItem = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
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
      label280:
      paramRespItem.edit().putInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (int)(System.currentTimeMillis() / 1000L)).commit();
      ((SharedPreferences.Editor)localObject).commit();
      paramRespItem = ResourcePluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager(), 64, false);
      try
      {
        if (localTimeRspBody.rptMsgAppInfo.has())
        {
          int i2 = localTimeRspBody.rptMsgAppInfo.size();
          i1 = 0;
          for (;;)
          {
            if (i1 < i2)
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
              break label280;
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
          paramRespItem.addAll(((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).c());
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
    FileUtils.a(new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).getAbsolutePath(), localTimeRspBody.toByteArray(), false);
    if ((localTimeRspBody != null) && (localTimeRspBody.rptSetting != null) && (localTimeRspBody.rptSetting.get() != null)) {
      LebaShowListManager.a().a(localTimeRspBody.rptSetting.get());
    }
    paramRespItem = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (paramRespItem != null) {
      paramRespItem.a();
    }
    paramRespItem = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GameCenterServlet.class);
    paramRespItem.setAction("gc_refresh_ui");
    paramRespItem.putExtra("gc_notify_type", 6);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramRespItem);
  }
  
  public int a()
  {
    return 7;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessInfoCheckUpdateItem", 2, "getCheckUpdateItemData,uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + ",serviceId=" + this.B);
    }
    ReqItem localReqItem = new ReqItem();
    if (localReqItem != null) {}
    switch (this.B)
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
    return this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */