import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class yor
  implements wlq
{
  yor(yop paramyop, String paramString) {}
  
  public void a(int paramInt, wlr paramwlr, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Yop.jdField_a_of_type_Wlr = paramwlr;
    if (!this.jdField_a_of_type_Yop.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramwlr.a()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Yop.d.setVisibility(0);
      this.jdField_a_of_type_Yop.a(bool);
      if (this.jdField_a_of_type_Yop.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Yop.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Yop.jdField_a_of_type_Wlr.b()) {
        this.jdField_a_of_type_Yop.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Yop.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Yop.jdField_a_of_type_Yxx != null)
      {
        this.jdField_a_of_type_Yop.jdField_a_of_type_Yxx.a(this.jdField_a_of_type_Yop.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Yop.jdField_a_of_type_Yxx.notifyDataSetChanged();
        if (this.jdField_a_of_type_Yop.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Yop.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Yop.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      ykv.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yor
 * JD-Core Version:    0.7.0.1
 */