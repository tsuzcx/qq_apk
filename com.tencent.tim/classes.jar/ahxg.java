import QC.BubbleRsp;
import QC.CommonRsp;
import QC.FontRsp;
import QC.SetFontBubbleRsp;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.mobileqq.hiboom.FontBubbleManager.1;
import com.tencent.mobileqq.hiboom.FontBubbleManager.2;
import com.tencent.mobileqq.hiboom.FontBubblePanelView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class ahxg
  implements Handler.Callback
{
  private achq jdField_a_of_type_Achq = new ahxj(this);
  private ahyf jdField_a_of_type_Ahyf;
  private long[] ai;
  private ahyf b;
  private QQAppInterface mApp;
  private Handler mHandler;
  
  public ahxg(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.mApp.addObserver(this.jdField_a_of_type_Achq);
  }
  
  public static ahxg a(QQAppInterface paramQQAppInterface)
  {
    return ((aqrc)paramQQAppInterface.getManager(235)).b;
  }
  
  private void a(BaseChatPie paramBaseChatPie, long paramLong, int paramInt)
  {
    FontBubble localFontBubble = this.b.b;
    Object localObject2 = localFontBubble.title;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = acfp.m(2131706387);
    }
    Object localObject3 = localFontBubble.msg;
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = "开通QQ会员即可使用该气泡";
    }
    String str = localFontBubble.btn;
    localObject3 = str;
    if (TextUtils.isEmpty(str)) {
      localObject3 = "开通QQ会员";
    }
    str = URLEncoder.encode("jsbridge://font/fontBubblePaySuccess?p={\"sid\":" + paramLong + ",\"id\":" + paramInt + "}");
    str = localFontBubble.payUrl + "&return_url=" + str;
    if (QLog.isColorLevel()) {
      QLog.d("FontBubbleManager", 2, "url: " + str);
    }
    aqha.a(paramBaseChatPie.a(), 230, (String)localObject1, (CharSequence)localObject2, acfp.m(2131706388), (String)localObject3, new ahxh(this, paramBaseChatPie, str), new ahxi(this)).show();
  }
  
  private boolean aZ(int paramInt1, int paramInt2)
  {
    if (this.b != null)
    {
      if (paramInt1 == 5L) {
        if (paramInt2 != this.b.b.fontId) {}
      }
      while (paramInt2 == this.b.b.bubbleId)
      {
        return true;
        return false;
      }
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt1).append(", ").append(paramInt2).append(" is not currentSelect: ");
    if (this.b == null) {}
    for (Object localObject = "null";; localObject = this.b.b)
    {
      QLog.e("FontBubbleManager", 1, localObject);
      return false;
    }
  }
  
  private void et(Context paramContext)
  {
    QQToast.a(paramContext, 0, acfp.m(2131706386), 2000).show();
    int j;
    if (this.b != null)
    {
      paramContext = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      j = this.b.b.panelType;
      if (j != 3) {
        break label107;
      }
    }
    label107:
    for (int i = this.b.b.fontId;; i = this.b.b.bubbleId)
    {
      VasWebviewUtil.reportCommercialDrainage(paramContext, "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i), FontBubblePanelView.bW(j), "1", "", "", "", 0, 0, 0, 0);
      this.b = null;
      this.jdField_a_of_type_Ahyf = null;
      return;
    }
  }
  
  private void w(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontBubbleManager", 2, "sendMsg");
    }
    String str = paramBaseChatPie.a.getText().toString();
    if (TextUtils.isEmpty(str)) {
      QLog.e("FontBubbleManager", 1, "sendMsg fail input is empty");
    }
    do
    {
      return;
      ujt.d locald = new ujt.d();
      paramBaseChatPie.a(locald);
      locald.aSL = paramBaseChatPie.aSL;
      paramBaseChatPie.aSL = false;
      this.ai = ujt.a(this.mApp, paramBaseChatPie.a(), paramBaseChatPie.a(), str, new ArrayList(), locald);
      paramBaseChatPie.a.setText("");
      paramBaseChatPie.aey();
    } while (this.b == null);
    int j = this.b.b.panelType;
    if (j == 3) {}
    for (int i = this.b.b.fontId;; i = this.b.b.bubbleId)
    {
      VasWebviewUtil.reportCommercialDrainage(paramBaseChatPie.app.getCurrentUin(), "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i), FontBubblePanelView.bW(j), "0", "", "", "", 0, 0, 0, 0);
      this.b = null;
      return;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, Bundle paramBundle)
  {
    int i = paramBundle.getInt("sid");
    int j = paramBundle.getInt("id");
    boolean bool = aZ(i, j);
    if (QLog.isColorLevel()) {
      QLog.d("FontBubbleManager", 2, "onFontBubblePaySuccess: " + i + "," + j + "," + bool);
    }
    if (this.b != null)
    {
      i = this.b.b.panelType;
      VasWebviewUtil.reportCommercialDrainage(paramBaseChatPie.app.getCurrentUin(), "aio_iconA", "OpenSvip", "", 1, 0, 0, "", "", FontBubblePanelView.bW(i));
      this.b = new ahyf(this.b.b);
      this.b.cY(this.mApp);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt)
  {
    if ((paramBoolean) && (paramSetFontBubbleRsp.stRet != null) && (paramSetFontBubbleRsp.stRet.ret == 0))
    {
      if ((this.b != null) && (this.b.seq == paramInt))
      {
        if (((this.b.b.panelType == 3) && (paramSetFontBubbleRsp.stFontRsp.authRet == 0)) || ((this.b.b.panelType == 4) && (paramSetFontBubbleRsp.stBubbleRsp.authRet == 0)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FontBubbleManager", 2, "onSetFontBubble mClick success: " + this.b.b);
          }
          ThreadManagerV2.excute(new FontBubbleManager.2(this, paramBaseChatPie), 32, null, true);
          return;
        }
        QLog.e("FontBubbleManager", 1, "onSetFontBubble mClick fail: " + paramSetFontBubbleRsp.stFontRsp.authRet + "," + paramSetFontBubbleRsp.stBubbleRsp.authRet + this.b.b);
        if ((paramSetFontBubbleRsp.stFontRsp.authRet < 0) || (paramSetFontBubbleRsp.stBubbleRsp.authRet < 0))
        {
          et(paramBaseChatPie.a());
          return;
        }
        if (this.b.b.panelType == 3)
        {
          a(paramBaseChatPie, 5L, paramSetFontBubbleRsp.stFontRsp.fontID);
          return;
        }
        a(paramBaseChatPie, 2L, paramSetFontBubbleRsp.stBubbleRsp.bubbleID);
        return;
      }
      if ((this.jdField_a_of_type_Ahyf != null) && (this.jdField_a_of_type_Ahyf.seq == paramInt))
      {
        if ((paramSetFontBubbleRsp.stFontRsp.authRet != 0) || (paramSetFontBubbleRsp.stBubbleRsp.authRet != 0)) {
          QLog.e("FontBubbleManager", 1, "onSetFontBubble failed," + " fontAuth:" + paramSetFontBubbleRsp.stFontRsp.authRet + " bubbleAuth:" + paramSetFontBubbleRsp.stBubbleRsp.authRet + this.jdField_a_of_type_Ahyf.b);
        }
        for (;;)
        {
          this.jdField_a_of_type_Ahyf = null;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FontBubbleManager", 2, "onSetFontBubble mRestore success: " + this.jdField_a_of_type_Ahyf.b);
          }
        }
      }
      QLog.e("FontBubbleManager", 1, "onSetFontBubble seq out of date," + paramSetFontBubbleRsp.stFontRsp.fontID + "," + paramSetFontBubbleRsp.stBubbleRsp.bubbleID + " fontAuth:" + paramSetFontBubbleRsp.stFontRsp.authRet + " bubbleAuth:" + paramSetFontBubbleRsp.stBubbleRsp.authRet);
      return;
    }
    StringBuilder localStringBuilder = wja.b().append("onSetFontBubble failed,");
    if ((paramSetFontBubbleRsp != null) && (paramSetFontBubbleRsp.stRet != null))
    {
      localStringBuilder.append(paramSetFontBubbleRsp.stFontRsp.fontID).append(",").append(paramSetFontBubbleRsp.stBubbleRsp.bubbleID);
      localStringBuilder.append(" ret:");
      localStringBuilder.append(paramSetFontBubbleRsp.stRet.ret);
      localStringBuilder.append("err:");
      localStringBuilder.append(paramSetFontBubbleRsp.stRet.err);
    }
    QLog.e("FontBubbleManager", 1, localStringBuilder.toString());
    if ((this.b != null) && (this.b.seq == paramInt)) {
      QLog.e("FontBubbleManager", 1, "click failed: " + this.b.b);
    }
    if ((this.jdField_a_of_type_Ahyf != null) && (this.jdField_a_of_type_Ahyf.seq == paramInt)) {
      QLog.e("FontBubbleManager", 1, "restore failed: " + this.jdField_a_of_type_Ahyf.b);
    }
    et(paramBaseChatPie.a());
  }
  
  public void a(FontBubble paramFontBubble)
  {
    ThreadManagerV2.excute(new FontBubbleManager.1(this, paramFontBubble), 32, null, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1000: 
      paramMessage = (Object[])paramMessage.obj;
      this.jdField_a_of_type_Ahyf = new ahyf((FontBubble)paramMessage[0]);
      this.b = new ahyf((FontBubble)paramMessage[1]);
      this.b.cY(this.mApp);
      return true;
    }
    w((BaseChatPie)paramMessage.obj);
    return true;
  }
  
  public void ka(long paramLong)
  {
    long[] arrayOfLong;
    int j;
    int i;
    if (this.ai != null)
    {
      arrayOfLong = this.ai;
      j = arrayOfLong.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (arrayOfLong[i] != paramLong) {
          break label59;
        }
        this.ai = null;
        if (this.jdField_a_of_type_Ahyf != null) {
          this.jdField_a_of_type_Ahyf.cY(this.mApp);
        }
      }
      return;
      label59:
      i += 1;
    }
  }
  
  public void onDestory()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_Achq);
  }
  
  public static class a
    extends aclh
  {
    private WeakReference<BaseChatPie> gc;
    
    public a(BaseChatPie paramBaseChatPie)
    {
      this.gc = new WeakReference(paramBaseChatPie);
    }
    
    public void a(boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt)
    {
      BaseChatPie localBaseChatPie = (BaseChatPie)this.gc.get();
      if (localBaseChatPie != null) {
        ahxg.a(localBaseChatPie.app).a(localBaseChatPie, paramBoolean, paramSetFontBubbleRsp, paramInt);
      }
    }
    
    public void ci(Bundle paramBundle)
    {
      BaseChatPie localBaseChatPie = (BaseChatPie)this.gc.get();
      if (localBaseChatPie != null) {
        ahxg.a(localBaseChatPie.app).a(localBaseChatPie, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxg
 * JD-Core Version:    0.7.0.1
 */