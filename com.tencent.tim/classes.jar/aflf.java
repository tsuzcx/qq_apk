import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class aflf
{
  private AtomicInteger bl;
  int cRR;
  private ProgressDialog e;
  private Map<Integer, aflf.a> kj;
  private Activity mActivity;
  private TextView yw;
  
  public aflf(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func SogouEmojiTaskController begins");
    }
    this.mActivity = paramActivity;
    init();
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func SogouEmojiTaskController ends");
    }
  }
  
  private void init()
  {
    this.bl = new AtomicInteger(0);
    this.kj = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));
  }
  
  public int J(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func addTask begins, packId:" + paramString1 + ",exprId:" + paramString2);
    }
    aflf.a locala = new aflf.a();
    this.cRR = this.bl.addAndGet(1);
    locala.bDT = paramString1;
    locala.bDU = paramString2;
    locala.taskId = this.cRR;
    if (this.kj != null) {
      this.kj.put(Integer.valueOf(this.cRR), locala);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func addTask ends, mCurTaskId:" + this.cRR);
    }
    am(2131696921);
    return this.cRR;
  }
  
  void am(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func showProgressDialog begins, textResId:" + paramInt);
    }
    for (;;)
    {
      try
      {
        if (this.e == null) {
          continue;
        }
        cancleProgressDailog();
        this.yw.setText(paramInt);
        if (!this.e.isShowing()) {
          this.e.show();
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SogouEmojiTaskController", 2, "func showProgressDialog ends, ERROR! msg:" + localThrowable.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmojiTaskController", 2, "func showProgressDialog ends");
      }
      return;
      this.e = new ReportProgressDialog(this.mActivity, 2131756467);
      this.e.setOnDismissListener(new aflg(this));
      this.e.setCancelable(true);
      this.e.show();
      this.e.setContentView(2131559761);
      this.yw = ((TextView)this.e.findViewById(2131373180));
    }
  }
  
  void cancleProgressDailog()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func cancleProgressDailog begins");
    }
    if ((this.e != null) && (this.e.isShowing())) {
      this.e.cancel();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func cancleProgressDailog ends");
    }
  }
  
  public boolean js(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func isTaskInMap begins, taskId:" + paramInt);
    }
    if (this.kj != null)
    {
      if ((aflf.a)this.kj.get(Integer.valueOf(paramInt)) != null) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmojiTaskController", 2, "func isTaskInMap ends, taskId:" + paramInt + ",exists=" + bool);
        }
        return bool;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func isTaskInMap ends, taskId:" + paramInt + " NOT exist, cause map is null.");
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDestroy begins");
    }
    if (this.kj != null)
    {
      this.kj.clear();
      this.kj = null;
    }
    this.mActivity = null;
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDestroy ends");
    }
  }
  
  public void removeTask(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func removeTask begins, taskId:" + paramInt + ",mEmojiTaskHashMap:" + this.kj);
    }
    if (this.kj != null) {
      this.kj.remove(Integer.valueOf(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func removeTask ends");
    }
  }
  
  public void uo()
  {
    if (this.kj != null) {
      this.kj.clear();
    }
  }
  
  static class a
  {
    public String bDT;
    public String bDU;
    public int taskId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflf
 * JD-Core Version:    0.7.0.1
 */