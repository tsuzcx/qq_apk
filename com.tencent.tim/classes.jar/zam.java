import QQService.EVIPSPEC;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.1;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class zam
  extends abgc
  implements View.OnClickListener, View.OnLongClickListener, SwipPinnedHeaderExpandableListView.c, yzr.a
{
  private static final zam.d jdField_a_of_type_Zam$d = new zam.d(null);
  private SparseIntArray M = new SparseIntArray();
  private final amhj jdField_a_of_type_Amhj;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private SimpleTextView jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
  private OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private zam.b jdField_a_of_type_Zam$b = new zam.b(this);
  private zam.c jdField_a_of_type_Zam$c = new zam.c(this);
  private final int aTM;
  private final boolean anv;
  private SparseArray<List<yzr>> ap = new SparseArray();
  private SimpleTextView b;
  public int bKH;
  private boolean bpL = true;
  private boolean bqm = true;
  private int cct = -1;
  private final View.OnClickListener cp = new zao(this);
  private final QQAppInterface e;
  private final acff h;
  private ArrayList<Object> lj = new ArrayList();
  final BaseActivity mContext;
  private final View.OnClickListener mOnClickListener;
  private AbsListView.e mOnScrollListener;
  private int mScrollState = 0;
  
  public zam(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SwipPinnedHeaderExpandableListView paramSwipPinnedHeaderExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseActivity, paramQQAppInterface, paramSwipPinnedHeaderExpandableListView);
    this.mContext = paramBaseActivity;
    this.e = paramQQAppInterface;
    this.jdField_a_of_type_Amhj = ((amhj)paramQQAppInterface.getManager(15));
    this.h = ((acff)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(167));
    this.mOnClickListener = paramOnClickListener;
    this.aTM = ((int)aqho.convertDpToPixel(this.mContext, 12.0F));
    notifyDataSetChanged();
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {}
    for (boolean bool = true;; bool = false)
    {
      this.anv = bool;
      return;
    }
  }
  
  private void a(ArrayList<Object> paramArrayList, SparseArray<List<yzr>> paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    Groups localGroups1 = new Groups();
    localGroups1.group_id = 1004;
    localGroups1.group_name = this.mContext.getString(2131717467);
    localGroups1.group_friend_count = 1;
    localGroups1.seqid = 0;
    paramArrayList.add(localGroups1);
    ArrayList localArrayList1 = new ArrayList();
    acff localacff = (acff)this.e.getManager(51);
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (localacff != null)
    {
      localObject1 = localacff.cp();
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((List)localObject1).size() != 0) {}
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("group list is ");
          if (localObject1 != null) {
            break label433;
          }
          localObject2 = "null";
          label136:
          QLog.d("BuddyListAdapter", 2, (String)localObject2);
        }
        if (localObject1 != null) {
          break label691;
        }
        localObject1 = new ArrayList();
      }
    }
    label281:
    label433:
    label691:
    for (;;)
    {
      paramArrayList.remove(localGroups1);
      localObject2 = localObject1;
      Iterator localIterator1 = ((List)localObject2).iterator();
      int i = 0;
      Groups localGroups2;
      label250:
      ArrayList localArrayList2;
      int j;
      Friends localFriends;
      int k;
      Object localObject4;
      if (localIterator1.hasNext())
      {
        localGroups2 = (Groups)localIterator1.next();
        paramArrayList.add(localGroups2);
        localObject1 = localacff.B(String.valueOf(localGroups2.group_id));
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          localArrayList2 = new ArrayList(((List)localObject1).size());
          Iterator localIterator2 = ((List)localObject1).iterator();
          localObject2 = null;
          j = 0;
          if (!localIterator2.hasNext()) {
            break label550;
          }
          localObject3 = (Entity)localIterator2.next();
          localFriends = (Friends)localObject3;
          k = aqgv.aU(localFriends.detalStatusFlag, localFriends.iTermType);
          localObject4 = this.h.a(localFriends.uin);
          if ((localObject4 == null) || (((SpecialCareInfo)localObject4).globalSwitch == 0)) {
            break label688;
          }
          localArrayList1.add(yzq.a(4, (Entity)localObject3, this.e, this.mContext));
          if ((k == 0) || (k == 6)) {
            break label688;
          }
          i += 1;
        }
      }
      for (;;)
      {
        if (((Friends)localObject3).gathtertype == 1)
        {
          break label281;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("BuddyListAdapter", 2, "FriendManager is null");
          localObject1 = localObject2;
          break;
          localObject2 = "empty";
          break label136;
          localObject1 = new ArrayList((Collection)localObject1);
          break label250;
        }
        if ((k != 0) && (k != 6)) {
          j += 1;
        }
        for (;;)
        {
          for (;;)
          {
            localObject3 = yzq.a(0, (Entity)localObject3, this.e, this.mContext);
            ((yzr)localObject3).a(this);
            try
            {
              localObject4 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              boolean bool = localFriends.uin.equals(localObject4);
              if (bool) {
                localObject2 = localObject3;
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              localArrayList2.add(localObject3);
            }
          }
          break label281;
          cO(localArrayList2);
          if (localObject2 != null) {
            localArrayList2.add(0, localObject2);
          }
          paramSparseIntArray.put(localGroups2.group_id, j);
          paramSparseArray.put(localGroups2.group_id, localArrayList2);
          if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "groupId: " + localGroups2.group_id + " num: " + ((List)localObject1).size());
          }
          break;
          cO(localArrayList1);
          paramSparseIntArray.put(1004, i);
          paramSparseArray.put(1004, localArrayList1);
          localGroups1.group_friend_count = localArrayList1.size();
          return;
        }
      }
    }
  }
  
  private void a(zam.a parama, Groups paramGroups, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (parama == null) {
      return;
    }
    if (!parama.C.isChecked()) {
      parama.C.setChecked(true);
    }
    Object localObject2 = parama.H;
    Object localObject1 = localObject2;
    int i;
    if (AppSetting.enableTalkBack)
    {
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder(24);
        ((StringBuilder)localObject1).append(paramGroups.group_name + " 分组");
      }
    }
    else
    {
      parama.aTO = paramInt1;
      parama.n.setText(paramGroups.group_name);
      parama.o.setVisibility(8);
      parama.k.setVisibility(8);
      parama.C.setVisibility(0);
      i = this.M.get(paramGroups.group_id);
      paramInt1 = getChildrenCount(paramInt1);
      if (paramGroups.group_id != 1005) {
        break label367;
      }
      parama.c.setText(paramInt1 + "");
      if (AppSetting.enableTalkBack) {
        ((StringBuilder)localObject1).append("共" + paramInt1 + "个常用群聊");
      }
      if (paramInt2 != 0) {
        break label539;
      }
      if (!this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(parama.aTO)) {
        break label474;
      }
      paramInt1 = 2;
    }
    for (;;)
    {
      label241:
      localObject2 = parama.C;
      boolean bool;
      if (paramInt1 == 2)
      {
        bool = true;
        label255:
        ((CheckBox)localObject2).setChecked(bool);
        if (AppSetting.enableTalkBack)
        {
          if (!parama.C.isChecked()) {
            break label485;
          }
          ((StringBuilder)localObject1).append(" 已展开");
        }
      }
      for (;;)
      {
        parama.c.setContentDescription(((StringBuilder)localObject1).toString());
        aqcl.Q(parama.C, false);
        if ((paramGroups.group_id != 1002) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.xy() != this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.xy())) {
          break label506;
        }
        if (!paramBoolean) {
          break label497;
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = parama.c;
        return;
        ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
        localObject1 = localObject2;
        break;
        label367:
        SimpleTextView localSimpleTextView = parama.c;
        if (this.anv) {}
        for (localObject2 = "%d / %d";; localObject2 = "%d/%d")
        {
          localSimpleTextView.setText(String.format((String)localObject2, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) }));
          if (!AppSetting.enableTalkBack) {
            break;
          }
          ((StringBuilder)localObject1).append("在线" + i + "人，共" + paramInt1 + "人");
          break;
        }
        label474:
        paramInt1 = 1;
        break label241;
        bool = false;
        break label255;
        label485:
        ((StringBuilder)localObject1).append(" 已折叠");
      }
      label497:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = parama.c;
      return;
      label506:
      if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView == parama.c) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView != parama.c) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = null;
      return;
      label539:
      paramInt1 = paramInt2;
    }
  }
  
  private void cO(List<yzr> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Zam$d);
      return;
    }
    catch (Exception paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BuddyListAdapter", 2, "", paramList);
    }
  }
  
  private void cmY()
  {
    int j = this.jdField_b_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_b_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof zap.a)))
      {
        localObject = (zap.a)localObject;
        if ((TextUtils.isEmpty(((zap.a)localObject).m.getText().toString())) && ((((zap.a)localObject).item instanceof Friends))) {
          a((Friends)((zap.a)localObject).item, (zap.a)localObject);
        }
      }
      i += 1;
    }
  }
  
  private void cnw()
  {
    int k = 0;
    Object localObject = this.e.getApp().getSharedPreferences(this.e.getAccount(), 0).getString("700_sp_key_last_expanded", "700_sp_key_last_expanded");
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "readExpand=" + (String)localObject);
    }
    HashSet localHashSet = new HashSet();
    int i;
    if (((String)localObject).equalsIgnoreCase("700_sp_key_last_expanded"))
    {
      i = 0;
      if (i < this.lj.size())
      {
        if (getGroupType(i) == 0)
        {
          localObject = (Groups)this.lj.get(i);
          if (((Groups)localObject).group_friend_count > 0) {
            localHashSet.add(Integer.valueOf(((Groups)localObject).group_id));
          }
        }
      }
      else
      {
        i = k;
        if (localHashSet.size() == 0)
        {
          this.bqm = true;
          i = k;
        }
      }
    }
    int m;
    int j;
    for (;;)
    {
      if (i < this.lj.size())
      {
        if ((getGroupType(i) == 0) && (localHashSet.contains(Integer.valueOf(((Groups)this.lj.get(i)).group_id)))) {
          this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
        }
        i += 1;
        continue;
        i += 1;
        break;
        i = k;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("_");
          m = localObject.length;
          j = 0;
        }
      }
    }
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      String str = localObject[j];
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str)));
        label289:
        j += 1;
        continue;
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label289;
      }
    }
  }
  
  private void cnx()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = getGroupCount();
    if (j <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BuddyListAdapter", 2, "no data. don't save group");
      }
      return;
    }
    int i = 0;
    while (i < j)
    {
      if (getGroupType(i) == 0)
      {
        Groups localGroups = (Groups)getGroup(i);
        if (this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i))
        {
          localStringBuffer.append(localGroups.group_id);
          localStringBuffer.append("_");
        }
      }
      i += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
    }
    this.e.getApp().getSharedPreferences(this.e.getAccount(), 0).edit().putString("700_sp_key_last_expanded", localStringBuffer.toString()).commit();
  }
  
  public boolean O(View paramView)
  {
    if (!this.bpL) {
      return false;
    }
    if ((paramView.getTag() instanceof zap.a))
    {
      paramView = (zap.a)paramView.getTag();
      if ((paramView.item instanceof Friends))
      {
        paramView = (Friends)paramView.item;
        if ((paramView.uin.equals(this.e.getCurrentAccountUin())) || (aqft.rj(paramView.uin))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean Pw()
  {
    return true;
  }
  
  String a(Friends paramFriends, zap.a parama)
  {
    return "";
  }
  
  public void al(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.EO(paramBoolean);
      return;
    }
  }
  
  public void cnv()
  {
    super.notifyDataSetChanged();
  }
  
  public void d(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.bKH = i;
      return;
    }
  }
  
  public void destroy()
  {
    cnx();
    ajoo.du(this.e);
    super.destroy();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      Groups localGroups = (Groups)this.lj.get(paramInt1);
      return ((List)this.ap.get(localGroups.group_id)).get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    long l2 = 0L;
    if ((localObject instanceof Friends)) {
      localObject = (Friends)localObject;
    }
    do
    {
      long l1;
      do
      {
        try
        {
          l1 = Long.parseLong(((Friends)localObject).uin);
          return l1;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable1));
            }
            l1 = 0L;
          }
        }
        if ((localThrowable1 instanceof PublicAccountInfo)) {
          return ((PublicAccountInfo)localThrowable1).uin;
        }
        l1 = l2;
      } while (!(localThrowable1 instanceof PhoneContact));
      PhoneContact localPhoneContact = (PhoneContact)localThrowable1;
      try
      {
        l1 = Long.parseLong(localPhoneContact.mobileNo);
        return l1;
      }
      catch (Throwable localThrowable2)
      {
        l1 = l2;
      }
    } while (!QLog.isColorLevel());
    QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable2));
    return 0L;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      if (((Groups)this.lj.get(paramInt1)).group_id == 1002) {
        return 1;
      }
      return 0;
    }
    return 99;
  }
  
  public int getChildTypeCount()
  {
    return 6;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    auvk.traceBegin("getChildView");
    yzr localyzr = (yzr)getChild(paramInt1, paramInt2);
    if (localyzr == null) {}
    for (paramView = null;; paramView = localyzr.a(paramInt1, paramInt2, paramView, paramViewGroup, this.mOnClickListener))
    {
      if (paramView != null)
      {
        a((yzr.b)paramView.getTag(), null);
        if (this.mOnClickListener != null) {
          paramView.setOnClickListener(this.mOnClickListener);
        }
        paramView.setOnLongClickListener(this.jdField_a_of_type_Zam$c);
      }
      auvk.traceEnd();
      return paramView;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (getGroupType(paramInt) == 1) {
      return 0;
    }
    paramInt = ((Groups)this.lj.get(paramInt)).group_id;
    List localList = (List)this.ap.get(paramInt);
    if (localList == null) {}
    for (paramInt = 0;; paramInt = localList.size()) {
      return paramInt;
    }
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
    if (getGroupType(paramInt) == 0) {
      return ((Groups)getGroup(paramInt)).group_id;
    }
    return 1000L;
  }
  
  public int getGroupType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.lj.size())) {
      QLog.e("BuddyListAdapter", 1, "getGroupType illegal, groupPosition =" + paramInt + ", size=" + this.lj.size());
    }
    while ((this.lj.get(paramInt) instanceof String)) {
      return 1;
    }
    return 0;
  }
  
  public int getGroupTypeCount()
  {
    return 2;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    if (getGroupType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(2131559065, paramViewGroup, false);
        paramViewGroup = (SingleLineTextView)paramView.findViewById(2131380662);
        paramViewGroup.setDefaultTextColor(-8355712);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = (String)getGroup(paramInt);
        paramViewGroup.setText("");
        return paramView;
        paramViewGroup = (SingleLineTextView)paramView.getTag();
      }
    }
    Object localObject = (Groups)getGroup(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131559068, paramViewGroup, false);
      paramViewGroup = new zam.a();
      paramViewGroup.n = ((SingleLineTextView)paramView.findViewById(2131368187));
      paramViewGroup.C = ((CheckBox)paramView.findViewById(2131369742));
      paramViewGroup.c = ((SimpleTextView)paramView.findViewById(2131365243));
      paramViewGroup.c.setDefaultTextColor(1711276032);
      paramViewGroup.k = ((ProgressBar)paramView.findViewById(2131369847));
      paramViewGroup.o = ((SingleLineTextView)paramView.findViewById(2131380888));
      paramView.setTag(paramViewGroup);
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.e, false)) {
        break label294;
      }
      paramViewGroup.c.setTextColor(-5196865);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.jdField_a_of_type_Zam$b);
      paramView.setOnLongClickListener(this.jdField_a_of_type_Zam$c);
      if (paramBoolean) {
        i = 2;
      }
      a(paramViewGroup, (Groups)localObject, paramInt, false, i);
      return paramView;
      paramViewGroup = (zam.a)paramView.getTag();
      break;
      label294:
      ColorStateList localColorStateList = this.mContext.getResources().getColorStateList(2131167383);
      paramViewGroup.c.setTextColor(localColorStateList);
    }
  }
  
  public int gj()
  {
    return 2131559068;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void hi() {}
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void j(View paramView, int paramInt)
  {
    Groups localGroups = (Groups)getGroup(paramInt);
    if (!(paramView.getTag() instanceof zam.a))
    {
      localObject = new zam.a();
      ((zam.a)localObject).C = ((CheckBox)paramView.findViewById(2131369742));
      ((zam.a)localObject).n = ((SingleLineTextView)paramView.findViewById(2131368187));
      ((zam.a)localObject).n.setDefaultTextColor(-8355712);
      ((zam.a)localObject).o = ((SingleLineTextView)paramView.findViewById(2131380888));
      ((zam.a)localObject).c = ((SimpleTextView)paramView.findViewById(2131365243));
      ((zam.a)localObject).c.setDefaultTextColor(1711276032);
      ((zam.a)localObject).k = ((ProgressBar)paramView.findViewById(2131369847));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (zam.a)paramView.getTag())
    {
      a(paramView, localGroups, paramInt, true, 0);
      paramView.n.setTypeface(Typeface.SANS_SERIF);
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.e, false)) {
        break;
      }
      paramView.c.setTextColor(-5196865);
      return;
    }
    Object localObject = this.mContext.getResources().getColorStateList(2131167383);
    paramView.c.setTextColor((ColorStateList)localObject);
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged");
    }
    ThreadManager.postImmediately(new BuddyListAdapter.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    zam.a locala = (zam.a)paramView.getTag();
    if (this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(locala.aTO)) {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.collapseGroup(locala.aTO);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(locala.aTO);
      ((alsb)this.e.getManager(91)).updateQzoneFeeds();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    if (this.bpL)
    {
      localObject1 = paramView.getTag();
      if (localObject1 != null) {
        if ((localObject1 instanceof zam.a))
        {
          localObject1 = new aqoa();
          ((aqoa)localObject1).dV(0, this.mContext.getResources().getString(2131694542));
          aqgq.a(paramView, (aqoa)localObject1, this.cp, null);
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      return bool1;
      if (!(localObject1 instanceof yzr.b)) {
        break;
      }
      Object localObject2 = ((yzr.b)localObject1).item;
      if ((localObject2 == null) || (!(localObject2 instanceof Friends))) {
        break;
      }
      paramView = (ausj)auss.a(this.mContext, null);
      localObject1 = (acff)this.e.getManager(51);
      localObject2 = (Friends)localObject2;
      localObject1 = ((acff)localObject1).a(((Friends)localObject2).uin);
      if (!this.e.getCurrentUin().equals(((Friends)localObject2).uin))
      {
        bool1 = bool2;
        if (localObject1 != null)
        {
          if (((SpecialCareInfo)localObject1).globalSwitch == 0) {
            bool1 = bool2;
          }
        }
        else {
          label188:
          if (!bool1) {
            break label240;
          }
        }
        label240:
        for (int i = 2131692012;; i = 2131692013)
        {
          for (;;)
          {
            paramView.addButton(i);
            paramView.addCancelButton(2131721058);
            paramView.a(new zan(this, bool1, (Friends)localObject2, paramView));
            try
            {
              paramView.show();
            }
            catch (Exception paramView) {}
          }
          break;
          bool1 = true;
          break label188;
        }
        bool1 = false;
      }
    }
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
    this.mScrollState = paramInt;
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      cmY();
      txn.a().stopMonitorScene("list_g_contacts", false);
    }
    for (;;)
    {
      if (this.mOnScrollListener != null) {
        this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
      }
      if (paramInt != 0) {
        ApngImage.pauseByTag(3);
      }
      if (paramInt == 0) {
        ApngImage.playByTag(3);
      }
      return;
      txn.a().startMonitorScene("list_g_contacts");
    }
  }
  
  public void pause()
  {
    cnx();
    ajoo.du(this.e);
  }
  
  public void setChildViewCanAction(boolean paramBoolean)
  {
    this.bpL = paramBoolean;
  }
  
  public static class a
  {
    public CheckBox C;
    public StringBuilder H;
    public int aTO;
    public SimpleTextView c;
    public ProgressBar k;
    public SingleLineTextView n;
    public SingleLineTextView o;
  }
  
  static class b
    implements View.OnClickListener
  {
    private WeakReference<zam> mRef;
    
    public b(zam paramzam)
    {
      this.mRef = new WeakReference(paramzam);
    }
    
    public void onClick(View paramView)
    {
      zam localzam = (zam)this.mRef.get();
      if (localzam != null) {
        localzam.onClick(paramView);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  static class c
    implements View.OnLongClickListener
  {
    private WeakReference<zam> mRef;
    
    public c(zam paramzam)
    {
      this.mRef = new WeakReference(paramzam);
    }
    
    public boolean onLongClick(View paramView)
    {
      zam localzam = (zam)this.mRef.get();
      if (localzam != null) {
        return localzam.onLongClick(paramView);
      }
      return false;
    }
  }
  
  static class d
    implements Comparator<yzr>
  {
    public int a(Friends paramFriends)
    {
      int i = 16384;
      int k = aqgv.aU(paramFriends.detalStatusFlag, paramFriends.iTermType);
      int j;
      if ((k != 6) && (k != 0))
      {
        j = 65536;
        label32:
        if (!anlm.ayn()) {
          break label100;
        }
      }
      for (;;)
      {
        switch (k)
        {
        case 5: 
        case 6: 
        default: 
          return j | i | (int)paramFriends.getLastLoginType();
          j = 131072;
          break label32;
          label100:
          if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            i = 4096;
          } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
            i = 8192;
          } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
            i = 12288;
          }
          break;
        }
      }
      return j | i | 0x1;
      return j | i | 0x2;
      return j | i | 0x3;
    }
    
    public int a(yzr paramyzr1, yzr paramyzr2)
    {
      paramyzr1 = (Friends)paramyzr1.c;
      paramyzr2 = (Friends)paramyzr2.c;
      int i = a(paramyzr1);
      int j = a(paramyzr2);
      if (i == j) {
        return acdb.a(paramyzr1.mComparePartInt, paramyzr1.mCompareSpell, paramyzr2.mComparePartInt, paramyzr2.mCompareSpell);
      }
      return i - j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zam
 * JD-Core Version:    0.7.0.1
 */