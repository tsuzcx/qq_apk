import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zig
  implements Runnable
{
  public zig(ClubContentUpdateHandler paramClubContentUpdateHandler, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler.a.getManager(152);
      int i = ApolloUtil.a(2);
      if (i != this.jdField_a_of_type_Int) {
        localApolloManager.a(2);
      }
      QLog.i("ClubContentUpdateHandler", 1, "handleApolloGameRealTimeUpdate name: " + this.jdField_a_of_type_JavaLangString + ", ver: " + this.jdField_a_of_type_Int + ", locver: " + i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ClubContentUpdateHandler", 1, "handleApolloGameRealTimeUpdate failed, errInfo" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zig
 * JD-Core Version:    0.7.0.1
 */