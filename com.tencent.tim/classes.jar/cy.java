import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class cy
  implements ahal.a
{
  cy(cx paramcx, DataLineMsgRecord paramDataLineMsgRecord, cv.a parama) {}
  
  public void aD()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.d.sessionid);
    DataLineMsgSet localDataLineMsgSet = cv.a(this.jdField_a_of_type_Cx.b).a(i).b(this.d.sessionid);
    if (localDataLineMsgSet != null) {
      localDataLineMsgSet.setPaused(false);
    }
    if (this.jdField_a_of_type_Cv$a.a.state != 1)
    {
      if ((this.d.fileMsgStatus == 1L) && (this.d.strMoloKey != null)) {
        cu.e(cv.a(this.jdField_a_of_type_Cx.b));
      }
      cv.a(this.jdField_a_of_type_Cx.b, this.jdField_a_of_type_Cv$a, this.d);
      return;
    }
    cv.b(this.jdField_a_of_type_Cx.b, this.jdField_a_of_type_Cv$a, this.d);
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cy
 * JD-Core Version:    0.7.0.1
 */