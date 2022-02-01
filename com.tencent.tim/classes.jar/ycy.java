import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.CustomMenuBar.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class ycy
  implements CustomMenuBar.a
{
  ycy(ycd paramycd) {}
  
  public void B(String paramString, int paramInt1, int paramInt2)
  {
    if ((xki.hN(this.this$0.sessionInfo.aTl)) && (paramInt1 == 0))
    {
      this.this$0.a.bzJ();
      return;
    }
    wja.bcO = true;
    this.this$0.b.a(paramString, this.this$0.mActivity, this.this$0.app, this.this$0.oL(), paramInt1, ycd.a(this.this$0), ycd.b(this.this$0), paramInt2, this.this$0.sessionInfo);
    adak.f(this.this$0.app, this.this$0.sessionInfo.aTl, ycd.e(this.this$0), paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycy
 * JD-Core Version:    0.7.0.1
 */