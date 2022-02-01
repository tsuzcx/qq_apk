import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class akuf
{
  private volatile CameraPosition b;
  private volatile boolean clA;
  private String friendUin;
  
  public akuf(String paramString)
  {
    this.friendUin = paramString;
  }
  
  public void Lr(boolean paramBoolean)
  {
    this.clA = paramBoolean;
  }
  
  public void a(CameraPosition paramCameraPosition)
  {
    this.b = paramCameraPosition;
  }
  
  public CameraPosition b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    localStringBuilder.append("mLastCameraPosition:").append(this.b);
    localStringBuilder.append(" mMapZoomKey:").append(this.clA);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akuf
 * JD-Core Version:    0.7.0.1
 */