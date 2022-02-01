import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.view.ViewGroup;
import android.widget.TextView;

public class vdi
  extends blij<stFeed>
{
  private TextView a;
  
  private vdi(ViewGroup paramViewGroup, uxe paramuxe)
  {
    super(paramViewGroup, 2131560456);
    b();
  }
  
  public static vdi a(ViewGroup paramViewGroup, uxe paramuxe)
  {
    return new vdi(paramViewGroup, paramuxe);
  }
  
  private void b()
  {
    this.a = ((TextView)a(2131381581));
  }
  
  public void a()
  {
    vka.a(2);
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
 * Qualified Name:     vdi
 * JD-Core Version:    0.7.0.1
 */