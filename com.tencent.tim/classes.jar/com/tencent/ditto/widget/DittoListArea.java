package com.tencent.ditto.widget;

import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.util.ArrayList;
import java.util.List;

public class DittoListArea
  extends LinearAreaLayout
{
  private ListAreaAdapter adapter;
  private int mItemInterval = 0;
  private List<Integer> numbersOfRows = new ArrayList();
  
  public DittoListArea(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
  }
  
  public ListAreaAdapter getAdapter()
  {
    return this.adapter;
  }
  
  public int getItemInterval()
  {
    return this.mItemInterval;
  }
  
  public void reloadRows()
  {
    if (this.adapter == null) {
      return;
    }
    this.numbersOfRows.clear();
    removeAllChildren();
    if ((this.adapter instanceof ListAreaAdapterWithSection)) {}
    for (int i = ((ListAreaAdapterWithSection)this.adapter).numberOfSections(this);; i = 1)
    {
      int j = 0;
      while (j < i)
      {
        int m = this.adapter.numberOfRows(this, j);
        this.numbersOfRows.add(Integer.valueOf(m));
        int k = 0;
        if (k < m)
        {
          DittoArea localDittoArea = this.adapter.getArea(this, j, k);
          if (localDittoArea != null) {
            if ((k != 0) && (this.mItemInterval != 0))
            {
              if (getOrientation() != 1) {
                break label151;
              }
              localDittoArea.setMargin(0, this.mItemInterval, 0, 0);
            }
          }
          for (;;)
          {
            addChild(localDittoArea);
            k += 1;
            break;
            label151:
            localDittoArea.setMargin(this.mItemInterval, 0, 0, 0);
          }
        }
        j += 1;
      }
      requestLayout();
      return;
    }
  }
  
  public void setAdapter(ListAreaAdapter paramListAreaAdapter)
  {
    this.adapter = paramListAreaAdapter;
    reloadRows();
  }
  
  public void setItemInterval(int paramInt)
  {
    this.mItemInterval = paramInt;
    reloadRows();
  }
  
  public static abstract interface ListAreaAdapter
  {
    public abstract DittoArea getArea(DittoListArea paramDittoListArea, int paramInt1, int paramInt2);
    
    public abstract int numberOfRows(DittoListArea paramDittoListArea, int paramInt);
  }
  
  public static abstract interface ListAreaAdapterWithSection
    extends DittoListArea.ListAreaAdapter
  {
    public abstract int numberOfSections(DittoListArea paramDittoListArea);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.widget.DittoListArea
 * JD-Core Version:    0.7.0.1
 */