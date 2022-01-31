import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

class tvp
  implements tvv
{
  tvp(tvo paramtvo, tvr paramtvr, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    paramString = new tvq(this.jdField_a_of_type_Tvr.a, paramBoolean, paramString);
    tvo.a(this.jdField_a_of_type_Tvo).put(this.jdField_a_of_type_Tvr.a, paramString);
    if (paramBoolean)
    {
      tvo.a(this.jdField_a_of_type_Tvo).incrementAndGet();
      if ((tvo.a(this.jdField_a_of_type_Tvo).get() + tvo.b(this.jdField_a_of_type_Tvo).get() == this.jdField_a_of_type_Int) && (tvo.a(this.jdField_a_of_type_Tvo) != null))
      {
        paramString = (tvs)tvo.a(this.jdField_a_of_type_Tvo).get();
        if (paramString != null) {
          if (tvo.b(this.jdField_a_of_type_Tvo).get() != 0) {
            break label153;
          }
        }
      }
    }
    label153:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.a(paramBoolean, tvo.a(this.jdField_a_of_type_Tvo));
      return;
      tvo.b(this.jdField_a_of_type_Tvo).incrementAndGet();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvp
 * JD-Core Version:    0.7.0.1
 */