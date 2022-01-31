import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatusEditText.RichStatusEditListener;
import com.tencent.mobileqq.widget.ClickableImageSpan;

public class ebv
  implements RichStatusEditText.RichStatusEditListener
{
  public ebv(EditActivity paramEditActivity) {}
  
  public void a(ClickableImageSpan paramClickableImageSpan)
  {
    if (EditActivity.a(this.a) == paramClickableImageSpan)
    {
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).a(null);
      }
      EditActivity.a(this.a, null);
      EditActivity.a(this.a).c = null;
      EditActivity.a(this.a).d = null;
      EditActivity.a(this.a).e = null;
      if (EditActivity.a(this.a) != 1) {
        EditActivity.c(this.a, true);
      }
    }
  }
  
  public boolean a(ClickableImageSpan paramClickableImageSpan)
  {
    return paramClickableImageSpan != EditActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebv
 * JD-Core Version:    0.7.0.1
 */