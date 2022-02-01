import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class aplb<VH extends RecyclerView.ViewHolder, D extends apkn>
  implements View.OnClickListener
{
  public aplb.a a;
  public XMediaEditor e;
  
  public aplb(XMediaEditor paramXMediaEditor)
  {
    this.e = paramXMediaEditor;
  }
  
  public abstract VH a(ViewGroup paramViewGroup);
  
  public aplb.a a()
  {
    return this.a;
  }
  
  public aplb a(aplb.a parama)
  {
    this.a = parama;
    return this;
  }
  
  public abstract void a(VH paramVH, D paramD, int paramInt);
  
  public abstract void a(View paramView, VH paramVH);
  
  public void b(View paramView, VH paramVH)
  {
    paramView.setTag(paramVH);
    paramView.setOnClickListener(this);
  }
  
  public void d(D paramD) {}
  
  public void e(D paramD) {}
  
  public void f(D paramD) {}
  
  public void onClick(View paramView)
  {
    a(paramView, (RecyclerView.ViewHolder)paramView.getTag());
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onViewAttachedToWindow(VH paramVH) {}
  
  public void onViewDetachedFromWindow(VH paramVH) {}
  
  public void onViewRecycled(VH paramVH) {}
  
  public void release() {}
  
  public static abstract interface a
  {
    public abstract void c(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean);
    
    public abstract void h(RecyclerView.ViewHolder paramViewHolder);
    
    public abstract void i(RecyclerView.ViewHolder paramViewHolder);
    
    public abstract void j(RecyclerView.ViewHolder paramViewHolder);
    
    public abstract void jR(int paramInt1, int paramInt2);
    
    public abstract void k(RecyclerView.ViewHolder paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplb
 * JD-Core Version:    0.7.0.1
 */