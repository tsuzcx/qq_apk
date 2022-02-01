import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class vhk
  implements ISPlayerPreDownloader.Listener, vgy<Object, SuperPlayerVideoInfo>
{
  private ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private vgz jdField_a_of_type_Vgz;
  
  public vhk(ISPlayerPreDownloader paramISPlayerPreDownloader)
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
  
  public void a(vgu<Object, SuperPlayerVideoInfo> paramvgu)
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) || (paramvgu == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo)paramvgu.d(), paramvgu.b, 2000L);
  }
  
  public void a(vgz paramvgz)
  {
    this.jdField_a_of_type_Vgz = paramvgz;
  }
  
  public boolean a(vgu<Object, SuperPlayerVideoInfo> paramvgu)
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
    if (this.jdField_a_of_type_Vgz == null) {
      return;
    }
    this.jdField_a_of_type_Vgz.a("", 0, "");
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    vmp.b("SuperPlayerPreDownloader", "[SuperPlayerPreDownloader.java][onPrepareSuccess] taskId:" + paramInt);
    if (this.jdField_a_of_type_Vgz == null) {
      return;
    }
    this.jdField_a_of_type_Vgz.a("", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhk
 * JD-Core Version:    0.7.0.1
 */