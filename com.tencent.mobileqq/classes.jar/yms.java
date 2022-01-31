import android.widget.TextView;
import java.util.Map;

class yms
  implements ynq
{
  yms(ymq paramymq, afkf paramafkf) {}
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    Long localLong = (Long)ymq.b(this.jdField_a_of_type_Ymq).get(Integer.valueOf(this.jdField_a_of_type_Afkf.b));
    if ((localLong != null) && (localLong.longValue() > paramLong2) && (paramLong1 != localLong.longValue()) && (Math.abs(paramLong1 - localLong.longValue()) > 100L))
    {
      this.jdField_a_of_type_Afkf.a.setText((CharSequence)ymq.c(this.jdField_a_of_type_Ymq).get(Integer.valueOf(this.jdField_a_of_type_Afkf.b)));
      return;
    }
    ymq.b(this.jdField_a_of_type_Ymq).put(Integer.valueOf(this.jdField_a_of_type_Afkf.b), Long.valueOf(paramLong2));
    ymq.c(this.jdField_a_of_type_Ymq).put(Integer.valueOf(this.jdField_a_of_type_Afkf.b), paramString);
    this.jdField_a_of_type_Afkf.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yms
 * JD-Core Version:    0.7.0.1
 */