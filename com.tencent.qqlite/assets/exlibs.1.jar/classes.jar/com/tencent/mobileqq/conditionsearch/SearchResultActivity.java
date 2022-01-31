package com.tencent.mobileqq.conditionsearch;

import SummaryCard.CondFitUser;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import dbg;
import dbh;
import dbi;
import dbj;
import dbk;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchResultActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public static final String a = "SearchResultActivity";
  static final boolean jdField_a_of_type_Boolean = true;
  public static final String b = "key_resp_search";
  private static List b;
  public static final String c = "key_keyword";
  private static final int d = 0;
  public static final String d = "key_sex_index";
  private static final int e = 1;
  public static final String e = "key_age_index";
  private static final int f = 2;
  public static final String f = "key_loc_code";
  private static final int g = 3;
  public static final String g = "key_home_code";
  private static final int h = 4;
  public static final String h = "key_has_more";
  static final String jdField_i_of_type_JavaLangString = "不限";
  private static final int j = 0;
  private static final int k = 1;
  private static final int l = 2;
  public int a;
  long jdField_a_of_type_Long = 0L;
  View jdField_a_of_type_AndroidViewView;
  ConditionSearchManager.ISearchListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener = new dbg(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new dbh(this);
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public XListView a;
  public dbi a;
  public List a;
  Set jdField_a_of_type_JavaUtilSet;
  public int b;
  int c = 0;
  private int jdField_i_of_type_Int;
  
  static
  {
    jdField_b_of_type_JavaUtilList = null;
  }
  
  public SearchResultActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2, List paramList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, SearchResultActivity.class);
    localIntent.putExtra("key_keyword", paramString);
    localIntent.putExtra("key_age_index", paramInt1);
    localIntent.putExtra("key_sex_index", paramInt2);
    localIntent.putExtra("key_loc_code", paramArrayOfString1);
    localIntent.putExtra("key_home_code", paramArrayOfString2);
    localIntent.putExtra("key_has_more", paramBoolean);
    jdField_b_of_type_JavaUtilList = paramList;
    paramContext.startActivity(localIntent);
  }
  
  private void a(dbj paramdbj, RichStatus paramRichStatus)
  {
    paramdbj.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.a()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.c))
      {
        paramdbj.jdField_a_of_type_Int = paramRichStatus.jdField_b_of_type_Int;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramRichStatus.jdField_b_of_type_Int, 200);
        localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
        int m = this.i;
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * m), m);
        paramdbj.d.setCompoundDrawables((Drawable)localObject, null, null, null);
      }
      for (;;)
      {
        paramdbj.d.setText(paramRichStatus.a(" "));
        return;
        paramdbj.jdField_a_of_type_Int = 0;
        paramdbj.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    paramdbj.jdField_a_of_type_Int = 0;
    paramdbj.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    paramdbj.d.setText("");
  }
  
  private void d()
  {
    Object localObject = (ViewGroup)findViewById(2131296894);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131297145);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131296901);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public String a(dbj paramdbj, CondFitUser paramCondFitUser)
  {
    int n = 2130838759;
    StringBuilder localStringBuilder = new StringBuilder();
    paramdbj.jdField_a_of_type_JavaLangString = (paramCondFitUser.lUIN + "");
    paramdbj.jdField_a_of_type_AndroidWidgetTextView.setText(paramCondFitUser.strNick);
    localStringBuilder.append(paramCondFitUser.strNick);
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramCondFitUser.locDesc);
    Object localObject2 = arrayOfString[1];
    Object localObject1 = localObject2;
    if (((String)localObject2).equals("不限")) {
      localObject1 = arrayOfString[0];
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("不限")) {
      localObject2 = "";
    }
    int m;
    if (paramCondFitUser.dwAge != 0L)
    {
      paramdbj.b.setText(String.valueOf(paramCondFitUser.dwAge));
      localObject1 = "";
      switch (paramCondFitUser.cSex)
      {
      default: 
        m = 0;
        label174:
        localStringBuilder.append((String)localObject1).append(String.format("%s岁", new Object[] { Long.valueOf(paramCondFitUser.dwAge) })).append((String)localObject2);
        if ((m == 0) && (TextUtils.isEmpty(paramdbj.b.getText().toString()))) {
          paramdbj.b.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      paramdbj.c.setText((CharSequence)localObject2);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramdbj.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = ImageUtil.a();
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramdbj.jdField_a_of_type_JavaLangString, 1, true, (byte)1);
          localObject1 = localObject2;
        }
      }
      paramdbj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      a(paramdbj, paramCondFitUser.richStatus);
      localStringBuilder.append(paramdbj.d.getText().toString());
      return localStringBuilder.toString();
      paramdbj.b.setText("");
      break;
      m = 2130838089;
      localObject1 = "男";
      break label174;
      m = 2130838084;
      n = 2130838758;
      localObject1 = "女";
      break label174;
      paramdbj.b.setVisibility(0);
      paramdbj.b.setCompoundDrawablesWithIntrinsicBounds(m, 0, 0, 0);
      paramdbj.b.setBackgroundResource(n);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Int == 0))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof dbj)))
        {
          localObject = (dbj)localObject;
          if (((dbj)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((dbj)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  void a(long paramLong) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    this.jdField_a_of_type_Dbi.notifyDataSetChanged();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    if (!NetworkUtil.e(this))
    {
      this.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_Dbi.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(false, null, 0, 0, null, null);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903482);
    d(2130837633);
    setTitle(2131364401);
    d();
    if (getIntent().getBooleanExtra("key_has_more", false)) {}
    for (int m = 1;; m = 0)
    {
      this.jdField_b_of_type_Int = m;
      this.jdField_a_of_type_JavaUtilList = jdField_b_of_type_JavaUtilList;
      jdField_b_of_type_JavaUtilList = null;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
        break;
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(49));
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.i = ((int)DisplayUtils.a(this, 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131296564));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_Dbi = new dbi(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dbi);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    int m;
    if (paramView != null)
    {
      if (!(paramView instanceof dbj)) {
        break label114;
      }
      paramView = (dbj)paramView;
      if (!this.app.a().equals(paramView.jdField_a_of_type_JavaLangString)) {
        break label79;
      }
      m = 0;
    }
    for (;;)
    {
      Object localObject = new ProfileActivity.AllInOne(paramView.jdField_a_of_type_JavaLangString, m);
      ((ProfileActivity.AllInOne)localObject).h = paramView.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      ((ProfileActivity.AllInOne)localObject).g = 87;
      ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
      label79:
      label114:
      do
      {
        return;
        localObject = (FriendManager)this.app.getManager(8);
        if ((localObject == null) || (!((FriendManager)localObject).b(paramView.jdField_a_of_type_JavaLangString))) {
          break label150;
        }
        m = 1;
        break;
      } while ((!(paramView instanceof dbk)) || ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4)));
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_Dbi.notifyDataSetChanged();
      return;
      label150:
      m = 75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity
 * JD-Core Version:    0.7.0.1
 */