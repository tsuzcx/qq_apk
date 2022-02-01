package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import java.util.List;

public class NoteCatAdapter
  extends BaseAdapter
{
  private Context mContext;
  private String mNoteCatId;
  private List<QMNNoteCategory> mNoteCategorys;
  
  public NoteCatAdapter(Context paramContext, List<QMNNoteCategory> paramList, String paramString)
  {
    this.mContext = paramContext;
    this.mNoteCategorys = paramList;
    this.mNoteCatId = paramString;
  }
  
  public int getCount()
  {
    return this.mNoteCategorys.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mNoteCategorys.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131559708, paramViewGroup, false);
      paramView = new ViewHolder(null);
      paramView.textView = ((TextView)localView.findViewById(2131370559));
      paramView.markView = ((ImageView)localView.findViewById(2131370557));
      localView.setTag(paramView);
      localObject = (QMNNoteCategory)getItem(paramInt);
      paramView.textView.setText(((QMNNoteCategory)localObject).getCatalogName());
      if (!this.mNoteCatId.equals(((QMNNoteCategory)localObject).getCatalogId())) {
        break label145;
      }
      paramView.markView.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label145:
      paramView.markView.setVisibility(8);
    }
  }
  
  public void setNoteCatId(String paramString)
  {
    this.mNoteCatId = paramString;
  }
  
  public void setNoteCategorys(List<QMNNoteCategory> paramList)
  {
    this.mNoteCategorys = paramList;
  }
  
  class ViewHolder
  {
    ImageView markView;
    TextView textView;
    
    private ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.NoteCatAdapter
 * JD-Core Version:    0.7.0.1
 */