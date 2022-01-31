import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class uvo
  implements sse
{
  uvo(uvm paramuvm, String paramString) {}
  
  public void a(int paramInt, ssf paramssf, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Uvm.jdField_a_of_type_Ssf = paramssf;
    if (!this.jdField_a_of_type_Uvm.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramssf.a()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Uvm.d.setVisibility(0);
      this.jdField_a_of_type_Uvm.a(bool);
      if (this.jdField_a_of_type_Uvm.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Uvm.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Uvm.jdField_a_of_type_Ssf.b()) {
        this.jdField_a_of_type_Uvm.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Uvm.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Uvm.jdField_a_of_type_Vfe != null)
      {
        this.jdField_a_of_type_Uvm.jdField_a_of_type_Vfe.a(this.jdField_a_of_type_Uvm.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Uvm.jdField_a_of_type_Vfe.notifyDataSetChanged();
        if (this.jdField_a_of_type_Uvm.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Uvm.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Uvm.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      urp.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvo
 * JD-Core Version:    0.7.0.1
 */