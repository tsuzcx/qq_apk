import UserGrowth.stFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class vdg
  extends blij<stFeed>
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private uxe jdField_a_of_type_Uxe;
  private vjt jdField_a_of_type_Vjt;
  
  private vdg(ViewGroup paramViewGroup, uxe paramuxe)
  {
    super(paramViewGroup, 2131560448);
    this.jdField_a_of_type_Uxe = paramuxe;
    b();
  }
  
  public static vdg a(ViewGroup paramViewGroup, uxe paramuxe)
  {
    return new vdg(paramViewGroup, paramuxe);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131367843));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376333));
    TextView localTextView1 = (TextView)a(2131381578);
    TextView localTextView2 = (TextView)a(2131381577);
    ImageView localImageView = (ImageView)a(2131381551);
    localTextView2.setVisibility(8);
    localImageView.setVisibility(8);
    localTextView1.setText(2131720131);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(a(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_Vjt = new vjt(a(), this.jdField_a_of_type_Uxe);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Vjt);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new uxt());
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_Vjt == null)) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      if ((i >= 0) && (j < this.jdField_a_of_type_Vjt.b().size())) {
        while (i <= j)
        {
          RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i);
          if ((localViewHolder instanceof vju)) {
            ((vju)localViewHolder).b();
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
    this.jdField_a_of_type_Vjt.a(paramstFeed);
    this.jdField_a_of_type_Vjt.a(paramstFeed.person_meta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdg
 * JD-Core Version:    0.7.0.1
 */