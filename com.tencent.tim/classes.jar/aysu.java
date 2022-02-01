import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class aysu
  extends Property<PickerContainer, Float>
{
  public aysu(PickerContainer paramPickerContainer, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public void b(PickerContainer paramPickerContainer, Float paramFloat)
  {
    if (paramPickerContainer != null) {
      PickerContainer.a(paramPickerContainer, paramFloat);
    }
  }
  
  public Float c(PickerContainer paramPickerContainer)
  {
    if (paramPickerContainer != null) {
      return PickerContainer.a(paramPickerContainer);
    }
    return Float.valueOf(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysu
 * JD-Core Version:    0.7.0.1
 */