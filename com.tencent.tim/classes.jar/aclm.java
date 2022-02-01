import android.os.Bundle;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;

public class aclm
  implements acci
{
  protected void B(int paramInt, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString) {}
  
  protected void az(Object paramObject) {}
  
  protected void bh(int paramInt, String paramString) {}
  
  protected void bi(int paramInt, String paramString) {}
  
  protected void f(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void m(int paramInt, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    String str = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int i = -1;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      B(paramInt, (Bundle)paramObject);
      return;
    case 2: 
      m(paramInt, (Bundle)paramObject);
      return;
    case 3: 
      i = 0;
      str = "";
      localObject1 = str;
      paramInt = i;
      if (paramBoolean)
      {
        paramObject = (Bundle)paramObject;
        localObject1 = str;
        paramInt = i;
        if (paramObject != null)
        {
          paramInt = paramObject.getInt("status");
          localObject1 = paramObject.getString("wording");
        }
      }
      f(paramBoolean, paramInt, (String)localObject1);
      return;
    case 4: 
      if (paramBoolean)
      {
        paramObject = (Bundle)paramObject;
        if (paramObject != null)
        {
          paramInt = paramObject.getInt(AuthDevRenameActivity.aLs);
          localObject1 = paramObject.getByteArray(AuthDevRenameActivity.aLr);
          paramObject = paramObject.getString(AuthDevRenameActivity.aLp);
        }
      }
      break;
    }
    for (;;)
    {
      a(paramBoolean, paramInt, (byte[])localObject1, paramObject);
      return;
      v(paramBoolean, (Bundle)paramObject);
      return;
      w(paramBoolean, (Bundle)paramObject);
      return;
      localObject1 = (Bundle)paramObject;
      paramObject = str;
      if (localObject1 != null)
      {
        i = ((Bundle)localObject1).getInt("ret_code", -1);
        paramObject = ((Bundle)localObject1).getString("err_msg");
      }
      bh(i, paramObject);
      return;
      localObject1 = (Bundle)paramObject;
      paramObject = localObject2;
      if (localObject1 != null)
      {
        i = ((Bundle)localObject1).getInt("ret_code", -1);
        paramObject = ((Bundle)localObject1).getString("err_msg");
      }
      bi(i, paramObject);
      return;
      az(paramObject);
      return;
      paramInt = -1;
      str = null;
      paramObject = localObject1;
      localObject1 = str;
    }
  }
  
  protected void v(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void w(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclm
 * JD-Core Version:    0.7.0.1
 */