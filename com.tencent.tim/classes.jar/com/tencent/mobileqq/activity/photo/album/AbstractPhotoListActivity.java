package com.tencent.mobileqq.activity.photo.album;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.b;
import com.tencent.widget.TriangleView;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractPhotoListActivity
  extends PeakFragmentActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AbstractAlbumListFragment.IAlbumListChoose
{
  static final int COLUMN_COUNT = 3;
  static final String SHARE_PREFERENCE_NAME = "share";
  public static final String TAG = "PhotoListActivity";
  FrameLayout albumListContainer;
  public AbstractAlbumListFragment albumListFragment;
  public View bottomBar;
  int mEdgePadding;
  public GestureSelectGridView mGridView;
  int mHorizontalSpacing;
  public int mImageHeight;
  public int mImageWidth;
  int mItemPadding;
  GestureSelectGridView.b mOnSelectChangeListener = new AbstractPhotoListActivity.1(this);
  PhotoListBaseData mPhotoListData;
  AdapterView.c mPhotoListItemClickListener = new AbstractPhotoListActivity.2(this);
  PhotoListLogicBase mPhotoListLogic;
  public int mTitleBarHeight;
  int mVerticalSpacing;
  Dialog pd;
  public PhotoListAdapter photoListAdapter = null;
  SharedPreferences pref;
  public Button previewBtn;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> queryPhotoTask;
  public Button sendBtn;
  TriangleView titleImage;
  LinearLayout titleLayout;
  TextView titleLeftBtn;
  TextView titleText;
  
  public static String formatTimeToString(long paramLong)
  {
    paramLong /= 1000L;
    int i = (int)paramLong % 60;
    int j = (int)paramLong / 60;
    String str1;
    if (i > 9)
    {
      str1 = String.valueOf(i);
      if (j <= 9) {
        break label102;
      }
    }
    label102:
    for (String str2 = String.valueOf(j);; str2 = "0" + String.valueOf(j))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2).append(":").append(str1);
      return localStringBuilder.toString();
      str1 = "0" + String.valueOf(i);
      break;
    }
  }
  
  public static void rotate180Degrees(View paramView, boolean paramBoolean)
  {
    float f2 = 180.0F;
    if (paramBoolean) {}
    for (float f1 = 180.0F;; f1 = 0.0F)
    {
      if (paramBoolean) {
        f2 = 360.0F;
      }
      RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(300L);
      localRotateAnimation.setFillAfter(true);
      paramView.startAnimation(localRotateAnimation);
      return;
    }
  }
  
  public void cancleProgressDailog()
  {
    if (this.pd != null) {}
    try
    {
      this.pd.cancel();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
    }
  }
  
  @TargetApi(8)
  File createImageFile()
    throws IOException
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String str = "JPEG_" + (String)localObject + "_";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      while (bool)
      {
        localObject = File.createTempFile(str, ".jpg", (File)localObject);
        this.mPhotoListData.currentPhotoPath = ((File)localObject).getAbsolutePath();
        return localObject;
        File localFile = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject = localFile;
        if (!localFile.exists())
        {
          bool = localFile.mkdirs();
          localObject = localFile;
        }
      }
    }
    return null;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.mPhotoListLogic.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if ((this.albumListFragment == null) || (!this.albumListFragment.isAdded())) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.mPhotoListLogic.onBackPressed();
      return;
    }
    transAlbumList(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onCreate(),extra is:" + paramBundle.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity,hashCode is:" + System.identityHashCode(this));
    }
    getWindow().setBackgroundDrawable(null);
    super.adjustStatusBar();
    try
    {
      super.setContentView(2131561539);
      getWindow().setBackgroundDrawable(null);
      this.mPhotoListLogic = ((PhotoListLogicBase)generateLogic());
      this.mPhotoListData = this.mPhotoListLogic.mPhotoListData;
      this.pref = BaseApplication.getContext().getSharedPreferences("share", 4);
      Resources localResources = getResources();
      int i = localResources.getDisplayMetrics().widthPixels;
      this.mEdgePadding = localResources.getDimensionPixelSize(2131297812);
      this.mHorizontalSpacing = localResources.getDimensionPixelSize(2131297814);
      this.mVerticalSpacing = localResources.getDimensionPixelSize(2131297815);
      this.mItemPadding = QAlbumCommonUtil.dp2px(1.0F, localResources);
      this.mImageWidth = ((i - this.mEdgePadding * 2 - this.mHorizontalSpacing * 2) / 3);
      this.mImageHeight = this.mImageWidth;
      this.mPhotoListLogic.initData(paramBundle);
      initUI();
      return true;
    }
    catch (Throwable paramBundle)
    {
      super.finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mPhotoListLogic.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent.putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onNewIntent() is called,extra is:" + paramIntent.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivityhashCode is:" + System.identityHashCode(this));
    }
    QLog.d("PhotoListActivity", 2, "onNewIntent()");
    processNewIntent(paramIntent);
    if (this.mPhotoListLogic.mPhotoCommonData.albumName != null) {
      paramIntent = this.mPhotoListLogic.mPhotoCommonData.albumName;
    }
    for (;;)
    {
      setTitle(paramIntent);
      return;
      if (this.mPhotoListData.showMediaType == 2) {
        paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.queryPhotoTask = null;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mPhotoListLogic.doOnResume();
  }
  
  public void excuteQueryPhotoTask()
  {
    this.queryPhotoTask = new QueryPhotoTask();
    this.queryPhotoTask.execute(new Object[0]);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  protected abstract PhotoListLogic generateLogic();
  
  public abstract AbstractAlbumListFragment getAlbumListFragment();
  
  protected Dialog getDialog()
  {
    return new ReportDialog(this);
  }
  
  public abstract Class getJumpActivity();
  
  protected void initUI()
  {
    this.albumListContainer = ((FrameLayout)findViewById(2131362594));
    this.titleLeftBtn = ((TextView)findViewById(2131369579));
    this.titleLeftBtn.setVisibility(0);
    this.titleLeftBtn.setOnClickListener(this);
    this.titleText = ((TextView)findViewById(2131369627));
    String str;
    if (this.mPhotoListLogic.mPhotoCommonData.albumName != null) {
      str = this.mPhotoListLogic.mPhotoCommonData.albumName;
    }
    for (;;)
    {
      setTitle(str);
      this.titleImage = ((TriangleView)findViewById(2131369624));
      this.titleImage.setColor(this.titleText.getCurrentTextColor());
      this.titleLayout = ((LinearLayout)findViewById(2131369572));
      this.titleLayout.setOnClickListener(this);
      this.previewBtn = ((Button)findViewById(2131373570));
      this.sendBtn = ((Button)findViewById(2131377990));
      this.bottomBar = findViewById(2131379990);
      this.mGridView = ((GestureSelectGridView)findViewById(2131373136));
      this.mGridView.setScrollBarStyle(0);
      this.mGridView.setNumColumns(3);
      this.mGridView.setColumnWidth(this.mImageWidth);
      this.mGridView.setHorizontalSpacing(this.mHorizontalSpacing);
      this.mGridView.setVerticalSpacing(this.mVerticalSpacing);
      this.mGridView.setPadding(this.mEdgePadding, this.mGridView.getPaddingTop(), this.mEdgePadding, this.mGridView.getPaddingBottom());
      this.mGridView.setOnItemClickListener(this.mPhotoListItemClickListener);
      this.mGridView.setOnIndexChangedListener(this.mOnSelectChangeListener);
      this.mGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
      this.photoListAdapter = new PhotoListAdapter();
      this.mGridView.setAdapter(this.photoListAdapter);
      this.mPhotoListLogic.postInitUI();
      return;
      if (this.mPhotoListData.showMediaType == 2) {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
    }
  }
  
  public boolean isGif(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAlbumListChoose(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mPhotoListLogic.mPhotoCommonData.albumName == null) {
        break label59;
      }
    }
    label59:
    for (paramQQAlbumInfo = this.mPhotoListLogic.mPhotoCommonData.albumName;; paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      setTitle(paramQQAlbumInfo);
      this.mPhotoListData.firstResume = true;
      runOnUiThread(new AbstractPhotoListActivity.3(this));
      transAlbumList(false);
      return;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131375366) {
      this.mPhotoListLogic.onQualityBtnClick(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369579) {
      this.mPhotoListLogic.onTitleBtnCancelClick(paramView);
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (i == 2131373570)
        {
          this.mPhotoListLogic.onPreviewBtnClick(paramView);
        }
        else
        {
          if (i != 2131377990) {
            break;
          }
          this.mPhotoListLogic.onSendBtnClick(paramView);
        }
      }
    } while (i != 2131369572);
    if ((this.albumListFragment == null) || (!this.albumListFragment.isAdded())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPhotoListLogic.enterAlbumListFragment(getIntent());
      }
      transAlbumList(bool);
      break;
    }
  }
  
  void processNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    this.mPhotoListLogic.initData(paramIntent);
  }
  
  public void recordLastPos(String paramString)
  {
    if (this.mPhotoListData.isRecodeLastAlbumPath)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.mPhotoListLogic.mPhotoCommonData.albumId, Integer.valueOf(this.photoListAdapter.getCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        QAlbumUtil.sLastAlbumPath = paramString;
        HashMap localHashMap = QAlbumUtil.sSelectItemAlbum;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          QAlbumUtil.sLastAlbumId = (String)paramString.first;
          QAlbumUtil.sLastAlbumName = (String)paramString.second;
          QAlbumUtil.putLastAlbumInfo(this, QAlbumUtil.sLastAlbumId, QAlbumUtil.sLastAlbumName);
        }
      }
    }
    QAlbumUtil.clearSelectItemInfo();
  }
  
  public void selectLimitRemind(boolean paramBoolean)
  {
    int i = this.mPhotoListLogic.mPhotoCommonData.selectedPhotoList.size();
    int j;
    if (((i == this.mPhotoListLogic.mPhotoCommonData.maxSelectNum) && (!paramBoolean)) || ((i == this.mPhotoListLogic.mPhotoCommonData.maxSelectNum - 1) && (paramBoolean)))
    {
      i = 1;
      if (i == 0) {
        return;
      }
      j = this.mGridView.getFirstVisiblePosition();
      int k = this.mGridView.getLastVisiblePosition();
      i = j;
      label77:
      if (i > k) {
        return;
      }
      if (this.photoListAdapter.getItemViewType(i) != 2) {
        break label107;
      }
    }
    for (;;)
    {
      i += 1;
      break label77;
      i = 0;
      break;
      label107:
      Object localObject = this.mGridView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.photoListAdapter.getItem(i);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      else if (localLocalMediaInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
        }
      }
      else
      {
        localObject = (AbstractPhotoListActivity.PhotoListAdapter.Holder)((View)localObject).getTag();
        if ((paramBoolean) || (localLocalMediaInfo.selectStatus == 1)) {
          ((AbstractPhotoListActivity.PhotoListAdapter.Holder)localObject).mImageView.setAlpha(1.0F);
        } else {
          ((AbstractPhotoListActivity.PhotoListAdapter.Holder)localObject).mImageView.setAlpha(0.3F);
        }
      }
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.titleText.setText(paramCharSequence);
  }
  
  public void showProgressDialog()
  {
    try
    {
      if (this.pd != null) {
        cancleProgressDailog();
      }
      while (!this.pd.isShowing())
      {
        this.pd.show();
        return;
        this.pd = getDialog();
        this.pd.setCancelable(true);
        this.pd.show();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "show dialog error", localException);
      }
      this.pd = null;
    }
  }
  
  public void transAlbumList(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction;
    ObjectAnimator localObjectAnimator;
    if (this.albumListFragment == null)
    {
      if (paramBoolean) {
        this.albumListFragment = getAlbumListFragment();
      }
    }
    else
    {
      localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setTransition(4097);
      if ((!paramBoolean) || (this.albumListFragment.isAdded())) {
        break label158;
      }
      localObjectAnimator = ObjectAnimator.ofInt(this.albumListContainer, "backgroundColor", new int[] { getResources().getColor(2131165626), getResources().getColor(2131165637) });
      rotate180Degrees(this.titleImage, false);
      localFragmentTransaction.add(2131362594, this.albumListFragment, null);
    }
    for (;;)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.commit();
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.start();
      this.mPhotoListLogic.onAlbumListShown(paramBoolean);
      return;
      label158:
      localObjectAnimator = ObjectAnimator.ofInt(this.albumListContainer, "backgroundColor", new int[] { getResources().getColor(2131165637), getResources().getColor(2131165626) });
      rotate180Degrees(this.titleImage, true);
      localFragmentTransaction.remove(this.albumListFragment);
    }
  }
  
  public void updateCheckbox(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.mPhotoListLogic.mPhotoCommonData.selectedPhotoList;
    int j = this.mGridView.getFirstVisiblePosition();
    int k = this.mGridView.getLastVisiblePosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      label372:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = this.mGridView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.photoListAdapter.getItem(i);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m;
          AbstractPhotoListActivity.PhotoListAdapter.Holder localHolder;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localHolder = (AbstractPhotoListActivity.PhotoListAdapter.Holder)((View)localObject).getTag();
              if ((localHolder != null) && (localHolder.mCheckBox != null)) {
                localHolder.mCheckBox.setCheckedNumber(m + 1);
              }
            }
          }
          else
          {
            m = QAlbumUtil.getMediaType(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localHolder = (AbstractPhotoListActivity.PhotoListAdapter.Holder)((View)localObject).getTag();
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                localHolder.mCheckBox.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.enableTalkBack) {
                  break label372;
                }
                localObject = QAlbumUtil.createContentDescriptionWithCheckBox(m, localLocalMediaInfo, i, localHolder.mCheckBox.isChecked());
                localHolder.mCheckBox.setContentDescription((CharSequence)localObject);
                break;
                if (n == 3)
                {
                  localHolder.mCheckBox.setChecked(false);
                }
                else
                {
                  localHolder.mCheckBox.setChecked(false);
                  if (((View)localObject).getBackground() != null) {
                    ((View)localObject).setBackgroundDrawable(null);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void updateCheckboxForDelete()
  {
    int j = this.mGridView.getFirstVisiblePosition();
    int k = this.mGridView.getLastVisiblePosition();
    int i = j;
    if (i <= k)
    {
      Object localObject = this.mGridView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.photoListAdapter.getItem(i);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m = this.mPhotoListLogic.mPhotoCommonData.selectedPhotoList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            localObject = (AbstractPhotoListActivity.PhotoListAdapter.Holder)((View)localObject).getTag();
            if ((localObject != null) && (((AbstractPhotoListActivity.PhotoListAdapter.Holder)localObject).mCheckBox != null)) {
              ((AbstractPhotoListActivity.PhotoListAdapter.Holder)localObject).mCheckBox.setCheckedNumber(m + 1);
            }
          }
        }
      }
    }
  }
  
  public class CheckBoxClickedListener
    implements View.OnClickListener
  {
    CheckBox mCheckBox;
    int mPosition;
    
    public CheckBoxClickedListener() {}
    
    public void onClick(View paramView)
    {
      if (AbstractPhotoListActivity.this.mPhotoListLogic != null) {
        AbstractPhotoListActivity.this.mPhotoListLogic.onCheckBoxClick(paramView, this.mPosition, this.mCheckBox);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public void setCheckBox(CheckBox paramCheckBox)
    {
      this.mCheckBox = paramCheckBox;
    }
    
    public void setPosition(int paramInt)
    {
      this.mPosition = paramInt;
    }
  }
  
  public class PhotoListAdapter
    extends BaseAdapter
    implements URLDrawableDownListener
  {
    static final String REPORT_OLD_TAG = "AlbumThumbCostOld";
    static final String REPORT_TAG = "AlbumThumbCost";
    ColorDrawable colorDrawable = new ColorDrawable(570425344);
    public ArrayList<LocalMediaInfo> mAllImages = new ArrayList();
    Drawable mDefaultPhotoDrawable = this.mResources.getDrawable(2130848704);
    public LayoutInflater mInflater = AbstractPhotoListActivity.this.getLayoutInflater();
    Resources mResources = AbstractPhotoListActivity.this.getResources();
    
    public PhotoListAdapter() {}
    
    public int getCount()
    {
      return this.mAllImages.size();
    }
    
    public LocalMediaInfo getItem(int paramInt)
    {
      return (LocalMediaInfo)this.mAllImages.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      return QAlbumUtil.getMediaType((LocalMediaInfo)this.mAllImages.get(paramInt));
    }
    
    public List<LocalMediaInfo> getPhotoList()
    {
      return this.mAllImages;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AbstractPhotoListActivity.CheckBoxClickedListener localCheckBoxClickedListener = new AbstractPhotoListActivity.CheckBoxClickedListener(AbstractPhotoListActivity.this);
      Object localObject;
      if (paramView == null)
      {
        localObject = new Holder();
        switch (getItemViewType(paramInt))
        {
        default: 
          label60:
          localObject = paramView;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
        localObject = (Holder)paramView.getTag();
        break;
        if (AbstractPhotoListActivity.this.mPhotoListLogic == null) {
          break label60;
        }
        localObject = AbstractPhotoListActivity.this.mPhotoListLogic.getViewCaseImage(paramInt, paramView, paramViewGroup, (Holder)localObject, localCheckBoxClickedListener);
        continue;
        if (AbstractPhotoListActivity.this.mPhotoListLogic == null) {
          break label60;
        }
        localObject = AbstractPhotoListActivity.this.mPhotoListLogic.getViewCaseVideo(paramInt, paramView, paramViewGroup, (Holder)localObject, localCheckBoxClickedListener);
        continue;
        if (AbstractPhotoListActivity.this.mPhotoListLogic == null) {
          break label60;
        }
        localObject = AbstractPhotoListActivity.this.mPhotoListLogic.getViewCaseCamera(paramInt, paramView, paramViewGroup);
      }
    }
    
    public int getViewTypeCount()
    {
      return QAlbumUtil.MEDIA_TYPE_MAPS.size();
    }
    
    public TextView newImageTypeView()
    {
      TextView localTextView = new TextView(AbstractPhotoListActivity.this);
      localTextView.setGravity(17);
      localTextView.setTextSize(10.0F);
      localTextView.setTextColor(-1);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0F, AbstractPhotoListActivity.this.getResources()), QAlbumCommonUtil.dp2px(18.0F, AbstractPhotoListActivity.this.getResources()));
      localGradientDrawable.setCornerRadii(new float[] { QAlbumCommonUtil.dp2px(2.0F, AbstractPhotoListActivity.this.getResources()), QAlbumCommonUtil.dp2px(2.0F, AbstractPhotoListActivity.this.getResources()), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      localGradientDrawable.setColor(1291845632);
      localTextView.setBackgroundDrawable(localGradientDrawable);
      return localTextView;
    }
    
    public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
    
    public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
    
    public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
    
    public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
    {
      new Rect();
      paramView = (LocalMediaInfo)paramURLDrawable.getTag();
      int i = paramView.listViewPosition;
      if ((i == -1) || (paramView.visableTime == 0L)) {}
      long l1;
      long l2;
      do
      {
        return;
        l1 = SystemClock.uptimeMillis();
        l2 = paramView.visableTime;
      } while (!QLog.isColorLevel());
      QLog.d("PhotoListActivity", 2, "onLoadSuccessed,no next ,listViewPositon:" + i + " costTime:" + (l1 - l2) + " imageInfo;" + paramView);
    }
    
    public void setPhotoList(List<LocalMediaInfo> paramList)
    {
      this.mAllImages.clear();
      if ((paramList == null) || (paramList.size() == 0)) {
        return;
      }
      if ((!AbstractPhotoListActivity.this.mPhotoListData.isShowCamera) && (QAlbumUtil.getMediaType((LocalMediaInfo)paramList.get(0)) == 2)) {
        paramList.remove(0);
      }
      this.mAllImages.addAll(paramList);
    }
    
    public class Holder
    {
      AbstractPhotoListActivity.CheckBoxClickedListener checkBoxListener;
      public NumberCheckBox mCheckBox;
      URLDrawable mDrawable;
      TextView mImageType;
      ImageView mImageView;
      public ImageView mImageViewPanoramaIcon;
      ImageView mMaskView;
      public ImageView mPhotoFlagView;
      View mSelectedBtn;
      ImageView mSelectedIconView;
      TextView mTextView;
      
      public Holder() {}
    }
  }
  
  public class QueryPhotoTask
    extends AsyncTask<Object, Object, List<LocalMediaInfo>>
  {
    private WeakReference<PhotoListLogicBase> mLogicForQueryTask;
    
    public QueryPhotoTask() {}
    
    protected List<LocalMediaInfo> doInBackground(Object... paramVarArgs)
    {
      paramVarArgs = (PhotoListLogicBase)this.mLogicForQueryTask.get();
      if (paramVarArgs == null) {
        paramVarArgs = null;
      }
      List localList;
      do
      {
        return paramVarArgs;
        localList = paramVarArgs.queryPhotoList();
        paramVarArgs = localList;
      } while (!QLog.isColorLevel());
      QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + localList.size());
      return localList;
    }
    
    protected void onPostExecute(List<LocalMediaInfo> paramList)
    {
      PhotoListLogic localPhotoListLogic = (PhotoListLogic)this.mLogicForQueryTask.get();
      if (localPhotoListLogic == null) {
        return;
      }
      localPhotoListLogic.onQueryPhoto(paramList);
      AbstractPhotoListActivity.this.cancleProgressDailog();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      this.mLogicForQueryTask = new WeakReference(AbstractPhotoListActivity.this.mPhotoListLogic);
      AbstractPhotoListActivity.this.showProgressDialog();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity
 * JD-Core Version:    0.7.0.1
 */