import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

final class acmv
  extends ansr
{
  acmv(String paramString)
  {
    super(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.aNt == null) {}
    for (String str = "";; str = this.aNt)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acmv
 * JD-Core Version:    0.7.0.1
 */