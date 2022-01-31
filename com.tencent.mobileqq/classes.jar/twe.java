import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.1;
import com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class twe
{
  public static final String a;
  private static OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  private static twe jdField_a_of_type_Twe;
  private static final String b = tqb.e;
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<twi>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = twe.class.getSimpleName();
  }
  
  private static OkHttpClient a()
  {
    if (jdField_a_of_type_Okhttp3OkHttpClient == null) {}
    try
    {
      if (jdField_a_of_type_Okhttp3OkHttpClient == null) {
        jdField_a_of_type_Okhttp3OkHttpClient = new OkHttpClient().newBuilder().protocols(Arrays.asList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 })).connectTimeout(30000L, TimeUnit.SECONDS).readTimeout(30000L, TimeUnit.SECONDS).writeTimeout(30000L, TimeUnit.SECONDS).build();
      }
      return jdField_a_of_type_Okhttp3OkHttpClient;
    }
    finally {}
  }
  
  private Request a(String paramString)
  {
    return new Request.Builder().url(paramString).head().build();
  }
  
  public static twe a()
  {
    if (jdField_a_of_type_Twe == null) {}
    try
    {
      if (jdField_a_of_type_Twe == null) {
        jdField_a_of_type_Twe = new twe();
      }
      return jdField_a_of_type_Twe;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    a(paramString, "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(b(paramString1)))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "downloadError encodePath is Empty");
      return;
    }
    String str = c(paramString1);
    try
    {
      ThreadManagerV2.executeOnFileThread(new QCircleResourceDownloadManager.2(this, paramString1, str, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "error " + paramString1.getMessage());
      paramString1.printStackTrace();
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (twi)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((twi)localObject).a(paramBoolean, paramString2);
            localConcurrentHashMap.remove(Integer.valueOf(localObject.hashCode()));
            QLog.e(jdField_a_of_type_JavaLangString, 1, "downloadUrl:" + paramString1 + "success");
          }
          else
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "downloadUrl:" + paramString1 + "  getFileListener release");
          }
        }
        else
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "downloadUrl:" + paramString1 + "WeakReference null");
        }
      }
    }
  }
  
  private String b(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      tpz.a().edit().putString(e(paramString1), paramString2).apply();
    }
  }
  
  private void b(String paramString, twi paramtwi)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramtwi.hashCode()), new WeakReference(paramtwi));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap1);
    QLog.d(jdField_a_of_type_JavaLangString, 2, "add GetFileListener url:" + paramString + " size:" + localConcurrentHashMap1.size());
  }
  
  private boolean b(String paramString)
  {
    return paramString.endsWith(".zip");
  }
  
  private String c(String paramString)
  {
    return b + b(paramString);
  }
  
  private String d(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    return String.valueOf(j) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  private String e(String paramString)
  {
    return "X-COS-META-MD5" + paramString;
  }
  
  public String a(String paramString)
  {
    return b + d(paramString) + File.separator;
  }
  
  public void a(String paramString, tvy paramtvy)
  {
    if (paramtvy == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "checkResource listener is null");
      return;
    }
    boolean bool = a(paramString);
    String str = tpz.a().getString(e(paramString), "");
    QLog.d(jdField_a_of_type_JavaLangString, 1, "checkResource url:" + paramString + " isDownloaded:" + bool + "  preMd5" + str);
    a().newCall(a(paramString)).enqueue(new twh(this, paramtvy, bool, str));
  }
  
  public void a(String paramString, twi paramtwi)
  {
    ThreadManagerV2.executeOnFileThread(new QCircleResourceDownloadManager.1(this, paramString, paramtwi));
  }
  
  public void a(String[] paramArrayOfString, twi paramtwi)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        a(paramArrayOfString[i], paramtwi);
        i += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = new File(a(paramString));
    if (bdms.a() == null) {
      return false;
    }
    return paramString.exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twe
 * JD-Core Version:    0.7.0.1
 */