import android.opengl.GLES20;

class addu
  implements adkd.a
{
  addu(addt paramaddt) {}
  
  public void init(int paramInt)
  {
    addt.a(this.this$0, GLES20.glGetUniformLocation(paramInt, "uDisplayType"));
    aded.checkGlError("glGetUniformLocation uDisplayType");
  }
  
  public void update()
  {
    GLES20.glUniform1i(addt.a(this.this$0), addt.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addu
 * JD-Core Version:    0.7.0.1
 */