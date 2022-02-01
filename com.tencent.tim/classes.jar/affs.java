import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.CameraRoamingStrategy.3;
import com.tencent.mobileqq.emosm.CameraRoamingStrategy.5;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class affs
  extends affr
{
  acck jdField_a_of_type_Acck = new affv(this);
  private afhc jdField_a_of_type_Afhc;
  private volatile boolean bXS;
  private List<aflv> zy = new ArrayList();
  
  public affs(QQAppInterface paramQQAppInterface, afgf paramafgf)
  {
    super(paramQQAppInterface, paramafgf);
  }
  
  private void cYW()
  {
    a(new afft(this));
  }
  
  private List<? extends afmi> ey()
  {
    return this.zy;
  }
  
  private void initBottomBar()
  {
    this.b.Rv.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.sx.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = wja.dp2px(16.0F, this.b.sx.getContext().getResources());
  }
  
  public int CQ()
  {
    return 2131693046;
  }
  
  public affx<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_Afhc == null) {
      this.jdField_a_of_type_Afhc = ((afhc)this.app.getManager(333));
    }
    return this.jdField_a_of_type_Afhc;
  }
  
  public String a(afmi paramafmi)
  {
    if ((paramafmi instanceof aflv))
    {
      String str = ((aflv)paramafmi).bDY;
      paramafmi = str;
      if (TextUtils.isEmpty(str)) {
        paramafmi = "";
      }
      return String.format(BaseApplicationImpl.getApplication().getString(2131693045), new Object[] { paramafmi });
    }
    return null;
  }
  
  public void a(affx.a parama)
  {
    a().a(new affu(this, parama));
  }
  
  public void a(GridView paramGridView, int paramInt, afpn paramafpn)
  {
    Object localObject = ((afhc)this.app.getManager(333)).ez();
    int i = paramafpn.Dg();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == i)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((aflv)paramafpn).bDZ = "needUpload";
        if (this.b != null) {
          this.b.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.bXX = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void cYP()
  {
    super.cYP();
    this.app.addObserver(this.jdField_a_of_type_Acck);
    this.b.setTitle(2131693044);
    this.bXS = false;
    if (this.jdField_a_of_type_Afhc == null) {
      this.jdField_a_of_type_Afhc = ((afhc)this.app.getManager(333));
    }
    initBottomBar();
    cYW();
  }
  
  public void cYS()
  {
    super.cYS();
    this.app.removeObserver(this.jdField_a_of_type_Acck);
    this.bXS = false;
  }
  
  public void cYT()
  {
    anot.a(this.app, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void cYU()
  {
    anot.a(this.app, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
  }
  
  public void cYV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraRoamingStrategy", 2, "doSyncEmotion");
    }
    if (this.app == null) {
      return;
    }
    ThreadManager.excute(new CameraRoamingStrategy.5(this), 128, null, false);
  }
  
  public void cYX()
  {
    if (this.bXS)
    {
      QLog.e("CameraRoamingStrategy", 1, "doDelEmotion,  camera data deleting");
      return;
    }
    this.bXS = true;
    ArrayList localArrayList = new ArrayList();
    List localList = a().ez();
    Object localObject1 = ey();
    if (localList != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (afmi)((Iterator)localObject1).next();
        if ((localObject2 instanceof aflv))
        {
          localObject2 = (aflv)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((aflv)localObject2).emoId == localCameraEmotionData.emoId) && (((aflv)localObject2).isChecked))
            {
              ((aflv)localObject2).isChecked = false;
              localArrayList.add(localCameraEmotionData);
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.post(new CameraRoamingStrategy.3(this, localArrayList), 5, null, false);
      return;
    }
    this.bXS = false;
  }
  
  public void jR(List<afmi> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.zy.clear();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      afmi localafmi = (afmi)paramList.next();
      if ((localafmi instanceof aflv))
      {
        ((aflv)localafmi).isChecked = false;
        Iterator localIterator = this.zy.iterator();
        while (localIterator.hasNext())
        {
          aflv localaflv = (aflv)localIterator.next();
          if (((aflv)localafmi).emoId == localaflv.emoId) {
            ((aflv)localafmi).isChecked = localaflv.isChecked;
          }
        }
        localArrayList.add((aflv)localafmi);
      }
    }
    this.zy = localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affs
 * JD-Core Version:    0.7.0.1
 */