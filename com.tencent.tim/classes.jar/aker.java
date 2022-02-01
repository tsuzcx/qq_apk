import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aker
  implements View.OnClickListener
{
  aker(akef paramakef, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.BC)
    {
      akef.a(this.this$0, 1);
      new anov(this.this$0.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.this$0.a.e.uin).report();
    }
    for (;;)
    {
      akef.b(this.this$0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.BD)
      {
        akef.a(this.this$0, 2);
        new anov(this.this$0.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.this$0.a.e.uin).report();
      }
      else if (paramView == this.BE)
      {
        akef.a(this.this$0, 3);
        new anov(this.this$0.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.this$0.a.e.uin).report();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aker
 * JD-Core Version:    0.7.0.1
 */