import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;

class tnb
  implements bhuk
{
  tnb(tna paramtna, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!ndk.a(tna.a(this.jdField_a_of_type_Tna)))
    {
      bflz.a().a(2131721489);
      return;
    }
    tna.a(this.jdField_a_of_type_Tna).b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 2);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 2;
    if ((tfw.a != null) && (tfw.a.poster != null)) {
      tfw.a.poster.followStatus = 2;
    }
    tna.a(this.jdField_a_of_type_Tna).setText("关注");
    tna.a(this.jdField_a_of_type_Tna).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnb
 * JD-Core Version:    0.7.0.1
 */