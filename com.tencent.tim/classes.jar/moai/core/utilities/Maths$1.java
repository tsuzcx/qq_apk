package moai.core.utilities;

import java.util.Random;

final class Maths$1
  extends ThreadLocal<Random>
{
  protected Random initialValue()
  {
    return new Random();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.Maths.1
 * JD-Core Version:    0.7.0.1
 */