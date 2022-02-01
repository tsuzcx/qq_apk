import com.tencent.biz.qqcircle.beans.Friend;
import com.tencent.biz.qqcircle.requests.QCircleGetFollowListRequest;
import com.tencent.biz.qqcircle.utils.QCircleDoubleFollowUserHepler.2;
import com.tencent.biz.qqcircle.utils.QCircleDoubleFollowUserHepler.3;
import com.tencent.biz.qqcircle.utils.QCircleDoubleFollowUserHepler.4;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class vtj
{
  private static vtj jdField_a_of_type_Vtj;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ArrayList<Friend> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<Friend> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private vtj()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {}
    while (!(localAppRuntime instanceof QQAppInterface)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
  }
  
  private ArrayList<RecentUser> a(List<Friend> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (Friend)localIterator.next();
      if (paramList != null)
      {
        if (uxx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramList.mUin))) {}
        for (paramList = new RecentUser(String.valueOf(paramList.mUin), 0);; paramList = new RecentUser(String.valueOf(paramList.mUin), 10008))
        {
          localArrayList.add(paramList);
          break;
        }
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  public static vtj a()
  {
    if (jdField_a_of_type_Vtj == null) {}
    try
    {
      if (jdField_a_of_type_Vtj == null) {
        jdField_a_of_type_Vtj = new vtj();
      }
      return jdField_a_of_type_Vtj;
    }
    finally {}
  }
  
  private void a(String paramString, long paramLong)
  {
    VSNetworkHelper.a().a(new QCircleGetFollowListRequest(paramString, paramLong), new vtk(this));
  }
  
  private ArrayList<Entity> b(List<Friend> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Friend localFriend = (Friend)paramList.next();
      if (localFriend != null)
      {
        Friends localFriends = new Friends();
        localFriends.uin = String.valueOf(localFriend.mUin);
        localFriends.name = localFriend.mName;
        localFriends.remark = localFriend.mName;
        localArrayList.add(localFriends);
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Vtj != null) {
      try
      {
        if (jdField_a_of_type_Vtj != null) {
          jdField_a_of_type_Vtj = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public ArrayList<RecentUser> a()
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      localObject1 = a(this.jdField_a_of_type_JavaUtilList);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(Friend.class);
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.i("QCircleDoubleFollowUserHepler", 2, "there has no double friends");
    return null;
    return a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    if (System.currentTimeMillis() - uwz.a().b() > QzoneConfig.getQQCircleGetFollowUserInternal())
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      a(null, 0L);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    label89:
    label127:
    do
    {
      long l;
      Friend localFriend;
      try
      {
        l = Long.parseLong(paramString1);
        if (paramBoolean) {
          break label127;
        }
        paramString2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString2.hasNext())
        {
          localFriend = (Friend)paramString2.next();
          if ((localFriend != null) && (localFriend.mUin == l))
          {
            this.jdField_a_of_type_JavaUtilList.remove(localFriend);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
              break label89;
            }
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("QCircleDoubleFollowUserHepler", 1, paramString1, new Object[0]);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      ThreadManagerV2.excute(new QCircleDoubleFollowUserHepler.3(this, paramString1), 32, null, true);
      return;
      paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString1.hasNext())
      {
        localFriend = (Friend)paramString1.next();
        if ((localFriend != null) && (localFriend.mUin == l)) {
          return;
        }
      }
      paramString1 = new Friend(l, paramString2);
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    }
    ThreadManagerV2.excute(new QCircleDoubleFollowUserHepler.4(this, paramString1), 32, null, true);
  }
  
  public void a(List<Friend> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleDoubleFollowUserHepler", 2, "updateRenameList");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
    } while ((paramList == null) || (paramList.size() == 0));
    ThreadManagerV2.excute(new QCircleDoubleFollowUserHepler.2(this, paramList), 32, null, true);
  }
  
  public ArrayList<Entity> b()
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      localObject1 = b(this.jdField_a_of_type_JavaUtilList);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(Friend.class);
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.i("QCircleDoubleFollowUserHepler", 2, "there has no double friends");
    return null;
    return b(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtj
 * JD-Core Version:    0.7.0.1
 */