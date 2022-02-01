import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.FunctionModuleConfigManager.3;
import com.tencent.mobileqq.search.model.BusinessGroupWord.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amjm
  implements Manager
{
  public static HashMap<String, List<BusinessGroupWord.c>> mQ = new HashMap();
  public static HashMap<String, String> mR = new HashMap();
  private static ArrayList<Integer> zx = new ArrayList();
  public amqg a;
  QQAppInterface app;
  public ampx b;
  protected Handler mHandler;
  
  static
  {
    zx.add(Integer.valueOf(10));
    zx.add(Integer.valueOf(12));
    zx.add(Integer.valueOf(13));
    zx.add(Integer.valueOf(14));
    zx.add(Integer.valueOf(15));
    zx.add(Integer.valueOf(17));
    zx.add(Integer.valueOf(18));
    zx.add(Integer.valueOf(19));
    zx.add(Integer.valueOf(20));
    zx.add(Integer.valueOf(22));
    zx.add(Integer.valueOf(36));
    zx.add(Integer.valueOf(43));
    zx.add(Integer.valueOf(46));
    zx.add(Integer.valueOf(51));
    zx.add(Integer.valueOf(52));
    zx.add(Integer.valueOf(53));
    zx.add(Integer.valueOf(54));
    zx.add(Integer.valueOf(55));
    zx.add(Integer.valueOf(56));
    zx.add(Integer.valueOf(57));
    zx.add(Integer.valueOf(58));
    zx.add(Integer.valueOf(64));
    zx.add(Integer.valueOf(65));
    zx.add(Integer.valueOf(109));
  }
  
  public amjm(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public static String M(List<Long> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((Long)paramList.next()).longValue()).append("&");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfLong[i]).append("&");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private List<amjm.a> gc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.FunctionModuleConfigManager", 2, "getFunctionItemList !!! no data,just use local data");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new amjm.a(1, "QQ会员", "https://pub.idqqimg.com/pc/misc/files/20170321/a89cb3ba283040058367d36b0a1f5aad.png", "https://h5.vip.qq.com/p/sonic/mc/vipcenterv5?_bid=193&_wvSb=1&asyncMode=3&_wwv=64&_nav_alpha=true&_wwv=4&pay_src=10&platform=1&type=20001&networkInfo=1&status=-1&number=0&path=100400"));
    localArrayList.add(new amjm.a(2, "QQ钱包", "https://pub.idqqimg.com/pc/misc/files/20170310/e3f2c05439d745c6b39505c757468bcc.png", ""));
    localArrayList.add(new amjm.a(3, acfp.m(2131706685), "https://pub.idqqimg.com/pc/misc/files/20170321/f8b7922d137b4174a32408c2a874d439.png", "https://zb.vip.qq.com/sonic/index?_wv=16778243&asyncMode=3&_wwv=68&_nav_txtclr=ffffff&_nav_titleclr=ffffff&btest=1"));
    localArrayList.add(new amjm.a(4, acfp.m(2131706670), "https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", ""));
    localArrayList.add(new amjm.a(5, acfp.m(2131706669), "https://pub.idqqimg.com/pc/misc/files/20170310/a601d5f50db940ee9cf8d30e915671ce.png", ""));
    localArrayList.add(new amjm.a(6, acfp.m(2131706687), "https://pub.idqqimg.com/pc/misc/files/20170310/2490d524bbf84417929137e35d93b0c2.png", ""));
    localArrayList.add(new amjm.a(7, "QQ达人", "https://pub.idqqimg.com/pc/misc/files/20170321/b38bddc6e6a24a1eb5253f6505fb349e.png", "https://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297"));
    localArrayList.add(new amjm.a(8, acfp.m(2131706673), "https://pub.idqqimg.com/pc/misc/files/20170310/5765374679c8415894d31ff020f5558a.png", ""));
    localArrayList.add(new amjm.a(9, "QQ空间", "https://pub.idqqimg.com/pc/misc/files/20170310/5aaef4e89ac540ff9d0e1a4c3f0aee65.png", ""));
    localArrayList.add(new amjm.a(10, acfp.m(2131706672), "https://pub.idqqimg.com/pc/misc/files/20170310/c88ccef2e6d44e3f94357ac7cecd04b4.png", ""));
    localArrayList.add(new amjm.a(11, acfp.m(2131706689), "https://pub.idqqimg.com/pc/misc/files/20170310/c83498c5dfd54489af3147b027c091b0.png", "https://cmshow.qq.com/apollo/html/intro.html?_wv=3&adtag=search"));
    localArrayList.add(new amjm.a(12, acfp.m(2131706668), "https://pub.idqqimg.com/pc/misc/files/20170310/e8310f3460fa41b487b5922a0df671c5.png", "https://buluo.qq.com/mobile/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&plg_auth=1"));
    localArrayList.add(new amjm.a(13, acfp.m(2131706684), "https://pub.idqqimg.com/pc/misc/files/20170310/ee1b6352ec7340bba07949a15b9adc19.png", "https://m.gamecenter.qq.com/directout/index?st=1489458002385&uin=3043939851&status=-1&number=0&path=489&plat=qq&gamecenter=1&_wv=1031&gc_version=2&ADTAG=neisou&_nav_bgclr=18b4ed&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=255&asyncMode=3&_wwv=64"));
    localArrayList.add(new amjm.a(14, plr.asY, "https://pub.idqqimg.com/pc/misc/files/20170310/6a09f5f91fff46e0ada71ff7b2a667f4.png", ""));
    localArrayList.add(new amjm.a(15, "QQ看点", "https://sqimg.qq.com/qq_product_operations/kan/images/QQkandian_symbol.png", ""));
    localArrayList.add(new amjm.a(16, acfp.m(2131706696), "https://pub.idqqimg.com/pc/misc/files/20170310/43121a2425204707868e3e271a9969a7.png", "https://wq.jd.com/mcoss/wxmall/home?ptype=4&_wv=67113987&fetchCode=1"));
    localArrayList.add(new amjm.a(17, acfp.m(2131706688), "https://pub.idqqimg.com/pc/misc/files/20170310/cd28b2e8ba7f4d9e98a2d244ced31789.png", ""));
    localArrayList.add(new amjm.a(18, acfp.m(2131706683), "https://pub.idqqimg.com/pc/misc/files/20170310/6727610036b648c3bc3aaa4d0c047ec3.png", ""));
    localArrayList.add(new amjm.a(19, acfp.m(2131706677), "https://pub.idqqimg.com/pc/misc/files/20170310/ee8e56925bb646f9b6ae831afcbb0aca.png", "https://y.qq.com/m/mqq/music/index.html?plg_auth=1&plg_dev=1"));
    localArrayList.add(new amjm.a(20, "NOW直播", "https://pub.idqqimg.com/pc/misc/files/20170321/fd790f79230e4776a33c608c9557ae0b.png", "https://now.qq.com/qq/hall.html?_bid=2374&_wv=16778245&from=1"));
    localArrayList.add(new amjm.a(21, acfp.m(2131706690), "https://pub.idqqimg.com/pc/misc/files/20170321/5657f0d4fd6f49858d10bca7451d91a8.png", "https://imgcache.qq.com/zzapp/chwl/prev/html/shop.html?max_age=0&_wv=3"));
    localArrayList.add(new amjm.a(22, acfp.m(2131706692), "https://pub.idqqimg.com/pc/misc/files/20170310/0291fa0854954779a9eeeb9d843f0157.png", "https://tcsh.qq.com/58/html/home.html?_wv=1027&plg_auth=1&plg_dev=1"));
    localArrayList.add(new amjm.a(23, acfp.m(2131706674), "https://pub.idqqimg.com/pc/misc/files/20170310/3a4608e81a5e4158a07d92e4ae8a7b7a.png", "https://info.3g.qq.com/g/s?aid=index&g_ut=3&_wv=1&g_f=22580&plg_auth=1&plg_dev=1"));
    localArrayList.add(new amjm.a(24, acfp.m(2131706695), "https://pub.idqqimg.com/pc/misc/files/20170310/35fa7f030fe44507a9732f6d034677e3.png", "https://yundong.qq.com/?_wv=2172899&asyncMode=1&crashFrom=40501"));
    localArrayList.add(new amjm.a(25, acfp.m(2131706680), "https://pub.idqqimg.com/pc/misc/files/20170310/26cee3d3d78a4c7e8be121cce7ce1df5.png", "https://m.ke.qq.com/index.html?_bid=167&_wv=5121"));
    localArrayList.add(new amjm.a(26, acfp.m(2131706682), "https://pub.idqqimg.com/pc/misc/files/20170321/30e65ca21a2a42529c90a83a46630ce1.png", "https://fudao.qq.com/rn2web/coursebreak.html?_wv=5123&_bid=2356&n_r=1&from=dongtai&plg_auth=1&plg_dev=1"));
    localArrayList.add(new amjm.a(27, acfp.m(2131706678), "https://pub.idqqimg.com/pc/misc/files/20170310/f668a11f690c49bc82210b5773e9f27b.png", ""));
    localArrayList.add(new amjm.a(28, acfp.m(2131696154), "https://pub.idqqimg.com/pc/misc/files/20170310/25b9983be4dd4092bf03f6cac00e0095.png", ""));
    localArrayList.add(new amjm.a(30, acfp.m(2131706681), "https://pub.idqqimg.com/pc/misc/files/20170321/831513c842904cdda53780b36110478e.png", ""));
    localArrayList.add(new amjm.a(31, acfp.m(2131706675), "https://pub.idqqimg.com/pc/misc/files/20170310/9f15b7bd262c42b28a285e3e12a49808.png", ""));
    localArrayList.add(new amjm.a(32, acfp.m(2131706679), "https://pub.idqqimg.com/pc/misc/files/20170310/4fedf2b96f4d4acda93fe619d9cb925e.png", ""));
    localArrayList.add(new amjm.a(33, acfp.m(2131706691), "https://pub.idqqimg.com/pc/misc/files/20170321/9cd89480b0284a27a8938318dbc897df.png", ""));
    localArrayList.add(new amjm.a(35, acfp.m(2131721297), "https://pub.idqqimg.com/pc/misc/files/20170310/6f2aad7545014d13a230cb237390b567.png", ""));
    localArrayList.add(new amjm.a(36, acfp.m(2131706693), "https://pub.idqqimg.com/pc/misc/files/20170310/43121a2425204707868e3e271a9969a7.png", ""));
    localArrayList.add(new amjm.a(37, acfp.m(2131692100), "https://pub.idqqimg.com/pc/misc/files/20170310/5cba92c8405749bbb66d13cd2f42c7b5.png", ""));
    localArrayList.add(new amjm.a(38, acfp.m(2131706676), "https://pub.idqqimg.com/pc/misc/files/20170322/3152361128324bfd97776b10c803f73c.png", ""));
    localArrayList.add(new amjm.a(39, "QQ红包", "https://pub.idqqimg.com/pc/misc/files/20170310/96d80f6c7cef4e3aa8d45237cc301295.png", "https://mqq.tenpay.com/mqq/hongbao/index.shtml?_wv=2098179&_wvNb=D12928&f=17&_vacf=qw&_wvNt=FFFFFF&_wvSb=1"));
    localArrayList.add(new amjm.a(40, "我的其他QQ帐号", "https://pub.idqqimg.com/pc/misc/files/20170510/e74d00a108ba43e8b7e324ad425dc85c.png", ""));
    localArrayList.add(new amjm.a(41, acfp.m(2131706694), "https://pub.idqqimg.com/pc/misc/files/20170510/9a58b5bdda80403cb3a2923d8f96f519.png", ""));
    localArrayList.add(new amjm.a(43, acfp.m(2131716887), "https://pub.idqqimg.com/pc/misc/files/20170510/445bcc0024c24add97831ec6e987d5a8.png", ""));
    localArrayList.add(new amjm.a(44, acfp.m(2131706671), "https://pub.idqqimg.com/pc/misc/files/20170510/439579e680cc45789586480ff897aad2.png", ""));
    return localArrayList;
  }
  
  /* Error */
  private String y(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: ldc 147
    //   6: astore_1
    //   7: aload_1
    //   8: areturn
    //   9: new 314	java/io/BufferedReader
    //   12: dup
    //   13: new 316	java/io/InputStreamReader
    //   16: dup
    //   17: new 318	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 321	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: ldc_w 323
    //   28: invokespecial 326	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   31: invokespecial 329	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_3
    //   35: ldc 147
    //   37: astore_2
    //   38: aload_3
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 332	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 4
    //   46: aload 4
    //   48: ifnull +32 -> 80
    //   51: aload_3
    //   52: astore_1
    //   53: new 72	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   60: aload_2
    //   61: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 4
    //   66: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 4
    //   74: aload 4
    //   76: astore_2
    //   77: goto -39 -> 38
    //   80: aload_3
    //   81: astore_1
    //   82: aload_3
    //   83: invokevirtual 335	java/io/BufferedReader:close	()V
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: ifnull -82 -> 7
    //   92: aload_3
    //   93: invokevirtual 335	java/io/BufferedReader:close	()V
    //   96: aload_2
    //   97: areturn
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 338	java/io/IOException:printStackTrace	()V
    //   103: aload_2
    //   104: areturn
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_3
    //   109: ldc 147
    //   111: astore_2
    //   112: aload_3
    //   113: astore_1
    //   114: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +16 -> 133
    //   120: aload_3
    //   121: astore_1
    //   122: ldc 125
    //   124: iconst_2
    //   125: aload 4
    //   127: invokevirtual 339	java/io/IOException:toString	()Ljava/lang/String;
    //   130: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_2
    //   134: astore_1
    //   135: aload_3
    //   136: ifnull -129 -> 7
    //   139: aload_3
    //   140: invokevirtual 335	java/io/BufferedReader:close	()V
    //   143: aload_2
    //   144: areturn
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 338	java/io/IOException:printStackTrace	()V
    //   150: aload_2
    //   151: areturn
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 335	java/io/BufferedReader:close	()V
    //   163: aload_2
    //   164: athrow
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 338	java/io/IOException:printStackTrace	()V
    //   170: goto -7 -> 163
    //   173: astore_2
    //   174: goto -19 -> 155
    //   177: astore 4
    //   179: goto -67 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	amjm
    //   0	182	1	paramArrayOfByte	byte[]
    //   37	114	2	localObject1	Object
    //   152	12	2	localObject2	Object
    //   173	1	2	localObject3	Object
    //   34	106	3	localBufferedReader	java.io.BufferedReader
    //   44	31	4	str	String
    //   105	21	4	localIOException1	java.io.IOException
    //   177	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   92	96	98	java/io/IOException
    //   9	35	105	java/io/IOException
    //   139	143	145	java/io/IOException
    //   9	35	152	finally
    //   159	163	165	java/io/IOException
    //   40	46	173	finally
    //   53	74	173	finally
    //   82	86	173	finally
    //   114	120	173	finally
    //   122	133	173	finally
    //   40	46	177	java/io/IOException
    //   53	74	177	java/io/IOException
    //   82	86	177	java/io/IOException
  }
  
  public void PH(String paramString)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("Q.uniteSearch.FunctionModuleConfigManager", 0);
    localSharedPreferences.edit().putString("content", paramString);
    localSharedPreferences.edit().commit();
  }
  
  public void PI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.equals(yX())) {
      return;
    }
    ThreadManager.post(new FunctionModuleConfigManager.3(this, paramString), 8, null, false);
  }
  
  public void PJ(String paramString)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("Q.uniteSearch.FunctionModuleConfigManager", 0);
    localSharedPreferences.edit().putString("contentUrl", paramString);
    localSharedPreferences.edit().commit();
  }
  
  public List<amjm.a> gb()
  {
    Object localObject1 = this.app.getApp().getSharedPreferences("Q.uniteSearch.FunctionModuleConfigManager", 0).getString("content", "");
    ArrayList localArrayList1 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int j;
      try
      {
        localObject1 = new JSONObject((String)localObject1).optJSONArray("functionList");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          break label268;
        }
        int i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label268;
        }
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        int k = ((JSONObject)localObject2).optInt("fid");
        String str1 = ((JSONObject)localObject2).optString("name");
        String str2 = ((JSONObject)localObject2).optString("headUrl");
        String str3 = ((JSONObject)localObject2).optString("androidJumpUrl");
        localObject2 = ((JSONObject)localObject2).optJSONArray("tag");
        ArrayList localArrayList2 = new ArrayList();
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            String str4 = ((JSONArray)localObject2).optString(j);
            if (TextUtils.isEmpty(str4)) {
              break label271;
            }
            localArrayList2.add(str4);
            break label271;
          }
        }
        localArrayList1.add(new amjm.a(k, str1, str2, str3, localArrayList2));
        i += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break label268;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.uniteSearch.FunctionModuleConfigManager", 2, localJSONException, new Object[0]);
        }
        return null;
      }
      QLog.i("Q.uniteSearch.FunctionModuleConfigManager", 2, "parseServletConfigContent param configContent is null");
      label268:
      return localJSONException;
      label271:
      j += 1;
    }
  }
  
  public void onDestroy() {}
  
  public List<ampx> v(String paramString, int paramInt)
  {
    Object localObject1 = gb();
    if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
      localObject1 = gc();
    }
    for (;;)
    {
      ArrayList localArrayList1 = new ArrayList(((List)localObject1).size() + 1);
      ArrayList localArrayList2 = new ArrayList(((List)localObject1).size() + 1);
      ArrayList localArrayList3 = new ArrayList();
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        amjm.a locala = (amjm.a)((Iterator)localObject2).next();
        int[] arrayOfInt = amxk.a(paramString, locala.name, true);
        if ((arrayOfInt == null) || (arrayOfInt.length < 3) || (arrayOfInt[0] <= -1) || ((awit.Vs()) && (locala.dCw == 15)) || (!anwa.aze()) || (!zx.contains(Integer.valueOf(locala.dCw)))) {}
      }
      localObject1 = ((List)localObject1).iterator();
      label475:
      label476:
      for (;;)
      {
        boolean bool;
        int i;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (amjm.a)((Iterator)localObject1).next();
          if ((((amjm.a)localObject2).tags == null) || (((amjm.a)localObject2).tags.size() == 0)) {
            continue;
          }
          bool = false;
          i = 0;
          label234:
          if (i >= ((amjm.a)localObject2).tags.size()) {
            break label475;
          }
          bool = paramString.contains((CharSequence)((amjm.a)localObject2).tags.get(i));
          if (!bool) {}
        }
        for (;;)
        {
          if ((!bool) || ((awit.Vs()) && (((amjm.a)localObject2).dCw == 15)) || ((anwa.aze()) && (zx.contains(Integer.valueOf(((amjm.a)localObject2).dCw))))) {
            break label476;
          }
          localArrayList3.add(new amow(paramString, ((amjm.a)localObject2).dCw + "", ((amjm.a)localObject2).name, ((amjm.a)localObject2).headUrl, ((amjm.a)localObject2).caB, "", 268435456L, null, paramInt));
          break;
          i += 1;
          break label234;
          Collections.sort(localArrayList2, new amjn(this));
          Collections.sort(localArrayList3, new amjo(this));
          localArrayList1.addAll(localArrayList2);
          localArrayList1.addAll(localArrayList3);
          i = localArrayList1.size();
          paramInt = 0;
          while (paramInt < i)
          {
            amxl.a((ampx)localArrayList1.get(paramInt), i, paramInt);
            paramInt += 1;
          }
          return localArrayList1;
        }
      }
    }
  }
  
  public String yX()
  {
    return this.app.getApp().getSharedPreferences("Q.uniteSearch.FunctionModuleConfigManager", 0).getString("contentUrl", "");
  }
  
  public static class a
  {
    public String caB;
    public int dCw;
    public String headUrl;
    public String name;
    public List<String> tags;
    
    public a(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      this.dCw = paramInt;
      this.name = paramString1;
      this.headUrl = paramString2;
      this.caB = paramString3;
    }
    
    public a(int paramInt, String paramString1, String paramString2, String paramString3, List<String> paramList)
    {
      this.dCw = paramInt;
      this.name = paramString1;
      this.headUrl = paramString2;
      this.caB = paramString3;
      this.tags = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjm
 * JD-Core Version:    0.7.0.1
 */