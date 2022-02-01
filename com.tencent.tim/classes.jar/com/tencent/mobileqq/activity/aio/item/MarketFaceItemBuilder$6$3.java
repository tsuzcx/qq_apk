package com.tencent.mobileqq.activity.aio.item;

import afke;
import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import xju;

public class MarketFaceItemBuilder$6$3
  implements Runnable
{
  public MarketFaceItemBuilder$6$3(xju paramxju, MarketFaceItemBuilder.b paramb, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.b != null) && (this.b.tf != null))
    {
      if ((!this.a.this$0.bgY) || (!this.a.this$0.b.ajs())) {
        break label107;
      }
      this.b.tf.setVisibility(0);
      this.b.tf.setImageResource(2130838101);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and doesnot needplay epId = " + this.d.epId);
      }
    }
    return;
    label107:
    this.b.tf.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.3
 * JD-Core Version:    0.7.0.1
 */