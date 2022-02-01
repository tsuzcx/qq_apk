import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout.a;

public class oyt
  implements QCircleCommentPraiseLayout.a
{
  public oyt(QCircleCommentItemView paramQCircleCommentItemView) {}
  
  public void rj(boolean paramBoolean)
  {
    sdw localsdw;
    QCircleCommentPraiseLayout localQCircleCommentPraiseLayout;
    if (QCircleCommentItemView.a(this.a) != null)
    {
      localsdw = QCircleCommentItemView.a(this.a);
      localQCircleCommentPraiseLayout = QCircleCommentItemView.a(this.a);
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (int i = 14;; i = 15)
    {
      localsdw.a(localQCircleCommentPraiseLayout, i, QCircleCommentItemView.a(this.a), QCircleCommentItemView.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyt
 * JD-Core Version:    0.7.0.1
 */