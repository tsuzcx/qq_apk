package com.tencent.mobileqq.search;

import android.content.Context;
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
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.activity.recent.RecentItemBuilderFactory;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter.ViewTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import gmp;
import gmq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConversationSearchAdapter
  extends BaseAdapter
  implements SearchAdapterInterface, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public static final int a = 0;
  private static Comparator jdField_a_of_type_JavaUtilComparator = new gmp();
  public static final int b = 1;
  public static final int c = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected RecentFaceDecoder a;
  protected RecentItemBuilderFactory a;
  protected QQAppInterface a;
  private ConversationSearchAdapter.SearchResultCallBack jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter$SearchResultCallBack = null;
  protected FaceDecoder a;
  protected XListView a;
  private gmq jdField_a_of_type_Gmq = null;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  
  public ConversationSearchAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory = new RecentItemBuilderFactory(0);
  }
  
  private Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return ImageUtil.a();
    }
    if (paramInt == 101) {
      return ImageUtil.d();
    }
    if (paramInt == 4) {
      return ImageUtil.c();
    }
    if (paramInt == 102) {
      return ImageUtil.f();
    }
    return ImageUtil.a();
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup, IContactSearchable paramIContactSearchable)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903150, paramViewGroup, false);
      paramViewGroup = new ContactsSearchResultAdapter.ViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231408));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231409));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231412));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231411));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231413));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231414));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramIContactSearchable.c());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(paramIContactSearchable.b());
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getString(2131559287, new Object[] { LocaleString.b(this.jdField_a_of_type_AndroidViewLayoutInflater.getContext(), paramIContactSearchable.a()) }));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramIContactSearchable.a());
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramIContactSearchable.b(), paramIContactSearchable.d()));
      paramViewGroup.jdField_a_of_type_JavaLangString = paramIContactSearchable.d();
      paramViewGroup.jdField_a_of_type_Int = paramIContactSearchable.b();
      paramIContactSearchable = paramIContactSearchable.a();
      if (paramIContactSearchable != null) {
        break label265;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (ContactsSearchResultAdapter.ViewTag)paramView.getTag();
      break;
      label265:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramIContactSearchable);
    }
  }
  
  protected View a(int paramInt, View paramView, ViewGroup paramViewGroup, IContactSearchable paramIContactSearchable)
  {
    RecentUser localRecentUser = ((ContactsSearchableRecentUser)paramIContactSearchable).a;
    Object localObject;
    if (localRecentUser != null)
    {
      String str = RecentDataListManager.a(localRecentUser.uin, localRecentUser.type);
      localObject = RecentDataListManager.a().a(str);
      paramIContactSearchable = (IContactSearchable)localObject;
      if (localObject == null)
      {
        paramIContactSearchable = ConversationDataFactory.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
        RecentDataListManager.a().a(paramIContactSearchable, str);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(paramIContactSearchable);
      if ((localObject == null) || (paramIContactSearchable == null)) {
        break label157;
      }
      paramViewGroup = ((RecentItemBaseBuilder)localObject).a(paramInt, paramIContactSearchable, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramIContactSearchable.a(), paramIContactSearchable.a()), paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, null, null);
    }
    label157:
    do
    {
      return paramViewGroup;
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "ConSearch|bindView, ru is null");
      }
      paramIContactSearchable = null;
      break;
      paramViewGroup = paramView;
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "ConSearch|bindView, [" + localObject + "," + paramIContactSearchable + "]");
    return paramView;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt1 = 0;
    label31:
    View localView;
    if (paramInt1 < i)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
      if (localView != null) {
        break label59;
      }
      label51:
      break label200;
      break label200;
      break label200;
    }
    label52:
    label59:
    label200:
    label332:
    label336:
    for (;;)
    {
      paramInt1 += 1;
      break label31;
      break;
      int j = ((Integer)localView.getTag(-1)).intValue();
      Object localObject = (IContactSearchable)getItem(j);
      if (getItemViewType(j) == 0)
      {
        localObject = (ContactsSearchableRecentUser)localObject;
        if (((ContactsSearchableRecentUser)localObject).a == null) {
          break label332;
        }
      }
      for (localObject = RecentDataListManager.a().a(((ContactsSearchableRecentUser)localObject).a.uin + "-" + ((ContactsSearchableRecentUser)localObject).a.type);; localObject = null)
      {
        if (localObject == null) {
          break label336;
        }
        j = ((RecentBaseData)localObject).a();
        switch (paramInt2)
        {
        default: 
          if (!Utils.a(paramString, ((RecentBaseData)localObject).a())) {
            break label52;
          }
          paramString = new BitmapDrawable(paramBitmap);
          paramBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
          if (paramBitmap == null) {
            break;
          }
          paramBitmap.a(localView, paramString);
          return;
        case 4: 
          if (j == 1) {
            break label51;
          }
          break;
        case 101: 
          if (j == 3000) {
            break label51;
          }
          break;
        case 11: 
          if (j == 1006) {
            break label51;
          }
          break label52;
          localObject = localView.getTag();
          if (!(localObject instanceof ContactsSearchResultAdapter.ViewTag)) {
            break label52;
          }
          localObject = (ContactsSearchResultAdapter.ViewTag)localObject;
          if ((!paramString.equals(((ContactsSearchResultAdapter.ViewTag)localObject).jdField_a_of_type_JavaLangString)) || (paramInt2 != ((ContactsSearchResultAdapter.ViewTag)localObject).jdField_a_of_type_Int)) {
            break label52;
          }
          ((ContactsSearchResultAdapter.ViewTag)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          return;
        }
      }
    }
  }
  
  public void a(ConversationSearchAdapter.SearchResultCallBack paramSearchResultCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter$SearchResultCallBack = paramSearchResultCallBack;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        notifyDataSetChanged();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_Gmq != null)
    {
      this.jdField_a_of_type_Gmq.cancel(true);
      this.jdField_a_of_type_Gmq = null;
    }
    this.jdField_a_of_type_Gmq = new gmq(this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Gmq.execute(new Void[0]);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_JavaLangString != null) {
      a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(List paramList)
  {
    Collections.sort(paramList, jdField_a_of_type_JavaUtilComparator);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(null);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
      return this.jdField_b_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((IContactSearchable)getItem(paramInt) instanceof ContactsSearchableRecentUser)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    IContactSearchable localIContactSearchable = (IContactSearchable)getItem(paramInt);
    if (getItemViewType(paramInt) == 0) {}
    for (paramView = a(paramInt, paramView, paramViewGroup, localIContactSearchable);; paramView = b(paramInt, paramView, paramViewGroup, localIContactSearchable))
    {
      if (paramView != null) {
        paramView.setTag(-1, Integer.valueOf(paramInt));
      }
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.ConversationSearchAdapter
 * JD-Core Version:    0.7.0.1
 */