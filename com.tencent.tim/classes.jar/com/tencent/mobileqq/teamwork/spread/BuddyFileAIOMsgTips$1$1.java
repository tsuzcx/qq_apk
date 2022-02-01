package com.tencent.mobileqq.teamwork.spread;

import aeur;
import aeus;
import ahbj;
import anaz;
import aocs.a;
import aocu;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

class BuddyFileAIOMsgTips$1$1
  implements Runnable
{
  BuddyFileAIOMsgTips$1$1(BuddyFileAIOMsgTips.1 param1, List paramList) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.GT);
    if (QLog.isColorLevel()) {
      QLog.i("BuddyFileAIOMsgTips", 1, "sub Thread getWordsList by buddyFile[" + System.currentTimeMillis() + "]");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new StringTokenizer(aeus.a().tW(), "|");
    if (!((StringTokenizer)localObject2).hasMoreTokens())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BuddyFileAIOMsgTips", 1, "config filetype is null");
      }
      this.a.a.mv(localArrayList);
      return;
    }
    String[] arrayOfString = new String[((StringTokenizer)localObject2).countTokens()];
    int i = 0;
    while (((StringTokenizer)localObject2).hasMoreTokens())
    {
      arrayOfString[i] = ((StringTokenizer)localObject2).nextToken();
      i += 1;
    }
    long l = anaz.gQ();
    localObject1 = ((List)localObject1).iterator();
    label304:
    label320:
    label369:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if (((FileManagerEntity)localObject2).uniseq == this.a.this$0.q.uniseq) {
          continue;
        }
        if (((FileManagerEntity)localObject2).srvTime - l * 1000L <= 86400000L) {
          break label304;
        }
        if (QLog.isColorLevel()) {
          QLog.i("BuddyFileAIOMsgTips", 1, "file is over 24h");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("BuddyFileAIOMsgTips", 1, "find file msg count[" + localArrayList.size() + "]");
      }
      this.a.a.mv(localArrayList);
      return;
      String str = ahbj.getExtension(((FileManagerEntity)localObject2).fileName);
      int j = arrayOfString.length;
      i = 0;
      if (i < j) {
        if (!arrayOfString[i].equalsIgnoreCase(str)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label369;
        }
        localArrayList.add(((FileManagerEntity)localObject2).fileName);
        break;
        i += 1;
        break label320;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips.1.1
 * JD-Core Version:    0.7.0.1
 */