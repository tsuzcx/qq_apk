import android.text.TextUtils;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.VisitorsActivity.d;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class wgd
  extends ajrw
{
  public wgd(VisitorsActivity paramVisitorsActivity) {}
  
  protected void a(boolean paramBoolean, ArrayList<ajqh.b> paramArrayList, int paramInt)
  {
    if ((paramBoolean) && (paramArrayList != null)) {}
    for (;;)
    {
      ajqh.b localb;
      try
      {
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          if (paramArrayList.hasNext())
          {
            localb = (ajqh.b)paramArrayList.next();
            if (paramInt != 511) {
              break label121;
            }
            if (localb.ret != 0) {
              continue;
            }
            alhr localalhr = this.this$0.jdField_a_of_type_Alhr;
            String str = localb.uin + "";
            int i = localb.dkw;
            localalhr.t(str, localb.dkx + i, false);
            continue;
          }
        }
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
      label121:
      if (localb.ret == 0) {
        this.this$0.jdField_a_of_type_Alhr.kG(localb.uin);
      }
    }
  }
  
  protected void ad(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals("0", paramString)))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
      }
      if (this.this$0.b != null) {
        this.this$0.b.notifyDataSetChanged();
      }
    }
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.this$0.app.getCurrentAccountUin())) {}
    do
    {
      return;
      if (paramInt2 == 1)
      {
        if (!paramBoolean)
        {
          this.this$0.jdField_a_of_type_Alhr.u(paramString2, paramInt1, false);
          return;
        }
        this.this$0.jdField_a_of_type_Alhr.t(paramString2, paramInt1, false);
        return;
      }
    } while (paramInt2 != 0);
    this.this$0.jdField_a_of_type_Alhr.kG(Long.parseLong(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgd
 * JD-Core Version:    0.7.0.1
 */