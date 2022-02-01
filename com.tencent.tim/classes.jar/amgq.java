import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.widget.QQToast;

public class amgq
  implements ausj.a
{
  public amgq(SignatureHistoryFragment paramSignatureHistoryFragment, CommentItem paramCommentItem, String paramString, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.superDismiss();
      return;
      if (!aqiw.isNetSupport(this.this$0.getActivity()))
      {
        QQToast.a(this.this$0.getActivity(), 2131694663, 0).show();
      }
      else
      {
        SignatureHistoryFragment.a(this.this$0, this.b);
        if ((this.b != null) && (!TextUtils.isEmpty(SignatureHistoryFragment.a(this.this$0))) && (!TextUtils.isEmpty(this.cac)))
        {
          if (SignatureHistoryFragment.a(this.this$0) == null) {
            SignatureHistoryFragment.a(this.this$0, new arhz(this.this$0.getActivity(), this.this$0.getActivity().getTitleBarHeight()));
          }
          SignatureHistoryFragment.a(this.this$0).setMessage(null);
          SignatureHistoryFragment.a(this.this$0).show();
          this.this$0.a.a(Long.valueOf(SignatureHistoryFragment.a(this.this$0)).longValue(), this.b.feedId, Long.valueOf(this.cac).longValue(), this.b.id);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amgq
 * JD-Core Version:    0.7.0.1
 */