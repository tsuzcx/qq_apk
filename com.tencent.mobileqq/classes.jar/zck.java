import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class zck
  implements Runnable
{
  public zck(IndividualRedPacketManager paramIndividualRedPacketManager) {}
  
  public void run()
  {
    int i = 0;
    String str = "font";
    Object localObject1 = str;
    try
    {
      arrayOfString = new String[4];
      localObject1 = str;
      arrayOfString[0] = IndividualRedPacketManager.a(5);
      localObject1 = str;
      arrayOfString[1] = IndividualRedPacketManager.a(6);
      localObject1 = str;
      arrayOfString[2] = IndividualRedPacketManager.a(7);
      localObject1 = str;
      arrayOfString[3] = IndividualRedPacketManager.a(8);
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String[] arrayOfString;
        Object localObject3;
        File[] arrayOfFile;
        int j;
        if (QLog.isColorLevel()) {
          QLog.e(IndividualRedPacketManager.b(), 2, "eliminateImageCache error: " + localException2.getMessage() + ", in step=" + (String)localObject1);
        }
        label425:
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_FailCode", localObject1);
          StatisticCollector.a(BaseApplicationImpl.sApplication.getApplicationContext()).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketClearCacheError", false, 1L, 0L, localHashMap, "", false);
          return;
        }
        catch (Exception localException1) {}
        i += 1;
      }
    }
    localObject1 = str;
    if (i < arrayOfString.length)
    {
      localObject1 = str;
      str = new String[] { "font", "aio", "tp", "send" }[i];
      localObject1 = str;
      localObject3 = new File(arrayOfString[i]);
      localObject1 = str;
      if (!((File)localObject3).exists()) {
        break label425;
      }
      localObject1 = str;
      if (!((File)localObject3).isDirectory()) {
        break label425;
      }
      localObject1 = str;
      arrayOfFile = ((File)localObject3).listFiles();
      if (arrayOfFile == null) {
        break label425;
      }
      localObject1 = str;
      if (arrayOfFile.length <= 150) {
        break label425;
      }
      localObject1 = str;
      Arrays.sort(arrayOfFile, this.a.jdField_a_of_type_JavaUtilComparator);
      j = 100;
      for (;;)
      {
        localObject1 = str;
        if (j < arrayOfFile.length)
        {
          localObject1 = str;
          localObject3 = this.a.jdField_a_of_type_JavaUtilLinkedList;
          localObject1 = str;
          try
          {
            this.a.jdField_a_of_type_JavaUtilLinkedList.add(arrayOfFile[j].getAbsolutePath());
            localObject1 = new File(arrayOfFile[j].getParent() + File.separator + System.currentTimeMillis());
            arrayOfFile[j].renameTo((File)localObject1);
            ((File)localObject1).delete();
            this.a.jdField_a_of_type_JavaUtilLinkedList.remove(arrayOfFile[j].getAbsolutePath());
            j += 1;
          }
          finally
          {
            localObject1 = str;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zck
 * JD-Core Version:    0.7.0.1
 */