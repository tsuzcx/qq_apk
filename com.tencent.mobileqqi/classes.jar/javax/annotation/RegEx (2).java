package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Syntax("RegEx")
@TypeQualifierNickname
public @interface RegEx
{
  When when() default When.ALWAYS;
  
  public static class Checker
    implements TypeQualifierValidator<RegEx>
  {
    public When forConstantValue(RegEx paramRegEx, Object paramObject)
    {
      if (!(paramObject instanceof String)) {
        return When.NEVER;
      }
      try
      {
        Pattern.compile((String)paramObject);
        return When.ALWAYS;
      }
      catch (PatternSyntaxException paramRegEx) {}
      return When.NEVER;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     javax.annotation.RegEx
 * JD-Core Version:    0.7.0.1
 */