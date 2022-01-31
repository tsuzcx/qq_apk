import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.qphone.base.util.QLog;

public class bhn
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LoadedBack jdField_a_of_type_ComTencentBizCommonUtilLoadedBack;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  private String b;
  
  bhn(Context paramContext, String paramString1, String paramString2, LoadedBack paramLoadedBack, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    if ((TextUtils.isEmpty(paramString1)) || (paramLoadedBack == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack = paramLoadedBack;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(paramInt);
    HtmlOffline.b(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "checkUpFinished code:" + paramInt);
    }
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HtmlCheckUpdate", 4, "downUpdateZip:" + paramString);
    }
    String str = HtmlOffline.i + this.jdField_a_of_type_JavaLangString + ".zip";
    long l = System.currentTimeMillis();
    OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext, paramString, paramInt, this.jdField_a_of_type_JavaLangString, str, new bho(this, l));
    return true;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 34	bhn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: invokestatic 112	com/tencent/biz/common/offline/HtmlOffline:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9: astore 6
    //   11: ldc 114
    //   13: astore 5
    //   15: aload 5
    //   17: astore 4
    //   19: aload 6
    //   21: ifnull +12 -> 33
    //   24: aload 6
    //   26: ldc 116
    //   28: invokevirtual 122	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 4
    //   33: aload_0
    //   34: getfield 28	bhn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   37: aload 4
    //   39: aload_0
    //   40: getfield 34	bhn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   43: aload_0
    //   44: getfield 32	bhn:b	Ljava/lang/String;
    //   47: invokestatic 125	com/tencent/biz/common/offline/HtmlOffline:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 4
    //   52: aload 4
    //   54: ifnonnull +37 -> 91
    //   57: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +11 -> 71
    //   63: ldc 83
    //   65: iconst_2
    //   66: ldc 127
    //   68: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aload_0
    //   72: iconst_2
    //   73: invokespecial 77	bhn:a	(I)V
    //   76: return
    //   77: astore 4
    //   79: aload 4
    //   81: invokevirtual 130	java/lang/Exception:printStackTrace	()V
    //   84: aload 5
    //   86: astore 4
    //   88: goto -55 -> 33
    //   91: new 118	org/json/JSONObject
    //   94: dup
    //   95: aload 4
    //   97: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   100: astore 4
    //   102: aload 4
    //   104: ldc 134
    //   106: invokevirtual 138	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   109: istore_1
    //   110: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +28 -> 141
    //   116: ldc 55
    //   118: iconst_2
    //   119: new 57	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   126: ldc 140
    //   128: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: iload_1
    //   132: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: iload_1
    //   142: ifne +174 -> 316
    //   145: aload 4
    //   147: ldc 142
    //   149: invokevirtual 138	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   152: istore_1
    //   153: aload_0
    //   154: iload_1
    //   155: putfield 18	bhn:jdField_a_of_type_Int	I
    //   158: iload_1
    //   159: ifle +148 -> 307
    //   162: aload 4
    //   164: ldc 144
    //   166: invokevirtual 122	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore 5
    //   171: aload 5
    //   173: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: istore_3
    //   177: iload_3
    //   178: ifne +106 -> 284
    //   181: aload 4
    //   183: ldc 146
    //   185: invokevirtual 138	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   188: istore_1
    //   189: aload_0
    //   190: aload 5
    //   192: iload_1
    //   193: invokespecial 148	bhn:a	(Ljava/lang/String;I)Z
    //   196: pop
    //   197: aload 4
    //   199: ldc 150
    //   201: invokevirtual 138	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   204: istore_1
    //   205: iconst_1
    //   206: iload_1
    //   207: if_icmpne -131 -> 76
    //   210: aload_0
    //   211: getfield 28	bhn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   214: aload_0
    //   215: getfield 34	bhn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   218: iload_1
    //   219: invokestatic 153	com/tencent/biz/common/offline/HtmlOffline:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   222: return
    //   223: astore 4
    //   225: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq -152 -> 76
    //   231: ldc 83
    //   233: iconst_2
    //   234: ldc 155
    //   236: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: return
    //   240: astore 4
    //   242: aload 4
    //   244: invokevirtual 156	org/json/JSONException:printStackTrace	()V
    //   247: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +11 -> 261
    //   253: ldc 83
    //   255: iconst_2
    //   256: ldc 158
    //   258: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_0
    //   262: iconst_2
    //   263: invokespecial 77	bhn:a	(I)V
    //   266: return
    //   267: astore 5
    //   269: aload 5
    //   271: invokevirtual 156	org/json/JSONException:printStackTrace	()V
    //   274: aload_0
    //   275: iconst_2
    //   276: invokespecial 77	bhn:a	(I)V
    //   279: iconst_0
    //   280: istore_1
    //   281: goto -171 -> 110
    //   284: aload_0
    //   285: iconst_2
    //   286: invokespecial 77	bhn:a	(I)V
    //   289: goto -92 -> 197
    //   292: astore 5
    //   294: aload 5
    //   296: invokevirtual 156	org/json/JSONException:printStackTrace	()V
    //   299: aload_0
    //   300: iconst_2
    //   301: invokespecial 77	bhn:a	(I)V
    //   304: goto -107 -> 197
    //   307: aload_0
    //   308: bipush 8
    //   310: invokespecial 77	bhn:a	(I)V
    //   313: goto -116 -> 197
    //   316: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +28 -> 347
    //   322: ldc 83
    //   324: iconst_2
    //   325: new 57	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   332: ldc 160
    //   334: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: iload_1
    //   338: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload_0
    //   348: iconst_2
    //   349: invokespecial 77	bhn:a	(I)V
    //   352: return
    //   353: astore 6
    //   355: iload_2
    //   356: istore_1
    //   357: goto -168 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	bhn
    //   109	248	1	i	int
    //   1	355	2	j	int
    //   176	2	3	bool	boolean
    //   17	36	4	str1	String
    //   77	3	4	localException	java.lang.Exception
    //   86	112	4	localObject	Object
    //   223	1	4	localJSONException1	org.json.JSONException
    //   240	3	4	localJSONException2	org.json.JSONException
    //   13	178	5	str2	String
    //   267	3	5	localJSONException3	org.json.JSONException
    //   292	3	5	localJSONException4	org.json.JSONException
    //   9	16	6	localJSONObject	org.json.JSONObject
    //   353	1	6	localJSONException5	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   24	33	77	java/lang/Exception
    //   197	205	223	org/json/JSONException
    //   210	222	223	org/json/JSONException
    //   91	102	240	org/json/JSONException
    //   102	110	267	org/json/JSONException
    //   145	158	292	org/json/JSONException
    //   162	177	292	org/json/JSONException
    //   189	197	292	org/json/JSONException
    //   284	289	292	org/json/JSONException
    //   307	313	292	org/json/JSONException
    //   181	189	353	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhn
 * JD-Core Version:    0.7.0.1
 */