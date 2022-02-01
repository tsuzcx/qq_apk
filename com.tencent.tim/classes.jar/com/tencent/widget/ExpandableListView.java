package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import autn;
import autp;
import auvm;
import java.util.ArrayList;

public class ExpandableListView
  extends ListView
{
  private static final int[] EMPTY_STATE_SET;
  private static final int esZ = getStyleableValue("ExpandableListView_childDivider");
  private static final int eta = getStyleableValue("ExpandableListView_childIndicatorRight");
  private static final int etb = getStyleableValue("ExpandableListView_childIndicatorLeft");
  private static final int etc = getStyleableValue("ExpandableListView_indicatorRight");
  private static final int etd = getStyleableValue("ExpandableListView_indicatorLeft");
  private static final int ete = getStyleableValue("ExpandableListView_childIndicator");
  private static final int etf = getStyleableValue("ExpandableListView_groupIndicator");
  private static final int[] tq;
  private static final int[] tr;
  private static final int[] ts;
  private static final int[] tt = { 16842918 };
  private static final int[][] z;
  private b jdField_a_of_type_ComTencentWidgetExpandableListView$b;
  private c jdField_a_of_type_ComTencentWidgetExpandableListView$c;
  private d jdField_a_of_type_ComTencentWidgetExpandableListView$d;
  private e jdField_a_of_type_ComTencentWidgetExpandableListView$e;
  private ExpandableListAdapter jdField_b_of_type_AndroidWidgetExpandableListAdapter;
  private ExpandableListConnector jdField_b_of_type_ComTencentWidgetExpandableListConnector;
  private int bbT;
  private int bbU;
  private final Rect br = new Rect();
  private int etg;
  private int eth;
  private Drawable fH;
  private Drawable gA;
  private Drawable gB;
  
  static
  {
    EMPTY_STATE_SET = new int[0];
    tq = new int[] { 16842920 };
    tr = new int[] { 16842921 };
    ts = new int[] { 16842920, 16842921 };
    z = new int[][] { EMPTY_STATE_SET, tq, tr, ts };
  }
  
  public ExpandableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842863);
  }
  
  public ExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new auvm(paramContext.obtainStyledAttributes(paramAttributeSet, getStyleableValues("ExpandableListView"), paramInt, 0));
    this.fH = paramContext.getDrawable(etf);
    this.gA = paramContext.getDrawable(ete);
    this.bbT = paramContext.getDimensionPixelSize(etd, 0);
    this.bbU = paramContext.getDimensionPixelSize(etc, 0);
    if ((this.bbU == 0) && (this.fH != null)) {
      this.bbU = (this.bbT + this.fH.getIntrinsicWidth());
    }
    this.etg = paramContext.getDimensionPixelSize(etb, -1);
    this.eth = paramContext.getDimensionPixelSize(eta, -1);
    this.gB = paramContext.getDrawable(esZ);
    paramContext.recycle();
  }
  
  private long a(autn paramautn)
  {
    if (paramautn.type == 1) {
      return this.jdField_b_of_type_AndroidWidgetExpandableListAdapter.getChildId(paramautn.ccW, paramautn.cWL);
    }
    return this.jdField_b_of_type_AndroidWidgetExpandableListAdapter.getGroupId(paramautn.ccW);
  }
  
  private Drawable a(ExpandableListConnector.b paramb)
  {
    int j = 1;
    int k = 0;
    Drawable localDrawable;
    if (paramb.jdField_a_of_type_Autn.type == 2)
    {
      localDrawable = this.fH;
      if ((localDrawable != null) && (localDrawable.isStateful()))
      {
        int i;
        if ((paramb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata == null) || (paramb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.esV == paramb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.esU))
        {
          i = 1;
          if (!paramb.isExpanded()) {
            break label97;
          }
        }
        for (;;)
        {
          if (i != 0) {
            k = 2;
          }
          localDrawable.setState(z[(j | k)]);
          return localDrawable;
          i = 0;
          break;
          label97:
          j = 0;
        }
      }
    }
    else
    {
      localDrawable = this.gA;
      if ((localDrawable != null) && (localDrawable.isStateful())) {
        if (paramb.jdField_a_of_type_Autn.esY != paramb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.esV) {
          break label152;
        }
      }
      label152:
      for (paramb = tt;; paramb = EMPTY_STATE_SET)
      {
        localDrawable.setState(paramb);
        return localDrawable;
      }
    }
    return localDrawable;
  }
  
  public static int getPackedPositionChild(long paramLong)
  {
    if (paramLong == 4294967295L) {}
    while ((paramLong & 0x0) != -9223372036854775808L) {
      return -1;
    }
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public static long getPackedPositionForChild(int paramInt1, int paramInt2)
  {
    return 0x0 | (paramInt1 & 0x7FFFFFFF) << 32 | paramInt2 & 0xFFFFFFFF;
  }
  
  public static long getPackedPositionForGroup(int paramInt)
  {
    return (paramInt & 0x7FFFFFFF) << 32;
  }
  
  public static int getPackedPositionGroup(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return -1;
    }
    return (int)((0x0 & paramLong) >> 32);
  }
  
  public static int getPackedPositionType(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return 2;
    }
    if ((paramLong & 0x0) == -9223372036854775808L) {
      return 1;
    }
    return 0;
  }
  
  private int lg(int paramInt)
  {
    return paramInt - getHeaderViewsCount();
  }
  
  private int lh(int paramInt)
  {
    return getHeaderViewsCount() + paramInt;
  }
  
  private boolean nf(int paramInt)
  {
    int i = this.mItemCount;
    int j = getFooterViewsCount();
    return (paramInt < getHeaderViewsCount()) || (paramInt >= i - j);
  }
  
  boolean a(View paramView, int paramInt, long paramLong)
  {
    ExpandableListConnector.b localb = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    paramLong = a(localb.jdField_a_of_type_Autn);
    if (localb.jdField_a_of_type_Autn.type == 2)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetExpandableListView$c != null) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView$c.a(this, paramView, localb.jdField_a_of_type_Autn.ccW, paramLong)))
      {
        localb.recycle();
        return true;
      }
      if (localb.isExpanded())
      {
        this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(localb);
        playSoundEffect(0);
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$d != null) {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView$d.onGroupCollapse(localb.jdField_a_of_type_Autn.ccW);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localb.recycle();
      return bool;
      this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.b(localb);
      playSoundEffect(0);
      if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$e != null) {
        this.jdField_a_of_type_ComTencentWidgetExpandableListView$e.onGroupExpand(localb.jdField_a_of_type_Autn.ccW);
      }
      paramInt = localb.jdField_a_of_type_Autn.ccW;
      int i = localb.jdField_a_of_type_Autn.esY + getHeaderViewsCount();
      smoothScrollToPosition(this.jdField_b_of_type_AndroidWidgetExpandableListAdapter.getChildrenCount(paramInt) + i, i);
      break;
      if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$b != null)
      {
        playSoundEffect(0);
        return this.jdField_a_of_type_ComTencentWidgetExpandableListView$b.a(this, paramView, localb.jdField_a_of_type_Autn.ccW, localb.jdField_a_of_type_Autn.cWL, paramLong);
      }
    }
  }
  
  public boolean collapseGroup(int paramInt)
  {
    boolean bool = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.collapseGroup(paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$d != null) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView$d.onGroupCollapse(paramInt);
    }
    return bool;
  }
  
  ContextMenu.ContextMenuInfo createContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    if (nf(paramInt)) {
      return new AdapterView.a(paramView, paramInt, paramLong);
    }
    paramInt = lg(paramInt);
    ExpandableListConnector.b localb = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    autn localautn = localb.jdField_a_of_type_Autn;
    localb.recycle();
    paramLong = a(localautn);
    long l = localautn.iF();
    localautn.recycle();
    return new a(paramView, l, paramLong);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.gA == null) && (this.fH == null)) {
      return;
    }
    int m = 0;
    int k;
    label38:
    int i;
    int i2;
    int i3;
    int i4;
    int i5;
    Rect localRect;
    int i1;
    int n;
    if ((this.mGroupFlags & 0x22) == 34)
    {
      k = 1;
      if (k != 0)
      {
        m = paramCanvas.save();
        i = getScrollX();
        j = getScrollY();
        paramCanvas.clipRect(getPaddingLeft() + i, getPaddingTop() + j, i + getRight() - getLeft() - getPaddingRight(), j + getBottom() - getTop() - getPaddingBottom());
      }
      i2 = getHeaderViewsCount();
      i3 = this.mItemCount;
      i4 = getFooterViewsCount();
      i5 = getBottom();
      localRect = this.br;
      int i6 = getChildCount();
      j = this.mFirstPosition;
      i = -4;
      i1 = 0;
      n = j - i2;
      label161:
      if (i1 >= i6) {
        break label213;
      }
      if (n >= 0) {
        break label198;
      }
      j = i;
    }
    label198:
    label213:
    int i7;
    int i8;
    do
    {
      do
      {
        i1 += 1;
        n += 1;
        i = j;
        break label161;
        k = 0;
        break label38;
        if (n > i3 - i4 - i2 - 1)
        {
          if (k == 0) {
            break;
          }
          paramCanvas.restoreToCount(m);
          return;
        }
        localObject = getChildAt(i1);
        i7 = ((View)localObject).getTop();
        i8 = ((View)localObject).getBottom();
        j = i;
      } while (i8 < 0);
      j = i;
    } while (i7 > i5);
    Object localObject = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(n);
    int j = i;
    if (((ExpandableListConnector.b)localObject).jdField_a_of_type_Autn.type != i)
    {
      if (((ExpandableListConnector.b)localObject).jdField_a_of_type_Autn.type != 1) {
        break label461;
      }
      if (this.etg == -1)
      {
        i = this.bbT;
        label313:
        localRect.left = i;
        if (this.eth != -1) {
          break label453;
        }
        i = this.bbU;
        label332:
        localRect.right = i;
        label338:
        localRect.left += getPaddingLeft();
        localRect.right += getPaddingLeft();
        j = ((ExpandableListConnector.b)localObject).jdField_a_of_type_Autn.type;
      }
    }
    else if (localRect.left != localRect.right)
    {
      if (!this.mStackFromBottom) {
        break label482;
      }
      localRect.top = i7;
    }
    for (localRect.bottom = i8;; localRect.bottom = i8)
    {
      Drawable localDrawable = a((ExpandableListConnector.b)localObject);
      if (localDrawable != null)
      {
        localDrawable.setBounds(localRect);
        localDrawable.draw(paramCanvas);
      }
      ((ExpandableListConnector.b)localObject).recycle();
      break;
      i = this.etg;
      break label313;
      label453:
      i = this.eth;
      break label332;
      label461:
      localRect.left = this.bbT;
      localRect.right = this.bbU;
      break label338;
      label482:
      localRect.top = i7;
    }
  }
  
  void drawDivider(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    paramInt = this.mFirstPosition + paramInt;
    if (paramInt >= 0)
    {
      int i = lg(paramInt);
      ExpandableListConnector.b localb = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(i);
      if ((localb.jdField_a_of_type_Autn.type == 1) || ((localb.isExpanded()) && (localb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.esV != localb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.esU)))
      {
        Drawable localDrawable = this.gB;
        if (localDrawable != null)
        {
          localDrawable.setBounds(paramRect);
          localDrawable.draw(paramCanvas);
        }
        localb.recycle();
        return;
      }
      localb.recycle();
    }
    super.drawDivider(paramCanvas, paramRect, paramInt);
  }
  
  public boolean expandGroup(int paramInt)
  {
    return expandGroup(paramInt, false);
  }
  
  public boolean expandGroup(int paramInt, boolean paramBoolean)
  {
    ExpandableListConnector.b localb = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(autn.a(2, paramInt, -1, -1));
    boolean bool = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.b(localb);
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$e != null) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView$e.onGroupExpand(paramInt);
    }
    if (paramBoolean)
    {
      int i = localb.jdField_a_of_type_Autn.esY + getHeaderViewsCount();
      smoothScrollToPosition(this.jdField_b_of_type_AndroidWidgetExpandableListAdapter.getChildrenCount(paramInt) + i, i);
    }
    localb.recycle();
    return bool;
  }
  
  public ListAdapter getAdapter()
  {
    return super.getAdapter();
  }
  
  public ExpandableListAdapter getExpandableListAdapter()
  {
    return this.jdField_b_of_type_AndroidWidgetExpandableListAdapter;
  }
  
  public long getExpandableListPosition(int paramInt)
  {
    if (nf(paramInt)) {
      return 4294967295L;
    }
    paramInt = lg(paramInt);
    ExpandableListConnector.b localb = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    long l = localb.jdField_a_of_type_Autn.iF();
    localb.recycle();
    return l;
  }
  
  public int getFlatListPosition(long paramLong)
  {
    Object localObject = autn.a(paramLong);
    if (localObject == null) {
      return -1;
    }
    localObject = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a((autn)localObject);
    int i = ((ExpandableListConnector.b)localObject).jdField_a_of_type_Autn.esY;
    ((ExpandableListConnector.b)localObject).recycle();
    return lh(i);
  }
  
  public boolean isGroupExpanded(int paramInt)
  {
    return this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.isGroupExpanded(paramInt);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.onRestoreInstanceState(SavedState.a(paramParcelable));
    } while ((this.jdField_b_of_type_ComTencentWidgetExpandableListConnector == null) || (paramParcelable.Es == null));
    this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.fo(paramParcelable.Es);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    if (this.jdField_b_of_type_ComTencentWidgetExpandableListConnector != null) {}
    for (ArrayList localArrayList = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.ev();; localArrayList = null) {
      return new SavedState(localParcelable, localArrayList);
    }
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    if (nf(paramInt)) {
      return super.performItemClick(paramView, paramInt, paramLong);
    }
    return a(paramView, lg(paramInt), paramLong);
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    this.jdField_b_of_type_AndroidWidgetExpandableListAdapter = paramExpandableListAdapter;
    if (paramExpandableListAdapter != null) {}
    for (this.jdField_b_of_type_ComTencentWidgetExpandableListConnector = new ExpandableListConnector(paramExpandableListAdapter);; this.jdField_b_of_type_ComTencentWidgetExpandableListConnector = null)
    {
      super.setAdapter(this.jdField_b_of_type_ComTencentWidgetExpandableListConnector);
      return;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
  }
  
  public void setChildDivider(Drawable paramDrawable)
  {
    this.gB = paramDrawable;
  }
  
  public void setChildIndicator(Drawable paramDrawable)
  {
    this.gA = paramDrawable;
  }
  
  public void setChildIndicatorBounds(int paramInt1, int paramInt2)
  {
    this.etg = paramInt1;
    this.eth = paramInt2;
  }
  
  public void setGroupIndicator(Drawable paramDrawable)
  {
    this.fH = paramDrawable;
    if ((this.bbU == 0) && (this.fH != null)) {
      this.bbU = (this.bbT + this.fH.getIntrinsicWidth());
    }
  }
  
  public void setIndicatorBounds(int paramInt1, int paramInt2)
  {
    this.bbT = paramInt1;
    this.bbU = paramInt2;
  }
  
  public void setOnChildClickListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$b = paramb;
  }
  
  public void setOnGroupClickListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$c = paramc;
  }
  
  public void setOnGroupCollapseListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$d = paramd;
  }
  
  public void setOnGroupExpandListener(e parame)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$e = parame;
  }
  
  public void setOnItemClickListener(AdapterView.c paramc)
  {
    super.setOnItemClickListener(paramc);
  }
  
  public boolean setSelectedChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    autn localautn = autn.a(paramInt1, paramInt2);
    ExpandableListConnector.b localb2 = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(localautn);
    ExpandableListConnector.b localb1 = localb2;
    if (localb2 == null)
    {
      if (!paramBoolean) {
        return false;
      }
      expandGroup(paramInt1);
      localb2 = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(localautn);
      localb1 = localb2;
      if (localb2 == null) {
        throw new IllegalStateException("Could not find child");
      }
    }
    super.setSelection(lh(localb1.jdField_a_of_type_Autn.esY));
    localautn.recycle();
    localb1.recycle();
    return true;
  }
  
  public void setSelectedGroup(int paramInt)
  {
    autn localautn = autn.a(paramInt);
    ExpandableListConnector.b localb = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(localautn);
    localautn.recycle();
    super.setSelection(lh(localb.jdField_a_of_type_Autn.esY));
    localb.recycle();
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    autn localautn = autn.a(paramInt);
    ExpandableListConnector.b localb = this.jdField_b_of_type_ComTencentWidgetExpandableListConnector.a(localautn);
    localautn.recycle();
    int i = localb.jdField_a_of_type_Autn.esY + getHeaderViewsCount();
    smoothScrollToPosition(this.jdField_b_of_type_AndroidWidgetExpandableListAdapter.getChildrenCount(paramInt) + i, i);
    localb.recycle();
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new autp();
    ArrayList<ExpandableListConnector.GroupMetadata> Es;
    private Parcelable e;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.e = paramParcel.readParcelable(getClass().getClassLoader());
      this.Es = new ArrayList();
      paramParcel.readList(this.Es, ExpandableListConnector.class.getClassLoader());
    }
    
    SavedState(Parcelable paramParcelable, ArrayList<ExpandableListConnector.GroupMetadata> paramArrayList)
    {
      super();
      this.Es = paramArrayList;
      this.e = paramParcelable;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.e, paramInt);
      paramParcel.writeList(this.Es);
    }
  }
  
  public static class a
    implements ContextMenu.ContextMenuInfo
  {
    public long id;
    public long packedPosition;
    public View targetView;
    
    public a(View paramView, long paramLong1, long paramLong2)
    {
      this.targetView = paramView;
      this.packedPosition = paramLong1;
      this.id = paramLong2;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong);
  }
  
  public static abstract interface d
  {
    public abstract void onGroupCollapse(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void onGroupExpand(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ExpandableListView
 * JD-Core Version:    0.7.0.1
 */