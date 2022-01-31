package com.tencent.mobileqq.emosm.view;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.widget.ProgressCircle;

class DragSortAdapter$2
  extends EmoticonPackageDownloadListener
{
  DragSortAdapter$2(DragSortAdapter paramDragSortAdapter, EmoticonPackage paramEmoticonPackage, ProgressCircle paramProgressCircle, View paramView1, View paramView2) {}
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.epId.equals(this.val$pkg.epId)) && (paramEmoticonPackage.status == 2)) {
      DragSortAdapter.access$000(this.this$0).post(new DragSortAdapter.2.3(this, paramInt));
    }
  }
  
  public void onPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.epId.equals(this.val$pkg.epId)) && (paramEmoticonPackage.status == 2)) {
      DragSortAdapter.access$000(this.this$0).post(new DragSortAdapter.2.2(this, paramInt1, paramInt2));
    }
  }
  
  public void onPackageStart(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.epId.equals(this.val$pkg.epId)) && (paramEmoticonPackage.status == 2)) {
      DragSortAdapter.access$000(this.this$0).post(new DragSortAdapter.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.2
 * JD-Core Version:    0.7.0.1
 */