import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class yxa
  extends acmc
{
  public yxa(TroopActivity paramTroopActivity) {}
  
  public void B(boolean paramBoolean, List<Stranger> paramList)
  {
    if (paramBoolean) {
      if (paramList != null)
      {
        this.this$0.tw.clear();
        this.this$0.tw.addAll(paramList);
        QLog.d("TroopActivity", 2, "onGetListRemote :" + this.this$0.tw.size());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopActivity", 2, "onGetListRemote is failed");
  }
  
  public void C(boolean paramBoolean, List<Stranger> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      this.this$0.tw.clear();
      this.this$0.tw.addAll(paramList);
      QLog.d("TroopActivity", 2, "onGetListLocal :" + this.this$0.tw.size());
    }
  }
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (paramBoolean)
    {
      if (paramPBRepeatMessageField != null)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        while (paramPBRepeatMessageField.hasNext())
        {
          oidb_0x5d4.DelResult localDelResult = (oidb_0x5d4.DelResult)paramPBRepeatMessageField.next();
          QLog.d("TroopActivity", 2, "ondelete: uin " + localDelResult.uin.get());
          if (this.this$0.tw != null)
          {
            int i = 0;
            while (i < this.this$0.tw.size())
            {
              Stranger localStranger = (Stranger)this.this$0.tw.get(i);
              if (localStranger.uin.equals(String.valueOf(localDelResult.uin.get()))) {
                this.this$0.tw.remove(localStranger);
              }
              i += 1;
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("TroopActivity", 2, "onDelete is failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxa
 * JD-Core Version:    0.7.0.1
 */