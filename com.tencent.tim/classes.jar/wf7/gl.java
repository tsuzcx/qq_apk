package wf7;

import android.os.Bundle;

public class gl
{
  protected a sn = null;
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    if (this.sn != null)
    {
      if (paramInt != 1) {
        break label23;
      }
      this.sn.a(paramBundle);
    }
    label23:
    while (paramInt != 2) {
      return;
    }
    this.sn.b(paramBundle);
  }
  
  public void a(a parama)
  {
    this.sn = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(Bundle paramBundle);
    
    public abstract void b(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.gl
 * JD-Core Version:    0.7.0.1
 */