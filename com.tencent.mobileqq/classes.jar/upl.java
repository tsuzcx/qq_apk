import android.text.TextUtils;
import java.lang.ref.WeakReference;

class upl
  implements Runnable
{
  upl(upk paramupk, String paramString) {}
  
  public void run()
  {
    uqb localuqb;
    if (upk.a(this.jdField_a_of_type_Upk) != null)
    {
      localuqb = (uqb)upk.a(this.jdField_a_of_type_Upk).get();
      if (localuqb != null) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localuqb.a(bool, upk.a(this.jdField_a_of_type_Upk), upk.b(this.jdField_a_of_type_Upk), this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upl
 * JD-Core Version:    0.7.0.1
 */