package com.tencent.qqmail.namelist;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.mobeta.android.dslv.DragSortListView.DragSortListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.namelist.cursor.NameListBaseCursor;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.ItemScrollAdapter;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class NameListAdapter
  extends BaseAdapter
  implements SectionIndexer, DragSortListView.DragSortListener, ItemScrollListView.ItemScrollAdapter
{
  private Context context;
  private NameListBaseCursor cursor;
  private boolean isFromSearch;
  protected HashMap<String, Integer> sectionMap;
  
  public NameListAdapter(Context paramContext, NameListBaseCursor paramNameListBaseCursor, boolean paramBoolean)
  {
    this.context = paramContext;
    this.cursor = paramNameListBaseCursor;
    this.isFromSearch = paramBoolean;
  }
  
  private View generateCell()
  {
    TextView localTextView1 = new TextView(new ContextThemeWrapper(this.context, 2131756291), null, 0);
    TextView localTextView2 = new TextView(this.context);
    Object localObject1 = new FrameLayout.LayoutParams(-1, this.context.getResources().getDimensionPixelSize(2131297616));
    ((FrameLayout.LayoutParams)localObject1).gravity = 16;
    localTextView2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localTextView2.setPadding(this.context.getResources().getDimensionPixelSize(2131297032), 0, QMUIKit.dpToPx(30), 0);
    localTextView2.setTextColor(ContextCompat.getColor(this.context, 2131166572));
    localTextView2.setTextSize(0, this.context.getResources().getDimensionPixelSize(2131297623));
    localTextView2.setSingleLine(true);
    localTextView2.setGravity(16);
    localTextView2.setEllipsize(TextUtils.TruncateAt.END);
    localObject1 = ItemScrollListView.wrap(localTextView2);
    if (!this.isFromSearch)
    {
      localObject2 = ((HorizontalScrollItemView)localObject1).getDeleteView();
      ((TextView)localObject2).setText(2131690893);
      ItemScrollListView.formatRightViewStyle((TextView)localObject2, 1);
      ((TextView)localObject2).setVisibility(0);
    }
    ((HorizontalScrollItemView)localObject1).addSectionView(localTextView1, this.context.getResources().getDimensionPixelSize(2131299372));
    Object localObject2 = new NameListItemViewHolder();
    ((NameListItemViewHolder)localObject2).category = localTextView1;
    ((NameListItemViewHolder)localObject2).address = localTextView2;
    ((HorizontalScrollItemView)localObject1).setTag(localObject2);
    return localObject1;
  }
  
  private String getCategory(int paramInt)
  {
    return this.cursor.getCategory(paramInt);
  }
  
  public void drag(int paramInt1, int paramInt2) {}
  
  public void drop(int paramInt1, int paramInt2) {}
  
  public int getCount()
  {
    if (this.cursor != null) {
      return this.cursor.getCount();
    }
    return 0;
  }
  
  public NameListContact getItem(int paramInt)
  {
    if (this.cursor == null) {}
    while (paramInt >= this.cursor.getCount()) {
      return null;
    }
    return this.cursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    NameListContact localNameListContact = getItem(paramInt);
    if (localNameListContact != null) {
      return localNameListContact.getId();
    }
    return 0L;
  }
  
  public int getPositionForSection(int paramInt)
  {
    if ((paramInt < 0) || (this.sectionMap == null) || (this.sectionMap.size() == 0)) {
      return 0;
    }
    int i = paramInt;
    if (paramInt >= this.sectionMap.size()) {
      i = this.sectionMap.size() - 1;
    }
    Iterator localIterator = this.sectionMap.entrySet().iterator();
    paramInt = 0;
    int j = 0;
    for (;;)
    {
      if ((!localIterator.hasNext()) || (i == paramInt)) {
        return j + 1;
      }
      j += ((Integer)((Map.Entry)localIterator.next()).getValue()).intValue();
      paramInt += 1;
    }
  }
  
  public int getSectionForPosition(int paramInt)
  {
    return 0;
  }
  
  public Object[] getSections()
  {
    return new Object[0];
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    if ((paramView == null) || (paramView.getTag() == null)) {
      paramView = generateCell();
    }
    for (;;)
    {
      NameListItemViewHolder localNameListItemViewHolder = (NameListItemViewHolder)paramView.getTag();
      localNameListItemViewHolder.address.setText(getItem(paramInt).getEmail());
      String str1 = getCategory(paramInt);
      if ((paramInt == 0) && (str1 != null))
      {
        localNameListItemViewHolder.category.setText(str1.toUpperCase(Locale.getDefault()));
        localNameListItemViewHolder.category.setVisibility(0);
        localNameListItemViewHolder.category.setOnClickListener(null);
        if (i == 0) {
          break label219;
        }
        localNameListItemViewHolder.address.setBackgroundResource(2130845612);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        String str2 = getCategory(paramInt - 1);
        if (str1 != null)
        {
          if (!str1.equals(str2))
          {
            localNameListItemViewHolder.category.setText(str1.toUpperCase(Locale.getDefault()));
            localNameListItemViewHolder.category.setVisibility(0);
            localNameListItemViewHolder.category.setOnClickListener(null);
            break;
          }
          localNameListItemViewHolder.category.setVisibility(8);
          i = 0;
          break;
        }
        localNameListItemViewHolder.category.setVisibility(8);
        i = 0;
        break;
        label219:
        localNameListItemViewHolder.address.setBackgroundResource(2130845609);
      }
    }
  }
  
  public int isEnabledScroll(int paramInt)
  {
    return 2;
  }
  
  public void remove(int paramInt) {}
  
  public void setSectionMap(HashMap<String, Integer> paramHashMap)
  {
    this.sectionMap = paramHashMap;
  }
  
  public class NameListItemViewHolder
  {
    public TextView address;
    public TextView category;
    
    public NameListItemViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListAdapter
 * JD-Core Version:    0.7.0.1
 */