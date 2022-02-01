package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.d.a.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class StatisticReport$2
  implements a.a
{
  StatisticReport$2(StatisticReport paramStatisticReport) {}
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    if (paramInputStream == null) {}
    do
    {
      return;
      try
      {
        paramMap = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          paramInt = paramInputStream.read(arrayOfByte);
          if (paramInt == -1) {
            break;
          }
          paramMap.write(arrayOfByte, 0, paramInt);
        }
        paramMap.close();
      }
      catch (IOException paramMap)
      {
        paramMap.printStackTrace();
        return;
      }
      paramInputStream.close();
      paramMap = new String(paramMap.toByteArray());
      f.c(paramMap, new Object[0]);
      try
      {
        paramInt = new JSONObject(paramMap).getInt("CODE");
        if (paramInt == 0)
        {
          f.a("Statistic report successfully!", new Object[0]);
          return;
        }
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
        return;
      }
      if (paramInt == -1001)
      {
        f.c("Statistic report error! Not post method!", new Object[0]);
        return;
      }
      if (paramInt == -1002)
      {
        f.c("Statistic report error! Params not valid!", new Object[0]);
        return;
      }
      if (paramInt == -1003)
      {
        f.c("Statistic report error! Server exception!", new Object[0]);
        return;
      }
      if (paramInt == -1004)
      {
        f.c("Statistic report error! Server over charge!", new Object[0]);
        return;
      }
      if (paramInt == -1005)
      {
        f.c("Statistic report error! DB exception!", new Object[0]);
        return;
      }
      if (paramInt == -1006)
      {
        f.c("Statistic report error! DB exception!", new Object[0]);
        return;
      }
    } while (paramInt != -1007);
    f.c("Statistic report error! Config not hit!", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport.2
 * JD-Core Version:    0.7.0.1
 */