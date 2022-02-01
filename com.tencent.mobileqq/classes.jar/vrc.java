import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;

class vrc
  implements bkzq
{
  vrc(vrb paramvrb, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(vrb.a(this.jdField_a_of_type_Vrb)))
    {
      bjkv.a().a(2131720145);
      return;
    }
    vrb.a(this.jdField_a_of_type_Vrb).b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 2);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 2;
    vrb.a(this.jdField_a_of_type_Vrb).setText("关注");
    vrb.a(this.jdField_a_of_type_Vrb).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrc
 * JD-Core Version:    0.7.0.1
 */