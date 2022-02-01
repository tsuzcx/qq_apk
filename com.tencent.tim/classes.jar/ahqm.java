import java.io.File;

public class ahqm
{
  public static void v(File paramFile)
  {
    if ((paramFile == null) || (paramFile.exists())) {}
    do
    {
      return;
      paramFile = paramFile.getParentFile();
    } while ((paramFile == null) || (paramFile.exists()));
    v(paramFile);
    paramFile.mkdirs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqm
 * JD-Core Version:    0.7.0.1
 */