import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class tsy
  implements bcob
{
  tsy(tsx paramtsx, tta paramtta) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    QLog.e("NativeVueLoaderManager", 1, "[NativeVueLoaderManager], resCode: " + paramInt);
    tsx.a(this.jdField_a_of_type_Tsx, false);
    if (paramInt == 0)
    {
      tsx.b(this.jdField_a_of_type_Tsx, true);
      tsx.a(this.jdField_a_of_type_Tsx, this.jdField_a_of_type_Tta);
      return;
    }
    tsx.b(this.jdField_a_of_type_Tsx, false);
    tsx.b(this.jdField_a_of_type_Tsx, this.jdField_a_of_type_Tta);
    QLog.e("NativeVueLoaderManager", 2, "load NativeVue Error: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsy
 * JD-Core Version:    0.7.0.1
 */