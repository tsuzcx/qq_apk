import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class zeu
  extends DownloadListener
{
  public zeu(ApolloLottieAnim paramApolloLottieAnim, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.a()) {
      ApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim, true, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "downloadZip onDone task.getStatus()->" + paramDownloadTask.a());
      }
      return;
      ApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim, 2);
      ApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim, false, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zeu
 * JD-Core Version:    0.7.0.1
 */