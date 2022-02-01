package com.tencent.mobileqq.emosm.favroaming;

import afhj;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class EmoticonFromGroupDBManager$2
  implements Runnable
{
  public EmoticonFromGroupDBManager$2(afhj paramafhj, int paramInt, EmoticonFromGroupEntity paramEmoticonFromGroupEntity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_DBManager", 2, "db operation start single. opType: " + this.aLU);
    }
    switch (this.aLU)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_DBManager", 2, "db operation end single.");
      }
      return;
      if ((!this.this$0.a(this.a)) && (QLog.isColorLevel()))
      {
        QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "updateEntity error, e.md5=" + this.a.md5);
        continue;
        if ((!this.this$0.mEntityManager.remove(this.a)) && (QLog.isColorLevel()) && (this.a.getStatus() != 1000)) {
          QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "remove error, e.md5=" + this.a.md5);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager.2
 * JD-Core Version:    0.7.0.1
 */