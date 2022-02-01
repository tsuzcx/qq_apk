package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.Iterator;
import java.util.List;
import xsi;
import xsk;
import xto;
import xuf;
import xuh;

public class AIOGalleryScene$31
  implements Runnable
{
  public AIOGalleryScene$31(xsk paramxsk, long paramLong, xuf paramxuf, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    int i;
    boolean bool;
    if ((this.rJ == this.c.e.id) || (this.biV))
    {
      i = this.this$0.a.getSaveFileProgress(this.c.e.id, this.c.e.subId);
      if ((i >= 0) && (i < 100))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "onRevokeMsg isSaving:" + bool);
        }
        xsk.a(this.this$0, this.c, bool);
        xsi.b(xsk.O(this.this$0), xsk.b(this.this$0));
      }
    }
    label208:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (this.this$0.jdField_b_of_type_Xto.a(this.rJ) != null) {
          break label208;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + this.rJ + ", selectItem seq:" + this.c.e.id);
      return;
      List localList = this.this$0.jdField_b_of_type_Xto.be();
      Iterator localIterator = localList.iterator();
      xuf localxuf;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localxuf = (xuf)localIterator.next();
      } while (localxuf.e.id != this.c.e.id);
      i = localList.indexOf(localxuf);
    } while (i < 0);
    this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.notifyDataSetChanged(true);
    xsk.e(this.this$0).setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.31
 * JD-Core Version:    0.7.0.1
 */