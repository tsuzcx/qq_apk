import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class aulf
  extends smq.m
{
  aulf(aule paramaule) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      if (paramDownloadFileRspBody != null)
      {
        paramInt = paramDownloadFileRspBody.int32_ret_code.get();
        if (paramInt != 0) {
          break label414;
        }
        Object localObject = aqhs.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
        paramBundle = (Bundle)localObject;
        if (localObject != null) {
          paramBundle = ((String)localObject).toLowerCase();
        }
        localObject = paramDownloadFileRspBody.str_download_ip.get();
        String str = aqhs.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.i("TeamWorkFileImportJobForGroup", 2, "---onReqDownloadFileResult success ,ip: " + (String)localObject + ",param: " + str);
        }
        paramDownloadFileRspBody = new StringBuilder("http://");
        paramDownloadFileRspBody.append((String)localObject).append("/ftn_handler/").append(str).append("/?fname=").append(aqhs.String2HexString(this.a.c.cjE));
        try
        {
          localObject = new JSONArray();
          ((JSONArray)localObject).put(0, paramDownloadFileRspBody.toString());
          localJSONObject.put("urls", localObject);
          localJSONObject.put("filename", this.a.c.fileName);
          localJSONObject.put("cookie", "FTN5K=" + paramBundle);
          paramInt = 1;
          if (paramInt != 0) {}
        }
        catch (Exception paramDownloadFileRspBody)
        {
          label346:
          QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult json exception: " + paramDownloadFileRspBody.toString());
        }
      }
    }
    try
    {
      localJSONObject.put("filename", this.a.c.fileName);
      localJSONObject.put("filetype", 3);
      localJSONObject.put("fileid", this.a.c.cjE);
      localJSONObject.put("businesstype", this.a.c.dNP);
      localJSONObject.put("groupuin", Long.valueOf(this.a.c.peerUin));
      i = 1;
    }
    catch (Exception paramDownloadFileRspBody)
    {
      label414:
      QLog.e("TeamWorkFileImportJobForGroup", 2, "put fileid exception: " + paramDownloadFileRspBody.toString());
      break label346;
      this.a.QI(true);
    }
    if (((i != 0) || (paramInt != 0)) && (localJSONObject != null))
    {
      this.a.a.a(localJSONObject, this.a.c);
      return;
      for (;;)
      {
        paramInt = 0;
        break;
        QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult retCode: " + paramInt);
        continue;
        QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult errorCode: " + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulf
 * JD-Core Version:    0.7.0.1
 */