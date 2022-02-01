import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;
import java.util.List;

class aubu
  implements AdapterView.e
{
  aubu(aubs paramaubs) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    aubs.a(this.a, paramInt);
    this.a.OH(paramInt);
    if (this.a.jdField_b_of_type_Atyr != null) {
      this.a.jdField_b_of_type_Atyr.av(paramInt);
    }
    paramAdapterView = (atzy.a)aubs.a(this.a).get(paramInt);
    if (paramAdapterView == null)
    {
      auds.JE(BaseApplicationImpl.getContext().getString(2131693595));
      return;
    }
    this.a.jdField_a_of_type_Atzy.a().a(paramAdapterView);
    this.a.jdField_a_of_type_Atzy.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_Aucr.dkt();
    if (this.a.jdField_b_of_type_Agsa != null) {
      this.a.jdField_b_of_type_Agsa.it();
    }
    if (this.a.cfs)
    {
      this.a.jdField_b_of_type_Atyr.as(true);
      this.a.jdField_a_of_type_Aucr.JJ(false);
      aubs.a(this.a, true);
    }
    this.a.cfs = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubu
 * JD-Core Version:    0.7.0.1
 */