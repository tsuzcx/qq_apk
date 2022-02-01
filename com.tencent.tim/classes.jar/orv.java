import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;

class orv
  implements ausj.a
{
  orv(oru paramoru, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!jqi.isNetworkAvailable(oru.a(this.a)))
    {
      arxa.a().showToast(2131721932);
      return;
    }
    oru.a(this.a).aY(this.c.id, 2);
    this.c.followStatus = 2;
    if ((ojk.e != null) && (ojk.e.poster != null)) {
      ojk.e.poster.followStatus = 2;
    }
    oru.a(this.a).setText("关注");
    oru.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orv
 * JD-Core Version:    0.7.0.1
 */