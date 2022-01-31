import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class gon
  implements Runnable
{
  public gon(MainAcitivityReportHelper paramMainAcitivityReportHelper) {}
  
  private void a()
  {
    SplashActivity localSplashActivity = (SplashActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSplashActivity == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = localSplashActivity.b;
    } while (localQQAppInterface == null);
    String str = localQQAppInterface.a();
    StatisticCollector localStatisticCollector = StatisticCollector.a(localSplashActivity);
    Object localObject = (EmoticonManager)localQQAppInterface.getManager(12);
    if (localObject != null)
    {
      localObject = ((EmoticonManager)localObject).b();
      if (localObject == null) {}
    }
    for (int i = ((List)localObject).size();; i = 0)
    {
      localObject = new HashMap();
      ((Map)localObject).put("Ep_amount", Integer.valueOf(i));
      localStatisticCollector.b(localQQAppInterface, str, (Map)localObject);
      i = 0;
      while (i < 3)
      {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "ep_tab2", 0, StatisticAssist.a(localSplashActivity, str, "ep_tab2" + i), 0, i);
        i += 1;
      }
      i = StatisticAssist.a(localSplashActivity, str, "Ep_offer_info");
      if (i > 0) {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Ep_offer_info", 0, i, 0);
      }
      i = StatisticAssist.a(localSplashActivity, str, "Ep_offer_info_more");
      if (i > 0) {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Ep_offer_info_more", 0, i, 0);
      }
      i = StatisticAssist.a(localSplashActivity, str, "Ep_manage");
      if (i > 0) {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Ep_manage", 0, i, 0);
      }
      i = StatisticAssist.a(localSplashActivity, str, "Clk_ep_edit");
      if (i > 0) {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Clk_ep_edit", 0, i, 0);
      }
      i = StatisticAssist.a(localSplashActivity, str, "Delete_ep");
      if (i > 0) {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Delete_ep", 0, i, 0);
      }
      i = StatisticAssist.a(localSplashActivity, str, "Ep_order");
      if (i <= 0) {
        break;
      }
      localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Ep_order", 0, i, 0);
      return;
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = (SplashActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((SplashActivity)localObject).b;
    } while (localObject == null);
    int i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_op4dongtai");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Clk_data_wire_in", 8, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_op4buddylist");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Clk_data_wire_in", 21, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_op4recent");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Clk_data_wire_in", 22, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_ckpic");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_pic", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_ckvideo");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_video", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_ckfile");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_file", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_cktxt");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_text", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_cktkphoto");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_photo", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_copy");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Long_press_copy", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_forward");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Long_press_retran", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_delete");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Long_press_delete", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_save2weiyun");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Long_press_weiyun", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_ckadv");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "data_wire_setting", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_ckviewrecvfile");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Chkfiles_data_wire", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_ckclearmsg");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Clean_data_wire", 0, i, 0);
    }
    boolean bool = ((QQAppInterface)localObject).getPreferences().getBoolean("auto_receive_files", false);
    StatisticCollector localStatisticCollector = StatisticCollector.a(MainAcitivityReportHelper.a(this.a));
    HashMap localHashMap = new HashMap();
    localHashMap.clear();
    if (bool) {}
    for (i = 1;; i = 0)
    {
      localHashMap.put("auto_receive_files", Integer.valueOf(i));
      localStatisticCollector.b((AppRuntime)localObject, paramString, localHashMap);
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_forwardin_text");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Retran_text", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_forwardin_image");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Retran_pic", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_forwardin_file");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Retran_file", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_forwardin_link");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Retran_link", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_open_via_qq");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Open_via_qq", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_share_my_pc");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "share_my_PC", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "dl_share_frd");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "share_frd", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "Clk_disconnect_wp");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "Wifiphoto", "Clk_disconnect_wp", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "Clk_wp_back");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "Wifiphoto", "Clk_wp_back", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.a), paramString, "Open_wp");
      if (i <= 0) {
        break;
      }
      StatisticCollector.a(MainAcitivityReportHelper.a(this.a)).a((AppRuntime)localObject, paramString, paramString, "Wifiphoto", "Open_wp", 0, i, 0);
      return;
    }
  }
  
  private void b()
  {
    Object localObject1 = (SplashActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {}
    FriendsManagerImp localFriendsManagerImp;
    do
    {
      do
      {
        return;
        localObject1 = ((SplashActivity)localObject1).b;
      } while (localObject1 == null);
      localObject2 = ((QQAppInterface)localObject1).a();
      localFriendsManagerImp = (FriendsManagerImp)((QQAppInterface)localObject1).getManager(8);
    } while (localFriendsManagerImp == null);
    Object localObject2 = localFriendsManagerImp.a((String)localObject2);
    if (localObject2 != null) {}
    for (long l = ((ExtensionInfo)localObject2).pendantId;; l = 0L)
    {
      ReportController.b((QQAppInterface)localObject1, "CliStatus", "", "", "AvatarPendant", "AvatarPendantOn", 0, 0, String.valueOf(l), "", "", "");
      return;
    }
  }
  
  private void c()
  {
    Object localObject1 = (SplashActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ((SplashActivity)localObject1).b;
    } while (localQQAppInterface == null);
    List localList = ((EmoticonManager)localQQAppInterface.getManager(12)).b();
    localObject1 = "";
    Object localObject2 = localObject1;
    int i;
    if (localList != null)
    {
      i = 0;
      localObject2 = localObject1;
      if (i < localList.size())
      {
        localObject2 = (EmoticonPackage)localList.get(i);
        if (3 != ((EmoticonPackage)localObject2).jobType) {
          break label187;
        }
        if (!"100000".equals(((EmoticonPackage)localObject2).epId)) {}
      }
    }
    label187:
    for (;;)
    {
      i += 1;
      break;
      if (((String)localObject1).equals(""))
      {
        localObject1 = ((EmoticonPackage)localObject2).epId;
      }
      else
      {
        localObject1 = (String)localObject1 + "|" + ((EmoticonPackage)localObject2).epId;
        continue;
        ReportController.b(localQQAppInterface, "CliStatus", "", "", "MbBaoyou", "MbBaoyouID", 0, 0, (String)localObject2, "", "", "");
        return;
      }
    }
  }
  
  public void run()
  {
    Object localObject1 = (SplashActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ((SplashActivity)localObject1).b;
    } while (localQQAppInterface == null);
    localObject1 = ((SplashActivity)localObject1).getSharedPreferences("mobileQQi", 0);
    long l2 = ((SharedPreferences)localObject1).getLong("LastTimeLogin_" + localQQAppInterface.a(), 0L);
    long l3 = System.currentTimeMillis() - 10L;
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(l2);
    localCalendar2.add(5, 1);
    localCalendar2.clear(10);
    localCalendar2.clear(12);
    localCalendar2.clear(13);
    localCalendar2.clear(14);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).add(5, 1);
    ((Calendar)localObject2).clear(10);
    ((Calendar)localObject2).clear(12);
    ((Calendar)localObject2).clear(13);
    ((Calendar)localObject2).clear(14);
    long l1 = ((Calendar)localObject2).getTimeInMillis() - l3 - 100L;
    if (l1 < 0L) {
      l1 = 86400000L;
    }
    for (;;)
    {
      if ((l2 > 0L) && (localCalendar1.after(localCalendar2)))
      {
        QQSettingUtil.a(localQQAppInterface);
        NotifyPushSettingActivity.a(localQQAppInterface, localQQAppInterface.a());
        StatisticCollector.a(BaseApplication.getContext()).b(localQQAppInterface, localQQAppInterface.a());
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "friend", Contacts.c);
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "troop", Contacts.b);
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "discussion", Contacts.d);
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "search", Contacts.a);
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "plugin_manage", Leba.f);
        if (DiscussionInfoCardActivity.c > 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "", "discuss", "share_discuss", 0, DiscussionInfoCardActivity.c, 0);
        }
        if (DiscussionInfoCardActivity.d > 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "", "discuss", "copy_link", 0, DiscussionInfoCardActivity.d, 0);
        }
        if (DiscussionInfoCardActivity.e > 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "", "discuss", "share_linkman", 0, DiscussionInfoCardActivity.e, 0);
        }
        if (MttBrowerWrapper.a > 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "", "discuss", "click_link", 0, MttBrowerWrapper.a, 0);
        }
        localObject2 = new HashMap();
        int i = ((SharedPreferences)localObject1).getInt("online_friend_enter_count_" + localQQAppInterface.a(), 0);
        if (i > 0) {
          ((HashMap)localObject2).put("Click_online", Integer.valueOf(i));
        }
        if (AssistantSettingActivity.a > 0) {
          ((HashMap)localObject2).put("Cleancache_pic", Integer.valueOf(AssistantSettingActivity.a));
        }
        i = StatisticTroopAssist.a(MainAcitivityReportHelper.a(this.a), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject2).put("Click_grp_asst", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.b(MainAcitivityReportHelper.a(this.a), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject2).put("grp_setting_asst", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.c(MainAcitivityReportHelper.a(this.a), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject2).put("grp_setting_msg", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.d(MainAcitivityReportHelper.a(this.a), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject2).put("grp_msg_equ", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.e(MainAcitivityReportHelper.a(this.a), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject2).put("grp_msg_dec", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.f(MainAcitivityReportHelper.a(this.a), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject2).put("grp_msg_inc", Integer.valueOf(i));
        }
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), (Map)localObject2);
        StatisticTroopAssist.h(MainAcitivityReportHelper.a(this.a), localQQAppInterface.a());
        FileManagerUtil.a(localQQAppInterface, MainAcitivityReportHelper.a(this.a));
        a(localQQAppInterface.a());
        Object localObject3 = MainAcitivityReportHelper.a(this.a);
        localObject2 = localQQAppInterface.a();
        StatisticCollector localStatisticCollector = StatisticCollector.a((Context)localObject3);
        i = StatisticAssist.a((Context)localObject3, (String)localObject2, "ep_tab");
        if (i > 0) {
          localStatisticCollector.a(localQQAppInterface, (String)localObject2, "", "ep_mall", "ep_tab", 1, i, 0);
        }
        i = StatisticAssist.a((Context)localObject3, (String)localObject2, "ep_mall_in2");
        if (i > 0) {
          localStatisticCollector.a(localQQAppInterface, (String)localObject2, "", "ep_mall", "ep_mall_in", 2, i, 0);
        }
        try
        {
          a();
          b();
          c();
          Object localObject4 = (FriendsManagerImp)localQQAppInterface.getManager(8);
          if (localObject4 != null)
          {
            localObject4 = ((FriendsManagerImp)localObject4).a((String)localObject2);
            if (localObject4 != null) {
              ReportController.b(localQQAppInterface, "CliStatus", "", "", "FontStatus", "FontOn", 0, 0, String.valueOf(((ExtensionInfo)localObject4).uVipFont), "", "", "");
            }
          }
          localObject4 = StatisticAssist.a(localQQAppInterface);
          if (localObject4 != null)
          {
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (MessageReportData)((Iterator)localObject4).next();
              if (((MessageReportData)localObject5).msgCount > 0) {
                localStatisticCollector.c(localQQAppInterface, ((MessageReportData)localObject5).getMsgReport());
              }
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject5;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MainAcitivityReportHelper", 2, "reportAioEmotionData", localException);
            }
          }
          i = localQQAppInterface.a().a(-2002);
          int j = localQQAppInterface.a().c();
          if (j > 0)
          {
            BigDecimal localBigDecimal = new BigDecimal(i * 100.0D / j).setScale(0, 4);
            localObject5 = new HashMap();
            ((HashMap)localObject5).put("pttPercent", Integer.toString(localBigDecimal.intValue()));
            ((HashMap)localObject5).put("pttMsgNum", Integer.toString(i));
            ((HashMap)localObject5).put("totalMsgNum", Integer.toString(j));
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttMsg", true, 0L, 0L, (HashMap)localObject5, null);
            if (QLog.isColorLevel()) {
              QLog.d("SendMessageStatistic", 2, "pttMsgNum=" + i + ",totalMsgNum=" + j + ",pttPercent=" + localBigDecimal);
            }
            localQQAppInterface.a().h();
          }
          i = MainAcitivityReportHelper.a((Context)localObject3, (String)localObject2);
          if (i > 0) {
            StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "Menu_Quit", i);
          }
          i = QQSettingUtil.a((Context)localObject3, (String)localObject2);
          if (i > 0) {
            StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "Setting_Quit", i);
          }
          i = StatisticAssist.a((Context)localObject3, (String)localObject2, "public_account_search_list_click");
          if (i > 0) {
            localStatisticCollector.a(localQQAppInterface, (String)localObject2, "", "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot", 1, i, 0);
          }
          i = NotifyPushSettingActivity.b((Context)localObject3, (String)localObject2, "LED_light");
          localObject3 = new HashMap();
          ((HashMap)localObject3).clear();
          ((HashMap)localObject3).put("LED_light", Integer.valueOf(i));
          localStatisticCollector.b(localQQAppInterface, (String)localObject2, (Map)localObject3);
          PicReporter.a();
          i = ThemeUtil.getThemeSwitchTimes(localQQAppInterface);
          if (i > 0) {
            localStatisticCollector.a(localQQAppInterface, (String)localObject2, "", "theme_mall", "theme_replace", 0, i, 0);
          }
          i = ChatBackgroundSettingActivity.a(MainAcitivityReportHelper.a(this.a), localQQAppInterface.a());
          if (i > 0) {
            localStatisticCollector.a(localQQAppInterface, (String)localObject2, "", "background", "bkground_replace", 0, i, 0);
          }
          MainAcitivityReportHelper.a(this.a, localStatisticCollector);
          MainAcitivityReportHelper.b(this.a, localStatisticCollector);
          this.a.a();
          if (QLog.isColorLevel()) {
            QLog.d("StatisticCollector", 2, "**************report data below:*****************");
          }
          this.a.b(localQQAppInterface.getAccount());
          ((SharedPreferences)localObject1).edit().putLong("LastTimeLogin_" + localQQAppInterface.a(), l3).commit();
        }
      }
      if (localCalendar1.after(localCalendar2))
      {
        ThemeUiPlugin.reportThemeNumAndCurrThemeName(localQQAppInterface, localQQAppInterface.a());
        ChatBackgroundSettingActivity.a(localQQAppInterface, localQQAppInterface.a());
      }
      if (l2 == 0L) {
        ((SharedPreferences)localObject1).edit().putLong("LastTimeLogin_" + localQQAppInterface.a(), l3).commit();
      }
      l2 = (Math.random() * 30.0D * 60.0D * 1000.0D);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, l2 + l1 + 60000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gon
 * JD-Core Version:    0.7.0.1
 */