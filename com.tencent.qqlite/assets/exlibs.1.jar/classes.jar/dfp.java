import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;

public class dfp
  implements Runnable
{
  public dfp(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.a();
      this.a.postDelayed(this, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfp
 * JD-Core Version:    0.7.0.1
 */