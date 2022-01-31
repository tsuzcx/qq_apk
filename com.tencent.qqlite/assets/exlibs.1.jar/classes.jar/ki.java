import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.biz.PoiMapActivity;
import com.tencent.widget.XListView;
import java.util.List;

public class ki
  implements TextWatcher
{
  private ki(PoiMapActivity paramPoiMapActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (TextUtils.isEmpty(paramEditable))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.a.jdField_a_of_type_JavaUtilList.clear();
    }
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    } while (!this.a.d);
    this.a.a(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ki
 * JD-Core Version:    0.7.0.1
 */