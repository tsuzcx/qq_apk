import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;

class xdg
  implements MediaScanner.OnMediaInfoScannerListener
{
  xdg(xde paramxde, int paramInt) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xde.a.d();
    if (QQStoryFlowCallback.a(this.jdField_a_of_type_Xde.a, paramLocalMediaInfo)) {
      this.jdField_a_of_type_Xde.a.a(paramLocalMediaInfo, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdg
 * JD-Core Version:    0.7.0.1
 */