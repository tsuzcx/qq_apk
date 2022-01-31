import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloGameArkHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class yjr
  implements Runnable
{
  public yjr(ApolloGameArkHandler paramApolloGameArkHandler, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    Object localObject;
    do
    {
      Setting localSetting;
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler.a();
        } while (localObject == null);
        localSetting = ((QQAppInterface)localObject).c(this.jdField_a_of_type_JavaLangString);
      } while ((localSetting == null) || (TextUtils.isEmpty(localSetting.url)));
      localObject = MsfSdkUtils.insertMtype("QQHeadIcon", ((FriendListHandler)((QQAppInterface)localObject).a(1)).a().a(localSetting.url, localSetting.bFaceFlags, localSetting.bUsrType, 0));
    } while (TextUtils.isEmpty((CharSequence)localObject));
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler.a(this.jdField_a_of_type_JavaLangString, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yjr
 * JD-Core Version:    0.7.0.1
 */