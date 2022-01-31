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
import com.tencent.mobileqq.statistics.ReportController;
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
import ejw;
import ejx;
import ejy;
import ejz;
import ekb;
import ekc;
import ekd;
import eke;
import ekf;
import ekg;
import ekh;
import eki;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TroopAvatarWallPreviewActivity
  extends BaseActivity
{
  static Object a;
  public static final String a = "curType";
  public static final String b = "url";
  public static final String c = "_id";
  public static final String d = "friendUin";
  public static final String e = "requestTypeKey";
  static boolean e = false;
  public static final String f = "faceid";
  public static final String g = "index";
  public static final String h = "KEY_THUMBNAL_BOUND";
  public static final String i = "default_avator_index";
  public int a;
  protected long a;
  protected View.OnClickListener a;
  protected View a;
  protected FrameLayout a;
  protected ImageButton a;
  protected RelativeLayout a;
  public TextView a;
  public TroopAvatarBigPhotoAdapter a;
  public ImageAnimationView a;
  public Gallery a;
  protected ArrayList a;
  protected List a;
  public boolean a;
  public int b;
  protected List b;
  protected boolean b;
  public boolean c;
  protected boolean d;
  public boolean f = false;
  public String j;
  protected String k;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public TroopAvatarWallPreviewActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 300L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ejz(this);
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
    int i3;
    int i4;
    int m;
    label170:
    int n;
    label181:
    int i2;
    label245:
    int i1;
    if (paramDrawable == null)
    {
      if ((TextUtils.isEmpty(str)) && (str.equals("-5"))) {
        return null;
      }
      paramDrawable = a(paramBoolean, str);
      ((URLDrawable)paramDrawable).setAutoDownload(true);
      i3 = this.jdField_a_of_type_ComTencentWidgetGallery.getWidth();
      i4 = this.jdField_a_of_type_ComTencentWidgetGallery.getHeight();
      if (((Drawable)localObject).getIntrinsicWidth() != 0) {
        break label414;
      }
      m = 1;
      if (((Drawable)localObject).getIntrinsicHeight() != 0) {
        break label424;
      }
      n = 1;
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
      i2 = 1;
      if (paramDrawable.getIntrinsicHeight() != 0) {
        break label444;
      }
      i1 = 1;
    }
    for (;;)
    {
      float f1 = ImagePreviewAnimationUtil.a(i2, i1);
      paramRect1.set(ImagePreviewAnimationUtil.a(m, n, i2, i1));
      paramRect2.set(ImagePreviewAnimationUtil.b(i2, i1, i3, i4));
      paramRect4.set(ImagePreviewAnimationUtil.c(i2, i1, i3, i4));
      ImagePreviewAnimationUtil.a(paramRect1, f1);
      ImagePreviewAnimationUtil.a(paramRect2, f1);
      m = (int)(i2 * f1);
      n = (int)(i1 * f1);
      try
      {
        paramRect3 = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_4444);
        paramRect4 = new Canvas(paramRect3);
        localObject = new Rect(0, 0, i2, i1);
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
      m = ((Drawable)localObject).getIntrinsicWidth();
      break label170;
      label424:
      n = ((Drawable)localObject).getIntrinsicHeight();
      break label181;
      label434:
      i2 = paramDrawable.getIntrinsicWidth();
      break label245;
      label444:
      i1 = paramDrawable.getIntrinsicHeight();
      continue;
      label454:
      i1 = n;
      i2 = m;
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
    new ekg(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private boolean c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.a();
    if (localObject1 == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    Object localObject2 = ((ImageView)((View)localObject1).findViewById(2131296283)).getDrawable();
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
    this.f = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a((Bitmap)localObject2, localRect3, localRect2, localRect1, (Rect)localObject1, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setAnimationListener(new ekh(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new eki(this), this.jdField_a_of_type_Long);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setInterpolator(new DecelerateInterpolator());
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    return true;
  }
  
  private void e()
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
        localObject = ((ImageView)((View)localObject).findViewById(2131296283)).getDrawable();
      } while ((localObject == null) || (!(localObject instanceof URLDrawable)));
      localObject = (URLDrawable)localObject;
    } while (((URLDrawable)localObject).getStatus() != 1);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (this.c)
    {
      localActionSheet.a(2131363941, 1);
      localActionSheet.a(2131363945, 1);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localActionSheet.a(2131362531, 5);
      localActionSheet.a(2131363947, 3);
    }
    localActionSheet.d(2131362790);
    localActionSheet.a(new ekd(this, (URLDrawable)localObject, localActionSheet));
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
      this.jdField_b_of_type_JavaUtilList.add("" + paramInt);
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        getIntent().putStringArrayListExtra("del_list", (ArrayList)this.jdField_b_of_type_JavaUtilList);
        setResult(-1, getIntent());
      }
      finish();
      return;
    }
    QQToast.a(this, getString(2131362521), 1).b(getTitleBarHeight());
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (this.k != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.k, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.au).mkdirs();
      str = AppConstants.au + this.j + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          QQToast.a(this, getString(2131363440), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131363442)).setMessage(getString(2131363444)).setPositiveButton(getString(2131363443), new ekf(this, paramURLDrawable, str)).setNegativeButton(getString(2131362787), new eke(this)).show();
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.k != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.k, "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    Object localObject = new File(AppConstants.aR);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    String str = AppConstants.aR + this.j + Utils.Crc64String(paramURLDrawable.getURL().toString());
    localObject = str;
    if (!new File(str).exists()) {}
    try
    {
      localObject = paramURLDrawable.saveTo(str);
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
    catch (IOException localIOException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.e("foward", 2, "IOException", localIOException);
          localObject = str;
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
  
  public void c()
  {
    if ((!this.f) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentWidgetGallery.a() != this.jdField_a_of_type_Int)) {
        break label53;
      }
      if (!c()) {
        d();
      }
    }
    return;
    label53:
    d();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.f = true;
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
    localAnimationSet.setAnimationListener(new ejx(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.postDelayed(new ejy(this), 500L);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
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
    c();
  }
  
  protected void onCreate(Bundle arg1)
  {
    super.onCreate(???);
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (e)
        {
          super.finish();
          return;
        }
        e = true;
        setContentView(2130903211);
        ??? = getIntent().getExtras();
        this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131297187));
        this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296993));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296564));
        this.jdField_a_of_type_AndroidViewView = findViewById(2131296445);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297186));
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131296440));
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView = ((ImageAnimationView)findViewById(2131297188));
        ((ImageView)findViewById(2131297189)).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_Boolean = ???.getBoolean("IS_EDIT");
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_JavaUtilArrayList = ???.getParcelableArrayList("KEY_THUMBNAL_BOUND");
          this.c = ???.getBoolean("is_show_action", true);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter = new TroopAvatarBigPhotoAdapter(this, this.app);
          this.j = ???.getString("troop_uin");
          this.jdField_a_of_type_Boolean = ???.getBoolean("troop_info_is_member");
          this.jdField_a_of_type_JavaUtilList = ???.getStringArrayList("seqNum");
          this.d = ???.getBoolean("is_not_show_index", true);
          this.k = ???.getString("src_id");
          if (this.k != null) {
            ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer", "open", 0, 0, this.k, "", "", "");
          }
          if (this.jdField_a_of_type_JavaUtilList != null) {
            this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
          }
          if (!this.d) {
            break label540;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.j);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(???.getBoolean("is_use_path", false));
          this.jdField_a_of_type_Int = ???.getInt("index", -1);
          this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter);
          this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131492924));
          this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new ejw(this));
          this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new ekb(this));
          this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new ekc(this));
          return;
        }
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      continue;
      label540:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected void onDestroy()
  {
    System.gc();
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a();
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      e = false;
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      e();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */