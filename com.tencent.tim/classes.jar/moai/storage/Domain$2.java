package moai.storage;

import com.google.common.base.Function;

final class Domain$2
  implements Function<T, T>
{
  public T apply(T paramT)
  {
    try
    {
      paramT = (Domain)Domain.access$000(paramT);
      return paramT;
    }
    catch (CloneNotSupportedException paramT)
    {
      throw new RuntimeException(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Domain.2
 * JD-Core Version:    0.7.0.1
 */