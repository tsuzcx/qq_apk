import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class ansb
  extends anqu
{
  String bgColor;
  protected String chJ;
  String icon;
  public int maxLines = 1;
  int radius = 10;
  public String text;
  protected String textColor;
  protected String textStyle;
  
  public ansb()
  {
    this(null);
  }
  
  public ansb(String paramString)
  {
    this(paramString, "tag");
  }
  
  public ansb(String paramString1, String paramString2)
  {
    this.mTypeName = paramString2;
    this.text = paramString1;
  }
  
  public int Kp()
  {
    return -1;
  }
  
  public int Kq()
  {
    return 10;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramBundle = (URLImageView)paramView.findViewById(2131369034);
      paramContext = (TextView)paramView.findViewById(2131380958);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.bgColor)) {}
      try
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setColor(Color.parseColor(this.bgColor));
        if (this.radius > 0) {
          ((GradientDrawable)localObject).setCornerRadius(this.radius);
        }
        ((GradientDrawable)localObject).setGradientType(0);
        paramView.setBackgroundDrawable((Drawable)localObject);
        if (!TextUtils.isEmpty(this.icon))
        {
          localObject = new ColorDrawable(2131167595);
          localObject = URLDrawable.getDrawable(this.icon, (Drawable)localObject, (Drawable)localObject);
          if (((URLDrawable)localObject).getStatus() != 1) {
            ((URLDrawable)localObject).restartDownload();
          }
          paramBundle.setImageDrawable((Drawable)localObject);
          paramBundle.setVisibility(0);
          if (TextUtils.isEmpty(this.text)) {
            break label465;
          }
          paramContext.setText(this.text);
        }
      }
      catch (IllegalArgumentException paramBundle)
      {
        try
        {
          paramContext.setTextColor(Color.parseColor(this.textColor));
        }
        catch (Exception paramBundle)
        {
          try
          {
            for (;;)
            {
              paramContext.setTextSize(Integer.parseInt(this.chJ));
              paramContext.setVisibility(0);
              return paramView;
              paramView = new LinearLayout(paramContext);
              paramView.setOrientation(0);
              paramView.setMinimumHeight(wja.dp2px(14.0F, (Resources)localObject));
              paramView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
              paramView.setGravity(16);
              paramView.setPadding(wja.dp2px(5.0F, (Resources)localObject), wja.dp2px(2.0F, (Resources)localObject), wja.dp2px(5.0F, (Resources)localObject), wja.dp2px(2.0F, (Resources)localObject));
              paramBundle = new URLImageView(paramContext);
              paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(wja.dp2px(9.0F, (Resources)localObject), wja.dp2px(9.0F, (Resources)localObject));
              paramBundle.setId(2131369034);
              paramView.addView(paramBundle, localLayoutParams);
              paramContext = new TextView(paramContext);
              localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
              localLayoutParams.setMargins(wja.dp2px(2.0F, (Resources)localObject), 0, 0, 0);
              paramContext.setSingleLine(true);
              paramContext.setMaxLines(1);
              paramContext.setEllipsize(TextUtils.TruncateAt.END);
              paramContext.setGravity(16);
              paramContext.setId(2131380958);
              paramView.addView(paramContext, localLayoutParams);
              break;
              localIllegalArgumentException = localIllegalArgumentException;
              if (QLog.isColorLevel())
              {
                QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml bgColor is not a color value.", localIllegalArgumentException);
                continue;
                paramBundle.setVisibility(8);
                continue;
                paramBundle = paramBundle;
                paramContext.setTextColor(Kp());
              }
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramContext.setTextSize(Kq());
            }
          }
        }
        label465:
        paramContext.setVisibility(8);
      }
    }
    return paramView;
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
      paramXmlSerializer.text(this.text);
      if (!TextUtils.isEmpty(this.bgColor)) {
        paramXmlSerializer.attribute(null, "bgColor", this.bgColor);
      }
      if (!TextUtils.isEmpty(this.icon)) {
        paramXmlSerializer.attribute(null, "icon", this.icon);
      }
      if (this.radius > 0) {
        paramXmlSerializer.attribute(null, "radius", this.radius + "");
      }
    }
    paramXmlSerializer.endTag(null, this.mTypeName);
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {}
    do
    {
      return true;
      this.textColor = paramansf.getAttribute("color");
      this.textStyle = paramansf.getAttribute("style");
      this.chJ = paramansf.getAttribute("size");
      this.text = anbk.w(anre.a(paramansf), false);
      this.bgColor = paramansf.getAttribute("bgColor");
      this.icon = paramansf.getAttribute("icon");
      paramansf = paramansf.getAttribute("radius");
      try
      {
        this.radius = Integer.valueOf(paramansf).intValue();
        return true;
      }
      catch (NumberFormatException paramansf) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml radius is not a integer value.", paramansf);
    return true;
  }
  
  public String getLayoutStr()
  {
    return "tag";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.textColor = anbk.w(paramObjectInput.readUTF(), false);
    this.chJ = anbk.w(paramObjectInput.readUTF(), false);
    this.text = anbk.w(paramObjectInput.readUTF(), false);
    this.bgColor = anbk.w(paramObjectInput.readUTF(), false);
    this.icon = anbk.w(paramObjectInput.readUTF(), false);
    this.radius = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    String str;
    if (this.textColor == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.chJ != null) {
        break label121;
      }
      str = "";
      label34:
      paramObjectOutput.writeUTF(str);
      if (this.text != null) {
        break label129;
      }
      str = "";
      label52:
      paramObjectOutput.writeUTF(str);
      if (this.bgColor != null) {
        break label141;
      }
      str = "";
      label70:
      paramObjectOutput.writeUTF(str);
      if (this.icon != null) {
        break label149;
      }
      str = "";
      label88:
      paramObjectOutput.writeUTF(str);
      if (this.radius > 0) {
        break label157;
      }
    }
    label129:
    label141:
    label149:
    label157:
    for (int i = 10;; i = this.radius)
    {
      paramObjectOutput.writeInt(i);
      return;
      str = this.textColor;
      break;
      label121:
      str = this.chJ;
      break label34;
      str = anbk.w(this.text, false);
      break label52;
      str = this.bgColor;
      break label70;
      str = this.icon;
      break label88;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansb
 * JD-Core Version:    0.7.0.1
 */