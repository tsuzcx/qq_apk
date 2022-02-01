package com.tencent.biz.pubaccount;

import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.List;
import jym;

public class EncryptUinHandler$3
  implements Runnable
{
  public EncryptUinHandler$3(jym paramjym) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(this.this$0.mApp.getLongAccountUin()));
    jym.a(this.this$0, localArrayList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.EncryptUinHandler.3
 * JD-Core Version:    0.7.0.1
 */