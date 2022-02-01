package com.tencent.qqmail.activity.media;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.media.QMAlbumManager;
import com.tencent.qqmail.model.media.QMAlbumManager.QMAlbumCallback;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.model.media.QMUploadImageManager;
import com.tencent.qqmail.model.media.QMUploadImageManager.QMUploadState;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import moai.core.watcher.Watchers;
import moai.core.watcher.Watchers.Watcher;

public class MediaFolderSelectActivity
  extends BaseActivityEx
  implements IMediaInterface
{
  private static final String ARG_MAX_SELECTED_NUM = "arg_max_selected_num";
  private static final String ARG_PATH = "arg_path";
  private static final String ARG_TYPE = "arg_type";
  private static final int REQUEST_SELECT_BUCKET_REQUEST = 1;
  public static final String TAG = "MediaFolderSelectActivity";
  private static List<AttachInfo> selectedResult;
  private MediaFolderSelectAdapter adapter;
  private final View.OnClickListener addButtonClickListener = new MediaFolderSelectActivity.7(this);
  private String bucketName;
  private String cachePath;
  private int firstVisibleItem;
  private ListView folderListView;
  private QMAlbumManager.QMMediaIntentType intentType = QMAlbumManager.QMMediaIntentType.QMMediaIntentType_NORMAIL;
  private boolean isVisibleItemChanged;
  private QMMediaBottom mMediaBottom;
  private MediaFolderWatcher mMediaFolderWatcher = new MediaFolderSelectActivity.6(this);
  private List<MediaItemInfo> mMediaItemInfoList;
  private int maxSelectedNum;
  private TextView selectedFileSizeTx;
  private QMTopBar topBar;
  private int visibleItemCount;
  
  public static Intent createIntent(QMAlbumManager.QMMediaIntentType paramQMMediaIntentType, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MediaFolderSelectActivity.class);
    localIntent.putExtra("arg_type", paramQMMediaIntentType.toString());
    localIntent.putExtra("arg_path", paramString);
    return localIntent;
  }
  
  public static Intent createIntent(QMAlbumManager.QMMediaIntentType paramQMMediaIntentType, String paramString, int paramInt)
  {
    paramQMMediaIntentType = createIntent(paramQMMediaIntentType, paramString);
    paramQMMediaIntentType.putExtra("arg_max_selected_num", paramInt);
    return paramQMMediaIntentType;
  }
  
  public static List<AttachInfo> getSelectedResult()
  {
    return selectedResult;
  }
  
  private void handleCancel()
  {
    QMUploadImageManager localQMUploadImageManager;
    if (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH) {
      localQMUploadImageManager = QMUploadImageManager.sharedInstance();
    }
    synchronized (localQMUploadImageManager.getState())
    {
      if (localQMUploadImageManager.getState() != QMUploadImageManager.QMUploadState.QMUploadState_Done) {
        QMUploadImageManager.sharedInstance().cancelUpload();
      }
      setSelectedResult(null);
      setResult(0, null);
      finish();
      return;
    }
  }
  
  private void handleDone()
  {
    Object localObject = new ArrayList();
    Iterator localIterator = MediaData.getSelectedInfoList().iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(QMAttachUtils.mediaItemInfo2AttachInfo((MediaItemInfo)localIterator.next()));
    }
    setSelectedResult((List)localObject);
    if (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH)
    {
      if (selectedResult != null)
      {
        localObject = QMAlbumManager.shareInstance().albumCallback;
        if (localObject != null) {
          ((QMAlbumManager.QMAlbumCallback)localObject).handleSelectMedias(selectedResult);
        }
      }
      return;
    }
    localObject = new Intent();
    if (selectedResult != null) {
      ((Intent)localObject).putExtra("selected", selectedResult.size());
    }
    setResult(-1, (Intent)localObject);
    finish();
  }
  
  private void initAddButton()
  {
    if (this.intentType != QMAlbumManager.QMMediaIntentType.QMMediaIntentType_AVATAR)
    {
      this.mMediaBottom = ((QMMediaBottom)findViewById(2131371208));
      this.mMediaBottom.init(this);
      this.mMediaBottom.setVisibility(0);
      this.mMediaBottom.addButton.setOnClickListener(this.addButtonClickListener);
    }
  }
  
  private void initListView()
  {
    this.mMediaItemInfoList = new ArrayList();
    if ((MediaData.getCovers() != null) && (MediaData.getCovers().size() > 0)) {
      this.mMediaItemInfoList.addAll(MediaData.getCovers());
    }
    this.adapter = new MediaFolderSelectAdapter(this, 2131559530, this.mMediaItemInfoList, MediaData.getCoverCounts());
    this.folderListView = ((ListView)findViewById(2131368833));
    this.folderListView.setAdapter(this.adapter);
    this.folderListView.setOnItemClickListener(new MediaFolderSelectActivity.4(this));
    this.folderListView.setOnScrollListener(new MediaFolderSelectActivity.5(this));
    if (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_AVATAR)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.folderListView.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.folderListView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(this.bucketName);
    this.topBar.setButtonRightNormal(2131691246);
    this.topBar.getButtonRight().setOnClickListener(new MediaFolderSelectActivity.2(this));
    this.topBar.setCenterOnclickListener(new MediaFolderSelectActivity.3(this));
  }
  
  private boolean isMediaImage()
  {
    return (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_AVATAR) || (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_NOTE) || (this.intentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FEEDBACK);
  }
  
  @SuppressLint({"NewApi"})
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
  
  private void selectCover()
  {
    startActivityForResult(MediaBucketGridActivity.createIntent(this.intentType, this.bucketName, this.cachePath, this.maxSelectedNum), 1);
    overridePendingTransition(2130772401, 2130772423);
  }
  
  public static void setSelectedResult(List<AttachInfo> paramList)
  {
    selectedResult = paramList;
  }
  
  private void updateAddButton()
  {
    int i;
    List localList;
    long l;
    if (this.adapter == null)
    {
      i = 0;
      if (this.mMediaBottom != null) {
        this.mMediaBottom.updateAddButton(this.intentType, i);
      }
      localList = MediaData.getSelectedInfoList();
      Iterator localIterator = localList.iterator();
      l = 0L;
      label44:
      if (!localIterator.hasNext()) {
        break label94;
      }
      MediaItemInfo localMediaItemInfo = (MediaItemInfo)localIterator.next();
      if (localMediaItemInfo == null) {
        break label185;
      }
      l = localMediaItemInfo.getFileSize() + l;
    }
    label185:
    for (;;)
    {
      break label44;
      i = MediaData.getSelectedInfoList().size();
      break;
      label94:
      this.selectedFileSizeTx = ((TextView)findViewById(2131377972));
      if (this.selectedFileSizeTx == null) {
        return;
      }
      if (localList.size() > 0)
      {
        this.selectedFileSizeTx.setText("已选择" + localList.size() + "项，共" + Formatter.formatFileSize(this, l));
        return;
      }
      this.selectedFileSizeTx.setText("");
      return;
    }
  }
  
  private void updateMediaFolderList()
  {
    if (this.mMediaItemInfoList != null)
    {
      this.mMediaItemInfoList.clear();
      if ((MediaData.getCovers() != null) && (MediaData.getCovers().size() > 0)) {
        this.mMediaItemInfoList.addAll(MediaData.getCovers());
      }
    }
    if (this.adapter != null) {
      this.adapter.notifyDataSetChanged();
    }
  }
  
  public void finishMedia()
  {
    handleCancel();
  }
  
  public void initDataSource()
  {
    String str = getIntent().getStringExtra("arg_type");
    if ((str == null) || (str.length() == 0))
    {
      this.intentType = QMAlbumManager.QMMediaIntentType.QMMediaIntentType_NORMAIL;
      this.cachePath = getIntent().getStringExtra("arg_path");
      if (!isMediaImage()) {
        break label87;
      }
    }
    label87:
    for (this.bucketName = QMApplicationContext.sharedInstance().getString(2131695697);; this.bucketName = QMApplicationContext.sharedInstance().getString(2131695698))
    {
      this.maxSelectedNum = getIntent().getIntExtra("arg_max_selected_num", -1);
      return;
      this.intentType = QMAlbumManager.QMMediaIntentType.valueOf(str);
      break;
    }
  }
  
  public void initDom()
  {
    initTopBar();
    initListView();
    initAddButton();
  }
  
  public void initUI()
  {
    setContentView(2131558495);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) || (paramInt2 == 0))
    {
      if (paramInt2 == -1)
      {
        paramIntent = new ArrayList();
        Iterator localIterator = MediaData.getSelectedInfoList().iterator();
        while (localIterator.hasNext()) {
          paramIntent.add(QMAttachUtils.mediaItemInfo2AttachInfo((MediaItemInfo)localIterator.next()));
        }
        setSelectedResult(paramIntent);
      }
      setResult(paramInt2);
      finish();
    }
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.mMediaFolderWatcher, paramBoolean);
  }
  
  public void onFetchCursor()
  {
    selectCover();
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    overridePendingTransition(2130772423, 2130772402);
  }
  
  public void onRelease()
  {
    this.folderListView.setOnScrollListener(null);
    this.folderListView.setAdapter(null);
    this.folderListView = null;
    this.adapter = null;
    QMImageLoader.getInstance().recycle();
  }
  
  public void onSizeTooLarge()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(getString(2131690588))).setMessage(getString(2131690591)).addAction(getString(2131696547), new MediaFolderSelectActivity.1(this))).create().show();
  }
  
  public void refreshData() {}
  
  public void render()
  {
    updateMediaFolderList();
    updateAddButton();
  }
  
  public void resetAddButton(boolean paramBoolean)
  {
    if (this.mMediaBottom != null) {
      this.mMediaBottom.setEnabled(paramBoolean);
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
  
  public static abstract interface MediaFolderWatcher
    extends Watchers.Watcher
  {
    public abstract void onDataLoad();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaFolderSelectActivity
 * JD-Core Version:    0.7.0.1
 */