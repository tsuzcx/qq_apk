import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLoadDelegate;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class msk
  implements aahb.b
{
  @Nullable
  private aahb.d jdField_a_of_type_Aahb$d;
  @NonNull
  private final PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  String aid;
  boolean anF;
  String md5;
  @NonNull
  private final WeakReference<QQAppInterface> n;
  String puin;
  String vid;
  
  public msk(@NonNull PendingIntent paramPendingIntent, @NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppPendingIntent = paramPendingIntent;
    this.n = new WeakReference(paramQQAppInterface);
    this.puin = paramString1;
    this.aid = paramString2;
    this.vid = paramString3;
    this.md5 = paramString4;
    this.anF = paramBoolean;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, PendingIntent paramPendingIntent, String paramString1, String paramString2)
  {
    int i = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((paramPendingIntent == null) || (i < 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("ReadInjoyVideoInteract", 1, "invalid intent extra from ReadinjoyVideo, " + paramString1 + " / " + paramString2 + " / " + paramPendingIntent + " / " + i);
      return;
    }
    String str1 = paramIntent.getStringExtra("banner_readinjoy_puin");
    String str2 = paramIntent.getStringExtra("banner_readinjoy_vid");
    String str3 = paramIntent.getStringExtra("banner_readinjoy_md5");
    paramIntent = new msk(paramPendingIntent, paramQQAppInterface, str1, paramIntent.getStringExtra("banner_readinjoy_article_id"), str2, str3, paramIntent.getBooleanExtra("banner_readinjoy_is_weishi_mode", false));
    paramQQAppInterface = aahb.a(paramQQAppInterface, i, paramString1, paramString2, paramIntent);
    paramIntent.onExposure();
    paramIntent.a(paramQQAppInterface);
  }
  
  private void lO(String paramString)
  {
    nce.a locala;
    QQAppInterface localQQAppInterface;
    String str2;
    if (this.n.get() != null)
    {
      locala = new nce.a(this.md5, this.puin, this.vid, this.aid);
      locala.h(this.aid);
      localQQAppInterface = (QQAppInterface)this.n.get();
      str2 = this.puin;
      if (!this.anF) {
        break label96;
      }
    }
    label96:
    for (String str1 = "1";; str1 = "0")
    {
      kbp.a(localQQAppInterface, str2, paramString, paramString, 0, 0, str1, "", "", locala.a().toJsonString(), false);
      return;
    }
  }
  
  public void a(@Nullable aahb.d paramd)
  {
    this.jdField_a_of_type_Aahb$d = paramd;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_Aahb$d == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.n.get();
    } while (localQQAppInterface == null);
    aahb.a(localQQAppInterface, this.jdField_a_of_type_Aahb$d);
    VideoFeedsLoadDelegate.a(this.jdField_a_of_type_AndroidAppPendingIntent);
    lO("0X80097FA");
  }
  
  public void onEnter()
  {
    if (this.jdField_a_of_type_Aahb$d == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.n.get();
    } while (localQQAppInterface == null);
    try
    {
      this.jdField_a_of_type_AndroidAppPendingIntent.send();
      aahb.a(localQQAppInterface, this.jdField_a_of_type_Aahb$d);
      lO("0X80097F9");
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;)
      {
        QLog.e("ReadInjoyVideoInteract", 1, "send pending intent fail with " + this.jdField_a_of_type_AndroidAppPendingIntent + "\r\n" + localCanceledException);
      }
    }
  }
  
  public void onExposure()
  {
    lO("0X80097F8");
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msk
 * JD-Core Version:    0.7.0.1
 */