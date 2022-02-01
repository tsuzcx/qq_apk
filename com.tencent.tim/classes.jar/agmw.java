import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agmw
  extends BaseAdapter
{
  private argf a;
  private Object dG;
  private View.OnClickListener eQ;
  private Context mContext;
  
  public agmw(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.mContext = paramContext;
    this.eQ = paramOnClickListener;
  }
  
  public void a(argf paramargf)
  {
    this.a = paramargf;
  }
  
  public boolean a(int paramInt, View paramView, ShaderAnimLayout paramShaderAnimLayout, Button paramButton, Object paramObject)
  {
    boolean bool = false;
    if (paramShaderAnimLayout != null)
    {
      if ((this.dG != null) && (this.dG.equals(paramObject)))
      {
        bool = true;
        paramShaderAnimLayout.show();
        if (this.a != null) {
          this.a.setMotionView(paramView, paramInt);
        }
        paramButton.setOnClickListener(this.eQ);
        paramButton.setTag(Integer.valueOf(paramInt));
      }
    }
    else {
      return bool;
    }
    paramShaderAnimLayout.eiW();
    paramButton.setOnClickListener(null);
    paramButton.setTag(null);
    return false;
  }
  
  public void bk(Object paramObject)
  {
    this.dG = paramObject;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agmw
 * JD-Core Version:    0.7.0.1
 */