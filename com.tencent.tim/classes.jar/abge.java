import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.a;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.adapter.TroopListAdapter2.2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class abge
  extends abeg
  implements CompoundButton.OnCheckedChangeListener
{
  abge.b jdField_a_of_type_Abge$b;
  ShowExternalTroopListActivity.a jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$a;
  QQAppInterface app;
  protected acdu b;
  protected TroopManager b;
  protected boolean bCj;
  protected boolean bCk = true;
  protected boolean bpw;
  public int cmE;
  public int cmF;
  public int cmG;
  public int cmI;
  int coh = 0;
  public int coi;
  public int coj;
  Context context;
  protected View.OnClickListener eL = new abgh(this);
  protected View.OnClickListener eo = new abgg(this);
  protected HashMap<String, Switch> ih;
  SlideDetectListView k;
  protected acnd l;
  protected LayoutInflater layoutInflater;
  public boolean mIsResume = true;
  public List<abge.d> vH = new ArrayList();
  protected List<Entity> vV = new ArrayList();
  
  public abge(Context paramContext, QQAppInterface paramQQAppInterface, abge.b paramb, XListView paramXListView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ShowExternalTroopListActivity.a parama)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Abge$b = paramb;
    this.context = paramContext;
    this.coh = paramInt;
    this.k = ((SlideDetectListView)paramXListView);
    this.layoutInflater = LayoutInflater.from(paramContext);
    this.bpw = paramBoolean1;
    this.bCk = paramBoolean2;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$a = parama;
    this.jdField_b_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(52));
    this.jdField_b_of_type_Acdu = ((acdu)paramQQAppInterface.getManager(53));
    if ((this.bpw) && ((this.context instanceof TroopActivity)))
    {
      this.ih = new HashMap();
      this.l = new abgf(this, (TroopActivity)this.context);
    }
  }
  
  private void a(abge.d paramd, String paramString, boolean paramBoolean)
  {
    ((acms)this.app.getBusinessHandler(20)).h(paramString, paramd.troopInfo.troopuin, paramBoolean, false);
    if (paramBoolean) {
      anot.a(this.app, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramd.troopInfo.troopuin, "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$a.bf(paramd.troopInfo.troopuin, paramBoolean);
      }
      return;
      anot.a(this.app, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramd.troopInfo.troopuin, "", "", "");
    }
  }
  
  private List<abge.d> dB()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.bpw) && (this.ih != null)) {
      this.ih.clear();
    }
    Object localObject1 = (TroopManager)this.app.getManager(52);
    this.vV = ((TroopManager)localObject1).cE();
    if (this.vV == null)
    {
      this.vV = new ArrayList();
      return localArrayList;
    }
    Object localObject5 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).eg();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new abge.a());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject5).add(((TroopManager)localObject1).b(((CommonlyUsedTroop)((Iterator)localObject2).next()).troopUin));
      }
      this.coi = ((List)localObject5).size();
    }
    Object localObject4 = new ArrayList();
    Object localObject3 = new ArrayList();
    localObject2 = new ArrayList();
    Object localObject6 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject7 = this.vV.iterator();
    label395:
    while (((Iterator)localObject7).hasNext())
    {
      localObject8 = (TroopInfo)((Iterator)localObject7).next();
      int i = fS(this.app.cs(((TroopInfo)localObject8).troopuin));
      if (((TroopInfo)localObject8).isQidianPrivateTroop())
      {
        ((List)localObject1).add(new abge.e(i, (Entity)localObject8));
      }
      else
      {
        if ((((TroopInfo)localObject8).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new abge.e(i, (Entity)localObject8));
        }
        for (;;)
        {
          if (((TroopInfo)localObject8).hasSetTroopName()) {
            break label395;
          }
          ((List)localObject6).add(new abge.e(i, (Entity)localObject8));
          break;
          if ((((TroopInfo)localObject8).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject3).add(new abge.e(i, (Entity)localObject8));
          } else {
            ((List)localObject2).add(new abge.e(i, (Entity)localObject8));
          }
        }
      }
    }
    localObject7 = this.app.a().a();
    Object localObject8 = ((acdu)this.app.getManager(53)).getDiscussList();
    if (this.bCk)
    {
      localObject8 = ((List)localObject8).iterator();
      label593:
      while (((Iterator)localObject8).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject8).next();
        RecentUser localRecentUser = ((acxw)localObject7).a(localDiscussionInfo.uin, 3000);
        localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
        if (localRecentUser.showUpTime != 0L) {
          ((List)localObject5).add(localDiscussionInfo);
        }
        if (this.app.getCurrentUin().equals(localDiscussionInfo.ownerUin)) {
          ((List)localObject4).add(new abge.e(1, localDiscussionInfo));
        }
        for (;;)
        {
          if (localDiscussionInfo.hasRenamed()) {
            break label593;
          }
          ((List)localObject6).add(new abge.e(1, localDiscussionInfo));
          break;
          ((List)localObject2).add(new abge.e(1, localDiscussionInfo));
        }
      }
    }
    if (this.coh == 2)
    {
      ((List)localObject5).clear();
      ((List)localObject2).clear();
      ((List)localObject6).clear();
      ((List)localObject1).clear();
    }
    this.coi = ((List)localObject5).size();
    this.cmE = ((List)localObject4).size();
    this.cmG = ((List)localObject2).size();
    this.cmI = ((List)localObject6).size();
    localObject7 = new abge.c();
    Collections.sort((List)localObject4, (Comparator)localObject7);
    Collections.sort((List)localObject3, (Comparator)localObject7);
    Collections.sort((List)localObject2, (Comparator)localObject7);
    Collections.sort((List)localObject6, (Comparator)localObject7);
    Collections.sort((List)localObject1, (Comparator)localObject7);
    if (this.coi > 0)
    {
      localArrayList.add(new abge.d(0, null));
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject5).next();
        if ((localObject7 instanceof TroopInfo))
        {
          localArrayList.add(new abge.d(1, (Entity)localObject7));
        }
        else if ((localObject7 instanceof DiscussionInfo))
        {
          localObject7 = (DiscussionInfo)localObject7;
          localArrayList.add(new abge.d(1, (DiscussionInfo)localObject7, this.jdField_b_of_type_Acdu.cn(((DiscussionInfo)localObject7).uin)));
        }
      }
    }
    if (this.cmI > 0)
    {
      localArrayList.add(new abge.d(8, null));
      localObject5 = ((List)localObject6).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (abge.e)((Iterator)localObject5).next();
        if ((((abge.e)localObject6).d instanceof TroopInfo))
        {
          localArrayList.add(new abge.d(9, ((abge.e)localObject6).d));
        }
        else if ((((abge.e)localObject6).d instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)((abge.e)localObject6).d;
          localArrayList.add(new abge.d(9, (DiscussionInfo)localObject6, this.jdField_b_of_type_Acdu.cn(((DiscussionInfo)localObject6).uin)));
        }
      }
    }
    if (this.cmE > 0)
    {
      localArrayList.add(new abge.d(4, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (abge.e)((Iterator)localObject4).next();
        if ((((abge.e)localObject5).d instanceof TroopInfo))
        {
          localArrayList.add(new abge.d(5, ((abge.e)localObject5).d));
        }
        else if ((((abge.e)localObject5).d instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((abge.e)localObject5).d;
          localArrayList.add(new abge.d(5, (DiscussionInfo)localObject5, this.jdField_b_of_type_Acdu.cn(((DiscussionInfo)localObject5).uin)));
        }
      }
    }
    this.cmF = ((List)localObject3).size();
    if (this.cmF > 0)
    {
      localArrayList.add(new abge.d(6, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(new abge.d(7, ((abge.e)((Iterator)localObject3).next()).d));
      }
    }
    if (this.cmG > 0)
    {
      localArrayList.add(new abge.d(2, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (abge.e)((Iterator)localObject2).next();
        if ((((abge.e)localObject3).d instanceof TroopInfo))
        {
          localArrayList.add(new abge.d(3, ((abge.e)localObject3).d));
        }
        else if ((((abge.e)localObject3).d instanceof DiscussionInfo))
        {
          localObject3 = (DiscussionInfo)((abge.e)localObject3).d;
          localArrayList.add(new abge.d(3, (DiscussionInfo)localObject3, this.jdField_b_of_type_Acdu.cn(((DiscussionInfo)localObject3).uin)));
        }
      }
    }
    this.coj = ((List)localObject1).size();
    if (this.coj > 0)
    {
      localArrayList.add(new abge.d(10, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(new abge.d(11, ((abge.e)((Iterator)localObject1).next()).d));
      }
    }
    return localArrayList;
  }
  
  public static int fS(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.vH.size())) {
      return ((abge.d)this.vH.get(paramInt)).troopInfo;
    }
    return null;
  }
  
  public int getCount()
  {
    return this.vH.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.vH.get(paramInt);
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.bCj = true;
    Object localObject1 = (abge.d)getItem(paramInt);
    abge.f localf;
    if (paramView == null)
    {
      paramView = this.layoutInflater.inflate(2131560085, paramViewGroup, false);
      localf = new abge.f(paramView);
      paramView.setTag(localf);
      ((Button)paramView.findViewById(2131380243)).setOnClickListener(this.eo);
      paramView.setOnClickListener(this.eL);
      if (this.bpw) {
        localf.D.setOnCheckedChangeListener(this);
      }
      localf.b = ((abge.d)localObject1);
      if ((this.bpw) && (localf.b.itemType != 0) && (localf.b.itemType != 4) && (localf.b.itemType != 6) && (localf.b.itemType != 8) && (localf.b.itemType != 2))
      {
        localf.D.setVisibility(0);
        localf.D.setTag(localf.b);
        if (this.jdField_b_of_type_ComTencentMobileqqAppTroopManager == null) {
          this.jdField_b_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqAppTroopManager == null) || (localf.b.troopInfo == null) || (!this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.kx(((abge.d)localObject1).troopInfo.troopuin))) {
          break label379;
        }
        localf.D.setChecked(true);
        label254:
        if ((this.ih != null) && (((abge.d)localObject1).troopInfo != null)) {
          this.ih.put(((abge.d)localObject1).troopInfo.troopuin, localf.D);
        }
      }
      if (((abge.d)localObject1).itemType != 0) {
        break label391;
      }
      localf.AF.setVisibility(8);
      localf.jf.setVisibility(0);
      localf.PB.setText(acfp.m(2131715834));
      localf.PC.setText(String.valueOf(this.coi));
    }
    for (;;)
    {
      this.bCj = false;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localf = (abge.f)paramView.getTag();
      break;
      label379:
      localf.D.setChecked(false);
      break label254;
      label391:
      if (((abge.d)localObject1).itemType == 2)
      {
        localf.AF.setVisibility(8);
        localf.jf.setVisibility(0);
        localf.PB.setText(acfp.m(2131716172));
        localf.PC.setText(String.valueOf(this.cmG));
      }
      else if (((abge.d)localObject1).itemType == 4)
      {
        localf.AF.setVisibility(8);
        localf.jf.setVisibility(0);
        localf.PB.setText(acfp.m(2131716176));
        localf.PC.setText(String.valueOf(this.cmE));
      }
      else if (((abge.d)localObject1).itemType == 6)
      {
        localf.AF.setVisibility(8);
        localf.jf.setVisibility(0);
        localf.PB.setText(acfp.m(2131716179));
        localf.PC.setText(String.valueOf(this.cmF));
      }
      else if (((abge.d)localObject1).itemType == 8)
      {
        localf.AF.setVisibility(8);
        localf.jf.setVisibility(0);
        localf.PB.setText(acfp.m(2131716177));
        localf.PC.setText(String.valueOf(this.cmI));
      }
      else if (((abge.d)localObject1).itemType == 10)
      {
        localf.AF.setVisibility(8);
        localf.jf.setVisibility(0);
        localf.PB.setText(acfp.m(2131704478));
        localf.PC.setText(String.valueOf(this.coj));
      }
      else
      {
        Object localObject2;
        if (((abge.d)localObject1).troopInfo != null)
        {
          localf.AF.setVisibility(0);
          localf.jf.setVisibility(8);
          localObject2 = ((abge.d)localObject1).troopInfo;
          localf.uin = ((TroopInfo)localObject2).troopuin;
          if (this.app.cs(((TroopInfo)localObject2).troopuin) != 3)
          {
            localf.uT.setVisibility(4);
            label763:
            TextView localTextView = localf.fe;
            if (TextUtils.isEmpty(((TroopInfo)localObject2).getTroopName())) {
              break label980;
            }
            localObject1 = ((TroopInfo)localObject2).getTroopName();
            label788:
            localTextView.setText((CharSequence)localObject1);
            localf.pQ.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
            if ((((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
              break label990;
            }
            localf.OO.setVisibility(0);
            localf.OO.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
            label867:
            if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
              break label1049;
            }
            if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
              break label1003;
            }
            localf.uV.setVisibility(0);
            localf.uV.setBackgroundResource(2130844648);
          }
          label1049:
          for (;;)
          {
            if (((TroopInfo)localObject2).troopCreditLevel != 2L) {
              break label1062;
            }
            localf.uU.setVisibility(0);
            localf.uT.setVisibility(0);
            localf.uT.setImageResource(2130851449);
            break;
            localf.uT.setVisibility(0);
            localf.uT.setImageResource(2130851446);
            break label763;
            label980:
            localObject1 = ((TroopInfo)localObject2).troopuin;
            break label788;
            label990:
            localf.OO.setVisibility(8);
            break label867;
            label1003:
            if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
            {
              localf.uV.setVisibility(0);
              localf.uV.setBackgroundResource(2130844648);
            }
            else
            {
              localf.uV.setVisibility(8);
              continue;
              localf.uV.setVisibility(8);
            }
          }
          label1062:
          if (((TroopInfo)localObject2).troopCreditLevel == 1L)
          {
            localf.uU.setVisibility(0);
            localf.uT.setVisibility(0);
            localf.uT.setImageResource(2130851447);
          }
          else
          {
            localf.uU.setVisibility(4);
          }
        }
        else if (((abge.d)localObject1).d != null)
        {
          localf.AF.setVisibility(0);
          localf.jf.setVisibility(8);
          localObject2 = ((abge.d)localObject1).d;
          localf.uin = ((DiscussionInfo)localObject2).uin;
          localf.uT.setVisibility(4);
          localf.fe.setText(aqgv.a(this.context, (DiscussionInfo)localObject2));
          if (!((DiscussionInfo)localObject2).hasRenamed())
          {
            localf.OO.setVisibility(0);
            localf.OO.setText(String.format("(%d)", new Object[] { Integer.valueOf(((abge.d)localObject1).cmL) }));
          }
          localf.pQ.setImageBitmap(a(101, ((DiscussionInfo)localObject2).uin));
        }
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    ThreadManager.post(new TroopListAdapter2.2(this), 8, null, true);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.bCj) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      Object localObject = paramCompoundButton.getTag();
      if ((localObject instanceof abge.d))
      {
        localObject = (abge.d)localObject;
        if (((abge.d)localObject).troopInfo != null)
        {
          if (this.jdField_b_of_type_ComTencentMobileqqAppTroopManager == null) {
            this.jdField_b_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
          }
          String str1 = ((abge.d)localObject).troopInfo.troopcode;
          String str2 = ((abge.d)localObject).troopInfo.troopuin;
          TroopManager localTroopManager = this.jdField_b_of_type_ComTencentMobileqqAppTroopManager;
          if (TextUtils.isEmpty(str1)) {
            ThreadManager.post(new TroopListAdapter2.5(this, localTroopManager, str2, (abge.d)localObject, paramBoolean), 8, null, true);
          } else {
            a((abge.d)localObject, str1, paramBoolean);
          }
        }
      }
    }
  }
  
  public static class a
    implements Comparator<CommonlyUsedTroop>
  {
    public int a(CommonlyUsedTroop paramCommonlyUsedTroop1, CommonlyUsedTroop paramCommonlyUsedTroop2)
    {
      if (paramCommonlyUsedTroop1.addedTimestamp < paramCommonlyUsedTroop2.addedTimestamp) {
        return 1;
      }
      if (paramCommonlyUsedTroop1.addedTimestamp > paramCommonlyUsedTroop2.addedTimestamp) {
        return -1;
      }
      return 0;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(DiscussionInfo paramDiscussionInfo);
    
    public abstract void a(TroopInfo paramTroopInfo, int paramInt);
  }
  
  public static class c
    implements Comparator<abge.e>
  {
    private int a(abge.e parame)
    {
      if ((a(parame) == 0L) || (parame.maskType == 4)) {
        return parame.maskType + 3;
      }
      return parame.maskType;
    }
    
    private long a(abge.e parame)
    {
      if ((parame.d instanceof TroopInfo)) {
        return ((TroopInfo)parame.d).lastMsgTime;
      }
      if ((parame.d instanceof DiscussionInfo)) {
        return ((DiscussionInfo)parame.d).lastMsgTime;
      }
      return 0L;
    }
    
    public int a(abge.e parame1, abge.e parame2)
    {
      if ((parame1 == null) && (parame2 == null)) {
        return 0;
      }
      if (parame1 == null) {
        return -1;
      }
      if (parame2 == null) {
        return 1;
      }
      if (a(parame1) == a(parame2)) {
        return (int)(a(parame2) - a(parame1));
      }
      return a(parame1) - a(parame2);
    }
  }
  
  public static class d
  {
    public int cmL;
    public DiscussionInfo d;
    public int itemType;
    public TroopInfo troopInfo;
    
    public d(int paramInt, DiscussionInfo paramDiscussionInfo)
    {
      this.itemType = paramInt;
      this.d = paramDiscussionInfo;
    }
    
    public d(int paramInt1, DiscussionInfo paramDiscussionInfo, int paramInt2)
    {
      this.itemType = paramInt1;
      this.d = paramDiscussionInfo;
      this.cmL = paramInt2;
    }
    
    public d(int paramInt, Entity paramEntity)
    {
      this.itemType = paramInt;
      this.troopInfo = ((TroopInfo)paramEntity);
    }
  }
  
  public static class e
  {
    public Entity d;
    public int maskType;
    
    public e(int paramInt, Entity paramEntity)
    {
      this.maskType = paramInt;
      this.d = paramEntity;
    }
  }
  
  public static class f
    extends abeg.a
  {
    public View AF;
    public Switch D;
    public TextView Mu;
    public TextView OO;
    public TextView PB;
    public TextView PC;
    public abge.d b;
    public TextView fe;
    public RelativeLayout jf;
    public ImageView uT;
    public ImageView uU;
    public ImageView uV;
    
    public f(View paramView)
    {
      this.pQ = ((ImageView)paramView.findViewById(2131368698));
      this.uU = ((ImageView)paramView.findViewById(2131371159));
      this.uT = ((ImageView)paramView.findViewById(2131378715));
      this.jf = ((RelativeLayout)paramView.findViewById(2131377518));
      this.fe = ((TextView)paramView.findViewById(2131379402));
      this.OO = ((TextView)paramView.findViewById(2131379404));
      this.Mu = ((TextView)paramView.findViewById(2131372035));
      this.Mu.setVisibility(8);
      this.uV = ((ImageView)paramView.findViewById(2131380238));
      this.pQ.setClickable(false);
      this.D = ((Switch)paramView.findViewById(2131374477));
      this.AF = paramView.findViewById(2131380330);
      this.PB = ((TextView)paramView.findViewById(2131380396));
      this.PC = ((TextView)paramView.findViewById(2131380395));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abge
 * JD-Core Version:    0.7.0.1
 */