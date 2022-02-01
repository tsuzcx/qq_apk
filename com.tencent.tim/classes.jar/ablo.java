import android.util.SparseArray;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class ablo
{
  private static long NR = -1L;
  private static SparseArray<Long> bX = new SparseArray();
  
  public static void d(CmGameStartChecker.StartCheckParam arg0)
  {
    if (??? != null)
    {
      int i = ???.gameId;
      if (i == 0) {
        return;
      }
      try
      {
        if (bX == null) {
          bX = new SparseArray();
        }
        synchronized (bX)
        {
          long l = System.currentTimeMillis();
          bX.put(i, Long.valueOf(l));
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameTimeReporter", 2, "[reportStart] set time " + i + " # " + l);
          }
          return;
        }
        QLog.e("ApolloGameTimeReporter", 1, "[reportStart] no para");
      }
      catch (Throwable ???)
      {
        QLog.e("ApolloGameTimeReporter", 1, ???, new Object[] { "[reportStart]" });
        return;
      }
    }
  }
  
  public static void destroy()
  {
    if (bX != null) {
      bX.clear();
    }
    bX = null;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameTimeReporter", 2, "[destroy]");
    }
  }
  
  public static void e(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    int i;
    if (paramStartCheckParam != null)
    {
      i = paramStartCheckParam.gameId;
      if (i == 0) {}
    }
    else
    {
      label301:
      for (;;)
      {
        try
        {
          if (bX == null) {
            break;
          }
          synchronized (bX)
          {
            int j = paramStartCheckParam.gameMode;
            long l1 = paramStartCheckParam.roomId;
            long l2 = ((Long)bX.get(i, Long.valueOf(NR))).longValue();
            paramStartCheckParam = abmt.a(i);
            if (paramStartCheckParam == null) {
              break label301;
            }
            paramStartCheckParam = paramStartCheckParam.c();
            if (paramStartCheckParam == null) {
              break label301;
            }
            l1 = paramStartCheckParam.mRoomId;
            if (l2 != NR)
            {
              long l3 = System.currentTimeMillis() - l2;
              VipUtils.a(null, "cmshow", "Apollo", "game_time", 0, 0, new String[] { i + "", String.valueOf(j), String.valueOf(l3), String.valueOf(l1) });
              bX.remove(i);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameTimeReporter", 2, new Object[] { "[reportEnd] report: id:", Integer.valueOf(i), "# roomId:", Long.valueOf(l1), "# mode:", Integer.valueOf(j), "# [", Long.valueOf(l3), "] #", Long.valueOf(l2), " => ", Long.valueOf(System.currentTimeMillis()) });
              }
            }
            return;
          }
          QLog.e("ApolloGameTimeReporter", 1, "[reportEnd] no para");
        }
        catch (Throwable paramStartCheckParam)
        {
          QLog.e("ApolloGameTimeReporter", 1, paramStartCheckParam, new Object[] { "[reportEnd]" });
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ablo
 * JD-Core Version:    0.7.0.1
 */