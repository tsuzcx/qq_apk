import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRender.11.1;
import java.util.Map;

public final class abhw
  implements abyp
{
  public abhw(View paramView, long paramLong, String paramString1, String paramString2, ApolloRender paramApolloRender) {}
  
  public void callback(int paramInt, @NonNull Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte)
  {
    if ((this.val$view instanceof abjq)) {
      ((abjq)this.val$view).runRenderTask(new ApolloRender.11.1(this, paramMap, paramInt, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhw
 * JD-Core Version:    0.7.0.1
 */