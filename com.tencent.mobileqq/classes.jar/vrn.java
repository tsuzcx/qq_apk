import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;

public class vrn
  implements TroopMemberApiClient.Callback
{
  public vrn(AIOGalleryAdapter paramAIOGalleryAdapter, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIOImageData paramAIOImageData) {}
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("ThumbnailFile_Large");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a.runOnUiThread(new vro(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrn
 * JD-Core Version:    0.7.0.1
 */