package com.tencent.biz.pubaccount.readinjoy.skin;

import aqhq;
import aqiw;
import aqmj;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mfk;
import mfn;
import mfo;
import mfs;
import mgf;
import mgg;
import mgh;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ReadInjoySkinAndRefreshFacade$2$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$2$1(mgg parammgg, oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2) {}
  
  public void run()
  {
    int j = (int)(System.currentTimeMillis() / 1000L);
    Object localObject2 = (mfn)this.jdField_a_of_type_Mgg.this$0.mApp.getManager(271);
    Object localObject1;
    Object localObject4;
    int i;
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo.has())
    {
      localObject1 = new GuideData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo, this.val$source);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySkinAndRefreshFacadeManager", 2, "guideData = " + localObject1);
      }
      localObject3 = this.jdField_a_of_type_Mgg.this$0.mApp.getEntityManagerFactory().createEntityManager();
      if (localObject1 == null) {
        break label332;
      }
      ((GuideData)localObject1).business = "operation_guide";
      localObject4 = (GuideData)((EntityManager)localObject3).find(GuideData.class, new String[] { ((GuideData)localObject1).id, ((GuideData)localObject1).uin, ((GuideData)localObject1).business });
      if ((localObject4 == null) || (((GuideData)localObject4).showTime == 0)) {
        ((EntityManager)localObject3).persistOrReplace((Entity)localObject1);
      }
      localObject1 = ((mfn)localObject2).d("operation_guide", ((GuideData)localObject1).id);
      if (localObject1 == null) {
        break label342;
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      label196:
      if (!((Iterator)localObject1).hasNext()) {
        break label342;
      }
      localObject3 = (GuideData)((Iterator)localObject1).next();
      if ((i != 0) || (((GuideData)localObject3).source != this.val$source) || (j < ((GuideData)localObject3).beginTime) || (j > ((GuideData)localObject3).endTime)) {
        break label291;
      }
      mgf.a(this.jdField_a_of_type_Mgg.this$0, 271, "operation_guide", (BaseResData)localObject3);
      mgf.a(this.jdField_a_of_type_Mgg.this$0, true);
    }
    for (;;)
    {
      i += 1;
      break label196;
      localObject1 = null;
      break;
      label291:
      if ((j <= ((GuideData)localObject3).endTime) && (aqiw.isWifiConnected(this.jdField_a_of_type_Mgg.this$0.mApp.getApplication()))) {
        ((mfn)localObject2).c("operation_guide", (BaseResData)localObject3);
      }
    }
    label332:
    ((mfn)localObject2).dq(this.val$source);
    label342:
    Object localObject3 = (mfo)this.jdField_a_of_type_Mgg.this$0.mApp.getManager(270);
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo.has())
    {
      localObject1 = new RefreshData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo);
      localObject2 = ((mfo)localObject3).a(this.jdField_a_of_type_Mgg.this$0.mApp.getApplication(), this.val$source);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.4tab", 2, "onReqGuideInfo 5bd回包 ");
        if (localObject1 != null) {
          break label911;
        }
        QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + localObject1);
        label452:
        if (localObject2 != null) {
          break label942;
        }
        QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localObject2);
      }
      label483:
      if (localObject1 != null) {
        break label974;
      }
      if (localObject2 != null)
      {
        aqmj.l(this.jdField_a_of_type_Mgg.this$0.mApp.getApplication(), this.jdField_a_of_type_Mgg.this$0.mApp.getCurrentAccountUin(), null, this.val$source);
        aqhq.cm(mgh.getResPath());
        ((mfo)localObject3).b(0, "", -1L, this.val$source);
      }
      label547:
      if (localObject1 != null)
      {
        ((RefreshData)localObject1).setShowInSource(true, mgf.a(this.jdField_a_of_type_Mgg.this$0));
        if (localObject2 != null) {
          ((RefreshData)localObject1).isShown = ((RefreshData)localObject2).isShown;
        }
        aqmj.l(this.jdField_a_of_type_Mgg.this$0.mApp.getApplication(), this.jdField_a_of_type_Mgg.this$0.mApp.getCurrentAccountUin(), ((RefreshData)localObject1).toJson().toString(), this.val$source);
      }
      if (!this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo.has()) {
        break label1056;
      }
      localObject1 = new SkinData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo);
      label642:
      localObject4 = new GuideData(this.b, this.val$source);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "guideData = " + localObject4);
      }
      localObject3 = (mfs)this.jdField_a_of_type_Mgg.this$0.mApp.getManager(261);
      if ((mgf.a(this.jdField_a_of_type_Mgg.this$0)) || (localObject4 == null) || (j < ((GuideData)localObject4).beginTime) || (j > ((GuideData)localObject4).endTime)) {
        break label1061;
      }
      mgf.a(this.jdField_a_of_type_Mgg.this$0, 261, "", (BaseResData)localObject4);
      label765:
      localObject4 = ((mfs)localObject3).a(this.jdField_a_of_type_Mgg.this$0.mApp.getApplication());
      if ((localObject1 != null) || (((mfs)localObject3).pg() != 1)) {
        break label1116;
      }
      mgf.a(this.jdField_a_of_type_Mgg.this$0, ((mfs)localObject3).jM());
      aqmj.ag(this.jdField_a_of_type_Mgg.this$0.mApp.getApplication(), this.jdField_a_of_type_Mgg.this$0.mApp.getCurrentAccountUin(), null);
      if ((localObject2 != null) && (j <= ((RefreshData)localObject2).endTime))
      {
        ((RefreshData)localObject2).isShown = true;
        aqmj.l(this.jdField_a_of_type_Mgg.this$0.mApp.getApplication(), this.jdField_a_of_type_Mgg.this$0.mApp.getCurrentAccountUin(), ((RefreshData)localObject2).toJson().toString(), this.val$source);
      }
    }
    label911:
    label942:
    label974:
    label1116:
    while ((localObject1 == null) || (localObject4 == null) || (!((SkinData)localObject4).id.equals(((SkinData)localObject1).id)) || (((SkinData)localObject4).seq == ((SkinData)localObject1).seq))
    {
      return;
      localObject1 = null;
      break;
      QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + ((RefreshData)localObject1).toString());
      break label452;
      QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + ((RefreshData)localObject2).toString());
      break label483;
      if (((localObject2 != null) && (((RefreshData)localObject1).id.equals(((RefreshData)localObject2).id)) && ((!((RefreshData)localObject1).id.equals(((RefreshData)localObject2).id)) || (((RefreshData)localObject1).seq <= ((RefreshData)localObject2).seq))) || (j > ((RefreshData)localObject1).endTime)) {
        break label547;
      }
      aqhq.cm(mgh.getResPath());
      ((mfo)localObject3).a((RefreshData)localObject1, mgf.a(this.jdField_a_of_type_Mgg.this$0));
      break label547;
      localObject1 = null;
      break label642;
      if ((localObject4 == null) || (j > ((GuideData)localObject4).endTime) || (!aqiw.isWifiConnected(this.jdField_a_of_type_Mgg.this$0.mApp.getApplication()))) {
        break label765;
      }
      ((mfs)localObject3).a((GuideData)localObject4);
      ((mfs)localObject3).a(((GuideData)localObject4).skinData);
      break label765;
    }
    label1056:
    label1061:
    aqmj.ag(this.jdField_a_of_type_Mgg.this$0.mApp.getApplication(), this.jdField_a_of_type_Mgg.this$0.mApp.getCurrentAccountUin(), ((SkinData)localObject1).toJson().toString());
    if (((SkinData)localObject1).id.equals(((mfs)localObject3).jM()))
    {
      mgf.a(this.jdField_a_of_type_Mgg.this$0, ((SkinData)localObject1).id);
      return;
    }
    aqhq.cn(mfk.eP(((SkinData)localObject1).id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.2.1
 * JD-Core Version:    0.7.0.1
 */