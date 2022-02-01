import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class aobc
  extends smq.m
{
  aobc(aobb paramaobb) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      if (paramDownloadFileRspBody != null)
      {
        paramInt = paramDownloadFileRspBody.int32_ret_code.get();
        if (paramInt != 0) {
          break label549;
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
        paramDownloadFileRspBody.append((String)localObject).append("/ftn_handler/").append(str).append("/?fname=").append(aqhs.String2HexString(this.a.e.cjE));
        try
        {
          localObject = new JSONArray();
          ((JSONArray)localObject).put(0, paramDownloadFileRspBody.toString());
          localJSONObject.put("urls", localObject);
          localJSONObject.put("filename", this.a.e.fileName);
          localJSONObject.put("cookie", "FTN5K=" + paramBundle);
          paramInt = 1;
          if (paramInt != 0) {}
        }
        catch (Exception paramDownloadFileRspBody)
        {
          label459:
          QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult json exception: " + paramDownloadFileRspBody.toString());
        }
      }
    }
    try
    {
      localJSONObject.put("filename", this.a.e.fileName);
      localJSONObject.put("filetype", 3);
      localJSONObject.put("fileid", this.a.e.cjE);
      localJSONObject.put("businesstype", this.a.e.dNP);
      localJSONObject.put("groupuin", Long.valueOf(this.a.e.peerUin));
      localJSONObject.put("importoption", this.a.e.dNR);
      if (this.a.entity != null)
      {
        localJSONObject.put("md5", this.a.entity.strFileMd5);
        localJSONObject.put("sha", this.a.entity.strFileSHA);
      }
      localJSONObject.put("filesize", this.a.e.fileSize);
      this.a.e.cjG = this.a.e.cjE;
      this.a.e.filetype = 3;
      i = 1;
    }
    catch (Exception paramDownloadFileRspBody)
    {
      label549:
      QLog.e("TeamWorkFileImportJobForGroup", 2, "put fileid exception: " + paramDownloadFileRspBody.toString());
      break label459;
      this.a.QI(true);
    }
    if (((i != 0) || (paramInt != 0)) && (aoag.u(localJSONObject)) && (aobb.a(this.a, localJSONObject)))
    {
      this.a.a.a(localJSONObject, this.a.e, this.a.hashCode());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobc
 * JD-Core Version:    0.7.0.1
 */