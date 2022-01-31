package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.galleryactivity.AbstractGalleryPageView;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.GalleryPageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.PreloadGallery;
import com.tencent.mobileqq.activity.photo.PreloadGallery.OnPreloadListener;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UnCompletedCode;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import ebu;
import ebv;
import ebw;
import ebx;
import eby;
import ebz;
import eca;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AIOGalleryScene
  extends AbstractGalleryScene
{
  static final int jdField_a_of_type_Int = 0;
  public static final String a = "AIOGalleryScene";
  View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public AIOGalleryAdapter a;
  public AIOImageListModel a;
  public IAIOImageProvider a;
  public eca a;
  boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 1;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  boolean e;
  private boolean g = false;
  
  public AIOGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.jdField_b_of_type_JavaLangString = ((PeakActivity)paramActivity).a.a();
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
    paramBundle = new Bundle(paramBundle);
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    paramBundle = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, localArrayList, 0, false);
  }
  
  @UnCompletedCode
  private void a(String paramString, int paramInt) {}
  
  private void r()
  {
    AIOImageInfo localAIOImageInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    File localFile = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4);
    if (localFile == null) {
      localFile = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2);
    }
    for (;;)
    {
      if ((localFile == null) && (this.jdField_c_of_type_Boolean)) {
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
      if (localFile != null)
      {
        localActionSheet.c(2131562128);
        localActionSheet.c(2131562777);
        if (this.g) {
          localActionSheet.c(2131562778);
        }
        localActionSheet.c(2131562803);
        localActionSheet.c(2131561606);
      }
      if (!this.jdField_c_of_type_Boolean) {
        localActionSheet.c(2131563176);
      }
      localActionSheet.d(2131561746);
      localActionSheet.a(new ebz(this, localActionSheet, localAIOImageInfo, localFile));
      localActionSheet.show();
      return;
    }
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903599, null);
  }
  
  protected AbstractGalleryPageView a(Context paramContext)
  {
    paramContext = new GalleryPageView();
    paramContext.jdField_a_of_type_Int = 25;
    return paramContext;
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
  }
  
  public void a()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    AIOImageInfo localAIOImageInfo = new AIOImageInfo((AIOImageData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(localAIOImageInfo);
    localAIOImageInfo.jdField_b_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    this.jdField_c_of_type_Boolean = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.g = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    if (this.g)
    {
      this.jdField_c_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
      this.jdField_d_of_type_JavaLangString = localBundle.getString("extra.GROUP_CODE");
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null)) {
        throw new IllegalArgumentException("mGroupUin=" + this.jdField_c_of_type_JavaLangString + ", mGroupCode=" + this.jdField_d_of_type_JavaLangString + ", mMyUin=" + this.jdField_b_of_type_JavaLangString);
      }
    }
    this.jdField_d_of_type_Int = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 0)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      paramInt2 = 0;
      if (paramInt2 < ((List)localObject1).size())
      {
        localObject2 = (AIOImageInfo)((List)localObject1).get(paramInt2);
        if ((((AIOImageInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_Long != paramLong1) || (((AIOImageInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_d_of_type_Int != paramInt1)) {
          break label91;
        }
        ((AIOImageInfo)localObject2).jdField_a_of_type_Int = paramInt3;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramInt3 / 100);
      }
    }
    label91:
    while ((paramInt2 != 4) || (this.jdField_a_of_type_Eca == null) || (this.jdField_a_of_type_Eca.jdField_a_of_type_Long != paramLong1) || (this.jdField_a_of_type_Eca.jdField_a_of_type_Int != paramInt1) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
      for (;;)
      {
        return;
        paramInt2 += 1;
      }
    }
    if ((this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
    if (paramLong2 > 0L)
    {
      localObject1 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)paramLong2);
      localObject2 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)(paramInt3 * paramLong2) / 10000.0F);
      localObject1 = (String)localObject2 + "/" + (String)localObject1;
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt3 / 100 + "%");
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (paramInt2 == 2)
    {
      localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
      if (paramInt3 == 1)
      {
        paramInt1 = localAIOImageListModel.a(paramLong, paramInt1, paramInt2, paramString);
        paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.q();
        paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
        {
          paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt1, paramString);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
        }
      }
    }
    while ((paramInt2 != 4) || (this.jdField_a_of_type_Eca == null) || (this.jdField_a_of_type_Eca.jdField_a_of_type_Long != paramLong) || (this.jdField_a_of_type_Eca.jdField_a_of_type_Int != paramInt1)) {
      for (;;)
      {
        return;
        paramString = "I:E";
      }
    }
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 == 1)
    {
      localAIOImageListModel.a(paramLong, paramInt1, paramInt2, paramString);
      if (paramInt3 != 1) {
        break label318;
      }
      paramString = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4));
      switch (paramString.getStatus())
      {
      }
    }
    for (;;)
    {
      paramString.setTag(Integer.valueOf(1));
      paramString.setURLDrawableListener(this.jdField_a_of_type_Eca);
      paramString.startDownload();
      this.jdField_a_of_type_Eca.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
      return;
      paramString = "I:E";
      break;
      this.jdField_a_of_type_Eca.onLoadSuccessed(paramString);
      return;
      this.jdField_a_of_type_Eca.onLoadFialed(paramString, null);
      return;
      this.jdField_a_of_type_Eca.onLoadCanceled(paramString);
    }
    label318:
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131561436), 0).a();
    c(true);
    a(false);
    this.jdField_a_of_type_Eca = null;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramView == null) {}
    do
    {
      return;
      paramView = (URLDrawable)((ImageView)paramView).getDrawable();
    } while (paramView.getStatus() != 1);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1).jdField_b_of_type_Int = i;
      paramView = new File(paramView.getURL().getFile());
      if (!paramView.exists()) {
        break;
      }
      new eby(this, paramView, paramInt2).execute(new Void[0]);
      return;
      i = 3;
      continue;
      i = 8;
      continue;
      i = 6;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    paramViewGroup = (RelativeLayout)a();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 14.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131563184);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838986);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131361845));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837646);
    this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageButton, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ebu(this));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903602, null);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131232134));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233039));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ebv(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ebw(this));
    if ((PreloadGallery.OnPreloadListener.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter)) && (PreloadGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
      ((PreloadGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter);
    }
  }
  
  public void a(AIOImageInfo paramAIOImageInfo)
  {
    File localFile = paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4);
    if (localFile == null) {
      localFile = paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2);
    }
    for (int i = 0;; i = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(1));
      paramAIOImageInfo = paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
      if (i != 0) {}
      for (i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", paramAIOImageInfo.a(i));
        localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
        paramAIOImageInfo = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        paramAIOImageInfo.putExtras(localBundle);
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramAIOImageInfo, 0);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(false);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void a(AIOImageData[] paramArrayOfAIOImageData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramArrayOfAIOImageData, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == 0)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, 2131562227, 0).show();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (paramInt == this.jdField_a_of_type_ComTencentWidgetGallery.p())
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView.a(this.jdField_a_of_type_ComTencentWidgetGallery, paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(paramInt);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "3", "", "", "");
      r();
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    try
    {
      r();
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
        }
      }
    }
  }
  
  public void a_(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a_(paramAdapterView, paramView, paramInt, paramLong);
    if (AIOGalleryAdapter.GalleryURLImageView.class.isInstance(paramView))
    {
      paramAdapterView = (AIOGalleryAdapter.GalleryURLImageView)paramView;
      paramView = paramAdapterView.getDrawable();
      if ((!paramAdapterView.jdField_b_of_type_Boolean) && (paramView != null) && ((paramView instanceof URLDrawable)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4)))
      {
        c(true);
        return;
      }
    }
    c(false);
  }
  
  public void b()
  {
    o();
    this.e = true;
    AIOImageInfo localAIOImageInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIOImageInfo != null) {
      localAIOImageInfo.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    Looper.myQueue().addIdleHandler(new ebx(this));
  }
  
  public void c()
  {
    this.e = false;
    c(this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((this.jdField_d_of_type_Boolean) && (this.e)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
  }
  
  public void e() {}
  
  public void f()
  {
    super.f();
    if (this.jdField_c_of_type_Int > 0) {
      ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, "" + this.jdField_c_of_type_Int, "", "", "");
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Eca != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(this.jdField_a_of_type_Eca.jdField_a_of_type_Long, this.jdField_a_of_type_Eca.jdField_a_of_type_Int, 4);
      this.jdField_a_of_type_Eca = null;
    }
    c(false);
    a(false);
    super.i();
  }
  
  public void l()
  {
    super.l();
    AIOImageInfo localAIOImageInfo = ((AIOImageListModel)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel).b();
    if (localAIOImageInfo != null) {
      localAIOImageInfo.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void m()
  {
    super.m();
    AIOImageInfo localAIOImageInfo = ((AIOImageListModel)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel).b();
    if (localAIOImageInfo != null) {
      localAIOImageInfo.jdField_a_of_type_Boolean = false;
    }
  }
  
  @TargetApi(11)
  public void o()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b();
  }
  
  void p() {}
  
  public void q()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        n();
        a("Pic_view", 0);
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131562289, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene
 * JD-Core Version:    0.7.0.1
 */