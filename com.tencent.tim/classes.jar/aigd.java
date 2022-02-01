import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.2;
import com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.3;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class aigd
{
  public aifc a;
  ActionCallback a;
  private aifl.a b;
  long lastTimeStamp = 0L;
  QQAppInterface mApp;
  
  public aigd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceActionCallback = new aigf(this);
    this.jdField_a_of_type_Aifc = aigi.a().a();
    this.mApp = paramQQAppInterface;
  }
  
  private void cO(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("coverurl");
    String str1 = "";
    Object localObject2 = str1;
    if (!TextUtils.isEmpty(str2))
    {
      localObject2 = aoiz.getFile(str2);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = aoiz.getFile(str2 + "?busiType=3");
      }
      localObject2 = str1;
      if (localObject1 != null) {
        localObject2 = ((File)localObject1).getAbsolutePath();
      }
    }
    paramBundle.putString("cover_file", (String)localObject2);
    paramBundle.putString("appid", "2");
    paramBundle.putString("uid", this.mApp.getCurrentUin());
    paramBundle.putString("hostVersion", String.valueOf(aewh.getVersionCode(BaseApplicationImpl.getContext())));
    Object localObject1 = Uri.parse(paramBundle.getString("mqqScheme", "")).getQuery();
    NowLive.doActionWithExtra((String)localObject1 + "&action=openroom", paramBundle, this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceActionCallback);
  }
  
  private boolean mX(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.startsWith("//"));
  }
  
  public void a(Bundle paramBundle, aifl.a parama)
  {
    this.b = parama;
    parama = paramBundle.getString("mqqUrl", "");
    long l = System.currentTimeMillis();
    if ((l - this.lastTimeStamp < 1000L) && (!aiff.h(paramBundle).equals("1")))
    {
      QLog.i("DynamicNow | NowEntry", 1, "开始处理mqq　scheme,time = " + System.currentTimeMillis() + " 点太快了");
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131709197), 0).show();
      return;
    }
    this.lastTimeStamp = l;
    QLog.i("DynamicNow | NowEntry", 1, "开始进入now结合版,time = " + System.currentTimeMillis() + " mqqScheme = " + parama);
    paramBundle.putInt("action", 1);
    cN(paramBundle);
  }
  
  public void cL(Bundle paramBundle)
  {
    a(paramBundle, null);
  }
  
  public void cN(Bundle paramBundle)
  {
    Object localObject1 = aiff.f(paramBundle);
    Object localObject2 = aiff.g(paramBundle);
    long l = aiff.c(paramBundle);
    this.jdField_a_of_type_Aifc.a(false, (String)localObject2, String.valueOf(l), (String)localObject1, false, false, true);
    paramBundle.putLong("entryTime", System.currentTimeMillis());
    localObject1 = paramBundle.getString("coverurl");
    localObject2 = (String)localObject1 + "?busiType=3";
    if ((mX((String)localObject1)) || (aoiz.getFile((String)localObject1) != null) || (aoiz.getFile((String)localObject2) != null))
    {
      cO(paramBundle);
      return;
    }
    localObject2 = new AtomicBoolean(false);
    l = System.currentTimeMillis();
    QLog.i("DynamicNow | NowEntry", 1, "start to download cover pic  url = " + (String)localObject1);
    localObject1 = URLDrawable.getDrawable((String)localObject1, URLDrawable.URLDrawableOptions.obtain());
    ((URLDrawable)localObject1).setURLDrawableListener(new aige(this, l, (AtomicBoolean)localObject2, paramBundle));
    if (((URLDrawable)localObject1).getStatus() != 1)
    {
      ((AtomicBoolean)localObject2).set(false);
      ThreadManagerV2.excute(new NowEntry.2(this, (URLDrawable)localObject1), 128, null, false);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new NowEntry.3(this, (AtomicBoolean)localObject2, paramBundle), 500L);
      return;
    }
    QLog.i("DynamicNow | NowEntry", 1, "exception case!");
    ((AtomicBoolean)localObject2).set(true);
    cO(paramBundle);
  }
  
  public void unInit()
  {
    this.mApp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigd
 * JD-Core Version:    0.7.0.1
 */