import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class agsp
  implements aebf
{
  private FileManagerEntity f;
  
  public agsp(FileManagerEntity paramFileManagerEntity)
  {
    this.f = paramFileManagerEntity;
  }
  
  private String vK()
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.f != null)
      {
        localJSONObject.put("file_color_note_peerType", this.f.peerType);
        localJSONObject.put("file_color_note_peerUin", this.f.peerUin);
        localJSONObject.put("file_color_note_uniSeq", this.f.uniseq);
        localJSONObject.put("file_color_note_sessionId", this.f.nSessionId);
        str = localJSONObject.toString();
      }
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public ColorNote getColorNote()
  {
    if (this.f == null)
    {
      QLog.i("OfflineFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
      return null;
    }
    ColorNote.a locala = new ColorNote.a();
    locala.a(17039360);
    String str = ahbr.F(1, this.f.nSessionId + "");
    if (QLog.isColorLevel()) {
      QLog.i("OfflineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "] fileId[" + this.f.Uuid + "]");
    }
    locala.a(str);
    locala.b(this.f.fileName);
    locala.c(ahbj.g(this.f.fileSize));
    int i = ahav.hL(ahav.getFileType(this.f.fileName));
    locala.d("resdrawable://" + i);
    str = vK();
    if (!TextUtils.isEmpty(str)) {
      locala.a(str.getBytes());
    }
    return locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agsp
 * JD-Core Version:    0.7.0.1
 */