import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class vih
  implements tex
{
  vih(vif paramvif, String paramString) {}
  
  public void a(int paramInt, tey paramtey, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Vif.jdField_a_of_type_Tey = paramtey;
    if (!this.jdField_a_of_type_Vif.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramtey.a()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Vif.d.setVisibility(0);
      this.jdField_a_of_type_Vif.a(bool);
      if (this.jdField_a_of_type_Vif.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Vif.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Vif.jdField_a_of_type_Tey.b()) {
        this.jdField_a_of_type_Vif.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Vif.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Vif.jdField_a_of_type_Vrx != null)
      {
        this.jdField_a_of_type_Vif.jdField_a_of_type_Vrx.a(this.jdField_a_of_type_Vif.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Vif.jdField_a_of_type_Vrx.notifyDataSetChanged();
        if (this.jdField_a_of_type_Vif.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Vif.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Vif.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      vei.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vih
 * JD-Core Version:    0.7.0.1
 */