package com.tencent.qqmail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class ContactAddrListView
  extends ListView
{
  public ContactAddrListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.w("roylktest", "ListView onSizeChanged,w:" + paramInt1 + ", h:" + paramInt2 + ", oldw:" + paramInt3 + ", oldh:" + paramInt4);
    if ((paramInt1 == paramInt3) && (paramInt2 != paramInt4))
    {
      View localView = getFocusedChild();
      if ((localView != null) && (localView.getBottom() > getBottom()))
      {
        paramInt1 = getPositionForView(localView);
        if (paramInt1 != -1) {
          smoothScrollToPosition(paramInt1);
        }
      }
      return;
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ContactAddrListView
 * JD-Core Version:    0.7.0.1
 */