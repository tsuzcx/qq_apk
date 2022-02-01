import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public class psr
  extends psb
{
  public static String auR = "key_get_video_source_tag_config_time";
  public static String auS = bT(-128);
  public static String auT = "key_last_get_config_time";
  private long Aq;
  public psp a = (psp)ppf.a(psp.class, new Object[0]);
  
  public psr()
  {
    super.attachContext(BaseApplicationImpl.getApplication());
  }
  
  public static boolean IK()
  {
    return ((Boolean)((psr)psx.a(10)).c("boolean_enable_cq_mode", Boolean.valueOf(true))).booleanValue();
  }
  
  public static boolean IL()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    return ((Boolean)((psr)psx.a(10)).c("boolean_need_high_profile", Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean IM()
  {
    return false;
  }
  
  public static boolean IN()
  {
    int i = ((Integer)((psr)psx.a(10)).c("integer_show_sync_to_qzone_btn", Integer.valueOf(0))).intValue();
    ram.b("Q.qqstory.config.StoryConfigManager", "isShowSyncToQzone :%d", Integer.valueOf(i));
    return i == 1;
  }
  
  public static boolean IO()
  {
    int i = ((Integer)((psr)psx.a(10)).c("integer_enable_sync_to_qzone", Integer.valueOf(-1))).intValue();
    ram.b("Q.qqstory.config.StoryConfigManager", "isSyncToQzone :%s", Integer.valueOf(i));
    return i == 1;
  }
  
  public static boolean IP()
  {
    return ((Integer)((psr)psx.a(10)).c("integer_show_sync_to_qzone_tip", Integer.valueOf(0))).intValue() == 0;
  }
  
  public static boolean IQ()
  {
    psr localpsr = (psr)psx.a(10);
    if (((Integer)localpsr.c("sp_key_user_first_enter_album", Integer.valueOf(-1))).intValue() == -1)
    {
      localpsr.n("sp_key_user_first_enter_album", Integer.valueOf(0));
      return true;
    }
    return false;
  }
  
  public static boolean IR()
  {
    return ((Boolean)((psr)psx.a(10)).c("key_take_video_node_config_clicked", Boolean.valueOf(false))).booleanValue();
  }
  
  public static String bT(int paramInt)
  {
    return "qqstory_config_version_of_type__" + paramInt;
  }
  
  public static void bmF()
  {
    ((psr)psx.a(10)).n("integer_show_sync_to_qzone_tip", Integer.valueOf(1));
  }
  
  public static void bmG()
  {
    ((psr)psx.a(10)).rg("follow_capture_config");
  }
  
  public static String mA()
  {
    return (String)((psr)psx.a(10)).c("key_story_album_config", "");
  }
  
  public static String mB()
  {
    return (String)((psr)psx.a(10)).c("key_story_home_album_entra_confg", "");
  }
  
  public static String mC()
  {
    return (String)((psr)psx.a(10)).d("thumbnail_config", "");
  }
  
  public static String mw()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static String my()
  {
    return (String)((psr)psx.a(10)).d("follow_capture_config", "");
  }
  
  public static String mz()
  {
    return (String)((psr)psx.a(10)).c("key_take_video_node_config", "");
  }
  
  public static void ri(String paramString)
  {
    ((psr)psx.a(10)).o("follow_capture_config", paramString);
  }
  
  public static void rj(String paramString)
  {
    ((psr)psx.a(10)).n("key_take_video_node_config", paramString);
  }
  
  public static void rk(String paramString)
  {
    ((psr)psx.a(10)).n("key_story_album_config", paramString);
  }
  
  public static void rl(String paramString)
  {
    ((psr)psx.a(10)).n("key_story_home_album_entra_confg", paramString);
  }
  
  public static void rm(String paramString)
  {
    ((psr)psx.a(10)).o("thumbnail_config", paramString);
  }
  
  public static void sf(boolean paramBoolean)
  {
    ram.b("Q.qqstory.config.StoryConfigManager", "setShowSyncToQzone :%s", Boolean.valueOf(paramBoolean));
    psr localpsr = (psr)psx.a(10);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localpsr.n("integer_show_sync_to_qzone_btn", Integer.valueOf(i));
      if (!paramBoolean) {
        localpsr.n("integer_enable_sync_to_qzone", Integer.valueOf(-1));
      }
      return;
    }
  }
  
  public static void sg(boolean paramBoolean)
  {
    ram.b("Q.qqstory.config.StoryConfigManager", "setSyncToQzone :%s", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((psr)psx.a(10)).n("integer_enable_sync_to_qzone", Integer.valueOf(i));
      return;
    }
  }
  
  public static void sh(boolean paramBoolean)
  {
    ram.b("Q.qqstory.config.StoryConfigManager", "setSyncToQzoneDefaultValue :%s", Boolean.valueOf(paramBoolean));
    psr localpsr = (psr)psx.a(10);
    if (((Integer)localpsr.c("integer_enable_sync_to_qzone", Integer.valueOf(-1))).intValue() == -1)
    {
      ram.d("Q.qqstory.config.StoryConfigManager", "setSyncToQzoneDefaultValue work");
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      localpsr.n("integer_enable_sync_to_qzone", Integer.valueOf(i));
      return;
    }
  }
  
  public static void si(boolean paramBoolean)
  {
    ((psr)psx.a(10)).n("key_take_video_node_config_clicked", Boolean.valueOf(paramBoolean));
  }
  
  public static void sj(boolean paramBoolean)
  {
    ((psr)psx.a(10)).n("key_qa_entrance", Boolean.valueOf(paramBoolean));
  }
  
  public static int sx()
  {
    return ((Integer)((psr)psx.a(10)).c("int_upload_video_size_limit", Integer.valueOf(5120))).intValue() * 1024;
  }
  
  public static int sy()
  {
    return ((Integer)((psr)psx.a(10)).c("int_high_bitrate", Integer.valueOf(3000))).intValue() * 1000;
  }
  
  public boolean II()
  {
    return ((Boolean)c("has_show_play_guide_vertical", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean IJ()
  {
    return ((Boolean)c("has_show_play_guide_horizontal", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean a(int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    return this.a.a(paramInt, paramIntent, paramConfig);
  }
  
  public void bmE()
  {
    ram.d("Q.qqstory.config.StoryConfigManager", "getBlackStatus");
    int i = ((Integer)c("qqstory_black_status_last_update_time", Integer.valueOf(0))).intValue();
    int j = ((Integer)c("qqstory_black_status_update_interval", Integer.valueOf(14400))).intValue();
    long l = NetConnInfoCenter.getServerTime();
    if (l > j + i)
    {
      pyo localpyo = new pyo();
      localpyo.mUnionId = QQStoryContext.a().getCurrentUid();
      ppv.a().a(localpyo, new pss(this, l));
    }
  }
  
  public <V> V c(@NonNull String paramString, @NonNull V paramV)
  {
    return super.getValue(paramString + "_" + mw(), paramV);
  }
  
  public <V> V d(@NonNull String paramString, @NonNull V paramV)
  {
    return super.getValue(paramString, paramV);
  }
  
  public long dI()
  {
    return ((Long)c("recent_story_refresh_time", Long.valueOf(0L))).longValue();
  }
  
  public long dJ()
  {
    return this.Aq;
  }
  
  public long dK()
  {
    return ((Long)d(auT, Long.valueOf(0L))).longValue();
  }
  
  public long dL()
  {
    return ((Long)d(auR, Long.valueOf(0L))).longValue();
  }
  
  public void fg(long paramLong)
  {
    this.Aq = paramLong;
  }
  
  public void fh(long paramLong)
  {
    o(auT, Long.valueOf(paramLong));
  }
  
  public void fi(long paramLong)
  {
    o(auR, Long.valueOf(paramLong));
  }
  
  public int lA()
  {
    return aqmj.i(QQStoryContext.a().getApplication(), auS, QQStoryContext.a().mi());
  }
  
  public String mv()
  {
    return (String)c("qqstory_retry_proto_list", "");
  }
  
  public String mx()
  {
    return (String)c("key_video_source_tag_info_config", "");
  }
  
  public <V> void n(@NonNull String paramString, @NonNull V paramV)
  {
    super.m(paramString + "_" + mw(), paramV);
  }
  
  public <V> void o(@NonNull String paramString, @NonNull V paramV)
  {
    super.m(paramString, paramV);
  }
  
  public void rf(String paramString)
  {
    n("qqstory_retry_proto_list", paramString);
  }
  
  public <V> void rg(@NonNull String paramString)
  {
    super.removeValue(paramString);
  }
  
  public void rh(String paramString)
  {
    n("key_video_source_tag_info_config", paramString);
  }
  
  public void sd(boolean paramBoolean)
  {
    n("has_show_play_guide_vertical", Boolean.valueOf(paramBoolean));
  }
  
  public void se(boolean paramBoolean)
  {
    n("has_show_play_guide_horizontal", Boolean.valueOf(paramBoolean));
  }
  
  public int sw()
  {
    return ((Integer)c("qqstory_black_status", Integer.valueOf(0))).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psr
 * JD-Core Version:    0.7.0.1
 */