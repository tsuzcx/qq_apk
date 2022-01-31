package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemHr
  extends AbsStructMsgElement
{
  public StructMsgItemHr()
  {
    this.a = "hr";
  }
  
  public View a(Context paramContext, View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = new View(paramContext);
      localView.setBackgroundColor(-3618613);
    }
    return localView;
  }
  
  public String a()
  {
    return "Hr";
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "hr");
    paramXmlSerializer.endTag(null, "hr");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemHr
 * JD-Core Version:    0.7.0.1
 */