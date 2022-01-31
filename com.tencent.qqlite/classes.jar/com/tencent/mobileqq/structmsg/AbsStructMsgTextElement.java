package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgTextElement
  extends AbsStructMsgElement
  implements View.OnClickListener
{
  protected boolean a;
  protected boolean b = false;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  
  public AbsStructMsgTextElement()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public AbsStructMsgTextElement(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.k = paramString1;
  }
  
  protected TextUtils.TruncateAt a()
  {
    return TextUtils.TruncateAt.END;
  }
  
  public View a(Context paramContext, View paramView)
  {
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      paramView = (TextView)paramView;
      paramView.setTag(this);
      if (!this.b) {
        break label130;
      }
      paramView.setSingleLine(true);
    }
    for (;;)
    {
      if ((this.b) || (!this.jdField_a_of_type_Boolean)) {
        paramView.setEllipsize(a());
      }
      paramContext = a(paramContext.getResources());
      if (paramContext != null)
      {
        paramView.setTextColor(paramContext.jdField_a_of_type_Int);
        paramView.requestLayout();
        paramView.setTypeface(Typeface.DEFAULT, paramContext.b);
        paramView.setTextSize(paramContext.c);
        paramView.setText(paramContext.jdField_a_of_type_JavaLangString);
      }
      return paramView;
      paramView = new TextView(paramContext);
      paramView.setId(c());
      break;
      label130:
      if (!this.jdField_a_of_type_Boolean) {
        paramView.setMaxLines(b());
      }
    }
  }
  
  public AbsStructMsgTextElement.RichText a(Resources paramResources)
  {
    paramResources = new AbsStructMsgTextElement.RichText();
    for (;;)
    {
      try
      {
        if ((this.h == null) || (this.h.equals("")))
        {
          m = d();
          paramResources.jdField_a_of_type_Int = m;
        }
      }
      catch (Exception localException1)
      {
        paramResources.jdField_a_of_type_Int = d();
        continue;
        int m = Integer.parseInt(this.i);
        continue;
        m = Integer.parseInt(this.j);
        continue;
        paramResources.jdField_a_of_type_JavaLangString = b();
        return paramResources;
      }
      try
      {
        if ((this.i != null) && (!this.i.equals(""))) {
          continue;
        }
        m = f();
        paramResources.b = m;
      }
      catch (Exception localException3)
      {
        continue;
      }
      if ((paramResources.b < 0) || (paramResources.b >= 4)) {
        paramResources.b = f();
      }
      try
      {
        if ((this.j != null) && (!this.j.equals(""))) {
          continue;
        }
        m = e();
        paramResources.c = m;
      }
      catch (Exception localException2)
      {
        continue;
      }
      if (paramResources.c < 1) {
        paramResources.c = e();
      }
      paramResources.c /= 2;
      if ((b() != null) && (!b().equals(""))) {
        continue;
      }
      return null;
      m = Color.parseColor(this.h);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.d == 1) {
      this.k = MessageUtils.a(paramObjectInput.readUTF(), false);
    }
    while (this.d != 2) {
      return;
    }
    this.h = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.i = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.j = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.k = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.d == 1) {
      if (this.k == null)
      {
        str = "";
        paramObjectOutput.writeUTF(str);
      }
    }
    while (this.d != 2) {
      for (;;)
      {
        return;
        str = MessageUtils.a(this.k, false);
      }
    }
    if (this.h == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.i != null) {
        break label128;
      }
      str = "";
      label78:
      paramObjectOutput.writeUTF(str);
      if (this.j != null) {
        break label136;
      }
      str = "";
      label95:
      paramObjectOutput.writeUTF(str);
      if (this.k != null) {
        break label144;
      }
    }
    label128:
    label136:
    label144:
    for (String str = "";; str = MessageUtils.a(this.k, false))
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.h;
      break;
      str = this.i;
      break label78;
      str = this.j;
      break label95;
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.k = paramString;
      return;
    }
    this.k = StringUtil.g(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.k != null)
    {
      if (!TextUtils.isEmpty(this.j)) {
        paramXmlSerializer.attribute(null, "size", this.j);
      }
      if (!TextUtils.isEmpty(this.h)) {
        paramXmlSerializer.attribute(null, "color", this.h);
      }
      if (!TextUtils.isEmpty(this.i)) {
        paramXmlSerializer.attribute(null, "style", this.i);
      }
      paramXmlSerializer.text(this.k);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.h = paramStructMsgNode.a("color");
    this.i = paramStructMsgNode.a("style");
    this.j = paramStructMsgNode.a("size");
    this.k = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
  
  public int b()
  {
    return 2;
  }
  
  public String b()
  {
    if (this.k == null) {}
    for (String str = "";; str = this.k)
    {
      this.k = str;
      return this.k;
    }
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
  
  protected abstract int c();
  
  public void c(String paramString)
  {
    this.i = paramString;
  }
  
  public int d()
  {
    return -16777216;
  }
  
  public void d(String paramString)
  {
    this.j = paramString;
  }
  
  public int e()
  {
    return 26;
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgTextElement
 * JD-Core Version:    0.7.0.1
 */