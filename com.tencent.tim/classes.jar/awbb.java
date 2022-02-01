import cooperation.qzone.util.NetworkState;

public class awbb
  extends awaw
{
  public static final String TAG = awbb.class.getName();
  public int ezN = -1;
  
  public awbb(String paramString)
  {
    super(paramString);
  }
  
  public static boolean aMb()
  {
    if (awbj.getContext() == null) {
      return false;
    }
    return NetworkState.isWap();
  }
  
  public awaw.a a()
  {
    if ((aMb()) && (this.ezN == 1)) {
      return awaw.a.a;
    }
    return null;
  }
  
  public int aw(String paramString, int paramInt)
  {
    if (this.ezN == -1)
    {
      int j = super.aw(paramString, paramInt);
      int i = j;
      if (aMb())
      {
        if (j != 0)
        {
          this.ezN = 1;
          i = super.aw(paramString, paramInt);
        }
      }
      else {
        return i;
      }
      this.ezN = 0;
      return j;
    }
    return super.aw(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awbb
 * JD-Core Version:    0.7.0.1
 */