package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import exi;
import exj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class AllBuddyListAdapter
  extends FacePreloadBaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#";
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Comparator jdField_a_of_type_JavaUtilComparator = new exi(this);
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private char[] jdField_a_of_type_ArrayOfChar = null;
  private int[] jdField_a_of_type_ArrayOfInt = null;
  private int b;
  private int c;
  
  public AllBuddyListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    ChnToSpell.a(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(13));
    this.b = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.c = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    c();
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    Friends localFriends;
    label135:
    String str;
    label158:
    Object localObject1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903145, paramViewGroup, false);
      paramViewGroup = new BuddyListAdapter.ViewTag();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131230940));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131231395));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131231396));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localFriends = (Friends)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangObject = localFriends;
      if (localFriends.groupid == -1007) {
        break label404;
      }
      paramViewGroup.jdField_a_of_type_JavaLangString = localFriends.uin;
      paramViewGroup.c.setImageBitmap(a(1, localFriends.uin));
      str = ContactUtils.a(localFriends);
      paramViewGroup.d.setText(str);
      if (this.jdField_a_of_type_Int == 0) {
        break label417;
      }
      localObject1 = localFriends.getRichStatus(bool);
      if (TextUtils.isEmpty(((RichStatus)localObject1).c)) {
        break label423;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject1).b, 200);
      localObject2 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2);
      paramInt = this.b;
      ((Drawable)localObject2).setBounds(0, 0, Math.round(((Drawable)localObject2).getIntrinsicWidth() * 1.0F / ((Drawable)localObject2).getIntrinsicHeight() * paramInt), paramInt);
      paramViewGroup.e.setCompoundDrawables((Drawable)localObject2, null, null, null);
    }
    for (;;)
    {
      localObject1 = ((RichStatus)localObject1).a(null);
      paramViewGroup.e.setText((CharSequence)localObject1);
      paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131362080));
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramViewGroup.c.setOnClickListener(new exj(this, localFriends));
      paramViewGroup = new StringBuilder(str);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext.getString(2131559165)).append((CharSequence)localObject1);
      }
      paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext.getString(2131559166));
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramViewGroup = (BuddyListAdapter.ViewTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label404:
      paramViewGroup.c.setImageResource(2130838590);
      break label135;
      label417:
      bool = false;
      break label158;
      label423:
      paramViewGroup.e.setCompoundDrawables(null, null, null, null);
    }
  }
  
  private void c()
  {
    Object localObject1 = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Object localObject2 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b();
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      ((ArrayList)localObject1).addAll((Collection)localObject2);
    }
    Collections.sort((List)localObject1, this.jdField_a_of_type_JavaUtilComparator);
    localObject1 = ((ArrayList)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Entity)((Iterator)localObject1).next();
      String str = ChnToSpell.a(ContactUtils.a((Friends)localObject2).trim(), 2);
      if (str.length() > 0)
      {
        c1 = str.charAt(0);
        label128:
        if (StringUtil.c(c1)) {
          break label222;
        }
      }
      label222:
      for (char c1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#".charAt("ABCDEFGHIJKLMNOPQRSTUVWXYZ#".length() - 1);; c1 = Character.toUpperCase(c1))
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(c1)) == null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Character.valueOf(c1), new ArrayList());
        }
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(c1))).add(localObject2);
        break;
        c1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#".charAt("ABCDEFGHIJKLMNOPQRSTUVWXYZ#".length() - 1);
        break label128;
      }
    }
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet();
    this.jdField_a_of_type_ArrayOfInt = new int[((Set)localObject1).size() + 1];
    this.jdField_a_of_type_ArrayOfChar = new char[((Set)localObject1).size()];
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    this.jdField_a_of_type_ArrayOfInt[0] = 0;
    int i = 1;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfInt;
      int j = localObject2[i];
      int k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
      localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + j);
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      this.jdField_a_of_type_ArrayOfChar[i] = ((Character)((Iterator)localObject1).next()).charValue();
      i += 1;
    }
  }
  
  public int a(char paramChar)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfChar.length) {
      if (paramChar != this.jdField_a_of_type_ArrayOfChar[i]) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      i = -1;
    }
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = ((Friends)getItem(paramInt)).uin;
    return localFaceInfo;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int k = this.b;
      int i = 0;
      if (i < j)
      {
        BuddyListAdapter.ViewTag localViewTag = (BuddyListAdapter.ViewTag)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
        Object localObject1;
        if ((localViewTag != null) && (localViewTag.jdField_a_of_type_JavaLangString != null) && (localViewTag.jdField_a_of_type_JavaLangString.length() > 0))
        {
          localObject1 = ((Friends)localViewTag.jdField_a_of_type_JavaLangObject).getRichStatus(false);
          if (TextUtils.isEmpty(((RichStatus)localObject1).c)) {
            break label201;
          }
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject1).b, 200);
          localObject2 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2);
          ((Drawable)localObject2).setBounds(0, 0, Math.round(((Drawable)localObject2).getIntrinsicWidth() * 1.0F / ((Drawable)localObject2).getIntrinsicHeight() * k), k);
          localViewTag.e.setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
        for (;;)
        {
          localObject1 = ((RichStatus)localObject1).a(null);
          localViewTag.e.setText((CharSequence)localObject1);
          i += 1;
          break;
          label201:
          localViewTag.e.setCompoundDrawables(null, null, null, null);
        }
      }
    }
    super.a(paramAbsListView, paramInt);
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
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      return this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return (Entity)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(this.jdField_a_of_type_ArrayOfChar[i]))).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i]);
    }
    i = -(i + 1) - 1;
    return (Entity)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(this.jdField_a_of_type_ArrayOfChar[i]))).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i]);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void notifyDataSetChanged()
  {
    c();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AllBuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */