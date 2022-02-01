import android.content.Context;
import android.text.InputFilter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText;

class aycy
  extends rhf
{
  aycy(aycm paramaycm, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setMaxTextLength(int paramInt)
  {
    super.setMaxTextLength(paramInt);
    this.a.setFilters(new InputFilter[] { new aycz(this, paramInt, paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycy
 * JD-Core Version:    0.7.0.1
 */