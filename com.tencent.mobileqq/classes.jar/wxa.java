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

public abstract class wxa
{
  public static Map<String, String> a;
  private int a;
  public WeakReference<Activity> a;
  public wvy a;
  public wyb a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public wxa()
  {
    this.jdField_a_of_type_Wyb = new wyb();
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
        ykq.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    ykq.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
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
      localObject = new wyf();
      ((wyf)localObject).jdField_a_of_type_Int = paramInt;
      new wyd(this, (wyf)localObject).a();
      return;
    case 1: 
      localObject = new wyg();
      ((wyg)localObject).jdField_a_of_type_Int = paramInt;
      a_((wyf)localObject);
      a((wyg)localObject);
      b((wyf)localObject);
      b((wyg)localObject);
      return;
    case 2: 
      localObject = new wyh();
      ((wyh)localObject).jdField_a_of_type_Int = paramInt;
      a_((wyf)localObject);
      a((wyh)localObject);
      b((wyf)localObject);
      b((wyh)localObject);
      return;
    case 3: 
      localObject = new wyj();
      ((wyj)localObject).jdField_a_of_type_Int = paramInt;
      a_((wyf)localObject);
      a((wyj)localObject);
      b((wyf)localObject);
      c((wyj)localObject);
      return;
    case 4: 
      localObject = new wyj();
      ((wyj)localObject).jdField_a_of_type_Int = paramInt;
      ((wyj)localObject).jdField_a_of_type_Boolean = true;
      a_((wyf)localObject);
      b((wyj)localObject);
      b((wyf)localObject);
      c((wyj)localObject);
      return;
    case 5: 
      localObject = new wyi();
      ((wyi)localObject).jdField_a_of_type_Int = paramInt;
      a_((wyf)localObject);
      a((wyi)localObject);
      b((wyf)localObject);
      b((wyi)localObject);
      return;
    }
    Object localObject = new wye();
    ((wye)localObject).jdField_a_of_type_Int = paramInt;
    a_((wyf)localObject);
    a((wye)localObject);
    b((wyf)localObject);
    b((wye)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, wyf paramwyf)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramwyf != null) {
      localHashMap.putAll(paramwyf.jdField_a_of_type_JavaUtilMap);
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
    zdl.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(wye paramwye) {}
  
  public void a(wyg paramwyg) {}
  
  public void a(wyh paramwyh) {}
  
  public void a(wyi paramwyi) {}
  
  public void a(wyj paramwyj)
  {
    paramwyj.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Wyb.a(new ShareModeBase.23(this));
      return;
    }
    wyf localwyf = new wyf();
    localwyf.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localwyf);
  }
  
  protected void a_(wyf paramwyf) {}
  
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
  
  protected void b(wye paramwye)
  {
    String str = paramwye.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Wyb.a(new wxh(this, str, null, false, paramwye)).a(new wxg(this, paramwye)).a(new wyd(this, paramwye));
  }
  
  protected final void b(wyf paramwyf)
  {
    ykq.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramwyf);
    if ((paramwyf instanceof wyj)) {
      ((wyj)paramwyf).d = a(((wyj)paramwyf).d, paramwyf);
    }
    do
    {
      return;
      if ((paramwyf instanceof wye))
      {
        ((wye)paramwyf).jdField_a_of_type_JavaLangString = a(((wye)paramwyf).jdField_a_of_type_JavaLangString, paramwyf);
        return;
      }
      if ((paramwyf instanceof wyi))
      {
        ((wyi)paramwyf).c = a(((wyi)paramwyf).c, paramwyf);
        return;
      }
      if ((paramwyf instanceof wyh))
      {
        ((wyh)paramwyf).e = a(((wyh)paramwyf).e, paramwyf);
        return;
      }
    } while (!(paramwyf instanceof wyg));
    ((wyg)paramwyf).h = a(((wyg)paramwyf).h, paramwyf);
  }
  
  protected void b(wyg paramwyg)
  {
    if ((paramwyg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwyg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Wyb.a(new wxb(this, paramwyg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwyg));
    }
    for (;;)
    {
      String str = paramwyg.h;
      this.jdField_a_of_type_Wyb.a(new wxq(this, str, null, true, paramwyg)).a(new wyd(this, paramwyg));
      return;
      if ((paramwyg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwyg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Wyb.a(new wxm(this, paramwyg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwyg));
      }
    }
  }
  
  protected void b(wyh paramwyh)
  {
    String str = paramwyh.e;
    this.jdField_a_of_type_Wyb.a(new wxw(this, str, null, false, paramwyh));
    if ((paramwyh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwyh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Wyb.a(new wxd(this, paramwyh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new wxc(this, paramwyh));
    }
    for (;;)
    {
      this.jdField_a_of_type_Wyb.a(new wyd(this, paramwyh));
      return;
      if ((paramwyh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwyh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Wyb.a(new wxf(this, paramwyh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new wxe(this, paramwyh));
      }
    }
  }
  
  protected void b(wyi paramwyi)
  {
    String str = paramwyi.c;
    this.jdField_a_of_type_Wyb.a(new wxi(this, str, null, false, paramwyi));
    if ((paramwyi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwyi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Wyb.a(new wxl(this, paramwyi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwyi)).a(new wxk(this, paramwyi)).a(new wxj(this, paramwyi));
    }
    for (;;)
    {
      this.jdField_a_of_type_Wyb.a(new wyd(this, paramwyi));
      return;
      if ((paramwyi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwyi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Wyb.a(new wxp(this, paramwyi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwyi)).a(new wxo(this, paramwyi)).a(new wxn(this, paramwyi));
      } else {
        this.jdField_a_of_type_Wyb.a(new wwg(paramwyi.e, paramwyi.d, paramwyi.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(wyj paramwyj)
  {
    paramwyj.jdField_a_of_type_Boolean = true;
  }
  
  public void c(wyf paramwyf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    wyf localwyf;
    if (this.jdField_a_of_type_Wvy != null)
    {
      localwyf = paramwyf;
      if (paramwyf == null)
      {
        localwyf = new wyf();
        localwyf.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Wvy.a(localwyf);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localwyf));
  }
  
  protected void c(wyj paramwyj)
  {
    String str = paramwyj.d;
    ykq.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Wyb.a(new wxr(this, str, null, false, paramwyj));
    if ((paramwyj.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwyj.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Wyb.a(new wxs(this, paramwyj.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwyj));
    }
    for (;;)
    {
      this.jdField_a_of_type_Wyb.a(new wxv(this, paramwyj.e)).a(new wxu(this, paramwyj.b, paramwyj.c, paramwyj)).a(new wyd(this, paramwyj));
      return;
      if ((paramwyj.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramwyj.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Wyb.a(new wxt(this, paramwyj.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwyj));
      }
    }
  }
  
  public void d(wyf paramwyf)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    wyf localwyf;
    if (this.jdField_a_of_type_Wvy != null)
    {
      localwyf = paramwyf;
      if (paramwyf == null)
      {
        localwyf = new wyf();
        localwyf.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Wvy.b(localwyf);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localwyf));
  }
  
  public void e(wyf paramwyf)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    wyf localwyf;
    if (this.jdField_a_of_type_Wvy != null)
    {
      localwyf = paramwyf;
      if (paramwyf == null)
      {
        localwyf = new wyf();
        localwyf.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Wvy.c(localwyf);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localwyf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxa
 * JD-Core Version:    0.7.0.1
 */