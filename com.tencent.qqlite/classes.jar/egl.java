import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.HashMap;

public final class egl
  implements INetEngine.IBreakDownFix
{
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      paramNetReq = (HttpNetReq)paramNetReq;
      paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
      paramNetResp.c = 0L;
      paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
      paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
      paramNetResp = paramNetReq.jdField_a_of_type_JavaLangString;
    } while (!paramNetResp.contains("range="));
    paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
    paramNetReq.jdField_a_of_type_JavaLangString = (paramNetResp + "range=" + paramNetReq.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     egl
 * JD-Core Version:    0.7.0.1
 */