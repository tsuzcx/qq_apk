import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.PadInfo;
import java.util.Iterator;
import java.util.List;

public class auma
  extends atdt
{
  private atku jdField_a_of_type_Atku = new atku(0L);
  private aujw jdField_a_of_type_Aujw;
  private Activity mActivity;
  private long mCreateTime;
  protected Handler mHandler;
  
  public auma(QQAppInterface paramQQAppInterface, Activity paramActivity, aujw paramaujw, augx paramaugx, Handler paramHandler)
  {
    super(paramQQAppInterface, paramActivity, 1, paramaugx);
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Aujw = paramaujw;
    this.mHandler = paramHandler;
    this.mCreateTime = (anaz.gQ() * 1000L);
  }
  
  public void a(int paramInt, atiu paramatiu)
  {
    PadInfo localPadInfo;
    if ((paramatiu instanceof FileManagerEntity))
    {
      localPadInfo = athu.a((FileManagerEntity)paramatiu);
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localPadInfo = (PadInfo)paramatiu;
                break;
              } while (this.jdField_a_of_type_Aujw == null);
              this.jdField_a_of_type_Aujw.d(localPadInfo);
              return;
            } while (this.jdField_a_of_type_Aujw == null);
            this.jdField_a_of_type_Aujw.e(localPadInfo);
            return;
          } while (this.jdField_a_of_type_Aujw == null);
          this.jdField_a_of_type_Aujw.g(localPadInfo);
          return;
        } while (this.jdField_a_of_type_Aujw == null);
        this.jdField_a_of_type_Aujw.f(localPadInfo);
        return;
      } while (this.jdField_a_of_type_Aujw == null);
      this.jdField_a_of_type_Aujw.c(localPadInfo);
      return;
      atiz.clearSelected();
      atiz.a(paramatiu);
    } while (this.jdField_a_of_type_Auhk$j == null);
    this.jdField_a_of_type_Auhk$j.bG(paramatiu);
  }
  
  public void dUi()
  {
    if (this.GW != null) {
      this.GW.clear();
    }
  }
  
  public void mw(List<? extends Object> paramList)
  {
    int i;
    atiu localatiu;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.GW.addAll(paramList);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(4);
      }
      paramList = this.GW.iterator();
      i = 0;
      if (!paramList.hasNext()) {
        break label153;
      }
      localatiu = (atiu)paramList.next();
      if (localatiu != null) {
        break label113;
      }
      paramList.remove();
      QLog.w("TeamWorkAdapter", 1, "filelist contains null ");
    }
    label153:
    for (;;)
    {
      break;
      dUi();
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(3);
      }
      return;
      label113:
      if ((localatiu != null) && ((localatiu.getCloudFileType() == 2) || (localatiu.getCloudFileType() == 0) || (localatiu.getCloudFileType() == 1)))
      {
        i += 1;
        continue;
        this.epp = i;
        notifyDataSetChanged();
        return;
      }
    }
  }
  
  public void mx(List<? extends Object> paramList)
  {
    this.GW.clear();
    int i;
    label45:
    atiu localatiu;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.GW.addAll(paramList);
      paramList = this.GW.iterator();
      i = 0;
      if (!paramList.hasNext()) {
        break label142;
      }
      localatiu = (atiu)paramList.next();
      if (localatiu != null) {
        break label102;
      }
      paramList.remove();
      QLog.w("TeamWorkAdapter", 1, "filelist contains null ");
    }
    label142:
    for (;;)
    {
      break label45;
      this.GW.add(this.jdField_a_of_type_Atku);
      break;
      label102:
      if ((localatiu != null) && ((localatiu.getCloudFileType() == 2) || (localatiu.getCloudFileType() == 0) || (localatiu.getCloudFileType() == 1)))
      {
        i += 1;
        continue;
        this.epp = i;
        notifyDataSetChanged();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auma
 * JD-Core Version:    0.7.0.1
 */