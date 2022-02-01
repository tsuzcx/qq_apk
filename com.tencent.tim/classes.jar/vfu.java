import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class vfu
  implements Handler.Callback
{
  private vfu.a a;
  private boolean aXX;
  private boolean aXY;
  private QQAppInterface app;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private vfu.a jdField_b_of_type_Vfu$a;
  private vfu.a c;
  private int currentIndex;
  private vfu.a d;
  private ImageSwitcher f;
  private MqqHandler g;
  private int playState = 0;
  private ArrayList<String> po;
  private ImageView qm;
  
  public vfu(ImageSwitcher paramImageSwitcher1, ImageSwitcher paramImageSwitcher2, ImageView paramImageView, MqqHandler paramMqqHandler, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_AndroidWidgetImageSwitcher = paramImageSwitcher1;
    this.f = paramImageSwitcher2;
    this.qm = paramImageView;
    this.g = new MqqHandler(Looper.getMainLooper(), this);
    this.app = paramQQAppInterface;
  }
  
  private boolean PQ()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageSwitcher == null) {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "mQzoneFeedSubIcon=null");
      }
    }
    do
    {
      return false;
      if ((this.po != null) && (!this.po.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "activeFeedsUin没有uin数据");
    return false;
    return true;
  }
  
  private boolean PR()
  {
    String str;
    if ((this.currentIndex >= this.po.size()) || ((this.aXX) && (this.po.size() == 2)) || ((this.aXX) && (this.currentIndex >= this.po.size() - 1))) {
      if ((this.d != null) && (this.playState != 4))
      {
        if (!this.aXX) {
          break label478;
        }
        if ((this.c != null) && (!this.c.isRecycled())) {
          break label302;
        }
        str = (String)this.po.get(1);
        if ((this.d.isRecycled()) || (!this.d.uin.equals(str))) {
          break label287;
        }
        this.c = this.d;
        this.d = null;
        this.f.setImageDrawable(this.c.c);
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "isPlayFinished play two" + this.c.uin);
        }
        str = (String)this.po.get(0);
        if ((this.d == null) || (this.d.isRecycled()) || (!this.d.uin.equals(str))) {
          break label412;
        }
        this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.d.c);
        this.a = this.jdField_b_of_type_Vfu$a;
        this.jdField_b_of_type_Vfu$a = this.d;
        this.d = null;
      }
    }
    for (;;)
    {
      this.playState = 4;
      if (this.playState != 4) {
        break label553;
      }
      return true;
      label287:
      this.c = vfu.a.a(str, this.app);
      break;
      label302:
      if (this.c.uin.equals(this.po.get(1))) {
        break;
      }
      if (!this.c.isRecycled())
      {
        this.c.recycle();
        this.c = null;
      }
      str = (String)this.po.get(1);
      if ((!this.d.isRecycled()) && (this.d.uin.equals(str)))
      {
        this.c = this.d;
        this.d = null;
        break;
      }
      this.c = vfu.a.a(str, this.app);
      break;
      label412:
      this.a = this.jdField_b_of_type_Vfu$a;
      if ((this.d != null) && (!this.d.isRecycled()))
      {
        this.d.recycle();
        this.d = null;
      }
      this.jdField_b_of_type_Vfu$a = vfu.a.a(str, this.app);
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.jdField_b_of_type_Vfu$a.c);
      continue;
      label478:
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.d.c);
      this.a = this.jdField_b_of_type_Vfu$a;
      this.jdField_b_of_type_Vfu$a = this.d;
      this.d = null;
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "isPlayFinished play one" + this.jdField_b_of_type_Vfu$a.uin);
      }
    }
    label553:
    return false;
  }
  
  private vfu.a a(String paramString)
  {
    if (this.d != null)
    {
      if (!this.d.hm(paramString)) {
        break label54;
      }
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "命中预加载faceDrawable  uin:" + paramString);
      }
    }
    for (;;)
    {
      return this.d;
      label54:
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "没有命中预加载，回收预加载:" + paramString);
      }
      this.d.recycle();
      this.d = null;
    }
  }
  
  private void bQR()
  {
    if ((this.a != null) && (!this.a.isRecycled()))
    {
      this.a.recycle();
      this.a = null;
    }
    if ((this.jdField_b_of_type_Vfu$a != null) && (!this.jdField_b_of_type_Vfu$a.isRecycled()))
    {
      this.jdField_b_of_type_Vfu$a.recycle();
      this.jdField_b_of_type_Vfu$a = null;
    }
    if ((this.c != null) && (!this.c.isRecycled()))
    {
      this.c.recycle();
      this.c = null;
    }
    if ((this.d != null) && (!this.d.isRecycled()))
    {
      this.d.recycle();
      this.d = null;
    }
  }
  
  private void bQV()
  {
    if (this.qm != null)
    {
      if ("1000".equals(ThemeUtil.curThemeId)) {
        break label28;
      }
      this.qm.setVisibility(8);
    }
    label28:
    while ((!this.aXX) || (this.qm.getVisibility() == 0)) {
      return;
    }
    this.qm.setVisibility(0);
  }
  
  private static boolean c(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if ((paramArrayList1 == null) && (paramArrayList2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, " equal arrayList1==null&&arrayList2==null");
      }
      return true;
    }
    if ((paramArrayList1 == null) || (paramArrayList2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal  arrayList1==null||arrayList2==null");
      }
      return false;
    }
    if (paramArrayList1.size() != paramArrayList2.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal arrayList1.size()!=arrayList2.size()");
      }
      return false;
    }
    int i = 0;
    try
    {
      while (i < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i);
        String str2 = (String)paramArrayList2.get(i);
        if (!str1.equals(str2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("not equal index: %d,uin1:%s,uin2:%s", new Object[] { Integer.valueOf(i), str1, str2 }));
          }
          return false;
        }
        i += 1;
      }
      return true;
    }
    catch (Throwable paramArrayList1)
    {
      QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, paramArrayList1, new Object[0]);
      return false;
    }
  }
  
  private void clearAnimation()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageSwitcher == null) {
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageSwitcher.getInAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageSwitcher.getOutAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setOutAnimation(null);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setInAnimation(null);
    this.f.setOutAnimation(null);
    this.f.setInAnimation(null);
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidWidgetImageSwitcher.getChildCount())
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageSwitcher.getChildAt(i);
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      i += 1;
    }
    i = 0;
    while (i < this.f.getChildCount())
    {
      localObject = this.f.getChildAt(i);
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      i += 1;
    }
    this.aXY = false;
  }
  
  private String cu(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return acfp.m(2131707646);
    case 0: 
      return acfp.m(2131707648);
    case 1: 
      return acfp.m(2131707650);
    case 2: 
      return acfp.m(2131707649);
    }
    return acfp.m(2131707651);
  }
  
  private boolean gd(int paramInt)
  {
    return this.playState >= paramInt;
  }
  
  private boolean ge(int paramInt)
  {
    return this.playState < paramInt;
  }
  
  public void bQS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "pausePlayFace pre playState=" + cu(this.playState));
    }
    if ((gd(2)) && (ge(4)))
    {
      this.g.removeMessages(1688002);
      this.playState = 1;
    }
  }
  
  public void bQT()
  {
    bQV();
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "resumePlayFace pre playState=" + cu(this.playState));
    }
    if (!ge(4))
    {
      this.playState = 2;
      this.currentIndex = 0;
      yO();
    }
    while (!gd(1)) {
      return;
    }
    this.playState = 2;
    if ((this.po != null) && (this.currentIndex >= this.po.size())) {
      this.currentIndex = 0;
    }
    yO();
  }
  
  public void bQU()
  {
    if (this.po != null)
    {
      this.po.clear();
      this.currentIndex = 0;
    }
    clearAnimation();
    if (this.jdField_b_of_type_AndroidWidgetImageSwitcher != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable(null);
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
    }
    if (this.f != null)
    {
      this.f.setImageDrawable(null);
      this.f.setVisibility(8);
    }
    if (this.qm != null) {
      this.qm.setVisibility(8);
    }
    bQR();
  }
  
  public void cR(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      this.aXX = true;
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("start play qzone face pre list:%s, current list:%s, currentPlayState:%s, currentIndex:%d", new Object[] { String.valueOf(this.po), String.valueOf(paramArrayList), cu(this.playState), Integer.valueOf(this.currentIndex) }));
      }
      if ((!ge(2)) && (c(this.po, paramArrayList))) {
        break label339;
      }
      this.g.removeMessages(1688002);
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        break label314;
      }
      this.playState = 2;
      this.currentIndex = 0;
      if (this.po != null) {
        break label269;
      }
      this.po = new ArrayList(paramArrayList.size());
      this.po.addAll(paramArrayList);
      paramArrayList = (String)this.po.get(this.currentIndex);
      if (this.aXX) {
        paramArrayList = (String)this.po.get(this.currentIndex + 1);
      }
      this.d = vfu.a.a(paramArrayList, this.app);
      if (this.jdField_b_of_type_AndroidWidgetImageSwitcher.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
      }
      if (!this.aXX) {
        break label279;
      }
      if (this.f.getVisibility() != 0) {
        this.f.setVisibility(0);
      }
      bQV();
      yO();
    }
    label269:
    label279:
    label314:
    label339:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        this.aXX = false;
        break;
        this.po.clear();
        continue;
        if (this.f != null) {
          this.f.setVisibility(8);
        }
        if (this.qm != null) {
          this.qm.setVisibility(8);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "start play qzone face 更新数据为 null，隐藏头像");
      }
      bQU();
      this.playState = 0;
      return;
    }
    QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "数据没有发生变化，保持原有的播放状态:" + this.po);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.app != null) && ("0".equals(this.app.getCurrentAccountUin()))) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1688002: 
      yO();
      return true;
    }
    this.currentIndex = 0;
    if (this.po != null) {
      this.po.clear();
    }
    return true;
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    bQU();
    this.app = paramQQAppInterface;
  }
  
  public void onPostThemeChanged()
  {
    bQV();
  }
  
  void xA(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageSwitcher == null) {}
    while (this.aXY) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setAnimateFirstView(false);
    this.f.setAnimateFirstView(false);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(1400L);
    localAlphaAnimation1.setAnimationListener(new vfv(this, paramBoolean));
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(1400L);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setInAnimation(localAlphaAnimation1);
    this.f.setInAnimation(localAlphaAnimation2);
    localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(1400L);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setOutAnimation(localAlphaAnimation1);
    this.f.setOutAnimation(localAlphaAnimation1);
    this.aXY = true;
  }
  
  void yO()
  {
    for (;;)
    {
      try
      {
        if (!PQ()) {
          break label812;
        }
        if (PR())
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "已经播放完毕，不再轮播头像");
          return;
        }
        if (!gd(2)) {
          break label776;
        }
        if ((this.po.size() > 1) && (this.currentIndex > 0))
        {
          xA(true);
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("play index :%d, uin:%s,total size=:%d", new Object[] { Integer.valueOf(this.currentIndex), this.po.get(this.currentIndex), Integer.valueOf(this.po.size()) }));
          }
          this.a = this.jdField_b_of_type_Vfu$a;
          Object localObject = (String)this.po.get(this.currentIndex);
          if (!this.aXX) {
            break label591;
          }
          if ((this.c == null) || (this.c.isRecycled())) {
            break label545;
          }
          if (!this.c.uin.equals(localObject)) {
            break label520;
          }
          this.jdField_b_of_type_Vfu$a = this.c;
          this.c = null;
          localObject = this.jdField_b_of_type_Vfu$a.a();
          this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable((Drawable)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "play two" + this.jdField_b_of_type_Vfu$a.uin);
          }
          this.c = a((String)this.po.get(this.currentIndex + 1));
          if (this.c == null) {
            this.c = vfu.a.a((String)this.po.get(this.currentIndex + 1), this.app);
          }
          localObject = this.c.a();
          if (localObject != null)
          {
            this.f.setImageDrawable((Drawable)localObject);
            if (QLog.isColorLevel()) {
              QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "play two" + this.c.uin);
            }
          }
          if (this.currentIndex == 0) {
            this.g.sendEmptyMessageDelayed(1688002, 1400L);
          }
          this.currentIndex += 1;
          if (((!this.aXX) || (this.currentIndex >= this.po.size() - 1)) && ((this.aXX) || (this.currentIndex >= this.po.size()))) {
            break;
          }
          localObject = (String)this.po.get(this.currentIndex);
          if (this.aXX) {
            localObject = (String)this.po.get(this.currentIndex + 1);
          }
          this.d = vfu.a.a((String)localObject, this.app);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, "播放头像过程中出现错误，请关注异常信息", localThrowable);
        awcz.h(localThrowable, acfp.m(2131707647));
        return;
      }
      clearAnimation();
      continue;
      label520:
      if (!this.c.isRecycled())
      {
        this.c.recycle();
        this.c = null;
        continue;
        label545:
        if ((this.jdField_b_of_type_Vfu$a == null) || ((!this.jdField_b_of_type_Vfu$a.isRecycled()) && (!this.jdField_b_of_type_Vfu$a.uin.equals(localThrowable))))
        {
          this.jdField_b_of_type_Vfu$a = vfu.a.a(localThrowable, this.app);
          continue;
          label591:
          this.jdField_b_of_type_Vfu$a = a(localThrowable);
          if (this.jdField_b_of_type_Vfu$a == null) {
            this.jdField_b_of_type_Vfu$a = vfu.a.a(localThrowable, this.app);
          }
          aqdj localaqdj = this.jdField_b_of_type_Vfu$a.a();
          if (localaqdj != null)
          {
            this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable(localaqdj);
            if (QLog.isColorLevel()) {
              QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "play one" + this.jdField_b_of_type_Vfu$a.uin);
            }
          }
        }
      }
    }
    if (((!this.aXX) && (this.currentIndex == this.po.size())) || ((this.aXX) && (this.currentIndex == this.po.size() - 1)))
    {
      this.d = vfu.a.a((String)this.po.get(0), this.app);
      if (this.aXX)
      {
        this.c = vfu.a.a((String)this.po.get(1), this.app);
        return;
        label776:
        if (QLog.isColorLevel())
        {
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "播放状态不对，不进行播放 playState:" + this.playState);
          return;
          label812:
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "非法状态，不进行播放下一张头像");
          }
        }
      }
    }
  }
  
  static class a
  {
    private static a e;
    private static int sPoolSize;
    private static final Object sPoolSync = new Object();
    volatile boolean aEC;
    aqdj c;
    private a f;
    String uin;
    
    static a a()
    {
      synchronized (sPoolSync)
      {
        if (e != null)
        {
          a locala = e;
          e = locala.f;
          locala.f = null;
          sPoolSize -= 1;
          return locala;
        }
        return new a();
      }
    }
    
    static a a(String paramString, QQAppInterface paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
      }
      a locala = a();
      locala.uin = paramString;
      aqdj localaqdj = locala.a();
      if (localaqdj != null) {
        localaqdj.cancel();
      }
      locala.c = aqdj.a(paramQQAppInterface, String.valueOf(paramString), (byte)4);
      locala.aEC = false;
      return locala;
    }
    
    aqdj a()
    {
      if (this.c == null) {
        return null;
      }
      return this.c;
    }
    
    boolean hm(String paramString)
    {
      return (!this.aEC) && (paramString != null) && (paramString.equals(this.uin));
    }
    
    public boolean isRecycled()
    {
      return this.aEC;
    }
    
    void recycle()
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.uin });
      }
      this.aEC = true;
      ??? = a();
      if (??? != null) {
        ((aqdj)???).cancel();
      }
      this.uin = null;
      synchronized (sPoolSync)
      {
        if (sPoolSize < 3)
        {
          this.f = e;
          e = this;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfu
 * JD-Core Version:    0.7.0.1
 */