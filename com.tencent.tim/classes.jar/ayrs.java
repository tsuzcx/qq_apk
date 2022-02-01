import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ayrs
  extends BaseAdapter
{
  protected ayrs.a a;
  protected QQAppInterface app = qem.getQQAppInterface();
  protected Context mContext;
  protected ArrayList<ayrs.b> nG;
  
  public ayrs(Context paramContext, ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.mContext = paramContext;
    this.nG = ayrs.b.g(paramArrayList, paramArrayList1);
  }
  
  public void a(ayrs.a parama)
  {
    this.a = parama;
  }
  
  public void a(ayrs.b paramb)
  {
    if ((this.a == null) || (this.a.a(bw(), paramb))) {
      if (paramb.isCheck) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      paramb.isCheck = bool;
      notifyDataSetChanged();
      if (this.a != null) {
        this.a.z(bw());
      }
      return;
    }
  }
  
  public ArrayList<String> bw()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.nG != null)
    {
      int i = 0;
      while (i < this.nG.size())
      {
        ayrs.b localb = (ayrs.b)this.nG.get(i);
        if ((localb.isCheck) && (!localArrayList.contains(localb.a.troopuin))) {
          localArrayList.add(localb.a.troopuin);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.ShareToGrouopAdapter", 2, "selectTroopUinList" + localArrayList);
    }
    return localArrayList;
  }
  
  public int getCount()
  {
    if (this.nG == null) {
      return 0;
    }
    return this.nG.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.nG.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ayrs.b localb = (ayrs.b)getItem(paramInt);
    TroopInfo localTroopInfo = localb.a;
    qyd localqyd;
    ImageView localImageView;
    Drawable localDrawable;
    if (paramView != null)
    {
      localqyd = (qyd)paramView.getTag();
      localImageView = (ImageView)localqyd.get(2131368159);
      localDrawable = this.app.l(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label168;
      }
      localImageView.setImageBitmap(aqhu.aL());
      label69:
      ((TextView)localqyd.get(2131368211)).setText(localTroopInfo.troopname);
      ((CheckBox)localqyd.get(2131364592)).setChecked(localb.isCheck);
      if (getCount() > 1) {
        break label178;
      }
      paramView.setBackgroundResource(2130839682);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.mContext).inflate(2131560861, null);
      localqyd = new qyd(paramView);
      paramView.setTag(localqyd);
      break;
      label168:
      localImageView.setImageDrawable(localDrawable);
      break label69;
      label178:
      if (paramInt == 0) {
        paramView.setBackgroundResource(2130839701);
      } else if (paramInt == getCount() - 1) {
        paramView.setBackgroundResource(2130839689);
      } else {
        paramView.setBackgroundResource(2130839695);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(ArrayList<String> paramArrayList, ayrs.b paramb);
    
    public abstract void z(ArrayList<String> paramArrayList);
  }
  
  public static class b
  {
    TroopInfo a;
    public boolean isCheck;
    
    public b(boolean paramBoolean, TroopInfo paramTroopInfo)
    {
      this.isCheck = paramBoolean;
      this.a = paramTroopInfo;
    }
    
    public static ArrayList<b> g(ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
    {
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      int i = 0;
      while (i < paramArrayList.size())
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        b localb = new b(false, localTroopInfo);
        if ((paramArrayList1 != null) && (paramArrayList1.contains(localTroopInfo.troopuin))) {
          localb.isCheck = true;
        }
        localArrayList.add(localb);
        i += 1;
      }
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrs
 * JD-Core Version:    0.7.0.1
 */