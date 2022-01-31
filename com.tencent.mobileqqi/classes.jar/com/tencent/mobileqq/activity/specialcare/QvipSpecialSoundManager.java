package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import exk;
import exl;
import exm;
import exn;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QvipSpecialSoundManager
{
  public static final String a = "key_special_sound_list";
  public static HashMap a;
  private static final String b = "QvipSpecialSoundManager";
  public static HashMap b = new HashMap();
  private static final String c = "http://imgcache.qq.com/club/moblie/special_sound/sound_config.json";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public QvipSpecialSoundManager(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private String a()
  {
    Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "http://imgcache.qq.com/club/moblie/special_sound/sound_config.json");
    int i = 0;
    if (!((File)localObject).exists())
    {
      try
      {
        boolean bool = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "http://imgcache.qq.com/club/moblie/special_sound/sound_config.json", (File)localObject);
        i = bool;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          long l = 0L;
        }
      }
      if (i == 0) {
        break label122;
      }
      if (localObject != null)
      {
        l = ((File)localObject).length();
        a(l);
      }
    }
    label122:
    for (;;)
    {
      if (i == 0)
      {
        b("downLoad Special Sound Config failed.");
        return "";
        i = 1;
      }
      else
      {
        try
        {
          localObject = a((File)localObject);
          return localObject;
        }
        catch (IOException localIOException)
        {
          b("decodeTextFile is exception.");
          localIOException.printStackTrace();
          return "";
        }
      }
    }
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: new 106	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 111	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 112	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 4
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: sipush 4096
    //   30: invokevirtual 118	java/io/InputStream:read	([BII)I
    //   33: istore_2
    //   34: iload_2
    //   35: iconst_m1
    //   36: if_icmpeq +50 -> 86
    //   39: aload 4
    //   41: aload_3
    //   42: iconst_0
    //   43: iload_2
    //   44: invokevirtual 122	java/io/ByteArrayOutputStream:write	([BII)V
    //   47: goto -23 -> 24
    //   50: astore_3
    //   51: aload_3
    //   52: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   55: aload_1
    //   56: ifnull +7 -> 63
    //   59: aload_1
    //   60: invokevirtual 125	java/io/InputStream:close	()V
    //   63: aload 4
    //   65: ifnull +8 -> 73
    //   68: aload 4
    //   70: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   73: ldc 90
    //   75: astore_1
    //   76: aload_1
    //   77: areturn
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 127	java/io/FileNotFoundException:printStackTrace	()V
    //   83: ldc 90
    //   85: areturn
    //   86: new 129	java/lang/String
    //   89: dup
    //   90: aload 4
    //   92: invokevirtual 133	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   95: ldc 135
    //   97: invokespecial 138	java/lang/String:<init>	([BLjava/lang/String;)V
    //   100: astore_3
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 125	java/io/InputStream:close	()V
    //   109: aload_3
    //   110: astore_1
    //   111: aload 4
    //   113: ifnull -37 -> 76
    //   116: aload 4
    //   118: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   121: aload_3
    //   122: areturn
    //   123: astore_3
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 125	java/io/InputStream:close	()V
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   142: aload_3
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	QvipSpecialSoundManager
    //   0	144	1	paramFile	File
    //   33	11	2	i	int
    //   23	19	3	arrayOfByte	byte[]
    //   50	2	3	localIOException	IOException
    //   100	22	3	str	String
    //   123	20	3	localObject	Object
    //   16	122	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	34	50	java/io/IOException
    //   39	47	50	java/io/IOException
    //   86	101	50	java/io/IOException
    //   0	9	78	java/io/FileNotFoundException
    //   24	34	123	finally
    //   39	47	123	finally
    //   51	55	123	finally
    //   86	101	123	finally
  }
  
  private void a(QvipSpecialSoundManager.CallBack paramCallBack, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new exn(this, paramCallBack, paramBoolean));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null)) {
          return;
        }
        if (TextUtils.isEmpty(paramString2)) {
          return;
        }
        paramString2 = QvipSpecialSoundConfig.a(new JSONObject(paramString2));
        paramString1 = QvipSpecialSoundConfig.a(new JSONObject(paramString1));
        localObject1 = paramString1.jdField_a_of_type_JavaLangString;
        localObject2 = paramString2.jdField_a_of_type_JavaLangString;
        if ((localObject2 != null) && (!((String)localObject2).equals(localObject1)))
        {
          localObject1 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
          ((SharedPreferences)localObject1).edit().putBoolean("special_care_red_point_one", true).commit();
          ((SharedPreferences)localObject1).edit().putBoolean("special_care_red_point_two", true).commit();
        }
        paramString2 = paramString2.jdField_a_of_type_JavaUtilList;
        paramString1 = paramString1.jdField_a_of_type_JavaUtilList;
        if ((paramString2 == null) || (paramString1 == null) || (paramString2.isEmpty()) || (paramString1.isEmpty()) || (paramString2.size() < paramString1.size()))
        {
          b("updateSpecialSound return.");
          return;
        }
      }
      catch (Exception paramString1)
      {
        b("updateSpecialSound exception");
        paramString1.printStackTrace();
        return;
      }
      int j = paramString1.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (exk)paramString2.get(i);
        localObject2 = (exk)paramString1.get(i);
        if ((((exk)localObject1).jdField_a_of_type_Int == ((exk)localObject2).jdField_a_of_type_Int) && (!((exk)localObject1).jdField_b_of_type_JavaLangString.equals(((exk)localObject2).jdField_b_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new exl(this, (exk)localObject1));
        }
        i += 1;
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      b("SpecialSoundList is empty, donot need sort.");
    }
    do
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int j = paramList.size();
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
      int i = 0;
      if (i < j)
      {
        exk localexk = (exk)paramList.get(i);
        if (!b.containsKey(String.valueOf(localexk.jdField_a_of_type_Int))) {
          b.put(String.valueOf(localexk.jdField_a_of_type_Int), localexk);
        }
        localEditor.putString("special_sound_url" + localexk.jdField_a_of_type_Int, localexk.c);
        if (!b(localexk.d)) {
          b("is white list.");
        }
        for (;;)
        {
          i += 1;
          break;
          if (localexk.jdField_a_of_type_Int != 1) {
            if (localexk.jdField_b_of_type_Int == 1) {
              localArrayList1.add(localexk);
            } else {
              localArrayList2.add(localexk);
            }
          }
        }
      }
      localEditor.commit();
      paramList.clear();
      paramList.addAll(localArrayList1);
      paramList.addAll(localArrayList2);
    } while (jdField_a_of_type_JavaUtilHashMap.containsKey("key_special_sound_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    jdField_a_of_type_JavaUtilHashMap.put("key_special_sound_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramList);
  }
  
  private boolean b(String paramString)
  {
    str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return true;
      if (paramString.contains("|")) {
        try
        {
          String[] arrayOfString = paramString.split("\\|");
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label85;
            }
            boolean bool = arrayOfString[i].trim().equals(str);
            if (bool) {
              break;
            }
            i += 1;
          }
          return paramString.equals(str);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void c()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
    localEditor.putInt("defaulut_special_sound_source1", 2131165214);
    localEditor.commit();
  }
  
  public String a(int paramInt)
  {
    if ((b != null) && (!b.isEmpty()))
    {
      exk localexk = (exk)b.get(String.valueOf(paramInt));
      if (localexk != null) {
        return localexk.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: aconst_null
    //   3: astore 8
    //   5: aload_0
    //   6: getfield 47	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9: invokestatic 178	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   12: ldc_w 320
    //   15: lconst_0
    //   16: invokeinterface 324 4 0
    //   21: lstore_3
    //   22: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   25: lload_3
    //   26: lsub
    //   27: ldc2_w 330
    //   30: lcmp
    //   31: ifgt +19 -> 50
    //   34: invokestatic 336	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +12 -> 49
    //   40: ldc 12
    //   42: iconst_2
    //   43: ldc_w 338
    //   46: invokestatic 342	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: return
    //   50: new 58	java/io/File
    //   53: dup
    //   54: aload_0
    //   55: getfield 47	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   58: invokevirtual 64	android/content/Context:getFilesDir	()Ljava/io/File;
    //   61: ldc 15
    //   63: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: astore 9
    //   68: aload 9
    //   70: invokevirtual 71	java/io/File:exists	()Z
    //   73: ifeq +86 -> 159
    //   76: aload_0
    //   77: aload 9
    //   79: invokespecial 96	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(Ljava/io/File;)Ljava/lang/String;
    //   82: astore 6
    //   84: aload_0
    //   85: getfield 49	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: ldc 15
    //   90: aload 9
    //   92: invokestatic 76	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   95: istore 5
    //   97: aload 8
    //   99: astore 7
    //   101: iload 5
    //   103: ifeq +27 -> 130
    //   106: aload_0
    //   107: aload 9
    //   109: invokespecial 96	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(Ljava/io/File;)Ljava/lang/String;
    //   112: astore 7
    //   114: aload 9
    //   116: ifnull +9 -> 125
    //   119: aload 9
    //   121: invokevirtual 80	java/io/File:length	()J
    //   124: lstore_1
    //   125: aload_0
    //   126: lload_1
    //   127: invokevirtual 83	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(J)V
    //   130: aload 7
    //   132: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifeq +63 -> 198
    //   138: aload_0
    //   139: ldc_w 344
    //   142: invokevirtual 88	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   145: return
    //   146: astore 6
    //   148: aload_0
    //   149: ldc 98
    //   151: invokevirtual 88	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   154: aload 6
    //   156: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: astore 6
    //   162: goto -78 -> 84
    //   165: astore 7
    //   167: aload 7
    //   169: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   172: iconst_0
    //   173: istore 5
    //   175: goto -78 -> 97
    //   178: astore 7
    //   180: aload_0
    //   181: ldc 98
    //   183: invokevirtual 88	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   186: aload 7
    //   188: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   191: aload 8
    //   193: astore 7
    //   195: goto -65 -> 130
    //   198: aload 6
    //   200: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   203: ifne +21 -> 224
    //   206: aload 6
    //   208: aload 7
    //   210: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +11 -> 224
    //   216: aload_0
    //   217: ldc_w 346
    //   220: invokevirtual 88	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   223: return
    //   224: aload_0
    //   225: aload 6
    //   227: aload 7
    //   229: invokespecial 348	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_0
    //   233: getfield 47	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   236: invokestatic 178	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   239: invokeinterface 184 1 0
    //   244: ldc_w 320
    //   247: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   250: invokeinterface 352 4 0
    //   255: invokeinterface 195 1 0
    //   260: pop
    //   261: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	QvipSpecialSoundManager
    //   1	126	1	l1	long
    //   21	5	3	l2	long
    //   95	79	5	bool	boolean
    //   82	1	6	str	String
    //   146	9	6	localIOException	IOException
    //   160	66	6	localCharSequence	java.lang.CharSequence
    //   99	32	7	localObject1	Object
    //   165	3	7	localException1	Exception
    //   178	9	7	localException2	Exception
    //   193	35	7	localObject2	Object
    //   3	189	8	localObject3	Object
    //   66	54	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   76	84	146	java/io/IOException
    //   84	97	165	java/lang/Exception
    //   106	114	178	java/lang/Exception
    //   119	125	178	java/lang/Exception
    //   125	130	178	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      b("reportFlowData is Empty flowSize = " + paramLong);
      return;
    }
    String[] arrayOfString;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      b("reportFlowData int wifi state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFISpecialCareDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      b("sendAppDataIncerment flowSize = " + paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), arrayOfString, paramLong);
      return;
      b("reportFlowData int 2G/3G state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGSpecialCareDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
  
  public void a(QvipSpecialSoundManager.CallBack paramCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new exm(this, paramCallBack));
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = QvipSpecialSoundConfig.a(new JSONObject(paramString));
        if (paramString != null)
        {
          a(paramString.jdField_a_of_type_JavaUtilList);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    String str = "key_special_sound_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    return jdField_a_of_type_JavaUtilHashMap.containsKey(str);
  }
  
  public boolean a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), paramString);
    try
    {
      boolean bool = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localFile);
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    c();
    a(a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QvipSpecialSoundManager", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager
 * JD-Core Version:    0.7.0.1
 */