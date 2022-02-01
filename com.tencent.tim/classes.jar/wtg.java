import android.content.Intent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class wtg
{
  private static int sCount;
  private static BaseActivity sTopActivity;
  private long IC;
  private aqju Q;
  private wtg.a jdField_a_of_type_Wtg$a;
  private wtg.b jdField_a_of_type_Wtg$b;
  public boolean bfT;
  
  private boolean Y(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "containCurMsg  mOriginUniSeq:" + this.IC);
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.d("MergeForwardRevokeHelper", 2, "containCurMsg  mr.uniseq:" + localMessageRecord.uniseq);
        }
        if (localMessageRecord.uniseq == this.IC) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void i(BaseActivity paramBaseActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramBaseActivity.getWindow().getDecorView();
    ImageView localImageView = new ImageView(paramBaseActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localImageView.setImageResource(2130846147);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localViewGroup.addView(localImageView, localLayoutParams);
    if (this.Q != null) {
      this.Q.dismiss();
    }
    this.Q = aqha.a(paramBaseActivity, 230).setMessage(acfp.m(2131708128)).setPositiveButton(paramBaseActivity.getString(2131695681), new wth(this, paramBaseActivity));
    this.Q.show();
    if (this.jdField_a_of_type_Wtg$a != null) {
      this.jdField_a_of_type_Wtg$a.cbF();
    }
  }
  
  public void e(BaseActivity paramBaseActivity)
  {
    sCount += 1;
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onCreate");
    }
    if ((paramBaseActivity.getIntent() != null) && (paramBaseActivity.getAppInterface() != null))
    {
      AppInterface localAppInterface = paramBaseActivity.getAppInterface();
      wtg.b localb = new wtg.b(paramBaseActivity, null);
      this.jdField_a_of_type_Wtg$b = localb;
      localAppInterface.addObserver(localb);
      this.IC = paramBaseActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
    }
  }
  
  public void g(BaseActivity paramBaseActivity)
  {
    sTopActivity = paramBaseActivity;
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onResume");
    }
    this.bfT = false;
  }
  
  public void h(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onDestroy");
    }
    if (paramBaseActivity.getAppInterface() != null) {
      paramBaseActivity.getAppInterface().removeObserver(this.jdField_a_of_type_Wtg$b);
    }
    if ((this.Q != null) && (this.Q.isShowing())) {
      this.Q.dismiss();
    }
    this.Q = null;
    int i = sCount - 1;
    sCount = i;
    if (i <= 0) {
      sTopActivity = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cbF();
    
    public abstract void cbG();
  }
  
  class b
    extends achq
  {
    private WeakReference<BaseActivity> mActivity;
    
    private b(BaseActivity paramBaseActivity)
    {
      this.mActivity = new WeakReference(paramBaseActivity);
    }
    
    public void b(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
    {
      super.b(paramBoolean1, paramList, paramBoolean2);
      if ((wtg.a(wtg.this, paramList)) && (paramBoolean1)) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        paramList = (BaseActivity)this.mActivity.get();
        if (QLog.isColorLevel()) {
          QLog.d("MergeForwardRevokeHelper", 2, "onMsgRevokeNotice  hasMsgRevoked:" + paramBoolean2 + "; isSuccess:" + paramBoolean1);
        }
        if ((paramBoolean2) && (paramList != null))
        {
          if (!wtg.this.bfT) {
            break;
          }
          paramList.finish();
        }
        return;
      }
      if (wtg.c() == paramList)
      {
        wtg.a(wtg.this, paramList);
        return;
      }
      paramList.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtg
 * JD-Core Version:    0.7.0.1
 */