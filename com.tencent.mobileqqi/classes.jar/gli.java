import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class gli
  implements IStatusListener
{
  public gli(EditActivity paramEditActivity) {}
  
  public void a(int paramInt, RichStatus paramRichStatus)
  {
    if (paramInt != 100)
    {
      EditActivity.a(this.a, null);
      EditActivity.a(this.a, null);
    }
    EditActivity.b(this.a, true);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gli
 * JD-Core Version:    0.7.0.1
 */