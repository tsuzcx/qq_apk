import android.graphics.Color;
import android.text.TextUtils;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anuw
  extends anqw
{
  String bgColor;
  
  public anuw()
  {
    this(null);
  }
  
  public anuw(String paramString)
  {
    super(paramString, "remark");
  }
  
  public String Av()
  {
    return this.bgColor;
  }
  
  public int Kp()
  {
    return Color.rgb(128, 128, 128);
  }
  
  public int Kq()
  {
    return 24;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    super.a(paramXmlSerializer);
    if (!TextUtils.isEmpty(this.bgColor)) {
      paramXmlSerializer.attribute(null, "url", this.bgColor);
    }
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return true;
    }
    this.bgColor = paramansf.getAttribute("bgColor");
    return super.a(paramansf);
  }
  
  public String getLayoutStr()
  {
    return "Remark";
  }
  
  public int getMaxLines()
  {
    return 1;
  }
  
  public int getTextId()
  {
    return 2131380893;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.bgColor = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.bgColor == null) {}
    for (String str = "";; str = this.bgColor)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuw
 * JD-Core Version:    0.7.0.1
 */