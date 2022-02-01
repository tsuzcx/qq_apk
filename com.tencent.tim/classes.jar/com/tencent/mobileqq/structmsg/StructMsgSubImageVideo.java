package com.tencent.mobileqq.structmsg;

import acfp;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import anqy;
import ansf;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class StructMsgSubImageVideo
  extends AbsStructMsg
{
  private ImageItem imageItem;
  private VideoItem videoItem;
  
  public StructMsgSubImageVideo() {}
  
  StructMsgSubImageVideo(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public StructMsgSubImageVideo(ansf paramansf)
  {
    super(paramansf);
    if (paramansf.children == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramansf.children.iterator();
      while (localIterator.hasNext())
      {
        paramansf = (ansf)localIterator.next();
        Object localObject;
        if ((paramansf == null) || (!"item".equals(paramansf.name)))
        {
          localObject = new StringBuilder().append("StructMsgSubImageVideo: null or wrong node ");
          if (paramansf == null) {}
          for (paramansf = "null";; paramansf = paramansf.name)
          {
            Log.i("StructMsgSubImageVideo", paramansf);
            break;
          }
        }
        if ((paramansf.children == null) || (paramansf.children.isEmpty()))
        {
          Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: no child in node");
        }
        else
        {
          localObject = paramansf.getAttribute("apptype");
          if (!"10".equals(localObject))
          {
            Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: wrong app type " + (String)localObject);
          }
          else
          {
            localObject = paramansf.getAttribute("type");
            if ("0".equals(localObject)) {
              this.videoItem = VideoItem.a(paramansf);
            } else if ("1".equals(localObject)) {
              this.imageItem = ImageItem.a(paramansf);
            } else {
              Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: wrong type " + (String)localObject);
            }
          }
        }
      }
    }
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgSubImageVideo", 2, localIOException.getMessage());
      }
    }
    return null;
  }
  
  public ImageItem getImageItem()
  {
    return this.imageItem;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    paramContext = new View(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(600, 600));
    paramContext.setBackgroundColor(-65536);
    return paramContext;
  }
  
  public String getSourceName()
  {
    return acfp.m(2131715035);
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    return null;
  }
  
  public VideoItem getVideoItem()
  {
    return this.videoItem;
  }
  
  public boolean isValid()
  {
    return (this.videoItem != null) || (this.imageItem != null);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    Log.i("StructMsgSubImageVideo", "readExternal: " + i);
    this.mMsgBrief = paramObjectInput.readUTF();
    this.mFlag = paramObjectInput.readInt();
    i = paramObjectInput.readInt();
    if ((i & 0x1) != 0)
    {
      if (this.videoItem == null) {
        this.videoItem = new VideoItem();
      }
      this.videoItem.readExternal(paramObjectInput);
    }
    if ((i & 0x10) != 0)
    {
      if (this.imageItem == null) {
        this.imageItem = new ImageItem();
      }
      this.imageItem.readExternal(paramObjectInput);
    }
  }
  
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    AbsStructMsg.a locala = new AbsStructMsg.a(this, new anqy());
    try
    {
      locala.setOutput(paramByteArrayOutputStream, paramString);
      locala.startDocument(paramString, Boolean.valueOf(true));
      locala.startTag(null, "msg");
      locala.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      locala.attribute(null, "flag", String.valueOf(this.mFlag));
      locala.attribute(null, "brief", this.mMsgBrief);
      if (this.videoItem != null) {
        this.videoItem.toXml(locala);
      }
      if (this.imageItem != null) {
        this.imageItem.toXml(locala);
      }
      locala.endTag(null, "msg");
      locala.endDocument();
      locala.flush();
      return;
    }
    catch (IOException paramByteArrayOutputStream)
    {
      Log.w("StructMsgSubImageVideo", "toXml: ", paramByteArrayOutputStream);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = 1;
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(1);
    paramObjectOutput.writeUTF(this.mMsgBrief);
    paramObjectOutput.writeInt(this.mFlag);
    if (this.videoItem != null) {}
    for (;;)
    {
      int j = i;
      if (this.imageItem != null) {
        j = i | 0x10;
      }
      paramObjectOutput.writeInt(j);
      if (this.videoItem != null) {
        this.videoItem.writeExternal(paramObjectOutput);
      }
      if (this.imageItem != null) {
        this.imageItem.writeExternal(paramObjectOutput);
      }
      return;
      i = 0;
    }
  }
  
  public static class ImageItem
    implements Externalizable
  {
    public String imageUrl;
    public String schema;
    public String title;
    
    private static ImageItem a(ansf paramansf)
    {
      Iterator localIterator = paramansf.children.iterator();
      Object localObject1 = null;
      Object localObject2 = null;
      Object localObject3;
      if (localIterator.hasNext())
      {
        localObject3 = (ansf)localIterator.next();
        if ("title".equals(((ansf)localObject3).name)) {
          localObject2 = localObject3;
        }
      }
      for (;;)
      {
        break;
        if ("picture".equals(((ansf)localObject3).name))
        {
          localObject1 = localObject3;
          continue;
          if (localObject1 == null)
          {
            Log.i("StructMsgSubImageVideo", "parseImageNode: null imageNode");
            return null;
          }
          localObject3 = new ImageItem();
          ((ImageItem)localObject3).schema = paramansf.getAttribute("url");
          if (localObject2 == null) {}
          for (paramansf = "";; paramansf = localObject2.value)
          {
            ((ImageItem)localObject3).title = paramansf;
            ((ImageItem)localObject3).imageUrl = localObject1.getAttribute("cover");
            return localObject3;
          }
        }
      }
    }
    
    public void readExternal(ObjectInput paramObjectInput)
      throws IOException, ClassNotFoundException
    {
      this.title = paramObjectInput.readUTF();
      this.imageUrl = paramObjectInput.readUTF();
      this.schema = paramObjectInput.readUTF();
    }
    
    public void toXml(AbsStructMsg.a parama)
      throws IOException
    {
      parama.startTag(null, "item");
      parama.attribute(null, "apptype", "10");
      parama.attribute(null, "type", "0");
      parama.attribute(null, "url", this.schema);
      parama.startTag(null, "title");
      if (this.title == null)
      {
        str = "";
        parama.text(str);
        parama.endTag(null, "title");
        parama.startTag(null, "picture");
        if (this.imageUrl != null) {
          break label124;
        }
      }
      label124:
      for (String str = "";; str = this.imageUrl)
      {
        parama.attribute(null, "cover", str);
        parama.endTag(null, "picture");
        parama.endTag(null, "item");
        return;
        str = this.title;
        break;
      }
    }
    
    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      if (this.title == null)
      {
        str = "";
        paramObjectOutput.writeUTF(str);
        if (this.imageUrl != null) {
          break label60;
        }
        str = "";
        label27:
        paramObjectOutput.writeUTF(str);
        if (this.schema != null) {
          break label68;
        }
      }
      label60:
      label68:
      for (String str = "";; str = this.schema)
      {
        paramObjectOutput.writeUTF(str);
        return;
        str = this.title;
        break;
        str = this.imageUrl;
        break label27;
      }
    }
  }
  
  public static class VideoItem
    implements Externalizable
  {
    public String coverUrl;
    public int height;
    public String schema;
    public String title;
    public String videoUrl;
    public int width;
    
    private static VideoItem a(ansf paramansf)
    {
      Iterator localIterator = paramansf.children.iterator();
      Object localObject1 = null;
      Object localObject2 = null;
      Object localObject3;
      if (localIterator.hasNext())
      {
        localObject3 = (ansf)localIterator.next();
        if ("title".equals(((ansf)localObject3).name)) {
          localObject2 = localObject3;
        }
      }
      for (;;)
      {
        break;
        if ("video".equals(((ansf)localObject3).name))
        {
          localObject1 = localObject3;
          continue;
          if (localObject1 == null)
          {
            Log.i("StructMsgSubImageVideo", "parseVideoNode: null videoNode");
            return null;
          }
          localObject3 = new VideoItem();
          ((VideoItem)localObject3).schema = paramansf.getAttribute("url");
          if (localObject2 == null) {}
          for (paramansf = "";; paramansf = localObject2.value)
          {
            ((VideoItem)localObject3).title = paramansf;
            ((VideoItem)localObject3).coverUrl = localObject1.getAttribute("cover");
            ((VideoItem)localObject3).videoUrl = localObject1.getAttribute("url");
            try
            {
              ((VideoItem)localObject3).width = Integer.parseInt(localObject1.getAttribute("width"));
              ((VideoItem)localObject3).height = Integer.parseInt(localObject1.getAttribute("height"));
              return localObject3;
            }
            catch (NumberFormatException paramansf)
            {
              Log.w("StructMsgSubImageVideo", "parseVideoNode: wrong width or height param", paramansf);
              return localObject3;
            }
          }
        }
      }
    }
    
    public void readExternal(ObjectInput paramObjectInput)
      throws IOException, ClassNotFoundException
    {
      this.title = paramObjectInput.readUTF();
      this.coverUrl = paramObjectInput.readUTF();
      this.videoUrl = paramObjectInput.readUTF();
      this.schema = paramObjectInput.readUTF();
      this.width = paramObjectInput.readInt();
      this.height = paramObjectInput.readInt();
    }
    
    public void toXml(AbsStructMsg.a parama)
      throws IOException
    {
      parama.startTag(null, "item");
      parama.attribute(null, "apptype", "10");
      parama.attribute(null, "type", "0");
      parama.attribute(null, "url", this.schema);
      parama.startTag(null, "title");
      if (this.title == null)
      {
        str = "";
        parama.text(str);
        parama.endTag(null, "title");
        parama.startTag(null, "video");
        if (this.coverUrl != null) {
          break label173;
        }
        str = "";
        label90:
        parama.attribute(null, "cover", str);
        if (this.videoUrl != null) {
          break label181;
        }
      }
      label173:
      label181:
      for (String str = "";; str = this.videoUrl)
      {
        parama.attribute(null, "url", str);
        parama.attribute(null, "width", Integer.toString(this.width));
        parama.attribute(null, "height", Integer.toString(this.height));
        parama.endTag(null, "video");
        parama.endTag(null, "item");
        return;
        str = this.title;
        break;
        str = this.coverUrl;
        break label90;
      }
    }
    
    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      if (this.title == null)
      {
        str = "";
        paramObjectOutput.writeUTF(str);
        if (this.coverUrl != null) {
          break label97;
        }
        str = "";
        label27:
        paramObjectOutput.writeUTF(str);
        if (this.videoUrl != null) {
          break label105;
        }
        str = "";
        label44:
        paramObjectOutput.writeUTF(str);
        if (this.schema != null) {
          break label113;
        }
      }
      label97:
      label105:
      label113:
      for (String str = "";; str = this.schema)
      {
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.width);
        paramObjectOutput.writeInt(this.height);
        return;
        str = this.title;
        break;
        str = this.coverUrl;
        break label27;
        str = this.videoUrl;
        break label44;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo
 * JD-Core Version:    0.7.0.1
 */