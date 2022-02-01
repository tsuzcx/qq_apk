import com.tencent.mobileqq.app.QQAppInterface;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class azaa
{
  static BaseShortVideoOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    case 1: 
    case 4: 
    default: 
      return null;
    }
    return new ayzh(paramQQAppInterface);
  }
  
  public static void a(azaf paramazaf, QQAppInterface paramQQAppInterface)
  {
    if (paramazaf == null)
    {
      akxe.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramazaf.dFl, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      akxe.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramazaf.dFl);
      return;
    }
    localBaseShortVideoOprerator.mApp = paramQQAppInterface;
    localBaseShortVideoOprerator.a = paramazaf;
    localBaseShortVideoOprerator.bUB = paramazaf.cdE;
    localBaseShortVideoOprerator.logTag = paramazaf.logTag;
    localBaseShortVideoOprerator.a(paramazaf.jdField_b_of_type_Azal);
    akxe.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.fg(paramazaf.dFq) + ", reqBusiType" + paramazaf.dFl + ", uuid:" + paramazaf.cdE);
    switch (paramazaf.dFq)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramazaf.jdField_b_of_type_Azai);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramazaf.a);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramazaf.jdField_b_of_type_Azai);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramazaf.jdField_b_of_type_Azac);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramazaf.jdField_b_of_type_Azac);
      return;
    }
    localBaseShortVideoOprerator.eR(paramazaf.yu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azaa
 * JD-Core Version:    0.7.0.1
 */