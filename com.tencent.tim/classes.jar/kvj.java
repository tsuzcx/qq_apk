import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeCommentTextView;
import com.tencent.widget.BubblePopupWindow.b;

public class kvj
  implements BubblePopupWindow.b
{
  public kvj(NativeCommentTextView paramNativeCommentTextView) {}
  
  public void onDismiss()
  {
    this.b.setBackgroundColor(NativeCommentTextView.a(this.b).getResources().getColor(2131167654));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvj
 * JD-Core Version:    0.7.0.1
 */