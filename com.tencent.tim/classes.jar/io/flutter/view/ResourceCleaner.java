package io.flutter.view;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import java.io.File;

class ResourceCleaner
{
  private static final long DELAY_MS = 5000L;
  private static final String TAG = "ResourceCleaner";
  private final Context mContext;
  
  ResourceCleaner(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  void start()
  {
    Object localObject = this.mContext.getCacheDir();
    if (localObject == null) {}
    do
    {
      return;
      localObject = new CleanTask(((File)localObject).listFiles(new ResourceCleaner.1(this)));
    } while (!((CleanTask)localObject).hasFilesToDelete());
    new Handler().postDelayed(new ResourceCleaner.2(this, (CleanTask)localObject), 5000L);
  }
  
  static class CleanTask
    extends AsyncTask<Void, Void, Void>
  {
    private final File[] mFilesToDelete;
    
    CleanTask(File[] paramArrayOfFile)
    {
      this.mFilesToDelete = paramArrayOfFile;
    }
    
    private void deleteRecursively(File paramFile)
    {
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          deleteRecursively(arrayOfFile[i]);
          i += 1;
        }
      }
      paramFile.delete();
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      paramVarArgs = this.mFilesToDelete;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Void localVoid = paramVarArgs[i];
        if (localVoid.exists()) {
          deleteRecursively(localVoid);
        }
        i += 1;
      }
      return null;
    }
    
    boolean hasFilesToDelete()
    {
      return (this.mFilesToDelete != null) && (this.mFilesToDelete.length > 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.ResourceCleaner
 * JD-Core Version:    0.7.0.1
 */