import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anse
  extends anqu
{
  public int length;
  
  public anse()
  {
    this.mTypeName = "voice";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return null;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "voice");
    paramXmlSerializer.attribute(null, "length", String.valueOf(this.length));
    paramXmlSerializer.endTag(null, "voice");
  }
  
  public boolean a(ansf paramansf)
  {
    paramansf = paramansf.getAttribute("length");
    if (!TextUtils.isEmpty(paramansf)) {
      this.length = Integer.parseInt(paramansf);
    }
    return true;
  }
  
  public String getLayoutStr()
  {
    return null;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.length = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeInt(this.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anse
 * JD-Core Version:    0.7.0.1
 */