import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class ansk
  extends anqu
{
  public String aGC;
  public int dMp;
  public String mUin;
  
  public ansk()
  {
    this.mTypeName = "head";
  }
  
  public ansk(int paramInt, String paramString1, String paramString2)
  {
    this();
    this.dMp = paramInt;
    this.mUin = paramString1;
    this.aGC = paramString2;
  }
  
  public View a(Context paramContext, View paramView, int paramInt, Bundle paramBundle)
  {
    Object localObject2 = paramContext.getResources();
    LinearLayout localLinearLayout;
    Object localObject1;
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localObject1 = (ImageView)localLinearLayout.findViewById(2131380570);
      paramBundle = (ImageView)localLinearLayout.findViewById(2131380573);
      paramView = (TextView)localLinearLayout.findViewById(2131380571);
      localObject3 = aqhu.aU();
      localObject2 = localObject3;
      if ((paramContext instanceof BaseActivity)) {
        localObject2 = aqdj.a(((BaseActivity)paramContext).app, 1, this.mUin, 3, (Drawable)localObject3, (Drawable)localObject3);
      }
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (paramBundle != null)
      {
        if (paramInt != 2) {
          break label594;
        }
        paramBundle.setImageResource(2130851457);
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.setText(this.aGC);
        paramView.setTextSize(2, 20.0F);
        paramView.setTextColor(-1);
        paramView.setSingleLine();
        paramView.setEllipsize(TextUtils.TruncateAt.END);
      }
      return localLinearLayout;
      localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setId(2131380572);
      localLinearLayout.setOrientation(1);
      if (this.dMp == 4)
      {
        i = 53;
        label193:
        if (this.dMp != 4) {
          break label406;
        }
      }
      label406:
      for (int j = 53;; j = 135)
      {
        i = paramBundle.getInt("bundle_args_cover_width", wja.dp2px(i, (Resources)localObject2));
        j = paramBundle.getInt("bundle_args_cover_height", wja.dp2px(j, (Resources)localObject2));
        paramView = new FrameLayout(paramContext);
        localObject1 = new LinearLayout.LayoutParams(i, j);
        ((LinearLayout.LayoutParams)localObject1).gravity = 1;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localLinearLayout.addView(paramView);
        if (paramInt != 4) {
          break label414;
        }
        i = paramBundle.getInt("bundle_args_avatar_width", wja.dp2px(50.0F, (Resources)localObject2));
        j = paramBundle.getInt("bundle_args_avatar_height", wja.dp2px(50.0F, (Resources)localObject2));
        localObject1 = new ImageView(paramContext);
        ((ImageView)localObject1).setId(2131380570);
        paramBundle = new FrameLayout.LayoutParams(i, j);
        paramBundle.gravity = 17;
        paramView.addView((View)localObject1, paramBundle);
        paramBundle = new ImageView(paramContext);
        paramBundle.setId(2131380573);
        paramView.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
        paramView = null;
        break;
        i = 180;
        break label193;
      }
      label414:
      int i = paramBundle.getInt("bundle_args_avatar_width", wja.dp2px(80.0F, (Resources)localObject2));
      j = paramBundle.getInt("bundle_args_avatar_height", wja.dp2px(80.0F, (Resources)localObject2));
      localObject1 = new ImageView(paramContext);
      ((ImageView)localObject1).setId(2131380570);
      paramBundle = new FrameLayout.LayoutParams(i, j);
      paramBundle.gravity = 17;
      paramView.addView((View)localObject1, paramBundle);
      paramBundle = new ImageView(paramContext);
      paramBundle.setId(2131380573);
      paramView.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
      paramView = new TextView(paramContext);
      paramView.setId(2131380571);
      localObject3 = new LinearLayout.LayoutParams(wja.dp2px(180.0F, (Resources)localObject2), -2);
      ((LinearLayout.LayoutParams)localObject3).gravity = 1;
      ((LinearLayout.LayoutParams)localObject3).topMargin = wja.dp2px(5.0F, (Resources)localObject2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramView.setGravity(1);
      localLinearLayout.addView(paramView);
      break;
      label594:
      if (paramInt == 1) {
        paramBundle.setImageResource(2130851459);
      } else if (paramInt == 3) {
        paramBundle.setImageResource(2130851458);
      } else if (paramInt == 4) {
        paramBundle.setImageResource(2130851456);
      }
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, this.dMp, paramBundle);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "head");
    if (this.mUin == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uin", str);
      if (this.aGC != null) {
        break label71;
      }
    }
    label71:
    for (String str = "";; str = this.aGC)
    {
      paramXmlSerializer.attribute(null, "nick", str);
      paramXmlSerializer.endTag(null, "head");
      return;
      str = this.mUin;
      break;
    }
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return false;
    }
    String str2 = paramansf.getAttribute("uin");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.mUin = str1;
    str1 = paramansf.getAttribute("nick");
    paramansf = str1;
    if (str1 == null) {
      paramansf = "";
    }
    this.aGC = paramansf;
    return true;
  }
  
  public String getLayoutStr()
  {
    return "Avatar";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.mUin = paramObjectInput.readUTF();
    this.aGC = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.mUin == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.aGC != null) {
        break label48;
      }
    }
    label48:
    for (String str = "";; str = this.aGC)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.mUin;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansk
 * JD-Core Version:    0.7.0.1
 */