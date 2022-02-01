import android.view.View;
import java.util.List;

class aodf
  implements ausj.a
{
  aodf(aodc paramaodc, List paramList, aoef paramaoef, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.GV.size())
    {
      paramView = (aoeg)this.GV.get(paramInt);
      if (aodc.a(this.jdField_a_of_type_Aodc) != null) {
        aodc.a(this.jdField_a_of_type_Aodc).a(paramView.hF(), this.jdField_a_of_type_Aoef);
      }
      this.b.dismiss();
      return;
    }
    this.b.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodf
 * JD-Core Version:    0.7.0.1
 */