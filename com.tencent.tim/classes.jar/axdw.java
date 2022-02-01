import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class axdw
  extends RecyclerView.Adapter<axdw.a>
{
  private RecyclerView L;
  private axdn b;
  private Context mContext;
  private ArrayList<axdk> mData;
  private int mSelectedPos = -1;
  
  public axdw(Context paramContext, axdn paramaxdn)
  {
    this.mContext = paramContext;
    this.b = paramaxdn;
    setData(this.b.getData());
    f(this.b.getRecyclerView());
  }
  
  private void f(RecyclerView paramRecyclerView)
  {
    this.L = paramRecyclerView;
  }
  
  private void setData(ArrayList<axdk> paramArrayList)
  {
    this.mData = paramArrayList;
  }
  
  public axdw.a a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mContext == null) {
      this.mContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558626, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new axdw.a(paramViewGroup);
  }
  
  public void a(axdw.a parama, int paramInt)
  {
    if (parama.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(aqcx.dip2px(this.mContext, 33.0F), aqcx.dip2px(this.mContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, aqcx.dip2px(this.mContext, 51.0F), 0);
      parama.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
      return;
    }
    Object localObject = ((axdk)this.mData.get(parama.getLayoutPosition() - 1)).text;
    parama.mTextView.setText((CharSequence)localObject);
    if (this.mSelectedPos == parama.getLayoutPosition()) {
      parama.setSelected(true);
    }
    for (;;)
    {
      parama.itemView.setOnClickListener(new axdx(this, parama, (String)localObject));
      break;
      parama.setSelected(false);
    }
  }
  
  public void clearSelection()
  {
    axdw.a locala = (axdw.a)this.L.findViewHolderForLayoutPosition(this.mSelectedPos);
    if (locala != null) {
      locala.setSelected(false);
    }
    for (;;)
    {
      if (this.mSelectedPos >= 0) {
        ((axdk)this.mData.get(this.mSelectedPos - 1)).setSelected(false);
      }
      this.mSelectedPos = -1;
      return;
      if (this.mSelectedPos >= 0) {
        notifyItemChanged(this.mSelectedPos);
      }
    }
  }
  
  public int getItemCount()
  {
    return this.mData.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt != 0) {
      return 0;
    }
    return 1;
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    TextView mTextView;
    
    public a(View paramView)
    {
      super();
      this.mTextView = ((TextView)paramView.findViewById(2131374694));
    }
    
    public void setSelected(boolean paramBoolean)
    {
      this.itemView.setSelected(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdw
 * JD-Core Version:    0.7.0.1
 */