package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ImagePreviewAnimationUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Gallery;
import grj;
import grk;
import grl;
import grm;
import gro;
import grp;
import grq;
import grr;
import grs;
import grt;
import gru;
import grv;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TroopAvatarWallPreviewActivity
  extends BaseActivity
{
  public static final String a = "curType";
  public static final String b = "url";
  public static final String c = "_id";
  public static final String d = "friendUin";
  public static final String e = "requestTypeKey";
  public static final String f = "faceid";
  public static final String g = "index";
  public static final String h = "KEY_THUMBNAL_BOUND";
  public static final String i = "default_avator_index";
  public int a;
  long jdField_a_of_type_Long = 300L;
  protected View.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public TroopAvatarBigPhotoAdapter a;
  public ImageAnimationView a;
  public Gallery a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  List jdField_a_of_type_JavaUtilList;
  public boolean a;
  List jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean = false;
  public boolean c;
  public boolean d = false;
  public String j;
  
  public TroopAvatarWallPreviewActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new grm(this);
  }
  
  private Bitmap a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, Drawable paramDrawable, boolean paramBoolean)
  {
    Rect localRect;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localRect = (Rect)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      localObject = a(paramBoolean);
      if ((localObject == null) || (localRect == null)) {
        return null;
      }
    }
    else
    {
      return null;
    }
    String str = b(paramBoolean);
    if (((String)localObject).equals("-5")) {}
    for (Object localObject = paramDrawable; (paramDrawable == null) && ((!paramBoolean) || (localObject == null)); localObject = a(paramBoolean, (String)localObject)) {
      return null;
    }
    int i2;
    int i3;
    int k;
    label170:
    int m;
    label181:
    int i1;
    label245:
    int n;
    if (paramDrawable == null)
    {
      if ((TextUtils.isEmpty(str)) && (str.equals("-5"))) {
        return null;
      }
      paramDrawable = a(paramBoolean, str);
      ((URLDrawable)paramDrawable).setAutoDownload(true);
      i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getWidth();
      i3 = this.jdField_a_of_type_ComTencentWidgetGallery.getHeight();
      if (((Drawable)localObject).getIntrinsicWidth() != 0) {
        break label414;
      }
      k = 1;
      if (((Drawable)localObject).getIntrinsicHeight() != 0) {
        break label424;
      }
      m = 1;
      localObject = AnimationUtils.a(this.jdField_a_of_type_ComTencentWidgetGallery);
      if (localObject != null) {
        localRect.offset(((Rect)localObject).left, -((Rect)localObject).top);
      }
      paramRect3.set(localRect);
      if ((!paramBoolean) || (((URLDrawable)paramDrawable).getStatus() != 1)) {
        break label454;
      }
      if (paramDrawable.getIntrinsicWidth() != 0) {
        break label434;
      }
      i1 = 1;
      if (paramDrawable.getIntrinsicHeight() != 0) {
        break label444;
      }
      n = 1;
    }
    for (;;)
    {
      float f1 = ImagePreviewAnimationUtil.a(i1, n);
      paramRect1.set(ImagePreviewAnimationUtil.a(k, m, i1, n));
      paramRect2.set(ImagePreviewAnimationUtil.b(i1, n, i2, i3));
      paramRect4.set(ImagePreviewAnimationUtil.c(i1, n, i2, i3));
      ImagePreviewAnimationUtil.a(paramRect1, f1);
      ImagePreviewAnimationUtil.a(paramRect2, f1);
      k = (int)(i1 * f1);
      m = (int)(n * f1);
      try
      {
        paramRect3 = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_4444);
        paramRect4 = new Canvas(paramRect3);
        localObject = new Rect(0, 0, i1, n);
        ImagePreviewAnimationUtil.a((Rect)localObject, f1);
        paramDrawable.setBounds((Rect)localObject);
        paramRect4.clipRect(ImagePreviewAnimationUtil.a(paramRect1, paramRect2));
        paramDrawable.draw(paramRect4);
        return paramRect3;
      }
      catch (Throwable paramRect1)
      {
        if (!QLog.isColorLevel()) {
          break label500;
        }
        QLog.e("ImagePreveiew", 2, "makeAnimationRect " + paramRect1.getMessage());
      }
      break;
      label414:
      k = ((Drawable)localObject).getIntrinsicWidth();
      break label170;
      label424:
      m = ((Drawable)localObject).getIntrinsicHeight();
      break label181;
      label434:
      i1 = paramDrawable.getIntrinsicWidth();
      break label245;
      label444:
      n = paramDrawable.getIntrinsicHeight();
      continue;
      label454:
      n = m;
      i1 = k;
    }
    label500:
    return null;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new grt(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private boolean c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.a();
    if (localObject1 == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    Object localObject2 = ((ImageView)((View)localObject1).findViewById(2131230758)).getDrawable();
    if ((localObject2 != null) && ((localObject2 instanceof URLDrawable)))
    {
      if (((URLDrawable)localObject2).getStatus() != 1) {
        return false;
      }
    }
    else if (localObject2 == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setVisibility(0);
    localObject1 = new Rect();
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    localObject2 = a(localRect2, localRect3, (Rect)localObject1, localRect1, (Drawable)localObject2, localObject2 instanceof URLDrawable);
    if (localObject2 == null) {
      return false;
    }
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a((Bitmap)localObject2, localRect3, localRect2, localRect1, (Rect)localObject1, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setAnimationListener(new gru(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new grv(this), this.jdField_a_of_type_Long);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setInterpolator(new DecelerateInterpolator());
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    return true;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentWidgetGallery.a();
        } while (localObject == null);
        localObject = ((ImageView)((View)localObject).findViewById(2131230758)).getDrawable();
      } while ((localObject == null) || (!(localObject instanceof URLDrawable)));
      localObject = (URLDrawable)localObject;
    } while (((URLDrawable)localObject).getStatus() != 1);
    boolean bool = AvatarTroopUtil.b((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (bool)
    {
      localActionSheet.a(2131562128, 1);
      localActionSheet.a(2131562803, 1);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localActionSheet.a(2131560646, 5);
      localActionSheet.a(2131561928, 3);
    }
    localActionSheet.d(2131561746);
    localActionSheet.a(new grq(this, bool, (URLDrawable)localObject, localActionSheet));
    localActionSheet.show();
  }
  
  Drawable a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return URLDrawable.getDrawable(paramString);
    }
    return new BitmapDrawable(BitmapFactory.decodeFile(paramString, ImageUtil.a(paramString, 100)));
  }
  
  public String a(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "picIndex" + this.jdField_a_of_type_Int + "," + "mSeqNumList.size()" + this.jdField_a_of_type_JavaUtilList.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals("-5"))) {
      return "-5";
    }
    return AvatarTroopUtil.a(AvatarTroopUtil.a(str, this.j, 1));
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() > 1)
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        getIntent().putStringArrayListExtra("del_list", (ArrayList)this.jdField_b_of_type_JavaUtilList);
        setResult(-1, getIntent());
      }
      finish();
      return;
    }
    QQToast.a(this, getString(2131560636), 1).b(d());
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.ap).mkdirs();
      str = AppConstants.ap + this.j + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            b(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131561446), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131562802)).setMessage(getString(2131561976)).setPositiveButton(getString(2131562765), new grs(this, paramURLDrawable, str)).setNegativeButton(getString(2131562473), new grr(this)).show();
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    Object localObject = new File(AppConstants.aM);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    String str = AppConstants.aM + this.j + Utils.Crc64String(paramURLDrawable.getURL().toString());
    localObject = str;
    if (!new File(str).exists()) {}
    try
    {
      localObject = paramURLDrawable.saveTo(str);
      if (paramString.equals("-5"))
      {
        paramString = AvatarTroopUtil.a(paramString, this.j, 0);
        paramString = AvatarTroopUtil.a(paramString);
        localBundle.putBoolean("forward_urldrawable", true);
        localBundle.putString("forward_urldrawable_thumb_url", paramString);
        localBundle.putString("forward_filepath", (String)localObject);
        localBundle.putString("forward_urldrawable_big_url", paramURLDrawable.getURL().toString());
        localBundle.putString("forward_extra", (String)localObject);
        paramURLDrawable = new Intent(this, ForwardRecentActivity.class);
        paramURLDrawable.putExtras(localBundle);
        startActivityForResult(paramURLDrawable, 21);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.e("foward", 2, "IOException", localIOException);
          localObject = str;
          continue;
          paramString = AvatarTroopUtil.a(paramString, this.j, 1);
        }
      }
    }
  }
  
  public String b(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "picIndex" + this.jdField_a_of_type_Int + "," + "mSeqNumList.size()" + this.jdField_a_of_type_JavaUtilList.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals("-5"))) {
      return "-5";
    }
    return AvatarTroopUtil.b(AvatarTroopUtil.a(str, this.j, 1));
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {
      return;
    }
    getIntent().putExtra("default_avator_index", paramInt);
    setResult(-1, getIntent());
    finish();
  }
  
  public void d()
  {
    if ((!this.d) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentWidgetGallery.a() != this.jdField_a_of_type_Int)) {
        break label53;
      }
      if (!c()) {
        e();
      }
    }
    return;
    label53:
    e();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.d = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new grk(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.postDelayed(new grl(this), 500L);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void onBackPressed()
  {
    d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903250);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131231776));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230976));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231116));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131230991);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131231775));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131230986));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView = ((ImageAnimationView)findViewById(2131231777));
    ((ImageView)findViewById(2131231778)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("IS_EDIT");
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getParcelableArrayList("KEY_THUMBNAL_BOUND");
      this.c = paramBundle.getBoolean("is_show_action", true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter = new TroopAvatarBigPhotoAdapter(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.j = paramBundle.getString("troop_uin");
      this.jdField_a_of_type_Boolean = paramBundle.getBoolean("troop_info_is_member");
      this.jdField_a_of_type_JavaUtilList = paramBundle.getStringArrayList("seqNum");
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.j);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(paramBundle.getBoolean("is_use_path", false));
      this.jdField_a_of_type_Int = paramBundle.getInt("index", -1);
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131427411));
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new grj(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new gro(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new grp(this));
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
  }
  
  protected void onDestroy()
  {
    System.gc();
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      f();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */