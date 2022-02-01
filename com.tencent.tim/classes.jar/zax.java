import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import java.util.ArrayList;
import java.util.List;

public class zax
  extends RecyclerView.Adapter<zax.b>
{
  PaintDrawable a;
  private int ccA;
  private QQAppInterface d;
  private List<Object> tD = new ArrayList();
  
  public zax(QQAppInterface paramQQAppInterface, List<Object> paramList, PaintDrawable paramPaintDrawable, int paramInt)
  {
    this.d = paramQQAppInterface;
    if (paramList != null) {
      this.tD = paramList;
    }
    this.a = paramPaintDrawable;
    this.ccA = paramInt;
  }
  
  public zax.b a(ViewGroup paramViewGroup, int paramInt)
  {
    return new zax.b(LayoutInflater.from(this.d.getApp()).inflate(2131560054, null));
  }
  
  public void a(zax.b paramb, int paramInt)
  {
    Object localObject;
    if ((this.tD != null) && (this.tD.size() > 0))
    {
      localObject = this.tD.get(paramInt);
      if (!(localObject instanceof ytq)) {
        break label113;
      }
      localObject = (ytq)localObject;
      localObject = aqdj.a(this.d, 1, ((ytq)localObject).getUin());
      paramb.f.setImageDrawable((Drawable)localObject);
      if (this.a != null)
      {
        if (paramInt != this.ccA - 1) {
          break label190;
        }
        paramb.g.setVisibility(0);
        paramb.g.setBackgroundDrawable(this.a);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
      return;
      label113:
      if ((localObject instanceof PhoneContact))
      {
        localObject = (PhoneContact)localObject;
        localObject = aqdj.a(this.d, 11, ((PhoneContact)localObject).unifiedCode);
        paramb.f.setImageDrawable((Drawable)localObject);
        break;
      }
      if (!(localObject instanceof ytp)) {
        break;
      }
      localObject = (ytp)localObject;
      localObject = aqdj.a(this.d, 11, ((ytp)localObject).a.unifiedCode);
      paramb.f.setImageDrawable((Drawable)localObject);
      break;
      label190:
      paramb.g.setVisibility(8);
    }
  }
  
  public void aJ(Object paramObject)
  {
    if (paramObject != null)
    {
      if (this.tD.size() == this.ccA)
      {
        this.tD.remove(this.ccA - 1);
        notifyItemRemoved(this.ccA - 1);
      }
      this.tD.add(0, paramObject);
      notifyItemInserted(0);
      if (this.tD.size() == this.ccA) {
        notifyItemChanged(this.ccA - 1);
      }
    }
  }
  
  public void bp(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
  }
  
  public void eu(List<Object> paramList)
  {
    if (paramList != null)
    {
      this.tD.clear();
      if (paramList.size() <= this.ccA) {
        break label52;
      }
      this.tD.addAll(paramList.subList(0, this.ccA));
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      label52:
      this.tD.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    if (this.tD != null) {
      return this.tD.size();
    }
    return 0;
  }
  
  public static class a
    extends RecyclerView.ItemDecoration
  {
    private int space;
    
    public a(int paramInt)
    {
      this.space = paramInt;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      paramRect.right = this.space;
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    public FixSizeImageView f;
    public FixSizeImageView g;
    
    public b(View paramView)
    {
      super();
      this.f = ((FixSizeImageView)paramView.findViewById(2131368375));
      this.g = ((FixSizeImageView)paramView.findViewById(2131371159));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zax
 * JD-Core Version:    0.7.0.1
 */