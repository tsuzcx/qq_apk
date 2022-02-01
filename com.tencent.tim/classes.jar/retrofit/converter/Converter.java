package retrofit.converter;

import java.lang.reflect.Type;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public abstract interface Converter
{
  public abstract Object fromBody(TypedInput paramTypedInput, Type paramType)
    throws ConversionException;
  
  public abstract TypedOutput toBody(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.converter.Converter
 * JD-Core Version:    0.7.0.1
 */