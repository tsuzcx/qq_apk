import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender.9.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public final class abih
  extends abyn
{
  public abih(View paramView, long paramLong) {}
  
  public void httpCallBack(int paramInt, byte[] paramArrayOfByte)
  {
    if ((this.val$view instanceof ApolloSurfaceView)) {
      ((ApolloSurfaceView)this.val$view).runRenderTask(new ApolloRender.9.1(this, paramArrayOfByte, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abih
 * JD-Core Version:    0.7.0.1
 */