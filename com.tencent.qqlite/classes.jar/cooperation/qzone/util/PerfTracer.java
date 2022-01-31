package cooperation.qzone.util;

import android.os.Handler;
import android.os.HandlerThread;
import fnw;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class PerfTracer
{
  public static final String A = "QunFeed_parseIntent";
  public static final String B = "QunFeed_initUI";
  public static final String C = "QunFeed_initData";
  public static final String D = "QunFeed_onResume";
  public static final String E = "Detail_click2Activity";
  public static final String F = "Detail_onCreate";
  public static final String G = "Detail_init";
  public static final String H = "Detail_initEmoView";
  public static final String I = "Detail_onResume";
  public static final String J = "Detail_render";
  public static final String K = "UploadPhoto_onCreate";
  public static final String L = "UploadPhoto_state_init";
  public static final String M = "UploadPhoto_initUI";
  public static final String N = "UploadPhoto_initData";
  public static final String O = "UploadPhoto_initEmoView";
  public static final String P = "UploadPhoto_onResume";
  public static final String Q = "QunAlbum_click2Activity";
  public static final String R = "QunAlbum_onCreate";
  public static final String S = "QunAlbum_state_init";
  public static final String T = "QunAlbum_parseIntent";
  public static final String U = "QunAlbum_initUI";
  public static final String V = "QunAlbum_initData";
  public static final String W = "QunAlbum_onResume";
  public static final String X = "UserHome_onCreate";
  public static final String Y = "UserHome_parseIntent";
  public static final String Z = "UserHome_initUI";
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public static final String a = "click2LoadCompleted";
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
  public static final boolean a = false;
  public static final String aa = "UserHome_initData";
  public static final String ab = "UserHome_onResume";
  public static final String ac = "QzoneAlbum_onCreate";
  public static final String ad = "QzoneAlbum_onResume";
  public static final String ae = "QzoneRecent_click2Activity";
  public static final String af = "QzoneRecent_onCreate";
  public static final String ag = "QzoneRecent_onResume";
  public static final String ah = "ShareAlbum_click2Activity";
  public static final String ai = "ShareAlbum_onCreate";
  public static final String aj = "ShareAlbum_parseIntent";
  public static final String ak = "ShareAlbum_initUI";
  public static final String al = "ShareAlbum_initData";
  public static final String am = "ShareAlbum_onResume";
  public static final String an = "PhotoWall_onCreate";
  public static final String ao = "PhotoWall_initUI";
  public static final String ap = "PhotoWall_initData";
  public static final String aq = "PhotoWall_onResume";
  private static final String ar = "Perf.Qzone";
  public static final String b = "App_onCreate";
  public static final String c = "Runtime_load_runtime";
  public static final String d = "Runtime_onCreate";
  public static final String e = "Runtime_super_onCreate";
  public static final String f = "Runtime_first_init";
  public static final String g = "Runtime_Business_onLogin";
  public static final String h = "Preload_contentView";
  public static final String i = "Preload_headView";
  public static final String j = "Preload_New_FriendFeed";
  public static final String k = "Preload_Cover";
  public static final String l = "Preload_Avatar";
  public static final String m = "Preload_FriendFeedData";
  public static final String n = "Preload_QunFeedData";
  public static final String o = "FriendFeed_click2Activity";
  public static final String p = "FriendFeed_onCreate";
  public static final String q = "FriendFeed_parseIntent";
  public static final String r = "FriendFeed_initFakeUI";
  public static final String s = "FriendFeed_initUI";
  public static final String t = "FriendFeed_initHeader";
  public static final String u = "FriendFeed_initHeader_Cover";
  public static final String v = "FriendFeed_initData";
  public static final String w = "FriendFeed_onResume";
  public static final String x = "FriendFeed_onCreate2WindowFocus";
  public static final String y = "FriendFeed_delayShow";
  public static final String z = "QunFeed_onCreate";
  
  public static Handler a()
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Perf.Qzone");
      jdField_a_of_type_AndroidOsHandlerThread.start();
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return jdField_a_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static final void a(String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    a().post(new fnw(paramString1, l1, paramString2));
  }
  
  private static boolean c(String paramString)
  {
    return paramString.contains("click");
  }
  
  private static boolean d(String paramString)
  {
    return (paramString.startsWith("FriendFeed_")) || (paramString.startsWith("App_")) || (paramString.startsWith("Runtime_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.qzone.util.PerfTracer
 * JD-Core Version:    0.7.0.1
 */