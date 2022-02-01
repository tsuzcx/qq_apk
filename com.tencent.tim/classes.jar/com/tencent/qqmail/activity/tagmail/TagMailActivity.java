package com.tencent.qqmail.activity.tagmail;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.MailTagWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailTag;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.movemail.ManageFolderActivity;
import com.tencent.qqmail.qmui.alpha.QMUIAlphaButton;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import moai.core.watcher.Watchers;
import moai.fragment.app.ActivityCompat;

public class TagMailActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNTID = "arg_tagmail_accountid";
  private static final String ARG_CONV_CHILDLIST = "arg_tagmail_fromconvchildlist";
  private static final String ARG_MAILIDS = "arg_tagmail_mailids";
  public static final String ARG_TAG_CONFIRM = "arg_tagmail_confirm";
  public static final String ARG_TAG_MAILIDS = "arg_tagmail_mailids";
  private static final int CREATE_TAG = 1;
  public static final String TAG = "TagMailActivity";
  public static final String TOGGLE_VIEW_TYPE = "TOGGLE_VIEW_TYPE";
  private boolean hasNoTagAlertShown = false;
  private int mAccountId;
  private QMBottomBar mBottomBar;
  private HashMap<String, String> mChildTagList = new HashMap();
  private boolean mIsFromConvChildList;
  private QMContentLoadingView mListEmptyView;
  private ListView mListView;
  private long[] mMailids;
  private QMTips mQmTips = null;
  private HashMap<Long, Long> mSelectMailIds = new HashMap();
  private ArrayList<QMFolder> mTagFolders = null;
  View.OnClickListener onAddNewTag = new TagMailActivity.4(this);
  private final MailTagWatcher tagmailWatcher = new TagMailActivity.1(this);
  
  public static Intent createIntent(int paramInt, ArrayList<Long> paramArrayList)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), TagMailActivity.class);
    localIntent.putExtra("arg_tagmail_accountid", paramInt);
    long[] arrayOfLong = new long[paramArrayList.size()];
    paramInt = 0;
    while (paramInt < paramArrayList.size())
    {
      arrayOfLong[paramInt] = ((Long)paramArrayList.get(paramInt)).longValue();
      paramInt += 1;
    }
    localIntent.putExtra("arg_tagmail_mailids", arrayOfLong);
    return localIntent;
  }
  
  public static Intent createIntent(int paramInt, ArrayList<Long> paramArrayList, boolean paramBoolean)
  {
    paramArrayList = createIntent(paramInt, paramArrayList);
    paramArrayList.putExtra("arg_tagmail_fromconvchildlist", paramBoolean);
    return paramArrayList;
  }
  
  public static Intent createIntent(int paramInt, long[] paramArrayOfLong)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), TagMailActivity.class);
    localIntent.putExtra("arg_tagmail_accountid", paramInt);
    localIntent.putExtra("arg_tagmail_mailids", paramArrayOfLong);
    return localIntent;
  }
  
  public static Intent createIntent(int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    paramArrayOfLong = createIntent(paramInt, paramArrayOfLong);
    paramArrayOfLong.putExtra("arg_tagmail_fromconvchildlist", paramBoolean);
    return paramArrayOfLong;
  }
  
  private void gotoManageFolder()
  {
    startActivityForResult(ManageFolderActivity.createIntentForOne(this.mAccountId, null, true, false), 1);
  }
  
  private void hackGetTagFolder()
  {
    Object localObject = QMFolderManager.sharedInstance().getFoldersByAccountId(this.mAccountId);
    this.mTagFolders = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      QMFolder localQMFolder = (QMFolder)((Iterator)localObject).next();
      if (localQMFolder.getType() == 14) {
        this.mTagFolders.add(localQMFolder);
      }
    }
  }
  
  private void hideTips()
  {
    if (this.mQmTips != null) {
      this.mQmTips.hideDialog();
    }
  }
  
  private void initBottomBar()
  {
    QMUIAlphaButton localQMUIAlphaButton = this.mBottomBar.addButton(0, getString(2131696312), this.onAddNewTag);
    ViewGroup.LayoutParams localLayoutParams = localQMUIAlphaButton.getLayoutParams();
    localLayoutParams.width = QMUIKit.dpToPx(150);
    localQMUIAlphaButton.setLayoutParams(localLayoutParams);
  }
  
  private boolean isTagConvChildList()
  {
    return (this.mIsFromConvChildList) && (this.mMailids.length > 0);
  }
  
  private void onClickConfirm(View paramView)
  {
    int j = 0;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramView = this.mListView.getCheckedItemPositions();
    int i = 0;
    while (i < paramView.size())
    {
      int k = paramView.keyAt(i);
      if (paramView.valueAt(i))
      {
        localObject = (QMFolder)this.mListView.getItemAtPosition(k);
        if (localObject != null) {
          localArrayList1.add(((QMFolder)localObject).getRemoteId());
        }
      }
      i += 1;
    }
    paramView = this.mTagFolders.iterator();
    while (paramView.hasNext())
    {
      localObject = (QMFolder)paramView.next();
      if (!localArrayList1.contains(((QMFolder)localObject).getRemoteId())) {
        localArrayList2.add(((QMFolder)localObject).getRemoteId());
      }
    }
    paramView = null;
    Object localObject = new MailOperate();
    if (isTagConvChildList())
    {
      long l = QMMailManager.sharedInstance().getConvParentId(this.mMailids[0]);
      paramView = new long[this.mMailids.length + 1];
      i = j;
      while (i < this.mMailids.length)
      {
        paramView[i] = this.mMailids[i];
        i += 1;
      }
      paramView[this.mMailids.length] = l;
    }
    i = this.mAccountId;
    if (isTagConvChildList()) {}
    for (;;)
    {
      ((MailOperate)localObject).tagMail(i, paramView, (String[])localArrayList1.toArray(new String[localArrayList1.size()]), (String[])localArrayList2.toArray(new String[localArrayList2.size()]));
      return;
      paramView = this.mMailids;
    }
  }
  
  private void renderTagMailListData()
  {
    boolean[] arrayOfBoolean = new boolean[this.mTagFolders.size()];
    int i;
    int j;
    if (this.mMailids.length == 1)
    {
      localObject = QMMailManager.sharedInstance().readMail(this.mMailids[0], false);
      if ((localObject != null) && (((Mail)localObject).getInformation() != null))
      {
        localObject = ((Mail)localObject).getInformation().getTagList();
        int k = ((ArrayList)localObject).size();
        i = 0;
        while (i < k)
        {
          int m = this.mTagFolders.size();
          j = 0;
          while (j < m)
          {
            if (((QMFolder)this.mTagFolders.get(j)).getRemoteId().equals(((MailTag)((ArrayList)localObject).get(i)).getTagId())) {
              arrayOfBoolean[j] = true;
            }
            j += 1;
          }
          i += 1;
        }
      }
    }
    Object localObject = new TagMailAdapter(this, 0, this.mTagFolders);
    this.mListView.setAdapter((ListAdapter)localObject);
    if (arrayOfBoolean.length > 0)
    {
      j = arrayOfBoolean.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfBoolean[i] != 0) {
          this.mListView.setItemChecked(this.mListView.getHeaderViewsCount() + i, true);
        }
        i += 1;
      }
    }
  }
  
  private static int[] toArray(List<Integer> paramList)
  {
    int j = paramList.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void initDataSource()
  {
    Bundle localBundle = getIntent().getExtras();
    this.mMailids = localBundle.getLongArray("arg_tagmail_mailids");
    this.mAccountId = localBundle.getInt("arg_tagmail_accountid");
    this.mIsFromConvChildList = localBundle.getBoolean("arg_tagmail_fromconvchildlist");
  }
  
  public void initDom()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131720744).setButtonLeftNormal(2131691246);
    localQMTopBar.setButtonRightBlue(2131696547);
    localQMTopBar.getButtonRight().setOnClickListener(new TagMailActivity.2(this));
    localQMTopBar.getButtonLeft().setOnClickListener(new TagMailActivity.3(this));
    this.mListView.setChoiceMode(2);
    initBottomBar();
  }
  
  public void initUI()
  {
    Object localObject = initBaseView(this);
    ((QMBaseView)localObject).setBackgroundColor(ActivityCompat.getColor(this, 2131167681));
    this.mListView = ((QMBaseView)localObject).addPtrListView(false);
    this.mListEmptyView = ((QMBaseView)localObject).addListEmptyView();
    this.mBottomBar = new QMBottomBar(this);
    ((QMBaseView)localObject).addView(this.mBottomBar);
    localObject = (FrameLayout.LayoutParams)this.mListView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, getResources().getDimensionPixelSize(2131297365));
    this.mListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.mListEmptyView.hide();
      this.mTagFolders.add(QMFolderManager.sharedInstance().getFolder(paramIntent.getIntExtra("folderId", 0)));
      renderTagMailListData();
      this.mListView.setItemChecked(this.mListView.getCount() - 1, true);
      this.mQmTips = new QMTips(this);
      this.mQmTips.setCanceledOnTouchOutside(false);
      this.mQmTips.showLoading("");
      getTopBar().getButtonRight().performClick();
    }
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.tagmailWatcher, true);
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    overridePendingTransition(2130772423, 2130772068);
  }
  
  public void onRelease()
  {
    Watchers.bind(this.tagmailWatcher, false);
    hideTips();
  }
  
  public void refreshData()
  {
    hackGetTagFolder();
    renderTagMailListData();
    if ((!this.hasNoTagAlertShown) && (this.mTagFolders.size() == 0))
    {
      this.mListEmptyView.showTips(2131696368);
      return;
    }
    this.mListEmptyView.hide();
  }
  
  public void render()
  {
    View localView = getTopBar().getButtonRight();
    if (this.mTagFolders.size() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localView.setEnabled(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.tagmail.TagMailActivity
 * JD-Core Version:    0.7.0.1
 */