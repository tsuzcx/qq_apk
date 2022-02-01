import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akdh
  implements View.OnClickListener
{
  akdh(akcx paramakcx, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.BC)
    {
      akcx.a(this.this$0, 1);
      new anov(this.this$0.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.this$0.a.e.uin).report();
    }
    for (;;)
    {
      akcx.b(this.this$0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.BD)
      {
        akcx.a(this.this$0, 2);
        new anov(this.this$0.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.this$0.a.e.uin).report();
      }
      else if (paramView == this.BE)
      {
        akcx.a(this.this$0, 3);
        new anov(this.this$0.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.this$0.a.e.uin).report();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akdh
 * JD-Core Version:    0.7.0.1
 */