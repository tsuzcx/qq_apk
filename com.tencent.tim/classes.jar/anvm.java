import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

public class anvm
  extends ansr
{
  public anvm()
  {
    this.mTypeName = "vote";
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "vote");
    if (this.aNt == null) {}
    for (String str = "";; str = this.aNt)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "vote");
      return;
    }
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return true;
    }
    paramansf = paramansf.getAttribute("cover");
    if (paramansf != null) {}
    for (;;)
    {
      this.aNt = paramansf;
      return true;
      paramansf = "";
    }
  }
  
  public String getLayoutStr()
  {
    return "VoteCover";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvm
 * JD-Core Version:    0.7.0.1
 */