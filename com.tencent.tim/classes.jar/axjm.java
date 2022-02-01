import com.tencent.tavcut.bean.CropConfig;

public class axjm
{
  public CropConfig cropConfig = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
  public int height;
  public String path;
  public int width;
  
  public axjm(String paramString, int paramInt1, int paramInt2, CropConfig paramCropConfig)
  {
    this.path = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.cropConfig = paramCropConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjm
 * JD-Core Version:    0.7.0.1
 */