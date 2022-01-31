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

public class zlm
  implements Runnable
{
  private int jdField_a_of_type_Int = 2;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public zlm(GroupIconHelper paramGroupIconHelper, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (GroupIconHelper.a(paramString))
    {
      this.jdField_a_of_type_JavaLangString = GroupIconHelper.b(paramString);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    zln localzln1;
    label56:
    Object localObject3;
    do
    {
      return;
      localzln1 = (zln)GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).get(this.jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      localzln1 = (zln)GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).get(GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      if ((localzln1 == null) && (this.jdField_a_of_type_Int != 3)) {
        break label1047;
      }
      localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        localzln1 = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString, true, localzln1, false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckAndCreateDisIcon Done: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + localzln1.jdField_a_of_type_Boolean);
        }
        break;
      }
    } while (!localzln1.jdField_a_of_type_Boolean);
    Object localObject2;
    label247:
    String[] arrayOfString;
    int j;
    int i;
    if (localzln1.c)
    {
      GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      return;
      localObject2 = this.jdField_a_of_type_JavaLangString;
      if (localzln1 == null) {
        break label1043;
      }
      try
      {
        if (localzln1.jdField_a_of_type_JavaLangString != null) {
          break label1043;
        }
        localzln1 = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString, false, localzln1, true);
        if (localzln1 == null)
        {
          QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. iconinfo is null, disUin=" + this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + " ,isSyncFace=" + localzln2.jdField_b_of_type_Boolean + ", faceUinSet=" + localzln2.jdField_a_of_type_JavaLangString);
      }
      localzln2.e = true;
      if (!localzln2.jdField_b_of_type_Boolean)
      {
        localzln2.jdField_b_of_type_Boolean = true;
        localzln2.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((localzln2.jdField_a_of_type_JavaLangString != null) && (localzln2.jdField_a_of_type_JavaLangString.length() > 1))
        {
          arrayOfString = localzln2.jdField_a_of_type_JavaLangString.split(";");
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
            localzln2.jdField_a_of_type_JavaUtilArrayList.add(str);
          }
        }
      }
      else
      {
        try
        {
          QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + localzln2.toString());
          if ((localzln2.jdField_a_of_type_Byte == 2) && (localzln2.jdField_b_of_type_JavaLangString != null))
          {
            localObject3 = GroupIconHelper.a(localzln2.jdField_a_of_type_JavaUtilArrayList, false);
            if (localzln2.jdField_b_of_type_JavaLangString.equals(localObject3)) {
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
          i = localzln2.jdField_a_of_type_JavaUtilArrayList.size();
          if ((i >= localzln2.jdField_a_of_type_Int) || ((localzln2.jdField_a_of_type_Byte == 1) && (i >= 4) && (localzln2.jdField_a_of_type_Int > 4)) || ((localzln2.jdField_a_of_type_Byte == 2) && (i > 0)) || (localzln2.d))
          {
            GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString, localzln2, false);
            if (i >= localzln2.jdField_a_of_type_Int) {
              GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).remove(this.jdField_a_of_type_JavaLangString);
            }
          }
          if ((i < localzln2.jdField_a_of_type_Int) && (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper) == null)) {}
          synchronized (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper))
          {
            if (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper) == null)
            {
              GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, new zlk(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, null));
              ThreadManager.post(GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper), 8, null, false);
            }
            return;
          }
        }
        GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString);
        return;
        ??? = new zln(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, null);
        ??? = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper, this.jdField_a_of_type_JavaLangString, true, (zln)???, true);
        boolean bool;
        if (((zln)???).jdField_a_of_type_Boolean) {
          if (GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper).containsKey(this.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.d(this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.a(this.jdField_a_of_type_JavaLangString);
            bool = true;
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + ((zln)???).jdField_a_of_type_Boolean + ", isCreated=" + bool);
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
  
  public void run()
  {
    a();
    GroupIconHelper localGroupIconHelper = this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper;
    localGroupIconHelper.b -= 1;
    GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zlm
 * JD-Core Version:    0.7.0.1
 */