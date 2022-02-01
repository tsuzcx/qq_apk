import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.HashMap;
import java.util.Map;

public class axcg
{
  public static final axcg A;
  public static final axcg B;
  public static final axcg C;
  public static final axcg a;
  private static final axcg[] a;
  public static final axcg b;
  public static final axcg c;
  public static final axcg d;
  public static final axcg e;
  public static final axcg f;
  public static final axcg g;
  public static final axcg h;
  public static final axcg i;
  public static final axcg j;
  public static final axcg k;
  public static final axcg l;
  public static final axcg m;
  public static final axcg n;
  public static final axcg o;
  public static final axcg p;
  public static final axcg q;
  public static final axcg r;
  public static final axcg s;
  public static final axcg t;
  public static final axcg u;
  public static final axcg v;
  public static final axcg w;
  public static final axcg x;
  public static final axcg y;
  public static final axcg z;
  private String cTK;
  private int id;
  private boolean needReport;
  
  static
  {
    jdField_a_of_type_Axcg = new axcg("", -1);
    b = new axcg("h5", 0);
    c = new axcg("mainCamera", 1);
    d = new axcg("", 2);
    e = new axcg("aioMainCamera", 3);
    f = new axcg("", 4);
    g = new axcg("qzoneCamera", 5);
    h = new axcg("", 6);
    i = new axcg("aioGifCamera", 7);
    j = new axcg("", 8);
    k = new axcg("aioGroupSignin", 9);
    l = new axcg("qzoneSignin", 10);
    m = new axcg("qzoneBanner", 11);
    n = new axcg("qzoneTail", 12);
    o = new axcg("qzoneMoodList", 13);
    p = new axcg("", 14);
    q = new axcg("qzoneFriendPlus", 15);
    r = new axcg("qzoneFriendState", 16);
    s = new axcg("qzoneSlideCamera", 17);
    t = new axcg("aioChats", 18);
    u = new axcg("massSendBless", 19);
    v = new axcg("qzonePublishFrame", 20);
    w = new axcg("aioGifCameraTail", 23);
    x = new axcg("circleCamera", 25);
    y = new axcg("circlePickCamera", 26);
    z = new axcg("circleGuideCamera", 27);
    A = new axcg("circleGuidePicker", 28);
    B = new axcg("qudongTakeFacePhoto", 1001, false);
    C = new axcg("web", 1002, false);
    jdField_a_of_type_ArrayOfAxcg = new axcg[] { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, B, C, v, x, z };
  }
  
  private axcg(String paramString, int paramInt)
  {
    this.id = paramInt;
    this.cTK = paramString;
    this.needReport = true;
  }
  
  private axcg(String paramString, int paramInt, boolean paramBoolean)
  {
    this.id = paramInt;
    this.cTK = paramString;
    this.needReport = paramBoolean;
  }
  
