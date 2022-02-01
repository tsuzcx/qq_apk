import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class kwu
  extends RecyclerView.Adapter
{
  private nre.a a;
  private List<String> gJ = new ArrayList();
  private List<String> gK = new ArrayList();
  private Context mContext;
  
  public kwu(Context paramContext, List<String> paramList1, List<String> paramList2, nre.a parama)
  {
    this.gK = paramList1;
    this.gJ = paramList2;
    this.mContext = paramContext;
    this.a = parama;
  }
  
  public int getItemCount()
  {
    if (this.gK != null) {
      return this.gK.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof kwu.a))
    {
      kwu.a locala = (kwu.a)paramViewHolder;
      if ((paramInt >= 0) && (paramInt < this.gK.size()))
      {
        String str1 = (String)this.gK.get(paramInt);
        String str2 = (String)this.gJ.get(paramInt);
        locala.tvTitle.setText(str1);
        locala.tvTitle.setOnClickListener(new kwv(this, str2, str1));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new kwu.a(View.inflate(this.mContext, 2131560335, null));
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    public TextView tvTitle;
    
    public a(View paramView)
    {
      super();
      this.tvTitle = ((TextView)paramView.findViewById(2131369532));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwu
 * JD-Core Version:    0.7.0.1
 */