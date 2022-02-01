import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

public class anuy
  extends anqw
{
  public int bkg = 48;
  public boolean cJP;
  public boolean cJZ = true;
  public int dMq;
  public int maxLines = 1;
  public int weight = 1;
  
  public anuy()
  {
    this(null);
  }
  
  public anuy(String paramString)
  {
    super(paramString, "td");
  }
  
  public int Kp()
  {
    if ((this.cJP) && (this.dMq != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int Kq()
  {
    return 28;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, this.mTypeName);
    paramXmlSerializer.attribute(null, "weight", String.valueOf(this.weight));
    paramXmlSerializer.attribute(null, "align", String.valueOf(this.bkg));
    paramXmlSerializer.endTag(null, this.mTypeName);
    super.a(paramXmlSerializer);
  }
  
  public boolean a(ansf paramansf)
  {
    try
    {
      Object localObject = paramansf.getAttribute("weight");
      if (localObject != null) {}
      for (int i = Integer.parseInt((String)localObject);; i = 0)
      {
        this.weight = i;
        localObject = paramansf.getAttribute("align");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split("\\|");
        HashMap localHashMap = new HashMap();
        localHashMap.put("left", Integer.valueOf(3));
        localHashMap.put("right", Integer.valueOf(5));
        localHashMap.put("top", Integer.valueOf(48));
        localHashMap.put("bottom", Integer.valueOf(80));
        localHashMap.put("center", Integer.valueOf(17));
        i = 0;
        while (i < localObject.length)
        {
          if (!TextUtils.isEmpty(localObject[i]))
          {
            String str = localObject[i].toLowerCase();
            if (localHashMap.containsKey(str))
            {
              int j = this.bkg;
              this.bkg = (((Integer)localHashMap.get(str)).intValue() | j);
            }
          }
          i += 1;
        }
      }
      return super.a(paramansf);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.weight = 1;
    }
  }
  
  public TextView d(Context paramContext)
  {
    return new TextView(paramContext);
  }
  
  public String getLayoutStr()
  {
    return "td";
  }
  
  public int getMaxLines()
  {
    return this.maxLines;
  }
  
  protected int getTextId()
  {
    return 2131380951;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.weight = paramObjectInput.readInt();
    this.bkg = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeInt(this.weight);
    paramObjectOutput.writeInt(this.bkg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuy
 * JD-Core Version:    0.7.0.1
 */