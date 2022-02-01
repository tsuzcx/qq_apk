package com.tencent.beacon.module;

import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;

class QmspModule$2
  implements IAsyncQimeiListener
{
  QmspModule$2(QmspModule paramQmspModule) {}
  
  public void onQimeiDispatch(Qimei paramQimei)
  {
    QmspModule.a(this.a, paramQimei.getQimeiOld());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.module.QmspModule.2
 * JD-Core Version:    0.7.0.1
 */