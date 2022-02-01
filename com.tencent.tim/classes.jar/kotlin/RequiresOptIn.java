package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;

@java.lang.annotation.Retention(RetentionPolicy.CLASS)
@java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/RequiresOptIn;", "", "message", "", "level", "Lkotlin/RequiresOptIn$Level;", "()Lkotlin/RequiresOptIn$Level;", "()Ljava/lang/String;", "Level", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.ANNOTATION_CLASS})
@SinceKotlin(version="1.3")
public @interface RequiresOptIn
{
  Level level() default Level.ERROR;
  
  String message() default "";
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/RequiresOptIn$Level;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static enum Level
  {
    static
    {
      Level localLevel1 = new Level("WARNING", 0);
      WARNING = localLevel1;
      Level localLevel2 = new Level("ERROR", 1);
      ERROR = localLevel2;
      $VALUES = new Level[] { localLevel1, localLevel2 };
    }
    
    private Level() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.RequiresOptIn
 * JD-Core Version:    0.7.0.1
 */