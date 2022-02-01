import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.av.redpacket.AVRedPacketManager.a;
import com.tencent.av.redpacket.AVRedPacketManager.b;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class irn
  implements Handler.Callback, AVRedPacketManager.a
{
  public VideoAppInterface a;
  public AVActivity a;
  public AVRedPacketManager b;
  public int mState = -1;
  public Handler mSubHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  public Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  
  public irn(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.b = ((AVRedPacketManager)paramVideoAppInterface.a(6));
    this.b.a(this);
  }
  
  private RedPacketGameView a()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131366050);
    Object localObject1 = null;
    Object localObject2;
    View localView;
    if (localViewGroup != null)
    {
      localObject2 = (RedPacketGameView)localViewGroup.findViewById(2131374182);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new RedPacketGameView(localViewGroup.getContext(), this.jdField_a_of_type_ComTencentAvUiAVActivity);
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.a != null) {
          break label114;
        }
        i = 0;
        ((RedPacketGameView)localObject1).setScoreMarginTop(i);
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        localView = localViewGroup.findViewById(2131374149);
        if (localView == null) {
          break label128;
        }
      }
    }
    label128:
    for (int i = localViewGroup.indexOfChild(localView);; i = -1)
    {
      localViewGroup.addView((View)localObject1, i, (ViewGroup.LayoutParams)localObject2);
      return localObject1;
      label114:
      i = this.jdField_a_of_type_ComTencentAvUiAVActivity.a.me();
      break;
    }
  }
  
  private void apT()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131366050);
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)localViewGroup.findViewById(2131374182);
    if (localRedPacketGameView != null)
    {
      localRedPacketGameView.recycle();
      localViewGroup.removeView(localRedPacketGameView);
    }
  }
  
  private void c(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    int i = 3;
    paramLocalFrameSyncInfo = paramLocalFrameSyncInfo.localHitInfo;
    if (paramLocalFrameSyncInfo.topWordTipType == 1) {}
    for (;;)
    {
      if (i != -1) {
        this.b.C(i, false);
      }
      if (paramLocalFrameSyncInfo.comboCnt > 0) {
        this.b.C(6, false);
      }
      return;
      if (paramLocalFrameSyncInfo.topWordTipType == 2) {
        i = 2;
      } else if (paramLocalFrameSyncInfo.topWordTipType == 3) {
        i = 4;
      } else if (paramLocalFrameSyncInfo.topWordTipType == 4) {
        i = 5;
      } else {
        i = -1;
      }
    }
  }
  
  private boolean vq()
  {
    return this.mState != -1;
  }
  
  public void B(int paramInt, boolean paramBoolean)
  {
    if (!vp()) {}
    RedPacketGameView localRedPacketGameView;
    do
    {
      return;
      localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182);
      if (paramInt == AVRedPacketManager.asH)
      {
        localRedPacketGameView.iS(paramBoolean);
        return;
      }
      if (paramInt == AVRedPacketManager.asI)
      {
        localRedPacketGameView.iT(paramBoolean);
        return;
      }
      if (paramInt == AVRedPacketManager.asJ)
      {
        localRedPacketGameView.iU(paramBoolean);
        return;
      }
    } while (paramInt != AVRedPacketManager.asK);
    localRedPacketGameView.iV(paramBoolean);
  }
  
  public void a(int paramInt, AVRedPacketManager.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.preLoadRes,mState = " + this.mState + ",type = " + paramInt + ",manager = " + this.b);
    }
    try
    {
      long l1 = System.currentTimeMillis();
      RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182);
      if (localRedPacketGameView != null) {
        localRedPacketGameView.d(this.b);
      }
      for (boolean bool = true;; bool = false)
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.preLoadRes,suc = " + bool + ",type = " + paramInt + ",cost = " + (l2 - l1));
        }
        if (paramb == null) {
          break;
        }
        paramb.u(bool, paramInt);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.preLoadRes  not init");
        }
      }
      return;
    }
    catch (Exception paramb)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.preLoadRes  exception", paramb);
      }
    }
  }
  
  public void a(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.onEmojiHit, " + this.mState + ",localFrameSyncInfo=" + paramLocalFrameSyncInfo);
    }
    if (!vq()) {
      return;
    }
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.d(paramLocalFrameSyncInfo);
    c(paramLocalFrameSyncInfo);
  }
  
  public void apO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.onGameFinish," + this.mState);
    }
    if (!vq()) {}
    while (this.mState == 5) {
      return;
    }
    this.mState = 5;
    apQ();
    apT();
    this.mState = -1;
  }
  
  public void apP()
  {
    if (!vq()) {
      return;
    }
    ((RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182)).apP();
  }
  
  public void apQ()
  {
    if (this.mState == -1) {}
    while ((vr()) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.d("AVRedPacketManager", 2, "gameMode");
  }
  
  public void apR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showRedPacketSend, " + this.mState);
    }
    if (!vp()) {}
    while (this.mState == 2) {
      return;
    }
    this.mState = 2;
    apQ();
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.aqs();
  }
  
  public void apS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showRedPacketCome, " + this.mState);
    }
    if (!vp()) {}
    while (this.mState == 2) {
      return;
    }
    this.mState = 2;
    apQ();
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.apZ();
  }
  
  public void apU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showReceiverUserGuide, " + this.mState);
    }
    if (!vp()) {}
    RedPacketGameView localRedPacketGameView;
    do
    {
      return;
      localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182);
    } while (localRedPacketGameView == null);
    localRedPacketGameView.apU();
  }
  
  public void b(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.onUpdateFrameInfo, " + this.mState + "," + paramLocalFrameSyncInfo);
    }
    if (!vq()) {
      return;
    }
    ((RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182)).b(paramLocalFrameSyncInfo);
  }
  
  public void g(int paramInt, List<AVRedPacketManager.LocalEmojiInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showGameReady, " + this.mState + "," + paramInt);
    }
    if (!vp()) {}
    while (this.mState == 3) {
      return;
    }
    this.mState = 3;
    apQ();
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.h(paramInt, paramList);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    return false;
  }
  
  public void iL(boolean paramBoolean) {}
  
  public void lx(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showGameRunning, " + this.mState + "," + paramInt);
    }
    if (!vq()) {}
    while (this.mState == 4) {
      return;
    }
    this.mState = 4;
    apQ();
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.iS(false);
    if (paramInt == 2) {
      localRedPacketGameView.aqt();
    }
    this.b.C(7, true);
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      this.b.a(null);
    }
  }
  
  public boolean vp()
  {
    Object localObject = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374182);
    if (this.mState == -1)
    {
      RedPacketGameView localRedPacketGameView = a();
      localObject = localRedPacketGameView;
      if (localRedPacketGameView != null)
      {
        this.mState = 1;
        localObject = localRedPacketGameView;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "initUI," + this.mState + "," + localObject);
    }
    return localObject != null;
  }
  
  public boolean vr()
  {
    return this.mState != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irn
 * JD-Core Version:    0.7.0.1
 */