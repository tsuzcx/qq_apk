import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;
import java.util.List;

class agwr
  implements AdapterView.e
{
  agwr(agwn paramagwn) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    agwn.a(this.a, paramInt);
    paramAdapterView = this.a.jdField_a_of_type_Agxw;
    if (agwn.a(this.a) == agwn.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.JO(bool);
      this.a.OH(paramInt);
      if (this.a.jdField_b_of_type_Agsb != null) {
        this.a.jdField_b_of_type_Agsb.av(paramInt);
      }
      paramAdapterView = (aguk.a)agwn.a(this.a).get(paramInt);
      if (paramAdapterView != null) {
        break;
      }
      ahao.JE(BaseApplicationImpl.getContext().getString(2131693595));
      return;
    }
    this.a.jdField_a_of_type_Aguk.a().a(paramAdapterView);
    this.a.jdField_a_of_type_Aguk.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_Agxw.JN(agwn.a(this.a, agwn.a(this.a)));
    this.a.jdField_a_of_type_Agxw.dkt();
    if (this.a.jdField_b_of_type_Agsa != null) {
      this.a.jdField_b_of_type_Agsa.it();
    }
    if (this.a.cfs)
    {
      this.a.jdField_b_of_type_Agsb.as(true);
      this.a.jdField_a_of_type_Agxw.JJ(false);
      agwn.a(this.a, true);
    }
    this.a.cfs = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwr
 * JD-Core Version:    0.7.0.1
 */