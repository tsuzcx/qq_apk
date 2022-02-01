package btmsdkobf;

import java.io.Serializable;
import java.util.List;

public class dl
  implements Serializable
{
  private List<Long> mY;
  
  public boolean b(int paramInt, long paramLong)
  {
    boolean bool3 = cx.y(paramInt);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (cx.z(paramInt)) {
        return true;
      }
      Object localObject = this.mY;
      bool1 = bool2;
      if (localObject != null)
      {
        bool2 = ((List)localObject).contains(Long.valueOf(paramLong));
        bool1 = bool2;
        if (!bool2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[shark_vip] request not allow currently, cmd: ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(" ident: ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" mVipIdents: ");
          ((StringBuilder)localObject).append(this.mY);
          eh.f("VipRule", ((StringBuilder)localObject).toString());
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mVipIdents|");
    localStringBuilder.append(this.mY);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dl
 * JD-Core Version:    0.7.0.1
 */