import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class xwy
  extends ashx
{
  xwy(xwq paramxwq) {}
  
  protected void a(boolean paramBoolean, ashy.a parama)
  {
    boolean bool = true;
    if ((paramBoolean) && (parama != null)) {
      if ((this.a.sessionInfo.aTl != null) && (this.a.sessionInfo.aTl.equals(String.valueOf(parama.puin)))) {
        if (parama.isShow == 1)
        {
          localashz = (ashz)this.a.app.getBusinessHandler(105);
          localPubAccountNavigationMenu = localashz.a(this.a.sessionInfo.aTl);
          localxwq = this.a;
          if (parama.emf == 0)
          {
            paramBoolean = bool;
            xwq.b(localxwq, paramBoolean);
            if ((localPubAccountNavigationMenu != null) && (parama.emf == localPubAccountNavigationMenu.version)) {
              break label152;
            }
            localashz.bC(this.a.sessionInfo.aTl, parama.axh);
          }
        }
      }
    }
    label152:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          PubAccountNavigationMenu localPubAccountNavigationMenu;
          for (;;)
          {
            ashz localashz;
            xwq localxwq;
            return;
            paramBoolean = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
          }
          if (xwq.a(this.a) == 0)
          {
            this.a.a(localPubAccountNavigationMenu);
            return;
          }
          xwq.a(this.a, 0);
          return;
          if (parama.emg == 1) {
            xwq.a(this.a, 1);
          }
        } while (!QLog.isColorLevel());
        QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response no need show");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response not the same aio");
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response error");
  }
  
  protected void a(boolean paramBoolean, PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if (paramBoolean) {
      if ((!xwq.b(this.a)) && (xwq.a(this.a) != 0)) {
        xwq.a(this.a, 0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.a.a(paramPubAccountNavigationMenu);
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetNatigation response error");
  }
  
  protected void c(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if (this.a.sessionInfo.aTl.equals(paramHashMap.uin))
      {
        if ((TextUtils.isEmpty(this.a.sessionInfo.aTn)) || (this.a.sessionInfo.aTn.equals(this.a.sessionInfo.aTl)))
        {
          this.a.sessionInfo.aTn = paramHashMap.nickname;
          this.a.mTitleText.setText(this.a.sessionInfo.aTn);
        }
        this.a.bGT();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo not current uin");
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo fail");
  }
  
  protected void d(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    int i = 0;
    super.d(paramBoolean, paramHashMap);
    if ((paramBoolean) && (paramHashMap != null)) {}
    try
    {
      int j = Integer.parseInt(String.valueOf(paramHashMap.get("result")));
      String.valueOf(paramHashMap.get("master_uin"));
      if ((this.a.sessionInfo.aTl != null) && (j == 1))
      {
        long l1 = Long.parseLong(this.a.sessionInfo.aTl);
        paramHashMap = ((ashz)this.a.app.getBusinessHandler(105)).a(this.a.sessionInfo.aTl);
        ashy localashy = (ashy)this.a.app.getBusinessHandler(85);
        long l2 = this.a.app.getLongAccountUin();
        if (paramHashMap != null) {
          i = paramHashMap.version;
        }
        localashy.c(l1, l2, i, xwq.a(this.a), false);
      }
      return;
    }
    catch (Exception paramHashMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwy
 * JD-Core Version:    0.7.0.1
 */