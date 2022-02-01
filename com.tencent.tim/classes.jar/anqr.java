import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class anqr
{
  public aqhv a;
  public short ac;
  public String cgQ = "";
  public String cgR = "";
  public String cgS = "";
  public String cgT = "";
  public String cgU = "";
  public String cgV;
  public String cgW;
  public String channelId = "";
  public String desc = "";
  @unique
  public String id;
  public String md5;
  public String msg = "";
  public String subject = "";
  public String time;
  
  public anqr(long paramLong, String paramString, short paramShort)
  {
    this.id = String.valueOf(paramLong);
    this.time = paramString;
    if (paramShort == 0)
    {
      this.ac = 10;
      return;
    }
    this.ac = paramShort;
  }
  
  public boolean pD(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("&");
      if (arrayOfString.length == 7)
      {
        this.cgQ = arrayOfString[0].substring("RESPCONDITION=".length());
        this.subject = arrayOfString[1].substring("SUBJECT=".length());
        this.desc = arrayOfString[2].substring("DESC=".length());
        this.cgR = arrayOfString[3].substring("RESPDESC=".length());
        this.cgS = arrayOfString[4].substring("RESPCONTENTTYPES=".length());
        this.cgT = aqoj.pL(arrayOfString[5].substring("RESPDEST=".length()));
        int i;
        String str;
        if ((this.cgT != null) && (this.cgT.length() > 0))
        {
          i = this.cgT.lastIndexOf("channel_id");
          if (i != -1)
          {
            paramString = this.cgT.substring(i);
            i = paramString.charAt("channel_id".length());
            if (i != 37) {
              break label244;
            }
            str = paramString.substring(paramString.indexOf('%') + 3);
            paramString = str;
            if (str.indexOf('%') > 0) {
              paramString = str.substring(0, str.indexOf('%'));
            }
            this.channelId = paramString;
          }
        }
        for (;;)
        {
          this.cgU = arrayOfString[6].substring("RESPCONTENTS=".length());
          if (!"PLUGIN".equalsIgnoreCase(this.cgS)) {
            break;
          }
          return true;
          label244:
          if (i == 61)
          {
            str = paramString.substring(paramString.indexOf('=') + 1);
            paramString = str;
            if (str.indexOf('&') > 0) {
              paramString = str.substring(0, str.indexOf('&'));
            }
            this.channelId = paramString;
          }
        }
        return false;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PushBanner", 2, "loadParams Exception:", paramString);
      }
    }
    throw new IllegalArgumentException("PushBanner Params Count must be:7");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqr
 * JD-Core Version:    0.7.0.1
 */