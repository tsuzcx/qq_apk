import com.dataline.activities.LiteMutiPicViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bz
  implements ahal.a
{
  public bz(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity, acde paramacde) {}
  
  public void aD()
  {
    Object localObject1 = null;
    LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setPaused(false);
    if ((LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getGroupType() == -2000) && (!LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).isSingle())) {
      cu.p(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app);
    }
    Iterator localIterator = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).values().iterator();
    Object localObject2 = null;
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      DLFileInfo localDLFileInfo = cv.a(localDataLineMsgRecord);
      Object localObject3;
      if (localDLFileInfo.state == 1)
      {
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = new ArrayList();
        }
        ((ArrayList)localObject3).add(localDataLineMsgRecord);
        localObject2 = localObject3;
      }
      else
      {
        if (localDLFileInfo.state != 4)
        {
          localObject3 = localObject1;
          if (localDLFileInfo.state != 2) {}
        }
        else if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null))
        {
          if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
            break label269;
          }
          cu.d(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app);
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new ArrayList();
          }
          ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
          int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
          localDataLineMsgRecord.fileMsgStatus = 0L;
          this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app.b().a(i).ig(localDataLineMsgRecord.msgId);
          localObject1 = localObject3;
          break;
          label269:
          cu.e(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app);
        }
      }
    }
    if ((localObject2 != null) && (localObject2.size() > 0)) {
      this.jdField_a_of_type_Acde.z(localObject2, true);
    }
    if ((localObject1 != null) && (localObject1.size() > 0)) {
      this.jdField_a_of_type_Acde.af(localObject1);
    }
    LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity);
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bz
 * JD-Core Version:    0.7.0.1
 */