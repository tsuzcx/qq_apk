import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.7.1;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.7.2;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.b;
import java.nio.ByteBuffer;

public class abjk
  implements ApolloCmdChannel.b
{
  public abjk(ApolloCmdChannel paramApolloCmdChannel, long paramLong, String paramString) {}
  
  public void f(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null)
    {
      localByteBuffer = ByteBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
      paramBitmap.copyPixelsToBuffer(localByteBuffer);
      if ((abmt.b() != null) && (ApolloCmdChannel.access$400(this.this$0) != null) && (ApolloCmdChannel.access$400(this.this$0).a(abmt.b().getGameId()) != null)) {
        ApolloCmdChannel.access$400(this.this$0).a(abmt.b().getGameId()).runRenderTask(new ApolloCmdChannel.7.1(this, paramInt, paramBitmap, localByteBuffer));
      }
    }
    while ((abmt.b() == null) || (ApolloCmdChannel.access$400(this.this$0) == null) || (ApolloCmdChannel.access$400(this.this$0).a(abmt.b().getGameId()) == null))
    {
      ByteBuffer localByteBuffer;
      return;
    }
    ApolloCmdChannel.access$400(this.this$0).a(abmt.b().getGameId()).runRenderTask(new ApolloCmdChannel.7.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjk
 * JD-Core Version:    0.7.0.1
 */