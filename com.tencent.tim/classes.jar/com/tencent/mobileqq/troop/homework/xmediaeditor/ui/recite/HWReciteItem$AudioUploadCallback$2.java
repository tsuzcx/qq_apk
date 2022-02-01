package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.support.v7.widget.RecyclerView.Adapter;
import apkp;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

class HWReciteItem$AudioUploadCallback$2
  implements Runnable
{
  HWReciteItem$AudioUploadCallback$2(HWReciteItem.a parama) {}
  
  public void run()
  {
    this.a.this$0.e.getAdapter().notifyItemChanged(this.a.d.mPosition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */