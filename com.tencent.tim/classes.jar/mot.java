import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.SelectMemberBuddyListAdapter.2;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class mot
  extends abdt
  implements ajdo.a, View.OnClickListener, View.OnLongClickListener, mmf.a<ObservableArrayList<ResultRecord>>
{
  private static final mot.c jdField_a_of_type_Mot$c = new mot.c(null);
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private ExpandableListView jdField_a_of_type_ComTencentWidgetExpandableListView;
  private final int aTM;
  private final int aTN;
  private boolean anu = true;
  private final boolean anv;
  private final SparseArray<List<Entity>> ap = new SparseArray();
  protected ObservableArrayList<ResultRecord> b;
  private View.OnClickListener clickListener;
  private final View.OnClickListener cp = new mow(this);
  private final QQAppInterface e;
  private final ArrayList<Groups> lj = new ArrayList();
  protected final Context mContext;
  private final View.OnClickListener mOnClickListener = new mou(this);
  private AbsListView.e mOnScrollListener;
  
  public mot(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.mContext = paramContext;
    this.e = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.anu = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    paramExpandableListView.post(new SelectMemberBuddyListAdapter.2(this));
    this.aTM = ((int)aqho.convertDpToPixel(this.mContext, 12.0F));
    this.aTN = ((int)aqho.convertDpToPixel(this.mContext, 9.0F));
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.anv = paramBoolean;
      return;
    }
  }
  
  private int R(int paramInt1, int paramInt2)
  {
    if (((Groups)this.lj.get(paramInt1)).group_id == 1002) {
      return 1;
    }
    return 0;
  }
  
  private void aQT()
  {
    Object localObject1 = this.e.a().a();
    if (localObject1 != null)
    {
      Object localObject3 = ((acxw)localObject1).q(true);
      if (localObject3 != null)
      {
        Object localObject2 = this.e.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (RecentUser)((Iterator)localObject3).next();
          if (localObject4 != null) {
            try
            {
              if ((((RecentUser)localObject4).getType() == 0) && (Long.parseLong(((RecentUser)localObject4).uin) >= 10000L) && (!((RecentUser)localObject4).uin.equals(localObject2)) && (!aqft.rj(((RecentUser)localObject4).uin)))
              {
                localObject4 = ((acff)this.e.getManager(51)).b(((RecentUser)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (!asgx.ag(this.e, ((Friends)localObject4).uin))) {
                  ((List)localObject1).add(localObject4);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        if (!((List)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.mContext.getString(2131718631);
          ((Groups)localObject2).group_friend_count = ((List)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.lj.add(localObject2);
          this.ap.put(((Groups)localObject2).group_id, localObject1);
        }
      }
    }
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131560607, paramViewGroup, false);
      paramViewGroup = new mot.e();
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.rc = ((TextView)paramView.findViewById(2131372190));
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131364587));
      paramViewGroup.lo = paramView.findViewById(2131380904);
      if (this.mOnClickListener != null) {
        paramView.setOnClickListener(this.mOnClickListener);
      }
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = getChild(paramInt1, paramInt2);
      PhoneContact localPhoneContact = (PhoneContact)localObject;
      paramViewGroup.item = localObject;
      paramViewGroup.uin = localPhoneContact.mobileCode;
      a(paramViewGroup, null);
      if (paramViewGroup.lo != null) {
        paramViewGroup.lo.setVisibility(8);
      }
      paramViewGroup.pQ.setImageDrawable(null);
      paramViewGroup.rc.setText(localPhoneContact.name);
      if ((AppSetting.enableTalkBack) && (paramViewGroup.checkBox.isEnabled()) && (paramViewGroup.checkBox.isChecked())) {}
      return paramView;
      paramViewGroup = (mot.e)paramView.getTag();
      paramViewGroup.rc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || ((paramView.getTag() instanceof mot.e)))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131559826, paramViewGroup, false);
      paramViewGroup = new mot.d();
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.jH = ((ImageView)paramView.findViewById(2131367209));
      paramViewGroup.rc = ((TextView)paramView.findViewById(2131379402));
      paramViewGroup.fe = ((TextView)paramView.findViewById(2131373774));
      paramViewGroup.rb = ((TextView)paramView.findViewById(2131373757));
      paramViewGroup.ra = ((TextView)paramView.findViewById(2131373784));
      paramViewGroup.rd = ((TextView)paramView.findViewById(2131379404));
      paramView.setTag(paramViewGroup);
      if (this.mOnClickListener == null) {
        break label484;
      }
      paramView.setOnClickListener(this.mOnClickListener);
    }
    label484:
    for (;;)
    {
      Object localObject = getChild(paramInt1, paramInt2);
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localObject;
      paramViewGroup.item = localObject;
      paramViewGroup.uin = Long.toString(localPublicAccountInfo.uin);
      paramViewGroup.rc.setTextColor(this.mContext.getResources().getColorStateList(2131167304));
      if (PublicAccountInfo.isLooker(localPublicAccountInfo))
      {
        paramViewGroup.rb.setVisibility(0);
        paramViewGroup.rc.setVisibility(8);
        paramViewGroup.jH.setVisibility(8);
        paramViewGroup.pQ.setImageDrawable(null);
        paramViewGroup.fe.setVisibility(8);
        paramViewGroup.ra.setVisibility(8);
        paramViewGroup.rd.setVisibility(8);
        if (AppSetting.enableTalkBack) {
          paramView.setContentDescription(paramViewGroup.rc.getText());
        }
        return paramView;
        paramViewGroup = (mot.d)paramView.getTag();
        paramViewGroup.rc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      else
      {
        paramViewGroup.rb.setVisibility(8);
        paramViewGroup.rc.setVisibility(0);
        paramViewGroup.rd.setVisibility(0);
        paramViewGroup.rc.setText(localPublicAccountInfo.name);
        if (localPublicAccountInfo.certifiedGrade > 0L)
        {
          paramViewGroup.jH.setVisibility(0);
          paramViewGroup.jH.setBackgroundResource(2130842599);
        }
        for (;;)
        {
          paramViewGroup.rd.setText(localPublicAccountInfo.summary);
          a(paramViewGroup, null);
          paramViewGroup.fe.setVisibility(8);
          paramViewGroup.ra.setVisibility(8);
          break;
          paramViewGroup.jH.setVisibility(8);
        }
      }
    }
  }
  
  private void cO(List<mot.a> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Mot$c);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "", paramList);
    }
  }
  
  private void ie()
  {
    this.lj.clear();
    this.ap.clear();
    aQT();
    acff localacff = (acff)this.e.getManager(51);
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (localacff != null)
    {
      localObject1 = localacff.co();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label562;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("group list is ");
        if (localObject1 != null) {
          break label273;
        }
        localObject2 = "null";
        label89:
        QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, (String)localObject2);
      }
      if (localObject1 != null) {
        break label562;
      }
      localObject1 = new ArrayList();
    }
    label273:
    label559:
    label562:
    for (;;)
    {
      localObject3 = ((List)localObject1).iterator();
      Groups localGroups;
      Object localObject4;
      Object localObject5;
      int i;
      if (((Iterator)localObject3).hasNext())
      {
        localGroups = (Groups)((Iterator)localObject3).next();
        this.lj.add(localGroups);
        localObject2 = localacff.B(String.valueOf(localGroups.group_id));
        if (localObject2 == null) {}
        for (localObject2 = new ArrayList();; localObject2 = new ArrayList((Collection)localObject2))
        {
          localObject4 = new ArrayList();
          localObject5 = ((List)localObject2).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((ArrayList)localObject4).add(new mot.a((Friends)((Iterator)localObject5).next(), -1));
          }
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "FriendManager is null");
          localObject1 = localObject2;
          break;
          localObject2 = "empty";
          break label89;
        }
        cO((List)localObject4);
        ((List)localObject2).clear();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((List)localObject2).add(((mot.a)((Iterator)localObject4).next()).a);
        }
        localObject4 = ((List)localObject2).iterator();
        i = 0;
        label360:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Friends)((Iterator)localObject4).next();
          int j = aqgv.aU(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
          if ((j == 0) || (j == 6)) {
            break label559;
          }
          i += 1;
        }
      }
      for (;;)
      {
        break label360;
        localObject4 = new ArrayList();
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject5 = (Friends)((List)localObject2).get(i);
          if ((!((Friends)localObject5).uin.equals(this.e.getCurrentAccountUin())) && (!aqft.rj(((Friends)localObject5).uin)) && (!asgx.ag(this.e, ((Friends)localObject5).uin))) {
            ((ArrayList)localObject4).add(((List)localObject2).get(i));
          }
          i += 1;
        }
        this.ap.put(localGroups.group_id, localObject4);
        break;
        if ((!((List)localObject1).isEmpty()) && (this.anu)) {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
        }
        return;
      }
    }
  }
  
  public void T(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "onRecommendCountChanged count=" + paramInt);
    }
    notifyDataSetChanged();
  }
  
  protected View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    Friends localFriends;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131560607, paramViewGroup, false);
      paramViewGroup = new mot.e();
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.rc = ((TextView)paramView.findViewById(2131372190));
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131364587));
      paramViewGroup.lo = paramView.findViewById(2131380904);
      if (this.mOnClickListener != null) {
        paramView.setOnClickListener(this.mOnClickListener);
      }
      paramView.findViewById(2131380761).setVisibility(8);
      paramView.setTag(paramViewGroup);
      localObject = getChild(paramInt1, paramInt2);
      localFriends = (Friends)localObject;
      paramViewGroup.item = localObject;
      paramViewGroup.uin = localFriends.uin;
      a(paramViewGroup, null);
      if (paramViewGroup.lo != null)
      {
        if (!aprg.V(this.e, paramViewGroup.uin)) {
          break label318;
        }
        paramViewGroup.lo.setVisibility(0);
      }
    }
    for (;;)
    {
      paramViewGroup.pQ.setImageDrawable(null);
      localObject = aqgv.c(localFriends);
      paramViewGroup.rc.setText((CharSequence)localObject);
      paramViewGroup.checkBox.setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(ResultRecord.a(localFriends.uin, localFriends.name)));
      a(paramViewGroup, localFriends);
      if ((AppSetting.enableTalkBack) && (paramViewGroup.checkBox.isEnabled()) && (paramViewGroup.checkBox.isChecked())) {}
      return paramView;
      paramViewGroup = (mot.e)paramView.getTag();
      paramViewGroup.rc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label318:
      paramViewGroup.lo.setVisibility(8);
    }
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    if (paramObservableArrayList != null)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = paramObservableArrayList;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
    }
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(mot.e parame, Friends paramFriends) {}
  
  protected void aQM() {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    notifyDataSetChanged();
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    notifyDataSetChanged();
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void eH(long paramLong) {}
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((List)this.ap.get(((Groups)this.lj.get(paramInt1)).group_id)).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    if ((localObject instanceof Friends))
    {
      localObject = (Friends)localObject;
      try
      {
        l = Long.parseLong(((Friends)localObject).uin);
        return l;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(localThrowable));
        }
      }
    }
    while (!(localThrowable instanceof PublicAccountInfo))
    {
      long l;
      return 0L;
    }
    return ((PublicAccountInfo)localThrowable).uin;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    return R(paramInt1, paramInt2);
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    auvk.traceBegin("getChildView");
    if (R(paramInt1, paramInt2) == 0) {
      paramView = a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    }
    for (;;)
    {
      auvk.traceEnd();
      return paramView;
      if (R(paramInt1, paramInt2) == 1) {
        paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      } else {
        paramView = c(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    Groups localGroups = (Groups)this.lj.get(paramInt);
    if ((localGroups == null) || (this.ap.get(localGroups.group_id) == null)) {
      return 0;
    }
    return ((List)this.ap.get(((Groups)this.lj.get(paramInt)).group_id)).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.lj.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.lj.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return ((Groups)getGroup(paramInt)).group_id;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (mot.b)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = (Groups)getGroup(paramInt);
      paramView.aTO = paramInt;
      paramView.qZ.setText(((Groups)localObject).group_name);
      if ((AppSetting.enableTalkBack) && (paramBoolean)) {}
      paramViewGroup.setOnLongClickListener(this);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560606, paramViewGroup, false);
      paramView = new mot.b();
      paramView.qZ = ((TextView)paramViewGroup.findViewById(2131368187));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
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
  
  public void j(View paramView, int paramInt)
  {
    mot.b localb = (mot.b)paramView.getTag();
    if (localb == null)
    {
      localb = new mot.b();
      paramView.findViewById(2131369742).setVisibility(0);
      localb.qZ = ((TextView)paramView.findViewById(2131368187));
      paramView.setTag(localb);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      localb.qZ.setText(localGroups.group_name);
      ((CheckBox)paramView.findViewById(2131369742)).setChecked(this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
      return;
    }
  }
  
  public void notifyDataSetChanged()
  {
    ie();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    mot.b localb = (mot.b)paramView.getTag();
    if (this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(localb.aTO)) {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.collapseGroup(localb.aTO);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(localb.aTO);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    aqoa localaqoa = new aqoa();
    localaqoa.dV(0, this.mContext.getResources().getString(2131694542));
    aqgq.a(paramView, localaqoa, this.cp, new mov(this));
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void sc(int paramInt)
  {
    notifyDataSetChanged();
  }
  
  public void sd(int paramInt) {}
  
  public void se(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "onUpdateContactList, " + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.clickListener = paramOnClickListener;
  }
  
  static class a
  {
    public Friends a;
    public int priority;
    
    public a(Friends paramFriends, int paramInt)
    {
      this.a = paramFriends;
      this.priority = paramInt;
    }
  }
  
  static class b
  {
    public int aTO;
    public TextView qZ;
  }
  
  static class c
    implements Comparator<mot.a>
  {
    public int a(mot.a parama)
    {
      if (parama.priority != -1) {
        return parama.priority;
      }
      Friends localFriends = parama.a;
      int k = aqgv.aU(localFriends.detalStatusFlag, localFriends.iTermType);
      int j;
      int i;
      if ((k != 6) && (k != 0))
      {
        j = 65536;
        if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
          break label132;
        }
        i = 4096;
        switch (k)
        {
        case 5: 
        case 6: 
        default: 
          label64:
          i = j | i | (int)localFriends.getLastLoginType();
        }
      }
      for (;;)
      {
        parama.priority = i;
        return i;
        j = 131072;
        break;
        label132:
        if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
        {
          i = 8192;
          break label64;
        }
        if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ))
        {
          i = 12288;
          break label64;
        }
        i = 16384;
        break label64;
        i = j | i | 0x1;
        continue;
        i = j | i | 0x2;
        continue;
        i = j | i | 0x3;
      }
    }
    
    public int a(mot.a parama1, mot.a parama2)
    {
      return a(parama1) - a(parama2);
    }
  }
  
  static class d
    extends mot.f
  {
    public TextView fe;
    public ImageView jH;
    public TextView ra;
    public TextView rb;
  }
  
  static class e
    extends mot.f
  {}
  
  public static class f
    extends abeg.a
  {
    public CheckBox checkBox;
    public Object item;
    public View lo;
    public TextView rc;
    public TextView rd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mot
 * JD-Core Version:    0.7.0.1
 */