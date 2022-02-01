import android.app.Activity;

class qbe
  implements qbg
{
  qbe(qbc paramqbc) {}
  
  public void d(qdk paramqdk)
  {
    qbc.a(this.b).dismissProgressDialog();
    Activity localActivity = qbc.a(this.b).m();
    if (localActivity == null)
    {
      f(paramqdk);
      return;
    }
    qdw.a(localActivity, paramqdk, qbc.a(this.b));
  }
  
  public void e(qdk paramqdk)
  {
    qbc.a(this.b).dismissProgressDialog();
    if (qbc.a(this.b) != null)
    {
      qbc.a(this.b).onFailure(paramqdk.blL);
      qbc.a(this.b).onFinish();
    }
  }
  
  public void f(qdk paramqdk)
  {
    qbc.a(this.b).dismissProgressDialog();
    if (qbc.a(this.b) != null)
    {
      qbc.a(this.b).we(paramqdk.blL);
      qbc.a(this.b).onFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbe
 * JD-Core Version:    0.7.0.1
 */