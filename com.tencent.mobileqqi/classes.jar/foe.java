import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;

public class foe
  implements Runnable
{
  public foe(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void run()
  {
    if (EmoticonLinearLayout.a(this.a) != null)
    {
      EmoticonLinearLayout.a(this.a).a();
      this.a.postDelayed(this, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     foe
 * JD-Core Version:    0.7.0.1
 */