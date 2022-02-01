import com.tencent.qphone.base.util.QLog;

class jif
  extends iya
{
  jif(jib paramjib) {}
  
  protected void b(iya.d paramd)
  {
    if (paramd.Wa) {
      return;
    }
    paramd.Wa = this.this$0.b(false, 2);
    if (paramd.Wa) {
      paramd.Rj = "AVRegbagResultUI";
    }
    QLog.w(this.this$0.TAG, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + paramd.Wa + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jif
 * JD-Core Version:    0.7.0.1
 */