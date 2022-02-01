import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ashg
  extends ashx
{
  public ashg(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void c(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    super.c(paramBoolean, paramHashMap);
    this.this$0.aAt();
    if ((paramBoolean) && (paramHashMap != null))
    {
      j = 0;
      i = j;
      if (paramHashMap.containsKey("external"))
      {
        i = j;
        if (paramHashMap.get("external") != null)
        {
          localQidianExternalInfo = (QidianExternalInfo)paramHashMap.get("external");
          if (!this.this$0.a.e.uin.equals(localQidianExternalInfo.uin)) {
            if (QLog.isColorLevel()) {
              QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo not current uin");
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        QidianExternalInfo localQidianExternalInfo;
        return;
        int i = j;
        if (!localQidianExternalInfo.equals(this.this$0.b))
        {
          this.this$0.b = localQidianExternalInfo;
          i = 1;
        }
        int j = i;
        if (paramHashMap.containsKey("ConfigGroupInfo"))
        {
          j = i;
          if (paramHashMap.get("ConfigGroupInfo") != null)
          {
            paramHashMap = (QidianProfileUiInfo)paramHashMap.get("ConfigGroupInfo");
            j = i;
            if (!paramHashMap.equals(QidianProfileCardActivity.a(this.this$0)))
            {
              QidianProfileCardActivity.a(this.this$0, paramHashMap);
              j = 1;
            }
          }
        }
        if (j != 0)
        {
          this.this$0.Fo(6);
          this.this$0.enu();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo not change");
      return;
    }
    QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo fail");
  }
  
  protected void f(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    super.f(paramBoolean, paramHashMap);
    this.this$0.aAt();
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null) && (paramHashMap.containsKey("corp")) && (paramHashMap.get("corp") != null) && (paramHashMap.containsKey("ConfigGroupInfo")) && (paramHashMap.get("ConfigGroupInfo") != null))
    {
      localQidianExternalInfo = (QidianExternalInfo)paramHashMap.get("external");
      localQidianCorpInfo = (QidianCorpInfo)paramHashMap.get("corp");
      paramHashMap = (QidianProfileUiInfo)paramHashMap.get("ConfigGroupInfo");
      if (this.this$0.a.e.uin.equals(localQidianExternalInfo.uin)) {
        if ((!localQidianExternalInfo.equals(this.this$0.b)) || (!localQidianCorpInfo.equals(QidianProfileCardActivity.a(this.this$0))) || (!paramHashMap.equals(QidianProfileCardActivity.a(this.this$0))))
        {
          i = 1;
          if (i == 0) {
            break label230;
          }
          this.this$0.b = localQidianExternalInfo;
          QidianProfileCardActivity.a(this.this$0, localQidianCorpInfo);
          QidianProfileCardActivity.a(this.this$0, paramHashMap);
          this.this$0.Fo(1);
          this.this$0.enu();
        }
      }
    }
    label230:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          for (;;)
          {
            QidianExternalInfo localQidianExternalInfo;
            QidianCorpInfo localQidianCorpInfo;
            return;
            int i = 0;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not change");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not current uin");
      return;
    }
    QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashg
 * JD-Core Version:    0.7.0.1
 */