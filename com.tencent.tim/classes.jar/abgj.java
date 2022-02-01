import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class abgj
  extends BaseAdapter
{
  private TroopManager b;
  private QQAppInterface mApp;
  private Context mContext;
  private List<Long> vZ = new ArrayList();
  
  public abgj(Context paramContext, QQAppInterface paramQQAppInterface, List<Long> paramList)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.vZ = paramList;
    this.b = ((TroopManager)this.mApp.getManager(52));
  }
  
  private void v(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMessageSettingAdapter", 2, "setItemBackground() childPos = " + paramInt1 + ", listSize = " + paramInt2);
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130839682);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130839701);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130839689);
      return;
    }
    paramView.setBackgroundResource(2130839695);
  }
  
  public void cS(List<Long> paramList)
  {
    this.vZ = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.vZ == null) {
      return 0;
    }
    return this.vZ.size();
  }
  
  public Object getItem(int paramInt)
  {
    String str = String.valueOf(this.vZ.get(paramInt));
    return this.b.c(str);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopInfo localTroopInfo = this.b.c(String.valueOf(this.vZ.get(paramInt)));
    Object localObject;
    View localView;
    if (paramView != null)
    {
      localObject = (abgj.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      localObject = this.mApp.l(localTroopInfo.troopuin);
      if (localObject != null) {
        break label219;
      }
      localObject = aqhu.aL();
      paramView.nN.setImageBitmap((Bitmap)localObject);
    }
    for (;;)
    {
      paramView.PD.setText(localTroopInfo.getTroopName());
      paramView.PE.setVisibility(0);
      v(localView, paramInt, getCount());
      localView.setBackgroundResource(2130839682);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = LayoutInflater.from(this.mContext).inflate(2131563079, null);
      paramView = new abgj.a();
      paramView.nN = ((ImageView)localView.findViewById(2131368159));
      paramView.PD = ((TextView)localView.findViewById(2131368211));
      paramView.PE = ((TextView)localView.findViewById(2131368175));
      paramView.xr = ((ImageView)localView.findViewById(2131377180));
      localView.setTag(paramView);
      break;
      label219:
      paramView.nN.setImageDrawable((Drawable)localObject);
    }
  }
  
  public class a
  {
    public TextView PD;
    public TextView PE;
    public ImageView nN;
    public ImageView xr;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgj
 * JD-Core Version:    0.7.0.1
 */