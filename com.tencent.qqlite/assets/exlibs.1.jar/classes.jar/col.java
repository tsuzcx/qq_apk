import android.view.View;
import com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter;

public class col
  implements Runnable
{
  public col(BaseWhatASmoothAdapter paramBaseWhatASmoothAdapter, View paramView, Object paramObject1, Object paramObject2, int paramInt, coo paramcoo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((this.jdField_a_of_type_JavaLangObject != null) && (this.b != null) && ((this.b.equals(localObject)) || (localObject == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBaseWhatASmoothAdapter.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidViewView.setTag(this.jdField_a_of_type_ComTencentMobileqqAdapterBaseWhatASmoothAdapter.b + this.jdField_a_of_type_Int);
    }
    coo.a(this.jdField_a_of_type_Coo, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     col
 * JD-Core Version:    0.7.0.1
 */