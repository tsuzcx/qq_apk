package com.tencent.mobileqq.activity.specialcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import esc;
import esd;
import ese;
import esf;
import esg;
import esh;
import esi;
import esj;

public class QvipSpecialCareActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private static final int jdField_a_of_type_Int = 0;
  private static final long jdField_a_of_type_Long = 90000L;
  public static final String a = "memberUin";
  public static final String b = "memberName";
  private static final String c = "QvipSpecialCareActivity";
  private Intent jdField_a_of_type_AndroidContentIntent;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new esd(this);
  private View jdField_a_of_type_AndroidViewView;
  @SuppressLint({"NewApi"})
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new ese(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QvipSpecialCareManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private SpecialCareTipsController jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecialCareTipsController;
  private FriendsManagerImp jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = null;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new esj(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String d;
  
  private void a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(this.d))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      str = paramString;
      if (paramString == null) {
        str = "";
      }
      ((TextView)localObject).setText(str);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.a());
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.c(this.d);
        str = paramString;
        if (localObject != null)
        {
          str = paramString;
          if (((Friends)localObject).isFriend()) {
            str = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.b(this.d);
          }
        }
      }
    }
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = this.d;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    a(this.d, this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  private void a(String paramString, int paramInt)
  {
    DialogUtil.a(this, 230, getString(2131562519), paramString, 2131561746, paramInt, new esf(this), new esg(this)).show();
  }
  
  private void a(String paramString, ImageView paramImageView)
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
      paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
  }
  
  private void b(String paramString)
  {
    if (!isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramString, d(), 0, 0);
    }
  }
  
  private void c(String paramString)
  {
    DialogUtil.a(this, 230, getString(2131562519), paramString, 2131561845, 0, null, new esh(this)).show();
  }
  
  private boolean c()
  {
    return (this.b != null) && (this.b.d() != 0);
  }
  
  @SuppressLint({"NewApi"})
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131230985));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231000));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131233451));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131233450));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    h(2131561692);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131233452));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.b);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = ((FriendsManagerImp)this.b.getManager(8));
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.b);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.d = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("memberUin");
    a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("memberName"));
    g();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
      f();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecialCareTipsController = new SpecialCareTipsController(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  private void f()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new esc(this));
  }
  
  private void g()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a();
    if (System.currentTimeMillis() - l <= 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QvipSpecialCareActivity", 2, "not 24 hours, donot neet get quota.");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(null, 1, null);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(this.d))
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(this.d));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("special_care_red_point_two", false))
      {
        localObject = getResources().getDrawable(2130840209);
        Drawable localDrawable = getResources().getDrawable(2130837804);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon((Drawable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localDrawable);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0), 90000L);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903699, null);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131233459).setOnClickListener(new esi(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecialCareTipsController.a(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void k()
  {
    startActivity(new Intent(this, SoundAndVibrateActivity.class));
  }
  
  private void l()
  {
    Object localObject = new Intent(this, QvipSpecialSoundActivity.class);
    ((Intent)localObject).putExtra("friendUin", this.d);
    startActivity((Intent)localObject);
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("special_care_red_point_two", false)) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(this.d)))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("special_care_red_point_two", false).commit();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("special_care_red_point_one", false).commit();
      localObject = getResources().getDrawable(2130837804);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (paramBitmap != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903695);
    setTitle(2131561776);
    d();
    e();
    if (this.b != null) {
      this.b.a(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.b != null) {
      this.b.c(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void doOnResume()
  {
    super.doOnResume();
    h();
    if ((c()) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecialCareTipsController != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecialCareTipsController.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialCareActivity
 * JD-Core Version:    0.7.0.1
 */