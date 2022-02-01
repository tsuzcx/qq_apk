import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class xzy
  implements vwv
{
  xzy(xzw paramxzw, String paramString) {}
  
  public void a(int paramInt, vww paramvww, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Xzw.jdField_a_of_type_Vww = paramvww;
    if (!this.jdField_a_of_type_Xzw.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramvww.a()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Xzw.d.setVisibility(0);
      this.jdField_a_of_type_Xzw.a(bool);
      if (this.jdField_a_of_type_Xzw.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Xzw.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Xzw.jdField_a_of_type_Vww.b()) {
        this.jdField_a_of_type_Xzw.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Xzw.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Xzw.jdField_a_of_type_Yje != null)
      {
        this.jdField_a_of_type_Xzw.jdField_a_of_type_Yje.a(this.jdField_a_of_type_Xzw.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Xzw.jdField_a_of_type_Yje.notifyDataSetChanged();
        if (this.jdField_a_of_type_Xzw.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Xzw.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Xzw.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      xwa.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzy
 * JD-Core Version:    0.7.0.1
 */