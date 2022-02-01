import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ksv
  implements View.OnClickListener
{
  public ksv(ReadInJoyCommentListView paramReadInJoyCommentListView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyCommentListView", 2, "loadmore comment when network not available");
    ReadInJoyCommentListView.b(this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksv
 * JD-Core Version:    0.7.0.1
 */