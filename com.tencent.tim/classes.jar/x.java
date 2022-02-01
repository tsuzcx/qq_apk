import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.DLFilesViewerActivity.2.1;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;

public class x
  extends acdl
{
  public x(DLFilesViewerActivity paramDLFilesViewerActivity) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new DLFilesViewerActivity.2.1(this, paramLong, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.b(this.a);
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.b(this.a);
  }
  
  protected void c(boolean paramBoolean, long paramLong, String paramString)
  {
    super.c(paramBoolean, paramLong, paramString);
    DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.b(this.a);
  }
  
  protected void d(boolean paramBoolean, long paramLong, String paramString)
  {
    super.c(paramBoolean, paramLong, paramString);
    DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.b(this.a);
  }
  
  protected void t(String paramString)
  {
    super.t(paramString);
    Iterator localIterator = DLFilesViewerActivity.a(this.a).values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if (paramString.equals(localDataLineMsgRecord.strMoloKey))
      {
        localDataLineMsgRecord.nAppStatus = 1;
        DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
      }
    }
    DLFilesViewerActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     x
 * JD-Core Version:    0.7.0.1
 */