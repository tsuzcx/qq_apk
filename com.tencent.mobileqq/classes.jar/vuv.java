import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.lang.ref.WeakReference;

public class vuv
  implements DialogInterface.OnDismissListener
{
  private final WeakReference<VideoViewVideoHolder> jdField_a_of_type_JavaLangRefWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  
  public vuv(VideoViewVideoHolder paramVideoViewVideoHolder, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoViewVideoHolder);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (VideoViewVideoHolder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramDialogInterface != null)
    {
      if ((paramDialogInterface.a()) && (!paramDialogInterface.a().isFinishing())) {
        break label40;
      }
      wxe.b("OnNewGuideDialogDismissListener", "activity token invalid, preventing from showing dialog");
    }
    label40:
    while (paramDialogInterface.e()) {
      return;
    }
    paramDialogInterface.c(this.jdField_a_of_type_Boolean);
    paramDialogInterface.d();
    paramDialogInterface.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vuv
 * JD-Core Version:    0.7.0.1
 */