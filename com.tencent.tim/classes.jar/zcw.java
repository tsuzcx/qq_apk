import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;

public class zcw
  extends RecyclerView.OnScrollListener
{
  public zcw(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    paramInt1 = paramRecyclerView.findFirstVisibleItemPosition();
    String str = EmoticonGroupStoreFragment.a(this.this$0).cS(paramInt1);
    if ((str != null) && (paramInt2 != 0))
    {
      EmoticonGroupStoreFragment.a(this.this$0).setTextSize(16.0F);
      EmoticonGroupStoreFragment.a(this.this$0).setTextColor(Color.parseColor("#FF000000"));
      EmoticonGroupStoreFragment.a(this.this$0).setText(str);
    }
    if (paramInt2 < 0)
    {
      paramRecyclerView = paramRecyclerView.findViewByPosition(paramInt1);
      if (paramRecyclerView != null)
      {
        float f = paramRecyclerView.getY();
        if ((paramInt1 == 0) && (0.0F == f))
        {
          EmoticonGroupStoreFragment.a(this.this$0).setTextSize(14.0F);
          EmoticonGroupStoreFragment.a(this.this$0).setTextColor(Color.parseColor("#FF777777"));
          EmoticonGroupStoreFragment.a(this.this$0).setText(EmoticonGroupStoreFragment.a(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcw
 * JD-Core Version:    0.7.0.1
 */