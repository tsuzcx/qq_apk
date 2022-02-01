import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

final class xkw
  implements aolm.b
{
  xkw(String paramString1, String paramString2) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "pe res download repeating ");
      }
      return;
    }
    boolean bool;
    if (paramaomh.mResult == 0)
    {
      paramaomh = paramaomh.b.atY;
      String str1 = aqhq.px(paramaomh);
      String str2 = this.aVx;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.aVy)))
      {
        try
        {
          aqhq.W(paramaomh, str2, false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            label78:
            if (QLog.isColorLevel()) {
              QLog.d("PokeEmo", 2, "downloadRes.onResp download succ but unzip is failed");
            }
            bool = false;
          }
        }
        aqhq.deleteFile(paramaomh);
        if (!bool) {
          break label184;
        }
        aqmj.SM(true);
        xks.bhj = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download result = " + bool);
      }
      xks.bhk = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download succ but md5 is mismatched");
      }
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp failed ");
      }
      bool = false;
      break label78;
      label184:
      xks.bTX += 1;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkw
 * JD-Core Version:    0.7.0.1
 */