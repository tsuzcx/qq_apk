import com.tencent.qqprotect.qsec.ICloudAVEngine.d;

final class asyh
  extends asye.a.b
{
  public ICloudAVEngine.d a;
  private String mKey;
  
  public asyh(asye.a parama, String paramString)
  {
    super(null);
    this.mKey = paramString;
  }
  
  public boolean a(String paramString, ICloudAVEngine.d paramd)
  {
    if (paramString.equalsIgnoreCase(this.mKey))
    {
      this.a = paramd;
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyh
 * JD-Core Version:    0.7.0.1
 */