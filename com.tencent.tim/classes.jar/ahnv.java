import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ahnv
  implements ausj.a
{
  public ahnv(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.this$0.mActionSheet != null) {
        this.this$0.mActionSheet.dismiss();
      }
      this.this$0.dpb();
      return;
      this.this$0.dpc();
      continue;
      if (this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() == null) {
        this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
      }
      if ((aqiw.isNetSupport(BaseApplication.getContext())) && (!this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
      {
        ahng.a(this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
      else
      {
        QQToast.a(BaseApplication.getContext(), 1, this.this$0.getString(2131696270), 0).show(this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnv
 * JD-Core Version:    0.7.0.1
 */