import com.etrump.mixlayout.ETEngine;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class ez
  implements FilenameFilter
{
  public ez(ETEngine paramETEngine, ArrayList paramArrayList) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = new File(paramFile.getAbsolutePath() + File.separatorChar + paramString);
    if (paramFile.isDirectory()) {
      paramFile.listFiles(new fa(this));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ez
 * JD-Core Version:    0.7.0.1
 */