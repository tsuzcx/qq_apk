import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

public class juq
  implements ausj.a
{
  juq(juk paramjuk, jzs.a parama, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if (this.b.abB) {
      return;
    }
    this.b.abB = true;
    if (paramInt + 1 == 1)
    {
      if (!acbn.blP.equals(this.b.mUin)) {
        break label209;
      }
      kbp.a(null, "", "0X8009947", "0X8009947", 0, 0, "", "", "", "", false);
      i = 1;
    }
    label209:
    for (;;)
    {
      this.b.app.removeObserver(this.b.b);
      this.b.b = new adai(new jur(this, i));
      this.b.app.addObserver(this.b.b);
      adam.f(this.b.app, this.b.a.uin, this.b.a.name, paramInt);
      this.u.dismiss();
      return;
      int j = 3;
      i = j;
      if (acbn.blP.equals(this.b.mUin))
      {
        kbp.a(null, "", "0X8009943", "0X8009943", 0, 0, "", "", "", "", false);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     juq
 * JD-Core Version:    0.7.0.1
 */