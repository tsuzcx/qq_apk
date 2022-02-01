import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.chatroom.VideoChatRoomContainer;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

public class jgg
{
  private final AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  private VideoChatRoomContainer jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
  private final jgg.a jdField_a_of_type_Jgg$a;
  private final jgg.b jdField_a_of_type_Jgg$b;
  private final VideoAppInterface d;
  private List<jgf> fE;
  private ArrayList<ilw> iX = new ArrayList(10);
  private ArrayList<jgf> iY = new ArrayList(10);
  private ArrayList<jgf> iZ = new ArrayList(10);
  private RelativeLayout mRootView;
  private StringBuilder t;
  
  public jgg(AVActivity paramAVActivity, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.mRootView = ((RelativeLayout)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131373916));
    this.d = paramVideoAppInterface;
    this.jdField_a_of_type_Jgg$b = new jgg.b(this);
    this.jdField_a_of_type_Jgg$a = new jgg.a(this);
    this.d.addObserver(this.jdField_a_of_type_Jgg$b);
    paramAVActivity = this.d.a();
    if (paramAVActivity != null) {
      paramAVActivity.a(this.jdField_a_of_type_Jgg$a);
    }
  }
  
  private VideoChatRoomContainer a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null)
    {
      ((ViewStub)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131374231)).inflate();
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = ((VideoChatRoomContainer)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131373957));
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.q(this.d);
    }
    return this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
  }
  
  private void avZ()
  {
    if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.a.cF(1)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a.awu();
    }
  }
  
  private void c(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo == null) {
      return;
    }
    this.iX.clear();
    ilu localilu = this.d.a();
    if (localilu != null) {
      localilu.a(paramChatRoomInfo, this.iX);
    }
    paramChatRoomInfo = null;
    if (this.fE != this.iY) {
      paramChatRoomInfo = this.iY;
    }
    for (;;)
    {
      i(this.iX, paramChatRoomInfo);
      this.fE = paramChatRoomInfo;
      this.jdField_a_of_type_ComTencentAvUiAVActivity.runOnUiThread(new VideoChatRoomUIContoller.3(this));
      return;
      if (this.fE != this.iZ) {
        paramChatRoomInfo = this.iZ;
      }
    }
  }
  
  private int getWidth()
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null)
    {
      int j = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getWidth();
      int i = j;
      if (j == 0)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.measure(0, 0);
        i = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getMeasuredWidth();
      }
      return i;
    }
    return 0;
  }
  
  private void i(List<ilw> paramList, List<jgf> paramList1)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    String str1 = this.d.getCurrentAccountUin();
    paramList1.clear();
    paramList = paramList.iterator();
    label31:
    ilw localilw;
    jgf localjgf;
    while (paramList.hasNext())
    {
      localilw = (ilw)paramList.next();
      if (localilw != null)
      {
        String str2 = String.valueOf(localilw.senderUin);
        localjgf = jgf.a();
        localjgf.ks(str2);
        localjgf.setContent(localilw.msg);
        if (!TextUtils.equals(str2, str1)) {
          break label154;
        }
      }
    }
    label154:
    for (int i = 1;; i = 2)
    {
      localjgf.setType(i);
      localjgf.setMsgId(String.format("%s|%s", new Object[] { Long.valueOf(localilw.lO), Long.valueOf(localilw.lN) }));
      paramList1.add(localjgf);
      break label31;
      break;
    }
  }
  
  private void nu(int paramInt)
  {
    iiv localiiv = igv.a().a();
    if ((localiiv.isRecording) || (localiiv.Qw)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel can not show when recording.");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null) || (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getVisibility() != 0)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel has already show");
    return;
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null) {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = a();
    }
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(0);
    avZ();
    Object localObject;
    if (paramInt == 2)
    {
      localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "TranslationX", new float[] { getWidth(), 0.0F });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.start();
    }
    for (;;)
    {
      nv(this.jdField_a_of_type_ComTencentAvUiAVActivity.mControlUI.mi());
      awa();
      localObject = this.d.a();
      if (localObject != null)
      {
        localObject = ((ilu)localObject).a(localiiv, true);
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomUtil", 2, String.format("showChatRoomPanelWithAnimation, session[%s], chat_room[%s]", new Object[] { localiiv, localObject }));
        }
        c((ChatRoomInfo)localObject);
      }
      ily.report("0X800A8D3");
      return;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setTranslationX(0.0F);
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setAlpha(1.0F);
      }
    }
  }
  
  public void awa()
  {
    if (xj()) {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, this.jdField_a_of_type_ComTencentAvUiAVActivity.lI());
    }
  }
  
  public void destroy(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (igv.a().a().Rn = xj();; igv.a().a().Rn = false)
    {
      ilu localilu = this.d.a();
      if (localilu != null) {
        localilu.b(this.jdField_a_of_type_Jgg$a);
      }
      this.d.deleteObserver(this.jdField_a_of_type_Jgg$b);
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, "VideoChatRoomUIContoller-destroy, isQuit[" + paramBoolean + "], mCheckFirstShowChatRoomPanel[" + igv.a().a().Rn + "]");
      }
      return;
    }
  }
  
  public void kt(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    ilu localilu;
    ChatRoomInfo localChatRoomInfo;
    do
    {
      do
      {
        return;
        localilu = this.d.a();
      } while (localilu == null);
      localChatRoomInfo = localilu.a(igv.a().a(), true);
    } while (localChatRoomInfo == null);
    localilu.a(localChatRoomInfo, paramString, System.currentTimeMillis());
  }
  
  public int ms()
  {
    int i = 0;
    if (xj()) {
      i = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.mr();
    }
    return i;
  }
  
  public void nt(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "showChatRoomPanel, which[" + paramInt + "]");
    }
    nu(paramInt);
  }
  
  public void nv(int paramInt)
  {
    if (xj())
    {
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.lI() != 4) {
        break label144;
      }
      iiv localiiv = null;
      VideoController localVideoController = this.d.b();
      if (localVideoController != null) {
        localiiv = localVideoController.b();
      }
      if ((localiiv == null) || (!localiiv.td()) || (!localiiv.isVideo())) {
        break label144;
      }
    }
    label144:
    for (int i = this.jdField_a_of_type_ComTencentAvUiAVActivity.b.axX + paramInt + this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getDimensionPixelSize(2131298069);; i = paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomUtil", 4, String.format("updateChatRoomPanel, [%s --> %s], layoutMode[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.lI()) }));
      }
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.ns(i);
      return;
    }
  }
  
  public void nw(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatRoomUtil", 4, "hideChatRoomPanel, from[" + paramInt + "]");
    }
    Object localObject;
    if (xj())
    {
      if (paramInt == 2)
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(300L);
        ((AlphaAnimation)localObject).setAnimationListener(new jgh(this));
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.startAnimation((Animation)localObject);
      }
    }
    else {
      return;
    }
    if (paramInt == 1)
    {
      localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "TranslationX", new float[] { 0.0F, getWidth() });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "alpha", new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new jgi(this));
      localAnimatorSet.start();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(8);
  }
  
  public boolean onBackPressed()
  {
    boolean bool = false;
    if (xj()) {
      bool = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.onBackPressed();
    }
    return bool;
  }
  
  public boolean xh()
  {
    return (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null) && (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.xh());
  }
  
  public boolean xj()
  {
    return (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null) && (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getVisibility() == 0);
  }
  
  static class a
    implements ilx
  {
    private final WeakReference<jgg> j;
    
    a(jgg paramjgg)
    {
      this.j = new WeakReference(paramjgg);
    }
    
    public void b(int paramInt, ChatRoomInfo paramChatRoomInfo)
    {
      int i;
      jgg localjgg;
      if ((paramInt & 0x4) == 4)
      {
        i = 1;
        if (QLog.isDevelopLevel()) {
          QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
        }
        localjgg = (jgg)this.j.get();
        if (localjgg != null) {
          break label77;
        }
      }
      label77:
      do
      {
        return;
        i = 0;
        break;
        if (localjgg.xj())
        {
          jgg.a(localjgg, paramChatRoomInfo);
          return;
        }
      } while (i == 0);
      jgg.a(localjgg, 0);
    }
    
    public void c(ilw paramilw)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramilw + "]");
      }
      jgg localjgg = (jgg)this.j.get();
      if ((paramilw == null) || (localjgg == null)) {}
      while (!localjgg.xj()) {
        return;
      }
      jgg.a(localjgg, paramilw.b);
    }
  }
  
  static class b
    implements Observer
  {
    private final WeakReference<jgg> j;
    
    b(jgg paramjgg)
    {
      this.j = new WeakReference(paramjgg);
    }
    
    public void update(Observable paramObservable, Object paramObject)
    {
      paramObservable = (Object[])paramObject;
      switch (((Integer)paramObservable[0]).intValue())
      {
      }
      do
      {
        return;
        paramObject = (jgg)this.j.get();
      } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
      paramObject.awa();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgg
 * JD-Core Version:    0.7.0.1
 */