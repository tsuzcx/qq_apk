final class aqnd
  implements aqnc.b<Integer>
{
  public Integer evaluate(float paramFloat, Integer paramInteger1, Integer paramInteger2)
  {
    int i = paramInteger1.intValue();
    float f = i;
    return Integer.valueOf((int)((paramInteger2.intValue() - i) * paramFloat + f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnd
 * JD-Core Version:    0.7.0.1
 */