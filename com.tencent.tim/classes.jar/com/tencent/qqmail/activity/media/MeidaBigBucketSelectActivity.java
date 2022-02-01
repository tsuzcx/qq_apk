package com.tencent.qqmail.activity.media;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.FullWindowHelper;
import java.io.File;
import java.util.List;
import java.util.Map;

public class MeidaBigBucketSelectActivity
  extends BaseActivityEx
{
  private static final String ARG_BUCKET_NAME = "arg_mediabucketselectactivity_bucketname";
  private static final String ARG_BUCKET_SELECTED_POSITION = "arg_bigbucketselectactivity_selected_position";
  private static final String ARG_MAX_SELECTED_NUM = "arg_max_selected_num";
  private static final String ARG_TYPE = "arg_bigbucketselect_type";
  public static final String RESULT_CURRENT_POSITION = "result_bigbucketselectactivity_current_position";
  public static final String TAG = "MeidaBigBucketSelectActivity";
  private static QMMediaBottom sFloatedBottom = null;
  private Animation anim_bar_gone;
  private Animation anim_bar_visiable;
  private String bucketName;
  private int currentPos = 0;
  private QMUIDialog dialog;
  private QMMediaBottom floatedBottom = null;
  private Animation foot_bar_gone;
  private Animation foot_bar_visible;
  private QMAlbumManager.QMMediaIntentType intentType = QMAlbumManager.QMMediaIntentType.QMMediaIntentType_NORMAIL;
  private boolean isFirstInViewPager = false;
  private boolean isHideBar = false;
  private Button mAddToMailBtn = null;
  private ViewPager mImageViewPager;
  private QMMediaBottom mMediaBottom = null;
  private View mMediaBucketBottom = null;
  private View mMediaBucketTop = null;
  private int maxSelectedNum;
  private List<MediaItemInfo> mediaInfos;
  private View root;
  private int topbarHeight = 0;
  
  private void adjustImageToFillLayout()
  {
    int i = QMUIKit.getStatusBarHeight(this);
    if (VersionUtils.hasLolipop())
    {
      StatusBarUtil.layoutUnderStatusBar(this, StatusBarUtil.BLACK_COLOR);
      localLayoutParams = (FrameLayout.LayoutParams)this.mMediaBucketTop.getLayoutParams();
      j = QMUIKit.getStatusBarHeight(this);
      if (this.topbarHeight == 0)
      {
        localLayoutParams.height = (j + localLayoutParams.height);
        this.topbarHeight = localLayoutParams.height;
        this.mMediaBucketTop.setLayoutParams(localLayoutParams);
        this.mMediaBucketTop.setPadding(this.mMediaBucketTop.getPaddingLeft(), i, this.mMediaBucketTop.getPaddingRight(), this.mMediaBucketTop.getPaddingBottom());
      }
    }
    while ((!VersionUtils.hasKitKat()) || (this.mImageViewPager == null)) {
      for (;;)
      {
        FrameLayout.LayoutParams localLayoutParams;
        int j;
        return;
        localLayoutParams.height = this.topbarHeight;
      }
    }
    this.mImageViewPager.setPadding(this.mImageViewPager.getPaddingLeft(), -i, this.mImageViewPager.getPaddingRight(), this.mImageViewPager.getPaddingBottom());
  }
  
  private void autoHideOrShowBar()
  {
    if (!this.isHideBar)
    {
      FullWindowHelper.changeToFullScreen(getWindow(), this);
      if ((this.mImageViewPager != null) && (VersionUtils.isKitKat())) {
        this.mImageViewPager.setPadding(this.mImageViewPager.getPaddingLeft(), 0, this.mImageViewPager.getPaddingRight(), this.mImageViewPager.getPaddingBottom());
      }
      if (this.mMediaBucketTop != null)
      {
        this.mMediaBucketTop.setVisibility(8);
        this.mMediaBucketTop.startAnimation(this.anim_bar_gone);
      }
      if (this.mMediaBucketBottom != null)
      {
        this.mMediaBucketBottom.setVisibility(8);
        this.mMediaBucketBottom.startAnimation(this.foot_bar_gone);
      }
      ((CheckBox)findViewById(2131363423)).setVisibility(8);
      if (this.isHideBar) {
        break label220;
      }
    }
    label220:
    for (boolean bool = true;; bool = false)
    {
      this.isHideBar = bool;
      return;
      FullWindowHelper.changeToNotFullScreen(getWindow(), this);
      adjustImageToFillLayout();
      if (this.mMediaBucketTop != null)
      {
        this.mMediaBucketTop.setVisibility(0);
        this.mMediaBucketTop.startAnimation(this.anim_bar_visiable);
      }
      if (this.mMediaBucketBottom != null)
      {
        this.mMediaBucketBottom.setVisibility(0);
        this.mMediaBucketBottom.startAnimation(this.foot_bar_visible);
      }
      ((CheckBox)findViewById(2131363423)).setVisibility(0);
      break;
    }
  }
  
  public static Intent createIntent(QMAlbumManager.QMMediaIntentType paramQMMediaIntentType, String paramString, int paramInt1, QMMediaBottom paramQMMediaBottom, int paramInt2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MeidaBigBucketSelectActivity.class);
    localIntent.putExtra("arg_bigbucketselect_type", paramQMMediaIntentType.toString());
    localIntent.putExtra("arg_mediabucketselectactivity_bucketname", paramString);
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    localIntent.putExtra("arg_bigbucketselectactivity_selected_position", i);
    localIntent.putExtra("arg_max_selected_num", paramInt2);
    sFloatedBottom = paramQMMediaBottom;
    return localIntent;
  }
  
  private void finishWithResult(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
    if (paramInt == 2)
    {
      paramInt = MediaData.getSelectedInfoList().size();
      if (this.floatedBottom != null)
      {
        this.floatedBottom.updateAddButton(this.intentType, paramInt);
        this.floatedBottom.showAndAutoHide();
      }
    }
  }
  
  private boolean[] getSelectedImage()
  {
    List localList = MediaData.getSelectedInfoList();
    if (localList != null)
    {
      boolean[] arrayOfBoolean = new boolean[this.mediaInfos.size()];
      int i = 0;
      if (i < localList.size())
      {
        MediaItemInfo localMediaItemInfo = (MediaItemInfo)localList.get(i);
        int j = this.mediaInfos.indexOf(localMediaItemInfo);
        if ((j < 0) || (j >= this.mediaInfos.size())) {}
        for (;;)
        {
          i += 1;
          break;
          arrayOfBoolean[j] = true;
        }
      }
      return arrayOfBoolean;
    }
    return new boolean[0];
  }
  
  private void handleBack()
  {
    recycle();
    Intent localIntent = new Intent();
    if (this.mImageViewPager != null) {}
    for (int i = this.mImageViewPager.getCurrentItem();; i = 0)
    {
      localIntent.putExtra("result_bigbucketselectactivity_current_position", i);
      finishWithResult(2, localIntent);
      overridePendingTransition(2130772421, 2130772420);
      return;
    }
  }
  
  private void initAddBottomView()
  {
    this.mAddToMailBtn = ((Button)findViewById(2131363771));
    this.mAddToMailBtn.setOnClickListener(new MeidaBigBucketSelectActivity.6(this));
    this.mMediaBottom = ((QMMediaBottom)findViewById(2131371209));
    this.mMediaBottom.init(this);
  }
  
  private void initAnimation()
  {
    this.isFirstInViewPager = true;
    this.foot_bar_gone = AnimationUtils.loadAnimation(this, 2130772086);
    this.foot_bar_visible = AnimationUtils.loadAnimation(this, 2130772087);
    this.anim_bar_gone = AnimationUtils.loadAnimation(getActivity(), 2130772037);
    this.anim_bar_visiable = AnimationUtils.loadAnimation(getActivity(), 2130772038);
  }
  
  private void initImageViewPager()
  {
    if ((this.mediaInfos != null) && (this.mediaInfos.size() > 0))
    {
      this.mImageViewPager = ((ViewPager)findViewById(2131368921));
      this.mImageViewPager.setPageMargin((int)getResources().getDimension(2131297468));
      this.mImageViewPager.setOffscreenPageLimit(2);
      ImagePagerAdapter localImagePagerAdapter = new ImagePagerAdapter(this, 0, new MeidaBigBucketSelectActivity.2(this), new MeidaBigBucketSelectActivity.3(this), null);
      this.mImageViewPager.setAdapter(localImagePagerAdapter);
      localImagePagerAdapter.change(this.mediaInfos, getSelectedImage());
      this.mImageViewPager.setOnPageChangeListener(new MeidaBigBucketSelectActivity.4(this));
      CheckBox localCheckBox = (CheckBox)findViewById(2131363423);
      localCheckBox.setOnClickListener(new MeidaBigBucketSelectActivity.5(this, localCheckBox, localImagePagerAdapter));
      int i = getIntent().getIntExtra("arg_bigbucketselectactivity_selected_position", 0);
      this.mImageViewPager.setCurrentItem(i);
      checkMediaType(((MediaItemInfo)this.mediaInfos.get(this.currentPos)).getDataPath());
      updateCheckbox(i);
    }
  }
  
  private void initTopbar()
  {
    TextView localTextView = (TextView)findViewById(2131363794);
    localTextView.setText(this.bucketName);
    Drawable localDrawable = getResources().getDrawable(2130850502);
    localDrawable.setBounds(0, 0, QMUIKit.dpToPx(12), QMUIKit.dpToPx(24));
    localTextView.setCompoundDrawables(localDrawable, null, null, null);
    localTextView.setOnClickListener(new MeidaBigBucketSelectActivity.7(this));
  }
  
  private void recycle()
  {
    this.mediaInfos = null;
  }
  
  @TargetApi(11)
  public static final void setStatusBarTransparent(boolean paramBoolean, Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow();
    switch (1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramActivity == null) || (paramActivity.getDecorView() == null));
      if (!paramBoolean) {
        break;
      }
    } while (0 == 0);
    paramActivity.getDecorView().setSystemUiVisibility(4);
    return;
    paramActivity.getDecorView().setSystemUiVisibility(0);
  }
  
  private void updateAddButton()
  {
    int i = MediaData.getSelectedInfoList().size();
    String str = QMMediaBottom.getAddStringByIntentType(this.intentType);
    if (i == 0)
    {
      this.mAddToMailBtn.setEnabled(true);
      this.mAddToMailBtn.setText(str);
    }
    do
    {
      return;
      if (i > 30)
      {
        this.mAddToMailBtn.setEnabled(false);
        this.mAddToMailBtn.setText(str + "(" + i + ")");
        return;
      }
    } while (i <= 0);
    this.mAddToMailBtn.setEnabled(true);
    this.mAddToMailBtn.setText(str + "(" + i + ")");
  }
  
  private void updateCheckbox(int paramInt)
  {
    if (this.mImageViewPager != null)
    {
      ImagePagerAdapter localImagePagerAdapter = (ImagePagerAdapter)this.mImageViewPager.getAdapter();
      ((CheckBox)findViewById(2131363423)).setChecked(localImagePagerAdapter.getSelectedArray()[paramInt]);
    }
  }
  
  public void checkMediaType(String paramString)
  {
    FileUtil.getFileType(paramString);
  }
  
  public void initDataSource()
  {
    this.intentType = QMAlbumManager.QMMediaIntentType.valueOf(getIntent().getStringExtra("arg_bigbucketselect_type"));
    this.bucketName = getIntent().getStringExtra("arg_mediabucketselectactivity_bucketname");
    this.mediaInfos = ((List)MediaData.getBuckets().get(this.bucketName));
    this.maxSelectedNum = getIntent().getIntExtra("arg_max_selected_num", -1);
    this.floatedBottom = sFloatedBottom;
    sFloatedBottom = null;
  }
  
  public void initDom()
  {
    initTopbar();
    initAddBottomView();
    initAnimation();
    initImageViewPager();
    adjustImageToFillLayout();
  }
  
  public void initUI()
  {
    setContentView(2131558496);
    this.root = findViewById(2131363424);
    this.mMediaBucketTop = findViewById(2131371211);
    MeidaBigBucketSelectActivity.1 local1 = new MeidaBigBucketSelectActivity.1(this);
    this.mMediaBucketBottom = findViewById(2131371210);
    this.mMediaBucketTop.setOnTouchListener(local1);
    this.mMediaBucketBottom.setOnTouchListener(local1);
    StatusBarUtil.immerseBlack(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    MediaItemInfo localMediaItemInfo1;
    MediaItemInfo localMediaItemInfo2;
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("EXTRA_RESULT_PATH");
      ((CheckBox)findViewById(2131363423)).setChecked(false);
      localMediaItemInfo1 = (MediaItemInfo)this.mediaInfos.get(this.currentPos);
      MediaData.selectItem(localMediaItemInfo1, false);
      localMediaItemInfo2 = new MediaItemInfo();
      File localFile = new File(paramIntent);
      localMediaItemInfo2.setDataPath(paramIntent);
      localMediaItemInfo2.setFileName(localFile.getName());
      localMediaItemInfo2.setFileSize(localFile.length());
      if (!TextUtils.isEmpty(localMediaItemInfo1.getOriDataPath())) {
        break label141;
      }
      localMediaItemInfo2.setOriDataPath(localMediaItemInfo1.getDataPath());
    }
    for (;;)
    {
      MediaData.selectItem(localMediaItemInfo2, true);
      finishWithResult(-1, null);
      return;
      label141:
      localMediaItemInfo2.setOriDataPath(localMediaItemInfo1.getOriDataPath());
    }
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onButtonBackClick()
  {
    findViewById(2131363794).setSelected(true);
    handleBack();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      handleBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onOverridePendingTransition()
  {
    overridePendingTransition(2130772422, 2130772419);
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    overridePendingTransition(0, 2130772402);
  }
  
  public void onRelease()
  {
    recycle();
  }
  
  public void refreshData() {}
  
  public void render()
  {
    updateAddButton();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MeidaBigBucketSelectActivity
 * JD-Core Version:    0.7.0.1
 */