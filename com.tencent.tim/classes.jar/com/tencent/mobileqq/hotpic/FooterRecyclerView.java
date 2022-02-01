package com.tencent.mobileqq.hotpic;

import ahyw;
import aiab;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;

public class FooterRecyclerView
  extends RecyclerView
{
  ahyw a;
  
  public FooterRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(ahyw paramahyw)
  {
    if (getAdapter() != null) {}
    this.a = paramahyw;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    Object localObject = paramAdapter;
    if (this.a != null)
    {
      localObject = new aiab(paramAdapter, this.a);
      if (QLog.isColorLevel()) {
        QLog.d("FooterRecyclerView", 2, "has footer");
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.FooterRecyclerView
 * JD-Core Version:    0.7.0.1
 */