import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.a;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.nearfield_group.nearfield_group.BusiRespHead;

public class afzo
  extends acib
{
  public afzo(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void a(agay paramagay)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.bFZ;
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvTroopPush, from_type=").append(this.this$0.cVN).append(",groupProfile isNull=");
      if (paramagay == null)
      {
        bool = true;
        QLog.d((String)localObject, 2, bool + ",show_type=");
      }
    }
    else if ((this.this$0.cVN == 0) && (paramagay != null) && (!this.this$0.AE.contains(paramagay)))
    {
      this.this$0.AE.add(paramagay);
      if (this.this$0.ae.size() != this.this$0.AG.size()) {
        break label162;
      }
      Face2FaceAddFriendActivity.a(this.this$0, paramagay);
    }
    for (;;)
    {
      paramagay = this.this$0;
      paramagay.cVW += 1;
      return;
      bool = false;
      break;
      label162:
      localObject = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
      ((Message)localObject).what = 10;
      ((Message)localObject).obj = paramagay;
      Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(10, 5000L);
    }
  }
  
  public void a(agbb paramagbb)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.bFZ;
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvMemberPush, from_type=").append(this.this$0.cVN).append(",fromTroopUin=").append(this.this$0.bGa).append(",userProfile isNull=");
      if (paramagbb == null)
      {
        bool = true;
        QLog.d((String)localObject, 2, bool + "total:" + (this.this$0.AD.size() + 1));
      }
    }
    else
    {
      if (paramagbb != null) {
        break label108;
      }
    }
    label108:
    do
    {
      long l1;
      long l2;
      long l3;
      do
      {
        return;
        bool = false;
        break;
        l1 = System.currentTimeMillis();
        l2 = l1 - this.this$0.XZ;
        if ((this.this$0.XZ == 0L) || (l2 >= 1000L) || (paramagbb.Ye != 0L)) {
          break label269;
        }
        localObject = Message.obtain();
        ((Message)localObject).what = 16;
        ((Message)localObject).obj = paramagbb;
        l3 = 1000L - l2;
        Face2FaceAddFriendActivity.a(this.this$0).sendMessageDelayed((Message)localObject, l3);
        paramagbb.Ye = l1;
        this.this$0.XZ = (l1 + l3);
      } while (!QLog.isColorLevel());
      QLog.d(Face2FaceAddFriendActivity.bFZ, 2, "onRecvMemberPush, delay=" + l2 + ", delayed=" + l3 + ",mLastToopMemberPushStamp=" + this.this$0.XZ);
      return;
      if (paramagbb.Ye == 0L) {
        this.this$0.XZ = l1;
      }
    } while ((this.this$0.cVN != 1) || (this.this$0.AD.contains(paramagbb)));
    label269:
    this.this$0.AD.add(paramagbb);
    if ((this.this$0.ccj) && (this.this$0.jdField_a_of_type_Agaz != null))
    {
      this.this$0.RU.setText(String.valueOf(this.this$0.AD.size()));
      this.this$0.jdField_a_of_type_Agaz.c(paramagbb);
      return;
    }
    Face2FaceAddFriendActivity.a(this.this$0, paramagbb);
    this.this$0.dep();
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = Face2FaceAddFriendActivity.bFZ;
      StringBuilder localStringBuilder = new StringBuilder().append("onCloseFace2faceTroop, respHead isNull=");
      if (paramBusiRespHead == null)
      {
        bool = true;
        QLog.d(str, 2, bool);
      }
    }
    else
    {
      if (paramBusiRespHead != null) {
        break label59;
      }
    }
    label59:
    int i;
    int j;
    int k;
    do
    {
      return;
      bool = false;
      break;
      i = paramBusiRespHead.int32_reply_code.get();
      j = paramBusiRespHead.int32_seq.get();
      k = paramBusiRespHead.int32_version.get();
      paramBusiRespHead = paramBusiRespHead.str_result.get();
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onCloseFace2faceTroop, ret=" + i + ",seqNo=" + j + ",ver=" + k + ",errInfo=" + paramBusiRespHead + ",from_type=" + this.this$0.cVN + ",fromTroopUin=" + this.this$0.bGa);
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, String paramString)
  {
    if ((this.this$0.O != null) && (this.this$0.O.isShowing()))
    {
      this.this$0.O.dismiss();
      this.this$0.O = null;
    }
    if (paramBusiRespHead == null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.d(-1, "", paramString, this.this$0.isFinishing());
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.bFZ, 2, "onJoinTroop, respHead isNull=true, troopCode=" + paramString);
      }
    }
    int i;
    String str;
    do
    {
      return;
      i = paramBusiRespHead.int32_reply_code.get();
      int j = paramBusiRespHead.int32_seq.get();
      int k = paramBusiRespHead.int32_version.get();
      str = paramBusiRespHead.str_result.get();
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.bFZ, 2, "onJoinTroop, ret=" + i + ", seqNo=" + j + ",ver=" + k + ",errInfo=" + str + ",troopCode=" + paramString + ",from_type=" + this.this$0.cVN + ",fromTroopUin=" + this.this$0.bGa);
      }
    } while (this.this$0.cVN != 0);
    if (i == 0)
    {
      Iterator localIterator = this.this$0.jdField_a_of_type_Agan.AI.iterator();
      while (localIterator.hasNext())
      {
        paramBusiRespHead = (Face2FaceFriendBubbleView)localIterator.next();
        if ((paramBusiRespHead != null) && (paramBusiRespHead.lk() == 2) && (paramString.equals(paramBusiRespHead.getUin())))
        {
          paramBusiRespHead.setStatusWithAnimation(2);
          paramBusiRespHead = paramBusiRespHead.g();
          if (!(paramBusiRespHead instanceof agay)) {
            break label479;
          }
        }
      }
    }
    label479:
    for (paramBusiRespHead = paramBusiRespHead.bGh + "_" + ((agay)paramBusiRespHead).bGg;; paramBusiRespHead = paramString)
    {
      this.this$0.jdField_a_of_type_Agan.Iy(paramBusiRespHead);
      paramBusiRespHead = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
      paramBusiRespHead.what = 11;
      paramBusiRespHead.arg1 = 2;
      Face2FaceAddFriendActivity.a(this.this$0).sendMessageDelayed(paramBusiRespHead, this.this$0.DV());
      break;
      anot.a(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "suc_join", 0, 0, paramString, "3.4.4", "", this.this$0.app.getCurrentAccountUin());
      this.this$0.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.d(i, str, paramString, this.this$0.isFinishing());
      return;
    }
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, List<agay> paramList)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    if (paramList == null)
    {
      i = 0;
      if (QLog.isColorLevel())
      {
        String str = Face2FaceAddFriendActivity.bFZ;
        StringBuilder localStringBuilder = new StringBuilder().append("onOpenFace2faceTroop, respHead isNull=");
        if (paramBusiRespHead != null) {
          break label179;
        }
        bool1 = true;
        label42:
        localStringBuilder = localStringBuilder.append(bool1).append(", troopList isNull=");
        bool1 = bool2;
        if (paramList == null) {
          bool1 = true;
        }
        QLog.d(str, 2, bool1 + ", troopList.size=" + i);
      }
      if (paramBusiRespHead != null) {
        break label185;
      }
      this.this$0.cVR = 2;
      Face2FaceAddFriendActivity.d(this.this$0);
      if (this.this$0.cVN == 1) {
        aqha.a(this.this$0, 230, this.this$0.getString(2131721103), acfp.m(2131706028), 2131721058, 2131693282, new afzp(this), null).show();
      }
    }
    label179:
    label185:
    do
    {
      do
      {
        return;
        i = paramList.size();
        break;
        bool1 = false;
        break label42;
        i = paramBusiRespHead.int32_reply_code.get();
        int j = paramBusiRespHead.int32_seq.get();
        int k = paramBusiRespHead.int32_version.get();
        paramBusiRespHead = paramBusiRespHead.str_result.get();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.bFZ, 2, "onOpenFace2faceTroop, ret=" + i + ",seqNo=" + j + ",ver=" + k + ",errInfo=" + paramBusiRespHead + ",from_type=" + this.this$0.cVN + ",fromTroopUin=" + this.this$0.bGa);
        }
        if (i != 0) {
          break label421;
        }
        this.this$0.cVR = 1;
      } while (this.this$0.cVN != 0);
      if ((paramList != null) && (paramList.size() > 0)) {
        paramBusiRespHead = paramList.iterator();
      }
      for (;;)
      {
        if (paramBusiRespHead.hasNext())
        {
          paramList = (agba)paramBusiRespHead.next();
          if (!this.this$0.AE.contains(paramList)) {}
        }
        else
        {
          this.this$0.ccc = true;
          Face2FaceAddFriendActivity.d(this.this$0);
          return;
        }
        this.this$0.AE.add(paramList);
      }
      this.this$0.cVR = 2;
      Face2FaceAddFriendActivity.d(this.this$0);
    } while (this.this$0.cVN != 1);
    label421:
    aqha.a(this.this$0, 230, this.this$0.getString(2131721103), acfp.m(2131706021), 2131721058, 2131693282, new afzq(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzo
 * JD-Core Version:    0.7.0.1
 */