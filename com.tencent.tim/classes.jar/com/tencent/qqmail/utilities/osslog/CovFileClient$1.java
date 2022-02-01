package com.tencent.qqmail.utilities.osslog;

import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import rx.functions.Func1;

class CovFileClient$1
  implements Func1<Integer, Void>
{
  CovFileClient$1(CovFileClient paramCovFileClient) {}
  
  public Void call(Integer paramInteger)
  {
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      QMLog.log(4, "CovFileClient", "finish upload request, ret: " + paramInteger);
      return null;
      new File(CovFileClient.getCovLogPath()).delete();
      QMLog.log(5, "CovFileClient", "finish");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.osslog.CovFileClient.1
 * JD-Core Version:    0.7.0.1
 */