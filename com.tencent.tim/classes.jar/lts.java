import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class lts
  implements RecyclerView.OnChildAttachStateChangeListener
{
  lts(ltp paramltp) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    if ((paramView instanceof Container))
    {
      if (ltp.a(this.this$0) != null)
      {
        int j = ltp.a(this.this$0).getChildCount();
        int i = 0;
        while (i < j)
        {
          Iterator localIterator = ((Container)ltp.a(this.this$0).getChildAt(i)).getViewIdMapping().entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            if ((((Map.Entry)localObject).getValue() instanceof lso))
            {
              localObject = (lso)((Map.Entry)localObject).getValue();
              if ((((lso)localObject).a() instanceof NativeVideoView))
              {
                localObject = ((lso)localObject).a();
                if (localObject != null) {
                  ((NativeVideoView)localObject).setVideoPlayListener(new ltt(this));
                }
              }
            }
          }
          i += 1;
        }
      }
      lft.c((Container)paramView);
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    if ((paramView instanceof Container)) {
      lft.d((Container)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lts
 * JD-Core Version:    0.7.0.1
 */