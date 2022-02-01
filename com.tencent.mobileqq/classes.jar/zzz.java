import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDownloader.1;
import com.tencent.biz.richframework.download.RFWDownloader.2;
import com.tencent.biz.richframework.download.RFWDownloader.3;
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

public class zzz
{
  private static OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<aaad>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private zzy jdField_a_of_type_Zzy;
  
  public zzz(zzy paramzzy)
  {
    this.jdField_a_of_type_Zzy = paramzzy;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static OkHttpClient a()
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
  
  private void a(String paramString)
  {
    a(paramString, "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(c(paramString1)))
    {
      QLog.e("RFWDownloader", 1, "downloadError encodePath is Empty");
      return;
    }
    String str = a(paramString1);
    try
    {
      ThreadManagerV2.executeOnFileThread(new RFWDownloader.2(this, paramString1, str, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("RFWDownloader", 1, "error " + paramString1.getMessage());
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
          localObject = (aaad)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((aaad)localObject).a(paramBoolean, paramString2);
            localConcurrentHashMap.remove(Integer.valueOf(localObject.hashCode()));
            QLog.e("RFWDownloader", 1, "downloadUrl:" + paramString1 + "success");
          }
          else
          {
            QLog.e("RFWDownloader", 1, "downloadUrl:" + paramString1 + "  getFileListener release");
          }
        }
        else
        {
          QLog.e("RFWDownloader", 1, "downloadUrl:" + paramString1 + "WeakReference null");
        }
      }
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      uyk.a().edit().putString(e(paramString1), paramString2).apply();
    }
  }
  
  private String c(String paramString)
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
  
  private void c(String paramString, aaad paramaaad)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramaaad.hashCode()), new WeakReference(paramaaad));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap1);
    QLog.d("RFWDownloader", 2, "add GetFileListener url:" + paramString + " size:" + localConcurrentHashMap1.size());
  }
  
  private boolean c(String paramString)
  {
    return paramString.endsWith(".zip");
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
    return this.jdField_a_of_type_Zzy.b() + c(paramString);
  }
  
  public void a(String paramString, aaad paramaaad)
  {
    ThreadManagerV2.executeOnFileThread(new RFWDownloader.1(this, paramString, paramaaad));
  }
  
  public void a(String paramString, zzv paramzzv)
  {
    if (paramzzv == null)
    {
      QLog.d("RFWDownloader", 1, "checkResource listener is null");
      return;
    }
    boolean bool = a(paramString);
    String str = uyk.a().getString(e(paramString), "");
    QLog.d("RFWDownloader", 1, "checkResource url:" + paramString + " isDownloaded:" + bool + "  preMd5" + str);
    a().newCall(a(paramString)).enqueue(new aaac(this, paramString, paramzzv, bool, str));
  }
  
  public boolean a(String paramString)
  {
    paramString = new File(b(paramString));
    if (bhrw.a() == null) {}
    while ((!paramString.exists()) || ((!paramString.isFile()) && ((!paramString.isDirectory()) || (paramString.listFiles() == null) || (paramString.listFiles().length <= 0)))) {
      return false;
    }
    return true;
  }
  
  public String b(String paramString)
  {
    if (c(paramString)) {
      return this.jdField_a_of_type_Zzy.b() + d(paramString) + File.separator;
    }
    return a(paramString);
  }
  
  public void b(String paramString, aaad paramaaad)
  {
    ThreadManagerV2.executeOnFileThread(new RFWDownloader.3(this, paramaaad, paramString));
  }
  
  public boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzz
 * JD-Core Version:    0.7.0.1
 */