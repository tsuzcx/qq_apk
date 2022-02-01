public class aqsv
  extends aqsm
{
  public static final aqsv a = new aqsv();
  private int ecv;
  
  public void a(aqqq paramaqqq)
  {
    int i = this.ecv;
    this.ecv = (i + 1);
    if (i < 2) {
      download(null, 0, paramaqqq, false);
    }
  }
  
  public long getBID()
  {
    return 3L;
  }
  
  protected String getRootDir()
  {
    return "tintconfig";
  }
  
  public String getScid(int paramInt)
  {
    return getScidPrefix();
  }
  
  protected String getScidPrefix()
  {
    return "theme_mapping_config_android";
  }
  
  protected boolean isZip_KeepZip()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsv
 * JD-Core Version:    0.7.0.1
 */