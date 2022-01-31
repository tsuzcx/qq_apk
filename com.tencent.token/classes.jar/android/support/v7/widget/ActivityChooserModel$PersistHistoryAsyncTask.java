package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class ActivityChooserModel$PersistHistoryAsyncTask
  extends AsyncTask
{
  ActivityChooserModel$PersistHistoryAsyncTask(ActivityChooserModel paramActivityChooserModel) {}
  
  public Void doInBackground(Object... paramVarArgs)
  {
    int i = 0;
    List localList = (List)paramVarArgs[0];
    Object localObject2 = (String)paramVarArgs[1];
    for (;;)
    {
      try
      {
        paramVarArgs = this.this$0.mContext.openFileOutput((String)localObject2, 0);
        localObject2 = Xml.newSerializer();
        int j;
        ActivityChooserModel.HistoricalRecord localHistoricalRecord;
        ((XmlSerializer)localObject2).endTag(null, "historical-records");
      }
      catch (FileNotFoundException paramVarArgs)
      {
        try
        {
          ((XmlSerializer)localObject2).setOutput(paramVarArgs, null);
          ((XmlSerializer)localObject2).startDocument("UTF-8", Boolean.valueOf(true));
          ((XmlSerializer)localObject2).startTag(null, "historical-records");
          j = localList.size();
          if (i >= j) {
            break label213;
          }
          localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)localList.remove(0);
          ((XmlSerializer)localObject2).startTag(null, "historical-record");
          ((XmlSerializer)localObject2).attribute(null, "activity", localHistoricalRecord.activity.flattenToString());
          ((XmlSerializer)localObject2).attribute(null, "time", String.valueOf(localHistoricalRecord.time));
          ((XmlSerializer)localObject2).attribute(null, "weight", String.valueOf(localHistoricalRecord.weight));
          ((XmlSerializer)localObject2).endTag(null, "historical-record");
          i += 1;
          continue;
          paramVarArgs = paramVarArgs;
          Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + (String)localObject2, paramVarArgs);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, localIllegalArgumentException);
          this.this$0.mCanReadHistoricalData = true;
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, localIllegalStateException);
          this.this$0.mCanReadHistoricalData = true;
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        catch (IOException localIOException)
        {
          Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, localIOException);
          this.this$0.mCanReadHistoricalData = true;
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        finally
        {
          this.this$0.mCanReadHistoricalData = true;
          if (paramVarArgs == null) {
            break label441;
          }
        }
        return null;
      }
      label213:
      ((XmlSerializer)localObject2).endDocument();
      this.this$0.mCanReadHistoricalData = true;
      if (paramVarArgs != null) {
        try
        {
          paramVarArgs.close();
          return null;
        }
        catch (IOException paramVarArgs)
        {
          return null;
        }
      }
    }
    try
    {
      paramVarArgs.close();
      label441:
      throw localObject1;
    }
    catch (IOException paramVarArgs)
    {
      break label441;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserModel.PersistHistoryAsyncTask
 * JD-Core Version:    0.7.0.1
 */