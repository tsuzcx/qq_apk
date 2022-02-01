import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class abii
{
  public static String TAG = "ApolloRenderInterfaceImpl";
  private ApolloRenderDriver mApolloWorker;
  private ApolloRender mRender;
  
  public abii(ApolloRenderDriver paramApolloRenderDriver, ApolloRender paramApolloRender)
  {
    this.mApolloWorker = paramApolloRenderDriver;
    this.mRender = paramApolloRender;
  }
  
  public int a(int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[onSetActions], actionId:" + paramInt1);
    }
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length != 2) || (this.mApolloWorker == null)) {
      i = 1;
    }
    do
    {
      return i;
      File localFile = new File(ApolloRender.getRscStaticPath(paramArrayOfString1[0], "json"));
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "errInfo->rsc NOT exist. rscFile:" + localFile);
        }
        return 2;
      }
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length == 2))
      {
        localFile = new File(ApolloRender.getRscStaticPath(paramArrayOfString2[0], "json"));
        if (!localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "errInfo->rsc NOT exist. rscFile:" + localFile);
          }
          return 2;
        }
      }
    } while (this.mApolloWorker == null);
    return this.mApolloWorker.a(paramInt1, paramInt2, paramArrayOfString1, paramArrayOfString2);
  }
  
  public int a(int paramInt1, String paramString, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[onLoadRole] roleType=", Integer.valueOf(paramInt1), ", apolloId=", paramString, ", roleId=", Integer.valueOf(paramInt2), ", roleScale=", Float.valueOf(paramFloat1), ", xPos=", Float.valueOf(paramFloat2), ", yPos=", Float.valueOf(paramFloat3) });
    }
    if (!ApolloUtil.ih(paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "errInfo->role rsc NOT exist.");
      }
      i = 2;
    }
    while (this.mApolloWorker == null) {
      return i;
    }
    paramInt1 = this.mApolloWorker.a(paramInt1, paramString, paramInt2, paramFloat1, paramFloat2, paramFloat3);
    this.mApolloWorker.aNu();
    return paramInt1;
  }
  
  public int a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[onExecAction] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt2), ", roleType=", Integer.valueOf(paramInt1), ", actionId=", Integer.valueOf(paramInt2), ", taskId=", Integer.valueOf(paramInt3), ", actionRscName=", paramString2, ", animName=", paramString3 });
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (this.mApolloWorker == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "errInfo->null param.");
      }
      i = 1;
    }
    do
    {
      do
      {
        do
        {
          return i;
          File localFile = new File(ApolloRender.getRscStaticPath(paramString2, "json"));
          if (!localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "errInfo->rsc NOT exist. rscFile:" + localFile);
            }
            return 2;
          }
        } while (this.mApolloWorker == null);
        if (this.mRender != null) {
          this.mRender.mIsFrameMode = false;
        }
        this.mApolloWorker.aNu();
        paramInt1 = this.mApolloWorker.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramString3);
        i = paramInt1;
      } while (paramInt1 != 0);
      i = paramInt1;
    } while (paramInt3 >= 1000000);
    this.mApolloWorker.aS.set(8);
    return paramInt1;
  }
  
  public int a(int paramInt, String paramString, int[] paramArrayOfInt, abvo paramabvo)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[onChangeDress] apolloId=", paramString, ", roleType=", Integer.valueOf(paramInt), ", dressId=", paramArrayOfInt, ", callback=", paramabvo });
    }
    int i;
    if (paramArrayOfInt == null) {
      i = 1;
    }
    do
    {
      return i;
      i = 0;
      while (i < paramArrayOfInt.length)
      {
        if (!ApolloUtil.ig(paramArrayOfInt[i]))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "errInfo->dress rsc NOT exist, id:" + paramArrayOfInt[i]);
          }
          return 2;
        }
        i += 1;
      }
      i = j;
    } while (this.mApolloWorker == null);
    paramInt = this.mApolloWorker.a(paramInt, paramString, paramArrayOfInt, paramabvo);
    this.mApolloWorker.aNu();
    return paramInt;
  }
  
  public int b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    int i = 1;
    if (this.mApolloWorker != null) {
      i = this.mApolloWorker.b(paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramString3);
    }
    return i;
  }
  
  public ApolloRender getRender()
  {
    return this.mRender;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[onDestroy]");
    }
    if (this.mApolloWorker != null) {
      this.mApolloWorker.onDestroy();
    }
  }
  
  public void onExecDispose()
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.onExecDispose();
    }
  }
  
  public void onExecDispose(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[onExecDispose] apolloId=", paramString });
    }
    if ((this.mApolloWorker != null) && (!TextUtils.isEmpty(paramString))) {
      this.mApolloWorker.onExecDispose(paramString);
    }
  }
  
  public void run()
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.aNu();
    }
  }
  
  public void stopLoopDelayed(long paramLong)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.stopLoopDelayed(paramLong);
    }
  }
  
  public void u(int paramInt, String paramString1, String paramString2)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.u(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abii
 * JD-Core Version:    0.7.0.1
 */