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

public abstract class vji
{
  public static Map<String, String> a;
  private int a;
  public WeakReference<Activity> a;
  public vig a;
  public vkj a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public vji()
  {
    this.jdField_a_of_type_Vkj = new vkj();
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
        wxe.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    wxe.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
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
      localObject = new vkn();
      ((vkn)localObject).jdField_a_of_type_Int = paramInt;
      new vkl(this, (vkn)localObject).a();
      return;
    case 1: 
      localObject = new vko();
      ((vko)localObject).jdField_a_of_type_Int = paramInt;
      a_((vkn)localObject);
      a((vko)localObject);
      b((vkn)localObject);
      b((vko)localObject);
      return;
    case 2: 
      localObject = new vkp();
      ((vkp)localObject).jdField_a_of_type_Int = paramInt;
      a_((vkn)localObject);
      a((vkp)localObject);
      b((vkn)localObject);
      b((vkp)localObject);
      return;
    case 3: 
      localObject = new vkr();
      ((vkr)localObject).jdField_a_of_type_Int = paramInt;
      a_((vkn)localObject);
      a((vkr)localObject);
      b((vkn)localObject);
      c((vkr)localObject);
      return;
    case 4: 
      localObject = new vkr();
      ((vkr)localObject).jdField_a_of_type_Int = paramInt;
      ((vkr)localObject).jdField_a_of_type_Boolean = true;
      a_((vkn)localObject);
      b((vkr)localObject);
      b((vkn)localObject);
      c((vkr)localObject);
      return;
    case 5: 
      localObject = new vkq();
      ((vkq)localObject).jdField_a_of_type_Int = paramInt;
      a_((vkn)localObject);
      a((vkq)localObject);
      b((vkn)localObject);
      b((vkq)localObject);
      return;
    }
    Object localObject = new vkm();
    ((vkm)localObject).jdField_a_of_type_Int = paramInt;
    a_((vkn)localObject);
    a((vkm)localObject);
    b((vkn)localObject);
    b((vkm)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, vkn paramvkn)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramvkn != null) {
      localHashMap.putAll(paramvkn.jdField_a_of_type_JavaUtilMap);
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
    xqq.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(vkm paramvkm) {}
  
  public void a(vko paramvko) {}
  
  public void a(vkp paramvkp) {}
  
  public void a(vkq paramvkq) {}
  
  public void a(vkr paramvkr)
  {
    paramvkr.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Vkj.a(new ShareModeBase.23(this));
      return;
    }
    vkn localvkn = new vkn();
    localvkn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localvkn);
  }
  
  protected void a_(vkn paramvkn) {}
  
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
  
  protected void b(vkm paramvkm)
  {
    String str = paramvkm.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Vkj.a(new vjp(this, str, null, false, paramvkm)).a(new vjo(this, paramvkm)).a(new vkl(this, paramvkm));
  }
  
  protected final void b(vkn paramvkn)
  {
    wxe.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramvkn);
    if ((paramvkn instanceof vkr)) {
      ((vkr)paramvkn).d = a(((vkr)paramvkn).d, paramvkn);
    }
    do
    {
      return;
      if ((paramvkn instanceof vkm))
      {
        ((vkm)paramvkn).jdField_a_of_type_JavaLangString = a(((vkm)paramvkn).jdField_a_of_type_JavaLangString, paramvkn);
        return;
      }
      if ((paramvkn instanceof vkq))
      {
        ((vkq)paramvkn).c = a(((vkq)paramvkn).c, paramvkn);
        return;
      }
      if ((paramvkn instanceof vkp))
      {
        ((vkp)paramvkn).e = a(((vkp)paramvkn).e, paramvkn);
        return;
      }
    } while (!(paramvkn instanceof vko));
    ((vko)paramvkn).h = a(((vko)paramvkn).h, paramvkn);
  }
  
  protected void b(vko paramvko)
  {
    if ((paramvko.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvko.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Vkj.a(new vjj(this, paramvko.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvko));
    }
    for (;;)
    {
      String str = paramvko.h;
      this.jdField_a_of_type_Vkj.a(new vjy(this, str, null, true, paramvko)).a(new vkl(this, paramvko));
      return;
      if ((paramvko.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvko.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Vkj.a(new vju(this, paramvko.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvko));
      }
    }
  }
  
  protected void b(vkp paramvkp)
  {
    String str = paramvkp.e;
    this.jdField_a_of_type_Vkj.a(new vke(this, str, null, false, paramvkp));
    if ((paramvkp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvkp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Vkj.a(new vjl(this, paramvkp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new vjk(this, paramvkp));
    }
    for (;;)
    {
      this.jdField_a_of_type_Vkj.a(new vkl(this, paramvkp));
      return;
      if ((paramvkp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvkp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Vkj.a(new vjn(this, paramvkp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new vjm(this, paramvkp));
      }
    }
  }
  
  protected void b(vkq paramvkq)
  {
    String str = paramvkq.c;
    this.jdField_a_of_type_Vkj.a(new vjq(this, str, null, false, paramvkq));
    if ((paramvkq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvkq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Vkj.a(new vjt(this, paramvkq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvkq)).a(new vjs(this, paramvkq)).a(new vjr(this, paramvkq));
    }
    for (;;)
    {
      this.jdField_a_of_type_Vkj.a(new vkl(this, paramvkq));
      return;
      if ((paramvkq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvkq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Vkj.a(new vjx(this, paramvkq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvkq)).a(new vjw(this, paramvkq)).a(new vjv(this, paramvkq));
      } else {
        this.jdField_a_of_type_Vkj.a(new vio(paramvkq.e, paramvkq.d, paramvkq.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(vkr paramvkr)
  {
    paramvkr.jdField_a_of_type_Boolean = true;
  }
  
  public void c(vkn paramvkn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    vkn localvkn;
    if (this.jdField_a_of_type_Vig != null)
    {
      localvkn = paramvkn;
      if (paramvkn == null)
      {
        localvkn = new vkn();
        localvkn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Vig.a(localvkn);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localvkn));
  }
  
  protected void c(vkr paramvkr)
  {
    String str = paramvkr.d;
    wxe.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Vkj.a(new vjz(this, str, null, false, paramvkr));
    if ((paramvkr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvkr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Vkj.a(new vka(this, paramvkr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvkr));
    }
    for (;;)
    {
      this.jdField_a_of_type_Vkj.a(new vkd(this, paramvkr.e)).a(new vkc(this, paramvkr.b, paramvkr.c, paramvkr)).a(new vkl(this, paramvkr));
      return;
      if ((paramvkr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvkr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Vkj.a(new vkb(this, paramvkr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvkr));
      }
    }
  }
  
  public void d(vkn paramvkn)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    vkn localvkn;
    if (this.jdField_a_of_type_Vig != null)
    {
      localvkn = paramvkn;
      if (paramvkn == null)
      {
        localvkn = new vkn();
        localvkn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Vig.b(localvkn);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localvkn));
  }
  
  public void e(vkn paramvkn)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    vkn localvkn;
    if (this.jdField_a_of_type_Vig != null)
    {
      localvkn = paramvkn;
      if (paramvkn == null)
      {
        localvkn = new vkn();
        localvkn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Vig.c(localvkn);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localvkn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vji
 * JD-Core Version:    0.7.0.1
 */