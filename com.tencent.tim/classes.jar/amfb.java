import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;

public class amfb
  implements amff
{
  public amfb(EditActivity paramEditActivity) {}
  
  public void fk(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 102) && (EditActivity.a(this.this$0).actionId != 0) && (" ".equals(EditActivity.a(this.this$0).actionText)))
    {
      amev localamev = EditActivity.a(this.this$0).a(EditActivity.a(this.this$0).actionId);
      if (localamev != null)
      {
        EditActivity.a(this.this$0).actionText = localamev.name;
        EditActivity.a(this.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfb
 * JD-Core Version:    0.7.0.1
 */