import UserGrowth.stSimpleMetaComment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ohr
  implements View.OnClickListener
{
  ohr(ohl.b paramb, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void onClick(View paramView)
  {
    if (ohl.a(this.b.this$0) != null)
    {
      this.b.this$0.a().a(ohl.a(this.b.this$0), this.d);
      this.b.this$0.axf = true;
      ooz.e("comment", "5 mCommentListChanged:" + this.b.this$0.axf + ", hashCode" + this.b.this$0.hashCode());
    }
    ohl.a(this.b.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohr
 * JD-Core Version:    0.7.0.1
 */