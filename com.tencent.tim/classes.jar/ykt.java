import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.c;

public class ykt
  extends GridLayoutManager.SpanSizeLookup
{
  public ykt(ZhituPanelView.c paramc) {}
  
  public int getSpanSize(int paramInt)
  {
    switch (this.c.getItemViewType(paramInt))
    {
    case 1: 
    default: 
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykt
 * JD-Core Version:    0.7.0.1
 */