import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class ovn
  extends ryh
{
  private QCirclePersonalBottomView a;
  
  public ovn(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    this.a = new QCirclePersonalBottomView(paramViewGroup.getContext(), paramrxq);
    return this.a;
  }
  
  public void loadData(rxt paramrxt) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovn
 * JD-Core Version:    0.7.0.1
 */