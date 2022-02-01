import android.view.View;
import java.util.ArrayList;

public class afpt
{
  private ArrayList<View> hT = new ArrayList();
  
  public View bW()
  {
    if (this.hT.size() > 0) {
      return (View)this.hT.remove(0);
    }
    return null;
  }
  
  public void dbs()
  {
    this.hT.clear();
  }
  
  public void gx(View paramView)
  {
    if (this.hT.size() >= 3) {
      return;
    }
    this.hT.add(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpt
 * JD-Core Version:    0.7.0.1
 */