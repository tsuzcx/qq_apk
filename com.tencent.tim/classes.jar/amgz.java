import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment.DataAdapter.2.1;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment.a;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView.a;
import java.util.List;

public class amgz
  implements CommentsView.a
{
  public amgz(SignatureHistoryFragment.a parama, HistorySignItem paramHistorySignItem) {}
  
  public void j(int paramInt, View paramView)
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
    if (localamhr.uin.equals(SignatureHistoryFragment.b(this.b.this$0)))
    {
      SignatureHistoryFragment.a(this.b.this$0, (CommentItem)localObject, SignatureHistoryFragment.b(this.b.this$0));
      return;
    }
    SignatureHistoryFragment.a(this.b.this$0).setVisibility(0);
    SignatureHistoryFragment.a(this.b.this$0).setVisibility(0);
    SignatureHistoryFragment.a(this.b.this$0).requestFocus();
    SignatureHistoryFragment.a(this.b.this$0).setHint(String.format(this.b.this$0.getString(2131690177), new Object[] { this.b.this$0.nb(localamhr.uin) }));
    SignatureHistoryFragment.a(this.b.this$0, true);
    paramInt = SignatureHistoryFragment.a(this.b.this$0, paramView);
    int i = paramView.getHeight();
    this.b.this$0.GF = paramView;
    SignatureHistoryFragment.a(this.b.this$0).postDelayed(new SignatureHistoryFragment.DataAdapter.2.1(this, paramInt, i), 200L);
    SignatureHistoryFragment.a(this.b.this$0, new CommentItem());
    SignatureHistoryFragment.a(this.b.this$0).targetId = ((CommentItem)localObject).id;
    SignatureHistoryFragment.a(this.b.this$0).feedId = ((CommentItem)localObject).feedId;
    SignatureHistoryFragment.a(this.b.this$0).toReplyUser = ((CommentItem)localObject).user;
    SignatureHistoryFragment.a(this.b.this$0).user = new amhr(SignatureHistoryFragment.b(this.b.this$0), this.b.this$0.a.bd(Long.valueOf(SignatureHistoryFragment.b(this.b.this$0)).longValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amgz
 * JD-Core Version:    0.7.0.1
 */