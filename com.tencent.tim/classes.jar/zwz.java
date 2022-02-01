import com.tencent.image.Utils;

public class zwz
  extends zxa
{
  public zwz(String paramString)
  {
    super(paramString);
    this.TAG = "PhotoIncompatibleWebp";
    this.REPORT_TAG = "reportGenerateHeif";
  }
  
  static boolean iA(String paramString)
  {
    return Utils.isHeifFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwz
 * JD-Core Version:    0.7.0.1
 */