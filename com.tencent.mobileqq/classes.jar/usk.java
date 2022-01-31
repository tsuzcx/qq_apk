import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ConfessNewsItemBuilder;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.data.MessageForConfessNews;

public class usk
  implements View.OnClickListener
{
  public usk(ConfessNewsItemBuilder paramConfessNewsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof ConfessNewsBgView))
    {
      Object localObject = paramView.getTag();
      if ((localObject instanceof MessageForConfessNews))
      {
        localObject = (MessageForConfessNews)localObject;
        ConfessMsgUtil.a(this.a.a, paramView.getContext(), ((MessageForConfessNews)localObject).nTopicId, ((MessageForConfessNews)localObject).strConfessorUin, ((MessageForConfessNews)localObject).nConfessorSex, ((MessageForConfessNews)localObject).strRecUin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     usk
 * JD-Core Version:    0.7.0.1
 */