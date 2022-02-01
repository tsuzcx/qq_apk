import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aiqe
  extends ainv
{
  aiqe(aiqd paramaiqd) {}
  
  protected void S(int paramInt, String paramString1, String paramString2)
  {
    aiqd.a(this.this$0, paramInt, paramString1, paramString2);
  }
  
  protected void as(String paramString, int paramInt1, int paramInt2)
  {
    this.this$0.as(paramString, paramInt1, paramInt2);
  }
  
  protected void cU(int paramInt, String paramString)
  {
    QLog.d("BaseListenTogetherPanel", 1, String.format("onJoinAndEnter [%d,%s] [%d,%s] resumed=[%b] ", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(this.this$0.a.mCurType), this.this$0.a.mCurUin, Boolean.valueOf(this.this$0.zR) }));
    if ((!this.this$0.zR) || (this.this$0.a.mCurType != paramInt) || (!this.this$0.a.mCurUin.equalsIgnoreCase(paramString))) {
      return;
    }
    paramString = ListenTogetherManager.a(this.this$0.mActivity.app).a(paramInt, paramString);
    if ((paramString == null) || (this.this$0.a.status == 3))
    {
      QQToast.a(this.this$0.mActivity, 2131695338, 0).show();
      return;
    }
    if (this.this$0.a.deR != 2)
    {
      QQToast.a(this.this$0.mActivity, 2131695340, 0).show();
      return;
    }
    if (this.this$0.a.status == 4)
    {
      QQToast.a(this.this$0.mActivity, 2131695343, 0).show();
      return;
    }
    MusicInfo localMusicInfo = paramString.b();
    ListenTogetherPlayFragment.a(this.this$0.mActivity, paramString, localMusicInfo, this.this$0.a.isAdmin, null);
  }
  
  protected void cV(int paramInt, String paramString)
  {
    this.this$0.cV(paramInt, paramString);
  }
  
  protected void d(ListenTogetherSession paramListenTogetherSession)
  {
    this.this$0.d(paramListenTogetherSession);
  }
  
  protected void db(int paramInt, String paramString)
  {
    this.this$0.db(paramInt, paramString);
  }
  
  protected void s(int paramInt, String paramString, boolean paramBoolean)
  {
    this.this$0.s(paramInt, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqe
 * JD-Core Version:    0.7.0.1
 */