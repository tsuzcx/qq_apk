import com.tencent.qphone.base.util.QLog;

public class aqsf
{
  public static int kt(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "unknown DynamicSource", new RuntimeException("DynamicFaceDrawable don't have " + paramInt));
      i = 7;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsf
 * JD-Core Version:    0.7.0.1
 */