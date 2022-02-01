import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;

public class vkq
  extends LinearLayoutManager
{
  public vkq(QCircleCommentItemView paramQCircleCommentItemView, Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
  
  public boolean canScrollVertically()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkq
 * JD-Core Version:    0.7.0.1
 */