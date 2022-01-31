import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

class twa
  implements twi
{
  twa(tvz paramtvz, twc paramtwc, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    paramString = new twb(this.jdField_a_of_type_Twc.a, paramBoolean, paramString);
    tvz.a(this.jdField_a_of_type_Tvz).put(this.jdField_a_of_type_Twc.a, paramString);
    if (paramBoolean)
    {
      tvz.a(this.jdField_a_of_type_Tvz).incrementAndGet();
      if ((tvz.a(this.jdField_a_of_type_Tvz).get() + tvz.b(this.jdField_a_of_type_Tvz).get() == this.jdField_a_of_type_Int) && (tvz.a(this.jdField_a_of_type_Tvz) != null))
      {
        paramString = (twd)tvz.a(this.jdField_a_of_type_Tvz).get();
        if (paramString != null) {
          if (tvz.b(this.jdField_a_of_type_Tvz).get() != 0) {
            break label153;
          }
        }
      }
    }
    label153:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.a(paramBoolean, tvz.a(this.jdField_a_of_type_Tvz));
      return;
      tvz.b(this.jdField_a_of_type_Tvz).incrementAndGet();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twa
 * JD-Core Version:    0.7.0.1
 */