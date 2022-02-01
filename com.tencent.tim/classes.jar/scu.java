import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.CommentInputPopupWindow.7;
import com.tencent.biz.subscribe.comment.CommentInputPopupWindow.8;
import com.tencent.biz.subscribe.comment.EmoView;
import com.tencent.biz.subscribe.comment.WorkSpaceView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class scu
  extends sdz
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private ImageButton S;
  private ImageButton T;
  private CommentEditText jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
  private EmoView jdField_a_of_type_ComTencentBizSubscribeCommentEmoView;
  private sch jdField_a_of_type_Sch;
  private scu.a jdField_a_of_type_Scu$a;
  private sea jdField_a_of_type_Sea;
  private boolean axc;
  private boolean axd;
  private Activity mActivity;
  private InputMethodManager mImm;
  private Handler mMainHandler;
  private View nq;
  
  private void bkn()
  {
    if (this.axc) {
      dt(this.nq);
    }
    this.axd = true;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.setVisibility(0);
    WorkSpaceView localWorkSpaceView = (WorkSpaceView)this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.getChildAt(0);
    if (localWorkSpaceView != null) {
      getMainHandler().post(new CommentInputPopupWindow.8(this, localWorkSpaceView));
    }
    if ("workSpaceView is empty" + localWorkSpaceView != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("CommentInputPopupWindow", 1, new Object[] { Boolean.valueOf(bool) });
      hideSoftInput(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
      return;
    }
  }
  
  private void dt(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void du(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private Handler getMainHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  private void qD(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.setVisibility(8);
    }
    du(this.nq);
    if (paramBoolean) {
      ds(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    }
  }
  
  @TargetApi(19)
  public void beF()
  {
    int i = 0;
    super.beF();
    Object localObject = getWindow();
    if (localObject == null) {}
    label101:
    for (;;)
    {
      return;
      localObject = ((Window)localObject).getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = ((ViewGroup)localObject).getChildAt(0);
        if ((localObject instanceof ViewGroup))
        {
          int j = ((ViewGroup)localObject).getChildCount();
          for (;;)
          {
            if (i >= j) {
              break label101;
            }
            View localView = ((ViewGroup)localObject).getChildAt(i);
            if ((localView == null) || (localView.getId() == 16908290)) {
              break;
            }
            if (!(localView instanceof ViewStub)) {
              localView.setAlpha(0.0F);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public void dismiss()
  {
    hideSoftInput(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    qD(false);
    super.dismiss();
  }
  
  public void ds(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new CommentInputPopupWindow.7(this, paramView));
  }
  
  public void hideSoftInput(View paramView)
  {
    this.mImm.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public void onClick(View paramView)
  {
    QLog.d("CommentInputPopupWindow", 1, "onClick:" + paramView.getId());
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("CommentInputPopupWindow", 1, "btn_emotion");
      bkn();
      this.T.setVisibility(0);
      this.S.setVisibility(8);
      continue;
      QLog.d("CommentInputPopupWindow", 1, "text_input");
      qD(true);
      this.T.setVisibility(8);
      this.S.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_Sch != null)
      {
        this.jdField_a_of_type_Sch.beU();
        continue;
        QLog.d("CommentInputPopupWindow", 1, "btn_keyboard");
        qD(true);
        this.T.setVisibility(8);
        this.S.setVisibility(0);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Sea.bya();
    this.jdField_a_of_type_Sea = null;
    this.S.setVisibility(8);
    this.T.setVisibility(0);
    this.axc = false;
    if (this.jdField_a_of_type_Scu$a != null) {
      this.jdField_a_of_type_Scu$a.onDismiss();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scu
 * JD-Core Version:    0.7.0.1
 */