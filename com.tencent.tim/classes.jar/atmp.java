import android.text.TextUtils;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.cloud.history_file_extension.history_file_extension.FileExtension;

public class atmp
  implements Manager
{
  private static final String TAG = atmp.class.getName();
  private atmp.a jdField_a_of_type_Atmp$a;
  atmp.b jdField_a_of_type_Atmp$b;
  private QQAppInterface app;
  
  public static atlb a(CloudHistoryInfo paramCloudHistoryInfo, FileManagerEntity paramFileManagerEntity)
  {
    if (paramCloudHistoryInfo != null)
    {
      atlb localatlb = new atlb();
      localatlb.title = paramCloudHistoryInfo.fileName;
      Object localObject;
      if (paramCloudHistoryInfo.fileIdBytes == null) {
        localObject = "";
      }
      for (;;)
      {
        localatlb.cGZ = ((String)localObject);
        localatlb.a = new atlb.a();
        localatlb.a.file_size = paramCloudHistoryInfo.fileSize;
        localatlb.a.file_type = paramCloudHistoryInfo.fileType;
        paramCloudHistoryInfo.operateTime /= 1000L;
        localatlb.a.ayh = paramCloudHistoryInfo.operateTime;
        localatlb.a.historyId = paramCloudHistoryInfo.historyId;
        localatlb.a.historySeq = paramCloudHistoryInfo.historySeq;
        localatlb.a.fileName = paramCloudHistoryInfo.fileName;
        localatlb.a.fileSize = paramCloudHistoryInfo.fileSize;
        localatlb.a.operateTime = paramCloudHistoryInfo.operateTime;
        localatlb.a.operateType = paramCloudHistoryInfo.operateType;
        localatlb.a.localPath = paramCloudHistoryInfo.localPath;
        localatlb.a.sourceType = paramCloudHistoryInfo.sourceType;
        localatlb.a.fileType = paramCloudHistoryInfo.fileType;
        atlb.a locala = localatlb.a;
        if (paramCloudHistoryInfo.fileSha == null)
        {
          localObject = "";
          label206:
          locala.cHi = ((String)localObject);
          locala = localatlb.a;
          if (paramCloudHistoryInfo.fileExtInfo != null) {
            break label512;
          }
          localObject = "";
          label228:
          locala.cHj = ((String)localObject);
          locala = localatlb.a;
          if (paramCloudHistoryInfo.fileIdBytes != null) {
            break label524;
          }
          localObject = "";
          label250:
          locala.cHk = ((String)localObject);
          localatlb.ayf = paramCloudHistoryInfo.operateTime;
          localatlb.aya = paramCloudHistoryInfo.operateTime;
          localatlb.dNU = atlb.eqm;
          localatlb.eqp = (atlb.eqm + paramCloudHistoryInfo.fileType);
          localatlb.cVN = 1;
          localatlb.cHa = "";
          localatlb.ayd = 300000000L;
          localatlb.eqn = 1;
          locala = localatlb.a;
          if ((paramFileManagerEntity == null) || (TextUtils.isEmpty(paramFileManagerEntity.peerNick))) {
            break label544;
          }
          localObject = paramFileManagerEntity.peerNick;
          label339:
          locala.cHm = ((String)localObject);
          locala = localatlb.a;
          if ((paramFileManagerEntity == null) || (TextUtils.isEmpty(paramFileManagerEntity.peerUin))) {
            break label550;
          }
          localObject = paramFileManagerEntity.peerUin;
          label370:
          locala.cHl = ((String)localObject);
          if (paramCloudHistoryInfo.sourceType == 5) {
            localatlb.a.cHm = "微云";
          }
          localatlb.cGX = aueh.rr(paramCloudHistoryInfo.localPath);
          if (paramFileManagerEntity != null)
          {
            localObject = localatlb.a;
            if (paramFileManagerEntity.nOpType != 0) {
              break label556;
            }
            paramFileManagerEntity = atlb.cGU;
            ((atlb.a)localObject).cHn = paramFileManagerEntity;
          }
          paramFileManagerEntity = new history_file_extension.FileExtension();
        }
        try
        {
          paramFileManagerEntity.mergeFrom(paramCloudHistoryInfo.fileExtInfo);
          if (paramFileManagerEntity.uint64_session_id.has()) {
            localatlb.a.ayi = paramFileManagerEntity.uint64_session_id.get();
          }
          return localatlb;
          localObject = new String(paramCloudHistoryInfo.fileIdBytes, Charset.forName("UTF-8"));
          continue;
          localObject = new String(paramCloudHistoryInfo.fileSha, Charset.forName("UTF-8"));
          break label206;
          label512:
          localObject = aqgo.encodeToString(paramCloudHistoryInfo.fileExtInfo, 0);
          break label228;
          label524:
          localObject = new String(paramCloudHistoryInfo.fileIdBytes, Charset.forName("UTF-8"));
          break label250;
          label544:
          localObject = "";
          break label339;
          label550:
          localObject = "";
          break label370;
          label556:
          paramFileManagerEntity = atlb.cGV;
        }
        catch (InvalidProtocolBufferMicroException paramCloudHistoryInfo)
        {
          for (;;)
          {
            paramCloudHistoryInfo.printStackTrace();
            QLog.e(TAG, 1, new Object[] { "web_db_helper webDbItemCreate error :", paramCloudHistoryInfo.toString() });
          }
        }
      }
    }
    return null;
  }
  
  public static CloudHistoryInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        CloudHistoryInfo localCloudHistoryInfo = new CloudHistoryInfo();
        localCloudHistoryInfo.historyId = paramJSONObject.optLong("historyId");
        localCloudHistoryInfo.historySeq = paramJSONObject.optLong("historySeq");
        localCloudHistoryInfo.fileName = paramJSONObject.optString("fileName");
        localCloudHistoryInfo.fileSize = paramJSONObject.optLong("fileSize");
        localCloudHistoryInfo.operateTime = paramJSONObject.optLong("operateTime");
        localCloudHistoryInfo.operateType = paramJSONObject.optInt("operateType");
        localCloudHistoryInfo.localPath = paramJSONObject.optString("localPath");
        localCloudHistoryInfo.sourceType = paramJSONObject.optInt("sourceType");
        localCloudHistoryInfo.fileId = paramJSONObject.optString("fileIdBytes");
        localCloudHistoryInfo.fileType = paramJSONObject.optInt("fileType");
        localCloudHistoryInfo.fileSha = paramJSONObject.optString("fileSha").getBytes();
        localCloudHistoryInfo.fileExtInfo = aqgo.decode(paramJSONObject.optString("fileExtInfo"), 0);
        localCloudHistoryInfo.fileIdBytes = paramJSONObject.optString("fileIdBytes").getBytes();
        return localCloudHistoryInfo;
      }
      catch (Exception paramJSONObject)
      {
        QLog.i(TAG, 2, "web_db_helper jsonToCloudHistoryInfo Exception = " + paramJSONObject.toString());
      }
    }
    return null;
  }
  
  private void a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    if (paramCloudHistoryInfo != null) {}
    try
    {
      paramCloudHistoryInfo = ahav.a(paramCloudHistoryInfo, paramObject);
      if (paramCloudHistoryInfo != null) {
        this.jdField_a_of_type_Atmp$a.KI.add(paramCloudHistoryInfo);
      }
      if (this.jdField_a_of_type_Atmp$a.KI.size() >= this.jdField_a_of_type_Atmp$a.KH.size()) {
        this.jdField_a_of_type_Atmp$b.onFetchRecentHistoryCallback(this.jdField_a_of_type_Atmp$a.KI, this.jdField_a_of_type_Atmp$a.hasMore, this.jdField_a_of_type_Atmp$a.errorCode, this.jdField_a_of_type_Atmp$a.errorMessage);
      }
      return;
    }
    finally {}
  }
  
  private JSONObject n(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      if (paramInt == atlb.eqm)
      {
        localJSONObject1.put("column", "local_search_type");
        localJSONObject1.put("type", 1);
        JSONObject localJSONObject2 = new JSONObject();
        try
        {
          localJSONObject2.put("open", false);
          localJSONObject2.put("lower", atlb.eqm);
          localJSONObject1.put("value", localJSONObject2);
          return localJSONObject1;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
      }
      localJSONObject1.put("column", "local_search_type");
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
      return localJSONObject1;
    }
    localJSONObject1.put("type", 4);
    localJSONObject1.put("value", paramInt);
    return localJSONObject1;
  }
  
  public int a(String paramString, JSONObject paramJSONObject)
  {
    return -1;
  }
  
  public void eue()
  {
    JSONArray localJSONArray1 = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray2 = new JSONArray("[\"title\",\"last_modify_ts\",\"last_browse_ts\",\"from_type\",\"owner_nick\",\"local_search_type\"]");
      localJSONObject.put("tableName", "recent_file_local");
      localJSONObject.put("keyName", "pad_id");
      localJSONObject.put("indexs", localJSONArray2);
      localJSONArray1.put(localJSONObject);
      z(localJSONArray1);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(TAG, 1, new Object[] { "web_db_helper initRecentWebTable error :", localJSONException.toString() });
      }
    }
  }
  
  public void onDestroy() {}
  
  public void z(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {}
  }
  
  public class a
  {
    List<CloudHistoryInfo> KH;
    List<atkw> KI;
    int errorCode;
    String errorMessage;
    boolean hasMore;
  }
  
  public static abstract interface b
  {
    public abstract void onFetchRecentHistoryCallback(List<atkw> paramList, boolean paramBoolean, int paramInt, String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void nN(List<CloudHistoryInfo> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmp
 * JD-Core Version:    0.7.0.1
 */