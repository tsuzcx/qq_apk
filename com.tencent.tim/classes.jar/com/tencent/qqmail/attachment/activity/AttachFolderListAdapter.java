package com.tencent.qqmail.attachment.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.common.base.Strings;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.attachment.cursor.IAttachFolderListCursor;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachFolderListLockTip;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.attachment.util.AttachFolderHelper;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.attachment.view.AttachFolderThumbListener;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.view.QMListItemView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class AttachFolderListAdapter
  extends BaseAdapter
{
  protected static final int ITEM_VIEW_TYPE_ATTACH = 0;
  protected static final int ITEM_VIEW_TYPE_LOCK = 1;
  public static final String TAG = "AttachFolderListAdapter";
  private boolean isEditing;
  private boolean isFastScroll;
  private Set<Long> mCheckSet;
  private Context mContext;
  private IAttachFolderListCursor mCursor;
  private ListView mListView;
  private AttachFolderListLockTip mLockTip;
  
  public AttachFolderListAdapter(Context paramContext, AttachFolderListCursor paramAttachFolderListCursor, ListView paramListView, Set<Long> paramSet)
  {
    this.mListView = paramListView;
    this.mCursor = paramAttachFolderListCursor;
    this.mContext = paramContext;
    this.mLockTip = new AttachFolderListLockTip();
    this.mLockTip.setLockAcctCount(calcLockCount());
    this.mCheckSet = paramSet;
  }
  
  private LockTipViewHolder buildLockTipViewHolder(View paramView, int paramInt1, int paramInt2)
  {
    LockTipViewHolder localLockTipViewHolder = new LockTipViewHolder();
    localLockTipViewHolder.lockTip = ((TextView)paramView.findViewById(2131370873));
    localLockTipViewHolder.lockCount = paramInt2;
    localLockTipViewHolder.position = paramInt1;
    if (paramInt2 > 1)
    {
      String str = String.format(this.mContext.getResources().getString(2131690606), new Object[] { Integer.valueOf(paramInt2) });
      localLockTipViewHolder.lockTip.setText(str);
    }
    paramView.setTag(localLockTipViewHolder);
    return localLockTipViewHolder;
  }
  
  private AttachViewHolder buildViewHolder(View paramView, int paramInt)
  {
    AttachViewHolder localAttachViewHolder = new AttachViewHolder();
    localAttachViewHolder.thumbnail = ((ImageView)paramView.findViewById(2131379638));
    localAttachViewHolder.name = ((TextView)paramView.findViewById(2131367070));
    localAttachViewHolder.size = ((TextView)paramView.findViewById(2131367074));
    localAttachViewHolder.sender = ((TextView)paramView.findViewById(2131378018));
    localAttachViewHolder.subject = ((TextView)paramView.findViewById(2131378941));
    localAttachViewHolder.position = paramInt;
    localAttachViewHolder.needInflate = false;
    paramView.setTag(localAttachViewHolder);
    return localAttachViewHolder;
  }
  
  private int calcLockCount()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if ((!localAccount.isQQMail()) || (!QMSettingManager.sharedInstance().getAttachFolderLockStatus(localAccount.getId()))) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private int calcRelativePosition(int paramInt)
  {
    int i = paramInt;
    if (hasLockTip()) {
      i = paramInt - 1;
    }
    return i;
  }
  
  private void fillLockTipViewHolder(int paramInt1, int paramInt2, LockTipViewHolder paramLockTipViewHolder)
  {
    paramLockTipViewHolder.lockCount = paramInt2;
    paramLockTipViewHolder.position = paramInt1;
    paramLockTipViewHolder.lockTip.setText(2131690603);
    if (paramInt2 > 1)
    {
      String str = String.format(this.mContext.getResources().getString(2131690606), new Object[] { Integer.valueOf(paramInt2) });
      paramLockTipViewHolder.lockTip.setText(str);
    }
  }
  
  private void fillViewHolder(View paramView, Attach paramAttach, int paramInt, AttachViewHolder paramAttachViewHolder)
  {
    if ((paramAttach == null) || (paramAttachViewHolder == null)) {
      return;
    }
    paramAttachViewHolder.name.setText(paramAttach.getName());
    paramAttachViewHolder.size.setText(paramAttach.getSize());
    if (Strings.isNullOrEmpty(paramAttach.getMailSender()))
    {
      paramAttachViewHolder.sender.setVisibility(8);
      if (!Strings.isNullOrEmpty(paramAttach.getMailSubject())) {
        break label118;
      }
      paramAttachViewHolder.subject.setVisibility(8);
    }
    for (;;)
    {
      paramAttachViewHolder.position = paramInt;
      setThumbnail(paramView, paramAttachViewHolder.thumbnail, paramInt, paramAttach, false);
      return;
      paramAttachViewHolder.sender.setVisibility(0);
      paramAttachViewHolder.sender.setText(paramAttach.getMailSender());
      break;
      label118:
      paramAttachViewHolder.subject.setVisibility(0);
      paramAttachViewHolder.subject.setText(paramAttach.getMailSubject());
    }
  }
  
  private int getViewHolderPosition(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof AttachViewHolder)) {
      return ((AttachViewHolder)paramView).position;
    }
    return -1;
  }
  
  private View inflateView(int paramInt, ViewGroup paramViewGroup)
  {
    Context localContext1 = this.mContext;
    Context localContext2 = this.mContext;
    return ((LayoutInflater)localContext1.getSystemService("layout_inflater")).inflate(paramInt, paramViewGroup, false);
  }
  
  private View newListItem(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    paramViewGroup = inflateView(paramInt1, paramViewGroup);
    buildViewHolder(paramViewGroup, paramInt2);
    return paramViewGroup;
  }
  
  private View newLockTipItem(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    paramViewGroup = inflateView(paramInt1, paramViewGroup);
    buildLockTipViewHolder(paramViewGroup, paramInt2, paramInt3);
    return paramViewGroup;
  }
  
  private void setOnItemClick(View paramView, int paramInt)
  {
    long l = getItemId(paramInt);
    paramView.setOnClickListener(new AttachFolderListAdapter.2(this, paramInt, l));
    paramView.setOnLongClickListener(new AttachFolderListAdapter.3(this, paramInt, l));
  }
  
  private void setThumbnail(View paramView, ImageView paramImageView, int paramInt, Attach paramAttach, boolean paramBoolean)
  {
    if ((paramImageView == null) || (paramAttach == null)) {}
    String str;
    do
    {
      return;
      str = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName()))).name().toLowerCase(Locale.getDefault());
      if (str.equals("image"))
      {
        AttachFolderHelper.loadImageThumb(paramAttach.getAccountId(), paramAttach.getPreview().getIcon(), paramInt, paramImageView, this.isFastScroll, new AttachFolderThumbListener("AttachFolderListAdapter", this.mContext, paramAttach.getAccountId(), paramView, paramImageView, paramInt, new AttachFolderListAdapter.1(this)));
        return;
      }
    } while (paramBoolean);
    AttachFolderHelper.setDefaultThumbByType(paramImageView, str);
  }
  
  public ArrayList<LockInfo> getAttachFolderLockInfoList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if ((localAccount.isQQMail()) && (QMSettingManager.sharedInstance().getAttachFolderLockStatus(localAccount.getId()))) {
        localArrayList.add(new LockInfo(localAccount.getId(), 0, localAccount.getEmail()));
      }
    }
    return localArrayList;
  }
  
  public int getCount()
  {
    int j = 1;
    int i = 1;
    if (this.mCursor != null)
    {
      j = this.mCursor.getCount();
      if (hasLockTip()) {
        i += j;
      }
    }
    do
    {
      return i;
      i = 0;
      break;
      i = j;
    } while (hasLockTip());
    return -1;
  }
  
  public IAttachFolderListCursor getCursor()
  {
    return this.mCursor;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.mCursor == null) {
      return null;
    }
    paramInt = calcRelativePosition(paramInt);
    if (paramInt < 0) {
      return this.mLockTip;
    }
    return this.mCursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (this.mCursor == null) {}
    do
    {
      return 0L;
      paramInt = calcRelativePosition(paramInt);
    } while (paramInt < 0);
    return this.mCursor.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (hasLockTip())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    int i;
    if (getItemViewType(paramInt) == 1)
    {
      i = this.mLockTip.getLockAcctCount();
      if (paramView != null)
      {
        localObject = paramView;
        if ((paramView.getTag() instanceof LockTipViewHolder)) {}
      }
      else
      {
        localObject = newLockTipItem(paramViewGroup, 2131559494, paramInt, i);
      }
      ((View)localObject).setEnabled(true);
      fillLockTipViewHolder(paramInt, i, (LockTipViewHolder)((View)localObject).getTag());
      setOnItemClick((View)localObject, paramInt);
      paramView = (View)localObject;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    Attach localAttach;
    if ((localObject instanceof Attach))
    {
      localAttach = (Attach)localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if ((paramView.getTag() instanceof AttachViewHolder)) {}
      }
      else
      {
        localObject = newListItem(paramViewGroup, 2131558756, paramInt);
      }
      if (!((AttachViewHolder)((View)localObject).getTag()).needInflate) {
        break label312;
      }
    }
    label312:
    for (paramView = newListItem(paramViewGroup, 2131558756, paramInt);; paramView = (View)localObject)
    {
      localObject = (AttachViewHolder)paramView.getTag();
      QMListItemView localQMListItemView = (QMListItemView)paramView;
      if (this.isEditing) {
        localQMListItemView.setItemToEditMode();
      }
      for (;;)
      {
        fillViewHolder(paramView, localAttach, paramInt, (AttachViewHolder)localObject);
        setOnItemClick(paramView, paramInt);
        i = this.mListView.getHeaderViewsCount() + paramInt;
        if ((this.mCheckSet.contains(Long.valueOf(localAttach.getHashId()))) && (!this.mListView.isItemChecked(i))) {
          this.mListView.setItemChecked(i, true);
        }
        localObject = paramView;
        break;
        localQMListItemView.setItemToNormalMode();
      }
      throw new DevRuntimeException("item param type error " + String.valueOf(localObject));
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean hasLockTip()
  {
    return this.mLockTip.getLockAcctCount() > 0;
  }
  
  public void setCursor(AttachFolderListCursor paramAttachFolderListCursor)
  {
    this.mCursor = paramAttachFolderListCursor;
    notifyDataSetChanged();
  }
  
  public void setIsEditing(boolean paramBoolean)
  {
    this.isEditing = paramBoolean;
  }
  
  public void setIsFastScroll(boolean paramBoolean)
  {
    this.isFastScroll = paramBoolean;
  }
  
  public void setThumbnail(int paramInt, View paramView)
  {
    Object localObject = getItem(paramInt);
    Attach localAttach;
    if ((getItemViewType(paramInt) != 1) && ((localObject instanceof Attach)))
    {
      localAttach = (Attach)localObject;
      AttachViewHolder localAttachViewHolder = (AttachViewHolder)paramView.getTag();
      if (localAttachViewHolder == null) {
        break label71;
      }
      localObject = localAttachViewHolder.thumbnail;
      localAttachViewHolder.position = paramInt;
      paramView.setTag(localAttachViewHolder);
    }
    for (;;)
    {
      setThumbnail(paramView, (ImageView)localObject, paramInt, localAttach, true);
      return;
      label71:
      localObject = (ImageView)paramView.findViewById(2131379638);
    }
  }
  
  public boolean updateLockCount()
  {
    int i = calcLockCount();
    if (i != this.mLockTip.getLockAcctCount())
    {
      this.mLockTip.setLockAcctCount(i);
      return true;
    }
    return false;
  }
  
  public static class AttachViewHolder
  {
    public TextView name = null;
    public boolean needInflate;
    public int position;
    public TextView sender = null;
    public TextView size = null;
    public TextView subject = null;
    public ImageView thumbnail = null;
  }
  
  public static class LockTipViewHolder
  {
    public int lockCount;
    public TextView lockTip;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListAdapter
 * JD-Core Version:    0.7.0.1
 */