import java.util.HashMap;
import java.util.Map;

public class asrt
{
  private static asrt a;
  long axG = 1L;
  Map<Long, asrt.a> pl = new HashMap();
  
  public static asrt a()
  {
    if (a == null) {
      a = new asrt();
    }
    return a;
  }
  
  public void a(int paramInt, asrt.a parama)
  {
    long l = in();
    this.pl.put(Long.valueOf(l), parama);
    parama = abmt.a();
    if (parama != null) {
      parama.z("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    asrt.a locala;
    if (this.pl.containsKey(Long.valueOf(paramLong)))
    {
      locala = (asrt.a)this.pl.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      locala.onSuccess(paramArrayOfByte);
    }
    for (;;)
    {
      this.pl.remove(Long.valueOf(paramLong));
      return;
      label62:
      locala.onError(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, asrt.a parama)
  {
    long l = in();
    this.pl.put(Long.valueOf(l), parama);
    paramString1 = abmt.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
  
  long in()
  {
    return this.axG % 1000L + 1L;
  }
  
  public static abstract interface a
  {
    public abstract void onError(int paramInt, String paramString);
    
    public abstract void onSuccess(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asrt
 * JD-Core Version:    0.7.0.1
 */