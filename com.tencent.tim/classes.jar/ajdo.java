import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.data.PhoneContact;
import friendlist.GetOnlineInfoResp;
import java.util.List;
import mqq.manager.Manager;

public abstract interface ajdo
  extends Manager
{
  public abstract void J(int paramInt, List<String> paramList);
  
  public abstract boolean Ur();
  
  public abstract boolean Uv();
  
  public abstract RespondQueryQQBindingStat a();
  
  public abstract PhoneContact a(String paramString);
  
  public abstract void a(ajdo.a parama);
  
  public abstract void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp);
  
  public abstract PhoneContact b(String paramString);
  
  public abstract void b(ajdo.a parama);
  
  public abstract void bi(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract PhoneContact c(String paramString);
  
  public abstract List<PhoneContact> cY();
  
  public abstract List<List<PhoneContact>> cZ();
  
  public abstract void clK();
  
  public abstract void clO();
  
  public abstract Object[] d();
  
  public abstract void dR(String paramString1, String paramString2);
  
  public abstract List<PhoneContact> da();
  
  public abstract List<PhoneContact> db();
  
  public abstract String di(String paramString);
  
  public abstract String dv(String paramString);
  
  public abstract int xy();
  
  public static abstract interface a
  {
    public abstract void T(boolean paramBoolean, int paramInt);
    
    public abstract void eH(long paramLong);
    
    public abstract void sc(int paramInt);
    
    public abstract void sd(int paramInt);
    
    public abstract void se(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajdo
 * JD-Core Version:    0.7.0.1
 */