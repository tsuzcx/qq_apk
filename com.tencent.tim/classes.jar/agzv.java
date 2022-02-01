import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class agzv
{
  public static int a(auyc paramauyc, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == 0L)
    {
      if (paramLong1 < paramauyc.a(BaseApplication.getContext(), paramLong1, paramLong3, 1024)) {}
      for (;;)
      {
        i = (int)paramLong1;
        int k = auye.getNetWorkType(BaseApplication.getContext());
        int j;
        if (k != 1)
        {
          j = i;
          if (k != 2) {}
        }
        else
        {
          j = i;
          if (i > 16384) {
            j = 16384;
          }
        }
        i = Math.min(j, 1048576);
        if (QLog.isColorLevel()) {
          QLog.d("OfflineFileHttpUtils<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong2 + "], size[" + i + "]");
        }
        return i;
        paramLong1 = 1024L;
      }
    }
    int i = paramauyc.a(BaseApplication.getContext(), paramLong1, paramLong2, 131072);
    if (paramLong1 < i + paramLong2) {}
    for (paramLong1 -= paramLong2;; paramLong1 = i)
    {
      i = (int)paramLong1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agzv
 * JD-Core Version:    0.7.0.1
 */