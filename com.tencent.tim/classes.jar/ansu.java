import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

public class ansu
  extends anqu
{
  public long anV;
  public String cij;
  public StructMsgForImageShare d;
  public long filesize;
  public MessageForPic j;
  public URL m;
  public int mMaxHeight;
  public int mMaxWidth;
  public String mMd5;
  public int mMinHeight;
  public int mMinWidth;
  public String mUuid;
  public long time;
  
  public ansu()
  {
    this.mVersion = 14;
    this.mTypeName = "image";
  }
  
  public ansu(String paramString)
  {
    this();
    this.cij = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (this.j != null)
    {
      paramBundle = aoop.a(this.j, 65537);
      if ((this.m != null) && (this.m.equals(paramBundle))) {}
    }
    for (paramBundle = xkl.b(paramContext, this.j);; paramBundle = null)
    {
      Object localObject = paramBundle;
      if (paramBundle == null)
      {
        if (this.d == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "StructMsgItemImage.createView.mImageShareMsg == null nudnik trick");
          }
          return new View(paramContext);
        }
        localObject = new MessageForPic();
        ((MessageForPic)localObject).path = this.cij;
        ((MessageForPic)localObject).uuid = this.mUuid;
        ((MessageForPic)localObject).md5 = this.mMd5;
        ((MessageForPic)localObject).istroop = this.d.uinType;
        ((MessageForPic)localObject).msgtype = this.d.mMsgType;
        ((MessageForPic)localObject).versionCode = this.d.messageVersion;
        ((MessageForPic)localObject).uniseq = this.d.mUniseq;
        ((MessageForPic)localObject).issend = this.d.mIsSend;
        ((MessageForPic)localObject).selfuin = this.d.currentAccountUin;
        ((MessageForPic)localObject).frienduin = this.d.uin;
        ((MessageForPic)localObject).groupFileID = this.anV;
        ((MessageForPic)localObject).busiType = 1030;
        if (this.d.mIsSend != 1) {
          break label469;
        }
      }
      label469:
      for (paramBundle = this.d.currentAccountUin;; paramBundle = this.d.uin)
      {
        ((MessageForPic)localObject).senderuin = paramBundle;
        ((MessageForPic)localObject).size = this.filesize;
        ((MessageForPic)localObject).time = this.time;
        ((MessageForPic)localObject).subVersion = 5;
        ((MessageForPic)localObject).fileSizeFlag = 0;
        ((MessageForPic)localObject).thumbHeight = this.d.thumbHeight;
        ((MessageForPic)localObject).thumbWidth = this.d.thumbWidth;
        ((MessageForPic)localObject).rawMsgUrl = this.d.rawUrl;
        ((MessageForPic)localObject).bigMsgUrl = this.d.bigUrl;
        ((MessageForPic)localObject).thumbMsgUrl = this.d.thumbUrl;
        if (useCustomSize()) {
          ((MessageForPic)localObject).thumbWidthHeightDP = new ThumbWidthHeightDP(this.mMinWidth, this.mMinHeight, this.mMaxWidth, this.mMaxHeight, true);
        }
        paramBundle = aoiz.getFile(aoop.a((akxw)localObject, 1, null).toString());
        if ((paramBundle != null) && (GifDrawable.isGifFile(paramBundle))) {
          ((MessageForPic)localObject).imageType = 2000;
        }
        this.j = ((MessageForPic)localObject);
        localObject = xkl.b(paramContext, this.j);
        this.m = ((URLDrawable)localObject).getURL();
        if ((paramView == null) || (!(paramView instanceof BubbleImageView))) {
          break;
        }
        paramContext = (BubbleImageView)paramView;
        paramContext.TE(false);
        paramContext.setShowEdge(true);
        paramContext.setImageDrawable((Drawable)localObject);
        ahtr.a(this.d, paramContext);
        return paramContext;
      }
      paramView = new BubbleImageView(paramContext);
      paramView.setId(2131369034);
      paramView.setAdjustViewBounds(true);
      if (this.mMaxWidth != 0)
      {
        i = wja.dp2px(this.mMaxWidth, paramContext.getResources());
        label522:
        paramView.setMaxWidth(i);
        if (this.mMaxHeight == 0) {
          break label634;
        }
      }
      label634:
      for (int i = wja.dp2px(this.mMaxHeight, paramContext.getResources());; i = aoop.G(false))
      {
        paramView.setMaxHeight(i);
        if (this.mMinWidth != 0) {
          paramView.setMinimumWidth(wja.dp2px(this.mMinWidth, paramContext.getResources()));
        }
        if (this.mMinHeight != 0) {
          paramView.setMinimumHeight(wja.dp2px(this.mMinHeight, paramContext.getResources()));
        }
        paramView.setAdjustViewBounds(true);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setRadius(12.0F);
        paramContext = paramView;
        break;
        i = aoop.G(false);
        break label522;
      }
    }
  }
  
  public MessageForPic a()
  {
    MessageForPic localMessageForPic = new MessageForPic();
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "StructMsgItemImage.generateMessageForPic.mImageShareMsg == null nudnik trick");
      }
      return localMessageForPic;
    }
    localMessageForPic.path = this.cij;
    localMessageForPic.uuid = this.mUuid;
    localMessageForPic.md5 = this.mMd5;
    localMessageForPic.istroop = this.d.uinType;
    localMessageForPic.msgtype = this.d.mMsgType;
    localMessageForPic.versionCode = this.d.messageVersion;
    localMessageForPic.uniseq = this.d.mUniseq;
    localMessageForPic.issend = this.d.mIsSend;
    localMessageForPic.selfuin = this.d.currentAccountUin;
    localMessageForPic.frienduin = this.d.uin;
    localMessageForPic.groupFileID = this.anV;
    localMessageForPic.busiType = 1030;
    if (this.d.mIsSend == 1) {}
    for (String str = this.d.currentAccountUin;; str = this.d.uin)
    {
      localMessageForPic.senderuin = str;
      localMessageForPic.size = this.filesize;
      localMessageForPic.time = this.time;
      localMessageForPic.subVersion = 5;
      localMessageForPic.fileSizeFlag = 0;
      localMessageForPic.thumbHeight = this.d.thumbHeight;
      localMessageForPic.thumbWidth = this.d.thumbWidth;
      return localMessageForPic;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "image");
    if (this.mUuid == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uuid", str);
      if (this.mMd5 != null) {
        break label206;
      }
      str = "";
      label44:
      paramXmlSerializer.attribute(null, "md5", str);
      paramXmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.anV));
      paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.filesize));
      if (this.cij != null) {
        break label214;
      }
    }
    label206:
    label214:
    for (String str = "";; str = this.cij)
    {
      paramXmlSerializer.attribute(null, "local_path", str);
      paramXmlSerializer.attribute(null, "minWidth", Integer.toString(this.mMinWidth));
      paramXmlSerializer.attribute(null, "minHeight", Integer.toString(this.mMinHeight));
      paramXmlSerializer.attribute(null, "maxWidth", Integer.toString(this.mMaxWidth));
      paramXmlSerializer.attribute(null, "maxHeight", Integer.toString(this.mMaxHeight));
      paramXmlSerializer.endTag(null, "image");
      return;
      str = this.mUuid;
      break;
      str = this.mMd5;
      break label44;
    }
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {}
    for (;;)
    {
      return true;
      String str4 = paramansf.getAttribute("uuid");
      String str3 = paramansf.getAttribute("md5");
      String str6 = paramansf.getAttribute("md5");
      String str5 = paramansf.getAttribute("filesize");
      String str2 = paramansf.getAttribute("local_path");
      String str1 = str4;
      if (str4 == null) {
        str1 = "";
      }
      this.mUuid = str1;
      if (str3 == null)
      {
        str1 = "";
        label76:
        this.mMd5 = str1;
        if (str2 != null) {
          break label193;
        }
        str1 = "";
        this.cij = str1;
        this.mMinWidth = wja.a(paramansf, "minWidth");
        this.mMinHeight = wja.a(paramansf, "minHeight");
        this.mMaxWidth = wja.a(paramansf, "maxWidth");
        this.mMaxHeight = wja.a(paramansf, "maxHeight");
        if (str6 == null) {}
      }
      try
      {
        this.anV = Long.parseLong(str6);
        if (str5 == null) {
          continue;
        }
        try
        {
          this.filesize = Long.parseLong(str5);
          return true;
        }
        catch (NumberFormatException paramansf) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, paramansf.getMessage());
        return true;
        str1 = str3;
        break label76;
        label193:
        str1 = str2;
      }
      catch (NumberFormatException paramansf)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramansf.getMessage());
          }
        }
      }
    }
  }
  
  public String getLayoutStr()
  {
    return "Image";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.cij = paramObjectInput.readUTF();
    this.mUuid = paramObjectInput.readUTF();
    this.mMd5 = paramObjectInput.readUTF();
    this.anV = paramObjectInput.readLong();
    this.filesize = paramObjectInput.readLong();
    this.time = paramObjectInput.readLong();
    if (this.mVersion > 13)
    {
      this.mMinWidth = paramObjectInput.readInt();
      this.mMinHeight = paramObjectInput.readInt();
      this.mMaxWidth = paramObjectInput.readInt();
      this.mMaxHeight = paramObjectInput.readInt();
    }
  }
  
  public boolean useCustomSize()
  {
    return (this.mMinWidth != 0) && (this.mMinHeight != 0) && (this.mMaxWidth != 0) && (this.mMaxHeight != 0);
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.cij == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mUuid != null) {
        break label147;
      }
      str = "";
      label34:
      paramObjectOutput.writeUTF(str);
      if (this.mMd5 != null) {
        break label155;
      }
    }
    label147:
    label155:
    for (String str = "";; str = this.mMd5)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.anV);
      paramObjectOutput.writeLong(this.filesize);
      paramObjectOutput.writeLong(this.time);
      if (this.mVersion > 13)
      {
        paramObjectOutput.writeInt(this.mMinWidth);
        paramObjectOutput.writeInt(this.mMinHeight);
        paramObjectOutput.writeInt(this.mMaxWidth);
        paramObjectOutput.writeInt(this.mMaxHeight);
      }
      return;
      str = this.cij;
      break;
      str = this.mUuid;
      break label34;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansu
 * JD-Core Version:    0.7.0.1
 */