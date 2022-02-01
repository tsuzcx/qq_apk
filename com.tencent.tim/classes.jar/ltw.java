import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView.b;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;

class ltw
  implements ProteusRecycleView.b
{
  ltw(ltp paramltp) {}
  
  public void aCI()
  {
    if (ltp.a(this.this$0) != null)
    {
      ltp.a(this.this$0).aCI();
      return;
    }
    kxm.aJ(ltp.c(this.this$0).getContext(), ltp.b(this.this$0));
    QLog.d("RvPolymericContainer", 1, "mScrollJumpUrl : " + ltp.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltw
 * JD-Core Version:    0.7.0.1
 */