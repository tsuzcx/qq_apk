package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import glc;
import gld;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTimer
  extends StructMsgItemSummary
{
  protected long b;
  public long c;
  public boolean c;
  protected long d;
  protected int g;
  protected int h;
  private String l;
  private String m;
  
  public StructMsgItemTimer()
  {
    this.a = "timer";
  }
  
  public StructMsgItemTimer(String paramString)
  {
    this();
    this.k = paramString;
  }
  
  public StructMsgItemTimer(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this(paramString1);
    a(paramString2, paramString3, paramLong, paramInt1, paramInt2);
  }
  
  private long a()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      long l1 = MessageCache.a();
      long l2 = this.b + this.g - l1;
      if (l2 < 0L)
      {
        this.jdField_c_of_type_Boolean = true;
        l1 = 0L;
      }
      do
      {
        return l1;
        if (l2 <= 0L) {
          break;
        }
        l1 = l2;
      } while (l2 < this.g);
      return this.g;
      this.jdField_c_of_type_Boolean = true;
      return l2;
    }
    return 0L;
  }
  
  private SpannableStringBuilder a(long paramLong)
  {
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-91585);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.l);
    localSpannableStringBuilder.append('\n');
    if (paramLong > 0L)
    {
      int i = localSpannableStringBuilder.length();
      String str = String.valueOf(paramLong) + BaseApplicationImpl.getContext().getString(2131559296);
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(this.k);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan, i, str.length() + i, 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(this.m);
    return localSpannableStringBuilder;
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
  {
    this.l = paramString1;
    this.m = paramString2;
    this.b = paramLong;
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public View a(Context paramContext, View paramView)
  {
    if ((paramView != null) && ((paramView instanceof CountdownTextView)))
    {
      paramContext = (CountdownTextView)paramView;
      paramContext.a(a(), new glc(this, paramContext));
      paramContext.setTag(this);
      return paramContext;
    }
    paramContext = new CountdownTextView(paramContext);
    paramContext.setId(2131230798);
    paramContext.setTag(this);
    paramContext.setMaxLines(3);
    paramContext.setTextColor(-10987432);
    paramContext.setTextSize(2, 12.0F);
    long l1 = a();
    if (this.k != null) {
      paramContext.setText(a(l1));
    }
    paramContext.a(l1, new gld(this, paramContext));
    return paramContext;
  }
  
  public String a()
  {
    return "Timer";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.l = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.m = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.b = paramObjectInput.readLong();
    this.g = paramObjectInput.readInt();
    this.h = paramObjectInput.readInt();
    this.jdField_c_of_type_Long = paramObjectInput.readLong();
    this.d = paramObjectInput.readLong();
    this.jdField_c_of_type_Boolean = paramObjectInput.readBoolean();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.l == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.m != null) {
        break label108;
      }
    }
    label108:
    for (String str = "";; str = this.m)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.b);
      paramObjectOutput.writeInt(this.g);
      paramObjectOutput.writeInt(this.h);
      paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
      paramObjectOutput.writeLong(this.d);
      paramObjectOutput.writeBoolean(this.jdField_c_of_type_Boolean);
      return;
      str = this.l;
      break;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "timer");
    paramXmlSerializer.attribute(null, "st", String.valueOf(this.b));
    paramXmlSerializer.attribute(null, "dr", String.valueOf(this.g));
    paramXmlSerializer.attribute(null, "index", String.valueOf(this.h));
    if (this.l == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "summary", str);
      if (this.m != null) {
        break label133;
      }
    }
    label133:
    for (String str = "";; str = this.m)
    {
      paramXmlSerializer.attribute(null, "ending", str);
      paramXmlSerializer.text(this.k);
      paramXmlSerializer.endTag(null, "timer");
      return;
      str = this.l;
      break;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.b = StructMsgUtils.a(paramStructMsgNode.a("st"));
    this.g = StructMsgUtils.a(paramStructMsgNode.a("dr"));
    this.h = StructMsgUtils.a(paramStructMsgNode.a("index"));
    this.l = MessageUtils.a(paramStructMsgNode.a("summary"), false);
    this.m = MessageUtils.a(paramStructMsgNode.a("st"), false);
    this.k = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTimer
 * JD-Core Version:    0.7.0.1
 */