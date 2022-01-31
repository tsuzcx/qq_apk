package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.AppBehavior;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlReqHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlRspHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.PreloadInfoReq;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.PreloadInfoRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PreloadInfoCheckUpdateItem
  implements CheckUpdateItemInterface
{
  private static final String jdField_a_of_type_JavaLangString = "PreloadInfoCheckUpdateItem";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PreloadInfoCheckUpdateItem(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private boolean a(GameCenterManagerImp paramGameCenterManagerImp, String paramString)
  {
    if (paramGameCenterManagerImp == null) {}
    while (paramGameCenterManagerImp.a(paramString) == -1) {
      return false;
    }
    return true;
  }
  
  public static byte[] a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)((0xFF00 & paramInt) >> 8);
    int k = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), k, j, i };
  }
  
  public int a()
  {
    return 3;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadInfoCheckUpdateItem", 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 123;
    Object localObject1 = new PreloadInfoCheckUpdate.PreloadInfoReq();
    Object localObject2 = new PreloadInfoCheckUpdate.ControlReqHead();
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).protocol_ver.set(1);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_plat_id.set(109);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_ver.set("3.5.0");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).os_ver.set(Build.VERSION.SDK);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).uin.set(this.a.getLongAccountUin());
    ((PreloadInfoCheckUpdate.PreloadInfoReq)localObject1).head.set((MessageMicro)localObject2);
    localObject2 = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 0);
    Object localObject3 = SharedPreferencesHandler.a((SharedPreferences)localObject2, "key_web_plugin_list" + this.a.a(), null);
    if ((localObject3 != null) && (!((Set)localObject3).isEmpty()))
    {
      GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.a.getManager(11);
      localObject3 = ((Set)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        PreloadInfoCheckUpdate.AppBehavior localAppBehavior = new PreloadInfoCheckUpdate.AppBehavior();
        localAppBehavior.appid.set(Integer.parseInt(str));
        localAppBehavior.click_num.set(((SharedPreferences)localObject2).getInt("key_web_plugin_click_num" + str + this.a.a(), 0));
        localAppBehavior.click_red_num.set(((SharedPreferences)localObject2).getInt("key_web_plugin_click_red_num" + str + this.a.a(), 0));
        PBInt32Field localPBInt32Field = localAppBehavior.red_state;
        if (a(localGameCenterManagerImp, str)) {}
        for (i = 2;; i = 1)
        {
          localPBInt32Field.set(i);
          ((PreloadInfoCheckUpdate.PreloadInfoReq)localObject1).app_behavior.add(localAppBehavior);
          break;
        }
      }
    }
    localObject1 = ((PreloadInfoCheckUpdate.PreloadInfoReq)localObject1).toByteArray();
    int i = localObject1.length;
    int j = i + 4;
    localObject2 = new byte[j];
    System.arraycopy(a(j), 0, localObject2, 0, 4);
    System.arraycopy(localObject1, 0, localObject2, 4, i);
    localReqItem.vecParam = ((byte[])localObject2);
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      i = paramRespItem.cResult;
      paramRespItem = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("PreloadInfoCheckUpdateItem", 2, "handleCheckUpdateItemData result=" + i + ",dataLen=" + paramRespItem.length);
      }
      if (i == 2) {
        try
        {
          if (paramRespItem.length > 4)
          {
            i = (int)PkgTools.a(paramRespItem, 0);
            localObject1 = new byte[i - 4];
            PkgTools.a((byte[])localObject1, 0, paramRespItem, 4, i - 4);
            paramRespItem = new PreloadInfoCheckUpdate.PreloadInfoRsp();
            paramRespItem.mergeFrom((byte[])localObject1);
            if (paramRespItem != null)
            {
              localObject1 = (PreloadInfoCheckUpdate.ControlRspHead)paramRespItem.head.get();
              if (localObject1 != null)
              {
                i = ((PreloadInfoCheckUpdate.ControlRspHead)localObject1).code.get();
                if (QLog.isColorLevel()) {
                  QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem preloadInfoRsp data code=" + i);
                }
                if (i != 0) {
                  break label880;
                }
                localObject1 = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 0).edit();
                ((SharedPreferences.Editor)localObject1).putInt("key_preload_strategy" + this.a.a(), paramRespItem.preload_switch.get());
                if (QLog.isColorLevel()) {
                  QLog.d("PreloadInfoCheckUpdateItem", 2, "preload_switch=" + paramRespItem.preload_switch.get());
                }
                ((SharedPreferences.Editor)localObject1).putBoolean("key_preload_flag" + this.a.a(), paramRespItem.preload.get());
                if (QLog.isColorLevel()) {
                  QLog.d("PreloadInfoCheckUpdateItem", 2, "preload=" + paramRespItem.preload.get());
                }
                ((SharedPreferences.Editor)localObject1).putInt("key_check_update_interval" + this.a.a(), paramRespItem.interval.get());
                if (QLog.isColorLevel()) {
                  QLog.d("PreloadInfoCheckUpdateItem", 2, "interval=" + paramRespItem.interval.get());
                }
                localObject3 = paramRespItem.applist.get();
                if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
                  break label650;
                }
                localObject2 = new HashSet();
                localObject3 = ((List)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  str = (String)((Iterator)localObject3).next();
                  ((Set)localObject2).add(str);
                  ((SharedPreferences.Editor)localObject1).putInt("key_web_plugin_click_num" + str + this.a.a(), 0);
                  ((SharedPreferences.Editor)localObject1).putInt("key_web_plugin_click_red_num" + str + this.a.a(), 0);
                }
              }
            }
          }
          return;
        }
        catch (Exception paramRespItem)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem Exception msg=" + paramRespItem.getMessage());
          }
          paramRespItem.printStackTrace();
        }
      }
    }
    label650:
    label880:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      do
      {
        do
        {
          int i;
          Object localObject3;
          String str;
          Object localObject2 = ((Set)localObject2).toArray();
          SharedPreferencesHandler.a((SharedPreferences.Editor)localObject1, "key_web_plugin_list" + this.a.a(), (Object[])localObject2);
          ((SharedPreferences.Editor)localObject1).putInt("key_red_ram" + this.a.a(), paramRespItem.red_ram.get());
          if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "red_ram=" + paramRespItem.red_ram.get());
          }
          ((SharedPreferences.Editor)localObject1).putInt("key_click_ram" + this.a.a(), paramRespItem.click_ram.get());
          if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "click_ram=" + paramRespItem.click_ram.get());
          }
          ((SharedPreferences.Editor)localObject1).putInt("key_last_check_update_timestamp" + this.a.a(), (int)(System.currentTimeMillis() / 1000L));
          ((SharedPreferences.Editor)localObject1).commit();
          paramRespItem = (WebProcessManager)this.a.getManager(12);
        } while (paramRespItem == null);
        paramRespItem.a();
        paramRespItem.b();
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem preloadInfoRsp erro msg=" + ((PreloadInfoCheckUpdate.ControlRspHead)localObject1).err_msg.get());
      return;
    }
    QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem handleCheckUpdateItemData respitem is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PreloadInfoCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */