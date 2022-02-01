package moai.storage;

import android.util.PrintStreamPrinter;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.tencent.moai.database.sqlite.SQLiteDebug;
import java.util.List;

public class SQLiteDatabaseDumper
  implements DumperPlugin
{
  public void dump(DumperContext paramDumperContext)
    throws DumpException
  {
    PrintStreamPrinter localPrintStreamPrinter = new PrintStreamPrinter(paramDumperContext.getStdout());
    paramDumperContext = paramDumperContext.getArgsAsList();
    SQLiteDebug.dump(localPrintStreamPrinter, (String[])paramDumperContext.toArray(new String[paramDumperContext.size()]));
  }
  
  public String getName()
  {
    return "database";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.SQLiteDatabaseDumper
 * JD-Core Version:    0.7.0.1
 */