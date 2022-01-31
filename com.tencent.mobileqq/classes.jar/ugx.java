import android.annotation.TargetApi;
import com.tencent.common.config.AppSetting;

@TargetApi(14)
public class ugx
{
  public static final Boolean a;
  public static final String a;
  public static boolean a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  public static final String i;
  public static final String j;
  public static final String k;
  public static final String l;
  public static final String m;
  public static final String n;
  public static final String o;
  public static final String p;
  public static final String q;
  public static final String r;
  public static final String s;
  public static final String t;
  public static final String u;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131711195);
    b = alpo.a(2131711192);
    jdField_a_of_type_Boolean = AppSetting.a().contains("r");
    c = ajni.jdField_a_of_type_JavaLangString + "/qqstory/";
    d = c + "debug/";
    e = c + "upload/";
    f = e + ".music/";
    g = c + ".tmp/";
    h = g + "download/preload/";
    i = g + "download/mine/";
    j = g + ".tmp/";
    k = j + "watermark/";
    l = j + "merge/";
    m = j + "audio/";
    n = j + "video/";
    o = j + "slideshow/";
    p = j + "textfilter/";
    q = j + "pk/result/";
    r = k + "source/";
    s = k + "doodle/";
    t = k + "composite/";
    u = k + "download/";
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "VIDEO";
    case 1: 
      return "MASK_PIC";
    }
    return "THUMBNAIL";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugx
 * JD-Core Version:    0.7.0.1
 */