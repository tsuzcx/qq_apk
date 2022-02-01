import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;

public class aayq
  extends abeg
{
  protected XListView C;
  private jnm.d a = new aayr(this);
  protected acdu b;
  public int cmE;
  public int cmF;
  public int cmG;
  public int cmH;
  public int cmI;
  private int cmJ;
  private int cmK;
  protected View.OnClickListener eK;
  acnd j = new aays(this);
  QQAppInterface mAppInterface;
  protected Context mContext;
  protected LayoutInflater mLayoutInflater;
  private int mType;
  protected List<aayq.b> vH = new ArrayList();
  
  public aayq(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.mContext = paramContext;
    this.mAppInterface = paramQQAppInterface;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.C = paramXListView;
    this.eK = paramOnClickListener;
    this.cmJ = paramContext.getResources().getColor(2131167304);
    this.cmK = Color.parseColor("#808080");
    this.b = ((acdu)paramQQAppInterface.getManager(53));
    paramQQAppInterface.addObserver(this.j);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, jnm.d paramd, ArrayList<String> paramArrayList)
  {
    oidb_0x88d.ReqBody localReqBody = new oidb_0x88d.ReqBody();
    localReqBody.uint32_appid.set(AppSetting.getAppId());
    Object localObject = paramArrayList.iterator();
    int i = 0;
    int k;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      String str = (String)((Iterator)localObject).next();
      k = i + 1;
      oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
      localGroupInfo.uint32_app_privilege_flag.set(0);
      oidb_0x88d.ReqGroupInfo localReqGroupInfo = new oidb_0x88d.ReqGroupInfo();
      localReqGroupInfo.uint64_group_code.set(Long.parseLong(str));
      localReqGroupInfo.stgroupinfo.set(localGroupInfo);
      localReqBody.stzreqgroupinfo.add(localReqGroupInfo);
      i = k;
    } while (k != 49);
    localObject = new Bundle();
    if (paramArrayList.size() > 50)
    {
      i = 0;
      while (i < 50)
      {
        paramArrayList.remove(0);
        i += 1;
      }
      ((Bundle)localObject).putStringArrayList("TroopList", paramArrayList);
    }
    jnm.b(paramQQAppInterface, paramd, localReqBody.toByteArray(), "OidbSvc.0x88d_0", 2189, 0, (Bundle)localObject);
  }
  
  public void c(QQAppInterface paramQQAppInterface, ArrayList<Entity> paramArrayList)
  {
    this.vH.clear();
    Object localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
    Object localObject4 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).eg();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new aayq.a());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((TroopManager)localObject1).b(((CommonlyUsedTroop)((Iterator)localObject2).next()).troopUin);
        if ((localObject3 != null) && (!((TroopInfo)localObject3).isQidianPrivateTroop())) {
          ((List)localObject4).add(localObject3);
        }
      }
      this.cmH = ((List)localObject4).size();
    }
    Object localObject3 = new ArrayList();
    localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject6 = paramArrayList.iterator();
    int i;
    label330:
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (TroopInfo)((Iterator)localObject6).next();
      if (!((TroopInfo)localObject7).isQidianPrivateTroop())
      {
        i = fS(paramQQAppInterface.cs(((TroopInfo)localObject7).troopuin));
        if ((((TroopInfo)localObject7).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject3).add(new abge.e(i, (Entity)localObject7));
        }
        for (;;)
        {
          if (((TroopInfo)localObject7).hasSetTroopName()) {
            break label330;
          }
          ((List)localObject5).add(new abge.e(i, (Entity)localObject7));
          break;
          if ((((TroopInfo)localObject7).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject2).add(new abge.e(i, (Entity)localObject7));
          } else {
            ((List)localObject1).add(new abge.e(i, (Entity)localObject7));
          }
        }
      }
    }
    localObject6 = paramQQAppInterface.a().a();
    Object localObject7 = ((acdu)paramQQAppInterface.getManager(53)).getDiscussList().iterator();
    label508:
    while (((Iterator)localObject7).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject7).next();
      RecentUser localRecentUser = ((acxw)localObject6).a(localDiscussionInfo.uin, 3000);
      localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
      if (localRecentUser.showUpTime != 0L) {
        ((List)localObject4).add(localDiscussionInfo);
      }
      if (paramQQAppInterface.getCurrentUin().equals(localDiscussionInfo.ownerUin)) {
        ((List)localObject3).add(new abge.e(1, localDiscussionInfo));
      }
      for (;;)
      {
        if (localDiscussionInfo.hasRenamed()) {
          break label508;
        }
        ((List)localObject5).add(new abge.e(1, localDiscussionInfo));
        break;
        ((List)localObject1).add(new abge.e(1, localDiscussionInfo));
      }
    }
    this.cmH = ((List)localObject4).size();
    this.cmE = ((List)localObject3).size();
    this.cmG = ((List)localObject1).size();
    this.cmI = ((List)localObject5).size();
    localObject6 = new abge.c();
    Collections.sort((List)localObject3, (Comparator)localObject6);
    Collections.sort((List)localObject2, (Comparator)localObject6);
    Collections.sort((List)localObject1, (Comparator)localObject6);
    Collections.sort((List)localObject5, (Comparator)localObject6);
    if (this.cmH > 0)
    {
      this.vH.add(new aayq.b(0, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (Entity)((Iterator)localObject4).next();
        if ((localObject6 instanceof TroopInfo))
        {
          this.vH.add(new aayq.b(1, (Entity)localObject6));
        }
        else if ((localObject6 instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)localObject6;
          i = this.b.cn(((DiscussionInfo)localObject6).uin);
          this.vH.add(new aayq.b(1, (DiscussionInfo)localObject6, i));
        }
      }
    }
    if (this.cmI > 0)
    {
      this.vH.add(new aayq.b(8, null));
      localObject4 = ((List)localObject5).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (abge.e)((Iterator)localObject4).next();
        if ((((abge.e)localObject5).d instanceof TroopInfo))
        {
          this.vH.add(new aayq.b(3, ((abge.e)localObject5).d));
        }
        else if ((((abge.e)localObject5).d instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((abge.e)localObject5).d;
          i = this.b.cn(((DiscussionInfo)localObject5).uin);
          this.vH.add(new aayq.b(3, (DiscussionInfo)localObject5, i));
        }
      }
    }
    if (this.cmE > 0)
    {
      this.vH.add(new aayq.b(4, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (abge.e)((Iterator)localObject3).next();
        if ((((abge.e)localObject4).d instanceof TroopInfo))
        {
          this.vH.add(new aayq.b(5, ((abge.e)localObject4).d));
        }
        else if ((((abge.e)localObject4).d instanceof DiscussionInfo))
        {
          localObject4 = (DiscussionInfo)((abge.e)localObject4).d;
          i = this.b.cn(((DiscussionInfo)localObject4).uin);
          this.vH.add(new aayq.b(5, (DiscussionInfo)localObject4, i));
        }
      }
    }
    this.cmF = ((List)localObject2).size();
    if (this.cmF > 0)
    {
      this.vH.add(new aayq.b(6, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (abge.e)((Iterator)localObject2).next();
        this.vH.add(new aayq.b(7, ((abge.e)localObject3).d));
      }
    }
    if (this.cmG > 0)
    {
      this.vH.add(new aayq.b(2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (abge.e)((Iterator)localObject1).next();
        if ((((abge.e)localObject2).d instanceof TroopInfo))
        {
          this.vH.add(new aayq.b(3, ((abge.e)localObject2).d));
        }
        else if ((((abge.e)localObject2).d instanceof DiscussionInfo))
        {
          localObject2 = (DiscussionInfo)((abge.e)localObject2).d;
          i = this.b.cn(((DiscussionInfo)localObject2).uin);
          this.vH.add(new aayq.b(3, (DiscussionInfo)localObject2, i));
        }
      }
    }
    if ((this.mContext instanceof SelectMemberActivity))
    {
      this.mType = ((SelectMemberActivity)this.mContext).getType();
      if (this.mType == 3000)
      {
        localObject1 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((ArrayList)localObject1).add(((TroopInfo)paramArrayList.next()).troopuin);
        }
        a(paramQQAppInterface, this.a, (ArrayList)localObject1);
      }
    }
  }
  
  public void destroy()
  {
    this.mAppInterface.removeObserver(this.j);
    super.destroy();
  }
  
  public int fS(int paramInt)
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
  
  public int getCount()
  {
    if (this.vH == null) {
      return 0;
    }
    return this.vH.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.vH != null) && (paramInt >= 0) && (paramInt < this.vH.size())) {
      return this.vH.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aayq.b localb = (aayq.b)getItem(paramInt);
    Object localObject1;
    if (localb == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    label55:
    View localView;
    Object localObject2;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject1 = (aayq.c)paramView.getTag();
      localView = paramView.findViewById(2131380330);
      localObject2 = (TextView)paramView.findViewById(2131380396);
      if (localb.itemType != 0) {
        break label242;
      }
      localView.setVisibility(8);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(this.mContext.getString(2131698428, new Object[] { String.valueOf(this.cmH) }));
    }
    label520:
    label622:
    for (;;)
    {
      localObject1 = paramView;
      break;
      paramView = this.mLayoutInflater.inflate(2131563071, this.C, false);
      localObject1 = new aayq.c();
      ((aayq.c)localObject1).pQ = ((ImageView)paramView.findViewById(2131366624));
      ((aayq.c)localObject1).wO = ((ImageView)paramView.findViewById(2131366652));
      ((aayq.c)localObject1).ON = ((TextView)paramView.findViewById(2131380362));
      ((aayq.c)localObject1).OO = ((TextView)paramView.findViewById(2131380351));
      ((aayq.c)localObject1).arrow = ((ImageView)paramView.findViewById(2131362978));
      paramView.setTag(localObject1);
      break label55;
      label242:
      if (localb.itemType == 2)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.mContext.getString(2131698448, new Object[] { String.valueOf(this.cmG) }));
      }
      else if (localb.itemType == 4)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.mContext.getString(2131698361, new Object[] { String.valueOf(this.cmE) }));
      }
      else if (localb.itemType == 6)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.mContext.getString(2131698400, new Object[] { String.valueOf(this.cmF) }));
      }
      else if (localb.itemType == 8)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.mContext.getString(2131698543, new Object[] { String.valueOf(this.cmI) }));
      }
      else
      {
        if (localb.troopInfo != null)
        {
          localView.setVisibility(0);
          ((TextView)localObject2).setVisibility(8);
          TroopInfo localTroopInfo = localb.troopInfo;
          ((aayq.c)localObject1).uin = localTroopInfo.troopuin;
          TextView localTextView = ((aayq.c)localObject1).ON;
          if (localTroopInfo.getTroopName() != null)
          {
            localObject2 = localTroopInfo.getTroopName();
            localTextView.setText((CharSequence)localObject2);
            ((aayq.c)localObject1).pQ.setImageBitmap(a(4, localTroopInfo.troopuin));
            ((aayq.c)localObject1).g = localTroopInfo;
            ((aayq.c)localObject1).c = null;
            ((aayq.c)localObject1).itemType = localb.itemType;
            if ((localTroopInfo.hasSetTroopName()) || (localTroopInfo.wMemberNumClient <= 0)) {
              break label718;
            }
            ((aayq.c)localObject1).OO.setVisibility(0);
            ((aayq.c)localObject1).OO.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
            if ((localTroopInfo.isAllowCreateDiscuss()) || (localTroopInfo.isTroopOwner(this.mAppInterface.getCurrentAccountUin())) || (localTroopInfo.isTroopAdmin(this.mAppInterface.getCurrentAccountUin()))) {
              break label731;
            }
            localView.setEnabled(false);
            ((aayq.c)localObject1).wO.setVisibility(0);
            ((aayq.c)localObject1).arrow.setVisibility(8);
            ((aayq.c)localObject1).ON.setTextColor(this.cmK);
          }
          for (;;)
          {
            paramView.setOnClickListener(this.eK);
            break;
            localObject2 = localTroopInfo.troopcode;
            break label520;
            ((aayq.c)localObject1).OO.setVisibility(8);
            break label622;
            ((aayq.c)localObject1).wO.setVisibility(8);
            ((aayq.c)localObject1).arrow.setVisibility(0);
            ((aayq.c)localObject1).ON.setTextColor(this.cmJ);
          }
        }
        if (localb.d != null)
        {
          localView.setVisibility(0);
          ((TextView)localObject2).setVisibility(8);
          localObject2 = localb.d;
          ((aayq.c)localObject1).uin = ((DiscussionInfo)localObject2).uin;
          ((aayq.c)localObject1).ON.setText(aqgv.a(this.mContext, (DiscussionInfo)localObject2));
          ((aayq.c)localObject1).pQ.setImageBitmap(a(101, ((DiscussionInfo)localObject2).uin));
          if (!((DiscussionInfo)localObject2).hasRenamed())
          {
            ((aayq.c)localObject1).OO.setVisibility(0);
            ((aayq.c)localObject1).OO.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.b.cn(((DiscussionInfo)localObject2).uin)) }));
          }
          ((aayq.c)localObject1).c = ((DiscussionInfo)localObject2);
          ((aayq.c)localObject1).g = null;
          ((aayq.c)localObject1).itemType = localb.itemType;
          ((aayq.c)localObject1).wO.setVisibility(8);
          ((aayq.c)localObject1).arrow.setVisibility(0);
          ((aayq.c)localObject1).ON.setTextColor(this.cmJ);
          paramView.setOnClickListener(this.eK);
        }
      }
    }
  }
  
  public class a
    implements Comparator<CommonlyUsedTroop>
  {
    protected a() {}
    
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
  
  public class b
  {
    public int cmL;
    public DiscussionInfo d;
    public int itemType;
    public TroopInfo troopInfo;
    
    public b(int paramInt, DiscussionInfo paramDiscussionInfo)
    {
      this.itemType = paramInt;
      this.d = paramDiscussionInfo;
    }
    
    public b(int paramInt1, DiscussionInfo paramDiscussionInfo, int paramInt2)
    {
      this.itemType = paramInt1;
      this.d = paramDiscussionInfo;
      this.cmL = paramInt2;
    }
    
    public b(int paramInt, Entity paramEntity)
    {
      this.itemType = paramInt;
      this.troopInfo = ((TroopInfo)paramEntity);
    }
  }
  
  public class c
    extends abeg.a
  {
    public TextView ON;
    public TextView OO;
    public ImageView arrow;
    public DiscussionInfo c;
    public TroopInfo g;
    public int itemType;
    public ImageView wO;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayq
 * JD-Core Version:    0.7.0.1
 */