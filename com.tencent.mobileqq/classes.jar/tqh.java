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

public abstract class tqh
{
  public static Map<String, String> a;
  private int a;
  public WeakReference<Activity> a;
  public tpf a;
  public tri a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public tqh()
  {
    this.jdField_a_of_type_Tri = new tri();
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
        ved.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    ved.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
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
      localObject = new trm();
      ((trm)localObject).jdField_a_of_type_Int = paramInt;
      new trk(this, (trm)localObject).a();
      return;
    case 1: 
      localObject = new trn();
      ((trn)localObject).jdField_a_of_type_Int = paramInt;
      a_((trm)localObject);
      a((trn)localObject);
      b((trm)localObject);
      b((trn)localObject);
      return;
    case 2: 
      localObject = new tro();
      ((tro)localObject).jdField_a_of_type_Int = paramInt;
      a_((trm)localObject);
      a((tro)localObject);
      b((trm)localObject);
      b((tro)localObject);
      return;
    case 3: 
      localObject = new trq();
      ((trq)localObject).jdField_a_of_type_Int = paramInt;
      a_((trm)localObject);
      a((trq)localObject);
      b((trm)localObject);
      c((trq)localObject);
      return;
    case 4: 
      localObject = new trq();
      ((trq)localObject).jdField_a_of_type_Int = paramInt;
      ((trq)localObject).jdField_a_of_type_Boolean = true;
      a_((trm)localObject);
      b((trq)localObject);
      b((trm)localObject);
      c((trq)localObject);
      return;
    case 5: 
      localObject = new trp();
      ((trp)localObject).jdField_a_of_type_Int = paramInt;
      a_((trm)localObject);
      a((trp)localObject);
      b((trm)localObject);
      b((trp)localObject);
      return;
    }
    Object localObject = new trl();
    ((trl)localObject).jdField_a_of_type_Int = paramInt;
    a_((trm)localObject);
    a((trl)localObject);
    b((trm)localObject);
    b((trl)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, trm paramtrm)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramtrm != null) {
      localHashMap.putAll(paramtrm.jdField_a_of_type_JavaUtilMap);
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
    vxp.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(trl paramtrl) {}
  
  public void a(trn paramtrn) {}
  
  public void a(tro paramtro) {}
  
  public void a(trp paramtrp) {}
  
  public void a(trq paramtrq)
  {
    paramtrq.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Tri.a(new ShareModeBase.23(this));
      return;
    }
    trm localtrm = new trm();
    localtrm.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localtrm);
  }
  
  protected void a_(trm paramtrm) {}
  
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
  
  protected void b(trl paramtrl)
  {
    String str = paramtrl.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Tri.a(new tqo(this, str, null, false, paramtrl)).a(new tqn(this, paramtrl)).a(new trk(this, paramtrl));
  }
  
  protected final void b(trm paramtrm)
  {
    ved.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramtrm);
    if ((paramtrm instanceof trq)) {
      ((trq)paramtrm).d = a(((trq)paramtrm).d, paramtrm);
    }
    do
    {
      return;
      if ((paramtrm instanceof trl))
      {
        ((trl)paramtrm).jdField_a_of_type_JavaLangString = a(((trl)paramtrm).jdField_a_of_type_JavaLangString, paramtrm);
        return;
      }
      if ((paramtrm instanceof trp))
      {
        ((trp)paramtrm).c = a(((trp)paramtrm).c, paramtrm);
        return;
      }
      if ((paramtrm instanceof tro))
      {
        ((tro)paramtrm).e = a(((tro)paramtrm).e, paramtrm);
        return;
      }
    } while (!(paramtrm instanceof trn));
    ((trn)paramtrm).h = a(((trn)paramtrm).h, paramtrm);
  }
  
  protected void b(trn paramtrn)
  {
    if ((paramtrn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Tri.a(new tqi(this, paramtrn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrn));
    }
    for (;;)
    {
      String str = paramtrn.h;
      this.jdField_a_of_type_Tri.a(new tqx(this, str, null, true, paramtrn)).a(new trk(this, paramtrn));
      return;
      if ((paramtrn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Tri.a(new tqt(this, paramtrn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrn));
      }
    }
  }
  
  protected void b(tro paramtro)
  {
    String str = paramtro.e;
    this.jdField_a_of_type_Tri.a(new trd(this, str, null, false, paramtro));
    if ((paramtro.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtro.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Tri.a(new tqk(this, paramtro.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new tqj(this, paramtro));
    }
    for (;;)
    {
      this.jdField_a_of_type_Tri.a(new trk(this, paramtro));
      return;
      if ((paramtro.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtro.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Tri.a(new tqm(this, paramtro.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new tql(this, paramtro));
      }
    }
  }
  
  protected void b(trp paramtrp)
  {
    String str = paramtrp.c;
    this.jdField_a_of_type_Tri.a(new tqp(this, str, null, false, paramtrp));
    if ((paramtrp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Tri.a(new tqs(this, paramtrp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrp)).a(new tqr(this, paramtrp)).a(new tqq(this, paramtrp));
    }
    for (;;)
    {
      this.jdField_a_of_type_Tri.a(new trk(this, paramtrp));
      return;
      if ((paramtrp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Tri.a(new tqw(this, paramtrp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrp)).a(new tqv(this, paramtrp)).a(new tqu(this, paramtrp));
      } else {
        this.jdField_a_of_type_Tri.a(new tpn(paramtrp.e, paramtrp.d, paramtrp.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(trq paramtrq)
  {
    paramtrq.jdField_a_of_type_Boolean = true;
  }
  
  public void c(trm paramtrm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    trm localtrm;
    if (this.jdField_a_of_type_Tpf != null)
    {
      localtrm = paramtrm;
      if (paramtrm == null)
      {
        localtrm = new trm();
        localtrm.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Tpf.a(localtrm);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localtrm));
  }
  
  protected void c(trq paramtrq)
  {
    String str = paramtrq.d;
    ved.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Tri.a(new tqy(this, str, null, false, paramtrq));
    if ((paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Tri.a(new tqz(this, paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrq));
    }
    for (;;)
    {
      this.jdField_a_of_type_Tri.a(new trc(this, paramtrq.e)).a(new trb(this, paramtrq.b, paramtrq.c, paramtrq)).a(new trk(this, paramtrq));
      return;
      if ((paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Tri.a(new tra(this, paramtrq.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtrq));
      }
    }
  }
  
  public void d(trm paramtrm)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    trm localtrm;
    if (this.jdField_a_of_type_Tpf != null)
    {
      localtrm = paramtrm;
      if (paramtrm == null)
      {
        localtrm = new trm();
        localtrm.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Tpf.b(localtrm);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localtrm));
  }
  
  public void e(trm paramtrm)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    trm localtrm;
    if (this.jdField_a_of_type_Tpf != null)
    {
      localtrm = paramtrm;
      if (paramtrm == null)
      {
        localtrm = new trm();
        localtrm.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Tpf.c(localtrm);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localtrm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqh
 * JD-Core Version:    0.7.0.1
 */