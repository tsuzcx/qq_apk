import QQService.EVIPSPEC;
import Wallet.PfaFriend;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberBuddyListAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aayg
  extends abdt
  implements ajdo.a, View.OnClickListener, View.OnLongClickListener, zzn.a
{
  private static final aayg.c jdField_a_of_type_Aayg$c = new aayg.c(null);
  aayg.f jdField_a_of_type_Aayg$f = null;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  protected SelectMemberActivity a;
  private ExpandableListView jdField_a_of_type_ComTencentWidgetExpandableListView;
  private final int aTM;
  private final int aTN;
  private boolean anu = true;
  private final boolean anv;
  private final SparseArray<ArrayList<Entity>> ap = new SparseArray();
  private aozi b;
  private boolean bBg;
  private final View.OnClickListener cp = new aayi(this);
  private final QQAppInterface e;
  private final ArrayList<Groups> lj = new ArrayList();
  private final Context mContext;
  private final View.OnClickListener mOnClickListener;
  private AbsListView.e mOnScrollListener;
  ArrayList<Entity> st;
  
  public aayg(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = ((SelectMemberActivity)paramContext);
    this.mContext = paramContext;
    this.e = paramQQAppInterface;
    this.mOnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.anu = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView != null) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.post(new SelectMemberBuddyListAdapter.1(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAK) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this);
    }
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
    if (((Groups)this.lj.get(paramInt1)).group_id == 1008) {
      return 2;
    }
    return 0;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131560607, paramViewGroup, false);
      paramViewGroup = new aayg.e();
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.rc = ((TextView)paramView.findViewById(2131372190));
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131364587));
      paramViewGroup.lo = paramView.findViewById(2131380904);
      if (this.mOnClickListener != null) {
        paramView.setOnClickListener(this.mOnClickListener);
      }
      paramView.findViewById(2131380761).setVisibility(8);
      paramView.setTag(paramViewGroup);
      localObject1 = getChild(paramInt1, paramInt2);
      paramViewGroup.item = localObject1;
      paramViewGroup.groupId = getGroupId(paramInt1);
      if (!(localObject1 instanceof TroopMemberInfo)) {
        break label431;
      }
      localObject2 = (TroopMemberInfo)localObject1;
      if (this.jdField_a_of_type_Aayg$f == null) {
        this.jdField_a_of_type_Aayg$f = new aayg.f(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.e);
      }
      paramViewGroup.uin = ((TroopMemberInfo)localObject2).memberuin;
      localObject1 = aqgv.h(this.e, ((TroopMemberInfo)localObject2).troopuin, ((TroopMemberInfo)localObject2).memberuin);
      a(paramViewGroup, this.jdField_a_of_type_Aayg$f.a((TroopMemberInfo)localObject2));
      label234:
      if (paramViewGroup.lo != null)
      {
        if (!aprg.V(this.e, paramViewGroup.uin)) {
          break label465;
        }
        paramViewGroup.lo.setVisibility(0);
      }
      label266:
      paramViewGroup.pQ.setImageDrawable(null);
      paramViewGroup.rc.setText((CharSequence)localObject1);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.iX(paramViewGroup.uin)) {
        break label478;
      }
      paramViewGroup.checkBox.setChecked(true);
      label309:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.so == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.so.contains(paramViewGroup.uin))) {
        break label490;
      }
      paramViewGroup.checkBox.setEnabled(false);
    }
    for (;;)
    {
      if ((AppSetting.enableTalkBack) && (paramViewGroup.checkBox.isEnabled()))
      {
        if (!paramViewGroup.checkBox.isChecked()) {
          break label502;
        }
        paramView.setContentDescription((String)localObject1 + acfp.m(2131714225));
      }
      return paramView;
      paramViewGroup = (aayg.e)paramView.getTag();
      paramViewGroup.rc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label431:
      localObject2 = (Friends)localObject1;
      localObject1 = aqgv.c((Friends)localObject2);
      paramViewGroup.uin = ((Friends)localObject2).uin;
      a(paramViewGroup, null);
      break label234;
      label465:
      paramViewGroup.lo.setVisibility(8);
      break label266;
      label478:
      paramViewGroup.checkBox.setChecked(false);
      break label309;
      label490:
      paramViewGroup.checkBox.setEnabled(true);
    }
    label502:
    paramView.setContentDescription((String)localObject1 + acfp.m(2131714206));
    return paramView;
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
              if ((((RecentUser)localObject4).getType() == 0) && (Long.parseLong(((RecentUser)localObject4).uin) >= 10000L) && (!((RecentUser)localObject4).uin.equals(localObject2)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr.contains(((RecentUser)localObject4).uin)) && (!aqft.rj(((RecentUser)localObject4).uin)) && ((!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bBc) || (!aprg.V(this.e, ((RecentUser)localObject4).uin))))
              {
                localObject4 = ((acff)this.e.getManager(51)).b(((RecentUser)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (!asgx.ag(this.e, ((Friends)localObject4).uin))) {
                  ((ArrayList)localObject1).add(localObject4);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.mContext.getString(2131718631);
          ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.lj.add(localObject2);
          this.ap.put(((Groups)localObject2).group_id, localObject1);
        }
      }
    }
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    PhoneContact localPhoneContact;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131560607, paramViewGroup, false);
      paramViewGroup = new aayg.e();
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.rc = ((TextView)paramView.findViewById(2131372190));
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131364587));
      paramViewGroup.lo = paramView.findViewById(2131380904);
      if (this.mOnClickListener != null) {
        paramView.setOnClickListener(this.mOnClickListener);
      }
      paramView.setTag(paramViewGroup);
      Object localObject = getChild(paramInt1, paramInt2);
      localPhoneContact = (PhoneContact)localObject;
      paramViewGroup.item = localObject;
      paramViewGroup.uin = localPhoneContact.mobileCode;
      a(paramViewGroup, null);
      if (paramViewGroup.lo != null) {
        paramViewGroup.lo.setVisibility(8);
      }
      paramViewGroup.pQ.setImageDrawable(null);
      paramViewGroup.rc.setText(localPhoneContact.name);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.iX(paramViewGroup.uin)) {
        break label353;
      }
      paramViewGroup.checkBox.setChecked(true);
      label214:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.so == null) || ("0".equals(localPhoneContact.uin)) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.so.contains(localPhoneContact.uin))) {
        break label365;
      }
      paramViewGroup.checkBox.setEnabled(false);
    }
    for (;;)
    {
      if ((AppSetting.enableTalkBack) && (paramViewGroup.checkBox.isEnabled()))
      {
        if (!paramViewGroup.checkBox.isChecked()) {
          break label377;
        }
        paramView.setContentDescription(localPhoneContact.name + acfp.m(2131714219));
      }
      return paramView;
      paramViewGroup = (aayg.e)paramView.getTag();
      paramViewGroup.rc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label353:
      paramViewGroup.checkBox.setChecked(false);
      break label214;
      label365:
      paramViewGroup.checkBox.setEnabled(true);
    }
    label377:
    paramView.setContentDescription(localPhoneContact.name + acfp.m(2131714230));
    return paramView;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || ((paramView.getTag() instanceof aayg.e)))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131559826, paramViewGroup, false);
      paramViewGroup = new aayg.d();
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.jH = ((ImageView)paramView.findViewById(2131367209));
      paramViewGroup.rc = ((TextView)paramView.findViewById(2131379402));
      paramViewGroup.fe = ((TextView)paramView.findViewById(2131373774));
      paramViewGroup.rb = ((TextView)paramView.findViewById(2131373757));
      paramViewGroup.ra = ((TextView)paramView.findViewById(2131373784));
      paramViewGroup.rd = ((TextView)paramView.findViewById(2131379404));
      paramView.setTag(paramViewGroup);
      if (this.mOnClickListener == null) {
        break label483;
      }
      paramView.setOnClickListener(this.mOnClickListener);
    }
    label483:
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
        paramViewGroup = (aayg.d)paramView.getTag();
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
  
  private void cAk()
  {
    boolean bool = true;
    if (!this.bBg) {
      this.bBg = true;
    }
    for (;;)
    {
      Object localObject2 = zzn.a(this, bool, 0, 0);
      Object localObject3 = ((HashMap)localObject2).get(zzn.bbQ);
      Object localObject1 = null;
      if (localObject3 != null) {
        localObject1 = (ArrayList)localObject3;
      }
      localObject2 = ((HashMap)localObject2).get(zzn.bbR);
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.ss = ((ArrayList)localObject2);
      }
      if (localObject1 != null)
      {
        localObject3 = this.e.getCurrentAccountUin();
        localObject2 = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject4 = (PfaFriend)((Iterator)localObject1).next();
          if (localObject4 != null) {
            try
            {
              if ((((PfaFriend)localObject4).uin != null) && (!((PfaFriend)localObject4).uin.equals(localObject3)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr.contains(((PfaFriend)localObject4).uin)))
              {
                localObject4 = ((acff)this.e.getManager(51)).b(((PfaFriend)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (!asgx.ag(this.e, ((Friends)localObject4).uin))) {
                  ((ArrayList)localObject2).add(localObject4);
                }
              }
            }
            catch (Exception localException) {}
          }
        }
        if (!((ArrayList)localObject2).isEmpty())
        {
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = 1003;
          ((Groups)localObject1).group_name = this.mContext.getString(2131693998);
          ((Groups)localObject1).group_friend_count = ((ArrayList)localObject2).size();
          ((Groups)localObject1).seqid = 0;
          this.lj.add(localObject1);
          this.ap.put(((Groups)localObject1).group_id, localObject2);
        }
      }
      return;
      bool = false;
    }
  }
  
  private void cAl()
  {
    if (this.st == null) {
      this.st = new ArrayList();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mIntent.getStringExtra("group_name");
    Groups localGroups = new Groups();
    localGroups.group_id = 1006;
    localGroups.group_name = str;
    localGroups.group_friend_count = this.st.size();
    localGroups.seqid = 0;
    this.lj.add(localGroups);
    this.ap.put(localGroups.group_id, this.st);
    if (QLog.isDevelopLevel()) {
      QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "addCurGroup, mGroupmembers[" + this.st.size() + "]");
    }
  }
  
  private void cAm()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAK) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.xy();
        } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.Ur()) && (i != 8));
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.cT();
      } while (localObject == null);
      localArrayList = new ArrayList();
      localArrayList.addAll((Collection)localObject);
    } while (localArrayList.isEmpty());
    Object localObject = new Groups();
    ((Groups)localObject).group_id = 1002;
    ((Groups)localObject).group_name = this.mContext.getString(2131696819);
    ((Groups)localObject).group_friend_count = 1;
    ((Groups)localObject).seqid = 0;
    this.lj.add(localObject);
    this.ap.put(((Groups)localObject).group_id, localArrayList);
  }
  
  private void cO(List<aayg.a> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Aayg$c);
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
    this.jdField_b_of_type_Aozi.a(this.lj, this.ap);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mType == 1)) {
      cAl();
    }
    acff localacff;
    Object localObject2;
    Object localObject1;
    label104:
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 33)
    {
      cAk();
      cAm();
      localacff = (acff)this.e.getManager(51);
      localObject2 = null;
      if (localacff == null) {
        break label313;
      }
      localObject1 = localacff.co();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label677;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("group list is ");
        if (localObject1 != null) {
          break label338;
        }
        localObject2 = "null";
        label147:
        QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, (String)localObject2);
      }
      if (localObject1 != null) {
        break label677;
      }
      localObject1 = new ArrayList();
    }
    label674:
    label677:
    for (;;)
    {
      localObject3 = ((List)localObject1).iterator();
      Groups localGroups;
      Object localObject4;
      Object localObject5;
      label313:
      label338:
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
            ((ArrayList)localObject4).add(new aayg.a((Friends)((Iterator)localObject5).next(), -1));
          }
          aQT();
          break;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break label104;
          }
          QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "FriendManager is null");
          localObject1 = localObject2;
          break label104;
          localObject2 = "empty";
          break label147;
        }
        cO((List)localObject4);
        ((List)localObject2).clear();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((List)localObject2).add(((aayg.a)((Iterator)localObject4).next()).a);
        }
        localObject4 = ((List)localObject2).iterator();
        i = 0;
        label425:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Friends)((Iterator)localObject4).next();
          int j = aqgv.aU(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
          if ((j == 0) || (j == 6)) {
            break label674;
          }
          i += 1;
        }
      }
      for (;;)
      {
        break label425;
        localObject4 = new ArrayList();
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject5 = (Friends)((List)localObject2).get(i);
          if ((!((Friends)localObject5).uin.equals(this.e.getCurrentAccountUin())) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr.contains(((Friends)localObject5).uin)) && (!aqft.rj(((Friends)localObject5).uin)) && (!asgx.ag(this.e, ((Friends)localObject5).uin)) && ((!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bBc) || (!aprg.V(this.e, ((Friends)localObject5).uin)))) {
            ((ArrayList)localObject4).add(((List)localObject2).get(i));
          }
          i += 1;
        }
        this.ap.put(localGroups.group_id, localObject4);
        break;
        if ((this.jdField_a_of_type_ComTencentWidgetExpandableListView != null) && (!((List)localObject1).isEmpty()) && (this.anu)) {
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
  
  public Groups a(long paramLong)
  {
    int i = 0;
    while (i < this.lj.size())
    {
      Groups localGroups = (Groups)this.lj.get(i);
      if (localGroups.group_id == paramLong) {
        return localGroups;
      }
      i += 1;
    }
    return null;
  }
  
  public void a(aozi paramaozi)
  {
    this.jdField_b_of_type_Aozi = paramaozi;
  }
  
  public void cnv()
  {
    super.notifyDataSetChanged();
  }
  
  public void destroy()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAK) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 33) {
      zzn.bA(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app);
    }
    if (this.jdField_a_of_type_Aayg$f != null)
    {
      this.jdField_a_of_type_Aayg$f.destroy();
      this.jdField_a_of_type_Aayg$f = null;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = null;
    super.destroy();
  }
  
  public void dr(ArrayList<Entity> paramArrayList)
  {
    this.st = paramArrayList;
  }
  
  public void eH(long paramLong) {}
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    int i = ((Groups)this.lj.get(paramInt1)).group_id;
    ArrayList localArrayList = (ArrayList)this.ap.get(i);
    if ((paramInt2 < localArrayList.size()) && (paramInt2 >= 0)) {
      return localArrayList.get(paramInt2);
    }
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 1, "getChild error,members.size = " + localArrayList.size() + ",childPositon = " + paramInt2 + "，groupPosition = " + paramInt1);
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    long l1 = 0L;
    if ((localObject instanceof Friends)) {
      localObject = (Friends)localObject;
    }
    do
    {
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
              QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(localThrowable1));
            }
            l1 = 0L;
          }
        }
        if ((localThrowable1 instanceof PublicAccountInfo)) {
          return ((PublicAccountInfo)localThrowable1).uin;
        }
        if (!(localThrowable1 instanceof TroopMemberInfo)) {
          break;
        }
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localThrowable1;
        try
        {
          long l2 = Long.parseLong(localTroopMemberInfo.memberuin);
          return l2;
        }
        catch (Throwable localThrowable2) {}
      } while (!QLog.isColorLevel());
      QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(localThrowable2));
      return 0L;
    } while (!(localThrowable2 instanceof RelationTroopEntity));
    RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)localThrowable2;
    return this.jdField_b_of_type_Aozi.b(localRelationTroopEntity.troopInfo.troopuin).longValue();
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
      if (R(paramInt1, paramInt2) == 1)
      {
        paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      }
      else if (R(paramInt1, paramInt2) == 2)
      {
        RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)getChild(paramInt1, paramInt2);
        paramView = this.jdField_b_of_type_Aozi.b(paramInt1, paramInt2, paramView, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.mOnClickListener, localRelationTroopEntity);
      }
      else
      {
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
    return ((ArrayList)this.ap.get(((Groups)this.lj.get(paramInt)).group_id)).size();
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
      localObject = (aayg.b)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (Groups)getGroup(paramInt);
      paramView.aTO = paramInt;
      paramView.qZ.setText(((Groups)localObject).group_name);
      if (AppSetting.enableTalkBack)
      {
        if (!paramBoolean) {
          break label153;
        }
        paramViewGroup.setContentDescription(((Groups)localObject).group_name + acfp.m(2131714221));
      }
    }
    for (;;)
    {
      paramViewGroup.setOnLongClickListener(this);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560606, paramViewGroup, false);
      paramView = new aayg.b();
      paramView.qZ = ((TextView)paramViewGroup.findViewById(2131368187));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
      break;
      label153:
      paramViewGroup.setContentDescription(((Groups)localObject).group_name + acfp.m(2131714214));
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
    aayg.b localb = (aayg.b)paramView.getTag();
    if (localb == null)
    {
      localb = new aayg.b();
      paramView.findViewById(2131369742).setVisibility(0);
      localb.qZ = ((TextView)paramView.findViewById(2131368187));
      paramView.setTag(localb);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      localb.qZ.setText(localGroups.group_name);
      if (this.jdField_a_of_type_ComTencentWidgetExpandableListView != null) {
        ((CheckBox)paramView.findViewById(2131369742)).setChecked(this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
      }
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
    Object localObject = (aayg.b)paramView.getTag();
    if (this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(((aayg.b)localObject).aTO)) {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.collapseGroup(((aayg.b)localObject).aTO);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      try
      {
        this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(((aayg.b)localObject).aTO);
        localObject = (Groups)getGroup(((aayg.b)localObject).aTO);
        if (((Groups)localObject).group_id == 1003)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bGG == 0) {
            anot.a(this.e, "CliOper", "", "", "0X8005442", "0X8005442", 1, 0, "", "", "", "");
          } else {
            anot.a(this.e, "CliOper", "", "", "0X8005442", "0X8005442", 2, 0, "", "", "", "");
          }
        }
        else if (((Groups)localObject).group_id == 1002)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bGG == 0) {
            anot.a(this.e, "CliOper", "", "", "0X8005444", "0X8005444", 1, 0, "", "", "", "");
          } else {
            anot.a(this.e, "CliOper", "", "", "0X8005444", "0X8005444", 2, 0, "", "", "", "");
          }
        }
        else if (((Groups)localObject).group_id == 0)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bGG == 0) {
            anot.a(this.e, "CliOper", "", "", "0X8005443", "0X8005443", 1, 0, "", "", "", "");
          } else {
            anot.a(this.e, "CliOper", "", "", "0X8005443", "0X8005443", 2, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bGG == 0) {
          anot.a(this.e, "CliOper", "", "", "0X8005445", "0X8005445", 1, 0, "", "", "", "");
        } else {
          anot.a(this.e, "CliOper", "", "", "0X8005445", "0X8005445", 2, 0, "", "", "", "");
        }
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    aqoa localaqoa = new aqoa();
    localaqoa.dV(0, this.mContext.getResources().getString(2131694542));
    aqgq.a(paramView, localaqoa, this.cp, new aayh(this));
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
  
  public void xh(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.isFinishing())) {
      return;
    }
    notifyDataSetChanged();
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
    implements Comparator<aayg.a>
  {
    public int a(aayg.a parama)
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
    
    public int a(aayg.a parama1, aayg.a parama2)
    {
      return a(parama1) - a(parama2);
    }
  }
  
  static class d
    extends aayg.g
  {
    public TextView fe;
    public ImageView jH;
    public TextView ra;
    public TextView rb;
  }
  
  public static class e
    extends aayg.g
  {
    public long groupId;
    public View lo;
  }
  
  class f
    implements aqdf.a
  {
    protected aqdf a;
    boolean mDisable = true;
    
    public f(Context paramContext, AppInterface paramAppInterface)
    {
      this.a = new aqdf(paramContext, paramAppInterface);
      this.a.a(this);
    }
    
    private Bitmap a(String paramString, int paramInt1, byte paramByte, int paramInt2)
    {
      Object localObject;
      if (this.a == null) {
        localObject = null;
      }
      Bitmap localBitmap;
      do
      {
        return localObject;
        localBitmap = this.a.b(paramInt1, paramString, paramInt2);
        localObject = localBitmap;
      } while (localBitmap != null);
      QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "requestDecodeFace, uin[" + paramString + "]");
      this.a.a(paramString, paramInt1, true, paramByte);
      return aqhu.G();
    }
    
    public Bitmap a(TroopMemberInfo paramTroopMemberInfo)
    {
      return a(paramTroopMemberInfo.memberuin, 1, (byte)0, 0);
    }
    
    public void destroy()
    {
      try
      {
        if (this.a != null)
        {
          this.a.destory();
          this.a = null;
        }
        this.mDisable = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.a = null;
        }
      }
    }
    
    public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
    {
      QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "onDecodeTaskCompleted, uin[" + paramString + "]");
      if (this.mDisable) {
        return;
      }
      aayg.a(aayg.this, paramString, paramBitmap);
    }
  }
  
  public static class g
    extends abeg.a
  {
    public CheckBox checkBox;
    public Object item;
    public TextView rc;
    public TextView rd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayg
 * JD-Core Version:    0.7.0.1
 */