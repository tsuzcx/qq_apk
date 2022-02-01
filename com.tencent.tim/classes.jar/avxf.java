import cooperation.qzone.panorama.widget.PanoramaView;

public class avxf
  implements avwp
{
  public avxf(PanoramaView paramPanoramaView) {}
  
  public void bo(float paramFloat)
  {
    if (PanoramaView.a(this.b) != null) {
      PanoramaView.a(this.b).setScale(paramFloat);
    }
  }
  
  public void eBZ()
  {
    if (PanoramaView.a(this.b) != null) {
      PanoramaView.a(this.b).onPanoramaClick();
    }
  }
  
  public void r(float paramFloat1, float paramFloat2)
  {
    this.b.ac(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxf
 * JD-Core Version:    0.7.0.1
 */