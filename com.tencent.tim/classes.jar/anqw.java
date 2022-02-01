import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle.TitleTextView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class anqw
  extends anqu
  implements View.OnClickListener
{
  private static int CURRENT_VERSION = 11;
  protected boolean cJF;
  protected boolean cJG;
  protected String chI;
  protected String chJ;
  protected String chK;
  protected String chL;
  protected String chM;
  protected String chN;
  protected String chO;
  public String chP;
  public String text;
  protected String textColor;
  protected String textStyle;
  
  public anqw()
  {
    this.mVersion = CURRENT_VERSION;
  }
  
  public anqw(String paramString1, String paramString2)
  {
    this.mVersion = CURRENT_VERSION;
    this.mTypeName = paramString2;
    this.text = paramString1;
  }
  
  public String As()
  {
    return this.chJ;
  }
  
  public String At()
  {
    return this.textStyle;
  }
  
  public String Au()
  {
    return this.chM;
  }
  
  protected int Ko()
  {
    if (!TextUtils.isEmpty(this.chO)) {
      try
      {
        int i = Integer.parseInt(this.chO);
        return i;
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public int Kp()
  {
    return -16777216;
  }
  
  public int Kq()
  {
    return 26;
  }
  
  public int Kr()
  {
    return 0;
  }
  
  public void Rp(String paramString)
  {
    this.chP = paramString;
  }
  
  public void Rq(String paramString)
  {
    this.textColor = paramString;
  }
  
  public void Rr(String paramString)
  {
    this.chJ = paramString;
  }
  
  public void Rs(String paramString)
  {
    this.chO = paramString;
  }
  
  public void Rt(String paramString)
  {
    this.chN = paramString;
  }
  
  protected TextUtils.TruncateAt a()
  {
    return TextUtils.TruncateAt.END;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    if ((paramView != null) && (i().isInstance(paramView)))
    {
      paramView = (TextView)paramView;
      paramView.setTag(this);
      if (!this.cJG) {
        break label263;
      }
      paramView.setSingleLine(true);
    }
    for (;;)
    {
      if ((this.cJG) || (!this.cJF)) {
        paramView.setEllipsize(a());
      }
      paramContext = a(paramContext.getResources());
      if (paramContext == null) {
        break label291;
      }
      paramView.setTextColor(paramContext.color);
      paramView.requestLayout();
      paramView.setTypeface(Typeface.DEFAULT, paramContext.style);
      paramView.setTextSize(paramContext.size);
      paramView.setLineSpacing(wja.dp2px(Ko() * 1.0F / 2.0F, paramView.getResources()), 1.0F);
      if (paramContext.cJH == true) {
        paramView.getPaint().setFlags(8);
      }
      if (paramContext.cJI == true) {
        paramView.getPaint().setFlags(16);
      }
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("pre_dialog", false);
      }
      if ((bool) && (!TextUtils.isEmpty(this.chP))) {
        paramContext.text = this.chP;
      }
      if ((paramContext.chQ == null) || (paramContext.chQ.equals("")) || (!paramContext.chQ.trim().equals("1"))) {
        break label281;
      }
      paramView.setText(Html.fromHtml(paramContext.text));
      return paramView;
      paramView = d(paramContext);
      paramView.setId(getTextId());
      break;
      label263:
      if (!this.cJF) {
        paramView.setMaxLines(getMaxLines());
      }
    }
    label281:
    paramView.setText(paramContext.text);
    return paramView;
    label291:
    paramView.setText("");
    return paramView;
  }
  
  /* Error */
  public anqw.a a(android.content.res.Resources paramResources)
  {
    // Byte code:
    //   0: new 8	anqw$a
    //   3: dup
    //   4: invokespecial 243	anqw$a:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 245	anqw:chI	Ljava/lang/String;
    //   12: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +151 -> 166
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 245	anqw:chI	Ljava/lang/String;
    //   23: invokestatic 250	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   26: putfield 137	anqw$a:color	I
    //   29: aload_0
    //   30: getfield 50	anqw:textStyle	Ljava/lang/String;
    //   33: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +176 -> 212
    //   39: aload_0
    //   40: invokevirtual 252	anqw:Kr	()I
    //   43: istore_2
    //   44: aload_1
    //   45: iload_2
    //   46: putfield 153	anqw$a:style	I
    //   49: aload_0
    //   50: getfield 53	anqw:chM	Ljava/lang/String;
    //   53: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +167 -> 223
    //   59: iconst_0
    //   60: istore_2
    //   61: aload_1
    //   62: iload_2
    //   63: putfield 255	anqw$a:type	I
    //   66: aload_1
    //   67: iconst_0
    //   68: putfield 180	anqw$a:cJH	Z
    //   71: aload_1
    //   72: getfield 153	anqw$a:style	I
    //   75: iflt +11 -> 86
    //   78: aload_1
    //   79: getfield 153	anqw$a:style	I
    //   82: iconst_4
    //   83: if_icmplt +24 -> 107
    //   86: aload_1
    //   87: getfield 153	anqw$a:style	I
    //   90: iconst_4
    //   91: if_icmpne +152 -> 243
    //   94: aload_1
    //   95: iconst_1
    //   96: putfield 180	anqw$a:cJH	Z
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 252	anqw:Kr	()I
    //   104: putfield 153	anqw$a:style	I
    //   107: aload_0
    //   108: getfield 257	anqw:chK	Ljava/lang/String;
    //   111: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +145 -> 259
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 257	anqw:chK	Ljava/lang/String;
    //   122: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   125: putfield 160	anqw$a:size	I
    //   128: aload_1
    //   129: getfield 160	anqw$a:size	I
    //   132: iconst_1
    //   133: if_icmpge +11 -> 144
    //   136: aload_1
    //   137: aload_0
    //   138: invokevirtual 259	anqw:Kq	()I
    //   141: putfield 160	anqw$a:size	I
    //   144: aload_1
    //   145: aload_1
    //   146: getfield 160	anqw$a:size	I
    //   149: iconst_2
    //   150: idiv
    //   151: putfield 160	anqw$a:size	I
    //   154: aload_0
    //   155: invokevirtual 262	anqw:getText	()Ljava/lang/String;
    //   158: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +132 -> 293
    //   164: aconst_null
    //   165: areturn
    //   166: aload_0
    //   167: getfield 82	anqw:textColor	Ljava/lang/String;
    //   170: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifeq +28 -> 201
    //   176: aload_0
    //   177: invokevirtual 264	anqw:Kp	()I
    //   180: istore_2
    //   181: aload_1
    //   182: iload_2
    //   183: putfield 137	anqw$a:color	I
    //   186: goto -157 -> 29
    //   189: astore_3
    //   190: aload_1
    //   191: aload_0
    //   192: invokevirtual 264	anqw:Kp	()I
    //   195: putfield 137	anqw$a:color	I
    //   198: goto -169 -> 29
    //   201: aload_0
    //   202: getfield 82	anqw:textColor	Ljava/lang/String;
    //   205: invokestatic 250	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   208: istore_2
    //   209: goto -28 -> 181
    //   212: aload_0
    //   213: getfield 50	anqw:textStyle	Ljava/lang/String;
    //   216: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   219: istore_2
    //   220: goto -176 -> 44
    //   223: aload_0
    //   224: getfield 53	anqw:chM	Ljava/lang/String;
    //   227: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   230: istore_2
    //   231: goto -170 -> 61
    //   234: astore_3
    //   235: aload_1
    //   236: iconst_0
    //   237: putfield 255	anqw$a:type	I
    //   240: goto -174 -> 66
    //   243: aload_1
    //   244: getfield 153	anqw$a:style	I
    //   247: iconst_5
    //   248: if_icmpne -149 -> 99
    //   251: aload_1
    //   252: iconst_1
    //   253: putfield 192	anqw$a:cJI	Z
    //   256: goto -157 -> 99
    //   259: aload_0
    //   260: getfield 47	anqw:chJ	Ljava/lang/String;
    //   263: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifeq +16 -> 282
    //   269: aload_0
    //   270: invokevirtual 259	anqw:Kq	()I
    //   273: istore_2
    //   274: aload_1
    //   275: iload_2
    //   276: putfield 160	anqw$a:size	I
    //   279: goto -151 -> 128
    //   282: aload_0
    //   283: getfield 47	anqw:chJ	Ljava/lang/String;
    //   286: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   289: istore_2
    //   290: goto -16 -> 274
    //   293: aload_1
    //   294: aload_0
    //   295: invokevirtual 262	anqw:getText	()Ljava/lang/String;
    //   298: putfield 201	anqw$a:text	Ljava/lang/String;
    //   301: aload_1
    //   302: aload_0
    //   303: getfield 266	anqw:chL	Ljava/lang/String;
    //   306: putfield 204	anqw$a:chQ	Ljava/lang/String;
    //   309: aload_1
    //   310: areturn
    //   311: astore_3
    //   312: goto -263 -> 49
    //   315: astore_3
    //   316: goto -188 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	anqw
    //   0	319	1	paramResources	android.content.res.Resources
    //   43	247	2	i	int
    //   189	1	3	localException1	Exception
    //   234	1	3	localException2	Exception
    //   311	1	3	localException3	Exception
    //   315	1	3	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   8	29	189	java/lang/Exception
    //   166	181	189	java/lang/Exception
    //   181	186	189	java/lang/Exception
    //   201	209	189	java/lang/Exception
    //   49	59	234	java/lang/Exception
    //   61	66	234	java/lang/Exception
    //   223	231	234	java/lang/Exception
    //   29	44	311	java/lang/Exception
    //   44	49	311	java/lang/Exception
    //   212	220	311	java/lang/Exception
    //   107	128	315	java/lang/Exception
    //   259	274	315	java/lang/Exception
    //   274	279	315	java/lang/Exception
    //   282	290	315	java/lang/Exception
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, this.mTypeName);
    if (this.text != null)
    {
      if (!TextUtils.isEmpty(this.chJ)) {
        paramXmlSerializer.attribute(null, "size", this.chJ);
      }
      if (!TextUtils.isEmpty(this.textColor)) {
        paramXmlSerializer.attribute(null, "color", this.textColor);
      }
      if (!TextUtils.isEmpty(this.textStyle)) {
        paramXmlSerializer.attribute(null, "style", this.textStyle);
      }
      if (!TextUtils.isEmpty(this.chL)) {
        paramXmlSerializer.attribute(null, "html", this.chL);
      }
      if (!TextUtils.isEmpty(this.chM)) {
        paramXmlSerializer.attribute(null, "type", this.chM);
      }
      if (!TextUtils.isEmpty(this.chN)) {
        paramXmlSerializer.attribute(null, "maxLines", this.chN);
      }
      if (!TextUtils.isEmpty(this.chO)) {
        paramXmlSerializer.attribute(null, "lineSpace", this.chO);
      }
      paramXmlSerializer.text(this.text);
    }
    paramXmlSerializer.endTag(null, this.mTypeName);
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return true;
    }
    this.textColor = paramansf.getAttribute("color");
    this.textStyle = paramansf.getAttribute("style");
    this.chJ = paramansf.getAttribute("size");
    this.text = anbk.w(anre.a(paramansf), false);
    this.chL = paramansf.getAttribute("html");
    this.chM = paramansf.getAttribute("type");
    this.chN = paramansf.getAttribute("maxLines");
    this.chO = paramansf.getAttribute("lineSpace");
    return true;
  }
  
  public TextView d(Context paramContext)
  {
    if (StructMsgItemTitle.TitleTextView.class.isAssignableFrom(i())) {
      return new StructMsgItemTitle.TitleTextView(paramContext);
    }
    return new EllipsizingTextView(paramContext, null);
  }
  
  public void dTu()
  {
    this.cJF = true;
  }
  
  public void fK(String paramString)
  {
    this.chK = paramString;
  }
  
  public int getMaxLines()
  {
    if (!TextUtils.isEmpty(this.chN)) {
      try
      {
        int i = Integer.parseInt(this.chN);
        return i;
      }
      catch (Exception localException) {}
    }
    return 2;
  }
  
  public String getText()
  {
    if (this.text == null) {}
    for (String str = "";; str = this.text)
    {
      this.text = str;
      return this.text;
    }
  }
  
  public String getTextColor()
  {
    return this.textColor;
  }
  
  protected abstract int getTextId();
  
  protected Class<? extends TextView> i()
  {
    return TextView.class;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    if (this.mVersion == 1) {
      this.text = anbk.w(paramObjectInput.readUTF(), false);
    }
    do
    {
      do
      {
        return;
        if (this.mVersion == 2)
        {
          this.textColor = anbk.w(paramObjectInput.readUTF(), false);
          this.textStyle = anbk.w(paramObjectInput.readUTF(), false);
          this.chJ = anbk.w(paramObjectInput.readUTF(), false);
          this.text = anbk.w(paramObjectInput.readUTF(), false);
          return;
        }
        if (this.mVersion == 3)
        {
          this.textColor = anbk.w(paramObjectInput.readUTF(), false);
          this.textStyle = anbk.w(paramObjectInput.readUTF(), false);
          this.chJ = anbk.w(paramObjectInput.readUTF(), false);
          this.text = anbk.w(paramObjectInput.readUTF(), false);
          this.chL = anbk.w(paramObjectInput.readUTF(), false);
          return;
        }
      } while (this.mVersion < 4);
      this.textColor = anbk.w(paramObjectInput.readUTF(), false);
      this.textStyle = anbk.w(paramObjectInput.readUTF(), false);
      this.chJ = anbk.w(paramObjectInput.readUTF(), false);
      this.text = anbk.w(paramObjectInput.readUTF(), false);
      this.chL = anbk.w(paramObjectInput.readUTF(), false);
      this.chM = anbk.w(paramObjectInput.readUTF(), false);
    } while (this.mVersion < 11);
    this.chN = anbk.w(paramObjectInput.readUTF(), false);
    this.chO = anbk.w(paramObjectInput.readUTF(), false);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.cJG = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.text = paramString;
      return;
    }
    this.text = aqmr.ToDBC(paramString);
  }
  
  public void setTextColor(String paramString)
  {
    this.chI = paramString;
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.mVersion == 1) {
      if (this.text == null)
      {
        str = "";
        paramObjectOutput.writeUTF(str);
      }
    }
    label78:
    label95:
    label225:
    label363:
    label380:
    do
    {
      do
      {
        return;
        str = anbk.w(this.text, false);
        break;
        if (this.mVersion == 2)
        {
          if (this.textColor == null)
          {
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.textStyle != null) {
              break label128;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.chJ != null) {
              break label136;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.text != null) {
              break label144;
            }
          }
          for (str = "";; str = anbk.w(this.text, false))
          {
            paramObjectOutput.writeUTF(str);
            return;
            str = this.textColor;
            break;
            str = this.textStyle;
            break label78;
            str = this.chJ;
            break label95;
          }
        }
        if (this.mVersion == 3)
        {
          if (this.textColor == null)
          {
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.textStyle != null) {
              break label258;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.chJ != null) {
              break label266;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.text != null) {
              break label274;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.chL != null) {
              break label286;
            }
          }
          for (str = "";; str = this.chL)
          {
            paramObjectOutput.writeUTF(str);
            return;
            str = this.textColor;
            break;
            str = this.textStyle;
            break label191;
            str = this.chJ;
            break label208;
            str = anbk.w(this.text, false);
            break label225;
          }
        }
      } while (this.mVersion < 4);
      if (this.textColor != null) {
        break label448;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.textStyle != null) {
        break label456;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.chJ != null) {
        break label464;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.text != null) {
        break label472;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.chL != null) {
        break label484;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.chM != null) {
        break label492;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
    } while (this.mVersion < 11);
    label128:
    label136:
    label144:
    label191:
    label208:
    label346:
    if (this.chN == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.chO != null) {
        break label508;
      }
    }
    label258:
    label266:
    label274:
    label286:
    label329:
    label464:
    label472:
    label484:
    label492:
    label508:
    for (String str = "";; str = this.chO)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.textColor;
      break;
      str = this.textStyle;
      break label329;
      str = this.chJ;
      break label346;
      str = anbk.w(this.text, false);
      break label363;
      str = this.chL;
      break label380;
      str = this.chM;
      break label397;
      str = this.chN;
      break label423;
    }
  }
  
  public static class a
  {
    public int beginIndex;
    public boolean cJH;
    public boolean cJI;
    public String chQ;
    public int color;
    public int endIndex;
    public int size;
    public int style;
    public String text;
    public int type;
    
    protected a a()
    {
      a locala = new a();
      locala.color = this.color;
      locala.style = this.style;
      locala.text = this.text;
      locala.type = this.type;
      locala.beginIndex = this.beginIndex;
      locala.endIndex = this.endIndex;
      locala.cJH = this.cJH;
      locala.cJI = this.cJI;
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqw
 * JD-Core Version:    0.7.0.1
 */