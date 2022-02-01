import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public abstract class igm<T>
  extends aehv<T>
{
  final String TAG;
  final int mConfigID;
  
  public igm(int paramInt)
  {
    this.mConfigID = paramInt;
    this.TAG = ("QAVConfig_" + this.mConfigID);
  }
  
  @Nullable
  static aeic a(String paramString, int paramInt, aeic[] paramArrayOfaeic)
  {
    Object localObject1 = null;
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0))
    {
      paramArrayOfaeic = (aeic[])localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i(paramString, 2, "getSuitableItem, confFiles is null or empty.");
        paramArrayOfaeic = (aeic[])localObject1;
      }
      return paramArrayOfaeic;
    }
    int i;
    if ((QLog.isDevelopLevel()) || (paramArrayOfaeic.length > 1))
    {
      i = 1;
      label47:
      localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramInt = aeif.a().q(paramInt, ((AppInterface)localObject1).getCurrentAccountUin());
      if (i == 0) {
        break label341;
      }
    }
    label139:
    label338:
    label341:
    for (Object localObject2 = "getSuitableItem, Version[" + paramInt + "], size[" + paramArrayOfaeic.length + "]";; localObject2 = null)
    {
      localObject1 = paramArrayOfaeic[0];
      Object localObject4 = localObject2;
      Object localObject3 = localObject1;
      int j;
      if (paramArrayOfaeic.length > 1)
      {
        int k = paramArrayOfaeic.length;
        paramInt = 0;
        j = 0;
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (paramInt < k)
        {
          localObject4 = paramArrayOfaeic[paramInt];
          int m = ad(((aeic)localObject4).content);
          localObject3 = localObject2;
          if (i != 0) {
            localObject3 = (String)localObject2 + ", \nindex[" + j + "], taskId[" + ((aeic)localObject4).taskId + "], task_id[" + m + "]";
          }
          if (m != ((aeic)localObject4).taskId) {
            break label338;
          }
          localObject1 = localObject4;
        }
      }
      for (;;)
      {
        j += 1;
        paramInt += 1;
        localObject2 = localObject3;
        break label139;
        i = 0;
        break label47;
        paramArrayOfaeic = (aeic[])localObject3;
        if (i == 0) {
          break;
        }
        paramArrayOfaeic = (String)localObject4 + ", \nselect taskId[" + ((aeic)localObject3).taskId;
        QLog.w(paramString, 1, paramArrayOfaeic + "], content\n" + ((aeic)localObject3).content);
        return localObject3;
      }
    }
  }
  
  private static int ad(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("task_id");
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  @NonNull
  protected abstract T a(aeic[] paramArrayOfaeic)
    throws Exception;
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int ku()
  {
    String str = "";
    if (isAccountRelated()) {
      str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    }
    return aeif.a().q(this.mConfigID, str);
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public final T onParsed(aeic[] paramArrayOfaeic)
  {
    try
    {
      Object localObject = a(paramArrayOfaeic);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.w(this.TAG, 1, "onParsed, 配置解析异常, [\n" + paramArrayOfaeic[0].content + "\n]", localException);
      AudioHelper.UB(this.TAG + acfp.m(2131710317));
    }
    return migrateOldOrDefaultContent(type());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      int i = ku();
      QLog.w(this.TAG, 1, "onReqFailed, failCode[" + paramInt + "], version[" + i + "]");
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isDevelopLevel())
    {
      int i = ku();
      QLog.w(this.TAG, 1, "onReqNoReceive, version[" + i + "]");
    }
  }
  
  public void onUpdate(T paramT)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "onUpdate, " + paramT);
    }
  }
  
  public int type()
  {
    return this.mConfigID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igm
 * JD-Core Version:    0.7.0.1
 */