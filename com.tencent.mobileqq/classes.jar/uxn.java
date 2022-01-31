import android.text.TextUtils;
import java.lang.ref.WeakReference;

class uxn
  implements Runnable
{
  uxn(uxm paramuxm, String paramString) {}
  
  public void run()
  {
    uyd localuyd;
    if (uxm.a(this.jdField_a_of_type_Uxm) != null)
    {
      localuyd = (uyd)uxm.a(this.jdField_a_of_type_Uxm).get();
      if (localuyd != null) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localuyd.a(bool, uxm.a(this.jdField_a_of_type_Uxm), uxm.b(this.jdField_a_of_type_Uxm), this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxn
 * JD-Core Version:    0.7.0.1
 */