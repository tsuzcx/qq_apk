import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anum
  extends anqu
{
  String mContent = "";
  
  public anum()
  {
    this.mTypeName = "more";
  }
  
  public anum(String paramString)
  {
    this();
    this.mContent = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = LayoutInflater.from(paramContext).inflate(2131563121, null);
    }
    paramContext = (TextView)paramBundle.findViewById(2131378852);
    if (TextUtils.isEmpty(this.mContent)) {
      this.mContent = acfp.m(2131715034);
    }
    paramContext.setText(this.mContent);
    return paramBundle;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "title");
    paramXmlSerializer.text(this.mContent);
    paramXmlSerializer.endTag(null, "title");
  }
  
  public boolean a(ansf paramansf)
  {
    this.mContent = anbk.w(anre.a(paramansf), false);
    return true;
  }
  
  public String getLayoutStr()
  {
    return "More";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.mContent = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.mContent == null) {}
    for (String str = "";; str = anbk.w(this.mContent, false))
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anum
 * JD-Core Version:    0.7.0.1
 */