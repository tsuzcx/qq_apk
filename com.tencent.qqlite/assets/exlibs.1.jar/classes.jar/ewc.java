public final class ewc
  implements ewh
{
  public Integer a(float paramFloat, Integer paramInteger1, Integer paramInteger2)
  {
    int i = paramInteger1.intValue();
    float f = i;
    return Integer.valueOf((int)((paramInteger2.intValue() - i) * paramFloat + f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ewc
 * JD-Core Version:    0.7.0.1
 */