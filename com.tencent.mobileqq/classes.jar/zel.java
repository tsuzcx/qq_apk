import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class zel
  implements Runnable
{
  private int jdField_a_of_type_Int = 2;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public zel(GroupIconHelper paramGroupIconHelper, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (GroupIconHelper.a(paramString))
    {
      this.jdField_a_of_type_JavaLangString = GroupIconHelper.b(paramString);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    zem localzem1;
    label56:
    Object localObject3;
    do
    {
      return;
      localzem1 = (zem)GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).get(this.jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      localzem1 = (zem)GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).get(GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      if ((localzem1 == null) && (this.jdField_a_of_type_Int != 3)) {
        break label1047;
      }
      localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        localzem1 = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString, true, localzem1, false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckAndCreateDisIcon Done: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + localzem1.jdField_a_of_type_Boolean);
        }
        break;
      }
    } while (!localzem1.jdField_a_of_type_Boolean);
    Object localObject2;
    label247:
    String[] arrayOfString;
    int j;
    int i;
    if (localzem1.c)
    {
      GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      return;
      localObject2 = this.jdField_a_of_type_JavaLangString;
      if (localzem1 == null) {
        break label1043;
      }
      try
      {
        if (localzem1.jdField_a_of_type_JavaLangString != null) {
          break label1043;
        }
        localzem1 = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString, false, localzem1, true);
        if (localzem1 == null)
        {
          QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. iconinfo is null, disUin=" + this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + " ,isSyncFace=" + localzem2.jdField_b_of_type_Boolean + ", faceUinSet=" + localzem2.jdField_a_of_type_JavaLangString);
      }
      localzem2.e = true;
      if (!localzem2.jdField_b_of_type_Boolean)
      {
        localzem2.jdField_b_of_type_Boolean = true;
        localzem2.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((localzem2.jdField_a_of_type_JavaLangString != null) && (localzem2.jdField_a_of_type_JavaLangString.length() > 1))
        {
          arrayOfString = localzem2.jdField_a_of_type_JavaLangString.split(";");
          if (arrayOfString != null)
          {
            j = arrayOfString.length;
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (str.length() != 0)) {
          if (!((QQAppInterface)localObject3).a(1, str, 0)) {
            ((FriendListHandler)((QQAppInterface)localObject3).a(1)).a(str, (byte)0, (byte)2);
          } else {
            localzem2.jdField_a_of_type_JavaUtilArrayList.add(str);
          }
        }
      }
      else
      {
        try
        {
          QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + localzem2.toString());
          if ((localzem2.jdField_a_of_type_Byte == 2) && (localzem2.jdField_b_of_type_JavaLangString != null))
          {
            localObject3 = GroupIconHelper.a(localzem2.jdField_a_of_type_JavaUtilArrayList, false);
            if (localzem2.jdField_b_of_type_JavaLangString.equals(localObject3)) {
              return;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.qqhead.dih", 2, "TYPE_CREAT", localException);
            }
          }
          i = localzem2.jdField_a_of_type_JavaUtilArrayList.size();
          if ((i >= localzem2.jdField_a_of_type_Int) || ((localzem2.jdField_a_of_type_Byte == 1) && (i >= 4) && (localzem2.jdField_a_of_type_Int > 4)) || ((localzem2.jdField_a_of_type_Byte == 2) && (i > 0)) || (localzem2.d))
          {
            GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString, localzem2, false);
            if (i >= localzem2.jdField_a_of_type_Int) {
              GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).remove(this.jdField_a_of_type_JavaLangString);
            }
          }
          if ((i < localzem2.jdField_a_of_type_Int) && (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper) == null)) {}
          synchronized (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper))
          {
            if (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper) == null)
            {
              GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, new zej(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, null));
              ThreadManager.post(GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper), 8, null, false);
            }
            return;
          }
        }
        GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString);
        return;
        ??? = new zem(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, null);
        ??? = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString, true, (zem)???, true);
        boolean bool;
        if (((zem)???).jdField_a_of_type_Boolean) {
          if (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).containsKey(this.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.d(this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.a(this.jdField_a_of_type_JavaLangString);
            bool = true;
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + ((zem)???).jdField_a_of_type_Boolean + ", isCreated=" + bool);
          return;
          localObject2 = new File(localObject4.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0));
          if ((localObject2 != null) && (((File)localObject2).exists())) {
            ((File)localObject2).delete();
          }
          if (localObject4 != null) {
            localObject4.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0);
          }
          GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).remove(this.jdField_a_of_type_JavaLangString);
          bool = false;
          continue;
          GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).remove(this.jdField_a_of_type_JavaLangString);
          bool = false;
        }
        break;
        label1043:
        break label247;
        break label56;
        label1047:
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zel
 * JD-Core Version:    0.7.0.1
 */