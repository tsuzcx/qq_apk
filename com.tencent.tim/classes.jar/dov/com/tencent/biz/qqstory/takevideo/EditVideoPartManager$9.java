package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import aygz;
import ayym;
import com.tencent.qphone.base.util.QLog;

public class EditVideoPartManager$9
  implements Runnable
{
  public EditVideoPartManager$9(aygz paramaygz) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.W();
    if (localBitmap != null) {}
    try
    {
      if (aygz.r(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 64))
      {
        if (aygz.jdField_a_of_type_Ayym == null) {
          aygz.jdField_a_of_type_Ayym = new ayym();
        }
        aygz.jdField_a_of_type_Ayym.lE(localBitmap.getWidth(), localBitmap.getHeight());
      }
      return;
    }
    catch (Exception localException)
    {
      aygz.jdField_a_of_type_Ayym = null;
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.9
 * JD-Core Version:    0.7.0.1
 */