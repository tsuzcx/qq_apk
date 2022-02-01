package com.tencent.qqmail.movemail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.MailMoveWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMListItemView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.sectionlist.SectionListAdapter.MoveMailAndTagMailViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import moai.core.watcher.Watchers;

public class MoveMailActivity
  extends MoveActivity
{
  private static final String ARG_ACCOUNTID = "arg_movemail_accountid";
  @Deprecated
  public static final String ARG_CURRENT_FOLDER_INDEX = "currFolderIndex";
  private static final String ARG_FOLDERID = "arg_movemail_folderid";
  @Deprecated
  public static final String ARG_MAILIDS = "mailIds";
  private static final String ARG_MOVE_MAILIDS = "arg_movemail_mailids";
  public static final int CREATE_FOLDER = 1;
  private static final int NO_SELECTED_FOLDERID = -1;
  public static final String RETURN_RESULT = "return_movemail_result";
  public static final String TAG = "MoveMailActivity";
  private int desFolderId = 0;
  private boolean isCreateRule = false;
  private int mAccountId;
  private int mFolderId;
  private long[] mMailids;
  private final MailOperate mailOperate = new MailOperate();
  private final MailMoveWatcher moveWatcher = new MoveMailActivity.1(this);
  private int selectedRow = -1;
  
  public static Intent createIntent(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MoveMailActivity.class);
    localIntent.putExtra("arg_movemail_accountid", paramInt1);
    localIntent.putExtra("arg_movemail_folderid", paramInt2);
    localIntent.putExtra("arg_movemail_mailids", paramArrayOfLong);
    return localIntent;
  }
  
  private String getDefaultFoldername()
  {
    Object localObject;
    if ((this.mMailids != null) && (this.mMailids.length == 1))
    {
      localObject = QMMailManager.sharedInstance().readMailInfo(this.mMailids[0], false);
      if ((localObject != null) && (((Mail)localObject).getStatus() != null) && (!((Mail)localObject).getStatus().isConversation())) {
        break label53;
      }
    }
    label53:
    do
    {
      return null;
      localObject = ((Mail)localObject).getInformation().getFrom().getName();
    } while (localObject == null);
    return (String)localObject + "的文件夹";
  }
  
  private ArrayList<QMFolder> getDisplayFolderData()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    Object localObject = QMFolderManager.sharedInstance().getFoldersByAccountId(this.mAccountId);
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      QMFolder localQMFolder = (QMFolder)((Iterator)localObject).next();
      if (localAccount.isQQMail())
      {
        if ((localQMFolder.getType() == 4) || (localQMFolder.getType() == 8) || (localQMFolder.getType() == 5) || (localQMFolder.getType() == 6) || (localQMFolder.getType() == 102) || (localQMFolder.getType() == 14) || (localQMFolder.getType() == 15) || (localQMFolder.getId() == -2) || (localQMFolder.getType() == 16)) {}
      }
      else {
        do
        {
          localArrayList.add(localQMFolder);
          if (this.mFolderId == localQMFolder.getId()) {
            this.selectedRow = i;
          }
          i += 1;
          break;
          if ((localQMFolder.getType() == 4) || (localQMFolder.getType() == 14) || (localQMFolder.getId() == -2)) {
            break;
          }
        } while (localQMFolder.getType() != 16);
      }
    }
    return localArrayList;
  }
  
  protected View.OnClickListener getBottomBarListener()
  {
    return new MoveMailActivity.2(this);
  }
  
  protected String getBottomText()
  {
    return getString(2131696294);
  }
  
  protected String getTitleText()
  {
    return getString(2131696004);
  }
  
  public void initDataSource()
  {
    this.mMailids = getIntent().getLongArrayExtra("arg_movemail_mailids");
    this.mFolderId = getIntent().getIntExtra("arg_movemail_folderid", -1);
    this.mAccountId = getIntent().getIntExtra("arg_movemail_accountid", 0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      QMTips localQMTips = getTips();
      localQMTips.setCanceledOnTouchOutside(false);
      localQMTips.showLoading("");
      this.isCreateRule = paramIntent.getBooleanExtra("createRule", false);
      this.desFolderId = paramIntent.getIntExtra("folderId", 0);
      QMLog.log(4, "MoveMailActivity", "afterCreateRule: MoveMail - onActivityResult  isCreateRule:" + this.isCreateRule + ", desFolderId:" + this.desFolderId);
      if (this.isCreateRule) {
        break label138;
      }
      this.mailOperate.moveMail(this.mAccountId, this.mFolderId, this.mMailids, this.desFolderId);
    }
    for (;;)
    {
      getTopBar().getButtonRight().setClickable(false);
      return;
      label138:
      finish();
    }
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.moveWatcher, true);
  }
  
  protected boolean onClickConfirm(View paramView)
  {
    QMTips localQMTips = getTips();
    int i = this.mListView.getCheckedItemPosition();
    if (i == -1)
    {
      localQMTips.showInfo(getString(2131696002));
      return false;
    }
    paramView.setClickable(false);
    paramView.setSelected(true);
    i = ((QMFolder)this.mListView.getItemAtPosition(i)).getId();
    if (i == this.mFolderId)
    {
      localQMTips.showError(getString(2131696003));
      paramView.setClickable(true);
      return false;
    }
    this.mailOperate.moveMail(this.mAccountId, this.mFolderId, this.mMailids, i);
    return true;
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    overridePendingTransition(2130772423, 2130772068);
  }
  
  public void onRelease()
  {
    Watchers.bind(this.moveWatcher, false);
    this.mailOperate.clear();
  }
  
  public void refreshData()
  {
    MoveMailAdapter localMoveMailAdapter = new MoveMailAdapter(this, 0, getDisplayFolderData());
    this.mListView.setAdapter(localMoveMailAdapter);
    this.mListView.setChoiceMode(1);
    this.mListView.setItemChecked(this.selectedRow, true);
  }
  
  static class MoveMailAdapter
    extends ArrayAdapter<QMFolder>
  {
    LayoutInflater inflater = LayoutInflater.from(getContext());
    
    public MoveMailAdapter(Context paramContext, int paramInt, List<QMFolder> paramList)
    {
      super(paramInt, paramList);
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      QMListItemView localQMListItemView = (QMListItemView)paramView;
      SectionListAdapter.MoveMailAndTagMailViewHolder localMoveMailAndTagMailViewHolder;
      Object localObject;
      int i;
      label114:
      int j;
      if (localQMListItemView == null)
      {
        localQMListItemView = (QMListItemView)this.inflater.inflate(2131559673, paramViewGroup, false);
        localQMListItemView.setItemToEditMode();
        localMoveMailAndTagMailViewHolder = new SectionListAdapter.MoveMailAndTagMailViewHolder();
        localMoveMailAndTagMailViewHolder.imageView = ((ImageView)localQMListItemView.findViewById(2131371979));
        localMoveMailAndTagMailViewHolder.textView = ((TextView)localQMListItemView.findViewById(2131371980));
        localQMListItemView.setTag(localMoveMailAndTagMailViewHolder);
        localObject = (QMFolder)getItem(paramInt);
        localMoveMailAndTagMailViewHolder.textView.setText(((QMFolder)localObject).getName());
        if (((QMFolder)localObject).getParentId() != -7) {
          break label181;
        }
        i = 1;
        if (((QMFolder)localObject).getParentId() != -8) {
          break label187;
        }
        j = 1;
        label127:
        if (i == 0) {
          break label193;
        }
        localMoveMailAndTagMailViewHolder.imageView.setImageResource(2130840960);
        localMoveMailAndTagMailViewHolder.imageView.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localQMListItemView;
        localMoveMailAndTagMailViewHolder = (SectionListAdapter.MoveMailAndTagMailViewHolder)localQMListItemView.getTag();
        break;
        label181:
        i = 0;
        break label114;
        label187:
        j = 0;
        break label127;
        label193:
        if (j != 0)
        {
          localObject = ((QMFolder)localObject).getPopEmail().split("@");
          if ((localObject != null) && (localObject.length == 2))
          {
            localMoveMailAndTagMailViewHolder.imageView.setImageResource(QMUIHelper.getDrawableByDomain(localObject[1]));
            localMoveMailAndTagMailViewHolder.imageView.setVisibility(0);
          }
        }
        else
        {
          i = IListFolder.getSystemFolderDrawableResId(((QMFolder)localObject).getType());
          if (i != 0)
          {
            localMoveMailAndTagMailViewHolder.imageView.setImageResource(i);
            localMoveMailAndTagMailViewHolder.imageView.setVisibility(0);
          }
          else
          {
            localMoveMailAndTagMailViewHolder.imageView.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.MoveMailActivity
 * JD-Core Version:    0.7.0.1
 */