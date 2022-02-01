import UserGrowth.stFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.List;

public class ojg
  extends auwn<stFeed>
{
  private omz a;
  private oey b;
  private LinearLayout ez;
  private RecyclerView i;
  private LinearLayoutManager mLayoutManager;
  
  private ojg(ViewGroup paramViewGroup, oey paramoey)
  {
    super(paramViewGroup, 2131560581);
    this.b = paramoey;
    initView();
  }
  
  public static ojg a(ViewGroup paramViewGroup, oey paramoey)
  {
    return new ojg(paramViewGroup, paramoey);
  }
  
  private void initView()
  {
    this.ez = ((LinearLayout)getView(2131368130));
    this.i = ((RecyclerView)getView(2131376903));
    this.mLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.i.setLayoutManager(this.mLayoutManager);
    this.i.setHasFixedSize(true);
    this.a = new omz(getContext(), this.b);
    this.i.setAdapter(this.a);
  }
  
  public RecyclerView a()
  {
    return this.i;
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null)
    {
      this.ez.setVisibility(8);
      return;
    }
    this.ez.setVisibility(0);
    this.a.b(paramstFeed);
    this.a.D(paramstFeed.person_meta);
  }
  
  public void aCG()
  {
    if ((this.mLayoutManager == null) || (this.a == null)) {}
    for (;;)
    {
      return;
      int j = this.mLayoutManager.findFirstVisibleItemPosition();
      int k = this.mLayoutManager.findLastVisibleItemPosition();
      if ((j >= 0) && (k < this.a.be().size())) {
        while (j <= k)
        {
          RecyclerView.ViewHolder localViewHolder = this.i.findViewHolderForAdapterPosition(j);
          if ((localViewHolder instanceof ona)) {
            ((ona)localViewHolder).aCG();
          }
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojg
 * JD-Core Version:    0.7.0.1
 */