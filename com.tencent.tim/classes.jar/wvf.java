import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.xml.sax.XMLReader;

class wvf
  implements Html.TagHandler
{
  static
  {
    if (!wvd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  wvf(wvd paramwvd) {}
  
  public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    if (paramString.equalsIgnoreCase("newLine")) {}
    int i;
    do
    {
      do
      {
        paramEditable.append("\n");
        do
        {
          return;
        } while (!paramString.equalsIgnoreCase("emotion"));
        paramXMLReader = wvd.a(this.this$0, paramXMLReader, "id");
      } while (TextUtils.isEmpty(paramXMLReader));
      assert (paramXMLReader != null);
      i = Integer.parseInt(paramXMLReader);
      paramEditable.append(this.this$0.a("\024" + (char)i));
    } while (!QLog.isColorLevel());
    QLog.d("FullScreenInputHelper", 2, "[mix]handleTag: " + paramString + " emotionTag: " + paramXMLReader + " emotionId: " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvf
 * JD-Core Version:    0.7.0.1
 */