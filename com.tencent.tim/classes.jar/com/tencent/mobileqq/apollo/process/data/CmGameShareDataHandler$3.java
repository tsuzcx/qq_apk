package com.tencent.mobileqq.apollo.process.data;

import abpg;
import abpg.a;
import abuj;
import abxi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(abpg paramabpg) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(abxi.biF + "gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = abpg.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        abpg.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          abpg.a locala = (abpg.a)abpg.a(this.this$0).get(i);
          if (locala != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", locala.bZN);
            localJSONObject.put("activity", locala.cpN);
            localJSONObject.put("aioType", locala.byr);
            localJSONObject.put("gameId", locala.mGameId);
            localJSONObject.put("uin", locala.mUin);
            localJSONObject.put("shareTS", locala.Oj);
            localJSONObject.put("shareRet", locala.cqC);
            ((JSONArray)localObject).put(localJSONObject);
            abpg.a(this.this$0).put(locala.getCacheKey(), Boolean.TRUE);
          }
        }
        else
        {
          abuj.writeFile(abxi.biF + "gameShareResult.txt", ((JSONArray)localObject).toString());
          QLog.d("cmgame_process.CmGameShareDataHandler", 1, "saveShareResult finish");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameShareDataHandler", 1, "saveShareResult e:", localException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("cmgame_process.CmGameShareDataHandler", 1, localOutOfMemoryError, new Object[0]);
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.3
 * JD-Core Version:    0.7.0.1
 */