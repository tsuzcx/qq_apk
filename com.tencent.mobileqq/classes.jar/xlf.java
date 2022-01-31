import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.richmedia.EditPicQzComment;

public class xlf
  implements CompoundButton.OnCheckedChangeListener
{
  public xlf(EditPicQzComment paramEditPicQzComment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    EditPicQzComment.a(this.a).a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlf
 * JD-Core Version:    0.7.0.1
 */