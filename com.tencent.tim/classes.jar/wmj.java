import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.PoiMapActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.List<Laadm;>;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class wmj
{
  public static String aTe;
  public static String aTf;
  private static int bPo = -1;
  private static acnd i;
  
  public static void Co(int paramInt)
  {
    bPo = paramInt;
  }
  
  public static int a(SessionInfo paramSessionInfo)
  {
    if (aqfy.mq(paramSessionInfo.cZ)) {}
    for (int j = 5;; j = 6)
    {
      if (jof.a().dd(paramSessionInfo.aTl)) {
        j = 1;
      }
      return j;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent1, Intent paramIntent2)
  {
    Object localObject;
    if ((paramIntent1 == null) || (!paramIntent1.hasExtra("showFlashPic")))
    {
      localObject = (HotChatManager)paramQQAppInterface.getManager(60);
      paramIntent2.putExtra("showFlashPic", acei.a(paramSessionInfo.cZ, (HotChatManager)localObject, paramSessionInfo.troopUin));
    }
    paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    int j;
    int k;
    boolean bool2;
    boolean bool1;
    if ((!(paramActivity instanceof SplashActivity)) && (!(paramActivity instanceof ChatActivity)) && (!(paramActivity instanceof LiteActivity)))
    {
      paramIntent2.putExtras(paramActivity.getIntent());
      paramIntent2.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      if (paramIntent1 == null) {
        break label1110;
      }
      j = paramIntent1.getIntExtra("peakconstant.request_code", -1);
      paramIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent1.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      k = paramIntent1.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      bool2 = paramIntent1.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      bool1 = paramIntent1.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
      int m = paramIntent1.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      if (m == 1039) {
        paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      }
      if (m == 1040) {
        paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      paramIntent2.putExtra("PhotoConst.is_troop_send_mixed_msg", paramIntent1.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false));
      PhotoUtils.a(paramIntent1, paramIntent2);
      paramIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", paramIntent1.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false));
      paramIntent2.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", paramIntent1.getBooleanExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", false));
      paramIntent2.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", paramIntent1.getBooleanExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false));
      paramIntent2.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", paramIntent1.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false));
      paramIntent2.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent1.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
      paramIntent2.putExtra("fromPhotoListPanel", paramIntent1.getBooleanExtra("fromPhotoListPanel", false));
      paramIntent2.putExtra("KEY_IS_ANONYMOUS", paramIntent1.getBooleanExtra("KEY_IS_ANONYMOUS", false));
      paramIntent2.putExtra("PhotoConst.SEND_NO_PRESEND", paramIntent1.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false));
    }
    for (;;)
    {
      if ((paramSessionInfo.cZ == 1) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.aTl))) {
        paramIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
      }
      if (paramSessionInfo.cZ == 9501) {
        paramIntent2.putExtra("isdevicesupportmultiupload", true);
      }
      paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", bool2);
      paramIntent2.putExtra("filter_photolist_troopalbum_toolbar", bool1);
      paramIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", k);
      paramIntent2.putExtra("extra_image_sender_tag", "sessionInfo.enterAlbum");
      paramIntent2.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      paramIntent2.putExtra("album_enter_directly", true);
      paramIntent2.putExtra("ALBUM_ID", aqfy.ba(paramActivity));
      paramIntent2.putExtra("ALBUM_NAME", aqfy.bb(paramActivity));
      paramIntent2.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramIntent2.putExtra("uin", paramSessionInfo.aTl);
      paramIntent2.putExtra("uintype", paramSessionInfo.cZ);
      paramIntent2.putExtra("troop_uin", paramSessionInfo.troopUin);
      paramIntent2.putExtra("uinname", paramSessionInfo.aTn);
      paramIntent2.putExtra("entrance", paramSessionInfo.entrance);
      paramIntent2.putExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if ((((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))) && (((FragmentActivity)paramActivity).getChatFragment() != null)) {
        paramIntent2.putExtra("isBack2Root", ((FragmentActivity)paramActivity).getChatFragment().a().aL);
      }
      paramIntent2.putExtra("is_anonymous", jof.a().dd(paramSessionInfo.aTl));
      paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", a(paramSessionInfo));
      paramIntent2.getExtras().remove("forward_type");
      if ((paramIntent1 != null) && (paramIntent1.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false)))
      {
        paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
        paramIntent2.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        paramIntent2.putExtra("session_info", paramSessionInfo);
        paramIntent2.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
        paramIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", Math.min(altg.Z(paramQQAppInterface), k));
      }
      paramIntent2.putExtra("session_info", paramSessionInfo);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        paramIntent2.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PEAK", 2, "enterAlbum() INIT_ACTIVITY_CLASS_NAME=" + paramIntent2.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
        QLog.d("PlusPanelUtils", 2, "enterAlbum  maxNum = " + k);
      }
      return j;
      paramIntent2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localObject = paramIntent2;
      if ((paramActivity instanceof SplashActivity)) {
        localObject = wja.a(paramIntent2, null);
      }
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", paramActivity.getPackageName());
      ((Intent)localObject).putExtra("key_activity_code", ChatActivityUtils.d(paramActivity));
      if (paramSessionInfo.cZ == 9501)
      {
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
        ((Intent)localObject).putExtra(aqfx.REQUEST_CODE, 80);
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", paramActivity.getPackageName());
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        ((Intent)localObject).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
        paramIntent2 = (syw)paramQQAppInterface.getBusinessHandler(51);
        long l1;
        if ((paramIntent2 != null) && (paramIntent2.Nz())) {
          l1 = 0L;
        }
        try
        {
          long l2 = Long.parseLong(paramSessionInfo.aTl);
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (paramIntent2.i(l1, 1)) {
          ((Intent)localObject).putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        }
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
        ((Intent)localObject).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent2 = (Intent)localObject;
        break;
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", paramActivity.getPackageName());
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        ((Intent)localObject).putExtra("key_confess_topicid", paramSessionInfo.topicId);
      }
      label1110:
      bool1 = false;
      bool2 = false;
      j = -1;
      k = 20;
    }
  }
  
  public static void a(Intent paramIntent, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (a(paramSessionInfo, paramQQAppInterface.kp(paramSessionInfo.aTl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "prepareForPicPresend add binder!");
      }
      paramIntent.putExtra("binder_presendService", new BinderWarpper(new akya(paramSessionInfo.cZ, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramQQAppInterface.getAccount(), paramSessionInfo.topicId).asBinder()));
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (((QQAppInterface)paramAppInterface).bF())) {}
    for (;;)
    {
      return;
      if (!aqft.cC())
      {
        QQToast.a(paramActivity, paramActivity.getResources().getString(2131719242), 0).show();
        return;
      }
      paramAppInterface = acbn.SDCARD_IMG_CAMERA;
      boolean bool;
      label56:
      Object localObject;
      if (paramInt2 == 1)
      {
        bool = true;
        paramAppInterface = m(paramAppInterface, bool);
        localObject = new File(acbn.SDCARD_IMG_CAMERA);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", paramAppInterface).commit();
        localObject = new Intent();
        if (paramInt2 != 0) {
          break label202;
        }
        FileProvider7Helper.setSystemCapture(paramActivity, new File(paramAppInterface), (Intent)localObject);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_camera");
        ((Intent)localObject).putExtra("android.intent.extra.quickCapture", true);
        ((Intent)localObject).setFlags(536870912);
      }
      try
      {
        paramActivity.startActivityForResult((Intent)localObject, paramInt1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PlusPanelUtils", 2, "enter sys camera");
        return;
        bool = false;
        break label56;
        label202:
        ((Intent)localObject).setAction("android.media.action.VIDEO_CAPTURE");
        ((Intent)localObject).putExtra("output", Uri.fromFile(new File(paramAppInterface)));
        ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 100);
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          paramAppInterface.printStackTrace();
          QQToast.a(paramActivity, 2131691243, 0).show();
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      BaseChatPie localBaseChatPie = ((FragmentActivity)paramActivity).getChatFragment().a();
      localBaseChatPie.bIs();
      Intent localIntent = new Intent(paramActivity, PoiMapActivity.class).putExtra("uin", paramQQAppInterface.getAccount());
      localIntent.putExtra("is_need_destroy_broadcast", false);
      localIntent.putExtra("sessionType", localBaseChatPie.sessionInfo.cZ);
      boolean bool = ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, true, null);
      localIntent.putExtra("int_unread_msgs_num", paramQQAppInterface.b().bl());
      localIntent.putExtra("boolean_is_default_theme", bool);
      paramActivity.startActivityForResult(localIntent, 18);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      do
      {
        paramQQAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("enterQQMap", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    localIntent = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface = (syw)paramQQAppInterface.getBusinessHandler(51);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.aTl);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        localIntent.putExtra("from_aio", true);
        localIntent.addFlags(536870912);
        localIntent.putExtra("selectMode", true);
        localIntent.putExtra("peerType", paramSessionInfo.cZ);
        localIntent.putExtra("targetUin", paramSessionInfo.aTl);
        if (paramSessionInfo.cZ == 1000) {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.troopUin);
        }
        for (;;)
        {
          if (paramSessionInfo.cZ != 0) {
            break label358;
          }
          localIntent.putExtra("qfile_entrance_type_key", 1);
          break;
          if (paramSessionInfo.cZ == 1006) {
            localIntent.putExtra("srcDiscGroup", paramSessionInfo.phoneNum);
          } else {
            localIntent.putExtra("srcDiscGroup", paramSessionInfo.aTm);
          }
        }
        if (paramSessionInfo.cZ == 3000) {
          localIntent.putExtra("qfile_entrance_type_key", 5);
        } else if (paramSessionInfo.cZ == 1) {
          localIntent.putExtra("qfile_entrance_type_key", 3);
        }
      }
    }
    if ((paramSessionInfo.cZ == 9501) && (paramQQAppInterface != null) && (paramQQAppInterface.Nz()))
    {
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.aTl);
      localIntent.putExtra("peerType", paramSessionInfo.cZ);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", paramQQAppInterface.H(l1));
      if (paramQQAppInterface.i(l1, 1)) {
        localIntent.putExtra("max_select_size", 52428800L);
      }
      if ((paramSessionInfo.cZ == 0) || (paramSessionInfo.cZ == 3000) || (paramSessionInfo.cZ == 1)) {
        localIntent.putExtra("select_file_support_send_docs_file", aeuo.a().aib());
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2130771991, 2130771992);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    avor.a(paramQQAppInterface, "tenpay.com", new wmm(paramInt1, paramSessionInfo, paramQQAppInterface, paramInt2, paramString, paramActivity));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = (syw)paramQQAppInterface.getBusinessHandler(51);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.Nz())) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.aTl);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Intent localIntent;
        localException.printStackTrace();
        continue;
        int j = paramQQAppInterface.H(l1);
      }
    }
    if (paramBoolean)
    {
      j = 2;
      localIntent = new Intent(paramActivity, FMActivity.class);
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.aTl);
      localIntent.putExtra("peerType", paramSessionInfo.cZ);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", j);
      localIntent.putExtra("smart_device_switch_tab_flag", paramInt);
      if (paramQQAppInterface.i(l1, 1)) {
        localIntent.putExtra("max_select_size", 52428800);
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2130771991, 2130771992);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, aadm paramaadm, List<aadm> paramList, int paramInt)
  {
    if (paramaadm == null) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      RedPacketManager.CURRENT_PANEL_DATA.clear();
      RedPacketManager.CURRENT_PANEL_DATA.addAll(paramList);
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
    localIntent.putExtra("come_from", 2);
    localIntent.putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#aio");
    localIntent.putExtra("isFromPanel", true);
    Object localObject1 = String.valueOf(2);
    int k = 1;
    int j = 0;
    Object localObject2 = "";
    paramList = (zxj)paramQQAppInterface.getManager(125);
    if (paramList != null) {}
    label165:
    label1706:
    label1714:
    for (String str = paramList.qa();; str = null)
    {
      if (paramSessionInfo.cZ == 0)
      {
        j = 1;
        paramList = "entrance.click.c2c";
        k = 1;
      }
      label1648:
      for (;;)
      {
        int m;
        if (RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramaadm.type)) == null) {
          m = 1;
        }
        Object localObject3;
        switch (paramaadm.type)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        default: 
          localObject3 = "";
          paramaadm = (aadm)localObject1;
          localObject1 = localObject3;
        case 0: 
        case 1: 
        case 2: 
        case 6: 
        case 7: 
          for (;;)
          {
            localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + j, 0, null));
            localObject3 = new JSONObject();
            try
            {
              ((JSONObject)localObject3).put("recv_type", j);
              ((JSONObject)localObject3).put("recv_uin", paramSessionInfo.aTl);
              ((JSONObject)localObject3).put("channel", m);
              ((JSONObject)localObject3).put("bus_type", paramaadm);
              if (k > 0) {
                ((JSONObject)localObject3).put("people_num", k);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                ((JSONObject)localObject3).put("session_token", localObject2);
              }
              if (str != null) {
                ((JSONObject)localObject3).put("placeholder", str);
              }
              if (0 != 0) {
                ((JSONObject)localObject3).put("extra_info", null);
              }
            }
            catch (JSONException paramaadm)
            {
              for (;;)
              {
                long l;
                paramaadm.printStackTrace();
                continue;
                if (paramInt == 1)
                {
                  xro.i(paramQQAppInterface, "0X8005FC9", paramSessionInfo.cZ);
                  continue;
                  if (bPo == 1)
                  {
                    paramActivity = paramList + ".quick";
                  }
                  else
                  {
                    paramActivity = paramList;
                    continue;
                    paramList = "";
                  }
                }
              }
              paramList = "";
              k = 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PlusPanel", 2, "click HongBao:params=" + ((JSONObject)localObject3).toString());
            }
            localIntent.putExtra("extra_data", ((JSONObject)localObject3).toString());
            paramActivity.startActivity(localIntent);
            if (paramInt != 0) {
              break label1648;
            }
            xro.i(paramQQAppInterface, "0X8005CAF", paramSessionInfo.cZ);
            if (bPo != 0) {
              break label1668;
            }
            paramActivity = paramList + ".plus";
            anot.a(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramActivity, 0, 0, (String)localObject1, "", "", "");
            return;
            if (paramSessionInfo.cZ == 3000)
            {
              j = 2;
              paramList = "entrance.click.group";
              k = ((acdu)paramQQAppInterface.getManager(53)).cn(paramSessionInfo.aTl);
              break;
            }
            if (paramSessionInfo.cZ == 1)
            {
              paramList = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo.aTl);
              j = k;
              if (paramList != null)
              {
                j = paramList.wMemberNum;
                if (QLog.isColorLevel()) {
                  QLog.d("PlusPanelUtils", 2, "troop uin：" + paramSessionInfo.aTl + " people_num：" + j);
                }
              }
              if (QWalletHelper.isNeedUpdateTroopMemberNum(paramSessionInfo.aTl)) {}
              try
              {
                l = Long.parseLong(paramSessionInfo.aTl);
                paramList = (acms)paramQQAppInterface.getBusinessHandler(20);
                if (i == null) {
                  i = new wml(paramSessionInfo);
                }
                paramQQAppInterface.addObserver(i);
                paramList.I(l, 32, 0);
              }
              catch (NumberFormatException paramList)
              {
                for (;;)
                {
                  if (QLog.isColorLevel())
                  {
                    QLog.d("angelzhuang", 2, "群uin：" + paramSessionInfo.aTl + " 解析失败");
                    continue;
                    k = 3;
                  }
                }
              }
              paramList = (HotChatManager)paramQQAppInterface.getManager(60);
              if ((paramList != null) && (paramList.kj(paramSessionInfo.aTl)))
              {
                anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005B9C", "0X8005B9C", 0, 0, "", "", "", "");
                k = 6;
                paramList = "entrance.click.chatgroup";
                m = j;
                j = k;
                k = m;
                break;
              }
            }
            if (paramSessionInfo.cZ == 1000)
            {
              j = 4;
              localObject2 = paramSessionInfo.troopUin;
              paramList = "entrance.click.c2c";
              k = 1;
              break;
            }
            if (paramSessionInfo.cZ == 1004)
            {
              j = 5;
              localObject2 = paramSessionInfo.troopUin;
              paramList = "entrance.click.c2c";
              k = 1;
              break;
            }
            if ((paramSessionInfo.cZ != 1001) && (paramSessionInfo.cZ != 10002) && (paramSessionInfo.cZ != 10004)) {
              break label1714;
            }
            if (paramSessionInfo.cZ == 10004) {}
            for (paramList = paramQQAppInterface.a().S(paramSessionInfo.aTl);; paramList = paramQQAppInterface.a().T(paramSessionInfo.aTl))
            {
              if (paramList == null) {
                break label1706;
              }
              paramList = aqgo.encodeToString(paramList, 2);
              anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005B9D", "0X8005B9D", 0, 0, "", "", "", "");
              localObject3 = "entrance.click.c2c";
              localObject2 = paramList;
              j = 7;
              k = 1;
              paramList = (List<aadm>)localObject3;
              break;
            }
            m = ((Integer)RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramaadm.type))).intValue();
            break label165;
            localObject1 = "13140";
            paramaadm = String.valueOf(1);
            continue;
            localObject1 = "13141";
            paramaadm = String.valueOf(2);
            continue;
            localObject3 = "13142";
            paramaadm = (aadm)localObject1;
            localObject1 = localObject3;
            continue;
            localObject3 = "13146";
            paramaadm = (aadm)localObject1;
            localObject1 = localObject3;
            continue;
            localObject3 = "13147";
            paramaadm = (aadm)localObject1;
            localObject1 = localObject3;
          }
        case 5: 
          l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
          paramSessionInfo = new Intent(paramActivity, QrcodeHbGuiderActivity.class);
          paramSessionInfo.putExtra("appInfo", "");
          paramSessionInfo.putExtra("vacreport_key_seq", l);
          paramActivity.startActivity(paramSessionInfo);
          anot.a(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "plus.hongbao.click", 0, 0, "", "", "", "");
          return;
        case 3: 
          if (paramaadm.params != null) {}
          for (paramaadm = paramaadm.params.optString("theme_id", "");; paramaadm = "")
          {
            localIntent.putExtra("theme_type", paramaadm);
            localIntent.putExtra("theme", true);
            m = 1;
            localObject3 = "";
            paramaadm = (aadm)localObject1;
            localObject1 = localObject3;
            break;
          }
        case 4: 
          if (paramaadm.params == null) {
            break;
          }
          paramList = paramaadm.params.optString("url", "");
          paramQQAppInterface = paramList;
          if (paramaadm.params.optInt("subtype", 0) == 1) {
            if (paramList.indexOf("?") != -1) {
              break label1427;
            }
          }
          for (paramQQAppInterface = paramList + "?recv_uin=" + paramSessionInfo.aTl + "&recv_type=" + j;; paramQQAppInterface = paramList + "&recv_uin=" + paramSessionInfo.aTl + "&recv_type=" + j)
          {
            y(paramActivity, paramQQAppInterface);
            return;
          }
        case 12: 
          paramaadm = paramaadm.params.optString("schema");
          if (TextUtils.isEmpty(paramaadm)) {
            break;
          }
          a(paramQQAppInterface, paramActivity, paramSessionInfo, j, k, paramaadm);
          return;
        case 13: 
          paramaadm = paramaadm.params.optString("schema", "");
          if (TextUtils.isEmpty(paramaadm)) {
            break;
          }
          paramList = new HashMap();
          paramList.put("recv_group_type", j + "");
          paramList.put("recv_group_id", paramSessionInfo.aTl);
          paramList.put("send_uin", paramQQAppInterface.getCurrentUin());
          paramQQAppInterface = avor.a(paramaadm, paramList, true);
          if (QLog.isColorLevel()) {
            QLog.i("PlusPanelUtils", 2, "[go to miniapp] finalSchame: " + paramQQAppInterface);
          }
          aagc.M(paramActivity, paramQQAppInterface);
          return;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    anot.a(paramQQAppInterface, "CliOper", "", paramSessionInfo.aTl, "Music_gene", "Music_gene_AIO", 0, 0, String.valueOf(fb(paramSessionInfo.cZ)), "", "", "");
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface.putExtra("url", "https://y.qq.com/m/qzonemusic/mqzsearch.html" + "?touin=" + paramSessionInfo.aTl + "&uintype=" + paramSessionInfo.cZ + "&_wv=1&entry=aio&_bid=203");
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is null");
      }
    }
    for (;;)
    {
      paramQQAppInterface.putExtra("hide_left_button", true);
      paramQQAppInterface.putExtra("show_right_close_button", true);
      paramQQAppInterface.putExtra("finish_animation_up_down", true);
      paramActivity.startActivity(paramQQAppInterface);
      paramActivity.overridePendingTransition(2130771991, 0);
      return;
      paramQQAppInterface.putExtra("url", paramString.replace("$FriendUin$", paramSessionInfo.aTl).replace("$CurType$", String.valueOf(paramSessionInfo.cZ)));
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is get from file");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent)
  {
    a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, paramIntent, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent, HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      paramIntent.putExtra("PhotoConst.MY_UIN", paramSessionInfo.Vx);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
      paramIntent.putExtra("KEY_IS_ANONYMOUS", jof.a().dd(paramSessionInfo.aTl));
      localIntent.putExtra("enter_from", 1);
      int j = a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, paramIntent, localIntent);
      if (j == -1) {
        paramActivity.startActivity(localIntent);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "enterPhotoPicker");
        }
        aqfy.anim(paramActivity, false, true);
        if (avfp.h != null) {
          avfp.h.dqV();
        }
        return;
        paramQQAppInterface = zsh.d(paramHashMap);
        if (paramQQAppInterface != null) {
          localIntent.putExtra("PhotoConst.editPathMap", paramQQAppInterface);
        }
        paramActivity.startActivityForResult(localIntent, j);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo)
  {
    new wmo(paramSessionInfo, paramQQAppInterface, paramContext, aqhu.getRealPathFromContentURI(paramContext, paramUri)).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, BaseChatPie paramBaseChatPie)
  {
    if (jln.xR()) {
      return;
    }
    jln localjln = jln.a(paramContext);
    int[] arrayOfInt = new int[5];
    localjln.setMainTitle(2131689654);
    if (((paramSessionInfo.cZ == 1025) || (paramSessionInfo.cZ == 0) || (paramSessionInfo.cZ == 1000) || (paramSessionInfo.cZ == 1004)) && (((asgx)paramQQAppInterface.getManager(165)).sK(paramSessionInfo.aTl)))
    {
      arrayOfInt[0] = 5;
      localjln.addButton(2131700358);
    }
    for (int j = 1;; j = 0)
    {
      arrayOfInt[j] = 1;
      localjln.addButton(2131721238);
      j += 1;
      arrayOfInt[j] = 2;
      localjln.addButton(2131721260);
      localjln.addCancelButton(2131721058);
      localjln.a(new wmk(paramQQAppInterface));
      localjln.a(new wmn(localjln, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramBaseChatPie, paramContext, paramString));
      localjln.show();
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map<String, String> paramMap)
  {
    String str2;
    String str1;
    if (paramBoolean)
    {
      str2 = "0X80049C5";
      switch (paramSessionInfo.cZ)
      {
      default: 
        str1 = "0";
      }
    }
    for (;;)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", str2, str2, 0, 0, str1, "", "", "");
      b(paramQQAppInterface, paramContext, paramSessionInfo, paramBoolean, paramString, paramMap);
      return;
      str2 = "0X80049C7";
      break;
      str1 = "0";
      continue;
      str1 = "1";
      continue;
      str1 = "2";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
      continue;
      str1 = "5";
      continue;
      str1 = "6";
      continue;
      str1 = "7";
      continue;
      str1 = "30";
      continue;
      str1 = "4";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanelUtils", 2, "enter Camera");
    }
    if (AudioHelper.isForbidByRubbishMeizu(0))
    {
      aqha.a(paramContext, 230, paramContext.getString(2131700589), paramContext.getString(2131700590), new wmp(), null).show();
      return;
    }
    if (AudioHelper.mr(0))
    {
      aqha.a(paramContext, 230, paramContext.getString(2131700589), paramContext.getString(2131700591), new wmq(), null).show();
      return;
    }
    if (paramQQAppInterface.getApp().checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0)
    {
      aqha.a(paramContext, 230, paramContext.getString(2131700589), acfp.m(2131709778), new wmr(), null).show();
      return;
    }
    paramQQAppInterface.a().dWq();
    if (paramInt2 == 0) {}
    for (int j = 1;; j = 17000)
    {
      a(paramQQAppInterface, paramBaseActivity, j, paramInt2);
      aarz.cxI();
      paramBaseActivity.setCanLock(false);
      if (paramSessionInfo.cZ != 9501) {
        break;
      }
      tar.a(paramQQAppInterface, Long.parseLong(paramSessionInfo.aTl), "Usr_AIO_SendMsg", 2, 0, paramInt1);
      return;
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool4 = DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpresend_whitelist.name());
    Object localObject = BaseApplication.getContext();
    int j;
    boolean bool2;
    boolean bool1;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    if (Build.VERSION.SDK_INT > 10)
    {
      j = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", j);
      bool2 = ((SharedPreferences)localObject).getBoolean("key_presend_off_flag", false);
      bool1 = bool2;
      if (bool2)
      {
        long l = ((SharedPreferences)localObject).getLong("key_presend_off_time", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l > 86400000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "isPresendAllowed,PicPresend off more than 24h ,enable PicPresend!");
          }
          ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", false).commit();
          bool1 = false;
        }
      }
      if (DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "isPresendAllowed ,is VIP User");
        }
        bool1 = false;
      }
      if (paramSessionInfo.cZ != 1001)
      {
        bool2 = bool1;
        if (paramSessionInfo.cZ != 10002) {}
      }
      else
      {
        bool2 = bool1;
        if (!paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "isPresendAllowed,old lbs protocol ,disable PicPresend!");
          }
          bool2 = true;
        }
      }
      if (paramSessionInfo.cZ != 9500)
      {
        paramBoolean = bool2;
        if (paramSessionInfo.cZ != 9501) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "curType is smart device ,disable PicPresend!");
        }
        paramBoolean = true;
      }
      paramSessionInfo = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.pic_presend.name(), "0|0|0|0|1|0|1|1|1048576|0|307200|307200|0|90|70|50");
      bool1 = paramBoolean;
      if (!paramBoolean)
      {
        bool1 = paramBoolean;
        if (paramSessionInfo != null)
        {
          bool1 = paramBoolean;
          if (paramSessionInfo.length() > 0)
          {
            paramSessionInfo = paramSessionInfo.split("\\|");
            bool1 = paramBoolean;
            if (paramSessionInfo.length >= 4)
            {
              bool2 = paramSessionInfo[0].equals("1");
              bool5 = paramSessionInfo[1].equals("1");
              bool6 = paramSessionInfo[2].equals("1");
              bool7 = paramSessionInfo[3].equals("1");
              j = aqiw.getSystemNetwork(BaseApplicationImpl.getContext());
            }
          }
        }
      }
      switch (j)
      {
      default: 
        label392:
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("PEAK", 2, "isPresendAllowed netType = " + j + ",enablePreCompress_WIFI:" + bool2 + ", enablePreCompress_2G = " + bool5 + ", enablePreCompress_3G = " + bool6 + ", enablePreCompress_4G = " + bool7 + ", presendOFF  = " + paramBoolean);
          bool1 = paramBoolean;
        }
        if ((bool4) || (bool1)) {
          break;
        }
      }
    }
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "isPresendAllowed, isInDPCPicPresendWhiteList :" + bool4 + ", presendOFF = " + bool1 + ", result  = " + paramBoolean);
      }
      return paramBoolean;
      j = 0;
      break;
      if (!bool2)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
      if (!bool5)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
      if (!bool6)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
      if (!bool7)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("bEnterToSelect", true);
    localIntent.putExtra("paSessionInfo", paramSessionInfo);
    avja.a(paramActivity, paramQQAppInterface.getAccount(), localIntent, -1, false);
    avjg.b(paramQQAppInterface, 3, paramSessionInfo.cZ);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map<String, String> paramMap)
  {
    Object localObject = (ajdo)paramQQAppInterface.getManager(11);
    String str;
    if (paramSessionInfo.cZ == 1006) {
      str = ((ajdo)localObject).dv(paramSessionInfo.aTl);
    }
    for (localObject = paramSessionInfo.aTl; paramString == null; localObject = ((ajdo)localObject).di(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.cZ, str, paramSessionInfo.aTn, (String)localObject, paramBoolean, paramSessionInfo.troopUin, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.aTl;
    }
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.cZ, str, paramSessionInfo.aTn, (String)localObject, paramBoolean, paramSessionInfo.troopUin, true, true, null, paramString, paramMap);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = new Intent(paramActivity, FMLocalFileActivity.class);
    paramQQAppInterface.putExtra("category", 15);
    paramQQAppInterface.putExtra("busiType", 5);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.cZ);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.aTl);
    paramQQAppInterface.putExtra("STRING_Show_Music_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Video_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Apk_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Pic_Category", false);
    paramQQAppInterface.putExtra("STRING_SingleSelect", false);
    paramQQAppInterface.putExtra("max_select_count", 5);
    paramQQAppInterface.putExtra(aqfx.REQUEST_CODE, 84);
    paramQQAppInterface.putExtra("STRING_Show_Within_Suffixs", new String[] { "doc", "docx", "txt", "pdf", "ppt", "pptx", "xls", "xlsx", "bmp", "jpg", "gif", "png" });
    paramActivity.startActivityForResult(paramQQAppInterface, 84);
    aqfy.anim(paramActivity, false, true);
  }
  
  private static int fb(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static String getCameraPath()
  {
    return hp(acbn.SDCARD_IMG_CAMERA);
  }
  
  public static String hp(String paramString)
  {
    return m(paramString, false);
  }
  
  public static void l(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("enter_from", 1);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent = wja.a(localIntent, null);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
    localIntent.putExtra("fromPhotoListPanel", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20 - paramInt);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
    localIntent.putExtra("ALBUM_ID", aqfy.ba(paramActivity));
    localIntent.putExtra("ALBUM_NAME", aqfy.bb(paramActivity));
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("input_full_screen_mode", true);
    paramActivity.startActivityForResult(localIntent, 100017);
    aqfy.anim(paramActivity, false, true);
  }
  
  public static String m(String paramString, boolean paramBoolean)
  {
    int j = 1;
    Object localObject = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("IMG");
    localStringBuilder.append(((Calendar)localObject).get(1));
    int k = ((Calendar)localObject).get(2) + 1;
    if (k < 10)
    {
      paramString = "0" + k;
      localStringBuilder.append(paramString);
      k = ((Calendar)localObject).get(5);
      if (k >= 10) {
        break label322;
      }
      paramString = "0" + k;
      label115:
      localStringBuilder.append(paramString);
      k = ((Calendar)localObject).get(11);
      if (k >= 10) {
        break label330;
      }
      paramString = "0" + k;
      label157:
      localStringBuilder.append(paramString);
      k = ((Calendar)localObject).get(12);
      if (k >= 10) {
        break label338;
      }
      paramString = "0" + k;
      label199:
      localStringBuilder.append(paramString);
      k = ((Calendar)localObject).get(13);
      if (k >= 10) {
        break label346;
      }
      paramString = "0" + k;
      label241:
      localStringBuilder.append(paramString);
      if (!paramBoolean) {
        break label354;
      }
    }
    label322:
    label330:
    label338:
    label346:
    label354:
    for (paramString = ".mp4";; paramString = ".jpg")
    {
      if (new File(localStringBuilder.toString() + paramString).exists()) {
        break label361;
      }
      return localStringBuilder.toString() + paramString;
      paramString = Integer.valueOf(k);
      break;
      paramString = Integer.valueOf(k);
      break label115;
      paramString = Integer.valueOf(k);
      break label157;
      paramString = Integer.valueOf(k);
      break label199;
      paramString = Integer.valueOf(k);
      break label241;
    }
    label361:
    localObject = new StringBuilder(localStringBuilder);
    k = localStringBuilder.length();
    for (;;)
    {
      if (j < 2147483647)
      {
        ((StringBuilder)localObject).append('(');
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(')');
        ((StringBuilder)localObject).append(paramString);
        if (new File(((StringBuilder)localObject).toString()).exists()) {}
      }
      else
      {
        return ((StringBuilder)localObject).toString();
      }
      ((StringBuilder)localObject).delete(k, ((StringBuilder)localObject).length());
      j += 1;
    }
  }
  
  public static int vP()
  {
    return bPo;
  }
  
  public static void y(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        int j;
        do
        {
          return;
          j = paramString.indexOf(':');
        } while (j == -1);
        localObject = paramString.substring(0, j);
      } while (TextUtils.isEmpty((CharSequence)localObject));
      localObject = ((String)localObject).toLowerCase();
    } while ((((String)localObject).compareTo("http") != 0) && (((String)localObject).compareTo("https") != 0));
    Object localObject = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    paramActivity.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmj
 * JD-Core Version:    0.7.0.1
 */