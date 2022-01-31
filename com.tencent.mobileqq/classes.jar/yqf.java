import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.data.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class yqf
  implements Runnable
{
  public yqf(ApolloManager paramApolloManager, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList(8);
    ArrayList localArrayList2 = new ArrayList(16);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label808:
    while (localIterator.hasNext())
    {
      ApolloBaseInfo localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a != null) && (localApolloBaseInfo != null))
      {
        Object localObject3 = localApolloBaseInfo.getApolloDress();
        Object localObject1 = localApolloBaseInfo.getApolloPetDress();
        if (localObject3 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (QLog.isColorLevel()) {
            localStringBuilder.append("updateUserDress uin: ").append(localApolloBaseInfo.uin).append(", dress info: ").append(((ApolloDress)localObject3).toString());
          }
          int j = -1;
          long l = this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a(1, ((ApolloDress)localObject3).jdField_a_of_type_Int) / 1000L;
          int i = j;
          if (l != ((ApolloDress)localObject3).jdField_a_of_type_Long)
          {
            i = j;
            if (!localArrayList1.contains(Integer.valueOf(((ApolloDress)localObject3).jdField_a_of_type_Int)))
            {
              j = ((ApolloDress)localObject3).jdField_a_of_type_Int;
              localArrayList1.add(Integer.valueOf(((ApolloDress)localObject3).jdField_a_of_type_Int));
              i = j;
              if (QLog.isColorLevel())
              {
                localStringBuilder.append("\nrole id: ").append(((ApolloDress)localObject3).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((ApolloDress)localObject3).jdField_a_of_type_Long);
                i = j;
              }
            }
          }
          if (((ApolloDress)localObject3).jdField_a_of_type_JavaUtilHashMap != null)
          {
            Object localObject2 = new ArrayList();
            localObject3 = ((ApolloDress)localObject3).jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)((Iterator)localObject3).next()).getValue();
              l = this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a(2, localDress.jdField_a_of_type_Int) / 1000L;
              if ((l != localDress.jdField_a_of_type_Long) && (!localArrayList2.contains(Integer.valueOf(localDress.jdField_a_of_type_Int))))
              {
                ((ArrayList)localObject2).add(Integer.valueOf(localDress.jdField_a_of_type_Int));
                localArrayList2.add(Integer.valueOf(localDress.jdField_a_of_type_Int));
                if (QLog.isColorLevel()) {
                  localStringBuilder.append("\ndress id: ").append(localDress.jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(localDress.jdField_a_of_type_Long);
                }
              }
            }
            if ((localObject1 != null) && (((ApolloDress)localObject1).jdField_a_of_type_JavaUtilHashMap != null))
            {
              localObject1 = ((ApolloDress)localObject1).jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (ApolloDress.Dress)((Map.Entry)((Iterator)localObject1).next()).getValue();
                l = this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a(2, ((ApolloDress.Dress)localObject3).jdField_a_of_type_Int) / 1000L;
                if ((l != ((ApolloDress.Dress)localObject3).jdField_a_of_type_Long) && (!localArrayList2.contains(Integer.valueOf(((ApolloDress.Dress)localObject3).jdField_a_of_type_Int))))
                {
                  ((ArrayList)localObject2).add(Integer.valueOf(((ApolloDress.Dress)localObject3).jdField_a_of_type_Int));
                  localArrayList2.add(Integer.valueOf(((ApolloDress.Dress)localObject3).jdField_a_of_type_Int));
                  if (QLog.isColorLevel()) {
                    localStringBuilder.append("\npet dress id: ").append(((ApolloDress.Dress)localObject3).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((ApolloDress.Dress)localObject3).jdField_a_of_type_Long);
                  }
                }
              }
            }
            localObject1 = null;
            if (((ArrayList)localObject2).size() > 0)
            {
              localObject1 = new int[((ArrayList)localObject2).size()];
              localObject2 = ((ArrayList)localObject2).iterator();
              j = 0;
              while (((Iterator)localObject2).hasNext())
              {
                localObject1[j] = ((Integer)((Iterator)localObject2).next()).intValue();
                j += 1;
              }
            }
            if ((i == -1) && ((localObject1 == null) || (localObject1.length == 0)))
            {
              localObject1 = new ArrayList(1);
              ((ArrayList)localObject1).add(localApolloBaseInfo.uin);
              ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a.a(71)).a(2, true, localObject1);
              if (QLog.isColorLevel()) {
                localStringBuilder.append("\nlocal dress is OK");
              }
            }
            for (;;)
            {
              if (!QLog.isColorLevel()) {
                break label808;
              }
              QLog.d("ApolloManager", 2, localStringBuilder.toString());
              break;
              ApolloResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a, localApolloBaseInfo.uin, this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a(), i, (int[])localObject1, -1, -1, true);
              if (QLog.isColorLevel()) {
                localStringBuilder.append("\ndown load dress");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqf
 * JD-Core Version:    0.7.0.1
 */