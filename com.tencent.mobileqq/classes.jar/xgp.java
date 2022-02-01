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

public abstract class xgp
{
  public static Map<String, String> a;
  private int a;
  public WeakReference<Activity> a;
  public xfn a;
  public xhq a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public xgp()
  {
    this.jdField_a_of_type_Xhq = new xhq();
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
        yuk.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    yuk.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
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
      localObject = new xhu();
      ((xhu)localObject).jdField_a_of_type_Int = paramInt;
      new xhs(this, (xhu)localObject).a();
      return;
    case 1: 
      localObject = new xhv();
      ((xhv)localObject).jdField_a_of_type_Int = paramInt;
      a_((xhu)localObject);
      a((xhv)localObject);
      b((xhu)localObject);
      b((xhv)localObject);
      return;
    case 2: 
      localObject = new xhw();
      ((xhw)localObject).jdField_a_of_type_Int = paramInt;
      a_((xhu)localObject);
      a((xhw)localObject);
      b((xhu)localObject);
      b((xhw)localObject);
      return;
    case 3: 
      localObject = new xhy();
      ((xhy)localObject).jdField_a_of_type_Int = paramInt;
      a_((xhu)localObject);
      a((xhy)localObject);
      b((xhu)localObject);
      c((xhy)localObject);
      return;
    case 4: 
      localObject = new xhy();
      ((xhy)localObject).jdField_a_of_type_Int = paramInt;
      ((xhy)localObject).jdField_a_of_type_Boolean = true;
      a_((xhu)localObject);
      b((xhy)localObject);
      b((xhu)localObject);
      c((xhy)localObject);
      return;
    case 5: 
      localObject = new xhx();
      ((xhx)localObject).jdField_a_of_type_Int = paramInt;
      a_((xhu)localObject);
      a((xhx)localObject);
      b((xhu)localObject);
      b((xhx)localObject);
      return;
    }
    Object localObject = new xht();
    ((xht)localObject).jdField_a_of_type_Int = paramInt;
    a_((xhu)localObject);
    a((xht)localObject);
    b((xhu)localObject);
    b((xht)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, xhu paramxhu)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramxhu != null) {
      localHashMap.putAll(paramxhu.jdField_a_of_type_JavaUtilMap);
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
    znw.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(xht paramxht) {}
  
  public void a(xhv paramxhv) {}
  
  public void a(xhw paramxhw) {}
  
  public void a(xhx paramxhx) {}
  
  public void a(xhy paramxhy)
  {
    paramxhy.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xhq.a(new ShareModeBase.23(this));
      return;
    }
    xhu localxhu = new xhu();
    localxhu.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localxhu);
  }
  
  protected void a_(xhu paramxhu) {}
  
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
  
  protected void b(xht paramxht)
  {
    String str = paramxht.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Xhq.a(new xgw(this, str, null, false, paramxht)).a(new xgv(this, paramxht)).a(new xhs(this, paramxht));
  }
  
  protected final void b(xhu paramxhu)
  {
    yuk.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramxhu);
    if ((paramxhu instanceof xhy)) {
      ((xhy)paramxhu).d = a(((xhy)paramxhu).d, paramxhu);
    }
    do
    {
      return;
      if ((paramxhu instanceof xht))
      {
        ((xht)paramxhu).jdField_a_of_type_JavaLangString = a(((xht)paramxhu).jdField_a_of_type_JavaLangString, paramxhu);
        return;
      }
      if ((paramxhu instanceof xhx))
      {
        ((xhx)paramxhu).c = a(((xhx)paramxhu).c, paramxhu);
        return;
      }
      if ((paramxhu instanceof xhw))
      {
        ((xhw)paramxhu).e = a(((xhw)paramxhu).e, paramxhu);
        return;
      }
    } while (!(paramxhu instanceof xhv));
    ((xhv)paramxhu).h = a(((xhv)paramxhu).h, paramxhu);
  }
  
  protected void b(xhv paramxhv)
  {
    if ((paramxhv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxhv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Xhq.a(new xgq(this, paramxhv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxhv));
    }
    for (;;)
    {
      String str = paramxhv.h;
      this.jdField_a_of_type_Xhq.a(new xhf(this, str, null, true, paramxhv)).a(new xhs(this, paramxhv));
      return;
      if ((paramxhv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxhv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Xhq.a(new xhb(this, paramxhv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxhv));
      }
    }
  }
  
  protected void b(xhw paramxhw)
  {
    String str = paramxhw.e;
    this.jdField_a_of_type_Xhq.a(new xhl(this, str, null, false, paramxhw));
    if ((paramxhw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxhw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Xhq.a(new xgs(this, paramxhw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new xgr(this, paramxhw));
    }
    for (;;)
    {
      this.jdField_a_of_type_Xhq.a(new xhs(this, paramxhw));
      return;
      if ((paramxhw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxhw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Xhq.a(new xgu(this, paramxhw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new xgt(this, paramxhw));
      }
    }
  }
  
  protected void b(xhx paramxhx)
  {
    String str = paramxhx.c;
    this.jdField_a_of_type_Xhq.a(new xgx(this, str, null, false, paramxhx));
    if ((paramxhx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxhx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Xhq.a(new xha(this, paramxhx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxhx)).a(new xgz(this, paramxhx)).a(new xgy(this, paramxhx));
    }
    for (;;)
    {
      this.jdField_a_of_type_Xhq.a(new xhs(this, paramxhx));
      return;
      if ((paramxhx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxhx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Xhq.a(new xhe(this, paramxhx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxhx)).a(new xhd(this, paramxhx)).a(new xhc(this, paramxhx));
      } else {
        this.jdField_a_of_type_Xhq.a(new xfv(paramxhx.e, paramxhx.d, paramxhx.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(xhy paramxhy)
  {
    paramxhy.jdField_a_of_type_Boolean = true;
  }
  
  public void c(xhu paramxhu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    xhu localxhu;
    if (this.jdField_a_of_type_Xfn != null)
    {
      localxhu = paramxhu;
      if (paramxhu == null)
      {
        localxhu = new xhu();
        localxhu.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Xfn.a(localxhu);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localxhu));
  }
  
  protected void c(xhy paramxhy)
  {
    String str = paramxhy.d;
    yuk.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Xhq.a(new xhg(this, str, null, false, paramxhy));
    if ((paramxhy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxhy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Xhq.a(new xhh(this, paramxhy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxhy));
    }
    for (;;)
    {
      this.jdField_a_of_type_Xhq.a(new xhk(this, paramxhy.e)).a(new xhj(this, paramxhy.b, paramxhy.c, paramxhy)).a(new xhs(this, paramxhy));
      return;
      if ((paramxhy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramxhy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Xhq.a(new xhi(this, paramxhy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxhy));
      }
    }
  }
  
  public void d(xhu paramxhu)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    xhu localxhu;
    if (this.jdField_a_of_type_Xfn != null)
    {
      localxhu = paramxhu;
      if (paramxhu == null)
      {
        localxhu = new xhu();
        localxhu.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Xfn.b(localxhu);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localxhu));
  }
  
  public void e(xhu paramxhu)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    xhu localxhu;
    if (this.jdField_a_of_type_Xfn != null)
    {
      localxhu = paramxhu;
      if (paramxhu == null)
      {
        localxhu = new xhu();
        localxhu.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Xfn.c(localxhu);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localxhu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgp
 * JD-Core Version:    0.7.0.1
 */