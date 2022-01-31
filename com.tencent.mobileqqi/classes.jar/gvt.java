import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.widget.QQToast;

class gvt
  implements Runnable
{
  gvt(gvs paramgvs) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.a.a;
    if (localBaseActivity != null) {
      QQToast.a(localBaseActivity, localBaseActivity.getString(2131560417), 0).b(localBaseActivity.d());
    }
    this.a.cancel();
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gvt
 * JD-Core Version:    0.7.0.1
 */