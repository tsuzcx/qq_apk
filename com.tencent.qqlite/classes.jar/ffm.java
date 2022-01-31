import android.view.View;
import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ToastUtil;

public class ffm
  implements Runnable
{
  public ffm(ToastUtil paramToastUtil, View paramView, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b == null)
    {
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b = new Toast(CommonDataAdapter.a().a());
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setDuration(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.show();
      return;
    }
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setDuration(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ffm
 * JD-Core Version:    0.7.0.1
 */