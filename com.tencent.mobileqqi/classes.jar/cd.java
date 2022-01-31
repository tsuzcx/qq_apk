import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.DLBaseFileViewActivity.DLFileState;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cd
  implements DialogInterface.OnClickListener
{
  public cd(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity, DataLineHandler paramDataLineHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject2 = null;
    paramDialogInterface.dismiss();
    LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setPaused(false);
    if ((LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getGroupType() == -2000) && (!LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).isSingle())) {
      DataLineReportUtil.p(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.b);
    }
    Iterator localIterator = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).values().iterator();
    Object localObject1 = null;
    paramDialogInterface = (DialogInterface)localObject2;
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      DLFileInfo localDLFileInfo = DatalineFilesAdapter.a(localDataLineMsgRecord);
      if (localDLFileInfo.a == DLBaseFileViewActivity.DLFileState.SENDFAILED)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localDataLineMsgRecord);
        localObject1 = localObject2;
      }
      else
      {
        if (localDLFileInfo.a != DLBaseFileViewActivity.DLFileState.RECVFAILED)
        {
          localObject2 = paramDialogInterface;
          if (localDLFileInfo.a != DLBaseFileViewActivity.DLFileState.FILECOMING) {}
        }
        else if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null))
        {
          if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
            break label272;
          }
          DataLineReportUtil.d(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.b);
        }
        for (;;)
        {
          localObject2 = paramDialogInterface;
          if (paramDialogInterface == null) {
            localObject2 = new ArrayList();
          }
          ((List)localObject2).add(Long.valueOf(localDataLineMsgRecord.sessionid));
          localDataLineMsgRecord.fileMsgStatus = 0L;
          this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.b.a().c(localDataLineMsgRecord.msgId);
          paramDialogInterface = (DialogInterface)localObject2;
          break;
          label272:
          DataLineReportUtil.e(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.b);
        }
      }
    }
    if ((localObject1 != null) && (localObject1.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(localObject1, true);
    }
    if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(paramDialogInterface);
    }
    LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     cd
 * JD-Core Version:    0.7.0.1
 */