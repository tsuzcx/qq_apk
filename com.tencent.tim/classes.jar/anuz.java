import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anuz
  extends anqu
  implements View.OnClickListener
{
  public String ciq;
  public String cir;
  public int dME;
  public int dMF;
  public String mText;
  
  public anuz()
  {
    this.mTypeName = "textButton";
    Vu(32);
    Vv(32);
  }
  
  private LinearLayout b(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(0);
    paramContext.setGravity(16);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    paramContext.setId(2131380967);
    return paramContext;
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
  
  public void Vu(int paramInt)
  {
    this.dME = paramInt;
  }
  
  public void Vv(int paramInt)
  {
    this.dMF = paramInt;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramView != null) {
      paramContext = (anuz.a)paramView.getTag();
    }
    for (;;)
    {
      paramContext.mTextView.setTag(this);
      paramContext.mTextView.setTextColor(Kp());
      paramContext.mTextView.requestLayout();
      paramContext.mTextView.setTypeface(Typeface.DEFAULT, Kr());
      paramContext.mTextView.setTextSize(Kq() / 2);
      if (!TextUtils.isEmpty(this.mText)) {
        paramContext.mTextView.setText(this.mText);
      }
      try
      {
        if (!TextUtils.isEmpty(this.ciq))
        {
          paramBundle = URLDrawable.getDrawable(this.ciq, this.dME, this.dME, null, null);
          paramBundle.setAutoDownload(true);
          paramContext.DP.setImageDrawable(paramBundle);
        }
        if (!TextUtils.isEmpty(this.cir))
        {
          paramBundle = URLDrawable.getDrawable(this.cir, this.dMF, this.dMF, null, null);
          paramBundle.setAutoDownload(true);
          paramContext.DP.setImageDrawable(paramBundle);
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, " URLDrawable.exception illegal url : " + paramContext.getMessage());
          }
        }
      }
      if ((this.cgX != null) && (!this.cgX.equals("")))
      {
        paramView.setClickable(true);
        paramView.setOnClickListener(this);
      }
      return paramView;
      paramView = new anuz.a();
      paramView.mRootView = b(paramContext);
      paramView.DP = new ImageView(paramContext);
      paramView.DQ = new ImageView(paramContext);
      paramView.mTextView = new TextView(paramContext);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.gravity = 16;
      paramView.mRootView.addView(paramView.DP, paramContext);
      paramView.mRootView.addView(paramView.mTextView, paramContext);
      paramView.mRootView.addView(paramView.DQ, paramContext);
      paramView.mRootView.setTag(paramView);
      paramBundle = paramView.mRootView;
      paramContext = paramView;
      paramView = paramBundle;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, this.mTypeName);
    if (!TextUtils.isEmpty(this.mText)) {
      paramXmlSerializer.attribute(null, "text", this.mText);
    }
    if (!TextUtils.isEmpty(this.ciq)) {
      paramXmlSerializer.attribute(null, "leftImage", this.ciq);
    }
    if (!TextUtils.isEmpty(this.cir)) {
      paramXmlSerializer.attribute(null, "rightImage", this.cir);
    }
    if (!TextUtils.isEmpty(this.ku)) {
      paramXmlSerializer.attribute(null, "url", this.ku);
    }
    paramXmlSerializer.endTag(null, this.mTypeName);
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return true;
    }
    this.ku = paramansf.getAttribute("url");
    this.ciq = paramansf.getAttribute("leftImage");
    this.cir = paramansf.getAttribute("rightImage");
    this.mText = anbk.w(paramansf.getAttribute("text"), false);
    return true;
  }
  
  public String getLayoutStr()
  {
    return "TextButton";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.mText = anbk.w(paramObjectInput.readUTF(), false);
    this.ciq = anbk.w(paramObjectInput.readUTF(), false);
    this.cir = anbk.w(paramObjectInput.readUTF(), false);
    this.ku = anbk.w(paramObjectInput.readUTF(), false);
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.mText == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ciq != null) {
        break label86;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.cir != null) {
        break label94;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.ku != null) {
        break label102;
      }
    }
    label86:
    label94:
    label102:
    for (String str = "";; str = this.ku)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = anbk.w(this.mText, false);
      break;
      str = this.ciq;
      break label32;
      str = this.cir;
      break label49;
    }
  }
  
  class a
  {
    ImageView DP = null;
    ImageView DQ = null;
    LinearLayout mRootView = null;
    TextView mTextView = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuz
 * JD-Core Version:    0.7.0.1
 */