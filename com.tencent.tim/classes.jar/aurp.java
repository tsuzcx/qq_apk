import java.io.PrintWriter;
import java.io.StringWriter;

public class aurp
{
  public static String getStackTraceAsString(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurp
 * JD-Core Version:    0.7.0.1
 */