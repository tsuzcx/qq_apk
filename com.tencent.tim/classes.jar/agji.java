import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class agji
  extends accd
{
  agji(agjg paramagjg) {}
  
  protected void ar(Object paramObject)
  {
    Object localObject1 = (apcy)paramObject;
    if (localObject1 == null) {}
    agzi localagzi;
    do
    {
      do
      {
        return;
        paramObject = ((apcy)localObject1).TroopUin + "";
        localObject2 = ((apcy)localObject1).FilePath;
        localagzi = this.a.a("1", paramObject, (String)localObject2);
      } while (localagzi == null);
      switch (((apcy)localObject1).Status)
      {
      default: 
        return;
      }
    } while (localagzi.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((apcy)localObject1).ProgressValue * 1.0F / ((float)((apcy)localObject1).ProgressTotal * 1.0F) * 100.0F);
    localagzi.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localagzi.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = aqhq.fileExistsAndNotEmpty(((apcy)localObject1).LocalFile);
      localagzi.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localagzi);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localagzi.a() != null)
    {
      localObject1 = new Bundle();
      localagzi.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localagzi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agji
 * JD-Core Version:    0.7.0.1
 */