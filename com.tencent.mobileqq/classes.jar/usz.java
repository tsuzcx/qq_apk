import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class usz
  implements ISPlayerPreDownloader.Listener, usn<Object, SuperPlayerVideoInfo>
{
  private ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private uso jdField_a_of_type_Uso;
  
  public usz(ISPlayerPreDownloader paramISPlayerPreDownloader)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = paramISPlayerPreDownloader;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.setOnPreDownloadListener(this);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.stopAllPreDownload();
  }
  
  public void a(usj<Object, SuperPlayerVideoInfo> paramusj)
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) || (paramusj == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo)paramusj.d(), paramusj.b, 2000L);
  }
  
  public void a(uso paramuso)
  {
    this.jdField_a_of_type_Uso = paramuso;
  }
  
  public boolean a(usj<Object, SuperPlayerVideoInfo> paramusj)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.destory();
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {}
  
  public void onPrepareError(int paramInt)
  {
    if (this.jdField_a_of_type_Uso == null) {
      return;
    }
    this.jdField_a_of_type_Uso.a("", 0, "");
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    uya.b("SuperPlayerPreDownloader", "[SuperPlayerPreDownloader.java][onPrepareSuccess] taskId:" + paramInt);
    if (this.jdField_a_of_type_Uso == null) {
      return;
    }
    this.jdField_a_of_type_Uso.a("", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usz
 * JD-Core Version:    0.7.0.1
 */