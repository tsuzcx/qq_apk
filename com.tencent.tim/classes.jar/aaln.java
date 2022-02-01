import com.tencent.qphone.base.util.BaseApplication;

public class aaln
{
  public static Object a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    aalj localaalj = null;
    Object localObject1 = localaalj;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        localObject1 = localaalj;
      }
    }
    else {
      return localObject1;
    }
    switch (paramInt)
    {
    }
    for (localObject1 = localObject2;; localObject1 = new String(paramArrayOfByte))
    {
      localaalj = b(paramInt);
      if (localaalj == null) {
        break;
      }
      localaalj.ap(paramArrayOfByte);
      return localaalj;
    }
  }
  
  public static byte[] a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      switch (paramInt)
      {
      }
    } while (!(paramObject instanceof aall));
    return ((aall)paramObject).serialize();
    return ((String)paramObject).getBytes();
  }
  
  public static aalj b(int paramInt)
  {
    switch (paramInt)
    {
    case 15: 
    case 18: 
    case 19: 
    case 25: 
    case 26: 
    case 28: 
    default: 
      return null;
    case 17: 
      return new aamf(BaseApplication.getContext());
    case 16: 
      return new aalx(BaseApplication.getContext());
    case 10: 
      return new aals(BaseApplication.getContext());
    case 11: 
    case 29: 
      return new aalz(BaseApplication.getContext(), false);
    case 24: 
      return new aalp(BaseApplication.getContext());
    case 13: 
      return new aalo(BaseApplication.getContext());
    case 5: 
      return new awke(BaseApplication.getContext());
    case 14: 
    case 27: 
      return new aamc(BaseApplication.getContext());
    case 7: 
      return new aalv(BaseApplication.getContext());
    case 22: 
      return new aamd(BaseApplication.getContext());
    case 3: 
      return new aaly(BaseApplication.getContext(), 1);
    case 2: 
      return new aaly(BaseApplication.getContext(), 0);
    case 21: 
      return new aalr(BaseApplication.getContext());
    case 8: 
      return new aama(BaseApplication.getContext());
    case 4: 
      return new aalw(BaseApplication.getContext());
    case 9: 
      return new aamg(BaseApplication.getContext());
    case 12: 
      return new aamb(BaseApplication.getContext());
    case 6: 
      return new aalt(BaseApplication.getContext());
    case 20: 
      return new aalk(BaseApplication.getContext(), "");
    }
    return new aame(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaln
 * JD-Core Version:    0.7.0.1
 */