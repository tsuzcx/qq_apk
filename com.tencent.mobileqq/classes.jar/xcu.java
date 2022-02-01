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

public abstract class xcu
{
  public static Map<String, String> a;
  private int a;
  public WeakReference<Activity> a;
  public xbs a;
  public xdv a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public xcu()
  {
    this.jdField_a_of_type_Xdv = new xdv();
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
        yqp.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    yqp.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
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
      localObject = new xdz();
      ((xdz)localObject).jdField_a_of_type_Int = paramInt;
      new xdx(this, (xdz)localObject).a();
      return;
    case 1: 
      localObject = new xea();
      ((xea)localObject).jdField_a_of_type_Int = paramInt;
      a_((xdz)localObject);
      a((xea)localObject);
      b((xdz)localObject);
      b((xea)localObject);
      return;
    case 2: 
      localObject = new xeb();
      ((xeb)localObject).jdField_a_of_type_Int = paramInt;
      a_((xdz)localObject);
      a((xeb)localObject);
      b((xdz)localObject);
      b((xeb)localObject);
      return;
    case 3: 
      localObject = new xed();
      ((xed)localObject).jdField_a_of_type_Int = paramInt;
      a_((xdz)localObject);
      a((xed)localObject);
      b((xdz)localObject);
      c((xed)localObject);
      return;
    case 4: 
      localObject = new xed();
      ((xed)localObject).jdField_a_of_type_Int = paramInt;
      ((xed)localObject).jdField_a_of_type_Boolean = true;
      a_((xdz)localObject);
      b((xed)localObject);
      b((xdz)localObject);
      c((xed)localObject);
      return;
    case 5: 
      localObject = new xec();
      ((xec)localObject).jdField_a_of_type_Int = paramInt;
      a_((xdz)localObject);
      a((xec)localObject);
      b((xdz)localObject);
      b((xec)localObject);
      return;
    }
    Object localObject = new xdy();
    ((xdy)localObject).jdField_a_of_type_Int = paramInt;
    a_((xdz)localObject);
    a((xdy)localObject);
    b((xdz)localObject);
    b((xdy)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, xdz paramxdz)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramxdz != null) {
      localHashMap.putAll(paramxdz.jdField_a_of_type_JavaUtilMap);
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
    zkb.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(xdy paramxdy) {}
  
  public void a(xea paramxea) {}
  
  public void a(xeb paramxeb) {}
  
  public void a(xec paramxec) {}
  
  public void a(xed paramxed)
  {
    paramxed.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xdv.a(new ShareModeBase.23(this));
      return;
    }
    xdz localxdz = new xdz();
    localxdz.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localxdz);
  }
  
  protected void a_(xdz paramxdz) {}
  
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
  
  protected void b(xdy paramxdy)
  {
    String str = paramxdy.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Xdv.a(new xdb(this, str, null, false, paramxdy)).a(new xda(this, paramxdy)).a(new xdx(this, paramxdy));
  }
  
  protected final void b(xdz paramxdz)
  {
    yqp.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramxdz);
    if ((paramxdz instanceof xed)) {
      ((xed)paramxdz).d = a(((xed)paramxdz).d, paramxdz);
    }
    do
    {
      return;
      if ((paramxdz instanceof xdy))
      {
        ((xdy)paramxdz).jdField_a_of_type_JavaLangString = a(((xdy)paramxdz).jdField_a_of_type_JavaLangString, paramxdz);
        return;
      }
      if ((paramxdz instanceof xec))
      {
        ((xec)paramxdz).c = a(((xec)paramxdz).c, paramxdz);
        return;
      }
      if ((paramxdz instanceof xeb))
      {
        ((xeb)paramxdz).e = a(((xeb)paramxdz).e, paramxdz);
        return;
      }
    } while (!(paramxdz instanceof xea));
    ((xea)paramxdz).h = a(((xea)paramxdz).h, paramxdz);
  }
  
  protected void b(xea paramxea)
  {
    if ((paramxea.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxea.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Xdv.a(new xcv(this, paramxea.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxea));
    }
    for (;;)
    {
      String str = paramxea.h;
      this.jdField_a_of_type_Xdv.a(new xdk(this, str, null, true, paramxea)).a(new xdx(this, paramxea));
      return;
      if ((paramxea.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxea.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Xdv.a(new xdg(this, paramxea.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxea));
      }
    }
  }
  
  protected void b(xeb paramxeb)
  {
    String str = paramxeb.e;
    this.jdField_a_of_type_Xdv.a(new xdq(this, str, null, false, paramxeb));
    if ((paramxeb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxeb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Xdv.a(new xcx(this, paramxeb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new xcw(this, paramxeb));
    }
    for (;;)
    {
      this.jdField_a_of_type_Xdv.a(new xdx(this, paramxeb));
      return;
      if ((paramxeb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxeb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Xdv.a(new xcz(this, paramxeb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new xcy(this, paramxeb));
      }
    }
  }
  
  protected void b(xec paramxec)
  {
    String str = paramxec.c;
    this.jdField_a_of_type_Xdv.a(new xdc(this, str, null, false, paramxec));
    if ((paramxec.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxec.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Xdv.a(new xdf(this, paramxec.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxec)).a(new xde(this, paramxec)).a(new xdd(this, paramxec));
    }
    for (;;)
    {
      this.jdField_a_of_type_Xdv.a(new xdx(this, paramxec));
      return;
      if ((paramxec.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxec.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Xdv.a(new xdj(this, paramxec.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxec)).a(new xdi(this, paramxec)).a(new xdh(this, paramxec));
      } else {
        this.jdField_a_of_type_Xdv.a(new xca(paramxec.e, paramxec.d, paramxec.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(xed paramxed)
  {
    paramxed.jdField_a_of_type_Boolean = true;
  }
  
  public void c(xdz paramxdz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    xdz localxdz;
    if (this.jdField_a_of_type_Xbs != null)
    {
      localxdz = paramxdz;
      if (paramxdz == null)
      {
        localxdz = new xdz();
        localxdz.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Xbs.a(localxdz);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localxdz));
  }
  
  protected void c(xed paramxed)
  {
    String str = paramxed.d;
    yqp.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Xdv.a(new xdl(this, str, null, false, paramxed));
    if ((paramxed.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxed.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Xdv.a(new xdm(this, paramxed.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxed));
    }
    for (;;)
    {
      this.jdField_a_of_type_Xdv.a(new xdp(this, paramxed.e)).a(new xdo(this, paramxed.b, paramxed.c, paramxed)).a(new xdx(this, paramxed));
      return;
      if ((paramxed.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxed.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Xdv.a(new xdn(this, paramxed.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxed));
      }
    }
  }
  
  public void d(xdz paramxdz)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    xdz localxdz;
    if (this.jdField_a_of_type_Xbs != null)
    {
      localxdz = paramxdz;
      if (paramxdz == null)
      {
        localxdz = new xdz();
        localxdz.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Xbs.b(localxdz);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localxdz));
  }
  
  public void e(xdz paramxdz)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    xdz localxdz;
    if (this.jdField_a_of_type_Xbs != null)
    {
      localxdz = paramxdz;
      if (paramxdz == null)
      {
        localxdz = new xdz();
        localxdz.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Xbs.c(localxdz);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localxdz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcu
 * JD-Core Version:    0.7.0.1
 */