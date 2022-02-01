import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RequestFetchRunnable;
import com.tencent.av.random.RandomController.a;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.random.RandomWebProtocol.a;
import com.tencent.av.random.RandomWebProtocol.g;
import com.tencent.av.random.RandomWebProtocol.h;
import com.tencent.av.random.RandomWebProtocol.i;
import com.tencent.av.random.RandomWebProtocol.k;
import com.tencent.av.random.RandomWebProtocol.l;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class ire
  implements RandomWebProtocol.a
{
  public ire(RandomController paramRandomController) {}
  
  public void a(int paramInt, RandomWebProtocol.g paramg)
  {
    if (this.this$0.e == null) {}
    label517:
    label1015:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("RandomController", 2, "rsp.rsptype = " + paramg.asu + ", errCode = " + paramInt);
            }
            if ((paramg.asu == 1) || (paramg.asu == 2))
            {
              switch (paramInt)
              {
              case -2: 
              default: 
                RandomController.b(this.this$0);
                return;
              case 1: 
                if (RandomController.a(this.this$0).get() >= 3)
                {
                  RandomController.a(this.this$0);
                  return;
                }
                paramg = (RandomWebProtocol.h)paramg;
                RandomController.a(this.this$0).a(paramg);
                RandomController.a(this.this$0).getHandler().postDelayed(RandomController.a(this.this$0), paramg.asz);
                return;
              case 0: 
                RandomController.a(this.this$0, paramg);
                return;
              case -1: 
                RandomController.a(this.this$0);
                return;
              }
              RandomController.b(this.this$0, paramg);
              return;
            }
            if ((paramg.asu == -100) || (paramg.asu == 3))
            {
              if (RandomController.a(this.this$0) == 1)
              {
                if ((paramInt == 0) && ((paramg instanceof RandomWebProtocol.i)))
                {
                  paramg = (RandomWebProtocol.i)paramg;
                  this.this$0.e.a.ba = paramg.bg;
                  if (this.this$0.e.isConnected())
                  {
                    paramg = RandomController.a(this.this$0).iterator();
                    while (paramg.hasNext()) {
                      ((RandomController.a)paramg.next()).apJ();
                    }
                  }
                }
              }
              else if (RandomController.a(this.this$0) == 2)
              {
                Object localObject2;
                Object localObject1;
                if ((paramInt == 0) && ((paramg instanceof RandomWebProtocol.k)))
                {
                  localObject2 = (RandomWebProtocol.k)paramg;
                  if (((RandomWebProtocol.k)localObject2).asB != 0) {
                    if (((RandomWebProtocol.k)localObject2).asB != 2) {
                      break label517;
                    }
                  }
                  for (localObject1 = ((RandomWebProtocol.k)localObject2).Qf;; localObject1 = String.valueOf(((RandomWebProtocol.k)localObject2).mM))
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      VideoController.b localb = RandomController.a(this.this$0).a((String)localObject1);
                      if (localb != null)
                      {
                        localb.headUrl = ((RandomWebProtocol.k)localObject2).headurl;
                        RandomController.a(this.this$0).A((String)localObject1, ((RandomWebProtocol.k)localObject2).Ql, ((RandomWebProtocol.k)localObject2).headurl);
                        if (QLog.isColorLevel()) {
                          QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + localb.uin + ", headUrl:" + localb.headUrl);
                        }
                      }
                    }
                    localObject1 = RandomController.a(this.this$0).iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((RandomController.a)((Iterator)localObject1).next()).apJ();
                    }
                  }
                }
                if (paramInt == 100)
                {
                  localObject2 = RandomController.a(this.this$0).aN();
                  localObject1 = new StringBuilder();
                  localObject2 = ((ArrayList)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((StringBuilder)localObject1).append(((VideoController.b)((Iterator)localObject2).next()).uin).append("|");
                  }
                  if ((!this.this$0.Ur) && (RandomController.a(this.this$0) != null)) {
                    RandomController.a(this.this$0).a(RandomController.b(this.this$0), 5, ((StringBuilder)localObject1).toString(), this.this$0.av(RandomController.a(this.this$0).getAccount()), this.this$0.mK);
                  }
                }
                if ((paramg instanceof RandomWebProtocol.k))
                {
                  paramg = (RandomWebProtocol.k)paramg;
                  if ((!TextUtils.isEmpty(paramg.Qh)) && (TextUtils.isEmpty(this.this$0.e.a.Nc)))
                  {
                    this.this$0.e.a.Nc = (RandomController.a(this.this$0).getApp().getString(2131697962) + " “" + paramg.Qh + "” ");
                    RandomController.a(this.this$0, paramg.Qh);
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.this$0.e.a.Nc);
                    }
                  }
                }
              }
              if (paramInt == -3)
              {
                paramg = RandomController.a(this.this$0).iterator();
                while (paramg.hasNext()) {
                  ((RandomController.a)paramg.next()).apJ();
                }
              }
            }
            else
            {
              if ((!(paramg instanceof RandomWebProtocol.l)) || (paramg.asu != 5)) {
                break label1015;
              }
              if (paramInt != 0) {
                break;
              }
              paramg = (RandomWebProtocol.l)paramg;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "request room owner room owner change push，uin " + paramg.Qk + " [random room owner]");
              }
              this.this$0.aso = 5;
              this.this$0.PZ = paramg.Qk;
              paramg = RandomController.a(this.this$0).iterator();
              while (paramg.hasNext()) {
                ((RandomController.a)paramg.next()).apJ();
              }
            }
          }
        } while ((paramInt != -4) || (!QLog.isColorLevel()));
        QLog.e("RandomController", 2, "[random room owner] pull room fail fail");
        return;
      } while ((!(paramg instanceof RandomWebProtocol.l)) || (4 != paramg.asu));
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] RSP_MULTI_KICK_MEMBER");
      }
      RandomController.a(this.this$0).getHandler().removeCallbacks(RandomController.a(this.this$0));
      RandomController.a(this.this$0, false);
      paramg = (RandomWebProtocol.l)paramg;
      long l = paramg.z.optInt("groupid");
      this.this$0.PR = aqhs.hexString2String(paramg.z.optString("wording").trim());
      if (TextUtils.isEmpty(this.this$0.PR)) {
        this.this$0.PR = RandomController.a(this.this$0).getApp().getApplicationContext().getString(2131697955);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] KICK_MEMBER success groupId = " + l + ", mCurrGroupId = " + this.this$0.mK);
      }
      if (l == this.this$0.mK)
      {
        if (paramInt == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RandomController", 2, "[random room owner] KICK_MEMBER success");
          }
          this.this$0.aso = 6;
        }
        for (;;)
        {
          paramg = RandomController.a(this.this$0).iterator();
          while (paramg.hasNext()) {
            ((RandomController.a)paramg.next()).apJ();
          }
          break;
          if (paramInt == -4)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RandomController", 2, "[random room owner] KICK_MEMBER fail" + paramg.errmsg);
            }
            this.this$0.aso = 7;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "KICK_MEMBER success groupid != mCurrGroupId  [random room owner]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ire
 * JD-Core Version:    0.7.0.1
 */