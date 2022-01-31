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

public abstract class vez
{
  public static Map<String, String> a;
  private int a;
  public WeakReference<Activity> a;
  public vdx a;
  public vga a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public vez()
  {
    this.jdField_a_of_type_Vga = new vga();
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
        wsv.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    wsv.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
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
      localObject = new vge();
      ((vge)localObject).jdField_a_of_type_Int = paramInt;
      new vgc(this, (vge)localObject).a();
      return;
    case 1: 
      localObject = new vgf();
      ((vgf)localObject).jdField_a_of_type_Int = paramInt;
      a_((vge)localObject);
      a((vgf)localObject);
      b((vge)localObject);
      b((vgf)localObject);
      return;
    case 2: 
      localObject = new vgg();
      ((vgg)localObject).jdField_a_of_type_Int = paramInt;
      a_((vge)localObject);
      a((vgg)localObject);
      b((vge)localObject);
      b((vgg)localObject);
      return;
    case 3: 
      localObject = new vgi();
      ((vgi)localObject).jdField_a_of_type_Int = paramInt;
      a_((vge)localObject);
      a((vgi)localObject);
      b((vge)localObject);
      c((vgi)localObject);
      return;
    case 4: 
      localObject = new vgi();
      ((vgi)localObject).jdField_a_of_type_Int = paramInt;
      ((vgi)localObject).jdField_a_of_type_Boolean = true;
      a_((vge)localObject);
      b((vgi)localObject);
      b((vge)localObject);
      c((vgi)localObject);
      return;
    case 5: 
      localObject = new vgh();
      ((vgh)localObject).jdField_a_of_type_Int = paramInt;
      a_((vge)localObject);
      a((vgh)localObject);
      b((vge)localObject);
      b((vgh)localObject);
      return;
    }
    Object localObject = new vgd();
    ((vgd)localObject).jdField_a_of_type_Int = paramInt;
    a_((vge)localObject);
    a((vgd)localObject);
    b((vge)localObject);
    b((vgd)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, vge paramvge)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramvge != null) {
      localHashMap.putAll(paramvge.jdField_a_of_type_JavaUtilMap);
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
    xmh.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(vgd paramvgd) {}
  
  public void a(vgf paramvgf) {}
  
  public void a(vgg paramvgg) {}
  
  public void a(vgh paramvgh) {}
  
  public void a(vgi paramvgi)
  {
    paramvgi.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Vga.a(new ShareModeBase.23(this));
      return;
    }
    vge localvge = new vge();
    localvge.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localvge);
  }
  
  protected void a_(vge paramvge) {}
  
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
  
  protected void b(vgd paramvgd)
  {
    String str = paramvgd.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Vga.a(new vfg(this, str, null, false, paramvgd)).a(new vff(this, paramvgd)).a(new vgc(this, paramvgd));
  }
  
  protected final void b(vge paramvge)
  {
    wsv.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramvge);
    if ((paramvge instanceof vgi)) {
      ((vgi)paramvge).d = a(((vgi)paramvge).d, paramvge);
    }
    do
    {
      return;
      if ((paramvge instanceof vgd))
      {
        ((vgd)paramvge).jdField_a_of_type_JavaLangString = a(((vgd)paramvge).jdField_a_of_type_JavaLangString, paramvge);
        return;
      }
      if ((paramvge instanceof vgh))
      {
        ((vgh)paramvge).c = a(((vgh)paramvge).c, paramvge);
        return;
      }
      if ((paramvge instanceof vgg))
      {
        ((vgg)paramvge).e = a(((vgg)paramvge).e, paramvge);
        return;
      }
    } while (!(paramvge instanceof vgf));
    ((vgf)paramvge).h = a(((vgf)paramvge).h, paramvge);
  }
  
  protected void b(vgf paramvgf)
  {
    if ((paramvgf.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvgf.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Vga.a(new vfa(this, paramvgf.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvgf));
    }
    for (;;)
    {
      String str = paramvgf.h;
      this.jdField_a_of_type_Vga.a(new vfp(this, str, null, true, paramvgf)).a(new vgc(this, paramvgf));
      return;
      if ((paramvgf.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvgf.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Vga.a(new vfl(this, paramvgf.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvgf));
      }
    }
  }
  
  protected void b(vgg paramvgg)
  {
    String str = paramvgg.e;
    this.jdField_a_of_type_Vga.a(new vfv(this, str, null, false, paramvgg));
    if ((paramvgg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvgg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Vga.a(new vfc(this, paramvgg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new vfb(this, paramvgg));
    }
    for (;;)
    {
      this.jdField_a_of_type_Vga.a(new vgc(this, paramvgg));
      return;
      if ((paramvgg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvgg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Vga.a(new vfe(this, paramvgg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new vfd(this, paramvgg));
      }
    }
  }
  
  protected void b(vgh paramvgh)
  {
    String str = paramvgh.c;
    this.jdField_a_of_type_Vga.a(new vfh(this, str, null, false, paramvgh));
    if ((paramvgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Vga.a(new vfk(this, paramvgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvgh)).a(new vfj(this, paramvgh)).a(new vfi(this, paramvgh));
    }
    for (;;)
    {
      this.jdField_a_of_type_Vga.a(new vgc(this, paramvgh));
      return;
      if ((paramvgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Vga.a(new vfo(this, paramvgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvgh)).a(new vfn(this, paramvgh)).a(new vfm(this, paramvgh));
      } else {
        this.jdField_a_of_type_Vga.a(new vef(paramvgh.e, paramvgh.d, paramvgh.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(vgi paramvgi)
  {
    paramvgi.jdField_a_of_type_Boolean = true;
  }
  
  public void c(vge paramvge)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    vge localvge;
    if (this.jdField_a_of_type_Vdx != null)
    {
      localvge = paramvge;
      if (paramvge == null)
      {
        localvge = new vge();
        localvge.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Vdx.a(localvge);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localvge));
  }
  
  protected void c(vgi paramvgi)
  {
    String str = paramvgi.d;
    wsv.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Vga.a(new vfq(this, str, null, false, paramvgi));
    if ((paramvgi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvgi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Vga.a(new vfr(this, paramvgi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvgi));
    }
    for (;;)
    {
      this.jdField_a_of_type_Vga.a(new vfu(this, paramvgi.e)).a(new vft(this, paramvgi.b, paramvgi.c, paramvgi)).a(new vgc(this, paramvgi));
      return;
      if ((paramvgi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramvgi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Vga.a(new vfs(this, paramvgi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvgi));
      }
    }
  }
  
  public void d(vge paramvge)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    vge localvge;
    if (this.jdField_a_of_type_Vdx != null)
    {
      localvge = paramvge;
      if (paramvge == null)
      {
        localvge = new vge();
        localvge.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Vdx.b(localvge);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localvge));
  }
  
  public void e(vge paramvge)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    vge localvge;
    if (this.jdField_a_of_type_Vdx != null)
    {
      localvge = paramvge;
      if (paramvge == null)
      {
        localvge = new vge();
        localvge.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Vdx.c(localvge);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localvge));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vez
 * JD-Core Version:    0.7.0.1
 */