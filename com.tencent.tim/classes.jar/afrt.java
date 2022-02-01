import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class afrt
  extends afrl
{
  private boolean cay;
  public MessageRecord messageRecord;
  
  public afrt(MessageRecord paramMessageRecord)
  {
    this.messageRecord = paramMessageRecord;
  }
  
  public afmi a()
  {
    if ((this.messageRecord instanceof MessageForMarketFace)) {
      return afrn.a((MessageForMarketFace)this.messageRecord);
    }
    return null;
  }
  
  public CustomEmotionData a()
  {
    if (((this.messageRecord instanceof MessageForPic)) && (((MessageForPic)this.messageRecord).md5 != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((afhu)((QQAppInterface)localObject).getManager(149)).ez();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((MessageForPic)this.messageRecord).md5.equalsIgnoreCase(localCustomEmotionData.md5)) {
              return localCustomEmotionData;
            }
          }
        }
      }
    }
    return null;
  }
  
  public boolean a(afrl paramafrl)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramafrl instanceof afrt))
    {
      paramafrl = ((afrt)paramafrl).messageRecord;
      bool1 = bool2;
      if (paramafrl != null)
      {
        bool1 = bool2;
        if (this.messageRecord != null)
        {
          bool1 = bool2;
          if (paramafrl.shmsgseq == this.messageRecord.shmsgseq)
          {
            bool1 = bool2;
            if (paramafrl.msgUid == this.messageRecord.msgUid) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean ajO()
  {
    return this.messageRecord instanceof MessageForMarketFace;
  }
  
  public boolean ajP()
  {
    return this.cay;
  }
  
  public boolean ajQ()
  {
    if (((this.messageRecord instanceof MessageForPic)) && (((MessageForPic)this.messageRecord).picExtraData != null))
    {
      int i = ((MessageForPic)this.messageRecord).picExtraData.from;
      if ((i == 1) || (i == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean ajR()
  {
    if (((this.messageRecord instanceof MessageForPic)) && (((MessageForPic)this.messageRecord).picExtraData != null)) {
      return ((MessageForPic)this.messageRecord).picExtraData.isSelfieFace();
    }
    return false;
  }
  
  public afrl b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cur_msg_uniseq"))
    {
      QLog.d("MsgEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
      String str = paramBundle.getString("cur_msg_uin");
      int i = paramBundle.getInt("cur_msg_uin_type");
      long l = paramBundle.getLong("cur_msg_uniseq");
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface)) {
        return new afrt(((QQAppInterface)paramBundle).b().b(str, i, l));
      }
    }
    return null;
  }
  
  public void b(Bundle paramBundle, int paramInt)
  {
    super.b(paramBundle, paramInt);
    paramBundle.putString("cur_msg_uin", this.messageRecord.frienduin);
    paramBundle.putInt("cur_msg_uin_type", this.messageRecord.istroop);
    paramBundle.putLong("cur_msg_uniseq", this.messageRecord.uniseq);
  }
  
  public Drawable e(Context paramContext)
  {
    afrq localafrq = new afrq(this.messageRecord);
    paramContext = afrn.a(paramContext, localafrq);
    this.cay = localafrq.cay;
    return paramContext;
  }
  
  public long getUniqueId()
  {
    return this.messageRecord.uniseq;
  }
  
  public int t(List<afrl> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      afrl localafrl = (afrl)localIterator.next();
      if ((localafrl instanceof afrt))
      {
        MessageRecord localMessageRecord = ((afrt)localafrl).messageRecord;
        if (localMessageRecord.uniseq == this.messageRecord.uniseq) {
          if (((localMessageRecord instanceof MessageForPic)) && ((this.messageRecord instanceof MessageForPic)) && (((MessageForPic)localMessageRecord).md5 != null))
          {
            if (((MessageForPic)localMessageRecord).md5.equals(((MessageForPic)this.messageRecord).md5)) {
              return paramList.indexOf(localafrl);
            }
          }
          else {
            return paramList.indexOf(localafrl);
          }
        }
      }
    }
    return paramList.size() - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrt
 * JD-Core Version:    0.7.0.1
 */