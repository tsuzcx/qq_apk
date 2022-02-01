import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment.a;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView.b;
import java.util.List;

public class amha
  implements CommentsView.b
{
  public amha(SignatureHistoryFragment.a parama, HistorySignItem paramHistorySignItem) {}
  
  public void onItemLongClick(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.b.this$0)) {}
    Object localObject;
    amhr localamhr;
    do
    {
      do
      {
        return;
        localObject = this.a.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localamhr = ((CommentItem)localObject).user;
    } while ((localamhr == null) || (TextUtils.isEmpty(localamhr.uin)));
    paramView.setSelected(true);
    aqoa localaqoa = new aqoa();
    SignatureHistoryFragment.a(this.b.this$0, (CommentItem)localObject);
    localaqoa.Z(2131365509, this.b.this$0.getString(2131692330), 0);
    if ((localamhr.uin.equals(SignatureHistoryFragment.b(this.b.this$0))) || (aqft.equalsWithNullCheck(SignatureHistoryFragment.b(this.b.this$0), SignatureHistoryFragment.a(this.b.this$0)))) {
      localaqoa.Z(2131365686, this.b.this$0.getString(2131693962), 0);
    }
    aqgq.a(paramView, localaqoa, this.b.this$0, new amhb(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amha
 * JD-Core Version:    0.7.0.1
 */