import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

class jut
  implements ausj.a
{
  jut(juk paramjuk, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.b.abB) {
      return;
    }
    this.b.abB = true;
    if (paramInt == 0) {
      this.b.state = 0;
    }
    for (;;)
    {
      this.b.app.removeObserver(this.b.b);
      this.b.b = new adai(new juu(this));
      this.b.app.addObserver(this.b.b);
      adam.f(this.b.app, this.b.a.uin, this.b.a.name, this.b.state);
      this.u.dismiss();
      return;
      if (paramInt == 1) {
        this.b.state = 2;
      } else if (paramInt == 2) {
        this.b.state = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jut
 * JD-Core Version:    0.7.0.1
 */