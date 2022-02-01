import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class kww
  extends RecyclerView.Adapter
{
  private List<lik> P = new ArrayList();
  nre a;
  private List<lik> gL = new ArrayList();
  private Context mContext;
  
  public kww(Context paramContext, List<lik> paramList1, List<lik> paramList2)
  {
    this.P = paramList1;
    this.gL = paramList2;
    this.mContext = paramContext;
  }
  
  private void a(int paramInt, lik paramlik)
  {
    if (paramInt == 0) {
      awit.H("readinjoy_show_recommend_reason_in_title_b", paramlik.id);
    }
  }
  
  public int getItemCount()
  {
    int j = 0;
    if (this.P != null) {}
    for (int i = this.P.size();; i = 0)
    {
      if (this.gL != null) {
        j = this.gL.size();
      }
      return i + 0 + j;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.gL.size()) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    kww.a locala = (kww.a)paramViewHolder;
    lik locallik;
    if (paramInt >= this.gL.size())
    {
      paramInt -= this.gL.size();
      locallik = (lik)this.P.get(paramInt);
      locala.gk.setVisibility(8);
    }
    for (;;)
    {
      locala.fe.setText(locallik.name);
      locala.oY.setText(locallik.value);
      locala.itemView.setOnClickListener(new kwx(this, locala, locallik, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      locallik = (lik)this.gL.get(paramInt);
      locala.gk.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new kww.a(View.inflate(this.mContext, 2131560400, null));
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    public TextView fe;
    public View gk;
    public TextView oY;
    
    public a(View paramView)
    {
      super();
      this.fe = ((TextView)paramView.findViewById(2131380640));
      this.oY = ((TextView)paramView.findViewById(2131380641));
      this.gk = paramView.findViewById(2131370458);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kww
 * JD-Core Version:    0.7.0.1
 */