import android.widget.TextView;
import java.util.Map;

class yif
  implements yjd
{
  yif(yid paramyid, affq paramaffq) {}
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    Long localLong = (Long)yid.b(this.jdField_a_of_type_Yid).get(Integer.valueOf(this.jdField_a_of_type_Affq.b));
    if ((localLong != null) && (localLong.longValue() > paramLong2) && (paramLong1 != localLong.longValue()) && (Math.abs(paramLong1 - localLong.longValue()) > 100L))
    {
      this.jdField_a_of_type_Affq.a.setText((CharSequence)yid.c(this.jdField_a_of_type_Yid).get(Integer.valueOf(this.jdField_a_of_type_Affq.b)));
      return;
    }
    yid.b(this.jdField_a_of_type_Yid).put(Integer.valueOf(this.jdField_a_of_type_Affq.b), Long.valueOf(paramLong2));
    yid.c(this.jdField_a_of_type_Yid).put(Integer.valueOf(this.jdField_a_of_type_Affq.b), paramString);
    this.jdField_a_of_type_Affq.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yif
 * JD-Core Version:    0.7.0.1
 */