import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.now.NowVideoLayout;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anry
  extends anqu
{
  public String cia;
  public int dMn;
  public int dMo;
  public String imgUrl;
  public View.OnClickListener mOnClickListener = new ansa(this);
  public String recordId;
  public String roomId;
  public int sourceType = 1;
  public String title;
  public String videoUrl;
  
  public anry()
  {
    this.mTypeName = "live";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    LinearLayout localLinearLayout = null;
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof anry.a))) {}
    }
    for (paramView = (anry.a)paramView;; paramView = null)
    {
      paramBundle = paramView;
      if (paramView == null)
      {
        paramBundle = new anry.a();
        localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setOrientation(1);
        localLinearLayout.setGravity(17);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.gravity = 1;
        paramView.setMargins(0, wja.dp2px(10.0F, localResources), 0, wja.dp2px(20.0F, localResources));
        localLinearLayout.setLayoutParams(paramView);
        paramView = new NowVideoLayout(paramContext);
        Object localObject = new LinearLayout.LayoutParams(-2, -2);
        paramView.setId(2131378854);
        paramBundle.a = paramView;
        localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
        paramView = new LinearLayout(paramContext);
        paramView.setOrientation(1);
        localObject = new LinearLayout.LayoutParams(wja.dp2px(156.0F, localResources), -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        paramView.setPadding(wja.dp2px(7.0F, localResources), wja.dp2px(8.0F, localResources), wja.dp2px(7.0F, localResources), wja.dp2px(8.0F, localResources));
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setBackgroundResource(2130844493);
        localLinearLayout.addView(paramView);
        localObject = new TextView(paramContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        ((TextView)localObject).setBackgroundColor(localResources.getColor(2131167595));
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setTextColor(-16777216);
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject).setTextSize(0, wja.dp2px(12.0F, localResources));
        ((TextView)localObject).setSingleLine();
        localLayoutParams.setMargins(0, 0, 0, 0);
        paramBundle.tipsView = ((TextView)localObject);
        ((TextView)localObject).setId(2131380973);
        paramView.addView((View)localObject, localLayoutParams);
        paramContext = new TextView(paramContext);
        localObject = new LinearLayout.LayoutParams(-1, -2);
        paramContext.setBackgroundColor(localResources.getColor(2131167595));
        paramContext.setPadding(0, wja.dp2px(3.0F, localResources), 0, 0);
        paramContext.setTextColor(-16777216);
        paramContext.setEllipsize(TextUtils.TruncateAt.END);
        paramContext.setTextSize(0, wja.dp2px(12.0F, localResources));
        paramContext.setSingleLine();
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        paramBundle.titleView = paramContext;
        paramContext.setId(2131380976);
        paramView.addView(paramContext, (ViewGroup.LayoutParams)localObject);
      }
      localLinearLayout.setTag(paramBundle);
      paramBundle.a.setOnClickListener(this.mOnClickListener);
      paramBundle.a.setOnLongClickListener(new anrz(this));
      return localLinearLayout;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "live");
    paramXmlSerializer.attribute(null, "cover", this.imgUrl);
    paramXmlSerializer.attribute(null, "src", this.videoUrl);
    paramXmlSerializer.attribute(null, "video_info", this.cia);
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.dMn));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.dMo));
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.sourceType));
    paramXmlSerializer.attribute(null, "recordID", String.valueOf(this.recordId));
    paramXmlSerializer.attribute(null, "roomID", String.valueOf(this.roomId));
    paramXmlSerializer.attribute(null, "title", String.valueOf(this.title));
    paramXmlSerializer.endTag(null, "live");
  }
  
  /* Error */
  public boolean a(ansf paramansf)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_1
    //   5: ireturn
    //   6: aload_0
    //   7: aload_1
    //   8: ldc 189
    //   10: invokevirtual 246	ansf:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   13: putfield 191	anry:imgUrl	Ljava/lang/String;
    //   16: aload_0
    //   17: aload_1
    //   18: ldc 197
    //   20: invokevirtual 246	ansf:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   23: putfield 199	anry:videoUrl	Ljava/lang/String;
    //   26: aload_0
    //   27: aload_1
    //   28: ldc 201
    //   30: invokevirtual 246	ansf:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   33: putfield 203	anry:cia	Ljava/lang/String;
    //   36: aload_0
    //   37: aload_1
    //   38: ldc 221
    //   40: invokevirtual 246	ansf:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   43: putfield 223	anry:recordId	Ljava/lang/String;
    //   46: aload_0
    //   47: aload_1
    //   48: ldc 228
    //   50: invokevirtual 246	ansf:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   53: putfield 230	anry:roomId	Ljava/lang/String;
    //   56: aload_0
    //   57: aload_1
    //   58: ldc 231
    //   60: invokevirtual 246	ansf:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   63: putfield 233	anry:title	Ljava/lang/String;
    //   66: aload_1
    //   67: ldc 205
    //   69: invokevirtual 246	ansf:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_3
    //   73: aload_3
    //   74: ifnonnull +67 -> 141
    //   77: iconst_0
    //   78: istore_2
    //   79: aload_0
    //   80: iload_2
    //   81: putfield 207	anry:dMn	I
    //   84: aload_1
    //   85: ldc 215
    //   87: invokevirtual 246	ansf:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnonnull +80 -> 172
    //   95: iconst_0
    //   96: istore_2
    //   97: aload_0
    //   98: iload_2
    //   99: putfield 217	anry:dMo	I
    //   102: aload_1
    //   103: ldc 219
    //   105: invokevirtual 246	ansf:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_1
    //   109: aload_1
    //   110: ifnonnull +93 -> 203
    //   113: iconst_0
    //   114: istore_2
    //   115: aload_0
    //   116: iload_2
    //   117: putfield 26	anry:sourceType	I
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_1
    //   123: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq -122 -> 4
    //   129: ldc 254
    //   131: iconst_2
    //   132: ldc_w 256
    //   135: aload_1
    //   136: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: iconst_1
    //   140: ireturn
    //   141: aload_3
    //   142: invokestatic 265	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   145: invokevirtual 269	java/lang/Integer:intValue	()I
    //   148: istore_2
    //   149: goto -70 -> 79
    //   152: astore_3
    //   153: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -72 -> 84
    //   159: ldc 254
    //   161: iconst_2
    //   162: ldc_w 271
    //   165: aload_3
    //   166: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   169: goto -85 -> 84
    //   172: aload_3
    //   173: invokestatic 265	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   176: invokevirtual 269	java/lang/Integer:intValue	()I
    //   179: istore_2
    //   180: goto -83 -> 97
    //   183: astore_3
    //   184: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq -85 -> 102
    //   190: ldc 254
    //   192: iconst_2
    //   193: ldc_w 273
    //   196: aload_3
    //   197: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: goto -98 -> 102
    //   203: aload_1
    //   204: invokestatic 265	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   207: invokevirtual 269	java/lang/Integer:intValue	()I
    //   210: istore_2
    //   211: goto -96 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	anry
    //   0	214	1	paramansf	ansf
    //   78	133	2	i	int
    //   72	70	3	str	String
    //   152	21	3	localNumberFormatException1	java.lang.NumberFormatException
    //   183	14	3	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   102	109	122	java/lang/NumberFormatException
    //   115	120	122	java/lang/NumberFormatException
    //   203	211	122	java/lang/NumberFormatException
    //   66	73	152	java/lang/NumberFormatException
    //   79	84	152	java/lang/NumberFormatException
    //   141	149	152	java/lang/NumberFormatException
    //   84	91	183	java/lang/NumberFormatException
    //   97	102	183	java/lang/NumberFormatException
    //   172	180	183	java/lang/NumberFormatException
  }
  
  public String getLayoutStr()
  {
    return "live";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.imgUrl = paramObjectInput.readUTF();
    this.videoUrl = paramObjectInput.readUTF();
    this.cia = paramObjectInput.readUTF();
    this.dMn = paramObjectInput.readInt();
    this.dMo = paramObjectInput.readInt();
    this.sourceType = paramObjectInput.readInt();
    this.recordId = paramObjectInput.readUTF();
    this.roomId = paramObjectInput.readUTF();
    this.title = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.imgUrl != null)
    {
      str = this.imgUrl;
      paramObjectOutput.writeUTF(str);
      if (this.videoUrl == null) {
        break label157;
      }
      str = this.videoUrl;
      label36:
      paramObjectOutput.writeUTF(str);
      if (this.cia == null) {
        break label164;
      }
      str = this.cia;
      label55:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.dMn);
      paramObjectOutput.writeInt(this.dMo);
      paramObjectOutput.writeInt(this.sourceType);
      if (this.recordId == null) {
        break label171;
      }
      str = this.recordId;
      label104:
      paramObjectOutput.writeUTF(str);
      if (this.roomId == null) {
        break label178;
      }
      str = this.roomId;
      label123:
      paramObjectOutput.writeUTF(str);
      if (this.title == null) {
        break label185;
      }
    }
    label157:
    label164:
    label171:
    label178:
    label185:
    for (String str = this.title;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label55;
      str = "";
      break label104;
      str = "";
      break label123;
    }
  }
  
  public static class a
  {
    NowVideoLayout a;
    TextView tipsView;
    TextView titleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anry
 * JD-Core Version:    0.7.0.1
 */