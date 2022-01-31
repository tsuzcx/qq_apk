import java.lang.ref.WeakReference;

class vke
  implements Runnable
{
  vke(vkb paramvkb, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    vkb localvkb = (vkb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localvkb == null) {
      return;
    }
    localvkb.a(this.jdField_a_of_type_Int, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vke
 * JD-Core Version:    0.7.0.1
 */