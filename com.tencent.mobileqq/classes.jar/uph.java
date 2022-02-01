import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.view.ViewGroup;
import android.widget.TextView;

public class uph
  extends bjwy<stFeed>
{
  private TextView a;
  
  private uph(ViewGroup paramViewGroup, ujh paramujh)
  {
    super(paramViewGroup, 2131560406);
    b();
  }
  
  public static uph a(ViewGroup paramViewGroup, ujh paramujh)
  {
    return new uph(paramViewGroup, paramujh);
  }
  
  private void b()
  {
    this.a = ((TextView)a(2131381218));
  }
  
  public void a()
  {
    uvm.a(2);
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null) {}
    do
    {
      return;
      paramstFeed = paramstFeed.recommend_splitter;
    } while (paramstFeed == null);
    this.a.setText(paramstFeed.tips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uph
 * JD-Core Version:    0.7.0.1
 */