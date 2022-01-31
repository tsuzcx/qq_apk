package android.support.v7.internal.widget;

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
  private ActivityChooserModel$PersistHistoryAsyncTask(ActivityChooserModel paramActivityChooserModel) {}
  
  public Void doInBackground(Object... paramVarArgs)
  {
    int i = 0;
    List localList = (List)paramVarArgs[0];
    Object localObject2 = (String)paramVarArgs[1];
    for (;;)
    {
      try
      {
        paramVarArgs = ActivityChooserModel.access$200(this.this$0).openFileOutput((String)localObject2, 0);
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
          Log.e(ActivityChooserModel.access$300(), "Error writing historical recrod file: " + (String)localObject2, paramVarArgs);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.e(ActivityChooserModel.access$300(), "Error writing historical recrod file: " + ActivityChooserModel.access$400(this.this$0), localIllegalArgumentException);
          ActivityChooserModel.access$502(this.this$0, true);
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
          Log.e(ActivityChooserModel.access$300(), "Error writing historical recrod file: " + ActivityChooserModel.access$400(this.this$0), localIllegalStateException);
          ActivityChooserModel.access$502(this.this$0, true);
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
          Log.e(ActivityChooserModel.access$300(), "Error writing historical recrod file: " + ActivityChooserModel.access$400(this.this$0), localIOException);
          ActivityChooserModel.access$502(this.this$0, true);
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
          ActivityChooserModel.access$502(this.this$0, true);
          if (paramVarArgs == null) {
            break label446;
          }
        }
        return null;
      }
      label213:
      ((XmlSerializer)localObject2).endDocument();
      ActivityChooserModel.access$502(this.this$0, true);
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
      label446:
      throw localObject1;
    }
    catch (IOException paramVarArgs)
    {
      break label446;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel.PersistHistoryAsyncTask
 * JD-Core Version:    0.7.0.1
 */