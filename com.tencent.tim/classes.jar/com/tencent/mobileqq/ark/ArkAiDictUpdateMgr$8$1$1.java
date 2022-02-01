package com.tencent.mobileqq.ark;

import adpq.b;
import adpq.d;
import adpz;
import aopo;
import java.lang.ref.WeakReference;

public class ArkAiDictUpdateMgr$8$1$1
  implements Runnable
{
  public ArkAiDictUpdateMgr$8$1$1(adpz paramadpz, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Adpq$d.gv == null)
    {
      ArkAppCenter.r("ArkApp.Dict.Update", "downloadDictFile, weakPreDownloadCtrl is null, return");
      return;
    }
    aopo localaopo = (aopo)this.a.a.jdField_a_of_type_Adpq$d.gv.get();
    if (localaopo == null)
    {
      ArkAppCenter.r("ArkApp.Dict.Update", "downloadDictFile, preDownloadController is null, return");
      return;
    }
    byte[] arrayOfByte = this.du;
    long l;
    if (this.a.a.jdField_a_of_type_Adpq$d.bQk) {
      if (this.val$success)
      {
        String str = this.a.a.val$url;
        if (arrayOfByte == null)
        {
          l = 0L;
          localaopo.be(str, l);
        }
      }
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_Adpq$b.aY(arrayOfByte);
      return;
      l = arrayOfByte.length;
      break;
      localaopo.be(this.a.a.val$url, -1L);
      arrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8.1.1
 * JD-Core Version:    0.7.0.1
 */