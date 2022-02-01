import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.open.agent.BindGroupAdapter.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class arpt
  extends abeg
{
  private Context mContext;
  private List<TroopInfo> vY;
  
  public arpt(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.mContext = paramContext;
    this.vY = new ArrayList();
  }
  
  private void a(arpt.a parama, TroopInfo paramTroopInfo)
  {
    parama.uin = paramTroopInfo.troopuin;
    parama.type = 4;
    parama.troopInfo = paramTroopInfo;
    parama.Pq.setText(paramTroopInfo.getTroopName());
    if (paramTroopInfo.isThirdAppBind())
    {
      parama.acG.setVisibility(0);
      parama.acG.setText(acfp.m(2131703210));
    }
    for (;;)
    {
      parama.pQ.setImageBitmap(a(4, paramTroopInfo.troopuin));
      return;
      parama.acG.setVisibility(8);
    }
  }
  
  public TroopInfo b(int paramInt)
  {
    return (TroopInfo)this.vY.get(paramInt);
  }
  
  public int getCount()
  {
    return this.vY.size();
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
      localView = LayoutInflater.from(this.mContext).inflate(2131560153, null);
      paramView = new arpt.a();
      paramView.pQ = ((ImageView)localView.findViewById(2131369092));
      paramView.Pq = ((TextView)localView.findViewById(2131381145));
      paramView.acG = ((TextView)localView.findViewById(2131381154));
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramView, b(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      arpt.a locala = (arpt.a)paramView.getTag();
      localView = paramView;
      paramView = locala;
    }
  }
  
  public void nj(List<TroopInfo> paramList)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (paramList != null)
      {
        this.vY.clear();
        this.vY.addAll(paramList);
        notifyDataSetChanged();
      }
      return;
    }
    ThreadManager.getUIHandler().post(new BindGroupAdapter.1(this, paramList));
  }
  
  public static class a
    extends abeg.a
  {
    public TextView Pq;
    public TextView acG;
    public TroopInfo troopInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpt
 * JD-Core Version:    0.7.0.1
 */