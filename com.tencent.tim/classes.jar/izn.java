import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.texture.YUVTexture.b;
import com.tencent.qphone.base.util.QLog;

class izn
  implements YUVTexture.b
{
  izn(izm paramizm, VideoAppInterface paramVideoAppInterface) {}
  
  public void E(byte[] paramArrayOfByte)
  {
    if (this.b != null)
    {
      String str = this.this$0.getUin();
      this.b.l(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = izm.cx(paramInt4);
    if (QLog.isColorLevel()) {
      QLog.w(izm.a(this.this$0), 1, "onRenderInfoNotify, width[" + this.this$0.awc + "->" + paramInt1 + "], height[" + this.this$0.awd + "->" + paramInt2 + "], angle[" + this.this$0.awb + "->" + paramInt3 + "], rotation[" + izm.a(this.this$0) + "->" + i + "], srcR[" + paramInt4 + "], isLocalView[" + this.this$0.vh() + "]");
    }
    if ((!this.this$0.vh()) && (this.b != null)) {
      this.b.l(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    this.this$0.awc = paramInt1;
    this.this$0.awd = paramInt2;
    this.this$0.awb = paramInt3;
    this.this$0.avS = i;
    if (paramInt4 != -1) {
      izm.a(this.this$0, i);
    }
    izm.d(this.this$0);
  }
  
  public void onRenderFlush()
  {
    izm.c(this.this$0);
  }
  
  public void onRenderFrame()
  {
    izm.a(this.this$0);
  }
  
  public void onRenderReset()
  {
    izm.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izn
 * JD-Core Version:    0.7.0.1
 */