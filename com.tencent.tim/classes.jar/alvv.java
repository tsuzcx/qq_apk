import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.ConcurrentHashMap;

public class alvv
{
  public ConcurrentHashMap<String, alvp> gK = new ConcurrentHashMap(10);
  
  public alvp a(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    paramSVHwEncoder = new alvp(paramSVHwEncoder, paramSessionInfo, paramInt);
    this.gK.put(paramSVHwEncoder.bYG, paramSVHwEncoder);
    alvr.d("VideoCompoundController", "newProcessor, key = " + paramSVHwEncoder.bYG);
    return paramSVHwEncoder;
  }
  
  public alvp a(String paramString)
  {
    alvr.d("VideoCompoundController", "findProcessor, key = " + paramString);
    if ((!this.gK.isEmpty()) && (paramString != null) && (this.gK.containsKey(paramString))) {
      return (alvp)this.gK.get(paramString);
    }
    return null;
  }
  
  public boolean oy(String paramString)
  {
    alvr.d("VideoCompoundController", "removeProcessor, key = " + paramString);
    if (paramString == null) {}
    while (this.gK.remove(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvv
 * JD-Core Version:    0.7.0.1
 */