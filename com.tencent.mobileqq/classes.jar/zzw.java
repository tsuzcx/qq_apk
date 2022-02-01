import android.widget.TextView;
import java.util.Map;

class zzw
  extends zqe
{
  zzw(zzu paramzzu, agqf paramagqf) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)zzu.b(this.jdField_a_of_type_Zzu).get(Integer.valueOf(this.jdField_a_of_type_Agqf.b));
    if ((localInteger != null) && (localInteger.intValue() > paramInt2) && (paramInt1 != localInteger.intValue()) && (Math.abs(paramInt1 - localInteger.intValue()) > 100))
    {
      this.jdField_a_of_type_Agqf.a.setText((CharSequence)zzu.c(this.jdField_a_of_type_Zzu).get(Integer.valueOf(this.jdField_a_of_type_Agqf.b)));
      return;
    }
    zzu.b(this.jdField_a_of_type_Zzu).put(Integer.valueOf(this.jdField_a_of_type_Agqf.b), Integer.valueOf(paramInt2));
    zzu.c(this.jdField_a_of_type_Zzu).put(Integer.valueOf(this.jdField_a_of_type_Agqf.b), paramString);
    this.jdField_a_of_type_Agqf.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzw
 * JD-Core Version:    0.7.0.1
 */