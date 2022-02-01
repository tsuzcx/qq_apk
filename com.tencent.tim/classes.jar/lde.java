import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class lde
  extends lcs
{
  private static final String[] bn = { "https://pub.idqqimg.com/pc/misc/files/20200416/3c376048a60b488d998e1ef31153db5e.png", "https://pub.idqqimg.com/pc/misc/files/20200416/54aaad879a4042899540fafd969395f6.png", "https://pub.idqqimg.com/pc/misc/files/20200416/8b787675714740eeb21c7fc5b15712c0.png", "https://pub.idqqimg.com/pc/misc/files/20200416/1263e35cec174f0db53e0fc3bb8e7df2.png", "https://pub.idqqimg.com/pc/misc/files/20200430/21b88f2ba3bd43919173a767982d649d.png", "https://pub.idqqimg.com/pc/misc/files/20200430/eb40275894c9455f9ab438dd91081678.png" };
  private Activity activity;
  private boolean needShow;
  
  public lde(@NonNull lct paramlct, Activity paramActivity)
  {
    super(paramlct, "RIJUGCAccountPopupStep");
    this.activity = paramActivity;
    aiH();
  }
  
  private boolean BQ()
  {
    boolean bool2 = anwa.aze();
    boolean bool3 = mix.DH();
    boolean bool4 = lvy.a().dP("ugc_add_account");
    if ((!bool2) && (bool3) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
        QLog.i("RIJUGCAccountPopupStep", 2, "[handleUGCAccountCreate], isStudyMode = " + bool2 + "isPopupEnable = " + bool3 + ", isPtsLiteEnable = " + bool4);
      }
      if (bool1)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.b.startForResult(this.activity, localIntent, PublicTransFragmentActivity.class, RIJUGCAddAccountFragment.class, 10000);
      }
      return bool1;
    }
  }
  
  private void aiH()
  {
    if (!mix.DH()) {
      return;
    }
    String[] arrayOfString = bn;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        localObject1 = new URL((String)localObject1);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
          QLog.i("RIJUGCAccountPopupStep", 2, "[preloadResources] url = " + localObject1);
        }
        if (localObject1 != null)
        {
          noz localnoz = new noz();
          localnoz.url = ((URL)localObject1);
          noy.a().a(localnoz, null);
        }
        i += 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.i("RIJUGCAccountPopupStep", 1, "[preloadResources] error, e = " + localMalformedURLException);
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static void preload()
  {
    if (!mix.DH()) {
      return;
    }
    ReadInJoyUserInfoModule.a(kxm.getLongAccountUin(), null);
    String[] arrayOfString = bn;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        localObject1 = new URL((String)localObject1);
        if (localObject1 != null)
        {
          noz localnoz = new noz();
          localnoz.url = ((URL)localObject1);
          localnoz.isPreload = true;
          noy.a().a(localnoz, null);
          if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
            QLog.i("RIJUGCAccountPopupStep", 2, "[preload] url = " + localObject1);
          }
        }
        i += 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("RIJUGCAccountPopupStep", 1, "[preload] error, e = " + localMalformedURLException);
          Object localObject2 = null;
        }
      }
    }
  }
  
  protected void aKn()
  {
    nn(this.needShow);
  }
  
  protected void aKo()
  {
    this.needShow = BQ();
    nn(this.needShow);
    QLog.i("RIJUGCAccountPopupStep", 1, "[doStepFromOnShowSelf], needShow = " + this.needShow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lde
 * JD-Core Version:    0.7.0.1
 */