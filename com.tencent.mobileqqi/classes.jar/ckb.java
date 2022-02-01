import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.EmosmObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class ckb
  extends EmosmObserver
{
  public ckb(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmosmActivity", 2, "...........onUpdate.............");
    }
    if (paramInt == 1)
    {
      EmosmActivity.a(this.a);
      paramObject = (EmosmResp)paramObject;
      EmosmActivity.a(this.a).b(paramObject.delEpId + "");
      EmosmActivity.a(this.a).setNotifyOnChange(true);
      paramInt = 0;
      if (paramInt < EmosmActivity.a(this.a).getCount())
      {
        localObject1 = (EmoticonPackage)EmosmActivity.a(this.a).getItem(paramInt);
        if (!((EmoticonPackage)localObject1).epId.equals(paramObject.delEpId + "")) {
          break label273;
        }
        EmosmActivity.a(this.a).remove(localObject1);
        EmoticonController.a(this.a.b).b((EmoticonPackage)localObject1);
        StatisticAssist.a(this.a.b.getApplication().getApplicationContext(), this.a.b.a(), "Delete_ep");
        if (3 == ((EmoticonPackage)localObject1).jobType) {
          ReportController.b(this.a.b, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
        }
        EmosmActivity.a(this.a, (EmoticonPackage)localObject1);
      }
    }
    label273:
    while ((paramInt != 2) || (!paramBoolean)) {
      for (;;)
      {
        if (EmosmActivity.b(this.a) == EmosmActivity.c(this.a)) {
          this.a.a.dismiss();
        }
        return;
        paramInt += 1;
      }
    }
    Object localObject1 = (EmoticonManager)this.a.b.getManager(12);
    Object localObject2 = (EmosmResp)paramObject;
    paramObject = ((EmosmResp)localObject2).data;
    paramObject.addAll(((EmosmResp)localObject2).magicData);
    paramInt = 0;
    int i = 0;
    label495:
    for (;;)
    {
      try
      {
        if (i < paramObject.size())
        {
          localObject2 = (EmoticonPackage)paramObject.get(i);
          EmoticonPackage localEmoticonPackage = ((EmoticonManager)localObject1).b(((EmoticonPackage)localObject2).epId);
          if ((localEmoticonPackage == null) || ((localEmoticonPackage.expiretime == ((EmoticonPackage)localObject2).expiretime) && (localEmoticonPackage.wordingId == ((EmoticonPackage)localObject2).wordingId) && (localEmoticonPackage.jobType == ((EmoticonPackage)localObject2).jobType))) {
            break label495;
          }
          localEmoticonPackage.expiretime = ((EmoticonPackage)localObject2).expiretime;
          localEmoticonPackage.wordingId = ((EmoticonPackage)localObject2).wordingId;
          localEmoticonPackage.jobType = ((EmoticonPackage)localObject2).jobType;
          ((EmoticonManager)localObject1).a(localEmoticonPackage);
          paramInt = 1;
          i += 1;
          continue;
        }
        if (paramInt == 0) {
          break;
        }
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
      this.a.runOnUiThread(EmosmActivity.a(this.a));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ckb
 * JD-Core Version:    0.7.0.1
 */