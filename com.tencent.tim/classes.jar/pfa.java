import com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView.a;

public class pfa
  implements AsyncRichTextView.a
{
  public pfa(QCircleFeedCommentWidget paramQCircleFeedCommentWidget) {}
  
  public void bkt()
  {
    if (QCircleFeedCommentWidget.a(this.a) != null) {
      rwv.a().a(new QCircleFeedCommentEllipseEvent(QCircleFeedCommentWidget.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfa
 * JD-Core Version:    0.7.0.1
 */