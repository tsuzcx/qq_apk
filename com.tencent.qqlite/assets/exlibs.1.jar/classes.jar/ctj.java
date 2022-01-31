import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class ctj
  implements Runnable
{
  public static final int a = 1;
  public static final int b = 3;
  public static final int c = 2;
  private String jdField_a_of_type_JavaLangString;
  private int d = 2;
  
  public ctj(DiscussionIconHelper paramDiscussionIconHelper, int paramInt, String paramString)
  {
    this.d = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaLangString == null) {}
    Object localObject3;
    do
    {
      do
      {
        return;
        localObject3 = (cti)DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).get(this.jdField_a_of_type_JavaLangString);
      } while ((localObject3 == null) && (this.d != 3));
      switch (this.d)
      {
      default: 
        return;
      case 1: 
        localObject1 = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString, true, (cti)localObject3, false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckAndCreateDisIcon Done: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + ((cti)localObject1).jdField_a_of_type_Boolean);
        }
        break;
      }
    } while (!((cti)localObject1).jdField_a_of_type_Boolean);
    DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString);
    return;
    String str1 = this.jdField_a_of_type_JavaLangString;
    Object localObject1 = localObject3;
    if (localObject3 != null) {
      localObject1 = localObject3;
    }
    try
    {
      if (((cti)localObject3).jdField_a_of_type_JavaLangString == null) {
        localObject1 = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString, false, (cti)localObject3, true);
      }
      if (localObject1 == null) {
        return;
      }
    }
    finally {}
    int j;
    if (!localcti.jdField_b_of_type_Boolean)
    {
      localcti.jdField_b_of_type_Boolean = true;
      localcti.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((localcti.jdField_a_of_type_JavaLangString != null) && (localcti.jdField_a_of_type_JavaLangString.length() > 1))
      {
        localObject3 = localcti.jdField_a_of_type_JavaLangString.split(";");
        if (localObject3 != null) {
          j = localObject3.length;
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        String str2 = localObject3[i];
        if ((str2 != null) && (str2.length() != 0)) {
          if (!DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).a(1, str2, 0)) {
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).a().a(str2, (byte)0, (byte)2);
          } else {
            localcti.jdField_a_of_type_JavaUtilArrayList.add(str2);
          }
        }
      }
      else
      {
        if ((localcti.jdField_a_of_type_Byte == 2) && (localcti.jdField_b_of_type_JavaLangString != null))
        {
          localObject3 = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, localcti.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, false);
          if (localcti.jdField_b_of_type_JavaLangString.equals(localObject3)) {
            return;
          }
        }
        i = localcti.jdField_a_of_type_JavaUtilArrayList.size();
        if ((i >= localcti.jdField_a_of_type_Int) || ((localcti.jdField_a_of_type_Byte == 1) && (i >= 4) && (localcti.jdField_a_of_type_Int > 4)) || ((localcti.jdField_a_of_type_Byte == 2) && (i > 0)))
        {
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString, localcti, false);
          if (i >= localcti.jdField_a_of_type_Int) {
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).remove(this.jdField_a_of_type_JavaLangString);
          }
        }
        if ((i < localcti.jdField_a_of_type_Int) && (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper) == null)) {}
        synchronized (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper))
        {
          if (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper) == null)
          {
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, new ctg(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, null));
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).setName("CheckDisIconThread");
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).start();
          }
          return;
        }
        ??? = new cti(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, null);
        ??? = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString, true, (cti)???, true);
        if (((cti)???).jdField_a_of_type_Boolean) {
          if (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).containsKey(this.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.e(this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.b(this.jdField_a_of_type_JavaLangString);
          }
        }
        for (boolean bool = true; QLog.isColorLevel(); bool = false)
        {
          QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + ((cti)???).jdField_a_of_type_Boolean + ", isCreated=" + bool);
          return;
          File localFile = new File(DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).a.a(101, this.jdField_a_of_type_JavaLangString, 0));
          if ((localFile != null) && (localFile.exists())) {
            localFile.delete();
          }
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).a(101, this.jdField_a_of_type_JavaLangString, 0);
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).remove(this.jdField_a_of_type_JavaLangString);
        }
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ctj
 * JD-Core Version:    0.7.0.1
 */