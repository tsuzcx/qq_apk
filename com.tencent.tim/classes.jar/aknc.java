import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class aknc
  implements Camera.PreviewCallback
{
  aknc(akmz paramakmz) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.this$0.ctb) || (this.this$0.mMode == 1)) && (!akmz.a(this.this$0)))
    {
      this.this$0.eV = paramArrayOfByte;
      if ((this.this$0.mMode != 1) && (System.currentTimeMillis() - akmz.a(this.this$0) > this.this$0.dnH))
      {
        akmz.a(this.this$0, System.currentTimeMillis());
        akmz.a(this.this$0, paramArrayOfByte);
      }
    }
    akmz.a(this.this$0).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknc
 * JD-Core Version:    0.7.0.1
 */