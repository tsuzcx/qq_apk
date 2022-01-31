import com.tencent.av.ui.MultiVideoCtrlLayerUI;

public class bkb
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public bkb(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI, int paramInt1, long paramLong, String paramString, boolean paramBoolean, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt2;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkb
 * JD-Core Version:    0.7.0.1
 */