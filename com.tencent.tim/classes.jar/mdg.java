import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.protofile.cmd0xe23.cmd0xe23.GetConsumeInfoItem;
import com.tencent.protofile.cmd0xe23.cmd0xe23.RspBody;
import com.tencent.protofile.cmd0xe23.cmd0xe23.TaskConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class mdg
  extends jnm.d
{
  public mdg(RIJRedPacketManager paramRIJRedPacketManager, int paramInt, RIJRedPacketManager.f paramf) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe23 error code: " + paramInt);
    j = 0;
    i = j;
    if (paramInt == 0) {
      paramBundle = new cmd0xe23.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = 0;
      if (paramBundle.result_code.has()) {
        paramInt = paramBundle.result_code.get();
      }
      if (paramInt < 0) {
        break label669;
      }
      paramInt = RIJRedPacketManager.a().oT();
      if (!paramBundle.rpt_consume_info_item.has()) {
        break label779;
      }
      if (!((cmd0xe23.GetConsumeInfoItem)paramBundle.rpt_consume_info_item.get()).current_progress.has()) {
        break label776;
      }
      paramInt = ((cmd0xe23.GetConsumeInfoItem)paramBundle.rpt_consume_info_item.get()).current_progress.get();
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        boolean bool2;
        boolean bool5;
        boolean bool4;
        int n;
        label634:
        this.a.lJ(false);
        label663:
        label669:
        QLog.i("RIJRedPacketManager", 1, paramArrayOfByte.toString());
        i = 1;
        continue;
        break label791;
        int m = 0;
        continue;
        int k = 0;
        continue;
        j = 0;
        continue;
        i = 0;
        continue;
        long l = 0L;
        boolean bool3 = bool1;
        continue;
        boolean bool1 = true;
        continue;
        continue;
        l = 0L;
        bool3 = true;
        continue;
        continue;
        for (;;)
        {
          break;
          bool1 = false;
          break label788;
          if (n != 2) {
            break label733;
          }
          bool1 = true;
        }
        paramInt = 1;
      }
    }
    if (((cmd0xe23.GetConsumeInfoItem)paramBundle.rpt_consume_info_item.get()).need_record.has())
    {
      if (((cmd0xe23.GetConsumeInfoItem)paramBundle.rpt_consume_info_item.get()).need_record.get() != 1) {
        break label794;
      }
      bool1 = true;
      break label788;
      if (((cmd0xe23.GetConsumeInfoItem)paramBundle.rpt_consume_info_item.get()).next_request_time.has())
      {
        l = ((cmd0xe23.GetConsumeInfoItem)paramBundle.rpt_consume_info_item.get()).next_request_time.get() * 1000L;
        bool3 = bool1;
        j = 0;
        i = 0;
        k = 0;
        m = 0;
        bool2 = false;
        bool5 = false;
        bool1 = false;
        bool4 = false;
        if (paramBundle.task_config.has())
        {
          if (!paramBundle.task_config.article_max_time.has()) {
            break label754;
          }
          i = paramBundle.task_config.article_max_time.get();
          this.this$0.rC(i);
          if (!paramBundle.task_config.total_cycle.has()) {
            break label748;
          }
          j = paramBundle.task_config.total_cycle.get();
          this.this$0.rD(j);
          if (!paramBundle.task_config.article_still_max_time.has()) {
            break label742;
          }
          k = paramBundle.task_config.article_still_max_time.get();
          this.this$0.rB(k);
          if (paramBundle.task_config.total_progress.has())
          {
            m = paramBundle.task_config.total_progress.get();
            this.this$0.rA(m);
            paramArrayOfByte = paramBundle.task_config.rpt_record_article_type.get().iterator();
            bool2 = bool5;
            bool1 = bool4;
            if (paramArrayOfByte.hasNext())
            {
              n = ((Integer)paramArrayOfByte.next()).intValue();
              if (n != 1) {
                break label800;
              }
              bool2 = true;
              break label791;
            }
            RIJRedPacketManager.a(this.this$0, bool2);
            RIJRedPacketManager.b(this.this$0, bool1);
            n = j;
            j = i;
            i = n;
          }
        }
        else
        {
          QLog.i("RIJRedPacketManager", 1, "yyy_0xe23 rspbody:  global currentProgress: " + paramInt + "\n totalProgress: " + m + "\n can do task: " + bool3 + "\n next request can do task Time: " + l + "\n total cycle: " + i + "\n article still max time: " + k + "\n article max time: " + j);
          this.this$0.rz(paramInt);
          this.this$0.r(bool3, l);
          i = 1;
          if ((this.val$type == 1) && (bool2)) {
            break label812;
          }
          if ((this.val$type == 2) && (bool1))
          {
            break label812;
            paramArrayOfByte = this.a;
            if ((paramInt == 0) || (!this.this$0.Ds())) {
              break label663;
            }
            bool1 = true;
            paramArrayOfByte.lJ(bool1);
          }
          for (;;)
          {
            if (i == 0) {
              this.a.lJ(false);
            }
            return;
            paramInt = 0;
            break;
            bool1 = false;
            break label634;
            QLog.i("RIJRedPacketManager", 1, "yyy_0xe23 retCode " + paramInt + " request fail");
            i = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdg
 * JD-Core Version:    0.7.0.1
 */