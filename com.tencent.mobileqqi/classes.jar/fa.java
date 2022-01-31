import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

class fa
  implements FilenameFilter
{
  fa(ez paramez) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    ey localey;
    if (paramString.endsWith(".ttf"))
    {
      paramString = paramFile.getAbsolutePath() + File.separatorChar + paramString;
      localey = new ey();
      if (localey == null) {}
    }
    try
    {
      paramFile = paramFile.getAbsolutePath().split(File.separator);
      localey.jdField_a_of_type_Long = Long.parseLong(paramFile[(paramFile.length - 1)]);
      localey.jdField_a_of_type_JavaLangString = paramString;
      this.a.a.add(localey);
      label90:
      return false;
    }
    catch (Exception paramFile)
    {
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fa
 * JD-Core Version:    0.7.0.1
 */