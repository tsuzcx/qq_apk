import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class yyo
  implements wvf
{
  yyo(yym paramyym, String paramString) {}
  
  public void a(int paramInt, wvg paramwvg, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Yym.jdField_a_of_type_Wvg = paramwvg;
    if (!this.jdField_a_of_type_Yym.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramwvg.a()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Yym.d.setVisibility(0);
      this.jdField_a_of_type_Yym.a(bool);
      if (this.jdField_a_of_type_Yym.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Yym.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Yym.jdField_a_of_type_Wvg.b()) {
        this.jdField_a_of_type_Yym.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Yym.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Yym.jdField_a_of_type_Zie != null)
      {
        this.jdField_a_of_type_Yym.jdField_a_of_type_Zie.a(this.jdField_a_of_type_Yym.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Yym.jdField_a_of_type_Zie.notifyDataSetChanged();
        if (this.jdField_a_of_type_Yym.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Yym.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Yym.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      yup.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyo
 * JD-Core Version:    0.7.0.1
 */