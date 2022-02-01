package com.tencent.qqmail.download.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity;
import com.tencent.qqmail.activity.media.ImageAttachData;
import com.tencent.qqmail.activity.reademl.QMReadEmlActivity;
import com.tencent.qqmail.attachment.activity.WebViewPreviewActivity;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.cursor.DownloadInfoCursor;
import com.tencent.qqmail.download.loader.BigAttachDownloader;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.download.watcher.DownloadWatcher;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.watcher.FtnDownloadWatcher;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import moai.oss.OssHelper;

public class DownloadActivity
  extends BaseActivityEx
{
  private static final int REQUEST_CODE_CHANGE_SAVE_PATH = 1;
  public static final String TAG = "DownloadActivity";
  private HashMap<Long, BigAttachDownloader> bigAttachDownloaderHashMap = new HashMap();
  private QMBottomBar bottomBar;
  private View.OnClickListener btnDeleteEvent = new DownloadActivity.6(this);
  private View.OnClickListener btnSendMailEvent = new DownloadActivity.7(this);
  private Future<DownloadInfoCursor> downloadCursor;
  private DownloadWatcher downloadWatcher = new DownloadActivity.2(this);
  private FtnDownloadWatcher ftnDownloadWatcher = new DownloadActivity.1(this);
  private boolean isRefreshData;
  private long lastUpdateTime;
  private DownloadAdapter mAdapter;
  private TextView mBottomDeleteBtn;
  private TextView mBottomSendMailBtn;
  private ItemScrollListView mListView;
  private QMContentLoadingView mLoadingView;
  private QMListPopupWindow mPopWindow;
  private QMTips mTips;
  private QMTopBar mTopBar;
  private IObserver observerGetFtnShareUrlError = new DownloadActivity.5(this, null);
  private IObserver observerGetFtnShareUrlSuccess = new DownloadActivity.4(this, null);
  
  private void abortDownloadAttach(Attach paramAttach)
  {
    QMLog.log(4, "DownloadActivity", "start abort download attach " + paramAttach.getName());
    AttachDownloadManager.shareInstance().abort(DownloadUtil.getDownloadUrl(paramAttach));
  }
  
  private void abortDownloadBigAttach(MailBigAttach paramMailBigAttach)
  {
    boolean bool;
    if (paramMailBigAttach != null)
    {
      bool = true;
      ValidateHelper.assertInDebug("bigAttach is null", bool);
      if (paramMailBigAttach != null) {
        break label22;
      }
    }
    label22:
    do
    {
      return;
      bool = false;
      break;
      QMLog.log(4, "DownloadActivity", "start to abort download bigAttach " + paramMailBigAttach.getName());
      paramMailBigAttach = (BigAttachDownloader)this.bigAttachDownloaderHashMap.remove(Long.valueOf(paramMailBigAttach.getHashId()));
    } while (paramMailBigAttach == null);
    paramMailBigAttach.abort();
  }
  
  private void abortDownloadFtnAttach(DownloadInfo paramDownloadInfo)
  {
    QMLog.log(4, "DownloadActivity", "start abort download ftn attach " + paramDownloadInfo.getFileName());
    if (QMAttachUtils.isSuffixImage(FileUtil.getFileNameSuffix(paramDownloadInfo.getFileName())))
    {
      AttachDownloadManager.shareInstance().abort(DownloadUtil.getCgiUrl(paramDownloadInfo.getAccountId(), paramDownloadInfo.getUrl()));
      return;
    }
    FtnManager.sharedInstance().abortAndRemoveRequest(paramDownloadInfo.getFid());
  }
  
  private void abortDownloadZipInnerAttach(DownloadInfo paramDownloadInfo)
  {
    QMLog.log(4, "DownloadActivity", "start abort downloadZipInnerAttach " + paramDownloadInfo.getKey());
    AttachDownloadManager.shareInstance().abort(paramDownloadInfo.getKey());
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), DownloadActivity.class);
  }
  
  private void doRender()
  {
    refreshTopBar();
    if (getDataSource() == null)
    {
      showLoadingView();
      return;
    }
    if (getDataSource().getCount() == 0)
    {
      showEmptyView();
      return;
    }
    showListView();
  }
  
  private void downloadAttach(Attach paramAttach, String paramString)
  {
    QMLog.log(4, "DownloadActivity", "start to downloadAttach " + paramAttach.getName());
    AttachDownloadManager.shareInstance().fetchAttach(DownloadUtil.createDownloadInfoForNormal(paramAttach, paramString, false));
  }
  
  private void downloadBigAttach(MailBigAttach paramMailBigAttach, String paramString)
  {
    QMLog.log(4, "DownloadActivity", "start to download bigAttach " + paramMailBigAttach.getName());
    BigAttachDownloader localBigAttachDownloader2 = (BigAttachDownloader)this.bigAttachDownloaderHashMap.get(Long.valueOf(paramMailBigAttach.getHashId()));
    BigAttachDownloader localBigAttachDownloader1 = localBigAttachDownloader2;
    if (localBigAttachDownloader2 == null)
    {
      localBigAttachDownloader1 = new BigAttachDownloader(paramMailBigAttach, paramString, false);
      this.bigAttachDownloaderHashMap.put(Long.valueOf(paramMailBigAttach.getHashId()), localBigAttachDownloader1);
    }
    localBigAttachDownloader1.download();
  }
  
  private void downloadFtnAttach(DownloadInfo paramDownloadInfo)
  {
    QMLog.log(4, "DownloadActivity", "start download ftn attach " + paramDownloadInfo.getFileName());
    if (QMAttachUtils.isSuffixImage(FileUtil.getFileNameSuffix(paramDownloadInfo.getFileName())))
    {
      AttachDownloadManager.shareInstance().fetchAttach(paramDownloadInfo);
      return;
    }
    FtnManager.sharedInstance().getDownloadUrl(paramDownloadInfo);
  }
  
  private void downloadZipInnerAttach(DownloadInfo paramDownloadInfo, Attach paramAttach)
  {
    QMLog.log(4, "DownloadActivity", "start to downloadZipInnerAttach " + paramAttach.getName());
    AttachDownloadManager.shareInstance().fetchAttach(DownloadUtil.createDownloadInfoForZipInnerAttach(paramAttach, paramDownloadInfo.getKey()));
  }
  
  private void drapAttachByOneStep(View paramView, int paramInt)
  {
    DownloadInfo localDownloadInfo;
    if (OneStepUtils.isOneStepShowing())
    {
      paramInt -= this.mListView.getHeaderViewsCount();
      if (paramInt >= 0)
      {
        Attach localAttach = this.mAdapter.getAttachByPosition(paramInt);
        localDownloadInfo = this.mAdapter.getItem(paramInt);
        if ((localDownloadInfo != null) && (localDownloadInfo.getStatus() == 4) && (FileUtil.isFileExist(localDownloadInfo.getFilePath())))
        {
          if ((localAttach == null) || (!AttachToolbox.isAttachTypeImage(localAttach))) {
            break label86;
          }
          OneStepUtils.dragImageByOneStep(paramView, localDownloadInfo.getFilePath());
        }
      }
    }
    return;
    label86:
    OneStepUtils.dragFileByOneStep(paramView, localDownloadInfo.getFilePath(), localDownloadInfo.getFileName());
  }
  
  private String getClearLevel()
  {
    int i = 0;
    switch (QMApplicationContext.sharedInstance().getSharedPreferences("clear_attachment_period", 0).getInt("clear_attachment_period_level", 10))
    {
    }
    while (i == 0)
    {
      return "";
      i = 2131692947;
      continue;
      i = 2131692948;
      continue;
      i = 2131692949;
      continue;
      i = 2131692950;
    }
    return QMApplicationContext.sharedInstance().getString(i);
  }
  
  private DownloadInfoCursor getDataSource()
  {
    try
    {
      if (this.downloadCursor != null)
      {
        DownloadInfoCursor localDownloadInfoCursor = (DownloadInfoCursor)this.downloadCursor.get();
        return localDownloadInfoCursor;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "DownloadActivity", "getDataSource failed. " + localException.toString());
    }
    return null;
  }
  
  private boolean hasSDCardAndHandleErrorIfNo()
  {
    if (FileUtil.hasSdcard()) {
      return true;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setMessage(2131690273).setTitle(2131690274)).addAction(2131696547, new DownloadActivity.17(this))).create().show();
    return false;
  }
  
  private void initBottomBar()
  {
    this.bottomBar = new QMBottomBar(getActivity());
    this.mBottomDeleteBtn = this.bottomBar.addButton(1, getString(2131692952), this.btnDeleteEvent);
    this.mBottomSendMailBtn = this.bottomBar.addButton(0, getString(2131692965), this.btnSendMailEvent);
    addContentView(this.bottomBar, this.bottomBar.getLayoutParams());
  }
  
  private void initListView()
  {
    this.mListView.setOnRightViewClickListener(new DownloadActivity.12(this));
    this.mListView.setOnItemClickListener(new DownloadActivity.13(this));
    this.mListView.setOnItemLongClickListener(new DownloadActivity.14(this));
  }
  
  private void initTopBar()
  {
    refreshTopBar();
  }
  
  private boolean isEditing()
  {
    return (this.mAdapter != null) && (this.mAdapter.isEditMode());
  }
  
  private boolean isSelectAll()
  {
    int j = this.mListView.getHeaderViewsCount();
    if (getDataSource() != null)
    {
      int k = getDataSource().getCount();
      int i = 0;
      while (i < k)
      {
        if (!this.mListView.isItemChecked(i + j)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private void openFilePath(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (!FileUtil.isFileExist(paramDownloadInfo.getFilePath())))
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131692956), 0).show();
      QMLog.log(5, "DownloadActivity", "file is gone: " + paramDownloadInfo.getFileName() + " " + paramDownloadInfo.getFilePath());
      return;
    }
    IntentUtil.openAttachFileLocation(getActivity(), paramDownloadInfo.getFilePath());
  }
  
  private void operationDone()
  {
    refreshData(new DownloadActivity.3(this));
  }
  
  private void previewAttach(DownloadInfo paramDownloadInfo, Attach paramAttach)
  {
    QMLog.log(4, "DownloadActivity", "going to preview attach : " + paramDownloadInfo.getFileName() + ", previewType:" + FileUtil.getOpenType(getActivity(), FileUtil.getFileNameSuffix(paramDownloadInfo.getFileName())));
    if ((paramDownloadInfo != null) && (paramDownloadInfo.getStatus() == 4))
    {
      if (FileUtil.isFileExist(paramDownloadInfo.getFilePath())) {
        break label134;
      }
      Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131690552), 0).show();
      QMLog.log(5, "DownloadActivity", "file is gone: " + paramDownloadInfo.getFileName() + " " + paramDownloadInfo.getFilePath());
    }
    label134:
    label350:
    label356:
    do
    {
      do
      {
        do
        {
          return;
          if (paramAttach == null)
          {
            QMLog.log(5, "DownloadActivity", "attach is gone: " + paramDownloadInfo.getFileName() + " " + paramDownloadInfo.getFilePath());
            IntentUtil.openFile(this, paramDownloadInfo.getFilePath(), FileUtil.getFileNameSuffix(paramDownloadInfo.getFileName()), AttachPreviewType.LocalFile);
            return;
          }
          if (!AttachToolbox.isAttachEml(paramDownloadInfo.getFileName())) {
            break;
          }
          boolean bool1;
          int i;
          if (paramDownloadInfo.getAttachType() == 2)
          {
            bool1 = true;
            i = paramAttach.getAccountId();
            if (bool1) {
              break label350;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            startActivity(QMReadEmlActivity.createIntentFromEml(i, paramAttach, bool2, bool1));
            getActivity().overridePendingTransition(2130772422, 2130772419);
            if (paramDownloadInfo.getAttachType() != 2) {
              break label356;
            }
            OssHelper.ftnattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "DownloadActivity", "eml", "" });
            return;
            bool1 = false;
            break;
          }
          if (paramDownloadInfo.getAttachType() == 1)
          {
            OssHelper.bigattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "DownloadActivity", "eml", "" });
            return;
          }
        } while ((paramDownloadInfo.getAttachType() != 3) && (paramDownloadInfo.getAttachType() != 0));
        OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "DownloadActivity", "eml", "" });
        return;
        if (!AttachToolbox.isAttachICS(paramDownloadInfo.getFileName())) {
          break;
        }
        startActivity(MailFragmentActivity.createIntentToReadIcsEvent(paramDownloadInfo.getFilePath()));
        getActivity().overridePendingTransition(2130772422, 2130772419);
        if (paramDownloadInfo.getAttachType() == 2)
        {
          OssHelper.ftnattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "DownloadActivity", "ics", "" });
          return;
        }
        if (paramDownloadInfo.getAttachType() == 1)
        {
          OssHelper.bigattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "DownloadActivity", "ics", "" });
          return;
        }
      } while ((paramDownloadInfo.getAttachType() != 3) && (paramDownloadInfo.getAttachType() != 0));
      OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "DownloadActivity", "ics", "" });
      return;
      if ((AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName()))) == AttachType.IMAGE) && (!FileUtil.isFileTypeTiff(paramAttach.getName())))
      {
        startImageAttachPreview(paramDownloadInfo, paramAttach);
        return;
      }
      if (FileUtil.getOpenType(getActivity(), FileUtil.getFileNameSuffix(paramAttach.getName())) == 0)
      {
        startActivity(WebViewPreviewActivity.createIntent(getActivity(), paramAttach, paramAttach.getFolderId(), false));
        return;
      }
      if (paramDownloadInfo.getAttachType() == 2)
      {
        IntentUtil.openFile(this, paramAttach.getPreview().getMyDisk(), FileUtil.getFileNameSuffix(paramAttach.getName()), AttachPreviewType.FTNBigAttachPreview);
        return;
      }
      if (paramDownloadInfo.getAttachType() == 1)
      {
        IntentUtil.openFile(this, paramAttach.getPreview().getMyDisk(), FileUtil.getFileNameSuffix(paramAttach.getName()), AttachPreviewType.MailBigAttachPreview);
        return;
      }
    } while ((paramDownloadInfo.getAttachType() != 0) && (paramDownloadInfo.getAttachType() != 3));
    IntentUtil.openFile(this, paramAttach.getPreview().getMyDisk(), FileUtil.getFileNameSuffix(paramAttach.getName()), AttachPreviewType.MailNormalAttachPreview);
  }
  
  private void refreshBottomBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      initBottomBar();
      this.bottomBar.setVisibility(0);
      return;
    }
    this.bottomBar.setVisibility(8);
  }
  
  private void refreshData(QMRefreshCallback paramQMRefreshCallback)
  {
    if ((this.isRefreshData) && (getDataSource() != null)) {
      getDataSource().refresh(false, paramQMRefreshCallback);
    }
    this.isRefreshData = true;
  }
  
  private void refreshTopBar()
  {
    if (isEditing())
    {
      this.mTopBar.setTitle(2131692954);
      this.mTopBar.setSubTitle("");
      this.mTopBar.setButtonLeftNormal(2131719469);
      this.mTopBar.setButtonRightBlue(2131691246);
      refreshTopBarForEditMode();
    }
    for (;;)
    {
      this.mTopBar.setButtonLeftOnclickListener(new DownloadActivity.9(this));
      this.mTopBar.setButtonRightOnclickListener(new DownloadActivity.10(this));
      return;
      this.mTopBar.setButtonLeftBack();
      this.mTopBar.setTitle(2131692945);
      this.mTopBar.setButtonRightIcon(2130841095);
      String str = getClearLevel();
      this.mTopBar.setSubTitle(str);
      this.mTopBar.getButtonRight().setContentDescription(getString(2131720837));
    }
  }
  
  private void refreshTopBarForEditMode()
  {
    if (isSelectAll()) {
      this.mTopBar.setButtonLeftNormal(2131719470);
    }
    while ((this.mAdapter != null) && (this.mAdapter.getSelectDownloadInfo().size() > 0))
    {
      this.mTopBar.setTitle(String.format(getString(2131692953), new Object[] { Integer.valueOf(this.mAdapter.getSelectDownloadInfo().size()) }));
      this.mBottomDeleteBtn.setEnabled(true);
      if (this.mAdapter.hasSelectUnCompleteInfo())
      {
        this.mBottomSendMailBtn.setEnabled(false);
        return;
        this.mTopBar.setButtonLeftNormal(2131719469);
      }
      else
      {
        this.mBottomSendMailBtn.setEnabled(true);
        return;
      }
    }
    this.mTopBar.setTitle(2131692954);
    this.mBottomDeleteBtn.setEnabled(false);
    this.mBottomSendMailBtn.setEnabled(false);
  }
  
  private void renderProgress(int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (l - this.lastUpdateTime <= 300L);
      this.lastUpdateTime = l;
    } while (this.mAdapter == null);
    this.mAdapter.updateProgress(this.mListView, paramInt, paramLong1, paramLong2);
  }
  
  private void sendMailWithAttaches(String[] paramArrayOfString)
  {
    QMLog.log(4, "DownloadActivity", "send mail attaches:" + paramArrayOfString.toString());
    startActivity(ComposeMailActivity.createIntentForDownloadManager(this, paramArrayOfString));
  }
  
  private void setAllSelectState(boolean paramBoolean)
  {
    int j = 0;
    if (getDataSource() == null) {}
    int k;
    for (int i = 0;; i = getDataSource().getCount())
    {
      k = this.mListView.getHeaderViewsCount();
      if (!paramBoolean) {
        break label87;
      }
      while (j < i)
      {
        if (!this.mListView.isItemChecked(j + k))
        {
          this.mListView.setItemChecked(j + k, true);
          this.mAdapter.toggleSelect(j);
        }
        j += 1;
      }
    }
    refreshTopBar();
    return;
    label87:
    j = 0;
    while (j < i)
    {
      if (this.mListView.isItemChecked(j + k)) {
        this.mListView.setItemChecked(j + k, false);
      }
      j += 1;
    }
    this.mListView.clearChoices();
    this.mListView.invalidate();
    this.mAdapter.getSelectDownloadInfo().clear();
    refreshTopBar();
  }
  
  private void setAttachDownloadPath(String paramString)
  {
    QMLog.log(4, "DownloadActivity", "change download dir to:" + paramString);
    FileUtil.setAttachDownloadDir(paramString);
    Toast.makeText(this, 2131692960, 0).show();
  }
  
  private void setDataSource()
  {
    this.downloadCursor = Threads.submitTask(new DownloadActivity.8(this));
  }
  
  private void shareAttachFile(DownloadInfo paramDownloadInfo, Attach paramAttach)
  {
    if (paramAttach.isBigAttach()) {}
    for (int i = 2131692325; paramDownloadInfo.getAttachType() == 2; i = 2131690586)
    {
      this.mTips.showLoading("复制分享链接");
      QMLog.log(4, "DownloadActivity", "share ftn attach:" + paramAttach.getName());
      FtnManager.sharedInstance().getShareUrl(paramDownloadInfo.getFid(), paramDownloadInfo.getFileName(), paramDownloadInfo.getFtnKey(), paramDownloadInfo.getFtnCode(), 2131367770);
      return;
    }
    if (paramDownloadInfo.getAttachType() == 1)
    {
      QMLog.log(4, "DownloadActivity", "share big attach:" + paramAttach.getName());
      paramDownloadInfo = (MailBigAttach)paramAttach;
      new QMShareFileDialogHelper(getActivity(), getString(i), paramDownloadInfo.getPreview().getDownloadUrl(), QMShareFileDialogHelper.SHARE_TYPE_BIG_ATT, paramDownloadInfo.getHashId()).createDialog().show();
      return;
    }
    QMLog.log(4, "DownloadActivity", "share normal attach:" + paramAttach.getName());
    String str = paramAttach.getPreview().getMyDisk();
    Object localObject = null;
    if (!StringExtention.isNullOrEmpty(str)) {
      localObject = new File(str);
    }
    if ((localObject != null) && (((File)localObject).exists()))
    {
      paramDownloadInfo = getActivity();
      localObject = getString(i);
      if (QMAttachUtils.isSuffixImage(FileUtil.getFileNameSuffix(paramAttach.getName()))) {}
      for (i = QMShareFileDialogHelper.SHARE_TYPE_IMG;; i = QMShareFileDialogHelper.SHARE_TYPE_NORMAL_ATT)
      {
        new QMShareFileDialogHelper(paramDownloadInfo, (String)localObject, str, i).createDialog().show();
        return;
      }
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131692956), 0).show();
    QMLog.log(5, "DownloadActivity", "file is gone: " + paramDownloadInfo.getFileName() + " " + paramDownloadInfo.getFilePath());
  }
  
  private void showActionDialog(DownloadInfo paramDownloadInfo, Attach paramAttach)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder;
    String str;
    if ((paramDownloadInfo != null) && (paramDownloadInfo.getStatus() == 4))
    {
      localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
      if (paramAttach == null) {
        break label132;
      }
      str = paramAttach.getName();
      if (FileUtil.getOpenType(getActivity(), FileUtil.getFileNameSuffix(str)) == 2) {
        break label140;
      }
      localBottomListSheetBuilder.addItem(getString(2131692963));
    }
    for (;;)
    {
      if (paramAttach != null)
      {
        localBottomListSheetBuilder.addItem(getString(2131692965));
        localBottomListSheetBuilder.addItem(getString(2131692966));
      }
      localBottomListSheetBuilder.addItem(getString(2131692964));
      localBottomListSheetBuilder.setOnSheetItemClickListener(new DownloadActivity.16(this, paramAttach, paramDownloadInfo));
      localBottomListSheetBuilder.setTitle(str);
      localBottomListSheetBuilder.build().show();
      return;
      label132:
      str = paramDownloadInfo.getFileName();
      break;
      label140:
      str = str + ":" + getString(2131692944);
    }
  }
  
  private void showEmptyView()
  {
    QMLog.log(4, "DownloadActivity", "no any downloadInfo");
    this.mListView.setVisibility(8);
    this.mLoadingView.showTips(2131692955);
    this.mLoadingView.setVisibility(0);
  }
  
  private void showListView()
  {
    if (this.mAdapter == null)
    {
      this.mAdapter = new DownloadAdapter(getActivity(), getDataSource(), false);
      this.mAdapter.setOnStateClickListener(new DownloadActivity.15(this));
      this.mListView.setAdapter(this.mAdapter);
    }
    for (;;)
    {
      this.mLoadingView.setVisibility(8);
      return;
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  private void showLoadingView()
  {
    this.mListView.setVisibility(8);
    this.mLoadingView.showLoading(true);
    this.mLoadingView.setVisibility(0);
  }
  
  private void startImageAttachPreview(DownloadInfo paramDownloadInfo, Attach paramAttach)
  {
    int m = this.mAdapter.getCount();
    ArrayList localArrayList = Lists.newArrayList();
    int j = 0;
    int k;
    for (int i = 0; j < m; i = k)
    {
      Attach localAttach = this.mAdapter.getAttachByPosition(j);
      k = i;
      if (localAttach != null)
      {
        if (localAttach.getHashId() == paramAttach.getHashId()) {
          i = localArrayList.size();
        }
        k = i;
        if (AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(localAttach.getName()))) == AttachType.IMAGE)
        {
          k = i;
          if (!FileUtil.isFileTypeTiff(localAttach.getName()))
          {
            k = i;
            if (FileUtil.isFileExist(localAttach.getPreview().getMyDisk()))
            {
              localArrayList.add(localAttach);
              k = i;
            }
          }
        }
      }
      j += 1;
    }
    if (paramDownloadInfo.getAttachType() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      ImageAttachData.loadData(localArrayList, false, bool);
      if (localArrayList.size() > 0) {
        startActivity(ImageAttachBucketSelectActivity.createDownloadIntent(paramAttach.getAccountId(), i, paramAttach.getFolderId()));
      }
      return;
    }
  }
  
  private void toggleEditState()
  {
    this.mListView.setEnablePullToRefresh(false);
    this.mListView.setCouldScrollDecidByUser(false);
    this.mListView.setChoiceMode(2);
    this.mAdapter.setEditMode(true);
    this.mAdapter.notifyDataSetChanged();
    refreshBottomBar(true);
    refreshTopBar();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mListView.getLayoutParams();
    localLayoutParams.setMargins(0, getResources().getDimensionPixelOffset(2131299664), 0, getResources().getDimensionPixelSize(2131297365));
    this.mListView.setLayoutParams(localLayoutParams);
  }
  
  private void toggleNormalState()
  {
    this.mListView.setEnablePullToRefresh(false);
    this.mListView.setCouldScrollDecidByUser(true);
    setAllSelectState(false);
    this.mListView.setChoiceMode(0);
    this.mAdapter.setEditMode(false);
    this.mAdapter.notifyDataSetChanged();
    refreshBottomBar(false);
    refreshTopBar();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mListView.getLayoutParams();
    localLayoutParams.setMargins(0, getResources().getDimensionPixelOffset(2131299664), 0, 0);
    this.mListView.setLayoutParams(localLayoutParams);
  }
  
  public void initDataSource()
  {
    setDataSource();
  }
  
  public void initDom()
  {
    initTopBar();
    initPopupWindow();
    initListView();
  }
  
  public void initPopupWindow()
  {
    this.mPopWindow = new DownloadActivity.11(this, getActivity(), true);
  }
  
  public void initUI()
  {
    setContentView(2131558485);
    this.mTopBar = ((QMTopBar)findViewById(2131380043));
    this.mTips = new QMTips(this);
    this.mListView = ((ItemScrollListView)findViewById(2131370573));
    this.mLoadingView = ((QMContentLoadingView)findViewById(2131370820));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null)) {
      setAttachDownloadPath(paramIntent.getStringExtra("savePath"));
    }
  }
  
  public void onBackPressed()
  {
    if (isEditing())
    {
      toggleNormalState();
      return;
    }
    onButtonBackClick();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.downloadWatcher, paramBoolean);
    Watchers.bind(this.ftnDownloadWatcher, paramBoolean);
    if (paramBoolean)
    {
      QMNotification.registNotification("actiongetshareurlsucc", this.observerGetFtnShareUrlSuccess);
      QMNotification.registNotification("actiongetshareurlerror", this.observerGetFtnShareUrlError);
      return;
    }
    QMNotification.unregistNotification("actiongetshareurlsucc", this.observerGetFtnShareUrlSuccess);
    QMNotification.unregistNotification("actiongetshareurlerror", this.observerGetFtnShareUrlError);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return this.mListView.isFold();
  }
  
  public void onRelease()
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.getSelectDownloadInfo().clear();
      this.mAdapter = null;
      this.mListView.setAdapter(null);
    }
  }
  
  public void refreshData()
  {
    refreshData(null);
  }
  
  public void render()
  {
    doRender();
  }
  
  public void showPopMenuWindow(View paramView)
  {
    if ((this.mPopWindow == null) || (paramView == null)) {
      return;
    }
    if (this.mPopWindow.isShowing()) {
      this.mPopWindow.dismiss();
    }
    Object localObject = Lists.newArrayList();
    ((List)localObject).add(getString(2131692962));
    ((List)localObject).add(getString(2131692959));
    String str = FileUtil.getAttachDownloadDir();
    if ((str != null) && (!str.equals(QMPathManager.sharedInstance().getAttachDownloadPath()))) {
      ((List)localObject).add(getString(2131692961));
    }
    ((List)localObject).add(getString(2131692958));
    localObject = new PopupAdapter(getActivity(), 2131559771, 2131373495, (List)localObject);
    this.mPopWindow.setAdapter((ListAdapter)localObject);
    this.mPopWindow.setAnchor(paramView);
    this.mPopWindow.showDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity
 * JD-Core Version:    0.7.0.1
 */