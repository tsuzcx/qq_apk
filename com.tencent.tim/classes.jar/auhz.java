import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.PadInfo;
import java.util.Iterator;
import java.util.List;

class auhz
  extends aulm
{
  auhz(auhw paramauhw) {}
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, int paramInt4, List<PadInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("FeedListPresenter", 2, "onGetPadList time= " + String.valueOf(l - auhw.c(this.this$0)) + "ms isSuccess: " + paramBoolean1 + " retCode: " + paramInt2 + " isEnd:" + paramBoolean3 + " totalCount: " + paramInt3 + "typeOperation: " + paramInt4);
      QLog.i("FeedListPresenter", 2, "onGetPadList: isSuccess: " + paramBoolean1 + " retCode: " + paramInt2 + " typePadList: " + paramInt1 + " isEnd:" + paramBoolean3 + " totalCount: " + paramInt3 + "typeOperation: " + paramInt4 + " size: " + paramList.size());
    }
    if (paramInt1 == 4)
    {
      if (!paramBoolean1) {
        break label309;
      }
      if (!paramBoolean3) {
        break label241;
      }
      if (auhw.a(this.this$0))
      {
        paramList = this.this$0.dW.obtainMessage();
        paramList.what = 104;
        this.this$0.dW.sendMessage(paramList);
      }
    }
    label241:
    while (((paramList != null) && (paramList.size() != 0)) || (this.this$0.a == null) || (!this.this$0.a.Pp())) {
      return;
    }
    this.this$0.a.f(true, auhw.a(this.this$0), this.this$0.isComplete());
    return;
    label309:
    if ((this.this$0.a != null) && (this.this$0.a.Pp())) {
      this.this$0.a.f(false, auhw.a(this.this$0), this.this$0.isComplete());
    }
    auhw.b(this.this$0).clear();
  }
  
  public void t(boolean paramBoolean, int paramInt, String paramString)
  {
    super.t(paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("FeedListPresenter", 2, "onDeletePad: isSuccess: " + paramBoolean + " typePadList: " + paramInt + " padUrl: " + paramString);
    }
    if (paramBoolean)
    {
      Iterator localIterator = auhw.c(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (((localObject instanceof PadInfo)) && (paramString.equals(((PadInfo)localObject).pad_url)))
        {
          auhw.c(this.this$0).remove(localObject);
          if ((this.this$0.a != null) && (this.this$0.a.Pp())) {
            this.this$0.a.f(paramBoolean, 3, this.this$0.isComplete());
          }
        }
      }
    }
  }
  
  public void v(boolean paramBoolean, String paramString, int paramInt)
  {
    super.v(paramBoolean, paramString, paramInt);
    if ((paramBoolean) && (this.this$0.a != null) && (this.this$0.a.Pp())) {
      this.this$0.a.f(paramBoolean, 3, this.this$0.isComplete());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhz
 * JD-Core Version:    0.7.0.1
 */