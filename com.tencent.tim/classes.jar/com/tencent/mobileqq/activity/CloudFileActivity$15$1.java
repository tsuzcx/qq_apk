package com.tencent.mobileqq.activity;

import atgc;
import auhh;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import urf;

public class CloudFileActivity$15$1
  implements Runnable
{
  public CloudFileActivity$15$1(urf paramurf, List paramList) {}
  
  public void run()
  {
    Object localObject = (atgc)this.a.this$0.app.getManager(373);
    if (localObject != null) {}
    for (localObject = ((atgc)localObject).aG();; localObject = null)
    {
      if ((CloudFileActivity.a(this.a.this$0) != null) && (this.qD != null) && (localObject != null)) {
        CloudFileActivity.a(this.a.this$0).a((byte[])localObject, this.qD, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.CloudFileActivity.15.1
 * JD-Core Version:    0.7.0.1
 */