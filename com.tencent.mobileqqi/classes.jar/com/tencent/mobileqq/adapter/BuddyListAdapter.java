package com.tencent.mobileqq.adapter;

import android.app.Dialog;
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
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.I18nPublicAccountsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.TraceUtils;
import fcd;
import fce;
import fcf;
import fcg;
import fch;
import fci;
import fcj;
import fck;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BuddyListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final fcj jdField_a_of_type_Fcj = new fcj(null);
  private static final String jdField_a_of_type_JavaLangString = "BuddyListAdapter";
  private static final int jdField_b_of_type_Int = 2;
  private static final int c = 0;
  private static final int d = 1;
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private int e;
  private int f;
  
  public BuddyListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.b = new fcf(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(13));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130838691);
    paramExpandableListView.post(new fcd(this));
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
    Object localObject1;
    Friends localFriends;
    label203:
    label216:
    Object localObject3;
    Object localObject2;
    if ((paramView == null) || ((paramView.getTag() instanceof fck)))
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903145, paramViewGroup, false);
      localObject1 = new fcg();
      ((fcg)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131230940));
      ((fcg)localObject1).d = ((TextView)paramViewGroup.findViewById(2131231395));
      ((fcg)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131231398));
      ((fcg)localObject1).e = ((TextView)paramViewGroup.findViewById(2131231396));
      ((fcg)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131231397));
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramViewGroup.setTag(localObject1);
      paramView = getChild(paramInt1, paramInt2);
      localFriends = (Friends)paramView;
      ((fcg)localObject1).jdField_a_of_type_JavaLangObject = paramView;
      ((fcg)localObject1).jdField_a_of_type_JavaLangString = localFriends.uin;
      a((FacePreloadBaseAdapter.ViewHolder)localObject1, null);
      if (!AppConstants.P.equals(localFriends.uin)) {
        break label524;
      }
      if (localFriends.status != 0) {
        break label506;
      }
      paramInt1 = 1;
      paramView = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 0) {
        break label511;
      }
      paramInt2 = 2131562533;
      localObject3 = paramView.getString(paramInt2);
      ((fcg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("[" + (String)localObject3 + "]");
      localObject2 = ((fcg)localObject1).jdField_c_of_type_AndroidWidgetImageView;
      if (paramInt1 == 0) {
        break label518;
      }
    }
    label518:
    for (paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;; paramView = null)
    {
      ((ImageView)localObject2).setImageDrawable(paramView);
      localObject2 = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getString(2131558529));
      ((fcg)localObject1).e.setText((CharSequence)localObject2);
      ((fcg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((fcg)localObject1).d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131362070));
      paramView = (View)localObject3;
      localObject3 = ContactUtils.a(localFriends);
      ((fcg)localObject1).d.setText((CharSequence)localObject3);
      ((fcg)localObject1).e.setVisibility(0);
      ((fcg)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new fce(this, localFriends));
      localObject1 = new StringBuilder((String)localObject3);
      ((StringBuilder)localObject1).append("，").append(paramView).append("，");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131559167)).append((CharSequence)localObject2);
      }
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131559168));
      paramViewGroup.setContentDescription((CharSequence)localObject1);
      return paramViewGroup;
      localObject1 = (fcg)paramView.getTag();
      ((fcg)localObject1).d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramViewGroup = paramView;
      break;
      label506:
      paramInt1 = 0;
      break label203;
      label511:
      paramInt2 = 2131562556;
      break label216;
    }
    label524:
    paramInt2 = ContactUtils.a(localFriends.status, localFriends.detalStatusFlag, localFriends.isMqqOnLine, localFriends.sqqOnLineState, localFriends.iTermType);
    paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    switch (paramInt2)
    {
    case 5: 
    case 6: 
    default: 
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131562533);
      label623:
      if ((paramInt2 == 0) || (paramInt2 == 6))
      {
        paramInt1 = 1;
        label635:
        localObject3 = ((fcg)localObject1).jdField_c_of_type_AndroidWidgetImageView;
        if (paramInt1 == 0) {
          break label851;
        }
        localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((ImageView)localObject3).setImageDrawable((Drawable)localObject2);
        ((fcg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("[" + paramView + "]");
        localObject2 = a(localFriends, (fcg)localObject1);
        ((fcg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramInt1 == 0)
        {
          paramInt1 = localFriends.netTypeIconId;
          if ((paramInt2 == 8) && ((localFriends.abilityBits & 1L) == 0L)) {
            if (localFriends.netTypeIconIdIphoneOrWphoneNoWifi == 0) {
              break label857;
            }
          }
        }
      }
      label652:
      break;
    }
    label851:
    label857:
    for (paramInt1 = localFriends.netTypeIconIdIphoneOrWphoneNoWifi;; paramInt1 = localFriends.netTypeIconId)
    {
      ((fcg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((fcg)localObject1).d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131362070));
      ((fcg)localObject1).d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131561688);
      break label623;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131561723);
      break label623;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131562556);
      break label623;
      paramInt1 = 0;
      break label635;
      localObject2 = null;
      break label652;
    }
  }
  
  private void a(List paramList)
  {
    Collections.sort(paramList, jdField_a_of_type_Fcj);
  }
  
  private boolean a()
  {
    int i = ((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9)).a();
    return (i == 1) || (i == 2);
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || ((paramView.getTag() instanceof fcg)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903321, paramViewGroup, false);
      paramViewGroup = new fck();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131230940));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232077));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131231395));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232075));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232074));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131232076));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131231396));
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
      paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131362070));
      if (PublicAccountInfo.isLooker(localPublicAccountInfo))
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.e.setVisibility(8);
        paramView.setContentDescription(paramViewGroup.d.getText());
        return paramView;
        paramViewGroup = (fck)paramView.getTag();
        paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      else
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.d.setText(localPublicAccountInfo.name);
        if (localPublicAccountInfo.certifiedGrade > 0L)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838179);
        }
        for (;;)
        {
          paramViewGroup.e.setText(localPublicAccountInfo.summary);
          a(paramViewGroup, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.b.setVisibility(8);
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
      if ((localObject != null) && ((localObject instanceof fcg)))
      {
        localObject = (fcg)localObject;
        if ((TextUtils.isEmpty(((fcg)localObject).e.getText().toString())) && ((((fcg)localObject).jdField_a_of_type_JavaLangObject instanceof Friends))) {
          a((Friends)((fcg)localObject).jdField_a_of_type_JavaLangObject, (fcg)localObject);
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
    localGroups.group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131559169);
    localGroups.group_friend_count = 1;
    localGroups.group_online_friend_count = 1;
    localGroups.seqid = 0;
    localGroups.sqqOnLine_count = 0;
    this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
    ArrayList localArrayList = new ArrayList();
    Friends localFriends = new Friends();
    localFriends.uin = AppConstants.P;
    localFriends.remark = "我的电脑";
    localFriends.name = "我的电脑";
    if (a()) {}
    for (int i = 10;; i = 0)
    {
      localFriends.status = ((byte)i);
      localFriends.groupid = -1007;
      localFriends.memberLevel = 0;
      localFriends.isMqqOnLine = false;
      localFriends.sqqOnLineState = 0;
      localArrayList.add(localFriends);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localArrayList);
      i = j;
      if (localFriends.status != 0) {
        i = 1;
      }
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
    label95:
    Groups localGroups;
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
            break label348;
          }
          localObject2 = "null";
          QLog.d("BuddyListAdapter", 2, (String)localObject2);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
      }
      localObject3 = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localGroups = (Groups)localIterator.next();
        if ((localGroups.group_id != -1003) && (localGroups.group_id != -1004))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
          if (localObject3 == null) {
            break label649;
          }
        }
      }
    }
    label261:
    label646:
    label649:
    for (localObject1 = ((ContactFacade)localObject3).a(String.valueOf(localGroups.group_id));; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        label238:
        if ((((List)localObject1).size() != 0) || (localGroups.group_id != -1006)) {
          break label368;
        }
        localObject2 = localObject1;
      }
      label348:
      label368:
      int i;
      for (;;)
      {
        if (localGroups.group_id != -1006)
        {
          localObject1 = new ArrayList();
          Object localObject4 = ((List)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              ((ArrayList)localObject1).add(new fch((Friends)((Iterator)localObject4).next(), -1));
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("BuddyListAdapter", 2, "FriendManager is null");
              }
              localObject1 = null;
              break;
              localObject2 = "empty";
              break label95;
              localObject1 = new ArrayList((Collection)localObject1);
              break label238;
              localObject2 = localObject1;
              if (((List)localObject1).size() == 0) {
                break label261;
              }
              localObject2 = localObject1;
              if (localGroups.group_id != -1006) {
                break label261;
              }
              localObject4 = (I18nPublicAccountsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
              localObject2 = localObject1;
              if (localObject4 == null) {
                break label261;
              }
              localObject2 = new ArrayList();
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject1).next();
                if (((I18nPublicAccountsManagerImp)localObject4).a(String.valueOf(localPublicAccountInfo.uin))) {
                  ((List)localObject2).add(localPublicAccountInfo);
                }
              }
              break label261;
            }
          }
          a((List)localObject1);
          ((List)localObject2).clear();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((List)localObject2).add(((fch)((Iterator)localObject1).next()).a);
          }
          localObject1 = ((List)localObject2).iterator();
          i = 0;
          label546:
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Friends)((Iterator)localObject1).next();
            int j = ContactUtils.a(((Friends)localObject4).status, ((Friends)localObject4).detalStatusFlag, ((Friends)localObject4).isMqqOnLine, ((Friends)localObject4).sqqOnLineState, ((Friends)localObject4).iTermType);
            if ((j == 0) || (j == 6)) {
              break label646;
            }
            i += 1;
          }
        }
      }
      for (;;)
      {
        break label546;
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(localGroups.group_id, i);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject2);
        break;
        return;
      }
    }
  }
  
  public int a()
  {
    return 2130903141;
  }
  
  SpannableString a(Friends paramFriends, fcg paramfcg)
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
      paramfcg.e.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
    for (;;)
    {
      paramFriends = paramFriends.a(null);
      paramfcg.e.setText(paramFriends);
      return paramFriends;
      bool = false;
      break;
      label138:
      paramfcg.e.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject = (fci)paramView.getTag();
    if (localObject == null)
    {
      localObject = new fci();
      paramView.findViewById(2131231388).setVisibility(0);
      ((fci)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231389));
      ((fci)localObject).b = ((TextView)paramView.findViewById(2131231390));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      localObject = (Groups)getGroup(paramInt);
      LocaleString.a(((Groups)localObject).group_name, paramView.jdField_a_of_type_AndroidWidgetTextView);
      if (((Groups)localObject).group_id == -1006)
      {
        paramInt = a((Groups)localObject, paramInt);
        paramView.b.setText("" + paramInt);
        return;
      }
      if (((Groups)localObject).group_id != -1007)
      {
        paramView.b.setText(String.format("%d/%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(((Groups)localObject).group_id)), Integer.valueOf(getChildrenCount(paramInt)) }));
        return;
      }
      paramView.b.setText(String.valueOf(getChildrenCount(paramInt)));
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
    int j = 0;
    Object localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(-1007);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      localObject = (Friends)((List)localObject).get(0);
    } while (!((Friends)localObject).uin.equals(AppConstants.P));
    if (paramBoolean) {}
    for (int i = 10;; i = 0)
    {
      ((Friends)localObject).status = ((byte)i);
      i = j;
      if (((Friends)localObject).status != 0) {
        i = 1;
      }
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
      paramViewGroup = (fci)paramView.getTag();
      localGroups = (Groups)getGroup(paramInt);
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      LocaleString.a(localGroups.group_name, paramViewGroup.jdField_a_of_type_AndroidWidgetTextView);
      if (localGroups.group_id == -1006) {
        break label232;
      }
      TextView localTextView = paramViewGroup.b;
      if (!this.jdField_a_of_type_Boolean) {
        break label224;
      }
      paramViewGroup = "%d / %d";
      label72:
      localTextView.setText(String.format(paramViewGroup, new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(localGroups.group_id)), Integer.valueOf(getChildrenCount(paramInt)) }));
      label115:
      if (!paramBoolean) {
        break label301;
      }
      paramView.setContentDescription(localGroups.group_name + "分组已展开，双击此处可收起分组");
    }
    for (;;)
    {
      paramView.setOnLongClickListener(this);
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903141, paramViewGroup, false);
      paramViewGroup = new fci();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231389));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131231390));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this);
      break;
      label224:
      paramViewGroup = "%d/%d";
      break label72;
      label232:
      if (localGroups.group_id == -1006)
      {
        paramInt = a(localGroups, paramInt);
        paramViewGroup.b.setText("" + paramInt);
        break label115;
      }
      paramViewGroup.b.setText(String.valueOf(getChildrenCount(paramInt)));
      break label115;
      label301:
      paramView.setContentDescription(localGroups.group_name + "分组已折叠，双击此处可展开分组");
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
    paramView = (fci)paramView.getTag();
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
    localQQCustomMenu.a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131561778));
    this.jdField_a_of_type_AndroidAppDialog = BubbleContextMenu.a(paramView, localQQCustomMenu, this.b, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131561778));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */