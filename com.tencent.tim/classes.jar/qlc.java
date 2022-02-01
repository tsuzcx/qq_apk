import android.view.View;

public class qlc
  implements qlb
{
  private qlb jdField_a_of_type_Qlb;
  private qlc.a jdField_a_of_type_Qlc$a = new qlc.a(null);
  private qlc.b jdField_a_of_type_Qlc$b = new qlc.b(null);
  private qlc.c jdField_a_of_type_Qlc$c = new qlc.c(null);
  private qlc.d jdField_a_of_type_Qlc$d;
  
  public qlc(qlb paramqlb)
  {
    this.jdField_a_of_type_Qlb = paramqlb;
  }
  
  public qlb a()
  {
    return this.jdField_a_of_type_Qlb;
  }
  
  public qle.a a()
  {
    return this.jdField_a_of_type_Qlb.a();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qlb.a(paramString1, paramString2, paramString3, paramLong, paramInt1, paramInt2);
  }
  
  public void a(qlb.a parama)
  {
    this.jdField_a_of_type_Qlb.a(parama);
  }
  
  public void a(qlb.b paramb)
  {
    this.jdField_a_of_type_Qlb.a(paramb);
  }
  
  public void a(qlb.c paramc)
  {
    this.jdField_a_of_type_Qlc$a.a = paramc;
    this.jdField_a_of_type_Qlb.a(this.jdField_a_of_type_Qlc$a);
  }
  
  public void a(qlb.d paramd)
  {
    this.jdField_a_of_type_Qlc$b.a = paramd;
    this.jdField_a_of_type_Qlb.a(this.jdField_a_of_type_Qlc$b);
  }
  
  public void a(qlb.e parame)
  {
    this.jdField_a_of_type_Qlc$c.a = parame;
    this.jdField_a_of_type_Qlb.a(this.jdField_a_of_type_Qlc$c);
  }
  
  public void a(qlc.d paramd)
  {
    this.jdField_a_of_type_Qlc$d = paramd;
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Qlb.destroy();
  }
  
  public long getCurrentPosition()
  {
    return this.jdField_a_of_type_Qlb.getCurrentPosition();
  }
  
  public long getDuration()
  {
    return this.jdField_a_of_type_Qlb.getDuration();
  }
  
  public int getPlayType()
  {
    return this.jdField_a_of_type_Qlb.getPlayType();
  }
  
  public View getView()
  {
    return this.jdField_a_of_type_Qlb.getView();
  }
  
  public boolean isPlaying()
  {
    return this.jdField_a_of_type_Qlb.isPlaying();
  }
  
  public void pause()
  {
    if (this.jdField_a_of_type_Qlc$d != null) {
      this.jdField_a_of_type_Qlc$d.c(this.jdField_a_of_type_Qlb);
    }
    this.jdField_a_of_type_Qlb.pause();
  }
  
  public void restart()
  {
    if (this.jdField_a_of_type_Qlc$d != null)
    {
      this.jdField_a_of_type_Qlc$d.a(0L, this.jdField_a_of_type_Qlb.getDuration(), this.jdField_a_of_type_Qlb);
      this.jdField_a_of_type_Qlc$d.b(this.jdField_a_of_type_Qlb);
    }
    this.jdField_a_of_type_Qlb.restart();
  }
  
  public int sI()
  {
    return this.jdField_a_of_type_Qlb.sI();
  }
  
  public void setVisibility(int paramInt)
  {
    this.jdField_a_of_type_Qlb.setVisibility(paramInt);
  }
  
  public void start()
  {
    if (this.jdField_a_of_type_Qlc$d != null) {
      this.jdField_a_of_type_Qlc$d.b(this.jdField_a_of_type_Qlb);
    }
    this.jdField_a_of_type_Qlb.start();
  }
  
  public void stopPlayback()
  {
    this.jdField_a_of_type_Qlb.stopPlayback();
  }
  
  class a
    implements qlb.c
  {
    public qlb.c a;
    
    private a() {}
    
    public boolean a(qlb paramqlb, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
    {
      if (qlc.a(this.jdField_a_of_type_Qlc) != null) {
        qlc.a(this.jdField_a_of_type_Qlc).c(qlc.a(this.jdField_a_of_type_Qlc));
      }
      if (this.jdField_a_of_type_Qlb$c != null) {
        return this.jdField_a_of_type_Qlb$c.a(paramqlb, paramInt1, paramInt2, paramInt3, paramString, paramObject);
      }
      return false;
    }
  }
  
  class b
    implements qlb.d
  {
    public qlb.d a;
    
    private b() {}
    
    public boolean a(qlb paramqlb, int paramInt, Object paramObject)
    {
      if (qlc.a(this.jdField_a_of_type_Qlc) != null)
      {
        if (paramInt != 2) {
          break label54;
        }
        qlc.a(this.jdField_a_of_type_Qlc).c(qlc.a(this.jdField_a_of_type_Qlc));
      }
      while (this.jdField_a_of_type_Qlb$d != null)
      {
        return this.jdField_a_of_type_Qlb$d.a(paramqlb, paramInt, paramObject);
        label54:
        if (paramInt == 3) {
          qlc.a(this.jdField_a_of_type_Qlc).b(qlc.a(this.jdField_a_of_type_Qlc));
        }
      }
      return false;
    }
  }
  
  class c
    implements qlb.e
  {
    public qlb.e a;
    
    private c() {}
    
    public void d(qlb paramqlb)
    {
      if (qlc.a(this.jdField_a_of_type_Qlc) != null) {
        qlc.a(this.jdField_a_of_type_Qlc).a(0L, paramqlb.getDuration(), paramqlb);
      }
      if (this.jdField_a_of_type_Qlb$e != null) {
        this.jdField_a_of_type_Qlb$e.d(paramqlb);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(long paramLong1, long paramLong2, qlb paramqlb);
    
    public abstract void b(qlb paramqlb);
    
    public abstract void c(qlb paramqlb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlc
 * JD-Core Version:    0.7.0.1
 */