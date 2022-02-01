import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aphz
  extends acnd
{
  public aphz(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void a(boolean paramBoolean, apgk paramapgk)
  {
    super.a(paramBoolean, paramapgk);
    this.this$0.bF();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("获取作业信息");
      if (!paramBoolean) {
        break label123;
      }
    }
    for (String str = "成功";; str = "失败")
    {
      QLog.d("SubmitHomeWorkFragment", 2, str);
      if ((!paramBoolean) || (paramapgk == null) || (paramapgk.content == null)) {
        break;
      }
      this.this$0.c = paramapgk;
      paramapgk = paramapgk.content;
      try
      {
        paramapgk = new JSONObject(paramapgk).getJSONArray("c");
        paramapgk = new JSONObject().put("c", paramapgk).toString();
        this.this$0.SR(paramapgk);
        return;
      }
      catch (Exception paramapgk)
      {
        label123:
        this.this$0.a(3, null, null, null);
        return;
      }
    }
    this.this$0.a(3, null, null, null);
    this.this$0.c = null;
    this.this$0.getActivity().finish();
  }
  
  public void bc(boolean paramBoolean, int paramInt)
  {
    super.bc(paramBoolean, paramInt);
    this.this$0.bF();
    if (paramBoolean)
    {
      this.this$0.dZN();
      return;
    }
    if (paramInt == 1002)
    {
      this.this$0.a(2, null, null, null);
      return;
    }
    if (paramInt == 10022)
    {
      this.this$0.a(1, null, null, null);
      return;
    }
    this.this$0.a(3, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aphz
 * JD-Core Version:    0.7.0.1
 */