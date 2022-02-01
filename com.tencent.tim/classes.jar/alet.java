import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class alet
  extends RecyclerView.Adapter<alet.a>
{
  private List<alev> ET;
  private alet.b a;
  private int dsK;
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  
  public alet(List<alev> paramList, Context paramContext, alet.b paramb)
  {
    this.ET = paramList;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.a = paramb;
  }
  
  public alet.a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new alet.a(this.mLayoutInflater.inflate(2131561614, paramViewGroup, false));
  }
  
  public void a(alet.a parama, int paramInt)
  {
    if ((this.ET == null) || (this.ET.size() <= paramInt) || (((alev)this.ET.get(paramInt)).fm == null)) {}
    while ((parama == null) || (parama.a == null))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
      return;
    }
    parama.aHE = ((alev)this.ET.get(paramInt)).isSelected;
    parama.a.setBackground(((alev)this.ET.get(paramInt)).fm.getConstantState().newDrawable());
    if (parama.aHE)
    {
      this.dsK = paramInt;
      parama.a.setBorderWidth(wja.dp2px(4.0F, this.mContext.getResources()));
      parama.a.setCornerRadius(wja.dp2px(2.0F, this.mContext.getResources()));
      if (this.a != null) {
        this.a.a((alev)this.ET.get(paramInt));
      }
    }
    for (;;)
    {
      a(parama.a, parama.aHE);
      parama.a.setOnClickListener(new aleu(this, paramInt));
      break;
      parama.a.setBorderWidth(wja.dp2px(2.0F, this.mContext.getResources()));
      parama.a.setCornerRadius(wja.dp2px(2.0F, this.mContext.getResources()));
    }
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = wja.dp2px(28.0F, this.mContext.getResources());
        paramRoundedImageView.width = wja.dp2px(28.0F, this.mContext.getResources());
        paramRoundedImageView.setMargins(wja.dp2px(20.0F, this.mContext.getResources()), wja.dp2px(6.0F, this.mContext.getResources()), wja.dp2px(6.0F, this.mContext.getResources()), wja.dp2px(6.0F, this.mContext.getResources()));
      }
    }
    else
    {
      return;
    }
    paramRoundedImageView.height = wja.dp2px(24.0F, this.mContext.getResources());
    paramRoundedImageView.width = wja.dp2px(24.0F, this.mContext.getResources());
    paramRoundedImageView.setMargins(wja.dp2px(22.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()));
  }
  
  public int getItemCount()
  {
    if (this.ET == null) {
      return 0;
    }
    return this.ET.size();
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    public RoundedImageView a;
    public boolean aHE;
    
    public a(View paramView)
    {
      super();
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView = ((RoundedImageView)paramView.findViewById(2131377360));
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(alev paramalev);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alet
 * JD-Core Version:    0.7.0.1
 */