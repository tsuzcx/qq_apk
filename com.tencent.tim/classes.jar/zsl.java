import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

class zsl
  extends jnm.d
{
  zsl(zsi paramzsi) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((zsi.a(this.this$0).isFinishing()) || (this.this$0.aRg)) {
      return;
    }
    this.this$0.hideProgressDialog();
    if (zsi.a(this.this$0) != null) {
      zsi.a(this.this$0).removeCallbacks(zsi.b(this.this$0));
    }
    if (paramInt == 16)
    {
      this.this$0.bFG();
      return;
    }
    zsi.a(this.this$0, zsi.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsl
 * JD-Core Version:    0.7.0.1
 */