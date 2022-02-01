import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class yut
  implements wrk
{
  yut(yur paramyur, String paramString) {}
  
  public void a(int paramInt, wrl paramwrl, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Yur.jdField_a_of_type_Wrl = paramwrl;
    if (!this.jdField_a_of_type_Yur.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramwrl.a()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Yur.d.setVisibility(0);
      this.jdField_a_of_type_Yur.a(bool);
      if (this.jdField_a_of_type_Yur.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Yur.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Yur.jdField_a_of_type_Wrl.b()) {
        this.jdField_a_of_type_Yur.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Yur.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Yur.jdField_a_of_type_Zej != null)
      {
        this.jdField_a_of_type_Yur.jdField_a_of_type_Zej.a(this.jdField_a_of_type_Yur.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Yur.jdField_a_of_type_Zej.notifyDataSetChanged();
        if (this.jdField_a_of_type_Yur.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Yur.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Yur.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      yqu.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yut
 * JD-Core Version:    0.7.0.1
 */