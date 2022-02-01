package com.tencent.mobileqq.danmaku.core;

import aewv;
import aexe;
import aeyj;
import aeyr;

class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, aexe paramaexe, aeyr paramaeyr) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Aexe == null)
    {
      DanmakuManager.a(this.this$0).Hp(false);
      return;
    }
    this.jdField_a_of_type_Aeyr.P(this.jdField_a_of_type_Aexe.getContentLeft(), this.jdField_a_of_type_Aexe.getContentTop());
    aeyj localaeyj = this.jdField_a_of_type_Aexe.a(this.jdField_a_of_type_Aeyr);
    if (DanmakuManager.a(this.this$0, localaeyj))
    {
      DanmakuManager.a(this.this$0).Hp(true);
      if (localaeyj.bWZ) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Aexe);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Aexe, this.jdField_a_of_type_Aeyr, localaeyj);
      return;
    }
    DanmakuManager.a(this.this$0).Hp(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */