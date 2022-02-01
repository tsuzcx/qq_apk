package com.tencent.qqmail.attachment.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.model.AttachmentUI;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.sectionlist.SectionListAdapter.ViewHolderSimple;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ZipOnlinePreviewAdapter
  extends BaseAdapter
{
  private final ArrayList<AttachmentUI> attachmentUIs = new ArrayList();
  private final Context context;
  
  public ZipOnlinePreviewAdapter(Context paramContext, AttachmentUI paramAttachmentUI)
  {
    ValidateHelper.notNull(paramContext);
    ValidateHelper.notNull(paramAttachmentUI);
    this.context = paramContext;
    this.attachmentUIs.addAll(paramAttachmentUI.getAttachmentUIs());
  }
  
  public ArrayList<AttachmentUI> getAttachmentUI()
  {
    return this.attachmentUIs;
  }
  
  public int getCount()
  {
    return this.attachmentUIs.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.attachmentUIs.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    localAttachmentUI = (AttachmentUI)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131559356, paramViewGroup, false);
      paramView = new SectionListAdapter.ViewHolderSimple();
      paramView.imageView = ((ImageView)localView.findViewById(2131367778));
      paramView.chevron = ((ImageView)localView.findViewById(2131364597));
      paramView.titleTextView = ((TextView)localView.findViewById(2131367764));
      paramView.detailTextView = ((TextView)localView.findViewById(2131367765));
      localView.setTag(paramView);
    }
    for (;;)
    {
      localObject = localAttachmentUI.getUrlEncodeDirName();
      try
      {
        String str1 = URLDecoder.decode((String)localObject, "utf-8");
        localObject = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          if (localAttachmentUI.getType().equals("file"))
          {
            String str2 = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(localAttachmentUI.getDirName()))).name().toLowerCase(Locale.getDefault());
            paramView.imageView.setImageResource(ImageResourceUtil.getImageResource(str2, ImageResourceUtil.IMAGE_SIZE_58));
            paramView.titleTextView.setText((CharSequence)localObject);
            localObject = StringExtention.getHumanReadableSizeString(StringExtention.sizeStrToLong(localAttachmentUI.getSize()));
            paramView.detailTextView.setText((CharSequence)localObject);
            paramView.detailTextView.setVisibility(0);
            paramView.chevron.setVisibility(8);
          }
          else
          {
            paramView.imageView.setImageResource(2130840437);
            paramView.titleTextView.setText((CharSequence)localObject);
            localObject = String.format(this.context.getString(2131691934), new Object[] { Integer.valueOf(localAttachmentUI.getDirFileCount()) });
            paramView.detailTextView.setVisibility(0);
            paramView.detailTextView.setText((CharSequence)localObject);
            paramView.chevron.setVisibility(0);
          }
        }
      }
      if (!localAttachmentUI.getType().equals("back")) {
        break;
      }
      paramView.imageView.setImageResource(2130840972);
      paramView.titleTextView.setText((CharSequence)localObject);
      paramView.detailTextView.setText(null);
      paramView.detailTextView.setVisibility(8);
      paramView.chevron.setVisibility(8);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (SectionListAdapter.ViewHolderSimple)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
  
  public void setAttachmentUI(List<AttachmentUI> paramList)
  {
    ValidateHelper.mainThread();
    ValidateHelper.notNull(paramList);
    this.attachmentUIs.clear();
    this.attachmentUIs.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipOnlinePreviewAdapter
 * JD-Core Version:    0.7.0.1
 */