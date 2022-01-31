package wf7;

import android.os.Bundle;

class hc$a$1
  implements gl.a
{
  hc$a$1(hc.a parama) {}
  
  public void a(Bundle paramBundle)
  {
    if (hc.a.a(this.sM) != null) {
      hc.a.a(this.sM).ay(paramBundle.getInt("key_errcode"));
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (hc.a.a(this.sM) != null) {
      hc.a.a(this.sM).onProgress(paramBundle.getInt("key_progress"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.hc.a.1
 * JD-Core Version:    0.7.0.1
 */