import java.lang.ref.WeakReference;

class vfc
  implements Runnable
{
  vfc(vez paramvez, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    vez localvez = (vez)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localvez == null) {
      return;
    }
    localvez.a(this.jdField_a_of_type_Int, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfc
 * JD-Core Version:    0.7.0.1
 */