import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.HashMap;

class vmn
  implements INetEngine.IBreakDownFix
{
  vmn(vml paramvml) {}
  
  public void fixReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
    localHttpNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
    paramNetResp.mWrittenBlockLen = 0L;
    paramNetResp = "bytes=" + localHttpNetReq.mStartDownOffset + "-";
    localHttpNetReq.mReqProperties.put("Range", paramNetResp);
    String str1 = localHttpNetReq.mReqUrl;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localHttpNetReq.mReqUrl = (str2 + "range=" + localHttpNetReq.mStartDownOffset);
    }
    paramNetReq = paramNetReq.getUserData();
    if ((paramNetReq != null) && ((paramNetReq instanceof vmp))) {
      ((vmp)paramNetReq).b = true;
    }
    xvv.b("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { paramNetResp, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmn
 * JD-Core Version:    0.7.0.1
 */