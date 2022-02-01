import android.view.View;
import java.util.List;

class atju
  implements ausj.a
{
  atju(atjr paramatjr, List paramList, atiu paramatiu, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.GV.size())
    {
      paramView = (atiw)this.GV.get(paramInt);
      if (atjr.a(this.a) != null) {
        atjr.a(this.a).a(paramView.hF(), this.jdField_b_of_type_Atiu);
      }
      this.jdField_b_of_type_Ausj.dismiss();
      return;
    }
    this.jdField_b_of_type_Ausj.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atju
 * JD-Core Version:    0.7.0.1
 */