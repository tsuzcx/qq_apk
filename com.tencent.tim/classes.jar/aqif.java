import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class aqif
  implements qdy.a
{
  aqif(aqhv paramaqhv) {}
  
  public void a(pzs.a parama, arhz paramarhz)
  {
    if ((paramarhz != null) && (paramarhz.isShowing())) {
      paramarhz.dismiss();
    }
    qdy.u(this.this$0.attrs);
    if ((parama != null) && (parama.errorCode == 0))
    {
      qdy.g(parama.awp, this.this$0.attrs);
      aqhv.g(this.this$0);
      return;
    }
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131696273, 1).show();
      return;
    }
    this.this$0.ctj = "open";
    aqhv.g(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqif
 * JD-Core Version:    0.7.0.1
 */