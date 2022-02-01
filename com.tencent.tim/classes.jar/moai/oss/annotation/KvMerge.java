package moai.oss.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.FIELD})
public @interface KvMerge
{
  boolean value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.annotation.KvMerge
 * JD-Core Version:    0.7.0.1
 */