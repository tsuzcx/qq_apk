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

public abstract class qci
{
  public static Map<String, String> fO = new ConcurrentHashMap();
  public qbg a;
  public qdi a;
  private int blK;
  public Map<String, String> fP = new ConcurrentHashMap();
  public WeakReference<Activity> mContextWeakReference;
  
  public qci()
  {
    this.jdField_a_of_type_Qdi = new qdi();
  }
  
  public static String c(String paramString, Map<String, String> paramMap)
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
        ram.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void wf(int paramInt)
  {
    ram.d("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
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
      localObject = new qdk();
      ((qdk)localObject).blL = paramInt;
      new qdi.b(this, (qdk)localObject).bnG();
      return;
    case 1: 
      localObject = new qdl();
      ((qdl)localObject).blL = paramInt;
      h((qdk)localObject);
      a((qdl)localObject);
      i((qdk)localObject);
      b((qdl)localObject);
      return;
    case 2: 
      localObject = new qdm();
      ((qdm)localObject).blL = paramInt;
      h((qdk)localObject);
      a((qdm)localObject);
      i((qdk)localObject);
      b((qdm)localObject);
      return;
    case 3: 
      localObject = new qdo();
      ((qdo)localObject).blL = paramInt;
      h((qdk)localObject);
      a((qdo)localObject);
      i((qdk)localObject);
      c((qdo)localObject);
      return;
    case 4: 
      localObject = new qdo();
      ((qdo)localObject).blL = paramInt;
      ((qdo)localObject).isCircle = true;
      h((qdk)localObject);
      b((qdo)localObject);
      i((qdk)localObject);
      c((qdo)localObject);
      return;
    case 5: 
      localObject = new qdn();
      ((qdn)localObject).blL = paramInt;
      h((qdk)localObject);
      a((qdn)localObject);
      i((qdk)localObject);
      b((qdn)localObject);
      return;
    }
    Object localObject = new qdj();
    ((qdj)localObject).blL = paramInt;
    h((qdk)localObject);
    a((qdj)localObject);
    i((qdk)localObject);
    b((qdj)localObject);
  }
  
