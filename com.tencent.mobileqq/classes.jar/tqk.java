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

public abstract class tqk
{
  public static Map<String, String> a;
  private int a;
  public WeakReference<Activity> a;
  public tpi a;
  public trl a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public tqk()
  {
    this.jdField_a_of_type_Trl = new trl();
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
        veg.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    veg.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
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
      localObject = new trp();
      ((trp)localObject).jdField_a_of_type_Int = paramInt;
      new trn(this, (trp)localObject).a();
      return;
    case 1: 
      localObject = new trq();
      ((trq)localObject).jdField_a_of_type_Int = paramInt;
      a_((trp)localObject);
      a((trq)localObject);
      b((trp)localObject);
      b((trq)localObject);
      return;
    case 2: 
      localObject = new trr();
      ((trr)localObject).jdField_a_of_type_Int = paramInt;
      a_((trp)localObject);
      a((trr)localObject);
      b((trp)localObject);
      b((trr)localObject);
      return;
    case 3: 
      localObject = new trt();
      ((trt)localObject).jdField_a_of_type_Int = paramInt;
      a_((trp)localObject);
      a((trt)localObject);
      b((trp)localObject);
      c((trt)localObject);
      return;
    case 4: 
      localObject = new trt();
      ((trt)localObject).jdField_a_of_type_Int = paramInt;
      ((trt)localObject).jdField_a_of_type_Boolean = true;
      a_((trp)localObject);
      b((trt)localObject);
      b((trp)localObject);
      c((trt)localObject);
      return;
    case 5: 
      localObject = new trs();
      ((trs)localObject).jdField_a_of_type_Int = paramInt;
      a_((trp)localObject);
      a((trs)localObject);
      b((trp)localObject);
      b((trs)localObject);
      return;
    }
    Object localObject = new tro();
    ((tro)localObject).jdField_a_of_type_Int = paramInt;
    a_((trp)localObject);
    a((tro)localObject);
    b((trp)localObject);
    b((tro)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, trp paramtrp)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramtrp != null) {
      localHashMap.putAll(paramtrp.jdField_a_of_type_JavaUtilMap);
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
    vxs.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(tro paramtro) {}
  
  public void a(trq paramtrq) {}
  
  public void a(trr paramtrr) {}
  
  public void a(trs paramtrs) {}
  
  public void a(trt paramtrt)
  {
    paramtrt.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Trl.a(new ShareModeBase.23(this));
      return;
    }
    trp localtrp = new trp();
    localtrp.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localtrp);
  }
  
  protected void a_(trp paramtrp) {}
  
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
  
  protected void b(tro paramtro)
  {
    String str = paramtro.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Trl.a(new tqr(this, str, null, false, paramtro)).a(new tqq(this, paramtro)).a(new trn(this, paramtro));
  }
  
  protected final void b(trp paramtrp)
  {
    veg.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramtrp);
    if ((paramtrp instanceof trt)) {
      ((trt)paramtrp).d = a(((trt)paramtrp).d, paramtrp);
    }
    do
    {
      return;
      if ((paramtrp instanceof tro))
      {
        ((tro)paramtrp).jdField_a_of_type_JavaLangString = a(((tro)paramtrp).jdField_a_of_type_JavaLangString, paramtrp);
        return;
      }
      if ((paramtrp instanceof trs))
      {
        ((trs)paramtrp).c = a(((trs)paramtrp).c, paramtrp);
        return;
      }
      if ((paramtrp instanceof trr))
      {
        ((trr)paramtrp).e = a(((trr)paramtrp).e, paramtrp);
        return;
      }
    } while (!(paramtrp instanceof trq));
    ((trq)paramtrp).h = a(((trq)paramtrp).h, paramtrp);
  }
  
  protected void b(trq paramtrq)
  {
    if ((paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Trl.a(new tql(this, paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrq));
    }
    for (;;)
    {
      String str = paramtrq.h;
      this.jdField_a_of_type_Trl.a(new tra(this, str, null, true, paramtrq)).a(new trn(this, paramtrq));
      return;
      if ((paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Trl.a(new tqw(this, paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrq));
      }
    }
  }
  
  protected void b(trr paramtrr)
  {
    String str = paramtrr.e;
    this.jdField_a_of_type_Trl.a(new trg(this, str, null, false, paramtrr));
    if ((paramtrr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Trl.a(new tqn(this, paramtrr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new tqm(this, paramtrr));
    }
    for (;;)
    {
      this.jdField_a_of_type_Trl.a(new trn(this, paramtrr));
      return;
      if ((paramtrr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Trl.a(new tqp(this, paramtrr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new tqo(this, paramtrr));
      }
    }
  }
  
  protected void b(trs paramtrs)
  {
    String str = paramtrs.c;
    this.jdField_a_of_type_Trl.a(new tqs(this, str, null, false, paramtrs));
    if ((paramtrs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Trl.a(new tqv(this, paramtrs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrs)).a(new tqu(this, paramtrs)).a(new tqt(this, paramtrs));
    }
    for (;;)
    {
      this.jdField_a_of_type_Trl.a(new trn(this, paramtrs));
      return;
      if ((paramtrs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Trl.a(new tqz(this, paramtrs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrs)).a(new tqy(this, paramtrs)).a(new tqx(this, paramtrs));
      } else {
        this.jdField_a_of_type_Trl.a(new tpq(paramtrs.e, paramtrs.d, paramtrs.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(trt paramtrt)
  {
    paramtrt.jdField_a_of_type_Boolean = true;
  }
  
  public void c(trp paramtrp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    trp localtrp;
    if (this.jdField_a_of_type_Tpi != null)
    {
      localtrp = paramtrp;
      if (paramtrp == null)
      {
        localtrp = new trp();
        localtrp.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Tpi.a(localtrp);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localtrp));
  }
  
  protected void c(trt paramtrt)
  {
    String str = paramtrt.d;
    veg.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Trl.a(new trb(this, str, null, false, paramtrt));
    if ((paramtrt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Trl.a(new trc(this, paramtrt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrt));
    }
    for (;;)
    {
      this.jdField_a_of_type_Trl.a(new trf(this, paramtrt.e)).a(new tre(this, paramtrt.b, paramtrt.c, paramtrt)).a(new trn(this, paramtrt));
      return;
      if ((paramtrt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Trl.a(new trd(this, paramtrt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrt));
      }
    }
  }
  
  public void d(trp paramtrp)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    trp localtrp;
    if (this.jdField_a_of_type_Tpi != null)
    {
      localtrp = paramtrp;
      if (paramtrp == null)
      {
        localtrp = new trp();
        localtrp.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Tpi.b(localtrp);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localtrp));
  }
  
  public void e(trp paramtrp)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    trp localtrp;
    if (this.jdField_a_of_type_Tpi != null)
    {
      localtrp = paramtrp;
      if (paramtrp == null)
      {
        localtrp = new trp();
        localtrp.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Tpi.c(localtrp);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localtrp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqk
 * JD-Core Version:    0.7.0.1
 */