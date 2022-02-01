import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

class zwl
  implements zwi
{
  zwl(zwk paramzwk, zwn paramzwn, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    paramString = new zwm(this.jdField_a_of_type_Zwn.a, paramBoolean, paramString);
    zwk.a(this.jdField_a_of_type_Zwk).put(this.jdField_a_of_type_Zwn.a, paramString);
    if (paramBoolean)
    {
      zwk.a(this.jdField_a_of_type_Zwk).incrementAndGet();
      if ((zwk.a(this.jdField_a_of_type_Zwk).get() + zwk.b(this.jdField_a_of_type_Zwk).get() == this.jdField_a_of_type_Int) && (zwk.a(this.jdField_a_of_type_Zwk) != null))
      {
        paramString = (zwo)zwk.a(this.jdField_a_of_type_Zwk).get();
        if (paramString != null) {
          if (zwk.b(this.jdField_a_of_type_Zwk).get() != 0) {
            break label153;
          }
        }
      }
    }
    label153:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.a(paramBoolean, zwk.a(this.jdField_a_of_type_Zwk));
      return;
      zwk.b(this.jdField_a_of_type_Zwk).incrementAndGet();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwl
 * JD-Core Version:    0.7.0.1
 */