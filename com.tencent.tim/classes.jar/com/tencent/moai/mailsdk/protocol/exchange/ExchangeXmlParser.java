package com.tencent.moai.mailsdk.protocol.exchange;

import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Contact;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeItem;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ExchangeXmlParser
{
  public static Attachment getAttachment(Node paramNode)
  {
    if (paramNode == null) {
      return null;
    }
    Attachment localAttachment = new Attachment();
    Object localObject = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "AttachmentId");
    if (localObject != null)
    {
      localObject = ((Node)localObject).getAttributes();
      if (localObject != null)
      {
        localObject = ((NamedNodeMap)localObject).getNamedItem("Id");
        if (localObject == null) {
          break label160;
        }
        localObject = ((Node)localObject).getTextContent();
        localAttachment.setFid((String)localObject);
      }
    }
    localObject = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "ContentId");
    if (localObject != null)
    {
      localObject = ((Node)localObject).getTextContent();
      label79:
      localAttachment.setCid((String)localObject);
      localObject = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Name");
      if (localObject == null) {
        break label172;
      }
      localObject = ((Node)localObject).getTextContent();
      label102:
      localAttachment.setName((String)localObject);
      localAttachment.setSize(XmlDocumentHelper.getLongContent(XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Size")));
      XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Content");
      paramNode = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "IsInline");
      if ((paramNode == null) || (!"true".equalsIgnoreCase(paramNode.getTextContent()))) {
        break label178;
      }
      localAttachment.setType("inline");
    }
    for (;;)
    {
      return localAttachment;
      label160:
      localObject = "";
      break;
      localObject = "";
      break label79;
      label172:
      localObject = "";
      break label102;
      label178:
      localAttachment.setType("attachment");
    }
  }
  
  public static ArrayList<Attachment> getAttachments(Node paramNode)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramNode == null) {
      return localArrayList;
    }
    paramNode = XmlDocumentHelper.getChildNodesByLocalName(paramNode, "FileAttachment");
    if (paramNode != null)
    {
      paramNode = paramNode.iterator();
      while (paramNode.hasNext())
      {
        Attachment localAttachment = getAttachment((Node)paramNode.next());
        if (localAttachment != null) {
          localArrayList.add(localAttachment);
        }
      }
    }
    return localArrayList;
  }
  
  public static Contact getContact(Node paramNode)
  {
    if (paramNode == null) {
      return null;
    }
    Node localNode = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Name");
    paramNode = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "EmailAddress");
    Contact localContact = new Contact();
    if (paramNode == null)
    {
      paramNode = "";
      localContact.setEmail(paramNode);
      if (localNode != null) {
        break label64;
      }
    }
    label64:
    for (paramNode = "";; paramNode = localNode.getTextContent())
    {
      localContact.setNick(paramNode);
      return localContact;
      paramNode = paramNode.getTextContent();
      break;
    }
  }
  
  public static long getDateTimeSent(Node paramNode)
  {
    paramNode = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "DateTimeSent");
    if (paramNode == null) {
      return 0L;
    }
    return getTimeInSeconds(paramNode.getTextContent());
  }
  
  public static Folder getFolder(Node paramNode)
  {
    if (paramNode == null)
    {
      paramNode = null;
      return paramNode;
    }
    Folder localFolder = new Folder();
    Object localObject = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "FolderId");
    if (localObject != null)
    {
      localObject = ((Node)localObject).getAttributes();
      if (localObject != null)
      {
        localFolder.setRemoteId(((NamedNodeMap)localObject).getNamedItem("Id").getNodeValue());
        localFolder.setSvrKey(((NamedNodeMap)localObject).getNamedItem("ChangeKey").getNodeValue());
      }
    }
    localObject = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "ParentFolderId");
    if (localObject != null)
    {
      localObject = ((Node)localObject).getAttributes();
      if (localObject != null)
      {
        localFolder.setParentId(((NamedNodeMap)localObject).getNamedItem("Id").getNodeValue());
        ((NamedNodeMap)localObject).getNamedItem("ChangeKey").getNodeValue();
      }
    }
    localObject = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "FolderClass");
    if (localObject != null) {
      if ("IPF.Note".equals(((Node)localObject).getTextContent())) {
        localFolder.setType(6);
      }
    }
    for (;;)
    {
      localObject = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "DisplayName");
      if (localObject != null) {
        localFolder.setName(((Node)localObject).getTextContent());
      }
      localObject = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "TotalCount");
      paramNode = localFolder;
      if (localObject == null) {
        break;
      }
      localFolder.setTotalCount(XmlDocumentHelper.getIntContent((Node)localObject));
      return localFolder;
      localFolder.setType(6);
    }
  }
  
  public static ExchangeItem getItemId(Node paramNode)
  {
    if (paramNode == null) {}
    do
    {
      do
      {
        return null;
        paramNode = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "ItemId");
      } while (paramNode == null);
      paramNode = paramNode.getAttributes();
    } while (paramNode == null);
    ExchangeItem localExchangeItem = new ExchangeItem();
    localExchangeItem.setId(paramNode.getNamedItem("Id").getNodeValue());
    localExchangeItem.setChangeKey(paramNode.getNamedItem("ChangeKey").getNodeValue());
    return localExchangeItem;
  }
  
  public static Mail getMail(Node paramNode)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    if (paramNode == null) {
      return null;
    }
    Mail localMail = new Mail();
    Object localObject1 = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "ItemId");
    if (localObject1 != null)
    {
      localObject1 = ((Node)localObject1).getAttributes();
      if (localObject1 != null)
      {
        localMail.setRemoteId(((NamedNodeMap)localObject1).getNamedItem("Id").getNodeValue());
        localMail.setSvrKey(((NamedNodeMap)localObject1).getNamedItem("ChangeKey").getNodeValue());
      }
    }
    localObject1 = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Subject");
    label120:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((Node)localObject1).getTextContent();
      localMail.setSubject((String)localObject1);
      localObject1 = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Body");
      if (localObject1 == null) {
        break label309;
      }
      localObject1 = ((Node)localObject1).getTextContent();
      localMail.setPlainContent((String)localObject1);
      localMail.setHtmlContent((String)localObject1);
      localMail.setSize(XmlDocumentHelper.getLongContent(XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Size")));
      localObject3 = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "DateTimeSent");
      if (localObject3 != null) {
        break label315;
      }
      label159:
      if (localObject2 != null) {
        localMail.setUtc(getTimeInSeconds((String)localObject2));
      }
      localObject2 = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "HasAttachments");
      if ((localObject2 == null) || (!"true".equals(((Node)localObject2).getTextContent()))) {
        break label327;
      }
    }
    label309:
    label315:
    label327:
    for (boolean bool1 = true;; bool1 = false)
    {
      localMail.setHasAttach(bool1);
      localObject2 = getAttachments(XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Attachments"));
      localObject3 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Attachment localAttachment = (Attachment)((Iterator)localObject3).next();
        if (("attachment".equals(localAttachment.getType())) && (((String)localObject1).contains("cid:" + localAttachment.getCid()))) {
          localAttachment.setType("inline");
        }
      }
      localObject1 = "";
      break;
      localObject1 = "";
      break label120;
      localObject2 = ((Node)localObject3).getTextContent();
      break label159;
    }
    localMail.setAttachments((ArrayList)localObject2);
    XmlDocumentHelper.getChildNodeByLocalName(paramNode, "DateTimeCreated");
    XmlDocumentHelper.getChildNodeByLocalName(paramNode, "IsAssociated");
    XmlDocumentHelper.getChildNodeByLocalName(paramNode, "DisplayTo");
    XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Importance");
    localObject1 = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "IsRead");
    bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if ("true".equalsIgnoreCase(((Node)localObject1).getTextContent())) {
        bool1 = true;
      }
    }
    localMail.setIsRead(bool1);
    localObject1 = getContact(XmlDocumentHelper.getChildNodeByLocalName(XmlDocumentHelper.getChildNodeByLocalName(paramNode, "From"), "Mailbox"));
    if (localObject1 != null) {
      localMail.setFrom((Contact)localObject1);
    }
    localObject1 = getContact(XmlDocumentHelper.getChildNodeByLocalName(XmlDocumentHelper.getChildNodeByLocalName(paramNode, "Sender"), "Mailbox"));
    if (localObject1 != null) {
      localMail.setSender((Contact)localObject1);
    }
    localObject1 = getContact(XmlDocumentHelper.getChildNodeByLocalName(XmlDocumentHelper.getChildNodeByLocalName(paramNode, "ReplyTo"), "Mailbox"));
    if (localObject1 != null) {
      localMail.setReplyTo((Contact)localObject1);
    }
    localObject2 = XmlDocumentHelper.getChildNodesByLocalName(XmlDocumentHelper.getChildNodeByLocalName(paramNode, "ToRecipients"), "Mailbox");
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = getContact((Node)((Iterator)localObject2).next());
        if (localObject3 != null) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localMail.setTo((ArrayList)localObject1);
    }
    localObject2 = XmlDocumentHelper.getChildNodesByLocalName(XmlDocumentHelper.getChildNodeByLocalName(paramNode, "CcRecipients"), "Mailbox");
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = getContact((Node)((Iterator)localObject2).next());
        if (localObject3 != null) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localMail.setCc((ArrayList)localObject1);
    }
    localObject2 = XmlDocumentHelper.getChildNodesByLocalName(XmlDocumentHelper.getChildNodeByLocalName(paramNode, "BccRecipients"), "Mailbox");
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = getContact((Node)((Iterator)localObject2).next());
        if (localObject3 != null) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localMail.setBcc((ArrayList)localObject1);
    }
    localObject1 = XmlDocumentHelper.getChildNodeByLocalName(paramNode, "ExtendedProperty");
    paramNode = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "ExtendedFieldURI");
    localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Value");
    if ((paramNode != null) && (localObject1 != null))
    {
      paramNode = paramNode.getAttributes();
      localObject1 = ((Node)localObject1).getTextContent();
      if ((paramNode != null) && (localObject1 != null))
      {
        paramNode = paramNode.getNamedItem("PropertyTag").getNodeValue();
        if (!"0x1090".equalsIgnoreCase(paramNode)) {
          break label821;
        }
        localMail.setIsStar(true);
      }
    }
    for (;;)
    {
      return localMail;
      label821:
      if ("0x1095".equalsIgnoreCase(paramNode)) {
        localMail.setIsStar(true);
      }
    }
  }
  
  public static long getTimeInSeconds(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (Exception localException)
    {
      Logger.log(6, "MailParser", "parse time error " + paramString + " " + localException.getMessage());
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.ExchangeXmlParser
 * JD-Core Version:    0.7.0.1
 */