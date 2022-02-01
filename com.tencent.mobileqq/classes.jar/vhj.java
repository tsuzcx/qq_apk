import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class vhj
  extends vgu<Object, SuperPlayerVideoInfo>
{
  public int a(int paramInt)
  {
    if (paramInt == 101) {
      return 101;
    }
    return 103;
  }
  
  public SuperPlayerVideoInfo a()
  {
    return SuperPlayerFactory.createVideoInfoForUrl(this.b, a(this.a), null);
  }
  
  public Object a()
  {
    return null;
  }
  
  public SuperPlayerVideoInfo b()
  {
    return SuperPlayerFactory.createVideoInfoForUrl(this.b, a(this.a), null);
  }
  
  public Object b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhj
 * JD-Core Version:    0.7.0.1
 */