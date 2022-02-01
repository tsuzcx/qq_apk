package com.tencent.qqmail.activity.media;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.calendar.util.CalendarUtils;
import com.tencent.qqmail.model.media.QMAlbumManager;
import com.tencent.qqmail.model.media.QMAlbumManager.QMAlbumCallback;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.model.media.QMCameraManager;
import com.tencent.qqmail.model.media.QMUploadImageManager;
import com.tencent.qqmail.model.media.QMUploadImageManager.QMUploadState;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.QMWeakReference;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import com.tencent.qqmail.utilities.timer.TextChangeTimer.OnTextChangeListener;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;

public class MediaBucketGridActivity
  extends BaseActivityEx
  implements IMediaInterface
{
  private static final String ARG_BUCKET_NAME = "arg_bucket_name";
  private static final String ARG_MAX_SELECTED_NUM = "arg_max_selected_num";
  private static final String ARG_PATH = "arg_path";
  private static final String ARG_TYPE = "arg_type";
  private static final int LOAD_TYPE_IMAGE = 1;
  private static final int LOAD_TYPE_IMAGE_AND_VIDEO = 2;
  private static final int LOAD_TYPE_NONE = 0;
  private static final int REQUEST_IMAGE_BIG_BUCKET_SELECT = 2;
  private static final int REQUEST_IMAGE_CROP = 1;
  public static final String TAG = "MediaBucketSelActivity";
  private MediaBucketGridAdapter adapter;
  private String bucketName;
  private String cachePath;
  private int countPerLineLand;
  private int countPerLinePort;
  private QMUIDialog dialog;
  private QMContentLoadingView emptyView;
  private int firstVisibleItem;
  private GridView imageGridView;
  private int imageSizeLand;
  private int imageSizePort;
  private QMAlbumManager.QMMediaIntentType intentType = QMAlbumManager.QMMediaIntentType.QMMediaIntentType_NORMAIL;
  private boolean isScroll = false;
  private boolean isSupportCamera;
  private boolean isVisibleItemChanged;
  private int loadType;
  private TextChangeTimer.OnTextChangeListener mTextChangeListener = new TextChangeListener(this);
  private int maxSelectedNum;
  private QMMediaBottom mediaBottom = null;
  private List<MediaItemInfo> mediaInfoList;
  private List<MediaItemInfo> paintpadMediaItemInfos;
  private boolean reloadData = true;
  private boolean scrollState = false;
  private TextView selectedFileSizeTx = null;
  private TextChangeTimer textChangeTimer = new TextChangeTimer();
  private TextView timeline = null;
  private QMTopBar topBar;
  private int visibleItemCount;
  
  private void calculateImageSize()
  {
    int i = ((WindowManager)QMApplicationContext.sharedInstance().getSystemService("window")).getDefaultDisplay().getWidth();
    int j = getResources().getConfiguration().orientation;
    float f1 = QMApplicationContext.sharedInstance().getResources().getDimension(2131297432);
    float f2 = QMApplicationContext.sharedInstance().getResources().getDimension(2131296863);
    if (j == 2)
    {
      this.countPerLineLand = ((int)(i / (f1 + f2)));
      this.imageSizeLand = ((int)((i - (this.countPerLineLand - 1) * f2) / this.countPerLineLand));
    }
    while (j != 1) {
      return;
    }
    this.countPerLinePort = ((int)(i / (f1 + f2)));
    this.imageSizePort = ((int)((i - (this.countPerLinePort - 1) * f2) / this.countPerLinePort));
  }
  
  private void clickCameraButton()
  {
    DataCollector.logEvent("Event_ClickCamera_From_Gridview");
    if (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH) {
      this.cachePath = FileUtil.getExternalUpLoadImageCachePath();
    }
    while (FileUtil.isFileExist(this.cachePath))
    {
      String str = FileUtil.createPhotoDirAtRootPath(this.cachePath) + QMAttachUtils.generateUploadFileName(null);
      for (;;)
      {
        if (FileUtil.isFileExist(str))
        {
          str = FileUtil.createPhotoDirAtRootPath(this.cachePath) + QMAttachUtils.generateUploadFileName(null);
          continue;
          this.cachePath = getIntent().getStringExtra("arg_path");
          break;
        }
      }
      QMCameraManager.sharedInstance().setCameraPhotoPath(str);
      RxPermissions.getInstance(getActivity()).request(new String[] { "android.permission.CAMERA" }).subscribe(new MediaBucketGridActivity.11(this));
    }
  }
  
  public static QMUIDialog createImageLimitDialog(Context paramContext)
  {
    return ((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setMessage(2131719838).addAction(2131696547, new MediaBucketGridActivity.10())).create();
  }
  
  public static Intent createIntent(QMAlbumManager.QMMediaIntentType paramQMMediaIntentType, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MediaBucketGridActivity.class);
    localIntent.putExtra("arg_type", paramQMMediaIntentType.toString());
    localIntent.putExtra("arg_bucket_name", paramString1);
    localIntent.putExtra("arg_path", paramString2);
    localIntent.putExtra("arg_max_selected_num", paramInt);
    return localIntent;
  }
  
  private void doRender()
  {
    this.mediaInfoList = ((List)MediaData.getBuckets().get(this.bucketName));
    if ((this.paintpadMediaItemInfos != null) && (this.paintpadMediaItemInfos.size() > 0))
    {
      Iterator localIterator = this.paintpadMediaItemInfos.iterator();
      while (localIterator.hasNext())
      {
        MediaItemInfo localMediaItemInfo = (MediaItemInfo)localIterator.next();
        int i = this.mediaInfoList.indexOf(localMediaItemInfo);
        if (i >= 0)
        {
          ((MediaItemInfo)this.mediaInfoList.get(i)).setDataPath(localMediaItemInfo.getDataPath());
          ((MediaItemInfo)this.mediaInfoList.get(i)).setOriDataPath(localMediaItemInfo.getOriDataPath());
        }
      }
    }
    if ((this.mediaInfoList == null) || (this.mediaInfoList.size() == 0)) {
      renderEmpty();
    }
    for (;;)
    {
      updateAddButton();
      return;
      if (this.adapter == null) {
        initGridView();
      } else {
        renderGridView();
      }
    }
  }
  
  private void finishWithResult(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  private int getSelectedNum()
  {
    if (this.adapter == null) {
      return 0;
    }
    return MediaData.getSelectedInfoList().size();
  }
  
  private void handleCancel()
  {
    MediaFolderSelectActivity.setSelectedResult(null);
    DataCollector.logEvent("Event_ClickBack_From_VirtualFolder");
    QMUploadImageManager localQMUploadImageManager;
    if (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH) {
      localQMUploadImageManager = QMUploadImageManager.sharedInstance();
    }
    synchronized (localQMUploadImageManager.getState())
    {
      if (localQMUploadImageManager.getState() != QMUploadImageManager.QMUploadState.QMUploadState_Done) {
        QMUploadImageManager.sharedInstance().cancelUpload();
      }
      finishWithResult(2, null);
      overridePendingTransition(2130772421, 2130772420);
      return;
    }
  }
  
  private void handleCancelAll()
  {
    DataCollector.logEvent("Event_ClickBack_From_VirtualFolder");
    MediaFolderSelectActivity.setSelectedResult(null);
    QMUploadImageManager localQMUploadImageManager;
    if (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH) {
      localQMUploadImageManager = QMUploadImageManager.sharedInstance();
    }
    synchronized (localQMUploadImageManager.getState())
    {
      if (localQMUploadImageManager.getState() != QMUploadImageManager.QMUploadState.QMUploadState_Done) {
        QMUploadImageManager.sharedInstance().cancelUpload();
      }
      finishWithResult(0, null);
      overridePendingTransition(2130772423, 2130772402);
      return;
    }
  }
  
  private void handleDone()
  {
    DataCollector.logEvent("Event_ClickAdd_From_GridView");
    Object localObject1;
    if (this.adapter != null)
    {
      localObject1 = new ArrayList();
      Iterator localIterator = MediaData.getSelectedInfoList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (MediaItemInfo)localIterator.next();
        AttachInfo localAttachInfo = new AttachInfo();
        localAttachInfo.setAttachPath(((MediaItemInfo)localObject2).getDataPath());
        localAttachInfo.setAbsAttachPath(((MediaItemInfo)localObject2).getDataPath());
        localAttachInfo.setAttachName(((MediaItemInfo)localObject2).getFileName());
        localAttachInfo.setRealSize(((MediaItemInfo)localObject2).getFileSize());
        localAttachInfo.setFileType(AttachType.IMAGE);
        localObject2 = QMImageLoader.getInstance().loadImageByKey(((MediaItemInfo)localObject2).getDataPath());
        if (localObject2 != null) {
          localAttachInfo.setThumbnailData(localObject2);
        }
        localAttachInfo.setAttachName(QMAttachUtils.generateUploadFileName(localAttachInfo));
        ((List)localObject1).add(localAttachInfo);
      }
      MediaFolderSelectActivity.setSelectedResult((List)localObject1);
    }
    if (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH)
    {
      if (MediaFolderSelectActivity.getSelectedResult() != null)
      {
        localObject1 = QMAlbumManager.shareInstance().albumCallback;
        if (localObject1 != null) {
          ((QMAlbumManager.QMAlbumCallback)localObject1).handleSelectMedias(MediaFolderSelectActivity.getSelectedResult());
        }
      }
      return;
    }
    finishWithResult(-1, null);
  }
  
  private void initAddButton()
  {
    this.mediaBottom = ((QMMediaBottom)findViewById(2131371209));
    this.selectedFileSizeTx = ((TextView)findViewById(2131377972));
    this.mediaBottom.init(this);
    if (this.intentType != QMAlbumManager.QMMediaIntentType.QMMediaIntentType_AVATAR)
    {
      this.mediaBottom.setVisibility(0);
      this.mediaBottom.addButton.setOnClickListener(new MediaBucketGridActivity.5(this));
    }
  }
  
  private void initGridView()
  {
    this.adapter = new MediaBucketGridAdapter(this, 2131559529, this.mediaInfoList, this.intentType, this.isSupportCamera);
    updateSelectedItem();
    this.adapter.setCanLoadImage(true);
    this.adapter.setClickCheckBoxListener(new MediaBucketGridActivity.6(this));
    this.imageGridView.setOnItemClickListener(new MediaBucketGridActivity.7(this));
    int i = getResources().getConfiguration().orientation;
    calculateImageSize();
    setImageSize(i);
    this.imageGridView.setAdapter(this.adapter);
    this.imageGridView.setOnScrollListener(new MediaBucketGridActivity.8(this));
    if (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_AVATAR)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.imageGridView.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.imageGridView.setLayoutParams(localLayoutParams);
      return;
    }
    this.mediaBottom.setVisibility(0);
    this.mediaBottom.addButton.setOnClickListener(new MediaBucketGridActivity.9(this));
  }
  
  private void initMediaData()
  {
    
    if (MediaFolderSelectActivity.getSelectedResult() != null)
    {
      Iterator localIterator = MediaFolderSelectActivity.getSelectedResult().iterator();
      while (localIterator.hasNext())
      {
        MediaItemInfo localMediaItemInfo = QMAttachUtils.attachInfo2MediaItemInfo((AttachInfo)localIterator.next());
        MediaData.selectItem(localMediaItemInfo, true);
        if (!TextUtils.isEmpty(localMediaItemInfo.getOriDataPath()))
        {
          if (this.paintpadMediaItemInfos == null) {
            this.paintpadMediaItemInfos = new ArrayList();
          }
          this.paintpadMediaItemInfos.add(localMediaItemInfo);
        }
      }
    }
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(this.bucketName);
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new MediaBucketGridActivity.2(this));
    this.topBar.setButtonRightNormal(2131691246);
    this.topBar.getButtonRight().setOnClickListener(new MediaBucketGridActivity.3(this));
    this.topBar.setCenterOnclickListener(new MediaBucketGridActivity.4(this));
  }
  
  private void loadDataOnBackground()
  {
    runInBackground(new MediaBucketGridActivity.12(this));
  }
  
  private boolean moreThanMaxSelectedNum()
  {
    return (this.maxSelectedNum != -1) && (getSelectedNum() >= this.maxSelectedNum);
  }
  
  private void renderEmpty()
  {
    this.imageGridView.setVisibility(8);
    this.emptyView.setVisibility(0);
    this.emptyView.showTips(2131695699);
  }
  
  private void renderGridView()
  {
    this.emptyView.setVisibility(8);
    this.imageGridView.setVisibility(0);
  }
  
  private void scrollToTop(AbsListView paramAbsListView)
  {
    if (paramAbsListView == null) {
      return;
    }
    int i;
    if (paramAbsListView.getFirstVisiblePosition() > 8)
    {
      i = paramAbsListView.getCount();
      if (8 < i) {
        break label55;
      }
      i -= 1;
    }
    for (;;)
    {
      paramAbsListView.setSelection(i);
      if (Build.VERSION.SDK_INT >= 8)
      {
        paramAbsListView.smoothScrollToPosition(0, 0);
        return;
      }
      paramAbsListView.setSelection(0);
      return;
      label55:
      i = 8;
    }
  }
  
  private void setImageSize(int paramInt)
  {
    int i;
    if (paramInt == 2)
    {
      if (this.imageSizeLand == 0) {
        calculateImageSize();
      }
      i = this.countPerLineLand;
      paramInt = this.imageSizeLand;
    }
    for (;;)
    {
      if (this.adapter != null)
      {
        this.adapter.setItemSize(i, paramInt);
        this.adapter.notifyDataSetChanged();
      }
      return;
      if (paramInt == 1)
      {
        if (this.imageSizePort == 0) {
          calculateImageSize();
        }
        i = this.countPerLinePort;
        paramInt = this.imageSizePort;
      }
      else
      {
        paramInt = ((WindowManager)QMApplicationContext.sharedInstance().getSystemService("window")).getDefaultDisplay().getWidth();
        i = (int)(paramInt / QMApplicationContext.sharedInstance().getResources().getDimension(2131297432));
        paramInt = (int)((paramInt - 2.0F * QMApplicationContext.sharedInstance().getResources().getDimension(2131296863)) / this.countPerLinePort);
      }
    }
  }
  
  private void showDialog()
  {
    if (this.dialog == null) {
      this.dialog = createImageLimitDialog(this);
    }
    this.dialog.show();
  }
  
  private void updateAddButton()
  {
    int i = getSelectedNum();
    if (this.mediaBottom != null) {
      this.mediaBottom.updateAddButton(this.intentType, i);
    }
    Log.i("MediaBucketSelActivity", "updateAddButton");
    List localList = MediaData.getSelectedInfoList();
    Iterator localIterator = localList.iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      MediaItemInfo localMediaItemInfo = (MediaItemInfo)localIterator.next();
      if (localMediaItemInfo == null) {
        break label156;
      }
      l = localMediaItemInfo.getFileSize() + l;
    }
    label156:
    for (;;)
    {
      break;
      if (localList.size() > 0)
      {
        this.selectedFileSizeTx.setText("已选择" + localList.size() + "项，共" + Formatter.formatFileSize(this, l));
        return;
      }
      this.selectedFileSizeTx.setText("");
      return;
    }
  }
  
  private void updateSelectedItem()
  {
    List localList = MediaData.getSelectedInfoList();
    if ((localList != null) && (this.adapter != null)) {
      this.adapter.setSelectedInfoList(localList);
    }
  }
  
  private void updateTimeLine(long paramLong)
  {
    this.timeline.setVisibility(0);
    this.textChangeTimer.release();
    paramLong = 1000L * paramLong;
    String str;
    if (CalendarUtils.isThisWeek(paramLong)) {
      str = getString(2131695702);
    }
    for (;;)
    {
      if (!str.equals(this.timeline.getText().toString())) {
        this.timeline.setText(str);
      }
      return;
      if (CalendarUtils.isThisMonth(paramLong)) {
        str = getString(2131695701);
      } else if (CalendarUtils.isLastMonth(paramLong)) {
        str = getString(2131695700);
      } else {
        str = CalendarUtils.getYearAndMon(paramLong).replace("/0", "/");
      }
    }
  }
  
  public void finishMedia()
  {
    handleCancelAll();
  }
  
  public void initDataSource()
  {
    boolean bool2 = true;
    this.intentType = QMAlbumManager.QMMediaIntentType.valueOf(getIntent().getStringExtra("arg_type"));
    this.bucketName = getIntent().getStringExtra("arg_bucket_name");
    if (this.bucketName.equals(getString(2131695698)))
    {
      this.loadType = 2;
      if ((this.loadType != 1) && (this.loadType != 2)) {
        break label158;
      }
      bool1 = bool2;
      if (QMAlbumManager.QMMediaIntentType.QMMediaIntentType_NORMAIL != this.intentType)
      {
        bool1 = bool2;
        if (QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH != this.intentType) {
          if (QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FEEDBACK != this.intentType) {
            break label158;
          }
        }
      }
    }
    label158:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isSupportCamera = bool1;
      this.maxSelectedNum = getIntent().getIntExtra("arg_max_selected_num", -1);
      return;
      if (this.bucketName.equals(getString(2131695697)))
      {
        this.loadType = 1;
        break;
      }
      this.loadType = 0;
      break;
    }
  }
  
  public void initDom()
  {
    initTopBar();
    initAddButton();
  }
  
  public void initUI()
  {
    setContentView(2131558499);
    this.timeline = ((TextView)findViewById(2131379701));
    this.emptyView = ((QMContentLoadingView)findViewById(2131366446));
    this.imageGridView = ((GridView)findViewById(2131368833));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2;
    long l;
    if ((paramInt1 == 3) && (paramInt2 == -1))
    {
      if (this.intentType != QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH) {
        break label364;
      }
      ArrayList localArrayList = new ArrayList();
      if (this.adapter != null)
      {
        localObject1 = MediaData.getSelectedInfoList().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (MediaItemInfo)((Iterator)localObject1).next();
          localObject2 = new AttachInfo();
          ((AttachInfo)localObject2).setAttachPath(((MediaItemInfo)localObject3).getDataPath());
          ((AttachInfo)localObject2).setAbsAttachPath(((MediaItemInfo)localObject3).getDataPath());
          ((AttachInfo)localObject2).setAttachName(((MediaItemInfo)localObject3).getFileName());
          ((AttachInfo)localObject2).setRealSize(((MediaItemInfo)localObject3).getFileSize());
          ((AttachInfo)localObject2).setFileType(AttachType.IMAGE);
          localObject3 = QMImageLoader.getInstance().loadImageByKey(((MediaItemInfo)localObject3).getDataPath());
          if (localObject3 != null) {
            ((AttachInfo)localObject2).setThumbnailData(localObject3);
          }
          ((AttachInfo)localObject2).setAttachName(QMAttachUtils.generateUploadFileName((AttachInfo)localObject2));
          localArrayList.add(localObject2);
        }
      }
      Object localObject1 = new AttachInfo();
      localObject2 = new File(QMCameraManager.sharedInstance().getCameraPhotoPath());
      ((AttachInfo)localObject1).setAttachPath(QMCameraManager.sharedInstance().getCameraPhotoPath());
      ((AttachInfo)localObject1).setAbsAttachPath(((AttachInfo)localObject1).getAttachPath());
      ((AttachInfo)localObject1).setAttachName("tmpImage.jpg");
      ((AttachInfo)localObject1).setFileType(AttachType.IMAGE);
      if (localObject2 != null) {
        break label354;
      }
      l = 0L;
      ((AttachInfo)localObject1).setRealSize(l);
      localObject2 = QMImageLoader.getInstance().loadImageByKey(((AttachInfo)localObject1).getAttachPath());
      if (localObject2 != null) {
        ((AttachInfo)localObject1).setThumbnailData(localObject2);
      }
      localArrayList.add(localObject1);
      localObject1 = QMAlbumManager.shareInstance().albumCallback;
      if (localObject1 != null) {
        ((QMAlbumManager.QMAlbumCallback)localObject1).handleSelectMedias(localArrayList);
      }
    }
    for (;;)
    {
      if (((paramInt1 == 1) || (paramInt1 == 2)) && ((paramInt2 == -1) || (paramInt2 == 0))) {
        finishWithResult(paramInt2, paramIntent);
      }
      if ((paramInt1 == 2) && (paramInt2 == 2))
      {
        updateSelectedItem();
        this.imageGridView.setSelection(0);
      }
      return;
      label354:
      l = ((File)localObject2).length();
      break;
      label364:
      finishWithResult(paramInt2, null);
    }
  }
  
  public void onBackPressed()
  {
    handleCancel();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onButtonBackClick()
  {
    handleCancel();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    setImageSize(paramConfiguration.orientation);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return this.topBar.getButtonLeft().isEnabled();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.loadType == 1) || (this.loadType == 2))
      {
        handleCancelAll();
        return true;
      }
      handleCancel();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRelease()
  {
    if (this.imageGridView != null)
    {
      this.imageGridView.setOnScrollListener(null);
      this.imageGridView.setAdapter(null);
    }
    if (this.adapter != null) {
      this.adapter.recycle();
    }
    this.adapter = null;
    this.imageGridView = null;
    this.mediaInfoList = null;
  }
  
  public void onSizeTooLarge()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(getString(2131690588))).setMessage(getString(2131690591)).addAction(getString(2131696547), new MediaBucketGridActivity.1(this))).create().show();
  }
  
  public void refreshData() {}
  
  public void render()
  {
    if ((this.reloadData) && ((this.loadType == 1) || (this.loadType == 2)))
    {
      this.reloadData = false;
      loadDataOnBackground();
      return;
    }
    doRender();
  }
  
  public void resetAddButton(boolean paramBoolean)
  {
    if ((this.mediaBottom != null) && (this.mediaBottom.addButton != null)) {
      this.mediaBottom.addButton.setEnabled(paramBoolean);
    }
  }
  
  public void showUpload(QMTips.QMTipsCallback paramQMTipsCallback)
  {
    getTips().showUpload(paramQMTipsCallback);
  }
  
  public void updateUploadProcess(int paramInt)
  {
    getTips().updateUploadImageProcess(paramInt);
  }
  
  static final class TextChangeListener
    extends QMWeakReference<MediaBucketGridActivity>
    implements TextChangeTimer.OnTextChangeListener
  {
    public TextChangeListener(MediaBucketGridActivity paramMediaBucketGridActivity)
    {
      super();
    }
    
    public void onTextChange()
    {
      MediaBucketGridActivity localMediaBucketGridActivity = (MediaBucketGridActivity)get();
      if (localMediaBucketGridActivity == null) {
        return;
      }
      localMediaBucketGridActivity.timeline.setVisibility(8);
      localMediaBucketGridActivity.timeline.startAnimation(AnimationUtils.loadAnimation(localMediaBucketGridActivity, 2130772026));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridActivity
 * JD-Core Version:    0.7.0.1
 */