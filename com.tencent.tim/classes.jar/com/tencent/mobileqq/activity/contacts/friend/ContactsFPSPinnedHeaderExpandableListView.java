package com.tencent.mobileqq.activity.contacts.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import zam;

public class ContactsFPSPinnedHeaderExpandableListView
  extends FPSPinnedHeaderExpandableListView
{
  private boolean bpL = true;
  
  public ContactsFPSPinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsFPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactsFPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    if (this.bpL) {
      super.a(paramInt1, paramInt2, paramView, paramInt3);
    }
  }
  
  public void setChildViewCanAction(boolean paramBoolean)
  {
    ExpandableListAdapter localExpandableListAdapter = getExpandableListAdapter();
    if ((localExpandableListAdapter instanceof zam)) {
      ((zam)localExpandableListAdapter).setChildViewCanAction(paramBoolean);
    }
    this.bpL = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.ContactsFPSPinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */