package com.tencent.qqmail.activity.tagmail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMListItemView;
import com.tencent.qqmail.view.sectionlist.SectionListAdapter.MoveMailAndTagMailViewHolder;
import java.util.List;

class TagMailAdapter
  extends ArrayAdapter<QMFolder>
{
  private LayoutInflater inflater;
  
  public TagMailAdapter(Context paramContext, int paramInt, List<QMFolder> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.inflater = LayoutInflater.from(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QMListItemView localQMListItemView = (QMListItemView)paramView;
    SectionListAdapter.MoveMailAndTagMailViewHolder localMoveMailAndTagMailViewHolder;
    if (localQMListItemView == null)
    {
      localQMListItemView = (QMListItemView)this.inflater.inflate(2131563160, paramViewGroup, false);
      localQMListItemView.setItemToEditMode();
      localMoveMailAndTagMailViewHolder = new SectionListAdapter.MoveMailAndTagMailViewHolder();
      localMoveMailAndTagMailViewHolder.imageView = ((ImageView)localQMListItemView.findViewById(2131379243));
      localMoveMailAndTagMailViewHolder.textView = ((TextView)localQMListItemView.findViewById(2131379242));
      localQMListItemView.setTag(localMoveMailAndTagMailViewHolder);
    }
    for (;;)
    {
      QMFolder localQMFolder = (QMFolder)getItem(paramInt);
      localMoveMailAndTagMailViewHolder.textView.setText(localQMFolder.getName());
      QMUIHelper.setMailTagColor(getContext(), localMoveMailAndTagMailViewHolder.imageView, localQMFolder.getColorId());
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localQMListItemView;
      localMoveMailAndTagMailViewHolder = (SectionListAdapter.MoveMailAndTagMailViewHolder)localQMListItemView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.tagmail.TagMailAdapter
 * JD-Core Version:    0.7.0.1
 */