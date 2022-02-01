import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

class ahkz
  extends jnm.d
{
  ahkz(ahkr paramahkr) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((this.this$0.mActivity.isFinishing()) || (this.this$0.aRg)) {}
    do
    {
      return;
      this.this$0.hideProgressDialog();
      if (this.this$0.bJ != null) {
        this.this$0.bJ.removeCallbacksAndMessages(null);
      }
      if (paramInt == 16)
      {
        this.this$0.bFG();
        return;
      }
    } while (!ahkr.a(this.this$0));
    this.this$0.bf.putString("uin", String.valueOf("-1010"));
    this.this$0.bf.putInt("uintype", -1);
    this.this$0.bf.putInt("key_forward_ability_type", ahgg.a.V.intValue());
    this.this$0.dnB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkz
 * JD-Core Version:    0.7.0.1
 */