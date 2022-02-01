package com.tencent.qqmail.movenote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMListItemView;
import com.tencent.qqmail.view.sectionlist.SectionListAdapter.MoveMailAndTagMailViewHolder;
import java.util.HashMap;
import java.util.List;

public class MoveNoteAdapter
  extends ArrayAdapter<HashMap<String, String>>
{
  public static final String KEY_CATEGORYID = "id";
  public static final String KEY_CATEGORYNAME = "name";
  private int backgroundResid;
  private LayoutInflater inflater;
  
  public MoveNoteAdapter(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.inflater = LayoutInflater.from(paramContext);
    this.backgroundResid = paramInt2;
  }
  
  public MoveNoteAdapter(Context paramContext, int paramInt1, int paramInt2, List<HashMap<String, String>> paramList)
  {
    this(paramContext, paramInt1, paramInt2);
    addAll(paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    HashMap localHashMap = (HashMap)getItem(paramInt);
    QMListItemView localQMListItemView = (QMListItemView)paramView;
    SectionListAdapter.MoveMailAndTagMailViewHolder localMoveMailAndTagMailViewHolder;
    if (localQMListItemView == null)
    {
      localQMListItemView = (QMListItemView)this.inflater.inflate(2131559673, paramViewGroup, false);
      localQMListItemView.setEditModeBackgroundDrawable(ContextCompat.getDrawable(localQMListItemView.getContext(), this.backgroundResid));
      localQMListItemView.setItemToEditMode();
      localMoveMailAndTagMailViewHolder = new SectionListAdapter.MoveMailAndTagMailViewHolder();
      localMoveMailAndTagMailViewHolder.imageView = ((ImageView)localQMListItemView.findViewById(2131371979));
      localMoveMailAndTagMailViewHolder.imageView.setVisibility(8);
      localMoveMailAndTagMailViewHolder.textView = ((TextView)localQMListItemView.findViewById(2131371980));
      localQMListItemView.setTag(localMoveMailAndTagMailViewHolder);
    }
    for (;;)
    {
      localMoveMailAndTagMailViewHolder.textView.setText((CharSequence)localHashMap.get("name"));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localQMListItemView;
      localMoveMailAndTagMailViewHolder = (SectionListAdapter.MoveMailAndTagMailViewHolder)localQMListItemView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.MoveNoteAdapter
 * JD-Core Version:    0.7.0.1
 */