package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emoticon.EmoticonController;
import java.io.File;
import mqq.app.MobileQQ;

public class GetEmoticonWhenNoFile
  extends AsyncStep
{
  protected int a()
  {
    if (!new File(this.a.a.getApplication().getFilesDir() + "/recommend_emoticon_" + this.a.a.a() + ".dat").exists())
    {
      ((EmosmHandler)this.a.a.a(11)).a();
      this.a.e = true;
    }
    EmoticonController.a(this.a.a).d();
    EmoticonController.a(this.a.a).e();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile
 * JD-Core Version:    0.7.0.1
 */