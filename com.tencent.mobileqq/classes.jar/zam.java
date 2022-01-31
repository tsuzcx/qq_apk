import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnAudioDownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public final class zam
  extends DownloadListener
{
  public zam(int paramInt, ApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnAudioDownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnAudioDownloadListener.a(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + paramDownloadTask.a());
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnAudioDownloadListener == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnAudioDownloadListener.a(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zam
 * JD-Core Version:    0.7.0.1
 */