import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class cx
  implements View.OnClickListener
{
  cx(cv paramcv) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = (cv.a)paramView.getTag();
    int i = DataLineMsgRecord.getDevTypeBySeId(((cv.a)localObject).a.sessionid);
    DataLineMsgRecord localDataLineMsgRecord = cv.a(this.b).b().a(i).a(((cv.a)localObject).a.sessionid);
    if (localDataLineMsgRecord == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      DLFileInfo localDLFileInfo = ((cv.a)localObject).a;
      switch (localDLFileInfo.state)
      {
      default: 
        break;
      case 0: 
      case 3: 
        localObject = (acde)cv.a(this.b).getBusinessHandler(8);
        if ((localDataLineMsgRecord.strMoloKey != null) && (!localDataLineMsgRecord.isReportPause))
        {
          localDataLineMsgRecord.isReportPause = true;
          cu.m(cv.a(this.b));
        }
        ((acde)localObject).g(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
        if (localDataLineMsgRecord.isSendFromLocal()) {
          localDLFileInfo.state = 1;
        }
        break;
      case 1: 
      case 2: 
      case 4: 
        if (aqiw.isNetSupport(cv.a(this.b)))
        {
          if ((ahav.amK()) && (localDLFileInfo.fileSize > 3145728L))
          {
            if (localDLFileInfo.state == 1) {}
            for (;;)
            {
              ahav.b(bool, cv.a(this.b), new cy(this, localDataLineMsgRecord, (cv.a)localObject));
              break;
              bool = false;
            }
          }
          i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
          DataLineMsgSet localDataLineMsgSet = cv.a(this.b).a(i).b(localDataLineMsgRecord.sessionid);
          if (localDataLineMsgSet != null) {
            localDataLineMsgSet.setPaused(false);
          }
          if (localDLFileInfo.state != 1)
          {
            if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
              cu.e(cv.a(this.b));
            }
            cv.a(this.b, (cv.a)localObject, localDataLineMsgRecord);
          }
          else
          {
            cv.b(this.b, (cv.a)localObject, localDataLineMsgRecord);
          }
        }
        else
        {
          ahao.OS(2131696348);
        }
        break;
      case 5: 
        cv.a(this.b, localDataLineMsgRecord);
        continue;
        localDLFileInfo.state = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cx
 * JD-Core Version:    0.7.0.1
 */