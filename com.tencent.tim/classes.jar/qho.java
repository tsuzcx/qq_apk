import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class qho
  implements qgy
{
  private qgy.d a;
  public final String axs;
  private qgy.f b;
  private qgy.a c;
  public final List<String> nv = new ArrayList();
  
  public qho(String paramString)
  {
    this.nv.add(paramString);
    this.axs = paramString;
    this.c = new qgy.a();
    this.c.aDq = true;
    this.c.aDp = true;
    this.c.nP = new ArrayList();
    this.a = new qgy.d(new qgy.c("TROOP_GROUD_ID"));
    this.a.axq = this.axs;
    this.a.nv = this.nv;
    this.a.fR.put(this.axs, "TROOP_FEED_ID");
    this.c.nP.add(this.a);
    this.b = new qgy.f(new qgy.c("TROOP_GROUD_ID"), this.axs, "TROOP_FEED_ID");
    this.b.a = this.a;
  }
  
  public qgy.a a(@Nullable qgy.c paramc, int paramInt)
  {
    return this.c;
  }
  
  public void a(@Nullable qgy.c paramc, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qgy.e parame) {}
  
  public qgy.f b()
  {
    return this.b;
  }
  
  public void b(qgy.e parame) {}
  
  public void c(@Nullable qgy.c paramc, String paramString) {}
  
  public void create() {}
  
  public void destroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qho
 * JD-Core Version:    0.7.0.1
 */