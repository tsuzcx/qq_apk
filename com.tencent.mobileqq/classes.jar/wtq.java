import android.widget.TextView;
import java.util.Map;

class wtq
  implements wuo
{
  wtq(wto paramwto, adni paramadni) {}
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    Long localLong = (Long)wto.b(this.jdField_a_of_type_Wto).get(Integer.valueOf(this.jdField_a_of_type_Adni.b));
    if ((localLong != null) && (localLong.longValue() > paramLong2) && (paramLong1 != localLong.longValue()) && (Math.abs(paramLong1 - localLong.longValue()) > 100L))
    {
      this.jdField_a_of_type_Adni.a.setText((CharSequence)wto.c(this.jdField_a_of_type_Wto).get(Integer.valueOf(this.jdField_a_of_type_Adni.b)));
      return;
    }
    wto.b(this.jdField_a_of_type_Wto).put(Integer.valueOf(this.jdField_a_of_type_Adni.b), Long.valueOf(paramLong2));
    wto.c(this.jdField_a_of_type_Wto).put(Integer.valueOf(this.jdField_a_of_type_Adni.b), paramString);
    this.jdField_a_of_type_Adni.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtq
 * JD-Core Version:    0.7.0.1
 */