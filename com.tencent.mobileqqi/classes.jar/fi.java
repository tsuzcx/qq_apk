import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

class fi
  implements FilenameFilter
{
  fi(fh paramfh) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    fg localfg;
    if (paramString.endsWith(".ttf"))
    {
      paramString = paramFile.getAbsolutePath() + File.separatorChar + paramString;
      localfg = new fg();
      if (localfg == null) {}
    }
    try
    {
      paramFile = paramFile.getAbsolutePath().split(File.separator);
      localfg.jdField_a_of_type_Long = Long.parseLong(paramFile[(paramFile.length - 1)]);
      localfg.jdField_a_of_type_JavaLangString = paramString;
      this.a.a.add(localfg);
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
 * Qualified Name:     fi
 * JD-Core Version:    0.7.0.1
 */