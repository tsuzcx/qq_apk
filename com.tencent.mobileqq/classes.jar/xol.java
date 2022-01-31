import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.richmedia.EditPicQzComment;

public class xol
  implements CompoundButton.OnCheckedChangeListener
{
  public xol(EditPicQzComment paramEditPicQzComment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    EditPicQzComment.a(this.a).a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xol
 * JD-Core Version:    0.7.0.1
 */