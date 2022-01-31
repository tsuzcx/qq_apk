package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aox;
import aoy;
import aoz;
import apa;
import apb;
import apc;
import apd;
import apf;
import aph;
import api;
import apj;
import apk;
import apm;
import apn;
import apo;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.adapter.FriendProfileImageAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;

public class FriendProfileImageActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = "curType";
  public static final String b = "url";
  public static final String c = "_id";
  public static final String d = "friendUin";
  public static final String e = "requestTypeKey";
  public static final String f = "faceid";
  public static final String g = "index";
  public static final String h = "KEY_THUMBNAL_BOUND";
  public static final String i = "extra_pendant_id";
  public static final String j = "extra_action_source";
  public int a;
  private long jdField_a_of_type_Long = 350L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public AsyncTask a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new apd(this);
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageButton a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  public TextView a;
  public FriendProfileImageModel a;
  public FriendProfileImageAdapter a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public Gallery a;
  Runnable jdField_a_of_type_JavaLangRunnable = new apa(this);
  public boolean a;
  public int b;
  View b;
  public AlphaAnimation b;
  public boolean b;
  int c;
  public boolean c;
  private boolean d;
  private boolean e = false;
  
  public FriendProfileImageActivity()
  {
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_c_of_type_Boolean = false;
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString1 != null)
    {
      int k = paramString1.lastIndexOf("/");
      str1 = str2;
      if (k >= 0)
      {
        str1 = str2;
        if (k < paramString1.length() - 1) {
          str1 = AppConstants.au + paramString2 + paramString1.substring(k + 1);
        }
      }
    }
    return str1;
  }
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    this.jdField_c_of_type_Boolean = true;
    View localView = getActivity().findViewById(16908290);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    int i2;
    int n;
    int i1;
    int k;
    int m;
    float f1;
    float f2;
    if ((paramRect2 != null) && (paramRect1 != null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
      int i4 = paramRect1.width();
      int i5 = paramRect1.height();
      i2 = paramRect2.width();
      int i3 = paramRect2.height();
      n = localView.getWidth();
      i1 = localView.getHeight();
      if (i2 <= n)
      {
        k = i3;
        m = i2;
        if (i3 <= i1) {}
      }
      else
      {
        f1 = n / i2;
        f2 = i1 / i3;
        if (f1 >= f2) {
          break label422;
        }
        k = Math.round(i3 * f1);
        m = n;
      }
      f2 = AnimationUtils.a(m, k, n, i1);
      if ((m != i4) || (i5 != k))
      {
        f1 = i4 / m / f2;
        f2 = i5 / k / f2;
        if (f1 <= f2) {
          break label440;
        }
        f1 = f2;
      }
    }
    label422:
    label440:
    for (;;)
    {
      paramRect1 = new ScaleAnimation(f1, 1.0F, f1, 1.0F, 1, 0.5F, 1, 0.5F);
      paramRect1.setDuration(this.jdField_a_of_type_Long);
      paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(paramRect1);
      paramRect1 = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      AnimationUtils.a(localView, paramRect1);
      k = paramRect1.centerX();
      m = paramRect1.centerY();
      n = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.centerY();
      paramRect1 = new TranslateAnimation(-(k - n), 0.0F, -(m - i1), 0.0F);
      paramRect1.setDuration(this.jdField_a_of_type_Long);
      paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
      paramRect1.setAnimationListener(new apb(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramRect1);
      paramRect1 = new AlphaAnimation(0.0F, 1.0F);
      paramRect1.setInterpolator(new DecelerateInterpolator());
      paramRect1.setDuration(350L);
      paramRect1.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewView.startAnimation(paramRect1);
      return;
      m = Math.round(i2 * f2);
      k = i1;
      break;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new aoy(this, paramTextView));
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new aoz(this, paramTextView));
  }
  
  private void e()
  {
    FriendProfileImageModel.ProfileImageInfo localProfileImageInfo = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
    if ((localProfileImageInfo == null) || (localProfileImageInfo.h != 6)) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
    localActionSheet.a(2131363941, 1);
    localActionSheet.a(2131363945, 1);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      localActionSheet.a(2131363947, 3);
    }
    localActionSheet.d(2131362790);
    localActionSheet.a(new apm(this, localProfileImageInfo, localActionSheet));
    localActionSheet.show();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363248);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (paramProfileImageInfo != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putString("forward_filepath", paramProfileImageInfo.d);
      localBundle.putString("forward_thumb", paramProfileImageInfo.c);
      paramProfileImageInfo = new Intent(this, ForwardRecentActivity.class);
      paramProfileImageInfo.putExtras(localBundle);
      startActivityForResult(paramProfileImageInfo, 21);
    }
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if (paramAdapterView.b() <= 1) {
        break label159;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "/" + paramAdapterView.b());
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        break label124;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      if (this.d)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        this.d = false;
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    return;
    label124:
    this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    return;
    label159:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void a(String paramString1, String paramString2)
  {
    new File(AppConstants.au).mkdirs();
    paramString2 = a(paramString1, paramString2);
    if (!new File(paramString2).exists()) {
      b(paramString1, paramString2);
    }
    for (;;)
    {
      sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + paramString2)));
      return;
      DialogUtil.a(this, 230).setTitle(getString(2131363442)).setMessage(getString(2131363444)).setPositiveButton(getString(2131363443), new apo(this, paramString1, paramString2)).setNegativeButton(getString(2131362787), new apn(this)).show();
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131363445), 0).a();
    }
    Card localCard;
    do
    {
      return;
      localCard = ((FriendManager)this.app.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b);
    } while (localCard == null);
    ((CardHandler)this.app.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b, localCard.uFaceTimeStamp, HexUtil.a(paramProfileImageInfo.jdField_a_of_type_JavaLangString));
    a();
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (FileUtils.c(paramString1, paramString2))
    {
      QQToast.a(this, getString(2131363439) + " " + AppConstants.au, 0).a();
      return;
    }
    QQToast.a(this, getString(2131363440), 0).a();
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      d();
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall", 2, "updateCurrentImage uin=" + paramProfileImageInfo.e + ", state=" + paramProfileImageInfo.h);
      }
      localObject = (String)this.jdField_a_of_type_AndroidViewView.getTag();
      if (paramProfileImageInfo.h != 6) {
        break label104;
      }
      if ((localObject == null) || (!((String)localObject).equals(paramProfileImageInfo.d))) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.c(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
      }
    }
    label104:
    do
    {
      do
      {
        do
        {
          return;
          if ((paramProfileImageInfo.h != 3) && (paramProfileImageInfo.h != 4)) {
            break;
          }
          if ((localObject == null) || (!((String)localObject).equals(paramProfileImageInfo.c))) {
            this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.b(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
          }
        } while ((!paramProfileImageInfo.jdField_a_of_type_Boolean) || (paramProfileImageInfo.h != 4));
        localObject = (ImageProgressCircle)this.jdField_a_of_type_AndroidViewView.findViewById(2131296282);
        if (localObject != null)
        {
          ((ImageProgressCircle)localObject).setProgress(paramProfileImageInfo.i);
          if (((ImageProgressCircle)localObject).getVisibility() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a((ImageProgressCircle)localObject);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.PhotoWall", 2, "progressCircle = " + paramProfileImageInfo.i);
      return;
    } while ((paramProfileImageInfo.h != 5) && (paramProfileImageInfo.h != 2));
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(350L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 2.0F, 1.0F, 2.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new apc(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void doOnBackPressed()
  {
    c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427345);
    setContentView(2130903211);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131297187));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296993));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296564));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296445);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297186));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131296440));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297189));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aox(this));
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter = new FriendProfileImageAdapter(this);
    if (881 == paramBundle.getInt("requestType"))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel = new FriendProfileImageAvatar(this.app);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b = paramBundle.getString("friendUin");
      this.jdField_c_of_type_Int = paramBundle.getInt("extra_action_source", 0);
      if (!this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b)) {
        break label498;
      }
    }
    label498:
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Int = paramBundle.getInt("index", -1);
      FriendProfileImageModel.ProfileImageInfo localProfileImageInfo = new FriendProfileImageModel.ProfileImageInfo();
      localProfileImageInfo.e = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b;
      localProfileImageInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("filekey");
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this, localProfileImageInfo);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(new apf(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b(this);
      this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel);
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131492924));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new aph(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new api(this));
      a(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new apj(this));
      this.jdField_a_of_type_AndroidOsAsyncTask = new apk(this, localProfileImageInfo);
      return true;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel = new FriendProfileImagePortraits(this.app);
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this);
    System.gc();
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      e();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    float f1;
    int k;
    Object localObject2;
    Rect localRect;
    Object localObject3;
    Object localObject1;
    if ((paramBoolean) && (!this.e))
    {
      f1 = getResources().getDisplayMetrics().density;
      k = getResources().getDisplayMetrics().densityDpi;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      this.e = true;
      localRect = (Rect)getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
      if (localObject2 == null) {
        break label256;
      }
      localObject3 = ((FriendProfileImageModel.ProfileImageInfo)localObject2).c;
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    }
    for (;;)
    {
      try
      {
        if (((FriendProfileImageModel.ProfileImageInfo)localObject2).h == 6)
        {
          BitmapFactory.decodeFile(((FriendProfileImageModel.ProfileImageInfo)localObject2).d, (BitmapFactory.Options)localObject1);
          m = ImageUtil.a(((BitmapFactory.Options)localObject1).outWidth, 160, k);
          k = ImageUtil.a(((BitmapFactory.Options)localObject1).outHeight, 160, k);
          localObject2 = new Rect(0, 0, m, k);
          localObject3 = ImageUtil.a((Rect)localObject2, (int)getResources().getDimension(2131492908), f1);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = localObject2;
          }
          a(localRect, (Rect)localObject1);
          return;
        }
        BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("qqBaseActivity", 2, localOutOfMemoryError.toString());
        continue;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("qqBaseActivity", 2, localException.toString());
        continue;
      }
      label256:
      k = 0;
      int m = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity
 * JD-Core Version:    0.7.0.1
 */