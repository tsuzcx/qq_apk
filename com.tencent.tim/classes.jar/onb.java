import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;

class onb
  implements ausj.a
{
  onb(ona paramona) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!jqi.isNetworkAvailable(ona.a(this.a)))
    {
      arxa.a().showToast(2131721932);
      return;
    }
    ona.a(this.a).aY(ona.a(this.a).id, 2);
    ona.a(this.a).followStatus = 2;
    ona.a(this.a).setVisibility(0);
    ona.b(this.a).setVisibility(8);
    onf.b("follow", ona.a(this.a) + 1, ona.a(this.a).id, onh.a.aqP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onb
 * JD-Core Version:    0.7.0.1
 */