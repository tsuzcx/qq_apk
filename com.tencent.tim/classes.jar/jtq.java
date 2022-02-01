import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView.a;
import com.tencent.qphone.base.util.QLog;

class jtq
  implements AccountDetailXListView.a
{
  jtq(jtg paramjtg) {}
  
  public void ol(int paramInt)
  {
    float f;
    if ((this.this$0.a.getFirstVisiblePosition() == 0) && (this.this$0.isFullScreen))
    {
      paramInt = -this.this$0.mX();
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailBaseAdapter", 2, "onEndScroll scrollY = " + paramInt + " ,isScrollUp = " + this.this$0.abJ);
      }
      f = 150.0F * this.this$0.density;
      if (paramInt != 0)
      {
        if (!this.this$0.abJ) {
          break label127;
        }
        if (paramInt <= f) {
          break label119;
        }
        this.this$0.ok(paramInt);
      }
    }
    return;
    label119:
    this.this$0.azK();
    return;
    label127:
    if (paramInt > this.this$0.screenHeight - f)
    {
      this.this$0.ok(paramInt);
      return;
    }
    this.this$0.azK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtq
 * JD-Core Version:    0.7.0.1
 */