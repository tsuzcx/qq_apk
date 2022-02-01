package com.tencent.qqmail.attachment.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AttachFolderUnlockFolderActivity
  extends BaseActivityEx
{
  private static final String ARG_ATTACH_FOLDER_LOCK_INFO = "lockinfos";
  public static final String TAG = AttachFolderUnlockFolderActivity.class.getSimpleName();
  private QMBaseView mBaseView;
  private UITableView.ClickListener mExtensionListOnClickListener = new AttachFolderUnlockFolderActivity.2(this);
  private UITableView mExtensionListTableView;
  private QMUnlockFolderPwdWatcher mFolderLockWatcher = new AttachFolderUnlockFolderActivity.1(this);
  private FolderLockDialog mLockDialog;
  private ArrayList<LockInfo> mLockInfoList = new ArrayList();
  private HashMap<Integer, UITableItemView> mSelectAccountView = new HashMap();
  private QMTopBar mTopBar;
  
  public static Intent createIntent(ArrayList<LockInfo> paramArrayList)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), AttachFolderUnlockFolderActivity.class);
    localIntent.putExtra("lockinfos", paramArrayList);
    return localIntent;
  }
  
  private void initTable()
  {
    this.mExtensionListTableView = new UITableView(this);
    this.mBaseView.addContentView(this.mExtensionListTableView);
    Iterator localIterator = this.mLockInfoList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (LockInfo)localIterator.next();
      localObject = this.mExtensionListTableView.addItem(((LockInfo)localObject).getEmail());
      ((UITableItemView)localObject).setDetail("");
      ((UITableItemView)localObject).hideArrow();
      ((UITableItemView)localObject).setTag(Integer.valueOf(i));
      ((UITableItemView)localObject).setTailImage(2130840882).setVisibility(4);
      i += 1;
    }
    this.mExtensionListTableView.setClickListener(this.mExtensionListOnClickListener);
    this.mExtensionListTableView.commit();
  }
  
  private void initTopBar()
  {
    this.mTopBar = getTopBar();
    this.mTopBar.setTitle(getString(2131690607));
    this.mTopBar.setButtonLeftIcon(2130841088);
    this.mTopBar.setButtonLeftOnclickListener(new AttachFolderUnlockFolderActivity.3(this));
    this.mBaseView.addView(this.mTopBar);
  }
  
  public QMTopBar getTopBar()
  {
    if (this.mTopBar == null) {
      this.mTopBar = new QMTopBar(this);
    }
    return this.mTopBar;
  }
  
  public void initDataSource()
  {
    this.mLockInfoList = ((ArrayList)getIntent().getSerializableExtra("lockinfos"));
  }
  
  public void initDom()
  {
    initTopBar();
    initTable();
  }
  
  public void initUI()
  {
    this.mBaseView = initScrollView(this);
    this.mBaseView.setBackgroundColor(getResources().getColor(2131167681));
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    overridePendingTransition(0, 2130772402);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderUnlockFolderActivity
 * JD-Core Version:    0.7.0.1
 */