import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;

public class uhw
  extends bkrv<stFeed>
{
  private TextView a;
  private TextView b;
  
  private uhw(ViewGroup paramViewGroup, ucp paramucp)
  {
    super(paramViewGroup, 2131560375);
    b();
  }
  
  public static uhw a(ViewGroup paramViewGroup, ucp paramucp)
  {
    return new uhw(paramViewGroup, paramucp);
  }
  
  private void b()
  {
    this.a = ((TextView)a(2131381315));
    this.b = ((TextView)a(2131381316));
  }
  
  public void a()
  {
    umu.a(1);
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null) {}
    do
    {
      return;
      paramstFeed = paramstFeed.recommend_splitter;
    } while (paramstFeed == null);
    if (TextUtils.isEmpty(paramstFeed.text)) {
      this.a.setVisibility(8);
    }
    while (TextUtils.isEmpty(paramstFeed.tips))
    {
      this.b.setVisibility(8);
      return;
      this.a.setVisibility(0);
      this.a.setText(paramstFeed.text);
    }
    this.b.setVisibility(0);
    this.b.setText(paramstFeed.tips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhw
 * JD-Core Version:    0.7.0.1
 */