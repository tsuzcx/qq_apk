import android.widget.TextView;
import java.util.Map;

class wtn
  implements wul
{
  wtn(wtl paramwtl, adng paramadng) {}
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    Long localLong = (Long)wtl.b(this.jdField_a_of_type_Wtl).get(Integer.valueOf(this.jdField_a_of_type_Adng.b));
    if ((localLong != null) && (localLong.longValue() > paramLong2) && (paramLong1 != localLong.longValue()) && (Math.abs(paramLong1 - localLong.longValue()) > 100L))
    {
      this.jdField_a_of_type_Adng.a.setText((CharSequence)wtl.c(this.jdField_a_of_type_Wtl).get(Integer.valueOf(this.jdField_a_of_type_Adng.b)));
      return;
    }
    wtl.b(this.jdField_a_of_type_Wtl).put(Integer.valueOf(this.jdField_a_of_type_Adng.b), Long.valueOf(paramLong2));
    wtl.c(this.jdField_a_of_type_Wtl).put(Integer.valueOf(this.jdField_a_of_type_Adng.b), paramString);
    this.jdField_a_of_type_Adng.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtn
 * JD-Core Version:    0.7.0.1
 */