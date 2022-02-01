import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Set;

public class akwt
  extends akws
{
  private static final Set<Integer> cI = new HashSet();
  protected int mBusiType;
  
  static
  {
    cI.add(Integer.valueOf(1042));
    cI.add(Integer.valueOf(5));
    cI.add(Integer.valueOf(1030));
    cI.add(Integer.valueOf(1047));
    cI.add(Integer.valueOf(1044));
    cI.add(Integer.valueOf(1049));
  }
  
  public akwt(int paramInt)
  {
    this.mBusiType = paramInt;
  }
  
  public akwt(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.mBusiType = paramInt;
  }
  
  public static akwt.a a(MessageRecord paramMessageRecord, aool paramaool)
  {
    if (cI.contains(Integer.valueOf(paramaool.mBusiType))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        paramaool = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!paramaool.equals("")))
        {
          akwt.a locala = new akwt.a();
          locala.bUA = paramaool;
          locala.aex = l;
          locala.bRh = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return locala;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, akwt.a parama)
  {
    if ((parama != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", parama.bUA);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(parama.aex));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", parama.bRh);
    }
  }
  
  public akxy a(Intent paramIntent)
  {
    akxy localakxy = super.a(paramIntent);
    if ((paramIntent != null) && (localakxy != null))
    {
      akwt.a locala = new akwt.a();
      locala.bUA = paramIntent.getStringExtra("quick_send_original_md5");
      locala.aex = paramIntent.getLongExtra("quick_send_original_size", 0L);
      locala.bRh = paramIntent.getStringExtra("quick_send_thumb_md5");
      localakxy.a = locala;
      localakxy.from = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localakxy.source = paramIntent.getStringExtra("key_emotion_source_info");
      localakxy.webUrl = paramIntent.getStringExtra("key_emotion_source_weburl");
      localakxy.iconUrl = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localakxy.packageName = paramIntent.getStringExtra("key_emotion_source_packagename");
      localakxy.dpN = paramIntent.getIntExtra("key_emotion_source_epid", 0);
    }
    return localakxy;
  }
  
  protected void a(MessageForPic paramMessageForPic, akxy paramakxy)
  {
    super.a(paramMessageForPic, paramakxy);
    a(paramMessageForPic, paramakxy.a);
    paramakxy = paramMessageForPic.picExtraData;
    if (paramakxy == null) {
      paramakxy = new PicMessageExtraData();
    }
    for (;;)
    {
      if (this.mBusiType == 1042)
      {
        paramakxy.imageBizType = 2;
        paramakxy.textSummary = this.mApp.getApp().getString(2131692307);
        paramMessageForPic.picExtraData = paramakxy;
      }
      Object localObject;
      do
      {
        do
        {
          return;
          if (this.mBusiType == 1047)
          {
            paramakxy.imageBizType = 7;
            localObject = yhf.a(this.mApp).getCurrentText();
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramakxy.textSummary = ("[" + (String)localObject + "]");
            }
            paramMessageForPic.picExtraData = paramakxy;
            return;
          }
          if (this.mBusiType == 1044)
          {
            paramakxy.imageBizType = 3;
            paramakxy.textSummary = BaseApplicationImpl.getApplication().getString(2131692307);
            paramMessageForPic.picExtraData = paramakxy;
            return;
          }
        } while (this.mBusiType != 1049);
        paramakxy.imageBizType = 4;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localObject instanceof AppInterface)) {
          break;
        }
        localObject = ykm.a((AppInterface)localObject).getCurrentText();
      } while (TextUtils.isEmpty((CharSequence)localObject));
      paramakxy.textSummary = ("[" + (String)localObject + "]");
      paramMessageForPic.picExtraData = paramakxy;
      return;
    }
  }
  
  protected void o(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.o(paramMessageForPic);
  }
  
  public static class a
  {
    public long aex;
    public String bRh;
    public String bUA;
    public boolean cuK;
    
    public String toString()
    {
      return "QuickSendObject{mOriginMD5='" + this.bUA + '\'' + ", mOriginSize=" + this.aex + ", mThumbMD5='" + this.bRh + '\'' + ", mQuickSendFailed=" + this.cuK + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwt
 * JD-Core Version:    0.7.0.1
 */