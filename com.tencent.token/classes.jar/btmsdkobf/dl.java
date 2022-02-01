package btmsdkobf;

import java.io.Serializable;
import java.util.List;

public class dl
  implements Serializable
{
  private List<Long> mY;
  
  public boolean b(int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!cx.y(paramInt))
    {
      if (!cx.z(paramInt)) {
        break label28;
      }
      bool1 = bool2;
    }
    label28:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.mY == null);
      bool2 = this.mY.contains(Long.valueOf(paramLong));
      bool1 = bool2;
    } while (bool2);
    eh.f("VipRule", "[shark_vip] request not allow currently, cmd: " + paramInt + " ident: " + paramLong + " mVipIdents: " + this.mY);
    return bool2;
  }
  
  public String toString()
  {
    return "mVipIdents|" + this.mY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dl
 * JD-Core Version:    0.7.0.1
 */