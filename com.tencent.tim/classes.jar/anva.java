import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anva
  extends anux
{
  protected long anW;
  protected long anX;
  protected boolean cKa;
  private String cis;
  private String cit;
  protected int dMG;
  protected int mDuration;
  protected long mStartTime;
  
  public anva()
  {
    this.mTypeName = "timer";
  }
  
  private SpannableStringBuilder a(long paramLong)
  {
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-91585);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.cis);
    localSpannableStringBuilder.append('\n');
    if (paramLong > 0L)
    {
      int i = localSpannableStringBuilder.length();
      String str = String.valueOf(paramLong) + acfp.m(2131715027);
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(this.text);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan, i, str.length() + i, 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(this.cit);
    return localSpannableStringBuilder;
  }
  
  private long hd()
  {
    if (!this.cKa)
    {
      long l1 = anaz.gQ();
      long l2 = this.mStartTime + this.mDuration - l1;
      if (l2 < 0L)
      {
        this.cKa = true;
        l1 = 0L;
      }
      do
      {
        return l1;
        if (l2 <= 0L) {
          break;
        }
        l1 = l2;
      } while (l2 < this.mDuration);
      return this.mDuration;
      this.cKa = true;
      return l2;
    }
    return 0L;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof CountdownTextView)))
    {
      paramContext = (CountdownTextView)paramView;
      paramContext.a(hd(), new anvb(this, paramContext));
      paramContext.setTag(this);
      return paramContext;
    }
    paramContext = new CountdownTextView(paramContext);
    paramContext.setId(2131380636);
    paramContext.setTag(this);
    paramContext.setMaxLines(3);
    paramContext.setTextColor(-10987432);
    paramContext.setTextSize(2, 12.0F);
    long l = hd();
    if (this.text != null) {
      paramContext.setText(a(l));
    }
    paramContext.a(l, new anvc(this, paramContext));
    return paramContext;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "timer");
    paramXmlSerializer.attribute(null, "st", String.valueOf(this.mStartTime));
    paramXmlSerializer.attribute(null, "dr", String.valueOf(this.mDuration));
    paramXmlSerializer.attribute(null, "index", String.valueOf(this.dMG));
    if (!TextUtils.isEmpty(this.cis)) {
      paramXmlSerializer.attribute(null, "summary", this.cis);
    }
    if (!TextUtils.isEmpty(this.cit)) {
      paramXmlSerializer.attribute(null, "ending", this.cit);
    }
    paramXmlSerializer.text(this.text);
    paramXmlSerializer.endTag(null, "timer");
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return true;
    }
    this.mStartTime = ansi.getLongValue(paramansf.getAttribute("st"));
    this.mDuration = ansi.getIntValue(paramansf.getAttribute("dr"));
    this.dMG = ansi.getIntValue(paramansf.getAttribute("index"));
    this.cis = anbk.w(paramansf.getAttribute("summary"), false);
    this.cit = anbk.w(paramansf.getAttribute("st"), false);
    this.text = anbk.w(anre.a(paramansf), false);
    return true;
  }
  
  public String getLayoutStr()
  {
    return "Timer";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.cis = anbk.w(paramObjectInput.readUTF(), false);
    this.cit = anbk.w(paramObjectInput.readUTF(), false);
    this.mStartTime = paramObjectInput.readLong();
    this.mDuration = paramObjectInput.readInt();
    this.dMG = paramObjectInput.readInt();
    this.anW = paramObjectInput.readLong();
    this.anX = paramObjectInput.readLong();
    this.cKa = paramObjectInput.readBoolean();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.cis == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.cit != null) {
        break label108;
      }
    }
    label108:
    for (String str = "";; str = this.cit)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.mStartTime);
      paramObjectOutput.writeInt(this.mDuration);
      paramObjectOutput.writeInt(this.dMG);
      paramObjectOutput.writeLong(this.anW);
      paramObjectOutput.writeLong(this.anX);
      paramObjectOutput.writeBoolean(this.cKa);
      return;
      str = this.cis;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anva
 * JD-Core Version:    0.7.0.1
 */