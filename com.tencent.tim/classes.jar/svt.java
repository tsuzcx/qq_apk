import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

class svt
  implements jnn.a
{
  svt(svs paramsvs) {}
  
  public void e(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onSoftKeyboardToggled");
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "isCheatDialogShow:" + this.this$0.bzu);
    }
    if ((!paramBoolean) || (this.this$0.mActivity == null) || (this.this$0.webView == null)) {}
    do
    {
      do
      {
        return;
      } while ((this.this$0.code < 1) || (this.this$0.code > 2) || (this.this$0.aNy));
      if (this.this$0.bzu != svs.bzs) {
        break;
      }
    } while (this.this$0.code != 2);
    this.this$0.webView.removeCallbacks(this.this$0.task);
    this.this$0.bBn();
    this.this$0.aNy = true;
    this.this$0.yR(2131692458);
    return;
    this.this$0.aNy = true;
    this.this$0.yR(2131692458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svt
 * JD-Core Version:    0.7.0.1
 */