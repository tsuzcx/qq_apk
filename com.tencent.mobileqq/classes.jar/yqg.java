import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class yqg
  extends Handler
{
  public yqg(ApolloManager paramApolloManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == ApolloManager.jdField_a_of_type_Int)
    {
      paramMessage = (VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (paramMessage != null) {
        localObject = new ArrayList(ApolloManager.jdField_a_of_type_JavaUtilVector.size());
      }
    }
    while (paramMessage.what != ApolloManager.jdField_b_of_type_Int)
    {
      try
      {
        Iterator localIterator = ApolloManager.jdField_a_of_type_JavaUtilVector.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!((ArrayList)localObject).contains(str)) {
            ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(str)));
          }
        }
        paramMessage.a((ArrayList)localObject, "troop");
      }
      catch (Exception localException) {}
      for (;;)
      {
        ApolloManager.jdField_a_of_type_JavaUtilVector.clear();
        if (ApolloManager.jdField_b_of_type_JavaUtilVector.size() > 0)
        {
          paramMessage.a((String[])ApolloManager.jdField_b_of_type_JavaUtilVector.toArray(new String[0]));
          ApolloManager.jdField_b_of_type_JavaUtilVector.clear();
        }
        return;
        if ((ApolloManager.a(this.a) != null) && (ApolloManager.a(this.a).apolloLocalTS != ApolloManager.a(this.a).apolloServerTS) && (!((ArrayList)localObject).contains(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
          ((ArrayList)localObject).add(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
        }
      }
    }
    Object localObject = (String)paramMessage.obj;
    if (paramMessage.arg1 == 1) {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!ApolloManager.jdField_a_of_type_JavaUtilVector.contains(localObject)))
      {
        ApolloManager.jdField_a_of_type_JavaUtilVector.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->dress uin:" + (String)localObject);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(ApolloManager.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(ApolloManager.jdField_a_of_type_Int, 200L);
      return;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!ApolloManager.jdField_b_of_type_JavaUtilVector.contains(localObject)))
      {
        ApolloManager.jdField_b_of_type_JavaUtilVector.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->info uin:" + (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqg
 * JD-Core Version:    0.7.0.1
 */