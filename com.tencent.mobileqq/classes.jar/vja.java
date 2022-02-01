import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vja
{
  private static volatile vja jdField_a_of_type_Vja;
  private int jdField_a_of_type_Int = uxc.a();
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private List<QQCircleFeedBase.StTabInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, vjb> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = QzoneConfig.getQQCircleEnableFolderPageCache();
  private final long jdField_b_of_type_Long = QzoneConfig.getQQCircleFolderPageCacheLifeCycle() * 1000;
  private List<QQCircleFeedBase.StPolyLike> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private List<QQCircleBase.UserCircleInfo> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private List<QQCircleBase.UserCircleInfo> d = new ArrayList();
  
  public static vja a()
  {
    if (jdField_a_of_type_Vja == null) {}
    try
    {
      if (jdField_a_of_type_Vja == null) {
        jdField_a_of_type_Vja = new vja();
      }
      return jdField_a_of_type_Vja;
    }
    finally {}
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_Boolean) && (l1 - l2 <= this.jdField_b_of_type_Long)) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Vja != null) {
      try
      {
        if (jdField_a_of_type_Vja != null) {
          jdField_a_of_type_Vja = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.d.clear();
  }
  
  public void a()
  {
    c();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, vul paramvul)
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.d("QCircleFolderCacheHelper", 1, "saveTabInfoCache() disable tab info cache,direct return!");
    }
    do
    {
      return;
      c();
      this.jdField_a_of_type_Int = paramInt;
      if (paramvul != null)
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramvul.a());
        this.jdField_b_of_type_JavaUtilList.addAll(paramvul.b());
        this.jdField_c_of_type_JavaUtilList.addAll(paramvul.c());
        this.jdField_c_of_type_JavaUtilList.addAll(paramvul.d());
      }
    } while (this.jdField_a_of_type_JavaUtilList.isEmpty());
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(vtz paramvtz, int paramInt1, int paramInt2)
  {
    int i = 1;
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("QCircleFolderCacheHelper", 1, "savePageCache() disable page cache,direct return!");
      return;
    }
    QLog.d("QCircleFolderCacheHelper", 1, "savePageCache,pos:" + paramInt1 + ",top:" + paramInt2);
    if (paramvtz != null)
    {
      paramvtz = vjb.a(paramvtz, paramInt1, paramInt2);
      if (paramvtz != null)
      {
        String str = vjb.a(paramvtz).tabName.get();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramvtz);
        QLog.d("QCircleFolderCacheHelper", 1, "savePageCache success！tapid:" + str);
      }
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      this.jdField_c_of_type_Boolean = (paramInt1 | this.jdField_c_of_type_Boolean);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  public boolean a(vtz paramvtz)
  {
    if (a())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "checkCacheAlive cache not alive");
      return false;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      a();
      return false;
    }
    if (paramvtz != null)
    {
      Object localObject = paramvtz.a();
      if (localObject != null)
      {
        localObject = ((QQCircleFeedBase.StTabInfo)localObject).tabName.get();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          vjb localvjb = (vjb)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          if (localvjb != null)
          {
            if ((vjb.a(localvjb) <= 1) && (vjb.b(localvjb) == 0))
            {
              QLog.d("QCircleFolderCacheHelper", 1, "user not scroll yet!Don't use cache");
              return false;
            }
            paramvtz.a(vjb.a(localvjb), vjb.a(localvjb), vjb.a(localvjb), vjb.a(localvjb), vjb.b(localvjb), vjb.a(localvjb));
            paramvtz.b(vjb.a(localvjb), vjb.b(localvjb));
            QLog.d("QCircleFolderCacheHelper", 1, "readPageCache success！tapid:" + (String)localObject + ",pos:" + vjb.a(localvjb) + ",top:" + vjb.b(localvjb));
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(vul paramvul)
  {
    if (a())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "checkCacheAlive cache not alive");
      a();
    }
    do
    {
      return false;
      if (!this.jdField_b_of_type_Boolean)
      {
        a();
        return false;
      }
    } while (paramvul == null);
    paramvul.a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.d);
    paramvul.a(this.jdField_a_of_type_Int);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vja
 * JD-Core Version:    0.7.0.1
 */