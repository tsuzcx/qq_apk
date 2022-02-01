import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator.1;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import common.config.service.QzoneConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class wgv
{
  static final Pattern J = Pattern.compile(aqjb.WEB_URL.pattern());
  private static wgv a;
  public static int bNc = -1;
  public static boolean bcj = true;
  public static boolean bck;
  private long HE = 86400000L;
  private int bNd = 15;
  private int bNe = 10;
  private Set<String> bg;
  private DiskLruCache c;
  private byte[] ck = new byte[0];
  private Map<String, Long> hq;
  private boolean inited = true;
  private int mFlag;
  
  public wgv()
  {
    if (!bcj) {
      return;
    }
    aooa.a().init();
    String str = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.aio_gifplay.name());
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerator", 2, "DPC:" + str);
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("\\|");
      if (arrayOfString.length <= 5) {}
    }
    for (;;)
    {
      try
      {
        this.mFlag = Integer.parseInt(arrayOfString[4]);
        this.HE = (Integer.parseInt(arrayOfString[5]) * 1000 * 60 * 60);
        if (arrayOfString.length > 6) {
          this.bNe = Integer.parseInt(arrayOfString[6]);
        }
        i = j;
        if (this.bNe > 30)
        {
          this.bNe = 10;
          i = j;
        }
        if ((i == 0) && (QLog.isColorLevel())) {
          QLog.d("WebAccelerator", 2, "DPC not catch success[" + str + "]");
        }
        this.bg = new HashSet();
        this.hq = new HashMap();
        try
        {
          this.c = DiskLruCache.open(((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getApp().getCacheDir(), 1, 1, 1048576L);
          return;
        }
        catch (Exception localException1)
        {
          this.inited = false;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
        return;
      }
      catch (Exception localException2)
      {
        this.inited = false;
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
        }
      }
      int i = 0;
    }
  }
  
  private final boolean QW()
  {
    boolean bool = false;
    try
    {
      Object localObject1 = j();
      int j = ((SharedPreferences)localObject1).getInt("bankSize", 0);
      int i = j;
      if (j < this.bNd)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        i = j + 1;
        ((SharedPreferences.Editor)localObject1).putInt("bankSize", i);
        ((SharedPreferences.Editor)localObject1).commit();
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerator", 2, "shouldUseAccelerator:" + bool + "   " + i);
      }
      return bool;
    }
    finally {}
  }
  
  public static wgv a()
  {
    try
    {
      if (a == null) {
        a = new wgv();
      }
      wgv localwgv = a;
      return localwgv;
    }
    finally {}
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqzone://arouse/qqexplaunchlive").append("?ec_title=" + paramString1).append("&ec_room_init_type=" + paramInt1).append("&ec_room_from_type=" + paramInt2).append("&ec_room_owner_id = " + paramString2);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    paramContext.startActivity(localIntent);
  }
  
  public static boolean aI(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (aeou)aeif.a().o(158);
    if (paramContext != null) {}
    for (int i = paramContext.result;; i = 0)
    {
      QLog.d("WebAccelerator", 1, "hasUrlSsoCheckSwitchOn isSSOCheckValidate = " + i);
      if (i != 1) {
        break;
      }
      return true;
    }
  }
  
  public static boolean b(Context paramContext, String paramString, Intent paramIntent)
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZVideo", "qzone_eclive_livehost", "https://h5.qzone.qq.com/v2/audio-live/live/");
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString != null) && (paramString.contains(str1))) {
      try
      {
        Object localObject = Uri.parse(paramString);
        paramString = ((Uri)localObject).getQueryParameter("hostuin");
        str1 = ((Uri)localObject).getQueryParameter("roomid");
        String str2 = ((Uri)localObject).getQueryParameter("feedid");
        localObject = ((Uri)localObject).getQueryParameter("roomstatus");
        if (!isNumeric(str1))
        {
          QLog.d("WebAccelerator", 2, "room_id not number!");
          return false;
        }
        localStringBuilder.append("mqqzone://arouse/qqexplivevideo").append("?ec_room_id=" + str1).append("&ec_room_owner_id=" + paramString).append("&ec_room_from_type2").append("&ec_room_init_type=3");
        localIntent.setData(Uri.parse(localStringBuilder.toString()));
        paramContext.startActivity(localIntent);
        paramContext = new anop.a();
        paramContext.Uq = "kuolie_party";
        paramContext.Ur = "party_clk";
        paramContext.feedID = str2;
        paramContext.cfC = str1;
        paramContext.contentTitle = paramIntent.getStringExtra("title");
        paramContext.contentType = ((String)localObject);
        paramContext.cfE = paramString;
        paramContext.d1 = paramIntent.getStringExtra("friendUin");
        paramContext.d2 = "4";
        anop.a(null, paramContext);
        return true;
      }
      catch (Exception paramContext)
      {
        QLog.d("WebAccelerator", 1, "getQzoneVideoIntent parse url error!");
      }
    }
    return false;
  }
  
  public static void c(Context paramContext, Intent paramIntent, String paramString)
  {
    if (bcj)
    {
      ThreadManager.post(new WebAccelerator.1(paramString, paramIntent, paramContext), 8, null, false);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqzone://arouse/qqexplivevideo").append("?ec_title=" + paramString3).append("&ec_room_id=" + paramString1).append("&ec_content=" + paramString4).append("&ec_room_init_type=3").append("&ec_room_from_type=" + paramInt).append("&ec_room_owner_id=" + paramString2);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    paramContext.startActivity(localIntent);
  }
  
  private static boolean c(Context paramContext, String paramString, Intent paramIntent)
  {
    Object localObject1 = QzoneConfig.getInstance().getConfig("QZVideo", "qzone_eclive_livehost", "https://h5.qzone.qq.com/v2/audio-live/live/");
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith((String)localObject1))) {
      return b(paramContext, paramString, paramIntent);
    }
    Object localObject2 = QzoneConfig.getInstance().getConfig("QZVideo", "qzonelivevideo_livehost", "h5.qzone.qq.com/live/video/qzone/");
    int i = QzoneConfig.getInstance().getConfig("QZVideo", "module_jump_native", 1);
    Object localObject3 = QzoneConfig.getInstance().getConfig("Plato", "PlatoShareUrlPrefix", "plato.tswjs.org/share");
    int j = QzoneConfig.getInstance().getConfig("Plato", "qzoneplato_jump_native", 1);
    localObject1 = new Intent("android.intent.action.VIEW");
    ((Intent)localObject1).addCategory("android.intent.category.DEFAULT");
    ((Intent)localObject1).setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString != null) && (paramString.contains((CharSequence)localObject2)))
    {
      try
      {
        localObject3 = Uri.parse(paramString);
        String str = ((Uri)localObject3).getQueryParameter("stayin");
        if ((i != 1) || ((str != null) && (TextUtils.equals(str, "1"))))
        {
          QLog.d("WebAccelerator", 1, "is_native not available, jump to H5, " + paramString);
          paramString = new Intent(paramContext, QQBrowserActivity.class);
          paramString.putExtra("url", ((Uri)localObject3).toString());
          paramString.setData((Uri)localObject3);
          paramContext.startActivity(paramString);
          return true;
        }
        localObject3 = paramIntent.getStringExtra("self_uin");
        i = paramString.lastIndexOf((String)localObject2);
        localObject2 = paramString.substring(localObject2.length() + i, paramString.length()).split("/")[0];
        if ((localObject3 == null) || (localObject2 == null) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          break label735;
        }
        if (!isNumeric((String)localObject2))
        {
          QLog.d("WebAccelerator", 2, "room_id not number!");
          return false;
        }
        localObject2 = localStringBuilder.append("mqqzone://arouse/livevideo").append("?room=" + (String)localObject2).append("&uin=" + (String)localObject3).append("&video_play_source=12").append("&backup=" + URLEncoder.encode(paramString));
        localObject3 = new StringBuilder().append("&isEcLive=");
        if (paramIntent.getBooleanExtra("isEcLive", false)) {}
        for (paramString = "1";; paramString = "0")
        {
          ((StringBuilder)localObject2).append(paramString);
          ((Intent)localObject1).setData(Uri.parse(localStringBuilder.toString()));
          paramContext.startActivity((Intent)localObject1);
          return true;
        }
        if (TextUtils.isEmpty(paramString)) {
          break label733;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("WebAccelerator", 1, "getQzoneVideoIntent parse url error!");
        return false;
      }
    }
    else if (paramString.contains((CharSequence)localObject3))
    {
      if (j != 1) {
        return false;
      }
      try
      {
        paramIntent = aurr.getArguments(paramString.substring(paramString.lastIndexOf((String)localObject3) + ((String)localObject3).length() + 1));
        localStringBuilder.append("mqqzone://arouse/plato").append("?id=" + URLEncoder.encode((String)paramIntent.get("id")));
        if (!TextUtils.isEmpty((CharSequence)paramIntent.get("data"))) {
          localStringBuilder.append("&data=" + URLEncoder.encode((String)paramIntent.get("data")));
        }
        localStringBuilder.append("&url=" + URLEncoder.encode(paramString));
        ((Intent)localObject1).setData(Uri.parse(localStringBuilder.toString()));
        paramContext.startActivity((Intent)localObject1);
        return true;
      }
      catch (Exception paramContext)
      {
        QLog.d("WebAccelerator", 1, "arouse plato  parse url error!");
        return false;
      }
    }
    label733:
    return false;
    label735:
    return false;
  }
  
  public static final boolean d(AbsStructMsg paramAbsStructMsg)
  {
    return (paramAbsStructMsg != null) && ("web".equals(paramAbsStructMsg.mMsgAction)) && ((paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (!anqx.d((AbsShareMsg)paramAbsStructMsg));
  }
  
  public static boolean f(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramChatMessage.isSend())
    {
      if (!(paramChatMessage instanceof MessageForStructing)) {
        break label54;
      }
      AbsStructMsg localAbsStructMsg2 = ((MessageForStructing)paramChatMessage).structingMsg;
      AbsStructMsg localAbsStructMsg1 = localAbsStructMsg2;
      if (localAbsStructMsg2 == null) {
        localAbsStructMsg1 = anre.a(paramChatMessage.msgData);
      }
      if (!d(localAbsStructMsg1)) {
        break label106;
      }
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      label54:
      bool1 = bool2;
      if ((paramChatMessage instanceof MessageForText))
      {
        paramChatMessage = (MessageForText)paramChatMessage;
        bool1 = bool2;
        if (paramChatMessage.msg != null)
        {
          bool1 = bool2;
          if (!paramChatMessage.msg.equals(""))
          {
            bool1 = bool2;
            if (ho(paramChatMessage.msg) != null)
            {
              return true;
              label106:
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  private final boolean hasFlag(int paramInt)
  {
    return (this.mFlag & paramInt) == paramInt;
  }
  
  private final String hn(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      str1 = str2;
      localHttpURLConnection.setInstanceFollowRedirects(false);
      str1 = str2;
      localHttpURLConnection.connect();
      str1 = str2;
      paramString = localHttpURLConnection.getHeaderField("Location");
      str1 = paramString;
      QLog.d("WebAccelerator", 2, "code:" + localHttpURLConnection.getResponseCode());
    }
    catch (Exception localException)
    {
      do
      {
        paramString = str1;
      } while (!QLog.isColorLevel());
      QLog.e("WebAccelerator", 2, "doRedirect", localException);
    }
    return paramString;
    return str1;
  }
  
  public static String ho(@NonNull String paramString)
  {
    if (!paramString.contains("http")) {}
    Matcher localMatcher;
    do
    {
      return null;
      localMatcher = J.matcher(paramString);
    } while (!localMatcher.find());
    return paramString.substring(localMatcher.start(), localMatcher.end());
  }
  
  public static final boolean hy(String paramString)
  {
    return (paramString.startsWith("https://url.cn/")) || (paramString.startsWith("http%3A%2F%2Furl.cn%2F"));
  }
  
  public static boolean isNumeric(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public final boolean c(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (paramString1 != null)
    {
      if (!paramString1.equals("")) {
        break label31;
      }
      bool2 = bool3;
    }
    label31:
    do
    {
      return bool2;
      if ((this.inited) && (bcj) && (!paramString1.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) && (!paramString1.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) && (!hw(paramString1))) {
        break;
      }
      bool2 = bool3;
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "no need doSafeCheck");
    return false;
    for (;;)
    {
      Object localObject2;
      try
      {
        i = (int)SystemClock.uptimeMillis() % 2;
        localObject1 = svp.ce;
        if (i > -1)
        {
          localObject2 = localObject1[i];
          String str = aooa.a().o(0, false);
          localObject1 = localObject2;
          if (str != null)
          {
            localObject1 = localObject2;
            if (str.length() > 0) {
              localObject1 = ((String)localObject2).replaceFirst("http://[^/\\s]*/", str);
            }
          }
          localObject2 = wja.b();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("&u=");
          ((StringBuilder)localObject2).append(URLEncoder.encode(paramString1, "UTF-8"));
          ((StringBuilder)localObject2).append("&wap=3");
          switch (paramInt)
          {
          case 0: 
            ((StringBuilder)localObject2).append("&qq-pf-to=mqq.temporaryc2c");
            if (!TextUtils.isEmpty(paramString2)) {
              ((StringBuilder)localObject2).append("&uin=").append(paramString2);
            }
            if (!TextUtils.isEmpty(paramString3)) {
              ((StringBuilder)localObject2).append("&originuin=").append(paramString3);
            }
            localObject1 = ((StringBuilder)localObject2).toString();
            paramString2 = hn((String)localObject1);
            paramString3 = j();
            paramInt = paramString3.getInt("load_safeCheck", 0);
            paramString3.edit().putInt("load_safeCheck", paramInt + 1).commit();
            if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(paramString1))) {
              break label695;
            }
            paramString2 = null;
            paramString3 = null;
            localObject2 = Md5Utils.getMD5(paramString1);
            paramString1 = paramString3;
          }
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        int i;
        Object localObject1;
        bool2 = bool3;
      }
      try
      {
        paramString3 = this.c.edit((String)localObject2);
        if (paramString3 == null) {
          break label555;
        }
        paramString1 = paramString3;
        paramString2 = paramString3;
        paramString3.set(0, SystemClock.uptimeMillis() + "");
        paramString1 = paramString3;
        paramString2 = paramString3;
        paramString3.commit();
        bool1 = true;
      }
      catch (IOException paramString2)
      {
        if (!QLog.isColorLevel()) {
          break label610;
        }
        QLog.d("WebAccelerator", 2, "doSafeCheck", paramString2);
        bool1 = bool4;
        if (paramString1 == null) {
          continue;
        }
        try
        {
          paramString1.abort();
          bool1 = bool4;
        }
        catch (IOException paramString1)
        {
          bool1 = bool4;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("WebAccelerator", 2, "doSafeCheck", paramString1);
        bool1 = bool4;
        continue;
      }
      catch (Exception paramString1)
      {
        bool2 = bool3;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebAccelerator", 2, "doSafeCheck:" + (String)localObject1 + "   " + bool1);
      return bool1;
      i = 0;
      continue;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.c2c");
      continue;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("WebAccelerator", 2, "buildUrl fail", paramString1);
      return false;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.group");
      continue;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.discussion");
      continue;
      label555:
      boolean bool1 = bool4;
      paramString1 = paramString3;
      paramString2 = paramString3;
      if (QLog.isColorLevel())
      {
        paramString1 = paramString3;
        paramString2 = paramString3;
        QLog.e("WebAccelerator", 2, "fail to open cache.editor");
        bool1 = bool4;
        continue;
        label610:
        if (paramString2 == null) {
          break;
        }
        try
        {
          paramString2.abort();
          return false;
        }
        catch (IOException paramString1)
        {
          bool2 = bool3;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("WebAccelerator", 2, "doSafeCheck", paramString1);
        return false;
        label695:
        bool1 = bool4;
        if (QLog.isColorLevel())
        {
          QLog.d("WebAccelerator", 2, "doRedirect get fail url");
          bool1 = bool4;
        }
      }
    }
  }
  
  public final void h(String arg1, int paramInt, String paramString2, String paramString3)
  {
    int i = 2;
    if ((TextUtils.isEmpty(???)) || (!bcj)) {}
    String str;
    do
    {
      return;
      str = ???.trim();
      synchronized (this.ck)
      {
        if (this.bg.contains(str)) {
          return;
        }
      }
      this.bg.add(str);
      switch (jqc.getNetWorkType())
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "unknown network type , not use accelerator");
    return;
    i = 4;
    if ((hasFlag(i)) && (QW())) {
      if (!hasFlag(16)) {
        break label225;
      }
    }
    label225:
    for (??? = hm(str);; ??? = str)
    {
      if (hasFlag(32)) {
        c(???, paramInt, paramString2, paramString3);
      }
      if (hasFlag(64)) {
        hx(???);
      }
      synchronized (this.ck)
      {
        this.bg.remove(str);
        return;
      }
      i = 8;
      break;
      i = 1;
      break;
    }
  }
  
  /* Error */
  public final String hl(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_1
    //   12: ifnull +13 -> 25
    //   15: aload_1
    //   16: ldc_w 586
    //   19: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +7 -> 29
    //   25: aload_1
    //   26: astore_2
    //   27: aload_2
    //   28: areturn
    //   29: aload 4
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 69	wgv:inited	Z
    //   36: ifeq -9 -> 27
    //   39: aload 4
    //   41: astore_2
    //   42: getstatic 49	wgv:bcj	Z
    //   45: ifeq -18 -> 27
    //   48: aload_1
    //   49: invokestatic 707	com/tencent/smtt/utils/Md5Utils:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 193	wgv:c	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   57: aload_2
    //   58: invokevirtual 782	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +17 -> 82
    //   68: aload 4
    //   70: astore_2
    //   71: aload 6
    //   73: astore 5
    //   75: aload 4
    //   77: iconst_0
    //   78: invokevirtual 787	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   81: astore_3
    //   82: aload 4
    //   84: astore_2
    //   85: aload_3
    //   86: astore 5
    //   88: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +40 -> 131
    //   94: aload 4
    //   96: astore_2
    //   97: aload_3
    //   98: astore 5
    //   100: ldc 103
    //   102: iconst_2
    //   103: invokestatic 147	wja:b	()Ljava/lang/StringBuilder;
    //   106: ldc_w 789
    //   109: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 228
    //   118: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_3
    //   132: astore_2
    //   133: aload 4
    //   135: ifnull -108 -> 27
    //   138: aload 4
    //   140: invokevirtual 792	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   143: aload_3
    //   144: areturn
    //   145: astore_3
    //   146: aconst_null
    //   147: astore 4
    //   149: aload 5
    //   151: astore_1
    //   152: aload 4
    //   154: astore_2
    //   155: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +16 -> 174
    //   161: aload 4
    //   163: astore_2
    //   164: ldc 103
    //   166: iconst_2
    //   167: ldc_w 794
    //   170: aload_3
    //   171: invokestatic 624	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_1
    //   175: astore_2
    //   176: aload 4
    //   178: ifnull -151 -> 27
    //   181: aload 4
    //   183: invokevirtual 792	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   186: aload_1
    //   187: areturn
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_2
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 792	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: goto -11 -> 191
    //   205: astore_3
    //   206: aload 5
    //   208: astore_1
    //   209: goto -57 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	wgv
    //   0	212	1	paramString	String
    //   26	170	2	localObject1	Object
    //   1	143	3	str	String
    //   145	26	3	localIOException1	IOException
    //   205	1	3	localIOException2	IOException
    //   9	173	4	localSnapshot	DiskLruCache.Snapshot
    //   3	204	5	localObject2	Object
    //   6	66	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   53	63	145	java/io/IOException
    //   53	63	188	finally
    //   75	82	201	finally
    //   88	94	201	finally
    //   100	131	201	finally
    //   155	161	201	finally
    //   164	174	201	finally
    //   75	82	205	java/io/IOException
    //   88	94	205	java/io/IOException
    //   100	131	205	java/io/IOException
  }
  
  public final String hm(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    Object localObject2;
    do
    {
      DiskLruCache.Editor localEditor1;
      for (;;)
      {
        return paramString;
        if ((this.inited) && (bcj) && (hy(paramString)))
        {
          Object localObject1 = hl(paramString);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label371;
          }
          String str1 = hn(paramString);
          if ((str1 != null) && (!str1.equals("")))
          {
            localObject1 = j();
            int i = ((SharedPreferences)localObject1).getInt("load_shortLink", 0);
            ((SharedPreferences)localObject1).edit().putInt("load_shortLink", i + 1).commit();
            DiskLruCache.Editor localEditor2 = null;
            localObject2 = null;
            localObject1 = localObject2;
            localEditor1 = localEditor2;
            try
            {
              String str2 = Md5Utils.getMD5(paramString);
              localObject1 = localObject2;
              localEditor1 = localEditor2;
              localEditor2 = this.c.edit(str2);
              if (localEditor2 != null)
              {
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localEditor2.set(0, str1);
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localEditor2.commit();
              }
              for (;;)
              {
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localObject2 = str1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                QLog.d("WebAccelerator", 2, "doShortLink:" + paramString + "   " + str1);
                localObject2 = str1;
                break;
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                if (QLog.isColorLevel())
                {
                  localObject1 = localEditor2;
                  localEditor1 = localEditor2;
                  QLog.d("WebAccelerator", 2, "fail to open cache.Editor");
                }
              }
              if (localEditor1 == null) {}
            }
            catch (IOException paramString)
            {
              if (QLog.isColorLevel()) {
                QLog.e("WebAccelerator", 2, "doShortLink", paramString);
              }
              localObject2 = str1;
              if (localObject1 == null) {
                break label371;
              }
              try
              {
                ((DiskLruCache.Editor)localObject1).abort();
                localObject2 = str1;
              }
              catch (IOException paramString)
              {
                localObject2 = str1;
                if (!QLog.isColorLevel()) {
                  break label371;
                }
              }
              QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", paramString);
              localObject2 = str1;
            }
            catch (Exception localException) {}
          }
        }
      }
      try
      {
        localEditor1.abort();
        return paramString;
      }
      catch (IOException localIOException) {}
    } while (!QLog.isColorLevel());
    QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", localIOException);
    return paramString;
    label371:
    return localObject2;
  }
  
  public final boolean hw(String paramString)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      if (!paramString.equals("")) {
        break label28;
      }
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      label28:
      bool2 = bool1;
      if (!this.inited) {
        continue;
      }
      bool2 = bool1;
      if (!bcj) {
        continue;
      }
      Object localObject3 = null;
      Object localObject1 = null;
      String str = Md5Utils.getMD5(paramString);
      boolean bool3 = bool5;
      try
      {
        DiskLruCache.Snapshot localSnapshot = this.c.get(str);
        bool1 = bool4;
        if (localSnapshot != null)
        {
          bool3 = bool5;
          localObject1 = localSnapshot;
          localObject3 = localSnapshot;
        }
        try
        {
          l = Long.parseLong(localSnapshot.getString(0));
          bool3 = bool5;
          localObject1 = localSnapshot;
          localObject3 = localSnapshot;
          if (SystemClock.uptimeMillis() - l < this.HE)
          {
            bool1 = true;
            bool3 = bool1;
            localObject1 = localSnapshot;
            localObject3 = localSnapshot;
            if (QLog.isColorLevel())
            {
              bool3 = bool1;
              localObject1 = localSnapshot;
              localObject3 = localSnapshot;
              QLog.d("WebAccelerator", 2, "isSafeCheck:" + paramString + "   " + bool1);
            }
            bool2 = bool1;
            return bool1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            long l = 0L;
            continue;
            bool3 = bool5;
            localObject2 = localSnapshot;
            localObject3 = localSnapshot;
            this.c.remove(str);
            bool1 = bool4;
          }
        }
      }
      catch (IOException paramString)
      {
        Object localObject2;
        localObject3 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject3 = localObject2;
          QLog.e("WebAccelerator", 2, "isSafeCheck fail", paramString);
        }
        bool2 = bool3;
        return bool3;
      }
      finally
      {
        if (localObject3 != null) {
          localObject3.close();
        }
      }
    }
  }
  
  public final boolean hx(String paramString)
  {
    bool3 = false;
    bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      if (!paramString.equals("")) {
        break label25;
      }
      bool2 = bool1;
    }
    label25:
    do
    {
      do
      {
        return bool2;
        bool2 = bool1;
      } while (!bcj);
      String str = anqx.getDomain(paramString);
      try
      {
        InetAddress.getByName(str);
        bool1 = true;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        for (;;)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.e("WebAccelerator", 2, "doDNS", localUnknownHostException);
            bool1 = bool3;
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.e("WebAccelerator", 2, "doDNS", localSecurityException);
            bool1 = bool3;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "doDNS:" + paramString + "   " + bool1);
    return bool1;
  }
  
  /* Error */
  public final SharedPreferences j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 845	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: ldc 103
    //   7: iconst_0
    //   8: invokevirtual 849	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11: astore 5
    //   13: aload 5
    //   15: ldc_w 851
    //   18: lconst_0
    //   19: invokeinterface 855 4 0
    //   24: lstore_3
    //   25: lload_3
    //   26: lconst_0
    //   27: lcmp
    //   28: ifne +39 -> 67
    //   31: aload 5
    //   33: invokeinterface 212 1 0
    //   38: astore 6
    //   40: aload 6
    //   42: ldc_w 851
    //   45: invokestatic 860	java/lang/System:currentTimeMillis	()J
    //   48: invokeinterface 864 4 0
    //   53: pop
    //   54: aload 6
    //   56: invokeinterface 221 1 0
    //   61: pop
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 5
    //   66: areturn
    //   67: invokestatic 860	java/lang/System:currentTimeMillis	()J
    //   70: lload_3
    //   71: lsub
    //   72: ldc2_w 64
    //   75: lcmp
    //   76: ifle -14 -> 62
    //   79: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +12 -> 94
    //   85: ldc 103
    //   87: iconst_2
    //   88: ldc_w 866
    //   91: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload 5
    //   96: invokeinterface 212 1 0
    //   101: astore 6
    //   103: aload 6
    //   105: ldc_w 851
    //   108: invokestatic 860	java/lang/System:currentTimeMillis	()J
    //   111: invokeinterface 864 4 0
    //   116: pop
    //   117: aload 6
    //   119: ldc 202
    //   121: iconst_0
    //   122: invokeinterface 218 3 0
    //   127: pop
    //   128: aload 6
    //   130: ldc_w 868
    //   133: iconst_0
    //   134: invokeinterface 218 3 0
    //   139: pop
    //   140: aload_0
    //   141: getfield 161	wgv:hq	Ljava/util/Map;
    //   144: invokeinterface 871 1 0
    //   149: aload 5
    //   151: ldc_w 800
    //   154: iconst_0
    //   155: invokeinterface 208 3 0
    //   160: istore_1
    //   161: aload 6
    //   163: ldc_w 800
    //   166: iconst_0
    //   167: invokeinterface 218 3 0
    //   172: pop
    //   173: aload 5
    //   175: ldc_w 873
    //   178: iconst_0
    //   179: invokeinterface 208 3 0
    //   184: istore_2
    //   185: aload 6
    //   187: ldc_w 873
    //   190: iconst_0
    //   191: invokeinterface 218 3 0
    //   196: pop
    //   197: iload_1
    //   198: ifgt +7 -> 205
    //   201: iload_2
    //   202: ifle +93 -> 295
    //   205: new 158	java/util/HashMap
    //   208: dup
    //   209: iconst_4
    //   210: invokespecial 876	java/util/HashMap:<init>	(I)V
    //   213: astore 7
    //   215: aload 7
    //   217: ldc_w 878
    //   220: new 105	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   227: iload_1
    //   228: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 586
    //   234: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 882	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   243: pop
    //   244: aload 7
    //   246: ldc_w 884
    //   249: new 105	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   256: iload_2
    //   257: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: ldc_w 586
    //   263: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokevirtual 882	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   272: pop
    //   273: invokestatic 890	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   276: invokestatic 895	anpc:a	(Landroid/content/Context;)Lanpc;
    //   279: aconst_null
    //   280: ldc_w 897
    //   283: iconst_0
    //   284: lconst_0
    //   285: lconst_0
    //   286: aload 7
    //   288: ldc_w 586
    //   291: iconst_0
    //   292: invokevirtual 901	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   295: aload 5
    //   297: ldc_w 702
    //   300: iconst_0
    //   301: invokeinterface 208 3 0
    //   306: istore_1
    //   307: aload 6
    //   309: ldc_w 702
    //   312: iconst_0
    //   313: invokeinterface 218 3 0
    //   318: pop
    //   319: aload 5
    //   321: ldc_w 903
    //   324: iconst_0
    //   325: invokeinterface 208 3 0
    //   330: istore_2
    //   331: aload 6
    //   333: ldc_w 903
    //   336: iconst_0
    //   337: invokeinterface 218 3 0
    //   342: pop
    //   343: iload_1
    //   344: ifgt +7 -> 351
    //   347: iload_2
    //   348: ifle +93 -> 441
    //   351: new 158	java/util/HashMap
    //   354: dup
    //   355: iconst_4
    //   356: invokespecial 876	java/util/HashMap:<init>	(I)V
    //   359: astore 7
    //   361: aload 7
    //   363: ldc_w 878
    //   366: new 105	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   373: iload_1
    //   374: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: ldc_w 586
    //   380: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokevirtual 882	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   389: pop
    //   390: aload 7
    //   392: ldc_w 884
    //   395: new 105	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   402: iload_2
    //   403: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: ldc_w 586
    //   409: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokevirtual 882	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   418: pop
    //   419: invokestatic 890	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   422: invokestatic 895	anpc:a	(Landroid/content/Context;)Lanpc;
    //   425: aconst_null
    //   426: ldc_w 905
    //   429: iconst_0
    //   430: lconst_0
    //   431: lconst_0
    //   432: aload 7
    //   434: ldc_w 586
    //   437: iconst_0
    //   438: invokevirtual 901	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   441: aload 6
    //   443: invokeinterface 221 1 0
    //   448: pop
    //   449: goto -387 -> 62
    //   452: astore 5
    //   454: aload_0
    //   455: monitorexit
    //   456: aload 5
    //   458: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	wgv
    //   160	214	1	i	int
    //   184	219	2	j	int
    //   24	47	3	l	long
    //   11	309	5	localSharedPreferences	SharedPreferences
    //   452	5	5	localObject	Object
    //   38	404	6	localEditor	SharedPreferences.Editor
    //   213	220	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   2	25	452	finally
    //   31	62	452	finally
    //   67	94	452	finally
    //   94	197	452	finally
    //   205	295	452	finally
    //   295	343	452	finally
    //   351	441	452	finally
    //   441	449	452	finally
  }
  
  public final void xf(String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("WebAccelerator", 0);
      int i = localSharedPreferences.getInt(paramString, 0);
      if (i > 0) {
        localSharedPreferences.edit().putInt(paramString, i - 1).commit();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgv
 * JD-Core Version:    0.7.0.1
 */