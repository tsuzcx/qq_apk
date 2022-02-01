import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

class ozp
  implements ozq.a
{
  ozp(ozo paramozo, ozo.b paramb, int paramInt) {}
  
  public void C(boolean paramBoolean, String paramString)
  {
    paramString = new ozo.a(this.jdField_a_of_type_Ozo$b.mDownloadUrl, paramBoolean, paramString);
    ozo.a(this.jdField_a_of_type_Ozo).put(this.jdField_a_of_type_Ozo$b.mDownloadUrl, paramString);
    if (paramBoolean)
    {
      ozo.a(this.jdField_a_of_type_Ozo).incrementAndGet();
      if ((ozo.a(this.jdField_a_of_type_Ozo).get() + ozo.b(this.jdField_a_of_type_Ozo).get() == this.bgO) && (ozo.a(this.jdField_a_of_type_Ozo) != null))
      {
        paramString = (ozo.c)ozo.a(this.jdField_a_of_type_Ozo).get();
        if (paramString != null) {
          if (ozo.b(this.jdField_a_of_type_Ozo).get() != 0) {
            break label153;
          }
        }
      }
    }
    label153:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.b(paramBoolean, ozo.a(this.jdField_a_of_type_Ozo));
      return;
      ozo.b(this.jdField_a_of_type_Ozo).incrementAndGet();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozp
 * JD-Core Version:    0.7.0.1
 */