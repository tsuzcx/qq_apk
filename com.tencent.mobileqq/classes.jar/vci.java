import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;

class vci
  implements bjoe
{
  vci(vch paramvch, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(vch.a(this.jdField_a_of_type_Vch)))
    {
      bhzt.a().a(2131719692);
      return;
    }
    vch.a(this.jdField_a_of_type_Vch).b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 2);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 2;
    vch.a(this.jdField_a_of_type_Vch).setText("关注");
    vch.a(this.jdField_a_of_type_Vch).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vci
 * JD-Core Version:    0.7.0.1
 */