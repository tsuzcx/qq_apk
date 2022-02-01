package com.tencent.qqmail.activity.media;

import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ImageAttachData
{
  public static final List<MediaItemInfo> imageInfoList = new ArrayList();
  
  public static void clear()
  {
    imageInfoList.clear();
  }
  
  private static String getDownloadUrl(Attach paramAttach)
  {
    Object localObject2 = paramAttach.getPreview().getDownloadUrl();
    if (localObject2 == null) {
      localObject1 = "";
    }
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (!((String)localObject2).contains("groupattachment"));
    Object localObject1 = ((String)localObject2).split("\\?");
    localObject1 = localObject1[(localObject1.length - 1)].replaceAll("\\{", "%7B").replaceAll("\\}", "%7D");
    localObject2 = localObject1;
    if (!"groupattachment".equals("viewcompress"))
    {
      localObject2 = localObject1;
      if (!"groupattachment".equals("attdownload"))
      {
        String[] arrayOfString = ((String)localObject1).split("&");
        localObject2 = localObject1;
        if (arrayOfString.length > 0)
        {
          localObject2 = localObject1;
          if (((String)localObject1).contains("&filename="))
          {
            localObject1 = "";
            int i = 0;
            localObject2 = localObject1;
            if (i < arrayOfString.length - 1)
            {
              if (i == arrayOfString.length - 1) {}
              for (localObject1 = (String)localObject1 + arrayOfString[i];; localObject1 = (String)localObject1 + arrayOfString[i] + "&")
              {
                i += 1;
                break;
              }
            }
          }
        }
      }
    }
    return QMNetworkConfig.getCgiRequestHost(paramAttach.getAccountId()) + "/cgi-bin/" + "groupattachment" + "?" + (String)localObject2;
  }
  
  public static List<MediaItemInfo> getImageInfoList()
  {
    return imageInfoList;
  }
  
  public static MediaItemInfo getItem(int paramInt)
  {
    return (MediaItemInfo)imageInfoList.get(paramInt);
  }
  
  public static void loadData(List<Attach> paramList)
  {
    if (paramList == null) {
      return;
    }
    clear();
    paramList = paramList.iterator();
    label15:
    Attach localAttach;
    MediaItemInfo localMediaItemInfo;
    if (paramList.hasNext())
    {
      localAttach = (Attach)paramList.next();
      localMediaItemInfo = new MediaItemInfo();
      localMediaItemInfo.setMailId(localAttach.getBelongMailId());
      localMediaItemInfo.setFileName(localAttach.getName());
      localMediaItemInfo.setFileSize(StringExtention.sizeStrToLong(localAttach.getSize()));
      localMediaItemInfo.setDataPath(getDownloadUrl(localAttach));
      localMediaItemInfo.setSourcePath(localAttach.getPreview().getMyDisk());
      localMediaItemInfo.setAttach(localAttach);
      localMediaItemInfo.setAccountId(localAttach.getAccountId());
      if (!localAttach.isProtocol()) {
        break label140;
      }
      localMediaItemInfo.setImageType(4);
      QMMailManager.sharedInstance().readMailInfo(localMediaItemInfo.getMailId()).getInformation();
    }
    for (;;)
    {
      imageInfoList.add(localMediaItemInfo);
      break label15;
      break;
      label140:
      if (localAttach.isBigAttach()) {
        localMediaItemInfo.setImageType(3);
      } else {
        localMediaItemInfo.setImageType(2);
      }
    }
  }
  
  public static void loadData(List<Attach> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {
      return;
    }
    clear();
    paramList = paramList.iterator();
    label15:
    Attach localAttach;
    MediaItemInfo localMediaItemInfo;
    if (paramList.hasNext())
    {
      localAttach = (Attach)paramList.next();
      localMediaItemInfo = new MediaItemInfo();
      localMediaItemInfo.setMailId(localAttach.getBelongMailId());
      localMediaItemInfo.setFileName(localAttach.getName());
      localMediaItemInfo.setFileSize(StringExtention.sizeStrToLong(localAttach.getSize()));
      localMediaItemInfo.setDataPath(getDownloadUrl(localAttach));
      localMediaItemInfo.setAttach(localAttach);
      localMediaItemInfo.setAccountId(localAttach.getAccountId());
      if (!(localAttach instanceof MailBigAttach)) {
        break label168;
      }
      localMediaItemInfo.setImageType(3);
      if (StringExtention.isNullOrEmpty(((MailBigAttach)localAttach).getFid())) {
        break label149;
      }
      localMediaItemInfo.setSourcePath(localAttach.getPreview().getMyDisk());
    }
    for (;;)
    {
      imageInfoList.add(localMediaItemInfo);
      break label15;
      break;
      label149:
      localMediaItemInfo.setSourcePath(QMAttachManager.sharedInstance().getAttachMyDisk(localAttach.getHashId(), 1));
      continue;
      label168:
      if ((paramBoolean1) || (localAttach.isProtocol()))
      {
        localMediaItemInfo.setImageType(4);
        localMediaItemInfo.setSourcePath(QMAttachManager.sharedInstance().getAttachMyDisk(localAttach.getHashId(), 0));
      }
      else if (paramBoolean2)
      {
        localMediaItemInfo.setImageType(2);
        localMediaItemInfo.setSourcePath(localAttach.getPreview().getMyDisk());
      }
      else
      {
        localMediaItemInfo.setImageType(2);
        localMediaItemInfo.setSourcePath(QMAttachManager.sharedInstance().getAttachMyDisk(localAttach.getHashId(), 0));
      }
    }
  }
  
  public static int loadDataForCompose(ArrayList<AttachInfo> paramArrayList, AttachInfo paramAttachInfo)
  {
    int j = 0;
    int i = j;
    AttachInfo localAttachInfo;
    MediaItemInfo localMediaItemInfo;
    label71:
    Attach localAttach;
    if (paramArrayList != null)
    {
      i = j;
      if (paramArrayList.size() > 0)
      {
        clear();
        j = 0;
        i = 0;
        if (j < paramArrayList.size())
        {
          localAttachInfo = (AttachInfo)paramArrayList.get(j);
          localMediaItemInfo = new MediaItemInfo();
          localMediaItemInfo.setId(j);
          if (localAttachInfo.isBigAttach())
          {
            localMediaItemInfo.setImageType(3);
            if (localAttachInfo.getAttach() == null) {
              break label224;
            }
            localAttach = (Attach)localAttachInfo.getAttach();
            localMediaItemInfo.setAccountId(localAttach.getAccountId());
            localMediaItemInfo.setAttach(localAttach);
            localMediaItemInfo.setMailId(localAttach.getBelongMailId());
            localMediaItemInfo.setSourcePath(localAttach.getPreview().getMyDisk());
            localMediaItemInfo.setDataPath(localAttach.getPreview().getDownloadUrl());
            label142:
            localMediaItemInfo.setFileName(localAttachInfo.getAttachName());
            localMediaItemInfo.setFileSize(StringExtention.sizeStrToLong(localAttachInfo.getAttachSize()));
            localMediaItemInfo.setBucketName("");
            if (localAttachInfo != paramAttachInfo) {
              break label298;
            }
            i = j;
          }
        }
      }
    }
    label298:
    for (;;)
    {
      imageInfoList.add(localMediaItemInfo);
      j += 1;
      break;
      if (localAttachInfo.isProtocolAttach())
      {
        localMediaItemInfo.setImageType(4);
        break label71;
      }
      localMediaItemInfo.setImageType(2);
      break label71;
      label224:
      localAttach = new Attach();
      localAttach.getPreview().setMyDisk(localAttachInfo.getAttachPath());
      localAttach.setHashId(Attach.generateHashId(0L, localAttachInfo.getAttachSize(), localAttachInfo.getAttachPath()));
      localMediaItemInfo.setAttach(localAttach);
      localMediaItemInfo.setSourcePath(localAttachInfo.getAttachPath());
      localMediaItemInfo.setDataPath(localAttachInfo.getAttachPath());
      break label142;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachData
 * JD-Core Version:    0.7.0.1
 */