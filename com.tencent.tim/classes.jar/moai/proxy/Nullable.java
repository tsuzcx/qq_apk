package moai.proxy;

import com.google.common.base.Supplier;

public abstract class Nullable<T>
  implements Supplier<T>
{
  final Class<T> parameterizedType = Reflections.parameterizedType(this, 0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.proxy.Nullable
 * JD-Core Version:    0.7.0.1
 */