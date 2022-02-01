package wf7;

import android.os.Bundle;

public class gl
{
  protected gl.a sn = null;
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    gl.a locala = this.sn;
    if (locala != null)
    {
      if (paramInt == 1)
      {
        locala.a(paramBundle);
        return;
      }
      if (paramInt == 2) {
        locala.b(paramBundle);
      }
    }
  }
  
  public void a(gl.a parama)
  {
    this.sn = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.gl
 * JD-Core Version:    0.7.0.1
 */