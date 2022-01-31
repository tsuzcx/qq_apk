import java.lang.ref.WeakReference;

class vca
  implements Runnable
{
  vca(vbx paramvbx, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    vbx localvbx = (vbx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localvbx == null) {
      return;
    }
    localvbx.a(this.jdField_a_of_type_Int, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vca
 * JD-Core Version:    0.7.0.1
 */