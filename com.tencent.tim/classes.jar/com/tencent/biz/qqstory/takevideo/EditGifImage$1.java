package com.tencent.biz.qqstory.takevideo;

import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import auru;
import awcg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import rdc;

class EditGifImage$1
  implements Runnable
{
  EditGifImage$1(EditGifImage paramEditGifImage, LruCache paramLruCache) {}
  
  public void run()
  {
    if (!this.this$0.aGp)
    {
      if ((!(this.this$0.b.a.a instanceof EditLocalGifSource)) || (((EditLocalGifSource)this.this$0.b.a.a).ns == null) || (((EditLocalGifSource)this.this$0.b.a.a).ns.size() <= 0)) {
        break label284;
      }
      ArrayList localArrayList = ((EditLocalGifSource)this.this$0.b.a.a).ns;
      if (!awcg.a().a(localArrayList, this.j)) {
        break label247;
      }
      this.this$0.aGq = true;
      this.this$0.jdField_a_of_type_Auru.sendEmptyMessage(996);
      if ((this.j != null) && (this.j.size() == localArrayList.size()))
      {
        localArrayList = new ArrayList();
        int i = 0;
        while (i < this.j.size())
        {
          BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.j.get(Integer.valueOf(i));
          if (localBitmapDrawable != null) {
            localArrayList.add(localBitmapDrawable.getBitmap());
          }
          i += 1;
        }
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$a = new EditGifImage.a(this.this$0);
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$a.execute(new ArrayList[] { localArrayList });
      }
    }
    label247:
    do
    {
      do
      {
        return;
        this.this$0.aGq = false;
        this.this$0.jdField_a_of_type_Auru.sendEmptyMessage(997);
      } while (!QLog.isColorLevel());
      QLog.d("QzoneVision", 2, "MSG_CANNOT_ANTISHAKE");
      return;
      this.this$0.aGq = false;
      this.this$0.jdField_a_of_type_Auru.sendEmptyMessage(997);
    } while (!QLog.isColorLevel());
    label284:
    QLog.d("QzoneVision", 2, "MSG_CANNOT_ANTISHAKE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditGifImage.1
 * JD-Core Version:    0.7.0.1
 */