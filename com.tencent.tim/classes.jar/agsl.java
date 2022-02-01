import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class agsl
  implements aebf
{
  private DataLineMsgRecord e;
  
  public agsl(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.e = paramDataLineMsgRecord;
  }
  
  private String vK()
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.e != null)
      {
        localJSONObject.put("file_color_note_uniSeq", this.e.sessionid);
        str = localJSONObject.toString();
      }
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public ColorNote getColorNote()
  {
    if (this.e == null)
    {
      QLog.i("DatalineFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
      return null;
    }
    ColorNote.a locala = new ColorNote.a();
    locala.a(17039360);
    String str = ahbr.F(6, this.e.sessionid + "");
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    locala.a(str);
    locala.b(this.e.filename);
    locala.c(ahbj.g(this.e.filesize));
    int i = ahav.hL(ahav.getFileType(this.e.filename));
    locala.d("resdrawable://" + i);
    str = vK();
    if (!TextUtils.isEmpty(str)) {
      locala.a(str.getBytes());
    }
    return locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agsl
 * JD-Core Version:    0.7.0.1
 */