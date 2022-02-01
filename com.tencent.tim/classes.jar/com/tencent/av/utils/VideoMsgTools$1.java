package com.tencent.av.utils;

import com.tencent.mobileqq.app.QQAppInterface;

final class VideoMsgTools$1
  implements Runnable
{
  VideoMsgTools$1(int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt3, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    if ((this.aBm == 9) || (this.aBm == 62) || (this.aBm == 63))
    {
      VideoMsgTools.a(this.val$app, this.alR, this.aBm, this.aal, this.SO, this.SQ);
      return;
    }
    VideoMsgTools.b(this.val$app, this.alR, this.aBm, this.SO, this.SR, this.SQ, this.alQ, this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.1
 * JD-Core Version:    0.7.0.1
 */