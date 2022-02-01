import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;

class tml
  implements tlf
{
  tml(tmk paramtmk, FrameLayout paramFrameLayout) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (tmk.a(this.jdField_a_of_type_Tmk) != null) {
      tmk.a(this.jdField_a_of_type_Tmk).a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("float_layer_finsh_action");
      tmk.a(this.jdField_a_of_type_Tmk).getActivity().sendBroadcast(localIntent);
    }
    tmk.a(this.jdField_a_of_type_Tmk).getActivity().doOnBackPressed();
    tmk.a(this.jdField_a_of_type_Tmk).getActivity().overridePendingTransition(0, 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 2) && (tmk.a(this.jdField_a_of_type_Tmk).b()) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tml
 * JD-Core Version:    0.7.0.1
 */