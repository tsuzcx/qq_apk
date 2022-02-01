import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;

public class vdh
  extends blij<stFeed>
{
  private TextView a;
  private TextView b;
  
  private vdh(ViewGroup paramViewGroup, uxe paramuxe)
  {
    super(paramViewGroup, 2131560447);
    b();
  }
  
  public static vdh a(ViewGroup paramViewGroup, uxe paramuxe)
  {
    return new vdh(paramViewGroup, paramuxe);
  }
  
  private void b()
  {
    this.a = ((TextView)a(2131381574));
    this.b = ((TextView)a(2131381575));
  }
  
  public void a()
  {
    vka.a(1);
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
 * Qualified Name:     vdh
 * JD-Core Version:    0.7.0.1
 */