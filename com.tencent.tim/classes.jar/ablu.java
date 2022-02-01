import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ablu
  implements View.OnLayoutChangeListener
{
  public ablu(ApolloWebViewFragment paramApolloWebViewFragment) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = this.this$0.getHostActivity();
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        paramView = paramView.findViewById(16908290);
      } while (paramView == null);
      paramView.getWindowVisibleDisplayFrame(ApolloWebViewFragment.a(this.this$0));
      paramInt1 = ApolloWebViewFragment.a(this.this$0).right - ApolloWebViewFragment.a(this.this$0).left;
      paramInt2 = ApolloWebViewFragment.a(this.this$0).bottom - ApolloWebViewFragment.a(this.this$0).top;
    } while ((ApolloWebViewFragment.a(this.this$0) == paramInt1) && (ApolloWebViewFragment.b(this.this$0) == paramInt2));
    ThreadManager.getUIHandler().post(this.this$0.fy);
    ApolloWebViewFragment.a(this.this$0, paramInt1);
    ApolloWebViewFragment.b(this.this$0, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ablu
 * JD-Core Version:    0.7.0.1
 */