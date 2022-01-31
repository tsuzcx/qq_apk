import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class twl
{
  private static volatile twl jdField_a_of_type_Twl;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private List<QQCircleFeedBase.StTabInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, twm> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = QzoneConfig.getQQCircleEnableFolderPageCache();
  private final long jdField_b_of_type_Long = QzoneConfig.getQQCircleFolderPageCacheLifeCycle() * 1000;
  private List<QQCircleFeedBase.StPolyLike> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private List<QQCircleBase.UserCircleInfo> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private List<QQCircleBase.UserCircleInfo> d = new ArrayList();
  
  public static twl a()
  {
    if (jdField_a_of_type_Twl == null) {}
    try
    {
      if (jdField_a_of_type_Twl == null) {
        jdField_a_of_type_Twl = new twl();
      }
      return jdField_a_of_type_Twl;
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
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.d.clear();
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(ubm paramubm, int paramInt1, int paramInt2)
  {
    int i = 1;
    QLog.d("QCircleFolderCacheHelper", 1, "savePageCache,pos:" + paramInt1 + ",top:" + paramInt2);
    if (paramubm != null)
    {
      paramubm = twm.a(paramubm, paramInt1, paramInt2);
      if (paramubm != null)
      {
        String str = twm.a(paramubm).tabName.get();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramubm);
        QLog.d("QCircleFolderCacheHelper", 1, "savePageCache success！tapid:" + str);
      }
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      this.jdField_c_of_type_Boolean = (paramInt1 | this.jdField_c_of_type_Boolean);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
  }
  
  public void a(ubv paramubv)
  {
    b();
    if (paramubv != null)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramubv.a());
      this.jdField_b_of_type_JavaUtilList.addAll(paramubv.b());
      this.jdField_c_of_type_JavaUtilList.addAll(paramubv.c());
      this.jdField_c_of_type_JavaUtilList.addAll(paramubv.d());
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public boolean a(ubm paramubm)
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
    if (paramubm != null)
    {
      Object localObject = paramubm.a();
      if (localObject != null)
      {
        localObject = ((QQCircleFeedBase.StTabInfo)localObject).tabName.get();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          twm localtwm = (twm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          if (localtwm != null)
          {
            paramubm.a(twm.a(localtwm), twm.a(localtwm), twm.a(localtwm), twm.a(localtwm), twm.a(localtwm));
            paramubm.b(twm.a(localtwm), twm.b(localtwm));
            QLog.d("QCircleFolderCacheHelper", 1, "readPageCache success！tapid:" + (String)localObject + ",pos:" + twm.a(localtwm) + ",top:" + twm.b(localtwm));
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(ubv paramubv)
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
    } while (paramubv == null);
    paramubv.a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.d);
    paramubv.b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twl
 * JD-Core Version:    0.7.0.1
 */