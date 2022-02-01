import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceReqInfo;

public class anae
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<GetResourceReqInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramString = new ToServiceMsg("mobileqq.service", paramString, "ResourceConfig.GetResourceReq");
      paramString.extraData.putSerializable("getResourceReqInfos", paramArrayList);
      paramQQAppInterface.sendToService(paramString);
    }
  }
  
  public static void n(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = paramString2;
    localGetResourceReqInfo.uiCurVer = 0L;
    localGetResourceReqInfo.sResType = 4;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    localArrayList.add(localGetResourceReqInfo);
    a(paramQQAppInterface, paramString1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anae
 * JD-Core Version:    0.7.0.1
 */