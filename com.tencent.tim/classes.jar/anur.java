import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlSerializer;

public class anur
  extends anqu
{
  private String cia;
  public String imgUrl;
  public View.OnClickListener mOnClickListener = new anus(this);
  private URLDrawableDownListener.Adapter mUrlAdapter = new anut(this);
  private String videoUrl;
  
  public anur()
  {
    this.mTypeName = "pavideo";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramContext.getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    if ((paramView != null) && ((paramView instanceof AnyScaleTypeImageView))) {
      paramView = (PAHighLightImageView)paramView;
    }
    for (;;)
    {
      paramView.setTag(this);
      try
      {
        paramBundle = paramBundle.getDrawable(2130842577);
        if (TextUtils.isEmpty(this.imgUrl))
        {
          paramView.setBackgroundDrawable(paramBundle);
          if (this.hU != null)
          {
            paramView.setOnLongClickListener((View.OnLongClickListener)this.hU.get());
            paramView.setOnTouchListener((View.OnTouchListener)this.hU.get());
          }
          paramView.setOnClickListener(this.mOnClickListener);
          return paramView;
          paramView = new PAHighLightImageView(paramContext);
          paramView.setId(2131369004);
          paramView.setContentDescription(paramBundle.getString(2131696498));
          paramView.setDisplayRuleDef(arfd.b);
          paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          paramView.setContentDescription(paramBundle.getText(2131720493));
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          paramBundle = null;
        }
        paramBundle = URLDrawable.getDrawable(this.imgUrl, i, i, paramBundle, paramBundle);
        if (aoiz.hasFile(this.imgUrl)) {
          break label191;
        }
      }
    }
    label191:
    boolean bool;
    if (!aoop.bD(paramContext))
    {
      bool = true;
      label194:
      paramBundle.setAutoDownload(bool);
      if ((paramBundle == null) || (paramBundle.getStatus() != 1)) {
        break label231;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      paramView.setBackgroundDrawable(paramBundle);
      break;
      bool = false;
      break label194;
      label231:
      paramView.setURLDrawableDownListener(this.mUrlAdapter);
      paramView.setBackgroundColor(15790320);
    }
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131378856) {
        return (StructMsgForGeneralShare)paramView.getTag(2131378856);
      }
    }
    return null;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "pavideo");
    paramXmlSerializer.attribute(null, "cover", this.imgUrl);
    paramXmlSerializer.attribute(null, "src", this.videoUrl);
    if (this.mVersion > 5)
    {
      paramXmlSerializer.attribute(null, "video_info", this.cia);
      if (!TextUtils.isEmpty(this.index)) {
        paramXmlSerializer.attribute(null, "index", this.index);
      }
      if (!TextUtils.isEmpty(this.index_name)) {
        paramXmlSerializer.attribute(null, "index_name", this.index_name);
      }
      if (!TextUtils.isEmpty(this.index_type)) {
        paramXmlSerializer.attribute(null, "index_type", this.index_type);
      }
    }
    paramXmlSerializer.endTag(null, "pavideo");
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {}
    do
    {
      return true;
      this.imgUrl = paramansf.getAttribute("cover");
      this.videoUrl = paramansf.getAttribute("src");
    } while (this.mVersion <= 5);
    this.cia = paramansf.getAttribute("video_info");
    this.index = paramansf.getAttribute("index");
    this.index_name = paramansf.getAttribute("index_name");
    this.index_type = paramansf.getAttribute("index_type");
    return true;
  }
  
  public String getLayoutStr()
  {
    return "pavideo";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.imgUrl = paramObjectInput.readUTF();
    this.videoUrl = paramObjectInput.readUTF();
    if (this.mVersion > 5)
    {
      this.cia = paramObjectInput.readUTF();
      this.index = paramObjectInput.readUTF();
      this.index_name = paramObjectInput.readUTF();
      this.index_type = paramObjectInput.readUTF();
    }
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
        break label135;
      }
      str = this.videoUrl;
      label36:
      paramObjectOutput.writeUTF(str);
      if (this.mVersion > 5)
      {
        if (this.cia == null) {
          break label142;
        }
        str = this.cia;
        label63:
        paramObjectOutput.writeUTF(str);
        if (this.index == null) {
          break label149;
        }
        str = this.index;
        label82:
        paramObjectOutput.writeUTF(str);
        if (this.index_name == null) {
          break label156;
        }
        str = this.index_name;
        label101:
        paramObjectOutput.writeUTF(str);
        if (this.index_type == null) {
          break label163;
        }
      }
    }
    label135:
    label142:
    label149:
    label156:
    label163:
    for (String str = this.index_type;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label63;
      str = "";
      break label82;
      str = "";
      break label101;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anur
 * JD-Core Version:    0.7.0.1
 */