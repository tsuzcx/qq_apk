package com.tencent.qqmail.view.sectionlist;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SectionListAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, ListAdapter
{
  private final Map<View, String> currentViewSections = new HashMap();
  private final DataSetObserver dataSetObserver = new SectionListAdapter.1(this);
  protected final LayoutInflater inflater;
  private final Map<Integer, Integer> itemPositions = new LinkedHashMap();
  private final ListAdapter linkedAdapter;
  private AdapterView.OnItemClickListener linkedListener;
  private final ArrayList<Integer> sectionArr = new ArrayList();
  private final Map<Integer, String> sectionPositions = new LinkedHashMap();
  private View transparentSectionView;
  private int viewTypeCount;
  
  public SectionListAdapter(LayoutInflater paramLayoutInflater, ListAdapter paramListAdapter)
  {
    this.linkedAdapter = paramListAdapter;
    this.inflater = paramLayoutInflater;
    paramListAdapter.registerDataSetObserver(this.dataSetObserver);
    updateSessionCache();
  }
  
  private View getSectionView(View paramView, String paramString)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = createNewSectionView();
    }
    setSectionText(paramString, localView);
    replaceSectionViewsInMaps(paramString, localView);
    return localView;
  }
  
  private boolean isTheSame(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  private void updateSessionCache()
  {
    try
    {
      this.sectionPositions.clear();
      this.itemPositions.clear();
      this.viewTypeCount = (this.linkedAdapter.getViewTypeCount() + 1);
      int m = this.linkedAdapter.getCount();
      Object localObject1 = null;
      int i = 0;
      int j = 0;
      while (j < m)
      {
        SectionListItem localSectionListItem = (SectionListItem)this.linkedAdapter.getItem(j);
        Object localObject3 = localObject1;
        int k = i;
        if (!isTheSame((String)localObject1, localSectionListItem.section))
        {
          localObject3 = localObject1;
          k = i;
          if (localSectionListItem.section.length() > 0)
          {
            this.sectionPositions.put(Integer.valueOf(i), localSectionListItem.section);
            this.sectionArr.add(Integer.valueOf(i));
            localObject3 = localSectionListItem.section;
            k = i + 1;
          }
        }
        this.itemPositions.put(Integer.valueOf(k), Integer.valueOf(j));
        i = k + 1;
        j += 1;
        localObject1 = localObject3;
      }
      return;
    }
    finally {}
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.linkedAdapter.areAllItemsEnabled();
  }
  
  protected View createNewSectionView()
  {
    return this.inflater.inflate(2131563046, null);
  }
  
  public void finishLayout() {}
  
  public int getCount()
  {
    try
    {
      int i = this.sectionPositions.size();
      int j = this.itemPositions.size();
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public Object getItem(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokevirtual 160	com/tencent/qqmail/view/sectionlist/SectionListAdapter:isSection	(I)Z
    //   7: ifeq +21 -> 28
    //   10: aload_0
    //   11: getfield 53	com/tencent/qqmail/view/sectionlist/SectionListAdapter:sectionPositions	Ljava/util/Map;
    //   14: iload_1
    //   15: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokeinterface 164 2 0
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: areturn
    //   28: aload_0
    //   29: iload_1
    //   30: invokevirtual 167	com/tencent/qqmail/view/sectionlist/SectionListAdapter:getLinkedPosition	(I)Ljava/lang/Integer;
    //   33: invokevirtual 170	java/lang/Integer:intValue	()I
    //   36: istore_1
    //   37: aload_0
    //   38: getfield 67	com/tencent/qqmail/view/sectionlist/SectionListAdapter:linkedAdapter	Landroid/widget/ListAdapter;
    //   41: iload_1
    //   42: invokeinterface 117 2 0
    //   47: astore_2
    //   48: goto -24 -> 24
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	SectionListAdapter
    //   0	56	1	paramInt	int
    //   23	25	2	localObject1	Object
    //   51	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	51	finally
    //   28	48	51	finally
  }
  
  public long getItemId(int paramInt)
  {
    if (isSection(paramInt)) {
      return ((String)this.sectionPositions.get(Integer.valueOf(paramInt))).hashCode();
    }
    return this.linkedAdapter.getItemId(getLinkedPosition(paramInt).intValue());
  }
  
  public int getItemViewType(int paramInt)
  {
    if (isSection(paramInt)) {
      return this.viewTypeCount - 1;
    }
    return this.linkedAdapter.getItemViewType(getLinkedPosition(paramInt).intValue());
  }
  
  protected Integer getLinkedPosition(int paramInt)
  {
    return (Integer)this.itemPositions.get(Integer.valueOf(paramInt));
  }
  
  /* Error */
  public String getSectionName(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokevirtual 160	com/tencent/qqmail/view/sectionlist/SectionListAdapter:isSection	(I)Z
    //   7: ifeq +24 -> 31
    //   10: aload_0
    //   11: getfield 53	com/tencent/qqmail/view/sectionlist/SectionListAdapter:sectionPositions	Ljava/util/Map;
    //   14: iload_1
    //   15: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokeinterface 164 2 0
    //   23: checkcast 95	java/lang/String
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: areturn
    //   31: aconst_null
    //   32: astore_2
    //   33: goto -6 -> 27
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	SectionListAdapter
    //   0	41	1	paramInt	int
    //   26	7	2	str	String
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	36	finally
  }
  
  public View getTransparentSectionView()
  {
    try
    {
      if (this.transparentSectionView == null) {
        this.transparentSectionView = createNewSectionView();
      }
      View localView = this.transparentSectionView;
      return localView;
    }
    finally {}
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (isSection(paramInt)) {}
    for (View localView = getSectionView(paramView, (String)this.sectionPositions.get(Integer.valueOf(paramInt)));; localView = this.linkedAdapter.getView(getLinkedPosition(paramInt).intValue(), paramView, paramViewGroup))
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
  }
  
  public int getViewTypeCount()
  {
    return this.viewTypeCount;
  }
  
  public boolean hasStableIds()
  {
    return this.linkedAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.linkedAdapter.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (isSection(paramInt)) {
      return true;
    }
    return this.linkedAdapter.isEnabled(getLinkedPosition(paramInt).intValue());
  }
  
  public boolean isSection(int paramInt)
  {
    try
    {
      boolean bool = this.sectionPositions.containsKey(Integer.valueOf(paramInt));
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void makeSectionInvisibleIfFirstInList(int paramInt)
  {
    Object localObject1 = getSectionName(paramInt);
    Object localObject2 = this.currentViewSections.entrySet().iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((View)localEntry.getKey()).setVisibility(4);
      if ((((String)localEntry.getValue()).equals(localObject1)) && (i == 0))
      {
        ((View)localEntry.getKey()).setVisibility(4);
        i = 1;
      }
      for (;;)
      {
        break;
        ((View)localEntry.getKey()).setVisibility(0);
      }
    }
    localObject1 = this.sectionPositions.entrySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (((Integer)((Map.Entry)localObject2).getKey()).intValue() <= paramInt + 1) {}
      }
      else
      {
        return;
      }
      setSectionText((String)((Map.Entry)localObject2).getValue(), getTransparentSectionView());
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (isSection(paramInt)) {
      sectionClicked(getSectionName(paramInt));
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (this.linkedListener != null) {
        this.linkedListener.onItemClick(paramAdapterView, paramView, getLinkedPosition(paramInt).intValue(), paramLong);
      }
    }
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.linkedAdapter.registerDataSetObserver(paramDataSetObserver);
  }
  
  protected void replaceSectionViewsInMaps(String paramString, View paramView)
  {
    try
    {
      if (this.currentViewSections.containsKey(paramView)) {
        this.currentViewSections.remove(paramView);
      }
      this.currentViewSections.put(paramView, paramString);
      return;
    }
    finally {}
  }
  
  protected void sectionClicked(String paramString) {}
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.linkedListener = paramOnItemClickListener;
  }
  
  protected void setSectionText(String paramString, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131370534);
    if ((paramString == null) || (paramString.equals("")))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setText(paramString);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.linkedAdapter.unregisterDataSetObserver(paramDataSetObserver);
  }
  
  public static final class MoveMailAndTagMailViewHolder
  {
    public ImageView imageView;
    public TextView textView;
  }
  
  public static class ViewHolderSimple
  {
    public ImageView chevron;
    public TextView detailTextView;
    public ImageView imageView;
    public TextView titleTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.sectionlist.SectionListAdapter
 * JD-Core Version:    0.7.0.1
 */