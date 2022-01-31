import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLBaseFileViewActivity.DLFileState;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.DatalineFilesAdapter.ItemHolder;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ee
  implements View.OnClickListener
{
  public ee(DatalineFilesAdapter paramDatalineFilesAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
    Object localObject1 = DatalineFilesAdapter.a(this.a).a().b(((DatalineFilesAdapter.ItemHolder)localObject2).a.jdField_a_of_type_Long);
    if (localObject1 == null) {
      return;
    }
    paramView = ((DatalineFilesAdapter.ItemHolder)localObject2).a;
    switch (eh.a[paramView.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState.ordinal()])
    {
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
      if (NetworkUtil.e(DatalineFilesAdapter.a(this.a)))
      {
        if ((FileManagerUtil.a()) && (paramView.b > 5242880L))
        {
          localObject1 = new ef(this, (DataLineMsgRecord)localObject1, (DatalineFilesAdapter.ItemHolder)localObject2);
          localObject2 = new eg(this);
          if (paramView.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.SENDFAILED)
          {
            DialogUtil.a(DatalineFilesAdapter.a(this.a), 230, DatalineFilesAdapter.a(this.a).getString(2131558502), DatalineFilesAdapter.a(this.a).getString(2131558756), 2131561746, 2131558509, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject2).show();
            return;
          }
          DialogUtil.a(DatalineFilesAdapter.a(this.a), 230, DatalineFilesAdapter.a(this.a).getString(2131558505), DatalineFilesAdapter.a(this.a).getString(2131558757), 2131561746, 2131558509, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject2).show();
          return;
        }
        DataLineMsgSet localDataLineMsgSet = DatalineFilesAdapter.a(this.a).a().a(((DataLineMsgRecord)localObject1).sessionid);
        if (localDataLineMsgSet != null) {
          localDataLineMsgSet.setPaused(false);
        }
        if (paramView.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState != DLBaseFileViewActivity.DLFileState.SENDFAILED)
        {
          if ((((DataLineMsgRecord)localObject1).fileMsgStatus == 1L) && (((DataLineMsgRecord)localObject1).strMoloKey != null)) {
            DataLineReportUtil.e(DatalineFilesAdapter.a(this.a));
          }
          DatalineFilesAdapter.a(this.a, (DatalineFilesAdapter.ItemHolder)localObject2, (DataLineMsgRecord)localObject1);
          return;
        }
        DatalineFilesAdapter.b(this.a, (DatalineFilesAdapter.ItemHolder)localObject2, (DataLineMsgRecord)localObject1);
        return;
      }
      FMToastUtil.a(2131562488);
      return;
    case 4: 
      DatalineFilesAdapter.a(this.a, (DataLineMsgRecord)localObject1);
      return;
    }
    localObject2 = (DataLineHandler)DatalineFilesAdapter.a(this.a).a(8);
    if ((((DataLineMsgRecord)localObject1).strMoloKey != null) && (!((DataLineMsgRecord)localObject1).isReportPause))
    {
      ((DataLineMsgRecord)localObject1).isReportPause = true;
      DataLineReportUtil.m(DatalineFilesAdapter.a(this.a));
    }
    ((DataLineHandler)localObject2).a(((DataLineMsgRecord)localObject1).groupId, ((DataLineMsgRecord)localObject1).sessionid, false);
    if (((DataLineMsgRecord)localObject1).isSendFromLocal())
    {
      paramView.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.SENDFAILED;
      return;
    }
    paramView.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.RECVFAILED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ee
 * JD-Core Version:    0.7.0.1
 */