  protected String a(String paramString, qdk paramqdk)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(fO);
    if (paramqdk != null) {
      localHashMap.putAll(paramqdk.fQ);
    }
    localHashMap.putAll(this.fP);
    return c(paramString, localHashMap);
  }
  
  public void a(qdj paramqdj) {}
  
  public void a(qdl paramqdl) {}
  
  public void a(qdm paramqdm) {}
  
  public void a(qdn paramqdn) {}
  
  public void a(qdo paramqdo)
  {
    paramqdo.isCircle = false;
  }
  
  protected void b(qdj paramqdj)
  {
    String str = paramqdj.url;
    this.jdField_a_of_type_Qdi.a(new qcp(this, str, null, false, paramqdj)).a(new qco(this, paramqdj)).a(new qdi.b(this, paramqdj));
  }
  
  protected void b(qdl paramqdl)
  {
    if ((paramqdl.f != null) && (paramqdl.f.isPollVideo())) {
      this.jdField_a_of_type_Qdi.a(new qcj(this, paramqdl.f, paramqdl));
    }
    for (;;)
    {
      String str = paramqdl.msgAction;
      this.jdField_a_of_type_Qdi.a(new qcy(this, str, null, true, paramqdl)).a(new qdi.b(this, paramqdl));
      return;
      if ((paramqdl.f != null) && (paramqdl.f.isInteractVideo())) {
        this.jdField_a_of_type_Qdi.a(new qcu(this, paramqdl.f, paramqdl));
      }
    }
  }
  
  protected void b(qdm paramqdm)
  {
    String str = paramqdm.url;
    this.jdField_a_of_type_Qdi.a(new qde(this, str, null, false, paramqdm));
    if ((paramqdm.f != null) && (paramqdm.f.isPollVideo())) {
      this.jdField_a_of_type_Qdi.a(new qcl(this, paramqdm.f)).a(new qck(this, paramqdm));
    }
    for (;;)
    {
      this.jdField_a_of_type_Qdi.a(new qdi.b(this, paramqdm));
      return;
      if ((paramqdm.f != null) && (paramqdm.f.isInteractVideo())) {
        this.jdField_a_of_type_Qdi.a(new qcn(this, paramqdm.f)).a(new qcm(this, paramqdm));
      }
    }
  }
  
  protected void b(qdn paramqdn)
  {
    String str = paramqdn.url;
    this.jdField_a_of_type_Qdi.a(new qcq(this, str, null, false, paramqdn));
    if ((paramqdn.f != null) && (paramqdn.f.isPollVideo())) {
      this.jdField_a_of_type_Qdi.a(new qct(this, paramqdn.f, paramqdn)).a(new qcs(this, paramqdn)).a(new qcr(this, paramqdn));
    }
    for (;;)
    {
      this.jdField_a_of_type_Qdi.a(new qdi.b(this, paramqdn));
      return;
      if ((paramqdn.f != null) && (paramqdn.f.isInteractVideo())) {
        this.jdField_a_of_type_Qdi.a(new qcx(this, paramqdn.f, paramqdn)).a(new qcw(this, paramqdn)).a(new qcv(this, paramqdn));
      } else {
        this.jdField_a_of_type_Qdi.a(new qbo(paramqdn.imageUrl, paramqdn.awU, paramqdn.aCS));
      }
    }
  }
  
  public void b(qdo paramqdo)
  {
    paramqdo.isCircle = true;
  }
  
  protected abstract String bU(int paramInt);
  
  protected String bV(int paramInt)
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
  
  public void bd(@NonNull Activity paramActivity)
  {
    rom.checkNotNull(paramActivity);
    this.mContextWeakReference = new WeakReference(paramActivity);
  }
  
  protected void bnF()
  {
    sy(true);
  }
  
  protected void c(qdo paramqdo)
  {
    String str = paramqdo.url;
    ram.d("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Qdi.a(new qcz(this, str, null, false, paramqdo));
    if ((paramqdo.f != null) && (paramqdo.f.isPollVideo())) {
      this.jdField_a_of_type_Qdi.a(new qda(this, paramqdo.f, paramqdo));
    }
    for (;;)
    {
      this.jdField_a_of_type_Qdi.a(new qdd(this, paramqdo.imageUrl)).a(new qdc(this, paramqdo.aCS, paramqdo.aCT, paramqdo)).a(new qdi.b(this, paramqdo));
      return;
      if ((paramqdo.f != null) && (paramqdo.f.isInteractVideo())) {
        this.jdField_a_of_type_Qdi.a(new qdb(this, paramqdo.f, paramqdo));
      }
    }
  }
  
  protected void h(qdk paramqdk) {}
  
  protected final void i(qdk paramqdk)
  {
    ram.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramqdk);
    if ((paramqdk instanceof qdo)) {
      ((qdo)paramqdk).url = a(((qdo)paramqdk).url, paramqdk);
    }
    do
    {
      return;
      if ((paramqdk instanceof qdj))
      {
        ((qdj)paramqdk).url = a(((qdj)paramqdk).url, paramqdk);
        return;
      }
      if ((paramqdk instanceof qdn))
      {
        ((qdn)paramqdk).url = a(((qdn)paramqdk).url, paramqdk);
        return;
      }
      if ((paramqdk instanceof qdm))
      {
        ((qdm)paramqdk).url = a(((qdm)paramqdk).url, paramqdk);
        return;
      }
    } while (!(paramqdk instanceof qdl));
    ((qdl)paramqdk).msgAction = a(((qdl)paramqdk).msgAction, paramqdk);
  }
  
  public void j(qdk paramqdk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    qdk localqdk;
    if (this.jdField_a_of_type_Qbg != null)
    {
      localqdk = paramqdk;
      if (paramqdk == null)
      {
        localqdk = new qdk();
        localqdk.blL = this.blK;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Qbg.d(localqdk);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localqdk));
  }
  
  public void k(qdk paramqdk)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    qdk localqdk;
    if (this.jdField_a_of_type_Qbg != null)
    {
      localqdk = paramqdk;
      if (paramqdk == null)
      {
        localqdk = new qdk();
        localqdk.blL = this.blK;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Qbg.e(localqdk);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localqdk));
  }
  
  public void l(qdk paramqdk)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    qdk localqdk;
    if (this.jdField_a_of_type_Qbg != null)
    {
      localqdk = paramqdk;
      if (paramqdk == null)
      {
        localqdk = new qdk();
        localqdk.blL = this.blK;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Qbg.f(localqdk);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localqdk));
  }
  
  public void sy(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qdi.K(new ShareModeBase.23(this));
      return;
    }
    qdk localqdk = new qdk();
    localqdk.blL = this.blK;
    k(localqdk);
  }
  
  public final void vU(int paramInt)
  {
    this.blK = paramInt;
    bnF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qci
 * JD-Core Version:    0.7.0.1
 */