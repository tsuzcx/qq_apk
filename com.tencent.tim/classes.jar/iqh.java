import android.opengl.GLES20;

public class iqh
  extends iqi
{
  public iqh(String paramString)
  {
    super(paramString);
  }
  
  public void loadHandle(int paramInt)
  {
    this.handle = GLES20.glGetAttribLocation(paramInt, this.mName);
    irc.lx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqh
 * JD-Core Version:    0.7.0.1
 */