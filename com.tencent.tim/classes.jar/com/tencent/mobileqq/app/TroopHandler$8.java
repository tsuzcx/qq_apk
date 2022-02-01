package com.tencent.mobileqq.app;

import anqy;
import com.tencent.mobileqq.structmsg.AbsStructMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class TroopHandler$8
  extends StructMsgForGeneralShare
{
  public void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    AbsStructMsg.a locala = new AbsStructMsg.a(this, new anqy());
    try
    {
      locala.setOutput(paramByteArrayOutputStream, paramString);
      locala.startDocument(paramString, null);
      locala.startTag(null, "msg");
      locala.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      locala.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {}
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mMsgBrief)
      {
        locala.attribute(null, "brief", paramByteArrayOutputStream);
        toContentXml(locala);
        locala.startTag(null, "source");
        locala.endTag(null, "source");
        locala.endTag(null, "msg");
        locala.endDocument();
        locala.flush();
        return;
      }
      return;
    }
    catch (Exception paramByteArrayOutputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.8
 * JD-Core Version:    0.7.0.1
 */