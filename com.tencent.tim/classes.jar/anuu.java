import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anuu
  extends anux
{
  private String comment;
  
  public anuu()
  {
    this.mTypeName = "price";
  }
  
  public anuu(String paramString)
  {
    this();
    this.text = paramString;
  }
  
  public anuu(String paramString1, String paramString2)
  {
    this(paramString1);
    this.comment = paramString2;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramContext = (LinearLayout)paramView;
      ((TextView)paramContext.findViewById(2131380850)).setText(this.text);
      ((TextView)paramContext.findViewById(2131380852)).setText(this.comment);
      return paramContext;
    }
    paramView = new LinearLayout(paramContext);
    paramView.setOrientation(0);
    paramBundle = new TextView(paramContext);
    paramBundle.setId(2131380850);
    paramBundle.setText(this.text);
    paramBundle.setTextColor(-65536);
    paramBundle.setTextSize(14.0F);
    paramBundle.setSingleLine();
    paramBundle.setEllipsize(a());
    paramBundle.setGravity(3);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131380852);
    paramContext.setText(this.comment);
    paramContext.setSingleLine();
    paramContext.setEllipsize(a());
    paramContext.setTextSize(10.0F);
    paramContext.setTextColor(-65536);
    paramContext.setGravity(80);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(5, 0, 0, 0);
    paramContext.setLayoutParams(localLayoutParams);
    paramView.addView(paramBundle);
    paramView.addView(paramContext);
    paramView.setTag(this);
    return paramView;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "price");
    if (!TextUtils.isEmpty(this.comment)) {
      paramXmlSerializer.attribute(null, "unit", this.comment);
    }
    paramXmlSerializer.text(this.text);
    paramXmlSerializer.endTag(null, "price");
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return true;
    }
    this.comment = anbk.w(paramansf.getAttribute("unit"), false);
    this.text = anbk.w(anre.a(paramansf), false);
    return true;
  }
  
  public String getLayoutStr()
  {
    return "Price";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.comment = anbk.w(paramObjectInput.readUTF(), false);
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.comment == null) {}
    for (String str = "";; str = this.comment)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuu
 * JD-Core Version:    0.7.0.1
 */