import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jop
  extends jon
{
  public final ConcurrentHashMap<String, Set<String>> aQ = new ConcurrentHashMap(50);
  public final Handler aR = new joq(this, Looper.getMainLooper());
  
  public jop(SharedPreferences paramSharedPreferences, jon paramjon)
  {
    super(paramSharedPreferences, paramjon);
  }
  
  private void ayM()
  {
    Object localObject1 = this.mPref.getString("cmdConfig", null);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null) {
          break label123;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("AuthorizeConfig", 2, "now read cmdConfig {\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}");
          }
          JSONObject localJSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}");
          localObject1 = localJSONObject;
          if (localObject1 != null) {
            break label126;
          }
          QLog.e("AuthorizeConfig", 1, "cmdJsonObject is null!");
          return;
        }
        catch (JSONException localJSONException2)
        {
          if (!QLog.isColorLevel()) {
            break label123;
          }
          QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
        }
        localJSONException1 = localJSONException1;
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
        }
        localObject2 = null;
        continue;
      }
      QLog.e("AuthorizeConfig", 2, "now error! old mPref have no value for cmdConfig!");
      Object localObject2 = null;
      continue;
      label123:
      continue;
      label126:
      JSONArray localJSONArray1 = localObject2.names();
      if ((localJSONArray1 == null) || (localJSONArray1.length() == 0))
      {
        QLog.e("AuthorizeConfig", 1, "domain Name are all empty!");
        return;
      }
      this.aQ.clear();
      int i = 0;
      while (i < localJSONArray1.length())
      {
        HashSet localHashSet = new HashSet(20);
        String str = localJSONArray1.optString(i);
        JSONArray localJSONArray2 = localObject2.optJSONArray(str);
        if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
        {
          int j = 0;
          while (j < localJSONArray2.length())
          {
            localHashSet.add(localJSONArray2.optString(j));
            j += 1;
          }
          this.aQ.put(str, localHashSet);
        }
        i += 1;
      }
    }
  }
  
  private void ayN()
  {
    Object localObject1 = this.mPref.getString("cmd_config_new", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      Object localObject3;
      int j;
      String str;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          break label221;
        }
        this.aQ.clear();
        int m = ((JSONArray)localObject1).length();
        i = 0;
        if (i >= m) {
          break label220;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        JSONArray localJSONArray1 = ((JSONObject)localObject3).optJSONArray("api");
        JSONArray localJSONArray2 = ((JSONObject)localObject3).optJSONArray("match");
        int n = localJSONArray2.length();
        j = 0;
        if (j >= n) {
          break label249;
        }
        str = localJSONArray2.optString(j);
        Set localSet = (Set)this.aQ.get(str);
        localObject3 = localSet;
        if (localSet == null) {
          localObject3 = new HashSet(20);
        }
        int i1 = localJSONArray1.length();
        int k = 0;
        if (k >= i1) {
          break label230;
        }
        ((Set)localObject3).add(localJSONArray1.optString(k));
        k += 1;
        continue;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "Js Api Config JSONArray error!", localException);
        }
        Object localObject2 = null;
        continue;
      }
      QLog.e("AuthorizeConfig", 1, "get Js Api Config From Pref is empty!");
      label220:
      return;
      label221:
      QLog.e("AuthorizeConfig", 1, "Js Api Config JSONArray From Pref is empty");
      return;
      label230:
      this.aQ.put(str, localObject3);
      j += 1;
      continue;
      label249:
      i += 1;
    }
  }
  
  /* Error */
  public String a(android.content.SharedPreferences.Editor paramEditor, String paramString)
    throws Exception
  {
    // Byte code:
    //   0: new 58	org/json/JSONObject
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 61	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 10
    //   10: ldc 129
    //   12: astore 9
    //   14: aload 10
    //   16: ldc 157
    //   18: invokevirtual 160	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   21: astore 12
    //   23: new 15	java/util/concurrent/ConcurrentHashMap
    //   26: dup
    //   27: bipush 50
    //   29: invokespecial 18	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   32: astore 11
    //   34: aload 12
    //   36: ifnull +165 -> 201
    //   39: aload 12
    //   41: invokevirtual 96	org/json/JSONArray:length	()I
    //   44: ifle +157 -> 201
    //   47: aload_1
    //   48: ldc 127
    //   50: aload 12
    //   52: invokevirtual 164	org/json/JSONArray:toString	()Ljava/lang/String;
    //   55: invokeinterface 170 3 0
    //   60: pop
    //   61: aload_1
    //   62: ldc 44
    //   64: ldc 129
    //   66: invokeinterface 170 3 0
    //   71: pop
    //   72: aload 12
    //   74: invokevirtual 96	org/json/JSONArray:length	()I
    //   77: istore 6
    //   79: iconst_0
    //   80: istore_3
    //   81: iload_3
    //   82: iload 6
    //   84: if_icmpge +145 -> 229
    //   87: aload 12
    //   89: iload_3
    //   90: invokevirtual 134	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   93: astore_2
    //   94: aload_2
    //   95: ldc 136
    //   97: invokevirtual 112	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   100: astore 13
    //   102: aload_2
    //   103: ldc 138
    //   105: invokevirtual 112	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   108: astore 14
    //   110: aload 14
    //   112: invokevirtual 96	org/json/JSONArray:length	()I
    //   115: istore 7
    //   117: iconst_0
    //   118: istore 4
    //   120: iload 4
    //   122: iload 7
    //   124: if_icmpge +744 -> 868
    //   127: aload 14
    //   129: iload 4
    //   131: invokevirtual 172	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   134: astore 15
    //   136: aload 11
    //   138: aload 15
    //   140: invokevirtual 142	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   143: checkcast 114	java/util/Set
    //   146: astore_2
    //   147: aload_2
    //   148: ifnonnull +715 -> 863
    //   151: new 103	java/util/HashSet
    //   154: dup
    //   155: bipush 20
    //   157: invokespecial 104	java/util/HashSet:<init>	(I)V
    //   160: astore_2
    //   161: iconst_0
    //   162: istore 5
    //   164: aload 13
    //   166: invokevirtual 96	org/json/JSONArray:length	()I
    //   169: istore 8
    //   171: iload 5
    //   173: iload 8
    //   175: if_icmpge +36 -> 211
    //   178: aload_2
    //   179: aload 13
    //   181: iload 5
    //   183: invokevirtual 172	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   186: invokeinterface 118 2 0
    //   191: pop
    //   192: iload 5
    //   194: iconst_1
    //   195: iadd
    //   196: istore 5
    //   198: goto -27 -> 171
    //   201: ldc 69
    //   203: iconst_1
    //   204: ldc 174
    //   206: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aconst_null
    //   210: areturn
    //   211: aload 11
    //   213: aload 15
    //   215: aload_2
    //   216: invokevirtual 122	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: iload 4
    //   222: iconst_1
    //   223: iadd
    //   224: istore 4
    //   226: goto -106 -> 120
    //   229: invokestatic 180	android/os/Message:obtain	()Landroid/os/Message;
    //   232: astore_2
    //   233: aload_2
    //   234: iconst_1
    //   235: putfield 184	android/os/Message:what	I
    //   238: aload_2
    //   239: aload 11
    //   241: putfield 188	android/os/Message:obj	Ljava/lang/Object;
    //   244: aload_0
    //   245: getfield 33	jop:aR	Landroid/os/Handler;
    //   248: aload_2
    //   249: invokevirtual 194	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   252: pop
    //   253: aload 9
    //   255: astore_2
    //   256: aload_1
    //   257: ldc 196
    //   259: aload 10
    //   261: ldc 196
    //   263: invokevirtual 160	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   266: invokevirtual 164	org/json/JSONArray:toString	()Ljava/lang/String;
    //   269: invokeinterface 170 3 0
    //   274: pop
    //   275: aload_1
    //   276: ldc 198
    //   278: aload 10
    //   280: ldc 200
    //   282: invokevirtual 204	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   285: invokevirtual 205	org/json/JSONObject:toString	()Ljava/lang/String;
    //   288: invokeinterface 170 3 0
    //   293: pop
    //   294: aload_1
    //   295: ldc 207
    //   297: aload 10
    //   299: ldc 209
    //   301: invokevirtual 204	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   304: invokevirtual 205	org/json/JSONObject:toString	()Ljava/lang/String;
    //   307: invokeinterface 170 3 0
    //   312: pop
    //   313: aload_1
    //   314: ldc 211
    //   316: aload 10
    //   318: ldc 211
    //   320: invokevirtual 204	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   323: invokevirtual 205	org/json/JSONObject:toString	()Ljava/lang/String;
    //   326: invokeinterface 170 3 0
    //   331: pop
    //   332: new 58	org/json/JSONObject
    //   335: dup
    //   336: invokespecial 213	org/json/JSONObject:<init>	()V
    //   339: astore 9
    //   341: aload 10
    //   343: ldc 215
    //   345: invokevirtual 160	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   348: astore 11
    //   350: aload 11
    //   352: invokevirtual 96	org/json/JSONArray:length	()I
    //   355: istore 5
    //   357: iconst_0
    //   358: istore_3
    //   359: iload_3
    //   360: iload 5
    //   362: if_icmpge +263 -> 625
    //   365: aload 11
    //   367: iload_3
    //   368: invokevirtual 217	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   371: astore 13
    //   373: aload 13
    //   375: ldc 219
    //   377: invokevirtual 160	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   380: astore 12
    //   382: aload 13
    //   384: ldc 138
    //   386: invokevirtual 160	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   389: astore 13
    //   391: iconst_0
    //   392: istore 4
    //   394: aload 13
    //   396: invokevirtual 96	org/json/JSONArray:length	()I
    //   399: istore 6
    //   401: iload 4
    //   403: iload 6
    //   405: if_icmpge +213 -> 618
    //   408: aload 9
    //   410: aload 13
    //   412: iload 4
    //   414: invokevirtual 172	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   417: aload 12
    //   419: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   422: pop
    //   423: iload 4
    //   425: iconst_1
    //   426: iadd
    //   427: istore 4
    //   429: goto -28 -> 401
    //   432: astore_2
    //   433: new 224	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   440: ldc 129
    //   442: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_2
    //   446: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: astore_2
    //   456: goto -200 -> 256
    //   459: astore_2
    //   460: new 224	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   467: ldc 129
    //   469: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_2
    //   473: invokevirtual 234	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   476: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: astore_2
    //   483: goto -227 -> 256
    //   486: astore 9
    //   488: new 224	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   495: aload_2
    //   496: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc 236
    //   501: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload 9
    //   506: invokevirtual 237	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   509: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: astore_2
    //   516: goto -241 -> 275
    //   519: astore 9
    //   521: new 224	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   528: aload_2
    //   529: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc 236
    //   534: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload 9
    //   539: invokevirtual 237	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   542: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: astore_2
    //   549: goto -255 -> 294
    //   552: astore 9
    //   554: new 224	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   561: aload_2
    //   562: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: ldc 236
    //   567: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload 9
    //   572: invokevirtual 237	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   575: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: astore_2
    //   582: goto -269 -> 313
    //   585: astore 9
    //   587: new 224	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   594: aload_2
    //   595: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: ldc 236
    //   600: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload 9
    //   605: invokevirtual 237	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   608: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: astore_2
    //   615: goto -283 -> 332
    //   618: iload_3
    //   619: iconst_1
    //   620: iadd
    //   621: istore_3
    //   622: goto -263 -> 359
    //   625: aload_1
    //   626: ldc 215
    //   628: aload 9
    //   630: invokevirtual 205	org/json/JSONObject:toString	()Ljava/lang/String;
    //   633: invokeinterface 170 3 0
    //   638: pop
    //   639: aload_1
    //   640: ldc 239
    //   642: aload 10
    //   644: ldc 239
    //   646: invokevirtual 243	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   649: invokeinterface 247 4 0
    //   654: pop
    //   655: getstatic 253	jml:aW	[Ljava/lang/String;
    //   658: astore 11
    //   660: aload 11
    //   662: arraylength
    //   663: istore 4
    //   665: iconst_0
    //   666: istore_3
    //   667: iload_3
    //   668: iload 4
    //   670: if_icmpge +196 -> 866
    //   673: aload 11
    //   675: iload_3
    //   676: aaload
    //   677: astore 12
    //   679: aload 10
    //   681: aload 12
    //   683: invokevirtual 160	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   686: astore 13
    //   688: aload_1
    //   689: aload 12
    //   691: aload 13
    //   693: invokevirtual 164	org/json/JSONArray:toString	()Ljava/lang/String;
    //   696: invokeinterface 170 3 0
    //   701: pop
    //   702: aload_2
    //   703: astore 9
    //   705: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   708: ifeq +43 -> 751
    //   711: ldc 69
    //   713: iconst_2
    //   714: new 224	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   721: ldc 255
    //   723: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload 12
    //   728: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: ldc_w 257
    //   734: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: aload 13
    //   739: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: aload_2
    //   749: astore 9
    //   751: iload_3
    //   752: iconst_1
    //   753: iadd
    //   754: istore_3
    //   755: aload 9
    //   757: astore_2
    //   758: goto -91 -> 667
    //   761: astore 9
    //   763: new 224	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   770: aload_2
    //   771: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: ldc 236
    //   776: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload 9
    //   781: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   784: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: astore_2
    //   791: goto -152 -> 639
    //   794: astore 9
    //   796: ldc 69
    //   798: iconst_1
    //   799: new 224	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   806: ldc_w 262
    //   809: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload 9
    //   814: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   817: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   826: goto -171 -> 655
    //   829: astore 9
    //   831: new 224	java/lang/StringBuilder
    //   834: dup
    //   835: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   838: aload_2
    //   839: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: ldc 236
    //   844: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload 9
    //   849: invokevirtual 237	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   852: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: astore 9
    //   860: goto -109 -> 751
    //   863: goto -702 -> 161
    //   866: aload_2
    //   867: areturn
    //   868: iload_3
    //   869: iconst_1
    //   870: iadd
    //   871: istore_3
    //   872: goto -791 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	875	0	this	jop
    //   0	875	1	paramEditor	android.content.SharedPreferences.Editor
    //   0	875	2	paramString	String
    //   80	792	3	i	int
    //   118	553	4	j	int
    //   162	201	5	k	int
    //   77	329	6	m	int
    //   115	10	7	n	int
    //   169	7	8	i1	int
    //   12	397	9	localObject1	Object
    //   486	19	9	localJSONException1	JSONException
    //   519	19	9	localJSONException2	JSONException
    //   552	19	9	localJSONException3	JSONException
    //   585	44	9	localJSONException4	JSONException
    //   703	53	9	str1	String
    //   761	19	9	localException1	Exception
    //   794	19	9	localException2	Exception
    //   829	19	9	localJSONException5	JSONException
    //   858	1	9	str2	String
    //   8	672	10	localJSONObject	JSONObject
    //   32	642	11	localObject2	Object
    //   21	706	12	localJSONArray1	JSONArray
    //   100	638	13	localObject3	Object
    //   108	20	14	localJSONArray2	JSONArray
    //   134	80	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   14	34	432	java/lang/Exception
    //   39	79	432	java/lang/Exception
    //   87	117	432	java/lang/Exception
    //   127	147	432	java/lang/Exception
    //   151	161	432	java/lang/Exception
    //   164	171	432	java/lang/Exception
    //   178	192	432	java/lang/Exception
    //   201	209	432	java/lang/Exception
    //   211	220	432	java/lang/Exception
    //   229	253	432	java/lang/Exception
    //   14	34	459	java/lang/OutOfMemoryError
    //   39	79	459	java/lang/OutOfMemoryError
    //   87	117	459	java/lang/OutOfMemoryError
    //   127	147	459	java/lang/OutOfMemoryError
    //   151	161	459	java/lang/OutOfMemoryError
    //   164	171	459	java/lang/OutOfMemoryError
    //   178	192	459	java/lang/OutOfMemoryError
    //   201	209	459	java/lang/OutOfMemoryError
    //   211	220	459	java/lang/OutOfMemoryError
    //   229	253	459	java/lang/OutOfMemoryError
    //   256	275	486	org/json/JSONException
    //   275	294	519	org/json/JSONException
    //   294	313	552	org/json/JSONException
    //   313	332	585	org/json/JSONException
    //   332	357	761	java/lang/Exception
    //   365	391	761	java/lang/Exception
    //   394	401	761	java/lang/Exception
    //   408	423	761	java/lang/Exception
    //   625	639	761	java/lang/Exception
    //   639	655	794	java/lang/Exception
    //   679	702	829	org/json/JSONException
    //   705	748	829	org/json/JSONException
  }
  
  public JSONArray a(String paramString)
  {
    Object localObject1;
    if (!isEnabled()) {
      localObject1 = this.a.a(paramString);
    }
    do
    {
      for (;;)
      {
        return localObject1;
        localObject1 = this.mPref.getString(paramString, null);
        if (localObject1 == null) {
          break label128;
        }
        try
        {
          localJSONArray = new JSONArray((String)localObject1);
          localObject1 = localJSONArray;
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.e("AuthorizeConfig", 2, "Load server config for " + paramString);
              return localJSONArray;
            }
          }
          catch (JSONException localJSONException1) {}
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Object localObject2;
            JSONArray localJSONArray = null;
          }
        }
      }
      localObject2 = localJSONArray;
    } while (!QLog.isColorLevel());
    QLog.w("AuthorizeConfig", 2, "Decode " + paramString + " Config error");
    return localJSONArray;
    label128:
    return null;
  }
  
  public void ayO()
  {
    this.aR.sendEmptyMessage(1);
  }
  
  public void clear()
  {
    ayO();
  }
  
  public String getExt()
  {
    if (!isEnabled()) {
      return this.a.getExt();
    }
    return this.mPref.getString("extra", null);
  }
  
  public int h(String paramString1, String paramString2)
  {
    if (!isEnabled())
    {
      int i = this.a.h(paramString1, paramString2);
      if ((cR(i)) || (!y(i))) {
        return i;
      }
    }
    if (this.aQ.size() == 0)
    {
      ayN();
      if (this.aQ.size() == 0) {
        ayM();
      }
    }
    if (this.aQ.size() == 0)
    {
      QLog.e("AuthorizeConfig", 1, "can not find any JS API, so return!");
      return c(false, true);
    }
    Object localObject = this.aQ.keySet();
    if (((Set)localObject).size() == 0) {
      return c(false, true);
    }
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {
      str = paramString1.toLowerCase();
    }
    do
    {
      paramString1 = ((Set)localObject).iterator();
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!paramString1.hasNext()) {
              break;
            }
            localObject = (String)paramString1.next();
          } while (!jml.A((String)localObject, str));
          localObject = (Set)this.aQ.get(localObject);
        } while ((localObject == null) || (((Set)localObject).size() == 0));
        localObject = ((Set)localObject).iterator();
      }
    } while (!jml.A((String)((Iterator)localObject).next(), paramString2));
    return c(true, false);
    return c(false, false);
  }
  
  public String hH()
  {
    if (!isEnabled()) {
      return this.a.hH();
    }
    return this.mPref.getString("offlineHtml", null);
  }
  
  public String hI()
  {
    if (!isEnabled()) {
      return this.a.hI();
    }
    return this.mPref.getString("jump", null);
  }
  
  public JSONObject i()
    throws JSONException
  {
    JSONObject localJSONObject = null;
    if (!isEnabled()) {
      localJSONObject = this.a.i();
    }
    String str;
    do
    {
      return localJSONObject;
      str = this.mPref.getString("schemes", null);
    } while (str == null);
    return new JSONObject(str);
  }
  
  public boolean isEnabled()
  {
    ((joo)this.a).ayK();
    return !this.a.isEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jop
 * JD-Core Version:    0.7.0.1
 */