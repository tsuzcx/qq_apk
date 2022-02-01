import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class agso
  implements aebf
{
  private String bkm;
  
  public agso(String paramString)
  {
    this.bkm = paramString;
    if (aqhq.fileExistsAndNotEmpty(this.bkm)) {
      this.bkm = new File(this.bkm).getAbsolutePath();
    }
  }
  
  private String vK()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("file_color_note_local_path", this.bkm);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public ColorNote getColorNote()
  {
    if (!aqhq.fileExistsAndNotEmpty(this.bkm))
    {
      QLog.i("LocalFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    ColorNote.a locala = new ColorNote.a();
    locala.a(17039360);
    String str = ahbr.F(5, this.bkm);
    if (QLog.isColorLevel()) {
      QLog.i("LocalFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    locala.a(str);
    str = ahav.getFileName(this.bkm);
    locala.b(str);
    locala.c(ahbj.g(ahav.getFileSizes(this.bkm)));
    int i = ahav.hL(ahav.getFileType(str));
    locala.d("resdrawable://" + i);
    str = vK();
    if (!TextUtils.isEmpty(str)) {
      locala.a(str.getBytes());
    }
    return locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agso
 * JD-Core Version:    0.7.0.1
 */