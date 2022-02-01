import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class aejv
  extends aehv<aeju>
{
  @NonNull
  public aeju a(int paramInt)
  {
    return new aeju();
  }
  
  @Nullable
  public aeju a(aeic[] paramArrayOfaeic)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaeic != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaeic.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfaeic[0] != null)
        {
          localObject1 = aeju.a(paramArrayOfaeic[0].content);
          paramArrayOfaeic = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfaeic instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfaeic).getManager(217)).JV(((aeju)localObject1).byc);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(aeju paramaeju)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramaeju.toString());
    }
  }
  
  public Class<aeju> clazz()
  {
    return aeju.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 168;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejv
 * JD-Core Version:    0.7.0.1
 */