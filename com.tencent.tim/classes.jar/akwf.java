import com.tencent.mobileqq.persistence.fts.FTSEntity;

public class akwf
{
  public boolean KW;
  public String bUv;
  public String bUw;
  public int dpr = -1;
  public int dps;
  public String[] gc = new String[0];
  public boolean or;
  public String sql;
  public int type = 0;
  
  public akwf(String paramString, Class<? extends FTSEntity> paramClass, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    this.sql = paramString;
    this.bUw = paramClass.getName().replace('.', '/');
    this.gc = paramArrayOfString;
    this.KW = paramBoolean;
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwf
 * JD-Core Version:    0.7.0.1
 */