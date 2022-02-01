import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.PrecoverData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class affd
  extends afeu
{
  public affd(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.early.precover", paramQQAppInterface);
  }
  
  public boolean aiV()
  {
    return false;
  }
  
  public boolean ajb()
  {
    File localFile = new File(up());
    return (localFile != null) && (localFile.exists());
  }
  
  public boolean ajc()
  {
    File localFile = new File(uq());
    return (localFile != null) && (localFile.exists());
  }
  
  public void f(XmlData paramXmlData)
  {
    super.f(paramXmlData);
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof PrecoverData))) {
      QLog.d("PrecoverHandler", 2, new Object[] { "doOnServerResp, xmlData=", paramXmlData });
    }
  }
  
  public Class<? extends XmlData> g()
  {
    return PrecoverData.class;
  }
  
  public int getBusinessId()
  {
    return 10045;
  }
  
  public String un()
  {
    return "actEarlyPrecover";
  }
  
  public String uo()
  {
    return "prd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affd
 * JD-Core Version:    0.7.0.1
 */