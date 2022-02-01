import android.text.TextUtils;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class alki
  extends acdv
{
  public alki(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void N(boolean paramBoolean, String paramString)
  {
    if ((QCallDetailActivity.a(this.this$0) != null) && (QCallDetailActivity.a(this.this$0).equals(paramString)) && (QCallDetailActivity.a(this.this$0) == 3000)) {
      this.this$0.Oo(paramString);
    }
  }
  
  protected void V(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(QCallDetailActivity.a(this.this$0))) && (QCallDetailActivity.a(this.this$0).equals(paramString)) && (!this.this$0.isFinishing())) {
      this.this$0.finish();
    }
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCallDetailActivity", 2, " === onUpdateDiscussionFaceIcon isSuccess | " + paramBoolean1 + ", disUin | " + paramString + ",isComplete | " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2) && (QCallDetailActivity.a(this.this$0) != null) && (QCallDetailActivity.a(this.this$0) == 3000))
    {
      String str = paramString;
      if (GroupIconHelper.kH(paramString)) {
        str = GroupIconHelper.jz(paramString);
      }
      if (QCallDetailActivity.a(this.this$0).equals(str))
      {
        this.this$0.Oo(QCallDetailActivity.a(this.this$0));
        if (QLog.isColorLevel()) {
          QLog.i("QCallDetailActivity", 2, "==== onUpdateDiscussionFaceIcon updateUin ===");
        }
      }
    }
  }
  
  protected void p(boolean paramBoolean, Object paramObject)
  {
    if ((((ArrayList)paramObject).indexOf(QCallDetailActivity.a(this.this$0)) != -1) && (paramBoolean) && (QCallDetailActivity.a(this.this$0) == 3000)) {
      this.this$0.Oo(QCallDetailActivity.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alki
 * JD-Core Version:    0.7.0.1
 */