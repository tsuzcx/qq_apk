import android.view.MotionEvent;

public class ayop
{
  public static float[] a(MotionEvent paramMotionEvent)
  {
    float[] arrayOfFloat = new float[2];
    if (paramMotionEvent.getPointerCount() > 1)
    {
      arrayOfFloat[0] = ((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F);
      arrayOfFloat[1] = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
    }
    return arrayOfFloat;
  }
  
  public static float b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1) {
      return f(paramMotionEvent.getX(1) - paramMotionEvent.getX(0), paramMotionEvent.getY(1) - paramMotionEvent.getY(0));
    }
    return 0.0F;
  }
  
  public static float e(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    if (!Float.isNaN(paramFloat1)) {
      return paramFloat1;
    }
    return 1.0F;
  }
  
  public static float f(float paramFloat1, float paramFloat2)
  {
    float f = (float)Math.toDegrees(Math.asin(paramFloat2 / e(paramFloat1, paramFloat2)));
    if (!Float.isNaN(f))
    {
      if ((paramFloat2 >= 0.0F) && (paramFloat1 >= 0.0F)) {}
      do
      {
        return f;
        if ((paramFloat2 >= 0.0F) && (paramFloat1 <= 0.0F)) {
          return 180.0F - f;
        }
      } while ((paramFloat2 <= 0.0F) && (paramFloat1 >= 0.0F));
      if ((paramFloat2 <= 0.0F) && (paramFloat1 <= 0.0F)) {
        return -180.0F - f;
      }
    }
    return 0.0F;
  }
  
  public static float spacing(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1) {
      return e(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
    }
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayop
 * JD-Core Version:    0.7.0.1
 */