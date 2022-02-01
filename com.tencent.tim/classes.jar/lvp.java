import com.tencent.pts.nativemodule.IPTSHandleJSException;

public class lvp
  implements IPTSHandleJSException
{
  private final String TAG = "PTSHandleJSException";
  
  public void handleJSException(int paramInt1, int paramInt2, String paramString)
  {
    lwc.f("0X800A7C6", "", "", "", new lwc.a().a("type", "1").a("line", "" + paramInt1).a("column", "" + paramInt2).a("msg", paramString).build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvp
 * JD-Core Version:    0.7.0.1
 */