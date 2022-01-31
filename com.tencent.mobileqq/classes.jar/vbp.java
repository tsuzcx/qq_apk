import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.ThreadManager;

public class vbp
  implements View.OnClickListener
{
  public vbp(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.post(new vbq(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vbp
 * JD-Core Version:    0.7.0.1
 */