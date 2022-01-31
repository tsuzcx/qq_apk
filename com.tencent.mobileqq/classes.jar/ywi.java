import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.biz.troopgift.TroopGiftPanel;
import java.io.PrintStream;

public class ywi
  implements InputFilter
{
  protected int a;
  
  public ywi(TroopGiftPanel paramTroopGiftPanel, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    System.out.println("filter() source = " + paramCharSequence + ", dest = " + paramSpanned + ", start = " + paramInt1 + ", dstart = " + paramInt3 + ", dend = " + paramInt4);
    if (paramCharSequence.length() != 1) {
      return "";
    }
    paramInt1 = paramCharSequence.charAt(0);
    if ((paramInt1 < 48) || (paramInt1 > 57)) {
      return "";
    }
    if ((paramInt3 == 0) && (paramInt1 == 48)) {
      return "";
    }
    if ((this.jdField_a_of_type_Int > 0) && (paramSpanned.length() >= this.jdField_a_of_type_Int)) {
      return "";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ywi
 * JD-Core Version:    0.7.0.1
 */