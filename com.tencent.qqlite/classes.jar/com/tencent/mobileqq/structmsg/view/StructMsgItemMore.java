package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemMore
  extends AbsStructMsgElement
{
  String h = "";
  
  public StructMsgItemMore()
  {
    this.a = "more";
  }
  
  public StructMsgItemMore(String paramString)
  {
    this();
    this.h = paramString;
  }
  
  public View a(Context paramContext, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramContext).inflate(2130903659, null);
    }
    paramContext = (TextView)localView.findViewById(2131298857);
    if (TextUtils.isEmpty(this.h)) {
      this.h = "阅读全文";
    }
    paramContext.setText(this.h);
    return localView;
  }
  
  public String a()
  {
    return "More";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.h = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.h == null) {}
    for (String str = "";; str = MessageUtils.a(this.h, false))
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "title");
    paramXmlSerializer.text(this.h);
    paramXmlSerializer.endTag(null, "title");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    this.h = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemMore
 * JD-Core Version:    0.7.0.1
 */