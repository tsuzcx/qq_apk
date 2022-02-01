import java.util.ArrayList;
import java.util.HashMap;

public class ahqy
{
  public String bLt;
  public int daN;
  public int daO;
  public int fileSize;
  public HashMap<String, String> lf;
  public String mLanguage;
  public String mMd5;
  public int reqHeight;
  public int reqWidth;
  public String url;
  public ArrayList<ahqx> wZ = new ArrayList();
  public ArrayList<String> xa = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mMd5= ").append(this.mMd5).append("\n").append("baseWidth= ").append(this.daN).append("\n").append("baseHeight= ").append(this.daO).append("\n").append("mLanguage= ").append(this.mLanguage).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqy
 * JD-Core Version:    0.7.0.1
 */