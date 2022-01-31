import android.view.View;
import com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter;

public class fca
  implements Runnable
{
  public fca(BaseWhatASmoothAdapter paramBaseWhatASmoothAdapter, View paramView, Object paramObject1, Object paramObject2, int paramInt, fcc paramfcc) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((this.jdField_a_of_type_JavaLangObject != null) && (this.b != null) && ((this.b.equals(localObject)) || (localObject == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBaseWhatASmoothAdapter.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidViewView.setTag(this.jdField_a_of_type_ComTencentMobileqqAdapterBaseWhatASmoothAdapter.b + this.jdField_a_of_type_Int);
    }
    fcc.a(this.jdField_a_of_type_Fcc, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fca
 * JD-Core Version:    0.7.0.1
 */