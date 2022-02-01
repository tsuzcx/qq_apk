import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class abld
  extends abkx
{
  public static boolean bDC;
  public static String bubbleId;
  public static String content;
  public static String tips;
  public static String url;
  int actionId;
  public DrawerPushItem c;
  int cpC = 7;
  long showTime;
  
  public abld(QQAppInterface paramQQAppInterface, DrawerPushItem paramDrawerPushItem)
  {
    super(paramQQAppInterface);
    this.priority = paramDrawerPushItem.priority;
    content = paramDrawerPushItem.content;
    this.actionId = paramDrawerPushItem.action_id;
    url = paramDrawerPushItem.ext_url;
    bubbleId = paramDrawerPushItem.msg_id;
    tips = paramDrawerPushItem.tips_str;
    if (paramDrawerPushItem.bubble_res_id == 32) {
      this.cpC = 7;
    }
    for (;;)
    {
      this.c = paramDrawerPushItem;
      return;
      if (paramDrawerPushItem.bubble_res_id == 33) {
        this.cpC = 6;
      } else {
        this.cpC = 9;
      }
    }
  }
  
  public int b(abrs paramabrs, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((this.bDy) || (this.c == null) || (this.c.show_sum >= this.c.show_counts)) {
      return super.b(paramabrs, paramInt, paramAppInterface, paramContext);
    }
    int i;
    boolean bool;
    if (this.actionId > abxi.ctt)
    {
      i = 3;
      bool = ApolloUtil.aH(5, this.actionId);
      if (this.actionId <= 0) {
        break label225;
      }
      if (!bool) {
        break label172;
      }
      paramAppInterface = new ApolloActionData();
      paramAppInterface.actionId = this.actionId;
      paramAppInterface.actionType = 0;
      paramInt = 6;
      abrj.a(paramabrs, 6, paramAppInterface);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AplloDrawerStatus", 2, new Object[] { "PushDrawerStatus onExecAction:", Integer.valueOf(this.actionId), ",rscType:", Integer.valueOf(paramInt), ",isRscDone:", Boolean.valueOf(bool) });
      }
      return 0;
      i = 2;
      break;
      label172:
      super.a(paramabrs, i, paramInt, paramAppInterface, paramContext);
      abto.b(paramAppInterface, ApolloUtil.dr(this.actionId) + "/d.zip", ApolloUtil.ds(this.actionId));
      paramInt = 0;
      continue;
      label225:
      super.a(paramabrs, i, paramInt, paramAppInterface, paramContext);
      paramInt = 0;
    }
  }
  
  public void b(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((this.bDy) || (this.c == null) || (this.c.show_sum >= this.c.show_counts))
    {
      bDC = false;
      this.bDz = false;
      if (QLog.isColorLevel()) {
        QLog.i("AplloDrawerStatus", 2, "ShowCount Max:" + this.bDy);
      }
      return;
    }
    boolean bool;
    if (this.c.is_reddot == 0)
    {
      bool = true;
      label88:
      bDC = bool;
      this.bDz = true;
      if (!TextUtils.isEmpty(content)) {
        abrj.a(paramabrs, content, this.cpC, this.c.bubble_res_id);
      }
      this.showTime = System.currentTimeMillis();
      paramabrs = (abhh)paramQQAppInterface.getManager(153);
      QLog.d("AplloDrawerStatus", 1, new Object[] { "compass report, show, advId=", bubbleId });
      paramContext = bubbleId;
      if (!paramabrs.bCD) {
        break label306;
      }
    }
    label306:
    for (paramInt = 0;; paramInt = 1)
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotShow", 0, 0, new String[] { paramContext, String.valueOf(paramInt), this.c.act_id });
      if ((this.c == null) || (TextUtils.isEmpty(this.c.reddotPath))) {
        break;
      }
      QLog.d("AplloDrawerStatus", 1, new Object[] { "tianshu report, show, advId=", bubbleId, ", path=", this.c.reddotPath });
      paramabrs = (altq)paramQQAppInterface.getManager(36);
      paramabrs.e(paramabrs.getAppInfoByPath(this.c.reddotPath), "");
      return;
      bool = false;
      break label88;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, abrs paramabrs)
  {
    super.b(paramQQAppInterface, paramabrs);
    if ((paramQQAppInterface == null) || (this.showTime == 0L)) {}
    do
    {
      return;
      bDC = false;
    } while (System.currentTimeMillis() - this.showTime <= 1000L);
    c(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    paramabrs = this.c;
    paramabrs.show_sum += 1;
    paramQQAppInterface = (abhh)paramQQAppInterface.getManager(153);
    if ((this.c.show_sum >= this.c.show_counts) && (this.c.is_reddot != 1))
    {
      paramQQAppInterface.a(this.c);
      return;
    }
    paramQQAppInterface.b(this.c);
  }
  
  public void c(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    g(paramQQAppInterface, paramContext);
  }
  
  public void ca(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (this.c == null)) {
      return;
    }
    paramQQAppInterface = (abhh)paramQQAppInterface.getManager(153);
    if (this.c.is_reddot != 1) {
      paramQQAppInterface.a(this.c);
    }
    this.c.show_sum = this.c.show_counts;
  }
  
  public void d(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    g(paramQQAppInterface, paramContext);
  }
  
  public void g(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (this.c == null)) {
      return;
    }
    ca(paramQQAppInterface);
    abhh localabhh = (abhh)paramQQAppInterface.getManager(153);
    if (this.c.reddotGameId > 0)
    {
      QLog.d("AplloDrawerStatus", 1, "onBubbleClick play game id:" + this.c.reddotGameId);
      ApolloGameUtil.a(paramQQAppInterface, this.c.reddotGameId, 0L, 0, null, 323, null);
      label89:
      QLog.d("AplloDrawerStatus", 1, new Object[] { "compass report, click, advId=", bubbleId });
      paramContext = bubbleId;
      if (!localabhh.bCD) {
        break label267;
      }
    }
    label267:
    for (int i = 0;; i = 1)
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotClear", 0, 0, new String[] { paramContext, String.valueOf(i), this.c.act_id });
      if ((this.c == null) || (TextUtils.isEmpty(this.c.reddotPath))) {
        break;
      }
      QLog.d("AplloDrawerStatus", 1, new Object[] { "tianshu report, click, advId=", bubbleId, ", path=", this.c.reddotPath });
      ((altq)paramQQAppInterface.getManager(36)).OS(this.c.reddotPath);
      return;
      localabhh.b(paramQQAppInterface, paramContext, this.c.scheme, this.c.ext_url, "drawer");
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abld
 * JD-Core Version:    0.7.0.1
 */