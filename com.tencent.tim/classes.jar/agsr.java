import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class agsr
  implements aebf
{
  private apcy d;
  private String mTroopUin;
  
  public agsr(long paramLong, apcy paramapcy)
  {
    this.mTroopUin = (paramLong + "");
    this.d = paramapcy;
  }
  
  private String vK()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.mTroopUin);
      localJSONObject.put("file_color_note_fileName", this.d.FileName);
      localJSONObject.put("file_color_note_fileSize", this.d.ProgressTotal);
      if (this.d.Id != null) {
        localJSONObject.put("file_color_note_file_uuid", this.d.Id.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.d.FilePath);
        localJSONObject.put("file_color_note_busId", this.d.BusId);
        return localJSONObject.toString();
        localJSONObject.put("file_color_note_file_uuid", "");
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public ColorNote getColorNote()
  {
    if (this.d != null) {}
    ColorNote.a locala = new ColorNote.a();
    locala.a(17039360);
    String str = ahbr.F(2, this.d.FilePath);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    locala.a(str);
    locala.b(this.d.FileName);
    locala.c(ahbj.g(this.d.ProgressTotal));
    int i = ahav.hL(ahav.getFileType(this.d.FileName));
    locala.d("resdrawable://" + i);
    str = vK();
    if (!TextUtils.isEmpty(str)) {
      locala.a(str.getBytes());
    }
    return locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agsr
 * JD-Core Version:    0.7.0.1
 */