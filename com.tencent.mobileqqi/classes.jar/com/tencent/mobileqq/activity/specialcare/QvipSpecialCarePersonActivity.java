package com.tencent.mobileqq.activity.specialcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import esj;
import esk;
import esl;
import esm;
import esn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QvipSpecialCarePersonActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "QvipSpecialCarePersonActivity";
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
  private View jdField_a_of_type_AndroidViewView = null;
  private QvipSpecialCareManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = null;
  private QvipSpecialCarePersonActivity.SpecialCareAdapter jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity$SpecialCareAdapter;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new esl(this);
  private FriendsManagerImp jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = null;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new esm(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Comparator jdField_a_of_type_JavaUtilComparator = new esk(this);
  private int b;
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return "";
      } while (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp == null);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.c(paramString);
    } while (paramString == null);
    return ContactUtils.a(paramString);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecialCarePersonActivity", 2, "setItemBackground() childPos = " + paramInt1 + ", listSize = " + paramInt2);
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130837882);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130837882);
      return;
    }
    paramView.setBackgroundResource(2130837881);
  }
  
  private void a(String paramString, FormSimpleItem paramFormSimpleItem)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString);
    if (localBitmap == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 1, false, (byte)1);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
      }
      paramFormSimpleItem.setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
    paramFormSimpleItem.setLeftIcon(new BitmapDrawable(localBitmap), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, QvipSpecialCareActivity.class);
    localIntent.putExtra("memberUin", paramString1);
    localIntent.putExtra("memberName", paramString2);
    startActivity(localIntent);
  }
  
  private void d()
  {
    e();
    h(2131561692);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131233453));
    Object localObject = LayoutInflater.from(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232883);
    View localView = ((LayoutInflater)localObject).inflate(2130903703, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    localObject = ((LayoutInflater)localObject).inflate(2130903696, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.b((View)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131233454).setOnClickListener(this);
    ((View)localObject).findViewById(2131233452).setOnClickListener(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = ((FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
      g();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity$SpecialCareAdapter = new QvipSpecialCarePersonActivity.SpecialCareAdapter(this);
    this.jdField_b_of_type_Int = ((int)getResources().getDimension(2131427614));
  }
  
  private void g()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new esj(this));
  }
  
  @SuppressLint({"NewApi"})
  private void h()
  {
    i();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a();
    if ((localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = new ArrayList((Collection)localObject);
      Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity$SpecialCareAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity$SpecialCareAdapter.a((List)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.b(str))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(str);
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(str)) {
            this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.c(str);
          }
        }
      }
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this, ForwardFriendListActivity.class);
    localIntent.putExtra("extra_choose_friend", 1);
    startActivityForResult(localIntent, 1);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (esn)((View)localObject).getTag();
          if ((localObject != null) && (((esn)localObject).jdField_a_of_type_JavaLangString.endsWith(paramString)) && (((esn)localObject).jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (paramBitmap != null)) {
            ((esn)localObject).jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(new BitmapDrawable(paramBitmap), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
          }
        }
      }
      else
      {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903697);
    setTitle(2131561776);
    d();
    f();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    h();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    while ((paramInt1 != 1) || (paramIntent == null)) {
      return;
    }
    a(paramIntent.getStringExtra("extra_choose_friend_uin"), paramIntent.getStringExtra("extra_choose_friend_name"));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount() < 4)
      {
        j();
        return;
      }
      paramView = new QQToast(this);
      paramView.c(2000);
      paramView.b(2131559929);
      paramView.a();
      return;
      paramView = (esn)paramView.getTag();
    } while (paramView == null);
    a(paramView.jdField_a_of_type_JavaLangString, paramView.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialCarePersonActivity
 * JD-Core Version:    0.7.0.1
 */