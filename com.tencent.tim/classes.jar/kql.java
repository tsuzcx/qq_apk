import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class kql
{
  private kql.a a;
  private pog b = new pog();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.a != null) {
      this.a.b(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.a != null) {
      this.a.b(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(kql.a parama)
  {
    this.a = parama;
  }
  
  public void bu(String paramString1, String paramString2)
  {
    paramString1 = pog.a(paramString1);
    long l = System.currentTimeMillis();
    this.b.a(paramString1, paramString2 + ".tmp.mp4", false, true, new kqm(this, l, paramString1));
  }
  
  public void mt(String paramString)
  {
    pog.b(pog.a(paramString));
  }
  
  public static abstract interface a
  {
    public abstract void b(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString);
    
    public abstract void b(PublishVideoEntry paramPublishVideoEntry, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kql
 * JD-Core Version:    0.7.0.1
 */