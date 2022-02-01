import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class abel
  extends abdt
  implements View.OnClickListener
{
  public static int cnY = 1003;
  protected QQAppInterface app;
  private abel.b b;
  protected aqeb b;
  private boolean bCc;
  private View.OnClickListener dm = new abem(this);
  protected HashMap<Integer, ArrayList<Entity>> ie = new HashMap();
  protected HashMap<Integer, String> jdField_if = new HashMap();
  protected acff l;
  protected Context mContext;
  protected float mDensity;
  protected List<Entity> oW;
  
  public abel(Context paramContext, ExpandableListView paramExpandableListView, QQAppInterface paramQQAppInterface, List<Entity> paramList, abel.b paramb, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.app = paramQQAppInterface;
    this.l = ((acff)paramQQAppInterface.getManager(51));
    this.mContext = paramContext;
    this.jdField_b_of_type_Abel$b = paramb;
    this.bCc = paramBoolean;
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Aqeb = new aqeb(paramContext);
    this.jdField_b_of_type_Aqeb.kh((int)(this.mDensity * 100.0F), (int)(this.mDensity * 100.0F));
    ae(paramList, false);
    if (this.bCc) {
      cAm();
    }
  }
  
  public static void GX(int paramInt)
  {
    cnY = paramInt;
  }
  
  private void cAm()
  {
    Object localObject1 = (PhoneContactManagerImp)this.app.getManager(11);
    int i = ((PhoneContactManagerImp)localObject1).xy();
    if ((((PhoneContactManagerImp)localObject1).Ur()) || (i == 8))
    {
      Object localObject2 = ((PhoneContactManagerImp)localObject1).cT();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1002;
          ((Groups)localObject2).group_name = this.mContext.getString(2131696819);
          ((Groups)localObject2).group_friend_count = 1;
          ((Groups)localObject2).seqid = 0;
          this.oW.add(localObject2);
          this.ie.put(Integer.valueOf(((Groups)localObject2).group_id), localObject1);
        }
      }
    }
  }
  
  private ArrayList<Entity> cj()
  {
    return v(this.app.a().a().q(true));
  }
  
  private ArrayList<Entity> v(List<RecentUser> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() == 0) && (!aqft.rk(localRecentUser.uin)) && (this.l != null) && (this.l.isFriend(localRecentUser.uin))) {
        localArrayList.add(this.l.e(localRecentUser.uin));
      }
    }
    return localArrayList;
  }
  
  public static int zv()
  {
    return cnY;
  }
  
  public List<Entity> H(int paramInt)
  {
    paramInt = ((Groups)getGroup(paramInt)).group_id;
    return (List)this.ie.get(Integer.valueOf(paramInt));
  }
  
  public void ae(List<Entity> paramList, boolean paramBoolean)
  {
    this.oW = paramList;
    paramList = this.oW.iterator();
    if (paramList.hasNext())
    {
      Groups localGroups = (Groups)paramList.next();
      ArrayList localArrayList;
      int i;
      if ((localGroups.group_id == zv()) && (!this.ie.containsKey(Integer.valueOf(zv()))))
      {
        localArrayList = cj();
        this.ie.put(Integer.valueOf(zv()), localArrayList);
        if (localArrayList == null)
        {
          i = 0;
          label94:
          localGroups.group_friend_count = i;
        }
      }
      for (;;)
      {
        this.jdField_if.put(Integer.valueOf(localGroups.group_id), localGroups.group_name);
        break;
        i = localArrayList.size();
        break label94;
        Object localObject = ((acff)this.app.getManager(51)).B(String.valueOf(localGroups.group_id));
        localArrayList = new ArrayList();
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
        {
          localArrayList.addAll((Collection)localObject);
          localObject = localArrayList.iterator();
          label330:
          while (((Iterator)localObject).hasNext())
          {
            try
            {
              Friends localFriends = (Friends)((Iterator)localObject).next();
              if (!aqft.rj(localFriends.uin)) {
                break label248;
              }
              ((Iterator)localObject).remove();
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            continue;
            label248:
            if ((TextUtils.equals(localException.uin, this.app.getCurrentAccountUin())) && (this.mContext != null) && ((this.mContext instanceof ForwardFriendListActivity)))
            {
              Intent localIntent = ((ForwardFriendListActivity)this.mContext).getIntent();
              if (localIntent != null) {}
              for (boolean bool = localIntent.getBooleanExtra("choose_friend_isForConfess", false);; bool = false)
              {
                if (!bool) {
                  break label330;
                }
                ((Iterator)localObject).remove();
                break;
              }
            }
          }
        }
        this.ie.put(Integer.valueOf(localGroups.group_id), localArrayList);
      }
    }
    if (paramBoolean) {
      super.notifyDataSetChanged();
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return H(paramInt1).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    ForwardRecentItemView localForwardRecentItemView;
    Object localObject1;
    Object localObject2;
    String str;
    if (paramView == null)
    {
      localForwardRecentItemView = new ForwardRecentItemView(this.mContext);
      paramViewGroup = new abel.c();
      localForwardRecentItemView.setTag(paramViewGroup);
      localObject1 = getChild(paramInt1, paramInt2);
      if (!(localObject1 instanceof PhoneContact)) {
        break label284;
      }
      localObject2 = (PhoneContact)localObject1;
      str = ((PhoneContact)localObject2).name;
      paramView = ((PhoneContact)localObject2).mobileCode;
      if (!TextUtils.isEmpty(paramView)) {
        break label258;
      }
      paramView = ((PhoneContact)localObject2).mobileNo;
    }
    label258:
    label284:
    label316:
    for (;;)
    {
      label86:
      paramInt1 = 1006;
      for (paramViewGroup.type = 11;; paramViewGroup.type = 1)
      {
        paramViewGroup.pQ = localForwardRecentItemView.xl;
        paramViewGroup.uin = paramView;
        paramViewGroup.item = localObject1;
        paramBoolean = this.jdField_b_of_type_Abel$b.F(paramView, paramInt1);
        boolean bool = aprg.V(this.app, paramView);
        localObject2 = localForwardRecentItemView.b;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ResultRecord();
        }
        ((ResultRecord)localObject1).b(paramView, str, paramInt1, "", "");
        localForwardRecentItemView.a(str, "", null, (ResultRecord)localObject1, this.bCc, paramBoolean, bool);
        a(paramViewGroup, null);
        localForwardRecentItemView.setOnClickListener(this.dm);
        if (AppSetting.enableTalkBack) {
          localForwardRecentItemView.setContentDescription(str);
        }
        return localForwardRecentItemView;
        localForwardRecentItemView = (ForwardRecentItemView)paramView;
        paramViewGroup = (abel.c)localForwardRecentItemView.getTag();
        break;
        paramInt1 = paramView.indexOf("|");
        if (paramInt1 <= -1) {
          break label316;
        }
        paramView = paramView.substring(0, paramInt1);
        break label86;
        paramView = (Friends)localObject1;
        str = aqgv.c(paramView);
        paramView = paramView.uin;
        paramInt1 = 0;
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (H(paramInt) == null) {
      return 0;
    }
    return H(paramInt).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.oW.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.oW.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131559067, paramViewGroup, false);
      paramViewGroup = new abel.a();
      paramViewGroup.Ps = ((TextView)paramView.findViewById(2131368187));
      paramViewGroup.cB = ((TextView)paramView.findViewById(2131365243));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      paramViewGroup.Ps.setText(localGroups.group_name);
      paramViewGroup.cB.setText(String.valueOf(getChildrenCount(paramInt)));
      paramViewGroup.aTO = paramInt;
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(localGroups.group_name);
      }
      return paramView;
      paramViewGroup = (abel.a)paramView.getTag();
    }
  }
  
  public int gj()
  {
    return 2131559067;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.oW == null;
  }
  
  public void j(View paramView, int paramInt)
  {
    abel.a locala = (abel.a)paramView.getTag();
    if (locala == null)
    {
      locala = new abel.a();
      locala.Ps = ((TextView)paramView.findViewById(2131368187));
      locala.cB = ((TextView)paramView.findViewById(2131365243));
      paramView.findViewById(2131369742).setVisibility(0);
      paramView.setTag(locala);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      locala.Ps.setText(localGroups.group_name);
      locala.cB.setText(String.valueOf(localGroups.group_friend_count));
      ((CheckBox)paramView.findViewById(2131369742)).setChecked(this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    abel.a locala = (abel.a)paramView.getTag();
    if (this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(locala.aTO)) {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.collapseGroup(locala.aTO);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(locala.aTO);
    }
  }
  
  public static class a
  {
    public TextView Ps;
    public int aTO;
    public TextView cB;
  }
  
  public static abstract interface b
  {
    public abstract boolean F(String paramString, int paramInt);
    
    public abstract void eK(View paramView);
  }
  
  public static class c
    extends abeg.a
  {
    public Object item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abel
 * JD-Core Version:    0.7.0.1
 */