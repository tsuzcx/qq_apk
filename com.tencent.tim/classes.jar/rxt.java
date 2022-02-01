import NS_COMM.COMM.StCommonExt;
import com.tencent.common.app.BaseApplicationImpl;

public class rxt
{
  private COMM.StCommonExt a;
  private String aDi;
  private String aDj;
  private volatile boolean isFinish = true;
  private volatile int mCurrentState = 4;
  
  public boolean Mg()
  {
    return this.mCurrentState == 1;
  }
  
  public boolean Mh()
  {
    return this.mCurrentState == 2;
  }
  
  public boolean Mi()
  {
    return this.mCurrentState == 3;
  }
  
  public void a(COMM.StCommonExt paramStCommonExt)
  {
    this.a = paramStCommonExt;
  }
  
  public COMM.StCommonExt b()
  {
    return this.a;
  }
  
  public COMM.StCommonExt c()
  {
    return this.a;
  }
  
  public boolean isFinish()
  {
    return this.isFinish;
  }
  
  public boolean isLoading()
  {
    return this.mCurrentState != 4;
  }
  
  public String nm()
  {
    return this.aDi;
  }
  
  public String nn()
  {
    if (this.aDj == null) {
      this.aDj = aqfe.get(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache");
    }
    return this.aDj;
  }
  
  public void sP(String paramString)
  {
    this.aDi = paramString;
  }
  
  public void sQ(String paramString)
  {
    if (paramString != null) {
      aqfe.J(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.aDj = paramString;
  }
  
  public void setCurrentState(int paramInt)
  {
    this.mCurrentState = paramInt;
  }
  
  public void setFinish(boolean paramBoolean)
  {
    this.isFinish = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxt
 * JD-Core Version:    0.7.0.1
 */