import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QFileSendBarManager.5;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahdg
  extends AsyncTask<Void, Void, Void>
{
  public ahdg(QFileSendBarManager.5 param5) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = ahdb.a(this.a.this$0);
    Object localObject1 = ahdb.b(this.a.this$0);
    int i = ahdb.a(this.a.this$0);
    if (i == 5)
    {
      TroopFileProxyActivity.aw.addAll(agmz.D());
      return null;
    }
    label114:
    Object localObject2;
    if (paramVarArgs.equals(acbn.bkw))
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(agmz.D());
      paramVarArgs = (acde)this.a.this$0.mApp.getBusinessHandler(8);
      paramVarArgs.dA((ArrayList)localObject1);
      localObject1 = agmz.db().iterator();
      i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if (((FileManagerEntity)localObject2).nFileType == 13)
        {
          int j = i;
          if (paramVarArgs.a((FileManagerEntity)localObject2) == 0L) {
            j = i | 0x1;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      break label114;
      if ((((FileManagerEntity)localObject2).getCloudType() == 2) && (((FileManagerEntity)localObject2).WeiYunFileId != null))
      {
        paramVarArgs.e((FileManagerEntity)localObject2);
      }
      else if (!paramVarArgs.a().a((FileManagerEntity)localObject2))
      {
        i |= 0x4;
        continue;
        if ((i & 0x2) == 0) {
          break;
        }
        return null;
        if (i == 6002)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(agmz.D());
          ((RouterHandler)this.a.this$0.mApp.getBusinessHandler(48)).a((ArrayList)localObject1, null, null, Long.parseLong(paramVarArgs));
          return null;
        }
        if (i == 9501)
        {
          localObject1 = (szy)this.a.this$0.mApp.getBusinessHandler(49);
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).addAll(agmz.D());
          ((szy)localObject1).a().b(paramVarArgs, (List)localObject2);
          return null;
        }
        this.a.this$0.mApp.a().c(false, (String)localObject1, paramVarArgs, i);
        return null;
      }
    }
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    ahdb.c(this.a.this$0);
    agmz.clearSelected();
    this.a.this$0.ds(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdg
 * JD-Core Version:    0.7.0.1
 */