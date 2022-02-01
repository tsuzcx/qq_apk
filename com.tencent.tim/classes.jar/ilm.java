import com.tencent.av.VideoController;
import com.tencent.av.camera.CameraUtils;

public class ilm
  implements ilj.b
{
  public ilm(CameraUtils paramCameraUtils) {}
  
  public void a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, boolean paramBoolean)
  {
    if (this.this$0.a != null)
    {
      this.this$0.jd("onPreviewData_" + paramLong1);
      if (this.this$0.Sl) {
        this.this$0.q(-1019L, "onPreviewData_" + paramLong1);
      }
      this.this$0.a.a(paramLong1, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong2, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilm
 * JD-Core Version:    0.7.0.1
 */