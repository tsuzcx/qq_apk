import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean.FilterID;
import java.util.List;

public class axmx
  extends RecyclerView.Adapter<axmx.b>
{
  private List<AEEditorFilterBean> MV;
  private axmx.a a;
  private boolean cSH;
  private int dyf;
  private int eFZ;
  private int eGa;
  private int eGb;
  private int ehh;
  private int ehj;
  private RecyclerView recyclerView;
  private int selectedIndex;
  
  public axmx(List<AEEditorFilterBean> paramList, int paramInt, axmx.a parama)
  {
    this.MV = paramList;
    this.selectedIndex = paramInt;
    this.a = parama;
    this.cSH = axiz.aOK();
  }
  
  private void adK(int paramInt)
  {
    if (this.recyclerView == null) {}
    LinearLayoutManager localLinearLayoutManager;
    do
    {
      return;
      localLinearLayoutManager = (LinearLayoutManager)this.recyclerView.getLayoutManager();
    } while (localLinearLayoutManager == null);
    int i = this.recyclerView.getResources().getDimensionPixelSize(2131296373);
    localLinearLayoutManager.scrollToPositionWithOffset(paramInt, aqnm.getScreenWidth() - i >> 1);
  }
  
  @NonNull
  public axmx.b a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new axmx.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558614, paramViewGroup, false));
  }
  
  public void a(@NonNull axmx.b paramb, int paramInt)
  {
    AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)this.MV.get(paramInt);
    int i;
    if (paramInt == this.selectedIndex)
    {
      i = 1;
      if (i == 0) {
        break label158;
      }
      paramb.jE.setVisibility(0);
      paramb.jE.setBackgroundColor(this.ehh);
      paramb.textView.setTextColor(this.dyf);
      paramb.textView.setBackgroundColor(this.ehh);
      label70:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.NON) {
        break label192;
      }
      paramb.textView.setText(2131693726);
      if (i != 0) {
        paramb.jE.setImageResource(2130837963);
      }
      paramb.imageView.setImageResource(2130837964);
      paramb.imageView.setBackgroundResource(2130837968);
    }
    for (;;)
    {
      paramb.itemView.setOnClickListener(new axmy(this, localAEEditorFilterBean, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
      return;
      i = 0;
      break;
      label158:
      paramb.jE.setVisibility(8);
      paramb.textView.setTextColor(this.ehj);
      paramb.textView.setBackgroundColor(this.eGb);
      break label70;
      label192:
      if (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.AIFilter)
      {
        paramb.textView.setText(2131693724);
        if (i != 0) {
          paramb.jE.setImageResource(2130837957);
        }
        paramb.imageView.setImageResource(2130837960);
      }
      else if (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.Comics)
      {
        paramb.textView.setText(2131693725);
        if (i != 0) {
          paramb.jE.setImageResource(2130837961);
        } else {
          rpq.a(paramb.imageView, localAEEditorFilterBean.getPicUrl(), rpq.dip2px(paramb.imageView.getContext(), 67.0F), rpq.dip2px(paramb.imageView.getContext(), 67.0F), null, null);
        }
      }
      else
      {
        paramb.textView.setText(localAEEditorFilterBean.getName());
        if (i != 0) {
          paramb.jE.setImageResource(2130837967);
        }
        rpq.a(paramb.imageView, localAEEditorFilterBean.getPicUrl(), rpq.dip2px(paramb.imageView.getContext(), 67.0F), rpq.dip2px(paramb.imageView.getContext(), 67.0F), null, null);
      }
    }
  }
  
  public int getItemCount()
  {
    return this.MV.size();
  }
  
  public int getSelectedIndex()
  {
    return this.selectedIndex;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.recyclerView = paramRecyclerView;
    this.ehh = paramRecyclerView.getResources().getColor(2131165289);
    this.eFZ = paramRecyclerView.getResources().getColor(2131165298);
    this.eGa = paramRecyclerView.getResources().getColor(2131165300);
    this.eGb = paramRecyclerView.getResources().getColor(2131165292);
    this.dyf = paramRecyclerView.getResources().getColor(2131165294);
    this.ehj = paramRecyclerView.getResources().getColor(2131165296);
  }
  
  public void setSelectedIndex(int paramInt)
  {
    this.selectedIndex = paramInt;
    adK(paramInt);
    notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract boolean a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean);
  }
  
  public class b
    extends RecyclerView.ViewHolder
  {
    ImageView imageView;
    ImageView jE;
    TextView textView;
    
    public b(View paramView)
    {
      super();
      this.imageView = ((ImageView)paramView.findViewById(2131368846));
      this.textView = ((TextView)paramView.findViewById(2131379419));
      this.jE = ((ImageView)paramView.findViewById(2131377929));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmx
 * JD-Core Version:    0.7.0.1
 */