public class mqt
{
  private String ajA;
  private String ajz;
  private String coverUrl;
  private String videoMd5;
  private String videoUrl;
  private long wl;
  private long wm;
  
  private mqt(mqt.a parama)
  {
    this.coverUrl = mqt.a.a(parama);
    this.ajz = mqt.a.b(parama);
    this.videoUrl = mqt.a.c(parama);
    this.videoMd5 = mqt.a.d(parama);
    this.wl = mqt.a.a(parama);
    this.ajA = mqt.a.e(parama);
    this.wm = mqt.a.b(parama);
  }
  
  public static mqt.a a()
  {
    return new mqt.a(null);
  }
  
  public long cQ()
  {
    return this.wl;
  }
  
  public long cR()
  {
    return this.wm;
  }
  
  public String kk()
  {
    return this.coverUrl;
  }
  
  public String km()
  {
    return this.ajz;
  }
  
  public String kn()
  {
    return this.videoUrl;
  }
  
  public String ko()
  {
    return this.videoMd5;
  }
  
  public String kp()
  {
    return this.ajA;
  }
  
  public static final class a
  {
    private String ajA;
    private String ajz;
    private String coverUrl;
    private String videoMd5;
    private String videoUrl;
    private long wl;
    private long wm;
    
    public a a(long paramLong)
    {
      this.wl = paramLong;
      return this;
    }
    
    public a a(String paramString)
    {
      this.coverUrl = paramString;
      return this;
    }
    
    public mqt a()
    {
      return new mqt(this, null);
    }
    
    public a b(long paramLong)
    {
      this.wm = paramLong;
      return this;
    }
    
    public a b(String paramString)
    {
      this.ajz = paramString;
      return this;
    }
    
    public a c(String paramString)
    {
      this.videoUrl = paramString;
      return this;
    }
    
    public a d(String paramString)
    {
      this.videoMd5 = paramString;
      return this;
    }
    
    public a e(String paramString)
    {
      this.ajA = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqt
 * JD-Core Version:    0.7.0.1
 */