import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil.NotifyGameDressReady;
import com.tencent.mobileqq.app.QQAppInterface;

public final class zcv
  implements ApolloResDownloader.OnApolloDownLoadListener
{
  public zcv(ApolloGameBasicEventUtil.NotifyGameDressReady paramNotifyGameDressReady, int paramInt, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ApolloDress paramApolloDress, int[] paramArrayOfInt) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameBasicEventUtil$NotifyGameDressReady != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameBasicEventUtil$NotifyGameDressReady.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloDress.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zcv
 * JD-Core Version:    0.7.0.1
 */