import android.widget.TextView;
import java.util.Map;

class wev
  implements wfs
{
  wev(wet paramwet, adcg paramadcg) {}
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    Long localLong = (Long)wet.b(this.jdField_a_of_type_Wet).get(Integer.valueOf(this.jdField_a_of_type_Adcg.b));
    if ((localLong != null) && (localLong.longValue() > paramLong2) && (paramLong1 != localLong.longValue()) && (Math.abs(paramLong1 - localLong.longValue()) > 100L))
    {
      this.jdField_a_of_type_Adcg.a.setText((CharSequence)wet.c(this.jdField_a_of_type_Wet).get(Integer.valueOf(this.jdField_a_of_type_Adcg.b)));
      return;
    }
    wet.b(this.jdField_a_of_type_Wet).put(Integer.valueOf(this.jdField_a_of_type_Adcg.b), Long.valueOf(paramLong2));
    wet.c(this.jdField_a_of_type_Wet).put(Integer.valueOf(this.jdField_a_of_type_Adcg.b), paramString);
    this.jdField_a_of_type_Adcg.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wev
 * JD-Core Version:    0.7.0.1
 */