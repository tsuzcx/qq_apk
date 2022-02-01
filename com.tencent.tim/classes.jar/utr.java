import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class utr
  extends acgf
{
  utr(utq paramutq, BaseActivity paramBaseActivity) {}
  
  public void f(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.g.removeObserver(this);
    if (paramBoolean)
    {
      if ((this.b.C != null) && (this.b.C.isShowing())) {
        this.b.C.dismiss();
      }
      QQToast.a(this.g, 0, acfp.m(2131704501), 0).show(this.g.getTitleBarHeight());
      return;
    }
    if ((this.b.C != null) && (this.b.C.isShowing())) {
      this.b.C.dismiss();
    }
    QQToast.a(this.g, 0, acfp.m(2131704502), 0).show(this.g.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     utr
 * JD-Core Version:    0.7.0.1
 */