import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituPanelAdapter;

public class wjo
  extends GridLayoutManager.SpanSizeLookup
{
  public wjo(ZhituPanelView.ZhituPanelAdapter paramZhituPanelAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    switch (this.a.getItemViewType(paramInt))
    {
    case 1: 
    default: 
      return 1;
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjo
 * JD-Core Version:    0.7.0.1
 */