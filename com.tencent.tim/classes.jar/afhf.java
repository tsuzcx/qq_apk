import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.4;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class afhf
  implements akyf, Handler.Callback
{
  StructMsgForImageShare b;
  CustomEmotionData c;
  private WeakReference<afhf.a> fD;
  Handler handler;
  QQAppInterface mApp;
  Context mContext;
  int mSource;
  
  public afhf(QQAppInterface paramQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, StructMsgForImageShare paramStructMsgForImageShare, int paramInt)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.c = paramCustomEmotionData;
    this.b = paramStructMsgForImageShare;
    this.mSource = paramInt;
    this.handler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void Mt(int paramInt)
  {
    if (400010 == paramInt) {
      this.handler.sendEmptyMessage(1);
    }
    while (400011 != paramInt) {
      return;
    }
    this.handler.sendEmptyMessage(2);
  }
  
  private void Mu(int paramInt)
  {
    afhf.a locala;
    if (this.fD != null)
    {
      locala = (afhf.a)this.fD.get();
      if (locala != null)
      {
        if (400010 != paramInt) {
          break label43;
        }
        locala.ck(2, this.c.md5);
      }
    }
    return;
    label43:
    if (400011 == paramInt)
    {
      locala.ck(3, this.c.md5);
      return;
    }
    locala.ck(paramInt, this.c.md5);
  }
  
  private void Mv(int paramInt)
  {
    if ((400010 == paramInt) || (400011 == paramInt)) {
      ThreadManager.getFileThreadHandler().post(new EmoAddedAuthCallback.4(this));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    if (paramInt == 1)
    {
      new afhi(paramQQAppInterface, paramContext);
      if ((paramContext instanceof BaseActivity))
      {
        if (!((BaseActivity)paramContext).isFinishing()) {
          FavEmosmManageActivity.dd(paramContext);
        }
        ajdg.ew("2007", 1);
      }
    }
    while (paramInt != 2) {
      for (;;)
      {
        return;
        QQToast.a(paramContext, paramContext.getString(2131689841), 0).show(2131299627);
      }
    }
    QQToast.a(paramContext, paramContext.getString(2131689841), 0).show(2131299627);
    ajdg.ew("2007", 1);
  }
  
  private void cZx()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result success");
    }
    Object localObject;
    if (this.mSource == 0)
    {
      if ((!this.c.isMarkFace) && (TextUtils.isEmpty(this.c.md5)))
      {
        localObject = MD5.getFileMd5(this.c.emoPath);
        this.c.md5 = HexUtil.bytes2HexStr((byte[])localObject);
        localObject = this.mApp.a().createEntityManager();
        if (localObject != null)
        {
          ((EntityManager)localObject).update(this.c);
          ((EntityManager)localObject).close();
        }
      }
      ((afhu)this.mApp.getManager(149)).c(this.c);
      if (this.b != null) {
        xtm.b(this.mApp, this.b, this.c);
      }
      this.handler.sendEmptyMessage(3);
      localObject = this.mApp.getHandler(ChatActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
    }
    label168:
    do
    {
      do
      {
        do
        {
          break label168;
          do
          {
            return;
          } while (1 == this.mSource);
          if (2 != this.mSource) {
            break;
          }
          ((afhu)this.mApp.getManager(149)).c(this.c);
        } while ((2 != this.mSource) || (this.fD == null));
        localObject = (afhf.a)this.fD.get();
      } while (localObject == null);
      ((afhf.a)localObject).ck(0, this.c.md5);
      return;
    } while (3 != this.mSource);
    ((afhu)this.mApp.getManager(149)).c(this.c);
    this.handler.sendEmptyMessage(3);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(afhf.a parama)
  {
    this.fD = new WeakReference(parama);
  }
  
  public void a(akyf.a parama) {}
  
  public void b(akyf.a parama)
  {
    int i = parama.result;
    if (i == 0) {
      cZx();
    }
    do
    {
      do
      {
        return;
      } while (-1 != i);
      i = parama.errCode;
      Mv(i);
      if (QLog.isColorLevel()) {
        QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result errCode=" + i);
      }
      if (this.mSource == 0)
      {
        Mt(i);
        return;
      }
      if (2 == this.mSource)
      {
        Mu(i);
        return;
      }
    } while (3 != this.mSource);
    Mt(i);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
    case 2: 
      a(this.mApp, this.mContext, paramMessage.what);
      return true;
    }
    if (this.mContext != null)
    {
      QQToast.a(this.mContext, 2131689838, 0).show(2131299627);
      if ((this.c != null) && (this.c.isMarkFace)) {
        yhf.a(this.mApp).cir();
      }
    }
    ajdg.ew("0", 1);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void ck(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhf
 * JD-Core Version:    0.7.0.1
 */