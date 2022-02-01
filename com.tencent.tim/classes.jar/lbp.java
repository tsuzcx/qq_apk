import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class lbp
  extends altk
{
  public lbp(KandianMergeManager paramKandianMergeManager) {}
  
  public void g(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    if (!"kandian_num_red_pnt_buffer".equals(paramString)) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramString = ((NumRedMsg.NumMsgBusi)paramList.get(paramList.size() - 1)).str_ext.get();
    if (!TextUtils.isEmpty(paramString))
    {
      paramList = KandianMsgBoxRedPntInfo.createFromJSON(paramString);
      if ((paramList == null) || (paramList.mMsgCnt <= 0) || ((KandianMergeManager.a(this.this$0) != null) && (paramList.mSeq <= KandianMergeManager.a(this.this$0).mSeq)))
      {
        QLog.d("KandianMergeManager", 2, new Object[] { "[redpnt_center]new msgbox red info has error, local : ", KandianMergeManager.a(this.this$0), "new : ", paramList });
        return;
      }
      if (Aladdin.getConfig(215).getIntegerFromString("message_reddot_style", 1) == 2) {
        break label183;
      }
      this.this$0.a(paramList);
    }
    for (;;)
    {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | num red pnt buffer : " + paramString);
      return;
      label183:
      lbz.a().qx(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbp
 * JD-Core Version:    0.7.0.1
 */