package org.apache.commons.lang3.time;

final class FastDateParser$3
  extends FastDateParser.NumberStrategy
{
  FastDateParser$3(int paramInt)
  {
    super(paramInt);
  }
  
  int modify(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 24) {
      i = 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.time.FastDateParser.3
 * JD-Core Version:    0.7.0.1
 */