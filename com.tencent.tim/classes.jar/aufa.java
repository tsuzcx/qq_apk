import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aufa
  extends BaseAdapter
{
  private int dcJ;
  private ArrayList<aufa.b> iM;
  private ausj mActionSheet;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public static aufa.b a(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    aufa.b localb = new aufa.b();
    localb.gD = paramOnClickListener;
    localb.erp = paramInt;
    localb.cIq = paramString;
    return localb;
  }
  
  public int getCount()
  {
    return this.iM.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new aufa.a();
      localView = this.mInflater.inflate(2131561001, null);
      paramView.ny = ((ImageView)localView.findViewById(2131369043));
      paramView.mTitle = ((TextView)localView.findViewById(2131379506));
      localView.setTag(paramView);
      if (paramInt != this.dcJ) {
        break label177;
      }
      localView.setSelected(true);
    }
    for (;;)
    {
      paramView.mTitle.setText(((aufa.b)this.iM.get(paramInt)).cIq);
      paramView.ny.setBackgroundDrawable(audx.a(this.mContext, ((aufa.b)this.iM.get(paramInt)).erp));
      localView.setTag(paramView);
      localView.setOnClickListener(new aufb(this, paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      aufa.a locala = (aufa.a)paramView.getTag();
      localView = paramView;
      paramView = locala;
      break;
      label177:
      localView.setSelected(false);
    }
  }
  
  public static class a
  {
    public TextView mTitle;
    public ImageView ny;
  }
  
  public static class b
  {
    public String cIq;
    public int erp;
    public View.OnClickListener gD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufa
 * JD-Core Version:    0.7.0.1
 */