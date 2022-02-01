import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRender.12.1;

public final class abhx
  implements abyo
{
  public abhx(View paramView, ApolloRender paramApolloRender, long paramLong) {}
  
  public void onProgressChange(int paramInt1, int paramInt2)
  {
    if ((this.val$view instanceof abjq)) {
      ((abjq)this.val$view).runRenderTask(new ApolloRender.12.1(this, paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhx
 * JD-Core Version:    0.7.0.1
 */