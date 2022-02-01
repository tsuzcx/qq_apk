import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vle
{
  private static volatile vle jdField_a_of_type_Vle;
  private int jdField_a_of_type_Int = uyn.a();
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private List<QQCircleFeedBase.StTabInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, vlf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = QzoneConfig.getQQCircleEnableFolderPageCache();
  private final long jdField_b_of_type_Long = QzoneConfig.getQQCircleFolderPageCacheLifeCycle() * 1000;
  private List<QQCircleFeedBase.StPolyLike> jdField_b_of_type_JavaUtilList = new ArrayList();
  private List<QQCircleBase.UserCircleInfo> c = new ArrayList();
  private List<QQCircleBase.UserCircleInfo> d = new ArrayList();
  
  public static vle a()
  {
    if (jdField_a_of_type_Vle == null) {}
    try
    {
      if (jdField_a_of_type_Vle == null) {
        jdField_a_of_type_Vle = new vle();
      }
      return jdField_a_of_type_Vle;
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
    QLog.d("QCircleFolderCacheHelper", 1, "releaseInstance");
    if (jdField_a_of_type_Vle != null) {
      try
      {
        if (jdField_a_of_type_Vle != null) {
          jdField_a_of_type_Vle = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void c()
  {
    QLog.d("QCircleFolderCacheHelper", 1, "clearTabCache");
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.c.clear();
    this.d.clear();
  }
  
  private void d()
  {
    QLog.d("QCircleFolderCacheHelper", 1, "clearPageCache");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a()
  {
    c();
    d();
  }
  
  public void a(int paramInt, vxm paramvxm)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("QCircleFolderCacheHelper", 1, "saveTabInfoCache() disable tab info cache,direct return!");
      return;
    }
    c();
    this.jdField_a_of_type_Int = paramInt;
    if ((paramvxm != null) && (!paramvxm.a().isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramvxm.a());
      this.jdField_b_of_type_JavaUtilList.addAll(paramvxm.b());
      this.c.addAll(paramvxm.c());
      this.d.addAll(paramvxm.d());
    }
    int i;
    label120:
    StringBuilder localStringBuilder;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label171;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localStringBuilder = new StringBuilder().append("saveTabInfoCache ");
      if (i == 0) {
        break label179;
      }
    }
    label171:
    label179:
    for (paramvxm = "success";; paramvxm = "fail")
    {
      QLog.d("QCircleFolderCacheHelper", 1, paramvxm + ",currentShowTabType:" + paramInt);
      return;
      i = 0;
      break;
      this.jdField_a_of_type_Long = 0L;
      break label120;
    }
  }
  
  public void a(vwy paramvwy, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("QCircleFolderCacheHelper", 1, "savePageCache fail,disable page cache,direct return!");
      return;
    }
    QLog.d("QCircleFolderCacheHelper", 1, "savePageCache,pos:" + paramInt1 + ",top:" + paramInt2);
    int j = 0;
    int i = j;
    if (paramvwy != null)
    {
      paramvwy = vlf.a(paramvwy, paramInt1, paramInt2);
      i = j;
      if (paramvwy != null)
      {
        String str = vlf.a(paramvwy).tabName.get();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramvwy);
        QLog.d("QCircleFolderCacheHelper", 1, "savePageCache success！tapid:" + str);
        i = 1;
      }
    }
    if (i != 0)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
    QLog.d("QCircleFolderCacheHelper", 1, "savePageCache failed!");
    this.jdField_a_of_type_Long = 0L;
    d();
  }
  
  public boolean a(vwy paramvwy)
  {
    QLog.d("QCircleFolderCacheHelper", 1, "readPageCache");
    if (a())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,checkCacheAlive cache not alive");
      a();
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,page cache is null");
      a();
      return false;
    }
    if (paramvwy != null)
    {
      Object localObject = paramvwy.a();
      if (localObject != null)
      {
        localObject = ((QQCircleFeedBase.StTabInfo)localObject).tabName.get();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          vlf localvlf = (vlf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          if (localvlf != null)
          {
            if ((vlf.a(localvlf) <= 1) && (vlf.b(localvlf) == 0))
            {
              QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,user not scroll yet!Don't use cache");
              return false;
            }
            paramvwy.a(vlf.a(localvlf), vlf.a(localvlf), vlf.a(localvlf), vlf.a(localvlf), vlf.b(localvlf), vlf.a(localvlf));
            if (paramvwy.a(vlf.a(localvlf), vlf.b(localvlf)))
            {
              QLog.d("QCircleFolderCacheHelper", 1, "readPageCache success！tapid:" + (String)localObject + ",pos:" + vlf.a(localvlf) + ",top:" + vlf.b(localvlf));
              return true;
            }
          }
        }
      }
    }
    QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,page cache is null or init error");
    return false;
  }
  
  public boolean a(vxm paramvxm)
  {
    QLog.d("QCircleFolderCacheHelper", 1, "readTabInfoCache");
    if (a())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "readTabInfoCache fail,checkCacheAlive cache not alive");
      a();
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "readTabInfoCache fail,tabInfo cache is null");
      a();
      return false;
    }
    if (paramvxm != null)
    {
      paramvxm.a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.c, this.d);
      if (paramvxm.a(this.jdField_a_of_type_Int))
      {
        QLog.d("QCircleFolderCacheHelper", 1, "readTabInfoCache success");
        return true;
      }
    }
    QLog.d("QCircleFolderCacheHelper", 1, "readTabInfoCache fail,model is null or init error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vle
 * JD-Core Version:    0.7.0.1
 */