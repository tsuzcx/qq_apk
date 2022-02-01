package com.tencent.mobileqq.emoticonview;

import afon;
import afon.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.List;
import mqq.os.MqqHandler;

public class EmotionPanelDataBuilder$1
  implements Runnable
{
  public EmotionPanelDataBuilder$1(afon paramafon, QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, afon.a parama) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.val$app, this.cSK, this.e, this.alR, this.val$businessType, this.bZV);
    ThreadManager.getUIHandler().post(new EmotionPanelDataBuilder.1.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1
 * JD-Core Version:    0.7.0.1
 */