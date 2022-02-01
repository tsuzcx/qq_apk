import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v
  implements View.OnClickListener
{
  public v(DLFilesViewerActivity paramDLFilesViewerActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = DLFilesViewerActivity.a(this.a).values().iterator();
    Object localObject3;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject3 = cv.a((DataLineMsgRecord)((Iterator)localObject1).next());
    } while ((((DLFileInfo)localObject3).state != 0) && (((DLFileInfo)localObject3).state != 3));
    for (int i = 1;; i = 0)
    {
      acde localacde = (acde)this.a.app.getBusinessHandler(8);
      if (i != 0)
      {
        if ((!DLFilesViewerActivity.a(this.a).isReportPause) && (DLFilesViewerActivity.a(this.a).getGroupType() == -2335))
        {
          DLFilesViewerActivity.a(this.a).isReportPause = true;
          cu.m(this.a.app);
        }
        DLFilesViewerActivity.a(this.a).setPaused(true);
        if ((!DLFilesViewerActivity.a(this.a).isSingle()) && (DLFilesViewerActivity.a(this.a).getGroupType() != -2335))
        {
          localacde.g(DLFilesViewerActivity.a(this.a).getGroupId(), 0L, false);
          DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
        }
      }
      for (;;)
      {
        DLFilesViewerActivity.a(this.a);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = DLFilesViewerActivity.a(this.a).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DataLineMsgRecord)((Iterator)localObject1).next();
          localObject3 = cv.a((DataLineMsgRecord)localObject2);
          if ((((DLFileInfo)localObject3).state == 0) || (((DLFileInfo)localObject3).state == 3)) {
            localacde.g(((DataLineMsgRecord)localObject2).groupId, ((DataLineMsgRecord)localObject2).sessionid, false);
          }
        }
        break;
        if (aqiw.isNetSupport(this.a))
        {
          if ((ahav.amK()) && (DLFilesViewerActivity.a(this.a).getFileTotalSize() > 3145728L))
          {
            localObject1 = DLFilesViewerActivity.a(this.a).getFirstItem();
            ahav.b(((DataLineMsgRecord)localObject1).isSendFromLocal(), this.a, new w(this, (DataLineMsgRecord)localObject1, localacde));
          }
          else
          {
            localObject1 = DLFilesViewerActivity.a(this.a).getFirstItem();
            if ((localObject1 != null) && (!((DataLineMsgRecord)localObject1).isSendFromLocal()) && (((DataLineMsgRecord)localObject1).strMoloKey != null)) {
              localacde.F(112);
            }
            DLFilesViewerActivity.a(this.a).setPaused(false);
            Iterator localIterator = DLFilesViewerActivity.a(this.a).values().iterator();
            localObject1 = null;
            if (localIterator.hasNext())
            {
              DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
              DLFileInfo localDLFileInfo = cv.a(localDataLineMsgRecord);
              if (localDLFileInfo.state == 1)
              {
                localObject3 = localObject2;
                if (localObject2 == null) {
                  localObject3 = new ArrayList();
                }
                ((ArrayList)localObject3).add(localDataLineMsgRecord);
                localObject2 = localObject3;
              }
              for (;;)
              {
                break;
                if (localDLFileInfo.state != 4)
                {
                  localObject3 = localObject1;
                  if (localDLFileInfo.state != 2) {}
                }
                else
                {
                  if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
                    cu.e(this.a.app);
                  }
                  localObject3 = localObject1;
                  if (localObject1 == null) {
                    localObject3 = new ArrayList();
                  }
                  ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
                  localDataLineMsgRecord.fileMsgStatus = 0L;
                  i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
                  this.a.app.b().a(i).ig(localDataLineMsgRecord.msgId);
                }
                localObject1 = localObject3;
              }
            }
            if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
              localacde.z((ArrayList)localObject2, true);
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
              localacde.af((List)localObject1);
            }
            DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
          }
        }
        else {
          ahao.OS(2131696348);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     v
 * JD-Core Version:    0.7.0.1
 */