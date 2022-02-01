import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueLoaderManager.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaSDKManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

public class tsx
{
  private static volatile tsx jdField_a_of_type_Tsx;
  private List<WeakReference<tta>> jdField_a_of_type_JavaUtilList;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public static tsx a()
  {
    if (jdField_a_of_type_Tsx == null) {}
    try
    {
      if (jdField_a_of_type_Tsx == null) {
        jdField_a_of_type_Tsx = new tsx();
      }
      return jdField_a_of_type_Tsx;
    }
    finally {}
  }
  
  private void b(tta paramtta)
  {
    if (paramtta != null)
    {
      paramtta.a();
      QLog.e("NativeVueLoaderManager", 1, "leading success");
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    paramtta = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtta.hasNext())
    {
      tta localtta = (tta)((WeakReference)paramtta.next()).get();
      if (localtta == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeVueLoaderManager", 1, "[onLoadSuccess] listener is null");
        }
      }
      else
      {
        localtta.a();
        if (QLog.isColorLevel()) {
          QLog.d("NativeVueLoaderManager", 2, "[onLoadSuccess listener success]");
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void c(tta paramtta)
  {
    if (paramtta != null)
    {
      paramtta.b();
      QLog.e("NativeVueLoaderManager", 1, "leading error");
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    paramtta = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtta.hasNext())
    {
      tta localtta = (tta)((WeakReference)paramtta.next()).get();
      if (localtta == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeVueLoaderManager", 1, "[onLoadError] listener is null");
        }
      }
      else
      {
        localtta.b();
        if (QLog.isColorLevel()) {
          QLog.d("NativeVueLoaderManager", 2, "[onLoadError listener onError]");
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void d(tta paramtta)
  {
    if (paramtta == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramtta));
    } while (!QLog.isColorLevel());
    QLog.d("NativeVueLoaderManager", 1, "add waiter");
  }
  
  public void a()
  {
    int i = 1;
    if (Aladdin.getConfig(336).getIntegerFromString("disable_native_vue_predownload", 0) == 1) {}
    while (i != 0)
    {
      return;
      i = 0;
    }
    ViolaSDKManager.getInstance().getDomManager().post(new NativeVueLoaderManager.2(this));
  }
  
  public void a(tta paramtta)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramtta.a();
      return;
    }
    if (this.b)
    {
      d(paramtta);
      return;
    }
    this.b = true;
    bcof.a().a("nativevue", new tsy(this, paramtta));
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return "1".equals(Uri.parse(paramString).getQueryParameter("supportNV"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsx
 * JD-Core Version:    0.7.0.1
 */