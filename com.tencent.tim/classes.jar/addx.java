import android.opengl.GLES20;

class addx
  implements adkd.a
{
  addx(addw paramaddw) {}
  
  public void init(int paramInt)
  {
    addw.a(this.this$0, GLES20.glGetUniformLocation(paramInt, "uDisplayType"));
    aded.checkGlError("glGetUniformLocation uDisplayType");
  }
  
  public void update()
  {
    GLES20.glUniform1i(addw.a(this.this$0), addw.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addx
 * JD-Core Version:    0.7.0.1
 */