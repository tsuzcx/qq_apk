import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xau
  implements View.OnClickListener
{
  xau(xat paramxat) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    int i;
    if ((paramView instanceof ConfessNewsBgView))
    {
      localObject = paramView.getTag();
      if ((localObject instanceof MessageForConfessNews))
      {
        localObject = (MessageForConfessNews)localObject;
        if (((MessageForConfessNews)localObject).istroop != 1) {
          break label80;
        }
        i = 1;
        if (i == 0) {
          break label85;
        }
        aehj.a(this.a.app, this.a.mContext, 2, ((MessageForConfessNews)localObject).strGroupUin, ((MessageForConfessNews)localObject).nTopicId, ((MessageForConfessNews)localObject).strConfessorUin, ((MessageForConfessNews)localObject).strRecUin);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label80:
      i = 0;
      break;
      label85:
      aegu.a(this.a.app, paramView.getContext(), ((MessageForConfessNews)localObject).nTopicId, ((MessageForConfessNews)localObject).strConfessorUin, ((MessageForConfessNews)localObject).nConfessorSex, ((MessageForConfessNews)localObject).strRecUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xau
 * JD-Core Version:    0.7.0.1
 */