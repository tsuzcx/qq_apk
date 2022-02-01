import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class abks
  extends RecyclerView.Adapter<abks.a>
{
  private Context mContext;
  private List<abkr> mDatas;
  private View mFooterView;
  
  public abks(Context paramContext, List<abkr> paramList)
  {
    this.mContext = paramContext;
    this.mDatas = paramList;
  }
  
  public abks.a a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.mFooterView != null) && (paramInt == 1)) {
      return new abks.a(this.mFooterView);
    }
    return new abks.a(LayoutInflater.from(this.mContext).inflate(2131559003, paramViewGroup, false));
  }
  
  public void a(abks.a parama, int paramInt)
  {
    if (getItemViewType(paramInt) == 0)
    {
      abkr localabkr = (abkr)this.mDatas.get(paramInt);
      parama.PH.setText(localabkr.bgM);
      parama.PH.setTextColor(Color.parseColor(abkj.dw[localabkr.logLevel]));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    if (this.mFooterView != null) {
      return this.mDatas.size() + 1;
    }
    return this.mDatas.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mFooterView != null) && (paramInt == getItemCount() - 1)) {
      return 1;
    }
    return 0;
  }
  
  public void setDatas(List<abkr> paramList)
  {
    this.mDatas = paramList;
  }
  
  public void setFooterView(View paramView)
  {
    this.mFooterView = paramView;
    notifyItemInserted(getItemCount() - 1);
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    TextView PH;
    
    public a(View paramView)
    {
      super();
      if (paramView == abks.a(abks.this)) {
        return;
      }
      this.PH = ((TextView)paramView.findViewById(2131364825));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abks
 * JD-Core Version:    0.7.0.1
 */