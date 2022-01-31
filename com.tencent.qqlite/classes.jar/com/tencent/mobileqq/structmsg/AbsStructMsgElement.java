package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import egf;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgElement
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  long a;
  public String a;
  public String b;
  public String c = null;
  int d;
  public String d;
  int e;
  public String e;
  int f;
  public String f = null;
  public String g = null;
  
  public AbsStructMsgElement()
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = -1L;
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public abstract View a(Context paramContext, View paramView);
  
  public abstract String a();
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_d_of_type_Int = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
  }
  
  public abstract void a(XmlSerializer paramXmlSerializer);
  
  public boolean a(int paramInt)
  {
    return (this.jdField_e_of_type_Int & paramInt) == paramInt;
  }
  
  public abstract boolean a(StructMsgNode paramStructMsgNode);
  
  public void b(int paramInt)
  {
    if ((this.jdField_e_of_type_Int & paramInt) == 0) {
      this.jdField_e_of_type_Int |= paramInt;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_e_of_type_Int &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    Object localObject;
    Context localContext;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        localObject = paramView.getTag();
      } while (!getClass().isInstance(localObject));
      localObject = (AbsStructMsgElement)localObject;
      localContext = paramView.getContext();
    } while (!ChatActivity.class.isInstance(localContext));
    new egf(((ChatActivity)localContext).a(), paramView).a(((AbsStructMsgElement)localObject).c, ((AbsStructMsgElement)localObject).b, ((AbsStructMsgElement)localObject).jdField_d_of_type_JavaLangString, ((AbsStructMsgElement)localObject).jdField_e_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgElement
 * JD-Core Version:    0.7.0.1
 */