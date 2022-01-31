import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class vik
  implements tfa
{
  vik(vii paramvii, String paramString) {}
  
  public void a(int paramInt, tfb paramtfb, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Vii.jdField_a_of_type_Tfb = paramtfb;
    if (!this.jdField_a_of_type_Vii.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramtfb.a()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Vii.d.setVisibility(0);
      this.jdField_a_of_type_Vii.a(bool);
      if (this.jdField_a_of_type_Vii.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Vii.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Vii.jdField_a_of_type_Tfb.b()) {
        this.jdField_a_of_type_Vii.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Vii.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Vii.jdField_a_of_type_Vsa != null)
      {
        this.jdField_a_of_type_Vii.jdField_a_of_type_Vsa.a(this.jdField_a_of_type_Vii.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Vii.jdField_a_of_type_Vsa.notifyDataSetChanged();
        if (this.jdField_a_of_type_Vii.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Vii.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Vii.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      vel.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vik
 * JD-Core Version:    0.7.0.1
 */