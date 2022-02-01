import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajil
{
  private List<zof> Dg = new ArrayList();
  private volatile List<RecentBaseData> Dh;
  private ajik jdField_a_of_type_Ajik;
  private ajio jdField_a_of_type_Ajio;
  private ajip jdField_a_of_type_Ajip;
  private long acS;
  private boolean coP;
  private Handler df;
  private int djj;
  private Bitmap fw;
  private volatile Bitmap fx;
  private volatile Bitmap fy;
  private ArrayList<View> mCachedViews = new ArrayList();
  private int mContentHeight;
  private int mId;
  
  public ajil(ajik paramajik)
  {
    this.jdField_a_of_type_Ajik = paramajik;
  }
  
  public static ajil a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "create() called with: app = [" + paramAppInterface + "]");
    }
    paramAppInterface = (ajik)paramAppInterface.getManager(325);
    ajil localajil = new ajil(paramAppInterface);
    localajil.setId(paramAppInterface.a(localajil));
    return localajil;
  }
  
  private void lv(List<RecentBaseData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "setRecentUserList() called with: recentUserList = [" + paramList + "]");
    }
    this.Dh = paramList;
  }
  
  private void setId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public void LY(boolean paramBoolean)
  {
    this.coP = paramBoolean;
    if (paramBoolean) {
      this.acS = SystemClock.uptimeMillis();
    }
  }
  
  public View N(int paramInt)
  {
    if (this.mCachedViews.isEmpty()) {}
    for (View localView1 = null;; localView1 = (View)this.mCachedViews.remove(0))
    {
      if (localView1 != null)
      {
        localObject = localView1.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(localView1);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MultiAioContext", 2, "getCacheViewFor() called with: position = [" + paramInt + "], v = " + localView1);
      Object localObject = this.mCachedViews.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView2 = (View)((Iterator)localObject).next();
        QLog.d("MultiAioContext", 2, "getCacheViewFor() cached v = [" + localView2 + "]");
      }
    }
    return localView1;
  }
  
  public void QU(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public void QV(int paramInt)
  {
    this.djj = paramInt;
  }
  
  public void U(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "setDecorViewBitmap() called with: decorViewBitmap = [" + paramBitmap + "]");
    }
    this.fw = paramBitmap;
  }
  
  public void V(Bitmap paramBitmap)
  {
    this.fx = paramBitmap;
  }
  
  public void W(Bitmap paramBitmap)
  {
    this.fy = paramBitmap;
  }
  
  public ajip a()
  {
    return this.jdField_a_of_type_Ajip;
  }
  
  public List<RecentBaseData> a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "getRecentUserList() called with: app = [" + paramQQAppInterface + "], activity = [" + paramFragmentActivity + "], openedFrom = [" + paramString1 + "], enteranceType = [" + paramInt + "], enteranceUin = [" + paramString2 + "], enterNickName = [" + paramString3 + "], mRecentUserList = " + this.Dh);
    }
    List localList2 = this.Dh;
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = ajhz.a(paramFragmentActivity, paramQQAppInterface, paramString1, paramInt, paramString2, paramString3);
      lv(localList1);
    }
    return localList1;
  }
  
  public void a(int paramInt, zof paramzof)
  {
    while (this.Dg.size() <= paramInt) {
      this.Dg.add(null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "setMiniPie() called with: position = [" + paramInt + "], miniPie = [" + paramzof + "]");
    }
    this.Dg.set(paramInt, paramzof);
  }
  
  public void a(ajio paramajio)
  {
    this.jdField_a_of_type_Ajio = paramajio;
  }
  
  public void a(ajip paramajip)
  {
    this.jdField_a_of_type_Ajip = paramajip;
  }
  
  public void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt)
  {
    while (paramInt > 0)
    {
      he(paramLayoutInflater.inflate(2131558931, paramViewGroup, false));
      paramInt -= 1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.df == null) {
      this.df = new Handler(ThreadManager.getRecentThreadLooper());
    }
    this.df.removeCallbacksAndMessages(this);
    this.df.postAtTime(new MultiAioContext.1(this, paramFragmentActivity, paramQQAppInterface, paramString1, paramInt, paramString2, paramString3), this, 0L);
  }
  
  public Bitmap aA()
  {
    return this.fx;
  }
  
  public Bitmap aB()
  {
    return this.fy;
  }
  
  public boolean aqO()
  {
    return this.coP;
  }
  
  public Bitmap az()
  {
    return this.fw;
  }
  
  public zof b(MultiAIOItemFragment paramMultiAIOItemFragment)
  {
    Object localObject2 = null;
    int i = paramMultiAIOItemFragment.getPosition();
    Object localObject1 = localObject2;
    if (i >= 0)
    {
      localObject1 = localObject2;
      if (i < this.Dg.size()) {
        localObject1 = (zof)this.Dg.get(i);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = zol.a(paramMultiAIOItemFragment.getActivity(), paramMultiAIOItemFragment.a(), paramMultiAIOItemFragment.getActivity().app);
      a(i, (zof)localObject2);
    }
    return localObject2;
  }
  
  public void bI(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Ajio != null) {
      this.jdField_a_of_type_Ajio.bI(paramIntent);
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "destroy() called");
    }
    if (this.df != null) {
      this.df.removeCallbacksAndMessages(this);
    }
    this.Dg.clear();
    this.mCachedViews.clear();
    if (this.Dh != null) {
      this.Dh = null;
    }
    this.coP = false;
    this.fw = null;
    this.mContentHeight = 0;
    this.fx = null;
    this.fy = null;
  }
  
  public void dxK()
  {
    if (this.jdField_a_of_type_Ajip != null) {
      this.jdField_a_of_type_Ajip.dxG();
    }
  }
  
  public int getContentHeight()
  {
    return this.mContentHeight;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public void he(View paramView)
  {
    this.mCachedViews.add(paramView);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "putCacheView() called size = " + this.mCachedViews.size() + " with: v = [" + paramView + "]");
    }
  }
  
  public int wh()
  {
    return this.djj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajil
 * JD-Core Version:    0.7.0.1
 */