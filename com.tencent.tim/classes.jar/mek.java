import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;

public class mek
{
  private mef.a jdField_a_of_type_Mef$a;
  @Nullable
  private mef.b jdField_a_of_type_Mef$b;
  
  public mek(mef.a parama)
  {
    this.jdField_a_of_type_Mef$a = parama;
  }
  
  public void Q(int paramInt1, int paramInt2, int paramInt3)
  {
    c("", paramInt1, paramInt2, paramInt3);
  }
  
  public void a(long paramLong, String paramString1, @Nullable mdp parammdp, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Mef$b != null) {
      this.jdField_a_of_type_Mef$b.a(paramLong, paramString1, parammdp, paramString2, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(mef.b paramb)
  {
    this.jdField_a_of_type_Mef$b = paramb;
  }
  
  public void b(@Nullable String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Mef$a.a(new mel(this, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    RIJRedPacketManager.a().aOF();
    if (paramInt1 == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Mef$a.a(i, paramString, "", new mem(this, paramInt1, paramInt2, paramInt3));
      return;
      if (paramInt1 == 3) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public void detachView()
  {
    this.jdField_a_of_type_Mef$b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mek
 * JD-Core Version:    0.7.0.1
 */