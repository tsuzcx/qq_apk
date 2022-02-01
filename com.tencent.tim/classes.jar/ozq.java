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

public class ozq
{
  public static final String TAG = ozq.class.getSimpleName();
  private static OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  private static ozq jdField_a_of_type_Ozq;
  private static final String arA = oug.arv;
  private Set<String> ax = Collections.synchronizedSet(new HashSet());
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<ozq.a>>> bI = new ConcurrentHashMap();
  
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
  
  public static ozq a()
  {
    if (jdField_a_of_type_Ozq == null) {}
    try
    {
      if (jdField_a_of_type_Ozq == null) {
        jdField_a_of_type_Ozq = new ozq();
      }
      return jdField_a_of_type_Ozq;
    }
    finally {}
  }
  
  private void aT(String paramString)
  {
    cg(paramString, "");
  }
  
  private void b(String paramString, ozq.a parama)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.bI.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(parama.hashCode()), new WeakReference(parama));
    this.bI.put(paramString, localConcurrentHashMap1);
    QLog.d(TAG, 2, "add GetFileListener url:" + paramString + " size:" + localConcurrentHashMap1.size());
  }
  
  private void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.bI.get(paramString1);
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
          localObject = (ozq.a)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((ozq.a)localObject).C(paramBoolean, paramString2);
            localConcurrentHashMap.remove(Integer.valueOf(localObject.hashCode()));
            QLog.e(TAG, 1, "downloadUrl:" + paramString1 + "success");
          }
          else
          {
            QLog.e(TAG, 1, "downloadUrl:" + paramString1 + "  getFileListener release");
          }
        }
        else
        {
          QLog.e(TAG, 1, "downloadUrl:" + paramString1 + "WeakReference null");
        }
      }
    }
  }
  
  private void cg(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(fG(paramString1)))
    {
      QLog.e(TAG, 1, "downloadError encodePath is Empty");
      return;
    }
    String str = fH(paramString1);
    try
    {
      ThreadManagerV2.executeOnFileThread(new QCircleResourceDownloadManager.2(this, paramString1, str, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(TAG, 1, "error " + paramString1.getMessage());
      paramString1.printStackTrace();
    }
  }
  
  private void ch(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      oue.i().edit().putString(fJ(paramString1), paramString2).apply();
    }
  }
  
  private boolean eN(String paramString)
  {
    return paramString.endsWith(".zip");
  }
  
  private String fG(String paramString)
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
  
  private String fH(String paramString)
  {
    return arA + fG(paramString);
  }
  
  private String fI(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    return String.valueOf(j) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  private String fJ(String paramString)
  {
    return "X-COS-META-MD5" + paramString;
  }
  
  public void a(String paramString, ozn paramozn)
  {
    if (paramozn == null)
    {
      QLog.d(TAG, 1, "checkResource listener is null");
      return;
    }
    boolean bool = eM(paramString);
    String str = oue.i().getString(fJ(paramString), "");
    QLog.d(TAG, 1, "checkResource url:" + paramString + " isDownloaded:" + bool + "  preMd5" + str);
    a().newCall(a(paramString)).enqueue(new ozt(this, paramozn, bool, str));
  }
  
  public void a(String paramString, ozq.a parama)
  {
    ThreadManagerV2.executeOnFileThread(new QCircleResourceDownloadManager.1(this, paramString, parama));
  }
  
  public void a(String[] paramArrayOfString, ozq.a parama)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        a(paramArrayOfString[i], parama);
        i += 1;
      }
    }
  }
  
  public String aY(String paramString)
  {
    return arA + fI(paramString) + File.separator;
  }
  
  public boolean eM(String paramString)
  {
    paramString = new File(aY(paramString));
    if (aqmb.Cg() == null) {
      return false;
    }
    return paramString.exists();
  }
  
  public static abstract interface a
  {
    public abstract void C(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozq
 * JD-Core Version:    0.7.0.1
 */