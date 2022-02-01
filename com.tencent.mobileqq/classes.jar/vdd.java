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

public class vdd
  extends blij<stFeed>
  implements View.OnClickListener
{
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private uxe jdField_a_of_type_Uxe;
  private vjn jdField_a_of_type_Vjn;
  
  private vdd(ViewGroup paramViewGroup, uxe paramuxe)
  {
    super(paramViewGroup, 2131560448);
    this.jdField_a_of_type_Uxe = paramuxe;
    c();
  }
  
  public static vdd a(ViewGroup paramViewGroup, uxe paramuxe)
  {
    return new vdd(paramViewGroup, paramuxe);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131367843));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376333));
    TextView localTextView1 = (TextView)a(2131381577);
    TextView localTextView2 = (TextView)a(2131381578);
    ImageView localImageView = (ImageView)a(2131381551);
    localTextView1.setVisibility(0);
    localImageView.setVisibility(0);
    localTextView1.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    localTextView2.setText(2131720133);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(a(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_Vjn = new vjn(a(), this.jdField_a_of_type_Uxe);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Vjn);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new uxt());
    this.jdField_a_of_type_Vjn.a(new vde(this));
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int k = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      int i = j;
      while (i <= k - j)
      {
        RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localViewHolder instanceof blij)) {
          this.jdField_a_of_type_Vjn.a((blij)localViewHolder);
        }
        i += 1;
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
      List localList = vcd.a(paramstFeed);
      this.jdField_a_of_type_Vjn.a(localList);
    } while (paramstFeed == null);
    vpa.a().a(paramstFeed.attachInfo);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_Uxe == null)) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      if ((i >= 0) && (j < this.jdField_a_of_type_Uxe.b().size())) {
        while (i <= j)
        {
          RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
          if ((localViewHolder instanceof vjo)) {
            ((vjo)localViewHolder).b();
          }
          i += 1;
        }
      }
    }
  }
  
  public void h()
  {
    super.h();
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
      vka.b();
      continue;
      uym localuym = new uym(a());
      if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.friendFeed != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips))) {
        localuym.a(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips);
      }
      localuym.show();
      vka.a();
      vka.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdd
 * JD-Core Version:    0.7.0.1
 */