package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bzk;
import bzl;
import bzm;
import bzn;
import bzo;
import bzp;
import bzq;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import java.util.ArrayList;
import java.util.Iterator;

public class AIOImageListScene
  extends AbstractImageListScene
  implements DialogInterface.OnCancelListener
{
  private static final String jdField_a_of_type_JavaLangString = "AIOImageListScene";
  static final int c = 20;
  static final int d = 0;
  static final int e = 1;
  static final int f = 2;
  static final int g = 0;
  static final int h = 1;
  static final int i = 2;
  static final int j = 3;
  static final int k = 4;
  static final int l = 5;
  static final int m = 1;
  static final int n = 2;
  static final int o = 1;
  static final int p = 2;
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private bzq jdField_a_of_type_Bzq;
  private AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  private IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  public ArrayList a;
  private String b;
  
  public AIOImageListScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(String paramString)
  {
    if (paramString.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364261)))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(View paramView, GalleryImage paramGalleryImage)
  {
    Object localObject = (AIOPhotoListAdapter.Holder)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((AIOPhotoListAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView;
      localObject = ((AIOPhotoListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView;
      switch (paramGalleryImage.b())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
    }
    return false;
  }
  
  private boolean a(AIOImageInfo paramAIOImageInfo, boolean paramBoolean)
  {
    int i1 = paramAIOImageInfo.b();
    if (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean))) {}
    long l1;
    do
    {
      return false;
      if ((i1 != 2) || (!paramBoolean) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 20)) {
        break;
      }
      l1 = System.currentTimeMillis();
    } while (l1 - this.jdField_a_of_type_Long < 700L);
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, "最多只能选择20张图片", 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492887));
    this.jdField_a_of_type_Long = l1;
    return false;
    if (paramBoolean)
    {
      paramAIOImageInfo.a(1);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAIOImageInfo);
    }
    for (;;)
    {
      return true;
      paramAIOImageInfo.a(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramAIOImageInfo);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showDownloadResult type = " + paramInt1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new bzl(this));
    Object localObject;
    switch (paramInt1)
    {
    case 2: 
    default: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364271), new Object[] { Integer.valueOf(paramInt2) }));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131362802, new DialogUtil.DialogOnClickAdapter());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131364270);
      localObject = new bzm(this, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131362801, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131362446, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showSDCardResult type = " + paramInt2);
    }
    String str;
    if (paramInt2 == 22)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131363023);
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131363024);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, (String)localObject, str, null, null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(str);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131362802, new DialogUtil.DialogOnClickAdapter());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (paramInt2 == 24)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131363021);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131363022);
      }
      else if (paramInt2 == 23)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131363019);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131363020);
      }
      else
      {
        localObject = null;
        str = null;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showProgressDialog step = " + paramInt1);
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131624120);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903271);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297431);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localTextView.setText(str);
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      str = localTextView.getResources().getText(2131364264) + str;
      continue;
      str = localTextView.getResources().getText(2131364265) + str;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131363062), "qqsetting_auto_receive_pic_key", true);
    int i1;
    int i2;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      i1 = 1;
      if (NetworkUtil.b(BaseApplication.getContext()) != -1) {
        break label119;
      }
      i2 = 1;
      label64:
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((AIOImageInfo)((Iterator)localObject).next()).a.a(2) != null);
    }
    for (int i3 = 0;; i3 = 1)
    {
      if (i3 != 0)
      {
        q();
        return;
        i1 = 0;
        break;
        label119:
        i2 = 0;
        break label64;
      }
      if (i2 != 0)
      {
        b(1, this.jdField_a_of_type_JavaUtilArrayList.size());
        return;
      }
      if ((bool) || (i1 != 0))
      {
        a(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
        return;
      }
      b(0, 1);
      return;
    }
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null) && ((this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof AIOImageInfo)))
    {
      localBundle = new Bundle();
      localBundle.putInt("forward_type", 12);
      localObject1 = (AIOImageInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localObject2 = ((AIOImageInfo)localObject1).a.a(2);
      localBundle.putString("forward_urldrawable_thumb_url", ((AIOImageInfo)localObject1).a.a(1));
      localBundle.putString("forward_urldrawable_big_url", (String)localObject2);
      localBundle.putBoolean("forward_urldrawable", true);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        localBundle.putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + "张图片");
      }
      localBundle.putBoolean("sendMultiple", true);
      localObject1 = new ArrayList();
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(((AIOImageInfo)((Iterator)localObject2).next()).a.e);
      }
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
      localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtras(localBundle);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 1);
    }
    while (!QLog.isColorLevel())
    {
      Bundle localBundle;
      Object localObject1;
      Object localObject2;
      return;
    }
    QLog.d("AIOImageListScene", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131364262);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131364261);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GalleryImage)localIterator.next()).a(2);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
  }
  
  protected View.OnClickListener a()
  {
    return new bzp(this);
  }
  
  protected AbstractImageAdapter a(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = new AIOPhotoListAdapter(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel);
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  protected AdapterView.OnItemClickListener a()
  {
    return new bzn(this);
  }
  
  protected GestureSelectGridView.OnSelectListener a()
  {
    return new bzo(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    switch (paramInt1)
    {
    case 10: 
    default: 
      return;
    case 20: 
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364266) + AppConstants.au, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492887));
      return;
    case 21: 
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364267) + AppConstants.au, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492887));
      return;
    case 22: 
    case 23: 
    case 24: 
      b(3, 0);
      return;
    case 11: 
      b(1, paramInt2);
      return;
    }
    q();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendPhotoActivity.class);
      paramIntent = new Bundle(paramIntent.getExtras());
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      localIntent.putExtras(paramIntent);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
        if (paramInt3 != 1) {
          break;
        }
        localObject1 = ???;
        int i1 = ((AIOImageListModel)localObject3).a(paramLong, paramInt1, paramInt2, (String)localObject1);
        if (paramInt2 == 1)
        {
          int i2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q();
          int i3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
          if ((i1 >= i2) && (i1 <= i3 + i2 - 1))
          {
            localObject1 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i1 - i2);
            ((AIOPhotoListAdapter)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(i1), (View)localObject1);
          }
        }
      } while ((paramInt2 != 2) || (this.jdField_a_of_type_Bzq == null));
      localObject1 = this.jdField_a_of_type_Bzq;
    } while ((((bzq)localObject1).a == null) || (((bzq)localObject1).a.a.jdField_a_of_type_Long != paramLong) || (((bzq)localObject1).a.a.d != paramInt1));
    Object localObject3 = ((bzq)localObject1).a.a;
    if (paramInt3 == 1) {}
    for (;;)
    {
      ((AIOImageData)localObject3).e = ???;
      synchronized (((bzq)localObject1).a)
      {
        ((bzq)localObject1).a.notifyAll();
        return;
      }
      String str = "I:E";
      break;
      ??? = "I:E";
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    m();
    super.a(paramViewGroup);
  }
  
  public void a(Integer... paramVarArgs)
  {
    c(paramVarArgs[0].intValue(), 0);
    this.jdField_a_of_type_Bzq = new bzq(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Bzq.execute(paramVarArgs);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = null;
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onStart start FirstVisiblePosition " + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q() + " LastVisiblePosition " + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.r() + " SelectedIndex = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
      }
      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
      i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.d();
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c();
      if ((i2 > i3) || (i2 < i1) || (i2 - i1 < 4))
      {
        if ((i3 <= 0) || (i2 <= i3)) {
          break label301;
        }
        i2 -= i3;
        if ((i2 > 4) && (i2 % 4 == 0))
        {
          i1 = i2 + i1 + 4;
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "onStart selectedIndex > lastPosition n " + i1);
          }
          this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.r());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("AIOImageListScene", 2, "onStart end FirstVisiblePosition " + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q() + " LastVisiblePosition " + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.r() + " SelectedIndex = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
      }
    }
    label301:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        int i2;
        int i3;
        return;
        int i1 = i2 + i1 + 8;
        continue;
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
      }
    }
    QLog.d("AIOImageListScene", 2, "onStart error!! mAIOModel == null ");
  }
  
  protected void k()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null, 2131624120);
    localActionSheet.a(2131364259);
    localActionSheet.a(2131364260, 5);
    localActionSheet.d(2131362801);
    localActionSheet.a(new bzk(this, localActionSheet));
    localActionSheet.show();
  }
  
  protected void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "saveAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131363062), "qqsetting_auto_receive_pic_key", true);
    int i1;
    int i2;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      i1 = 1;
      if (NetworkUtil.b(BaseApplication.getContext()) != -1) {
        break label130;
      }
      i2 = 1;
      label64:
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((AIOImageInfo)((Iterator)localObject).next()).a.a(2) != null);
    }
    for (int i3 = 0;; i3 = 1)
    {
      if (i3 != 0)
      {
        a(new Integer[] { Integer.valueOf(1) });
        return;
        i1 = 0;
        break;
        label130:
        i2 = 0;
        break label64;
      }
      if (i2 != 0)
      {
        b(1, this.jdField_a_of_type_JavaUtilArrayList.size());
        return;
      }
      if ((bool) || (i1 != 0))
      {
        a(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
        return;
      }
      b(0, 0);
      return;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidAppDialog = null;
    paramDialogInterface = this.jdField_a_of_type_Bzq;
    if (paramDialogInterface != null) {
      bzq.a(paramDialogInterface, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene
 * JD-Core Version:    0.7.0.1
 */