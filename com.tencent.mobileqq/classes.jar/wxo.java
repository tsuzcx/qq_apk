import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import java.util.ArrayList;

class wxo
  implements MediaScanner.OnMediaInfoScannerListener
{
  wxo(wxk paramwxk, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wxk.a.d();
    if (QQStoryFlowCallback.a(this.jdField_a_of_type_Wxk.a, paramLocalMediaInfo))
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
      PhotoUtils.a(this.jdField_a_of_type_Wxk.a, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, this.jdField_a_of_type_Wxk.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxo
 * JD-Core Version:    0.7.0.1
 */