import android.view.View.OnClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.c;
import java.lang.ref.WeakReference;
import java.util.Deque;

public class acay
  implements PopupWindow.OnDismissListener
{
  public acay(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    View.OnClickListener localOnClickListener = null;
    this.this$0.d = null;
    if ((ApolloPanel.a(this.this$0) != null) && (ApolloPanel.a(this.this$0).size() > 0))
    {
      ApolloPanel.c localc = (ApolloPanel.c)ApolloPanel.a(this.this$0).poll();
      if (ApolloPanel.a(this.this$0).size() == 0) {
        ApolloPanel.a(this.this$0, null);
      }
      if (localc != null)
      {
        if (localc.gb != null) {
          localOnClickListener = (View.OnClickListener)localc.gb.get();
        }
        ApolloPanel.a(this.this$0, localc.mView, localc.mPosition, localc.mText, localc.cut, localOnClickListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acay
 * JD-Core Version:    0.7.0.1
 */