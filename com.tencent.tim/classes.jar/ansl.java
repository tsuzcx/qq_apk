import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class ansl
  extends anqw
{
  public String cie;
  public String cif;
  public String cig;
  public String cih;
  View.OnClickListener fO = new anso(this);
  public int payState = 999;
  long time = -1L;
  
  public ansl()
  {
    this.mTypeName = "button";
  }
  
  private void dTw()
  {
    if ((!TextUtils.isEmpty(this.cgX)) && (this.cgX.equals("pay"))) {
      if (!TextUtils.isEmpty(this.cgZ)) {
        break label130;
      }
    }
    for (Object localObject = this.cgY;; localObject = this.cgZ)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("appId")) {
          this.cie = ((JSONObject)localObject).getString("appId");
        }
        if (((JSONObject)localObject).has("orderId")) {
          this.cif = ((JSONObject)localObject).getString("orderId");
        }
        if (((JSONObject)localObject).has("package")) {
          this.cih = ((JSONObject)localObject).getString("package");
        }
        if (((JSONObject)localObject).has("expireTime")) {
          this.cig = ((JSONObject)localObject).getString("expireTime");
        }
        return;
      }
      catch (Exception localException)
      {
        label130:
        while (!QLog.isColorLevel()) {}
        QLog.e("StructMsgItemButton", 2, "read msg=" + localException.getMessage());
      }
    }
  }
  
  public int Kp()
  {
    return -16734752;
  }
  
  public int Kq()
  {
    return 32;
  }
  
  public void Vt(int paramInt)
  {
    this.payState = paramInt;
    switch (paramInt)
    {
    case -3: 
    case -2: 
    case -1: 
    default: 
      return;
    case 23001027: 
      this.payState = 0;
    case 0: 
      setText(acfp.m(2131715030));
      setTextColor("#ff777777");
      return;
    case -4: 
      setText(acfp.m(2131715037));
      setTextColor("#ff777777");
      return;
    }
    setText(acfp.m(2131715028));
    setTextColor("#ff777777");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = paramBundle.getInt("Layout3ButtonCount", 0);
    int j = paramBundle.getInt("Layout3ButtonIndex", -1);
    paramContext = (TextView)super.a(paramContext, paramView, paramBundle);
    paramContext.setBackgroundResource(2130838396);
    if (i > 1) {
      if (j == 0)
      {
        paramContext.setBackgroundResource(2130838389);
        i = 0;
      }
    }
    for (;;)
    {
      paramContext.setTag(2131378828, Integer.valueOf(i));
      paramContext.setGravity(17);
      paramContext.setSingleLine();
      paramContext.setEllipsize(null);
      if ((!ayZ()) || ((ayZ()) && (ayY())))
      {
        paramContext.setClickable(true);
        paramContext.setOnClickListener(this.fO);
        paramContext.setOnLongClickListener(new ansm(this));
        paramContext.setOnTouchListener(new ansn(this));
        return paramContext;
        if (j == i - 1)
        {
          paramContext.setBackgroundResource(2130838393);
          i = 2;
        }
        else
        {
          paramContext.setBackgroundResource(2130838391);
          i = 1;
        }
      }
      else
      {
        paramContext.setClickable(false);
        paramContext.setOnClickListener(null);
        paramContext.setOnTouchListener(null);
        paramContext.setOnLongClickListener(null);
        return paramContext;
        i = 0;
      }
    }
  }
  
  public void a(String paramString, MessageRecord paramMessageRecord, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    int j = 999;
    int i = j;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      if ((i != 23001027) && (i != 0) && (i != -4) && (i != -6))
      {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (!((aaai)paramString.getManager(245)).iH(paramMessageRecord.frienduin))
        {
          j = 1;
          i = -4;
          if (j != 0) {
            paramStructMsgForGeneralShare.savePayInfo(paramString.getApplication(), this.cif, i);
          }
          Vt(i);
          return;
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = j;
        continue;
        if (isOutDate())
        {
          j = 1;
          i = -6;
        }
        else
        {
          j = 0;
        }
      }
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    super.a(paramXmlSerializer);
    paramXmlSerializer.startTag(null, "button");
    if (!TextUtils.isEmpty(this.cgX)) {
      paramXmlSerializer.attribute(null, "action", this.cgX);
    }
    if (!TextUtils.isEmpty(this.cgY)) {
      paramXmlSerializer.attribute(null, "actionData", this.cgY);
    }
    if (!TextUtils.isEmpty(this.cgZ)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.cgZ);
    }
    if (!TextUtils.isEmpty(this.cha)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.cha);
    }
    if (!TextUtils.isEmpty(this.ku)) {
      paramXmlSerializer.attribute(null, "url", this.ku);
    }
    if (!TextUtils.isEmpty(this.index)) {
      paramXmlSerializer.attribute(null, "index", this.index);
    }
    if (!TextUtils.isEmpty(this.index_name)) {
      paramXmlSerializer.attribute(null, "index_name", this.index_name);
    }
    if (!TextUtils.isEmpty(this.index_type)) {
      paramXmlSerializer.attribute(null, "index_type", this.index_type);
    }
    paramXmlSerializer.endTag(null, "button");
  }
  
  public boolean a(ansf paramansf)
  {
    super.a(paramansf);
    this.cgX = paramansf.getAttribute("action");
    this.cgY = paramansf.getAttribute("actionData");
    this.cgZ = paramansf.getAttribute("a_actionData");
    this.cha = paramansf.getAttribute("i_actionData");
    this.ku = paramansf.getAttribute("url");
    this.index = paramansf.getAttribute("index");
    this.index_name = paramansf.getAttribute("index_name");
    this.index_type = paramansf.getAttribute("index_type");
    dTw();
    return true;
  }
  
  public boolean ayY()
  {
    switch (this.payState)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public boolean ayZ()
  {
    return (!TextUtils.isEmpty(this.cie)) && (!TextUtils.isEmpty(this.cig)) && (!TextUtils.isEmpty(this.cif)) && ("pay".equals(this.cgX));
  }
  
  public String getLayoutStr()
  {
    return "Confirm";
  }
  
  protected int getTextId()
  {
    return 2131363828;
  }
  
  public boolean isOutDate()
  {
    long l1 = NetConnInfoCenter.getServerTime();
    try
    {
      long l2 = Long.parseLong(this.cig);
      if (l2 > l1) {
        return false;
      }
    }
    catch (Exception localException) {}
    return true;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.ku = paramObjectInput.readUTF();
    this.cgX = paramObjectInput.readUTF();
    this.cgY = paramObjectInput.readUTF();
    this.cgZ = paramObjectInput.readUTF();
    this.cha = paramObjectInput.readUTF();
    if (this.mVersion > 5)
    {
      this.index = paramObjectInput.readUTF();
      this.index_name = paramObjectInput.readUTF();
      this.index_type = paramObjectInput.readUTF();
    }
    dTw();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.ku == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.cgX != null) {
        break label166;
      }
      str = "";
      label34:
      paramObjectOutput.writeUTF(str);
      if (this.cgY != null) {
        break label174;
      }
      str = "";
      label52:
      paramObjectOutput.writeUTF(str);
      if (this.cgZ != null) {
        break label182;
      }
      str = "";
      label70:
      paramObjectOutput.writeUTF(str);
      if (this.cha != null) {
        break label190;
      }
      str = "";
      label88:
      paramObjectOutput.writeUTF(str);
      if (this.mVersion > 5)
      {
        if (this.index != null) {
          break label198;
        }
        str = "";
        label114:
        paramObjectOutput.writeUTF(str);
        if (this.index_name != null) {
          break label206;
        }
        str = "";
        label132:
        paramObjectOutput.writeUTF(str);
        if (this.index_type != null) {
          break label214;
        }
      }
    }
    label166:
    label174:
    label182:
    label190:
    label198:
    label206:
    label214:
    for (String str = "";; str = this.index_type)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.ku;
      break;
      str = this.cgX;
      break label34;
      str = this.cgY;
      break label52;
      str = this.cgZ;
      break label70;
      str = this.cha;
      break label88;
      str = this.index;
      break label114;
      str = this.index_name;
      break label132;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansl
 * JD-Core Version:    0.7.0.1
 */