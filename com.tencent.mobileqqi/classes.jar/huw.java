import android.view.View;
import com.tencent.widget.AbsListView;

public class huw
  extends hvh
  implements Runnable
{
  private huw(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    View localView;
    if ((this.a.isPressed()) && (this.a.aA >= 0))
    {
      int i = this.a.aA;
      int j = this.a.ap;
      localView = this.a.getChildAt(i - j);
      if (this.a.p) {
        break label108;
      }
      if (!a()) {
        break label128;
      }
    }
    label128:
    for (boolean bool = this.a.b(localView, this.a.aA, this.a.d);; bool = false)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     huw
 * JD-Core Version:    0.7.0.1
 */