import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;

public class ciy
  implements MediaScannerConnection.MediaScannerConnectionClient
{
  MediaScannerConnection jdField_a_of_type_AndroidMediaMediaScannerConnection;
  final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  final String b;
  
  public ciy(PhotoListActivity paramPhotoListActivity, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramPhotoListActivity = new MediaScannerConnection(paramContext, this);
    paramPhotoListActivity.connect();
    this.jdField_a_of_type_AndroidMediaMediaScannerConnection = paramPhotoListActivity;
  }
  
  public void onMediaScannerConnected()
  {
    this.jdField_a_of_type_AndroidMediaMediaScannerConnection.scanFile(this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public void onScanCompleted(String paramString, Uri paramUri)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.runOnUiThread(new ciz(this));
    }
    this.jdField_a_of_type_AndroidMediaMediaScannerConnection.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ciy
 * JD-Core Version:    0.7.0.1
 */