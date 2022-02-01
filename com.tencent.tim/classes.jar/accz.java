import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.util.Pair;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceRespInfo;

public class accz
  implements acci
{
  protected void E(boolean paramBoolean, long paramLong) {}
  
  protected void EH(boolean paramBoolean) {}
  
  protected void F(boolean paramBoolean, long paramLong) {}
  
  protected void a(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  protected void a(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList) {}
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper) {}
  
  protected void a(boolean paramBoolean, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  protected void aV(boolean paramBoolean, int paramInt) {}
  
  protected void au(boolean paramBoolean, String paramString) {}
  
  protected void b(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  protected void bw(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void bx(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void hB(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              E(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
              return;
              a(paramBoolean, (GetResourceRespInfo)paramObject);
              return;
              au(paramBoolean, (String)paramObject);
              return;
              a(paramBoolean, (UpgradeDetailWrapper)paramObject);
              return;
              a(paramBoolean, (AppShareID)paramObject);
              return;
              F(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
              return;
              aV(paramBoolean, ((Integer)paramObject).intValue());
              return;
              if ((paramObject != null) && ((paramObject instanceof OperateVoipTipsInfo)))
              {
                paramObject = (OperateVoipTipsInfo)paramObject;
                a(paramObject.uin, paramObject.uinType, paramObject.taskList);
              }
              EH(paramBoolean);
              return;
              paramObject = (Pair)paramObject;
              w(paramBoolean, (String)paramObject.first, (String)paramObject.second);
              return;
              bx(paramBoolean, ((Boolean)paramObject).booleanValue());
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
            bw(((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
            return;
          } while (!(paramObject instanceof Object[]));
          paramObject = (Object[])paramObject;
          a((Boolean)paramObject[0], (Boolean)paramObject[1], (String)paramObject[2], (String)paramObject[3], (String)paramObject[4]);
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while (paramObject.length <= 4);
      b((Boolean)paramObject[0], (Boolean)paramObject[1], (String)paramObject[2], (String)paramObject[3], (String)paramObject[4]);
      return;
    } while (!(paramObject instanceof Object[]));
    hB(((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
  
  protected void w(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accz
 * JD-Core Version:    0.7.0.1
 */