import android.util.Pair;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class zej
  implements Runnable
{
  public boolean a;
  
  private zej(GroupIconHelper paramGroupIconHelper)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread start.");
    }
    int i;
    long l;
    Object localObject4;
    label62:
    Object localObject7;
    zem localzem;
    label319:
    label334:
    int j;
    boolean bool1;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 0;
      l = System.currentTimeMillis();
      localObject4 = null;
      Object localObject1 = null;
      for (;;)
      {
        synchronized (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper))
        {
          Iterator localIterator = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).keySet().iterator();
          if (!localIterator.hasNext()) {
            break label604;
          }
          localObject7 = (String)localIterator.next();
          localzem = (zem)GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).get(localObject7);
          if ((localzem != null) && (localzem.jdField_b_of_type_Int >= 8))
          {
            if ((GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper) instanceof DiscussionHandler)) {
              ((DiscussionHandler)GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper)).a(false, true, (String)localObject7);
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon, maxCreateCnt: " + (String)localObject7 + ",crateIconCount=" + localzem.jdField_b_of_type_Int);
          }
        }
        if ((localzem != null) && (!localzem.e))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon isFromCreate: " + (String)localObject7 + ",fromCreate is false");
          }
        }
        else
        {
          if ((localzem == null) || (localzem.jdField_a_of_type_JavaLangString == null) || (localzem.jdField_a_of_type_Byte == 3)) {
            break label866;
          }
          if ((localzem.jdField_a_of_type_Byte == 1) && (l - localzem.jdField_a_of_type_Long >= GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper)))
          {
            if (localObject4 != null) {
              break label875;
            }
            localObject4 = new ArrayList();
            if (!GroupIconHelper.a((String)localObject7)) {
              break label872;
            }
            localObject7 = GroupIconHelper.b((String)localObject7);
            j = localzem.jdField_a_of_type_JavaUtilArrayList.size();
            localzem.jdField_a_of_type_Byte = 2;
            if (j <= 0) {
              break label885;
            }
            bool2 = true;
            bool1 = bool2;
            if (localzem.jdField_b_of_type_JavaLangString != null)
            {
              String str = GroupIconHelper.a(localzem.jdField_a_of_type_JavaUtilArrayList, false);
              bool1 = bool2;
              if (localzem.jdField_b_of_type_JavaLangString.equals(str)) {
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (bool1)
            {
              ((ArrayList)localObject4).add(Pair.create(localObject7, localzem));
              GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).remove(localObject7);
            }
          }
        }
      }
    }
    label604:
    label866:
    label869:
    label872:
    label875:
    label878:
    label882:
    label885:
    for (boolean bool2 = bool1;; bool2 = false)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qqhead.dih", 2, "CheckDisIcon expired: " + (String)localObject7 + ", isTryCreate: " + bool2 + localzem.toString());
        break label878;
        if ((localzem.jdField_a_of_type_Byte == 2) && (l - localzem.jdField_a_of_type_Long >= GroupIconHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon timeout: " + (String)localObject7 + localzem.toString());
          }
          if (localObject2 != null) {
            break label869;
          }
          ??? = new ArrayList();
        }
        for (;;)
        {
          for (;;)
          {
            ((ArrayList)???).add(localObject7);
            i += 1;
            break label882;
            if (localzem.jdField_a_of_type_Byte == 3) {
              break label866;
            }
            i += 1;
            break label882;
            if ((this.jdField_a_of_type_Boolean) && (localObject4 != null))
            {
              j = 0;
              while ((j < ((ArrayList)localObject4).size()) && (this.jdField_a_of_type_Boolean))
              {
                localObject7 = (Pair)((ArrayList)localObject4).get(j);
                GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, (String)((Pair)localObject7).first, (zem)((Pair)localObject7).second, true);
                j += 1;
              }
            }
            if ((this.jdField_a_of_type_Boolean) && (??? != null))
            {
              j = 0;
              while ((j < ((ArrayList)???).size()) && (this.jdField_a_of_type_Boolean))
              {
                localObject4 = (String)((ArrayList)???).get(j);
                this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.b((String)localObject4);
                j += 1;
              }
            }
            if (i == 0) {}
            synchronized (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper))
            {
              GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, null);
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread exit. isRunning=" + this.jdField_a_of_type_Boolean);
              }
              return;
              if (!this.jdField_a_of_type_Boolean) {
                break;
              }
            }
          }
          try
          {
            synchronized (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper))
            {
              GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).wait(GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper) / 10);
            }
            localObject6 = finally;
            throw localObject6;
          }
          catch (InterruptedException localInterruptedException)
          {
            break label839;
          }
          break label882;
        }
        break label334;
        break label319;
      }
      i += 1;
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zej
 * JD-Core Version:    0.7.0.1
 */