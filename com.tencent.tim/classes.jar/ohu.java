import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ohu
  implements View.OnClickListener
{
  ohu(ohl.b paramb, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply) {}
  
  public void onClick(View paramView)
  {
    this.b.this$0.a().a(ohl.a(this.b.this$0), this.jdField_d_of_type_UserGrowthStSimpleMetaComment, this.jdField_d_of_type_UserGrowthStSimpleMetaReply);
    this.b.this$0.axf = true;
    ooz.e("comment", "6 mCommentListChanged:" + this.b.this$0.axf + ", hashCode" + this.b.this$0.hashCode());
    ohl.a(this.b.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohu
 * JD-Core Version:    0.7.0.1
 */