import UserGrowth.stFeed;
import UserGrowth.stFriendFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class uih
  extends blsy<stFeed>
  implements View.OnClickListener
{
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ucr jdField_a_of_type_Ucr;
  private ung jdField_a_of_type_Ung;
  
  private uih(ViewGroup paramViewGroup, ucr paramucr)
  {
    super(paramViewGroup, 2131560390);
    this.jdField_a_of_type_Ucr = paramucr;
    b();
  }
  
  public static uih a(ViewGroup paramViewGroup, ucr paramucr)
  {
    return new uih(paramViewGroup, paramucr);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131367675));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376320));
    TextView localTextView1 = (TextView)a(2131381497);
    TextView localTextView2 = (TextView)a(2131381498);
    ImageView localImageView = (ImageView)a(2131381471);
    localTextView1.setVisibility(0);
    localImageView.setVisibility(0);
    localTextView1.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    localTextView2.setText(2131719362);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(a(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_Ung = new ung(a(), this.jdField_a_of_type_Ucr);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ung);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new udg());
    this.jdField_a_of_type_Ung.a(new uii(this));
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_Ucr == null)) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      if ((i >= 0) && (j < this.jdField_a_of_type_Ucr.a().size())) {
        while (i <= j)
        {
          RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
          if ((localViewHolder instanceof unh)) {
            ((unh)localViewHolder).a();
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramstFeed = paramstFeed.friendFeed;
      List localList = uhm.a(paramstFeed);
      this.jdField_a_of_type_Ung.a(localList);
    } while (paramstFeed == null);
    usm.a().a(paramstFeed.attachInfo);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      WSVerticalPageFragment.a(a(), "friend_feed", "friend", null, 0);
      uns.b();
      continue;
      udz localudz = new udz(a());
      if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.friendFeed != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips))) {
        localudz.a(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips);
      }
      localudz.show();
      uns.a();
      uns.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uih
 * JD-Core Version:    0.7.0.1
 */