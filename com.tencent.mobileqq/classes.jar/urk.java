import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public class urk
  extends uqp
{
  public static String a;
  public static String b = a(-128);
  public static String c = "key_last_get_config_time";
  private long a;
  public urg a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "key_get_video_source_tag_config_time";
  }
  
  public urk()
  {
    this.jdField_a_of_type_Urg = ((urg)ume.a(urg.class, new Object[0]));
    super.a(BaseApplicationImpl.getApplication());
  }
  
  public static String a(int paramInt)
  {
    return "qqstory_config_version_of_type__" + paramInt;
  }
  
  public static void a(int paramInt)
  {
    ((urk)urr.a(10)).b("follow_capture_guide_count", Integer.valueOf(paramInt));
  }
  
  public static boolean a(String paramString)
  {
    return ((Integer)((urk)urr.a(10)).b("integer_show_follow_capture_tip" + paramString, Integer.valueOf(0))).intValue() == 0;
  }
  
  public static String b()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static int c()
  {
    return ((Integer)((urk)urr.a(10)).b("int_upload_video_size_limit", Integer.valueOf(5120))).intValue() * 1024;
  }
  
  public static void c(boolean paramBoolean)
  {
    wsv.a("Q.qqstory.config.StoryConfigManager", "setShowSyncToQzone :%s", Boolean.valueOf(paramBoolean));
    urk localurk = (urk)urr.a(10);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localurk.b("integer_show_sync_to_qzone_btn", Integer.valueOf(i));
      if (!paramBoolean) {
        localurk.b("integer_enable_sync_to_qzone", Integer.valueOf(-1));
      }
      return;
    }
  }
  
  public static boolean c()
  {
    return ((Boolean)((urk)urr.a(10)).b("boolean_enable_cq_mode", Boolean.valueOf(true))).booleanValue();
  }
  
  public static int d()
  {
    return ((Integer)((urk)urr.a(10)).b("int_high_bitrate", Integer.valueOf(3000))).intValue() * 1000;
  }
  
  public static String d()
  {
    return (String)((urk)urr.a(10)).c("follow_capture_config", "");
  }
  
  public static void d()
  {
    ((urk)urr.a(10)).b("integer_show_sync_to_qzone_tip", Integer.valueOf(1));
  }
  
  public static void d(boolean paramBoolean)
  {
    wsv.a("Q.qqstory.config.StoryConfigManager", "setSyncToQzone :%s", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((urk)urr.a(10)).b("integer_enable_sync_to_qzone", Integer.valueOf(i));
      return;
    }
  }
  
  public static boolean d()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    return ((Boolean)((urk)urr.a(10)).b("boolean_need_high_profile", Boolean.valueOf(false))).booleanValue();
  }
  
  public static int e()
  {
    return ((Integer)((urk)urr.a(10)).b("follow_capture_guide_count", Integer.valueOf(0))).intValue();
  }
  
  public static String e()
  {
    return (String)((urk)urr.a(10)).b("key_take_video_node_config", "");
  }
  
  public static void e()
  {
    ((urk)urr.a(10)).c("follow_capture_config");
  }
  
  public static void e(String paramString)
  {
    ((urk)urr.a(10)).b("integer_show_follow_capture_tip" + paramString, Integer.valueOf(1));
  }
  
  public static void e(boolean paramBoolean)
  {
    wsv.a("Q.qqstory.config.StoryConfigManager", "setSyncToQzoneDefaultValue :%s", Boolean.valueOf(paramBoolean));
    urk localurk = (urk)urr.a(10);
    if (((Integer)localurk.b("integer_enable_sync_to_qzone", Integer.valueOf(-1))).intValue() == -1)
    {
      wsv.b("Q.qqstory.config.StoryConfigManager", "setSyncToQzoneDefaultValue work");
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      localurk.b("integer_enable_sync_to_qzone", Integer.valueOf(i));
      return;
    }
  }
  
  public static boolean e()
  {
    return false;
  }
  
  public static String f()
  {
    return (String)((urk)urr.a(10)).b("key_story_album_config", "");
  }
  
  public static void f(String paramString)
  {
    ((urk)urr.a(10)).c("follow_capture_config", paramString);
  }
  
  public static void f(boolean paramBoolean)
  {
    ((urk)urr.a(10)).b("key_take_video_node_config_clicked", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean f()
  {
    int i = ((Integer)((urk)urr.a(10)).b("integer_show_sync_to_qzone_btn", Integer.valueOf(0))).intValue();
    wsv.a("Q.qqstory.config.StoryConfigManager", "isShowSyncToQzone :%d", Integer.valueOf(i));
    return i == 1;
  }
  
  public static String g()
  {
    return (String)((urk)urr.a(10)).b("key_story_home_album_entra_confg", "");
  }
  
  public static void g(String paramString)
  {
    ((urk)urr.a(10)).b("key_take_video_node_config", paramString);
  }
  
  public static void g(boolean paramBoolean)
  {
    ((urk)urr.a(10)).b("key_qa_entrance", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean g()
  {
    int i = ((Integer)((urk)urr.a(10)).b("integer_enable_sync_to_qzone", Integer.valueOf(-1))).intValue();
    wsv.a("Q.qqstory.config.StoryConfigManager", "isSyncToQzone :%s", Integer.valueOf(i));
    return i == 1;
  }
  
  public static String h()
  {
    return (String)((urk)urr.a(10)).c("thumbnail_config", "");
  }
  
  public static void h(String paramString)
  {
    ((urk)urr.a(10)).b("key_story_album_config", paramString);
  }
  
  public static boolean h()
  {
    return ((Integer)((urk)urr.a(10)).b("integer_show_sync_to_qzone_tip", Integer.valueOf(0))).intValue() == 0;
  }
  
  public static void i(String paramString)
  {
    ((urk)urr.a(10)).b("key_story_home_album_entra_confg", paramString);
  }
  
  public static boolean i()
  {
    urk localurk = (urk)urr.a(10);
    if (((Integer)localurk.b("sp_key_user_first_enter_album", Integer.valueOf(-1))).intValue() == -1)
    {
      localurk.b("sp_key_user_first_enter_album", Integer.valueOf(0));
      return true;
    }
    return false;
  }
  
  public static void j(String paramString)
  {
    ((urk)urr.a(10)).c("thumbnail_config", paramString);
  }
  
  public static boolean j()
  {
    return ((Boolean)((urk)urr.a(10)).b("key_take_video_node_config_clicked", Boolean.valueOf(false))).booleanValue();
  }
  
  public int a()
  {
    return ((Integer)b("qqstory_black_status", Integer.valueOf(0))).intValue();
  }
  
  public long a()
  {
    return ((Long)b("recent_story_refresh_time", Long.valueOf(0L))).longValue();
  }
  
  public String a()
  {
    return (String)b("qqstory_retry_proto_list", "");
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    b("has_show_play_guide_vertical", Boolean.valueOf(paramBoolean));
  }
  
  public boolean a()
  {
    return ((Boolean)b("has_show_play_guide_vertical", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean a(int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    return this.jdField_a_of_type_Urg.a(paramInt, paramIntent, paramConfig);
  }
  
  public int b()
  {
    return bdiv.a(QQStoryContext.a().a(), b, QQStoryContext.a().a());
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public <V> V b(@NonNull String paramString, @NonNull V paramV)
  {
    return super.a(paramString + "_" + b(), paramV);
  }
  
  public void b(long paramLong)
  {
    c(c, Long.valueOf(paramLong));
  }
  
  public void b(String paramString)
  {
    b("qqstory_retry_proto_list", paramString);
  }
  
  public <V> void b(@NonNull String paramString, @NonNull V paramV)
  {
    super.a(paramString + "_" + b(), paramV);
  }
  
  public void b(boolean paramBoolean)
  {
    b("has_show_play_guide_horizontal", Boolean.valueOf(paramBoolean));
  }
  
  public boolean b()
  {
    return ((Boolean)b("has_show_play_guide_horizontal", Boolean.valueOf(false))).booleanValue();
  }
  
  public long c()
  {
    return ((Long)c(c, Long.valueOf(0L))).longValue();
  }
  
  public <V> V c(@NonNull String paramString, @NonNull V paramV)
  {
    return super.a(paramString, paramV);
  }
  
  public String c()
  {
    return (String)b("key_video_source_tag_info_config", "");
  }
  
  public void c()
  {
    wsv.b("Q.qqstory.config.StoryConfigManager", "getBlackStatus");
    int i = ((Integer)b("qqstory_black_status_last_update_time", Integer.valueOf(0))).intValue();
    int j = ((Integer)b("qqstory_black_status_update_interval", Integer.valueOf(14400))).intValue();
    long l = NetConnInfoCenter.getServerTime();
    if (l > j + i)
    {
      vat localvat = new vat();
      localvat.b = QQStoryContext.a().b();
      ung.a().a(localvat, new url(this, l));
    }
  }
  
  public void c(long paramLong)
  {
    c(jdField_a_of_type_JavaLangString, Long.valueOf(paramLong));
  }
  
  public <V> void c(@NonNull String paramString)
  {
    super.a(paramString);
  }
  
  public <V> void c(@NonNull String paramString, @NonNull V paramV)
  {
    super.a(paramString, paramV);
  }
  
  public long d()
  {
    return ((Long)c(jdField_a_of_type_JavaLangString, Long.valueOf(0L))).longValue();
  }
  
  public void d(String paramString)
  {
    b("key_video_source_tag_info_config", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     urk
 * JD-Core Version:    0.7.0.1
 */