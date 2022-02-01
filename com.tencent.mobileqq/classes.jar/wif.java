import android.app.Activity;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.23;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.24;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.25;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.26;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public abstract class wif
{
  public static Map<String, String> a;
  private int a;
  public WeakReference<Activity> a;
  public whd a;
  public wjg a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public wif()
  {
    this.jdField_a_of_type_Wjg = new wjg();
  }
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (!paramString.contains("?")) {}
    label37:
    label192:
    for (String str1 = "?";; str1 = "")
    {
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        int i = 1;
        if (localIterator.hasNext())
        {
          String str4 = (String)localIterator.next();
          String str3 = (String)paramMap.get(str4);
          String str2 = str3;
          if (str3 == null) {
            str2 = "";
          }
          if (i != 0) {
            localStringBuilder.append(str1);
          }
          for (;;)
          {
            localStringBuilder.append(str4 + "=" + URLEncoder.encode(str2, "utf-8"));
            i = 0;
            break label37;
            if ((paramString.endsWith("?")) || (paramString.endsWith("&"))) {
              break label192;
            }
            str1 = "&";
            break;
            localStringBuilder.append("&");
          }
        }
        paramMap = localStringBuilder.toString();
      }
      catch (UnsupportedEncodingException paramMap)
      {
        xvv.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    xvv.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      localObject = new wjk();
      ((wjk)localObject).jdField_a_of_type_Int = paramInt;
      new wji(this, (wjk)localObject).a();
      return;
    case 1: 
      localObject = new wjl();
      ((wjl)localObject).jdField_a_of_type_Int = paramInt;
      a_((wjk)localObject);
      a((wjl)localObject);
      b((wjk)localObject);
      b((wjl)localObject);
      return;
    case 2: 
      localObject = new wjm();
      ((wjm)localObject).jdField_a_of_type_Int = paramInt;
      a_((wjk)localObject);
      a((wjm)localObject);
      b((wjk)localObject);
      b((wjm)localObject);
      return;
    case 3: 
      localObject = new wjo();
      ((wjo)localObject).jdField_a_of_type_Int = paramInt;
      a_((wjk)localObject);
      a((wjo)localObject);
      b((wjk)localObject);
      c((wjo)localObject);
      return;
    case 4: 
      localObject = new wjo();
      ((wjo)localObject).jdField_a_of_type_Int = paramInt;
      ((wjo)localObject).jdField_a_of_type_Boolean = true;
      a_((wjk)localObject);
      b((wjo)localObject);
      b((wjk)localObject);
      c((wjo)localObject);
      return;
    case 5: 
      localObject = new wjn();
      ((wjn)localObject).jdField_a_of_type_Int = paramInt;
      a_((wjk)localObject);
      a((wjn)localObject);
      b((wjk)localObject);
      b((wjn)localObject);
      return;
    }
    Object localObject = new wjj();
    ((wjj)localObject).jdField_a_of_type_Int = paramInt;
    a_((wjk)localObject);
    a((wjj)localObject);
    b((wjk)localObject);
    b((wjj)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, wjk paramwjk)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramwjk != null) {
      localHashMap.putAll(paramwjk.jdField_a_of_type_JavaUtilMap);
    }
    localHashMap.putAll(this.b);
    return a(paramString, localHashMap);
  }
  
  protected void a()
  {
    a(true);
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public void a(@NonNull Activity paramActivity)
  {
    yos.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(wjj paramwjj) {}
  
  public void a(wjl paramwjl) {}
  
  public void a(wjm paramwjm) {}
  
  public void a(wjn paramwjn) {}
  
  public void a(wjo paramwjo)
  {
    paramwjo.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Wjg.a(new ShareModeBase.23(this));
      return;
    }
    wjk localwjk = new wjk();
    localwjk.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localwjk);
  }
  
  protected void a_(wjk paramwjk) {}
  
  protected String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "qq";
    case 2: 
      return "qzone";
    case 3: 
      return "wechat";
    case 4: 
      return "wechat";
    case 5: 
      return "weibo";
    }
    return "copy_link";
  }
  
  protected void b(wjj paramwjj)
  {
    String str = paramwjj.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Wjg.a(new wim(this, str, null, false, paramwjj)).a(new wil(this, paramwjj)).a(new wji(this, paramwjj));
  }
  
  protected final void b(wjk paramwjk)
  {
    xvv.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramwjk);
    if ((paramwjk instanceof wjo)) {
      ((wjo)paramwjk).d = a(((wjo)paramwjk).d, paramwjk);
    }
    do
    {
      return;
      if ((paramwjk instanceof wjj))
      {
        ((wjj)paramwjk).jdField_a_of_type_JavaLangString = a(((wjj)paramwjk).jdField_a_of_type_JavaLangString, paramwjk);
        return;
      }
      if ((paramwjk instanceof wjn))
      {
        ((wjn)paramwjk).c = a(((wjn)paramwjk).c, paramwjk);
        return;
      }
      if ((paramwjk instanceof wjm))
      {
        ((wjm)paramwjk).e = a(((wjm)paramwjk).e, paramwjk);
        return;
      }
    } while (!(paramwjk instanceof wjl));
    ((wjl)paramwjk).h = a(((wjl)paramwjk).h, paramwjk);
  }
  
  protected void b(wjl paramwjl)
  {
    if ((paramwjl.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwjl.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Wjg.a(new wig(this, paramwjl.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwjl));
    }
    for (;;)
    {
      String str = paramwjl.h;
      this.jdField_a_of_type_Wjg.a(new wiv(this, str, null, true, paramwjl)).a(new wji(this, paramwjl));
      return;
      if ((paramwjl.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwjl.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Wjg.a(new wir(this, paramwjl.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwjl));
      }
    }
  }
  
  protected void b(wjm paramwjm)
  {
    String str = paramwjm.e;
    this.jdField_a_of_type_Wjg.a(new wjb(this, str, null, false, paramwjm));
    if ((paramwjm.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwjm.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Wjg.a(new wii(this, paramwjm.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new wih(this, paramwjm));
    }
    for (;;)
    {
      this.jdField_a_of_type_Wjg.a(new wji(this, paramwjm));
      return;
      if ((paramwjm.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwjm.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Wjg.a(new wik(this, paramwjm.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new wij(this, paramwjm));
      }
    }
  }
  
  protected void b(wjn paramwjn)
  {
    String str = paramwjn.c;
    this.jdField_a_of_type_Wjg.a(new win(this, str, null, false, paramwjn));
    if ((paramwjn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwjn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Wjg.a(new wiq(this, paramwjn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwjn)).a(new wip(this, paramwjn)).a(new wio(this, paramwjn));
    }
    for (;;)
    {
      this.jdField_a_of_type_Wjg.a(new wji(this, paramwjn));
      return;
      if ((paramwjn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwjn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Wjg.a(new wiu(this, paramwjn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwjn)).a(new wit(this, paramwjn)).a(new wis(this, paramwjn));
      } else {
        this.jdField_a_of_type_Wjg.a(new whl(paramwjn.e, paramwjn.d, paramwjn.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(wjo paramwjo)
  {
    paramwjo.jdField_a_of_type_Boolean = true;
  }
  
  public void c(wjk paramwjk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    wjk localwjk;
    if (this.jdField_a_of_type_Whd != null)
    {
      localwjk = paramwjk;
      if (paramwjk == null)
      {
        localwjk = new wjk();
        localwjk.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Whd.a(localwjk);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localwjk));
  }
  
  protected void c(wjo paramwjo)
  {
    String str = paramwjo.d;
    xvv.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Wjg.a(new wiw(this, str, null, false, paramwjo));
    if ((paramwjo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwjo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Wjg.a(new wix(this, paramwjo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwjo));
    }
    for (;;)
    {
      this.jdField_a_of_type_Wjg.a(new wja(this, paramwjo.e)).a(new wiz(this, paramwjo.b, paramwjo.c, paramwjo)).a(new wji(this, paramwjo));
      return;
      if ((paramwjo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwjo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Wjg.a(new wiy(this, paramwjo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwjo));
      }
    }
  }
  
  public void d(wjk paramwjk)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    wjk localwjk;
    if (this.jdField_a_of_type_Whd != null)
    {
      localwjk = paramwjk;
      if (paramwjk == null)
      {
        localwjk = new wjk();
        localwjk.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Whd.b(localwjk);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localwjk));
  }
  
  public void e(wjk paramwjk)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    wjk localwjk;
    if (this.jdField_a_of_type_Whd != null)
    {
      localwjk = paramwjk;
      if (paramwjk == null)
      {
        localwjk = new wjk();
        localwjk.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Whd.c(localwjk);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localwjk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wif
 * JD-Core Version:    0.7.0.1
 */