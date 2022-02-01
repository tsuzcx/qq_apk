import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.view.ViewGroup;
import android.widget.TextView;

public class uim
  extends blsy<stFeed>
{
  private TextView a;
  
  private uim(ViewGroup paramViewGroup, ucr paramucr)
  {
    super(paramViewGroup, 2131560397);
    b();
  }
  
  public static uim a(ViewGroup paramViewGroup, ucr paramucr)
  {
    return new uim(paramViewGroup, paramucr);
  }
  
  private void b()
  {
    this.a = ((TextView)a(2131381501));
  }
  
  public void a()
  {
    uns.a(2);
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
 * Qualified Name:     uim
 * JD-Core Version:    0.7.0.1
 */