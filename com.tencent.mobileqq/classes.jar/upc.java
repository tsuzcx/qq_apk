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

public class upc
  extends bjwy<stFeed>
  implements View.OnClickListener
{
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ujh jdField_a_of_type_Ujh;
  private uva jdField_a_of_type_Uva;
  
  private upc(ViewGroup paramViewGroup, ujh paramujh)
  {
    super(paramViewGroup, 2131560398);
    this.jdField_a_of_type_Ujh = paramujh;
    b();
  }
  
  public static upc a(ViewGroup paramViewGroup, ujh paramujh)
  {
    return new upc(paramViewGroup, paramujh);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131367707));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376086));
    TextView localTextView1 = (TextView)a(2131381214);
    TextView localTextView2 = (TextView)a(2131381215);
    ImageView localImageView = (ImageView)a(2131381188);
    localTextView1.setVisibility(0);
    localImageView.setVisibility(0);
    localTextView1.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    localTextView2.setText(2131719680);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(a(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_Uva = new uva(a(), this.jdField_a_of_type_Ujh);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Uva);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new ujw());
    this.jdField_a_of_type_Uva.a(new upd(this));
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_Ujh == null)) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      if ((i >= 0) && (j < this.jdField_a_of_type_Ujh.a().size())) {
        while (i <= j)
        {
          RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
          if ((localViewHolder instanceof uvb)) {
            ((uvb)localViewHolder).a();
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
      List localList = uod.a(paramstFeed);
      this.jdField_a_of_type_Uva.a(localList);
    } while (paramstFeed == null);
    vah.a().a(paramstFeed.attachInfo);
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
      uvm.b();
      continue;
      ukp localukp = new ukp(a());
      if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.friendFeed != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips))) {
        localukp.a(this.jdField_a_of_type_UserGrowthStFeed.friendFeed.dialogTips);
      }
      localukp.show();
      uvm.a();
      uvm.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upc
 * JD-Core Version:    0.7.0.1
 */