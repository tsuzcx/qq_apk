package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
public @interface RequiresPermission$Read
{
  RequiresPermission value() default @RequiresPermission;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.annotation.RequiresPermission.Read
 * JD-Core Version:    0.7.0.1
 */