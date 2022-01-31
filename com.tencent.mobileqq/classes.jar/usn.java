import android.text.TextUtils;
import java.lang.ref.WeakReference;

class usn
  implements Runnable
{
  usn(usm paramusm, String paramString) {}
  
  public void run()
  {
    utd localutd;
    if (usm.a(this.jdField_a_of_type_Usm) != null)
    {
      localutd = (utd)usm.a(this.jdField_a_of_type_Usm).get();
      if (localutd != null) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localutd.a(bool, usm.a(this.jdField_a_of_type_Usm), usm.b(this.jdField_a_of_type_Usm), this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     usn
 * JD-Core Version:    0.7.0.1
 */