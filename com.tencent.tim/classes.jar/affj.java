import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;

public class affj
  extends affk
{
  public affj(QQAppInterface paramQQAppInterface)
  {
    super(ur(), paramQQAppInterface);
  }
  
  public static String ur()
  {
    if (imm.getCpuArchitecture() <= 2) {
      return "qq.android.qav.so_665";
    }
    return "";
  }
  
  public Class<? extends XmlData> g()
  {
    return QavSoData.class;
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affj
 * JD-Core Version:    0.7.0.1
 */