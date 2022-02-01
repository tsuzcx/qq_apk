import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aypy
  extends auvp
{
  public static final TroopBarPOI c = new TroopBarPOI("-1", "", acfp.m(2131712394), 0, "", 0, "");
  protected TroopBarPOI a;
  protected ArrayList<TroopBarPOI> kd = new ArrayList();
  protected LayoutInflater mInflater;
  
  public aypy(Context paramContext)
  {
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(ArrayList<TroopBarPOI> paramArrayList, TroopBarPOI paramTroopBarPOI)
  {
    this.kd.clear();
    this.kd.addAll(paramArrayList);
    if (paramTroopBarPOI != null) {
      this.a = new TroopBarPOI(paramTroopBarPOI);
    }
  }
  
  public int getCount()
  {
    if (this.kd == null) {
      return 0;
    }
    return this.kd.size();
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
    Object localObject;
    TroopBarPOI localTroopBarPOI;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131561938, null);
      localObject = new aypy.a();
      ((aypy.a)localObject).nt = ((ImageView)paramView.findViewById(2131377968));
      ((aypy.a)localObject).yM = ((TextView)paramView.findViewById(2131370317));
      paramView.setTag(localObject);
      localTroopBarPOI = (TroopBarPOI)this.kd.get(paramInt);
      ((aypy.a)localObject).yM.setText(localTroopBarPOI.name);
      localObject = ((aypy.a)localObject).nt;
      if (!localTroopBarPOI.equals(this.a)) {
        break label160;
      }
    }
    label160:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      paramView.setContentDescription(localTroopBarPOI.name);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (aypy.a)paramView.getTag();
      break;
    }
  }
  
  public static class a
  {
    protected ImageView nt;
    protected TextView yM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypy
 * JD-Core Version:    0.7.0.1
 */