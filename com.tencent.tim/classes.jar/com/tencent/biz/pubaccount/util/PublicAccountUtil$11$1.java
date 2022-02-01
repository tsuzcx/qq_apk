package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.data.OpenID;
import ocp;
import ocr;

public class PublicAccountUtil$11$1
  implements Runnable
{
  public PublicAccountUtil$11$1(ocr paramocr, Object paramObject) {}
  
  public void run()
  {
    if ((this.val$data instanceof OpenID))
    {
      OpenID localOpenID = (OpenID)this.val$data;
      if (ocp.a(this.this$0.val$activity, localOpenID, this.this$0.val$app, this.this$0.c)) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ocp.b(this.this$0.val$activity, this.this$0.val$app, this.this$0.c);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.11.1
 * JD-Core Version:    0.7.0.1
 */