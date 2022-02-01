import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class qzk
  extends qwo
{
  qzk(qzh paramqzh, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, qyd paramqyd)
  {
    if (paramView == paramqyd.getItemView()) {
      qzh.a(this.this$0, paramInt, (StoryVideoItem)qzh.a(this.this$0).bu().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramqyd.get(2131375202))
      {
        paramView = (StoryCoverView)paramqyd.get(2131375201);
        if (this.aGi)
        {
          qzh.a(this.this$0, paramInt, (StoryVideoItem)qzh.a(this.this$0).bu().get(paramInt), paramView);
          return;
        }
        qzh.b(this.this$0, paramInt, (StoryVideoItem)qzh.a(this.this$0).bu().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramqyd.get(2131375257)) || (paramView == paramqyd.get(2131375204)))
      {
        qzh.a(this.this$0, paramInt, (StoryVideoItem)qzh.a(this.this$0).bu().get(paramInt));
        return;
      }
    } while (paramView != paramqyd.get(2131375253));
    this.this$0.b(paramqyd, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzk
 * JD-Core Version:    0.7.0.1
 */