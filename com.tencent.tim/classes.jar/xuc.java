import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class xuc
{
  public static long eq()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l / 1024L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xuc
 * JD-Core Version:    0.7.0.1
 */