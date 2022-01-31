import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class wwz
  implements utp
{
  wwz(wwx paramwwx, String paramString) {}
  
  public void a(int paramInt, utq paramutq, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Wwx.jdField_a_of_type_Utq = paramutq;
    if (!this.jdField_a_of_type_Wwx.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramutq.a()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Wwx.d.setVisibility(0);
      this.jdField_a_of_type_Wwx.a(bool);
      if (this.jdField_a_of_type_Wwx.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Wwx.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Wwx.jdField_a_of_type_Utq.b()) {
        this.jdField_a_of_type_Wwx.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Wwx.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Wwx.jdField_a_of_type_Xgp != null)
      {
        this.jdField_a_of_type_Wwx.jdField_a_of_type_Xgp.a(this.jdField_a_of_type_Wwx.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Wwx.jdField_a_of_type_Xgp.notifyDataSetChanged();
        if (this.jdField_a_of_type_Wwx.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Wwx.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Wwx.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      wta.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwz
 * JD-Core Version:    0.7.0.1
 */