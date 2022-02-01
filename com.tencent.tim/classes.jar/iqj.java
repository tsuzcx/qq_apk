import android.opengl.GLES20;

public class iqj
  extends iqi
{
  public iqj(String paramString)
  {
    super(paramString);
  }
  
  public void loadHandle(int paramInt)
  {
    this.handle = GLES20.glGetUniformLocation(paramInt, this.mName);
    irc.lx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqj
 * JD-Core Version:    0.7.0.1
 */