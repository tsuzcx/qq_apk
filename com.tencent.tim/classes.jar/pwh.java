import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ARMapHongBaoListView;

class pwh
  implements View.OnLayoutChangeListener
{
  pwh(pvz parampvz, psr parampsr) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    ram.d(pvz.access$100(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.this$0.aCo) || (this.this$0.aCp)) && (!this.this$0.mListView.mForStory))
    {
      ram.d(pvz.access$100(), "first show node, showStoryNode");
      if (this.this$0.aCo)
      {
        this.this$0.aCo = false;
        this.c.n("first_show_node", Boolean.valueOf(false));
      }
      this.this$0.aCp = false;
      if (this.this$0.Ji()) {
        this.this$0.a.bq("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwh
 * JD-Core Version:    0.7.0.1
 */