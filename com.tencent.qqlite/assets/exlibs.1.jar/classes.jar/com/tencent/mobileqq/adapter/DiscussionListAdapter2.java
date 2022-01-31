package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.DiscussionView;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import cpd;
import cpe;
import cpf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DiscussionListAdapter2
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cpe(this);
  public DiscussionView a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int d = 0;
  
  public DiscussionListAdapter2(Context paramContext, DiscussionView paramDiscussionView, ListView paramListView, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    if (paramBoolean) {
      b();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDiscussionView = paramDiscussionView;
    paramListView.setOnScrollListener(this);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
      if ((localObject == null) || (!(localObject instanceof cpf))) {
        break label169;
      }
      localObject = (cpf)localObject;
      if ((paramString == null) && (!TextUtils.isEmpty(((cpf)localObject).jdField_a_of_type_JavaLangString)))
      {
        paramBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(101, ((cpf)localObject).jdField_a_of_type_JavaLangString);
        if (paramBitmap != null) {
          ((cpf)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        }
      }
    }
    label169:
    for (;;)
    {
      i += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(((cpf)localObject).jdField_a_of_type_JavaLangString, 101, true);
      continue;
      if (TextUtils.equals(paramString, ((cpf)localObject).jdField_a_of_type_JavaLangString))
      {
        ((cpf)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
    }
  }
  
  private void b()
  {
    Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    localObject = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilList = ((ContactFacade)localObject).a("-1004");
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    ChnToSpell.a(this.jdField_a_of_type_AndroidContentContext);
    localObject = new HashMap();
    String str1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362952);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362954);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
      long l = 0L;
      String str3 = ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, localDiscussionInfo);
      String str4 = ChnToSpell.a(str3, 1);
      if ((str3.matches(str1)) || (str3.contains(str2))) {
        l = 65536L;
      }
      if ((str4 == null) || (str4.length() == 0)) {
        l |= 0xFFFF;
      }
      for (;;)
      {
        ((HashMap)localObject).put(localDiscussionInfo.uin, Long.valueOf(l));
        break;
        if (StringUtil.c(str4.charAt(0))) {
          l |= str4.charAt(0);
        } else if (Character.isDigit(str4.charAt(0))) {
          l |= 0xFFFE;
        } else {
          l |= 0xFFFF;
        }
      }
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new cpd(this, (HashMap)localObject));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.d == 0)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.d = paramInt;
    if (paramInt == 0)
    {
      a(null, null);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof DiscussionInfo)) {
      return Long.parseLong(((DiscussionInfo)localObject).uin);
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItem(paramInt) instanceof Integer)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (getItemViewType(paramInt) == 1)
    {
      String str;
      Object localObject2;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903176, paramViewGroup, false);
        paramViewGroup = new cpf(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296453));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296847));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131296850));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramViewGroup.b.setVisibility(0);
        paramView.setTag(paramViewGroup);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = (DiscussionInfo)getItem(paramInt);
        str = ((DiscussionInfo)localObject1).uin;
        localObject2 = ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramViewGroup.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(((FriendManager)localObject2).c(str)) }));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(101, str);
        if (localObject2 != null) {
          break label274;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(ImageUtil.d());
      }
      for (;;)
      {
        if (this.d == 0) {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 101, false);
        }
        paramViewGroup.jdField_a_of_type_JavaLangString = str;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject1);
        localObject1 = paramView;
        return localObject1;
        paramViewGroup = (cpf)paramView.getTag();
        break;
        label274:
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentWidgetListView.getResources(), (Bitmap)localObject2));
      }
    }
    if (paramView == null)
    {
      paramView = new cpf(null);
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903175, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131297008));
      ((View)localObject1).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = "";
      localObject1 = paramView;
      if (paramInt == 0) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("全部讨论组");
      return paramView;
      paramViewGroup = (cpf)paramView.getTag();
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void notifyDataSetChanged()
  {
    b();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.DiscussionListAdapter2
 * JD-Core Version:    0.7.0.1
 */