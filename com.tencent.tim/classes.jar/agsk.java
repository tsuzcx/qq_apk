import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class agsk
  implements aebf
{
  private FileManagerEntity f;
  
  public agsk(FileManagerEntity paramFileManagerEntity)
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
        localJSONObject.put("file_color_note_sessionId", this.f.nSessionId);
        localJSONObject.put("file_color_note_cloud_lastTime", this.f.lastTime);
        localJSONObject.put("file_color_note_cloud_fileId", this.f.WeiYunFileId);
        localJSONObject.put("file_color_note_fileName", this.f.fileName);
        localJSONObject.put("file_color_note_fileSize", this.f.fileSize);
        localJSONObject.put("file_color_note_cloud_srcType", this.f.nWeiYunSrcType);
        localJSONObject.put("file_color_note_cloud_encodeUrl", this.f.strLargeThumPath);
        localJSONObject.put("file_color_note_cloud_dirKey", this.f.WeiYunDirKey);
        localJSONObject.put("file_color_note_cloud_", this.f.strFileMd5);
        localJSONObject.put("file_color_note_cloud_", this.f.strFileSHA);
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
      QLog.i("CloudFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
      return null;
    }
    ColorNote.a locala = new ColorNote.a();
    locala.a(17039360);
    String str = ahbr.F(3, this.f.nSessionId + this.f.WeiYunFileId);
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
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
 * Qualified Name:     agsk
 * JD-Core Version:    0.7.0.1
 */