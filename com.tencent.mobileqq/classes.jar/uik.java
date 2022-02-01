import UserGrowth.stFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class uik
  extends blsy<stFeed>
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ucr jdField_a_of_type_Ucr;
  private unk jdField_a_of_type_Unk;
  
  private uik(ViewGroup paramViewGroup, ucr paramucr)
  {
    super(paramViewGroup, 2131560390);
    this.jdField_a_of_type_Ucr = paramucr;
    b();
  }
  
  public static uik a(ViewGroup paramViewGroup, ucr paramucr)
  {
    return new uik(paramViewGroup, paramucr);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131367675));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376320));
    TextView localTextView1 = (TextView)a(2131381498);
    TextView localTextView2 = (TextView)a(2131381497);
    ImageView localImageView = (ImageView)a(2131381471);
    localTextView2.setVisibility(8);
    localImageView.setVisibility(8);
    localTextView1.setText(2131719360);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(a(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_Unk = new unk(a(), this.jdField_a_of_type_Ucr);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Unk);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new udg());
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_Unk == null)) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      if ((i >= 0) && (j < this.jdField_a_of_type_Unk.a().size())) {
        while (i <= j)
        {
          RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
          if ((localViewHolder instanceof unl)) {
            ((unl)localViewHolder).b();
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Unk.a(paramstFeed);
    this.jdField_a_of_type_Unk.a(paramstFeed.person_meta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uik
 * JD-Core Version:    0.7.0.1
 */