import android.text.TextUtils;
import com.tencent.biz.PoiMapActivity;
import java.util.ArrayList;

public class bmq
  implements Runnable
{
  public bmq(PoiMapActivity paramPoiMapActivity, String paramString1, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, boolean paramBoolean) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      PoiMapActivity localPoiMapActivity;
      String str;
      ArrayList localArrayList;
      if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPoiMapActivity.c))
      {
        localPoiMapActivity = this.jdField_a_of_type_ComTencentBizPoiMapActivity;
        str = this.jdField_a_of_type_JavaLangString;
        localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_a_of_type_Int <= 0) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        localPoiMapActivity.a(str, localArrayList, bool);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_Int, this.c, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmq
 * JD-Core Version:    0.7.0.1
 */