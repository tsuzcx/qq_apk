import android.app.Activity;
import com.tencent.mobileqq.widget.QQToast;

class lqm
  implements nrl.a
{
  lqm(lqk.a parama) {}
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if ((paramBoolean) && ((lqk.a(this.a.a) instanceof Activity)))
    {
      if (lqk.a(this.a.a) == null) {
        lqk.a(this.a.a, new nng());
      }
      lqk.a(this.a.a).a(lqk.a.a(this.a), lqk.a.a(this.a, paramInt), (Activity)lqk.a(this.a.a), "", "", paramString2, "", 0, "");
      return;
    }
    QQToast.a(lqk.a(this.a.a), 1, 2131718413, 0).show();
  }
  
  public void w(boolean paramBoolean, String paramString) {}
  
  public void x(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqm
 * JD-Core Version:    0.7.0.1
 */