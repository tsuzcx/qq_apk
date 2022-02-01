import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.ditto.utils.ClassLoadUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.stickynote.QzoneStickyNoteManager.2;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class awbq
  implements AbsListView.e
{
  private Class M;
  private int Qa = 0;
  private ListView b;
  private int blU;
  private boolean dpK;
  private boolean dpL;
  private ClassLoader g;
  private Object gg;
  private Object gh;
  private View hY;
  private BaseAdapter j;
  private Activity mActivity;
  private QQAppInterface mApp;
  private boolean mIsAttach;
  private int mScrollState = 0;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  private long mUin;
  private boolean zx = true;
  
  private Object X()
  {
    if (this.gh != null) {
      return this.gh;
    }
    try
    {
      Class localClass = ClassLoadUtils.load(this.g, "com.qzone.homepage.ui.activity.FriendProfileCardAdapterConverter$LoadCallback");
      ClassLoader localClassLoader = this.g;
      awbs localawbs = new awbs(this);
      this.gh = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, localawbs);
      return this.gh;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 1, "getLocalCallback failed: " + localThrowable.getMessage());
      }
    }
  }
  
  private Object a(ListView paramListView)
  {
    boolean bool = true;
    if (this.g == null) {
      return null;
    }
    try
    {
      Constructor localConstructor = j().getConstructor(new Class[] { Activity.class, ListView.class, Long.TYPE, Boolean.TYPE });
      if ((this.mApp != null) && (this.mUin == this.mApp.getLongAccountUin())) {}
      for (;;)
      {
        paramListView = localConstructor.newInstance(new Object[] { this.mActivity, paramListView, Long.valueOf(this.mUin), Boolean.valueOf(bool) });
        return paramListView;
        bool = false;
      }
      return null;
    }
    catch (Exception paramListView)
    {
      QLog.w("QzoneStickyNoteManager", 4, "newConverter failed: " + paramListView.getMessage());
    }
  }
  
  private void c(ListAdapter paramListAdapter)
  {
    if ((!this.dpK) && (this.b != null) && (paramListAdapter != null))
    {
      this.b.setAdapter(paramListAdapter);
      if (this.hY != null) {
        this.hY.setVisibility(0);
      }
      this.dpK = true;
    }
  }
  
  private void e(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mIsAttach) {
      return;
    }
    try
    {
      j().getDeclaredMethod("onScroll", new Class[] { AbsListView.class, Integer.TYPE, Integer.TYPE, Integer.TYPE }).invoke(this.gg, new Object[] { paramAbsListView, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
    }
    catch (Exception paramAbsListView)
    {
      QLog.w("QzoneStickyNoteManager", 4, "onScrollProxy failed: " + paramAbsListView.getMessage());
    }
  }
  
  private void eDc()
  {
    QLog.i("QzoneStickyNoteManager", 1, "tryLoadMore");
    if ((this.zx) && (this.Qa != 2) && (this.mScrollState == 0))
    {
      this.Qa = 2;
      loadMore();
    }
  }
  
  private void eDd()
  {
    int i = this.b.getFirstVisiblePosition();
    QZLog.d("QzoneStickyNoteManager", 4, String.format("scrollToStickNoteTop firstVisiblePos=%s", new Object[] { Integer.valueOf(i) }));
    if ((i > 1) && ((this.mActivity instanceof FriendProfileCardActivity)))
    {
      i = ((FriendProfileCardActivity)this.mActivity).getTitleBarHeight();
      int k = this.hY.getHeight();
      this.b.setSelectionFromTop(1, i + k);
    }
  }
  
  private int hq()
  {
    return this.blU - 2;
  }
  
  private Class j()
  {
    if (this.M != null) {
      return this.M;
    }
    try
    {
      this.M = ClassLoadUtils.load(this.g, "com.qzone.homepage.ui.activity.FriendProfileCardAdapterConverter");
      return this.M;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 4, "getConverterClass failed: " + localException.getMessage());
      }
    }
  }
  
  private void loadMore()
  {
    QLog.i("QzoneStickyNoteManager", 1, "loadMore");
    Object localObject = X();
    if (localObject == null)
    {
      QLog.e("QzoneStickyNoteManager", 1, "loadMore exit due to null callback");
      return;
    }
    try
    {
      j().getDeclaredMethod("loadMore", new Class[] { Object.class }).invoke(this.gg, new Object[] { localObject });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneStickyNoteManager", 1, "loadMore failed: " + localException.getMessage());
    }
  }
  
  private void o(AbsListView paramAbsListView, int paramInt)
  {
    if (!this.mIsAttach) {
      return;
    }
    try
    {
      j().getDeclaredMethod("onScrollStateChanged", new Class[] { AbsListView.class, Integer.TYPE }).invoke(this.gg, new Object[] { paramAbsListView, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramAbsListView)
    {
      QLog.w("QzoneStickyNoteManager", 4, "onScrollStateChangedProxy failed: " + paramAbsListView.getMessage());
    }
  }
  
  private void onLifecycle(String paramString)
  {
    try
    {
      j().getDeclaredMethod("onLifecycle", new Class[] { String.class }).invoke(this.gg, new Object[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneStickyNoteManager", 4, "onLifecycle failed: " + paramString.getMessage());
    }
  }
  
  private void onLoad(int paramInt, boolean paramBoolean)
  {
    QZLog.d("QzoneStickyNoteManager", 4, String.format("onLoad pos=%s hasMore=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    if (this.Qa == 2) {
      this.Qa = 0;
    }
    this.dpL = true;
    this.zx = paramBoolean;
  }
  
  private void onLoadFinish(boolean paramBoolean)
  {
    QZLog.d("QzoneStickyNoteManager", 4, "onLoadFinish " + paramBoolean);
    this.Qa = 1;
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface, Card paramCard, ListView paramListView, View paramView)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null))
    {
      QLog.w("QzoneStickyNoteManager", 1, "init failed due to null parameter");
      return;
    }
    this.b = paramListView;
    this.hY = paramView;
    avsn.a(new awbr(this, paramActivity, paramQQAppInterface, paramListView, paramCard));
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, ListView paramListView, Card paramCard)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (paramCard == null)) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(paramCard.uin);
        QZLog.i("QzoneStickyNoteManager", "attach: " + this.mIsAttach + ", " + l);
        if ((l <= 0L) || (this.mIsAttach)) {
          continue;
        }
        if (this.g == null) {
          this.g = QzonePluginProxyActivity.a();
        }
        if (paramQQAppInterface != avsn.g()) {
          avsn.g(paramActivity, paramQQAppInterface);
        }
        this.mActivity = paramActivity;
        this.mApp = paramQQAppInterface;
        this.mUin = l;
        this.mUiHandler.post(new QzoneStickyNoteManager.2(this, paramListView, paramCard));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          long l = 0L;
        }
      }
    }
  }
  
  public void destroy()
  {
    if ((this.dpK) && (this.b != null)) {
      this.b.setAdapter(new auvv(null));
    }
  }
  
  public BaseAdapter getAdapter()
  {
    if (this.j != null) {
      return this.j;
    }
    if (this.gg == null) {
      return null;
    }
    if (this.g != null) {}
    try
    {
      this.j = ((BaseAdapter)j().getDeclaredMethod("getAdapter", new Class[0]).invoke(this.gg, new Object[0]));
      return this.j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 4, "getAdapter failed: " + localException.getMessage());
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QZLog.d("QzoneStickyNoteManager", 4, String.format("onActivityResult requestCode=%s resultCode=%s mCanLoadMore=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.zx) }));
    try
    {
      j().getDeclaredMethod("onActivityResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class }).invoke(this.gg, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if ((paramInt1 == 201209) && (paramInt2 == -1) && (!this.zx)) {
        eDd();
      }
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        QZLog.e("QzoneStickyNoteManager", 4, new Object[] { "onActivityResult failed!", paramIntent });
      }
    }
  }
  
  public void onDestroy()
  {
    onLifecycle("onDestroy");
    this.gg = null;
    this.mIsAttach = false;
    this.gh = null;
  }
  
  public void onResume()
  {
    onLifecycle("onResume");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.blU = paramInt3;
    e(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
    if (paramInt == 0)
    {
      if (this.dpL)
      {
        this.j.notifyDataSetChanged();
        this.dpL = false;
      }
      if (paramAbsListView.getLastVisiblePosition() >= hq()) {
        eDc();
      }
    }
    o(paramAbsListView, paramInt);
  }
  
  public void updateFriendProfileCard(Card paramCard)
  {
    if (this.gg == null) {}
    while (this.g == null) {
      return;
    }
    try
    {
      j().getDeclaredMethod("updateFriendProfileCard", new Class[] { Card.class }).invoke(this.gg, new Object[] { paramCard });
      return;
    }
    catch (Exception paramCard)
    {
      QLog.w("QzoneStickyNoteManager", 4, "updateFriendProfileCard failed: " + paramCard.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awbq
 * JD-Core Version:    0.7.0.1
 */