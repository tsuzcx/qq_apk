import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.qphone.base.util.QLog;

class vwv
  implements DialogInterface.OnDismissListener
{
  vwv(vwo paramvwo, Boolean[] paramArrayOfBoolean, VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_Vwo.b, 2, "[az]isResumeVideoPlaySelf === >" + this.jdField_a_of_type_ArrayOfJavaLangBoolean);
    }
    if ((!this.jdField_a_of_type_ArrayOfJavaLangBoolean[0].booleanValue()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwv
 * JD-Core Version:    0.7.0.1
 */