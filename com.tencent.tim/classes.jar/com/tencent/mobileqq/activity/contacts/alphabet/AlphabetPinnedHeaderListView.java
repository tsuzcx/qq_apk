package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.a;
import yyy;

public class AlphabetPinnedHeaderListView
  extends PinnedDividerListView
{
  private boolean bpL = true;
  
  public AlphabetPinnedHeaderListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlphabetPinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AlphabetPinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setChildViewCanAction(boolean paramBoolean)
  {
    PinnedDividerListView.a locala = a();
    if ((locala instanceof yyy)) {
      ((yyy)locala).setChildViewCanAction(paramBoolean);
    }
    this.bpL = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetPinnedHeaderListView
 * JD-Core Version:    0.7.0.1
 */