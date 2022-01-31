package com.tencent.mobileqq.adapter;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.MenuPopupDialog;
import com.tencent.widget.TraceUtils;
import cpw;
import cpx;
import cpy;
import cpz;
import cqa;
import cqb;
import cqc;
import cqd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BuddyListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final cqc jdField_a_of_type_Cqc = new cqc(null);
  private static final String jdField_a_of_type_JavaLangString = "BuddyListAdapter";
  private static final int jdField_b_of_type_Int = 2;
  private static final int c = 0;
  private static final int d = 1;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private MenuPopupDialog jdField_a_of_type_ComTencentWidgetMenuPopupDialog = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private int e;
  private int f;
  
  public BuddyListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.b = new cpy(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130838650);
    paramExpandableListView.post(new cpw(this));
    this.e = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.f = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id != -1006) {
      return 0;
    }
    return 1;
  }
  
  private int a(Groups paramGroups, int paramInt)
  {
    int i = getChildrenCount(paramInt);
    if ((i == 1) && (PublicAccountInfo.isLooker((PublicAccountInfo)getChild(paramInt, 0)))) {
      return 0;
    }
    return i;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject1;
    Friends localFriends;
    label203:
    label216:
    Object localObject2;
    if ((paramView == null) || ((paramView.getTag() instanceof cqd)))
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903121, paramViewGroup, false);
      localObject1 = new cpz();
      ((cpz)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296456));
      ((cpz)localObject1).d = ((TextView)localView.findViewById(2131296848));
      ((cpz)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296850));
      ((cpz)localObject1).e = ((TextView)localView.findViewById(2131296851));
      ((cpz)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296849));
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      localView.setTag(localObject1);
      paramView = getChild(paramInt1, paramInt2);
      localFriends = (Friends)paramView;
      ((cpz)localObject1).jdField_a_of_type_JavaLangObject = paramView;
      ((cpz)localObject1).jdField_a_of_type_JavaLangString = localFriends.uin;
      a((FacePreloadBaseAdapter.ViewHolder)localObject1, null);
      if (!AppConstants.T.equals(localFriends.uin)) {
        break label503;
      }
      if (localFriends.status != 0) {
        break label485;
      }
      paramInt1 = 1;
      paramView = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 0) {
        break label490;
      }
      paramInt2 = 2131364006;
      localObject2 = paramView.getString(paramInt2);
      ((cpz)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("[" + (String)localObject2 + "]");
      paramViewGroup = ((cpz)localObject1).jdField_b_of_type_AndroidWidgetImageView;
      if (paramInt1 == 0) {
        break label497;
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label276:
      paramViewGroup.setImageDrawable(paramView);
      paramViewGroup = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getString(2131361855));
      ((cpz)localObject1).e.setText(paramViewGroup);
      ((cpz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((cpz)localObject1).d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427469));
      paramView = (View)localObject2;
      label347:
      localObject2 = ContactUtils.a(localFriends);
      ((cpz)localObject1).d.setText((CharSequence)localObject2);
      ((cpz)localObject1).e.setVisibility(0);
      localObject1 = new StringBuilder((String)localObject2);
      ((StringBuilder)localObject1).append("，").append(paramView).append("，");
      if (!TextUtils.isEmpty(paramViewGroup))
      {
        if (!AppConstants.T.equals(localFriends.uin)) {
          break label1068;
        }
        ((StringBuilder)localObject1).append(paramViewGroup);
      }
    }
    for (;;)
    {
      localView.setContentDescription((CharSequence)localObject1);
      return localView;
      localObject1 = (cpz)paramView.getTag();
      ((cpz)localObject1).d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      ((cpz)localObject1).e.setCompoundDrawables(null, null, null, null);
      localView = paramView;
      break;
      label485:
      paramInt1 = 0;
      break label203;
      label490:
      paramInt2 = 2131364005;
      break label216;
      label497:
      paramView = null;
      break label276;
      label503:
      int m = ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
      paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      label612:
      label626:
      int j;
      label643:
      int i;
      switch (m)
      {
      case 5: 
      case 6: 
      default: 
        paramViewGroup = paramView.a(localFriends.getLastLoginType());
        paramView = paramViewGroup;
        if (paramViewGroup == null) {
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131364006);
        }
        if ((m == 0) || (m == 6))
        {
          paramInt2 = 1;
          localObject2 = ((cpz)localObject1).jdField_b_of_type_AndroidWidgetImageView;
          if (paramInt2 == 0) {
            break label958;
          }
          paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((ImageView)localObject2).setImageDrawable(paramViewGroup);
          ((cpz)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("[" + paramView + "]");
          paramViewGroup = a(localFriends, (cpz)localObject1);
          j = 1;
          ((cpz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramInt1 = 0;
          if (paramInt2 != 0) {
            break label977;
          }
          int k = localFriends.netTypeIconId;
          paramInt1 = k;
          i = j;
          if (m == 8)
          {
            paramInt1 = k;
            i = j;
            if ((localFriends.abilityBits & 1L) == 0L)
            {
              if (localFriends.netTypeIconIdIphoneOrWphoneNoWifi == 0) {
                break label964;
              }
              paramInt1 = localFriends.netTypeIconIdIphoneOrWphoneNoWifi;
              i = j;
            }
          }
          label771:
          if (i != 0)
          {
            paramInt1 = ContactUtils.a(paramInt1);
            ((cpz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramInt1);
          }
          localObject2 = ((cpz)localObject1).jdField_a_of_type_AndroidWidgetImageView;
          if (i == 0) {
            break label983;
          }
          paramInt1 = 0;
          label804:
          ((ImageView)localObject2).setVisibility(paramInt1);
          if ((paramInt2 != 0) || ((!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label989;
          }
          ((cpz)localObject1).d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427518));
        }
        break;
      }
      for (;;)
      {
        if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
          break label1013;
        }
        ((cpz)localObject1).d.setCompoundDrawablePadding(this.f);
        ((cpz)localObject1).d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839436, 0);
        break;
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131364003);
        break label612;
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131364004);
        break label612;
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131364005);
        break label612;
        paramInt2 = 0;
        break label626;
        label958:
        paramViewGroup = null;
        break label643;
        label964:
        paramInt1 = localFriends.netTypeIconId;
        i = j;
        break label771;
        label977:
        i = 0;
        break label771;
        label983:
        paramInt1 = 8;
        break label804;
        label989:
        ((cpz)localObject1).d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427469));
      }
      label1013:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
      {
        ((cpz)localObject1).d.setCompoundDrawablePadding(this.f);
        ((cpz)localObject1).d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839513, 0);
        break label347;
      }
      ((cpz)localObject1).d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label347;
      label1068:
      ((StringBuilder)localObject1).append("，个性签名， ").append(paramViewGroup);
    }
  }
  
  private void a(List paramList)
  {
    Collections.sort(paramList, jdField_a_of_type_Cqc);
  }
  
  private boolean a()
  {
    int i = ((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9)).a();
    return (i == 1) || (i == 2);
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || ((paramView.getTag() instanceof cpz)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903273, paramViewGroup, false);
      paramViewGroup = new cqd();
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296456));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297438));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131296848));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297436));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131297435));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297437));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131296851));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
        break label475;
      }
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    label475:
    for (;;)
    {
      Object localObject = getChild(paramInt1, paramInt2);
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(localPublicAccountInfo.uin);
      paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427469));
      if (PublicAccountInfo.isLooker(localPublicAccountInfo))
      {
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.e.setVisibility(8);
        paramView.setContentDescription(paramViewGroup.d.getText());
        return paramView;
        paramViewGroup = (cqd)paramView.getTag();
        paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      else
      {
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.d.setText(localPublicAccountInfo.name);
        if (localPublicAccountInfo.certifiedGrade > 0L)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838196);
        }
        for (;;)
        {
          paramViewGroup.e.setText(localPublicAccountInfo.summary);
          a(paramViewGroup, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  private void c()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof cpz)))
      {
        localObject = (cpz)localObject;
        if ((TextUtils.isEmpty(((cpz)localObject).e.getText().toString())) && ((((cpz)localObject).jdField_a_of_type_JavaLangObject instanceof Friends))) {
          a((Friends)((cpz)localObject).jdField_a_of_type_JavaLangObject, (cpz)localObject);
        }
      }
      i += 1;
    }
  }
  
  private void d()
  {
    int j = 0;
    Groups localGroups = new Groups();
    localGroups.group_id = -1007;
    localGroups.group_name = "我的设备";
    localGroups.group_friend_count = 1;
    localGroups.group_online_friend_count = 1;
    localGroups.seqid = 0;
    localGroups.sqqOnLine_count = 0;
    this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
    ArrayList localArrayList = new ArrayList();
    Friends localFriends = new Friends();
    localFriends.uin = AppConstants.T;
    localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131361822);
    localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131361822);
    if (a()) {}
    for (int i = 10;; i = 0)
    {
      localFriends.status = ((byte)i);
      localFriends.groupid = -1007;
      localFriends.memberLevel = 0;
      localFriends.isMqqOnLine = false;
      localFriends.sqqOnLineState = 0;
      localArrayList.add(localFriends);
      i = j;
      if (localFriends.status != 0) {
        i = 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localArrayList);
      this.jdField_a_of_type_AndroidUtilSparseIntArray.put(localGroups.group_id, i);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    d();
    Object localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((FriendManager)localObject1).a();
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
            break label386;
          }
          localObject2 = "null";
          label95:
          QLog.d("BuddyListAdapter", 2, (String)localObject2);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
      }
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      if (localObject1 == null) {
        break label569;
      }
    }
    label386:
    label560:
    label563:
    label569:
    for (localObject1 = ((FriendsManager)localObject1).c();; localObject1 = null)
    {
      localObject3 = ((List)localObject2).iterator();
      Groups localGroups;
      while (((Iterator)localObject3).hasNext())
      {
        localGroups = (Groups)((Iterator)localObject3).next();
        if ((localGroups.group_id != -1003) && (localGroups.group_id != -1004) && (localGroups.group_id != -1006))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
          if (localObject1 == null) {
            break label563;
          }
        }
      }
      for (localObject2 = (List)((ConcurrentHashMap)localObject1).get(String.valueOf(localGroups.group_id));; localObject2 = null)
      {
        if (localObject2 == null) {}
        Object localObject5;
        for (localObject2 = new ArrayList();; localObject2 = new ArrayList((Collection)localObject2))
        {
          if ((((List)localObject2).size() == 0) && (localGroups.group_id == -1006)) {
            ((List)localObject2).add(PublicAccountInfo.createLooker(this.jdField_a_of_type_AndroidContentContext));
          }
          if (localGroups.group_id == -1006) {
            break label462;
          }
          localObject4 = new ArrayList();
          localObject5 = ((List)localObject2).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((ArrayList)localObject4).add(new cqa((Friends)((Iterator)localObject5).next(), -1));
          }
          if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "FriendManager is null");
          }
          localObject1 = null;
          break;
          localObject2 = "empty";
          break label95;
        }
        a((List)localObject4);
        ((List)localObject2).clear();
        Object localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((List)localObject2).add(((cqa)((Iterator)localObject4).next()).a);
        }
        label462:
        localObject4 = ((List)localObject2).iterator();
        int i = 0;
        label473:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Friends)((Iterator)localObject4).next();
          int j = ContactUtils.a(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
          if ((j == 0) || (j == 6)) {
            break label560;
          }
          i += 1;
        }
        for (;;)
        {
          break label473;
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(localGroups.group_id, i);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject2);
          break;
          return;
        }
      }
    }
  }
  
  public int a()
  {
    return 2130903119;
  }
  
  SpannableString a(Friends paramFriends, cpz paramcpz)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) {
      return null;
    }
    boolean bool;
    if (this.jdField_a_of_type_Int != 0)
    {
      bool = true;
      paramFriends = paramFriends.getRichStatus(bool);
      if (TextUtils.isEmpty(paramFriends.c)) {
        break label138;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramFriends.b, 200);
      localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
      int i = this.e;
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
      paramcpz.e.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
    for (;;)
    {
      paramFriends = paramFriends.a(null);
      paramcpz.e.setText(paramFriends);
      return paramFriends;
      bool = false;
      break;
      label138:
      paramcpz.e.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject = (cqb)paramView.getTag();
    if (localObject == null)
    {
      localObject = new cqb();
      paramView.findViewById(2131296844).setVisibility(0);
      ((cqb)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296845));
      ((cqb)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296846));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      localObject = (Groups)getGroup(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject).group_name);
      if (((Groups)localObject).group_id == -1006)
      {
        paramInt = a((Groups)localObject, paramInt);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText("" + paramInt);
        return;
      }
      if (((Groups)localObject).group_id != -1007)
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%d/%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(((Groups)localObject).group_id)), Integer.valueOf(getChildrenCount(paramInt)) }));
        return;
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(getChildrenCount(paramInt)));
      return;
    }
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.a(paramAbsListView, paramInt);
    if (paramInt == 0) {
      c();
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(-1007);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    localObject = ((List)localObject).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext())
    {
      Friends localFriends = (Friends)((Iterator)localObject).next();
      if (localFriends.uin.equals(AppConstants.T))
      {
        if (paramBoolean)
        {
          j = 10;
          label88:
          localFriends.status = ((byte)j);
        }
      }
      else
      {
        if (localFriends.status == 0) {
          break label127;
        }
        i += 1;
      }
    }
    label127:
    for (;;)
    {
      break;
      j = 0;
      break label88;
      this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-1007, i);
      return;
    }
  }
  
  public void b()
  {
    super.notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id)).get(paramInt2);
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
          QLog.i("BuddyListAdapter", 2, Log.getStackTraceString(localThrowable));
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
    return a(paramInt1, paramInt2);
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.a("getChildView");
    if (a(paramInt1, paramInt2) == 0) {}
    for (paramView = a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);; paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup))
    {
      TraceUtils.a();
      return paramView;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).group_id)).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return ((Groups)getGroup(paramInt)).group_id;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Groups localGroups;
    if (paramView != null)
    {
      paramViewGroup = (cqb)paramView.getTag();
      localGroups = (Groups)getGroup(paramInt);
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
      if (localGroups.group_id == -1006) {
        break label211;
      }
      TextView localTextView = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
      if (!this.jdField_a_of_type_Boolean) {
        break label203;
      }
      paramViewGroup = "%d / %d";
      label72:
      localTextView.setText(String.format(paramViewGroup, new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(localGroups.group_id)), Integer.valueOf(getChildrenCount(paramInt)) }));
      label115:
      if (!paramBoolean) {
        break label280;
      }
      paramView.setContentDescription("");
    }
    for (;;)
    {
      paramView.setOnLongClickListener(this);
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903119, paramViewGroup, false);
      paramViewGroup = new cqb();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296845));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296846));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this);
      break;
      label203:
      paramViewGroup = "%d/%d";
      break label72;
      label211:
      if (localGroups.group_id == -1006)
      {
        paramInt = a(localGroups, paramInt);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("" + paramInt);
        break label115;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(getChildrenCount(paramInt)));
      break label115;
      label280:
      paramView.setContentDescription("");
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    e();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (cqb)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.e(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.d(paramView.jdField_a_of_type_Int);
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramView.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public boolean onLongClick(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363793);
    localQQCustomMenu.a(0, str);
    this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, str, localQQCustomMenu, this.b, new cpx(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */