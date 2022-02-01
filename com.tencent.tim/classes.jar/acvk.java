import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class acvk
  implements qdy.a
{
  acvk(acvj paramacvj) {}
  
  public void a(pzs.a parama, arhz paramarhz)
  {
    if ((paramarhz != null) && (paramarhz.isShowing())) {
      paramarhz.dismiss();
    }
    qdy.u(this.this$0.attrs);
    if ((parama != null) && (parama.errorCode == 0))
    {
      qdy.g(parama.awp, this.this$0.attrs);
      acvj.a(this.this$0);
      return;
    }
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131696273, 1).show();
      return;
    }
    this.this$0.ctj = "open";
    acvj.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvk
 * JD-Core Version:    0.7.0.1
 */