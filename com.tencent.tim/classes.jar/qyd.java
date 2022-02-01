import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class qyd
  implements View.OnClickListener, View.OnLongClickListener
{
  public SparseArray<View> aP;
  public SparseArray<String> aQ;
  public String azf;
  public qwo b;
  public int bov = -1;
  public HashMap<String, Object> fv;
  public View itemView;
  public Object param;
  public int position = -1;
  public int type;
  
  public qyd(View paramView)
  {
    this.itemView = paramView;
    this.aP = new SparseArray();
    this.aQ = new SparseArray();
    this.fv = new HashMap();
    paramView.setTag(this);
  }
  
  public void b(qwo paramqwo)
  {
    this.b = paramqwo;
  }
  
  public <T extends View> T get(int paramInt)
  {
    View localView2 = (View)this.aP.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.itemView.findViewById(paramInt);
      this.aP.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public View getItemView()
  {
    return this.itemView;
  }
  
  public Object l(String paramString)
  {
    return this.fv.get(paramString);
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null) {
      this.b.a(this.position, paramView, this.param, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.b != null) {
      this.b.b(this.position, paramView, this.param, this);
    }
    return true;
  }
  
  public void q(String paramString, Object paramObject)
  {
    this.fv.put(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qyd
 * JD-Core Version:    0.7.0.1
 */