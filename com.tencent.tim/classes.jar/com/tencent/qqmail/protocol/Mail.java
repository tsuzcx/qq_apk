package com.tencent.qqmail.protocol;

import com.tencent.qqmail.model.ConvertFromProtobuf;
import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protocol.ART.Folder;
import java.io.Serializable;

public class Mail
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String Duration;
  public boolean aborted;
  public String abstract_mail;
  public int accountId;
  @ConvertFromProtobuf(getProtoType=com.tencent.qqmail.protocol.ART.MailAttachment.class, isConvert=true)
  public MailAttachment[] attachment_set_;
  public String attachs;
  public String bcc;
  @ConvertFromProtobuf(getProtoType=com.tencent.qqmail.protocol.ART.ItemBodyStructureHelper.class, isConvert=true)
  public ItemBodyStructureHelper body_structure_helper_;
  public String cc;
  public String content;
  public double contentLength;
  public long convId;
  public int downloadType;
  public String encodeing;
  public boolean fileExist;
  public int flagStatus;
  public int folderId;
  public String folderName;
  public String folderRemoteId;
  public String fromEmail;
  public String fromIp;
  public String fromNick;
  public boolean hasAttach;
  public boolean isContentCompleted = true;
  public boolean isForward;
  public boolean isNew;
  public boolean isOutOfDate;
  public boolean isRead;
  public boolean isReply;
  public boolean isSearchMail;
  public boolean isStar;
  public String labels;
  public String location;
  public long mailAdType;
  public long mailId;
  public boolean mailReadReceipt;
  public int mailType;
  public String mail_reply_to_;
  public long meetingEndTime;
  public long meetingStartTime;
  public String messageId;
  public String original;
  public String originalText;
  protected byte[][] pb_attachment_set_;
  protected byte[] pb_body_structure_helper_;
  public boolean pushMail;
  public int receiveType;
  public double receivedUtc;
  public String references;
  public String remoteId;
  public String runTimeFolderServerName;
  public String runTimeMailServerKey;
  public double sendUtc;
  public String sender;
  public long sentBytes;
  public String serverOperationType;
  public double size;
  public String sps;
  public String subject;
  public String svrInfo;
  public String textWithTag;
  public String timezone;
  public String to;
  public int uniqueId;
  public String uploadFilePath;
  
  public static class Folder
    implements ARTConvert, Serializable
  {
    private static final long serialVersionUID = 1L;
    public int accountId;
    public int folderId;
    public int folderType;
    public boolean isTop;
    public boolean isVirtual;
    public String name;
    public int parentId;
    public String parentname;
    public int remoteFolderType;
    public String remoteId;
    public String sequence_idr;
    public String showname;
    public String showname_fromServer;
    public String svrKey;
    public String syncStatus;
    public int totalCnt;
    public int uidvalidity;
    public int unreadCnt;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (Folder)paramBaseProtoBuf;
      this.folderId = paramBaseProtoBuf.folderId;
      this.uidvalidity = paramBaseProtoBuf.uidvalidity;
      this.accountId = paramBaseProtoBuf.accountId;
      this.remoteId = paramBaseProtoBuf.remoteId;
      this.name = paramBaseProtoBuf.name;
      this.showname = paramBaseProtoBuf.showname;
      this.showname_fromServer = paramBaseProtoBuf.showname_fromServer;
      this.totalCnt = paramBaseProtoBuf.totalCnt;
      this.unreadCnt = paramBaseProtoBuf.unreadCnt;
      this.isTop = paramBaseProtoBuf.isTop;
      this.isVirtual = paramBaseProtoBuf.isVirtual;
      this.parentId = paramBaseProtoBuf.parentId;
      this.folderType = paramBaseProtoBuf.folderType;
      this.sequence_idr = paramBaseProtoBuf.sequence_idr;
      this.parentname = paramBaseProtoBuf.parentname;
      this.syncStatus = paramBaseProtoBuf.syncStatus;
      this.svrKey = paramBaseProtoBuf.svrKey;
      this.remoteFolderType = paramBaseProtoBuf.remoteFolderType;
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class RecvFolderInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public int local_mail_count_;
    public int[] mail_id_vec_;
    public int receive_count_;
    public int total_count_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.Mail
 * JD-Core Version:    0.7.0.1
 */