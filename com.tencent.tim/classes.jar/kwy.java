import android.widget.TextView;
import java.util.List;

class kwy
  implements nre.a
{
  kwy(kwx paramkwx) {}
  
  public void bz(String paramString1, String paramString2)
  {
    this.a.jdField_a_of_type_Kww$a.oY.setText(paramString2);
    this.a.jdField_a_of_type_Lik.value = paramString2;
    this.a.jdField_a_of_type_Lik.id = paramString1;
    if (this.a.val$position < kww.a(this.a.jdField_a_of_type_Kww).size()) {
      kww.a(this.a.jdField_a_of_type_Kww, this.a.val$position, this.a.jdField_a_of_type_Lik);
    }
    this.a.jdField_a_of_type_Kww.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwy
 * JD-Core Version:    0.7.0.1
 */