package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemImage
  extends AbsStructMsgElement
{
  public MessageForPic a;
  public StructMsgForImageShare a;
  public URL a;
  public long b = 0L;
  public long c = 0L;
  public long d;
  public String h = null;
  public String i;
  public String j;
  
  public StructMsgItemImage()
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = null;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = null;
    this.jdField_a_of_type_JavaNetURL = null;
    this.jdField_a_of_type_JavaLangString = "image";
  }
  
  public StructMsgItemImage(String paramString)
  {
    this();
    this.h = paramString;
  }
  
  public View a(Context paramContext, View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      localObject3 = URLDrawableHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 65537);
      if (this.jdField_a_of_type_JavaNetURL != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaNetURL.equals(localObject3)) {}
      }
      else
      {
        localObject1 = PicItemBuilder.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = new MessageForPic();
      ((MessageForPic)localObject3).path = this.h;
      ((MessageForPic)localObject3).uuid = this.i;
      ((MessageForPic)localObject3).md5 = this.j;
      ((MessageForPic)localObject3).istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
      ((MessageForPic)localObject3).msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
      ((MessageForPic)localObject3).versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
      ((MessageForPic)localObject3).uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
      ((MessageForPic)localObject3).issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
      ((MessageForPic)localObject3).selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
      ((MessageForPic)localObject3).frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
      ((MessageForPic)localObject3).groupFileID = this.b;
      ((MessageForPic)localObject3).busiType = 1030;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
        ((MessageForPic)localObject3).senderuin = ((String)localObject1);
        ((MessageForPic)localObject3).size = this.c;
        ((MessageForPic)localObject3).time = this.d;
        ((MessageForPic)localObject3).subVersion = 5;
        ((MessageForPic)localObject3).fileSizeFlag = 0;
        localObject2 = PicItemBuilder.a(paramContext, (MessageForPic)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject3);
        this.jdField_a_of_type_JavaNetURL = ((URLDrawable)localObject2).getURL();
      }
    }
    else
    {
      if ((paramView == null) || (!(paramView instanceof ChatThumbView))) {
        break label320;
      }
    }
    for (paramContext = (ChatThumbView)paramView;; paramContext = paramView)
    {
      paramContext.setImageDrawable((Drawable)localObject2);
      return paramContext;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
      break;
      label320:
      paramView = new ChatThumbView(paramContext);
      paramView.setAdjustViewBounds(true);
      float f = paramContext.getResources().getDisplayMetrics().density;
      paramView.setMaxWidth((int)(f * 100.0F + 0.5F));
      paramView.setMaxHeight((int)(f * 100.0F + 0.5F));
    }
  }
  
  public MessageForPic a()
  {
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.path = this.h;
    localMessageForPic.uuid = this.i;
    localMessageForPic.md5 = this.j;
    localMessageForPic.istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
    localMessageForPic.msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
    localMessageForPic.versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
    localMessageForPic.uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
    localMessageForPic.issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
    localMessageForPic.selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
    localMessageForPic.frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
    localMessageForPic.groupFileID = this.b;
    localMessageForPic.busiType = 1030;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;; str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin)
    {
      localMessageForPic.senderuin = str;
      localMessageForPic.size = this.c;
      localMessageForPic.time = this.d;
      localMessageForPic.subVersion = 5;
      localMessageForPic.fileSizeFlag = 0;
      return localMessageForPic;
    }
  }
  
  public String a()
  {
    return "Image";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.h = paramObjectInput.readUTF();
    this.i = paramObjectInput.readUTF();
    this.j = paramObjectInput.readUTF();
    this.b = paramObjectInput.readLong();
    this.c = paramObjectInput.readLong();
    this.d = paramObjectInput.readLong();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.h == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.i != null) {
        break label95;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.j != null) {
        break label103;
      }
    }
    label95:
    label103:
    for (String str = "";; str = this.j)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.b);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeLong(this.d);
      return;
      str = this.h;
      break;
      str = this.i;
      break label32;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "image");
    if (this.i == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uuid", str);
      if (this.j != null) {
        break label126;
      }
      str = "";
      label41:
      paramXmlSerializer.attribute(null, "md5", str);
      paramXmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.b));
      paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.c));
      if (this.h != null) {
        break label134;
      }
    }
    label134:
    for (String str = "";; str = this.h)
    {
      paramXmlSerializer.attribute(null, "local_path", str);
      paramXmlSerializer.endTag(null, "image");
      return;
      str = this.i;
      break;
      label126:
      str = this.j;
      break label41;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return true;
      String str3 = paramStructMsgNode.a("uuid");
      String str2 = paramStructMsgNode.a("md5");
      String str5 = paramStructMsgNode.a("md5");
      String str4 = paramStructMsgNode.a("filesize");
      String str1 = paramStructMsgNode.a("local_path");
      paramStructMsgNode = str3;
      if (str3 == null) {
        paramStructMsgNode = "";
      }
      this.i = paramStructMsgNode;
      if (str2 == null)
      {
        paramStructMsgNode = "";
        label67:
        this.j = paramStructMsgNode;
        if (str1 != null) {
          break label139;
        }
        paramStructMsgNode = "";
        this.h = paramStructMsgNode;
        if (str5 == null) {}
      }
      try
      {
        this.b = Long.parseLong(str5);
        if (str4 == null) {
          continue;
        }
        try
        {
          this.c = Long.parseLong(str4);
          return true;
        }
        catch (NumberFormatException paramStructMsgNode) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
        return true;
        paramStructMsgNode = str2;
        break label67;
        label139:
        paramStructMsgNode = str1;
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemImage
 * JD-Core Version:    0.7.0.1
 */