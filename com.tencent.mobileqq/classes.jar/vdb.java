import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;

class vdb
  implements bkzq
{
  vdb(vcu paramvcu, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(vcu.c(this.jdField_a_of_type_Vcu)))
    {
      bjkv.a().a(2131720145);
      return;
    }
    vcu.a(this.jdField_a_of_type_Vcu).b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 2);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 2;
    vcu.a(this.jdField_a_of_type_Vcu).setVisibility(0);
    vcu.b(this.jdField_a_of_type_Vcu).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdb
 * JD-Core Version:    0.7.0.1
 */