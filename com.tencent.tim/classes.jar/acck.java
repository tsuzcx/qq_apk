import com.tencent.mobileqq.data.CameraEmotionData;

public class acck
  implements acci
{
  protected void IF(int paramInt) {}
  
  protected void IG(int paramInt) {}
  
  protected void a(int paramInt, CameraEmotionData paramCameraEmotionData) {}
  
  protected void aT(boolean paramBoolean, int paramInt) {}
  
  protected void cHk() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (CameraEmotionData)paramObject[1]);
      return;
    case 2: 
      IF(((Integer)paramObject).intValue());
      return;
    case 3: 
      IG(((Integer)paramObject).intValue());
      return;
    case 4: 
      cHk();
      return;
    }
    aT(paramBoolean, ((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acck
 * JD-Core Version:    0.7.0.1
 */