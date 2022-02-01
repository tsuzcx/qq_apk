import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import java.util.List;

class anlx
  implements anlz
{
  anlx(anlw paramanlw, int paramInt, LoadParam paramLoadParam, anlz paramanlz) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, anlw.a(this.a));
    anlw.a(this.a, paramLoadExtResult);
    if (paramInt == 0) {
      if (this.dKb >= this.jdField_b_of_type_ComTencentMobileqqSoloadLoadParam.mLoadItems.size() - 1) {
        if (this.jdField_b_of_type_Anlz != null) {
          this.jdField_b_of_type_Anlz.a(paramInt, paramLoadExtResult);
        }
      }
    }
    do
    {
      return;
      anlw.a(this.a, this.jdField_b_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_b_of_type_Anlz, this.dKb + 1);
      return;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.dKb + 1);
      }
    } while (this.jdField_b_of_type_Anlz == null);
    this.jdField_b_of_type_Anlz.a(paramInt, paramLoadExtResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anlx
 * JD-Core Version:    0.7.0.1
 */