import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class aqmj
{
  protected static List<String> IR;
  
  public static void A(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_merge_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void A(Context paramContext, String paramString, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("key_notification_push_gray_tips_time_millis_today_zero_" + paramString, paramLong).apply();
  }
  
  public static void A(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("docs_export_file_is_first_" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static void B(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_crop_and_group_version_3058_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void B(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("sticker_remove_emoticon_package_time_" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void B(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("has_show_profile_nick_reddot" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void C(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_remote_reset_config_version_3058_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void C(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("emotion_rec_setting_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static String Ch()
  {
    String str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getAccount();
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString(str + "beancurd_config_data", "");
  }
  
  public static String Ci()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString("identification_download_path_other_new", "");
  }
  
  public static String Cj()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString("schedule_holidays", "");
  }
  
  public static void D(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("hot_friend_chat_config_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void D(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("record_delete_roaming_setting_switch_" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static void E(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("hot_friend_new_boat_config_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void E(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("emotion_edit_guide_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void F(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "shortvideo_dynamic_adjustment", paramInt);
    paramContext.commit();
  }
  
  public static void F(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("keyword_and_remark_version_code" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void F(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("emotion_edit_guide_pop_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void G(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("medal_config_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void G(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("send_bless_version_code" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void G(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("group_team_work_file", 4).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void H(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("scribble_red_switch_config_ver_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void H(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "nearby_flower_gray_tips_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void H(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = "key_cloud_file_guide_banner&" + paramString + "&AutoSaveGuideOpen";
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void I(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "weiyun_mini_app_gray_enable", paramInt);
    paramContext.apply();
  }
  
  public static void I(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "nearby_hotchat_v_list_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void I(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = "key_cloud_file_guide_banner&" + paramString + "&AutoSaveGuideClose";
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void I(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("is_nearby_auth_video_authentic", paramBoolean);
    paramContext.commit();
  }
  
  public static void J(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "weiyun_mini_app_version", paramInt);
    paramContext.apply();
  }
  
  public static void J(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "green_video_appid", paramInt);
    paramContext.commit();
  }
  
  public static void J(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("key_tam_work_doc_add_copy_success_first_time" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void J(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("kandian_read_data", paramBoolean);
    paramContext.commit();
  }
  
  public static int K(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("entry_config_verion_code_" + paramString, 0);
  }
  
  public static void K(Context paramContext, int paramInt, String paramString)
  {
    paramContext.getSharedPreferences("sso_list", 4).edit().putInt(paramString + "_sso_list_version", paramInt).apply();
  }
  
  public static void K(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("green_video_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void K(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("kandian_video_sound", paramBoolean);
    paramContext.commit();
  }
  
  public static int L(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("group_video_version_code_" + paramString, 0);
  }
  
  public static void L(Context paramContext, int paramInt, String paramString)
  {
    paramContext.getSharedPreferences("sso_list", 4).edit().putInt(paramString + "_sso_list_appid", paramInt).apply();
  }
  
  public static void L(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "video_compress_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static void L(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_res_damaged", paramBoolean);
    paramContext.commit();
  }
  
  public static int M(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("individuation_abtest_code_" + paramString, 0);
  }
  
  public static void M(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("video_compress_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void M(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("video_redbag_res_damaged", paramBoolean);
    paramContext.commit();
  }
  
  public static int Md()
  {
    String str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getAccount();
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt(str + "beancurd_config_version", 0);
  }
  
  public static int Me()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt("identification_download_version", 0);
  }
  
  public static int Mf()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt("identification_download_res_mode", 0);
  }
  
  public static int N(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "hotchat_classify_version_code", 0);
  }
  
  public static void N(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "search_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void N(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("readinjoy_folder_nickname", paramString1);
    paramContext.putString("readinjoy_folder_icon_url", paramString2);
    paramContext.commit();
  }
  
  public static void N(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("key_keep_alive_guide", paramBoolean);
    paramContext.commit();
  }
  
  public static int O(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qfind_pidlist_version_code", 0);
  }
  
  public static void O(int paramInt1, int paramInt2, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putInt("lastSeq" + paramInt1 + paramString, paramInt2);
    localEditor.commit();
  }
  
  public static void O(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static void O(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove(paramString2 + "_" + paramString1);
    paramContext.commit();
  }
  
  public static int P(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "", 0);
  }
  
  public static void P(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "search_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static void P(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("buluo_enter_url_config", 4).edit();
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "buluo_enter_url_config", paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.remove(paramString1 + "_" + "buluo_enter_url_config");
    }
  }
  
  public static int Q(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pushbanner_ad_version_code", 0);
  }
  
  public static void Q(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "subscript_recommend_config_version" + "_" + "3.4.4.3058", paramInt);
    paramContext.commit();
  }
  
  public static void Q(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1 + "_" + "buluo_profile_summary_url_config", paramString2);
    paramContext.commit();
  }
  
  public static int R(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "birthday_splash_version_code", 0);
  }
  
  public static void R(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "readinjoy_local_channel_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void R(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1 + "_" + "hot_chat_link", paramString2);
    paramContext.commit();
  }
  
  public static int S(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("keyword_and_remark_version_code" + paramString, 0);
  }
  
  public static String S(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("classic_head_activity_config_" + paramString, "");
  }
  
  public static void S(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qwallet_setting_version", paramInt);
    paramContext.commit();
  }
  
  public static void S(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1 + "_" + "robot_aio_bar", paramString2);
    paramContext.commit();
  }
  
  public static boolean S(int paramInt, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("hasClicked" + paramInt + paramString, false);
  }
  
  public static void SM(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putBoolean("poke_emo_download_mark", paramBoolean);
    localEditor.commit();
  }
  
  public static int T(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("send_bless_version_code" + paramString, 0);
  }
  
  public static String T(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("buluo_enter_url_config", 4).getString(paramString + "_" + "buluo_enter_url_config", "");
  }
  
  public static void T(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "passwd_red_bag_setting_version", paramInt);
    paramContext.commit();
  }
  
  public static void T(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1 + "_" + "robot_voice_tail", paramString2);
    paramContext.commit();
  }
  
  public static int U(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("general_configs_version_code_" + paramString, 0);
  }
  
  public static String U(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "buluo_profile_summary_url_config", "https://buluo.qq.com/mobile/personal_v2.html?_wv=16778243");
  }
  
  public static void U(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("pre_download_dialog_version" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void U(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "quick_shot_share_to_story_config", paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.remove(paramString1 + "_" + "quick_shot_share_to_story_config");
    }
  }
  
  public static void UV(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putLong(paramString + "_" + "clean_disk_cache_time", NetConnInfoCenter.getServerTime() / 3600L);
    localEditor.commit();
  }
  
  public static void UW(String paramString)
  {
    String str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getAccount();
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString(str + "beancurd_config_data", paramString);
  }
  
  public static void UX(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putString("identification_download_path_other_new", paramString);
    localEditor.commit();
  }
  
  public static int V(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("general_android_configs_version_code_" + paramString, 0);
  }
  
  public static String V(Context paramContext, String paramString)
  {
    paramString = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "hot_chat_link", "https://play.mobile.qq.com/play/mqqplay/hotchat/index_v2.html?_wv=1027&_bid=2152");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory", 2, "getHotChatLink,link:" + paramString);
    }
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://play.mobile.qq.com/play/mqqplay/hotchat/index_v2.html?_wv=1027&_bid=2152";
    }
    return paramContext;
  }
  
  public static void V(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("upgrade_tim_version" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void V(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "story_player_proxy_config", paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.remove(paramString1 + "_" + "story_player_proxy_config");
    }
  }
  
  public static int W(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "qav_upgrade_invite_config_version", 0);
  }
  
  public static String W(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "robot_aio_bar", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory", 2, "getRobotAioBar,aio_bar:" + paramContext);
    }
    return paramContext;
  }
  
  public static void W(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("photo_plus_sticker_version" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void W(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putString(paramString1 + "_" + "local_set_top_troop_uploaded_ignore", localSharedPreferences.getString(new StringBuilder().append(paramString1).append("_").append("local_set_top_troop_uploaded_ignore").toString(), "") + "_" + paramString2);
    localEditor.commit();
    if (IR == null) {
      IR = f(paramContext, paramString1);
    }
    IR.add(paramString2);
  }
  
  public static int X(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "qav_anychat_time_limit_config_version", 0);
  }
  
  public static String X(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "robot_voice_tail", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory", 2, "getRobotVoiceTail,aio_bar:" + paramContext);
    }
    return paramContext;
  }
  
  public static void X(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "readinjoy_folder_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void X(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("troop_gift_url_config", 0);
    paramContext.edit().putString(paramString1, paramString2);
    paramContext.edit().commit();
  }
  
  public static void XD(int paramInt)
  {
    String str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getAccount();
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putInt(str + "beancurd_config_version", paramInt).apply();
  }
  
  public static void XE(int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putInt("identification_download_version", paramInt);
    localEditor.commit();
  }
  
  public static void XF(int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putInt("identification_download_res_mode", paramInt);
    localEditor.commit();
  }
  
  public static int Y(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "now_tab_config_cmd_version", 0);
  }
  
  public static String Y(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "story_player_proxy_config", null);
  }
  
  public static void Y(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, "updateSupportFriendshipReactive code: " + paramInt);
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "hot_friendship_support_key", paramInt);
    paramContext.commit();
  }
  
  public static void Y(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, false, "device_manage_switch", paramString2);
  }
  
  public static int Z(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "now_download_engine_cmd_version", 0);
  }
  
  public static String Z(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("troop_gift_url_config", 0).getString(paramString, "");
  }
  
  public static void Z(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "create_troop_max_invite_num", paramInt);
    paramContext.commit();
  }
  
  public static void Z(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("qq_pre_down_yyb", 0);
    paramContext.edit().putString(paramString1, paramString2);
    paramContext.edit().commit();
  }
  
  public static void Z(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_qqstory_feed_timeout_second_" + paramString2;
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putInt(paramString2, paramInt).apply();
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getInt(paramContext, paramInt);
  }
  
  public static int a(BaseApplication paramBaseApplication)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramBaseApplication.getApplicationContext()).getInt("qim_dynamic_text_cfg_version", 0);
  }
  
  public static long a(String paramString, Context paramContext)
  {
    paramString = paramString + "&" + "key_ignore_battery_optimize_last_show_time";
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString, 0L);
  }
  
  public static SharedPreferences a(String paramString1, String paramString2)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences(paramString2 + paramString1, 0);
  }
  
  public static Float a(Context paramContext, String paramString)
  {
    return Float.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getFloat("scribble_red_version_conf_" + paramString, 0.0F));
  }
  
  public static Object a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramString = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "push_recommend_shield_config", Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return Integer.valueOf(paramContext.getInt(paramString, 0));
    }
    return paramContext.getString(paramString, "");
  }
  
  public static Object a(Context paramContext, String paramString1, String paramString2, Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = PreferenceManager.getDefaultSharedPreferencesName(paramContext);; str = paramContext.getPackageName() + "_preferences") {
      return a(paramContext, str, paramString1, paramString2, paramObject);
    }
  }
  
  public static Object a(Context paramContext, String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0);
    try
    {
      paramString1 = paramString3 + paramString2;
      if ((paramObject.getClass() == Integer.TYPE) || (paramObject.getClass() == Integer.class)) {
        return Integer.valueOf(paramContext.getInt(paramString1, ((Integer)paramObject).intValue()));
      }
      if (paramObject.getClass() == String.class) {
        return paramContext.getString(paramString1, (String)paramObject);
      }
      if ((paramObject.getClass() == Boolean.TYPE) || (paramObject.getClass() == Boolean.class)) {
        return Boolean.valueOf(paramContext.getBoolean(paramString1, ((Boolean)paramObject).booleanValue()));
      }
      if ((paramObject.getClass() == Float.TYPE) || (paramObject.getClass() == Float.class)) {
        return Float.valueOf(paramContext.getFloat(paramString1, ((Float)paramObject).floatValue()));
      }
      if ((paramObject.getClass() == Long.TYPE) || (paramObject.getClass() == Long.class))
      {
        long l = paramContext.getLong(paramString1, ((Long)paramObject).longValue());
        return Long.valueOf(l);
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("QQStoryFeedManager", 1, paramContext, new Object[0]);
    }
    return paramObject;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("dynamic_splash_config_version", paramInt1);
    paramContext.putInt("dynamic_splash_config_play_times", paramInt2);
    paramContext.putInt("dynamic_splash_config_play_internal", paramInt3);
    paramContext.putInt("dynamic_splash_config_show_times", paramInt4);
    paramContext.putString("dynamic_splash_config_md5", paramString1);
    paramContext.putString("dynamic_splash_config_effective_time", paramString2);
    paramContext.putString("dynamic_splash_config_zip_url", paramString3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, Boolean paramBoolean, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("scribble_red_switch_conf_" + paramString, paramBoolean.booleanValue());
    paramContext.commit();
  }
  
  public static void a(Context paramContext, Float paramFloat, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putFloat("scribble_red_version_conf_" + paramString, paramFloat.floatValue());
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "qim_user_special_config_version", paramInt1);
    paramContext.putInt(paramString1 + "_" + "qim_user_special_config_avatar_switch", paramInt2);
    paramContext.putInt(paramString1 + "_" + "qim_user_special_config_title_bg_switch", paramInt3);
    paramContext.putInt(paramString1 + "_" + "qim_user_special_config_bubble_switch", paramInt4);
    paramContext.putString(paramString1 + "_" + "qim_user_special_config_resources_url", paramString2);
    paramContext.putString(paramString1 + "_" + "qim_user_special_config_resources_md5", paramString3);
    paramContext.putString(paramString1 + "_" + "qim_user_special_config_qim_website", paramString4);
    paramContext.putString(paramString1 + "_" + "qim_user_special_config_online_wording", paramString5);
    paramContext.putBoolean("qim_user_special_need_force_download", paramBoolean);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Object paramObject)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "push_recommend_shield_config", Integer.valueOf(paramInt) });
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.i("QQStoryFeedManager", 2, String.format(Locale.getDefault(), "updatePushRecommendShield [uin: %s, type: %d, value: %s, key: %s ret: %s]", new Object[] { paramString, Integer.valueOf(paramInt), paramObject, str, Boolean.valueOf(bool) }));
      }
      return;
      if (!(paramObject instanceof Integer)) {
        break;
      }
      paramContext.edit().putInt(str, ((Integer)paramObject).intValue()).apply();
      bool = true;
      continue;
      if (!(paramObject instanceof String)) {
        break;
      }
      paramContext.edit().putString(str, (String)paramObject).apply();
      bool = true;
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    paramContext.putInt(paramString1 + "_" + "aio_poke_entry_type", paramInt1);
    paramContext.putInt(paramString1 + "_" + "aio_pe_view_type", paramInt5);
    paramContext.putString(paramString1 + "_" + "poke_emo_res_url", paramString2);
    paramContext.putString(paramString1 + "_" + "poke_emo_res_md5", paramString3);
    paramContext.putString(paramString1 + "_" + "poke_emo_surprice_indexs", paramString4);
    paramContext.putString(paramString1 + "_" + "poke_emo_order", paramString5);
    paramContext.putInt(paramString1 + "_" + "aio_pe_input_switch", paramInt2);
    paramContext.putInt(paramString1 + "_" + "aio_pe_feed_back_switch", paramInt3);
    paramContext.putInt(paramString1 + "_" + "aio_pe_bubble_limit_count", paramInt4);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_bar_config_version", paramInt1);
    if (paramBoolean)
    {
      paramContext.putInt(paramString + "_" + "poke_bar_switch", paramInt2);
      paramContext.putInt(paramString + "_" + "poke_pad_switch", paramInt3);
      paramContext.putInt(paramString + "_" + "aio_poke_unitcount", paramInt4);
      paramContext.putInt(paramString + "_" + "aio_poke_unittime", paramInt5);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "redbag_fold_msg_config_version", paramInt1);
    paramContext.putBoolean(paramString + "_" + "redbag_fold_msg_switch", paramBoolean1);
    paramContext.putInt(paramString + "_" + "redbag_fold_msg_num", paramInt2);
    paramContext.putBoolean(paramString + "_" + "redbag_fold_index_switch", paramBoolean2);
    paramContext.putBoolean(paramString + "_" + "redbag_fold_index_with_redbagid", paramBoolean3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3, Object paramObject)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    for (;;)
    {
      try
      {
        paramString1 = paramString3 + paramString2;
        if ((paramObject.getClass() == Integer.TYPE) || (paramObject.getClass() == Integer.class))
        {
          paramContext.putInt(paramString1, ((Integer)paramObject).intValue());
          if (!paramBoolean) {
            break;
          }
          paramContext.apply();
          return;
        }
        if (paramObject.getClass() == String.class)
        {
          paramContext.putString(paramString1, (String)paramObject);
          continue;
        }
        if (paramObject.getClass() == Boolean.TYPE) {
          break label144;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("QQStoryFeedManager", 1, paramContext, new Object[0]);
        return;
      }
      if (paramObject.getClass() == Boolean.class) {
        label144:
        paramContext.putBoolean(paramString1, ((Boolean)paramObject).booleanValue());
      } else if ((paramObject.getClass() == Float.TYPE) || (paramObject.getClass() == Float.class)) {
        paramContext.putFloat(paramString1, ((Float)paramObject).floatValue());
      } else if ((paramObject.getClass() == Long.TYPE) || (paramObject.getClass() == Long.class)) {
        paramContext.putLong(paramString1, ((Long)paramObject).longValue());
      }
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "game_invite", paramBoolean);
    paramContext.putLong(paramString + "_" + "game_invite_time", paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = PreferenceManager.getDefaultSharedPreferencesName(paramContext);; str = paramContext.getPackageName() + "_preferences")
    {
      a(paramContext, str, paramString1, paramBoolean, paramString2, paramObject);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString1 + "_" + "hot_friend_days_contact", paramBoolean1);
    paramContext.putBoolean(paramString1 + "_" + "hot_friend_days_chat", paramBoolean2);
    paramContext.putString("show_hot_friend_days_setting", paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("wifi_connect_switch_file_" + paramString, paramBoolean1);
    paramContext.putBoolean("wifi_connect_switch_security_" + paramString, paramBoolean2);
    paramContext.putBoolean("wifi_connect_switch_pdv_" + paramString, paramBoolean3);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "updateLocationBgReport: invoked. ", " isReporting = [" + paramBoolean + "], aliveSecond = [" + paramInt + "]" });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("key_location_is_reporting", paramBoolean);
    paramContext.putInt("key_alive_second", paramInt);
    paramContext.apply();
  }
  
  public static void a(String paramString, Context paramContext, long paramLong)
  {
    paramString = paramString + "&" + "key_ignore_battery_optimize_last_show_time";
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.apply();
  }
  
  public static int aA(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("hot_friend_new_boat_config_" + paramString, 0);
  }
  
  public static void aA(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("capture_ptv_template_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void aA(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("zhitu_config_page_len_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean aA(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_recommend_switch_" + paramString, false);
  }
  
  public static int aB(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("add_contacts_view_config_version_" + paramString, 0);
  }
  
  public static void aB(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ptv_template_web_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void aB(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("zhitu_safegate_request_interval_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean aB(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "troop_gift_to_all_tab", true);
  }
  
  public static int aC(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("classic_head_activity_config_version_" + paramString, 0);
  }
  
  public static void aC(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("doodle_template_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void aC(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "native_monitor_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static boolean aC(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("scribble_switch_conf_" + paramString, false);
  }
  
  public static int aD(Context paramContext, String paramString)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "aio_post_tab_plugin", 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.aio_post_list_plugin", 2, "getHotChatAIOPluginFlag,re:" + i);
    }
    return i;
  }
  
  public static void aD(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ptv_bless_special_pendant_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void aD(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "rich_text_chat_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static boolean aD(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("scribble_red_switch_conf_" + paramString, false);
  }
  
  public static int aE(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("medal_config_" + paramString, 0);
  }
  
  public static void aE(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("apollo_switch", paramInt);
    paramContext.commit();
  }
  
  public static void aE(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "rich_text_last_tab", paramInt);
    paramContext.commit();
  }
  
  public static boolean aE(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("scribble_plus_red_switch_conf_" + paramString, false);
  }
  
  public static int aF(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "shortvideo_dynamic_adjustment", 0);
  }
  
  public static void aF(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("apollo_3d_switch", paramInt);
    paramContext.commit();
  }
  
  public static void aF(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("docs_structing_msg_gray_tips_remain_count_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean aF(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "troop_effect_pic_guide", false);
  }
  
  public static boolean aFb()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 0).getBoolean("qq_filter_flag", false);
  }
  
  public static boolean aFc()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 0).getBoolean("av_pendant_flag", false);
  }
  
  public static int aG(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "show", 0);
  }
  
  public static void aG(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("camera_compatible_list_version", paramInt);
    paramContext.commit();
  }
  
  public static void aG(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("docs_structing_msg_gray_tips_group_showed_count_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean aG(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("zhitu_config_switch_" + paramString, false);
  }
  
  public static int aH(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "quick_shot_share_to_story_config_version", 0);
  }
  
  public static void aH(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("shortvideo_progressive_blacklist_version", paramInt);
    paramContext.commit();
  }
  
  public static void aH(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setUpgradeAppid: invoked. ", " id: ", Integer.valueOf(paramInt), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("upgrade_appid_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean aH(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("conversation_unfollow_public_acc_switch_" + paramString, false);
  }
  
  public static int aI(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "msg_box_inter_follow_unread_count", 0);
  }
  
  public static void aI(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_folder_setting_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void aI(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setDownloadDialogShownTimes: invoked. ", " times: ", Integer.valueOf(paramInt), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("download_dialog_shown_times_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean aI(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 4).getBoolean(paramString + "readinjoy_takevideo_guide", false);
  }
  
  public static int aJ(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("troop_gift_url_config_version_" + paramString, 0);
  }
  
  public static void aJ(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_folder_config_id", paramInt);
    paramContext.commit();
  }
  
  public static void aJ(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setInstallDialogShownTimes: invoked. ", " times: ", Integer.valueOf(paramInt), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("install_dialog_shown_times_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean aJ(Context paramContext, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean(paramString + "_readinjoy_skin_volume", false);
  }
  
  public static int aK(Context paramContext, String paramString)
  {
    return getInt("device_manage_switch_version");
  }
  
  public static void aK(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("scribble_config_ver", paramInt);
    paramContext.commit();
  }
  
  public static void aK(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qqstory_question_tab_version_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean aK(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("zhitu_setting_switch_" + paramString, true);
  }
  
  public static int aL(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("troop_pobing_config_version_" + paramString, 0);
  }
  
  public static void aL(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("unite_search_trigger_number", paramInt);
    paramContext.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.setUniteSearchTriggerNum", 2, "setUniteSearchTriggerNum:" + paramInt);
    }
  }
  
  public static void aL(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "mini_app_weiyun_entry_version", paramInt);
    paramContext.commit();
  }
  
  public static boolean aL(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("zhitu_config_save_share_switch_" + paramString, false);
  }
  
  public static int aM(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_pre_down_yyb_ver_" + paramString, 0);
  }
  
  public static void aM(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("unify_search_unite_trigger_number", paramInt);
    paramContext.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.setUnifySearchUniteTriggerNum", 2, "setUnifySearchUniteTriggerNum:" + paramInt);
    }
  }
  
  public static void aM(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt("key_notification_push_gray_tips_today_count_" + paramString, paramInt).apply();
  }
  
  public static boolean aM(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("zhitu_safegate_switch_" + paramString, false);
  }
  
  public static int aN(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("AvWeakNet_video_version_code", 0);
  }
  
  public static int aN(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("buluo_red_dot_config_version_" + paramString, 0);
  }
  
  public static void aN(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("native_monitor_config_version_so_hook", paramInt);
    paramContext.apply();
  }
  
  public static void aN(Context paramContext, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + "sp_aio_config", 0).edit();
    paramContext.putInt(paramString + "_" + "aio_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void aN(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager818searchProto_old", 2, "updateSearchDiscoveryLocalDataTime. ");
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("search_discovery_sp_prefixlast_update_time" + paramString + "_" + paramInt1, System.currentTimeMillis()).putLong("search_discovery_sp_prefixexpire_time" + paramString + "_" + paramInt1, paramInt2 * 1000).commit();
  }
  
  public static boolean aN(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if (QQAppInterface.class.isInstance(paramContext)) {}
    for (paramContext = ((QQAppInterface)paramContext).getCurrentUin();; paramContext = "") {
      return localSharedPreferences.getBoolean(paramString + "_" + "qim_video_combol_lock_info" + "_" + paramContext, true);
    }
  }
  
  public static int aO(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("eqq_config_version_code", 0);
  }
  
  public static int aO(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qqhead_history_numflag", -1);
  }
  
  public static void aO(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qqstory_follow_capture_version", paramInt);
    paramContext.apply();
  }
  
  public static void aO(Context paramContext, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + "sp_aio_config", 0).edit();
    paramContext.putInt(paramString + "_" + "multimsg_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void aO(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager818searchProto_new", 2, "updateUnifyDiscoveryLocalDataTime. ");
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("search_discovery_sp_prefix_unifylast_update_time" + paramString + "_" + paramInt1, System.currentTimeMillis()).putLong("search_discovery_sp_prefix_unifyexpire_time" + paramString + "_" + paramInt1, paramInt2 * 1000).commit();
  }
  
  public static boolean aO(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "rich_text_first_time_tab_showed", false);
  }
  
  public static int aP(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("splash_version_code", 0);
  }
  
  public static int aP(Context paramContext, String paramString)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("contact_recommend_tab_config_version_" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 1, "getContactRecommendTabConfigVersion version:" + i);
    }
    return i;
  }
  
  public static void aP(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("mini_app_entry_auto_show", paramInt);
    paramContext.apply();
  }
  
  public static boolean aP(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("rich_text_chat_config_settting_switch_" + paramString, true);
  }
  
  public static int aQ(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("nearby_chat_gray_tips_config_version", 0);
  }
  
  public static int aQ(Context paramContext, String paramString)
  {
    int i = j(paramString).getInt("boundaryFriendsCount", 5);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 1, "getContactRecommendTabBoundaryFriendsCount count:" + i);
    }
    return i;
  }
  
  public static void aQ(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("BatteryCapacity", paramInt);
    paramContext.apply();
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "updateBatteryCapacity", Integer.valueOf(paramInt) });
    }
  }
  
  public static boolean aQ(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("docs_export_file_is_first_" + paramString, true);
  }
  
  public static int aR(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("troop_rank_map_config_version", 0);
  }
  
  public static int aR(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doutu_config_version_" + paramString, 0);
  }
  
  public static void aR(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("PowerConnectStatus", paramInt);
    paramContext.apply();
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "updatePowerConnectStatus", Integer.valueOf(paramInt) });
    }
  }
  
  public static boolean aR(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("has_show_profile_nick_reddot" + paramString, false);
  }
  
  public static int aS(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ptv_template_cfg_version", 0);
  }
  
  public static int aS(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("cu_open_card_guide_config_appid_" + paramString, 0);
  }
  
  public static boolean aS(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("emotion_rec_setting_switch_" + paramString, true);
  }
  
  public static int aT(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("capture_ptv_template_cfg_version", 0);
  }
  
  public static int aT(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("cu_open_card_guide_" + paramString, 0);
  }
  
  public static boolean aT(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("record_delete_roaming_setting_switch_" + paramString, false);
  }
  
  public static int aU(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ptv_template_web_cfg_version", 0);
  }
  
  public static int aU(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "doutu_config_appid", 0);
  }
  
  public static boolean aU(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("emotion_edit_guide_pop_switch_" + paramString, true);
  }
  
  public static int aV(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doodle_template_cfg_version", 0);
  }
  
  public static int aV(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doutu_smart_default_count_" + paramString, 0);
  }
  
  public static boolean aV(Context paramContext, String paramString)
  {
    paramString = "key_cloud_file_guide_banner&" + paramString + "&AutoSaveGuideOpen";
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, true);
  }
  
  public static int aW(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doodle_template_cfg_version", 0);
  }
  
  public static int aW(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("video_redbag_config_version_" + paramString, 0);
  }
  
  public static boolean aW(Context paramContext, String paramString)
  {
    paramString = "key_cloud_file_guide_banner&" + paramString + "&AutoSaveGuideClose";
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, true);
  }
  
  public static int aX(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ptv_bless_special_pendant_cfg_version", 0);
  }
  
  public static int aX(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "troop_robot_panel_version", 0);
  }
  
  public static boolean aX(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("key_tam_work_doc_add_copy_success_first_time" + paramString, true);
  }
  
  public static int aY(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("public_account_config_version", 0);
  }
  
  public static int aY(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doutu_config_duitimes_" + paramString, 0);
  }
  
  public static int aZ(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("videodown_ct_whitelist_version", 0);
  }
  
  public static int aZ(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("app_guide_tips_config_version_" + paramString, 0);
  }
  
  public static int aa(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "nearby_flower_gray_tips_config_version", 0);
  }
  
  public static String aa(Context paramContext, String paramString)
  {
    return getString("device_manage_switch");
  }
  
  public static void aa(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "aio_post_tab_plugin", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.aio_post_list_plugin", 2, "updateHotChatAIOPluginFlag,re:" + paramInt);
    }
    paramContext.commit();
  }
  
  public static void aa(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = j(paramString1).edit();
    paramString1 = "contact_recommend_tab_config_json_" + paramString1;
    if (paramString2 == null) {
      paramContext = "";
    }
    for (;;)
    {
      localEditor.putString(paramString1, paramContext);
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramContext = new JSONObject(paramString2);
          if (paramContext.has("boundaryFriendsCount")) {
            localEditor.putInt("boundaryFriendsCount", paramContext.optInt("boundaryFriendsCount"));
          }
        }
        localEditor.commit();
        return;
        paramContext = paramString2;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          QLog.e("QQStoryFeedManager", 1, "updateContactRecommendTabConfigJson error:" + paramContext.getMessage());
        }
      }
    }
  }
  
  public static int ab(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "nearby_hotchat_v_list_config_version", 0);
  }
  
  public static void ab(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "show", paramInt);
    paramContext.commit();
  }
  
  public static int ac(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "green_video_appid", 0);
  }
  
  public static String ac(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("qq_pre_down_yyb", 0).getString(paramString, "");
  }
  
  public static void ac(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (paramInt == -1) {
      paramContext.remove(paramString + "_" + "quick_shot_share_to_story_config_version");
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putInt(paramString + "_" + "quick_shot_share_to_story_config_version", paramInt);
    }
  }
  
  public static void ac(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("doutu_res_url_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static boolean ac(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean(paramString, false);
    QLog.i("getSwitch", 2, "getting switch " + bool);
    return bool;
  }
  
  public static int ad(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("green_video_config_version_" + paramString, 0);
  }
  
  public static String ad(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("doutu_res_url_" + paramString, "");
  }
  
  public static void ad(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "msg_box_inter_follow_unread_count", paramInt);
    paramContext.commit();
  }
  
  public static void ad(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("doutu_res_md5_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static int ae(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "video_compress_config_appid", 0);
  }
  
  public static int ae(String paramString1, String paramString2)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "_" + "sp_aio_config", 0).getInt(paramString2, 0);
  }
  
  public static String ae(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("doutu_res_md5_" + paramString, "");
  }
  
  public static void ae(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, false, "device_manage_switch_version", Integer.valueOf(paramInt));
  }
  
  public static void ae(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("video_compress_config_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static int af(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("video_compress_config_version_" + paramString, 0);
  }
  
  public static String af(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("video_redbag_res_md5_" + paramString, "");
  }
  
  public static void af(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("troop_pobing_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void af(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString1 + "_isClickEnterEffectGrayTipsEntrance_" + paramString2, true);
    paramContext.commit();
  }
  
  public static int[] af()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4);
    return new int[] { localSharedPreferences.getInt("filter_download", 0), localSharedPreferences.getInt("filter_total", 0) };
  }
  
  public static int ag(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "search_config_version", 0);
  }
  
  public static String ag(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("video_redbag_res_url_" + paramString, "");
  }
  
  public static void ag(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("troop_gift_url_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void ag(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    if (paramString2 == null) {
      paramContext.remove(paramString1 + "_readinjoy_skin");
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString1 + "_readinjoy_skin", paramString2);
    }
  }
  
  public static void ag(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("key_cloud_file_show_default_add_tips", paramBoolean).commit();
  }
  
  public static int[] ag()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4);
    return new int[] { localSharedPreferences.getInt("av_pendant_download", 0), localSharedPreferences.getInt("av_pendant_total", 0) };
  }
  
  public static int ah(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "search_config_appid", 0);
  }
  
  public static String ah(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("video_compress_config_" + paramString, "");
  }
  
  public static void ah(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_pre_down_yyb_ver_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void ah(Context paramContext, String paramString1, String paramString2)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString1 + "_readinjoy_skin_guide_" + paramString2, true).commit();
  }
  
  public static void ah(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("key_cloud_file_first_guide_add", paramBoolean).commit();
  }
  
  public static int ai(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "poke_config_appid", 0);
  }
  
  public static String ai(Context paramContext, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getString(paramString + "_readinjoy_skin", null);
  }
  
  public static void ai(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("buluo_red_dot_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void ai(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("limit_chat_bg_pic_md5_", paramString2);
    paramContext.apply();
  }
  
  public static int aj(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pa_subcribe_config_version", 0);
  }
  
  public static String aj(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "story_halo_config_json", "");
  }
  
  public static void aj(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qqhead_history_numflag", paramInt);
    paramContext.commit();
  }
  
  public static void aj(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString2 + "_" + "weiyun_mini_app_apkg_url", paramString1);
    paramContext.apply();
  }
  
  public static int ak(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "subscript_recommend_config_version" + "_" + "3.4.4.3058", 0);
  }
  
  public static String ak(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("classic_head_activity_config_" + paramString, "");
  }
  
  public static void ak(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("contact_recommend_tab_config_version_" + paramString, paramInt);
    paramContext.commit();
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 1, "updateContactRecommendTabConfigVersion version:" + paramInt);
    }
  }
  
  public static int al(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "redbag_fold_msg_config_version", 0);
  }
  
  public static String al(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("limit_chat_bg_pic_md5_", null);
  }
  
  public static void al(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt("cu_open_card_guide_config_appid_" + paramString, paramInt).apply();
  }
  
  public static int am(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "poke_bar_config_version", 0);
  }
  
  public static String am(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "weiyun_mini_app_apkg_url", "");
  }
  
  public static void am(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("cu_open_card_guide_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static int an(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "heads_up_notify_version", 0);
  }
  
  public static void an(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("doutu_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void ano()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).edit();
    localEditor.putLong("av_pendant_spacing", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static int ao(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "readinjoy_local_channel_config_version", 0);
  }
  
  public static void ao(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "doutu_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static boolean ao(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("translate_bubble_first_time", true);
  }
  
  public static int ap(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qwallet_setting_version", 0);
  }
  
  public static void ap(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("doutu_smart_default_count_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static boolean ap(Context paramContext, String paramString)
  {
    paramString = "config_app_version_" + paramString;
    return !TextUtils.equals(PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, ""), "3.4.4");
  }
  
  public static boolean ap(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager818searchProto_old", 2, "isSearchDiscoveryLocalDataExpired. ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    long l1 = localSharedPreferences.getLong("search_discovery_sp_prefixlast_update_time" + paramString + "_" + paramInt, 0L);
    long l2 = localSharedPreferences.getLong("search_discovery_sp_prefixexpire_time" + paramString + "_" + paramInt, 0L);
    return System.currentTimeMillis() - l1 >= l2;
  }
  
  public static int aq(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "passwd_red_bag_setting_version", 0);
  }
  
  public static void aq(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "troop_robot_panel_version", paramInt);
    paramContext.commit();
  }
  
  public static boolean aq(Context paramContext, String paramString)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "hot_friendship_support_key", 0);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, "isSupportFriendshipReactive code: " + i);
    }
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean aq(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager818searchProto_new", 2, "isUnifyDiscoveryLocalDataExpired. ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    long l1 = localSharedPreferences.getLong("search_discovery_sp_prefix_unifylast_update_time" + paramString + "_" + paramInt, 0L);
    long l2 = localSharedPreferences.getLong("search_discovery_sp_prefix_unifyexpire_time" + paramString + "_" + paramInt, 0L);
    return System.currentTimeMillis() - l1 >= l2;
  }
  
  public static int ar(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("pre_download_dialog_version" + paramString, 0);
  }
  
  public static void ar(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("doutu_config_duitimes_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static boolean ar(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "auto_agree_join_troop", false);
  }
  
  public static int as(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("upgrade_tim_version" + paramString, 0);
  }
  
  public static void as(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("app_guide_tips_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static boolean as(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    boolean bool2 = paramContext.getBoolean(paramString + "_" + "local_set_top_troop_uploaded", false);
    int i = paramContext.getInt(paramString + "_" + "local_set_top_troop_uploaded_repeat_count", 0);
    paramContext.edit().putInt(paramString + "_" + "local_set_top_troop_uploaded_repeat_count", i + 1).commit();
    if ((bool2) || (i >= 5)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static int at(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("photo_plus_sticker_version" + paramString, 0);
  }
  
  public static void at(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "troop_aio_keyword_version", paramInt);
    paramContext.apply();
  }
  
  public static boolean at(Context paramContext, String paramString)
  {
    return getBoolean("device_manage_has_show");
  }
  
  public static int au(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "readinjoy_folder_config_version", 0);
  }
  
  public static void au(Context paramContext, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + "sp_aio_config", 0).edit();
    paramContext.putInt(paramString + "_" + "receipt_config_version", paramInt);
    paramContext.commit();
  }
  
  public static boolean au(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "is_show_buluo_red_num_red_dot", false);
  }
  
  public static int av(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_merge_config_version_" + paramString, 0);
  }
  
  public static void av(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("AvWeakNet_video_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void av(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qim_user_special_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static boolean av(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    boolean bool3 = paramContext.getBoolean(paramString + "_" + "game_invite", false);
    long l = paramContext.getLong(paramString + "_" + "game_invite_time", 0L);
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - l < 3600000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int aw(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_crop_and_group_version_3058_" + paramString, 0);
  }
  
  public static void aw(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("eqq_config_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void aw(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "tim_user_special_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static boolean aw(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "game_room", false);
  }
  
  public static int ax(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_remote_reset_config_version_3058_" + paramString, 0);
  }
  
  public static void ax(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("nearby_chat_gray_tips_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void ax(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("zhitu_config_version_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean ax(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_config_switch_" + paramString, false);
  }
  
  public static int ay(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "long_text_msg_config_version", 0);
  }
  
  public static void ay(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("troop_rank_map_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void ay(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("conversation_unfollow_public_acc_version_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static boolean ay(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_setting_switch_" + paramString, true);
  }
  
  public static int az(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("hot_friend_chat_config_" + paramString, 0);
  }
  
  public static void az(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ptv_template_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void az(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt(paramString + "_readinjoy_ad_material_is_preview", paramInt).apply();
  }
  
  public static boolean az(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_combo_config_switch_" + paramString, false);
  }
  
  public static Float b(Context paramContext, String paramString)
  {
    return Float.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getFloat("scribble_plus_red_version_conf_" + paramString, 0.0F));
  }
  
  public static <T> T b(Context paramContext, String paramString1, String paramString2, T paramT)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = PreferenceManager.getDefaultSharedPreferencesName(paramContext);; str = paramContext.getPackageName() + "_preferences") {
      return a(paramContext, str, paramString1, paramString2, paramT);
    }
  }
  
  public static void b(Context paramContext, Float paramFloat, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putFloat("scribble_plus_red_version_conf_" + paramString, paramFloat.floatValue());
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_bar_config_version", paramInt1);
    paramContext.putInt(paramString + "_" + "aio_unique_poke_show", paramInt2);
    paramContext.putInt(paramString + "_" + "aio_unique_poke_type", paramInt3);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "tim_user_special_config_version", paramInt1);
    paramContext.putInt(paramString1 + "_" + "tim_user_special_config_avatar_switch", paramInt2);
    paramContext.putInt(paramString1 + "_" + "tim_user_special_config_title_bg_switch", paramInt3);
    paramContext.putInt(paramString1 + "_" + "tim_user_special_config_bubble_switch", paramInt4);
    paramContext.putString(paramString1 + "_" + "tim_user_special_config_resources_url", paramString2);
    paramContext.putString(paramString1 + "_" + "tim_user_special_config_resources_md5", paramString3);
    paramContext.putString(paramString1 + "_" + "tim_user_special_config_tim_website", paramString4);
    paramContext.putString(paramString1 + "_" + "tim_user_special_config_online_wording", paramString5);
    paramContext.putBoolean("tim_user_special_need_force_download", paramBoolean);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong(paramString1 + "_" + "aio_poke_strength_rule_interval", paramLong);
    paramContext.putString(paramString1 + "_" + "aio_poke_res_url", paramString2);
    paramContext.putString(paramString1 + "_" + "aio_poke_res_md5", paramString3);
    paramContext.commit();
  }
  
  @TargetApi(9)
  public static void b(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT > 8)
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
  
  public static boolean b(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramContext == null)) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 4); paramInt > paramContext.getInt(paramString2, 0); paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 0)) {
      return true;
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString1, paramBoolean);
  }
  
  public static int bA(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "mini_app_weiyun_entry_version", 0);
  }
  
  public static int bB(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "weiyun_mini_app_gray_enable", 0);
  }
  
  public static int bC(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "weiyun_mini_app_version", 23);
  }
  
  public static int bD(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("sso_list", 4).getInt(paramString + "_sso_list_version", 0);
  }
  
  public static int bE(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("sso_list", 4).getInt(paramString + "_sso_list_appid", 0);
  }
  
  public static int bF(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("key_notification_push_gray_tips_today_count_" + paramString, 0);
  }
  
  public static int bG(Context paramContext, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + "sp_aio_config", 0).getInt(paramString + "_" + "aio_config_version", 0);
  }
  
  public static int bH(Context paramContext, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + "sp_aio_config", 0).getInt(paramString + "_" + "multimsg_config_version", 0);
  }
  
  public static boolean bY(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("kandian_read_data", true);
  }
  
  public static boolean bZ(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_res_damaged", false);
  }
  
  public static int ba(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("mix_msg_forward_config_version", 0);
  }
  
  public static int ba(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("scribble_red_switch_config_ver_" + paramString, 0);
  }
  
  public static int bb(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("apollo_switch", 0);
  }
  
  public static int bb(Context paramContext, String paramString)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "troop_aio_keyword_version", 0);
    if (QLog.isColorLevel()) {
      QLog.i("SharedPreUtils", 2, "getTroopAioKeyWordVersion, version=" + i);
    }
    return i;
  }
  
  public static int bc(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("apollo_3d_switch", 0);
  }
  
  public static int bc(Context paramContext, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + "sp_aio_config", 0).getInt(paramString + "_" + "receipt_config_version", 0);
  }
  
  public static long bc(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong(paramString + "_" + "clean_disk_cache_time", 0L);
  }
  
  public static int bd(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("hotchat_scene_config_version", 0);
  }
  
  public static int bd(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qim_user_special_config_version", 0);
  }
  
  public static long bd(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong(paramString, 0L);
  }
  
  public static int be(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("camera_compatible_list_version", 0);
  }
  
  public static int be(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qim_user_special_config_appid", 0);
  }
  
  public static long be(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getLong("last_close_noti_guid_banner_ts_" + paramString, -1L);
  }
  
  public static int bf(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("dynamic_splash_config_version", 0);
  }
  
  public static int bf(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "tim_user_special_config_version", 0);
  }
  
  public static long bf(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong("schedule_repeat_last_update_time_" + paramString, 0L);
  }
  
  public static int bg(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("shortvideo_progressive_blacklist_version", 0);
  }
  
  public static int bg(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "tim_user_special_config_appid", 0);
  }
  
  public static long bg(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong("schedule_unrepeat_last_update_time_" + paramString, 0L);
  }
  
  public static int bh(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qqhotspot_config_version", 0);
  }
  
  public static int bh(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("zhitu_config_version_" + paramString, 0);
  }
  
  public static int bi(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_folder_setting_config_version", 0);
  }
  
  public static int bi(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("conversation_unfollow_public_acc_version_" + paramString, 0);
  }
  
  public static int bj(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_folder_config_id", 0);
  }
  
  public static int bj(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_readinjoy_ad_material_is_preview", 0);
  }
  
  public static String bj(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("last_loginuin_for_birthday_uin", "");
  }
  
  public static int bk(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("scribble_config_ver", 0);
  }
  
  public static int bk(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("zhitu_config_page_len_" + paramString, 8);
  }
  
  public static String bk(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("birthday_user", "");
  }
  
  public static int bl(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_predownload_cfg_version", 0);
  }
  
  public static int bl(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("zhitu_safegate_request_interval_" + paramString, 0);
  }
  
  public static String bl(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("eqq-config-data", null);
  }
  
  public static int bm(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_music_cfg_version", 0);
  }
  
  public static int bm(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "aio_story_feed_config_version", 0);
  }
  
  public static String bm(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("green_video_list", "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24");
  }
  
  public static int bn(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_sticker_cfg_version", 0);
  }
  
  public static int bn(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "story_halo_config_version", 0);
  }
  
  public static String bn(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("public_account_config_data", null);
  }
  
  public static void bn(String paramString, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong(paramString, paramLong).commit();
  }
  
  public static int bo(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_faceu_cfg_version", 0);
  }
  
  public static int bo(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "native_monitor_config_version", 0);
  }
  
  public static String bo(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("videodown_ct_whitelist", null);
  }
  
  public static void bo(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("last_close_noti_guid_banner_ts_" + paramString, paramLong).apply();
  }
  
  public static int bp(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qqstory_follow_capture_version", 0);
  }
  
  public static int bp(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "native_monitor_config_appid", 0);
  }
  
  public static String bp(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("mix_msg_forward_config", null);
  }
  
  public static void bp(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putLong("schedule_repeat_last_update_time_" + paramString, paramLong);
    localEditor.commit();
  }
  
  public static int bq(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("mini_app_entry_auto_show", 0);
  }
  
  public static int bq(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("classic_head_activity_config_version_" + paramString, 0);
  }
  
  public static String bq(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("readinjoy_folder_nickname", "");
  }
  
  public static void bq(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putLong("schedule_unrepeat_last_update_time_" + paramString, paramLong);
    localEditor.commit();
  }
  
  public static int br(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("key_alive_second", 0);
  }
  
  public static int br(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "rich_text_chat_config_version", 0);
  }
  
  public static String br(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("readinjoy_folder_icon_url", "");
  }
  
  public static int bs(Context paramContext)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("BatteryCapacity", 0);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getBatteryCapacity", Integer.valueOf(i) });
    }
    return i;
  }
  
  public static int bs(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "rich_text_chat_config_appid", 0);
  }
  
  public static String bs(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("show_hot_friend_days_setting", "3|30|3|30|3|30|3|30|5|7|30|7|30");
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, "result=" + paramContext);
    }
    return paramContext;
  }
  
  public static int bt(Context paramContext)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("PowerConnectStatus", -1);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getPowerConnectStatus", Integer.valueOf(i) });
    }
    return i;
  }
  
  public static int bt(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "rich_text_last_tab", -1);
  }
  
  public static String bt(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0) {
      return paramContext.getSharedPreferences("nearby_glamour", i).getString("nearby_glamour_level_config_info", null);
    }
  }
  
  public static int bu(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("docs_structing_msg_gray_tips_remain_count_" + paramString, 0);
  }
  
  public static String bu(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_gif_ver", "");
  }
  
  public static int bv(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("docs_structing_msg_gray_tips_group_showed_count_" + paramString, 0);
  }
  
  public static String bv(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_paint_ver", "");
  }
  
  public static int bw(Context paramContext, String paramString)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("upgrade_appid_" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getUpgradeAppid: invoked. ", " appid: ", Integer.valueOf(i), " uin: ", paramString });
    }
    return i;
  }
  
  public static String bw(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_gif_config_content", null);
  }
  
  public static int bx(Context paramContext, String paramString)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("download_dialog_shown_times_" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getDownloadDialogShownTimes: invoked. ", " times: ", Integer.valueOf(i), " uin: ", paramString });
    }
    return i;
  }
  
  public static String bx(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_paint_config_content", null);
  }
  
  public static int by(Context paramContext, String paramString)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("install_dialog_shown_times_" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getInstallDialogShownTimes: invoked. ", " times: ", Integer.valueOf(i), " uin: ", paramString });
    }
    return i;
  }
  
  public static String by(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("docs_import_web_url", "");
  }
  
  public static int bz(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qqstory_question_tab_version_" + paramString, 0);
  }
  
  public static SharedPreferences c(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("color_note_" + paramString, 4);
  }
  
  public static void c(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("splash_version_code", paramInt);
    paramContext.putString("splash_effectivetime", paramString1);
    paramContext.putString("splash_md5value", paramString2);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString + "_" + "nearby_config_info", paramJSONObject.toString());
    paramContext.commit();
  }
  
  public static boolean c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getBoolean(paramContext, paramBoolean);
  }
  
  public static void cA(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_recommend_switch_" + paramString);
    paramContext.commit();
  }
  
  public static void cB(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_smart_default_count_" + paramString);
    paramContext.commit();
  }
  
  public static void cC(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_res_url_" + paramString);
    paramContext.commit();
  }
  
  public static void cD(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_res_md5_" + paramString);
    paramContext.commit();
  }
  
  public static void cE(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("video_compress_config_" + paramString);
    paramContext.commit();
  }
  
  public static void cF(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_config_duration_" + paramString);
    paramContext.commit();
  }
  
  public static void cG(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_config_duitimes_" + paramString);
    paramContext.commit();
  }
  
  public static void cH(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_config_combo_duration_" + paramString);
    paramContext.commit();
  }
  
  public static void cI(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_config_combo_keep_" + paramString);
    paramContext.commit();
  }
  
  public static void cJ(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_gif_ver", paramString);
    paramContext.commit();
  }
  
  public static void cK(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_paint_ver", paramString);
    paramContext.commit();
  }
  
  public static void cL(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_gif_config_content", paramString);
    paramContext.commit();
  }
  
  public static void cM(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_paint_config_content", paramString);
    paramContext.commit();
  }
  
  public static void cN(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "troop_effect_pic_guide", true);
    paramContext.commit();
  }
  
  public static void cO(Context paramContext, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString + "_readinjoy_diandian_guide", true).commit();
  }
  
  public static void cP(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 4).edit().putBoolean(paramString + "readinjoy_takevideo_guide", true).commit();
  }
  
  public static void cQ(Context paramContext, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong(paramString + "_readinjoy_skin_guide_time", System.currentTimeMillis()).commit();
  }
  
  public static void cR(Context paramContext, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong(paramString + "_readinjoy_ad_material_req_time", NetConnInfoCenter.getServerTime()).apply();
  }
  
  public static void cS(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("docs_import_web_url", paramString);
    paramContext.apply();
  }
  
  public static boolean ca(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("video_redbag_res_damaged", false);
  }
  
  public static boolean cb(Context paramContext)
  {
    return paramContext.getSharedPreferences("sp_file_huiyin", 0).getBoolean("huiyin_was_used", false);
  }
  
  public static boolean cb(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("key_cloud_file_show_default_add_tips", false);
  }
  
  public static boolean cc(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("key_location_is_reporting", false);
  }
  
  public static boolean cc(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("key_cloud_file_first_guide_add", true);
  }
  
  public static boolean cd(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("key_keep_alive_guide", true);
  }
  
  public static void co(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("last_loginuin_for_birthday_uin", paramString);
    paramContext.commit();
  }
  
  public static void cp(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("birthday_user", paramString);
    paramContext.commit();
  }
  
  public static void cq(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("eqq-config-data", paramString);
    paramContext.commit();
  }
  
  public static void cr(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("translate_bubble_first_time", false);
    paramContext.commit();
  }
  
  public static void cs(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("green_video_list", paramString);
    paramContext.commit();
  }
  
  public static void ct(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("public_account_config_data", paramString);
    paramContext.commit();
  }
  
  public static void cu(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("config_app_version_" + paramString, "3.4.4");
    paramContext.commit();
  }
  
  public static void cv(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      paramContext = paramContext.getSharedPreferences("nearby_glamour", i).edit();
      paramContext.putString("nearby_glamour_level_config_info", paramString);
      paramContext.commit();
      return;
    }
  }
  
  public static void cw(Context paramContext, String paramString) {}
  
  public static void cx(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "local_set_top_troop_uploaded", true);
    paramContext.commit();
  }
  
  public static void cy(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_config_switch_" + paramString);
    paramContext.commit();
  }
  
  public static void cz(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_combo_config_switch_" + paramString);
    paramContext.commit();
  }
  
  public static String d(Context paramContext, String paramString, int paramInt)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getString(paramString + "_readinjoy_refresh_" + paramInt, null);
  }
  
  public static String d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString3);
  }
  
  public static void d(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString2 + "_" + "birthday_splash_version_code", paramInt);
    paramContext.putString("birthday_splash_md5value", paramString1);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramContext == null)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 4).edit();; paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 0).edit())
    {
      paramContext.putInt(paramString2, paramInt);
      paramContext.commit();
      return;
    }
  }
  
  public static void d(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = "key_cloud_file_guide_banner&" + paramString + "&" + paramInt;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "heads_up_notify_version", paramInt);
    if (paramBoolean1) {
      paramContext.putBoolean(paramString + "_" + "heads_up_notify_switch", paramBoolean2);
    }
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString1, paramBoolean);
    paramContext.apply();
  }
  
  public static void d(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("kandian_interest_label_web_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void d(String paramString, Context paramContext, boolean paramBoolean)
  {
    paramString = paramString + "&" + "key_checked_schedule_permission";
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static boolean d(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = false;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    if (paramInt == 0) {
      bool = paramContext.getBoolean(paramString + "_" + "hot_friend_days_contact", false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, "type= " + paramInt + ",result=" + bool);
      }
      return bool;
      if (paramInt == 1) {
        bool = paramContext.getBoolean(paramString + "_" + "hot_friend_days_chat", false);
      }
    }
  }
  
  public static void dT(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putBoolean("hasClicked" + paramInt + paramString, true);
    localEditor.commit();
  }
  
  public static void dU(int paramInt, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putInt(paramString + "_sticker_bubble_last_send_id", paramInt).apply();
  }
  
  public static void dm(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putBoolean(paramString + "_is_has_show_troop_revoke_tip", paramBoolean);
    localEditor.apply();
  }
  
  public static int e(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "medal_strong_reminder_config", Integer.valueOf(paramInt) }), 0);
  }
  
  public static SharedPreferences e(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("aio_jump_lightalk_red_dot" + paramString, 0);
  }
  
  public static void e(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("add_contacts_view_config_version_" + paramString1, paramInt);
    paramContext.putString("add_contacts_view_config_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_bar_config_version", paramInt1);
    paramContext.putInt(paramString + "_" + "aio_poke_touch_effect", paramInt2);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "poke_bar_config_version", paramInt);
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "aio_poke_panel_config", paramString2);
    }
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "long_text_msg_config_version", paramInt);
    paramContext.putBoolean(paramString + "_" + "long_text_msg_switch", paramBoolean1);
    paramContext.putBoolean(paramString + "_msfpull_filter_switch", paramBoolean2);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putBoolean(paramContext, paramBoolean);
    localEditor.commit();
  }
  
  public static void e(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("scribble_switch_conf_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void e(String paramString, Context paramContext, boolean paramBoolean)
  {
    paramString = paramString + "&" + "key_setting_read_system_schedule";
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static boolean e(Context paramContext, String paramString, int paramInt)
  {
    paramString = "key_cloud_file_guide_banner&" + paramString + "&" + paramInt;
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, true);
  }
  
  public static void eeo()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4).edit();
    localEditor.putLong("filter_spacing", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static void eep()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 0).edit();
    localEditor.putBoolean("qq_filter_flag", true);
    localEditor.commit();
  }
  
  public static void eeq()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 0).edit();
    localEditor.putBoolean("av_pendant_flag", true);
    localEditor.commit();
  }
  
  public static int f(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      int i = QzoneConfig.getInstance().getConfig("qqminiapp", paramString, paramInt);
      return i;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQStoryFeedManager", 1, "miniapp getMiniProcessRecycleTime error.", paramContext);
    }
    return paramInt;
  }
  
  public static SharedPreferences f(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qav_upgrade_invite" + paramString, 0);
  }
  
  public static List<String> f(Context paramContext, String paramString)
  {
    if (IR != null) {
      return IR;
    }
    IR = new ArrayList();
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "local_set_top_troop_uploaded_ignore", null);
    if (TextUtils.isEmpty(paramContext)) {
      return IR;
    }
    paramContext = paramContext.split("_");
    if ((paramContext == null) && (paramContext.length == 0)) {
      return IR;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramContext[i];
      if (!TextUtils.isEmpty(paramString)) {
        IR.add(paramString);
      }
      i += 1;
    }
    return IR;
  }
  
  public static void f(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("classic_head_activity_config_version_" + paramString1, paramInt);
    paramContext.putString("classic_head_activity_config_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_bar_config_version", paramInt1);
    paramContext.putInt(paramString + "_" + "aio_poke_combo_time", paramInt2);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "story_halo_config_version", paramInt);
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "story_halo_config_json", paramString2);
    }
    paramContext.apply();
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("has_show_robot_chat_waring_banner" + paramString1 + "_" + paramString2, paramBoolean);
    paramContext.apply();
  }
  
  public static void f(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("scribble_plus_red_switch_conf_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void f(String paramString, Context paramContext, boolean paramBoolean)
  {
    paramString = paramString + "&" + "key_message_notify_guide";
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void fA(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("green_video_list");
    paramContext.commit();
  }
  
  public static void fB(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("sp_file_huiyin", 0).edit();
    paramContext.putBoolean("huiyin_was_used", true);
    paramContext.apply();
  }
  
  public static int fl(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt(paramString, 0);
  }
  
  public static int fm(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt(paramString + "_sticker_bubble_last_send_id", 1);
  }
  
  public static SharedPreferences g(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("AvWeakNet_video_version_code" + paramString, 0);
  }
  
  public static void g(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("classic_head_activity_config_version_" + paramString1, paramInt);
    paramContext.putString("classic_head_activity_config_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int k = 1;
    int j = 0;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    if (!paramBoolean)
    {
      j = paramContext.getInt("hotchat_scene_config_fcount", 0) + 1;
      if (j <= 5) {
        break label82;
      }
    }
    label82:
    for (i = k;; i = 0)
    {
      paramContext = paramContext.edit();
      if (i != 0) {
        paramContext.putInt("hotchat_scene_config_version", paramInt);
      }
      paramContext.putInt("hotchat_scene_config_fcount", j);
      paramContext.commit();
      return;
    }
  }
  
  public static void g(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "now_entrance_action_info" + "_" + paramInt1, paramInt2);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "aio_story_feed_config_version", paramInt);
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "aio_story_feed_config_json", paramString2);
    }
    paramContext.apply();
  }
  
  public static void g(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString2 + "_" + paramString1, paramInt);
    paramContext.commit();
  }
  
  public static Object get(String paramString, Object paramObject)
  {
    return a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString, paramObject);
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null) {
        i = paramContext.versionCode;
      }
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static boolean getBoolean(String paramString)
  {
    return ((Boolean)get(paramString, Boolean.valueOf(false))).booleanValue();
  }
  
  public static int getInt(String paramString)
  {
    return ((Integer)get(paramString, Integer.valueOf(0))).intValue();
  }
  
  public static long getMainProccessThreadMonitorTime()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).getLong("monitorStartTime", 0L);
  }
  
  public static long getMainProccessThreadPeakCounts()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).getLong("peakThreadCount", 0L);
  }
  
  public static String getString(String paramString)
  {
    return (String)get(paramString, "");
  }
  
  public static void go(String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putInt(paramString, paramInt).commit();
  }
  
  public static SharedPreferences h(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qav_anychat_time_limit" + paramString, 0);
  }
  
  public static void h(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramString = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "medal_strong_reminder_config", Integer.valueOf(paramInt1) });
    paramContext.edit().putInt(paramString, paramInt2).apply();
  }
  
  public static void h(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "native_monitor_config_version", paramInt);
    paramContext.putString(paramString1 + "_" + "native_monitor_config_content", paramString2);
    paramContext.commit();
  }
  
  public static void h(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + paramString2 + "_" + "msg_box_delete_msg_tab_flag", paramInt);
    paramContext.commit();
  }
  
  public static long hO()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4).getLong("filter_spacing", 0L);
  }
  
  public static long hP()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).getLong("av_pendant_spacing", 0L);
  }
  
  public static long hQ()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong("X5Update", 0L);
  }
  
  public static int i(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString2 + "_" + paramString1, 0);
  }
  
  public static SharedPreferences i(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qav_score" + paramString, 4);
  }
  
  public static void i(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "rich_text_chat_config_version", paramInt);
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "rich_text_chat_config_content", paramString2);
    }
    paramContext.commit();
  }
  
  public static void i(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_version", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1, paramInt);
    paramContext.apply();
  }
  
  public static void i(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i = 2;
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre auto =" + paramBoolean);
    }
    paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 4).edit().putBoolean("login_auto" + paramString, paramBoolean).commit();
    paramContext = paramContext.getSharedPreferences("sp_login_auto", 4).edit();
    if (paramBoolean) {}
    for (;;)
    {
      paramContext.putInt(paramString, i).commit();
      return;
      i = 1;
    }
  }
  
  public static boolean i(String paramString, Context paramContext)
  {
    paramString = paramString + "&" + "key_checked_schedule_permission";
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, false);
  }
  
  public static int j(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString1 + "_" + paramString2 + "_" + "msg_box_delete_msg_tab_flag", 0);
  }
  
  public static long j(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("upgrade_qq_time" + paramString, 0L);
  }
  
  public static SharedPreferences j(Context paramContext)
  {
    return paramContext.getSharedPreferences("qav_SP", 4);
  }
  
  public static SharedPreferences j(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("contact_recommend_sp" + paramString, 0);
  }
  
  public static void j(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_appid", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1, paramInt);
    paramContext.apply();
  }
  
  public static void j(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "enter_lightalk_vip", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean j(String paramString, Context paramContext)
  {
    paramString = paramString + "&" + "key_setting_read_system_schedule";
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, false);
  }
  
  public static int k(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, 0);
  }
  
  public static int k(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_version", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString1, 0);
  }
  
  public static long k(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("doutu_config_duration_" + paramString, 0L);
  }
  
  public static SharedPreferences k(Context paramContext)
  {
    return paramContext.getSharedPreferences("qav_business", 4);
  }
  
  public static SharedPreferences k(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("extend_friend_config_785" + paramString, 4);
  }
  
  public static String k(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, "");
  }
  
  public static void k(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "_" + "sp_aio_config", 0).edit();
    paramContext.putInt(paramString2, paramInt);
    paramContext.apply();
  }
  
  public static void k(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("readinjoy_folder_setting_url", paramString);
    paramContext.putBoolean("readinjoy_folder_setting_btn", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean k(String paramString, Context paramContext)
  {
    paramString = paramString + "&" + "key_message_notify_guide";
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, true);
  }
  
  public static void kk(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4).edit();
    localEditor.putInt("filter_download", paramInt1);
    localEditor.putInt("filter_total", paramInt2);
    localEditor.commit();
  }
  
  public static void kl(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).edit();
    localEditor.putInt("av_pendant_download", paramInt1);
    localEditor.putInt("av_pendant_total", paramInt2);
    localEditor.commit();
  }
  
  public static int l(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_appid", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString1, 0);
  }
  
  public static long l(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("doutu_config_combo_duration_" + paramString, 0L);
  }
  
  public static SharedPreferences l(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("lightalk_tips_sp_" + paramString, 0);
  }
  
  public static void l(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    if (paramString2 == null) {
      paramContext.remove(paramString1 + "_readinjoy_refresh_" + paramInt);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString1 + "_readinjoy_refresh_" + paramInt, paramString2);
    }
  }
  
  public static void l(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "auto_agree_join_troop", paramBoolean);
    paramContext.commit();
  }
  
  public static void lY(long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putLong("X5Update", paramLong);
    localEditor.commit();
  }
  
  public static long m(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("doutu_config_combo_keep_" + paramString, 0L);
  }
  
  public static String m(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString2 + "_" + paramString1, "");
  }
  
  public static void m(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("entry_config_verion_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void m(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "_" + "sp_aio_config", 0).edit();
    paramContext.putInt(paramString2, paramInt);
    paramContext.apply();
  }
  
  public static void m(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext, paramString, false, "device_manage_has_show", Boolean.valueOf(paramBoolean));
  }
  
  public static long n(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString + "_" + "graytips_call_last_alerttime", 0L);
  }
  
  public static String n(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getString(paramContext, null);
  }
  
  public static void n(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("group_video_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void n(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "is_show_buluo_red_num_red_dot", paramBoolean);
    paramContext.commit();
  }
  
  public static void n(String paramString, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfString.length - 1)
      {
        localStringBuilder.append(paramArrayOfString[i]).append("_");
        i += 1;
      }
      localStringBuilder.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString("pref_tag_hotword_title_list" + paramString, localStringBuilder.toString()).commit();
  }
  
  public static long o(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString + "_req_troop_effect_config", 0L);
  }
  
  public static void o(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("individuation_abtest_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void o(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "game_room", paramBoolean);
    paramContext.commit();
  }
  
  public static void o(String paramString, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfString.length - 1)
      {
        localStringBuilder.append(paramArrayOfString[i]).append("_");
        i += 1;
      }
      localStringBuilder.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString("pref_tag_unify_hotword_title_list" + paramString, localStringBuilder.toString()).commit();
  }
  
  public static long p(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("readinjoy_skin_guide_seq_" + paramString, 0L);
  }
  
  public static void p(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qfind_pidlist_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("upgrade_qq_time" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_config_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static long q(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString + "_readinjoy_skin_guide_time", 0L);
  }
  
  public static void q(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "", paramInt);
    paramContext.commit();
  }
  
  public static void q(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("doutu_config_duration_" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void q(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1, paramString3);
    paramContext.apply();
  }
  
  public static void q(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_combo_config_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static long r(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString + "_readinjoy_ad_material_req_time", 0L);
  }
  
  public static void r(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "pushbanner_ad_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void r(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("doutu_config_combo_duration_" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void r(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1, paramString3);
    paramContext.apply();
  }
  
  public static void r(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_recommend_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean rA(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(paramString + "_is_has_show_troop_revoke_tip", false);
  }
  
  public static long s(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("zhitu_safegate_request_time_" + paramString, 0L);
  }
  
  public static void s(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("general_configs_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void s(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("doutu_config_combo_keep_" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void s(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "_" + "sp_aio_config", 0).edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.apply();
  }
  
  public static void s(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "troop_gift_to_all_tab", paramBoolean);
    paramContext.commit();
  }
  
  public static void setMainProccessThreadMonitorTime(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).edit();
    localEditor.putLong("monitorStartTime", paramLong);
    localEditor.apply();
  }
  
  public static void setMainProccessThreadPeakCounts(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).edit();
    localEditor.putLong("peakThreadCount", paramLong);
    localEditor.apply();
  }
  
  public static int t(int paramInt, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt("lastSeq" + paramInt + paramString, 0);
  }
  
  public static long t(Context paramContext, String paramString)
  {
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("download_dialog_shown_timestamp_" + paramString, 0L);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getDownloadDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(l), " uin: ", paramString });
    }
    return l;
  }
  
  public static void t(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("general_android_configs_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void t(Context paramContext, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("daily_boot_report", paramLong).apply();
  }
  
  public static void t(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong(paramString + "_" + "graytips_call_last_alerttime", paramLong);
    paramContext.commit();
  }
  
  public static void t(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString2 + "_" + paramString1, paramString3);
    paramContext.commit();
  }
  
  public static void t(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("conversation_unfollow_public_acc_switch_" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static void t(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_latest_q_zone_feed_second_" + paramString2;
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putLong(paramString2, paramLong).apply();
  }
  
  public static boolean t(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString1 + "_readinjoy_skin_guide_" + paramString2, false);
  }
  
  public static long u(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("daily_boot_report", 0L);
  }
  
  public static long u(Context paramContext, String paramString)
  {
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("install_dialog_shown_timestamp_" + paramString, 0L);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getInstallDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(l), " uin: ", paramString });
    }
    return l;
  }
  
  public static void u(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "qav_upgrade_invite_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void u(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong(paramString + "_req_troop_effect_config", paramLong);
    paramContext.commit();
  }
  
  public static void u(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    paramContext.putBoolean(paramString + "_readinjoy_skin_volume", paramBoolean);
    paramContext.commit();
  }
  
  public static void u(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_latest_signature_feed_second_" + paramString2;
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putLong(paramString2, paramLong).apply();
  }
  
  public static boolean u(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("has_show_robot_chat_waring_banner" + paramString1 + "_" + paramString2, false);
  }
  
  public static long v(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("sp_report_login", 4).getLong("key_report_login_time_millis_today_zero_" + paramString, 0L);
  }
  
  public static void v(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "qav_anychat_time_limit_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void v(Context paramContext, String paramString, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("readinjoy_skin_guide_seq_" + paramString, paramLong).commit();
  }
  
  public static void v(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("zhitu_config_switch_" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static int w(Context paramContext, int paramInt)
  {
    try
    {
      int i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_process_max", paramInt);
      return i;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQStoryFeedManager", 1, "miniapp getMiniAppProcessMaxCount error.", paramContext);
    }
    return paramInt;
  }
  
  public static long w(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("key_notification_push_gray_tips_time_millis_today_zero_" + paramString, 0L);
  }
  
  public static void w(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "now_tab_config_cmd_version", paramInt);
    paramContext.commit();
  }
  
  public static void w(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("zhitu_safegate_request_time_" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void w(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("zhitu_config_save_share_switch_" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static int x(Context paramContext, int paramInt)
  {
    try
    {
      int i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_process_max", paramInt);
      return i;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQStoryFeedManager", 1, "miniapp getMiniGameProcessMaxCount error.", paramContext);
    }
    return paramInt;
  }
  
  public static long x(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sticker_remove_emoticon_package_time_" + paramString, 0L);
  }
  
  public static void x(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "now_download_engine_cmd_version", paramInt);
    paramContext.commit();
  }
  
  public static void x(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setDownloadDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(paramLong), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("download_dialog_shown_timestamp_" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void x(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("zhitu_safegate_switch_" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static String[] x(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString("pref_tag_hotword_title_list" + paramString, "").split("_");
  }
  
  public static int y(Context paramContext, int paramInt)
  {
    try
    {
      int i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_process_preload_count", paramInt);
      if (anmo.cIy)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Perf", 2, "disable preload mini processes，value =" + i);
        }
        anmo.aml = System.currentTimeMillis();
        return 0;
      }
      return i;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQStoryFeedManager", 1, "miniapp getMiniAppProcessPreloadCount error.", paramContext);
    }
    return paramInt;
  }
  
  public static void y(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("videodown_ct_whitelist_version", paramInt);
    paramContext.putString("videodown_ct_whitelist", paramString);
    paramContext.commit();
  }
  
  public static void y(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setInstallDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(paramLong), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("install_dialog_shown_timestamp_" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void y(Context paramContext, String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if (QQAppInterface.class.isInstance(paramContext)) {}
    for (paramContext = ((QQAppInterface)paramContext).getCurrentUin();; paramContext = "")
    {
      localEditor.putBoolean(paramString + "_" + "qim_video_combol_lock_info" + "_" + paramContext, paramBoolean);
      localEditor.commit();
      return;
    }
  }
  
  public static String[] y(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString("pref_tag_unify_hotword_title_list" + paramString, "").split("_");
  }
  
  public static void z(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("mix_msg_forward_config_version", paramInt);
    paramContext.putString("mix_msg_forward_config", paramString);
    paramContext.commit();
  }
  
  public static void z(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("sp_report_login", 4).edit().putLong("key_report_login_time_millis_today_zero_" + paramString, paramLong).apply();
  }
  
  public static void z(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "rich_text_first_time_tab_showed", paramBoolean);
    paramContext.commit();
  }
  
  public static void z(String paramString, Object paramObject)
  {
    a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), true, paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqmj
 * JD-Core Version:    0.7.0.1
 */