import android.view.View;
import com.tencent.widget.AbsListView;

public class fgu
  extends fhf
  implements Runnable
{
  private fgu(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    View localView;
    if ((this.a.isPressed()) && (this.a.az >= 0))
    {
      int i = this.a.az;
      int j = this.a.ao;
      localView = this.a.getChildAt(i - j);
      if (this.a.q) {
        break label108;
      }
      if (!a()) {
        break label128;
      }
    }
    label128:
    for (boolean bool = this.a.b(localView, this.a.az, this.a.d);; bool = false)
    {
      if (bool)
      {
        this.a.setPressed(false);
        localView.setPressed(false);
      }
      label108:
      do
      {
        return;
        this.a.setPressed(false);
      } while (localView == null);
      localView.setPressed(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fgu
 * JD-Core Version:    0.7.0.1
 */