import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;

class oje
  implements ausj.a
{
  oje(oiy paramoiy, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!jqi.isNetworkAvailable(oiy.a(this.jdField_a_of_type_Oiy)))
    {
      arxa.a().showToast(2131721932);
      return;
    }
    oiy.a(this.jdField_a_of_type_Oiy).aY(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 2);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 2;
    oiy.a(this.jdField_a_of_type_Oiy).setVisibility(0);
    oiy.b(this.jdField_a_of_type_Oiy).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oje
 * JD-Core Version:    0.7.0.1
 */