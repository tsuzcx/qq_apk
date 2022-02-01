import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.FavRoamingStrategy.3;
import com.tencent.mobileqq.emosm.FavRoamingStrategy.4;
import com.tencent.mobileqq.emosm.FavRoamingStrategy.7;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class afgn
  extends affr
{
  private afhu jdField_a_of_type_Afhu;
  afic<CustomEmotionData> jdField_a_of_type_Afic = new afgr(this);
  aceg b;
  private Handler mHandler;
  private List<String> zC = new ArrayList();
  
  public afgn(QQAppInterface paramQQAppInterface, afgf paramafgf)
  {
    super(paramQQAppInterface, paramafgf);
    this.jdField_b_of_type_Aceg = new afgq(this);
  }
  
  private void a(afim paramafim, int paramInt, Object paramObject)
  {
    ThreadManager.post(new FavRoamingStrategy.4(this, paramObject, paramafim, paramInt), 5, null, false);
  }
  
  private void a(afmi paramafmi, String paramString)
  {
    if ((paramafmi instanceof afpg)) {
      ((afpg)paramafmi).bDZ = paramString;
    }
    while (!(paramafmi instanceof afpu)) {
      return;
    }
    ((afpu)paramafmi).bDZ = paramString;
  }
  
  private void cYW()
  {
    a(new afgo(this));
  }
  
  private void cZj()
  {
    if ((this.aWh) && (!this.zx.isEmpty()))
    {
      Object localObject = this.jdField_b_of_type_Afgf.zB;
      int k = ((List)localObject).size();
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i = 0;
      if (j < k)
      {
        afmi localafmi = (afmi)((List)localObject).get(j);
        if (!(localafmi instanceof afpn)) {}
        for (;;)
        {
          j += 1;
          break;
          if (((afpn)localafmi).isChecked())
          {
            localArrayList.add(localafmi);
            i += 1;
          }
        }
      }
      ThreadManager.post(new FavRoamingStrategy.3(this, localArrayList), 5, null, true);
      anot.a(this.app, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(i), "", "", "");
      this.aWh = false;
      localObject = this.app.getHandler(ChatActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
      QQToast.a(this.app.getApp(), "趣图已添加至收藏面板", 0).show();
    }
  }
  
  public int CQ()
  {
    return 2131693055;
  }
  
  public void O(Context paramContext, Intent paramIntent)
  {
    super.O(paramContext, paramIntent);
    if ("com.tencent.mobileqq.action.update.emotiom".equals(paramIntent.getAction())) {
      a(new afgp(this));
    }
  }
  
  public affx<CustomEmotionData> a()
  {
    if (this.jdField_a_of_type_Afhu == null) {
      this.jdField_a_of_type_Afhu = ((afhu)this.app.getManager(149));
    }
    return this.jdField_a_of_type_Afhu;
  }
  
  public String a(afmi paramafmi)
  {
    if (paramafmi == null) {
      return null;
    }
    return afhv.a(this.app).a(Integer.valueOf(paramafmi.emoId));
  }
  
  public void a(GridView paramGridView, int paramInt, afpn paramafpn)
  {
    Object localObject = ((afhu)this.app.getManager(149)).ez();
    int i = paramafpn.Dg();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
      if (localCustomEmotionData.emoId == i)
      {
        QLog.d("FavRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCustomEmotionData.emoId) });
        if ((localCustomEmotionData.emoOriginalPath != null) && (!afht.lS(localCustomEmotionData.emoOriginalPath)))
        {
          ((acef)this.app.getBusinessHandler(72)).notifyUI(2, true, Integer.valueOf(1));
        }
        else
        {
          localCustomEmotionData.RomaingType = "needUpload";
          a((afmi)paramafpn, "needUpload");
          if (this.jdField_b_of_type_Afgf != null)
          {
            this.jdField_b_of_type_Afgf.fw(paramafpn.getPath(), "needUpload");
            this.jdField_b_of_type_Afgf.a(paramGridView, paramInt);
          }
          com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.bXX = false;
          ThreadManager.excute(new FavEmoSingleSend(localCustomEmotionData, true), 64, null, false);
        }
      }
    }
  }
  
  public boolean ajf()
  {
    return true;
  }
  
  public boolean ajg()
  {
    return false;
  }
  
  public void cYP()
  {
    super.cYP();
    this.mHandler = this.jdField_b_of_type_Afgf.getHandler();
    this.jdField_b_of_type_Afgf.setTitle(2131693071);
    this.app.addObserver(this.jdField_b_of_type_Aceg);
    cYW();
    if (this.jdField_a_of_type_Afhu == null) {
      this.jdField_a_of_type_Afhu = ((afhu)this.app.getManager(149));
    }
    ((afhv)this.app.getManager(103)).a(this.jdField_a_of_type_Afic);
  }
  
  public void cYS()
  {
    super.cYS();
    this.mHandler = null;
    this.zC.clear();
    if (this.bXR) {
      this.app.getApplication().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    ((afhv)this.app.getManager(103)).b(this.jdField_a_of_type_Afic);
    if (this.jdField_b_of_type_Aceg != null) {
      this.app.removeObserver(this.jdField_b_of_type_Aceg);
    }
  }
  
  public void cYT()
  {
    anot.a(this.app, "dc00898", "", "", "ep_mall", "0X800A6AA", 0, 0, "", "", "", "");
  }
  
  public void cYU()
  {
    anot.a(this.app, "dc00898", "", "", "ep_mall", "0X800A6AB", 0, 0, "", "", "", "");
  }
  
  public void cYV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavRoamingStrategy", 2, "fav doSyncEmotion");
    }
    if (this.app == null) {
      return;
    }
    ThreadManager.excute(new FavRoamingStrategy.7(this), 128, null, false);
  }
  
  public void cYX()
  {
    int j = 0;
    if ((this.jdField_b_of_type_Afgf == null) || (this.jdField_b_of_type_Afgf.zB == null)) {
      return;
    }
    Object localObject1 = this.jdField_b_of_type_Afgf.zB.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (afmi)((Iterator)localObject1).next();
    } while ((!(localObject2 instanceof afpn)) || (!((afpn)localObject2).isChecked()));
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject1 = (acef)this.app.getBusinessHandler(72);
        if (localObject1 != null)
        {
          ((acef)localObject1).ai(this.zC, false);
          if (QLog.isColorLevel()) {
            QLog.d("FavEmoRoamingHandler", 2, "-------start delfav---------delResid=" + this.zC.toString());
          }
          anot.a(this.app, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, this.zC.size() + "", "", "", "");
          anot.a(this.app, "dc00898", "", "", "0X800A6D5", "0X800A6D5", 0, 0, String.valueOf(this.zC.size()), "", "", "");
        }
      }
      if (this.cQ.get())
      {
        localObject1 = this.app.getHandler(ChatActivity.class);
        if (localObject1 == null) {
          break;
        }
        ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
        return;
      }
      cZj();
      localObject1 = (afim)this.app.getManager(141);
      i = j;
      if (i < this.jdField_b_of_type_Afgf.zB.size())
      {
        localObject2 = this.jdField_b_of_type_Afgf.getItem(i);
        if ((localObject2 == null) || (!(localObject2 instanceof afpn))) {}
        while (!((afpn)localObject2).isChecked())
        {
          i += 1;
          break;
        }
        a((afim)localObject1, i, localObject2);
        return;
      }
      localObject1 = this.app.getHandler(ChatActivity.class);
      if (localObject1 == null) {
        break;
      }
      ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
      return;
    }
  }
  
  public boolean s(Activity paramActivity)
  {
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra_key_from_web", false);
    this.aWh = bool;
    this.bXR = bool;
    if (this.aWh)
    {
      ArrayList localArrayList1 = paramActivity.getIntent().getStringArrayListExtra("extra_key_pkgids");
      ArrayList localArrayList2 = paramActivity.getIntent().getStringArrayListExtra("extra_key_paths");
      ArrayList localArrayList3 = paramActivity.getIntent().getStringArrayListExtra("extra_key_md5s");
      int j = paramActivity.getIntent().getIntExtra("extra_key_faile_count", 0);
      if ((localArrayList1 != null) && (localArrayList2 != null) && (localArrayList3 != null))
      {
        int i = Math.min(localArrayList1.size(), localArrayList2.size());
        int k = Math.min(localArrayList3.size(), i);
        i = 0;
        while (i < k)
        {
          afpg localafpg = new afpg();
          localafpg.eId = ((String)localArrayList1.get(i));
          localafpg.path = ((String)localArrayList2.get(i));
          localafpg.action = ((String)localArrayList3.get(i));
          this.zx.add(localafpg);
          i += 1;
        }
      }
      if (j > 0) {
        QQToast.a(paramActivity, j + "个下载失败", 0).show();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgn
 * JD-Core Version:    0.7.0.1
 */