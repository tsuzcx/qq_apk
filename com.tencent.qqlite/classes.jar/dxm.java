import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class dxm
  extends Client.onRemoteRespObserver
{
  public dxm(DataApiPlugin paramDataApiPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str1;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.a.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key))
    {
      localObject = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i(DataApiPlugin.jdField_a_of_type_JavaLangString, 2, "response:" + (String)localObject);
      }
      if ((localObject != null) && (!"getUserVipType".equals(localObject))) {
        break label221;
      }
    }
    for (;;)
    {
      int i;
      JSONObject localJSONObject;
      label221:
      try
      {
        localObject = new JSONObject();
        i = paramBundle.getInt("type");
        ((JSONObject)localObject).put("result", 0);
        ((JSONObject)localObject).put("message", "ok");
        localJSONObject = new JSONObject();
        localJSONObject.put("uin", paramBundle.getString("uin"));
        localJSONObject.put("type", i);
        ((JSONObject)localObject).put("data", localJSONObject);
        if (!TextUtils.isEmpty(str1)) {
          this.a.callJs(str1 + "(" + ((JSONObject)localObject).toString() + ");");
        }
        return;
      }
      catch (JSONException paramBundle) {}
      if ("getFaceFilePath".equals(localObject))
      {
        int j;
        try
        {
          localJSONObject = new JSONObject();
          if (paramBundle == null) {
            continue;
          }
          paramBundle = paramBundle.getString("faceFilePath");
          if (!new File(paramBundle).exists()) {
            continue;
          }
          localObject = ImageUtil.a(new BitmapFactory.Options(), paramBundle, 200);
        }
        catch (Exception paramBundle) {}
        try
        {
          paramBundle = BitmapFactory.decodeFile(paramBundle, (BitmapFactory.Options)localObject);
          i = paramBundle.getWidth();
          j = paramBundle.getHeight();
          localObject = ImageUtil.a(paramBundle, i, i, j);
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (((Bitmap)localObject).getWidth() > 200) {
              paramBundle = ImageUtil.b((Bitmap)localObject, 200);
            }
          }
        }
        catch (OutOfMemoryError paramBundle)
        {
          paramBundle = null;
          continue;
        }
        if (paramBundle == null)
        {
          localJSONObject.put("result", 1002);
          if (!TextUtils.isEmpty(str1))
          {
            this.a.callJs(str1 + "(" + localJSONObject.toString() + ");");
            return;
            if (QLog.isColorLevel())
            {
              QLog.i(DataApiPlugin.jdField_a_of_type_JavaLangString, 2, "response IPC_FUNC_CMD_GET_FACE_FILE_PATH error: " + paramBundle.getMessage());
              return;
              paramBundle = ImageUtil.a();
            }
          }
        }
        else
        {
          localObject = new ByteArrayOutputStream();
          paramBundle.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
          String str2 = Base64Util.a(((ByteArrayOutputStream)localObject).toByteArray(), 2);
          localJSONObject.put("result", 0);
          localJSONObject.put("file", "data:image/png;base64," + str2);
          localJSONObject.put("size", paramBundle.getWidth());
          ((ByteArrayOutputStream)localObject).close();
          continue;
          localJSONObject.put("result", 1002);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dxm
 * JD-Core Version:    0.7.0.1
 */