import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import java.util.ArrayList;
import java.util.Iterator;

class aq
  implements DialogInterface.OnClickListener
{
  aq(ap paramap) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    acde localacde = (acde)this.a.this$0.app.getBusinessHandler(8);
    Object localObject;
    if ((!this.a.b.isReportPause) && (this.a.b.getGroupType() == -2335))
    {
      this.a.b.isReportPause = true;
      if (!this.a.b.isSingle()) {
        cu.m(this.a.this$0.app);
      }
    }
    else
    {
      if ((this.a.b.getGroupType() == -2000) && (!this.a.b.isSingle())) {
        cu.o(this.a.this$0.app);
      }
      if ((this.a.b.isSingle()) || (this.a.b.getGroupType() == -2335)) {
        break label251;
      }
      localacde.g(this.a.b.getGroupId(), 0L, true);
      localObject = null;
      paramInt = 0;
    }
    for (;;)
    {
      localacde.c(this.a.b);
      if (paramInt != 0) {
        localacde.c((DataLineMsgSet)localObject);
      }
      this.a.this$0.jdField_a_of_type_Db.cj();
      this.a.this$0.jdField_a_of_type_Db.notifyDataSetChanged();
      paramDialogInterface.dismiss();
      return;
      cu.k(this.a.this$0.app);
      break;
      label251:
      localObject = this.a.b.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        localacde.g(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, true);
      }
      if ((this.a.b.values().size() == 1) && (this.a.b.getGroupType() == -2005))
      {
        paramInt = this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(((DataLineMsgRecord)this.a.b.values().get(0)).sessionid) + 1;
        if ((paramInt < this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) && (((DataLineMsgRecord)this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).values().get(0)).msgtype == -5041) && (Long.parseLong(((DataLineMsgRecord)this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).values().get(0)).getExtInfoFromExtStr("tim_aio_file_msg_uiniseq")) == ((DataLineMsgRecord)this.a.b.values().get(0)).sessionid))
        {
          localObject = this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
          paramInt = 1;
          continue;
        }
      }
      localObject = null;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aq
 * JD-Core Version:    0.7.0.1
 */