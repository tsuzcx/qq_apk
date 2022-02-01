import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anve
  extends anqu
{
  public int type;
  
  public anve()
  {
    this.mTypeName = "type";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return null;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "type");
    paramXmlSerializer.text(this.type + "");
    paramXmlSerializer.endTag(null, "type");
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return false;
    }
    try
    {
      this.type = Integer.valueOf(anbk.w(anre.a(paramansf), false)).intValue();
      return true;
    }
    catch (Exception paramansf)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StructMsgItemType", 2, paramansf, new Object[0]);
        }
      }
    }
  }
  
  public String getLayoutStr()
  {
    return "type";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.type = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeInt(this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anve
 * JD-Core Version:    0.7.0.1
 */