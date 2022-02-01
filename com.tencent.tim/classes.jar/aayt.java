import android.content.Context;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.1;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.2;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class aayt
  extends abdt
{
  public HashSet<Integer> aJ = new HashSet(6);
  public acdu b;
  protected Set<String> bE = new HashSet();
  private boolean bqm = true;
  protected int ccY;
  protected acnd j = new aayu(this);
  public QQAppInterface mApp;
  protected Context mContext;
  public List<Integer> oW = new ArrayList(6);
  public List<Entity> tI = new ArrayList();
  public List<abge.e> tJ = new ArrayList();
  public List<abge.e> tK = new ArrayList();
  public List<abge.e> tL = new ArrayList();
  public List<abge.e> tM = new ArrayList();
  public List<abge.e> vI = new ArrayList();
  
  public aayt(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.ccY = wja.dp2px(44.0F, paramContext.getResources());
    this.mApp.addObserver(this.j);
    this.jdField_b_of_type_Acdu = ((acdu)paramQQAppInterface.getManager(53));
  }
  
  private boolean L(String paramString, int paramInt)
  {
    return this.bE.contains(paramString + "_" + paramInt);
  }
  
  private void cod()
  {
    ThreadManager.post(new TroopListBaseAdapter.3(this, (TroopManager)this.mApp.getManager(52), this.mApp.a().a()), 8, null, true);
  }
  
  public aayt.a a(int paramInt1, int paramInt2)
  {
    switch (((Integer)this.oW.get(paramInt1)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return null;
    case 0: 
      localEntity = (Entity)this.tI.get(paramInt2);
      locala = new aayt.a();
      locala.d = localEntity;
      locala.itemType = 0;
      return locala;
    case 4: 
      localEntity = ((abge.e)this.tJ.get(paramInt2)).d;
      locala = new aayt.a();
      locala.d = localEntity;
      locala.itemType = 4;
      return locala;
    case 6: 
      localEntity = ((abge.e)this.tK.get(paramInt2)).d;
      locala = new aayt.a();
      locala.d = localEntity;
      locala.itemType = 6;
      return locala;
    case 2: 
      localEntity = ((abge.e)this.tL.get(paramInt2)).d;
      locala = new aayt.a();
      locala.d = localEntity;
      locala.itemType = 2;
      return locala;
    case 8: 
      localEntity = ((abge.e)this.tM.get(paramInt2)).d;
      locala = new aayt.a();
      locala.d = localEntity;
      locala.itemType = 8;
      return locala;
    }
    Entity localEntity = ((abge.e)this.vI.get(paramInt2)).d;
    aayt.a locala = new aayt.a();
    locala.d = localEntity;
    locala.itemType = 13;
    return locala;
  }
  
  public void a(TroopInfo paramTroopInfo, acxw paramacxw)
  {
    if (this.mApp.cs(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.mApp.b().a(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramacxw.a(paramTroopInfo.troopuin, 1).lastmsgtime;
  }
  
  public void cnv()
  {
    ThreadManager.getUIHandler().post(new TroopListBaseAdapter.2(this));
  }
  
  public void destroy()
  {
    super.destroy();
    this.mApp.removeObserver(this.j);
    if (this.jdField_b_of_type_ComTencentWidgetExpandableListView != null)
    {
      int k = this.jdField_b_of_type_ComTencentWidgetExpandableListView.getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView = this.jdField_b_of_type_ComTencentWidgetExpandableListView.getChildAt(i);
        if (localView != null) {
          localView.setOnClickListener(null);
        }
        i += 1;
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int k;
    if ((paramInt < 0) || (paramInt >= this.oW.size()))
    {
      k = 0;
      return k;
    }
    int i;
    switch (((Integer)this.oW.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      i = 0;
    }
    for (;;)
    {
      k = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopListBaseAdapter", 2, "getChildrenCount count:" + i + "  groupPosition:" + paramInt);
      return i;
      i = this.tI.size();
      continue;
      i = this.tJ.size();
      continue;
      i = this.tK.size();
      continue;
      i = this.tL.size();
      continue;
      i = this.tM.size();
      continue;
      i = this.vI.size();
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "getChildrenCount mGroups.size():" + this.oW.size());
    }
    return this.oW.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (((TroopManager)this.mApp.getManager(52)).eq == null)
    {
      ThreadManager.postImmediately(new TroopListBaseAdapter.1(this), null, false);
      return;
    }
    cod();
  }
  
  public void resetData()
  {
    this.bqm = true;
    this.aJ.clear();
    notifyDataSetChanged();
  }
  
  public class a
  {
    public Entity d;
    public int itemType;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayt
 * JD-Core Version:    0.7.0.1
 */