  public static boolean F(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramActivity.getIntent() != null)
      {
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Axcg.getId());
        if (i1 != C.getId())
        {
          bool1 = bool2;
          if (i1 != B.getId()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean G(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    return oe(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Axcg.getId()));
  }
  
  public static boolean H(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    if (paramActivity.hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {}
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Axcg.getId());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Axcg.getId())) {
      return og(i1);
    }
  }
  
  public static boolean I(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    int i1;
    if (paramActivity.hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE"))
    {
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Axcg.getId());
      if (n.getId() != i1) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Axcg.getId());
      break;
    }
  }
  
  public static axcg a(int paramInt)
  {
    axcg[] arrayOfaxcg = jdField_a_of_type_ArrayOfAxcg;
    int i2 = arrayOfaxcg.length;
    int i1 = 0;
    while (i1 < i2)
    {
      axcg localaxcg = arrayOfaxcg[i1];
      if (paramInt == localaxcg.getId()) {
        return localaxcg;
      }
      i1 += 1;
    }
    return jdField_a_of_type_Axcg;
  }
  
  public static axcg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Axcg;
    }
    axcg[] arrayOfaxcg = jdField_a_of_type_ArrayOfAxcg;
    int i2 = arrayOfaxcg.length;
    int i1 = 0;
    if (i1 < i2)
    {
      axcg localaxcg = arrayOfaxcg[i1];
      if (TextUtils.isEmpty(localaxcg.HH())) {}
      while (!paramString.equals(localaxcg.HH()))
      {
        i1 += 1;
        break;
      }
      return localaxcg;
    }
    return jdField_a_of_type_Axcg;
  }
  
  private static boolean al(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Axcg.getId()) == t.getId()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean am(Intent paramIntent)
  {
    boolean bool = false;
    if ((paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean an(Intent paramIntent)
  {
    return (paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 100);
  }
  
  public static boolean ao(Intent paramIntent)
  {
    return (aq(paramIntent)) || (ar(paramIntent)) || (as(paramIntent));
  }
  
  private static boolean ap(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101);
  }
  
  private static boolean aq(Intent paramIntent)
  {
    return (at(paramIntent)) && (ap(paramIntent));
  }
  
  private static boolean ar(Intent paramIntent)
  {
    return (al(paramIntent)) && (ap(paramIntent));
  }
  
  private static boolean as(Intent paramIntent)
  {
    return (au(paramIntent)) && (ap(paramIntent));
  }
  
  public static boolean at(Intent paramIntent)
  {
    return (paramIntent != null) && (i(paramIntent) == n.getId());
  }
  
  public static boolean au(Intent paramIntent)
  {
    int i1 = i(paramIntent);
    return (i1 == k.getId()) || (i1 == l.getId());
  }
  
  public static boolean av(Intent paramIntent)
  {
    return (paramIntent != null) && (i(paramIntent) == e.getId());
  }
  
  public static boolean aw(Intent paramIntent)
  {
    return (paramIntent != null) && (i(paramIntent) == B.getId());
  }
  
  public static boolean ax(Intent paramIntent)
  {
    return (paramIntent != null) && (i(paramIntent) == C.getId());
  }
  
  public static boolean ay(Intent paramIntent)
  {
    return (paramIntent != null) && ((i(paramIntent) == x.getId()) || (az(paramIntent)));
  }
  
  public static boolean az(Intent paramIntent)
  {
    return (paramIntent != null) && ((i(paramIntent) == z.getId()) || (i(paramIntent) == A.getId()));
  }
  
  public static int b(awtq paramawtq)
  {
    int i2 = 200;
    int i1 = i2;
    if (paramawtq != null)
    {
      i1 = i2;
      if (paramawtq.getActivity() != null)
      {
        i1 = i2;
        if (paramawtq.getActivity().getIntent() != null) {
          i1 = paramawtq.getActivity().getIntent().getIntExtra("AECAMERA_MODE", 200);
        }
      }
    }
    return i1;
  }
  
  public static boolean b(Intent paramIntent, int paramInt)
  {
    return (paramInt == 14) && (!am(paramIntent)) && (!an(paramIntent));
  }
  
  public static int gm(String paramString)
  {
    int i2 = 200;
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("camera", Integer.valueOf(200));
    localHashMap.put("all", Integer.valueOf(201));
    localHashMap.put("gif", Integer.valueOf(202));
    localHashMap.put("singlegif", Integer.valueOf(203));
    localHashMap.put("cameraAndPlay", Integer.valueOf(204));
    localHashMap.put("cameraAndGif", Integer.valueOf(205));
    localHashMap.put("play", Integer.valueOf(206));
    localHashMap.put("playAndGif", Integer.valueOf(207));
    int i1 = i2;
    if (paramString != null)
    {
      i1 = i2;
      if (localHashMap.containsKey(paramString))
      {
        i1 = i2;
        if (localHashMap.get(paramString) != null) {
          i1 = ((Integer)localHashMap.get(paramString)).intValue();
        }
      }
    }
    return i1;
  }
  
  public static int i(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_Axcg.getId();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Axcg.getId());
  }
  
  public static int j(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 0;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0);
  }
  
  public static int k(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 100;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100);
  }
  
  public static boolean oc(int paramInt)
  {
    return paramInt == t.getId();
  }
  
  public static boolean od(int paramInt)
  {
    return n.getId() == paramInt;
  }
  
  public static boolean oe(int paramInt)
  {
    return (paramInt == g.getId()) || (paramInt == o.getId()) || (paramInt == r.getId()) || (paramInt == v.getId());
  }
  
  public static boolean of(int paramInt)
  {
    return paramInt == c.getId();
  }
  
  public static boolean og(int paramInt)
  {
    return (paramInt == g.getId()) || (paramInt == o.getId()) || (paramInt == r.getId()) || (paramInt == v.getId());
  }
  
  public static boolean oh(int paramInt)
  {
    return e.getId() == paramInt;
  }
  
  public static boolean oi(int paramInt)
  {
    return (paramInt == x.getId()) || (oj(paramInt));
  }
  
  public static boolean oj(int paramInt)
  {
    return (paramInt == A.getId()) || (paramInt == z.getId());
  }
  
  public static boolean ok(int paramInt)
  {
    return (paramInt != e.getId()) && (paramInt != i.getId()) && (paramInt != p.getId()) && (paramInt != w.getId()) && (paramInt != x.getId()) && (paramInt != B.getId()) && (paramInt != C.getId());
  }
  
  @NonNull
  public static String sA(@Nullable String paramString)
  {
    if ("camera".equals(paramString)) {
      return String.valueOf(AECaptureMode.NORMAL.name);
    }
    if ("play".equals(paramString)) {
      return String.valueOf(AECaptureMode.PLAY.name);
    }
    if ("gif".equals(paramString)) {
      return String.valueOf(AECaptureMode.GIF.name);
    }
    return String.valueOf(AECaptureMode.NORMAL.name);
  }
  
  public String HH()
  {
    return this.cTK;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public boolean isNeedReport()
  {
    return this.needReport;
  }
  
  public boolean ob(int paramInt)
  {
    return this.id == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcg
 * JD-Core Version:    0.7.0.1
 */