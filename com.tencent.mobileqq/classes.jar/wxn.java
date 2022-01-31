import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.nearby.now.send.capturepart.QQNowVideoFlowCallback;

class wxn
  implements MediaScanner.OnMediaInfoScannerListener
{
  wxn(wxk paramwxk, int paramInt) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wxk.a.d();
    if (QQNowVideoFlowCallback.a(this.jdField_a_of_type_Wxk.a, paramLocalMediaInfo)) {
      this.jdField_a_of_type_Wxk.a.a(paramLocalMediaInfo, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxn
 * JD-Core Version:    0.7.0.1
 */