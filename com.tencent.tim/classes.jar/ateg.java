import android.view.View;
import java.util.List;

class ateg
  implements ausj.a
{
  ateg(atef paramatef, List paramList, atio paramatio, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.val$list.size())
    {
      paramView = (atiw)this.val$list.get(paramInt);
      this.jdField_a_of_type_Atef.b.a(paramView.hF(), this.jdField_a_of_type_Atio);
      this.b.dismiss();
      return;
    }
    this.b.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ateg
 * JD-Core Version:    0.7.0.1
 */