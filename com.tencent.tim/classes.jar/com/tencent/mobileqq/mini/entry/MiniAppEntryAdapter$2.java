package com.tencent.mobileqq.mini.entry;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

class MiniAppEntryAdapter$2
  implements View.OnLongClickListener
{
  MiniAppEntryAdapter$2(MiniAppEntryAdapter paramMiniAppEntryAdapter) {}
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppEntryAdapter", 2, "onLongClick. obj = " + localObject);
      }
    }
    do
    {
      return true;
      i = ((Integer)localObject).intValue();
    } while ((i != 1) && (i != 2));
    localObject = (MiniAppEntryAdapter.MicroAppViewHolder)((RecyclerView)paramView.getParent()).getChildViewHolder(paramView);
    MiniAppInfo localMiniAppInfo = ((MiniAppEntryAdapter.MicroAppViewHolder)localObject).miniAppInfo;
    int i = ((MiniAppEntryAdapter.MicroAppViewHolder)localObject).getLayoutPosition();
    this.this$0.handleLongClick(paramView, localMiniAppInfo, i);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.2
 * JD-Core Version:    0.7.0.1
 */