import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mit
{
  private static final String[] bt = { "readinjoy", "kandian" };
  
  public static JSONArray a(ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramArrayList.next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("uin", localBiuCommentInfo.i);
        localJSONObject.put("comment", localBiuCommentInfo.ahj);
        localJSONObject.put("feedid", localBiuCommentInfo.x);
        localJSONObject.put("opType", localBiuCommentInfo.aSO);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("KanDianVideoUploadUtils", 1, "biuList2JsonArray异常:" + localJSONException.toString());
      }
    }
    return localJSONArray;
  }
  
  public static void aC(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("mTaskID");
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    QLog.e("KanDianVideoUploadUtils", 1, "saveData2Local taskID:" + str1);
    JSONObject localJSONObject = new JSONObject();
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor;
    Object localObject;
    ArrayList localArrayList;
    String str2;
    try
    {
      localSharedPreferences = awit.a(kxm.getAppRuntime(), true, true);
      localEditor = localSharedPreferences.edit();
      localObject = be();
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str2 = ((Intent)((Iterator)localObject).next()).getStringExtra("mTaskID");
        if (!TextUtils.isEmpty(str2)) {
          localArrayList.add(str2);
        }
      }
      localObject = "";
    }
    catch (Exception paramBundle)
    {
      QLog.e("KanDianVideoUploadUtils", 1, str1 + "save data error" + paramBundle.toString());
      paramBundle.printStackTrace();
      return;
    }
    int i = 1;
    for (;;)
    {
      if (i <= 2)
      {
        str2 = localSharedPreferences.getString("arg_video_local_task1" + i, "");
        if (str1.equals(str2)) {
          break;
        }
        if (TextUtils.isEmpty(str2))
        {
          localObject = "arg_video_local_task1" + i;
          break label714;
        }
        if (localArrayList.contains(str2)) {
          break label714;
        }
        localObject = "arg_video_local_task1" + i;
        break label714;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localJSONObject.put("arg_is_from_wang_zhe", paramBundle.getBoolean("arg_is_from_wang_zhe", false));
        localJSONObject.put("is_from_dian_dian", paramBundle.getBoolean("is_from_dian_dian", false));
        localJSONObject.put("is_from_kan_dian", paramBundle.getBoolean("is_from_kan_dian", false));
        localJSONObject.put("arg_video_path", paramBundle.getString("arg_video_path", ""));
        localJSONObject.put("arg_video_cover", paramBundle.getString("arg_video_cover", ""));
        localJSONObject.put("mTaskID", str1);
        localJSONObject.put("commentString", paramBundle.getString("commentString", ""));
        localJSONObject.put("multiBiuStruct", a(paramBundle.getParcelableArrayList("multiBiuStruct")).toString());
        localJSONObject.put("mSelectedTagList", c(paramBundle.getParcelableArrayList("mSelectedTagList")).toString());
        localJSONObject.put("arg_ad_tag", paramBundle.getInt("arg_ad_tag"));
        localJSONObject.put("arg_topic_id", paramBundle.getString("arg_topic_id", ""));
        localJSONObject.put("arg_video_cover_url", paramBundle.getString("arg_video_cover_url", ""));
        localJSONObject.put("arg_video_cover_md5", paramBundle.getString("arg_video_cover_md5", ""));
        localJSONObject.put("arg_video_url", paramBundle.getString("arg_video_url", ""));
        localJSONObject.put("arg_video_title", paramBundle.getString("arg_video_title", ""));
        localJSONObject.put("arg_video_uuid", paramBundle.getString("arg_video_uuid", ""));
        localJSONObject.put("arg_video_duration", paramBundle.getLong("arg_video_duration"));
        localJSONObject.put("arg_video_cover_width", paramBundle.getInt("arg_video_cover_width"));
        localJSONObject.put("arg_video_cover_height", paramBundle.getInt("arg_video_cover_height"));
        localJSONObject.put("arg_video_width", paramBundle.getInt("arg_video_width"));
        localJSONObject.put("arg_video_height", paramBundle.getInt("arg_video_height"));
        localEditor.putString((String)localObject, str1);
        localEditor.putString(str1, localJSONObject.toString());
        localEditor.commit();
        QLog.e("KanDianVideoUploadUtils", 1, str1 + "  saveData2Local success! " + (String)localObject + " data content:" + localJSONObject.toString());
        return;
      }
      QLog.e("KanDianVideoUploadUtils", 1, str1 + "save  data failed!!");
      return;
      label714:
      i += 1;
    }
  }
  
  public static void aD(Bundle paramBundle)
  {
    String str = paramBundle.getString("mTaskID", "");
    aE(paramBundle);
    paramBundle = awit.a(kxm.getAppRuntime(), true, true);
    SharedPreferences.Editor localEditor = paramBundle.edit();
    boolean bool2 = false;
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i <= 2)
      {
        if (str.equals(paramBundle.getString("arg_video_local_task1" + i, "")))
        {
          localEditor.putString("arg_video_local_task1" + i, "");
          localEditor.putString(str, "");
          bool1 = true;
        }
      }
      else
      {
        QLog.e("KanDianVideoUploadUtils", 1, "remove local task:" + str + " state:" + bool1);
        localEditor.commit();
        return;
      }
      i += 1;
    }
  }
  
  private static void aE(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("arg_video_cover");
    String str2 = paramBundle.getString("compressPath");
    String str3 = paramBundle.getString("arg_video_path");
    paramBundle = paramBundle.getString("mFakeVidForComposition");
    if (!TextUtils.isEmpty(paramBundle)) {
      new kql().mt(paramBundle);
    }
    delete(str1);
    delete(str2);
    delete(str3);
  }
  
  public static ArrayList<SocializeFeedsInfo.BiuCommentInfo> b(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    try
    {
      paramJSONObject = new JSONArray(paramJSONObject.get("multiBiuStruct").toString());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        String str1 = localJSONObject.get("uin").toString();
        String str2 = localJSONObject.get("comment").toString();
        long l = Long.parseLong(localJSONObject.get("feedid").toString());
        localArrayList.add(new SocializeFeedsInfo.BiuCommentInfo(Long.valueOf(str1), Long.valueOf(l), str2));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("KanDianVideoUploadUtils", 1, "biuJson2List异常:" + paramJSONObject.toString());
    }
  }
  
  public static ArrayList<Intent> be()
  {
    ArrayList localArrayList = new ArrayList();
    SharedPreferences localSharedPreferences = awit.a(kxm.getAppRuntime(), true, false);
    int i = 1;
    while (i <= 2)
    {
      String str = localSharedPreferences.getString("arg_video_local_task1" + i, "");
      if (!TextUtils.isEmpty(str)) {
        p(localSharedPreferences.getString(str, ""), localArrayList);
      }
      i += 1;
    }
    QLog.e("KanDianVideoUploadUtils", 1, "task load over, fail task size:" + localArrayList.size());
    return localArrayList;
  }
  
  public static ArrayList<TagInfo> c(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    try
    {
      paramJSONObject = new JSONArray(paramJSONObject.get("mSelectedTagList").toString());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localArrayList.add(new TagInfo(Long.valueOf(localJSONObject.get("uin").toString()).longValue(), localJSONObject.get("nickName").toString(), Double.parseDouble(localJSONObject.get("tagScore").toString()), Long.parseLong(localJSONObject.get("channel").toString())));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("KanDianVideoUploadUtils", 1, "tagJson2List异常:" + paramJSONObject.toString());
    }
  }
  
  public static JSONArray c(List<TagInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TagInfo localTagInfo = (TagInfo)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("tagId", localTagInfo.cM());
        localJSONObject.put("tagName", localTagInfo.getTagName());
        localJSONObject.put("tagScore", localTagInfo.s());
        localJSONObject.put("channel", localTagInfo.cN());
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("KanDianVideoUploadUtils", 1, "tagList2JsonArray异常:" + localJSONException.toString());
      }
    }
    return localJSONArray;
  }
  
  public static void delete(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramString);
    } while (!paramString.exists());
    paramString.delete();
  }
  
  /* Error */
  private static void p(String paramString, ArrayList<Intent> paramArrayList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: new 148	android/content/Intent
    //   14: dup
    //   15: invokespecial 392	android/content/Intent:<init>	()V
    //   18: astore 6
    //   20: new 112	android/os/Bundle
    //   23: dup
    //   24: invokespecial 393	android/os/Bundle:<init>	()V
    //   27: astore 7
    //   29: new 46	org/json/JSONObject
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 394	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: aload_0
    //   39: ldc 195
    //   41: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 8
    //   46: aload_0
    //   47: ldc 110
    //   49: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 9
    //   54: aload_0
    //   55: ldc 179
    //   57: invokevirtual 398	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   60: istore 5
    //   62: aload 9
    //   64: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +579 -> 646
    //   70: aload 8
    //   72: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +415 -> 490
    //   78: goto +568 -> 646
    //   81: aload_0
    //   82: ldc 192
    //   84: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 10
    //   89: iload 5
    //   91: ifne +545 -> 636
    //   94: iload 4
    //   96: istore_3
    //   97: aload 10
    //   99: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +21 -> 123
    //   105: new 385	java/io/File
    //   108: dup
    //   109: aload 10
    //   111: invokespecial 386	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: invokevirtual 389	java/io/File:exists	()Z
    //   117: ifne +519 -> 636
    //   120: iload 4
    //   122: istore_3
    //   123: iload_3
    //   124: ifeq +275 -> 399
    //   127: aload 7
    //   129: ldc 179
    //   131: iload 5
    //   133: invokevirtual 402	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   136: aload 7
    //   138: ldc 188
    //   140: aload_0
    //   141: ldc 188
    //   143: invokevirtual 398	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   146: invokevirtual 402	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   149: aload 7
    //   151: ldc 190
    //   153: aload_0
    //   154: ldc 190
    //   156: invokevirtual 398	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   159: invokevirtual 402	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   162: aload 6
    //   164: ldc 192
    //   166: aload 10
    //   168: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   171: pop
    //   172: aload 6
    //   174: ldc 195
    //   176: aload 8
    //   178: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   181: pop
    //   182: aload 6
    //   184: ldc 110
    //   186: aload 9
    //   188: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   191: pop
    //   192: aload 6
    //   194: ldc 197
    //   196: aload_0
    //   197: ldc 197
    //   199: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   205: pop
    //   206: aload 7
    //   208: ldc 208
    //   210: aload_0
    //   211: invokestatic 408	mit:c	(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    //   214: invokevirtual 411	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   217: aload 7
    //   219: ldc 199
    //   221: aload_0
    //   222: invokestatic 413	mit:b	(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    //   225: invokevirtual 411	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   228: aload 7
    //   230: ldc 220
    //   232: aload_0
    //   233: ldc 220
    //   235: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokevirtual 416	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload 7
    //   243: ldc 214
    //   245: aload_0
    //   246: ldc 214
    //   248: invokevirtual 417	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   251: invokevirtual 421	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   254: aload 7
    //   256: ldc 245
    //   258: aload_0
    //   259: ldc 245
    //   261: invokevirtual 417	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   264: invokevirtual 421	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   267: aload 7
    //   269: ldc 247
    //   271: aload_0
    //   272: ldc 247
    //   274: invokevirtual 417	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   277: invokevirtual 421	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   280: aload 7
    //   282: ldc 232
    //   284: aload_0
    //   285: ldc 232
    //   287: invokevirtual 422	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   290: invokevirtual 426	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   293: aload 7
    //   295: ldc 222
    //   297: aload_0
    //   298: ldc 222
    //   300: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: invokevirtual 416	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload 7
    //   308: ldc 224
    //   310: aload_0
    //   311: ldc 224
    //   313: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   316: invokevirtual 416	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload 7
    //   321: ldc 226
    //   323: aload_0
    //   324: ldc 226
    //   326: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: invokevirtual 416	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload 7
    //   334: ldc 228
    //   336: aload_0
    //   337: ldc 228
    //   339: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: invokevirtual 416	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload 7
    //   347: ldc 230
    //   349: aload_0
    //   350: ldc 230
    //   352: invokevirtual 395	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: invokevirtual 416	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload 7
    //   360: ldc 241
    //   362: aload_0
    //   363: ldc 241
    //   365: invokevirtual 417	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   368: invokevirtual 421	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   371: aload 7
    //   373: ldc 243
    //   375: aload_0
    //   376: ldc 243
    //   378: invokevirtual 417	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   381: invokevirtual 421	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   384: aload 6
    //   386: aload 7
    //   388: invokevirtual 430	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   391: pop
    //   392: aload_1
    //   393: aload 6
    //   395: invokevirtual 155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   398: pop
    //   399: ldc 82
    //   401: iconst_1
    //   402: new 84	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   409: ldc_w 432
    //   412: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: iload_3
    //   416: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   419: ldc_w 434
    //   422: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 10
    //   427: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 436
    //   433: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 8
    //   438: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc_w 438
    //   444: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 9
    //   449: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: return
    //   459: astore_0
    //   460: ldc 82
    //   462: iconst_1
    //   463: new 84	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 443
    //   473: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_0
    //   477: invokevirtual 158	java/lang/Exception:toString	()Ljava/lang/String;
    //   480: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: return
    //   490: new 385	java/io/File
    //   493: dup
    //   494: aload 8
    //   496: invokespecial 386	java/io/File:<init>	(Ljava/lang/String;)V
    //   499: invokevirtual 389	java/io/File:exists	()Z
    //   502: ifne +139 -> 641
    //   505: iconst_0
    //   506: istore_2
    //   507: goto -426 -> 81
    //   510: astore 11
    //   512: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   515: ifeq -261 -> 254
    //   518: ldc_w 448
    //   521: iconst_2
    //   522: new 84	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   529: ldc_w 450
    //   532: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 11
    //   537: invokevirtual 158	java/lang/Exception:toString	()Ljava/lang/String;
    //   540: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: goto -295 -> 254
    //   552: astore 11
    //   554: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq -264 -> 293
    //   560: ldc_w 448
    //   563: iconst_2
    //   564: new 84	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 450
    //   574: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 11
    //   579: invokevirtual 158	java/lang/Exception:toString	()Ljava/lang/String;
    //   582: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: goto -298 -> 293
    //   594: astore 11
    //   596: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   599: ifeq -241 -> 358
    //   602: ldc_w 448
    //   605: iconst_2
    //   606: new 84	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   613: ldc_w 450
    //   616: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 11
    //   621: invokevirtual 158	java/lang/Exception:toString	()Ljava/lang/String;
    //   624: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: goto -275 -> 358
    //   636: iload_2
    //   637: istore_3
    //   638: goto -515 -> 123
    //   641: iconst_1
    //   642: istore_2
    //   643: goto -562 -> 81
    //   646: iconst_0
    //   647: istore_2
    //   648: goto -567 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	paramString	String
    //   0	651	1	paramArrayList	ArrayList<Intent>
    //   506	142	2	bool1	boolean
    //   96	542	3	bool2	boolean
    //   1	120	4	bool3	boolean
    //   60	72	5	bool4	boolean
    //   18	376	6	localIntent	Intent
    //   27	360	7	localBundle	Bundle
    //   44	451	8	str1	String
    //   52	396	9	str2	String
    //   87	339	10	str3	String
    //   510	26	11	localException1	Exception
    //   552	26	11	localException2	Exception
    //   594	26	11	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   3	10	459	java/lang/Exception
    //   11	78	459	java/lang/Exception
    //   81	89	459	java/lang/Exception
    //   97	120	459	java/lang/Exception
    //   127	228	459	java/lang/Exception
    //   358	399	459	java/lang/Exception
    //   399	458	459	java/lang/Exception
    //   490	505	459	java/lang/Exception
    //   512	549	459	java/lang/Exception
    //   554	591	459	java/lang/Exception
    //   596	633	459	java/lang/Exception
    //   228	254	510	java/lang/Exception
    //   254	293	552	java/lang/Exception
    //   293	358	594	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mit
 * JD-Core Version:    0.7.0.1
 */