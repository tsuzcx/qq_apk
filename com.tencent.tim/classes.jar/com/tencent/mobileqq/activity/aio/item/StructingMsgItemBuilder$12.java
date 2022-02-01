package com.tencent.mobileqq.activity.aio.item;

import ansu;
import aoiz;
import aoop;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class StructingMsgItemBuilder$12
  implements Runnable
{
  StructingMsgItemBuilder$12(StructingMsgItemBuilder paramStructingMsgItemBuilder, ansu paramansu) {}
  
  public void run()
  {
    Object localObject = aoop.a(this.a.j, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      if ((aoiz.hasFile((String)localObject)) && (this.a.j.thumbWidthHeightDP != null))
      {
        String str = aoiz.getFilePath((String)localObject);
        QLog.d("StructingMsgItemBuilder", 1, new Object[] { "big image exists, begin compress urlString=", localObject, ", dst=", str });
        StructingMsgItemBuilder.b(str, aoop.a(this.a.j, 65537), this.a.j.thumbWidthHeightDP);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */