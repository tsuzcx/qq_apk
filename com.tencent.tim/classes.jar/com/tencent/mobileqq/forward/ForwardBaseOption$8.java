package com.tencent.mobileqq.forward;

import ahgq;
import android.os.Bundle;
import aqju;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ForwardBaseOption$8
  implements Runnable
{
  public ForwardBaseOption$8(ahgq paramahgq, String paramString, aqju paramaqju) {}
  
  public void run()
  {
    Object localObject1;
    if (!this.this$0.cgO)
    {
      localObject2 = ahgq.a(this.this$0, this.val$filepath);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label83;
      }
      this.this$0.d(this.aq);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView getNormalDrawable null");
      }
    }
    do
    {
      return;
      localObject2 = ahgq.a(this.this$0);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView getURLDrawable null");
    return;
    label83:
    this.this$0.b(localObject1, this.this$0.cgO);
    Object localObject2 = (ArrayList)this.this$0.bf.get("PhotoConst.PHOTO_PATHS");
    ahgq localahgq = this.this$0;
    if (localObject2 != null) {}
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localahgq.a(localObject1, true, i, this.this$0.cgO);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.8
 * JD-Core Version:    0.7.0.1
 */