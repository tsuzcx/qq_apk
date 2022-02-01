import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class alen
{
  public String bWa;
  public String bWb;
  public String bWc;
  public String bWd;
  public String bWe;
  public int color;
  public Bitmap fQ;
  public Bitmap fR;
  public Bitmap fS;
  public int id;
  public String name;
  public String text;
  
  public alen(int paramInt)
  {
    this.id = paramInt;
  }
  
  public static alen a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = kb(paramString);
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PraiseInfo", 2, "content:" + paramString);
        }
        paramString = new JSONObject(paramString);
        alen localalen = new alen(paramInt);
        localalen.name = paramString.optString("name");
        localalen.text = paramString.optString("text");
        if (paramString.has("color"))
        {
          String str = paramString.optString("color").trim();
          paramString = str;
          if (str.startsWith("0x")) {
            paramString = str.substring(2);
          }
        }
        try
        {
          localalen.color = Color.parseColor("#" + paramString);
          return localalen;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PraiseInfo", 2, "color invalid");
            }
          }
        }
        return null;
      }
      catch (JSONException paramString)
      {
        QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with JsonException.", paramString);
        return null;
      }
      catch (IOException paramString)
      {
        QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with IOException.", paramString);
      }
    }
  }
  
  private static String kb(String paramString)
    throws IOException
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      QLog.e("PraiseInfo", 1, paramString + " not exist!");
    }
    do
    {
      return null;
      try
      {
        paramString = aqhq.readFileToString(localFile);
        return paramString;
      }
      catch (OutOfMemoryError paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("PraiseInfo", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alen
 * JD-Core Version:    0.7.0.1
 */