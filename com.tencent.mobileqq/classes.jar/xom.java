import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.richmedia.EditVideoQzComment;

public class xom
  implements CompoundButton.OnCheckedChangeListener
{
  public xom(EditVideoQzComment paramEditVideoQzComment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    EditVideoQzComment.a(this.a).a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xom
 * JD-Core Version:    0.7.0.1
 */