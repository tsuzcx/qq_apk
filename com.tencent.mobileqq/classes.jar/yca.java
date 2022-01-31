import android.view.View;
import java.lang.ref.WeakReference;

public class yca
{
  public WeakReference<View> a;
  public WeakReference<anis> b;
  
  public yca(ybz paramybz, View paramView, anis paramanis)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramanis);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public anis a()
  {
    return (anis)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yca
 * JD-Core Version:    0.7.0.1
 */