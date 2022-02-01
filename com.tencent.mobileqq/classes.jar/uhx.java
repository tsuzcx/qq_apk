import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.view.ViewGroup;
import android.widget.TextView;

public class uhx
  extends bkrv<stFeed>
{
  private TextView a;
  
  private uhx(ViewGroup paramViewGroup, ucp paramucp)
  {
    super(paramViewGroup, 2131560382);
    b();
  }
  
  public static uhx a(ViewGroup paramViewGroup, ucp paramucp)
  {
    return new uhx(paramViewGroup, paramucp);
  }
  
  private void b()
  {
    this.a = ((TextView)a(2131381322));
  }
  
  public void a()
  {
    umu.a(2);
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
 * Qualified Name:     uhx
 * JD-Core Version:    0.7.0.1
 */