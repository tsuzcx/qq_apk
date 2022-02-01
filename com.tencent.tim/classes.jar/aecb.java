import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class aecb
  implements aebx
{
  private void al(Context paramContext, int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = paramContext.getString(2131693644);
    }
    QQToast.a(paramContext, 0, str, 0).show();
  }
  
  private void d(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject = getQQAppInterface();
    if (localObject == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      paramColorNote = new JSONObject(paramColorNote);
      long l1 = paramColorNote.getLong("file_color_note_uniSeq");
      long l2 = paramColorNote.getLong("file_color_note_sessionId");
      int i = paramColorNote.getInt("file_color_note_peerType");
      paramColorNote = paramColorNote.getString("file_color_note_peerUin");
      paramColorNote = ((QQAppInterface)localObject).a().a(l1, paramColorNote, i, l2);
      if (paramColorNote == null)
      {
        al(paramContext, 1);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    paramColorNote = new agvl((QQAppInterface)localObject, paramContext, paramColorNote, 10001);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("from_qlink_enter_recent", false);
    paramColorNote.cB((Bundle)localObject);
    paramContext = new agvn(paramContext, paramColorNote);
    paramContext.Oy(14);
    paramContext.Oz(268435456);
    paramContext.djN();
  }
  
  private void e(Context paramContext, ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    long l;
    try
    {
      paramColorNote = new JSONObject(paramColorNote);
      paramColorNote.getInt("file_color_note_peerType");
      l = paramColorNote.getLong("file_color_note_peerUin");
      paramColorNote = apsv.a(localQQAppInterface, l, paramColorNote.getString("file_color_note_file_uuid"), paramColorNote.getString("file_color_note_file_url"), paramColorNote.getString("file_color_note_fileName"), paramColorNote.getLong("file_color_note_fileSize"), paramColorNote.getInt("file_color_note_busId"));
      if (paramColorNote == null)
      {
        al(paramContext, 1);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramColorNote.Status == 12)
    {
      al(paramContext, 1);
      return;
    }
    paramContext = new agvn(paramContext, new agvr(localQQAppInterface, paramContext, l, paramColorNote, -1));
    paramContext.Oy(14);
    paramContext.g(TroopFileDetailBrowserActivity.class);
    paramContext.JE(true);
    paramContext.Oz(268435456);
    paramContext.djN();
  }
  
  private void f(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject = getQQAppInterface();
    if (localObject == null) {
      return;
    }
    String str = new String(paramColorNote.getReserve());
    try
    {
      str = new JSONObject(str).getString("file_color_note_local_path");
      if (!aqhq.fileExistsAndNotEmpty(str))
      {
        al(paramContext, 1);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    int i = ahbr.de(paramColorNote.getSubType());
    paramColorNote = new agvl((QQAppInterface)localObject, paramContext, ahav.a(FileInfo.a(str)), 10000);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("file_color_note_subType", i);
    paramColorNote.cB((Bundle)localObject);
    paramContext = new agvn(paramContext, paramColorNote);
    paramContext.Oy(14);
    paramContext.Oz(268435456);
    paramContext.djN();
  }
  
  private void g(Context paramContext, ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      long l = new JSONObject(paramColorNote).getLong("file_color_note_uniSeq");
      int i = DataLineMsgRecord.getDevTypeBySeId(l);
      paramColorNote = localQQAppInterface.b().a(i).a(l);
      if (paramColorNote != null)
      {
        paramContext = new agvn(paramContext, new agvm(paramContext, ahav.a(paramColorNote)));
        paramContext.Oy(14);
        paramContext.Oz(268435456);
        paramContext.djN();
        return;
      }
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    al(paramContext, 1);
  }
  
  private QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void h(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject = getQQAppInterface();
    if (localObject == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      JSONObject localJSONObject = new JSONObject(paramColorNote);
      long l = localJSONObject.getLong("file_color_note_sessionId");
      paramColorNote = ((QQAppInterface)localObject).a().b(l);
      WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.mtime = localJSONObject.getLong("file_color_note_cloud_lastTime");
      localWeiYunFileInfo.nFileSize = localJSONObject.getLong("file_color_note_fileSize");
      localWeiYunFileInfo.cYi = localJSONObject.getInt("file_color_note_cloud_srcType");
      localWeiYunFileInfo.bIk = localJSONObject.getString("file_color_note_cloud_fileId");
      localWeiYunFileInfo.dirKey = localJSONObject.getString("file_color_note_cloud_dirKey");
      localWeiYunFileInfo.strFileName = localJSONObject.getString("file_color_note_fileName");
      if (localJSONObject.has("file_color_note_cloud_encodeUrl")) {
        localWeiYunFileInfo.encodeUrl = localJSONObject.getString("file_color_note_cloud_encodeUrl");
      }
      if (localJSONObject.has("file_color_note_cloud_")) {
        localWeiYunFileInfo.md5 = localJSONObject.getString("file_color_note_cloud_");
      }
      if (localJSONObject.has("file_color_note_cloud_")) {
        localWeiYunFileInfo.sha = localJSONObject.getString("file_color_note_cloud_");
      }
      localObject = new agvs((QQAppInterface)localObject, paramContext, localWeiYunFileInfo);
      ((agvs)localObject).F(paramColorNote);
      paramContext = new agvn(paramContext, (agvq)localObject);
      paramContext.Oy(14);
      paramContext.Oz(268435456);
      paramContext.djN();
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void b(Context paramContext, ColorNote paramColorNote)
  {
    if (paramColorNote.getServiceType() != 17039360) {}
    int i;
    do
    {
      return;
      if (TextUtils.isEmpty(paramColorNote.getSubType()))
      {
        QLog.i("QFileColorNoteLauncher", 1, "launch: subType is null.");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFileColorNoteLauncher", 2, "launch: subKey[" + paramColorNote.getSubType() + "]");
      }
      i = ahbr.de(paramColorNote.getSubType());
      if (i == -1)
      {
        QLog.i("QFileColorNoteLauncher", 1, "launch: subType is unknown.");
        return;
      }
    } while (paramColorNote.getReserve() == null);
    switch (i)
    {
    default: 
      return;
    case 1: 
      d(paramContext, paramColorNote);
      return;
    case 2: 
      e(paramContext, paramColorNote);
      return;
    case 5: 
      f(paramContext, paramColorNote);
      return;
    case 4: 
      f(paramContext, paramColorNote);
      return;
    case 6: 
      g(paramContext, paramColorNote);
      return;
    }
    h(paramContext, paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aecb
 * JD-Core Version:    0.7.0.1
 */