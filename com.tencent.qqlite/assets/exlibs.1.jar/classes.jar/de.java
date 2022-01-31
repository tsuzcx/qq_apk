import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.DatalineFilesAdapter.ItemHolder;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class de
  implements View.OnClickListener
{
  public de(DatalineFilesAdapter paramDatalineFilesAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
    Object localObject1 = DatalineFilesAdapter.a(this.a).a().a().b(((DatalineFilesAdapter.ItemHolder)localObject2).a.jdField_a_of_type_Long);
    if (localObject1 == null) {
      return;
    }
    paramView = ((DatalineFilesAdapter.ItemHolder)localObject2).a;
    switch (paramView.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 3: 
      localObject2 = (DataLineHandler)DatalineFilesAdapter.a(this.a).a(8);
      if ((((DataLineMsgRecord)localObject1).strMoloKey != null) && (!((DataLineMsgRecord)localObject1).isReportPause))
      {
        ((DataLineMsgRecord)localObject1).isReportPause = true;
        DataLineReportUtil.m(DatalineFilesAdapter.a(this.a));
      }
      ((DataLineHandler)localObject2).a(((DataLineMsgRecord)localObject1).groupId, ((DataLineMsgRecord)localObject1).sessionid, false);
      if (((DataLineMsgRecord)localObject1).isSendFromLocal())
      {
        paramView.jdField_a_of_type_Int = 1;
        return;
      }
      break;
    case 1: 
    case 2: 
    case 4: 
      if (NetworkUtil.e(DatalineFilesAdapter.a(this.a)))
      {
        if ((FileManagerUtil.a()) && (paramView.b > 5242880L))
        {
          localObject1 = new df(this, (DataLineMsgRecord)localObject1, (DatalineFilesAdapter.ItemHolder)localObject2);
          localObject2 = new dg(this);
          if (paramView.jdField_a_of_type_Int == 1)
          {
            DialogUtil.a(DatalineFilesAdapter.a(this.a), 230, DatalineFilesAdapter.a(this.a).getString(2131361828), DatalineFilesAdapter.a(this.a).getString(2131362016), 2131362794, 2131361835, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject2).show();
            return;
          }
          DialogUtil.a(DatalineFilesAdapter.a(this.a), 230, DatalineFilesAdapter.a(this.a).getString(2131361831), DatalineFilesAdapter.a(this.a).getString(2131362017), 2131362794, 2131361835, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject2).show();
          return;
        }
        DataLineMsgSet localDataLineMsgSet = DatalineFilesAdapter.a(this.a).a().a(((DataLineMsgRecord)localObject1).sessionid);
        if (localDataLineMsgSet != null) {
          localDataLineMsgSet.setPaused(false);
        }
        if (paramView.jdField_a_of_type_Int != 1)
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
      FMToastUtil.a(2131363450);
      return;
    case 5: 
      DatalineFilesAdapter.a(this.a, (DataLineMsgRecord)localObject1);
      return;
    }
    paramView.jdField_a_of_type_Int = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     de
 * JD-Core Version:    0.7.0.1
 */