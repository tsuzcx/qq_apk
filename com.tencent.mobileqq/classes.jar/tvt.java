import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class tvt
{
  public static final String a;
  private static tvt jdField_a_of_type_Tvt;
  private static final String b = tqb.c;
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<tvv>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = tvt.class.getSimpleName();
  }
  
  public static tvt a()
  {
    if (jdField_a_of_type_Tvt == null) {}
    try
    {
      if (jdField_a_of_type_Tvt == null) {
        jdField_a_of_type_Tvt = new tvt();
      }
      return jdField_a_of_type_Tvt;
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
      ThreadManagerV2.executeOnFileThread(new QCircleResourceDownloadManager.1(this, paramString1, str, paramString2));
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
    paramString1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    if (paramString1 == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramString1.values().iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null))
        {
          ((tvv)localWeakReference.get()).a(paramBoolean, paramString2);
          paramString1.remove(Integer.valueOf(((tvv)localWeakReference.get()).hashCode()));
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
  
  private void b(String paramString, tvv paramtvv)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramtvv.hashCode()), new WeakReference(paramtvv));
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
  
  public void a(String paramString, tvv paramtvv)
  {
    String str = a(paramString);
    File localFile = new File(str);
    if (bdij.a() == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "getFile error, SdCardUtil.getSdCardDirectory() == null");
      if (paramtvv != null) {
        paramtvv.a(false, "");
      }
    }
    if (localFile.exists())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "getFile success, the file is exist path:" + str);
      if (paramtvv != null) {
        paramtvv.a(true, str);
      }
      return;
    }
    if (paramtvv != null) {
      b(paramString, paramtvv);
    }
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "getFile ..., file is downloading");
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "getFile ..., start download");
    a(paramString);
  }
  
  public void a(String[] paramArrayOfString, tvv paramtvv)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        a(paramArrayOfString[i], paramtvv);
        i += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = new File(a(paramString));
    if (bdij.a() == null) {
      return false;
    }
    return paramString.exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvt
 * JD-Core Version:    0.7.0.1
 */