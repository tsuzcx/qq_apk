import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantItemData;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager.onShareAlbumResultListener;
import com.tencent.qphone.base.util.QLog;

public class gjh
  implements QZoneShareAlbumAssistantManager.onShareAlbumResultListener
{
  public gjh(QZoneShareAlbumAssistantActivity paramQZoneShareAlbumAssistantActivity) {}
  
  public void a(QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData)
  {
    QZoneShareAlbumAssistantManager.a().h(this.a.b);
    QZoneShareAlbumAssistantActivity.a(this.a, paramQZoneShareAlbumAssistantItemData);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantActivity", 2, "ShareAlbum ondata Rsp");
    }
    QZoneShareAlbumAssistantActivity.a(this.a, false);
    QZoneShareAlbumAssistantActivity.a(this.a);
    this.a.runOnUiThread(new gji(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjh
 * JD-Core Version:    0.7.0.1
 */