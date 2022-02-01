import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.gamecenter.view.FullPopVideoView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ahtv
{
  private ImageView Aj;
  private ImageView Ar;
  private ImageView As;
  private ImageView At;
  private List<String> Cf = new ArrayList();
  private FullPopData jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData;
  private FullPopVideoView jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView;
  private FrameLayout bI;
  public boolean cih;
  public boolean cii;
  private Context context;
  private String gameId;
  private RelativeLayout kF;
  private String msgId;
  
  public ahtv(Context paramContext, MessageRecord paramMessageRecord)
  {
    this.context = paramContext;
    this.msgId = ahtz.t(paramMessageRecord);
    this.gameId = ahtz.b(paramMessageRecord, 0);
    dqc();
  }
  
  public ahtv(Context paramContext, QQGameMsgInfo paramQQGameMsgInfo)
  {
    this.context = paramContext;
    this.msgId = paramQQGameMsgInfo.paMsgid;
    this.gameId = paramQQGameMsgInfo.gameAppId;
    dqc();
  }
  
  private void dqc()
  {
    Object localObject1 = ahua.wJ();
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("-");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.Cf.add(localObject2);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      if ((this.Cf != null) && (this.Cf.size() > 0))
      {
        localObject1 = new StringBuffer();
        localObject2 = this.Cf.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          ((StringBuffer)localObject1).append(" " + str);
        }
        QLog.d("FullPopBussiness", 1, "<getFullPopIdList>  fullPopIdsb=" + ((StringBuffer)localObject1).toString());
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("FullPopBussiness", 1, "<getFullPopIdList>  fullPopIdList is null");
  }
  
  public static void i(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      HashMap localHashMap = new HashMap();
      tbb.b(localHashMap, paramString1);
      localHashMap.put(Integer.valueOf(1), paramString2);
      localHashMap.put(Integer.valueOf(2), paramString1);
      if (paramBoolean) {
        localHashMap.put(Integer.valueOf(24), Integer.valueOf(1));
      }
      tbb.a(abmt.getAppInterface(), "769", paramString3, paramString2, "76906", "1", "160", localHashMap);
    }
  }
  
  public void KC(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FullPopBussiness", 1, "TVK_SDKMgr is not isInstalled");
    }
  }
  
  public void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    if (((paramQQGameMsgInfo == null) && (paramMessageRecord == null)) || (paramAppInterface == null)) {}
    label315:
    for (;;)
    {
      return;
      int i = ahty.getNetWorkType();
      if ((i != 1) && (i != 4) && (i != 6))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FullPopBussiness", 1, "currentType is:" + i);
        }
      }
      else
      {
        long l1 = ahua.gi();
        long l2 = ahty.Fk() * 24 * 60 * 60 * 1000;
        long l3 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("FullPopBussiness", 1, "lastFullPopExtTime is:" + l1);
          QLog.d("FullPopBussiness", 1, "fullPopInterval is:" + l2);
          QLog.d("FullPopBussiness", 1, "nowTime is:" + l3);
        }
        if (l1 > l3)
        {
          ahua.jX(0L);
          return;
        }
        if ((l1 < 0L) || (l2 < 0L) || (l3 - l1 <= l2)) {
          break label350;
        }
        Object localObject = null;
        if (paramMessageRecord != null) {
          paramMessageRecord = ahua.a(paramMessageRecord);
        }
        for (;;)
        {
          if (paramMessageRecord == null) {
            break label315;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FullPopBussiness", 1, "<checkFullPopRes> fullPopData.id:" + paramMessageRecord.id);
          }
          if (!this.Cf.contains(paramMessageRecord.id)) {
            break label317;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FullPopBussiness", 1, "the full pop is already played.");
          return;
          paramMessageRecord = localObject;
          if (paramQQGameMsgInfo != null) {
            paramMessageRecord = paramQQGameMsgInfo.fullPopData;
          }
        }
      }
    }
    label317:
    if (QLog.isColorLevel()) {
      QLog.d("FullPopBussiness", 1, "the full pop is not played.");
    }
    ahua.a(paramAppInterface, paramMessageRecord.resUrl, new ahtw(this, paramMessageRecord), false);
    return;
    label350:
    if (QLog.isColorLevel()) {
      QLog.d("FullPopBussiness", 1, "full pop is lose efficacy because time");
    }
    i(this.msgId, this.gameId, "205930", true);
  }
  
  public void u(View paramView)
  {
    this.kF = ((RelativeLayout)paramView.findViewById(2131367796));
    this.bI = ((FrameLayout)paramView.findViewById(2131367797));
    this.As = ((ImageView)paramView.findViewById(2131367794));
    this.Ar = ((ImageView)paramView.findViewById(2131367798));
    this.At = ((ImageView)paramView.findViewById(2131367795));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView = ((FullPopVideoView)paramView.findViewById(2131381713));
    this.Aj = ((ImageView)paramView.findViewById(2131369021));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtv
 * JD-Core Version:    0.7.0.1
 */