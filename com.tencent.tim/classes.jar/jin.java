import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class jin
  extends iya
{
  jin(jim paramjim) {}
  
  protected void b(iya.d paramd)
  {
    if (paramd.Wa) {
      return;
    }
    paramd.Wa = this.this$0.cH("onAVActivityPreBackPressed");
    if (paramd.Wa) {
      paramd.Rj = "AVRegbagResultUI";
    }
    QLog.w(this.this$0.TAG, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + paramd.Wa + "]");
  }
  
  protected void jW(String paramString)
  {
    if (this.this$0.a() != null)
    {
      QLog.w(this.this$0.TAG, 1, "onActivityOnResume, peerUin[" + paramString + "], mStarter[" + this.this$0.b.Zx + "], mPlayUin[" + this.this$0.b.Sm + "], mStartUin[" + this.this$0.b.Sl + "]");
      if (((this.this$0.b.Zx) && (TextUtils.equals(this.this$0.b.Sm, paramString))) || ((!this.this$0.b.Zx) && (TextUtils.equals(this.this$0.b.Sl, paramString)))) {
        this.this$0.awT();
      }
    }
    else
    {
      return;
    }
    this.this$0.awB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jin
 * JD-Core Version:    0.7.0.1
 */