package com.tencent.mobileqq.emoticonview;

import afnt;
import afnt.a;
import ajdg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class EmoticonTabAdapter$1
  implements Runnable
{
  public EmoticonTabAdapter$1(afnt paramafnt, afnt.a parama) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.w("EmoticonTabAdapter", 2, "package lossY");
    }
    ajdg localajdg = (ajdg)this.this$0.app.getManager(14);
    EmoticonPackage localEmoticonPackage = localajdg.b(this.a.epId);
    if (localEmoticonPackage != null)
    {
      localEmoticonPackage.status = 0;
      localajdg.m(localEmoticonPackage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.1
 * JD-Core Version:    0.7.0.1
 */