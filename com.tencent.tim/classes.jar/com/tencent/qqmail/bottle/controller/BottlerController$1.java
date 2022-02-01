package com.tencent.qqmail.bottle.controller;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.bottle.model.Bottler;
import com.tencent.qqmail.bottle.model.table.BottlerTableData;
import com.tencent.qqmail.bottle.model.table.BottlerTableDataORM;
import java.util.concurrent.Callable;

class BottlerController$1
  implements Callable<Bottler[]>
{
  BottlerController$1(BottlerController paramBottlerController) {}
  
  public Bottler[] call()
    throws Exception
  {
    SQLiteDatabase localSQLiteDatabase = BottlerController.access$000(this.this$0).mDBOpenHelper.getWritableDatabase();
    Bottler localBottler1 = BottlerController.access$100(this.this$0);
    BottlerTableData localBottlerTableData = new BottlerTableData();
    Bottler localBottler2 = new Bottler();
    if (localBottler1 != null)
    {
      localBottlerTableData.setAll("@@mYboTtLe3.1415926", localBottler1.getAvatar(), localBottler1.getBigAvatar(), localBottler1.getName(), localBottler1.isAnonymous(), localBottler1.isMale(), 2);
      BottlerTableDataORM.replace(localSQLiteDatabase, localBottlerTableData);
      localBottler2.setAll("@@mYboTtLe3.1415926", localBottler1.getAvatar(), localBottler1.getBigAvatar(), localBottler1.getName(), localBottler1.isMale(), localBottler1.isAnonymous());
    }
    for (;;)
    {
      return new Bottler[] { localBottler1, localBottler2 };
      localBottlerTableData.setAll("@@mYboTtLe3.1415926", "", "", "", false, true, 2);
      BottlerTableDataORM.insertOrIgnore(localSQLiteDatabase, localBottlerTableData);
      localBottler2.setAll("@@mYboTtLe3.1415926", "", "", "", true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottlerController.1
 * JD-Core Version:    0.7.0.1
 */