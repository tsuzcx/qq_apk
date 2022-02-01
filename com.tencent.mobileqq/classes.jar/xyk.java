import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.qphone.base.util.QLog;

class xyk
  implements DialogInterface.OnDismissListener
{
  xyk(xyd paramxyd, Boolean[] paramArrayOfBoolean, VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_Xyd.b, 2, "[az]isResumeVideoPlaySelf === >" + this.jdField_a_of_type_ArrayOfJavaLangBoolean);
    }
    if ((!this.jdField_a_of_type_ArrayOfJavaLangBoolean[0].booleanValue()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyk
 * JD-Core Version:    0.7.0.1
 */