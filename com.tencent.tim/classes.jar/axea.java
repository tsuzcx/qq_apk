import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorSelectionView;
import java.util.List;
import javax.annotation.Nonnull;

public class axea
  extends RecyclerView.Adapter<axea.a>
{
  private static List<axdl.a> rf;
  private RecyclerView L;
  private String auH;
  private String cTX;
  private Context mContext;
  private int mSelectedPos;
  private TextView mTextView;
  
  public axea(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.mContext = paramContext;
    this.L = paramRecyclerView;
    initData();
    this.auH = ((axdl.a)rf.get(this.mSelectedPos)).textColor;
    this.cTX = ((axdl.a)rf.get(this.mSelectedPos)).cTQ;
  }
  
  private void initData()
  {
    rf = axdl.colorList;
  }
  
  public int Rb()
  {
    return this.mSelectedPos;
  }
  
  public void U(TextView paramTextView)
  {
    this.mTextView = paramTextView;
  }
  
  @NonNull
  public axea.a a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mContext == null) {
      this.mContext = paramViewGroup.getContext();
    }
    return new axea.a(LayoutInflater.from(this.mContext).inflate(2131558628, paramViewGroup, false));
  }
  
  public void a(@NonNull axea.a parama, int paramInt)
  {
    parama.setColor(((axdl.a)rf.get(paramInt)).textColor);
    if (paramInt == this.mSelectedPos) {
      parama.setSelected(true);
    }
    for (;;)
    {
      parama.itemView.setOnClickListener(new axeb(this, paramInt, parama));
      EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
      return;
      parama.setSelected(false);
    }
  }
  
  public void adL(int paramInt)
  {
    this.mSelectedPos = paramInt;
    this.auH = ((axdl.a)rf.get(paramInt)).textColor;
    this.cTX = ((axdl.a)rf.get(paramInt)).cTQ;
  }
  
  public int getItemCount()
  {
    return rf.size();
  }
  
  @Nonnull
  public String getOutlineColor()
  {
    return this.cTX;
  }
  
  public String getTextColor()
  {
    return this.auH;
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    AEGIFTextColorSelectionView a;
    
    public a(@NonNull View paramView)
    {
      super();
      this.a = ((AEGIFTextColorSelectionView)paramView.findViewById(2131364135));
    }
    
    public void setColor(String paramString)
    {
      this.a.setColor(paramString);
    }
    
    public void setSelected(boolean paramBoolean)
    {
      this.a.p(Boolean.valueOf(paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axea
 * JD-Core Version:    0.7.0.1
 */