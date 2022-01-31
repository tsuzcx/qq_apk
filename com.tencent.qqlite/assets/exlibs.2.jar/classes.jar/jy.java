import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.PoiTab;
import java.util.ArrayList;

public class jy
  implements Runnable
{
  public jy(PoiMapActivity paramPoiMapActivity, boolean paramBoolean1, String paramString1, String paramString2, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void run()
  {
    label109:
    PoiMapActivity localPoiMapActivity;
    String str;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.g) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("rec_locate", "call_foursquare", "", "", "", "");
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPoiMapActivity.b[0]))
        {
          this.jdField_a_of_type_ComTencentBizPoiMapActivity.f = 0;
          this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].b(true);
        }
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          break label226;
        }
        if (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPoiMapActivity.c))
        {
          localPoiMapActivity = this.jdField_a_of_type_ComTencentBizPoiMapActivity;
          str = this.jdField_b_of_type_JavaLangString;
          localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
          if (this.jdField_a_of_type_Int <= 0) {
            break label221;
          }
        }
      }
    }
    label221:
    for (boolean bool = true;; bool = false)
    {
      localPoiMapActivity.a(str, localArrayList, bool);
      return;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break label109;
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break label109;
    }
    label226:
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.d, this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     jy
 * JD-Core Version:    0.7.0.1
 */