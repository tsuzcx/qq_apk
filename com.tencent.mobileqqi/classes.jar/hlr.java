import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ToastUtil;

public class hlr
  implements Runnable
{
  public hlr(ToastUtil paramToastUtil, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a == null)
    {
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a = Toast.makeText(CommonDataAdapter.a().a(), this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a.show();
      return;
    }
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a.setText(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a.setDuration(this.b);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hlr
 * JD-Core Version:    0.7.0.1
 */