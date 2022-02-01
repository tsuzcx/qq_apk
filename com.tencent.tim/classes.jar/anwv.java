import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment;

public class anwv
  implements DialogInterface.OnCancelListener
{
  public anwv(StudyRoomLoadingFragment paramStudyRoomLoadingFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwv
 * JD-Core Version:    0.7.0.1
 */