import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anst
  extends anqu
{
  public boolean cJR;
  public int type;
  
  public anst()
  {
    this.mTypeName = "hr";
    this.mVersion = 9;
  }
  
  @TargetApi(11)
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (!this.cJR)
    {
      paramBundle = paramView;
      if (paramView == null) {
        paramBundle = new View(paramContext);
      }
      if (this.type == 0) {
        paramBundle.setBackgroundColor(-2170912);
      }
      do
      {
        do
        {
          return paramBundle;
        } while (this.type != 1);
        paramBundle.setBackgroundResource(2130848344);
      } while (Build.VERSION.SDK_INT < 11);
      paramBundle.setLayerType(1, null);
      return paramBundle;
    }
    return null;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "hr");
    if (this.mVersion > 4) {
      if (!this.cJR) {
        break label76;
      }
    }
    label76:
    for (String str = "true";; str = "false")
    {
      paramXmlSerializer.attribute(null, "hidden", str);
      if (this.mVersion >= 9) {
        paramXmlSerializer.attribute(null, "style", String.valueOf(this.type));
      }
      paramXmlSerializer.endTag(null, "hr");
      return;
    }
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {}
    for (;;)
    {
      return true;
      if (this.mVersion > 4)
      {
        String str = paramansf.getAttribute("hidden");
        if ((str != null) && (str.toLowerCase().equals("true"))) {
          this.cJR = true;
        }
      }
      if (this.mVersion >= 9)
      {
        paramansf = paramansf.getAttribute("style");
        if (!TextUtils.isEmpty(paramansf)) {
          try
          {
            this.type = Integer.parseInt(paramansf);
            if (QLog.isColorLevel())
            {
              QLog.i("StructMsg", 2, "type=" + this.type);
              return true;
            }
          }
          catch (NumberFormatException paramansf)
          {
            if (QLog.isColorLevel()) {
              QLog.e("StructMsg", 2, "", paramansf);
            }
          }
        }
      }
    }
    return false;
  }
  
  public String getLayoutStr()
  {
    return "Hr";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    if (this.mVersion > 4)
    {
      String str = paramObjectInput.readUTF();
      if ((str != null) && (str.toLowerCase().equals("true"))) {
        this.cJR = true;
      }
    }
    if (this.mVersion >= 9) {
      this.type = paramObjectInput.readInt();
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.cJR) {}
    for (String str = "true";; str = "false")
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.type);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anst
 * JD-Core Version:    0.7.0.1
 */