package com.tencent.qqmail.search.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.uidomain.NoteUI;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class SearchNoteListAdapter
  extends ArrayAdapter<NoteUI>
{
  public static final int TYPE_LOAD_MORE = 1;
  public static final int TYPE_NORMAL = 0;
  private Context context;
  private LayoutInflater layoutInflater;
  private NoteUI noteUI;
  
  public SearchNoteListAdapter(Context paramContext, int paramInt, NoteUI paramNoteUI)
  {
    super(paramContext, paramInt);
    this.context = paramContext;
    this.noteUI = paramNoteUI;
    this.layoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void findHolderParamView(View paramView, ViewHolder paramViewHolder)
  {
    if ((paramView != null) && (paramViewHolder != null))
    {
      paramViewHolder.content = ((TextView)paramView.findViewById(2131372508));
      paramViewHolder.subject = ((TextView)paramView.findViewById(2131372511));
      paramViewHolder.time = ((TextView)paramView.findViewById(2131372509));
      paramViewHolder.image = ((ImageView)paramView.findViewById(2131379637));
      paramViewHolder.star = ((ImageView)paramView.findViewById(2131372510));
      paramViewHolder.audioimage = ((ImageView)paramView.findViewById(2131379636));
    }
  }
  
  private void setHolderParam(ViewHolder paramViewHolder, NoteUI paramNoteUI)
  {
    Object localObject = StringExtention.htmlEncode(this.noteUI.getAbstract()).replaceAll("<br\\s*/?>", "\n");
    if (((String)localObject).length() > 0)
    {
      paramViewHolder.content.setText((String)localObject + QMUIKit.ELLIPSIZE_FIXED);
      if (this.noteUI.getSubject().length() <= 0) {
        break label342;
      }
      paramViewHolder.subject.setText(this.noteUI.getSubject() + QMUIKit.ELLIPSIZE_FIXED);
      label101:
      localObject = (ViewGroup.MarginLayoutParams)paramViewHolder.subject.getLayoutParams();
      if (!this.noteUI.getStarred()) {
        break label361;
      }
      paramViewHolder.star.setVisibility(0);
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = this.context.getResources().getDimensionPixelSize(2131297829);
      label148:
      localObject = paramViewHolder.star;
      if (!this.noteUI.getStarred()) {
        break label379;
      }
    }
    label342:
    label361:
    label379:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = DateExtension.shortDateName(new Date(this.noteUI.getUpdatetime() * 1000L));
      paramViewHolder.time.setText((CharSequence)localObject);
      localObject = paramViewHolder.image;
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setTag("");
      ((ImageView)localObject).setImageResource(2130841019);
      if (StringUtils.isEmpty(paramNoteUI.getThumbUrl())) {
        break label384;
      }
      paramNoteUI = paramNoteUI.getThumbUrl();
      paramViewHolder.audioimage.setVisibility(8);
      paramViewHolder = paramNoteUI.replaceAll("^\\s*file://localhost", "file://");
      QMLog.log(2, "thumbimageurl", paramViewHolder);
      ((ImageView)localObject).setTag(paramViewHolder);
      paramNoteUI = new DownloadInfo();
      paramNoteUI.setUrl(paramViewHolder);
      paramNoteUI.setAccountId(NoteManager.sharedInstance().mCurAccountId);
      paramNoteUI.setImageDownloadListener(new SearchNoteListAdapter.1(this, (ImageView)localObject));
      ImageDownloadManager.shareInstance().fetchImage(paramNoteUI);
      return;
      paramViewHolder.content.setText(this.context.getString(2131696411));
      break;
      paramViewHolder.subject.setText(this.context.getString(2131696420));
      break label101;
      paramViewHolder.star.setVisibility(8);
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
      break label148;
    }
    label384:
    if (!paramNoteUI.getAudio().equals("0"))
    {
      paramViewHolder.audioimage.setVisibility(0);
      paramViewHolder.image.setVisibility(8);
      paramViewHolder.audioimage.setImageResource(2130841020);
      return;
    }
    paramViewHolder.image.setVisibility(8);
    paramViewHolder.audioimage.setVisibility(8);
  }
  
  public int getCount()
  {
    if (this.noteUI != null)
    {
      if (this.noteUI.getServerSearch()) {
        return this.noteUI.size() + 1;
      }
      return this.noteUI.size();
    }
    return 0;
  }
  
  public NoteUI getItem(int paramInt)
  {
    if (this.noteUI == null) {
      return null;
    }
    this.noteUI.moveToPosition(paramInt);
    return this.noteUI;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.noteUI != null) && (this.noteUI.getServerSearch()) && (paramInt == getCount() - 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      if (paramView != null) {
        break label167;
      }
      paramView = new MailListMoreItemView(getContext());
      ((AbsListView.LayoutParams)paramView.getLayoutParams()).height = this.context.getResources().getDimensionPixelSize(2131297826);
    }
    label167:
    for (;;)
    {
      ((MailListMoreItemView)paramView).showTips(2131719324);
      Object localObject1 = paramView;
      Object localObject2 = localObject1;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
      if (paramView == null)
      {
        paramView = this.layoutInflater.inflate(2131559709, paramViewGroup, false);
        localObject1 = new ViewHolder(null);
        findHolderParamView(paramView, (ViewHolder)localObject1);
        paramView.setTag(localObject1);
      }
      for (;;)
      {
        this.noteUI.moveToPosition(paramInt);
        setHolderParam((ViewHolder)localObject1, this.noteUI);
        localObject1 = paramView;
        localObject2 = paramView;
        break;
        localObject1 = (ViewHolder)paramView.getTag();
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setItems(NoteUI paramNoteUI)
  {
    this.noteUI = paramNoteUI;
  }
  
  class ViewHolder
  {
    public ImageView audioimage;
    TextView content;
    ImageView image;
    ImageView star;
    TextView subject;
    TextView time;
    
    private ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListAdapter
 * JD-Core Version:    0.7.0.1
 */