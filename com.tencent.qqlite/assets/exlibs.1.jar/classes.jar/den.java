import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;

public class den
  implements Runnable
{
  public den(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
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
 * Qualified Name:     den
 * JD-Core Version:    0.7.0.1
 */