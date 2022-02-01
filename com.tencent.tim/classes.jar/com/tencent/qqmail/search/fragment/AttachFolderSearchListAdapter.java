package com.tencent.qqmail.search.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.cursor.AttachFolderListSearchCursor;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.AttachFolderHelper;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.attachment.view.AttachFolderThumbListener;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.view.QMListItemView;
import java.util.Locale;

public class AttachFolderSearchListAdapter
  extends BaseAdapter
{
  public static final String TAG = "AttachFolderSearchListAdapter";
  private Context mContext;
  private ListView mListView;
  private AttachFolderListSearchCursor mSearchCursor;
  
  public AttachFolderSearchListAdapter(Context paramContext, ListView paramListView, AttachFolderListSearchCursor paramAttachFolderListSearchCursor)
  {
    this.mContext = paramContext;
    this.mListView = paramListView;
    this.mSearchCursor = paramAttachFolderListSearchCursor;
  }
  
  private SearchViewHolder buildViewHolder(View paramView, int paramInt)
  {
    SearchViewHolder localSearchViewHolder = new SearchViewHolder();
    localSearchViewHolder.chevron = ((ImageView)paramView.findViewById(2131364597));
    localSearchViewHolder.thumbnail = ((ImageView)paramView.findViewById(2131379638));
    localSearchViewHolder.name = ((TextView)paramView.findViewById(2131367070));
    localSearchViewHolder.size = ((TextView)paramView.findViewById(2131367074));
    localSearchViewHolder.sender = ((TextView)paramView.findViewById(2131378018));
    localSearchViewHolder.subject = ((TextView)paramView.findViewById(2131378941));
    localSearchViewHolder.position = paramInt;
    localSearchViewHolder.needInflate = false;
    paramView.setTag(localSearchViewHolder);
    return localSearchViewHolder;
  }
  
  private void closeCursor()
  {
    if (this.mSearchCursor != null) {
      this.mSearchCursor.close();
    }
  }
  
  private void fillViewHolder(View paramView, Attach paramAttach, int paramInt, SearchViewHolder paramSearchViewHolder)
  {
    if ((paramAttach == null) || (paramSearchViewHolder == null)) {
      return;
    }
    paramSearchViewHolder.name.setText(paramAttach.getName());
    paramSearchViewHolder.size.setText(paramAttach.getSize());
    paramSearchViewHolder.sender.setText(paramAttach.getMailSender());
    paramSearchViewHolder.subject.setText(paramAttach.getMailSubject());
    paramSearchViewHolder.position = paramInt;
    setThumbnail(paramView, paramSearchViewHolder.thumbnail, paramInt, paramAttach);
  }
  
  private int getViewHolderPosition(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof SearchViewHolder)) {
      return ((SearchViewHolder)paramView).position;
    }
    return -1;
  }
  
  private View inflateView(int paramInt, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(this.mContext).inflate(paramInt, paramViewGroup, false);
  }
  
  private View newListItem(int paramInt1, int paramInt2, ViewGroup paramViewGroup)
  {
    paramViewGroup = inflateView(paramInt1, paramViewGroup);
    buildViewHolder(paramViewGroup, paramInt2);
    return paramViewGroup;
  }
  
  private void setOnItemClick(View paramView, int paramInt)
  {
    long l = getItemId(paramInt);
    paramView.setOnClickListener(new AttachFolderSearchListAdapter.4(this, paramInt, l));
    paramView.setOnLongClickListener(new AttachFolderSearchListAdapter.5(this, paramInt, l));
  }
  
  private void setThumbnail(View paramView, ImageView paramImageView, int paramInt, Attach paramAttach)
  {
    if ((paramImageView == null) || (paramAttach == null)) {
      return;
    }
    String str = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName()))).name().toLowerCase(Locale.getDefault());
    if (str.equals("image"))
    {
      AttachFolderHelper.loadImageThumb(paramAttach.getAccountId(), paramAttach.getPreview().getIcon(), paramInt, paramImageView, false, new AttachFolderThumbListener("AttachFolderSearchListAdapter", this.mContext, paramAttach.getAccountId(), paramView, paramImageView, paramInt, new AttachFolderSearchListAdapter.3(this)));
      return;
    }
    AttachFolderHelper.setDefaultThumbByType(paramImageView, str);
  }
  
  public int getCount()
  {
    if (this.mSearchCursor == null) {
      return 0;
    }
    return this.mSearchCursor.getCount();
  }
  
  public AttachFolderListSearchCursor getCursor()
  {
    return this.mSearchCursor;
  }
  
  public Attach getItem(int paramInt)
  {
    if (this.mSearchCursor == null) {
      return null;
    }
    return this.mSearchCursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (this.mSearchCursor == null) {
      return 0L;
    }
    return this.mSearchCursor.getItemId(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Attach localAttach = getItem(paramInt);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if ((paramView.getTag() instanceof SearchViewHolder)) {}
    }
    else
    {
      localObject = newListItem(2131558756, paramInt, paramViewGroup);
    }
    SearchViewHolder localSearchViewHolder = (SearchViewHolder)((View)localObject).getTag();
    if (localSearchViewHolder.needInflate) {}
    for (paramView = newListItem(2131558756, paramInt, paramViewGroup);; paramView = (View)localObject)
    {
      localObject = (QMListItemView)paramView;
      if (localObject != null)
      {
        ((QMListItemView)localObject).bindItemChevron(localSearchViewHolder.chevron);
        ((QMListItemView)localObject).setItemToNormalMode();
      }
      fillViewHolder(paramView, localAttach, paramInt, localSearchViewHolder);
      setOnItemClick(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public void resetCursor()
  {
    try
    {
      closeCursor();
      notifyDataSetChanged();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCursor(AttachFolderListSearchCursor paramAttachFolderListSearchCursor)
  {
    if (this.mSearchCursor != paramAttachFolderListSearchCursor)
    {
      if (this.mSearchCursor != null) {
        this.mSearchCursor.close();
      }
      this.mSearchCursor = paramAttachFolderListSearchCursor;
    }
  }
  
  public void update(boolean paramBoolean, Runnable paramRunnable)
  {
    try
    {
      if (this.mSearchCursor != null) {
        this.mSearchCursor.asyncSearch(paramBoolean, new AttachFolderSearchListAdapter.1(this), new AttachFolderSearchListAdapter.2(this, paramRunnable));
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public static class SearchViewHolder
  {
    public ImageView chevron = null;
    public TextView name = null;
    public boolean needInflate;
    public int position;
    public TextView sender = null;
    public TextView size = null;
    public TextView subject = null;
    public ImageView thumbnail = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListAdapter
 * JD-Core Version:    0.7.0.1
 */