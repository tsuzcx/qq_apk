package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgForHypertext
  extends AbsStructMsg
{
  public ArrayList mHpertextArray = null;
  protected boolean mHyperClick = false;
  public int mHypertextContentLayout = -1;
  
  StructMsgForHypertext() {}
  
  StructMsgForHypertext(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mMsgServiceID = 3;
    paramStructMsgNode = paramStructMsgNode.b();
    StructMsgNode localStructMsgNode;
    if (paramStructMsgNode != null)
    {
      if (paramStructMsgNode.a == 1) {
        break label77;
      }
      paramStructMsgNode = StructMsgFactory.a(paramStructMsgNode);
      if (paramStructMsgNode != null)
      {
        localStructMsgNode = paramStructMsgNode.b();
        paramStructMsgNode = localStructMsgNode;
        if (localStructMsgNode.a != 1) {
          paramStructMsgNode = StructMsgFactory.a(localStructMsgNode);
        }
        parseItem(paramStructMsgNode);
      }
    }
    label77:
    do
    {
      return;
      localStructMsgNode = paramStructMsgNode.b();
    } while (localStructMsgNode == null);
    paramStructMsgNode = localStructMsgNode;
    if (localStructMsgNode.a != 1) {
      paramStructMsgNode = StructMsgFactory.a(localStructMsgNode);
    }
    parseItem(paramStructMsgNode);
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HypertextMsg", 2, "getBytes failure");
      }
    }
    return null;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    return null;
  }
  
  public SpannableStringBuilder getSpannableString()
  {
    if (this.mHpertextArray == null) {
      return new SpannableStringBuilder("");
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Iterator localIterator = this.mHpertextArray.iterator();
    while (localIterator.hasNext())
    {
      StructMsgForHypertext.Hypertext localHypertext = (StructMsgForHypertext.Hypertext)localIterator.next();
      String str = localHypertext.f;
      if (!TextUtils.isEmpty(localHypertext.b))
      {
        int i = localSpannableStringBuilder.toString().length();
        int j = str.length();
        localSpannableStringBuilder.append(str);
        localSpannableStringBuilder.setSpan(new StructMsgForHypertext.HyperSpannable(this, localHypertext), i, j + i, 33);
      }
      else
      {
        localSpannableStringBuilder.append(str);
      }
    }
    return localSpannableStringBuilder;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (ViewGroup)super.getView(paramContext, paramView, paramOnLongClickAndTouchListener);
    paramOnLongClickAndTouchListener = new StructMsgForHypertext.HyperTextView(paramContext);
    Resources localResources = paramContext.getResources();
    paramOnLongClickAndTouchListener.setPadding((int)localResources.getDimension(2131427488), (int)localResources.getDimension(2131427490), (int)localResources.getDimension(2131427489), (int)localResources.getDimension(2131427491));
    paramOnLongClickAndTouchListener.setText(getSpannableString());
    paramOnLongClickAndTouchListener.setTextSize(0, ChatTextSizeSettingActivity.a(paramContext));
    paramOnLongClickAndTouchListener.setTextColor(paramContext.getResources().getColor(2131361819));
    paramOnLongClickAndTouchListener.setLinkTextColor(paramContext.getResources().getColor(2131361846));
    paramOnLongClickAndTouchListener.setLinksClickable(false);
    paramOnLongClickAndTouchListener.setMovementMethod(LinkMovementMethod.getInstance());
    paramView.addView(paramOnLongClickAndTouchListener);
    paramContext = paramView.getLayoutParams();
    if (paramContext == null) {
      new LinearLayout.LayoutParams(BaseChatItemLayout.g, -2);
    }
    for (;;)
    {
      paramView.setLongClickable(true);
      paramView.setTag(2131230767, this);
      return paramView;
      paramContext.width = BaseChatItemLayout.g;
      paramContext.height = -2;
    }
  }
  
  public byte[] getXmlBytes()
  {
    Object localObject2 = new ByteArrayOutputStream();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    try
    {
      localXmlSerializer.setOutput((OutputStream)localObject2, "UTF-8");
      localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localXmlSerializer.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgAction == null)
      {
        localObject1 = "";
        localXmlSerializer.attribute(null, "action", (String)localObject1);
        if (this.mMsgActionData != null) {
          break label493;
        }
        localObject1 = "";
        label121:
        localXmlSerializer.attribute(null, "actionData", (String)localObject1);
        if (this.mMsg_A_ActionData != null) {
          break label501;
        }
        localObject1 = "";
        label144:
        localXmlSerializer.attribute(null, "a_actionData", (String)localObject1);
        if (this.mMsg_I_ActionData != null) {
          break label509;
        }
        localObject1 = "";
        label167:
        localXmlSerializer.attribute(null, "i_actionData", (String)localObject1);
        if (this.mMsgUrl != null) {
          break label517;
        }
        localObject1 = "";
        label190:
        localXmlSerializer.attribute(null, "url", (String)localObject1);
        if (this.fwFlag == 1) {
          localXmlSerializer.attribute(null, "fwflag", String.valueOf(this.fwFlag));
        }
        localXmlSerializer.startTag(null, "item");
        localXmlSerializer.attribute(null, "layout", String.valueOf(this.mHypertextContentLayout));
        localXmlSerializer.startTag(null, "hypertext");
        if (this.mHpertextArray == null) {
          break label533;
        }
        i = 0;
        label282:
        if (i >= this.mHpertextArray.size()) {
          break label533;
        }
        localObject1 = (StructMsgForHypertext.Hypertext)this.mHpertextArray.get(i);
        localXmlSerializer.startTag(null, "text");
        if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).b))
        {
          if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).a)) {
            localXmlSerializer.attribute(null, "url", ((StructMsgForHypertext.Hypertext)localObject1).a);
          }
          localXmlSerializer.attribute(null, "action", ((StructMsgForHypertext.Hypertext)localObject1).b);
          if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).c)) {
            localXmlSerializer.attribute(null, "actionData", ((StructMsgForHypertext.Hypertext)localObject1).c);
          }
          if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).d)) {
            localXmlSerializer.attribute(null, "a_actionData", ((StructMsgForHypertext.Hypertext)localObject1).d);
          }
          if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).e)) {
            localXmlSerializer.attribute(null, "i_actionData", ((StructMsgForHypertext.Hypertext)localObject1).e);
          }
        }
        if (((StructMsgForHypertext.Hypertext)localObject1).f != null) {
          break label525;
        }
      }
      label517:
      label525:
      for (localObject1 = "";; localObject1 = ((StructMsgForHypertext.Hypertext)localObject1).f)
      {
        localXmlSerializer.text((String)localObject1);
        localXmlSerializer.endTag(null, "text");
        i += 1;
        break label282;
        localObject1 = this.mMsgAction;
        break;
        label493:
        localObject1 = this.mMsgActionData;
        break label121;
        label501:
        localObject1 = this.mMsg_A_ActionData;
        break label144;
        label509:
        localObject1 = this.mMsg_I_ActionData;
        break label167;
        localObject1 = this.mMsgUrl;
        break label190;
      }
      label533:
      localXmlSerializer.endTag(null, "hypertext");
      localXmlSerializer.endTag(null, "item");
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      localXmlSerializer.flush();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, localIllegalArgumentException.getMessage(), localIllegalArgumentException);
        }
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, localIllegalStateException.getMessage(), localIllegalStateException);
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, localIOException.getMessage(), localIOException);
        }
      }
    }
    localObject1 = StructMsgUtils.b(((ByteArrayOutputStream)localObject2).toByteArray());
    i = localObject1.length;
    localObject2 = new byte[i + 1];
    localObject2[0] = 1;
    System.arraycopy(localObject1, 0, localObject2, 1, i);
    return localObject2;
  }
  
  protected void parseItem(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramStructMsgNode.a())
    {
      Object localObject3 = paramStructMsgNode.a(i);
      if (localObject3 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject1;
        Object localObject2;
        if (((StructMsgNode)localObject3).a())
        {
          localObject1 = ((StructMsgNode)localObject3).a("url");
          localObject2 = ((StructMsgNode)localObject3).a("action");
          String str1 = ((StructMsgNode)localObject3).a("actionData");
          String str2 = ((StructMsgNode)localObject3).a("a_actionData");
          String str3 = ((StructMsgNode)localObject3).a("i_actionData");
          localObject3 = StructMsgFactory.a((StructMsgNode)localObject3);
          localObject1 = new StructMsgForHypertext.Hypertext((String)localObject1, (String)localObject2, str1, str2, str3, (String)localObject3);
          this.mHpertextArray.add(localObject1);
          localStringBuilder.append((String)localObject3);
        }
        else
        {
          localObject1 = StructMsgFactory.a((StructMsgNode)localObject3);
          localObject2 = new StructMsgForHypertext.Hypertext((String)localObject1);
          this.mHpertextArray.add(localObject2);
          localStringBuilder.append((String)localObject1);
        }
      }
    }
    this.mMsgBrief = localStringBuilder.toString();
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int i = paramObjectInput.readInt();
    this.mVersion = i;
    if (i == 1)
    {
      this.mMsgTemplateID = paramObjectInput.readInt();
      this.mMsgAction = paramObjectInput.readUTF();
      this.mMsgActionData = paramObjectInput.readUTF();
      this.mMsg_A_ActionData = paramObjectInput.readUTF();
      this.mMsg_I_ActionData = paramObjectInput.readUTF();
      this.mMsgUrl = paramObjectInput.readUTF();
      this.mMsgBrief = paramObjectInput.readUTF();
      int j = paramObjectInput.readInt();
      if (j > 0)
      {
        this.mHpertextArray = new ArrayList();
        i = 0;
        while (i < j)
        {
          StructMsgForHypertext.Hypertext localHypertext = new StructMsgForHypertext.Hypertext(paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF());
          this.mHpertextArray.add(localHypertext);
          i += 1;
        }
      }
      this.fwFlag = paramObjectInput.readInt();
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    label57:
    label74:
    label91:
    label108:
    StructMsgForHypertext.Hypertext localHypertext;
    if (this.mMsgAction == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgActionData != null) {
        break label310;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_A_ActionData != null) {
        break label318;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_I_ActionData != null) {
        break label326;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgUrl != null) {
        break label334;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeUTF(this.mMsgBrief);
      if (this.mHpertextArray == null) {
        break label378;
      }
      paramObjectOutput.writeInt(this.mHpertextArray.size());
      Iterator localIterator = this.mHpertextArray.iterator();
      label153:
      if (!localIterator.hasNext()) {
        break label385;
      }
      localHypertext = (StructMsgForHypertext.Hypertext)localIterator.next();
      if (localHypertext.a == null) {
        break label342;
      }
      str = localHypertext.a;
      label187:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.b == null) {
        break label348;
      }
      str = localHypertext.b;
      label208:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.c == null) {
        break label354;
      }
      str = localHypertext.c;
      label229:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.d == null) {
        break label360;
      }
      str = localHypertext.d;
      label250:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.e == null) {
        break label366;
      }
      str = localHypertext.e;
      label271:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.f == null) {
        break label372;
      }
    }
    label310:
    label318:
    label326:
    label334:
    label342:
    label348:
    label354:
    label360:
    label366:
    label372:
    for (String str = localHypertext.f;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      break label153;
      str = this.mMsgAction;
      break;
      str = this.mMsgActionData;
      break label57;
      str = this.mMsg_A_ActionData;
      break label74;
      str = this.mMsg_I_ActionData;
      break label91;
      str = this.mMsgUrl;
      break label108;
      str = "";
      break label187;
      str = "";
      break label208;
      str = "";
      break label229;
      str = "";
      break label250;
      str = "";
      break label271;
    }
    label378:
    paramObjectOutput.writeInt(0);
    label385:
    paramObjectOutput.writeInt(this.fwFlag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext
 * JD-Core Version:    0.7.0.1
 */